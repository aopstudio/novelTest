package top.neusoftware.novel;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

public class Functions {
	public static void allFiles(File file,HttpServletResponse response) throws IOException{	//遍历当前文件夹及子文件夹的文件
		File[] fs = file.listFiles();
		for(File f:fs){
			response.getWriter().println("<ul>");
			if(f.isDirectory())	{//打印目录
				
				String getPath=f.getPath();
				String path=URLEncoder.encode(getPath, "UTF-8");
				String getName=f.getName();
				String name=URLEncoder.encode(getName, "UTF-8");
				response.getWriter().println("<li><a href=\"/novelTest/Read?path="+path+"&name="+name+"\">"+getName+"</a></li>");
				allFiles(f,response);
			}
			response.getWriter().println("</ul>");
		}
	}
	public static void presentFiles(String directoryPath,HttpServletResponse response) throws IOException{	//遍历当前文件夹的文件（不遍历子文件夹）
		File file = new File(directoryPath);
		File[] fs = file.listFiles();
		boolean empty=true;
		for(File f:fs){		
			if(f.isDirectory())	{//打印目录
				empty=false;
				String getPath=f.getPath();
				String path=URLEncoder.encode(getPath, "UTF-8");
				String getName=f.getName();
				String name=URLEncoder.encode(getName, "UTF-8");
				response.getWriter().println("<a class=\"list-group-item\" href=\"/novelTest/Read?path="+path+"&name="+name+"\">"+getName+"</a>");
			}
		}
		if(empty) {
			response.getWriter().println("<p>暂时无分支，等你来续写</p>");
		}
	}
}
