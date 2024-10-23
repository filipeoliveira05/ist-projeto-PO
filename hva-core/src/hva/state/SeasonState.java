package hva.state;

import java.io.Serial;
import java.io.Serializable;

public abstract class SeasonState {
	private Season _season;

	public SeasonState(Season season) {
		_season = season;
	}

	public Season getSeason() {
		return _season;
	}

	public abstract void advanceSeason();
}
