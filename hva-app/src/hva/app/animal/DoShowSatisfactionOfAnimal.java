package hva.app.animal;

import java.text.Normalizer.Form;

import hva.app.exceptions.UnknownAnimalKeyException;
import hva.exceptions.UnknownAnimalException;


import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoShowSatisfactionOfAnimal extends Command<Hotel> {

    DoShowSatisfactionOfAnimal(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_ANIMAL, receiver);
        //FIXME add command fields if needed
        addStringField("id", Prompt.animalKey());
    }

    @Override
    protected final void execute() throws CommandException {
        //FIXME implement command
        int satisfaction;
        try {
            satisfaction = _receiver.satisfactionAnimal(stringField("id"));
        } 
        catch (UnknownAnimalException e2) {
            throw new UnknownAnimalKeyException(e2.getKey());
        }

        _display.addLine(satisfaction);
        _display.display();
    }
}