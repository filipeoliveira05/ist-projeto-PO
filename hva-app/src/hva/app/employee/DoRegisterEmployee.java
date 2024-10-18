package hva.app.employee;

import hva.Hotel;

import hva.app.exceptions.DuplicateEmployeeKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

import java.text.Normalizer;

class DoRegisterEmployee extends Command<Hotel> {

    DoRegisterEmployee(Hotel receiver) {
        super(Label.REGISTER_EMPLOYEE, receiver);
        addStringField("id", Prompt.employeeKey());
        addStringField("name", Prompt.employeeName());
        addStringField("type", Prompt.employeeType());
    }

    @Override
    protected void execute() throws CommandException {
        //FIXME VET/TRT únicos inputs válidos
        String type;

        do {
            type = stringField("type").toUpperCase();
        } while (!type.equals("VET") && !type.equals("TRT"));

        try {
            if (type.equals("VET")) {
                _receiver.registerVet(stringField("id"), stringField("name"));
            } else if (type.equals("TRT")) {
                _receiver.registerCaretaker(stringField("id"), stringField("name"));
            }
        } catch (hva.exceptions.DuplicateEmployeeKeyException e) {
            throw new DuplicateEmployeeKeyException(e.getKey());
        }
    }
}
