package org.dr.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dr.dao.MemberDAO;
import org.dr.dao.MemberVOImpl;
import org.dr.domain.MemberVO;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/member/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDAO dao;
	
	public JoinController() {
		dao = new MemberVOImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("join get.............");
		request.getRequestDispatcher("../WEB-INF/views/member/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("join post.............");

		Enumeration<String> form = request.getParameterNames();
		
		String name = "";
		String[] values = new String[7];
		
		int i = 0;
		
		while (form.hasMoreElements()) {
			name = form.nextElement();
			System.out.println("param : " + name);
			values[i] = request.getParameter(name);
			
			// 공백과 널 체크..
//			if(values[i].indexOf(" ") != -1 || values[i] == null) {
//				System.out.println("공백");
//				response.sendRedirect("/member/join");
//				return;
//			}
			
			System.out.println("값 : " + values[i]);
			
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

		System.out.println(vo);
		
		dao.insert(vo);
		
		response.sendRedirect("/board/list");
		
	}

}
