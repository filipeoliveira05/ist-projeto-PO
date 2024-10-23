package hva.state;

import java.io.Serial;
import java.io.Serializable;

public class VeraoState extends SeasonState {

	public VeraoState (Season season) {
		super(season);
	}

	public void advanceSeason() { getSeason().setState(new OutonoState(getSeason())); }
}
