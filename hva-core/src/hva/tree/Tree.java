package hva.tree;

import java.io.Serial;
import java.io.Serializable;

public class Tree implements Serializable{
    
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
        return id;
    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    public int getDifficulty() {
        return difficulty;
    }
}   