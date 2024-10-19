package hva.app.animal;

import java.text.Normalizer.Form;

import hva.exceptions.UnknownAnimalException;
import hva.exceptions.UnknownHabitatException;

import hva.app.exceptions.UnknownHabitatKeyException;
import hva.app.exceptions.UnknownAnimalKeyException;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoTransferToHabitat extends Command<Hotel> {

    DoTransferToHabitat(Hotel hotel) {
        super(Label.TRANSFER_ANIMAL_TO_HABITAT, hotel);
        //FIXME add command fields if needed
        addStringField("id", Prompt.animalKey());
        addStringField("idHabitat", hva.app.habitat.Prompt.habitatKey());
    }

    @Override
    protected final void execute() throws CommandException {
        //FIXME implement command
        try {
            _receiver.transferAnimal(stringField("id"),stringField("idHabitat"));
        } 
        
            catch (UnknownAnimalException e) {
                throw new UnknownAnimalKeyException(e.getKey());
            } 
            
            catch (UnknownHabitatException e) {
                throw new UnknownHabitatKeyException(e.getKey());
            }
    }

}
