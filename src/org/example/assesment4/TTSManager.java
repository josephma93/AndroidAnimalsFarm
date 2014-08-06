package org.example.assesment4;

import java.util.Locale;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;

public class TTSManager implements TextToSpeech.OnInitListener {
	private TextToSpeech myTTS;
	private boolean readyToSpeak = false;
	private Context context;

	public TTSManager(Context baseContext) {
		this.context = baseContext;
	}

	public void initOrInstallTTS() {
		myTTS = new TextToSpeech(context, this);
	}

	private void installTTS() {
		Intent installIntent = new Intent();
		installIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		installIntent.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
		context.startActivity(installIntent);
	}

	public void speak(String text) {
		if (readyToSpeak) {
			myTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
		}
	}

	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
			myTTS.setLanguage(Locale.US);
			myTTS.setSpeechRate(Float.valueOf("0.5"));
			readyToSpeak = true;
		} else {
			installTTS();
		}
	}
}