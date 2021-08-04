package com.example.texttoaudio;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.Locale;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etext;
    Button btn;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etext = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(this);
        textToSpeech = new TextToSpeech(getBaseContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                // if No error is found then only it will run
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                    Toast.makeText(getBaseContext(), "SUCCESS", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    // Adding OnClickListener
    @Override
    public void onClick(View v) {
        String text = etext.getText().toString();
        textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
}

