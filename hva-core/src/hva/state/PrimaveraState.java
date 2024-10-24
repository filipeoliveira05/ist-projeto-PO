package hva.state;

import java.io.Serializable;

public class PrimaveraState extends SeasonState {

	public PrimaveraState (Season season) {
		super(season, 0);
	}

	public void advanceSeason() { getSeason().setState(new VeraoState(getSeason())); }
}
