package hva.app.vaccine;

import java.util.Map;
import java.util.Collection;
import java.util.Collections;

import hva.Hotel;
import hva.vaccine.Vaccine;

import pt.tecnico.uilib.menus.Command;


class DoShowAllVaccines extends Command<Hotel> {

    DoShowAllVaccines(Hotel receiver) {
        super(Label.SHOW_ALL_VACCINES, receiver);
    }

    @Override
    protected void execute() {
        Collection<Vaccine> vaccines = _receiver.getAllVaccines();

        for (Vaccine vaccine : vaccines) {
            String vaccineInfo = "VACINA|"
                                + vaccine.getId() + "|"
                                + vaccine.getName() + "|"
                                + vaccine.getNumberApplications() + "|"
                                + vaccine.getSpeciesIdsAsString();
            _display.addLine(vaccineInfo);

            String speciesString = vaccine.getSpeciesIdsAsString();
            if (!speciesString.isEmpty()) {
                vaccineInfo += "|" + speciesString;
            }
            _display.addLine(vaccineInfo);
        }

        _display.display();
    }
}
