package com.lackwits.rpgtoolkit.AppFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lackwits.rpgtoolkit.R;

/**
 * Created by Danny on 02/05/2016.
 */
public class FragmentDangerRoller extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_danger_patrol, container, false);
    }
}