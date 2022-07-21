package z.nova.rifmobolgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GameMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);



        //кнопка "Играть" - начало
        Button buttonPlay = (Button) findViewById(R.id.btnPlay);
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try {
                //Смена активити
                Intent intent = new Intent(GameMenu.this, PlayGame.class );
                startActivity(intent);
                finish();
            }catch (Exception e){
                //Пусто
            }
            }
        });
        //кнопка "Играть" - конец

        //Кнопка "Вдвоём" - начало
        Button buttonMultiplayer = (Button) findViewById(R.id.btnMultiplayer);
        buttonMultiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(GameMenu.this, MultiplayerGame.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //Пусто
                }
            }
        });
        //Кнопка "Вдвоём" - конец



        //Кнопка "Правила" - начало
        Button buttonRules = (Button) findViewById(R.id.btnRules);
        buttonRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try {
                Intent intent = new Intent(GameMenu.this, RulesGame.class);
                startActivity(intent);
                finish();
            }catch (Exception e){
                //Пусто
            }
            }
        });
        //Кнопка "Правила" - конец

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


}
