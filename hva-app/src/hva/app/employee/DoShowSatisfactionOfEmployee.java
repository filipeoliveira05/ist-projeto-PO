package hva.app.employee;

import hva.Hotel;
import hva.exceptions.UnknownEmployeeException;

import hva.app.exceptions.UnknownEmployeeKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowSatisfactionOfEmployee extends Command<Hotel> {

    DoShowSatisfactionOfEmployee(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_EMPLOYEE, receiver);
        addStringField("id", Prompt.employeeKey());
    }

    @Override
    protected void execute() throws CommandException {
        int satisfaction;
        try {
            satisfaction = _receiver.satisfactionEmployee(stringField("id"));
        
        } catch (UnknownEmployeeException e) {
            throw new UnknownEmployeeKeyException(e.getKey());
        }

        _display.addLine(satisfaction);
        _display.display();
    }
}