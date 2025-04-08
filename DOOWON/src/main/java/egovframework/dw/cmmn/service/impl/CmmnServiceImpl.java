package egovframework.dw.cmmn.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.dw.cmmn.service.CmmnService;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.cmmn.service.UserSessionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


@Service("CmmnService")
public class CmmnServiceImpl extends EgovAbstractServiceImpl implements CmmnService {

	@Resource(name="CmmnMapper")
	private CmmnMapper CmmnMapper;

	//로그인체크
	public List<Map<String, String>> selectCmpnyIdCheck(SearchVO searchVO) throws Exception {
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

	@Override
	public List<?> selectAllCmpnyList(SearchVO vo) throws Exception {
		return CmmnMapper.selectAllCmpnyList(vo);
	}

}
