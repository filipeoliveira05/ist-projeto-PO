package hva;

import hva.exceptions.DuplicateAnimalKeyException;
import hva.exceptions.DuplicateEmployeeKeyException;
import hva.exceptions.DuplicateHabitatKeyException;
import hva.exceptions.DuplicateTreeKeyException;
import hva.exceptions.DuplicateVaccineKeyException;
import hva.exceptions.ImportFileException;
import hva.exceptions.MissingFileAssociationException;
import hva.exceptions.NoResponsibilityException;
import hva.exceptions.UnavailableFileException;
import hva.exceptions.UnknownSpeciesKeyException;
import hva.exceptions.UnknownVeterinarianKeyException;
import hva.exceptions.UnrecognizedEntryException;
import hva.exceptions.VeterinarianNotAuthorizedException;


import java.io.*;
import hva.exceptions.*;
//FIXME import other Java classes
//FIXME import other project classes

/**
 * Class that represents the hotel application.
 */
public class HotelManager {

    /** The network manager. */
    private String _filename = "";
    
    /** This is the current hotel. */
    private Hotel _hotel = new Hotel();

    // FIXME maybe add more fields if needed




    /**
    * @see Hotel#registerAnimal(String, String, String, String)
    */
    public void registerAnimal(String id, String name, String idSpecies, 
                          String idHabitat) throws DuplicateAnimalKeyException {
        this._hotel.registerAnimal(id, name, idSpecies, idHabitat);
    }

    /**
     * Saves the serialized application's state into the file associated to the current network.
     *
     * @throws FileNotFoundException if for some reason the file cannot be created or opened.
     * @throws MissingFileAssociationException if the current network does not have a file.
     * @throws IOException if there is some error while serializing the state of the network to disk.
     */
    public void save() throws FileNotFoundException, MissingFileAssociationException, IOException {
        /*if (_filename == null || _filename.equals(""))
      throw new UnnamedDBException();
    try (ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(_filename)))) {
      oos.writeObject(_hotel);
      _hotel.setChanged(false);
    }*/
    }

    /**
     * Saves the serialized application's state into the file associated to the current network.
     *
     * @throws FileNotFoundException if for some reason the file cannot be created or opened.
     * @throws MissingFileAssociationException if the current network does not have a file.
     * @throws IOException if there is some error while serializing the state of the network to disk.
     */
    public void saveAs(String filename) throws FileNotFoundException, MissingFileAssociationException, IOException {
        // FIXME implement serialization method
    }

    /**
     * @param filename name of the file containing the serialized application's state
     *        to load.
     * @throws UnavailableFileException if the specified file does not exist or there is
     *         an error while processing this file.
     */
    public void load(String filename) throws UnavailableFileException {
        // FIXME implement serialization method
    }

    /**
    * Imports data from a plaintext file where each line represents a single
    * object.
    *
    * @param textFile the name or path of the text file to import data from
    * @throws ImportFileException if any I/O error occurs, such as the file not
    *                             existing, or if the file contains malformed
    *                             data
    */
    public void importFile(String textFile) throws ImportFileException {
        try {
            this._hotel.importFile(textFile);
        }   catch (IOException e) {
            throw new ImportFileException(textFile);
        }
    }

    public Hotel getHotel () {
        return _hotel;
    }
}
