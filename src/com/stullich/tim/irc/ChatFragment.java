package com.stullich.tim.irc;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Tim Stullich
 *
 */
public class ChatFragment extends Fragment implements OnClickListener{
    
    private Button button;
    private TextView text;
    private int clickCount; 
    private OnButtonClickedListener listener;
    
    public ChatFragment() {
        
    }
    
    public interface OnButtonClickedListener {
        public void createFragment();
    }
    
    @Override
    public void onAttach(Activity activity) {
      super.onAttach(activity);
      if (activity instanceof OnButtonClickedListener) {
        listener = (OnButtonClickedListener) activity;
      } else {
        throw new ClassCastException(activity.toString()
            + " must implemenet ChatFragment.OnButtonClickedListener");
      }
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
          Bundle savedInstanceState) {
       // Create a new TextView and set its text to the fragment's section
       // number argument value.
       //TextView textView = new TextView(getActivity());
       //textView.setGravity(Gravity.CENTER);
       //textView.setText("This is a chat view");
       View v = inflater.inflate(R.layout.chat_fragment, container, false);
       
       button = (Button) v.findViewById(R.id.button);
       button.setOnClickListener(this);
       text = (TextView) v.findViewById(R.id.text_view);
       clickCount = 0;
       
       return v;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button : 
                listener.createFragment();
                setText();
        } 
    }
    
    private void setText() {
        text.setText("Times Clicked: " + clickCount);
        clickCount++;
        
    }
}
