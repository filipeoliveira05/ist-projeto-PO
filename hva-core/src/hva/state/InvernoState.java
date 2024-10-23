package hva.state;

import java.io.Serial;
import java.io.Serializable;

public class InvernoState extends SeasonState {

	public InvernoState (Season season) {
		super(season);
	}

	public void advanceSeason() { getSeason().setState(new PrimaveraState(getSeason())); }
}
