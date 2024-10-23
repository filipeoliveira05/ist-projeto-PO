package hva.state;

import java.io.Serial;
import java.io.Serializable;

public class PrimaveraState extends SeasonState {

	public PrimaveraState (Season season) {
		super(season);
	}

	public void advanceSeason() { getSeason().setState(new VeraoState(getSeason())); }
}
