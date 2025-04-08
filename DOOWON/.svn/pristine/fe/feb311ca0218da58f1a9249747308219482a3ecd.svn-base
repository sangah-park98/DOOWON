package egovframework.pf.cmmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import egovframework.pf.cmmn.service.MsgService;
import egovframework.pf.cmmn.service.SaveMsgVO;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : MsgService.java
 * @Description : MsgService Class
 * @Modification Information
 * @
 * @         수정일           		    수정자           				수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.04.19        	 권예지          				최초 생성
 *
 * @author 권예지
 * @since 2024.04.19
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KORD All right reserved.
 */

@Service("msgService")
public class MsgServiceImpl extends EgovAbstractServiceImpl implements MsgService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(FtaMenuServiceImpl.class);

	@Resource(name="msgMapper")
	private MsgMapper msgMapper;

	@Override
	public List<?> selectPfMsgList(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return msgMapper.selectPfMsgList(vo);
	}

	@Override
	public int selectPfMsgListCnt(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
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
