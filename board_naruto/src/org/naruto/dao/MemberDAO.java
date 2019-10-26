package org.naruto.dao;

import org.naruto.domain.MemberVO;

public interface MemberDAO extends CrudDAO<MemberVO, String>{
	public MemberVO select(MemberVO vo);
}
