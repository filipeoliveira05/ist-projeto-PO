package hva.state;

import java.io.Serializable;

public class Season implements Serializable{
    private SeasonState _state = new PrimaveraState(this);

    public void setState (SeasonState state) {
        _state = state;
    }

    public SeasonState getState() {
        return _state;
    }


    public void advanceSeason() {
        _state.advanceSeason();
    }

    public int getCurrentSeasonNumber() {
        return _state.getNumSeason();
    }

}