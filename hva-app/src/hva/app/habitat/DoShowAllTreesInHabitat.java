package hva.app.habitat;

import hva.Hotel;
import hva.habitat.Habitat;
import hva.tree.Tree;

import hva.app.exceptions.UnknownHabitatKeyException;

import java.util.Collection;
import java.util.Collections;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoShowAllTreesInHabitat extends Command<Hotel> {

    DoShowAllTreesInHabitat(Hotel receiver) {
        super(Label.SHOW_TREES_IN_HABITAT, receiver);
        addStringField("idHabitat", Prompt.habitatKey());
    }

    @Override
    protected void execute() throws CommandException {
        String habitatId = stringField("idHabitat");
        Habitat habitat = _receiver.getHabitat(habitatId);

        if (habitat == null) {
            throw new UnknownHabitatKeyException(habitatId);
        }

        Collection<Tree> treesInHabitat = habitat.getAllTreesInHabitat();

        if (!treesInHabitat.isEmpty()) {
            for (Tree tree : treesInHabitat) {
                String treeInfo = "ÁRVORE|"
                                + tree.getId() + "|"
                                + tree.getName() + "|"
                                + tree.getAge() + "|"
                                + tree.getDifficulty() + "|"
                                + tree.getType() + "|"
                                + "GERARFOLHAS"; //FIXME
                _display.addLine(treeInfo);
            }
        }
        
        _display.display();
    }
}