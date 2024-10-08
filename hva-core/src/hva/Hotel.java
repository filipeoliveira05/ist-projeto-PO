package hva;

import hva.exceptions.DuplicateAnimalKeyException;
import hva.exceptions.DuplicateEmployeeKeyException;
import hva.exceptions.DuplicateHabitatKeyException;
import hva.exceptions.DuplicateTreeKeyException;
import hva.exceptions.DuplicateVaccineKeyException;
import hva.exceptions.ImportFileException; //SERÁ QUE É PRECISO ESTA AQUI????
import hva.exceptions.NoResponsibilityException;
import hva.exceptions.UnknownSpeciesKeyException;
import hva.exceptions.UnknownVeterinarianKeyException;
import hva.exceptions.UnrecognizedEntryException;
import hva.exceptions.VeterinarianNotAuthorizedException;
import hva.animal.Animal;
import hva.tree.Tree;
import hva.tree.CaducaTree;
import hva.tree.PereneTree;
import hva.util.NaturalTextComparator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

//FIXME import other Java classes
//FIXME import project classes

public class Hotel implements Serializable {
    
    //FIXME define attributes
    //FIXME define constructor(s)
    //FIXME define methods
    
    @Serial
    private static final long serialVersionUID = 202407081733L;

    
    /**
    * Stores the hotel's animals, sorted by their key.
    */
    private final Map<String, Animal> animals = new TreeMap<>(
            new NaturalTextComparator());

    /**
    * Stores the hotel's trees, sorted by their key.
    */
    private final Map<String, Tree> trees = new TreeMap<>(
        new NaturalTextComparator());

    
    
    private boolean dirty = false;





    /**
    * Get whether the hotel has been modified since it was last cleaned. The
    * hotel is cleaned when it is saved to disk.
    *
    * @return the value of the dirty flag
    */
    public boolean isDirty() {
        return this.dirty;
    }

    /**
    * Turn the dirty flag off to indicate the hotel state has been saved.
    */
    public void clean() {
        this.dirty = false;
    }

    /**
    * Turn the dirty flag on to indicate a modification has occurred since last
    * clean-up (i.e. saved).
    */
    private void dirty() {
        this.dirty = true;
    }


    /**
    * Get all animals known to the hotel sorted by their key
    *
    * @return A sorted {@link Collection} of animals
    */
    public Collection<Animal> getAllAnimals() {
        return this.animals.values();
    }


    /**
    * Get all trees known to the hotel, perene or caduca, sorted by their key
    *
    * @return A sorted {@link Collection} of trees
    */
    public Collection<Tree> getAllTrees() {
        return this.trees.values();
    }


    /**
    * Get a animal by its key. Two animals are the same if their keys are the
    * same
    *
    * @param key The key of the animal to get
    * @return The {@link Animal} associated with the given key
    */
    public Animal getAnimal(String key) {
        Animal a = this.animals.get(key);
        return a;
    }


    /**
    * Get a tree by its key. Two trees are the same if their keys are the
    * same
    *
    * @param key The key of the tree to get
    * @return The {@link Tree} associated with the given key
    */
    public Tree getTree(String key) {
        Tree t = this.trees.get(key);
        return t;
    }




    /**
    * Import data from a plain text file.
    *
    * @param textFile The name of the file to be loaded
    * @throws IOException           if any sort of IO error occurs, such as the
    *                               file not existing, or is a directory
    */
    void importFile(String textFile) throws IOException {
        try (BufferedReader s = new BufferedReader(new FileReader(textFile))) {
            String line;
            while ((line = s.readLine()) != null) {
                importFromFields(line.split("\\|"));
            }
        }
    }


    /**
    * Parse and import an entry (line) from a plain text file.
    *
    * @param fields The fields of the entry to import, that were split by the
    *               separator
    */
    private void importFromFields(String[] fields) {
        switch (fields[0]) {
            //case "ESPECIE" -> this.importSpecie(fields);
            //case "ARVORE" -> this.importTree(fields);
            //case "HABITAT" -> this.importHabitat(fields);
            case "ANIMAL" -> this.importAnimal(fields);
            //case "TRATADOR" -> this.importCaretaker(fields);
            //case "VETERINARIO" -> this.importVet(fields);
            //case "VACINA" -> this.importVaccine(fields);
        }
    }




    /**
    * Parse and import an animal entry from a plain text file.
    * <p>
    * A correct animal entry has the following format:
    * {@code ANIMAL|id|name|idSpecies|idHabitat}
    *
    * @param fields The fields of the animal to import, that were split by the
    *               separator
    */
    private void importAnimal(String[] fields) {
        try {
            this.registerAnimal(fields[1], fields[2], fields[3], fields[4]);
        }   catch (DuplicateAnimalKeyException e) {
            
        }
    }


    /**
    * Register a new animal in this hotel, which will be created from the
    * given parameters.
    *
    * @param id      The key of the animal
    * @param name    The name of the animal
    * @param idSpecies The key of the animal's species
    * @param idHabitat The key of the animal's habitat
    * @return The {@link Animal} that was just created
    * @throws DuplicateAnimalKeyException if an animal with the given key
    *                                     already exists
    */
    public Animal registerAnimal(String id, String name, String idSpecies, 
                          String idHabitat) throws DuplicateAnimalKeyException {
        if (this.animals.containsKey(id)) {
            throw new DuplicateAnimalKeyException(id);
        }

        Animal a = new Animal(id, name, idSpecies, idHabitat);
        this.animals.put(id, a);
        this.dirty();
        return a;
    }




    /**
    * Parse and import a tree entry from a plain text file.
    * <p>
    * A correct tree entry has the following format:
    * {@code ÁRVORE|id|name|age|difficulty|type}
    *
    * @param fields The fields of the tree to import, that were split by the
    *               separator
    */
    /*private void importTree(String[] fields) {
        try {
            this.registerTree(fields[1], fields[2], fields[3], fields[4], fields[5]);
        }   catch (DuplicateTreeKeyException e) {
            
        }
    }*/




    /**
    * Register a new tree in this hotel, which will be created from the
    * given parameters.
    *
    * @param id      The key of the tree
    * @param name    The name of the tree
    * @param age     The age of the tree
    * @param difficulty The base cleaning difficulty of the tree
    * @param type    The type of the tree (caduca or perene)
    * @return The {@link Tree} that was just created
    * @throws DuplicateTreeKeyException if a tree with the given key
    *                                     already exists
    */
    public Tree registerTree(String id, String name, int age, int difficulty, String type) throws DuplicateTreeKeyException {
        if (this.trees.containsKey(id)) {
            throw new DuplicateTreeKeyException(id);
        }

        Tree t = null;

        if (type.equals("PERENE")) {
            t = new PereneTree(id, name, age, difficulty, type);
        } else if (type.equals("CADUCA")) {
            t = new CaducaTree(id, name, age, difficulty, type);
        }

        if (t != null) {
            this.trees.put(id, t);
            this.dirty();
        }

        return t;
    }









    /*
     * Read text input file and create domain entities.
     *
     * @param filename name of the text input file
     * @throws ImportFileException
     
    void importFile(String filename) throws ImportFileException {
	/*try {
            // FIXME open import file and create the associated objects
	    // ....
        } catch (IOException | UnrecognizedEntryException e) {
            throw new ImportFileException(filename, e);
        }
    }*/
}