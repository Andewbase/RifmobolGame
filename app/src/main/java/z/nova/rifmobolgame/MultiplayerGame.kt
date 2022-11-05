package z.nova.rifmobolgame

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import z.nova.rifmobolgame.multiplaer.*
import java.util.*

class MultiplayerGame : AppCompatActivity() {

   private val generator = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_menu)

        val activity: Class<*> = when (generator.nextInt(7) + 1) {
            1 -> MultiLevel1::class.java
            2 -> MultiLevelTwo1::class.java
            3 -> MultiLevelThree1::class.java
            4 -> MultiLevelFour1::class.java
            5 -> MultiLevelFive1::class.java
            6 -> MultiLevelSix1::class.java
            else -> MultiLevelSeven1::class.java
        }

        //val activity: Class<*> = MultiLevel1::class.java //TODO finish Refactoring -> DELETE

        // We use intents to start activities
        val intent = Intent(baseContext, activity)
        startActivity(intent)
        finish()
    }
}