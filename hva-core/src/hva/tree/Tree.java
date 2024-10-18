package hva.tree;

import hva.exceptions.DuplicateTreeKeyException;

import java.io.Serial;
import java.io.Serializable;

public abstract class Tree implements Serializable {

    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410081356L;

    private String id;
    private String name;
    private int age;
    private int difficulty;
    
    public Tree(String id, String name, int age, int difficulty) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.difficulty = difficulty;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public abstract String getType();
}