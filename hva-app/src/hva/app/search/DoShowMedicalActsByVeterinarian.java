package hva.app.search;

import hva.Hotel;
import hva.employee.VetEmployee;
import hva.vaccine.Vaccination;
import hva.exceptions.UnknownVeterinarianException;

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

        try {
            List<Vaccination> vaccinations = _receiver.getMedicalActsByVet(stringField("idVet"));
            
            for (Vaccination vaccination : vaccinations) {
                String vaccinationInfo = "REGISTO-VACINA|"
                                       + vaccination.getIdVaccine() + "|"
                                       + vaccination.getIdVet() + "|"
                                       + vaccination.getIdSpecies();
                _display.addLine(vaccinationInfo);
            }
            
            _display.display();
        
        } catch (UnknownVeterinarianException e) {
            throw new UnknownVeterinarianKeyException(e.getKey());
        }
    }
}