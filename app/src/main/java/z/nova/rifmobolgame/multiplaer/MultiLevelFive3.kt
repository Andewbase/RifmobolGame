package z.nova.rifmobolgame.multiplaer

import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yodo1.mas.Yodo1Mas
import z.nova.rifmobolgame.GameMenu
import z.nova.rifmobolgame.R

class MultiLevelFive3 : AppCompatActivity() {
    var mediaPlayer //Создаём Медиа плеер
            : MediaPlayer? = null
    var check = 0 //счётчики нажатия
   lateinit var mypref: SharedPreferences
    var correctanswer1 = 0 //Счёт первого игрока
    var correctanswer2 = 0 //Счёт второго игрока
    var onechek = false //проверка нажал ли первый игрок правильный ответ
    var twochek = false //проверка нажал ли второй игрок правильный ответ
   lateinit var score1: TextView
   lateinit var score2: TextView
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
        text_levels.setText(R.string.raund3) //Установили текст

        //Устанавливаем фон для уровня - начало
        val background = findViewById<View>(R.id.menu_background) as ImageView
        background.setImageResource(R.drawable.level3_background)
        //Устанавливаем фон для уровня - конец

        //Устанавливаем текст для уровня - начало
        val textlevel2 = findViewById<TextView>(R.id.couplet_text)
        textlevel2.setText(R.string.lvlcouplet23)
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
        p1btn_up_left.setText(R.string.lvl23textone)
        p1btn_up_right.setText(R.string.lvl23texttwo)
        p1btn_bottom_left.setText(R.string.lvl23textthree)
        p1btn_bottom_right.setText(R.string.lvl23textfour)
        p2btn_up_left.setText(R.string.lvl23textone)
        p2btn_up_right.setText(R.string.lvl23texttwo)
        p2btn_bottom_left.setText(R.string.lvl23textthree)
        p2btn_bottom_right.setText(R.string.lvl23textfour)
        //Меняем текст в кнопках - конец


        //Кнопка "Назад" - начало
        val btn_back = findViewById<View>(R.id.button_back) as Button
        btn_back.setOnClickListener {
            //Обрабатывем нажатие кнопки "Назад" - начало
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(this@MultiLevelFive3) //Показать рекламу
                val intent = Intent(
                    this@MultiLevelFive3,
                    GameMenu::class.java
                ) //Создали намерение для перехода
                startActivity(intent)
                finish()
            } else {
                try {
                    //Вернуться назад к выбору уровня - начало
                    val intent = Intent(
                        this@MultiLevelFive3,
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
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет -начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.mosquitoes2)
                        mediaPlayer?.start()
                        p1btn_up_left.isClickable =
                            false //Отключаем кнопку после нажатия, setEnable(false) красит в серый цвет кнопку
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent =
                            Intent(this@MultiLevelFive3, MultiLevelFive4::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
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
                onechek = true
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет - начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.mosquitoes2)
                        mediaPlayer?.start()
                        p1btn_up_right.isClickable = false //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent =
                            Intent(this@MultiLevelFive3, MultiLevelFive4::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
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
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.mosquitoes2)
                        mediaPlayer?.start()
                        p1btn_bottom_left.isClickable = false //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent =
                            Intent(this@MultiLevelFive3, MultiLevelFive4::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
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
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.mosquitoes2)
                        mediaPlayer?.start()
                        p1btn_bottom_right.isClickable = false //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent =
                            Intent(this@MultiLevelFive3, MultiLevelFive4::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
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
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет -начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.mosquitoes2)
                        mediaPlayer?.start()
                        p2btn_up_left.isClickable =
                            false //Отключаем кнопку после нажатия, setEnable(false) красит в серый цвет кнопку
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent =
                            Intent(this@MultiLevelFive3, MultiLevelFive4::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
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
                twochek = true
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет - начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.mosquitoes2)
                        mediaPlayer?.start()
                        p2btn_up_right.isClickable = false //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent =
                            Intent(this@MultiLevelFive3, MultiLevelFive4::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
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
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.mosquitoes2)
                        mediaPlayer?.start()
                        p2btn_bottom_left.isClickable = false //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent =
                            Intent(this@MultiLevelFive3, MultiLevelFive4::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
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
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.mosquitoes2)
                        mediaPlayer?.start()
                        p2btn_bottom_right.isClickable = false //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    p2btn_up_right.background =
                        resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent =
                            Intent(this@MultiLevelFive3, MultiLevelFive4::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
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
        val p1btn_up_right =
            findViewById<View>(R.id.p1btn_right_up) as Button //Создаём нижнюю левую кнопку
        val p2btn_up_right =
            findViewById<View>(R.id.p2btn_right_up) as Button //Создаём нижнюю левую кнопку (второй игрок)
        if (check <= 1) { //Если свернули игру до нажатия варианта ответа, либо когда нажал только один игрок
            mediaPlayer = MediaPlayer.create(applicationContext, R.raw.mosquitoes1)
            mediaPlayer?.start()
        } else if (check > 1) { //Иначе если свернули игру после нажатия вариантов ответа двумя игроками
            mediaPlayer = MediaPlayer.create(applicationContext, R.raw.mosquitoes2)
            mediaPlayer?.start()
            //Метод показывающий правельный ответ - начало
            mediaPlayer?.setOnCompletionListener(MediaPlayer.OnCompletionListener {
                p1btn_up_right.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                p2btn_up_right.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                accrualOfPoints()
                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                Handler().postDelayed({
                    if (check == 2) {
                        val intent =
                            Intent(this@MultiLevelFive3, MultiLevelFive4::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
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
            Yodo1Mas.getInstance().showInterstitialAd(this@MultiLevelFive3) // показать рекламу
            val intent =
                Intent(this@MultiLevelFive3, GameMenu::class.java) //Создали намерение для перехода
            startActivity(intent)
            finish()
        } else {
            try {
                val intent = Intent(this@MultiLevelFive3, GameMenu::class.java)
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