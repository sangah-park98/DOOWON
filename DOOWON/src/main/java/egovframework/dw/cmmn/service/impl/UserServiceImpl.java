package egovframework.dw.cmmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.dw.cmmn.service.CmmnService;
import egovframework.dw.cmmn.service.SaveMemberUpateVO;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.cmmn.service.UserService;
import egovframework.dw.cmmn.service.UserSessionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


@Service("UserService")
public class UserServiceImpl extends EgovAbstractServiceImpl implements UserService {

	@Resource(name="UserMapper")
	private UserMapper UserMapper;
	
	@Resource(name = "CmmnService")
	private CmmnService CmmnService;
	
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
			}
			// 사용자관리 - 등록일때
			else if ("01".equals(cdTp) && "enrol".equals(mnTp)) {
				 UserMapper.insertUserInfo(vo);
			// 사용자 - 사업자 등록일때 
			} else if("02".equals(cdTp)){
				UserMapper.insertCmpnyInfo(vo);
			}
		}
	}
}

	


