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
        Collection<Employee<?>> employees = _receiver.getAllEmployees();
    
        for (Employee<?> employee : employees) {
            String employeeInfo = employee.getType() + "|"
                                + employee.getId() + "|"
                                + employee.getName();
                                
            String responsibilitiesString = employee.getResponsibilitiesAsString();
            
            if (!responsibilitiesString.isEmpty()) {
                employeeInfo += "|" + responsibilitiesString;
            }
    
            _display.addLine(employeeInfo);
        }
    
        _display.display();
    }
}