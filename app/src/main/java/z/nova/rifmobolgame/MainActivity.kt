package z.nova.rifmobolgame

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yodo1.mas.Yodo1Mas
import com.yodo1.mas.error.Yodo1MasError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import z.nova.rifmobolgame.model.const.TEXT_BACK

private const val YODO1MAS_KEY = "sszpCIMxv0"

class MainActivity : AppCompatActivity() {

    private var backPressedTime: Long = 0
    private lateinit var backToast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //you just have to use this code in MainActivity not others. Just once
        Yodo1Mas.getInstance().init(this@MainActivity, YODO1MAS_KEY, object : Yodo1Mas.InitListener {
            override fun onMasInitSuccessful() {}
            override fun onMasInitFailed(error: Yodo1MasError) {}
        })

        val intent = Intent(this@MainActivity, GameMenu::class.java)
        GlobalScope.launch(Dispatchers.Main){
            delay(5000)
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
                Toast.makeText(baseContext, TEXT_BACK, Toast.LENGTH_SHORT)
            backToast.show()
        }
        backPressedTime = System.currentTimeMillis()
    } //Системная кнопка "Назад" - конец
}