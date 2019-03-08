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
		
		String getName=request.getParameter("name");	//��ȡ�ļ�����(δ���룩
		String parentName=URLDecoder.decode(getName, "UTF-8");	//�������룬�õ�����֧�ļ�����
		String getPath=request.getParameter("path");	//�����õ���ԭʼ·���ַ�������δ���룩
		String parentPath=URLDecoder.decode(getPath, "UTF-8");	//�������룬�õ�����֧·��
		File parent=new File(parentPath);
		File[] fs = parent.listFiles();
		int numberOfBranches=1;
		for(File f:fs){
			if(f.isDirectory())	{
				numberOfBranches++;	//�õ���ǰ�����Ѵ��ڵķ�֧����+1
			}
		}
		String path=parentPath+"\\"+parentName+"-"+numberOfBranches;
		File directory=new File(path);	//�·�֧���ļ���
		directory.mkdirs();	//����
		PrintWriter pw = new PrintWriter(new FileWriter(path+"\\1.txt"));
		String content=request.getParameter("content");
		pw.print(content);
        response.getWriter().println("�ύ�ɹ�");
        response.getWriter().println("<a href=\"http://localhost:8080/novelTest\">������ҳ</a>");
        pw.close();
	}

}
