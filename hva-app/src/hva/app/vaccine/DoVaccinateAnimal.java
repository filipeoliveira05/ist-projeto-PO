package hva.app.vaccine;

import hva.Hotel;
import java.text.Normalizer;
import java.text.Normalizer.Form;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoVaccinateAnimal extends Command<Hotel> {

    DoVaccinateAnimal(Hotel receiver) {
        super(Label.VACCINATE_ANIMAL, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected final void execute() throws CommandException {
        //FIXME implement command
        String veterinarianId = Form.requestString(Prompt.veterinarianKey());
        String animalId = Form.requestString("Insira o identificador do animal a vacinar");


    }

}
