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
        if (_receiver.changed() && Form.confirm(Message.saveBeforeExit())) {
            Do_313_Save cmd = new Do_313_Save(_receiver);
            cmd.execute();
          }
          _receiver.reset();
    }
}
