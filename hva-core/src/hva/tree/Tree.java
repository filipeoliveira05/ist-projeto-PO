package hva.tree;

import hva.util.NaturalTextComparator;
import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;

public class Tree implements Serializable{
    
    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410081356L;


    private static final Comparator<String> ID_COMPARATOR 
            = new NaturalTextComparator();
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

    //Getter for id
    public String getId() {
        return id;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for age
    public int getAge() {
        return age;
    }

    // Getter for difficulty
    public int getDifficulty() {
        return difficulty;
    }

    


}   