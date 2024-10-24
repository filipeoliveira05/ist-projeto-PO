package hva.state;

import java.io.Serializable;

public class VeraoState extends SeasonState {

	public VeraoState (Season season) {
		super(season, 1);
	}

	public void advanceSeason() { getSeason().setState(new OutonoState(getSeason())); }
}
