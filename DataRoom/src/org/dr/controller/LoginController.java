package org.dr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dr.dao.MemberDAO;
import org.dr.dao.MemberVOImpl;
import org.dr.domain.MemberVO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/member/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberDAO dao;

	public LoginController() {
		dao = new MemberVOImpl();
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("login get...............................");
		request.getRequestDispatcher("../WEB-INF/views/member/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("login post.................");

		String mem_id = request.getParameter("mem_id");
		String mem_pw = request.getParameter("mem_pw");
		
		System.out.println("mem_id" + mem_id);
		System.out.println("mem_pw" + mem_pw);
		
		MemberVO vo = new MemberVO();
		
		vo.setMem_id(mem_id);
		vo.setMem_pw(mem_pw);
		
		System.out.println("vo: " + vo);

		MemberVO result = dao.selectOne(vo);
		
		System.out.println("result: " + result);
    	
    	HttpSession session = request.getSession();
    	
    	session.setAttribute("result", result);

    	response.sendRedirect("/board/list");

	}

}
