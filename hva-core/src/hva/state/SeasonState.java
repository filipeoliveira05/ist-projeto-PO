package hva.state;

import java.io.Serial;
import java.io.Serializable;

public abstract class SeasonState {
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

	public abstract void advanceSeason();
}
