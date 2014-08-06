package org.example.assesment4;

import java.util.ArrayList;
import org.example.assesment4.models.Animal;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {

	private ArrayList<Animal> animals;
	private Context ctx;
	private LayoutInflater lytInflater;

	public CustomAdapter(ArrayList<Animal> animals, Context c) {
		super();
		this.animals = animals;
		this.ctx = c;
		lytInflater = (LayoutInflater) ctx
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		return animals.size();
	}

	@Override
	public Object getItem(int arg0) {
		return animals.get(arg0);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Create the cell (View) and populate it with
		// an element of the array
		if (convertView == null) {
			convertView = lytInflater.inflate(R.layout.animal_row, parent,
					false);
		}
		ImageView picture = (ImageView) convertView
				.findViewById(R.id.imageView1);
		picture.setImageResource(animals.get(position).getImageSource());
		return convertView;
	}
}
