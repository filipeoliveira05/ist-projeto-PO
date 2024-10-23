package hva.app.habitat;

import java.text.Normalizer.Form;

import hva.Hotel;
import hva.habitat.Habitat;
import hva.exceptions.UnknownHabitatException;

import hva.app.exceptions.UnknownHabitatKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoChangeHabitatArea extends Command<Hotel> {

    DoChangeHabitatArea(Hotel receiver) {
        super(Label.CHANGE_HABITAT_AREA, receiver);
        addStringField("id", Prompt.habitatKey());
        addIntegerField("area", Prompt.habitatArea());
    }

    @Override
    protected void execute() throws CommandException {
        try {
            _receiver.changeHabitatArea(stringField("id"), integerField("area"));
        
        } catch (UnknownHabitatException e) {
            throw new UnknownHabitatKeyException(e.getKey());
        }
    }
}