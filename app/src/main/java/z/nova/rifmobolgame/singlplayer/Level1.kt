package z.nova.rifmobolgame.singlplayer

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import z.nova.rifmobolgame.R
import z.nova.rifmobolgame.model.roundfactory.RoundFactory

class Level1 : AppCompatActivity() {

    private val roundFactory = RoundFactory(1,this@Level1)

    private lateinit var btn_bottom_right: Button
    private lateinit var btn_up_left: Button
    private lateinit var btn_up_right: Button
    private lateinit var btn_bottom_left: Button
    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.universal)

        btn_bottom_right = findViewById(R.id.btn_right_bottom) //Создаём нижнюю правую кнопку
        btn_up_left = findViewById(R.id.btn_left_up) //Создаём левую верхнюю кнопку
        btn_up_right = findViewById(R.id.btn_right_up) //Создаём правую верхнюю кнопку
        btn_bottom_left = findViewById(R.id.btn_left_bottom) //Создаём нижнюю правоую кнопку

        //Кнопка "Назад" - начало
        btnBack = findViewById(R.id.button_back)

        //Вызов диалогового окна Выйграл "В Конце" - начало
        roundFactory.dialogWinCreate(this@Level1, Level2::class.java)
        //Вызов диалогового окна Выйграл "В Конце" - конец

        //Вызов диалогового окна Проиграл "В Конце" - начало
        roundFactory.dialogLoseCreate(this@Level1, Level1::class.java, Level2::class.java)
        //Вызов диалогового окна Проиграл "В Конце" - конец

        //Кнопка "Назад" - начало
        btnBack.setOnClickListener {roundFactory.clickBackButton(this@Level1)}
        //Кнопка "Назад" - конец

        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - начало
        btn_up_left.setOnClickListener {
            roundFactory.clickButtonRoundLose(1,btn_up_left, btn_bottom_left)
            roundFactory.setButtonBackgroundCLick(btn_up_left, btn_up_right, btn_bottom_left, btn_bottom_right)
        }
        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - конец

        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - начало
        btn_up_right.setOnClickListener {
            roundFactory.clickButtonRoundLose(2, btn_up_right, btn_bottom_left)
            //Метод показывающий правельный ответ - конец
            roundFactory.setButtonBackgroundCLick(btn_up_right, btn_up_left, btn_bottom_left, btn_bottom_right)
        }
        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - конец

        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - начало //TODO Win Button
        btn_bottom_left.setOnClickListener {
            roundFactory.clickButtonRoundWin(3, btn_bottom_left)
            //Метод показывающий правельный ответ - конец
            roundFactory.setButtonBackgroundCLick(btn_bottom_left, btn_up_left, btn_up_right, btn_bottom_right)
        }
        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - конец

        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - начало
        btn_bottom_right.setOnClickListener {
            roundFactory.clickButtonRoundWin(4, btn_bottom_left)
            //Метод показывающий правельный ответ - конец
            roundFactory.setButtonBackgroundCLick(btn_bottom_right, btn_up_left, btn_up_right, btn_bottom_left) // Меняем фон кнопки при нажатие
        }
        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - конец
    }

    //Проигрываем музыку при запуске уровня - начало
    override fun onResume() {
        super.onResume()
        roundFactory.mediaStart(btn_bottom_left)
    }
    //Проигрываем музыку при запуске уровня - конец

    //Системная кнопка "Назад" - начало
    override fun onBackPressed() { roundFactory.clickBackButton(this@Level1) }
    //Системная кнопка "Назад" - конец

    //Останавливает проигрыватель при паузе активити - начало
    override fun onPause() {
        super.onPause()
        roundFactory.releaseMP()
    }
    //Останавливает проигрыватель при паузе активити - конец


    //Освобождаем ресурсы проигрывателя при уничтожение активити - начало
    override fun onDestroy() {
        super.onDestroy()
        roundFactory.releaseMP()
    } //Освобождаем ресурсы проигрывателя при уничтожение активити - конец
}