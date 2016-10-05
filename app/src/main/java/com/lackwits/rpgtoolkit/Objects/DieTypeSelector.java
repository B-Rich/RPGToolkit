package com.lackwits.rpgtoolkit.Objects;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageButton;

import com.lackwits.rpgtoolkit.R;

/**
 * Created by Danny on 21/06/2016.
 */
public class DieTypeSelector extends /*Image*/Button
{
    public int type;
    public String type_string;
    public int next;


    public DieTypeSelector( Context context, AttributeSet attrs )
    {
        super( context, attrs );

        TypedArray ta = context.getTheme().obtainStyledAttributes( attrs, R.styleable.DieTypeSelector, 0, 0);

        try
        {
            next = ta.getResourceId( R.styleable.DieTypeSelector_next, 0 );
            type = ta.getInteger( R.styleable.DieTypeSelector_type, -1 );

            /*if ( type == -1 )
            {
                type_string = ta.getString( R.styleable.DieTypeSelector_type, -1 )
            }*/
        }
        finally
        {
            ta.recycle();
        }
    }
}
