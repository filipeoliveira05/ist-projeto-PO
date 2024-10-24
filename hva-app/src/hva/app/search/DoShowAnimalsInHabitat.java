package hva.app.search;

import hva.Hotel;
import hva.habitat.Habitat;
import hva.animal.Animal;
import hva.exceptions.UnknownHabitatException;

import hva.app.exceptions.UnknownHabitatKeyException;

import java.util.Collection;
import java.util.Collections;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowAnimalsInHabitat extends Command<Hotel> {

    DoShowAnimalsInHabitat(Hotel receiver) {
        super(Label.ANIMALS_IN_HABITAT, receiver);
        addStringField("idHabitat", hva.app.habitat.Prompt.habitatKey());
    }

    @Override
    protected void execute() throws CommandException {
        
        try {
            Collection<Animal> animalsInHabitat = _receiver.getAnimalsInHabitat(stringField("idHabitat"));
            
            if (!animalsInHabitat.isEmpty()) {
                for (Animal animal : animalsInHabitat) {
                    String animalInfo = "ANIMAL|"
                                        + animal.getId() + "|"
                                        + animal.getName() + "|"
                                        + animal.getIdSpecies() + "|"
                                        + animal.getHealthHistory() + "|"
                                        + animal.getIdHabitat();
                    _display.addLine(animalInfo);
                }
            }
            
            _display.display();
        
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(e.getKey());
        }
    }
}