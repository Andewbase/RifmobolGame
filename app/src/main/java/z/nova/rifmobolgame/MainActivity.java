package z.nova.rifmobolgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.yodo1.mas.Yodo1Mas;
import com.yodo1.mas.error.Yodo1MasError;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //you just have to use this code in MainActivity not others. Just once
        Yodo1Mas.getInstance().init(this, "sszpCIMxv0", new Yodo1Mas.InitListener() {
            @Override
            public void onMasInitSuccessful() {

            }

            @Override
            public void onMasInitFailed(@NonNull Yodo1MasError error) {
                //пусто
            }
        });
        //Убираем панель с батареей
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, GameMenu.class);
                startActivity(intent);
                finish();
            }
        },5000);
    }

    //Системная кнопка "Назад" - начало

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel(); //Закрывает Тост вместе с приложением
            super.onBackPressed();
            return;
        }else {
            backToast = Toast.makeText(getBaseContext(), "Нажмити ещё раз, что бы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    //Системная кнопка "Назад" - конец

}
