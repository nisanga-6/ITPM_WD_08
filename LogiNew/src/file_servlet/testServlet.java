package file_servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class testServlet
 */
@WebServlet("/testServlet")
public class testServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public testServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("selectFactor");
		String code = request.getParameter("code");
		
		HttpSession session = request.getSession();
		session.setAttribute("test_code",code);
		
		if(type.equals("size")) {
			String sizeKeyword = request.getParameter("sizeKeyword");
			session.setAttribute("sizeKeyword",sizeKeyword);
			String sizeIdentifier = request.getParameter("sizeIdentifier");
			session.setAttribute("sizeIdentifier",sizeIdentifier);
			String sizeOperator = request.getParameter("sizeOperator");
			session.setAttribute("sizeOperator",sizeOperator);
			String sizeNumerical = request.getParameter("sizeNumerical");
			session.setAttribute("sizeNumerical",sizeNumerical);
			String sizeString = request.getParameter("sizeString");
			session.setAttribute("sizeString",sizeString);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resultSize.jsp");
			dispatcher.forward(request, response);
		}else if(type.equals("variable")) {
			String variableGlobal = request.getParameter("variableGlobal");
			session.setAttribute("variableGlobal",variableGlobal);
			String variableLocal = request.getParameter("variableLocal");
			session.setAttribute("variableLocal",variableLocal);
			String variablePrimitive = request.getParameter("variablePrimitive");
			session.setAttribute("variablePrimitive",variablePrimitive);
			String variableComposite = request.getParameter("variableComposite");
			session.setAttribute("variableComposite",variableComposite);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resultVariable.jsp");
			dispatcher.forward(request, response);
		}else if(type.equals("method")) {
			String methodPrimitive = request.getParameter("methodPrimitive");
			session.setAttribute("methodPrimitive",methodPrimitive);
			String methodComposite = request.getParameter("methodComposite");
			session.setAttribute("methodComposite",methodComposite);
			String methodPrimitiveData = request.getParameter("methodPrimitiveData");
			session.setAttribute("methodPrimitiveData",methodPrimitiveData);
			String methodCompositeData = request.getParameter("methodCompositeData");
			session.setAttribute("methodCompositeData",methodCompositeData);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resultMethod.jsp");
			dispatcher.forward(request, response);
		}else if(type.equals("controlStructure")) {
			String condition = request.getParameter("condition");
			session.setAttribute("condition",condition);
			String loop = request.getParameter("loop");
			session.setAttribute("loop",loop);
			String switchCase = request.getParameter("switchCase");
			session.setAttribute("switchCase",switchCase);
			String caseOnly = request.getParameter("caseOnly");
			session.setAttribute("caseOnly",caseOnly);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resultControl.jsp");
			dispatcher.forward(request, response);
		}else if(type.equals("inheritance")) {
			String Inheritance = request.getParameter("Inheritance");
			session.setAttribute("Inheritance",Inheritance);
			String Inheritance1 = request.getParameter("Inheritance1");
			session.setAttribute("Inheritance1",Inheritance1);
			String Inheritance2 = request.getParameter("Inheritance2");
			session.setAttribute("Inheritance2",Inheritance2);
			String Inheritance3 = request.getParameter("Inheritance3");
			session.setAttribute("Inheritance3",Inheritance3);
			String Inheritance4 = request.getParameter("Inheritance4");
			session.setAttribute("Inheritance4",Inheritance4);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resultIheritance.jsp");
			dispatcher.forward(request, response);
		}else if(type.equals("coupling")) {
			String recursive = request.getParameter("recursive");
			session.setAttribute("recursive",recursive);
			String regularRegular = request.getParameter("regularRegular");
			session.setAttribute("regularRegular",regularRegular);
			String regularRecursive = request.getParameter("regularRecursive");
			session.setAttribute("regularRecursive",regularRecursive);
			String recursiveRecursive = request.getParameter("recursiveRecursive");
			session.setAttribute("recursiveRecursive",recursiveRecursive);
			String recursiveRegular = request.getParameter("recursiveRegular");
			session.setAttribute("recursiveRegular",recursiveRegular);
			String regularGlobal = request.getParameter("regularGlobal");
			session.setAttribute("regularGlobal",regularGlobal);
			String recursiveGlobal = request.getParameter("recursiveGlobal");
			session.setAttribute("recursiveGlobal",recursiveGlobal);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resultCoplings.jsp");
			dispatcher.forward(request, response);
		}else if(type.equals("all")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/resultAll.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
