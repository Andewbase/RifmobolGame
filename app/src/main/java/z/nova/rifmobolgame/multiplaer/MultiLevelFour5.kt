package z.nova.rifmobolgame.multiplaer

import android.app.Dialog
import android.content.Intent
import android.content.SharedPreferences
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
import z.nova.rifmobolgame.GameMenu
import z.nova.rifmobolgame.R

class MultiLevelFour5 : AppCompatActivity() {
    var mediaPlayer //Создаём Медиа плеер
            : MediaPlayer? = null
   lateinit var dialogEndWin //Создаём Диалог Выйграл первый игрок
            : Dialog
   lateinit var dialogEndWin2 //Создаём Диалог Выйграл второй игрок
            : Dialog
   lateinit var dialogEndDraw //Создаём Диалог Ничья
            : Dialog
    var check = 0 //счётчики нажатия
   lateinit var mypref: SharedPreferences
    var correctanswer1 = 0 //Счёт первого игрока
    var correctanswer2 = 0 //Счёт второго игрока
    var onechek = false //проверка нажал ли первый игрок правильный ответ
    var twochek = false //проверка нажал ли второй игрок правильный ответ
   lateinit var score1: TextView
   lateinit var score2: TextView
   lateinit var scores1: String
   lateinit var scores2: String
   lateinit var multiscore: TextView
   lateinit var multiscore2: TextView
   lateinit var multiscoredraw: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.universalmulti)
        loadResult()

        //Создаём переменую с отображением счёта для первого игрока
        score1 = findViewById(R.id.scoree1)
        score1.setText("Первый Игрок : $correctanswer1") //Устанавливаем текст

        //Создаём переменую с отображением счёта для второго игрока
        score2 = findViewById(R.id.scoree2)
        score2.setText("Второй Игрок : $correctanswer2") //Устанавливаем текст


        //Создаём переменную text_levels
        val text_levels = findViewById<TextView>(R.id.text_levels)
        text_levels.setText(R.string.raund5) //Установили текст

        //Устанавливаем фон для уровня - начало
        val background = findViewById<View>(R.id.menu_background) as ImageView
        background.setImageResource(R.drawable.level10_background)
        //Устанавливаем фон для уровня - конец

        //Устанавливаем текст для уровня - начало
        val textlevel2 = findViewById<TextView>(R.id.couplet_text)
        textlevel2.setText(R.string.lvlcouplet20)
        //Устанавливаем текст для уровня - конец
        val p1btn_up_left =
            findViewById<View>(R.id.p1btn_left_up) as Button //Создаём левую верхнюю кнопку (первый игрок)
        val p1btn_up_right =
            findViewById<View>(R.id.p1btn_right_up) as Button //Создаём правую верхнюю кнопку (первый игрок)
        val p1btn_bottom_right =
            findViewById<View>(R.id.p1btn_right_bottom) as Button //Создаём нижнюю правоую кнопку (первый игрок)
        val p1btn_bottom_left =
            findViewById<View>(R.id.p1btn_left_bottom) as Button //Создаём нижнюю левую кнопку (первый игрок)
        val p2btn_up_left =
            findViewById<View>(R.id.p2btn_left_up) as Button //Создаём левую верхнюю кнопку (второй игрок)
        val p2btn_up_right =
            findViewById<View>(R.id.p2btn_right_up) as Button //Создаём правую верхнюю кнопку (второй игрок)
        val p2btn_bottom_right =
            findViewById<View>(R.id.p2btn_right_bottom) as Button //Создаём нижнюю правоую кнопку (второй игрок)
        val p2btn_bottom_left =
            findViewById<View>(R.id.p2btn_left_bottom) as Button //Создаём нижнюю левую кнопку (второй игрок)

        //Меняем текст в кнопках - начало
        p1btn_up_left.setText(R.string.lvl20textone)
        p1btn_up_right.setText(R.string.lvl20texttwo)
        p1btn_bottom_left.setText(R.string.lvl20textthree)
        p1btn_bottom_right.setText(R.string.lvl20textfour)
        p2btn_up_left.setText(R.string.lvl20textone)
        p2btn_up_right.setText(R.string.lvl20texttwo)
        p2btn_bottom_left.setText(R.string.lvl20textthree)
        p2btn_bottom_right.setText(R.string.lvl20textfour)
        //Меняем текст в кнопках - конец


        //Вызов диалогового окна Выйграл первый игрок "В Конце" - начало
        dialogEndWin = Dialog(this)
        dialogEndWin!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogEndWin!!.setContentView(R.layout.dialogend_winmulti)
        dialogEndWin!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogEndWin!!.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialogEndWin!!.setCancelable(false)
        //Вызов диалогового окна Выйграл первый игрок "В Конце" - конец

        //Вызов диалогового окна Выйграл второй игрок "В Конце" - начало
        dialogEndWin2 = Dialog(this)
        dialogEndWin2!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogEndWin2!!.setContentView(R.layout.dialogend_winmulti2)
        dialogEndWin2!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogEndWin2!!.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialogEndWin2!!.setCancelable(false)
        //Вызов диалогового окна Выйграл второй игрок "В Конце" - конец

        //Вызов диалогового окна Ничья "В Конце" - начало
        dialogEndDraw = Dialog(this)
        dialogEndDraw!!.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogEndDraw!!.setContentView(R.layout.dialogend_draw)
        dialogEndDraw!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogEndDraw!!.window!!.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
        dialogEndDraw!!.setCancelable(false)
        //Вызов диалогового окна Ничья "В Конце" - конец

        //(Первый игрок) Кнопка которая закрывет диалоговое окно - начало
        val btnclose = dialogEndWin!!.findViewById<View>(R.id.btnclose) as TextView
        btnclose.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(this@MultiLevelFour5)
                cleanResult()
                val intent = Intent(this@MultiLevelFour5, GameMenu::class.java)
                startActivity(intent)
                finish()
            } else {
                try {
                    cleanResult()
                    val intent = Intent(this@MultiLevelFour5, GameMenu::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    //Пусто
                }
                dialogEndWin!!.dismiss()
            }
        }
        //(Первый игрок) Кнопка которая закрывет диалоговое окно - конец

        //(Первый игрок) Кнопка "ДАЛЕЕ" - начало
        val buttoncontinue = dialogEndWin!!.findViewById<View>(R.id.btncontinue) as Button
        buttoncontinue.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(this@MultiLevelFour5)
                cleanResult()
                val intent = Intent(this@MultiLevelFour5, GameMenu::class.java)
                startActivity(intent)
                finish()
            } else {
                try {
                    cleanResult()
                    val intent = Intent(this@MultiLevelFour5, GameMenu::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    //Пусто
                }
                dialogEndWin!!.dismiss()
            }
        }
        //(Первый игрок) Кнопка "ДАЛЕЕ" - конец

        //(Второй игрок) Кнопка которая закрывет диалоговое окно - начало
        val btnclose2 = dialogEndWin2!!.findViewById<View>(R.id.btnclose2) as TextView
        btnclose2.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(this@MultiLevelFour5)
                cleanResult()
                val intent = Intent(this@MultiLevelFour5, GameMenu::class.java)
                startActivity(intent)
                finish()
            } else {
                try {
                    cleanResult()
                    val intent = Intent(this@MultiLevelFour5, GameMenu::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    //Пусто
                }
                dialogEndWin2!!.dismiss()
            }
        }
        //(Второй игрок) Кнопка которая закрывет диалоговое окно - конец

        //(Второй игрок) Кнопка "ДАЛЕЕ" - начало
        val buttoncontinue2 = dialogEndWin2!!.findViewById<View>(R.id.btncontinue2) as Button
        buttoncontinue2.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(this@MultiLevelFour5)
                cleanResult()
                val intent = Intent(this@MultiLevelFour5, GameMenu::class.java)
                startActivity(intent)
                finish()
            } else {
                try {
                    cleanResult()
                    val intent = Intent(this@MultiLevelFour5, GameMenu::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    //Пусто
                }
                dialogEndWin2!!.dismiss()
            }
        }
        //(Второй игрок) Кнопка "ДАЛЕЕ" - конец

        //(Ничья) Кнопка которая закрывет диалоговое окно - начало
        val btnclosedraw = dialogEndDraw!!.findViewById<View>(R.id.btnclosedraw) as TextView
        btnclosedraw.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(this@MultiLevelFour5)
                cleanResult()
                val intent = Intent(this@MultiLevelFour5, GameMenu::class.java)
                startActivity(intent)
                finish()
            } else {
                try {
                    cleanResult()
                    val intent = Intent(this@MultiLevelFour5, GameMenu::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    //Пусто
                }
                dialogEndDraw!!.dismiss()
            }
        }
        //(Ничья) Кнопка которая закрывет диалоговое окно - конец

        //(Ничья) Кнопка "ДАЛЕЕ" - начало
        val buttoncontinuedraw = dialogEndDraw!!.findViewById<View>(R.id.btncontinuedraw) as Button
        buttoncontinuedraw.setOnClickListener {
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(this@MultiLevelFour5)
                cleanResult()
                val intent = Intent(this@MultiLevelFour5, GameMenu::class.java)
                startActivity(intent)
                finish()
            } else {
                try {
                    cleanResult()
                    val intent = Intent(this@MultiLevelFour5, GameMenu::class.java)
                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                    //Пусто
                }
                dialogEndDraw!!.dismiss()
            }
        }
        //(Ничья) Кнопка "ДАЛЕЕ" - конец

        //Cчёт в диалоговом окне - начало
        multiscore = dialogEndWin!!.findViewById(R.id.multiscore)
        multiscore2 = dialogEndWin2!!.findViewById(R.id.multiscore2)
        multiscoredraw = dialogEndDraw!!.findViewById(R.id.multiscoredraw)
        //Cчёт в диалоговом окне - конец


        //Кнопка "Назад" - начало
        val btn_back = findViewById<View>(R.id.button_back) as Button
        btn_back.setOnClickListener {
            //Обрабатывем нажатие кнопки "Назад" - начало
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(this@MultiLevelFour5) //Показать рекламу
                val intent = Intent(
                    this@MultiLevelFour5,
                    GameMenu::class.java
                ) //Создали намерение для перехода
                startActivity(intent)
                finish()
            } else {
                try {
                    //Вернуться назад к выбору уровня - начало
                    val intent = Intent(
                        this@MultiLevelFour5,
                        GameMenu::class.java
                    ) //Создали намерение для перехода
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


        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - начало (первый игрок)
        p1btn_up_left.setOnClickListener {
            try {
                onechek = true
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет -начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.lilies2)
                        mediaPlayer?.start()
                        p1btn_up_left.isClickable =
                            false //Отключаем кнопку после нажатия, setEnable(false) красит в серый цвет кнопку
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        scores1 = correctanswer1.toString()
                        scores2 = correctanswer2.toString()
                        multiscore.setText("Счёт : $scores1 - $scores2")
                        multiscore2.setText("Счёт : $scores1 - $scores2")
                        multiscoredraw.setText("Счёт : $scores1 - $scores2")
                        if (correctanswer1 > correctanswer2) {
                            dialogEndWin!!.show()
                        } else if (correctanswer1 < correctanswer2) {
                            dialogEndWin2!!.show()
                        } else if (correctanswer1 == correctanswer2) {
                            dialogEndDraw!!.show()
                        }
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                }
                //Метод показывающий правельный ответ - конец
                p1btn_up_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whiteblue)
                p1btn_up_right.isClickable = false //Блокируем правую верхнюю
                p1btn_bottom_left.isClickable = false //Блокируем нижнюю левую
                p1btn_bottom_right.isClickable = false //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        }
        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - конец (первый игрок)

        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - начало (первый игрок)
        p1btn_up_right.setOnClickListener {
            try {
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет - начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.lilies2)
                        mediaPlayer?.start()
                        p1btn_up_right.isClickable = false //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        scores1 = correctanswer1.toString()
                        scores2 = correctanswer2.toString()
                        multiscore.setText("Счёт : $scores1 - $scores2")
                        multiscore2.setText("Счёт : $scores1 - $scores2")
                        multiscoredraw.setText("Счёт : $scores1 - $scores2")
                        if (correctanswer1 > correctanswer2) {
                            dialogEndWin!!.show()
                        } else if (correctanswer1 < correctanswer2) {
                            dialogEndWin2!!.show()
                        } else if (correctanswer1 == correctanswer2) {
                            dialogEndDraw!!.show()
                        }
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                p1btn_up_right.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whiteblue)
                p1btn_up_left.isClickable = false //Блокируем правую верхнюю
                p1btn_bottom_left.isClickable = false //Блокируем нижнюю левую
                p1btn_bottom_right.isClickable = false //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        }
        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - конец (первый игрок)

        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - начало (первый игрок)
        p1btn_bottom_left.setOnClickListener {
            try {
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет -начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.lilies2)
                        mediaPlayer?.start()
                        p1btn_bottom_left.isClickable = false //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        scores1 = correctanswer1.toString()
                        scores2 = correctanswer2.toString()
                        multiscore.setText("Счёт : $scores1 - $scores2")
                        multiscore2.setText("Счёт : $scores1 - $scores2")
                        multiscoredraw.setText("Счёт : $scores1 - $scores2")
                        if (correctanswer1 > correctanswer2) {
                            dialogEndWin!!.show()
                        } else if (correctanswer1 < correctanswer2) {
                            dialogEndWin2!!.show()
                        } else if (correctanswer1 == correctanswer2) {
                            dialogEndDraw!!.show()
                        }
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                p1btn_bottom_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whiteblue)
                p1btn_up_left.isClickable = false //Блокируем правую верхнюю
                p1btn_up_right.isClickable = false //Блокируем нижнюю левую
                p1btn_bottom_right.isClickable = false //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        }
        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - конец (первый игрок)

        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - начало
        p1btn_bottom_right.setOnClickListener {
            try {
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет - начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.lilies2)
                        mediaPlayer?.start()
                        p1btn_bottom_right.isClickable = false //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        scores1 = correctanswer1.toString()
                        scores2 = correctanswer2.toString()
                        multiscore.setText("Счёт : $scores1 - $scores2")
                        multiscore2.setText("Счёт : $scores1 - $scores2")
                        multiscoredraw.setText("Счёт : $scores1 - $scores2")
                        if (correctanswer1 > correctanswer2) {
                            dialogEndWin!!.show()
                        } else if (correctanswer1 < correctanswer2) {
                            dialogEndWin2!!.show()
                        } else if (correctanswer1 == correctanswer2) {
                            dialogEndDraw!!.show()
                        }
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                p1btn_bottom_right.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whiteblue)
                p1btn_up_left.isClickable = false //Блокируем правую верхнюю
                p1btn_up_right.isClickable = false //Блокируем нижнюю левую
                p1btn_bottom_left.isClickable = false //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        }
        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - конец (первый игрок)

        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - начало (второй игрок)
        p2btn_up_left.setOnClickListener {
            try {
                twochek = true
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет -начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.lilies2)
                        mediaPlayer?.start()
                        p2btn_up_left.isClickable =
                            false //Отключаем кнопку после нажатия, setEnable(false) красит в серый цвет кнопку
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        scores1 = correctanswer1.toString()
                        scores2 = correctanswer2.toString()
                        multiscore.setText("Счёт : $scores1 - $scores2")
                        multiscore2.setText("Счёт : $scores1 - $scores2")
                        multiscoredraw.setText("Счёт : $scores1 - $scores2")
                        if (correctanswer1 > correctanswer2) {
                            dialogEndWin!!.show()
                        } else if (correctanswer1 < correctanswer2) {
                            dialogEndWin2!!.show()
                        } else if (correctanswer1 == correctanswer2) {
                            dialogEndDraw!!.show()
                        }
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                }
                //Метод показывающий правельный ответ - конец
                p2btn_up_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitered)
                p2btn_up_right.isClickable = false //Блокируем правую верхнюю
                p2btn_bottom_left.isClickable = false //Блокируем нижнюю левую
                p2btn_bottom_right.isClickable = false //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        }
        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - конец (второй игрок)

        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - начало (второй игрок)
        p2btn_up_right.setOnClickListener {
            try {
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет - начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.lilies2)
                        mediaPlayer?.start()
                        p2btn_up_right.isClickable = false //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        scores1 = correctanswer1.toString()
                        scores2 = correctanswer2.toString()
                        multiscore.setText("Счёт : $scores1 - $scores2")
                        multiscore2.setText("Счёт : $scores1 - $scores2")
                        multiscoredraw.setText("Счёт : $scores1 - $scores2")
                        if (correctanswer1 > correctanswer2) {
                            dialogEndWin!!.show()
                        } else if (correctanswer1 < correctanswer2) {
                            dialogEndWin2!!.show()
                        } else if (correctanswer1 == correctanswer2) {
                            dialogEndDraw!!.show()
                        }
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                p2btn_up_right.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitered)
                p2btn_up_left.isClickable = false //Блокируем правую верхнюю
                p2btn_bottom_left.isClickable = false //Блокируем нижнюю левую
                p2btn_bottom_right.isClickable = false //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        }
        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - конец (второй игрок)

        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - начало (второй игрок)
        p2btn_bottom_left.setOnClickListener {
            try {
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет -начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.lilies2)
                        mediaPlayer?.start()
                        p2btn_bottom_left.isClickable = false //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        scores1 = correctanswer1.toString()
                        scores2 = correctanswer2.toString()
                        multiscore.setText("Счёт : $scores1 - $scores2")
                        multiscore2.setText("Счёт : $scores1 - $scores2")
                        multiscoredraw.setText("Счёт : $scores1 - $scores2")
                        if (correctanswer1 > correctanswer2) {
                            dialogEndWin!!.show()
                        } else if (correctanswer1 < correctanswer2) {
                            dialogEndWin2!!.show()
                        } else if (correctanswer1 == correctanswer2) {
                            dialogEndDraw!!.show()
                        }
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                p2btn_bottom_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitered)
                p2btn_up_left.isClickable = false //Блокируем правую верхнюю
                p2btn_up_right.isClickable = false //Блокируем нижнюю левую
                p2btn_bottom_right.isClickable = false //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        }
        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - конец (второй игрок)

        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - начало (второй игрок)
        p2btn_bottom_right.setOnClickListener {
            try {
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет - начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.lilies2)
                        mediaPlayer?.start()
                        p2btn_bottom_right.isClickable = false //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_left.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        scores1 = correctanswer1.toString()
                        scores2 = correctanswer2.toString()
                        multiscore.setText("Счёт : $scores1 - $scores2")
                        multiscore2.setText("Счёт : $scores1 - $scores2")
                        multiscoredraw.setText("Счёт : $scores1 - $scores2")
                        if (correctanswer1 > correctanswer2) {
                            dialogEndWin!!.show()
                        } else if (correctanswer1 < correctanswer2) {
                            dialogEndWin2!!.show()
                        } else if (correctanswer1 == correctanswer2) {
                            dialogEndDraw!!.show()
                        }
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                p2btn_bottom_right.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitered)
                p2btn_up_left.isClickable = false //Блокируем правую верхнюю
                p2btn_up_right.isClickable = false //Блокируем нижнюю левую
                p2btn_bottom_left.isClickable = false //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        }
        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - конец (второй игрок)
    }

    //Проигрываем музыку при запуске уровня - начало
    override fun onResume() {
        super.onResume()
        //Создаём переменую с отображением счёта для первого игрока
        score1 = findViewById(R.id.scoree1)

        //Создаём переменую с отображением счёта для второго игрока
        score2 = findViewById(R.id.scoree2)
        multiscore = dialogEndWin!!.findViewById(R.id.multiscore)
        multiscore2 = dialogEndWin2!!.findViewById(R.id.multiscore2)
        multiscoredraw = dialogEndDraw!!.findViewById(R.id.multiscoredraw)
        val p1btn_up_left =
            findViewById<View>(R.id.p1btn_left_up) as Button //Создаём нижнюю левую кнопку
        val p2btn_up_left =
            findViewById<View>(R.id.p2btn_left_up) as Button //Создаём нижнюю левую кнопку (второй игрок)
        if (check <= 1) { //Если свернули игру до нажатия варианта ответа, либо когда нажал только один игрок
            mediaPlayer = MediaPlayer.create(applicationContext, R.raw.lilies1)
            mediaPlayer?.start()
        } else if (check > 1) { //Иначе если свернули игру после нажатия вариантов ответа двумя игроками
            mediaPlayer = MediaPlayer.create(applicationContext, R.raw.lilies2)
            mediaPlayer?.start()
            //Метод показывающий правельный ответ - начало
            mediaPlayer?.setOnCompletionListener(MediaPlayer.OnCompletionListener {
                p1btn_up_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                p2btn_up_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                accrualOfPoints()
                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                Handler().postDelayed({
                    if (check == 2) {
                        scores1 = correctanswer1.toString()
                        scores2 = correctanswer2.toString()
                        multiscore.setText("Счёт : $scores1 - $scores2")
                        multiscore2.setText("Счёт : $scores1 - $scores2")
                        multiscoredraw.setText("Счёт : $scores1 - $scores2")
                        if (correctanswer1 > correctanswer2) {
                            dialogEndWin!!.show()
                        } else if (correctanswer1 < correctanswer2) {
                            dialogEndWin2!!.show()
                        } else if (correctanswer1 == correctanswer2) {
                            dialogEndDraw!!.show()
                        }
                    }
                }, 500)
                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
            })
            //Метод показывающий правельный ответ - конец
        }
    }

    //Проигрываем музыку при запуске уровня - конец
    //Метод начисления балов - начало
    private fun accrualOfPoints() {
        if (onechek == true && twochek == false) {
            correctanswer1 += 1 //Увеличиваем правильный ответ первому игроку на 1
            score1!!.text = "Первый Игрок : $correctanswer1" //Меняем текст первому игроку
        } else if (onechek == false && twochek == true) {
            correctanswer2 += 1 //Увеличиваем правильный ответ второму игроку на 1
            score2!!.text = "Второй Игрок : $correctanswer2" //Меняем текст первому игроку
        } else if (onechek == true && twochek == true) {
            correctanswer1 += 1 //Увеличиваем правильный ответ первому игроку на 1
            correctanswer2 += 1 //Увеличиваем правильный ответ первому игроку на 1
            score1!!.text = "Первый Игрок : $correctanswer1" //Меняем текст первому игроку
            score2!!.text = "Второй Игрок : $correctanswer2" //Меняем текст первому игроку
        }
        saveResult()
    }

    //Метод начисления балов - конец
    //Метод сохранения результатов уровня - начало
    private fun saveResult() {
        mypref = getSharedPreferences(
            "RessultGame",
            MODE_PRIVATE
        ) //получили объект класса который позволяет работаь с данными
        val ed = mypref.edit() //получили объект Editor для редактирования данных
        ed.putInt("score1", correctanswer1) //ключ хранения и данные
        ed.putInt("score2", correctanswer2) //ключ хранения и данные
        ed.apply() //Выполняем apply для сохранения данных
    }

    //Метод сохранения результатов уровня - конец
    //Метод Загрузки результатов преведушего уровня - начало
    private fun loadResult() {
        mypref = getSharedPreferences("RessultGame", MODE_PRIVATE)
        correctanswer1 = mypref.getInt("score1", 0)
        correctanswer2 = mypref.getInt("score2", 0)
    }

    //Метод Загрузки результатов преведущего уровня - конец
    //Метод очистки результата - начало
    private fun cleanResult() {
        mypref = getSharedPreferences("RessultGame", MODE_PRIVATE)
        val ed = mypref.edit()
        ed.remove("score1")
        ed.remove("score2")
        ed.apply()
    }

    //Метод очистки результата - конец
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
            Yodo1Mas.getInstance().showInterstitialAd(this@MultiLevelFour5) // показать рекламу
            val intent = Intent(this@MultiLevelFour5, GameMenu::class.java)
            startActivity(intent)
            finish()
        } else {
            try {
                val intent = Intent(this@MultiLevelFour5, GameMenu::class.java)
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