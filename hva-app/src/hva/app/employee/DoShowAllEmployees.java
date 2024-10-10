package hva.app.employee;

import java.util.Map;
import java.util.Collection;
import java.util.Collections;

import hva.Hotel;
import hva.employee.Employee;
import hva.employee.CaretakerEmployee;
import hva.employee.VetEmployee;

import pt.tecnico.uilib.menus.Command;


class DoShowAllEmployees extends Command<Hotel> {

    DoShowAllEmployees(Hotel receiver) {
        super(Label.SHOW_ALL_EMPLOYEES, receiver);
    }

    @Override
    protected void execute() {
        Collection<CaretakerEmployee> caretakerEmployees = _receiver.getAllCaretakers();

        for (CaretakerEmployee caretaker : caretakerEmployees) {
            String caretakerInfo = "TRT|"
                                + caretaker.getId() + "|"
                                + caretaker.getName();
            
            String habitatsString = caretaker.getResponsabilitiesHabitatsAsString();
            if (!habitatsString.isEmpty()) {
                caretakerInfo += "|" + habitatsString;
            }
            _display.addLine(caretakerInfo);
        }

        

        Collection<VetEmployee> vetEmployees = _receiver.getAllVets();

        for (VetEmployee vet : vetEmployees) {
            String vetInfo = "VET|"
                                + vet.getId() + "|"
                                + vet.getName();
            
            String speciesString = vet.getResponsabilitiesSpeciesAsString();
            if (!speciesString.isEmpty()) {
                vetInfo += "|" + speciesString;
            }
            _display.addLine(vetInfo);
        }

        _display.display();
    }

}
