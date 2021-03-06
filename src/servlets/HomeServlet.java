package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;
import java.util.ResourceBundle;
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String languageCode = request.getParameter("language");
		Locale locale = null;
		if(languageCode == null) {
			languageCode = (String)request.getSession().getAttribute("languageCode");
			if(languageCode == null){
				locale = Locale.getDefault();
			}else {
				locale = new Locale(languageCode);
			}
		}else {
			request.getSession().setAttribute("languageCode", languageCode);
			locale = new Locale(languageCode);
		}
        ResourceBundle apptexts = ResourceBundle.getBundle("apptexts", locale);
		
        request.getSession().setAttribute("apptext", apptexts);
        
		request.getRequestDispatcher("WEB-INF/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
