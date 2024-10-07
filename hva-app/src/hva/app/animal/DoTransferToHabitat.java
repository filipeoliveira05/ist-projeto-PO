package hva.app.animal;

import java.text.Normalizer.Form;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoTransferToHabitat extends Command<Hotel> {

    DoTransferToHabitat(Hotel hotel) {
        super(Label.TRANSFER_ANIMAL_TO_HABITAT, hotel);
        //FIXME add command fields if needed
    }

    @Override
    protected final void execute() throws CommandException {
        //FIXME implement command
        /*
        //adicionado por mim
        String animalId = Form.requestString(Prompt.animalKey());
        String habitatId = Form.requestString("Insira o identificador do habitat destino"); 

        _receiver.transferAnimal(animalId, habitatId);
        _display.popup(Message.animalTransferred(animalId, habitatId));
        */
    }

}
