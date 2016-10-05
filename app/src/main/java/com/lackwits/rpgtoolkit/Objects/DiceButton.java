package com.lackwits.rpgtoolkit.Objects;

import com.lackwits.rpgtoolkit.R;
import android.widget.Button;

import android.content.res.TypedArray;
import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Danny on 02/03/2016.
 */
public class DiceButton extends Button //View //ImageButton
{
    public int pool, type, next;

    public DiceButton( Context context, AttributeSet attrs )
    {
        super( context, attrs );

        TypedArray ta = context.getTheme().obtainStyledAttributes( attrs, R.styleable.DiceButton, 0, 0);

        try
        {
            pool = ta.getInteger( R.styleable.DiceButton_pool, 0 );
            next = ta.getResourceId( R.styleable.DiceButton_next, 0 );
            type = ta.getInteger( R.styleable.DiceButton_type, -1);
        }
        finally
        {
            ta.recycle();
        }

    }
}
