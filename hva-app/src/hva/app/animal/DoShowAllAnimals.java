package hva.app.animal;

import java.util.Map;
import java.util.Collection;
import java.util.Collections;

import hva.Hotel;
import hva.animal.Animal;

import pt.tecnico.uilib.menus.Command;


class DoShowAllAnimals extends Command<Hotel> {

    DoShowAllAnimals(Hotel receiver) {
        super(Label.SHOW_ALL_ANIMALS, receiver);
    }

    @Override
    protected final void execute() {
        Collection<Animal> animals = _receiver.getAllAnimals();

        for (Animal animal : animals) {
            String animalInfo = "ANIMAL|"
                                + animal.getId() + "|"
                                + animal.getName() + "|"
                                + animal.getIdSpecies() + "|"
                                + animal.getHealthHistory() + "|"
                                + animal.getIdHabitat();
            _display.addLine(animalInfo);
        }

        _display.display();
    }

}
