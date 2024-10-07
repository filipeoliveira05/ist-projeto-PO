package hva.app.vaccine;

import hva.Hotel;
import hva.app.exceptions.DuplicateVaccineKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;

import java.text.Normalizer;
import java.text.Normalizer.Form;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoRegisterVaccine extends Command<Hotel> {

    DoRegisterVaccine(Hotel receiver) {
        super(Label.REGISTER_VACCINE, receiver);
    }

    @Override
    protected final void execute() throws CommandException {
        /*
        String vaccineId = Form.requestString(Prompt.vaccineKey());

        // Verifica duplicidade de vacina
        try {
            _receiver.checkDuplicateVaccine(vaccineId);
        } catch (DuplicateVaccineKeyException e) {
            throw e;
        }

        String vaccineName = Form.requestString(Prompt.vaccineName());
        String speciesList = Form.requestString(Prompt.listOfSpeciesKeys());

        try {
            _receiver.registerVaccine(vaccineId, vaccineName, speciesList.split(","));
            _display.popup(Message.vaccineRegistered(vaccineName));
        } catch (UnknownSpeciesKeyException e) {
            throw e;
        }
        */
    }
}
