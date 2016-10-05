package com.lackwits.rpgtoolkit.Objects;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Danny on 26/06/2016.
 */
public class LifeDisplay extends TextView
{
    public int life;

    public LifeDisplay( Context context, AttributeSet attrs )
    {
        super( context, attrs );
        life = 20;
    }
}
