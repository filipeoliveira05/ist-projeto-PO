package hva.app.employee;

import java.text.Normalizer.Form;

import hva.app.exceptions.UnknownEmployeeKeyException;
import hva.exceptions.UnknownEmployeeException;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoShowSatisfactionOfEmployee extends Command<Hotel> {

    DoShowSatisfactionOfEmployee(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_EMPLOYEE, receiver);
        //FIXME add command fields if needed
        addStringField("id", Prompt.employeeKey());
    }

    @Override
    protected void execute() throws CommandException {
        //FIXME implement command
        int satisfaction;
        try {
            satisfaction = _receiver.satisfactionEmployee(stringField("id"));
        } 
        catch (UnknownEmployeeException e2) {
            throw new UnknownEmployeeKeyException(e2.getKey());
        }

        _display.addLine(satisfaction);
        _display.display();
    }
}
