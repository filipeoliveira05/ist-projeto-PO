package hva.exceptions;

import java.io.Serial;

public class UnknownVaccineException extends Exception{
    
    /** Serial number for serialization. */
  @Serial
  private static final long serialVersionUID = 202410212103L;

  /** The key that had an attempted access */
  private String key;

  /** @param key Unknown key provided. */
  public UnknownVaccineException(String key) {
    super();
    this.key = key;
  }

  /**
   * @param key   Unknown key provided.
   * @param cause What exception caused this one.
   */
  public UnknownVaccineException(String key, Exception cause) {
    super(cause);
    this.key = key;
  }

  /**
   * @return the key
   */
  public String getKey() {
    return this.key;
  }
}
