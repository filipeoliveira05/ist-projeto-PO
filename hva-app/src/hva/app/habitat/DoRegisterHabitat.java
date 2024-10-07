package hva.app.habitat;

import java.text.Normalizer.Form;

import hva.Hotel;
import hva.app.exceptions.DuplicateHabitatKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoRegisterHabitat extends Command<Hotel> {

    DoRegisterHabitat(Hotel receiver) {
        super(Label.REGISTER_HABITAT, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        /*
        String habitatId = Form.requestString(Prompt.habitatKey());

        // Verifica duplicidade de habitat
        try {
            _receiver.checkDuplicateHabitat(habitatId);
        } catch (DuplicateHabitatKeyException e) {
            throw e;
        }

        String habitatName = Form.requestString(Prompt.habitatName());
        int habitatArea = Form.requestInteger(Prompt.habitatArea());

        _receiver.registerHabitat(habitatId, habitatName, habitatArea);  // Registra o habitat
        _display.popup(Message.habitatRegistered(habitatName));
        */
    }
}
