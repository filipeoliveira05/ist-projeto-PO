package hva;


import hva.exceptions.DuplicateAnimalException;
import hva.exceptions.DuplicateEmployeeException;
import hva.exceptions.DuplicateHabitatException;
import hva.exceptions.DuplicateSpeciesNameException;
import hva.exceptions.DuplicateTreeException;
import hva.exceptions.DuplicateVaccineException;
import hva.exceptions.ImportFileException;
import hva.exceptions.InappropriateVaccineException;
import hva.exceptions.NoResponsibilityExcept;
import hva.exceptions.UnknownAnimalException;
import hva.exceptions.UnknownEmployeeException;
import hva.exceptions.UnknownHabitatException;
import hva.exceptions.UnknownSpeciesException;
import hva.exceptions.UnknownVaccineException;
import hva.exceptions.UnknownVeterinarianException;
import hva.exceptions.VeterinarianNotAuthorizedExcept;

import hva.animal.Animal;
import hva.employee.CaretakerEmployee;
import hva.employee.Employee;
import hva.employee.VetEmployee;
import hva.habitat.Habitat;
import hva.species.Species;
import hva.tree.CaducaTree;
import hva.tree.PereneTree;
import hva.tree.Tree;
import hva.vaccine.Vaccination;
import hva.vaccine.Vaccine;
import hva.state.Season;
import hva.state.SeasonState;
import hva.state.PrimaveraState;
import hva.state.VeraoState;
import hva.state.OutonoState;
import hva.state.InvernoState;
import hva.satisfaction.SatisfactionStrategy;
import hva.satisfaction.AnimalSatisfactionStrategy;
import hva.satisfaction.CaretakerSatisfactionStrategy;
import hva.satisfaction.VetSatisfactionStrategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;



public class Hotel implements Serializable {
    
    /**
    * Serial number for serialization
    */
    @Serial
    private static final long serialVersionUID = 202407081733L;

    /**
    * Stores the hotel's vaccines, sorted by their key.
    */
    private Map<String, Vaccine> _vaccines = new HashMap<>();

    /**
    * Stores the hotel's vaccinations, sorted by their key.
    */
    private List<Vaccination> _vaccinations = new ArrayList<>();

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
    private Map<String, Employee<?>> _employees = new HashMap<>();

    /**
    * Stores the hotel's veterinarians, sorted by their key.
    */
    private Map<String, VetEmployee> _vets = new HashMap<>();

    /**
    * Stores the hotel's caretakers, sorted by their key.
    */
    private Map<String, CaretakerEmployee> _caretakers = new HashMap<>();


    private Season _season = new Season(); // Campo para rastrear a estação

    public void advanceSeason() {
        _season.advanceSeason();

        for (Tree tree : getAllTrees()) {
            tree.setSeason(_season);
            tree.passSeason();
            tree.upgradeAge();
        }

        this.dirty();
    }


    // Método para obter o número da estação atual
    public int getCurrentSeasonNumber() {
        return _season.getCurrentSeasonNumber();
    }

    
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
        Map<String, Species> sortedSpecies = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sortedSpecies.putAll(_species);
        return Collections.unmodifiableCollection(sortedSpecies.values());
    }


    /**
    * Get all trees known to the hotel, perene or caduca, sorted by their key
    *
    * @return A sorted {@link Collection} of trees
    */
    public Collection<Tree> getAllTrees() {
        Map<String, Tree> sortedTrees = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sortedTrees.putAll(_trees);
        return Collections.unmodifiableCollection(sortedTrees.values());
    }


    /**
    * Get all habitats known to the hotel sorted by their key
    *
    * @return A sorted {@link Collection} of habitats
    */
    public Collection<Habitat> getAllHabitats() {
        Map<String, Habitat> sortedHabitats = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sortedHabitats.putAll(_habitats);
        return Collections.unmodifiableCollection(sortedHabitats.values());
    }


    /**
    * Get all animals known to the hotel sorted by their key
    *
    * @return A sorted {@link Collection} of animals
    */
    public Collection<Animal> getAllAnimals() {
        Map<String, Animal> sortedAnimals = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sortedAnimals.putAll(_animals);
        return Collections.unmodifiableCollection(sortedAnimals.values());
    }


    /**
    * Get all employees known to the hotel, caretakers or vets, sorted by key
    *
    * @return A sorted {@link Collection} of employees
    */
    public Collection<Employee<?>> getAllEmployees() {
        Map<String, Employee<?>> sortedEmployees = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sortedEmployees.putAll(_employees);
        return Collections.unmodifiableCollection(sortedEmployees.values());
    }

    /**
    * Get all caretakers known to the hotel sorted by their key
    *
    * @return A sorted {@link Collection} of caretakers
    */
    public Collection<CaretakerEmployee> getAllCaretakers() {
        Map<String, CaretakerEmployee> sortedCaretakers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sortedCaretakers.putAll(_caretakers);
        return Collections.unmodifiableCollection(sortedCaretakers.values());
    }


    /**
    * Get all veterinarians known to the hotel sorted by their key
    *
    * @return A sorted {@link Collection} of veterinarians
    */
    public Collection<VetEmployee> getAllVets() {
        Map<String, VetEmployee> sortedVets = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sortedVets.putAll(_vets);
        return Collections.unmodifiableCollection(sortedVets.values());
    }


    /**
    * Get all vaccines known to the hotel sorted by their key
    *
    * @return A sorted {@link Collection} of vaccines
    */
    public Collection<Vaccine> getAllVaccines() {
        Map<String, Vaccine> sortedVaccines = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        sortedVaccines.putAll(_vaccines);
        return Collections.unmodifiableCollection(sortedVaccines.values());
    }


    /**
    * Get all vaccinations known to the hotel sorted by application
    *
    * @return A sorted {@link List} of vaccinnations
    */
    public List<Vaccination> getAllVaccinations() {
        return Collections.unmodifiableList(_vaccinations);
    }



    public Collection<Tree> getTreesInHabitat (String idHabitat) throws UnknownHabitatException {
        Habitat habitat = _habitats.get(idHabitat);
        if (habitat == null) {
            throw new UnknownHabitatException(idHabitat);
        }

        Collection<Tree> treesInHabitat = habitat.getAllTreesInHabitat();
        return treesInHabitat;
    }
    
    
    public Collection<Animal> getAnimalsInHabitat (String idHabitat) throws UnknownHabitatException {
        Habitat habitat = _habitats.get(idHabitat);
        if (habitat == null) {
            throw new UnknownHabitatException(idHabitat);
        }

        Collection<Animal> animalsInHabitat = habitat.getAllAnimalsInHabitat();
        return animalsInHabitat;
    }


    public List<Vaccination> getMedicalActsByVet (String idVet) throws UnknownVeterinarianException {
        VetEmployee vet = _vets.get(idVet);
        if (vet == null || !vet.isVet()) {
            throw new UnknownVeterinarianException(idVet);
        }

        List<Vaccination> medicalActsByVet = vet.getVaccinations();
        return medicalActsByVet;
    }


    public List<Vaccination> getMedicalActsOnAnimal (String idAnimal) throws UnknownAnimalException {
        Animal animal = _animals.get(idAnimal);
        if (animal == null) {
            throw new UnknownAnimalException(idAnimal);
        }

        List<Vaccination> medicalActsOnAnimal = animal.getVaccinations();
        return medicalActsOnAnimal;
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
    * Get a employee by its key. Two employees are the same if their keys are 
    * the same
    *
    * @param key The key of the caretaker to get
    * @return The {@link Employee} associated with the given key
    */
    public Employee getEmployee(String key) {
        Employee e = this._employees.get(key);
        return e;
    }


    /**
    * Get a caretaker by its key. Two caretakers are the same if their keys are 
    * the same
    *
    * @param key The key of the caretaker to get
    * @return The {@link CaretakerEmployee} associated with the given key
    */
    public CaretakerEmployee getCaretaker(String key) {
        CaretakerEmployee c = this._caretakers.get(key);
        return c;
    }


    /**
    * Get a veterinarian by its key. Two veterinarians are the same if their 
    * keys are the same
    *
    * @param key The key of the veterinarian to get
    * @return The {@link VetEmployee} associated with the given key
    */
    public VetEmployee getVet(String key) {
        VetEmployee v = this._vets.get(key);
        return v;
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
            case "ESPÉCIE" -> this.importSpecies(fields);
            case "ÁRVORE" -> this.importTree(fields);
            case "HABITAT" -> this.importHabitat(fields);
            case "ANIMAL" -> this.importAnimal(fields);
            case "TRATADOR" -> this.importCaretaker(fields);
            case "VETERINÁRIO" -> this.importVet(fields);
            case "VACINA" -> this.importVaccine(fields);
        }
    }



    /**
    * Parse and import a species entry from a plain text file.
    *
    * A correct species entry has the following format:
    * {@code ESPECIE|id|name}
    *
    * @param fields The fields of the species to import, that were split by the
    *               separator
    */
    private void importSpecies(String[] fields) {
        try {
            this.registerSpecies(fields[1], fields[2]);
        } catch (DuplicateSpeciesNameException e) {
            e.printStackTrace();
        }
    }


    /**
    * Register a new species in this hotel, which will be created from the
    * given parameters.
    *
    * @param id      The key of the species
    * @param name    The name of the species
    * @return The {@link Species} that was just created
    * @throws DuplicateSpeciesNameException if a species with the same name already exists
    */
    public Species registerSpecies(String id, String name) throws DuplicateSpeciesNameException {
        for (Species species : _species.values()) {
            if (species.getName().equalsIgnoreCase(name)) {
                throw new DuplicateSpeciesNameException(name);
            }
        }

        Species s = new Species(id, name);
        this._species.put(id, s);
        this.dirty();
        return s;
    }





    /**
    * Parse and import a tree entry from a plain text file.
    *
    * A correct tree entry has the following format:
    * {@code ÁRVORE|id|name|age|difficulty|type}
    *
    * @param fields The fields of the tree to import, that were split by the
    *               separator
    */
    private void importTree(String[] fields) {
        try {
            this.registerTree(fields[1], fields[2], Integer.parseInt(fields[3]), Integer.parseInt(fields[4]), fields[5]);
        }   catch (DuplicateTreeException e) {
            e.printStackTrace();
        }
    }


    /**
    * Register a new tree in this hotel, which will be created from the
    * given parameters.
    *
    * @param id         The key of the tree
    * @param name       The name of the tree
    * @param age        The age of the tree
    * @param difficulty The base cleaning difficulty of the tree
    * @param type       The type of the tree (caduca or perene)
    * @return The {@link Tree} that was just created
    * @throws DuplicateTreeException if a tree with the given key
    *                                   already exists
    */
    public Tree registerTree(String id, String name, int age, int difficulty, String type) 
                             throws DuplicateTreeException {
        
        for (String existingId : this._trees.keySet()) {
            if (existingId.equalsIgnoreCase(id)) {
                throw new DuplicateTreeException(id);
            }
        }

        Tree t = null;
        switch (type.toUpperCase()) {
            case "PERENE" -> t = new PereneTree(id, name, age, difficulty, _season);
            case "CADUCA" -> t = new CaducaTree(id, name, age, difficulty, _season);
        }

        if (t != null) {
            this._trees.put(id, t);
            this.dirty();
        }

        return t;
    }


    /**
    * Register a new tree in an habitat, which will be created from the
    * given parameters.
    *
    * @param idHabitat  The key of the habitat to put the tree
    * @param id         The key of the tree
    * @param name       The name of the tree
    * @param age        The age of the tree
    * @param difficulty The base cleaning difficulty of the tree
    * @param type       The type of the tree (caduca or perene)
    * @return The {@link Tree} that was just created
    * @throws DuplicateTreeException if a tree with the given key
    *                                   already exists
    * @throws UnknownHabitatException   if the habitat with the given key
    *                                   doesn't exist
    */
    public Tree registerTreeInHabitat(String idHabitat, String id, String name, int age, int difficulty, String type) 
                             throws DuplicateTreeException, UnknownHabitatException {
        
        for (String existingId : this._trees.keySet()) {
            if (existingId.equalsIgnoreCase(id)) {
                throw new DuplicateTreeException(id);
            }
        }

        Habitat habitat = _habitats.get(idHabitat);
        if (habitat == null) {
            throw new UnknownHabitatException(idHabitat);
        }

        Tree t = null;
        switch (type.toUpperCase()) {
            case "PERENE" -> t = new PereneTree(id, name, age, difficulty, _season);
            case "CADUCA" -> t = new CaducaTree(id, name, age, difficulty, _season);
        }

        if (t != null) {
            habitat.addTree(t);
            this._trees.put(id, t);
            this.dirty();
        }

        return t;
    }




    /**
    * Parse and import a habitat entry from a plain text file.
    *
    * A correct habitat entry has the following format:
    * {@code HABITAT|id|name|area|idTree1,...,idTreeN}
    *
    * @param fields The fields of the habitat to import, that were split by the
    *               separator
    */
    private void importHabitat(String[] fields) {
        try {
            this.registerHabitat(fields[1], fields[2], Integer.parseInt(fields[3]));
        }   catch (DuplicateHabitatException e) {
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
    * @param area    The area of the habitat
    * @return The {@link Habitat} that was just created
    * @throws DuplicateHabitatException if a habitat with the given key
    *                                      already exists
    */
    public Habitat registerHabitat(String id, String name, int area) 
                                   throws DuplicateHabitatException {
        
        for (String existingId : this._habitats.keySet()) {
            if (existingId.equalsIgnoreCase(id)) {
                throw new DuplicateHabitatException(id);
            }
        }

        Habitat h = new Habitat(id, name, area);
        this._habitats.put(id, h);
        this.dirty();
        return h;
    }




    /**
    * Parse and import an animal entry from a plain text file.
    *
    * A correct animal entry has the following format:
    * {@code ANIMAL|id|name|idSpecies|idHabitat}
    *
    * @param fields The fields of the animal to import, that were split by the
    *               separator
    */
    private void importAnimal(String[] fields) {
        try {
            this.registerAnimal(fields[1], fields[2], fields[3], fields[4]);
        }   catch (DuplicateAnimalException | UnknownSpeciesException | UnknownHabitatException e) {
            e.printStackTrace();
        }
    }


    /**
    * Register a new animal in this hotel, which will be created from the
    * given parameters.
    *
    * @param id         The key of the animal
    * @param name       The name of the animal
    * @param idSpecies  The key of the animal's species
    * @param idHabitat  The key of the animal's habitat
    * @return The {@link Animal} that was just created
    * @throws UnknownSpeciesException     if the species with the given key
    *                                     doesn't exist
    * @throws UnknownHabitatException     if the habitat with the given key
    *                                     doesn't exist
    * @throws DuplicateAnimalException if an animal with the given key
    *                                     already exists
    */
    public Animal registerAnimal(String id, String name, String idSpecies, String idHabitat) 
                                throws UnknownSpeciesException, UnknownHabitatException, DuplicateAnimalException {
        
        Species species = _species.get(idSpecies);
        if (species == null) {
            throw new UnknownSpeciesException(idSpecies);
        }

        Habitat habitat = _habitats.get(idHabitat);
        if (habitat == null) {
            throw new UnknownHabitatException(idHabitat);
        }

        for (String existingId : this._animals.keySet()) {
            if (existingId.equalsIgnoreCase(id)) {
                throw new DuplicateAnimalException(id);
            }
        }

        Animal a = new Animal(id, name, idSpecies, idHabitat);
        this._animals.put(id, a);
        habitat.addAnimal(a);
        habitat.addSpecies(species);
        this.dirty();
        return a;
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
        }   catch (DuplicateEmployeeException e) {
            e.printStackTrace();
        }
        
        CaretakerEmployee c = getCaretaker(fields[1]);
        if (fields.length > 3) {
            String[] habitatIds = fields[3].split(",");
            for (String habitatId : habitatIds) {
                Habitat h = getHabitat(habitatId);
                c.addResponsibility(habitatId, h);
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
    * @throws DuplicateEmployeeException if a caretaker with the given key
    *                                       already exists
    */
    public CaretakerEmployee registerCaretaker(String id, String name) 
                                   throws DuplicateEmployeeException {
        
        for (String existingId : this._employees.keySet()) {
            if (existingId.equalsIgnoreCase(id)) {
                throw new DuplicateEmployeeException(id);
            }
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
        }   catch (DuplicateEmployeeException e) {
            e.printStackTrace();
        }
        
        VetEmployee v = getVet(fields[1]);
        if (fields.length > 3) {
            String[] speciesIds = fields[3].split(",");
            for (String speciesId : speciesIds) {
                Species s = getSpecies(speciesId);
                if (s != null) {
                    v.addResponsibility(speciesId, s);
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
    * @throws DuplicateEmployeeException if a veterinarian with the given key
    *                                       already exists
    */
    public VetEmployee registerVet(String id, String name) 
                                   throws DuplicateEmployeeException {
                                    
        for (String existingId : this._employees.keySet()) {
            if (existingId.equalsIgnoreCase(id)) {
                throw new DuplicateEmployeeException(id);
            }
        }

        VetEmployee v = new VetEmployee(id, name);
        this._vets.put(id, v);
        this._employees.put(id, v);
        this.dirty();
        return v;
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
        }   catch (DuplicateVaccineException e) {
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
    * @throws DuplicateVaccineException if a vaccine with the given key
    *                                      already exists
    */
    public Vaccine registerVaccine(String id, String name) 
                                   throws DuplicateVaccineException {
        
        for (String existingId : this._vaccines.keySet()) {
            if (existingId.equalsIgnoreCase(id)) {
                throw new DuplicateVaccineException(id);
            }
        }

        Vaccine v = new Vaccine(id, name);
        this._vaccines.put(id, v);
        this.dirty();
        return v;
    }




    /**
     * Changes the area of a habitat.
     * 
     * @param idHabitat The id of the habitat to change area
     * @param newArea The new area to set for the habitat
     * @throws UnknownHabitatException if the habitat ID does not exist
     */
    public void changeHabitatArea(String idHabitat, int newArea) throws UnknownHabitatException {
        Habitat habitat = _habitats.get(idHabitat);
        if (habitat == null) {
            throw new UnknownHabitatException(idHabitat);
        }
        
        habitat.setArea(newArea);
        this.dirty();
    }




    /**
     * Adds a responsibility to an employee based on their type.
     * 
     * @param idEmployee The id of the employee
     * @param idResponsibility The id of the responsibility
     * @throws NoResponsibilityExcept if the responsibility does not exist
     * @throws UnknownEmployeeException if the employee does not exist
     */
    public void addResponsibilityToEmployee(String idEmployee, String idResponsibility) throws NoResponsibilityExcept, UnknownEmployeeException {
        Employee<?> employee = _employees.get(idEmployee);

        if (employee == null) {
            throw new UnknownEmployeeException(idEmployee);
        }

        if (employee.isVet()) {
            if (!_species.containsKey(idResponsibility)) {
                throw new NoResponsibilityExcept(idEmployee, idResponsibility);
            }

            if (employee.getResponsibilitiesAsString().contains(idResponsibility)) {
                return;
            }

            Species s = getSpecies(idResponsibility);
            ((VetEmployee) employee).addResponsibility(idResponsibility, s);
            this.dirty();

        } else if (employee.isCaretaker()) {
            if (!_habitats.containsKey(idResponsibility)) {
                throw new NoResponsibilityExcept(idEmployee, idResponsibility);
            }

            if (employee.getResponsibilitiesAsString().contains(idResponsibility)) {
                return;
            }

            Habitat h = getHabitat(idResponsibility);
            ((CaretakerEmployee) employee).addResponsibility(idResponsibility, h);
            this.dirty();
        }
    }





    /**
    * Removes a responsibility from an employee based on their type.
    * 
    * @param idEmployee The id of the employee
    * @param idResponsibility The id of the responsibility to remove
    * @throws NoResponsibilityExcept if the responsibility does not exist
    * @throws UnknownEmployeeException if the employee does not exist
    */
    public void removeResponsibilityOfEmployee(String idEmployee, String idResponsibility) throws NoResponsibilityExcept, UnknownEmployeeException {
        Employee<?> employee = _employees.get(idEmployee);

        if (employee == null) {
            throw new UnknownEmployeeException(idEmployee);
        }

        if (employee.isVet()) {
            if (!_species.containsKey(idResponsibility) || !employee.getResponsibilitiesAsString().contains(idResponsibility)) {
                throw new NoResponsibilityExcept(idEmployee, idResponsibility);
            }

            employee.removeResponsibility(idResponsibility);
            this.dirty();

        } else if (employee.isCaretaker()) {
            if (!_habitats.containsKey(idResponsibility) || !employee.getResponsibilitiesAsString().contains(idResponsibility)) {
                throw new NoResponsibilityExcept(idEmployee, idResponsibility);
            }

            employee.removeResponsibility(idResponsibility);
            this.dirty();
        }
    }
    



    public void transferAnimal(String animalId, String newHabitatId) throws UnknownHabitatException, UnknownAnimalException {
        Animal animal = _animals.get(animalId);
        if (animal == null) {
            throw new UnknownAnimalException(animalId);
        }

        Habitat currentHabitat = _habitats.get(animal.getIdHabitat());
        if (currentHabitat != null) {
            currentHabitat.removeAnimal(animal);
        }

        Habitat newHabitat = _habitats.get(newHabitatId);
        if (newHabitat == null) {
            throw new UnknownHabitatException(newHabitatId);
        }

        animal.setHabitatId(newHabitatId);
        newHabitat.addAnimal(animal);
        this.dirty();
    }



    public int globalSatisfaction() {
        int totalSatisfaction = 0;
    
        for (Animal animal : getAllAnimals()) {
            try {
                totalSatisfaction += new AnimalSatisfactionStrategy(this).calculateSatisfaction(animal.getId());
            } catch (UnknownAnimalException e) {
                e.printStackTrace();
            }
        }
    
        for (Employee<?> employee : getAllEmployees()) {
            
            if (employee.isCaretaker()) {
                try {
                    totalSatisfaction += new CaretakerSatisfactionStrategy(this).calculateSatisfaction(employee.getId());
                } catch (UnknownEmployeeException e) {
                    e.printStackTrace();
                }
            }

            if (employee.isVet()) {
                try {
                    totalSatisfaction += new VetSatisfactionStrategy(this).calculateSatisfaction(employee.getId());
                } catch (UnknownEmployeeException e) {
                    e.printStackTrace();
                }
            }
        }
    
        return Math.round(totalSatisfaction);
    }
    


    public Vaccine registerVaccineWithSpecies(String id, String name, String idSpecies) 
                                           throws DuplicateVaccineException, UnknownSpeciesException {
        
        for (String existingId : this._vaccines.keySet()) {
            if (existingId.equalsIgnoreCase(id)) {
                throw new DuplicateVaccineException(id);
            }
        }
        
        String[] speciesIds = idSpecies.split(",");
        for (String speciesId : speciesIds) {
            if (!_species.containsKey(speciesId.trim())) {
                throw new UnknownSpeciesException(speciesId.trim());
            }
        }
        
        Vaccine v = new Vaccine(id, name);
        this._vaccines.put(id, v);
        
        for (String speciesId : speciesIds) {
            Species s = getSpecies(speciesId);
            if (s != null) {
            v.addSpecies(s);   
            }
        }

        this.dirty();
        return v;
    }




    public void vaccinateAnimal(String idVaccine, String idVet, String idAnimal) 
            throws UnknownVaccineException, UnknownVeterinarianException, UnknownAnimalException, VeterinarianNotAuthorizedExcept, InappropriateVaccineException {
        
        Vaccine vaccine = _vaccines.get(idVaccine);
        if (vaccine == null) {
            throw new UnknownVaccineException(idVaccine);
        }

        VetEmployee vet = _vets.get(idVet);
        if (vet == null) {
            throw new UnknownVeterinarianException(idVet);
        }

        Animal animal = _animals.get(idAnimal);
        if (animal == null) {
            throw new UnknownAnimalException(idAnimal);
        }

        String idSpecies = animal.getIdSpecies();
        if (!vet.getResponsibilitiesAsString().contains(idSpecies)) {
            throw new VeterinarianNotAuthorizedExcept(idVet, idSpecies);
        }

        String rightOrWrong = "";
        if (vaccine.getSpeciesIdsAsString().contains(idSpecies)) {
            rightOrWrong = "right";
        } else {
            rightOrWrong = "wrong";
        }

        Vaccination v = new Vaccination(idVaccine, idVet, idAnimal, idSpecies, rightOrWrong);
        this._vaccinations.add(v);
        vaccine.addVaccination(v);
        vet.addVaccination(v);
        animal.addVaccination(v);


        if (rightOrWrong.equals("right")) {
            animal.addHealthEvent(0, "right");
        } else {
            int damage = calculateDamage(animal, vaccine);
            animal.addHealthEvent(damage, "wrong");
            throw new InappropriateVaccineException(idVaccine, idAnimal);
        }

        this.dirty();
    }


    private int calculateDamage(Animal animal, Vaccine vaccine) {
        String animalSpeciesId = animal.getIdSpecies();
        Species s = getSpecies(animalSpeciesId);
        String speciesName = s.getName(); 
        Set<String> vaccineSpeciesNames = new HashSet<>();

        for (String speciesId : vaccine.getSpeciesIdsAsString().split(",")) {
            Species species = getSpecies(speciesId.trim());
            if (species != null) {
                vaccineSpeciesNames.add(species.getName());
            }
        }

        int maxDamage = 0;

        for (String vaccineSpecies : vaccineSpeciesNames) {
            int damage = calculateMaxDamage(speciesName, vaccineSpecies);
            maxDamage = Math.max(maxDamage, damage);
        }

        return maxDamage;
    }


    private int calculateMaxDamage(String animalSpecies, String vaccineSpecies) {
        int maxLength = Math.max(animalSpecies.length(), vaccineSpecies.length());
        int commonCharacters = countCommonCharacters(animalSpecies, vaccineSpecies);
        return maxLength - commonCharacters;
    }


    public int countCommonCharacters(String s1, String s2) {
        HashSet<Character> charsInS1 = new HashSet<>();
        for (char c : s1.toCharArray()) {
            charsInS1.add(c);
        }

        HashSet<Character> commonChars = new HashSet<>();
        for (char c : s2.toCharArray()) {
            if (charsInS1.contains(c)) {
                commonChars.add(c);
            }
        }

        return commonChars.size();
    }




    public void changeHabitatInfluence(String idHabitat, String idSpecies, String influenceType)
                                       throws UnknownHabitatException, UnknownSpeciesException {
        
        Habitat habitat = _habitats.get(idHabitat);
        if (habitat == null) {
            throw new UnknownHabitatException(idHabitat);
        }
        
        Species species = _species.get(idSpecies);
        if (species == null) {
            throw new UnknownSpeciesException(idSpecies);
        }

        
        int influenceValue = 0;
    
        switch (influenceType.toUpperCase()) {
            case "POS":
                influenceValue = 20;
                break;
            case "NEG":
                influenceValue = -20;
                break;
            case "NEU":
                influenceValue = 0;
                break;
        }
    
        habitat.setSpeciesInfluence(species, influenceValue);
        this.dirty();
    }
    
}