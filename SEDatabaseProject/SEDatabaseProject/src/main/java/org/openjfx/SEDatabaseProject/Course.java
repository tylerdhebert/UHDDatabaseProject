package org.openjfx.SEDatabaseProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Course {

	private String courseID;
	private ArrayList<Student> enrolledStudents = new ArrayList<Student>();
	private Map<String, Integer> examOneScores = new HashMap<>();
	private Map<String, Integer> examTwoScores = new HashMap<>();
	private Map<String, Integer> examThreeScores = new HashMap<>();
	private Map<String, Integer> examFourScores = new HashMap<>();
	
	public Course(String courseID)
	{
		this.courseID = courseID;
	}
	
	public void addStudent(Student student)
	{
		enrolledStudents.add(student);
	}
	
	public void dropStudent(String studentID, Student student)
	{
		student.dropCourse(this.courseID);
		enrolledStudents.remove(enrolledStudents.indexOf(student));
	}
	
	public Integer getScore(int examNum, String studentID)
	{
		switch(examNum)
		{
		case 1:
			return examOneScores.get(studentID);
		case 2:
			return examTwoScores.get(studentID);
		case 3:
			return examThreeScores.get(studentID);
		case 4:
			return examFourScores.get(studentID);
		default:
			return 0;
		}
	}
	
	public void setScore(int examNum, String studentID, int score)
	{
		switch(examNum)
		{
			case 1:
				examOneScores.put(studentID, score);
				break;
			case 2:
				examTwoScores.put(studentID, score);
				break;
			case 3:
				examThreeScores.put(studentID, score);
				break;
			case 4:
				examFourScores.put(studentID, score);
				break;
			default:
				break;
		}
	}
}
