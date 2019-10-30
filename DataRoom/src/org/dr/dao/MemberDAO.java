package org.dr.dao;

import org.dr.domain.MemberVO;

public interface MemberDAO extends CrudDAO<MemberVO, String> {
	
	public MemberVO selectOne(MemberVO vo);
	
	public String confirmId(String mem_id);
	
}
