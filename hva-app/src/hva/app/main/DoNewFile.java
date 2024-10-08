package hva.app.main;

import hva.HotelManager;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoNewFile extends Command<HotelManager> {
    DoNewFile(HotelManager receiver) {
        super(Label.NEW_FILE, receiver);
    }

    @Override
    protected final void execute() throws CommandException {
        if (_receiver.getHotel() != null) {
            // Se houver alterações não salvas, pergunta ao usuário se deseja salvar
            if (_receiver.getHotel().isDirty() && Form.confirm(Prompt.saveBeforeExit())) {
                try {
                    _receiver.save(); // Salva o estado atual
                } catch (Exception e) {
                    throw new SaveCommandException("Erro ao salvar antes de criar um novo arquivo.");
                }
            }
        }

        // Reseta o estado atual da aplicação, criando uma nova aplicação vazia
        _receiver.reset(); // Limpa todos os dados e prepara uma nova instância
    
    }
}
    
