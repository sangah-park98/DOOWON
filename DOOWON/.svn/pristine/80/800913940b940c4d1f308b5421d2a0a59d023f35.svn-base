package egovframework.pf.rpt.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.rpt.service.KPIService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : KPIServiceImpl.java
 * @Description : KPIServiceImpl Class
 * @Modification Information
 * @
 * @         수정일            		       수정자           			수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.04.04          	이재성         			최초 생성
 *
 * @author 이재성
 * @since 2024.04.04
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KordSystems All right reserved.
 */

@Service("kpiService")
public class KPIServiceImpl extends EgovAbstractServiceImpl implements KPIService {


	@Resource(name="kpiMapper")
	private KPIMapper kpiMapper;
	
	// 수입 정확성 관리
	@Override
	public List<?> selectKpiImportList(SearchVO vo) throws Exception {
		return kpiMapper.selectKpiImportList(vo);
	}
	
	// 수입 정확성 관리 갯수
	@Override
	public int selectKpiImportListCnt(SearchVO vo) throws Exception {
		return kpiMapper.selectKpiImportListCnt(vo);
	}
	
	// 수출 정확성 관리
	@Override
	public List<?> selectKpiExportList(SearchVO vo) throws Exception {
		return kpiMapper.selectKpiExportList(vo);
	}
	
	// 수출 정확성 관리 갯수
	@Override
	public int selectKpiExportListCnt(SearchVO vo) throws Exception {
		return kpiMapper.selectKpiExportListCnt(vo);
	}
	
	// 수입신고 LeadTime
	@Override
	public List<?> selectKpiLeadtimeList(SearchVO vo) throws Exception {
		return kpiMapper.selectKpiLeadtimeList(vo);
	}
	
	// 수입신고 LeadTime 갯수
	@Override
	public int selectKpiLeadtimeListCnt(SearchVO vo) throws Exception {
		return kpiMapper.selectKpiLeadtimeListCnt(vo);
	}
}
