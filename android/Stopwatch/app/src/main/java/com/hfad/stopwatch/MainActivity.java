package com.hfad.stopwatch;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import java.util.Locale;
import android.os.Handler;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Number of seconds displayed on the stopwatch
    private int seconds = 0;
    //Is the stopwatch running
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runTimer();
    }

    //start the stopwatch runnint when the Start button is clicked.
    public void onClickStart(View view){
        running = true;
    }
    //Start the stopwatch running when the Stop button is clicked.
    public void onClickStop(View view){
        running = false;
    }

    //Reset the stopwatch when the Reset button is clicked.
    public void onClickReset(View view){
        running = false;
        seconds = 0;
    }


    private void runTimer(){
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final Handler handler = new Handler ();
        handler.post(new Runnable(){
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;
                String time = String.format(Locale.getDefault(),
                        "%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                if(running){
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
