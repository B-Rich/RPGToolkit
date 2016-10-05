package com.lackwits.rpgtoolkit.Objects;

import com.lackwits.rpgtoolkit.R;
import android.widget.ImageButton;

import android.content.res.TypedArray;
import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by Danny on 23/06/2016.
 */
public class ArrowButton extends ImageButton
{
    public int mod, ref;

    public ArrowButton( Context context, AttributeSet attrs )
    {
        super( context, attrs );

        TypedArray ta = context.getTheme().obtainStyledAttributes( attrs, R.styleable.ArrowButton, 0, 0);

        try
        {
            mod = ta.getInteger( R.styleable.ArrowButton_mod, 0 );
            ref = ta.getResourceId( R.styleable.ArrowButton_ref, 0 );
        }
        finally
        {
            ta.recycle();
        }
    }
}
