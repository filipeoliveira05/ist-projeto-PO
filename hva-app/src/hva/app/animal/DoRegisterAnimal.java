package hva.app.animal;

import hva.Hotel;
import hva.app.exceptions.DuplicateAnimalKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;




class DoRegisterAnimal extends Command<Hotel> {

    DoRegisterAnimal(Hotel receiver) {
        super(Label.REGISTER_ANIMAL, receiver);
        addStringField("id", Prompt.animalKey());
        addStringField("name", Prompt.animalName());
        addStringField("idSpecies", Prompt.speciesKey());
        addStringField("idHabitat", Prompt.habitatKey());
    }

    @Override
    protected final void execute() throws CommandException {
        try {
            _receiver.registerAnimal(
                    stringField("id"),
                    stringField("name"),
                    stringField("idSpecies"),
                    stringField("idHabitat")
            );
          } catch (hva.exceptions.DuplicateAnimalKeyException e) {
            throw new DuplicateAnimalKeyException(e.getKey());
          }
    }
}

