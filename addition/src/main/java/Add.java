
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException ,IOException {
	 String firstNumber = request.getParameter("firstNumber");
	 String secondNumber = request.getParameter("secondNumber");
	 
	 int firstNumber1=Integer.parseInt(firstNumber);
	 int secondNumber1=Integer.parseInt(secondNumber);
	 
	 int result=firstNumber1+secondNumber1;
	 
	 PrintWriter out = response.getWriter();
	 out.println("The added value=" +result);
}
}

	 
	 
	 