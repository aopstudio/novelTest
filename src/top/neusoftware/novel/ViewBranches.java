package top.neusoftware.novel;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddBranch
 */

public class ViewBranches extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewBranches() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"utf-8\">\r\n" + 
				"<title>查看全部分支</title>\r\n" + 
				"<link href=\"https://cdn.bootcss.com/twitter-bootstrap/3.4.1/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
				"<link rel=\"stylesheet\" href=\"/novelTest/css/jquery.treeview.css\" />\r\n" + 
				"<script src=\"https://cdn.bootcss.com/jquery/1.4.2/jquery.min.js\"></script>"+
				"<script src=\"/novelTest/js/jquery.treeview.js\" type=\"text/javascript\"></script>"+		
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<div class=\"container\">"+
				"<h1>查看全部分支</h1>    \r\n" + 
				"<ul id=\"tree\">");
		String path = "D:\\novels";		//要遍历的路径
		File file = new File(path);
		Functions.allFiles(file, response);
		response.getWriter().print("</ul>\r\n"+
				
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
