package com.lackwits.rpgtoolkit;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.TableRow;

import com.lackwits.rpgtoolkit.AppFragments.FragmentDDRoller;
import com.lackwits.rpgtoolkit.AppFragments.FragmentDangerRoller;
import com.lackwits.rpgtoolkit.AppFragments.FragmentLifeCounter;
import com.lackwits.rpgtoolkit.AppFragments.FragmentNWoDRoller;
import com.lackwits.rpgtoolkit.Objects.ArrowButton;
import com.lackwits.rpgtoolkit.Objects.DiceButton;
import com.lackwits.rpgtoolkit.Objects.DiceLayout;
import com.lackwits.rpgtoolkit.Objects.DieTypeSelector;
import com.lackwits.rpgtoolkit.Objects.LifeDisplay;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        /*
        AssetManager am = getApplicationContext().getAssets();
        //typeFace = Typeface.createFromAsset( am, String.format(Locale.CANADA, "fonts%s", "chawp.ttf" ) );

        setTypeface( Typeface.createFromAsset( am, String.format(Locale.CANADA, "fonts%s", "chawp.ttf" ) ) );
        */

        //- startActivityForResult(new Intent(MainActivity.this, IntroPlaques.class), 1);
        //startActivityForResult(new Intent(MainActivity.this, DieSetSelector.class), 1);

        setContentView(R.layout.activity_main);

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageButton IBB = (ImageButton) findViewById(R.id.ib_breakout);
        IBB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Snackbar SB = Snackbar.make(view, "Check us out!", Snackbar.LENGTH_LONG).setAction("Action", new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view) {    tellMeBoutSponsor();    }
                });
                SB.show();
            }
        });
        */

        if ( savedInstanceState == null )
        {

            startActivityForResult(new Intent(MainActivity.this, IntroPlaques.class), 1);

            FragmentManager FM = getFragmentManager();
            FragmentTransaction FT = FM.beginTransaction();
            FragmentDDRoller FDD = new FragmentDDRoller();

            FT.replace(R.id.fragment_container, FDD);
            FT.commit();
        }
        else
        {

        }
    }

   /* @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if ( id == R.id.action_dice_set )
        {
            startActivityForResult(new Intent(MainActivity.this, DieSetSelector.class), 1);
        }
        else if ( id == R.id.action_about_us )
        {
            tellMeBoutSponsor();
        }

        return super.onOptionsItemSelected( item );
    }

    public void tellMeBoutSponsor()
    {
        Uri BoC = Uri.parse( "http://lackwits.com/" );//getString( R.string.url_sponsor ) );
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, BoC);
        startActivity(launchBrowser);
    }

    public void DiceButtonPress(View v)
    {
        DiceButton DB = (DiceButton) v;
        int pl = DB.pool;
        Dice roller = new Dice();

        if ( DB.type == -1 )
        {
            //- DiceLayout DL = (DiceLayout) DB.getParent();
            TableRow row = (TableRow) DB.getParent().getParent();
            //-row.setBackgroundColor( getResources().getColor( R.color.DB_Success) );

            DieTypeSelector DTS = (DieTypeSelector) row.getChildAt(0);
            //-DTS.setBackgroundColor( getResources().getColor( R.color.DB_Crit ) );
            //- DTS.rollPool(DB.pool);

            //+ add way to change to fate or starwars dice.

            int[] results = roller.rollPool( pl, DTS.type );

            DB = (DiceButton) findViewById(DTS.next);

            for (int i = 0; i < pl; ++i)
            {
                DB.setText( "" + results[i] );
                //+ highlight crits, fails and success'
                DB.setAlpha(1);
                DB = (DiceButton) findViewById( DB.next );
                //-DB.setBackgroundColor( getResources().getColor( R.color.DB_Default ) );
            }

            while (DB != null)
            {
                DB.setText( "" + '-' );
                DB.setAlpha( 0.25f );
                DB = (DiceButton) findViewById( DB.next );
            }


        }
        else
        {
            DiceLayout DL = (DiceLayout) DB.getParent();
            //-DL.setBackgroundColor( getResources().getColor( R.color.colorWhite ) );

            DB = (DiceButton) DL.getChildAt(0);
            //-DB.setBackgroundColor( getResources().getColor( R.color.colorAccent ) );

            for ( int r = 0; r < pl; ++r )
            {
                DB.setText( "" + roller.rollSingle( DB.type ) );
                DB.setAlpha(1);
                DB = (DiceButton) findViewById( DB.next );
            }

            while (DB != null)
            {
                DB.setText( "" + '-' );
                DB.setAlpha( 0.25f );
                DB = (DiceButton) findViewById( DB.next );
            }
        }
    }

    public void LifeMod(View v)
    {
        ArrowButton AB = (ArrowButton) v;
        LifeDisplay LD = (LifeDisplay) findViewById( AB.ref );
        //+ get closer to red the lower health?
        //LD.setTextColor( getResources().getColor( R.color.DB_Fail ) );
        LD.life +=  AB.mod;
        LD.setText( "" + LD.life );
    }

    public void changeType ( View v )
    {
        DieTypeSelector DT = (DieTypeSelector) v;
        DT.type += 2;
        String text = "D" + DT.type;
        //DT.setBackground();

        switch ( DT.type ) {
            case 4:
                DT.setBackgroundResource( R.mipmap.chalk_d4 );
                break;
            case 6:
                DT.setBackgroundResource( R.mipmap.chalk_d6 );
                break;
            case 8:
                DT.setBackgroundResource( R.mipmap.chalk_d8 );
                break;
            case 10:
                DT.setBackgroundResource( R.mipmap.chalk_d10 );
                break;
            case 12:
                DT.setBackgroundResource( R.mipmap.chalk_d12 );
                break;
            case 14:
                DT.type = 20;
                text = "D20";
                DT.setBackgroundResource( R.mipmap.chalk_d20 );
                break;
            case 22:
                DT.type = 100;
                text = "D%";
                DT.setBackgroundResource( R.mipmap.chalk_square );
                break;
            case 102:
                DT.type = 2;
                text = "D2";
                DT.setBackgroundResource( R.mipmap.circle2 );
                break;
        }

        DiceButton DB = (DiceButton) findViewById( DT.next );

        while (DB != null)
        {
            DB.setText( "" + DT.type );
            DB.setAlpha( 1 );
            DB = (DiceButton) findViewById( DB.next );
        }

        DT.setText( text );
    }

    public void DieSetSelectorPopup(View v)
    {
        startActivityForResult(new Intent(MainActivity.this, DieSetSelector.class), 1);
    }

    @Override
    protected void onActivityResult(int request, int result, Intent data)
    {
        if ( result == RESULT_OK )
        {
            FragmentManager FM = getFragmentManager();
            FragmentTransaction FT = FM.beginTransaction();

            int dt = data.getIntExtra("dieSet", -1);

            if ( dt == R.id.dd_button )
            {
                FragmentDDRoller newFrag = new FragmentDDRoller();
                FT.replace(R.id.fragment_container, newFrag);
            }
            else if ( dt == R.id.nwod_button )
            {
                FragmentNWoDRoller newFrag = new FragmentNWoDRoller();
                FT.replace(R.id.fragment_container, newFrag);
            }
            else if ( dt == R.id.life_button )
            {
                FragmentLifeCounter newFrag = new FragmentLifeCounter();
                FT.replace(R.id.fragment_container, newFrag);
            }
            /*else if ( dt == R.id.danger_button )
            {
                FragmentDangerRoller newFrag = new FragmentDangerRoller();
                FT.replace(R.id.fragment_container, newFrag);
            }*/
            else    {   }

            FT.commit();
        }
        else    {   }
    }
}











