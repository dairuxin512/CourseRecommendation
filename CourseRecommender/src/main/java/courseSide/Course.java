package courseSide;

import java.util.Arrays;

public class Course {
	private int courseNum;
	private String courseName, courseCode, section;
	private boolean[] term;
	
	public Course(int cNum, String cName, String cCode, String sec) {
		courseNum = cNum;
		courseName = cName;
		courseCode = cCode;
		section = sec;
		term = new boolean[10]; //fall, spring, j-term, summer1, summer2 (?)
	}
	
	public int getCourseNum() {
		return courseNum;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public String getSection() {
		return section;
	}
	
	public boolean[] getTerm() {
		return term;
	}
	
	public void setCourseNum(int courseNum) {
		this.courseNum = courseNum;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public void setSection(String section) {
		this.section = section;
	}
	
	public void setTerm(boolean[] term) {
		this.term = term;
	}

	@Override
	public String toString() {
		return "Course [courseNum=" + courseNum + ", courseName=" + courseName + ", courseCode=" + courseCode
				+ ", section=" + section + ", term=" + Arrays.toString(term) + "]";
	}
	
}
