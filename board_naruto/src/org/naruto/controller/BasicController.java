package org.naruto.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BasicController
 */
public abstract class BasicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void service(HttpServletRequest req
			, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String path = req.getRequestURI(); 
		
		System.out.println("PATH: " + path);
		
		String methodType = req.getMethod(); 
		
		System.out.println("Method: " + methodType);
		
		Method[] methods = this.getClass().getDeclaredMethods(); 
		System.out.println(methods[0]);
		Method targetMethod = null;
		
		for (int i = 0; i < methods.length; i++) {
			Method m = methods[i]; 
			RequestMapping anno =
						m.getDeclaredAnnotation(RequestMapping.class);
			System.out.println("anno : "+anno);
			String annoPath = anno.value();
			System.out.println("annopath : "+annoPath);
			String annoType = anno.type();
			System.out.println("annoType : "+annoType);
			if (path.equals(annoPath) && (annoType.equals(methodType))) { 
				targetMethod = m; 
				break; 
			}
			
		}
		
		try {
			
			System.out.println("targetMethod: " + targetMethod);
			
			String result = (String)targetMethod.invoke(this, req, res); 
			
			System.out.println(result);
			if(result.startsWith("redirect:")) { 
				System.out.println(result.substring(10));
				res.sendRedirect(result.substring(10)); 
				
			} else {
				req.getRequestDispatcher("/WEB-INF/views" + result + ".jsp")
				.forward(req, res);
			}
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
