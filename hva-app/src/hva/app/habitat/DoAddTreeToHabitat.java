package hva.app.habitat;


import hva.Hotel;
import hva.exceptions.UnknownHabitatException;
import hva.app.exceptions.DuplicateTreeKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;


class DoAddTreeToHabitat extends Command<Hotel> {

    DoAddTreeToHabitat(Hotel receiver) {
        super(Label.ADD_TREE_TO_HABITAT, receiver);
        addStringField("id", Prompt.habitatKey());
        addStringField("idTree", Prompt.treeKey());
        addStringField("nameTree", Prompt.treeName());
        addIntegerField("ageTree", Prompt.treeAge());
        addIntegerField("difficultyTree", Prompt.treeDifficulty());
    }

    @Override
    protected void execute() throws CommandException {
        // Loop para garantir que a resposta seja "PERENE" ou "CADUCA"
        String typeTree;
        while (true) {
            typeTree = Form.requestString(Prompt.treeType());
            if (typeTree.equals("PERENE") || typeTree.equals("CADUCA")) {
                break; // Sai do loop se o tipo for válido
            }
        }

        try {
            // Tenta registrar a árvore no habitat
            _receiver.registerTreeInHabitat(
                    stringField("id"),
                    stringField("idTree"),
                    stringField("nameTree"),
                    integerField("ageTree"),
                    integerField("difficultyTree"),
                    typeTree
            );

            // Exibição das informações da árvore registrada
            String treeInfo = "ÁRVORE|"
                            + stringField("idTree") + "|"
                            + stringField("nameTree") + "|"
                            + integerField("ageTree") + "|"
                            + integerField("difficultyTree") + "|"
                            + typeTree + "|"
                            + "GERARFOLHAS"; // FIXME: substituir "GERARFOLHAS" pela lógica correta do ciclo biológico

            _display.addLine(treeInfo);
            _display.display();

        } catch (hva.exceptions.DuplicateTreeKeyException e) {
            throw new DuplicateTreeKeyException(e.getKey());

        } catch (UnknownHabitatException e1) {
            throw new UnknownHabitatKeyException(e1.getKey());
        }
    }
}


