package z.nova.rifmobolgame.multiplaer

import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import z.nova.rifmobolgame.R
import z.nova.rifmobolgame.model.roundfactory.MultiRoundFactory

class MultiLevelTwo5 : AppCompatActivity() {

    private val multiLevelRoundFactory = MultiRoundFactory(10, this@MultiLevelTwo5)

    private lateinit var score1: TextView //Создаём переменую с отображением счёта для первого игрока
    private lateinit var score2: TextView //Создаём переменую с отображением счёта для второго игрока

    private lateinit var text_levels: TextView
    private lateinit var background: ImageView
    private lateinit var textLevlCouplet: TextView

    private lateinit var p1btn_up_left: Button
    private lateinit var p1btn_up_right: Button
    private lateinit var p1btn_bottom_right: Button
    private lateinit var p1btn_bottom_left: Button
    private lateinit var p2btn_up_left: Button
    private lateinit var p2btn_up_right: Button
    private lateinit var p2btn_bottom_right: Button
    private lateinit var p2btn_bottom_left: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.universalmulti)

        multiLevelRoundFactory.loadResult()

        score1 = findViewById(R.id.scoree1) //Создаём переменую с отображением счёта для первого игрока
        score2 = findViewById(R.id.scoree2) //Создаём переменую с отображением счёта для второго игрока

        text_levels = findViewById(R.id.text_levels) //Создаём переменную text_levels
        background = findViewById(R.id.menu_background) //Устанавливаем фон для уровня
        textLevlCouplet = findViewById(R.id.couplet_text)  //Устанавливаем текст для уровня

        p1btn_up_left = findViewById(R.id.p1btn_left_up)//Создаём левую верхнюю кнопку (первый игрок)
        p1btn_up_right = findViewById(R.id.p1btn_right_up)//Создаём правую верхнюю кнопку (первый игрок)
        p1btn_bottom_right = findViewById(R.id.p1btn_right_bottom)//Создаём нижнюю правоую кнопку (первый игрок)
        p1btn_bottom_left = findViewById(R.id.p1btn_left_bottom)//Создаём нижнюю левую кнопку (первый игрок)

        p2btn_up_left = findViewById(R.id.p2btn_left_up)//Создаём левую верхнюю кнопку (второй игрок)
        p2btn_up_right = findViewById(R.id.p2btn_right_up)//Создаём правую верхнюю кнопку (второй игрок)
        p2btn_bottom_right = findViewById(R.id.p2btn_right_bottom)//Создаём нижнюю правоую кнопку (второй игрок)
        p2btn_bottom_left = findViewById(R.id.p2btn_left_bottom)//Создаём нижнюю левую кнопку (второй игрок)

        btnBack = findViewById(R.id.button_back)

        //Меняем размер текста в кнопках - начало
        p1btn_up_left.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        p1btn_up_right.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        p1btn_bottom_left.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        p1btn_bottom_right.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
        p2btn_up_left.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        p2btn_up_right.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        p2btn_bottom_left.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12f)
        p2btn_bottom_right.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10f)
        //Меняем размер текста в кнопках конец

        multiLevelRoundFactory.setScoreText(score1, score2)
        multiLevelRoundFactory.setUIMultiRound(text_levels, textLevlCouplet, background)
        multiLevelRoundFactory.setUIBtnTextMultiRoundP1(p1btn_up_left, p1btn_up_right, p1btn_bottom_left, p1btn_bottom_right)
        multiLevelRoundFactory.setUIBtnTextMultiRoundP2(p2btn_up_left, p2btn_up_right, p2btn_bottom_left, p2btn_bottom_right)

        multiLevelRoundFactory.dialogEndWinP1Create(this@MultiLevelTwo5)
        multiLevelRoundFactory.dialogEndWinP2Create(this@MultiLevelTwo5)
        multiLevelRoundFactory.dialogEndDrawreate(this@MultiLevelTwo5)

        //Кнопка "Назад" - начало
        btnBack.setOnClickListener {multiLevelRoundFactory.clickBackButtonMulti(this@MultiLevelTwo5)}
        //Кнопка "Назад" - конец

        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - начало (первый игрок)
        p1btn_up_left.setOnClickListener {
            multiLevelRoundFactory.clickButtonPlayerLoseFinalRound(p1btn_up_left, p1btn_bottom_right, p2btn_bottom_right, score1, score2)
            //Метод показывающий правельный ответ - конец
            multiLevelRoundFactory.setButtonBackgroundCLickPlayer1(p1btn_up_left, p1btn_up_right, p1btn_bottom_right, p1btn_bottom_left)
        }
        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - конец (первый игрок)

        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - начало (первый игрок)
        p1btn_up_right.setOnClickListener {
            multiLevelRoundFactory.clickButtonPlayerLoseFinalRound(p1btn_up_right, p1btn_bottom_right, p2btn_bottom_right, score1, score2)
            //Метод показывающий правельный ответ - конец
            multiLevelRoundFactory.setButtonBackgroundCLickPlayer1(p1btn_up_right, p1btn_up_left, p1btn_bottom_right, p1btn_bottom_left)
        }
        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - конец (первый игрок)

        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - начало (первый игрок)
        p1btn_bottom_left.setOnClickListener {
            multiLevelRoundFactory.clickButtonPlayerLoseFinalRound(p1btn_bottom_left, p1btn_bottom_right, p2btn_bottom_right, score1, score2)
            //Метод показывающий правельный ответ - конец
            multiLevelRoundFactory.setButtonBackgroundCLickPlayer1(p1btn_bottom_left, p1btn_up_left, p1btn_up_right, p1btn_bottom_right)
        }
        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - конец (первый игрок)

        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - начало
        p1btn_bottom_right.setOnClickListener {
            multiLevelRoundFactory.clickButtonPlayer1WinFinalRound(p1btn_bottom_right, p2btn_bottom_right, score1, score2)
            //Метод показывающий правельный ответ - конец
            multiLevelRoundFactory.setButtonBackgroundCLickPlayer1(p1btn_bottom_right, p1btn_up_left, p1btn_up_right, p1btn_bottom_left)
        }
        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - конец (первый игрок)

        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - начало (второй игрок)
        p2btn_up_left.setOnClickListener {
            multiLevelRoundFactory.clickButtonPlayerLoseFinalRound(p2btn_up_left, p1btn_bottom_right, p2btn_bottom_right, score1, score2)
            //Метод показывающий правельный ответ - конец
            multiLevelRoundFactory.setButtonBackgroundCLickPlayer2(p2btn_up_left, p2btn_up_right, p2btn_bottom_left, p2btn_bottom_right)
        }
        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - конец (второй игрок)

        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - начало (второй игрок)
        p2btn_up_right.setOnClickListener {
            multiLevelRoundFactory.clickButtonPlayerLoseFinalRound(p2btn_up_right, p1btn_bottom_right, p2btn_bottom_right, score1, score2)
            //Метод показывающий правельный ответ - конец
            multiLevelRoundFactory.setButtonBackgroundCLickPlayer2(p2btn_up_right, p2btn_up_left, p2btn_bottom_right, p2btn_bottom_left)
        }
        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - конец (второй игрок)

        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - начало (второй игрок)
        p2btn_bottom_left.setOnClickListener {
            multiLevelRoundFactory.clickButtonPlayerLoseFinalRound(p2btn_bottom_left, p1btn_bottom_right, p2btn_bottom_right, score1, score2)
            //Метод показывающий правельный ответ - конец
            multiLevelRoundFactory.setButtonBackgroundCLickPlayer2(p2btn_bottom_left, p2btn_up_right, p2btn_up_left, p2btn_bottom_right)
        }
        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - конец (второй игрок)

        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - начало (второй игрок)
        p2btn_bottom_right.setOnClickListener {
            multiLevelRoundFactory.clickButtonPlayer2WinFinalRound(p2btn_bottom_right, p1btn_bottom_right, score1, score2)
            //Метод показывающий правельный ответ - конец
            multiLevelRoundFactory.setButtonBackgroundCLickPlayer2(p2btn_bottom_right, p2btn_up_right, p2btn_up_left, p2btn_bottom_left)
        }
        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - конец (второй игрок)
    }

    //Проигрываем музыку при запуске уровня - начало
    override fun onResume() {
        super.onResume()
        multiLevelRoundFactory.mediaStrartMulitFinalRound(p1btn_bottom_right, p2btn_bottom_right, score1, score2)
    }
    //Проигрываем музыку при запуске уровня - конец

    //Системная кнопка "Назад" - начало
    override fun onBackPressed() {multiLevelRoundFactory.clickBackButtonMulti(this@MultiLevelTwo5)}
    //Системная кнопка "Назад" - конец

    //Останавливает проигрыватель при паузе активити - начало
    override fun onPause() {
        super.onPause()
        multiLevelRoundFactory.releaseMPMulti()
    }
    //Останавливает проигрыватель при паузе активити - конец

    //Освобождаем ресурсы проигрывателя при уничтожение активити - начало
    override fun onDestroy() {
        super.onDestroy()
        multiLevelRoundFactory.releaseMPMulti()
    } //Освобождаем ресурсы проигрывателя при уничтожение активити - конец
}