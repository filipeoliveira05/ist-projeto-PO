package hva.satisfaction;

import hva.exceptions.UnknownAnimalException;
import hva.exceptions.UnknownEmployeeException;

import java.io.Serial;
import java.io.Serializable;

public interface SatisfactionStrategy {
    int calculateSatisfaction(String id) throws UnknownAnimalException, UnknownEmployeeException;
}