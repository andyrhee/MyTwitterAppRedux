package com.codepath.apps.mytwitterapp;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;

import com.codepath.apps.mytwitterapp.fragments.HomeTimelineFragment;
import com.codepath.apps.mytwitterapp.fragments.MentionsFragment;
import com.codepath.apps.mytwitterapp.fragments.TweetsListFragment;

public class TimelineActivity extends FragmentActivity implements TabListener {
	TweetsListFragment fragmentTweets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        setupNavigatioinTabs();
    }
    
    private void setupNavigatioinTabs() {
    	ActionBar actionBar = getActionBar();
    	actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
    	actionBar.setDisplayShowTitleEnabled(true);
    	Tab tabHome = actionBar.newTab().setText("Home")
    			.setTag("HomeTimelineFragment").setIcon(R.drawable.ic_home)
    			.setTabListener(this);
    	Tab tabMentions = actionBar.newTab().setText("Mentions")
    			.setTag("MentionsTimelineFragment").setIcon(R.drawable.ic_mentions)
    			.setTabListener(this);
    	actionBar.addTab(tabHome);
    	actionBar.addTab(tabMentions);
		actionBar.selectTab(tabHome);
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.timeline, menu);
        return true;
    }

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		FragmentManager manager = getSupportFragmentManager();
		android.support.v4.app.FragmentTransaction fts = manager.beginTransaction();
		if (tab.getTag() == "HomeTimelineFragment") {
			// set the fragment in framelayout to home timeline
			fts.replace(R.id.frame_container, new HomeTimelineFragment());
		} else {
			// set the fragment in framelayout to mentiones timeline
			fts.replace(R.id.frame_container, new MentionsFragment());
		}
		fts.commit();
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		
	}
    
}
