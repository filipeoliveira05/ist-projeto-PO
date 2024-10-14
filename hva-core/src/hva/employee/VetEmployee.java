package hva.employee;

import hva.species.Species;
import java.io.Serial;

public class VetEmployee extends Employee<Species> {

    /**
     * Serial number for serialization.
     */
    @Serial
    private static final long serialVersionUID = 202410081525L;

    public VetEmployee(String id, String name) {
        super(id, name);
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