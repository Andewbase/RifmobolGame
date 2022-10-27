package z.nova.rifmobolgame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RulesGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rules)


        val button_back = findViewById<View>(R.id.button_back) as Button
        button_back.setOnClickListener {
            try {
                val intent = Intent(this@RulesGame, GameMenu::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                //Пусто
            }
        }
    }

    //Системная кнопка "Назад" - начало
    override fun onBackPressed() {
        try {
            val intent =
                Intent(this@RulesGame, GameMenu::class.java) //Создали намерение для перехода
            startActivity(intent)
            finish()
        } catch (e: Exception) {
        }
    } //Системная кнопка "Назад" - конец
}