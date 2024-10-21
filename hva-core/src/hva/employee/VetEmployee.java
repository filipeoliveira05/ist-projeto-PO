package hva.employee;

import hva.species.Species;
import hva.vaccine.Vaccination;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import java.io.Serial;

public class VetEmployee extends Employee<Species> {

    /**
     * Serial number for serialization.
     */
    @Serial
    private static final long serialVersionUID = 202410081525L;

    private List<Vaccination> vaccinations;

    public VetEmployee(String id, String name) {
        super(id, name);
        this.vaccinations = new ArrayList<>();
    }


    public void addVaccination(Vaccination vaccination) {
        vaccinations.add(vaccination);
    }


    public List<Vaccination> getVaccinations() {
        return Collections.unmodifiableList(vaccinations);
    }


    @Override
    public boolean isVet() {
        return true;
    }

    @Override
    public boolean isCaretaker() {
        return false;
    }

    @Override
    public String getType() {
        return "VET";
    }
}