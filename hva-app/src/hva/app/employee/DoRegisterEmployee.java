package hva.app.employee;

import hva.Hotel;
import hva.exceptions.DuplicateEmployeeException;

import hva.app.exceptions.DuplicateEmployeeKeyException;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoRegisterEmployee extends Command<Hotel> {

    DoRegisterEmployee(Hotel receiver) {
        super(Label.REGISTER_EMPLOYEE, receiver);
        addStringField("id", Prompt.employeeKey());
        addStringField("name", Prompt.employeeName());
        addOptionField("type", Prompt.employeeType(), "VET", "TRT");
    }

    @Override
    protected void execute() throws CommandException {
        String typeEmployee = optionField("type");

        try {
            if (typeEmployee.equals("VET")) {
                _receiver.registerVet(stringField("id"), stringField("name"));
            } else if (typeEmployee.equals("TRT")) {
                _receiver.registerCaretaker(stringField("id"), stringField("name"));
            }
        
        } catch (DuplicateEmployeeException e) {
            throw new DuplicateEmployeeKeyException(e.getKey());
        }
    }
}