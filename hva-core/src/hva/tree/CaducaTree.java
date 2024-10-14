package hva.tree;

import java.io.Serial;

public class CaducaTree extends Tree {
    
    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410081411L;

    public CaducaTree(String id, String name, int age, int difficulty) {
        super(id, name, age, difficulty);
    }

    @Override
    public String getType() {
        return "CADUCA";
    }
}