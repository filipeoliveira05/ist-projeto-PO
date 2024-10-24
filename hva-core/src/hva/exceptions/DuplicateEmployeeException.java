package hva.exceptions;

import java.io.Serial;

public class DuplicateEmployeeException extends Exception {

    /**
     * Class serial number.
     */
    @Serial
    private static final long serialVersionUID = 202410061053L;
  
    private final String key;   
  
    public DuplicateEmployeeException(String key) {
      this.key = key;
    }
  
    public String getKey() {
      return key;
    }
  }