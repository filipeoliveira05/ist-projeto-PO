package hva.app.search;

import java.util.List;
import java.util.Collection;
import java.util.Collections;

import hva.Hotel;
import hva.vaccine.Vaccination;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoShowWrongVaccinations extends Command<Hotel> {

    DoShowWrongVaccinations(Hotel receiver) {
        super(Label.WRONG_VACCINATIONS, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        List<Vaccination> vaccinations = _receiver.getAllVaccinations();

        for (Vaccination vaccination : vaccinations) {
            if ("wrong".equals(vaccination.isRightOrWrong())) {
                String vaccinationInfo = "REGISTO-VACINA|"
                                       + vaccination.getIdVaccine() + "|"
                                       + vaccination.getIdVet() + "|"
                                       + vaccination.getIdSpecies();

                _display.addLine(vaccinationInfo);
            }
        }

        _display.display();
    }
}