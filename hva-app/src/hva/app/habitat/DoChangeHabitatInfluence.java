package hva.app.habitat;

import java.text.Normalizer.Form;

import hva.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoChangeHabitatInfluence extends Command<Hotel> {

    DoChangeHabitatInfluence(Hotel receiver) {
        super(Label.CHANGE_HABITAT_INFLUENCE, receiver);
    }

    @Override
    protected void execute() throws CommandException {
        String habitatId = Form.requestString(Prompt.habitatKey());
        String speciesId = Form.requestString("Identificador único da espécie:");
        String influence;
        
        do {
            influence = Form.requestString(Prompt.habitatInfluence()).toUpperCase();
        } while (!influence.equals("POS") && !influence.equals("NEG") && !influence.equals("NEU"));

        _receiver.changeHabitatInfluence(habitatId, speciesId, influence);  // Altera a influência
        _display.popup(Message.habitatInfluenceChanged(habitatId, speciesId, influence));


        //FALTA EXCECAO com message NOASSOCIATION
    }
}
