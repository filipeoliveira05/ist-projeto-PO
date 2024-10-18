package hva.habitat;

import hva.tree.Tree;
import hva.animal.Animal;
import hva.employee.Employee;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import java.util.Collection;
import java.util.Collections;

public class Habitat implements Serializable{
    
    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410081506L;

    private String id;
    private String name;
    private int area;
    private Map<String, Tree> trees;
    private Map<String, Animal> animals;
    private Map<String, Employee> employees;
    
    
    public Habitat(String id, String name, int area) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.trees = new HashMap<>();
        this.animals = new HashMap<>();
        this.employees = new HashMap<>();
    }


    /**
    * Adds a new tree to the map of trees in the habitat
    * 
    * @param tree The {@link Tree} object to be added.
    */
    public void addTree(Tree tree){
        trees.put(tree.getId(), tree);
    }


    /**
    * Adds a new animal to the map of animals in the habitat
    * 
    * @param animal The {@link Animal} object to be added.
    */
    public void addAnimal(Animal animal){
        animals.put(animal.getId(), animal);
    }


    /**
    * Adds a new employee to the map of employees in the habitat
    * 
    * @param employee The {@link Employee} object to be added.
    */
    public void addEmployee(Employee employee){
        employees.put(employee.getId(), employee);
    }


    public String getId() {
        return this.id;
    }


    public String getName() {
        return this.name;
    }


    public int getArea() {
        return this.area;
    }

    
    public int getNumberTrees () {
        return this.trees.size();
    }


    public Collection<Tree> getAllTreesInHabitat() {
        Map<String, Tree> sortedTreesInHabitat = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sortedTreesInHabitat.putAll(trees);
        return Collections.unmodifiableCollection(sortedTreesInHabitat.values());
    }   


    /**
    * Updates the area of the habitat.
    * 
    * @param newArea The new area to set for the habitat.
    */
    public void setArea(int newArea) {
        this.area = newArea;
    }

}