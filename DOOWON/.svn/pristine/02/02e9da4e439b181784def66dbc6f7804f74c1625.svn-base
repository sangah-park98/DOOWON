package egovframework.pf.cmmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Service;

import egovframework.pf.cmmn.service.AuthorService;
import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.SaveAuthorVO;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : AuthorService.java
 * @Description : AuthorService Class
 * @Modification Information
 * @
 * @         수정일            			수정자          			 수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.02.07        	권예지 				최초 생성
 *
 * @author 권예지
 * @since 2024.02.07
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("AuthorService")
public class AuthorServiceImpl extends EgovAbstractServiceImpl implements AuthorService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(FtaAuthorServiceImpl.class);

	@Resource(name="AuthorMapper")
	private AuthorMapper AuthorMapper;

	@Resource(name="CmmnService")
	private CmmnService CmmnService;

	//권한정보 목록 조회
	@Override
	public List<?> selectAuthorList(SearchVO vo) throws Exception {
		List<?> resultList = null;

		//검색구분
		String srchTp = vo.getSrch1();
		System.out.print(srchTp);
		//그룹 조회
		if(srchTp.equals("01")) {
			resultList = AuthorMapper.selectUserGrpInfoList(vo);

		//메뉴별권한 조회
		}else {
			resultList = AuthorMapper.selectMenuAuthorList(vo);
		}
		return resultList;
	}

	//권한정보 총 갯수 조회
	@Override
	public int selectAuthorListCnt(SearchVO vo) throws Exception {
		int cnt =0;

		//검색구분
		String srchTp = vo.getSrch1();

		//그룹 조회
		if(srchTp.equals("01")) {
			cnt = AuthorMapper.selectUserGrpInfoListCnt(vo);

		//메뉴별권한 조회
		}else {
			cnt = AuthorMapper.selectMenuAuthorListCnt(vo);
		}

		return cnt;
	}

	//권한정보 정보 저장
	public void saveAuthorInfo(List<SaveAuthorVO> voList, UserSessionVO userVO) throws Exception {
		String id = userVO.getId();
		SearchVO srchVO = new SearchVO();

		

		for(SaveAuthorVO vo : voList) {
			String target = vo.getTargetType();
			vo.setRegId(id);
			vo.setEdtId(id);
			System.out.println("vo1"+vo.getMenuId());
			System.out.println("vo2"+vo.getGrpCd());
			//사용자그룹 채크
			//사용자그룹에 있을경우 update, 그룹체크 카운트 증가
			if(target.equals("01")) {
				
				//사용자 그룹에 없으면 추가, 권한은 읽기,쓰기 모두 N으로
					//매뉴 조회
					srchVO.setStrSelect("MENU_ID");
					srchVO.setStrFrom("MENU_INFO");
					srchVO.setStrWhere("DEL_YN = 'N'");
					srchVO.setStrOrderBy("MENU_ID");
					List<?> menuList = CmmnService.selectCmmnCdPop(srchVO);
					 //AuthorMapper.insertUserGrpInfo(vo);
					for(int j=0; j < menuList.size(); j++) {
						vo.setGrpCd(vo.getGrpCd());
						//EgovMap getMenuId = (EgovMap)menuList.get(j);
						//String menuId = (String)getMenuId.get("menuId");
						//vo.setMenuId(menuId);
						AuthorMapper.insertGroupAuthor(vo);
				}
				
			//메뉴별권한
			}else {
				String wYn = vo.getwYn();
				vo.setAuthorCd("W");
				if("Y".equals(wYn)) {
					vo.setDelYn("N");
					AuthorMapper.insertMenuAuthor(vo);
				} else {
					vo.setDelYn("Y");
					AuthorMapper.insertMenuAuthor(vo);
				}

				String rYn = vo.getrYn();
				
				System.out.println("rYn: " + rYn);

				vo.setAuthorCd("R");
				if("Y".equals(rYn)) {
					vo.setDelYn("N");
					AuthorMapper.insertMenuAuthor(vo);
				} else {
					vo.setDelYn("Y");
					AuthorMapper.insertMenuAuthor(vo);
				}
			}

		}
	}

	@Override
	public List<?> selectMenuIdDropdown() throws Exception {
		// TODO Auto-generated method stub
		return AuthorMapper.selectMenuIdDropdown();
	}

	@Override
	public List<?> selectGroupCodeDropdown() throws Exception {
		// TODO Auto-generated method stub
		return AuthorMapper.selectGroupCodeDropdown();
	}

	@Override
	public List<?> selectMenuNameDropdown() throws Exception {
		// TODO Auto-generated method stub
		return AuthorMapper.selectMenuNameDropdown();
	}

	

}
