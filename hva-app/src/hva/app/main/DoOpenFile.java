package hva.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import hva.HotelManager;
import hva.app.exceptions.FileOpenFailedException;
import hva.exceptions.UnavailableFileException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME import other classes if needed

class DoOpenFile extends Command<HotelManager> {
    DoOpenFile(HotelManager receiver) {
        super(Label.OPEN_FILE, receiver);
    }

    @Override
    protected final void execute() throws CommandException {
      /*if (_receiver.changed() && Form.confirm(Message.saveBeforeExit())) {
        Do_313_Save cmd = new Do_313_Save(_receiver);
        cmd.execute();
      }
      _receiver.reset();*/
    }
}
