package egovframework.ms.imp.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.ms.imp.service.msImportService;
import egovframework.pf.cmmn.service.SearchVO;

import egovframework.pf.imp.service.ImportService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : ImportService.java
 * @Description : ImportService Class
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

@Service("msimportService")
public class msImportServiceImpl extends EgovAbstractServiceImpl implements msImportService {


	@Resource(name="msimportMapper")
	private msImportMapper msimportMapper;

	@Override
	public List<?> selectImportViewList2(SearchVO vo) throws Exception {
		return msimportMapper.selectImportViewList2(vo);
	}
	
	@Override
	public int selectImportViewListCnt2(SearchVO vo) throws Exception {
		int cnt;
		cnt = msimportMapper.selectImportViewListCnt2(vo);
		return cnt;
	}
	
	@Override
	public List<?> selectImportViewLanList2(SearchVO vo) throws Exception {
		return msimportMapper.selectImportViewLanList2(vo);
	}
	@Override
	public List<?> selectImportViewSpecList2(SearchVO vo) throws Exception {
		return msimportMapper.selectImportViewSpecList2(vo);
	}
	@Override
	public List<?> selectImportBlList2(SearchVO vo) throws Exception {
		return msimportMapper.selectImportBlList2(vo);
	}

	@Override
	public int selectImportBlListCnt2(SearchVO vo) throws Exception {
		int cnt;
		cnt = msimportMapper.selectImportBlListCnt2(vo);
		return cnt;
	}

	@Override
	public List<?> selectImportUpdateList2(SearchVO vo) throws Exception {
		return msimportMapper.selectImportUpdateList2(vo);
	}

	@Override
	public int selectImportUpdateListCnt2(SearchVO vo) throws Exception {
		int cnt;
		cnt = msimportMapper.selectImportUpdateListCnt2(vo);
		return cnt;
	}
	
	
}
