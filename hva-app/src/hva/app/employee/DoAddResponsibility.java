package hva.app.employee;

import java.text.Normalizer.Form;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoAddResponsibility extends Command<Hotel> {

    DoAddResponsibility(Hotel receiver) {
        super(Label.ADD_RESPONSABILITY, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected void execute() throws CommandException {
        //FIXME implement command

        String employeeId = Form.requestString(Prompt.employeeKey());
        String responsibility = Form.requestString(Prompt.responsibilityKey());  

        _receiver.addResponsabilityToEmployee(employeeId, responsibility);
        
    }

}
