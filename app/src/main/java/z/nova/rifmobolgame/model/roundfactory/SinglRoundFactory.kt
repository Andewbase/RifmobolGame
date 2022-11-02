package z.nova.rifmobolgame.model.roundfactory

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.yodo1.mas.Yodo1Mas
import z.nova.rifmobolgame.PlayGame
import z.nova.rifmobolgame.R
import z.nova.rifmobolgame.model.round.GetRoundInfo
import z.nova.rifmobolgame.model.round.RoundInfo
import z.nova.rifmobolgame.model.round.RoundInfoImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SinglRoundFactory(private val idRound: Int, private val context: Context, private var clickedIdBtn: Int = 0) {


    private var mediaPlayer: MediaPlayer? = null

    private lateinit var dialogEndWin: Dialog
    private lateinit var dialogEndLose: Dialog

    private val roundInfoImpl = RoundInfoImpl(idRound)
    private val getRoundInfo = GetRoundInfo(roundRepo = roundInfoImpl)

    private val roundInfo: RoundInfo = getRoundInfo.execut()

    private var isClickEvenAdvertising: Boolean = false

    //Dialog
    private lateinit var textdescriptionsDialogWin: TextView
    private lateinit var btnCloseDialogWin: TextView
    private lateinit var buttonContinueDialogWIn: Button
    private lateinit var textdescriptionsDialogLose: TextView
    private lateinit var btnCloseDialogLose: TextView
    private lateinit var btnOneMoreTimeDialogLose: Button
    private lateinit var btnNextDialogLose: Button

    fun clickButtonRoundLose(clickIdBtn: Int, btnLose: Button, btnWin: Button) {
        clickedIdBtn = clickIdBtn //Кнопка нажата
        //Вопроизводим полный куплет -начало
        if (mediaPlayer != null) {
            releaseMP()
            mediaPlayer = MediaPlayer.create(context, roundInfo.music2)
            mediaPlayer?.start()
            btnLose.isClickable = false //Отключаем кнопку после нажатия
        }
        //Вопроизводим полный куплет - конец

        //Метод показывающий правельный ответ - начало
        mediaPlayer!!.setOnCompletionListener {
            setButtonBackgroundWin(btnWin)
            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
            GlobalScope.launch(Dispatchers.Main) {
                delay(500)
                dialogEndLose.show() //Выводим диалог проиграл
            }
            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
        }
    }

    fun clickButtonRoundWin(clickIdBtn: Int, btnWin: Button) {
        clickedIdBtn = clickIdBtn //Кнопка нажата
        //Вопроизводим полный куплет -начало
        if (mediaPlayer != null) {
            releaseMP()
            mediaPlayer = MediaPlayer.create(context, roundInfo.music2)
            mediaPlayer?.start()
            btnWin.isClickable = false //Отключаем кнопку после нажатия
        }
        //Вопроизводим полный куплет - конец

        //Метод показывающий правельный ответ - начало
        mediaPlayer!!.setOnCompletionListener {

            setButtonBackgroundWin(btnWin)
            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
            GlobalScope.launch(Dispatchers.Main) {
                delay(500)
                dialogEndWin.show() //Выводим диалог выйграл
            }
            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
        }

    }

    fun clickBackButton(activity: Activity) {
        if (Yodo1Mas.getInstance().isInterstitialAdLoaded) {
            Yodo1Mas.getInstance().showInterstitialAd(activity) //Показать рекламу
            val intent = Intent(activity, PlayGame::class.java)
            context.startActivity(intent)
            activity.finish()
        } else {
            //Вернуться назад к выбору уровня - начало
            val intent = Intent(activity, PlayGame::class.java) //Создали намерение для перехода
            context.startActivity(intent)
            activity.finish()
            //Вернуться назад к выбору уровня - конец
            //Обрабатываем нажатие кнопки "Назад" - конец
        }
    }

    fun setButtonBackgroundCLick(btnClick: Button, btnBlock1: Button, btnBlock2: Button, btnBlock3: Button){
        btnClick.background = ContextCompat.getDrawable(
            context,
            R.drawable.style_btn_stroke_whiteblack_press_whiteblue
        )
        btnBlock1.isClickable = false
        btnBlock2.isClickable = false
        btnBlock3.isClickable = false
    }

    fun setTextRound(textLevel: TextView, textLevelCouplet: TextView, btn_up_left: Button, btn_up_right: Button, btn_bottom_left: Button, btn_bottom_right: Button) {
        textLevel.setText(roundInfo.textLvl)
        textLevelCouplet.setText(roundInfo.textCouplet)
        btn_up_left.setText(roundInfo.nameBtnone)
        btn_up_right.setText(roundInfo.nameBtntwo)
        btn_bottom_left.setText(roundInfo.nameBtnthree)
        btn_bottom_right.setText(roundInfo.nameBtnfour)
    }

    fun setTextRound(textLevel: TextView, textLevelCouplet: TextView, background: ImageView, btn_up_left: Button, btn_up_right: Button, btn_bottom_left: Button, btn_bottom_right: Button) {
        textLevel.setText(roundInfo.textLvl)
        textLevelCouplet.setText(roundInfo.textCouplet)
        background.setImageResource(roundInfo.backgroundRound)
        btn_up_left.setText(roundInfo.nameBtnone)
        btn_up_right.setText(roundInfo.nameBtntwo)
        btn_bottom_left.setText(roundInfo.nameBtnthree)
        btn_bottom_right.setText(roundInfo.nameBtnfour)
    }


    fun mediaStart(btnWin: Button) {
        if (mediaPlayer == null && clickedIdBtn == 0) { //Если свернули игру до нажатия варианта ответа
            mediaPlayer = MediaPlayer.create(context, roundInfo.music1)
            mediaPlayer?.start()
        } else if (clickedIdBtn > 0) { //Иначе если свернули игру после нажатия варианта ответа
            mediaPlayer = MediaPlayer.create(context, roundInfo.music2)
            mediaPlayer?.start()
            //Метод показывающий правельный ответ - начало
            mediaPlayer?.setOnCompletionListener {
                setButtonBackgroundWin(btnWin)
                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало

                GlobalScope.launch(Dispatchers.Main) {
                    delay(500)
                        if (clickedIdBtn == 4) {
                            dialogEndWin.show() //Выводит диалог выйграл
                        } else {
                            dialogEndLose.show() //Выводит диалог проиграл
                        }
                }
                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
            }
            //Метод показывающий правельный ответ - конец
        }
    }

    fun dialogWinCreate(activity: Activity, clsNext: Class<*>) {
        dialogEndWin = Dialog(context)
        dialogEndWin.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogEndWin.setContentView(R.layout.dialogend_win)
        dialogEndWin.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogEndWin.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialogEndWin.setCancelable(false)

        //Устанавливаем текст в диалоговое окно - начало
        textdescriptionsDialogWin = dialogEndWin.findViewById(R.id.textwin)
        textdescriptionsDialogWin.setText(roundInfo.textDialogWin)
        //Устанавливаем текст в диалоговое окно - начало

        //Кнопка которая закрывет диалоговое окно - начало
        btnCloseDialogWin = dialogEndWin.findViewById(R.id.btnclose)
        btnCloseDialogWin.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) {
                Yodo1Mas.getInstance().showInterstitialAd(activity) //Показать рекламу
                val intent = Intent(activity, PlayGame::class.java)
                context.startActivity(intent)
                activity.finish()
            } else {
                val intent = Intent(activity, PlayGame::class.java)
                context.startActivity(intent)
                activity.finish()

                dialogEndWin.dismiss()
            }
        }
        //Кнопка которая закрывет диалоговое окно - конец

        //Кнопка "ДАЛЕЕ" - начало
        buttonContinueDialogWIn = dialogEndWin.findViewById(R.id.btncontinue)
        buttonContinueDialogWIn.setOnClickListener {
            nextButtonDialog(activity, clsNext)
        }
        //Кнопка "ДАЛЕЕ" - конец

    }

    fun dialogLoseCreate(activity: Activity, clsOneMoreTime: Class<*>, clsNext: Class<*>) {
        dialogEndLose = Dialog(context)
        dialogEndLose.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogEndLose.setContentView(R.layout.dialogend_lose)
        dialogEndLose.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogEndLose.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialogEndLose.setCancelable(false)

        //Устанавливаем текст в диалоговое окно - начало
        textdescriptionsDialogLose = dialogEndLose.findViewById(R.id.textlose)
        textdescriptionsDialogLose.setText(roundInfo.textDialogLose)
        //Устанавливаем текст в диалоговое окно - начало

        //Кнопка которая закрывет диалоговое окно - начало
        btnCloseDialogLose = dialogEndLose.findViewById(R.id.btnclose)
        btnCloseDialogLose.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) {
                Yodo1Mas.getInstance().showInterstitialAd(activity) //Показать рекламу
                val intent = Intent(activity, PlayGame::class.java)
                context.startActivity(intent)
                activity.finish()
            } else {
                val intent = Intent(activity, PlayGame::class.java)
                context.startActivity(intent)
                activity.finish()
                dialogEndLose.dismiss()
            }
        }
        //Кнопка которая закрывет диалоговое окно - конец

        //Кнопка "ЕЩЕ РАЗ" - начало
        btnOneMoreTimeDialogLose = dialogEndLose.findViewById(R.id.btncontinueback)
        btnOneMoreTimeDialogLose.setOnClickListener {
                val intent = Intent(activity, clsOneMoreTime)
                context.startActivity(intent)
                activity.finish()

            dialogEndLose.dismiss()
        }
        //Кнопка "ЕЩЁ РАЗ" - конец

        //Кнопка "ДАЛЕЕ" - начало
        btnNextDialogLose = dialogEndLose.findViewById(R.id.btncontinue)
        btnNextDialogLose .setOnClickListener {

                val intent = Intent(activity, clsNext) //ИЗМЕНИТЬ
                context.startActivity(intent)
                activity.finish()

            dialogEndLose.dismiss()
        }
        //Кнопка "ДАЛЕЕ" - конец

    }

    fun releaseMP() {
        if (mediaPlayer != null) {
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }

    private fun nextButtonDialog(activity: Activity, clsNext: Class<*>) {
        isClickEvenAdvertising = when (idRound) {
            5 -> true
            10 -> true
            15 -> true
            20 -> true
            25 -> true
            30 -> true
            35 -> true
            else -> false
        }
        if (isClickEvenAdvertising) {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) {
                Yodo1Mas.getInstance().showInterstitialAd(activity)
                val intent = Intent(activity, clsNext) //ИЗМЕНИТЬ
                context.startActivity(intent)
                activity.finish()
            } else {
                val intent = Intent(activity, clsNext) //ИЗМЕНИТЬ
                context.startActivity(intent)
                activity.finish()
            }
        } else {
            val intent = Intent(activity, clsNext) //ИЗМЕНИТЬ
            context.startActivity(intent)
            activity.finish()
        }

        dialogEndWin.dismiss()
    }

    private fun setButtonBackgroundWin(btn: Button) {
        btn.background = ContextCompat.getDrawable(
            context,
            R.drawable.style_btn_stroke_whiteblack_press_whitgreen
        )
    }

}