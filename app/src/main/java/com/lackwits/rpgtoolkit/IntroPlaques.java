package com.lackwits.rpgtoolkit;

/**
 * Created by Danny on 16/05/2016.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.os.CountDownTimer;

public class IntroPlaques extends Activity
{
    private int count;
    private ImageView logoBox;
    CountDownTimer CDT = new CountDownTimer(6000, 2000)
    {
        public void onTick(long millisUntilFinished)
        {
            if ( ++count == 2)
            {
                logoBox.setImageResource( R.mipmap.lwlogo );
            }
            else if (count == 1)
            {
                logoBox.setImageResource( R.drawable.d20 );
            }
        }

        public void onFinish() {
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introplaques);

        logoBox = (ImageView)findViewById(R.id.logobox);
        count = 0;

        CDT.start();
    }

    public void Close(View v)
    {
        finish();
    }
}