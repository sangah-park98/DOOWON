package egovframework.pf.cmmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.pf.cmmn.service.ConectInfoService;
import egovframework.pf.cmmn.service.SaveConectInfoVO;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : ConectInfoService.java
 * @Description : ConectInfoService Class
 * @Modification Information
 * @
 * @         수정일            			수정자          				 수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.02.13                     권예지     					최초 생성
 *
 * @author 권예지
 * @since 2024.02.13
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("conectionInfoService")
public class ConectInfoServiceImpl extends EgovAbstractServiceImpl implements ConectInfoService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(ConectInfoServiceImpl.class);

	@Resource(name="conectionInfoMapper")
	private ConectInfoMapper conectInfoMapper;

	//접속 목록 조회
	@Override
	public List<?> selectConectList(SearchVO vo) throws Exception {
		return conectInfoMapper.selectConectList(vo);
	}

	//접속 총 갯수 조회
	@Override
	public int selectConectListCnt(SearchVO vo) throws Exception {
		return conectInfoMapper.selectConectListCnt(vo);
	}

	//접속 정보 저장
	public void saveConectInfo(UserSessionVO userVO) throws Exception {
		SaveConectInfoVO saveVO = new SaveConectInfoVO();
		saveVO.setUsrId(userVO.getId());
		saveVO.setConCmpnyCd(userVO.getCmpnyCd());
		saveVO.setRegId(userVO.getId());
		saveVO.setRegIp(userVO.getIp());
		conectInfoMapper.insertConectInfo(saveVO);
	}

}
