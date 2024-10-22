package hva.exceptions;

import java.io.Serial;

public class InappropriateVaccineException extends Exception {

    /**
     * Class serial number.
     */
    @Serial
    private static final long serialVersionUID = 202410230004L;
  
    private String idVaccine;
    private String idAnimal;  
  
    public InappropriateVaccineException(String idVaccine, String idAnimal) {
      this.idVaccine = idVaccine;
      this.idAnimal = idAnimal;
    }
  
    public String getIdVaccine() {
      return this.idVaccine;
    }

    public String getIdAnimal() {
        return this.idAnimal;
      }
  }