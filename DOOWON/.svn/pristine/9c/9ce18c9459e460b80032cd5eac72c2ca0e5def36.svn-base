package egovframework.pf.cmmn.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.pf.cmmn.service.ChangeHistService;
import egovframework.pf.cmmn.service.SaveChangeHistVO;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : ChangeHistService.java
 * @Description : ChangeHistService Class
 * @Modification Information
 * @
 * @         수정일           			수정자          				 수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.02.13                    권예지         			       최초 생성
 *
 * @author 권예지
 * @since 2024.02.13
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("changeHistoryService")
public class ChangeHistServiceImpl extends EgovAbstractServiceImpl implements ChangeHistService {

	//private static final Logger LOGGER = LoggerFactory.getLogger(ChangeHistServiceImpl.class);

	@Resource(name="changeHistoryMapper")
	private ChangeHistMapper changeHistMapper;

	//변경이력 목록 조회
	@Override
	public List<?> selectChangeHistList(SearchVO vo) throws Exception {
		return changeHistMapper.selectChangeHistList(vo);
	}

	//변경이력 총 갯수 조회
	@Override
	public int selectChangeHistListCnt(SearchVO vo) throws Exception {
		return changeHistMapper.selectChangeHistListCnt(vo);
	}

	//변경이력 정보 저장
	public void saveChangeHistInfo(SaveChangeHistVO vo) throws Exception {
		changeHistMapper.insertChangeHistInfo(vo);
	}

}
