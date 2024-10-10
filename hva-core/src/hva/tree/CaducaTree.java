package hva.tree;

import hva.exceptions.DuplicateTreeKeyException;

import java.io.Serial;

public class CaducaTree extends Tree{

    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410081411L;

    private final String type;
    
    
    public CaducaTree(String id, String name, int age, int difficulty, String type) {
        super(id, name, age, difficulty);
        this.type = type;
    } 
}
