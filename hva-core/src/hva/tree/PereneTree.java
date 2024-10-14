package hva.tree;

import java.io.Serial;

public class PereneTree extends Tree {

    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410081403L;

    public PereneTree(String id, String name, int age, int difficulty) {
        super(id, name, age, difficulty);
    }

    @Override
    public String getType() {
        return "PERENE";
    }
}