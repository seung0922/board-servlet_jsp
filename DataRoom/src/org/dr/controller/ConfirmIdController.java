package org.dr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dr.dao.MemberDAO;
import org.dr.dao.MemberVOImpl;

import lombok.extern.log4j.Log4j;

/**
 * Servlet implementation class ConfirmIdController
 */
@Log4j
@WebServlet("/member/confirm")
public class ConfirmIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	MemberDAO dao;
	
	public ConfirmIdController() {
		dao = new MemberVOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 입력한 파라미터 아이디 갖고온다.
		String mem_id = request.getParameter("id");
		
		// db에서 해당 아이디와 같은 값 있나 찾아본다.
		String r = dao.confirmId(mem_id);
		
		log.info(r);
		
		request.setAttribute("mem_id", r);
		
		request.getRequestDispatcher("../WEB-INF/views/member/confirmId.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
