package hva.app.habitat;

public interface Message {

    static String noAssociation(String idHabitat, String idSpecies) {
        return "Não existe  associação entre o habitat '" + idHabitat + "' e a espécie'" + idSpecies + "' ";
    }

    static String habitatRegistered(String habitatName) {
        return "Habitat " + habitatName + " registrado com sucesso!";
    }

    static String habitatAreaChanged(String habitatId, int newArea) {
        return "Área do habitat " + habitatId + " alterada para " + newArea + ".";
    }

    static String habitatInfluenceChanged(String habitatId, String speciesId, String influence) {
        return "Influência do habitat " + habitatId + " sobre a espécie " + speciesId + " alterada para " + influence + ".";
    }

    static String treeAddedToHabitat(String treeId, String habitatId) {
        return "Árvore " + treeId + " plantada com sucesso no habitat " + habitatId + ".";
    }
}

}