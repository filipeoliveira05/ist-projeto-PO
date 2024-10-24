package hva.app.habitat;

import hva.Hotel;
import hva.tree.Tree;
import hva.exceptions.DuplicateTreeException;
import hva.exceptions.UnknownHabitatException;

import hva.app.exceptions.DuplicateTreeKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoAddTreeToHabitat extends Command<Hotel> {

    DoAddTreeToHabitat(Hotel receiver) {
        super(Label.ADD_TREE_TO_HABITAT, receiver);
        addStringField("id", Prompt.habitatKey());
        addStringField("idTree", Prompt.treeKey());
        addStringField("nameTree", Prompt.treeName());
        addIntegerField("ageTree", Prompt.treeAge());
        addIntegerField("difficultyTree", Prompt.treeDifficulty());
        addOptionField("typeTree", Prompt.treeType(), "PERENE", "CADUCA");
    }

    @Override
    protected void execute() throws CommandException {
        String typeTree = optionField("typeTree");

        try {
            _receiver.registerTreeInHabitat(
                    stringField("id"),
                    stringField("idTree"),
                    stringField("nameTree"),
                    integerField("ageTree"),
                    integerField("difficultyTree"),
                    typeTree
            );

            Tree tree = _receiver.getTree(stringField("idTree"));
            String biologicalCycle = tree.getBiologicalCycle();

            String treeInfo = "ÁRVORE|"
                            + stringField("idTree") + "|"
                            + stringField("nameTree") + "|"
                            + integerField("ageTree") + "|"
                            + integerField("difficultyTree") + "|"
                            + typeTree + "|"
                            + biologicalCycle;

            _display.addLine(treeInfo);
            _display.display();

        } catch (DuplicateTreeException e) {
            throw new DuplicateTreeKeyException(e.getKey());

        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(e.getKey());
        }
    }
}