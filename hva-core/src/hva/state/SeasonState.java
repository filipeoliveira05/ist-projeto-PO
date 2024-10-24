package hva.state;

import java.io.Serializable;

public abstract class SeasonState implements Serializable {
	private Season _season;
	private int _numSeason;

	public SeasonState(Season season, int numSeason) {
		_season = season;
		_numSeason = numSeason;
	}

	public Season getSeason() {
		return _season;
	}

	public int getNumSeason() {
		return _numSeason;
	}

	public void setSeason (Season season) {
		_season = season;
	}

	public abstract void advanceSeason();
}
