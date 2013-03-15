package com.stullich.tim.irc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends FragmentActivity implements ChatFragment.OnButtonClickedListener{

   /**
    * The {@link android.support.v4.view.PagerAdapter} that will provide
    * fragments for each of the sections. We use a
    * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which will
    * keep every loaded fragment in memory. If this becomes too memory
    * intensive, it may be best to switch to a
    * {@link android.support.v4.app.FragmentStatePagerAdapter}.
    */
   SectionsPagerAdapter mSectionsPagerAdapter;

   /**
    * The {@link ViewPager} that will host the section contents.
    */
   ViewPager mViewPager;
   Fragment fragment;
   private int numPages;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);

      // Create the adapter that will return a fragment for each of the three
      // primary sections of the app.
      mSectionsPagerAdapter = new SectionsPagerAdapter(
            getSupportFragmentManager());

      // Set up the ViewPager with the sections adapter.
      mViewPager = (ViewPager) findViewById(R.id.pager);
      mViewPager.setAdapter(mSectionsPagerAdapter);
      
      numPages = 1;
   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.activity_main, menu);
      return true;
   }

   /**
    * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
    * one of the sections/tabs/pages.
    */
   public class SectionsPagerAdapter extends FragmentPagerAdapter {

      public SectionsPagerAdapter(FragmentManager fm) {
         super(fm);
      }

      @Override
      public Fragment getItem(int position) {
         // getItem is called to instantiate the fragment for the given page.
         // Return a DummySectionFragment (defined as a static inner class
         // below) with the page number as its lone argument.
         fragment = new ChatFragment();
         Bundle args = new Bundle();
         args.putInt("Section", position + 1);
         fragment.setArguments(args);
         return fragment;
      }

      @Override
      public int getCount() {
         // Show total pages.
         return numPages;
      }

      @Override
      public CharSequence getPageTitle(int position) {
         switch (position) {
         case 0:
            return getString(R.string.title_section1).toUpperCase();
         case 1:
            return getString(R.string.title_section2).toUpperCase();
         case 2:
            return getString(R.string.app_name).toUpperCase();
         default :
             return "SECTION" + Integer.valueOf(position);
         }
      }
   }
   
   @Override 
   public void createFragment() {
       Log.i("iRC", "Create Frag");
       numPages++;
       mSectionsPagerAdapter.notifyDataSetChanged();
   }
}
