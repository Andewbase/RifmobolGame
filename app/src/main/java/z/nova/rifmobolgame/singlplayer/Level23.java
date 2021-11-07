package z.nova.rifmobolgame.singlplayer;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import z.nova.rifmobolgame.PlayGame;
import z.nova.rifmobolgame.R;

public class Level23 extends AppCompatActivity {

    MediaPlayer mediaPlayer; //Создаём Медиа плеер
    Dialog dialogEndWin; //Создаём Диалог Выйграл
    Dialog dialogEndLose; //Создаем Диалог Проиграл
    int Clicked = 0; //Создаём переменую для отслеживания нажатия

    public InterstitialAd interstitialAd; //Реклама



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //Реклама - начало
        MobileAds.initialize(this, "ca-app-pub-7867301759529153~4469254788");
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId("ca-app-pub-7867301759529153/6261682753");
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);
        //Реклама - конец

        //Закрытие рекламы по крестику - начало
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                try {
                    Intent intent1 = new Intent(Level23.this, PlayGame.class );
                    startActivity(intent1); finish();
                }catch (Exception e){
                    //пусто
                }
            }
        });
        //Закрытие рекламы по крестику - начало

        //Создаём переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level23); //Установили текст


        final Button btn_bottom_right = (Button) findViewById(R.id.btn_right_bottom);//Создаём нижнюю правую кнопку
        final Button btn_up_left = (Button) findViewById(R.id.btn_left_up);//Создаём левую верхнюю кнопку
        final Button btn_up_right = (Button) findViewById(R.id.btn_right_up);//Создаём правую верхнюю кнопку
        final Button btn_bottom_left = (Button) findViewById(R.id.btn_left_bottom);//Создаём нижнюю правоую кнопку

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Устанавливаем фон для уровня - начало
        ImageView background = (ImageView) findViewById(R.id.menu_background);
        background.setImageResource(R.drawable.level3_background);
        //Устанавливаем фон для уровня - конец

        //Устанавливаем текст для уровня - начало
        TextView textlevel2 = findViewById(R.id.couplet_text);
        textlevel2.setText(R.string.lvlcouplet23);
        //Устанавливаем текст для уровня - конец



        //Меняем текст в кнопках - начало
        btn_up_left.setText(R.string.lvl23textone);
        btn_up_right.setText(R.string.lvl23texttwo);
        btn_bottom_left.setText(R.string.lvl23textthree);
        btn_bottom_right.setText(R.string.lvl23textfour);
        //Меняем текст в кнопках - конец

        //Вызов диалогового окна Выйграл "В Конце" - начало
        dialogEndWin = new Dialog (this);
        dialogEndWin.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEndWin.setContentView(R.layout.dialogend_win);
        dialogEndWin.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEndWin.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEndWin.setCancelable(false);
        //Вызов диалогового окна Выйграл "В Конце" - конец



        //Устанавливаем текст в диалоговое окно - начало
        TextView textdescriptions = (TextView) dialogEndWin.findViewById(R.id.textwin);
        textdescriptions.setText(R.string.dialogwins3);
        //Устанавливаем текст в диалоговое окно - начало

        //Кнопка которая закрывет диалоговое окно - начало
        TextView btnclose = (TextView) dialogEndWin.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show(); //Показать рекламу
                } else {
                    try {
                        Intent intent = new Intent(Level23.this, PlayGame.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        //Пусто
                    }
                    dialogEndWin.dismiss();
                }
            }
        });
        //Кнопка которая закрывет диалоговое окно - конец

        //Кнопка "ДАЛЕЕ" - начало
        Button buttoncontinue = (Button) dialogEndWin.findViewById(R.id.btncontinue);
        buttoncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level23.this, Level24.class); //ИЗМЕНИТЬ
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //Пусто
                }
                dialogEndWin.dismiss();
            }
        });
        //Кнопка "ДАЛЕЕ" - конец

        //Вызов диалогового окна Проиграл "В Конце" - начало
        dialogEndLose = new Dialog (this);
        dialogEndLose.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEndLose.setContentView(R.layout.dialogend_lose);
        dialogEndLose.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEndLose.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);
        dialogEndLose.setCancelable(false);
        //Вызов диалогового окна Проиграл "В Конце" - конец



        //Устанавливаем текст в диалоговое окно - начало
        TextView textdescriptionsl = (TextView) dialogEndLose.findViewById(R.id.textlose);
        textdescriptionsl.setText(R.string.dialoglose3);
        //Устанавливаем текст в диалоговое окно - начало


        //Кнопка которая закрывет диалоговое окно - начало
        TextView btnclose1 = (TextView) dialogEndLose.findViewById(R.id.btnclose);
        btnclose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (interstitialAd.isLoaded()) {
                    interstitialAd.show(); //Показать рекламу
                } else {
                    try {
                        Intent intent = new Intent(Level23.this, PlayGame.class);
                        startActivity(intent);
                        finish();
                    } catch (Exception e) {
                        //Пусто
                    }
                    dialogEndLose.dismiss();
                }
            }
        });
        //Кнопка которая закрывет диалоговое окно - конец

        //Кнопка "ЕЩЕ РАЗ" - начало
        Button buttoncontinueback1 = (Button) dialogEndLose.findViewById(R.id.btncontinueback);
        buttoncontinueback1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level23.this, Level23.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //Пусто
                }
                dialogEndLose.dismiss();
            }
        });
        //Кнопка "ЕЩЁ РАЗ" - конец

        //Кнопка "ДАЛЕЕ" - начало
        Button buttoncontinue1 = (Button) dialogEndLose.findViewById(R.id.btncontinue);
        buttoncontinue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level23.this, Level24.class); //ИЗМЕНИТЬ
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                    //Пусто
                }
                dialogEndLose.dismiss();
            }
        });
        //Кнопка "ДАЛЕЕ" - конец



        //Кнопка "Назад" - начало
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обрабатывем нажатие кнопки "Назад" - начало
                if (interstitialAd.isLoaded()){
                    interstitialAd.show(); //Показать рекламу
                }else {
                    try {
                        //Вернуться назад к выбору уровня - начало
                        Intent intent = new Intent(Level23.this, PlayGame.class); //Создали намерение для перехода
                        startActivity(intent);
                        finish();
                        //Вернуться назад к выбору уровня - конец
                    } catch (Exception e) {
                        //Здесь кода не будет
                    }
                    //Обрабатываем нажатие кнопки "Назад" - конец
                }
            }
        });
        //Кнопка "Назад" - конец

        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - начало
        btn_up_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Clicked = 1; //Кнопка нажата
                    //Вопроизводим полный куплет -начало
                    if (mediaPlayer!=null){
                        releaseMP();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mosquitoes2); //Изменять
                        mediaPlayer.start();
                        btn_up_left.setClickable(false);//Отключаем кнопку после нажатия, setEnable(false) красит в серый цвет кнопку
                    }
                    //Вопроизводим полный куплет - конец

                    //Метод показывающий правельный ответ - начало
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            btn_up_right.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    dialogEndLose.show(); // Выводим диалог проиграл
                                }
                            },500);
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                        }
                    });
                    //Метод показывающий правельный ответ - конец

                    btn_up_left.setBackground(getResources().
                            getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whiteblue));// Меняем фон кнопки при нажатие
                    btn_up_right.setClickable(false);//Блокируем правую верхнюю
                    btn_bottom_left.setClickable(false);//Блокируем нижнюю левую
                    btn_bottom_right.setClickable(false);//Блокируем нижнюю правую
                }catch (Exception e){
                    //Пусто
                }
            }
        });
        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - конец

        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - начало
        btn_up_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Clicked = 2; //Кнопка нажата
                    //Вопроизводим полный куплет -начало
                    if (mediaPlayer!=null){
                        releaseMP();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mosquitoes2);
                        mediaPlayer.start();
                        btn_up_right.setClickable(false);//Отключаем кнопку после нажатия
                    }
                    //Вопроизводим полный куплет - конец

                    //Метод показывающий правельный ответ - начало
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            btn_up_right.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    dialogEndWin.show(); //Выводим диалог проиграл
                                }
                            },500);
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                        }
                    });
                    //Метод показывающий правельный ответ - конец

                    btn_up_right.setBackground(getResources().
                            getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whiteblue));// Меняем фон кнопки при нажатие
                    btn_up_left.setClickable(false);//Блокируем правую верхнюю
                    btn_bottom_left.setClickable(false);//Блокируем нижнюю левую
                    btn_bottom_right.setClickable(false);//Блокируем нижнюю правую
                }catch (Exception e){
                    //Пусто
                }
            }
        });
        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - конец

        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - начало
        btn_bottom_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Clicked = 3; //Кнопка нажата
                    //Вопроизводим полный куплет -начало
                    if (mediaPlayer!=null){
                        releaseMP();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mosquitoes2);
                        mediaPlayer.start();
                        btn_bottom_left.setClickable(false);//Отключаем кнопку после нажатия
                    }
                    //Вопроизводим полный куплет - конец

                    //Метод показывающий правельный ответ - начало
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            btn_up_right.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    dialogEndLose.show(); //Выводим диалог проиграл
                                }
                            },500);
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                        }
                    });
                    //Метод показывающий правельный ответ - конец

                    btn_bottom_left.setBackground(getResources().
                            getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whiteblue));// Меняем фон кнопки при нажатие
                    btn_up_left.setClickable(false);//Блокируем правую верхнюю
                    btn_up_right.setClickable(false);//Блокируем нижнюю левую
                    btn_bottom_right.setClickable(false);//Блокируем нижнюю правую
                }catch (Exception e){
                    //Пусто
                }
            }
        });
        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - конец

        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - начало
        btn_bottom_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Clicked = 4; //Кнопка нажата
                    //Вопроизводим полный куплет -начало
                    if (mediaPlayer!=null){
                        releaseMP();
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mosquitoes2);
                        mediaPlayer.start();
                        btn_bottom_right.setClickable(false);//Отключаем кнопку после нажатия
                    }
                    //Вопроизводим полный куплет - конец

                    //Метод показывающий правельный ответ - начало
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion (MediaPlayer mediaPlayer){
                            btn_up_right.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    dialogEndLose.show();//Выводим диалог выйграл
                                }
                            }, 500);
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                        }
                    });
                    //Метод показывающий правельный ответ - конец

                    btn_bottom_right.setBackground(getResources().
                            getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whiteblue));// Меняем фон кнопки при нажатие
                    btn_up_left.setClickable(false);//Блокируем правую верхнюю
                    btn_up_right.setClickable(false);//Блокируем нижнюю левую
                    btn_bottom_left.setClickable(false);//Блокируем нижнюю правую
                }catch (Exception e){
                    //Пусто
                }
            }
        });
        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - конец

    }
    //Проигрываем музыку при запуске уровня - начало
    @Override
    protected void onResume() {
        super.onResume();
        final Button btn_up_right = (Button) findViewById(R.id.btn_right_up);//Создаём нижнюю правую кнопку
        if (mediaPlayer == null & Clicked == 0) { //Если свернули игру до нажатия варианта ответа
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mosquitoes1);
            mediaPlayer.start();
        }else if(Clicked > 0){ //Иначе если свернули игру после нажатия варианта ответа
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.mosquitoes2);
            mediaPlayer.start();
            //Метод показывающий правельный ответ - начало
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    btn_up_right.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (Clicked == 2){
                                dialogEndWin.show();//Выводит диалог выйграл
                            }else{
                                dialogEndLose.show();//Выводит диалог проиграл
                            };
                        }
                    }, 500);
                    //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                }
            });
            //Метод показывающий правельный ответ - конец
        }
    }
    //Проигрываем музыку при запуске уровня - конец

    //Метод освобождения Плеера - начало
    private void releaseMP (){
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
                mediaPlayer = null;

            }catch (Exception e){
                //Пусто
            }
        }
    }
    //Метод освобождения Плеера - конец

    //Системная кнопка "Назад" - начало
    @Override
    public void onBackPressed(){
        if (interstitialAd.isLoaded()){
            interstitialAd.show(); // показать рекламу
        }else {
            try {
                Intent intent = new Intent(Level23.this, PlayGame.class);
                startActivity(intent);
                finish();
            } catch (Exception e) {
                //Пусто
            }
        }
    }
    //Системная кнопка "Назад" - конец

    //Останавливает проигрыватель при паузе активити - начало
    @Override
    protected void onPause() {
        super.onPause();
        releaseMP();
    }
    //Останавливает проигрыватель при паузе активити - конец

    //Освобождаем ресурсы проигрывателя при уничтожение активити - начало
    protected void onDestroy() {
        super.onDestroy();
        releaseMP();
    }
    //Освобождаем ресурсы проигрывателя при уничтожение активити - конец
}

