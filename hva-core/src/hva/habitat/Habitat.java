package hva.habitat;

import hva.tree.Tree;
import hva.util.NaturalTextComparator;
import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Habitat implements Serializable{
    
    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410081506L;


    private static final Comparator<String> ID_COMPARATOR 
            = new NaturalTextComparator();
    private String id;
    private String name;
    private int area;
    private Map<String, Tree> trees;
    
    
    public Habitat(String id, String name, int area) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.trees = new HashMap<>();
        }


    public void addTree(Tree tree){
        trees.put(tree.getId(), tree);
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
    public int getArea() {
        return area;
    }

    
}
