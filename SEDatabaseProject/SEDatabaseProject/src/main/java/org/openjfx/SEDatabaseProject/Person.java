package org.openjfx.SEDatabaseProject;

public class Person {
	public String name;
	public String schoolID;
	public Boolean editPermissions;
	
	public Person(String name, String schoolID, Boolean editPermissions) {
		this.name = name;
		this.schoolID = schoolID;
		this.editPermissions = editPermissions;
	}
}
