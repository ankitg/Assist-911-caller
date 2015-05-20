package com.stmichaelshospital.assist911caller;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

import com.stmichaelshospital.assist911caller.dialpad.DialpadImageButton;
import com.android.dialer.dialpad.DigitsEditText;


public class DialerActivity extends Activity implements View.OnClickListener {

    private static final String FAKE911NUMBER = "9055108606";

    private DialpadImageButton btnOne;
    private DialpadImageButton btnTwo;
    private DialpadImageButton btnThree;
    private DialpadImageButton btnFour;
    private DialpadImageButton btnFive;
    private DialpadImageButton btnSix;
    private DialpadImageButton btnSeven;
    private DialpadImageButton btnEight;
    private DialpadImageButton btnNine;
    private DialpadImageButton btnZero;
    private DialpadImageButton btnStar;
    private DialpadImageButton btnPound;
    private ImageButton btnBackspace;
    private ImageButton btnCall;

    private DigitsEditText etDigits;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer);

        initializeViews();
    }

    private void initializeViews() {
        btnOne = (DialpadImageButton)findViewById(R.id.one);
        btnOne.setOnClickListener(this);
        btnTwo = (DialpadImageButton)findViewById(R.id.two);
        btnTwo.setOnClickListener(this);
        btnThree = (DialpadImageButton)findViewById(R.id.three);
        btnThree.setOnClickListener(this);
        btnFour = (DialpadImageButton)findViewById(R.id.four);
        btnFour.setOnClickListener(this);
        btnFive = (DialpadImageButton)findViewById(R.id.five);
        btnFive.setOnClickListener(this);
        btnSix = (DialpadImageButton)findViewById(R.id.six);
        btnSix.setOnClickListener(this);
        btnSeven = (DialpadImageButton)findViewById(R.id.seven);
        btnSeven.setOnClickListener(this);
        btnEight = (DialpadImageButton)findViewById(R.id.eight);
        btnEight.setOnClickListener(this);
        btnNine = (DialpadImageButton)findViewById(R.id.nine);
        btnNine.setOnClickListener(this);
        btnZero = (DialpadImageButton)findViewById(R.id.zero);
        btnZero.setOnClickListener(this);

        btnStar = (DialpadImageButton)findViewById(R.id.star);
        btnStar.setOnClickListener(this);
        btnPound = (DialpadImageButton)findViewById(R.id.pound);
        btnPound.setOnClickListener(this);
        btnBackspace = (ImageButton)findViewById(R.id.deleteButton);
        btnBackspace.setOnClickListener(this);
        btnCall = (ImageButton)findViewById(R.id.dialButton);
        btnCall.setOnClickListener(this);

        etDigits = (DigitsEditText)findViewById(R.id.digits);
    }

    private void onDial() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + FAKE911NUMBER));
        this.startActivity(intent);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.one:
                etDigits.append("1");
                break;
            case R.id.two:
                etDigits.append("2");
                break;
            case R.id.three:
                etDigits.append("3");
                break;
            case R.id.four:
                etDigits.append("4");
                break;
            case R.id.five:
                etDigits.append("5");
                break;
            case R.id.six:
                etDigits.append("6");
                break;
            case R.id.seven:
                etDigits.append("7");
                break;
            case R.id.eight:
                etDigits.append("8");
                break;
            case R.id.nine:
                etDigits.append("9");
                break;
            case R.id.zero:
                etDigits.append("0");
                break;
            case R.id.deleteButton:
                etDigits.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                break;
            case R.id.star:
                etDigits.append("*");
                break;
            case R.id.pound:
                etDigits.append("#");
                break;
            case R.id.dialButton:
                if(etDigits.getText().toString().equalsIgnoreCase("911")) {
                    onDial();
                } else {
                    // TODO: Reset, you failed.
                }
                break;
        }
    }
}
