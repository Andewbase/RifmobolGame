package z.nova.rifmobolgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GameMenu : AppCompatActivity() {

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
}