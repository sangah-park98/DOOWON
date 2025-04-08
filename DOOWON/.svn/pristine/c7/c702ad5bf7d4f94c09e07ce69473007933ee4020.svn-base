package egovframework.pf.cmmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.pf.cmmn.service.CmmnCdService;
import egovframework.pf.cmmn.service.SaveCmmnCdVO;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : CmmnCdService.java
 * @Description : CmmnCdService Class
 * @Modification Information
 * @
 * @         수정일            			수정자          				 수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.04.18          	권예지         				최초 생성
 *
 * @author 권예지
 * @since 2024.04.18
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KORD All right reserved.
 */

@Service("cmmnCdService")
public class CmmnCdServiceImpl extends EgovAbstractServiceImpl implements CmmnCdService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(FtaMenuServiceImpl.class);

	@Resource(name="cmmnCdMapper")
	private CmmnCdMapper cmmnCdMapper;

	// 공통코드 목록 조회
	@Override
	public List<?> selectPfCmmnCdList(SearchVO vo) throws Exception {
		List<?> resultList;
		String cmmnCdTp = vo.getSrch6();
	/*	if("01".equals(cmmnCdTp)) {
			// 그룹공통코드
		}else {
			//그룹코드
			resultList = cmmnCdMapper.selectPfCmmnCdList(vo);
		}*/
		resultList = cmmnCdMapper.selectPfCmmnCdList(vo);
		return resultList;
	}
	// 공통코드 목록 총 갯수 조회
	@Override
	public int selectPfCmmnCdListCnt(SearchVO vo) throws Exception {
		int totCnt;
		String cmmnCdTp = vo.getSrch6();
		/*if("01".equals(cmmnCdTp)) {
		
		}else {
			totCnt = cmmnCdMapper.selectPfCmmnCdListCnt(vo);
		}*/
		totCnt = cmmnCdMapper.selectPfCmmnCdListCnt(vo);

		return totCnt;
	}
	// 등록 그룹코드 드롭다운
	@Override
	public List<?> selectCmmnGrpDropdown() throws Exception {
		// TODO Auto-generated method stub
		return cmmnCdMapper.selectCmmnGrpDropdown();
	}
	@Override
	public void savePfCmmnCdInfo(List<SaveCmmnCdVO> voList, UserSessionVO userVO) throws Exception {
		String cdTp = "";
		String id = userVO.getId();
		
		for(SaveCmmnCdVO vo : voList) {
			vo.setRegId(id);
			cdTp = vo.getCdTp();

			/*if("01".equals(cdTp)) 
				// 그룹공통코드
				 cmmnCdMapper.insertPfCmmnGrpCd(vo) ; 			//그룹코드
			else //그룹코드  
*/				cmmnCdMapper.insertPfCmmnCd(vo); 
		}
	}
}
