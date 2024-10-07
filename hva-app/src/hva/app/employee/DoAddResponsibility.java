package hva.app.employee;

import java.text.Normalizer.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.Hotel;
import hva.exceptions.NoResponsibilityException;

class DoAddResponsibility extends Command<Hotel> {

    DoAddResponsibility(Hotel receiver) {
        super(Label.ADD_RESPONSABILITY, receiver);
    }

    @Override
    protected void execute() throws CommandException{
        /*
        String employeeId = Form.requestString(Prompt.employeeKey());
        String responsibility = Form.requestString(Prompt.responsibilityKey());

        try {
            _receiver.addResponsibilityToEmployee(employeeId, responsibility);
            _display.popup(Message.responsibilityAdded(employeeId, responsibility));
        } catch (NoResponsibilityException e) {
            _display.popup(Message.noResponsibility());
        }
        */
    }
}
