package hva.app.search;

import hva.Hotel;
import hva.animal.Animal;
import hva.vaccine.Vaccination;
import hva.exceptions.UnknownAnimalException;

import hva.app.exceptions.UnknownAnimalKeyException;

import java.util.List;
import java.util.Collection;
import java.util.Collections;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowMedicalActsOnAnimal extends Command<Hotel> {

    DoShowMedicalActsOnAnimal(Hotel receiver) {
        super(Label.MEDICAL_ACTS_ON_ANIMAL, receiver);
        addStringField("idAnimal", hva.app.animal.Prompt.animalKey());
    }

    @Override
    protected void execute() throws CommandException {
        
        try {
            List<Vaccination> vaccinations = _receiver.getMedicalActsOnAnimal(stringField("idAnimal"));
            
            for (Vaccination vaccination : vaccinations) {
                String vaccinationInfo = "REGISTO-VACINA|"
                                       + vaccination.getIdVaccine() + "|"
                                       + vaccination.getIdVet() + "|"
                                       + vaccination.getIdSpecies();
                _display.addLine(vaccinationInfo);
            }
            
            _display.display();
        
        } catch (UnknownAnimalException e) {
            throw new UnknownAnimalKeyException(e.getKey());
        }
    }
}