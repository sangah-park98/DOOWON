package egovframework.ms.docu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.ms.docu.service.DocumentService;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.docu.service.pfDocumentService;
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

@Service("documentService")
public class DocumentServiceImpl extends EgovAbstractMapper implements DocumentService {

	@Resource(name="documentMapper")
	private DocumentMapper documentMapper;

	@Override
	public List<?> selectDocumentViewList(SearchVO vo) throws Exception {
		return documentMapper.selectDocumentViewList(vo);
	}


}
