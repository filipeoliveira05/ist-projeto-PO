package hva.app.animal;

import hva.Hotel;
import hva.exceptions.UnknownAnimalException;

import hva.app.exceptions.UnknownAnimalKeyException;

import java.text.Normalizer.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowSatisfactionOfAnimal extends Command<Hotel> {

    DoShowSatisfactionOfAnimal(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_ANIMAL, receiver);
        addStringField("id", Prompt.animalKey());
    }

    @Override
    protected final void execute() throws CommandException {
        int satisfaction;
        try {
            satisfaction = _receiver.satisfactionAnimal(stringField("id"));
        
        } catch (UnknownAnimalException e2) {
            throw new UnknownAnimalKeyException(e2.getKey());
        }

        _display.addLine(satisfaction);
        _display.display();
    }
}