package hva.app.habitat;

import hva.Hotel;
import hva.habitat.Habitat;
import hva.exceptions.UnknownHabitatException;
import hva.exceptions.UnknownSpeciesException;

import hva.app.exceptions.UnknownHabitatKeyException;
import hva.app.exceptions.UnknownSpeciesKeyException;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoChangeHabitatInfluence extends Command<Hotel> {

    DoChangeHabitatInfluence(Hotel receiver) {
        super(Label.CHANGE_HABITAT_INFLUENCE, receiver);
        addStringField("idHabitat", Prompt.habitatKey());
        addStringField("idSpecies", hva.app.animal.Prompt.speciesKey());
    }

    @Override
    protected void execute() throws CommandException {
        String habitatInfluence;
        while (true) {
            habitatInfluence = Form.requestString(Prompt.habitatInfluence());
            if (habitatInfluence.equals("POS") || habitatInfluence.equals("NEG") || habitatInfluence.equals("NEU")) {
                break;
            }
        }

        try {
            _receiver.changeHabitatInfluence(stringField("idHabitat"), stringField("idSpecies"), habitatInfluence);
        
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(e.getKey());
        
        } catch (UnknownSpeciesException e) {
            throw new UnknownSpeciesKeyException(e.getKey());
        }
    }
}
