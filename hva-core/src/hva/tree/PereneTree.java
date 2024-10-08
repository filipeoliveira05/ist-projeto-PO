package hva.tree;

import hva.exceptions.DuplicateTreeKeyException;

import java.io.Serial;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class PereneTree extends Tree {

    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410081403L;

    private final String type;
    
    public PereneTree(String id, String name, int age, int difficulty, String type) {
        super(id, name, age, difficulty);
        this.type = type;
    }

}
