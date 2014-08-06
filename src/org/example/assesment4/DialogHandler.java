package org.example.assesment4;

import org.example.assesment4.models.Animal;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class DialogHandler {
	private Dialog dialog;
	private Animal animal;
	private TTSManager tts;
	private MediaPlayer player;
	private Dialog gameResult;

	public DialogHandler(Dialog dialog, Animal animal) {
		super();
		this.dialog = dialog;
		this.animal = animal;
		this.tts = new TTSManager(dialog.getContext());
		this.gameResult = new Dialog(dialog.getContext());
		// set up
		this.dialog.setContentView(R.layout.animal_dialog);
		this.dialog.setTitle("Time to play!!");
		addEventListeners();
		this.tts.initOrInstallTTS();
	}

	// ======================== Getters and Setters ========================
	public Dialog getDialog() {
		return dialog;
	}

	public void setDialog(Dialog dialog) {
		this.dialog = dialog;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public void open() {
		dialog.show();
	}

	private void validateName() {
		EditText spelledName = (EditText) dialog.findViewById(R.id.spelled_name);
		String nameTyped = spelledName.getText().toString();
		spelledName.setText("");
		int resultSound = 0;
		if (nameTyped.equalsIgnoreCase(animal.getName())) {
			this.gameResult.setContentView(R.layout.win);
			this.gameResult.setTitle("Congratulations!");
			dialog.cancel();
			resultSound = R.raw.clapping_sound;
		} else {
			this.gameResult.setContentView(R.layout.lose);
			this.gameResult.setTitle("Please, try again!");
			resultSound = R.raw.boo_sound;
		}
		player = MediaPlayer.create(dialog.getContext(), resultSound);
		player.start();
		this.gameResult.show();
	}

	private void addEventListeners() {
		dialog.findViewById(R.id.play_sound).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						player = MediaPlayer.create(dialog.getContext(), animal.getSoundSource());
						player.start();
						Log.d("debug", "play sound");
					}
				});
		dialog.findViewById(R.id.spell_it).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						tts.speak(animal.getSpellName());
						Log.d("debug", "spell it");
					}
				});
		dialog.findViewById(R.id.get_score).setOnClickListener(
				new OnClickListener() {
					@Override
					public void onClick(View v) {
						validateName();
						Log.d("debug", "get score");
					}
				});
	}
}
