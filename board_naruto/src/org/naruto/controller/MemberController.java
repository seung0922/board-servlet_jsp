package org.naruto.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.naruto.dao.MemberDAO;
import org.naruto.dao.MemberDAOImpl;
import org.naruto.domain.MemberVO;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends BasicController {
	private static final long serialVersionUID = 1L;
       
	MemberDAO dao;
    
    public MemberController() {
    	dao = new MemberDAOImpl();
    }

    @RequestMapping(value="/member/login",type="GET")
    protected String LoginGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	return "/member/login";
    }
    
    @RequestMapping(value="/member/login",type="POST")
	protected String LoginPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String mem_id = request.getParameter("mem_id");
    	String mem_pw = request.getParameter("mem_pw");
    	MemberVO vo = new MemberVO();
    	vo.setMem_id(mem_id);
    	vo.setMem_pw(mem_pw);
    	
    	MemberVO result = dao.select(vo);
    	if(result ==null) {
    		response.sendRedirect("/member/login?msg=error");
    	}
    	
    	HttpSession session = request.getSession();
    	
    	session.setAttribute("result", result);
    	
			
		return "/member/myPage";
	}
    @RequestMapping(value="/member/join", type="GET")
    protected String joinGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	return "/member/join";	
    }
    @RequestMapping(value="/member/join", type="POST")
    protected String joinPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Enumeration<String> form = request.getParameterNames();
    	String name = "";
    	String[] values = new String[8];
    	int i = 0;
    	while(form.hasMoreElements()) {
    		name = form.nextElement();
    		System.out.println("param : "+name);
    		values[i] = request.getParameter(name);
    		System.out.println(values[i]);
    		i++;
    	}
		MemberVO vo = new MemberVO();
		vo.setMem_id(values[0]);
		vo.setMem_pw(values[1]);
		vo.setMem_name(values[2]);
		vo.setMem_birth(values[3]);
		vo.setMem_sex(values[4]);
		vo.setMem_email(values[5]);
		vo.setMem_pn(values[6]);
		
		dao.insert(vo);
		
    	return "redirect:/login";	
    }
    @RequestMapping(value="/member/logout", type="GET")
    protected String logOutGET(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
    	return "/member/logout";	
    }
    @RequestMapping(value="/member/logout", type="POST")
    protected String logOutPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession session = request.getSession();
    	session.invalidate();
    
    	return "redirect:/login?msg=logout";	
    }
    @RequestMapping(value="/member/myPage", type="GET")
	protected String myPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	return "/member/myPage";
	}


}
