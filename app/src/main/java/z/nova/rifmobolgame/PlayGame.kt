package z.nova.rifmobolgame

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yodo1.mas.banner.Yodo1MasBannerAdListener
import com.yodo1.mas.banner.Yodo1MasBannerAdView
import com.yodo1.mas.error.Yodo1MasError
import z.nova.rifmobolgame.model.LevelAdapter
import z.nova.rifmobolgame.model.LevelAdapter.ListItemClickListener
import z.nova.rifmobolgame.model.TextLevel
import z.nova.rifmobolgame.singlplayer.*

class PlayGame : AppCompatActivity() {
    lateinit var bannerAdView: Yodo1MasBannerAdView
    var textLevels = ArrayList<TextLevel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_game)
        bannerAdView = findViewById(R.id.adView)
        bannerAdView.setAdListener(object : Yodo1MasBannerAdListener {
            override fun onBannerAdLoaded(bannerAdView: Yodo1MasBannerAdView) {
                // Code to be executed when an ad finishes loading.
            }

            override fun onBannerAdFailedToLoad(
                bannerAdView: Yodo1MasBannerAdView,
                error: Yodo1MasError
            ) {
                // Code to be executed when an ad request fails.
            }

            override fun onBannerAdOpened(bannerAdView: Yodo1MasBannerAdView) {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onBannerAdFailedToOpen(
                bannerAdView: Yodo1MasBannerAdView,
                error: Yodo1MasError
            ) {
                // Code to be executed when an ad open fails.
            }

            override fun onBannerAdClosed(bannerAdView: Yodo1MasBannerAdView) {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        })
        bannerAdView.loadAd()

        //Yodo1

        val button_back = findViewById<View>(R.id.button_back) as Button
        button_back.setOnClickListener {
            try {
                val intent = Intent(this@PlayGame, GameMenu::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {
                //Пусто
            }
        }
        setInitialData()
        val recyclerView = findViewById<RecyclerView>(R.id.list)
        val numberofColums = 5
        val levelClickListener = object : ListItemClickListener {
            override fun onListItemClick(clickItemIndex: Int) {
                val intent: Intent
                when (clickItemIndex) {
                    0 -> {
                        intent = Intent(this@PlayGame, Level1::class.java)
                        startActivity(intent)
                    }
                    1 -> {
                        intent = Intent(this@PlayGame, Level2::class.java)
                        startActivity(intent)
                    }
                    2 -> {
                        intent = Intent(this@PlayGame, Level3::class.java)
                        startActivity(intent)
                    }
                    3 -> {
                        intent = Intent(this@PlayGame, Level4::class.java)
                        startActivity(intent)
                    }
                    4 -> {
                        intent = Intent(this@PlayGame, Level5::class.java)
                        startActivity(intent)
                    }
                    5 -> {
                        intent = Intent(this@PlayGame, Level6::class.java)
                        startActivity(intent)
                    }
                    6 -> {
                        intent = Intent(this@PlayGame, Level7::class.java)
                        startActivity(intent)
                    }
                    7 -> {
                        intent = Intent(this@PlayGame, Level8::class.java)
                        startActivity(intent)
                    }
                    8 -> {
                        intent = Intent(this@PlayGame, Level9::class.java)
                        startActivity(intent)
                    }
                    9 -> {
                        intent = Intent(this@PlayGame, Level10::class.java)
                        startActivity(intent)
                    }
                    10 -> {
                        intent = Intent(this@PlayGame, Level11::class.java)
                        startActivity(intent)
                    }
                    11 -> {
                        intent = Intent(this@PlayGame, Level12::class.java)
                        startActivity(intent)
                    }
                    12 -> {
                        intent = Intent(this@PlayGame, Level13::class.java)
                        startActivity(intent)
                    }
                    13 -> {
                        intent = Intent(this@PlayGame, Level14::class.java)
                        startActivity(intent)
                    }
                    14 -> {
                        intent = Intent(this@PlayGame, Level15::class.java)
                        startActivity(intent)
                    }
                    15 -> {
                        intent = Intent(this@PlayGame, Level16::class.java)
                        startActivity(intent)
                    }
                    16 -> {
                        intent = Intent(this@PlayGame, Level17::class.java)
                        startActivity(intent)
                    }
                    17 -> {
                        intent = Intent(this@PlayGame, Level18::class.java)
                        startActivity(intent)
                    }
                    18 -> {
                        intent = Intent(this@PlayGame, Level19::class.java)
                        startActivity(intent)
                    }
                    19 -> {
                        intent = Intent(this@PlayGame, Level20::class.java)
                        startActivity(intent)
                    }
                    20 -> {
                        intent = Intent(this@PlayGame, Level21::class.java)
                        startActivity(intent)
                    }
                    21 -> {
                        intent = Intent(this@PlayGame, Level22::class.java)
                        startActivity(intent)
                    }
                    22 -> {
                        intent = Intent(this@PlayGame, Level23::class.java)
                        startActivity(intent)
                    }
                    23 -> {
                        intent = Intent(this@PlayGame, Level24::class.java)
                        startActivity(intent)
                    }
                    24 -> {
                        intent = Intent(this@PlayGame, Level25::class.java)
                        startActivity(intent)
                    }
                    25 -> {
                        intent = Intent(this@PlayGame, Level26::class.java)
                        startActivity(intent)
                    }
                    26 -> {
                        intent = Intent(this@PlayGame, Level27::class.java)
                        startActivity(intent)
                    }
                    27 -> {
                        intent = Intent(this@PlayGame, Level28::class.java)
                        startActivity(intent)
                    }
                    28 -> {
                        intent = Intent(this@PlayGame, Level29::class.java)
                        startActivity(intent)
                    }
                    29 -> {
                        intent = Intent(this@PlayGame, Level30::class.java)
                        startActivity(intent)
                    }
                    30 -> {
                        intent = Intent(this@PlayGame, Level31::class.java)
                        startActivity(intent)
                    }
                    31 -> {
                        intent = Intent(this@PlayGame, Level32::class.java)
                        startActivity(intent)
                    }
                    32 -> {
                        intent = Intent(this@PlayGame, Level33::class.java)
                        startActivity(intent)
                    }
                    33 -> {
                        intent = Intent(this@PlayGame, Level34::class.java)
                        startActivity(intent)
                    }
                    34 -> {
                        intent = Intent(this@PlayGame, Level35::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
        recyclerView.layoutManager = GridLayoutManager(this, numberofColums)
        val adapter = LevelAdapter(this, textLevels, levelClickListener)
        recyclerView.adapter = adapter
    }

    private fun setInitialData() {
        textLevels.add(TextLevel("1"))
        textLevels.add(TextLevel("2"))
        textLevels.add(TextLevel("3"))
        textLevels.add(TextLevel("4"))
        textLevels.add(TextLevel("5"))
        textLevels.add(TextLevel("6"))
        textLevels.add(TextLevel("7"))
        textLevels.add(TextLevel("8"))
        textLevels.add(TextLevel("9"))
        textLevels.add(TextLevel("10"))
        textLevels.add(TextLevel("11"))
        textLevels.add(TextLevel("12"))
        textLevels.add(TextLevel("13"))
        textLevels.add(TextLevel("14"))
        textLevels.add(TextLevel("15"))
        textLevels.add(TextLevel("16"))
        textLevels.add(TextLevel("17"))
        textLevels.add(TextLevel("18"))
        textLevels.add(TextLevel("19"))
        textLevels.add(TextLevel("20"))
        textLevels.add(TextLevel("21"))
        textLevels.add(TextLevel("22"))
        textLevels.add(TextLevel("23"))
        textLevels.add(TextLevel("24"))
        textLevels.add(TextLevel("25"))
        textLevels.add(TextLevel("26"))
        textLevels.add(TextLevel("27"))
        textLevels.add(TextLevel("28"))
        textLevels.add(TextLevel("29"))
        textLevels.add(TextLevel("30"))
        textLevels.add(TextLevel("31"))
        textLevels.add(TextLevel("32"))
        textLevels.add(TextLevel("33"))
        textLevels.add(TextLevel("34"))
        textLevels.add(TextLevel("35"))
    }

    //Системная кнопка "Назад" - начало
    override fun onBackPressed() {
        try {
            val intent = Intent(this@PlayGame, GameMenu::class.java)
            startActivity(intent)
            finish()
        } catch (e: Exception) {
            //Пусто
        }
    } //Системная кнопка "Назад" - конец
}