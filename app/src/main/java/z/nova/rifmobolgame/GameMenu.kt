package z.nova.rifmobolgame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GameMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_menu)


        //кнопка "Играть" - начало
        val buttonPlay = findViewById<View>(R.id.btnPlay) as Button
        buttonPlay.setOnClickListener {
            try {
                //Смена активити
                val intent = Intent(this@GameMenu, PlayGame::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                //Пусто
            }
        }
        //кнопка "Играть" - конец

        //Кнопка "Вдвоём" - начало
        val buttonMultiplayer = findViewById<View>(R.id.btnMultiplayer) as Button
        buttonMultiplayer.setOnClickListener {
            try {
                val intent = Intent(this@GameMenu, MultiplayerGame::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                //Пусто
            }
        }
        //Кнопка "Вдвоём" - конец


        //Кнопка "Правила" - начало
        val buttonRules = findViewById<View>(R.id.btnRules) as Button
        buttonRules.setOnClickListener {
            try {
                val intent = Intent(this@GameMenu, RulesGame::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                //Пусто
            }
        }
        //Кнопка "Правила" - конец

    }
}