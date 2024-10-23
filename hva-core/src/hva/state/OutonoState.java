package hva.state;

import java.io.Serial;
import java.io.Serializable;

public class OutonoState extends SeasonState {

	public OutonoState (Season season) {
		super(season);
	}

	public void advanceSeason() { getSeason().setState(new InvernoState(getSeason())); }
}
