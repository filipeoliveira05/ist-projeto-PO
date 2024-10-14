package hva.app.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import hva.HotelManager;
import hva.app.exceptions.FileOpenFailedException;
import hva.exceptions.UnavailableFileException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

class DoOpenFile extends Command<HotelManager> {
  DoOpenFile(HotelManager receiver) {
    super(Label.OPEN_FILE, receiver);
  }

  @Override
  protected final void execute() throws CommandException {
    try {
      if (_receiver.dirty() && Form.confirm(Prompt.saveBeforeExit())) {
        DoSaveFile cmd = new DoSaveFile(_receiver);
        cmd.execute();
      }
      _receiver.load(Form.requestString(Prompt.openFile()));
    } catch (UnavailableFileException e) {
        throw new FileOpenFailedException(e);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}