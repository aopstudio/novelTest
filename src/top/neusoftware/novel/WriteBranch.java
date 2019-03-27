package top.neusoftware.novel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WriteBranch
 */
@WebServlet("/WriteBranch")
public class WriteBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteBranch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		response.getWriter().println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"utf-8\">\r\n" + 
				"<title>新建分支</title>\r\n" + 
				"<link href=\"https://cdn.bootcss.com/twitter-bootstrap/3.4.1/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"    \r\n" + 
				"<div class=\"container\">\r\n" + 
				"    <h1>新建分支</h1>\r\n" + 
				"    <form action=\"AddBranch\" class=\"col-md-10\" method=\"POST\">\r\n" + 
				"    <input type=\"hidden\" value=\""+
					request.getParameter("directory") + 
				"\" name=\"path\"></input>\r\n" + 
				"    <input type=\"hidden\" value=\""+
					request.getParameter("name") + 
				"\" name=\"name\"></input>\r\n" + 
				"    <h2>内容</h2>\r\n" + 
				"    <textarea class=\"form-control\" name=\"content\"></textarea>\r\n" + 
				"    <button type=\"submit\" class=\"btn btn-default\">提交</button>\r\n" + 
				"    </form>\r\n" + 
				"</div>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
