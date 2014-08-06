package org.example.assesment4.models;

public abstract class Animal {
	protected int soundSource;
	protected String name;
	protected String spellName;
	protected String life_average;
	protected String what_eat;
	protected boolean is_domestic;
	protected String orign_zone;
	protected String sleep_day;
	protected int imageSource;

	public Animal(int soundSource, String name, String spellName,
			String life_average, String what_eat, boolean is_domestic,
			String orign_zone, String sleep_day, int imageSource) {
		super();
		this.soundSource = soundSource;
		this.name = name;
		this.spellName = spellName;
		this.life_average = life_average;
		this.what_eat = what_eat;
		this.is_domestic = is_domestic;
		this.orign_zone = orign_zone;
		this.sleep_day = sleep_day;
		this.imageSource = imageSource;
	}

	public int getSoundSource() {
		return soundSource;
	}

	protected void setSoundSource(int soundSource) {
		this.soundSource = soundSource;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public String getSpellName() {
		return spellName;
	}

	protected void setSpellName(String spellName) {
		this.spellName = spellName;
	}

	public String getLife_average() {
		return life_average;
	}

	protected void setLife_average(String life_average) {
		this.life_average = life_average;
	}

	public String getWhat_eat() {
		return what_eat;
	}

	protected void setWhat_eat(String what_eat) {
		this.what_eat = what_eat;
	}

	public boolean isIs_domestic() {
		return is_domestic;
	}

	protected void setIs_domestic(boolean is_domestic) {
		this.is_domestic = is_domestic;
	}

	public String getOrign_zone() {
		return orign_zone;
	}

	protected void setOrign_zone(String orign_zone) {
		this.orign_zone = orign_zone;
	}

	public String getSleep_day() {
		return sleep_day;
	}

	protected void setSleep_day(String sleep_day) {
		this.sleep_day = sleep_day;
	}

	public int getImageSource() {
		return imageSource;
	}

	protected void setImageSource(int imageSource) {
		this.imageSource = imageSource;
	}

}
