package comq.example.eddiehuang.introduction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button leftButt;
    private Button rightButt;
    private TextView pointView;
    private int rand1 = 0;
    private int rand2 = 0;
    private int points = 0;
    private Random randy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randy = new Random();

        pointView = (TextView) findViewById(R.id.pointText);

        updateNumber();


    }

    public void rightButtonEvent(View view) {
        if (rand1 >= rand2){
            points++;
            Toast.makeText(this,"Good job", Toast.LENGTH_LONG );
        }else {
            points--;
            Toast.makeText(this,"You Suck", Toast.LENGTH_LONG );

        }
        pointView.setText("points" + points);
        updateNumber();


    }

    public void leftButtonEvent(View view) {
        if (rand1 < rand2){
            points++;
            Toast.makeText(this,"Good job", Toast.LENGTH_LONG );

        }else {
            points--;
            Toast.makeText(this,"You Suck", Toast.LENGTH_LONG );

        }
        pointView.setText("points:" + points);
        updateNumber();
    }

    public void updateNumber(){
        rand1 = randy.nextInt(10);
        rand2 = randy.nextInt(10);
        leftButt = (Button) findViewById(R.id.leftButton);
        rightButt = (Button) findViewById(R.id.rightButton);
        leftButt.setText(Integer.toString(rand1));
        rightButt.setText(Integer.toString(rand2));

    }
}
