package hva;

import hva.exceptions.UnknownSpeciesKeyException;
import hva.exceptions.DuplicateVaccineKeyException;
import hva.exceptions.DuplicateAnimalKeyException;
import hva.exceptions.DuplicateHabitatKeyException;
import hva.exceptions.DuplicateTreeKeyException;
import hva.exceptions.DuplicateEmployeeKeyException;
import hva.exceptions.ImportFileException;
import hva.vaccine.Vaccine;
import hva.species.Species;
import hva.animal.Animal;
import hva.habitat.Habitat;
import hva.tree.CaducaTree;
import hva.tree.PereneTree;
import hva.tree.Tree;
import hva.employee.Employee;
import hva.employee.CaretakerEmployee;
import hva.employee.VetEmployee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;


public class Hotel implements Serializable {
    
    @Serial
    private static final long serialVersionUID = 202407081733L;

    /**
    * Stores the hotel's vaccines, sorted by their key.
    */
    private Map<String, Vaccine> _vaccines = new HashMap<>();

    /**
    * Stores the hotel's species, sorted by their key.
    */
    private Map<String, Species> _species = new HashMap<>();

    /**
    * Stores the hotel's animals, sorted by their key.
    */
    private Map<String, Animal> _animals = new HashMap<>();

    /**
    * Stores the hotel's trees, sorted by their key.
    */
    private Map<String, Tree> _trees = new HashMap<>();

    /**
    * Stores the hotel's habitats, sorted by their key.
    */
    private Map<String, Habitat> _habitats = new HashMap<>();

    /**
    * Stores the hotel's employees, sorted by their key.
    */
    private Map<String, Employee> _employees = new HashMap<>();

    /**
    * Stores the hotel's veterinarians, sorted by their key.
    */
    private Map<String, VetEmployee> _vets = new HashMap<>();

    /**
    * Stores the hotel's caretakers, sorted by their key.
    */
    private Map<String, CaretakerEmployee> _caretakers = new HashMap<>();


    
    /**
    * Whether the hotel is in a dirty state, that is, if it was modified
    * since the last time it was saved (or created).
    */
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
    * Get all species known to the hotel sorted by their key
    *
    * @return A sorted {@link Collection} of species
    */
    public Collection<Species> getAllSpecies() {
        Map<String, Species> sortedSpecies = new TreeMap<> (_species);
        return Collections.unmodifiableCollection(sortedSpecies.values());
    }



    /**
    * Get all vaccines known to the hotel sorted by their key
    *
    * @return A sorted {@link Collection} of vaccines
    */
    public Collection<Vaccine> getAllVaccines() {
        Map<String, Vaccine> sortedVaccines = new TreeMap<> (_vaccines);
        return Collections.unmodifiableCollection(sortedVaccines.values());
    }


    /**
    * Get all animals known to the hotel sorted by their key
    *
    * @return A sorted {@link Collection} of animals
    */
    public Collection<Animal> getAllAnimals() {
        Map<String, Animal> sortedAnimals = new TreeMap<> (_animals);
        return Collections.unmodifiableCollection(sortedAnimals.values());
    }


    /**
    * Get all trees known to the hotel, perene or caduca, sorted by their key
    *
    * @return A sorted {@link Collection} of trees
    */
    public Collection<Tree> getAllTrees() {
        Map<String, Tree> sortedTrees = new TreeMap<> (_trees);
        return Collections.unmodifiableCollection(sortedTrees.values());
    }



    /**
    * Get all habitats known to the hotel sorted by their key
    *
    * @return A sorted {@link Collection} of habitats
    */
    public Collection<Habitat> getAllHabitats() {
        Map<String, Habitat> sortedHabitats = new TreeMap<> (_habitats);
        return Collections.unmodifiableCollection(sortedHabitats.values());
    }


    /**
    * Get all employees known to the hotel sorted by their key
    *
    * @return A sorted {@link Collection} of employees
    */
    public Collection<Employee> getAllEmployees() {
        Map<String, Employee> sortedEmployees = new TreeMap<> (_employees);
        return Collections.unmodifiableCollection(sortedEmployees.values());
    }


    /**
    * Get all veterinarians known to the hotel sorted by their key
    *
    * @return A sorted {@link Collection} of veterinarians
    */
    public Collection<VetEmployee> getAllVets() {
        Map<String, VetEmployee> sortedVets = new TreeMap<> (_vets);
        return Collections.unmodifiableCollection(sortedVets.values());
    }


    /**
    * Get all caretakers known to the hotel sorted by their key
    *
    * @return A sorted {@link Collection} of caretakers
    */
    public Collection<CaretakerEmployee> getAllCaretakers() {
        Map<String, CaretakerEmployee> sortedCaretakers = new TreeMap<> (_caretakers);
        return Collections.unmodifiableCollection(sortedCaretakers.values());
    }


    /**
    * Get a species by its key. Two species are the same if their keys are the
    * same
    *
    * @param key The key of the species to get
    * @return The {@link Species} associated with the given key
    */
    public Species getSpecies(String key) {
        Species s = this._species.get(key);
        return s;
    }
    

    /**
    * Get a vaccine by its key. Two vaccines are the same if their keys are the
    * same
    *
    * @param key The key of the vaccine to get
    * @return The {@link Vaccine} associated with the given key
    */
    public Vaccine getVaccine(String key) {
        Vaccine v = this._vaccines.get(key);
        return v;
    }
    
    
    /**
    * Get a animal by its key. Two animals are the same if their keys are the
    * same
    *
    * @param key The key of the animal to get
    * @return The {@link Animal} associated with the given key
    */
    public Animal getAnimal(String key) {
        Animal a = this._animals.get(key);
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
        Tree t = this._trees.get(key);
        return t;
    }


    /**
    * Get a habitat by its key. Two habitats are the same if their keys are the
    * same
    *
    * @param key The key of the habitat to get
    * @return The {@link Habitat} associated with the given key
    */
    public Habitat getHabitat(String key) {
        Habitat h = this._habitats.get(key);
        return h;
    }


    /**
    * Get a veterinarian by its key. Two veterinarians are the same if their keys are the
    * same
    *
    * @param key The key of the veterinarian to get
    * @return The {@link VetEmployee} associated with the given key
    */
    public VetEmployee getVet(String key) {
        VetEmployee v = this._vets.get(key);
        return v;
    }


    /**
    * Get a caretaker by its key. Two caretakers are the same if their keys are the
    * same
    *
    * @param key The key of the caretaker to get
    * @return The {@link CaretakerEmployee} associated with the given key
    */
    public CaretakerEmployee getCaretaker(String key) {
        CaretakerEmployee c = this._caretakers.get(key);
        return c;
    }




    /**
    * Import data from a plain text file.
    *
    * @param textFile The name of the file to be loaded
    * @throws ImportFileException
    */
    public void importFile(String textFile) throws ImportFileException {
        try (BufferedReader s = new BufferedReader(new FileReader(textFile))) {
            String line;
            while ((line = s.readLine()) != null) {
                importFromFields(line.split("\\|"));
            }
        }   catch (IOException e) {
            throw new ImportFileException(textFile);
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
            case "ESPECIE" -> this.importSpecies(fields);
            case "ARVORE" -> this.importTree(fields);
            case "HABITAT" -> this.importHabitat(fields);
            case "ANIMAL" -> this.importAnimal(fields);
            case "TRATADOR" -> this.importCaretaker(fields);
            case "VETERINARIO" -> this.importVet(fields);
            case "VACINA" -> this.importVaccine(fields);
        }
    }



    /**
    * Parse and import a species entry from a plain text file.
    *
    * A correct species entry has the following format:
    * {@code ESPECIE|id|name}
    *
    * @param fields The fields of the SPECIES to import, that were split by the
    *               separator
    */
    private void importSpecies(String[] fields) {
        this.registerSpecies(fields[1], fields[2]);
    }


    /**
    * Register a new species in this hotel, which will be created from the
    * given parameters.
    *
    * @param id      The key of the species
    * @param name    The name of the species
    * @return The {@link Species} that was just created
    */
    public Species registerSpecies(String id, String name) {
        Species s = new Species(id, name);
        this._species.put(id, s);
        this.dirty();
        return s;
    }




    /**
    * Parse and import a vaccine entry from a plain text file.
    *
    * A correct vaccine entry has the following format:
    * {@code VACINA|id|name|idSpecies1,...,idSpeciesN}
    *
    * @param fields The fields of the vaccine to import, that were split by the
    *               separator
    */
    private void importVaccine(String[] fields) {
        try {
            this.registerVaccine(fields[1], fields[2]);
        }   catch (DuplicateVaccineKeyException e) {
            e.printStackTrace();
        }
        
        Vaccine v = getVaccine(fields[1]);
        if (fields.length > 3) {
            String[] speciesIds = fields[3].split(",");
            for (String speciesId : speciesIds) {
                Species s = getSpecies(speciesId);
                if (s != null) {
                v.addSpecies(s);
                }
            }
        }

    }


    /**
    * Register a new vaccine in this hotel, which will be created from the
    * given parameters.
    *
    * @param id      The key of the vaccine
    * @param name    The name of the vaccine
    * @return The {@link Vaccine} that was just created
    * @throws DuplicateVaccineKeyException if a vaccine with the given key
    *                                     already exists
    */
    public Vaccine registerVaccine(String id, String name) 
                                   throws DuplicateVaccineKeyException {
        if (this._vaccines.containsKey(id)) {
            throw new DuplicateVaccineKeyException(id);
        }

        Vaccine v = new Vaccine(id, name);
        this._vaccines.put(id, v);
        this.dirty();
        return v;
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
            e.printStackTrace();
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
        if (this._animals.containsKey(id)) {
            throw new DuplicateAnimalKeyException(id);
        }

        Animal a = new Animal(id, name, idSpecies, idHabitat);
        this._animals.put(id, a);
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
    private void importTree(String[] fields) {
        try {
            this.registerTree(fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), fields[5]);
        }   catch (DuplicateTreeKeyException e) {
            e.printStackTrace();
        }
    }


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
        if (this._trees.containsKey(id)) {
            throw new DuplicateTreeKeyException(id);
        }

        Tree t = null;

        if (type.equals("PERENE")) {
            t = new PereneTree(id, name, age, difficulty, type);
        } else if (type.equals("CADUCA")) {
            t = new CaducaTree(id, name, age, difficulty, type);
        }

        if (t != null) {
            this._trees.put(id, t);
            this.dirty();
        }

        return t;
    }




    /**
    * Parse and import a habitat entry from a plain text file.
    * <p>
    * A correct habitat entry has the following format:
    * {@code ANIMAL|id|name|area|idTree1,...,idTreeN}
    *
    * @param fields The fields of the habitat to import, that were split by the
    *               separator
    */
    private void importHabitat(String[] fields) {
        try {
            this.registerHabitat(fields[1], fields[2], Integer.parseInt(fields[3]));
        }   catch (DuplicateHabitatKeyException e) {
            e.printStackTrace();
        }
        
        Habitat h = getHabitat(fields[1]);
        if (fields.length > 4) {
            // O campo 4 contém os IDs das árvores, separados por vírgula
            String[] treeIds = fields[4].split(",");
            for (String treeId : treeIds) {
                Tree t = getTree(treeId);
                h.addTree(t);
            }
        }     

    }


    /**
    * Register a new habitat in this hotel, which will be created from the
    * given parameters.
    *
    * @param id      The key of the habitat
    * @param name    The name of the habitat
    * @param area    The area of the habitats's species
    * @return The {@link Habitat} that was just created
    * @throws DuplicateHabitatKeyException if a habitat with the given key
    *                                     already exists
    */
    public Habitat registerHabitat(String id, String name, int area) 
                                   throws DuplicateHabitatKeyException {
        if (this._habitats.containsKey(id)) {
            throw new DuplicateHabitatKeyException(id);
        }

        Habitat h = new Habitat(id, name, area);
        this._habitats.put(id, h);
        this.dirty();
        return h;
    }




    /**
    * Parse and import a caretaker entry from a plain text file.
    *
    * A correct caretaker entry has the following format:
    * {@code TRATADOR|id|name|idHabitat1,...,idHabitatN}
    *
    * @param fields The fields of the caretaker to import, that were split by 
    *               the separator
    */
    private void importCaretaker(String[] fields) {
        try {
            this.registerCaretaker(fields[1], fields[2]);
        }   catch (DuplicateEmployeeKeyException e) {
            e.printStackTrace();
        }
        
        CaretakerEmployee c = getCaretaker(fields[1]);
        if (fields.length > 3) {
            String[] habitatIds = fields[3].split(",");
            for (String habitatId : habitatIds) {
                Habitat h = getHabitat(habitatId);
                c.addHabitat(h);
            }
        }  
    }


    /**
    * Register a new caretaker in this hotel, which will be created from the
    * given parameters.
    *
    * @param id      The key of the caretaker
    * @param name    The name of the caretaker
    * @return The {@link CaretakerEmployee} that was just created
    * @throws DuplicateEmployeeKeyException if a caretaker with the given key
    *                                       already exists
    */
    public CaretakerEmployee registerCaretaker(String id, String name) 
                                   throws DuplicateEmployeeKeyException {
        if (this._caretakers.containsKey(id)) {
            throw new DuplicateEmployeeKeyException(id);
        }

        CaretakerEmployee c = new CaretakerEmployee(id, name);
        this._caretakers.put(id, c);
        this._employees.put(id, c);
        this.dirty();
        return c;
    }


    
    /**
    * Parse and import a veterinarian entry from a plain text file.
    *
    * A correct veterinarian entry has the following format:
    * {@code VETERINÁRIO|id|name|idSpecies1,...,idSpeciesN}
    *
    * @param fields The fields of the veterinarian to import, that were split by 
    *               the separator
    */
    private void importVet(String[] fields) {
        try {
            this.registerVet(fields[1], fields[2]);
        }   catch (DuplicateEmployeeKeyException e) {
            e.printStackTrace();
        }
        
        VetEmployee v = getVet(fields[1]);
        if (fields.length > 3) {
            String[] speciesIds = fields[3].split(",");
            for (String speciesId : speciesIds) {
                Species s = getSpecies(speciesId);
                if (s != null) {
                    v.addSpecies(s);
                }
            }
        }  
    }


    /**
    * Register a new veterinarian in this hotel, which will be created from the
    * given parameters.
    *
    * @param id      The key of the veterinarian
    * @param name    The name of the veterinarian
    * @return The {@link VetEmployee} that was just created
    * @throws DuplicateEmployeeKeyException if a veterinarian with the given key
    *                                       already exists
    */
    public VetEmployee registerVet(String id, String name) 
                                   throws DuplicateEmployeeKeyException {
        if (this._vets.containsKey(id)) {
            throw new DuplicateEmployeeKeyException(id);
        }

        VetEmployee v = new VetEmployee(id, name);
        this._vets.put(id, v);
        this._employees.put(id, v);
        this.dirty();
        return v;
    }
    
}