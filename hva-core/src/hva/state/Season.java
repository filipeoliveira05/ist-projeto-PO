package hva.state;

import java.io.Serial;
import java.io.Serializable;

public class Season implements Serializable{
    private SeasonState _state = new PrimaveraState(this);

    public void setState (SeasonState state) {
        _state = state;
    }

    public void advanceSeason() {
        _state.advanceSeason();
    }

    // Método para obter o número da estação atual
    public int getCurrentSeasonNumber() {
        return _state.getNumSeason();
    }

}
