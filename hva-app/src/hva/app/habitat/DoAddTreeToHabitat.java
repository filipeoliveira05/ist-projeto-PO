package hva.app.habitat;

import hva.Hotel;
import hva.exceptions.UnknownHabitatException;

import hva.app.exceptions.DuplicateTreeKeyException;
import hva.app.exceptions.UnknownHabitatKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

import java.text.Normalizer.Form;

class DoAddTreeToHabitat extends Command<Hotel> {
    //FIXME PERENE/CADUCA únicos inputs válidos
    DoAddTreeToHabitat(Hotel receiver) {
        super(Label.ADD_TREE_TO_HABITAT, receiver);
        addStringField("id", Prompt.habitatKey());
        addStringField("idTree", Prompt.treeKey());
        addStringField("nameTree", Prompt.treeName());
        addIntegerField("ageTree", Prompt.treeAge());
        addIntegerField("difficultyTree", Prompt.treeDifficulty());
        addStringField("typeTree", Prompt.treeType());
    }

    @Override
    protected void execute() throws CommandException {
        try {
            _receiver.registerTreeInHabitat(
                    stringField("id"),
                    stringField("idTree"),
                    stringField("nameTree"),
                    integerField("ageTree"),
                    integerField("difficultyTree"),
                    stringField("typeTree")
            );
        } catch (hva.exceptions.DuplicateTreeKeyException e) {
            throw new DuplicateTreeKeyException(e.getKey());
          
        } catch (UnknownHabitatException e1) {
            throw new UnknownHabitatKeyException(e1.getKey());
        }
    }
}
