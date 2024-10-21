package hva.app.search;

import hva.Hotel;
import hva.employee.VetEmployee;
import hva.vaccine.Vaccination;

import hva.app.exceptions.UnknownVeterinarianKeyException;

import java.util.List;
import java.util.Collection;
import java.util.Collections;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoShowMedicalActsByVeterinarian extends Command<Hotel> {

    DoShowMedicalActsByVeterinarian(Hotel receiver) {
        super(Label.MEDICAL_ACTS_BY_VET, receiver);
        addStringField("idVet", hva.app.employee.Prompt.employeeKey());
    }

    @Override
    protected void execute() throws CommandException {
        String vetId = stringField("idVet");
        VetEmployee vet = _receiver.getVet(vetId);

        if (vet == null || !vet.isVet()) {
            throw new UnknownVeterinarianKeyException(vetId);
        }

        List<Vaccination> vaccinations = vet.getVaccinations();

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