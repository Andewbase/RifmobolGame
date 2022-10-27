package z.nova.rifmobolgame

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import z.nova.rifmobolgame.multiplaer.*
import java.util.*

class MultiplayerGame : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_menu)

        val generator = Random()
        val number = generator.nextInt(7) + 1
        // The '5' is the number of activities
        var activity: Class<*>? = null
        activity = when (number) {
            1 ->                 // E.g., if the output is 1, the activity we will open is ActivityOne.class
                MultiLevel1::class.java
            2 -> MultiLevelTwo1::class.java
            3 -> MultiLevelThree1::class.java
            4 -> MultiLevelFour1::class.java
            5 -> MultiLevelFive1::class.java
            6 -> MultiLevelSix1::class.java
            else -> MultiLevelSeven1::class.java
        }
        // We use intents to start activities
        val intent = Intent(baseContext, activity)
        startActivity(intent)
        finish()
    }
}