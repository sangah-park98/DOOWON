package egovframework.pf.notice.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.notice.service.pfNoticeService;
import egovframework.pf.notice.service.saveNoticeVO;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

/**
 * @Class Name : ExportService.java
 * @Description : ExportService Class
 * @Modification Information
 * @
 * @         수정일            		       수정자           			수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.01.10          	서인석         			최초 생성
 *
 * @author 서인석
 * @since 2024.01.10
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KordSystems All right reserved.
 */

@Service("pfNoticeService")
public class pfNoticeServiceImpl extends EgovAbstractMapper implements pfNoticeService {

	@Resource(name="pfNoticeMapper")
	private pfNoticeMapper pfNoticeMapper;

	@Override
	public List<?> selectMainNoticeViewList(SearchVO vo) throws Exception {
		return pfNoticeMapper.selectMainNoticeViewList(vo);
	}

	@Override
	public int selectMainNoticeViewCnt(SearchVO vo) throws Exception {
		int cnt;
		cnt = pfNoticeMapper.selectMainNoticeViewCnt(vo);
		return cnt;
	}

	@Override
	public List<?> selectModalViewList(SearchVO vo) throws Exception {
		return pfNoticeMapper.selectModalViewList(vo);
	}

	@Override
	public void insertNoticeInputList(saveNoticeVO nvo) throws Exception {
		pfNoticeMapper.insertNoticeInputList(nvo);
	}

	@Override
	public void deleteNoticeViewList(SearchVO vo) throws Exception {
		pfNoticeMapper.deleteNoticeViewList(vo);
	}

	@Override
	public void updateNoticeViewList(SearchVO vo) throws Exception {
		pfNoticeMapper.updateNoticeViewList(vo);
	}

}
