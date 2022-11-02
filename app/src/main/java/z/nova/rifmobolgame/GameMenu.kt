package z.nova.rifmobolgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import z.nova.rifmobolgame.model.const.TEXT_BACK

class GameMenu : AppCompatActivity() {

    private var backPressedTime: Long = 0
    private lateinit var backToast: Toast

    private lateinit var buttonPlay: Button
    private lateinit var buttonMultiplayer: Button
    private lateinit var buttonRules: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_menu)


        //кнопка "Играть" - начало
        buttonPlay = findViewById(R.id.btnPlay)
        buttonPlay.setOnClickListener {
                //Смена активити
                val intent = Intent(this@GameMenu, PlayGame::class.java)
                startActivity(intent)
                finish()
        }
        //кнопка "Играть" - конец

        //Кнопка "Вдвоём" - начало
        buttonMultiplayer = findViewById(R.id.btnMultiplayer)
        buttonMultiplayer.setOnClickListener {
                val intent = Intent(this@GameMenu, MultiplayerGame::class.java)
                startActivity(intent)
                finish()
        }
        //Кнопка "Вдвоём" - конец

        //Кнопка "Правила" - начало
        buttonRules = findViewById(R.id.btnRules)
        buttonRules.setOnClickListener {
                val intent = Intent(this@GameMenu, RulesGame::class.java)
                startActivity(intent)
                finish()
        }
        //Кнопка "Правила" - конец
    }

    //Системная кнопка "Назад" - начало
    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel() //Закрывает Тост вместе с приложением
            super.onBackPressed()
            return
        } else {
            backToast =
                Toast.makeText(baseContext, TEXT_BACK, Toast.LENGTH_SHORT)
            backToast.show()
        }
        backPressedTime = System.currentTimeMillis()
    } //Системная кнопка "Назад" - конец
}