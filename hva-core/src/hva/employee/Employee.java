package hva.employee;

import hva.exceptions.DuplicateEmployeeKeyException;
import hva.exceptions.NoResponsibilityException;

import hva.habitat.Habitat;
import hva.species.Species;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Employee implements Serializable{
    
    /**
    * Serial number for serialization.
    */
    @Serial
    private static final long serialVersionUID = 202410081520L;



    private String id;
    private String name;
    
    
    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }


    //Getter for id
    public String getId() {
        return this.id;
    }

    // Getter for name
    public String getName() {
        return this.name;
    }

    // Método para verificar se é um Caretaker (padrão false, será sobrescrito)
    public boolean isCaretaker() {
        return false;
    }

    // Método para verificar se é um Vet (padrão false, será sobrescrito)
    public boolean isVet() {
        return false;
    }

}   