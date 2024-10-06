package hva.exceptions;

import java.io.Serial;

public class VeterinarianNotAuthorizedException extends Exception {

    /**
     * Class serial number.
     */
    @Serial
    private static final long serialVersionUID = 202410061105L;
  
    private String idVet;
    private String idSpecies;  
  
    public VeterinarianNotAuthorizedException(String idVet, String idSpecies) {
      this.idVet = idVet;
      this.idSpecies = idSpecies;
    }
  
    public String getIdVet() {
      return this.idVet;
    }

    public String getIdSpecies() {
        return this.idSpecies;
      }

  }