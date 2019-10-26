package org.naruto.dao;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.naruto.domain.MemberVO;
import org.naruto.dto.PagingDTO;
import org.naruto.util.MyBatisLoader;

public class MemberDAOImpl implements MemberDAO {
	
	SqlSessionFactory factory = MyBatisLoader.INSTANCE.getFactory();
	
	
	@Override
	public boolean insert(MemberVO vo) {
		boolean result = false;
		int rs = 0;
		try(SqlSession session = factory.openSession())
		{
			rs = session.insert("org.naruto.dao.MemberMapper.join",vo);
			session.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		result = rs==1?true:false;
		System.out.println(result);
		return result;
	}
	@Override
	public MemberVO select(MemberVO vo) {
		MemberVO result = null;
		try(SqlSession session = factory.openSession())
		{
			result = session.selectOne("org.naruto.dao.MemberMapper.select",vo);
			
			System.out.println(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
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
	public List<MemberVO> getList(PagingDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAOImpl();
		MemberVO vo = new MemberVO();
		vo.setMem_id("home");
		vo.setMem_pw("123");
		vo.setMem_name("집");
		vo.setMem_birth("2019-12-04");
		vo.setMem_sex("1");
		vo.setMem_email("123@mdd.com");
		vo.setMem_pn("010-1234-5678");
		
		dao.insert(vo);
	}
	@Override
	public MemberVO select(String key) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
}
