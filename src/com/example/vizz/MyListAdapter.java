package com.example.vizz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class MyListAdapter extends ArrayAdapter<String> {
	
	Context context;
	String[] titles;
	String[] descriptions;
	int[] images;
	public MyListAdapter (Context c, String[] titles, int imgs[], String[] desc) {
		super(c, R.layout.single_row, R.id.textView1, titles);
		this.context = c;
		// dane do wyświetlenia
		this.images = imgs;
		this.titles = titles;
		this.descriptions = desc;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		View row = convertView;
		MyViewHolder holder = null;
		
		// uruchamiane tylko za pierwszym wykonaniem
		if(row == null) {
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.single_row, parent, false);
			holder = new MyViewHolder(row);
			row.setTag(holder);
		} else { // recycling
			holder = (MyViewHolder) row.getTag();
			holder.images.setImageResource(images[position]);
			holder.titles.setText(titles[position]);
			holder.descriptions.setText(descriptions[position]);
		}
		return row;
	}
	
	class MyViewHolder {
		public TextView titles;
		public TextView descriptions;
		public ImageView images;
		
		public MyViewHolder(View view) {
			images = (ImageView) view.findViewById(R.id.imageView);
			titles = (TextView) view.findViewById(R.id.textView1);
			descriptions = (TextView) view.findViewById(R.id.textView2);
		}
	}
}
