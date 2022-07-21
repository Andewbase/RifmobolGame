package z.nova.rifmobolgame.multiplaer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.yodo1.mas.Yodo1Mas;

import z.nova.rifmobolgame.GameMenu;
import z.nova.rifmobolgame.R;

public class MultiLevelSix1 extends AppCompatActivity {

    MediaPlayer mediaPlayer; //Создаём Медиа плеер
    int check = 0; //счётчики нажатия

    SharedPreferences mypref;

    int correctanswer1 = 0;//Счёт первого игрока
    int correctanswer2 = 0;//Счёт второго игрока
    boolean onechek = false;//проверка нажал ли первый игрок правильный ответ
    boolean twochek = false;//проверка нажал ли второй игрок правильный ответ
    TextView score1; //Создаём переменую с отображением счёта для первого игрока
    TextView score2; //Создаём переменую с отображением счёта для второго игрока
    Button p1btn_up_left;
    Button p1btn_up_right;
    Button p1btn_bottom_right;
    Button p1btn_bottom_left;

    Button p2btn_up_left;
    Button p2btn_up_right;
    Button p2btn_bottom_right;
    Button p2btn_bottom_left;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universalmulti);

        score1 = findViewById(R.id.scoree1); //Создаём переменую с отображением счёта для первого игрока
        score1.setText("Первый Игрок : " + correctanswer1);//Устанавливаем текст

        score2 = findViewById(R.id.scoree2); //Создаём переменую с отображением счёта для второго игрока
        score2.setText("Второй Игрок : " + correctanswer2);//Устанавливаем текст

        //Создаём переменную text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.raund1); //Установили текст

        //Устанавливаем фон для уровня - начало
        ImageView background = (ImageView) findViewById(R.id.menu_background);
        background.setImageResource(R.drawable.level6_background);
        //Устанавливаем фон для уровня - конец

        //Устанавливаем текст для уровня - начало
        TextView textlevel2 = findViewById(R.id.couplet_text);
        textlevel2.setText(R.string.lvlcouplet26);
        //Устанавливаем текст для уровня - конец

        p1btn_up_left =  findViewById(R.id.p1btn_left_up);//Создаём левую верхнюю кнопку (первый игрок)
        p1btn_up_right =  findViewById(R.id.p1btn_right_up);//Создаём правую верхнюю кнопку (первый игрок)
        p1btn_bottom_right = findViewById(R.id.p1btn_right_bottom);//Создаём нижнюю правоую кнопку (первый игрок)
        p1btn_bottom_left =  findViewById(R.id.p1btn_left_bottom);//Создаём нижнюю левую кнопку (первый игрок)

        p2btn_up_left = findViewById(R.id.p2btn_left_up);//Создаём левую верхнюю кнопку (второй игрок)
        p2btn_up_right = findViewById(R.id.p2btn_right_up);//Создаём правую верхнюю кнопку (второй игрок)
        p2btn_bottom_right = findViewById(R.id.p2btn_right_bottom);//Создаём нижнюю правоую кнопку (второй игрок)
        p2btn_bottom_left = findViewById(R.id.p2btn_left_bottom);//Создаём нижнюю левую кнопку (второй игрок)

        //Меняем текст в кнопках - начало
        p1btn_up_left.setText(R.string.lvl26textone);
        p1btn_up_right.setText(R.string.lvl26texttwo);
        p1btn_bottom_left.setText(R.string.lvl26textthree);
        p1btn_bottom_right.setText(R.string.lvl26textfour);


        p2btn_up_left.setText(R.string.lvl26textone);
        p2btn_up_right.setText(R.string.lvl26texttwo);
        p2btn_bottom_left.setText(R.string.lvl26textthree);
        p2btn_bottom_right.setText(R.string.lvl26textfour);
        //Меняем текст в кнопках - конец

        //Меняем размер текста в кнопках - начало
        p1btn_up_right.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);

        p2btn_up_right.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        //Меняем размер текста в кнопках конец

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //Кнопка "Назад" - начало
        Button btn_back = (Button) findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обрабатывем нажатие кнопки "Назад" - начало
                if (Yodo1Mas.getInstance().isInterstitialAdLoaded()) { //TODO
                    Yodo1Mas.getInstance().showInterstitialAd(MultiLevelSix1.this); //Показать рекламу
                    Intent intent = new Intent(MultiLevelSix1.this, GameMenu.class); //Создали намерение для перехода
                    startActivity(intent);
                    finish();
                }else {
                    try {
                        //Вернуться назад к выбору уровня - начало
                        Intent intent = new Intent(MultiLevelSix1.this, GameMenu.class); //Создали намерение для перехода
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


            //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - начало (первый игрок)
            p1btn_up_left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        onechek = true;

                        check++; // Общий счётчик нажатия

                        if (check == 2) {//Если нажали два раза
                            //Вопроизводим полный куплет -начало
                            if (mediaPlayer != null) {
                                releaseMP();
                                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.passive2);
                                mediaPlayer.start();
                                p1btn_up_left.setClickable(false);//Отключаем кнопку после нажатия, setEnable(false) красит в серый цвет кнопку
                            }
                        }
                        //Вопроизводим полный куплет - конец

                        //Метод показывающий правельный ответ - начало
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                p1btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                                p2btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                                accrualOfPoints();
                                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(MultiLevelSix1.this, MultiLevelSix2.class); //ИЗМЕНИТЬ
                                        startActivity(intent);
                                        finish();
                                    }
                                }, 500);
                                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                            }
                        });
                        //Метод показывающий правельный ответ - конец

                        p1btn_up_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whiteblue);

                            p1btn_up_right.setClickable(false);//Блокируем правую верхнюю
                            p1btn_bottom_left.setClickable(false);//Блокируем нижнюю левую
                            p1btn_bottom_right.setClickable(false);//Блокируем нижнюю правую

                    } catch (Exception e) {
                        //Пусто
                    }
                }
            });
            //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - конец (первый игрок)

            //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - начало (первый игрок)
            p1btn_up_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        check++; // Общий счётчик нажатия


                        if (check == 2) {//Если нажали два раза
                            //Вопроизводим полный куплет - начало
                            if (mediaPlayer != null) {
                                releaseMP();
                                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.passive2);
                                mediaPlayer.start();
                                p1btn_up_right.setClickable(false);//Отключаем кнопку после нажатия
                            }
                        }
                        //Вопроизводим полный куплет - конец

                        //Метод показывающий правельный ответ - начало
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                p1btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                                p2btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                                accrualOfPoints();
                                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(MultiLevelSix1.this, MultiLevelSix2.class); //ИЗМЕНИТЬ
                                        startActivity(intent);
                                        finish();
                                    }
                                }, 500);
                                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                            }
                        });
                        //Метод показывающий правельный ответ - конец

                            p1btn_up_right.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whiteblue);

                            p1btn_up_left.setClickable(false);//Блокируем правую верхнюю
                            p1btn_bottom_left.setClickable(false);//Блокируем нижнюю левую
                            p1btn_bottom_right.setClickable(false);//Блокируем нижнюю правую

                    } catch (Exception e) {
                        //Пусто
                    }
                }
            });
            //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - конец (первый игрок)

            //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - начало (первый игрок)
            p1btn_bottom_left.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {

                        check++; // Общий счётчик нажатия


                        if (check == 2) {//Если нажали два раза
                            //Вопроизводим полный куплет -начало
                            if (mediaPlayer != null) {
                                releaseMP();
                                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.passive2);
                                mediaPlayer.start();
                                p1btn_bottom_left.setClickable(false);//Отключаем кнопку после нажатия
                            }
                        }
                        //Вопроизводим полный куплет - конец

                        //Метод показывающий правельный ответ - начало
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                                p1btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                                p2btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                                accrualOfPoints();
                                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(MultiLevelSix1.this, MultiLevelSix2.class); //ИЗМЕНИТЬ
                                        startActivity(intent);
                                        finish();
                                    }
                                }, 500);
                                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                            }
                        });
                        //Метод показывающий правельный ответ - конец

                            p1btn_bottom_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whiteblue);

                            p1btn_up_left.setClickable(false);//Блокируем правую верхнюю
                            p1btn_up_right.setClickable(false);//Блокируем нижнюю левую
                            p1btn_bottom_right.setClickable(false);//Блокируем нижнюю правую

                    } catch (Exception e) {
                        //Пусто
                    }
                }
            });
            //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - конец (первый игрок)

            //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - начало
            p1btn_bottom_right.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        check++; // Общий счётчик нажатия


                        if (check == 2) {//Если нажали два раза
                            //Вопроизводим полный куплет - начало
                            if (mediaPlayer != null) {
                                releaseMP();
                                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.passive2);
                                mediaPlayer.start();
                                p1btn_bottom_right.setClickable(false);//Отключаем кнопку после нажатия
                            }
                        }
                        //Вопроизводим полный куплет - конец

                        //Метод показывающий правельный ответ - начало
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mediaPlayer) {
                               p1btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                               p2btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                                accrualOfPoints();
                                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(MultiLevelSix1.this, MultiLevelSix2.class); //ИЗМЕНИТЬ
                                        startActivity(intent);
                                        finish();
                                    }
                                }, 500);
                                //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                            }
                        });
                        //Метод показывающий правельный ответ - конец

                            p1btn_bottom_right.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whiteblue);

                            p1btn_up_left.setClickable(false);//Блокируем правую верхнюю
                            p1btn_up_right.setClickable(false);//Блокируем нижнюю левую
                            p1btn_bottom_left.setClickable(false);//Блокируем нижнюю правую

                    } catch (Exception e) {
                        //Пусто
                    }
                }
            });
            //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - конец (первый игрок)

        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - начало (второй игрок)
        p2btn_up_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    twochek = true;

                    check++; // Общий счётчик нажатия

                    if (check == 2) {//Если нажали два раза
                        //Вопроизводим полный куплет -начало
                        if (mediaPlayer != null) {
                            releaseMP();
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.passive2);
                            mediaPlayer.start();
                            p2btn_up_left.setClickable(false);//Отключаем кнопку после нажатия, setEnable(false) красит в серый цвет кнопку
                        }
                    }
                    //Вопроизводим полный куплет - конец

                    //Метод показывающий правельный ответ - начало
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            p1btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                            p2btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                            accrualOfPoints();
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(MultiLevelSix1.this, MultiLevelSix2.class); //ИЗМЕНИТЬ
                                    startActivity(intent);
                                    finish();
                                }
                            }, 500);
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                        }
                    });
                    //Метод показывающий правельный ответ - конец

                    p2btn_up_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitered);

                    p2btn_up_right.setClickable(false);//Блокируем правую верхнюю
                    p2btn_bottom_left.setClickable(false);//Блокируем нижнюю левую
                    p2btn_bottom_right.setClickable(false);//Блокируем нижнюю правую

                } catch (Exception e) {
                    //Пусто
                }
            }
        });
        //Обрабатываем нажатие на "Левую Верхнюю Кнопку" - конец (второй игрок)

        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - начало (второй игрок)
        p2btn_up_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {


                    check++; // Общий счётчик нажатия


                    if (check == 2) {//Если нажали два раза
                        //Вопроизводим полный куплет - начало
                        if (mediaPlayer != null) {
                            releaseMP();
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.passive2);
                            mediaPlayer.start();
                            p2btn_up_right.setClickable(false);//Отключаем кнопку после нажатия
                        }
                    }
                    //Вопроизводим полный куплет - конец

                    //Метод показывающий правельный ответ - начало
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            p1btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                            p2btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                            accrualOfPoints();
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(MultiLevelSix1.this, MultiLevelSix2.class); //ИЗМЕНИТЬ
                                    startActivity(intent);
                                    finish();
                                }
                            }, 500);
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                        }
                    });
                    //Метод показывающий правельный ответ - конец

                    p2btn_up_right.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitered);

                    p2btn_up_left.setClickable(false);//Блокируем правую верхнюю
                    p2btn_bottom_left.setClickable(false);//Блокируем нижнюю левую
                    p2btn_bottom_right.setClickable(false);//Блокируем нижнюю правую

                } catch (Exception e) {
                    //Пусто
                }
            }
        });
        //Обрабатываем нажатие на "Правую Верхнюю Кнопку" - конец (второй игрок)

        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - начало (второй игрок)
        p2btn_bottom_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    check++; // Общий счётчик нажатия


                    if (check == 2) {//Если нажали два раза
                        //Вопроизводим полный куплет -начало
                        if (mediaPlayer != null) {
                            releaseMP();
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.passive2);
                            mediaPlayer.start();
                            p2btn_bottom_left.setClickable(false);//Отключаем кнопку после нажатия
                        }
                    }
                    //Вопроизводим полный куплет - конец

                    //Метод показывающий правельный ответ - начало
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            p1btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                            p2btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                           accrualOfPoints();
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(MultiLevelSix1.this, MultiLevelSix2.class); //ИЗМЕНИТЬ
                                    startActivity(intent);
                                    finish();
                                }
                            }, 500);
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                        }
                    });
                    //Метод показывающий правельный ответ - конец

                    p2btn_bottom_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitered);

                    p2btn_up_left.setClickable(false);//Блокируем правую верхнюю
                    p2btn_up_right.setClickable(false);//Блокируем нижнюю левую
                    p2btn_bottom_right.setClickable(false);//Блокируем нижнюю правую

                } catch (Exception e) {
                    //Пусто
                }
            }
        });
        //Обрабатываем нажатие на "Левую Нижнюю Кнопку" - конец (второй игрок)

        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - начало (второй игрок)
        p2btn_bottom_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    check++; // Общий счётчик нажатия


                    if (check == 2) {//Если нажали два раза
                        //Вопроизводим полный куплет - начало
                        if (mediaPlayer != null) {
                            releaseMP();
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.passive2);
                            mediaPlayer.start();
                            p2btn_bottom_right.setClickable(false);//Отключаем кнопку после нажатия
                        }
                    }
                    //Вопроизводим полный куплет - конец

                    //Метод показывающий правельный ответ - начало
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            p1btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                            p2btn_up_left.setBackground(getResources().getDrawable(R.drawable.style_btn_stroke_whiteblack_press_whitgreen));
                            accrualOfPoints();
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    Intent intent = new Intent(MultiLevelSix1.this, MultiLevelSix2.class); //ИЗМЕНИТЬ
                                    startActivity(intent);
                                    finish();
                                }
                            }, 500);
                            //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                        }
                    });
                    //Метод показывающий правельный ответ - конец


                    p2btn_bottom_right.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitered);

                    p2btn_up_left.setClickable(false);//Блокируем правую верхнюю
                    p2btn_up_right.setClickable(false);//Блокируем нижнюю левую
                    p2btn_bottom_left.setClickable(false);//Блокируем нижнюю правую

                } catch (Exception e) {
                    //Пусто
                }
            }
        });
        //Обрабатываем нажатие на "Правую Нижнюю Кнопку" - конец (второй игрок)

    }
    //Проигрываем музыку при запуске уровня - начало
    @Override
    protected void onResume() {
        super.onResume();
        //Создаём переменую с отображением счёта для первого игрока
        score1 = findViewById(R.id.scoree1);

        //Создаём переменую с отображением счёта для второго игрока
        score2 = findViewById(R.id.scoree2);

        p1btn_up_left = findViewById(R.id.p1btn_left_up);//Создаём нижнюю левую кнопку
        p2btn_up_left = findViewById(R.id.p2btn_left_up);//Создаём нижнюю левую кнопку (второй игрок)
        if (check <= 1) { //Если свернули игру до нажатия варианта ответа, либо когда нажал только один игрок
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.passive1);
            mediaPlayer.start();
        }else if(check > 1){ //Иначе если свернули игру после нажатия вариантов ответа двумя игроками
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.passive2);
            mediaPlayer.start();
                //Метод показывающий правельный ответ - начало
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        p1btn_up_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitgreen);
                        p2btn_up_left.setBackgroundResource(R.drawable.style_btn_stroke_whiteblack_press_whitgreen);
                        accrualOfPoints();
                        //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Начало
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (check == 2){
                                    Intent intent = new Intent(MultiLevelSix1.this, MultiLevelSix2.class); //ИЗМЕНИТЬ
                                    startActivity(intent);
                                    finish();
                                }
                            }
                        }, 500);
                        //ВЫХОД ИЗ ТРЭКА (Задержка 0.3 секунды) - Конец
                    }
                });
                //Метод показывающий правельный ответ - конец


        }
    }
    //Проигрываем музыку при запуске уровня - конец

    //Метод начисления балов - начало
    private void accrualOfPoints (){
        if (onechek == true && twochek == false){
            correctanswer1  += 1;//Увеличиваем правильный ответ первому игроку на 1
            score1.setText("Первый Игрок : " + correctanswer1);//Меняем текст первому игроку
        }else if (onechek == false && twochek == true){
            correctanswer2  += 1;//Увеличиваем правильный ответ второму игроку на 1
            score2.setText("Второй Игрок : " + correctanswer2);//Меняем текст первому игроку
        }else if (onechek == true && twochek==true){
            correctanswer1  += 1;//Увеличиваем правильный ответ первому игроку на 1
            correctanswer2  += 1;//Увеличиваем правильный ответ первому игроку на 1
            score1.setText("Первый Игрок : " + correctanswer1);//Меняем текст первому игроку
            score2.setText("Второй Игрок : " + correctanswer2);//Меняем текст первому игроку
        }
        saveResult ();
    }
    //Метод начисления балов - конец

    //Метод сохранения результатов уровня - начало
    private void saveResult (){
        mypref = getSharedPreferences("RessultGame", Context.MODE_PRIVATE);//получили объект класса который позволяет работаь с данными
        SharedPreferences.Editor ed = mypref.edit();//получили объект Editor для редактирования данных
        ed.putInt("score1", correctanswer1); //ключ хранения и данные
        ed.putInt("score2", correctanswer2);//ключ хранения и данные
        ed.apply();//Выполняем apply для сохранения данных
    }
    //Метод сохранения результатов уровня - конец

    //Метод очистки результата - начало
    private void cleanResult (){
        mypref = getSharedPreferences("RessultGame", Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = mypref.edit();
        ed.remove("score1");
        ed.remove("score2");
        ed.apply();
    }
    //Метод очистки результата - конец

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
        if (Yodo1Mas.getInstance().isInterstitialAdLoaded()) { //TODO
            Yodo1Mas.getInstance().showInterstitialAd(MultiLevelSix1.this); // показать рекламу
            Intent intent = new Intent(MultiLevelSix1.this, GameMenu.class); //Создали намерение для перехода
            startActivity(intent);
            finish();
        }else {
            try {
                Intent intent = new Intent(MultiLevelSix1.this, GameMenu.class);
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
