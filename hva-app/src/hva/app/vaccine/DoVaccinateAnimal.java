package hva.app.vaccine;

import hva.Hotel;
import hva.exceptions.UnknownVaccineException;
import hva.exceptions.UnknownVeterinarianException;
import hva.exceptions.UnknownAnimalException;
import hva.exceptions.VeterinarianNotAuthorizedExcept;
import hva.exceptions.InappropriateVaccineException;

import hva.app.exceptions.UnknownVaccineKeyException;
import hva.app.exceptions.UnknownVeterinarianKeyException;
import hva.app.exceptions.UnknownAnimalKeyException;
import hva.app.exceptions.VeterinarianNotAuthorizedException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoVaccinateAnimal extends Command<Hotel> {

    DoVaccinateAnimal(Hotel receiver) {
        super(Label.VACCINATE_ANIMAL, receiver);
        addStringField("idVaccine", Prompt.vaccineKey());
        addStringField("idVet", Prompt.veterinarianKey());
        addStringField("idAnimal", hva.app.animal.Prompt.animalKey());
    }

    @Override
    protected final void execute() throws CommandException {
        try {
            _receiver.vaccinateAnimal(stringField("idVaccine"), stringField("idVet"), stringField("idAnimal"));
        
        } catch (UnknownVaccineException e) {
            throw new UnknownVaccineKeyException(e.getKey());
        
        } catch (UnknownVeterinarianException e) {
            throw new UnknownVeterinarianKeyException(e.getKey());
        
        } catch (UnknownAnimalException e) {
            throw new UnknownAnimalKeyException(e.getKey());
        
        } catch (VeterinarianNotAuthorizedExcept e) {
            throw new VeterinarianNotAuthorizedException(e.getIdVet(), e.getIdSpecies());
        
        } catch (InappropriateVaccineException e) {
            _display.popup(Message.wrongVaccine(e.getIdVaccine(), e.getIdAnimal()));
        }
    }
}