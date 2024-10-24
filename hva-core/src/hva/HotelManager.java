package hva;

import hva.exceptions.DuplicateAnimalException;
import hva.exceptions.DuplicateEmployeeException;
import hva.exceptions.DuplicateHabitatException;
import hva.exceptions.DuplicateSpeciesNameException;
import hva.exceptions.DuplicateTreeException;
import hva.exceptions.DuplicateVaccineException;
import hva.exceptions.ImportFileException;
import hva.exceptions.MissingFileAssociationException;
import hva.exceptions.NoResponsibilityExcept;
import hva.exceptions.UnavailableFileException;
import hva.exceptions.UnknownAnimalException;
import hva.exceptions.UnknownEmployeeException;
import hva.exceptions.UnknownHabitatException;
import hva.exceptions.UnknownSpeciesException;
import hva.exceptions.UnknownVaccineException;
import hva.exceptions.UnknownVeterinarianException;
import hva.exceptions.UnrecognizedEntryException;
import hva.exceptions.VeterinarianNotAuthorizedExcept;


import java.io.*;
import hva.exceptions.*;

/**
 * Class that represents the hotel application.
 */
public class HotelManager {

    /** The network manager. */
    private String _filename = "";
    
    /** This is the current hotel. */
    private Hotel _hotel = new Hotel();


    /**
    * @see Hotel#registerSpecies(String, String)
    */
    public void registerSpecies(String id, String name)  throws DuplicateSpeciesNameException {
        this._hotel.registerSpecies(id, name);
    }


    /**
    * @see Hotel#registerTree(String, String, int, int, String)
    */
    public void registerTree(String id, String name, int age, int difficulty, 
                             String type) throws DuplicateTreeException {
        this._hotel.registerTree(id, name, age, difficulty, type);
    }


    /**
    * @see Hotel#registerTreeInHabitat(String, String, String, int, int, String)
    */
    public void registerTreeInHabitat(String idHabitat, String id, String name, int age, int difficulty, 
                             String type) throws DuplicateTreeException, UnknownHabitatException {
        this._hotel.registerTreeInHabitat(idHabitat, id, name, age, difficulty, type);
    }


    /**
    * @see Hotel#registerHabitat(String, String, int)
    */
    public void registerHabitat(String id, String name, int area) 
                             throws DuplicateHabitatException {
        this._hotel.registerHabitat(id, name, area);
    }


    /**
    * @see Hotel#registerAnimal(String, String, String, String)
    */
    public void registerAnimal(String id, String name, String idSpecies, String idHabitat) 
                            throws UnknownSpeciesException, UnknownHabitatException, DuplicateAnimalException {
        this._hotel.registerAnimal(id, name, idSpecies, idHabitat);
    }


    /**
    * @see Hotel#registerCaretaker(String, String)
    */
    public void registerCaretaker(String id, String name) 
                                  throws DuplicateEmployeeException {
        this._hotel.registerCaretaker(id, name);
    }


    /**
    * @see Hotel#registerVet(String, String)
    */
    public void registerVet(String id, String name) 
                            throws DuplicateEmployeeException {
        this._hotel.registerVet(id, name);
    }


    /**
    * @see Hotel#registerVaccine(String, String)
    */
    public void registerVaccine(String id, String name) 
                                throws DuplicateVaccineException {
        this._hotel.registerVaccine(id, name);
    }

    /**
    * @see Hotel#registerVaccine(String, String, String)
    */
    public void registerVaccineWithSpecies(String id, String name, String idSpecies) 
                            throws DuplicateVaccineException, UnknownSpeciesException {
        this._hotel.registerVaccineWithSpecies(id, name, idSpecies);
    }



    /**
     * Saves the serialized application's state into the file associated to the 
     * current network.
     *
     * @throws FileNotFoundException if for some reason the file cannot be 
     *                               created or opened.
     * @throws MissingFileAssociationException if the current network does not 
     *                                         have a file.
     * @throws IOException if there is some error while serializing the state 
     *                     of the network to disk.
     */
    public void save() throws FileNotFoundException, 
                              MissingFileAssociationException, IOException {
        if (_filename == null || _filename.isBlank())
            throw new MissingFileAssociationException();

        if (_hotel.isDirty()) {
            try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(_filename)))) {
              out.writeObject(_hotel);
                }
                _hotel.clean();
        }
    }



    /**
     * Saves the serialized application's state into the file associated to the
     * current network.
     *
     * @throws FileNotFoundException if for some reason the file cannot be 
     *                               created or opened.
     * @throws MissingFileAssociationException if the current network does not
     *                                         have a file.
     * @throws IOException if there is some error while serializing the state 
     *                     of the network to disk.
     */
    public void saveAs(String filename) throws FileNotFoundException,
                                MissingFileAssociationException, IOException {
        _filename = filename;
        save();
    }



    /**
     * @param filename name of the file containing the serialized application's 
     *                 state to load.
     * @throws UnavailableFileException if the specified file does not exist 
     *                                  or there is an error while processing 
     *                                  this file.
     */
    public void load(String filename) throws UnavailableFileException, 
                                      IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(filename)))) {
            _hotel = (Hotel) in.readObject();
            this._filename = filename;
        } catch (IOException | ClassNotFoundException e) {
          throw new UnavailableFileException(filename);
        }
    }



    /**
    * Imports data from a plaintext file where each line represents a single
    * object.
    *
    * @param textFile the name or path of the text file to import data from
    * @throws ImportFileException
    */
    public void importFile(String textFile) throws ImportFileException {
        _hotel.importFile(textFile);
    }



    public Hotel getHotel() {
        return _hotel;
    }


   
    public void reset() {
        _hotel = new Hotel();
        _filename = null;
    }



    /**
    * @return changed?
    */
    public boolean dirty() {
        return _hotel.isDirty();
    }
}
