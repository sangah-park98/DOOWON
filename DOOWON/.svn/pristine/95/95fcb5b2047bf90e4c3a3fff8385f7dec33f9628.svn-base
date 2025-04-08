package egovframework.pf.news.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.news.service.pfNewsService;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

/**
 * @Class Name : ExportService.java
 * @Description : ExportService Class
 * @Modification Information
 * @
 * @         수정일            		       수정자           			수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.01.10          	서인석         			최초 생성
 *
 * @author 서인석
 * @since 2024.01.10
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KordSystems All right reserved.
 */

@Service("pfNewsService")
public class pfNewsServiceImpl extends EgovAbstractMapper implements pfNewsService {

	@Resource(name="pfNewsMapper")
	private pfNewsMapper pfNewsMapper;

	@Override
	public List<?> selectNewsViewList(SearchVO vo) throws Exception {
		return pfNewsMapper.selectNewsViewList(vo);
	}
	
	@Override
	public int selectNewsViewtotCnt(SearchVO vo) throws Exception {
		int cnt;
		cnt = pfNewsMapper.selectNewsViewtotCnt(vo);
		return cnt;
	}
	
	@Override
	public List<?> selectNewsModalViewList(SearchVO vo) throws Exception {
		return pfNewsMapper.selectNewsModalViewList(vo);
	}


}
