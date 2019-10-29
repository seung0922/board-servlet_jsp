package org.dr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dr.domain.BoardVO;
import org.dr.dto.PagingDTO;
import org.dr.util.MyBatisLoader;

public class BoardDAOImpl implements BoardDAO {

	private SqlSessionFactory factory = MyBatisLoader.INSTANCE.getFactory();

	public static void main(String[] args) {
		
		BoardDAO dao = new BoardDAOImpl();
		BoardVO vo = new BoardVO();
		
		// insert
//		vo.setTitle("제목ㅎㅎ...");
//		vo.setContent("내용ㅎㅎ...");
//		vo.setWriter("작성자ㅎㅎ...");
//		dao.insert(vo);
		
		// select
		dao.selectOne(100L);
		
	}

	// 게시물 등록
	public boolean insert(BoardVO vo) {
		boolean result = false;
		int a = 0;
		try {

			SqlSession session = factory.openSession();
			a = session.insert("org.dr.dao.BoardMapper.insert", vo);
			
			session.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		result = a == 1 ? true : false;
		
		System.out.println(result);
		
		return result;
	}

	// 게시물 조회
	@Override
	public BoardVO selectOne(Long bno) {
		BoardVO result = null;

		try {

			SqlSession session = factory.openSession();
			result = session.selectOne("org.dr.dao.BoardMapper.selectOne", bno);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	// 글 리스트 가져오기
	@Override
	public List<BoardVO> selectList(PagingDTO dto) {
		List<BoardVO> result = null;

		try {
			SqlSession session = factory.openSession();
			result = session.selectList("org.dr.dao.BoardMapper.selectList", dto);
			System.out.println(result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	// 게시물 수정
	@Override
	public boolean update(BoardVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	// 게시물 삭제
	@Override
	public boolean delete(Long bno) {
		// TODO Auto-generated method stub
		return false;
	}

	// 게시물 전체 개수 구하기
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	// 글 조회수 구하기
	@Override
	public boolean updateViewCnt(Long bno) {
		// TODO Auto-generated method stub
		return false;
	}

}
