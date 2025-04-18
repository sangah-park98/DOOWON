package egovframework.dw.docu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.docu.service.SaveDocuFileVO;
import egovframework.dw.docu.service.pfDocumentService;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

/**
 * @Class Name : DocumentService.java
 * @Description : DocumentService Class
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

@Service("pfDocumentService")
public class pfDocumentServiceImpl extends EgovAbstractMapper implements pfDocumentService {

	@Resource(name="pfDocumentMapper")
	private pfDocumentMapper pfDocumentMapper;

	@Override
	public List<?> selectDocumentViewListByRptNo(String rptNo) throws Exception {
		return pfDocumentMapper.selectDocumentViewListByRptNo(rptNo);
	}
	@Override
	public List<?> selectDocumentImpViewList(SearchVO vo) throws Exception {
		return pfDocumentMapper.selectDocumentImpViewList(vo);
	}
	@Override
	public int selectDocuViewImpTotCnt(SearchVO vo) throws Exception {
		return pfDocumentMapper.selectDocuViewImpTotCnt(vo);
	}
	@Override
	public int selectDocuViewExpTotCnt(SearchVO vo) throws Exception {
		return pfDocumentMapper.selectDocuViewExpTotCnt(vo);
	}
	@Override
	public List<?> selectDocumentExpViewList(SearchVO vo) throws Exception {
		return pfDocumentMapper.selectDocumentExpViewList(vo);
	}
	@Override
	public void insertImpDocuFilesInfo(SaveDocuFileVO vo) throws Exception {
		pfDocumentMapper.insertImpDocuFilesInfo(vo);
	}
	@Override
	public List<?> selectDownloadFileList(Object paramMap) throws Exception {
		return pfDocumentMapper.selectDownloadFileList(paramMap);
	}
	@Override
	public void insertExpDocuFilesInfo(SaveDocuFileVO vo) throws Exception {
		pfDocumentMapper.insertExpDocuFilesInfo(vo);
	}
	@Override
	public List<?> selectDocuImpModalUpdateList(SearchVO vo) throws Exception {
		return pfDocumentMapper.selectDocuImpModalUpdateList(vo);
	}
	@Override
	public List<?> selectDocuExpModalUpdateList(SearchVO vo) throws Exception {
		return pfDocumentMapper.selectDocuExpModalUpdateList(vo);
	}
	@Override
	public void deleteDocuFile(SearchVO vo) throws Exception {
		pfDocumentMapper.deleteDocuFile(vo);
	}
}
