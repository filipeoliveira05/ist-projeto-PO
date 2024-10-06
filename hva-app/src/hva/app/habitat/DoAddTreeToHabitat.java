package hva.app.habitat;

import java.text.Normalizer.Form;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoAddTreeToHabitat extends Command<Hotel> {

    DoAddTreeToHabitat(Hotel receiver) {
        super(Label.ADD_TREE_TO_HABITAT, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        String habitatId = Form.requestString(Prompt.habitatKey());
        String treeId = Form.requestString(Prompt.treeKey());

        // Verifica duplicidade de árvore
        try {
            _receiver.checkDuplicateTree(treeId);
        } catch (DuplicateTreeKeyException e) {
            throw e;
        }

        String treeName = Form.requestString(Prompt.treeName());
        int treeAge = Form.requestInteger(Prompt.treeAge());
        int treeDifficulty = Form.requestInteger(Prompt.treeDifficulty());
        String treeType;
        
        // Valida o tipo de árvore (PERENE ou CADUCA)
        do {
            treeType = Form.requestString(Prompt.treeType()).toUpperCase();
        } while (!treeType.equals("PERENE") && !treeType.equals("CADUCA"));

        _receiver.addTreeToHabitat(habitatId, treeId, treeName, treeAge, treeDifficulty, treeType);  // Planta a árvore
        _display.popup(Message.treeAddedToHabitat(treeId, habitatId));
    }
}
