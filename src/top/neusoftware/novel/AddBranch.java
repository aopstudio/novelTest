package top.neusoftware.novel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddBranch
 */

public class AddBranch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBranch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String getName=request.getParameter("name");	//获取文件夹名(未解码）
		String parentName=URLDecoder.decode(getName, "UTF-8");	//参数解码，得到父分支文件夹名
		String getPath=request.getParameter("path");	//参数得到的原始路径字符串（还未解码）
		String parentPath=URLDecoder.decode(getPath, "UTF-8");	//参数解码，得到父分支路径
		File parent=new File(parentPath);
		File[] fs = parent.listFiles();
		int numberOfBranches=1;
		for(File f:fs){
			if(f.isDirectory())	{
				numberOfBranches++;	//得到当前所有已存在的分支数量+1
			}
		}
		String path=parentPath+"\\"+parentName+"-"+numberOfBranches;
		File directory=new File(path);	//新分支的文件夹
		directory.mkdirs();	//创建
		PrintWriter pw = new PrintWriter(new FileWriter(path+"\\1.txt"));
		String content=request.getParameter("content");
		pw.print(content);
        response.getWriter().println("提交成功");
        response.getWriter().println("<a href=\"http://localhost:8080/novelTest\">返回首页</a>");
        pw.close();
	}

}
