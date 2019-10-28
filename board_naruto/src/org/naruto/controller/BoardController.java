package org.naruto.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.naruto.dao.BoardDAO;
import org.naruto.dao.BoardDAOImple;
import org.naruto.domain.BoardVO;
import org.naruto.dto.PageMaker;
import org.naruto.dto.PagingDTO;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/board/*") // board로 시작하는 모든 애들 다받음
public class BoardController extends BasicController {
	private static final long serialVersionUID = 1L;

	private BoardDAO dao;

	public BoardController() {
		dao = new BoardDAOImple();
	}

	@RequestMapping(value = "/board/register", type = "GET")
	public String add(HttpServletRequest req, HttpServletResponse res) throws Exception {

		System.out.println("add...............");

		return "/board/register";
	}

	@RequestMapping(value = "/board/list", type = "GET")
	public String list(HttpServletRequest req, HttpServletResponse res) throws Exception {

		// 파라미터 수집 -> pageDTO 변환
		PagingDTO dto = new PagingDTO(req.getParameter("page"), req.getParameter("amount"));

		// Model 완성
		req.setAttribute("list", dao.getList(dto));
		req.setAttribute("pm", new PageMaker(dao.getCount(), dto));

		System.out.println("list...............");

		return "/board/list";
	}

	@RequestMapping(value = "/board/register", type = "POST")
	public String addPost(HttpServletRequest req, HttpServletResponse res) throws Exception {

		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");

		BoardVO vo = new BoardVO();

		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(writer);

		boolean insert = dao.insert(vo);

		System.out.println(insert);
		System.out.println("add.post.................");
		System.out.println(req.getParameter("title"));

		return "redirect:/list";
	}

	@RequestMapping(value = "/board/delete", type = "get")
	public String deleteGet(HttpServletRequest req, HttpServletResponse res) {

		BoardVO vo = new BoardVO();

		String bno = req.getParameter("bno");
		Long bnos = Long.parseLong(bno);

		vo.setBno(bnos);

		boolean delete = dao.delete(bnos);

		System.out.println(delete);

		return "redirect:/list";
	}

	@RequestMapping(value = "/board/read", type = "GET")
	public String Read(HttpServletRequest req, HttpServletResponse res) {

		// Cookie targetCookie = checkCookieExist(req, 쿠키이름)

		// existCookie = targetCookie == null;

		// already = checkCookieValue(bno, '%');

		// 조회수 쿠키를 확인한다. - RecentViewCookie => existCookie
		// 값을 가져오고 %로 분리
		// 해당 bno값이 있는지 확인 - already

		// if already가 false라면
		// 조회시에 update 하고 가져온다.
		// else

//		long bno = Long.parseLong(req.getParameter("bno"));

//		req.setAttribute("board", dao.selectOne(bno));

		// existCookie false
		// RecentViewCookie 생성

		// tagetCookie에
		Cookie targetCookie = checkCookieExist(req, "RecentView");
		boolean existCookie = targetCookie != null;

		boolean already = checkCookieValue(targetCookie, req.getParameter("bno"), "%");

		System.out.println("targetCookie" + targetCookie);
		System.out.println("already : " + already);

		// Cookie targetCookie = checkCookieExist (req,쿠키이름)
		// existCookie = targetCookie == null;
		// already = checkCookieValue(bno,'%');

		// 조회수 쿠키를 확인한다. -RecentViewCookie =>existCookies
		// 값을 가져오고 %로 분리
		// 해당 bno값이 있는지 확인 - already

		// if already가 false라면
		// 조회시에 update하고 가져온다.
		// else
		long bno = Long.parseLong(req.getParameter("bno"));
		if (already == false) {
			dao.updateViewCnt(bno);
		}
		
		req.setAttribute("board", dao.selectOne(bno));
		
		// exisCookiew false
		// RecentViewCookie 생성하고 response추가
		if (existCookie == false) {
			Cookie ck = new Cookie("RecentView", bno + "%");
			ck.setMaxAge(60 * 60 * 24); // a day
			ck.setPath("/board");
			res.addCookie(ck);
			System.out.println("신규쿠키발행");
		} else {// 있음
			String value = targetCookie.getValue();

			value += bno + "%";
			targetCookie.setValue(value);

			res.addCookie(targetCookie);

		}

		return "/board/read";
	}

}
