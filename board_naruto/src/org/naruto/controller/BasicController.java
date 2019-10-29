package org.naruto.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
	
	// 쿠키가 있는지 확인하는 메서드 -> 쿠키 있으면 가져와서 반환, 없으면 null 반환
	protected Cookie checkCookieExist(HttpServletRequest req, String cookieName) {
		
		//쿠키 생성
		Cookie[] cks = req.getCookies();
		
		//쿠키가 생성되지 않았으면 null
		if(cks == null || cks.length==0) {
			return null;
		}
		
		Optional<Cookie> result = Arrays.stream(cks)
				.filter(ck -> ck.getName().equals(cookieName)).findFirst();
		
		
		return result.isPresent() ? result.get() : null;
	}
	
	// 쿠키에 내가 클릭한 글번호 이미 있는지 없는지 확인하는 메서드
	// 있으면 true, 없으면 false 반환
	protected boolean checkCookieValue(Cookie targetCookie, String parameter, String token) {
		if(targetCookie == null || targetCookie.getValue().length() <= 1) {
			return false;
		}
		
		String[] arr = targetCookie.getValue().split(token);
		
		System.out.println(Arrays.toString(arr));
		
		Optional<String> result = Arrays.stream(arr).filter(str -> str.equals(parameter)).findFirst();
		
		return result.isPresent();
	}

}
