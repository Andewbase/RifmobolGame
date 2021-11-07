package z.nova.rifmobolgame;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import z.nova.rifmobolgame.multiplaer.MultiLevel1;
import z.nova.rifmobolgame.multiplaer.MultiLevelFive1;
import z.nova.rifmobolgame.multiplaer.MultiLevelFour1;
import z.nova.rifmobolgame.multiplaer.MultiLevelSix1;
import z.nova.rifmobolgame.multiplaer.MultiLevelThree1;
import z.nova.rifmobolgame.multiplaer.MultiLevelTwo1;

public class MultiplayerGame extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_menu);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Random generator = new Random();
        int number = generator.nextInt(6) + 1;
        // The '5' is the number of activities

        Class activity = null;

        // Here, we are checking to see what the output of the random was
        switch(number) {
            case 1:
                // E.g., if the output is 1, the activity we will open is ActivityOne.class
                activity = MultiLevel1.class;
                break;
            case 2:
                activity = MultiLevelTwo1.class;
                break;
            case 3:
                activity = MultiLevelThree1.class;
                break;
            case 4:
                activity = MultiLevelFour1.class;
                break;
            case 5:
                activity = MultiLevelFive1.class;
                break;
            default:
                activity = MultiLevelSix1.class;
                break;
        }
        // We use intents to start activities
        Intent intent = new Intent(getBaseContext(), activity);
        startActivity(intent);
        finish();
    }

}
