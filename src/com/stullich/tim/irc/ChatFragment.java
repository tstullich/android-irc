package com.stullich.tim.irc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Tim Stullich
 *
 */
public class ChatFragment extends Fragment{
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
          Bundle savedInstanceState) {
       // Create a new TextView and set its text to the fragment's section
       // number argument value.
       TextView textView = new TextView(getActivity());
       textView.setGravity(Gravity.CENTER);
       textView.setText("This is a chat view");
       return textView;
    }
}
