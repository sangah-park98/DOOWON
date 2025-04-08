package egovframework.dw.cmmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.dw.cmmn.service.ConectInfoService;
import egovframework.dw.cmmn.service.SaveConectInfoVO;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.cmmn.service.UserSessionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


@Service("conectionInfoService")
public class ConectInfoServiceImpl extends EgovAbstractServiceImpl implements ConectInfoService {

	@Resource(name="conectionInfoMapper")
	private ConectInfoMapper conectInfoMapper;

	@Override
	public List<?> selectConectList(SearchVO vo) throws Exception {
		return conectInfoMapper.selectConectList(vo);
	}
	@Override
	public int selectConectListCnt(SearchVO vo) throws Exception {
		return conectInfoMapper.selectConectListCnt(vo);
	}

	// 접속 정보 저장
	public void saveConectInfo(UserSessionVO userVO) throws Exception {
		SaveConectInfoVO saveVO = new SaveConectInfoVO();
		saveVO.setUsrId(userVO.getId());
		List<String> cmpnyCds = userVO.getCmpnyCds();
		if (cmpnyCds != null && !cmpnyCds.isEmpty()) {
			saveVO.setConCmpnyCd(String.join(",", cmpnyCds));
		}
		saveVO.setRegId(userVO.getId());
		saveVO.setRegIp(userVO.getIp());
		conectInfoMapper.insertConectInfo(saveVO);
	}
}
