package com.example.vizz;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Vivz on 10/25/13.
 */
public class FragmentB extends Fragment {
	
	String[] titles = {"Tytył 1","Tytył 4","Tytył 5","Tytył 6","Tytył 7"};
	ListView lista;
	String[] data = {"Nr. 1", "dwa", "trszy", "środa", "opis inny"};
	int[] images = {R.drawable.star, R.drawable.heart, R.drawable.help, R.drawable.lightning, R.drawable.fish};
	Activity activity;
	
	@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    	View view = inflater.inflate(R.layout.fragment_b,container,false);
    	ListView listView = (ListView) view.findViewById(R.id.list);
    	MyListAdapter listAdapter = new MyListAdapter(activity.getApplicationContext(), titles, images, data);
    	listView.setAdapter(listAdapter);
        return view;
    }
}
