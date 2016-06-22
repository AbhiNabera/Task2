package com.example.abhinabera.task2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    Sensor sensor;
    ImageView slide;
    Spinner track;
    Button slideshow, play, stop, enable, disable;
    TextView time;
    int item, count;
    MediaPlayer mp;
    String [] tracks = {"Sound Tracks.", "Start your engines.", "Race cars dont need headlights.", "Ferrari talking."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slide = (ImageView) findViewById(R.id.imageView);
        track = (Spinner) findViewById(R.id.spinner);
        slideshow = (Button) findViewById(R.id.show);
        play = (Button) findViewById(R.id.play);
        enable = (Button) findViewById(R.id.enable);
        disable = (Button) findViewById(R.id.disable);
        stop = (Button) findViewById(R.id.stop);
        time = (TextView) findViewById(R.id.time);
        disable.setEnabled(false);
        stop.setEnabled(false);
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        slideshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slideshow.setEnabled(false);
                slideshow.setBackgroundResource(R.drawable.slideshow2);
                slide.setBackgroundResource(0);
                slide.setImageResource(R.drawable.cars);
                new CountDownTimer(3000, 1){
                    public void onFinish() {
                        slide.setBackgroundResource(0);
                        slide.setImageResource(R.drawable.mcqueen);
                    }
                    public void onTick(long millisUntilFinished){
                        time.setText("Time: " + (4000 - millisUntilFinished) / 1000 + "s");
                    }
                }.start();
                new CountDownTimer(6000, 1){
                    public void onFinish() {
                        slide.setBackgroundResource(0);
                        slide.setImageResource(R.drawable.towmatter);
                    }
                    public void onTick(long millisUntilFinished){
                        time.setText("Time: " + (7000 - millisUntilFinished) / 1000 + "s");
                    }
                }.start();
                new CountDownTimer(9000, 1){
                    public void onFinish() {
                        slide.setBackgroundResource(0);
                        slide.setImageResource(R.drawable.grouppic);
                    }
                    public void onTick(long millisUntilFinished){
                        time.setText("Time: " + (10000 - millisUntilFinished) / 1000 + "s");
                    }
                }.start();
                new CountDownTimer(12000, 1){
                    public void onFinish() {
                        slide.setBackgroundResource(0);
                        slide.setImageResource(R.drawable.yellow);
                    }
                    public void onTick(long millisUntilFinished){
                        time.setText("Time: " + (13000 - millisUntilFinished) / 1000 + "s");
                    }
                }.start();
                new CountDownTimer(15000, 1){
                    public void onFinish() {
                        slide.setBackgroundResource(0);
                        slide.setImageResource(R.drawable.mcqueentruck);
                    }
                    public void onTick(long millisUntilFinished){
                        time.setText("Time: " + (16000 - millisUntilFinished) / 1000 + "s");
                    }
                }.start();
                new CountDownTimer(18000, 1){
                    public void onFinish() {
                        slide.setBackgroundResource(0);
                        slide.setImageResource(R.drawable.mcqueen2);
                    }
                    public void onTick(long millisUntilFinished){
                        time.setText("Time: " + (19000 - millisUntilFinished) / 1000 + "s");
                    }
                }.start();
                new CountDownTimer(21000, 1){
                    public void onFinish() {
                        slide.setBackgroundResource(0);
                        slide.setImageResource(R.drawable.last);
                        slideshow.setEnabled(true);
                        slideshow.setBackgroundResource(R.drawable.slideshow1);
                    }
                    public void onTick(long millisUntilFinished){
                        time.setText("Time: " + (22000 - millisUntilFinished) / 1000 + "s");
                    }
                }.start();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tracks);
        track.setAdapter(adapter);
        track.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
                item = arg0.getSelectedItemPosition();
                play.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        play.setEnabled(false);
                        play.setBackgroundResource(R.drawable.play2);
                        stop.setEnabled(true);
                        stop.setBackgroundResource(R.drawable.stop2);
                        if(item == 0)
                        {
                            play.setEnabled(true);
                            play.setBackgroundResource(R.drawable.play1);
                            stop.setEnabled(false);
                            stop.setBackgroundResource(R.drawable.stop1);
                            Toast.makeText(MainActivity.this, "Please select track.", Toast.LENGTH_SHORT).show();
                        }
                        else if(item == 1)
                        {
                            mp = MediaPlayer.create(MainActivity.this, R.raw.first);
                            mp.start();
                        }
                        else if(item == 2)
                        {
                            mp = MediaPlayer.create(MainActivity.this, R.raw.second);
                            mp.start();
                        }
                        else if(item == 3)
                        {
                            mp = MediaPlayer.create(MainActivity.this, R.raw.third);
                            mp.start();
                        }
                    }
                });
                stop.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        stop.setEnabled(false);
                        stop.setBackgroundResource(R.drawable.stop1);
                        play.setEnabled(true);
                        play.setBackgroundResource(R.drawable.play1);
                        mp.pause();
                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        enable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enable.setEnabled(false);
                enable.setBackgroundResource(R.drawable.enable2);
                disable.setEnabled(true);
                disable.setBackgroundResource(R.drawable.disable2);
                sm.registerListener(MainActivity.this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
                Toast.makeText(MainActivity.this, "Proximity sensor enabled.", Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, "Swipe in air to change picture.", Toast.LENGTH_SHORT).show();
            }
        });
        disable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disable.setEnabled(false);
                disable.setBackgroundResource(R.drawable.disable1);
                enable.setEnabled(true);
                enable.setBackgroundResource(R.drawable.enable1);
                sm.unregisterListener(MainActivity.this);
                Toast.makeText(MainActivity.this, "Proximity sensor disabled.", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void onSensorChanged(SensorEvent event) {


        count = count + 1;
        if(count == 1)
        {
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.cars);
        }
        else if(count == 2)
        {
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.mcqueen);
        }
        else if(count == 3)
        {
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.mcqueen);
        }

        else if(count == 4)
        {
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.towmatter);
        }
        else if(count == 5)
        {
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.towmatter);
        }
        else if(count == 6)
        {
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.grouppic);
        }
        else if(count == 7)
        {
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.grouppic);
        }
        else if(count == 8)
        {
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.yellow);
        }
        else if(count == 9)
        {
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.yellow);
        }
        else if(count == 10)
        {
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.mcqueentruck);
        }
        else if(count == 11)
        {
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.mcqueentruck);
        }
        else if(count == 12)
        {
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.mcqueen2);
        }
        else if(count == 13)
        {
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.last);
        }
        else if(count == 14)
        {
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.last);
        }
        else
        {
            count = 0;
            slide.setBackgroundResource(0);
            slide.setImageResource(R.drawable.cars);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
