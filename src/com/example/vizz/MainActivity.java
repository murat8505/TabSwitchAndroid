package com.example.vizz;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements ActionBar.TabListener {

    ViewPager viewPager=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager= (ViewPager) findViewById(R.id.pager);


        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        addTabs(actionBar);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                Log.d("VIVZ","onPageScrolled "+i+" "+v+" "+i2);
            }

            @Override
            public void onPageSelected(int i) {
                actionBar.setSelectedNavigationItem(i);
                Log.d("VIVZ","onPageSelected "+i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if(i==ViewPager.SCROLL_STATE_IDLE)
                Log.d("VIVZ","onPageScrollStateChanged scroll state idle "+i);
                if(i==ViewPager.SCROLL_STATE_DRAGGING)
                    Log.d("VIVZ","onPageScrollStateChanged scroll state dragging "+i);
                if(i==ViewPager.SCROLL_STATE_SETTLING)
                    Log.d("VIVZ","onPageScrollStateChanged scroll state settling "+i);
            }
        });

    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
   
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
        // action with ID action_refresh was selected
        case R.id.action_search:
          Toast.makeText(this, "Search selected", Toast.LENGTH_SHORT)
              .show();
          break;
        // action with ID action_settings was selected
        case R.id.action_settings:
          Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT)
              .show();
          break;
        default:
          break;
        }
    	
    	return true;
    }
    
    private void addTabs(ActionBar actionBar) {
        Tab tab1=actionBar.newTab();
        tab1.setText("Tab 1");
        tab1.setTabListener(this);

        Tab tab2=actionBar.newTab();
        tab2.setText("Tab 2");
        tab2.setTabListener(this);

        Tab tab3=actionBar.newTab();
        tab3.setText("Tab 3");
        tab3.setTabListener(this);

        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
    }
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		viewPager.setCurrentItem(tab.getPosition());
	}
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}
}

class MyAdapter extends FragmentStatePagerAdapter
{

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;
        if(i==0)
        {
            fragment=new FragmentA();
        }
        if(i==1)
        {
            fragment=new FragmentB();
        }
        if(i==2)
        {
            fragment=new FragmentC();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
