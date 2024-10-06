package hva.app.employee;

import java.text.Normalizer.Form;

import hva.Hotel;
import hva.app.exceptions.NoResponsibilityException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoRemoveResponsibility extends Command<Hotel> {

    DoRemoveResponsibility(Hotel receiver) {
        super(Label.REMOVE_RESPONSABILITY, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected void execute() throws CommandException {
        //FIXME implement command
        String employeeId = Form.requestString(Prompt.employeeKey());
        String responsibility = Form.requestString(Prompt.responsibilityKey());

        try{
            _receiver.removeResponsibilityFromEmployee(employeeId, responsibility);
            _display.popup(Message.responsibilityRemoved(employeeId, responsibility));
        } catch (NoResponsibilityException e) {
            _display.popup(Message.noResponsibility());
        }

        
    }

}
