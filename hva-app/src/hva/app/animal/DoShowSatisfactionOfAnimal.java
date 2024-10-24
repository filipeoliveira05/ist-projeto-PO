package hva.app.animal;

import hva.Hotel;
import hva.animal.Animal;
import hva.satisfaction.SatisfactionStrategy;
import hva.satisfaction.AnimalSatisfactionStrategy;
import hva.exceptions.UnknownAnimalException;

import hva.app.exceptions.UnknownAnimalKeyException;

import java.text.Normalizer.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowSatisfactionOfAnimal extends Command<Hotel> {

    DoShowSatisfactionOfAnimal(Hotel receiver) {
        super(Label.SHOW_SATISFACTION_OF_ANIMAL, receiver);
        addStringField("idAnimal", Prompt.animalKey());
    }

    @Override
    protected final void execute() throws CommandException {
        int satisfaction = 0;
    
        try {
            Animal animal = _receiver.getAnimal(stringField("idAnimal"));

            satisfaction = new AnimalSatisfactionStrategy(_receiver).calculateSatisfaction(stringField("idAnimal"));        
        
        } catch (UnknownAnimalException e) {
            throw new UnknownAnimalKeyException(e.getKey());
        }

        _display.addLine(satisfaction);
        _display.display();
    }
}