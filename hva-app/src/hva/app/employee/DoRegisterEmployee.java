package hva.app.employee;

import hva.Hotel;

import hva.app.exceptions.DuplicateEmployeeKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;

class DoRegisterEmployee extends Command<Hotel> {

    DoRegisterEmployee(Hotel receiver) {
        super(Label.REGISTER_EMPLOYEE, receiver);
        addStringField("id", Prompt.employeeKey());
        addStringField("name", Prompt.employeeName());
    }

    @Override
    protected void execute() throws CommandException {
        String typeEmployee;
        while (true) {
            typeEmployee = Form.requestString(Prompt.employeeType());
            if (typeEmployee.equals("VET") || typeEmployee.equals("TRT")) {
                break;
            }
        }

        try {
            if (typeEmployee.equals("VET")) {
                _receiver.registerVet(stringField("id"), stringField("name"));
            } else if (typeEmployee.equals("TRT")) {
                _receiver.registerCaretaker(stringField("id"), stringField("name"));
            }
        } catch (hva.exceptions.DuplicateEmployeeKeyException e) {
            throw new DuplicateEmployeeKeyException(e.getKey());
        }
    }
}
