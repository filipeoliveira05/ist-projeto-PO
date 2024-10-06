package hva.app.vaccine;

import hva.Hotel;
import java.text.Normalizer;
import java.text.Normalizer.Form;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoRegisterVaccine extends Command<Hotel> {

    DoRegisterVaccine(Hotel receiver) {
        super(Label.REGISTER_VACCINE, receiver);
	//FIXME add command fields if needed
    }

    @Override
    protected final void execute() throws CommandException {
        //FIXME implement command

        String vaccineName = Form.requestString(Prompt.vaccineName());
        String speciesId = Form.requestString(Prompt.listOfSpeciesKeys());

        _receiver.registerVaccine(vaccineName, speciesId);
    
    }

}
