package hva.app.vaccine;

import hva.Hotel;
import hva.exceptions.DuplicateVaccineException;
import hva.exceptions.UnknownSpeciesException;

import hva.app.exceptions.DuplicateVaccineKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;

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
        try {
            _receiver.registerVaccineWithSpecies(
                    stringField("id"),
                    stringField("name"),
                    stringField("species"));
        
        } catch (DuplicateVaccineException e) {
            throw new DuplicateVaccineKeyException(e.getKey());
        
        }  catch (UnknownSpeciesException e) {
            throw new UnknownSpeciesKeyException(e.getKey());
        }
    }
}