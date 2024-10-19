package hva.app.habitat;

import java.text.Normalizer.Form;

import hva.tree.Tree;
import java.util.Collection;
import java.util.Collections;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoShowAllTreesInHabitat extends Command<Hotel> {

    DoShowAllTreesInHabitat(Hotel receiver) {
        super(Label.SHOW_TREES_IN_HABITAT, receiver);
        //FIXME add command fields if needed
        addStringField("idHabitat", Prompt.habitatKey());
    }

    @Override
    protected void execute() throws CommandException {
        //FIXME implement command
        //String habitatId = stringField("idHabitat");
        
        Collection<Tree> treesInHabitat = _receiver.getHabitat(stringField("idHabitat")).getAllTreesInHabitat();

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

    }
}
