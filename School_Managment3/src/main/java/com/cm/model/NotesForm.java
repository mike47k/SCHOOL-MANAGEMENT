package com.cm.model;

import java.util.List;

public class NotesForm {
	
	private List<Note> notes;

	public NotesForm(List<Note> notes) {
		super();
		this.notes = notes;
	}

	public NotesForm() {
		super();
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	public void addNote(Note note) {
		this.notes.add(note);
	}

}
