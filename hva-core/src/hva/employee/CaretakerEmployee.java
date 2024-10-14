package hva.employee;

import hva.habitat.Habitat;
import java.io.Serial;

public class CaretakerEmployee extends Employee<Habitat> {

    /**
     * Serial number for serialization.
     */
    @Serial
    private static final long serialVersionUID = 202410081524L;

    public CaretakerEmployee(String id, String name) {
        super(id, name);
    }

    @Override
    public boolean isCaretaker() {
        return true;
    }

    @Override
    public boolean isVet() {
        return false;
    }

    @Override
    public String getType() {
        return "TRT";
    }
}