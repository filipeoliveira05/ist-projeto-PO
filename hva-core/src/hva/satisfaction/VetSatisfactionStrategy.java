package hva.satisfaction;

import hva.Hotel;
import hva.employee.Employee;
import hva.employee.VetEmployee;
import hva.species.Species;
import hva.animal.Animal;
import hva.vaccine.Vaccine;
import hva.exceptions.UnknownEmployeeException;

import java.util.Collection;

import java.io.Serial;
import java.io.Serializable;


public class VetSatisfactionStrategy implements SatisfactionStrategy, Serializable {
    
    private Hotel _hotel;

    public VetSatisfactionStrategy(Hotel hotel) {
        _hotel = hotel;
    }

    @Override
    public int calculateSatisfaction(String idEmployee) throws UnknownEmployeeException {
        VetEmployee vet = _hotel.getVet(idEmployee);
        if (vet == null) {
            throw new UnknownEmployeeException(idEmployee);
        }

        int satisfaction = 20 - workVet(vet);
        return Math.round(satisfaction);
    }


    private int workVet(VetEmployee vet) {
        int totalWork = 0;
        Collection<Species> responsibilities = vet.getResponsibilities();

        for (Species species : responsibilities) {
            int population = 0;
            int numVets = 0;

            for (Animal animal : _hotel.getAllAnimals()) {
                if (animal.getIdSpecies().equals(species.getId())) {
                    population++;
                }
            }

            for (Employee<?> emp : _hotel.getAllEmployees()) {
                if (emp.isVet() && ((VetEmployee) emp).getResponsibilities().contains(species)) {
                    numVets++;
                }
            }

            if (numVets > 0) {
                totalWork += population / numVets;
            }
        }

        return totalWork;
    }
  
}