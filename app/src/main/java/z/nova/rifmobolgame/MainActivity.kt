package z.nova.rifmobolgame

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yodo1.mas.Yodo1Mas
import com.yodo1.mas.error.Yodo1MasError
import java.util.*

import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    private var backPressedTime: Long = 0
    private lateinit var backToast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //you just have to use this code in MainActivity not others. Just once
        Yodo1Mas.getInstance().init(this, "sszpCIMxv0", object : Yodo1Mas.InitListener {
            override fun onMasInitSuccessful() {}
            override fun onMasInitFailed(error: Yodo1MasError) {
                //пусто
            }
        })


            val intent = Intent(this@MainActivity, GameMenu::class.java)
            Timer().schedule(5000) {
                startActivity(intent)
                finish()
            }
    }

    //Системная кнопка "Назад" - начало
    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel() //Закрывает Тост вместе с приложением
            super.onBackPressed()
            return
        } else {
            backToast =
                Toast.makeText(baseContext, "Нажмити ещё раз, что бы выйти", Toast.LENGTH_SHORT)
            backToast.show()
        }
        backPressedTime = System.currentTimeMillis()
    } //Системная кнопка "Назад" - конец
}