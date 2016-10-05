package com.lackwits.rpgtoolkit.AppFragments;

import android.app.Fragment;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lackwits.rpgtoolkit.R;

/**
 * Created by Danny on 02/05/2016.
 */
public class FragmentLifeCounter extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_lifecounter, container, false);
    }

    public void onPause()
    {
        if( getActivity() != null )
        {
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
        }

        super.onPause();
    }

    public void onResume()
    {
        if( getActivity() != null )
        {
            getActivity().setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
        }

        super.onResume();
    }

   /* In your Fragment call inside onResume to lock to portrait:

    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    then in onPause to unlock orientation:

    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR);
    OBS! For the sake, use if(getActivity != null) before using this methods.*/
}