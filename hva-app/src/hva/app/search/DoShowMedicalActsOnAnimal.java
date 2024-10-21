package hva.app.search;

import hva.Hotel;
import hva.animal.Animal;
import hva.vaccine.Vaccination;

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
        String animalId = stringField("idAnimal");
        Animal animal = _receiver.getAnimal(animalId);

        if (animal == null) {
            throw new UnknownAnimalKeyException(animalId);
        }

        List<Vaccination> vaccinations = animal.getVaccinations();

        for (Vaccination vaccination : vaccinations) {
            String vaccinationInfo = "REGISTO-VACINA|"
                                   + vaccination.getIdVaccine() + "|"
                                   + vaccination.getIdVet() + "|"
                                   + vaccination.getIdSpecies();
            _display.addLine(vaccinationInfo);
        }
        

        _display.display();
    }
}