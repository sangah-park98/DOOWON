package egovframework.dw.cmmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.dw.cmmn.service.MsgService;
import egovframework.dw.cmmn.service.SaveMsgVO;
import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.cmmn.service.UserSessionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("msgService")
public class MsgServiceImpl extends EgovAbstractServiceImpl implements MsgService {

	@Resource(name="msgMapper")
	private MsgMapper msgMapper;

	@Override
	public List<?> selectPfMsgList(SearchVO vo) throws Exception {
		return msgMapper.selectPfMsgList(vo);
	}

	@Override
	public int selectPfMsgListCnt(SearchVO vo) throws Exception {
		return msgMapper.selectPfMsgListCnt(vo);
	}

	@Override
	public void insertPfMsgInfo(List<SaveMsgVO> voList, UserSessionVO userVO) throws Exception {
		for(SaveMsgVO vo : voList) {
			vo.setRegId(userVO.getId());
			vo.setEdtId(userVO.getId()); //임시
			msgMapper.insertPfMsgInfo(vo);
		
		}
	}
}
