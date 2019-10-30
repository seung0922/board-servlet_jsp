package org.dr.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.dr.domain.MemberVO;
import org.dr.dto.PagingDTO;
import org.dr.util.MyBatisLoader;

public class MemberVOImpl implements MemberDAO {

	private SqlSessionFactory factory = MyBatisLoader.INSTANCE.getFactory();

	@Override
	public boolean insert(MemberVO vo) {

		boolean result = false;

		int a = 0;

		try {

			SqlSession session = factory.openSession();
			a = session.insert("org.dr.dao.MemberMapper.join", vo);

			session.commit();

		} catch (Exception e) {
			e.printStackTrace();
		}

		result = a == 1 ? true : false;

		System.out.println(result);

		return result;
	}

	@Override
	public boolean update(MemberVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<MemberVO> selectList(PagingDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		
		MemberVO result = null;

		try {
			
			SqlSession session = factory.openSession();
			
			result = session.selectOne("org.dr.dao.MemberMapper.selectOne", vo);

		} catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}

		System.out.println(result);

		return result;
	}

	@Override
	public MemberVO selectOne(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String confirmId(String mem_id) {
		String result = "";

		try {
			
			SqlSession session = factory.openSession();
			
			result = session.selectOne("org.dr.dao.MemberMapper.confirmId", mem_id);

		} catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}

		System.out.println(result);

		return result;
	}

}
