package hva.app.animal;

public class Message {
    static String animalRegistered(String animalName) {
        return "Animal " + animalName + " registrado com sucesso!";
    }

    static String animalTransferred(String animalId, String habitatId) {
        return "Animal " + animalId + " transferido para o habitat " + habitatId + ".";
    }

    static String animalSatisfaction(String animalId, int satisfaction) {
        return "Satisfação do animal " + animalId + ": " + satisfaction;
    }
}
