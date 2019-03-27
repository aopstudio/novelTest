package top.neusoftware.novel;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletResponse;

public class Functions {
	public static void func(File file,HttpServletResponse response) throws IOException{
		File[] fs = file.listFiles();
		for(File f:fs){
			if(f.isDirectory())	{//打印目录
				String getPath=f.getPath();
				String path=URLEncoder.encode(getPath, "UTF-8");
				String getName=f.getName();
				String name=URLEncoder.encode(getName, "UTF-8");
				response.getWriter().println("<a class=\"list-group-item\" href=\"/novelTest/Read?path="+path+"&name="+name+"\">"+getName+"</a>");
				func(f,response);
			}
		}
	}

}
