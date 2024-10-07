package hva.app.vaccine;

import hva.Hotel;
import java.text.Normalizer;
import java.text.Normalizer.Form;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoVaccinateAnimal extends Command<Hotel> {

    DoVaccinateAnimal(Hotel receiver) {
        super(Label.VACCINATE_ANIMAL, receiver);
        //FIXME add command fields if needed
    }

    @Override
    protected final void execute() throws CommandException {
        //FIXME implement command

        /*
        // Solicita o identificador da vacina
        String vaccineId = Form.requestString(Prompt.vaccineKey());

        // Solicita o identificador do veterinário
        String veterinarianId = Form.requestString(Prompt.veterinarianKey());

        // Solicita o identificador do animal
        String animalId = Form.requestString("Insira o identificador único do animal:");

        // Verifica se o identificador é de um veterinário válido
        try {
            _receiver.checkVeterinarian(veterinarianId);
        } catch (UnknownVeterinarianKeyException e) {
            throw e; // Se não for veterinário válido, lança a exceção
        }

        // Verifica se o veterinário está autorizado a ministrar a vacina
        try {
            _receiver.verifyVeterinarianAuthorization(veterinarianId, vaccineId);
        } catch (VeterinarianNotAuthorizedException e) {
            throw e; // Se o veterinário não tiver permissão, lança a exceção
        }

        // Vacinar o animal
        boolean success = _receiver.vaccinateAnimal(vaccineId, veterinarianId, animalId);

        // Se a vacina não for adequada ao animal, exibe uma mensagem de aviso, mas ainda vacina
        if (!success) {
            _display.popup(Message.wrongVaccine(vaccineId, animalId));
        }

        // Exibe mensagem de sucesso para a vacinação
        _display.popup(Message.animalVaccinated(animalId, vaccineId));
        */
    }
}
