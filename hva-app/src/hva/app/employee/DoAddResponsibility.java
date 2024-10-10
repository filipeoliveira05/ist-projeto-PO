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
        //FIXME implement command
    }
}
