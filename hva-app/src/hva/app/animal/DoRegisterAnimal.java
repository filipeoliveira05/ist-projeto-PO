package hva.app.animal;

import hva.Hotel;
import hva.exceptions.UnknownSpeciesException;
import hva.exceptions.DuplicateSpeciesNameException;
import hva.exceptions.UnknownHabitatException; 

import hva.app.exceptions.DuplicateAnimalKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;

import pt.tecnico.uilib.forms.Form;
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

      } catch (hva.exceptions.DuplicateAnimalKeyException e1) {
          throw new DuplicateAnimalKeyException(e1.getKey());

      } catch (UnknownSpeciesException e2) {
          String speciesName = Form.requestString(Prompt.speciesName());
          
          try {
              _receiver.registerSpecies(stringField("idSpecies"), speciesName);

              try {
                  _receiver.registerAnimal(
                          stringField("id"),
                          stringField("name"),
                          stringField("idSpecies"),
                          stringField("idHabitat")
                  );
              } catch (UnknownSpeciesException e5) {
                  throw new UnknownSpeciesKeyException(e5.getKey());
              } catch (hva.exceptions.DuplicateAnimalKeyException e6) {
                  throw new DuplicateAnimalKeyException(e6.getKey());
              }

          } catch (DuplicateSpeciesNameException e3) {
              e3.printStackTrace();
          } catch (UnknownHabitatException e4) {
              throw new UnknownHabitatKeyException(e4.getKey());
          }

      } catch (UnknownHabitatException e4) {
          throw new UnknownHabitatKeyException(e4.getKey());
      }
  }
}