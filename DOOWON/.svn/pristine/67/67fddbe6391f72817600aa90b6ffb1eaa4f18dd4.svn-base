package egovframework.pf.cmmn.service.impl;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Service;

import com.itextpdf.text.log.SysoCounter;

/*import egovframework.fta.base.service.impl.CnvrsnrtMapper;*/
/*import egovframework.fta.base.service.SaveCnvrsnrtVO;
import egovframework.fta.base.service.impl.CnvrsnrtMapper;*/
import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.SaveMemberUpateVO;
import egovframework.pf.cmmn.service.UserService;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

/**
 * @Class Name : FtaUserService.java
 * @Description : FtaUserService Class
 * @Modification Information
 * @
 * @         수정일            			수정자          			 수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.02.05	 	        권예지			          최초 생성
 * @     
 *
 * @author 권예지
 * @since 2024.02.05
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("UserService")
public class UserServiceImpl extends EgovAbstractServiceImpl implements UserService {

	@Resource(name="UserMapper")
	private UserMapper UserMapper;
	
	@Resource(name = "CmmnService")
	private CmmnService CmmnService;
	
	/*@Resource(name="cnvrsnrtMapper")
	private CnvrsnrtMapper cnvrsnrtMapper;*/

	//사용자정보 목록 조회
	@Override
	public List<?> selectUserInfoList(SearchVO vo) throws Exception {
		List<?> resultList = null;

		//검색구분
		String srchTp = vo.getSrch1();
		//사용자정보 조회
		if("01".equals(srchTp)) {
			resultList = UserMapper.selectUserList(vo);

		//사용자-사업자 조회
		}else if("02".equals(srchTp)) {
			if(vo.getGrpCd().equals("ADMIN")) {
				vo.setCmpnyCd("");
			}
			resultList = UserMapper.selectUserCompnyList(vo);
			
		}	
		return resultList;
	}

	//사용자정보 총 갯수 조회
	@Override
	public int selectUserInfoListCnt(SearchVO vo) throws Exception {
		int cnt = 0;

		//검색구분
		String srchTp = vo.getSrch1();
		//사용자정보 조회
		if("01".equals(srchTp)) {
			cnt = UserMapper.selectUserListCnt(vo);

		//사용자 - 사업자 조회
		}else if("02".equals(srchTp)) {
			cnt = UserMapper.selectUserCompnyListCnt(vo);
		}
		return cnt;
	}

	

	//사용자정보 정보 저장
	@Override
	public void saveUserInfo(List<SaveMemberUpateVO> voList, UserSessionVO userVO) throws Exception {
		String cdTp = "";
		String mnTp = "";
		String id = userVO.getId();
		String ip = userVO.getIp();
		String lang = userVO.getLang();
		SearchVO ocVO = new SearchVO();
		
		
		for(SaveMemberUpateVO vo : voList) {
			System.out.println("vo");
			cdTp = vo.getCdTp();
			mnTp = vo.getMnTp();
			vo.setRegId(id);
			vo.setEdtId(id);
			vo.setRegIp(ip);
			// 사용자관리 - 편집일때
			if("01".equals(cdTp) && "edit".equals(mnTp)) {
				System.out.println("edit");
				 UserMapper.insertUserInfo(vo);
				 // user_cmpny_info
				 //UserMapper.insertCmpnyInfo(vo);
				 // cmpny_info
				// UserMapper.insertCmpny(vo);
			}
			// 사용자관리 - 등록일때
			else if ("01".equals(cdTp) && "enrol".equals(mnTp)) {
				
				 UserMapper.insertUserInfo(vo);
				 //UserMapper.insertCmpnyInfo(vo);
				
				/*int cmpny = UserMapper.selectCmpny(vo);
				 // 회사가 이미 존재하는경우
				System.out.println("cmpny>"+cmpny);
				if(cmpny >0) {
					 UserMapper.insertUserInfo(vo);
					 UserMapper.insertCmpnyInfo(vo);
				// 회사가 존재하지 않아 등록해야되는경우
				}else {
					 UserMapper.insertUserInfo(vo);
					 // user_cmpny_info
					 UserMapper.insertCmpnyInfo(vo);
					 // cmpny_info
					UserMapper.insertCmpny(vo);
				}*/
			// 사용자 - 사업자 등록일때 
			} else if("02".equals(cdTp)){
				UserMapper.insertCmpnyInfo(vo);
				/*int cmpny = UserMapper.selectCmpny(vo);
				// 회사가 이미 존재하는 경우 
				System.out.println("cmpny>"+cmpny);
				if(cmpny >0) {
					 UserMapper.insertCmpnyInfo(vo);
				}else {
					// user_cmpny_info
					 UserMapper.insertCmpnyInfo(vo);
					 // cmpny_info
					 UserMapper.insertCmpny(vo);
				}*/
					
			}
		}
	}

}

	


