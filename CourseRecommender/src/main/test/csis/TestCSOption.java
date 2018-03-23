package csis;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;

import courseSide.Course;
import courseSide.CourseRecommendation;
import studentSide.Major;
import studentSide.Student;
import studentSide.StudentRecords;
import util.KnowledgeSessionHelper;

public class TestCSOption {
	
	static KieContainer kieContainer;
	StatelessKieSession sessionStateless = null;
	KieSession sessionStatefull = null;
	
	static Major csMajor;
	static Course cs162;
	
	Student csStudent;
	StudentRecords csStuRecords;
	CourseRecommendation csStuRecommends;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		kieContainer = KnowledgeSessionHelper.createRuleBase();
		csMajor = new Major("Computer Science", "CSIS", "CS");
		cs162 = new Course (162, "Programming II", "CSIS", "01");
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		csStudent = new Student ("1000000", "Jon", "M"); 
		csStuRecords = new StudentRecords(csStudent, csMajor);
		csStuRecommends = new CourseRecommendation(csStudent);
	}

	@After
	public void tearDown() throws Exception {
		csStudent = null;
		csStuRecords = null;
		csStuRecommends = null;
	}

	@Test
	public void testTo162() {
		sessionStatefull = KnowledgeSessionHelper
				.getStatefulKnowledgeSessionWithCallBack(kieContainer, "ksession-csisrules");
		csStuRecords.addRecord("CSIS", 161, 3.0);
		
		

		sessionStatefull.insert(csStudent);
		sessionStatefull.insert(csStuRecords);
		sessionStatefull.insert(csStuRecommends);
		sessionStatefull.insert(csMajor);
		sessionStatefull.insert(cs162);
		
		
		sessionStatefull.fireAllRules();

		System.out.println("**************************");
		csStuRecommends.display();
	}

}
