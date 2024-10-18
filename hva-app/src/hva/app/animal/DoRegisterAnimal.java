package hva.app.animal;

import hva.Hotel;
import hva.exceptions.UnknownSpeciesException;
import hva.exceptions.UnknownHabitatException;

import hva.app.exceptions.DuplicateAnimalKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;




class DoRegisterAnimal extends Command<Hotel> {

    DoRegisterAnimal(Hotel receiver) {
        super(Label.REGISTER_ANIMAL, receiver);
        addStringField("id", Prompt.animalKey());
        addStringField("name", Prompt.animalName());
        addStringField("idSpecies", Prompt.speciesKey());
        addStringField("idHabitat", hva.app.habitat.Prompt.habitatKey());
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
          
          } catch (UnknownSpeciesException e1) {
            String speciesName = Prompt.speciesName();
            _receiver.registerSpecies(stringField("idspecies"), speciesName);
            throw new UnknownSpeciesKeyException(e1.getKey());
          
          } catch (UnknownHabitatException e2) {
            throw new UnknownHabitatKeyException(e2.getKey());
        }
    }
}