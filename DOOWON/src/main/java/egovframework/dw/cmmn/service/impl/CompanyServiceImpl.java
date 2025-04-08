package egovframework.dw.cmmn.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Service;

import com.itextpdf.text.log.SysoCounter;

import egovframework.dw.cmmn.service.CmmnService;
import egovframework.dw.cmmn.service.CompanyService;
import egovframework.dw.cmmn.service.SaveMemberUpateVO;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.cmmn.service.UserService;
import egovframework.dw.cmmn.service.UserSessionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;


@Service("CompanyService")
public class CompanyServiceImpl extends EgovAbstractServiceImpl implements CompanyService {

	@Resource(name="CompanyMapper")
	private CompanyMapper CompanyMapper;
	
	@Resource(name = "CmmnService")
	private CmmnService CmmnService;

	@Override
	public List<?> selectCmpnyList(SearchVO vo) throws Exception {
		List<?> resultList = null;

		//검색구분
		String srchTp = vo.getSrch1();
		//사업자정보 조회
		if("01".equals(srchTp)) {
			resultList = CompanyMapper.selectCmpnyList(vo);

		//사용자-지사 조회
		}else if("02".equals(srchTp)) {
			resultList = CompanyMapper.selectCmpnyBranchInfo(vo);
		}	
		return resultList;
	}
	//사용자정보 총 갯수 조회
	@Override
	public int selectCmpnyListCnt(SearchVO vo) throws Exception {
		int cnt = 0;

		//검색구분
		String srchTp = vo.getSrch1();
		//사용자정보 조회
		if("01".equals(srchTp)) {
			cnt = CompanyMapper.selectCmpnyListCnt(vo);

		//사용자 - 사업자 조회
		}else if("02".equals(srchTp)) {
			cnt = CompanyMapper.selectCmpnyBranchInfoCnt(vo);
		}
		return cnt;
	}
	// 회사정보 저장
	@Override
	public void saveCompnyInfo(List<SaveMemberUpateVO> voList, UserSessionVO userVO) throws Exception {
		String cdTp = "";
		String id = userVO.getId();
		String ip = userVO.getIp();
		
		for(SaveMemberUpateVO vo : voList) {
			System.out.println("vo");
			// 사용자관리 - 등록일때
			 if ("01".equals(cdTp)) {
					vo.setRegId(id);
					vo.setEdtId(id);
					vo.setRegIp(ip);
					CompanyMapper.insertCompny(vo);
				
			// 사용자 - 사업자 등록일때 
			} else if("02".equals(cdTp)){
				vo.setRegId(id);
				vo.setEdtId(id);
				vo.setRegIp(ip);
				CompanyMapper.insertCmpnyBranchInfo(vo);
					
			}
		}
	}
}


	


