package hva.app.habitat;

import java.text.Normalizer.Form;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoChangeHabitatInfluence extends Command<Hotel> {

    DoChangeHabitatInfluence(Hotel receiver) {
        super(Label.CHANGE_HABITAT_INFLUENCE, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected void execute() throws CommandException {
        //FIXME implement command

        String habitatId = Form.requestString(Prompt.habitatKey());
        double newInfluence = Form.requestString(Prompt.habitatInfluence());

        _receiver.changeHabitatInfluence(habitatId, newInfluence);
    }

}
