package hva.exceptions;

import java.io.Serial;

public class DuplicateSpeciesNameException extends Exception {

    /**
     * Class serial number.
     */
    @Serial
    private static final long serialVersionUID = 202410211857L;
  
    private final String name;   
  
    public DuplicateSpeciesNameException(String name) {
      this.name = name;
    }
  
    public String getName() {
      return name;
    }
  }