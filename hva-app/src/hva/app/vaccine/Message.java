package hva.app.vaccine;

public interface Message {

    static String wrongVaccine(String vaccineKey, String animalKey) {
        return "A vacina '" + vaccineKey + "' não é apropiada para o animal '" + animalKey + "'.";}

    /*
        static String vaccineRegistered(String vaccineName) {
        return "Vacina " + vaccineName + " registada com sucesso!";
    }
    
    // Mensagem para quando um animal é vacinado com sucesso
    static String animalVaccinated(String animalId, String vaccineId) {
        return "Animal " + animalId + " vacinado com a vacina " + vaccineId + ".";
    }
    */
}


