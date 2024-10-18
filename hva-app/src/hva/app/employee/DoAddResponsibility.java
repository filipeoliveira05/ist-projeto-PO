package hva.app.employee;

import hva.Hotel;

import hva.app.exceptions.NoResponsibilityException;

import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

import java.text.Normalizer.Form;

class DoAddResponsibility extends Command<Hotel> {

    DoAddResponsibility(Hotel receiver) {
        super(Label.ADD_RESPONSABILITY, receiver);
        addStringField("idEmployee", Prompt.employeeKey());
        addStringField("idResponsability", Prompt.responsibilityKey());
    }

    @Override
    protected void execute() throws CommandException{
        try {
            _receiver.addResponsibilityToEmployee(stringField("idEmployee"), stringField("idResponsability"));
        } catch (hva.exceptions.NoResponsibilityException e) {
            throw new NoResponsibilityException(e.getEmployeeKey(), e.getResponsabilityKey());
        }
    }
}
