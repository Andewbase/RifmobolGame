package z.nova.rifmobolgame.model.roundfactory

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
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
import kotlinx.coroutines.*
import z.nova.rifmobolgame.GameMenu
import z.nova.rifmobolgame.R
import z.nova.rifmobolgame.model.round.multi.GetRoundInfoMulti
import z.nova.rifmobolgame.model.round.multi.RoundInfoImplMulti
import z.nova.rifmobolgame.model.round.multi.RoundInfoMulti

private const val KEY_SHARED_PREF = "RessultGame"
private const val KEY_SCORE1 = "score1"
private const val KEY_SCORE2 = "score2"
private const val ID_ZERO = 0
private const val ID_ONE = 1
private const val ID_TWO = 2


class MultiRoundFactory(idRound: Int, private val context: Context, private var checkdIdBtn: Int = ID_ZERO) {

    private var mediaPlayer: MediaPlayer? = null

    private lateinit var mypref: SharedPreferences

    private val roundInfoImplMulti = RoundInfoImplMulti(idRound)
    private val getRoundInfoMulti = GetRoundInfoMulti(roundRepoMulti = roundInfoImplMulti)

    private val roundInfoMulti: RoundInfoMulti = getRoundInfoMulti.execut()

    private lateinit var dialogEndWinP1: Dialog //Создаём Диалог Выйграл первый игрок
    private lateinit var dialogEndWinP2: Dialog //Создаём Диалог Выйграл второй игрок
    private lateinit var dialogEndDraw: Dialog //Создаём Диалог Ничья
    private lateinit var btnDialogEndWinP1Cloce: TextView
    private lateinit var btnDialogEndWinP1Continue: Button
    private lateinit var btnDialogEndWinP2Cloce: TextView
    private lateinit var btnDialogEndWinP2Continue: Button
    private lateinit var btnDialogEndDrawCloce: TextView
    private lateinit var btnDialogEndDrawContinue: Button
    private lateinit var multiscoreP1DialogWinP1: TextView
    private lateinit var multiscoreP2DialogWinP1: TextView
    private lateinit var multiscoreP1DialogWinP2: TextView
    private lateinit var multiscoreP2DialogWinP2: TextView
    private lateinit var multiscoreDrawDialogP1: TextView
    private lateinit var multiscoreDrawDialogP2: TextView


    private var correctanswer1 = ID_ZERO //Счёт первого игрока
    private var correctanswer2 = ID_ZERO //Счёт второго игрока

    private var onechek = false //проверка нажал ли первый игрок правильный ответ
    private var twochek = false //проверка нажал ли второй игрок правильный ответ

    private lateinit var scores1: String
    private lateinit var scores2: String

    fun setScoreText(score1: TextView, score2: TextView){
        score1.text = "$correctanswer1"
        score2.text = "$correctanswer2"
    }

    fun setUIMultiRound(textLevel: TextView, textLevelCouplet: TextView, background: ImageView){
        textLevel.setText(roundInfoMulti.textRoundMulti)
        textLevelCouplet.setText(roundInfoMulti.textCouplet)
        background.setImageResource(roundInfoMulti.backgroundRound)
    }

    fun setUIBtnTextMultiRoundP1(p1btn_up_left: Button, p1btn_up_right: Button, p1btn_bottom_left: Button, p1btn_bottom_right: Button){
        p1btn_up_left.setText(roundInfoMulti.nameBtnone)
        p1btn_up_right.setText(roundInfoMulti.nameBtntwo)
        p1btn_bottom_left.setText(roundInfoMulti.nameBtnthree)
        p1btn_bottom_right.setText(roundInfoMulti.nameBtnfour)
    }

    fun setUIBtnTextMultiRoundP2(p2btn_up_left: Button, p2btn_up_right: Button, p2btn_bottom_left: Button, p2btn_bottom_right: Button){
        p2btn_up_left.setText(roundInfoMulti.nameBtnone)
        p2btn_up_right.setText(roundInfoMulti.nameBtntwo)
        p2btn_bottom_left.setText(roundInfoMulti.nameBtnthree)
        p2btn_bottom_right.setText(roundInfoMulti.nameBtnfour)
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun clickButtonPlayerLose(clickBtnLose: Button, clickBtnWinPlayer1: Button, clickBtnWinPlayer2: Button, score1: TextView, score2: TextView, activity: Activity, nextClass: Class<*>){
        checkdIdBtn++
        if (checkdIdBtn == ID_TWO && mediaPlayer != null){
                releaseMPMulti()
                mediaPlayer = MediaPlayer.create(context, roundInfoMulti.music2)
                mediaPlayer?.start()
                clickBtnLose.isClickable = false
        }

        mediaPlayer!!.setOnCompletionListener {
            setButtonBackgroundWinPlayer1(clickBtnWinPlayer1)
            setButtonBackgroundWinPlayer2(clickBtnWinPlayer2)
            accrualOfPoints(score1, score2)
            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
            GlobalScope.launch(Dispatchers.Main) {
                delay(500)
                val intent = Intent(activity, nextClass) //ИЗМЕНИТЬ
                context.startActivity(intent)
                activity.finish()
            }
            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun clickButtonPlayerLoseFinalRound(clickBtnLose: Button, clickBtnWinPlayer1: Button, clickBtnWinPlayer2: Button, score1: TextView, score2: TextView){
        checkdIdBtn++
        if (checkdIdBtn == ID_TWO && mediaPlayer != null){
            releaseMPMulti()
            mediaPlayer = MediaPlayer.create(context, roundInfoMulti.music2)
            mediaPlayer?.start()
            clickBtnLose.isClickable = false
        }

        mediaPlayer!!.setOnCompletionListener {
            setButtonBackgroundWinPlayer1(clickBtnWinPlayer1)
            setButtonBackgroundWinPlayer2(clickBtnWinPlayer2)
            accrualOfPoints(score1, score2)
            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
            GlobalScope.launch(Dispatchers.Main) {
                delay(500)
                scores1 = correctanswer1.toString()
                scores2 = correctanswer2.toString()
                multiscoreP1DialogWinP1.text = scores1
                multiscoreP2DialogWinP1.text = scores2
                multiscoreP1DialogWinP2.text = scores1
                multiscoreP2DialogWinP2.text = scores2
                multiscoreDrawDialogP1.text = scores1
                multiscoreDrawDialogP2.text = scores2
                if (correctanswer1 > correctanswer2) {
                    dialogEndWinP1.show()
                } else if (correctanswer1 < correctanswer2) {
                    dialogEndWinP2.show()
                } else if (correctanswer1 == correctanswer2) {
                    dialogEndDraw.show()
                }
            }
            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun clickButtonPlayer1Win(clickBtnWinPlayer1: Button, clickBtnWinPlayer2: Button, score1: TextView, score2: TextView, activity: Activity, nextClass: Class<*>){
        onechek = true
        checkdIdBtn++
        if (checkdIdBtn == ID_TWO && mediaPlayer != null){
            releaseMPMulti()
            mediaPlayer = MediaPlayer.create(context, roundInfoMulti.music2)
            mediaPlayer?.start()
            clickBtnWinPlayer1.isClickable = false
        }

        mediaPlayer!!.setOnCompletionListener {
            setButtonBackgroundWinPlayer1(clickBtnWinPlayer1)
            setButtonBackgroundWinPlayer2(clickBtnWinPlayer2)
            accrualOfPoints(score1, score2)

            GlobalScope.launch(Dispatchers.Main) {
                delay(500)
                val intent = Intent(activity, nextClass)
                context.startActivity(intent)
                activity.finish()
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun clickButtonPlayer1WinFinalRound(clickBtnWinPlayer1: Button, clickBtnWinPlayer2: Button, score1: TextView, score2: TextView){
        onechek = true
        checkdIdBtn++
        if (checkdIdBtn == ID_TWO && mediaPlayer != null){
            releaseMPMulti()
            mediaPlayer = MediaPlayer.create(context, roundInfoMulti.music2)
            mediaPlayer?.start()
            clickBtnWinPlayer1.isClickable = false
        }

        mediaPlayer!!.setOnCompletionListener {
            setButtonBackgroundWinPlayer1(clickBtnWinPlayer1)
            setButtonBackgroundWinPlayer2(clickBtnWinPlayer2)
            accrualOfPoints(score1, score2)

            GlobalScope.launch(Dispatchers.Main) {
                delay(500)
                scores1 = correctanswer1.toString()
                scores2 = correctanswer2.toString()
                multiscoreP1DialogWinP1.text = scores1
                multiscoreP2DialogWinP1.text = scores2
                multiscoreP1DialogWinP2.text = scores1
                multiscoreP2DialogWinP2.text = scores2
                multiscoreDrawDialogP1.text = scores1
                multiscoreDrawDialogP2.text = scores2
                if (correctanswer1 > correctanswer2) {
                    dialogEndWinP1.show()
                } else if (correctanswer1 < correctanswer2) {
                    dialogEndWinP2.show()
                } else if (correctanswer1 == correctanswer2) {
                    dialogEndDraw.show()
                }
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun clickButtonPlayer2WinFinalRound(clickBtnWinPlayer2: Button, clickBtnWinPlayer1: Button, score1: TextView, score2: TextView){
        twochek = true
        checkdIdBtn++
        if (checkdIdBtn == ID_TWO && mediaPlayer != null){
            releaseMPMulti()
            mediaPlayer = MediaPlayer.create(context, roundInfoMulti.music2)
            mediaPlayer?.start()
            clickBtnWinPlayer1.isClickable = false
        }

        mediaPlayer!!.setOnCompletionListener {
            setButtonBackgroundWinPlayer1(clickBtnWinPlayer1)
            setButtonBackgroundWinPlayer2(clickBtnWinPlayer2)
            accrualOfPoints(score1, score2)

            GlobalScope.launch(Dispatchers.Main) {
                delay(500)
                scores1 = correctanswer1.toString()
                scores2 = correctanswer2.toString()
                multiscoreP1DialogWinP1.text = scores1
                multiscoreP2DialogWinP1.text = scores2
                multiscoreP1DialogWinP2.text = scores1
                multiscoreP2DialogWinP2.text = scores2
                multiscoreDrawDialogP1.text = scores1
                multiscoreDrawDialogP2.text = scores2
                if (correctanswer1 > correctanswer2) {
                    dialogEndWinP1.show()
                } else if (correctanswer1 < correctanswer2) {
                    dialogEndWinP2.show()
                } else if (correctanswer1 == correctanswer2) {
                    dialogEndDraw.show()
                }
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun clickButtonPlayer2Win(clickBtnWinPlayer2: Button, clickBtnWinPlayer1: Button, score1: TextView, score2: TextView, activity: Activity, nextClass: Class<*>){
        twochek = true
        checkdIdBtn++
        if (checkdIdBtn == ID_TWO && mediaPlayer != null){
            releaseMPMulti()
            mediaPlayer = MediaPlayer.create(context, roundInfoMulti.music2)
            mediaPlayer?.start()
            clickBtnWinPlayer1.isClickable = false
        }

        mediaPlayer!!.setOnCompletionListener {
            setButtonBackgroundWinPlayer1(clickBtnWinPlayer1)
            setButtonBackgroundWinPlayer2(clickBtnWinPlayer2)
            accrualOfPoints(score1, score2)

            GlobalScope.launch(Dispatchers.Main) {
                delay(500)
                val intent = Intent(activity, nextClass)
                context.startActivity(intent)
                activity.finish()
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun mediaStrartMulit(clickBtnWinPlayer1: Button, clickBtnWinPlayer2: Button, score1: TextView, score2: TextView, activity: Activity, nextClass: Class<*>){
        if (checkdIdBtn <= ID_ONE){
            mediaPlayer = MediaPlayer.create(context, roundInfoMulti.music1)
            mediaPlayer?.start()
        } else if (checkdIdBtn > ID_ONE){
            mediaPlayer = MediaPlayer.create(context, roundInfoMulti.music2)
            mediaPlayer?.start()

            mediaPlayer?.setOnCompletionListener {
                setButtonBackgroundWinPlayer1(clickBtnWinPlayer1)
                setButtonBackgroundWinPlayer2(clickBtnWinPlayer2)
                accrualOfPoints(score1, score2)
                GlobalScope.launch(Dispatchers.Main) {
                    delay(500)
                    if (checkdIdBtn == ID_TWO){
                        val intent = Intent(activity, nextClass)
                        context.startActivity(intent)
                        activity.finish()
                    }
                }
            }
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun mediaStrartMulitFinalRound(clickBtnWinPlayer1: Button, clickBtnWinPlayer2: Button, score1: TextView, score2: TextView){
        if (checkdIdBtn <= ID_ONE){
            mediaPlayer = MediaPlayer.create(context, roundInfoMulti.music1)
            mediaPlayer?.start()
        } else if (checkdIdBtn > ID_ONE){
            mediaPlayer = MediaPlayer.create(context, roundInfoMulti.music2)
            mediaPlayer?.start()

            mediaPlayer?.setOnCompletionListener {
                setButtonBackgroundWinPlayer1(clickBtnWinPlayer1)
                setButtonBackgroundWinPlayer2(clickBtnWinPlayer2)
                accrualOfPoints(score1, score2)
                GlobalScope.launch(Dispatchers.Main) {
                    delay(500)
                        if (checkdIdBtn == ID_TWO){
                            scores1 = correctanswer1.toString()
                            scores2 = correctanswer2.toString()
                            multiscoreP1DialogWinP1.text = scores1
                            multiscoreP2DialogWinP1.text = scores2
                            multiscoreP1DialogWinP2.text = scores1
                            multiscoreP2DialogWinP2.text = scores2
                            multiscoreDrawDialogP1.text = scores1
                            multiscoreDrawDialogP2.text = scores2
                            if (correctanswer1 > correctanswer2) {
                                dialogEndWinP1.show()
                            } else if (correctanswer1 < correctanswer2) {
                                dialogEndWinP2.show()
                            } else if (correctanswer1 == correctanswer2) {
                                dialogEndDraw.show()
                            }
                        }
                    }
                }
            }
        }


    fun releaseMPMulti() {
        if (mediaPlayer != null) {
            mediaPlayer!!.release()
            mediaPlayer = null
        }
    }

    fun clickBackButtonMulti(activity: Activity){
        if (Yodo1Mas.getInstance().isInterstitialAdLoaded) {
            Yodo1Mas.getInstance().showInterstitialAd(activity) // показать рекламу
            val intent = Intent(activity, GameMenu::class.java) //Создали намерение для перехода
            context.startActivity(intent)
            activity.finish()
        } else {
            val intent = Intent(activity, GameMenu::class.java)
            context.startActivity(intent)
            activity.finish()
        }
    }

    fun setButtonBackgroundCLickPlayer1(btnClick: Button, btnBlock1: Button, btnBlock2: Button, btnBlock3: Button){
        btnClick.background = ContextCompat.getDrawable(context, R.drawable.style_btn_stroke_whiteblack_press_whiteblue)
        btnBlock1.isClickable = false
        btnBlock2.isClickable = false
        btnBlock3.isClickable = false
    }

    fun setButtonBackgroundCLickPlayer2(btnClick: Button, btnBlock1: Button, btnBlock2: Button, btnBlock3: Button){
        btnClick.background = ContextCompat.getDrawable(context, R.drawable.style_btn_stroke_whiteblack_press_whitered)
        btnBlock1.isClickable = false
        btnBlock2.isClickable = false
        btnBlock3.isClickable = false
    }

    fun dialogEndWinP1Create(activity: Activity){
        //Вызов диалогового окна Выйграл первый игрок "В Конце" - начало
        dialogEndWinP1 = Dialog(context)
        dialogEndWinP1.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogEndWinP1.setContentView(R.layout.dialogend_winmulti)
        dialogEndWinP1.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogEndWinP1.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialogEndWinP1.setCancelable(false)
        //Вызов диалогового окна Выйграл первый игрок "В Конце" - конец

        multiscoreP1DialogWinP1 = dialogEndWinP1.findViewById(R.id.multip1scoreP1)
        multiscoreP2DialogWinP1 = dialogEndWinP1.findViewById(R.id.multip2scoreP1)

        //(Первый игрок) Кнопка которая закрывет диалоговое окно - начало
        btnDialogEndWinP1Cloce = dialogEndWinP1.findViewById(R.id.btnclose)
        btnDialogEndWinP1Cloce.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) {
                Yodo1Mas.getInstance().showInterstitialAd(activity)
                cleanResult()
                val intent = Intent(activity, GameMenu::class.java)
                context.startActivity(intent)
                activity.finish()
            } else {

                cleanResult()
                val intent = Intent(activity, GameMenu::class.java)
               context.startActivity(intent)
               activity.finish()

                dialogEndWinP1.dismiss()
            }
        }
        //(Первый игрок) Кнопка которая закрывет диалоговое окно - конец

        //(Первый игрок) Кнопка "ДАЛЕЕ" - начало
        btnDialogEndWinP1Continue = dialogEndWinP1.findViewById(R.id.btncontinue)
        btnDialogEndWinP1Continue.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) {
                Yodo1Mas.getInstance().showInterstitialAd(activity)
                cleanResult()
                val intent = Intent(activity, GameMenu::class.java)
               context.startActivity(intent)
               activity.finish()
            } else {
                cleanResult()
                val intent = Intent(activity, GameMenu::class.java)
                context.startActivity(intent)
                activity.finish()
                dialogEndWinP1.dismiss()
            }
        }
        //(Первый игрок) Кнопка "ДАЛЕЕ" - конец
    }

    fun dialogEndWinP2Create(activity: Activity){
        //Вызов диалогового окна Выйграл второй игрок "В Конце" - начало
        dialogEndWinP2 = Dialog(context)
        dialogEndWinP2.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogEndWinP2.setContentView(R.layout.dialogend_winmulti2)
        dialogEndWinP2.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogEndWinP2.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialogEndWinP2.setCancelable(false)
        //Вызов диалогового окна Выйграл второй игрок "В Конце" - конец

        multiscoreP1DialogWinP2 = dialogEndWinP2.findViewById(R.id.multip2scoreP1)
        multiscoreP2DialogWinP2 = dialogEndWinP2.findViewById(R.id.multip2scoreP2)

        //(Второй игрок) Кнопка которая закрывет диалоговое окно - начало
        btnDialogEndWinP2Cloce = dialogEndWinP2.findViewById(R.id.btnclose2)
        btnDialogEndWinP2Cloce.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(activity)
                cleanResult()
                val intent = Intent(activity, GameMenu::class.java)
               context.startActivity(intent)
               activity.finish()
            } else {
                    cleanResult()
                    val intent = Intent(activity, GameMenu::class.java)
                   context.startActivity(intent)
                   activity.finish()
                dialogEndWinP2.dismiss()
            }
        }
        //(Второй игрок) Кнопка которая закрывет диалоговое окно - конец

        //(Второй игрок) Кнопка "ДАЛЕЕ" - начало
        btnDialogEndWinP2Continue = dialogEndWinP2.findViewById(R.id.btncontinue2)
        btnDialogEndWinP2Continue.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(activity)
                cleanResult()
                val intent = Intent(activity, GameMenu::class.java)
               context.startActivity(intent)
               activity.finish()
            } else {
                    cleanResult()
                    val intent = Intent(activity, GameMenu::class.java)
                   context.startActivity(intent)
                   activity.finish()
                dialogEndWinP2.dismiss()
            }
        }
        //(Второй игрок) Кнопка "ДАЛЕЕ" - конец
    }

    fun dialogEndDrawreate(activity: Activity){
        //Вызов диалогового окна Ничья "В Конце" - начало
        dialogEndDraw = Dialog(context)
        dialogEndDraw.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogEndDraw.setContentView(R.layout.dialogend_draw)
        dialogEndDraw.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogEndDraw.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialogEndDraw.setCancelable(false)
        //Вызов диалогового окна Ничья "В Конце" - конец

        multiscoreDrawDialogP1 = dialogEndDraw.findViewById(R.id.multidrawscoreP1)
        multiscoreDrawDialogP2 = dialogEndDraw.findViewById(R.id.multidrawscoreP2)

        //(Ничья) Кнопка которая закрывет диалоговое окно - начало
        btnDialogEndDrawCloce = dialogEndDraw.findViewById(R.id.btnclosedraw)
        btnDialogEndDrawCloce.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(activity)
                cleanResult()
                val intent = Intent(activity, GameMenu::class.java)
               context.startActivity(intent)
               activity.finish()
            } else {
                try {
                    cleanResult()
                    val intent = Intent(activity, GameMenu::class.java)
                   context.startActivity(intent)
                   activity.finish()
                } catch (e: Exception) {
                    //Пусто
                }
                dialogEndDraw.dismiss()
            }
        }
        //(Ничья) Кнопка которая закрывет диалоговое окно - конец

        //(Ничья) Кнопка "ДАЛЕЕ" - начало
        btnDialogEndDrawContinue = dialogEndDraw.findViewById(R.id.btncontinuedraw)
        btnDialogEndDrawContinue.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(activity)
                cleanResult()
                val intent = Intent(activity, GameMenu::class.java)
               context.startActivity(intent)
               activity.finish()
            } else {
                try {
                    cleanResult()
                    val intent = Intent(activity, GameMenu::class.java)
                   context.startActivity(intent)
                   activity.finish()
                } catch (e: Exception) {
                    //Пусто
                }
                dialogEndDraw.dismiss()
            }
        }
        //(Ничья) Кнопка "ДАЛЕЕ" - конец
    }

    fun loadResult() {
        mypref = context.getSharedPreferences(KEY_SHARED_PREF, MODE_PRIVATE)
        correctanswer1 = mypref.getInt(KEY_SCORE1, ID_ZERO)
        correctanswer2 = mypref.getInt(KEY_SCORE2, ID_ZERO)
    }

    private fun setButtonBackgroundWinPlayer1(btn: Button) {
        btn.background = ContextCompat.getDrawable(context, R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
    }

    private fun setButtonBackgroundWinPlayer2(btn: Button) {
        btn.background = ContextCompat.getDrawable(context, R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
    }

    //Метод начисления балов - начало
    private fun accrualOfPoints(score1: TextView, score2: TextView) {
        if (onechek && !twochek) {
            correctanswer1 += 1 //Увеличиваем правильный ответ первому игроку на 1
            score1.text = "$correctanswer1" //Меняем текст первому игроку
        } else if (!onechek && twochek) {
            correctanswer2 += 1 //Увеличиваем правильный ответ второму игроку на 1
            score2.text = "$correctanswer2" //Меняем текст первому игроку
        } else if (onechek && twochek) {
            correctanswer1 += 1 //Увеличиваем правильный ответ первому игроку на 1
            correctanswer2 += 1 //Увеличиваем правильный ответ первому игроку на 1
            score1.text = "$correctanswer1" //Меняем текст первому игроку
            score2.text = "$correctanswer2" //Меняем текст первому игроку
        }
        saveResult()
    }
    //Метод начисления балов - конец

    //Метод сохранения результатов уровня - начало
    private fun saveResult() {
        mypref = context.getSharedPreferences(KEY_SHARED_PREF, MODE_PRIVATE) //получили объект класса который позволяет работаь с данными
        val ed = mypref.edit() //получили объект Editor для редактирования данных
        ed.putInt(KEY_SCORE1, correctanswer1) //ключ хранения и данные
        ed.putInt(KEY_SCORE2, correctanswer2) //ключ хранения и данные
        ed.apply() //Выполняем apply для сохранения данных
    }
    //Метод сохранения результатов уровня - конец

    //Метод очистки результата - начало
    private fun cleanResult() {
        mypref = context.getSharedPreferences(KEY_SHARED_PREF, MODE_PRIVATE)
        val ed = mypref.edit()
        ed.remove(KEY_SCORE1)
        ed.remove(KEY_SCORE2)
        ed.apply()
    }
    //Метод очистки результата - конец

}