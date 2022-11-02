package z.nova.rifmobolgame.multiplaer

import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.yodo1.mas.Yodo1Mas
import z.nova.rifmobolgame.GameMenu
import z.nova.rifmobolgame.R

class MultiLevel1 : AppCompatActivity() {
    var mediaPlayer //Создаём Медиа плеер
            : MediaPlayer? = null
    var check = 0 //счётчики нажатия
   lateinit var mypref: SharedPreferences
    var correctanswer1 = 0 //Счёт первого игрока
    var correctanswer2 = 0 //Счёт второго игрока
    var onechek = false //проверка нажал ли первый игрок правильный ответ
    var twochek = false //проверка нажал ли второй игрок правильный ответ
   lateinit var score1 //Создаём переменую с отображением счёта для первого игрока
            : TextView
   lateinit var score2 //Создаём переменую с отображением счёта для второго игрока
            : TextView
   lateinit var p1btn_up_left: Button
    lateinit var p1btn_up_right: Button
    lateinit var p1btn_bottom_right: Button
    lateinit var p1btn_bottom_left: Button
    lateinit var p2btn_up_left: Button
    lateinit var p2btn_up_right: Button
    lateinit var p2btn_bottom_right: Button
    lateinit var p2btn_bottom_left: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.universalmulti)
        score1 =
            findViewById(R.id.scoree1) //Создаём переменую с отображением счёта для первого игрока
        score1.setText("Первый Игрок : $correctanswer1") //Устанавливаем текст
        score2 =
            findViewById(R.id.scoree2) //Создаём переменую с отображением счёта для второго игрока
        score2.setText("Второй Игрок : $correctanswer2") //Устанавливаем текст

        //Создаём переменную text_levels
        val text_levels = findViewById<TextView>(R.id.text_levels)
        text_levels.setText(R.string.raund1) //Установили текст
        p1btn_up_left =
            findViewById(R.id.p1btn_left_up) //Создаём левую верхнюю кнопку (первый игрок)
        p1btn_up_right =
            findViewById(R.id.p1btn_right_up) //Создаём правую верхнюю кнопку (первый игрок)
        p1btn_bottom_right =
            findViewById(R.id.p1btn_right_bottom) //Создаём нижнюю правоую кнопку (первый игрок)
        p1btn_bottom_left =
            findViewById(R.id.p1btn_left_bottom) //Создаём нижнюю левую кнопку (первый игрок)
        p2btn_up_left =
            findViewById(R.id.p2btn_left_up) //Создаём левую верхнюю кнопку (второй игрок)
        p2btn_up_right =
            findViewById(R.id.p2btn_right_up) //Создаём правую верхнюю кнопку (второй игрок)
        p2btn_bottom_right =
            findViewById(R.id.p2btn_right_bottom) //Создаём нижнюю правоую кнопку (второй игрок)
        p2btn_bottom_left =
            findViewById(R.id.p2btn_left_bottom) //Создаём нижнюю левую кнопку (второй игрок)


        //Кнопка "Назад" - начало
        val btn_back = findViewById<View>(R.id.button_back) as Button
        btn_back.setOnClickListener {
            //Обрабатывем нажатие кнопки "Назад" - начало
            if (Yodo1Mas.getInstance().isInterstitialAdLoaded) { //TODO
                Yodo1Mas.getInstance().showInterstitialAd(this@MultiLevel1) //Показать рекламу
                val intent =
                    Intent(this@MultiLevel1, GameMenu::class.java) //Создали намерение для перехода
                startActivity(intent)
            } else {
                try {
                    //Вернуться назад к выбору уровня - начало
                    val intent = Intent(
                        this@MultiLevel1,
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
        p1btn_up_left.setOnClickListener(View.OnClickListener {
            try {
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет -начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.watchman2)
                        mediaPlayer?.start()
                        p1btn_up_left.setClickable(false) //Отключаем кнопку после нажатия, setEnable(false) красит в серый цвет кнопку
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    p2btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent = Intent(this@MultiLevel1, MultiLevel2::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                }
                //Метод показывающий правельный ответ - конец
                p1btn_up_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whiteblue)
                p1btn_up_right.setClickable(false) //Блокируем правую верхнюю
                p1btn_bottom_left.setClickable(false) //Блокируем нижнюю левую
                p1btn_bottom_right.setClickable(false) //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        })
        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - конец (первый игрок)

        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - начало (первый игрок)
        p1btn_up_right.setOnClickListener(View.OnClickListener {
            try {
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет - начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.watchman2)
                        mediaPlayer?.start()
                        p1btn_up_right.setClickable(false) //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    p2btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent = Intent(this@MultiLevel1, MultiLevel2::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                p1btn_up_right.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whiteblue)
                p1btn_up_left.setClickable(false) //Блокируем правую верхнюю
                p1btn_bottom_left.setClickable(false) //Блокируем нижнюю левую
                p1btn_bottom_right.setClickable(false) //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        })
        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - конец (первый игрок)

        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - начало (первый игрок)
        p1btn_bottom_left.setOnClickListener(View.OnClickListener {
            try {
                onechek = true
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет -начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.watchman2)
                        mediaPlayer?.start()
                        p1btn_bottom_left.setClickable(false) //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    p2btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent = Intent(this@MultiLevel1, MultiLevel2::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                p1btn_bottom_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whiteblue)
                p1btn_up_left.setClickable(false) //Блокируем правую верхнюю
                p1btn_up_right.setClickable(false) //Блокируем нижнюю левую
                p1btn_bottom_right.setClickable(false) //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        })
        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - конец (первый игрок)

        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - начало
        p1btn_bottom_right.setOnClickListener(View.OnClickListener {
            try {
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет - начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.watchman2)
                        mediaPlayer?.start()
                        p1btn_bottom_right.setClickable(false) //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    p2btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent = Intent(this@MultiLevel1, MultiLevel2::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                p1btn_bottom_right.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whiteblue)
                p1btn_up_left.setClickable(false) //Блокируем правую верхнюю
                p1btn_up_right.setClickable(false) //Блокируем нижнюю левую
                p1btn_bottom_left.setClickable(false) //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        })
        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - конец (первый игрок)

        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - начало (второй игрок)
        p2btn_up_left.setOnClickListener(View.OnClickListener {
            try {
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет -начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.watchman2)
                        mediaPlayer?.start()
                        p2btn_up_left.setClickable(false) //Отключаем кнопку после нажатия, setEnable(false) красит в серый цвет кнопку
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    p2btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent = Intent(this@MultiLevel1, MultiLevel2::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                }
                //Метод показывающий правельный ответ - конец
                p2btn_up_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitered)
                p2btn_up_right.setClickable(false) //Блокируем правую верхнюю
                p2btn_bottom_left.setClickable(false) //Блокируем нижнюю левую
                p2btn_bottom_right.setClickable(false) //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        })
        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - конец (второй игрок)

        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - начало (второй игрок)
        p2btn_up_right.setOnClickListener(View.OnClickListener {
            try {
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет - начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.watchman2)
                        mediaPlayer?.start()
                        p2btn_up_right.setClickable(false) //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    p2btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent = Intent(this@MultiLevel1, MultiLevel2::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                p2btn_up_right.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitered)
                p2btn_up_left.setClickable(false) //Блокируем правую верхнюю
                p2btn_bottom_left.setClickable(false) //Блокируем нижнюю левую
                p2btn_bottom_right.setClickable(false) //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        })
        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - конец (второй игрок)

        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - начало (второй игрок)
        p2btn_bottom_left.setOnClickListener(View.OnClickListener {
            try {
                twochek = true
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет -начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.watchman2)
                        mediaPlayer?.start()
                        p2btn_bottom_left.setClickable(false) //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    p2btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent = Intent(this@MultiLevel1, MultiLevel2::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                p2btn_bottom_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitered)
                p2btn_up_left.setClickable(false) //Блокируем правую верхнюю
                p2btn_up_right.setClickable(false) //Блокируем нижнюю левую
                p2btn_bottom_right.setClickable(false) //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        })
        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - конец (второй игрок)

        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - начало (второй игрок)
        p2btn_bottom_right.setOnClickListener(View.OnClickListener {
            try {
                check++ // Общий счётчик нажатия
                if (check == 2) { //Если нажали два раза
                    //Вопроизводим полный куплет - начало
                    if (mediaPlayer != null) {
                        releaseMP()
                        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.watchman2)
                        mediaPlayer?.start()
                        p2btn_bottom_right.setClickable(false) //Отключаем кнопку после нажатия
                    }
                }
                //Вопроизводим полный куплет - конец

                //Метод показывающий правельный ответ - начало
                mediaPlayer!!.setOnCompletionListener {
                    p1btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    p2btn_bottom_left.setBackground(resources.getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen))
                    accrualOfPoints()
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    Handler().postDelayed({
                        val intent = Intent(this@MultiLevel1, MultiLevel2::class.java) //ИЗМЕНИТЬ
                        startActivity(intent)
                        finish()
                    }, 500)
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
                //Метод показывающий правельный ответ - конец
                p2btn_bottom_right.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitered)
                p2btn_up_left.setClickable(false) //Блокируем правую верхнюю
                p2btn_up_right.setClickable(false) //Блокируем нижнюю левую
                p2btn_bottom_left.setClickable(false) //Блокируем нижнюю правую
            } catch (e: Exception) {
                //Пусто
            }
        })
        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - конец (второй игрок)
    }

    //Проигрываем музыку при запуске уровня - начало
    override fun onResume() {
        super.onResume()
        //Создаём переменую с отображением счёта для первого игрока
        score1 = findViewById(R.id.scoree1)

        //Создаём переменую с отображением счёта для второго игрока
        score2 = findViewById(R.id.scoree2)
        p1btn_bottom_left = findViewById(R.id.p1btn_left_bottom) //Создаём нижнюю левую кнопку
        p2btn_bottom_left =
            findViewById(R.id.p2btn_left_bottom) //Создаём нижнюю левую кнопку (второй игрок)
        if (check <= 1) { //Если свернули игру до нажатия варианта ответа, либо когда нажал только один игрок
            mediaPlayer = MediaPlayer.create(applicationContext, R.raw.watchman1)
            mediaPlayer?.start()
        } else if (check > 1) { //Иначе если свернули игру после нажатия вариантов ответа двумя игроками
            mediaPlayer = MediaPlayer.create(applicationContext, R.raw.watchman2)
            mediaPlayer?.start()
            //Метод показывающий правельный ответ - начало
            mediaPlayer?.setOnCompletionListener(MediaPlayer.OnCompletionListener {
                p1btn_bottom_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                p2btn_bottom_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitgreen)
                accrualOfPoints()
                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                Handler().postDelayed({
                    if (check == 2) {
                        val intent = Intent(this@MultiLevel1, MultiLevel2::class.java) //ИЗМЕНИТЬ
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
            Yodo1Mas.getInstance().showInterstitialAd(this@MultiLevel1) // показать рекламу
            val intent =
                Intent(this@MultiLevel1, GameMenu::class.java) //Создали намерение для перехода
            startActivity(intent)
        } else {
            try {
                val intent = Intent(this@MultiLevel1, GameMenu::class.java)
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