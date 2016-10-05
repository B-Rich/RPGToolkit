package com.lackwits.rpgtoolkit;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

public class DieSetSelector extends Activity
{
    Intent returnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        returnIntent = new Intent(/*DieSetSelector.this, MainActivity.class*/);

        setContentView(R.layout.activity_diesetselector);

        DisplayMetrics DM = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(DM);

        int width = DM.widthPixels;
        int height = DM.heightPixels;

        getWindow().setLayout((int) (width * 0.8), (int) (height *0.8) );
    }

    @Override
    protected void onDestroy()
    {
        if( !returnIntent.hasExtra("dieSet") )
        {
            setResult(Activity.RESULT_CANCELED, returnIntent);
        }

        super.onDestroy();
    }

    public void SwapTo( View v)
    {
        returnIntent.putExtra( "dieSet", v.getId());
        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}

