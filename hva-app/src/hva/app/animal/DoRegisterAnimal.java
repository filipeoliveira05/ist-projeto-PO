package hva.app.animal;

import hva.Hotel;
import java.text.Normalizer;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoRegisterAnimal extends Command<Hotel> {

    DoRegisterAnimal(Hotel receiver) {
        super(Label.REGISTER_ANIMAL, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected final void execute() throws CommandException {
        //FIXME implement command

        //adicionado por mim
        String animalName = Form.requestString(Prompt.animalName());
        String speciesId = Form.requestString(Prompt.speciesKey());
        String habitatId = Form.requestString("Insira o identificador do habitat destino");

        _receiver.registerAnimal(animalName, speciesId, habitatId);

        //_display.popup(Message.animalRegistered(animalName));  --> mensagem de confi
    }

}
