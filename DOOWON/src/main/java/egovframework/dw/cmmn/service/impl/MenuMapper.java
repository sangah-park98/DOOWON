package egovframework.dw.cmmn.service.impl;

import java.util.List;

import egovframework.dw.cmmn.service.SaveMenuVO;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("menuMapper")
public interface MenuMapper {

	List<?> selectMenuList(SearchVO vo);

	int selectMenuListCnt(SearchVO vo);

	List<?> selectUpprMenuDropdown();

	void insertPfMenuInfo(SaveMenuVO vo);

	String selectPfMenuId();
}
