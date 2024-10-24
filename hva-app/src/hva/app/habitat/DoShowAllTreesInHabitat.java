package hva.app.habitat;

import hva.Hotel;
import hva.habitat.Habitat;
import hva.tree.Tree;
import hva.exceptions.UnknownHabitatException;

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
        
        try {
            Collection<Tree> treesInHabitat = _receiver.getTreesInHabitat(stringField("idHabitat"));
            
            if (!treesInHabitat.isEmpty()) {
                for (Tree tree : treesInHabitat) {
                    String treeInfo = "ÁRVORE|"
                                    + tree.getId() + "|"
                                    + tree.getName() + "|"
                                    + tree.getAge() + "|"
                                    + tree.getDifficulty() + "|"
                                    + tree.getType() + "|"
                                    + tree.getBiologicalCycle();
                    _display.addLine(treeInfo);
                }
            }
            
            _display.display();
        
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(e.getKey());
        }
    }
}