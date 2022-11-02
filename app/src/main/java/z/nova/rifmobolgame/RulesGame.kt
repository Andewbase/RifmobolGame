package z.nova.rifmobolgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RulesGame : AppCompatActivity() {

    private lateinit var btnBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rules)

        btnBack = findViewById(R.id.button_back)
        btnBack.setOnClickListener {
                val intent = Intent(this@RulesGame, GameMenu::class.java)
                startActivity(intent)
                finish()
        }
    }

    //Системная кнопка "Назад" - начало
    override fun onBackPressed() {
            val intent =
                Intent(this@RulesGame, GameMenu::class.java) //Создали намерение для перехода
            startActivity(intent)
            finish()
    } //Системная кнопка "Назад" - конец
}