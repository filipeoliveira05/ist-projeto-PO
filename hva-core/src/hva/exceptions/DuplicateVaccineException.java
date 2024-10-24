package hva.exceptions;

import java.io.Serial;

public class DuplicateVaccineException extends Exception {

    /**
     * Class serial number.
     */
    @Serial
    private static final long serialVersionUID = 202410061053L;
  
    private final String key;   
  
    public DuplicateVaccineException(String key) {
      this.key = key;
    }
  
    public String getKey() {
      return key;
    }
  }