package hva.app.vaccine;

import java.util.List;
import java.util.Collection;
import java.util.Collections;

import hva.Hotel;
import hva.vaccine.Vaccination;

import pt.tecnico.uilib.menus.Command;


class DoShowVaccinations extends Command<Hotel> {

    DoShowVaccinations(Hotel receiver) {
        super(Label.SHOW_VACCINATIONS, receiver);
    }

    @Override
    protected void execute() {
        List<Vaccination> vaccinations = _receiver.getAllVaccinations();

        for (Vaccination vaccination : vaccinations) {
            String vaccinationInfo = "REGISTO-VACINA|"
                                   + vaccination.getIdVaccine() + "|"
                                   + vaccination.getIdVet() + "|"
                                   + vaccination.getIdSpecies();

            _display.addLine(vaccinationInfo);
        }

        _display.display();
    }
}
