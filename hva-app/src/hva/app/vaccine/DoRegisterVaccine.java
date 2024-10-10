package hva.app.vaccine;

import hva.Hotel;
import hva.app.exceptions.DuplicateVaccineKeyException;
import hva.vaccine.Vaccine;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoRegisterVaccine extends Command<Hotel> {

    DoRegisterVaccine(Hotel receiver) {
        super(Label.REGISTER_VACCINE, receiver);
        addStringField("id", Prompt.vaccineKey());
        addStringField("name", Prompt.vaccineName());
        addStringField("species", Prompt.listOfSpeciesKeys());
    }

    @Override
    protected void execute() throws CommandException {
        //FIXME implement command
        try {
            _receiver.registerVaccine(
                    stringField("id"),
                    stringField("name"));
            //_receiver.addMultipleSpecies(stringField("id"), stringField("species"));
          } catch (hva.exceptions.DuplicateVaccineKeyException e) {
            throw new DuplicateVaccineKeyException(e.getKey());
          }
        
    }
}
