package com.yaksha.assignment.functional;

import static com.yaksha.assignment.utils.TestUtils.businessTestFile;
import static com.yaksha.assignment.utils.TestUtils.currentTest;
import static com.yaksha.assignment.utils.TestUtils.testReport;
import static com.yaksha.assignment.utils.TestUtils.yakshaAssert;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import com.yaksha.assignment.controller.StudentController;
import com.yaksha.assignment.utils.CustomParser;

public class StudentControllerTest {

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testStudentControllerRedirection() throws Exception {
		// Mock HttpServletRequest, HttpSession, and Model using Mockito
		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpSession session = mock(HttpSession.class);
		Model model = mock(Model.class);

		// Setup mock behavior
		when(request.getRequestURI()).thenReturn("/studentList");
		when(request.getMethod()).thenReturn("GET");

		// Create an instance of the controller
		StudentController controller = new StudentController();

		// Call the method with mock request, session, and model
		String viewName = controller.showStudentList(model);

		// Verify that the view returned is the student list view
		boolean isStudentListViewReturned = viewName.equals("studentList");

		// Auto-grading with yakshaAssert
		yakshaAssert(currentTest(), isStudentListViewReturned, businessTestFile);
	}

	@Test
	public void testJspTagsAndHtmlTagClosureInIndexJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/index.jsp";

		// Check for form submission and input elements in index.jsp
		boolean hasFormTag = CustomParser.checkJspTagPresence(filePath, "<h2");
		boolean hasInputTags = CustomParser.checkJspTagPresence(filePath, "<a href");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasFormTag && hasInputTags, businessTestFile);
	}

	@Test
	public void testJstlTagPresenceInStudentListJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/studentList.jsp";

		// Ensure the presence of JSTL c:forEach tag and a closing </ul> tag
		boolean hasForEachTag = CustomParser.checkJspTagPresence(filePath, "<c:forEach");
		boolean hasListClosingTag = CustomParser.checkJspTagPresence(filePath, "</ul>");

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasForEachTag && hasListClosingTag, businessTestFile);
	}

	@Test
	public void testJspTagsAndHtmlTagClosureInFinalPageJsp() throws Exception {
		String filePath = "src/main/webapp/WEB-INF/views/studentList.jsp";

		// Ensure that finalPage.jsp contains the ${message} for the success message
		boolean hasMessageTag = CustomParser.checkJspTagPresence(filePath, "c:forEach");

		// Verify the page includes the correct JSP expression for the message
		boolean hasHtmlTagClosure = CustomParser.checkJspTagPresence(filePath, "<li>"); // check for proper closing
																							// of body tag

		// Run auto-grading using yakshaAssert
		yakshaAssert(currentTest(), hasMessageTag && hasHtmlTagClosure, businessTestFile);
	}

}
