package org.openjfx.SEDatabaseProject;

import java.util.ArrayList;

public class Student extends Person{
	public ArrayList<String> enrolledCourses;
	
	public Student(String name, String schoolID, Boolean editPermissions, ArrayList<String> enrolledCourses)
	{
		super(name, schoolID, editPermissions);
		this.enrolledCourses = enrolledCourses;
	}
	
	public void dropCourse(String courseID)
	{
		enrolledCourses.remove(enrolledCourses.indexOf(courseID));
	}
}
