package hva.app.animal;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

import java.text.Normalizer.Form;

import hva.Hotel;
import hva.exceptions.DuplicateAnimalKeyException;

class DoRegisterAnimal extends Command<Hotel> {

    DoRegisterAnimal(Hotel receiver) {
        super(Label.REGISTER_ANIMAL, receiver);
    }

    @Override
    protected final void execute() throws CommandException {
        /*String animalId = Form.requestString(Prompt.animalKey());

        // Verifica se o animal já existe
        try {
            _receiver.checkDuplicateAnimal(animalId);
        } catch (DuplicateAnimalKeyException e) {
            throw e;
        }

        String animalName = Form.requestString(Prompt.animalName());
        String speciesId = Form.requestString(Prompt.speciesKey());

        // Se a espécie não existir, solicita o nome da nova espécie e regista
        if (!_receiver.speciesExists(speciesId)) {
            String speciesName = Form.requestString(Prompt.speciesName());
            _receiver.registerSpecies(speciesId, speciesName);
        }

        String habitatId = Form.requestString("Insira o identificador do habitat:");
        _receiver.registerAnimal(animalId, animalName, speciesId, habitatId);

        _display.popup(Message.animalRegistered(animalName));*/
    }
}

