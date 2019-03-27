package top.neusoftware.novel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Read
 */

public class Read extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Read() {
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
		
		response.getWriter().print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"utf-8\">\r\n" + 
				"<title>查看分支</title>\r\n" + 
				"<link href=\"https://cdn.bootcss.com/twitter-bootstrap/3.4.1/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<div class=\"container\">"+
				"<h1>小说内容</h1>    \r\n"+
				"<p>");
		
		String getName=request.getParameter("name");	//获取文件夹名
		String getPath=request.getParameter("path");	//获取文件夹完整路径
		String directoryPath=URLDecoder.decode(getPath, "UTF-8");	//选择txt文件
		String filePath=directoryPath+"\\1.txt";
		FileReader reader = new FileReader(filePath);
        BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
        String line;
        //网友推荐更加简洁的写法
        while ((line = br.readLine()) != null) {
            // 一次读入一行数据
        	response.getWriter().println(line);
        }
        
		response.getWriter().println("</p>\r\n" +
				"<a class=\"btn btn-primary btn-lg\" href=\"/novelTest/WriteBranch?directory="+URLEncoder.encode(getPath, "UTF-8")+"&name="+URLEncoder.encode(getName, "UTF-8")+"\">新建分支</a>\r\n" +
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
