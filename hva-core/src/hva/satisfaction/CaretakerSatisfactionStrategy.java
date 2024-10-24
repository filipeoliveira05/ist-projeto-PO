package hva.satisfaction;

import hva.Hotel;
import hva.employee.Employee;
import hva.employee.CaretakerEmployee;
import hva.habitat.Habitat;
import hva.tree.Tree;
import hva.exceptions.UnknownEmployeeException;

import java.util.Collection;

import java.io.Serial;
import java.io.Serializable;


public class CaretakerSatisfactionStrategy implements SatisfactionStrategy, Serializable {
    
    private Hotel _hotel;

    public CaretakerSatisfactionStrategy(Hotel hotel) {
        _hotel = hotel;
    }

    @Override
    public int calculateSatisfaction(String idEmployee) throws UnknownEmployeeException {
        CaretakerEmployee caretaker = _hotel.getCaretaker(idEmployee);
        if (caretaker == null) {
            throw new UnknownEmployeeException(idEmployee);
        }

        int satisfaction = 300 - workCaretaker(caretaker);
        return Math.round(satisfaction);
    }

    private int workCaretaker(CaretakerEmployee caretaker) {
        int totalWork = 0;
        Collection<Habitat> responsibilities = caretaker.getResponsibilities();

        for (Habitat habitat : responsibilities) {
            int numCareTakers = 0;
            double habitatWork = habitat.getArea() + 3 * habitat.getPopulation() + habitat.getTotalCleaningEffort();

            for (Tree tree : habitat.getAllTreesInHabitat()) {
                habitatWork += tree.getDifficulty();
            }

            for (Employee<?> emp : _hotel.getAllEmployees()) {
                if (emp.isCaretaker() && ((CaretakerEmployee) emp).getResponsibilities().contains(habitat)) {
                    numCareTakers++;
                }
            }

            if (numCareTakers > 0) {
                totalWork += habitatWork / numCareTakers;
            }
        }

        return totalWork;
    }
  
}