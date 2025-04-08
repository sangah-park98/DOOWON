package egovframework.ms.exp.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.ms.exp.service.ExportService;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.exp.service.pfExportService;
import egovframework.pf.exp.service.SaveExpFileVO;
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

@Service("exportService")
public class ExportServiceImpl extends EgovAbstractMapper implements ExportService {

	@Resource(name="exportMapper")
	private ExportMapper exportMapper;

	@Override
	public List<?> selectExportInList2(SearchVO vo) throws Exception {
		return exportMapper.selectExportInList2(vo);
	}
	@Override
	public int selectExportInTotCnt2(SearchVO vo) throws Exception {
		return exportMapper.selectExportInTotCnt2(vo);
	}
	

}
