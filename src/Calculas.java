import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculas")
public class Calculas extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String operation = request.getParameter("operation");

        if ("ADD/ SUBTRACT/ MULTIPY/ DIVIDE".equals(operation)) {
            performAllCalculations(request, out);
        } else {
            performSingleCalculation(request, out, operation);
        }
    }

    private void performSingleCalculation(HttpServletRequest request, PrintWriter out, String operation) {
        // Existing code for single calculations
        // ...
    }

    private void performAllCalculations(HttpServletRequest request, PrintWriter out) {
    	 int num1 = Integer.parseInt(request.getParameter("num1"));
    	    int num2 = Integer.parseInt(request.getParameter("num2"));

    	    out.println("<html>");
    	    out.println("<head>");
    	    out.println("<style>");
    	    out.println("body {");
    	    out.println("    display: flex;");
    	    out.println("    justify-content: center;");
    	    out.println("    align-items: center;");
    	    out.println("    height: 100vh;");
    	    out.println("    margin: 0;");
    	    out.println("    background-color: pink;");
    	    out.println("}");
    	    out.println(".calculator-container {");
    	    out.println("    text-align: center;");
    	    out.println("    padding: 40px;");
    	    out.println("    border: 1px solid #ccc;");
    	    out.println("    border-radius: 15px;");
    	    out.println("    box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);");
    	    out.println("    width: 400px;");
    	    out.println("    background-color:lightblue;");
    	    out.println("}");
    	    out.println("</style>");
    	    out.println("</head>");
    	    out.println("<body>");
    	    out.println("<div class='calculator-container'>");
    	    out.println("<h2><u>ALL CALCULATIONS</u></h2>");

    	    // Perform calculations and add results to the container
    	    int additionResult = num1 + num2;
    	    int subtractionResult = num1 - num2;
    	    int multiplicationResult = num1 * num2;

    	    out.println("ADDITION: " + additionResult + "<br>");
    	    out.println("SUBTRACTION: " + subtractionResult + "<br>");
    	    out.println("MULTIPLICATION: " + multiplicationResult + "<br>");

    	    if (num2 != 0) {
    	        double divisionResult = (double) num1 / num2;
    	        out.println("DIVISION: " + divisionResult + "<br>");
    	    } else {
    	        out.println("DIVISION: Cannot divide by zero<br>");
    	    }

    	    out.println("</div>");
    	    out.println("</body>");
    	    out.println("</html>");
    	}
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
