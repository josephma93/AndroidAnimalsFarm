package org.example.assesment4;

import org.example.assesment4.models.*;
import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalDetailsActivity extends Activity {
	private DialogHandler dialogManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animal_details);
		
		Intent intent = getIntent();
		Animal anim = null;
		int value=0;
		String firstLetter;
		ImageView animal_picture = (ImageView) findViewById(R.id.animal_picture);
		TextView first_letter = (TextView) findViewById(R.id.first_letter);
		TextView life_average = (TextView) findViewById(R.id.life_average);
		TextView what_eat = (TextView) findViewById(R.id.what_eat);
		TextView is_domestic = (TextView) findViewById(R.id.is_domestic);
		TextView orign_zone = (TextView) findViewById(R.id.orign_zone);
		TextView sleep_day = (TextView) findViewById(R.id.sleep_day);

		if (intent != null) {
			value = intent.getIntExtra("ANIMAL", 0);
		}
		switch (value) {
		case R.drawable.dog:
			anim = new Dog();
			break;
		case R.drawable.cow:
			anim = new Cow();
			break;
		case R.drawable.horse:
			anim = new Horse();
			break;
		case R.drawable.pig:
			anim = new Pig();
			break;
		case R.drawable.sheep:
			anim = new Sheep();
			break;

		default:
			break;
		}
		this.dialogManager = new DialogHandler(new Dialog(this), anim);
		animal_picture.setImageResource(anim.getImageSource());
		firstLetter = anim.getName().substring(0, 1);
		first_letter.setText(firstLetter);
		life_average.setText(anim.getLife_average());
		what_eat.setText(anim.getWhat_eat());
		if(anim.isIs_domestic()){
			is_domestic.setText("No");
		} else {
			is_domestic.setText("Yes");
		}
		orign_zone.setText(anim.getOrign_zone());
		sleep_day.setText(anim.getSleep_day());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.animal_details, menu);
		return true;
	}
	
	public void goToGame(View v){
		dialogManager.open();
	}

}
