package org.example.assesment4;

import java.util.ArrayList;
import org.example.assesment4.models.*;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class AnimalsActivity extends Activity {
	ArrayList<Animal> anims;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animals);
		ListView listView = (ListView) findViewById(R.id.listView1);
		anims = new ArrayList<Animal>();
		anims.add(new Dog());
		anims.add(new Sheep());
		anims.add(new Horse());
		anims.add(new Cow());
		anims.add(new Pig());
		listView.setAdapter(new CustomAdapter(anims, this));
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long id) {
				Log.d(this.getClass().getName(), "Item click liestener");
				Intent intent = new Intent(AnimalsActivity.this,
						AnimalDetailsActivity.class);
				intent.putExtra("ANIMAL", anims.get(position).getImageSource());
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.animals, menu);
		return true;
	}

}
