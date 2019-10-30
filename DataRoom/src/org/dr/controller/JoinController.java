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
		String[] values = new String[9];
		
		int i = 0;
		
		// 파라미터 값 반복문으로 가져와서 배열에 저장
		while (form.hasMoreElements()) {
			name = form.nextElement();
			System.out.println("param : " + name);
			values[i] = request.getParameter(name);
			
			// 공백 체크 - 공백이면 다시 가입폼으로
			if(values[i].indexOf(" ") != -1) {
				System.out.println("공백");
				response.sendRedirect("/member/join");
				return;
			}
			
			System.out.println("값 : " + values[i]);
			
			i++;
		}
		
		// 생년월일에서 월, 일 한자리 수일때 앞에 0 붙여주기
		values[4] = (values[4].length() == 1) ? "0" + values[4] : values[4];
		values[5] = (values[5].length() == 1) ? "0" + values[5] : values[5];
		
		// MemberVO 생성 한 뒤 VO에 값 초기화해줌
		MemberVO vo = new MemberVO();
		
		vo.setMem_id(values[0]);	// 아이디
		vo.setMem_pw(values[1]);	// 패스워드
		vo.setMem_name(values[2]);	// 이름
		vo.setMem_birth(values[3] + "-" + values[4] + "-" + values[5]);	// 생년월일 "년-월-일" 식으로 들어가도록
		vo.setMem_sex(values[6]);	// 성별
		vo.setMem_email(values[7]);	// 이메일
		vo.setMem_pn(values[8]);	// 핸드폰번호

		System.out.println(vo);
		
		// db에 member 값 insert
		dao.insert(vo);
		
		// login 페이지로 이동
		response.sendRedirect("/member/login?msg=sss");
		
	}

}
