package hva.app.animal;

import java.text.Normalizer.Form;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoShowSatisfactionOfAnimal extends Command<Hotel> {

    DoShowSatisfactionOfAnimal(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_ANIMAL, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected final void execute() throws CommandException {
        //FIXME implement command

        /*
        //adicionado por mim

        String animalId = Form.requestString(Prompt.animalKey());
        int satisfaction = _receiver.getAnimalSatisfaction(animalId, satisfaction);

        _display.popup(Message.animalSatisfaction(animalId, satisfaction));
        */
    }

}
