package hva.state;

import java.io.Serializable;

public class InvernoState extends SeasonState {

	public InvernoState (Season season) {
		super(season, 3);
	}

	public void advanceSeason() { getSeason().setState(new PrimaveraState(getSeason())); }
}
