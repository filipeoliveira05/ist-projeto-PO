package hva.app.main;

import hva.HotelManager;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoAdvanceSeason extends Command<HotelManager> {
    DoAdvanceSeason(HotelManager receiver) {
        super(Label.ADVANCE_SEASON, receiver);
        // Nenhum campo adicional é necessário neste caso
    }

    @Override
    protected final void execute() {
        // Chama o método para avançar a estação no HotelManager
        _receiver.advanceSeason();
        int seasonNumber = _receiver.getCurrentSeasonNumber();
        _display.addLine(seasonNumber);
        _display.display();
    }
}

