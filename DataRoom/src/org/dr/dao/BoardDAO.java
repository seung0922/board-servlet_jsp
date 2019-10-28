package org.dr.dao;

import org.dr.domain.BoardVO;

public interface BoardDAO extends CrudDAO<BoardVO, Long> {

	public int getCount();

	public boolean updateViewCnt(Long bno);

}
