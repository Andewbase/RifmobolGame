package z.nova.rifmobolgame.singlplayer

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yodo1.mas.Yodo1Mas
import z.nova.rifmobolgame.PlayGame
import z.nova.rifmobolgame.R
import z.nova.rifmobolgame.model.round.GetRoundInfo
import z.nova.rifmobolgame.model.round.RoundInfo
import z.nova.rifmobolgame.model.round.RoundInfoImpl

class Level27 : AppCompatActivity() {

    val roundInfoImpl = RoundInfoImpl(27)
    val getRoundInfo = GetRoundInfo(roundRepo = roundInfoImpl)

    val roundInfo: RoundInfo = getRoundInfo.execut()

    var mediaPlayer //Создаём Медиа плеер
            : MediaPlayer? = null
   lateinit var dialogEndWin //Создаём Диалог Выйграл
            : Dialog
   lateinit var dialogEndLose //Создаем Диалог Проиграл
            : Dialog
    var Clicked = 0 //Создаём переменую для отслеживания нажатия
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.universal)

        //Создаём переменную text_levels
        val text_levels = findViewById<TextView>(R.id.text_levels)
        text_levels.setText(roundInfo.textLvl) //Установили текст
        val btn_bottom_right =
            findViewById<View>(R.id.btn_right_bottom) as Button //Создаём нижнюю правую кнопку
        val btn_up_left =
            findViewById<View>(R.id.btn_left_up) as Button //Создаём левую верхнюю кнопку
        val btn_up_right =
            findViewById<View>(R.id.btn_right_up) as Button //Создаём правую верхнюю кнопку
        val btn_bottom_left =
            findViewById<View>(R.id.btn_left_bottom) as Button //Создаём нижнюю правоую кнопку


        //Устанавливаем фон для уровня - начало
        val background = findViewById<View>(R.id.menu_background) as ImageView
        background.setImageResource(roundInfo.backgroundRound)
        //Устанавливаем фон для уровня - конец

        //Устанавливаем текст для уровня - начало
        val textlevel2 = findViewById<TextView>(R.id.couplet_text)
        textlevel2.setText(roundInfo.textCouplet)
        //Устанавливаем текст для уровня - конец


        //Меняем текст в кнопках - начало
        btn_up_left.setText(roundInfo.nameBtnone)
        btn_up_right.setText(roundInfo.nameBtntwo)
        btn_bottom_left.setText(roundInfo.nameBtnthree)
        btn_bottom_right.setText(roundInfo.nameBtnfour)
        //Меняем текст в кнопках - конец

        //Вызов диалогового окна Выйграл "В Конце" - начало
        dialogEndWin = Dialog(this)
        dialogEndWin!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogEndWin!!.setContentView(R.layout.dialogend_win)
        dialogEndWin!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogEndWin!!.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialogEndWin!!.setCancelable(false)
        //Вызов диалогового окна Выйграл "В Конце" - конец


        //Устанавливаем текст в диалоговое окно - начало
        val textdescriptions = dialogEndWin!!.findViewById<View>(R.id.textwin) as TextView
        textdescriptions.setText(R.string.dialogwins2)
        //Устанавливаем текст в диалоговое окно - начало

        //Кнопка которая закрывет диалоговое окно - начало
        val btnclose = dialogEndWin!!.findViewById<View>(R.id.btnclose) as TextView
        btnclose.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(this@Level27) //Показать рекламу
                val intent = Intent(this@Level27, PlayGame::class.java)
                startActivity(intent)
                finish()
            } else {
                try {
                    val intent = Intent(this@Level27, PlayGame::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    //Пусто
                }
                dialogEndWin!!.dismiss()
            }
        }
        //Кнопка которая закрывет диалоговое окно - конец

        //Кнопка "ДАЛЕЕ" - начало
        val buttoncontinue = dialogEndWin!!.findViewById<View>(R.id.btncontinue) as Button
        buttoncontinue.setOnClickListener {
            try {
                val intent = Intent(this@Level27, Level28::class.java) //ИЗМЕНИТЬ
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                //Пусто
            }
            dialogEndWin!!.dismiss()
        }
        //Кнопка "ДАЛЕЕ" - конец

        //Вызов диалогового окна Проиграл "В Конце" - начало
        dialogEndLose = Dialog(this)
        dialogEndLose!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogEndLose!!.setContentView(R.layout.dialogend_lose)
        dialogEndLose!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogEndLose!!.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialogEndLose!!.setCancelable(false)
        //Вызов диалогового окна Проиграл "В Конце" - конец


        //Устанавливаем текст в диалоговое окно - начало
        val textdescriptionsl = dialogEndLose!!.findViewById<View>(R.id.textlose) as TextView
        textdescriptionsl.setText(R.string.dialoglose2)
        //Устанавливаем текст в диалоговое окно - начало


        //Кнопка которая закрывет диалоговое окно - начало
        val btnclose1 = dialogEndLose!!.findViewById<View>(R.id.btnclose) as TextView
        btnclose1.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(this@Level27) //Показать рекламу
                val intent = Intent(this@Level27, PlayGame::class.java)
                startActivity(intent)
                finish()
            } else {
                try {
                    val intent = Intent(this@Level27, PlayGame::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    //Пусто
                }
                dialogEndLose!!.dismiss()
            }
        }
        //Кнопка которая закрывет диалоговое окно - конец

        //Кнопка "ЕЩЕ РАЗ" - начало
        val buttoncontinueback1 = dialogEndLose!!.findViewById<View>(R.id.btncontinueback) as Button
        buttoncontinueback1.setOnClickListener {
            try {
                val intent = Intent(this@Level27, Level27::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                //Пусто
            }
            dialogEndLose!!.dismiss()
        }
        //Кнопка "ЕЩЁ РАЗ" - конец

        //Кнопка "ДАЛЕЕ" - начало
        val buttoncontinue1 = dialogEndLose!!.findViewById<View>(R.id.btncontinue) as Button
        buttoncontinue1.setOnClickListener {
            try {
                val intent = Intent(this@Level27, Level28::class.java) //ИЗМЕНИТЬ
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                //Пусто
            }
            dialogEndLose!!.dismiss()
        }
        //Кнопка "ДАЛЕЕ" - конец


        //Кнопка "Назад" - начало
        val btn_back = findViewById<View>(R.id.button_back) as Button
        btn_back.setOnClickListener {
            //Обрабатывем нажатие кнопки "Назад" - начало
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(this@Level27) //Показать рекламу
                val intent = Intent(this@Level27, PlayGame::class.java)
                startActivity(intent)
                finish()
            } else {
                try {
                    //Вернуться назад к выбору уровня - начало
                    val intent =
                        Intent(this@Level27, PlayGame::class.java) //Создали намерение для перехода
                    startActivity(intent)
                    finish()
                    //Вернуться назад к выбору уровня - конец
                } catch (e: Exception) {
                    //Здесь кода не будет
                }
                //Обрабатываем нажатие кнопки "Назад" - конец
            }
        }
        //Кнопка "Назад" - конец

        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - начало
        btn_up_left.setOnClickListener {
            try {
                Clicked = 1 //Кнопка нажата
                //Вопроизводим полный куплет -начало
                if (mediaPlayer != null) {
                    releaseMP()
                    mediaPlayer = MediaPlayer.create(applicationContext, roundInfo.music2) //Изменять
                    mediaPlayer?.start()
                    btn_up_left.isClickable =
                        false //Отключаем кнопку после нажатия, setEnable(false) красит в серый цвет кнопку
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        dialogEndLose!!.show() // Выводим диалог проиграл
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                }
                //Метод показывающий правельный ответ - конец
                btn_up_left.background =
                    resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whiteblue) // Меняем фон кнопки при нажатие
                btn_up_right.isClickable = false //Блокируем правую верхнюю
                btn_bottom_left.isClickable = false //Блокируем нижнюю левую
                btn_bottom_right.isClickable = false //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        }
        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - конец

        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - начало
        btn_up_right.setOnClickListener {
            try {
                Clicked = 2 //Кнопка нажата
                //Вопроизводим полный куплет -начало
                if (mediaPlayer != null) {
                    releaseMP()
                    mediaPlayer = MediaPlayer.create(applicationContext, roundInfo.music2)
                    mediaPlayer?.start()
                    btn_up_right.isClickable = false //Отключаем кнопку после нажатия
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        dialogEndWin!!.show() //Выводим диалог проиграл
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                btn_up_right.background =
                    resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whiteblue) // Меняем фон кнопки при нажатие
                btn_up_left.isClickable = false //Блокируем правую верхнюю
                btn_bottom_left.isClickable = false //Блокируем нижнюю левую
                btn_bottom_right.isClickable = false //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        }
        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - конец

        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - начало
        btn_bottom_left.setOnClickListener {
            try {
                Clicked = 3 //Кнопка нажата
                //Вопроизводим полный куплет -начало
                if (mediaPlayer != null) {
                    releaseMP()
                    mediaPlayer = MediaPlayer.create(applicationContext, roundInfo.music2)
                    mediaPlayer?.start()
                    btn_bottom_left.isClickable = false //Отключаем кнопку после нажатия
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        dialogEndLose!!.show() //Выводим диалог проиграл
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                btn_bottom_left.background =
                    resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whiteblue) // Меняем фон кнопки при нажатие
                btn_up_left.isClickable = false //Блокируем правую верхнюю
                btn_up_right.isClickable = false //Блокируем нижнюю левую
                btn_bottom_right.isClickable = false //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        }
        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - конец

        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - начало
        btn_bottom_right.setOnClickListener {
            try {
                Clicked = 4 //Кнопка нажата
                //Вопроизводим полный куплет -начало
                if (mediaPlayer != null) {
                    releaseMP()
                    mediaPlayer = MediaPlayer.create(applicationContext, roundInfo.music2)
                    mediaPlayer?.start()
                    btn_bottom_right.isClickable = false //Отключаем кнопку после нажатия
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        dialogEndLose!!.show() //Выводим диалог выйграл
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                btn_bottom_right.background =
                    resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whiteblue) // Меняем фон кнопки при нажатие
                btn_up_left.isClickable = false //Блокируем правую верхнюю
                btn_up_right.isClickable = false //Блокируем нижнюю левую
                btn_bottom_left.isClickable = false //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        }
        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - конец
    }

    //Проигрываем музыку при запуске уровня - начало
    override fun onResume() {
        super.onResume()
        val btn_up_right =
            findViewById<View>(R.id.btn_right_up) as Button //Создаём нижнюю правую кнопку
        if (mediaPlayer == null && Clicked == 0) { //Если свернули игру до нажатия варианта ответа
            mediaPlayer = MediaPlayer.create(applicationContext, roundInfo.music1)
            mediaPlayer?.start()
        } else if (Clicked > 0) { //Иначе если свернули игру после нажатия варианта ответа
            mediaPlayer = MediaPlayer.create(applicationContext, roundInfo.music2)
            mediaPlayer?.start()
            //Метод показывающий правельный ответ - начало
            mediaPlayer?.setOnCompletionListener(MediaPlayer.OnCompletionListener {
                btn_up_right.background =
                    resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                Handler().postDelayed({
                    if (Clicked == 2) {
                        dialogEndWin!!.show() //Выводит диалог выйграл
                    } else {
                        dialogEndLose!!.show() //Выводит диалог проиграл
                    }
                }, 500)
                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
            })
            //Метод показывающий правельный ответ - конец
        }
    }

    //Проигрываем музыку при запуске уровня - конец
    //Метод освобождения Плеера - начало
    private fun releaseMP() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer!!.release()
                mediaPlayer = null
            } catch (e: Exception) {
                //Пусто
            }
        }
    }

    //Метод освобождения Плеера - конец
    //Системная кнопка "Назад" - начало
    override fun onBackPressed() {
        if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
            Yodo1Mas.getInstance().showInterstitialAd(this@Level27) // показать рекламу
            val intent = Intent(this@Level27, PlayGame::class.java)
            startActivity(intent)
            finish()
        } else {
            try {
                val intent = Intent(this@Level27, PlayGame::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                //Пусто
            }
        }
    }

    //Системная кнопка "Назад" - конец
    //Останавливает проигрыватель при паузе активити - начало
    override fun onPause() {
        super.onPause()
        releaseMP()
    }

    //Останавливает проигрыватель при паузе активити - конец
    //Освобождаем ресурсы проигрывателя при уничтожение активити - начало
    override fun onDestroy() {
        super.onDestroy()
        releaseMP()
    } //Освобождаем ресурсы проигрывателя при уничтожение активити - конец
}