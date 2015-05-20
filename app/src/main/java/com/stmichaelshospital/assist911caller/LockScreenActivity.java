package com.stmichaelshospital.assist911caller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;


public class LockScreenActivity extends Activity {

    private TextToSpeech mTextToSpeech; // For the audio prompts.
    private Button mEmergencyCallButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_screen);

        initializeViews();
    }

    private void initializeViews() {
        mEmergencyCallButton = (Button)findViewById(R.id.btn_emergency_call_practice_lock_screen);

        mEmergencyCallButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mDialpadIntent = new Intent(LockScreenActivity.this, DialerActivity.class);
                mDialpadIntent.putExtras(getIntent());
                startActivity(mDialpadIntent);
            }
        });
    }
}
