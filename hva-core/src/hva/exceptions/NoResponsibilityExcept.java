package hva.exceptions;

import java.io.Serial;

public class NoResponsibilityExcept extends Exception {

    /**
     * Class serial number.
     */
    @Serial
    private static final long serialVersionUID = 202410061058L;
  
    private String employeeKey;
    private String responsabilityKey;  
  
    public NoResponsibilityExcept(String employeeKey, String responsibilityKey) {
      this.employeeKey = employeeKey;
      this.responsabilityKey = responsibilityKey;
    }
  
    public String getEmployeeKey() {
      return this.employeeKey;
    }

    public String getResponsabilityKey() {
        return this.responsabilityKey;
      }

  }