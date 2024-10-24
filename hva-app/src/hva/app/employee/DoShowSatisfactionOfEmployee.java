package hva.app.employee;

import hva.Hotel;
import hva.employee.Employee;
import hva.satisfaction.SatisfactionStrategy;
import hva.satisfaction.CaretakerSatisfactionStrategy;
import hva.satisfaction.VetSatisfactionStrategy;
import hva.exceptions.UnknownEmployeeException;

import hva.app.exceptions.UnknownEmployeeKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowSatisfactionOfEmployee extends Command<Hotel> {

    DoShowSatisfactionOfEmployee(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_EMPLOYEE, receiver);
        addStringField("idEmployee", Prompt.employeeKey());
    }

    @Override
    protected void execute() throws CommandException {
        int satisfaction = 0;

        try {
            Employee<?> employee = _receiver.getEmployee(stringField("idEmployee"));

            if (employee.isVet()) {
                satisfaction = new VetSatisfactionStrategy(_receiver).calculateSatisfaction(stringField("idEmployee"));
            
            } else if (employee.isCaretaker()) {
                satisfaction = new CaretakerSatisfactionStrategy(_receiver).calculateSatisfaction(stringField("idEmployee"));
            } 

        } catch (UnknownEmployeeException e) {
            throw new UnknownEmployeeKeyException(e.getKey());
        }

        _display.addLine(satisfaction);
        _display.display();
    }
}