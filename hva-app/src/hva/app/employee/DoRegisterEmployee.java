package hva.app.employee;

import java.text.Normalizer;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.Hotel;
import hva.exceptions.DuplicateEmployeeKeyException;

class DoRegisterEmployee extends Command<Hotel> {

    DoRegisterEmployee(Hotel receiver) {
        super(Label.REGISTER_EMPLOYEE, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        //FIXME implement command
    }
}
