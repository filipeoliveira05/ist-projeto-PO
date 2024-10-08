package hva.app.main;

import hva.core.Hotel;
import hva.core.HotelManager;
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
        if (_receiver.dirty() && Form.confirm(Message.saveBeforeExit())) {
            DoSaveFile cmd = new DoSaveFile(_receiver);
            cmd.execute();
            }
            _receiver.reset();
          }
        
}
    


    
