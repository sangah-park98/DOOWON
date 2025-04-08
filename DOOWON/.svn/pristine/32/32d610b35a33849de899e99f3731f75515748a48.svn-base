package egovframework.pf.cmmn.service.impl;

import java.util.List;

import egovframework.pf.cmmn.service.SaveMenuVO;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;



@Mapper("menuMapper")
public interface MenuMapper {

	List<?> selectMenuList(SearchVO vo);

	int selectMenuListCnt(SearchVO vo);

	List<?> selectUpprMenuDropdown();

	void insertPfMenuInfo(SaveMenuVO vo);

	String selectPfMenuId();
}
