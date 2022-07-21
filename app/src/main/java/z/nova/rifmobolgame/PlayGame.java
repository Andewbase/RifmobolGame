package z.nova.rifmobolgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yodo1.mas.banner.Yodo1MasBannerAdListener;
import com.yodo1.mas.banner.Yodo1MasBannerAdView;
import com.yodo1.mas.error.Yodo1MasError;

import java.util.ArrayList;

import z.nova.rifmobolgame.Model.LevelAdapter;
import z.nova.rifmobolgame.Model.TextLevel;
import z.nova.rifmobolgame.singlplayer.Level1;
import z.nova.rifmobolgame.singlplayer.Level10;
import z.nova.rifmobolgame.singlplayer.Level11;
import z.nova.rifmobolgame.singlplayer.Level12;
import z.nova.rifmobolgame.singlplayer.Level13;
import z.nova.rifmobolgame.singlplayer.Level14;
import z.nova.rifmobolgame.singlplayer.Level15;
import z.nova.rifmobolgame.singlplayer.Level16;
import z.nova.rifmobolgame.singlplayer.Level17;
import z.nova.rifmobolgame.singlplayer.Level18;
import z.nova.rifmobolgame.singlplayer.Level19;
import z.nova.rifmobolgame.singlplayer.Level2;
import z.nova.rifmobolgame.singlplayer.Level20;
import z.nova.rifmobolgame.singlplayer.Level21;
import z.nova.rifmobolgame.singlplayer.Level22;
import z.nova.rifmobolgame.singlplayer.Level23;
import z.nova.rifmobolgame.singlplayer.Level24;
import z.nova.rifmobolgame.singlplayer.Level25;
import z.nova.rifmobolgame.singlplayer.Level26;
import z.nova.rifmobolgame.singlplayer.Level27;
import z.nova.rifmobolgame.singlplayer.Level28;
import z.nova.rifmobolgame.singlplayer.Level29;
import z.nova.rifmobolgame.singlplayer.Level3;
import z.nova.rifmobolgame.singlplayer.Level30;
import z.nova.rifmobolgame.singlplayer.Level31;
import z.nova.rifmobolgame.singlplayer.Level32;
import z.nova.rifmobolgame.singlplayer.Level33;
import z.nova.rifmobolgame.singlplayer.Level34;
import z.nova.rifmobolgame.singlplayer.Level35;
import z.nova.rifmobolgame.singlplayer.Level4;
import z.nova.rifmobolgame.singlplayer.Level5;
import z.nova.rifmobolgame.singlplayer.Level6;
import z.nova.rifmobolgame.singlplayer.Level7;
import z.nova.rifmobolgame.singlplayer.Level8;
import z.nova.rifmobolgame.singlplayer.Level9;

public class PlayGame extends AppCompatActivity {

    Yodo1MasBannerAdView bannerAdView;
    ArrayList<TextLevel> textLevels = new ArrayList<TextLevel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);

        bannerAdView = findViewById(R.id.adView);
        bannerAdView.setAdListener(new Yodo1MasBannerAdListener() {
            @Override
            public void onBannerAdLoaded(Yodo1MasBannerAdView bannerAdView) {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onBannerAdFailedToLoad(Yodo1MasBannerAdView bannerAdView, @NonNull Yodo1MasError error) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onBannerAdOpened(Yodo1MasBannerAdView bannerAdView) {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onBannerAdFailedToOpen(Yodo1MasBannerAdView bannerAdView, @NonNull Yodo1MasError error) {
                // Code to be executed when an ad open fails.
            }

            @Override
            public void onBannerAdClosed(Yodo1MasBannerAdView bannerAdView) {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });
        bannerAdView.loadAd();

        //Yodo1

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(PlayGame.this, GameMenu.class);
                    startActivity(intent); finish();
                }catch (Exception e){
                //Пусто
                }
            }
        });

        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        int numberofColums = 5;

        LevelAdapter.ListItemClickListener levelClickListener  = new LevelAdapter.ListItemClickListener() {
            @Override
            public void onListItemClick(int clickItemIndex) {
                Intent intent;
                switch (clickItemIndex){
                    case 0:
                        intent = new Intent(PlayGame.this, Level1.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(PlayGame.this, Level2.class);
                        startActivity(intent);
                        break;
                    case 2:
                    intent = new Intent(PlayGame.this, Level3.class);
                    startActivity(intent);
                    break;
                    case 3:
                        intent = new Intent(PlayGame.this, Level4.class);
                        startActivity(intent);
                        break;
                    case 4:
                    intent = new Intent(PlayGame.this, Level5.class);
                    startActivity(intent);
                    break;
                    case 5:
                        intent = new Intent(PlayGame.this, Level6.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(PlayGame.this, Level7.class);
                        startActivity(intent);
                        break;
                    case 7:
                        intent = new Intent(PlayGame.this, Level8.class);
                        startActivity(intent);
                        break;
                    case 8:
                        intent = new Intent(PlayGame.this, Level9.class);
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(PlayGame.this, Level10.class);
                        startActivity(intent);
                        break;
                    case 10:
                        intent = new Intent(PlayGame.this, Level11.class);
                        startActivity(intent);
                        break;
                    case 11:
                        intent = new Intent(PlayGame.this, Level12.class);
                        startActivity(intent);
                        break;
                    case 12:
                        intent = new Intent(PlayGame.this, Level13.class);
                        startActivity(intent);
                        break;
                    case 13:
                        intent = new Intent(PlayGame.this, Level14.class);
                        startActivity(intent);
                        break;
                    case 14:
                        intent = new Intent(PlayGame.this, Level15.class);
                        startActivity(intent);
                        break;
                    case 15:
                        intent = new Intent(PlayGame.this, Level16.class);
                        startActivity(intent);
                        break;
                    case 16:
                        intent = new Intent(PlayGame.this, Level17.class);
                        startActivity(intent);
                        break;
                    case 17:
                        intent = new Intent(PlayGame.this, Level18.class);
                        startActivity(intent);
                        break;
                    case 18:
                        intent = new Intent(PlayGame.this, Level19.class);
                        startActivity(intent);
                        break;
                    case 19:
                        intent = new Intent(PlayGame.this, Level20.class);
                        startActivity(intent);
                        break;
                    case 20:
                        intent = new Intent(PlayGame.this, Level21.class);
                        startActivity(intent);
                        break;
                    case 21:
                        intent = new Intent(PlayGame.this, Level22.class);
                        startActivity(intent);
                        break;
                    case 22:
                        intent = new Intent(PlayGame.this, Level23.class);
                        startActivity(intent);
                        break;
                    case 23:
                        intent = new Intent(PlayGame.this, Level24.class);
                        startActivity(intent);
                        break;
                    case 24:
                        intent = new Intent(PlayGame.this, Level25.class);
                        startActivity(intent);
                        break;
                    case 25:
                        intent = new Intent(PlayGame.this, Level26.class);
                        startActivity(intent);
                        break;
                    case 26:
                        intent = new Intent(PlayGame.this, Level27.class);
                        startActivity(intent);
                        break;
                    case 27:
                        intent = new Intent(PlayGame.this, Level28.class);
                        startActivity(intent);
                        break;
                    case 28:
                        intent = new Intent(PlayGame.this, Level29.class);
                        startActivity(intent);
                        break;
                    case 29:
                        intent = new Intent(PlayGame.this, Level30.class);
                        startActivity(intent);
                        break;
                    case 30:
                        intent = new Intent(PlayGame.this, Level31.class);
                        startActivity(intent);
                        break;
                    case 31:
                        intent = new Intent(PlayGame.this, Level32.class);
                        startActivity(intent);
                        break;
                    case 32:
                        intent = new Intent(PlayGame.this, Level33.class);
                        startActivity(intent);
                        break;
                    case 33:
                        intent = new Intent(PlayGame.this, Level34.class);
                        startActivity(intent);
                        break;
                    case 34:
                        intent = new Intent(PlayGame.this, Level35.class);
                        startActivity(intent);
                        break;

                }
            }
        };

        recyclerView.setLayoutManager(new GridLayoutManager(this, numberofColums));
        LevelAdapter adapter = new LevelAdapter(this, textLevels, levelClickListener);
        recyclerView.setAdapter(adapter);





    }

    private void setInitialData() {
        textLevels.add(new TextLevel("1"));
        textLevels.add(new TextLevel("2"));
        textLevels.add(new TextLevel("3"));
        textLevels.add(new TextLevel("4"));
        textLevels.add(new TextLevel("5"));
        textLevels.add(new TextLevel("6"));
        textLevels.add(new TextLevel("7"));
        textLevels.add(new TextLevel("8"));
        textLevels.add(new TextLevel("9"));
        textLevels.add(new TextLevel("10"));
        textLevels.add(new TextLevel("11"));
        textLevels.add(new TextLevel("12"));
        textLevels.add(new TextLevel("13"));
        textLevels.add(new TextLevel("14"));
        textLevels.add(new TextLevel("15"));
        textLevels.add(new TextLevel("16"));
        textLevels.add(new TextLevel("17"));
        textLevels.add(new TextLevel("18"));
        textLevels.add(new TextLevel("19"));
        textLevels.add(new TextLevel("20"));
        textLevels.add(new TextLevel("21"));
        textLevels.add(new TextLevel("22"));
        textLevels.add(new TextLevel("23"));
        textLevels.add(new TextLevel("24"));
        textLevels.add(new TextLevel("25"));
        textLevels.add(new TextLevel("26"));
        textLevels.add(new TextLevel("27"));
        textLevels.add(new TextLevel("28"));
        textLevels.add(new TextLevel("29"));
        textLevels.add(new TextLevel("30"));
        textLevels.add(new TextLevel("31"));
        textLevels.add(new TextLevel("32"));
        textLevels.add(new TextLevel("33"));
        textLevels.add(new TextLevel("34"));
        textLevels.add(new TextLevel("35"));
    }

    //Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed(){
        try {
            Intent intent = new Intent(PlayGame.this, GameMenu.class);
            startActivity(intent); finish();
        }catch (Exception e){
        //Пусто
        }
    }
    //Системная кнопка "Назад" - конец
}
