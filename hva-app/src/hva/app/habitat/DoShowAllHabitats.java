package hva.app.habitat;

import java.util.Map;
import java.util.Collection;
import java.util.Collections;

import hva.Hotel;
import hva.habitat.Habitat;
import hva.tree.Tree;

import pt.tecnico.uilib.menus.Command;


class DoShowAllHabitats extends Command<Hotel> {

    DoShowAllHabitats(Hotel receiver) {
        super(Label.SHOW_ALL_HABITATS, receiver);
    }

    @Override
    protected void execute() {
        Collection<Habitat> habitats = _receiver.getAllHabitats();
        
        for (Habitat habitat : habitats) {
            String habitatInfo = "HABITAT|"
                                + habitat.getId() + "|"
                                + habitat.getName() + "|"
                                + habitat.getArea() + "|"
                                + habitat.getNumberTrees();
            _display.addLine(habitatInfo);


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
        }

        _display.display();
    }
}
