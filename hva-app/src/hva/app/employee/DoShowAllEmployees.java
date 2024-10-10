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
        Collection<Employee> employees = _receiver.getAllEmployees();

        for (Employee employee : employees) {
            if (employee.isCaretaker()) {
                CaretakerEmployee caretaker = (CaretakerEmployee) employee;
                String caretakerInfo = "TRT|"
                                    + caretaker.getId() + "|"
                                    + caretaker.getName();

                String habitatsString = caretaker.getResponsabilitiesHabitatsAsString();
                if (!habitatsString.isEmpty()) {
                    caretakerInfo += "|" + habitatsString;
                }
                _display.addLine(caretakerInfo);
            
            } else if (employee.isVet()) {
                VetEmployee vet = (VetEmployee) employee;
                String vetInfo = "VET|"
                                + vet.getId() + "|"
                                + vet.getName();

                String speciesString = vet.getResponsabilitiesSpeciesAsString();
                if (!speciesString.isEmpty()) {
                    vetInfo += "|" + speciesString;
                }
                _display.addLine(vetInfo);
            }
        }

        _display.display();
    }
}