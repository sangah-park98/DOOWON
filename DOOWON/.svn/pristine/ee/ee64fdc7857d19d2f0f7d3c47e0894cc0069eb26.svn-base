package egovframework.pf.cmmn.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


/**
 * @Class Name : CmmnService.java
 * @Description : CmmnService Class
 * @Modification Information
 * @
 * @         수정일            			수정자         			  수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.02.13          	권예지         			 최초 생성
 *
 * @author 권예지
 * @since 2024.02.13
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("CmmnService")
public class CmmnServiceImpl extends EgovAbstractServiceImpl implements CmmnService {

	//private static final Logger Logger = LoggerFactory.getLogger(ItemInfoServiceImpl.class);

	@Resource(name="CmmnMapper")
	private CmmnMapper CmmnMapper;

	//로그인체크
	public Map<String, String> selectCmpnyIdCheck(SearchVO searchVO) throws Exception {
		return CmmnMapper.selectCmpnyIdCheck(searchVO);
	}

	//회사목록 조회
	@Override
	public List<?> selectUsrCmpnyList(SearchVO searchVO) throws Exception {
		return CmmnMapper.selectUsrCmpnyList(searchVO);
	}

	//대메뉴 조회
	@Override
	public List<?> selectLargeMenuList(SearchVO searchVO) throws Exception {
		return CmmnMapper.selectLargeMenuList(searchVO);
	}

	//소메뉴 조회
	@Override
	public List<?> selectSmallMenuList(SearchVO searchVO) throws Exception {
		return CmmnMapper.selectSmallMenuList(searchVO);
	}

	//특정메뉴정보 조회
	@Override
	public List<?> selectDashboardInfo(SearchVO searchVO) throws Exception {
		return CmmnMapper.selectDashboardInfo(searchVO);
	}

	//메시지 조회
	@Override
	public List<?> selectMsgList(SearchVO searchVO) throws Exception {
		return CmmnMapper.selectMsgList(searchVO);
	}

	//코드 조회(팝업)
	@Override
	public List<?> selectCmmnCdPop(SearchVO vo) throws Exception {
		List<?> resultList;

		//팝업유형
		String popType = vo.getSearchType();

		//공통코드 조회
		if("cmmnCd".equals(popType)) {
			resultList = CmmnMapper.selectCmmnCdPop(vo);

		//테이블 조회
		}else {
			String strWhere = vo.getStrWhere();
			vo.setStrWhere(strWhere.replaceAll("&apos;", "'"));
			resultList = CmmnMapper.selectCmmnTableInfoList(vo);
		}

		return resultList;
	}

	//공통코드 갯수 조회(팝업)
	@Override
	public int selectCmmnCdPopCnt(SearchVO vo) throws Exception {
		int cnt;

		//팝업유형
		String popType = vo.getSearchType();

		//공통코드 조회
		if("cmmnCd".equals(popType)) {
			cnt = CmmnMapper.selectCmmnCdPopCnt(vo);

		//테이블 조회
		}else {
			String strWhere = vo.getStrWhere();
			vo.setStrWhere(strWhere.replaceAll("&apos;", "'"));
			cnt = CmmnMapper.selectCmmnTableInfoListCnt(vo);
		}

		return cnt;
	}

	//공통코드 조회
	@Override
	public List<?> selectCmmnCdList(SearchVO searchVO) throws Exception {
		return CmmnMapper.selectCmmnCdList(searchVO);
	}

	//작성권한 체크
	@Override
	public String selectWriteCheck(String param, UserSessionVO userVO) throws Exception {
		SearchVO vo = new SearchVO();
		vo.setSrch1(param);
		vo.setGrpCd(userVO.getGrpCd());
		return CmmnMapper.selectWriteCheck(vo);
	}

	//플랜트코드 조회
	@Override
	public List<?> selectPlntCdList(SearchVO vo, UserSessionVO userVO) throws Exception {
		List<?> resultList;
		String lang = userVO.getLang();
		if("en".equals(lang)) {
			vo.setStrSelect("PLNT_CD AS CD, PLNT_NM_EN AS CD_NM");
		}else {
			vo.setStrSelect("PLNT_CD AS CD, PLNT_NM AS CD_NM");
		}
		vo.setStrFrom("CMPNY_PLNT_INFO");
		vo.setStrWhere("CMPNY_CD = '"+userVO.getCmpnyCd()+"' AND DEL_YN = 'N'");
		vo.setStrOrderBy("PLNT_CD");

		String strWhere = vo.getStrWhere();
		vo.setStrWhere(strWhere.replaceAll("&apos;", "'"));
		resultList = CmmnMapper.selectCmmnTableInfoList(vo);
		return resultList;
	}

	//그룹코드 조회
	@Override
	public List<?> selectGroupCdList(SearchVO vo, UserSessionVO userVO) throws Exception {
		List<?> resultList;
		vo.setStrSelect("GRP_CD AS CD, GRP_NM AS CD_NM");
		vo.setStrFrom("USER_GRP_INFO");
		vo.setStrWhere("DEL_YN = 'N'");
		vo.setStrOrderBy("GRP_AUTH_ORD");

		String strWhere = vo.getStrWhere();
		vo.setStrWhere(strWhere.replaceAll("&apos;", "'"));
		resultList = CmmnMapper.selectCmmnTableInfoList(vo);
		return resultList;
	}

	//대륙코드 조회
	@Override
	public List<?> selectOceanCdList(SearchVO vo) throws Exception {
		List<?> resultList;
		vo.setStrSelect("CMMN_CD AS CD, CMMN_NM_EN AS NM");
		vo.setStrFrom("CMMN_CD");
		vo.setStrWhere("DEL_YN = 'N' AND DISP_YN = 'Y' AND GRP_CD = 'CNTTCD'");
		vo.setStrOrderBy("CMMN_CD");
		String strWhere = vo.getStrWhere();
		vo.setStrWhere(strWhere.replaceAll("&apos;", "'"));
		resultList = CmmnMapper.selectCmmnTableInfoList(vo);
		return resultList;
	}

	public List<?> selectFtaCmmnCdList (SearchVO vo) throws Exception {
		return CmmnMapper.selectFtaCmmnCdList(vo);
	}

	
}
