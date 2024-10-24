package hva.state;

import java.io.Serializable;

public class OutonoState extends SeasonState {

	public OutonoState (Season season) {
		super(season, 2);
	}

	public void advanceSeason() { getSeason().setState(new InvernoState(getSeason())); }
}
