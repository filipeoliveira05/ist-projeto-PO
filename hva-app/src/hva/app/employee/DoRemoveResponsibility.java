package hva.app.employee;

import hva.Hotel;
import hva.exceptions.UnknownEmployeeException;

import hva.app.exceptions.NoResponsibilityException;
import hva.app.exceptions.UnknownEmployeeKeyException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;


class DoRemoveResponsibility extends Command<Hotel> {

    DoRemoveResponsibility(Hotel receiver) {
        super(Label.REMOVE_RESPONSABILITY, receiver);
        addStringField("idEmployee", Prompt.employeeKey());
        addStringField("idResponsability", Prompt.responsibilityKey());
    }

    @Override
    protected void execute() throws CommandException {
        try {
            _receiver.removeResponsibilityOfEmployee(stringField("idEmployee"), stringField("idResponsability"));
        
        } catch (hva.exceptions.NoResponsibilityException e) {
            throw new NoResponsibilityException(e.getEmployeeKey(), e.getResponsabilityKey());
        
        } catch (UnknownEmployeeException e) {
            throw new UnknownEmployeeKeyException(e.getKey());
        }
    }
}