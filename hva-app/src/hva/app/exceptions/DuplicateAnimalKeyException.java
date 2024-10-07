package hva.app.exceptions;

import pt.tecnico.uilib.menus.CommandException;

import java.io.Serial;

public class DuplicateAnimalKeyException extends CommandException {
	@Serial
	/** Serial number for serialization. */
	private static final long serialVersionUID = 202407081733L;

	/** @param id the duplicated key */
	public DuplicateAnimalKeyException(String id) {
		super(Message.duplicateAnimalKey(id));
	}
}
