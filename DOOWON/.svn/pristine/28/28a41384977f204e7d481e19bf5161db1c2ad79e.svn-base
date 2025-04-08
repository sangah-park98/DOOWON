package egovframework.pf.rpt.service;

import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;

/**
 * @Class Name : KPIExcelService.java
 * @Description : KPIExcelService Class
 * @Modification Information
 * @
 * @         수정일            		       수정자           			수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.05.13         	이재성         			최초 생성
 *
 * @author 이재성
 * @since 2024.05.13
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KordSystems All right reserved.
 */

public interface AnalysisExcelService {
	
	// 수입실적 
	XSSFSheet analysis1TopSummary(List<?> resultList, XSSFSheet sheet, SearchVO serarchVo, UserSessionVO userVO) throws Exception;
	
	// 수출실적
	XSSFSheet analysis2TopSummary(List<?> resultList, XSSFSheet sheet, SearchVO serarchVo, UserSessionVO userVO) throws Exception;
	
	// 해외거래처별 수입실적
	XSSFSheet analysis3TopSummary(List<?> resultList, XSSFSheet sheet, SearchVO serarchVo, UserSessionVO userVO) throws Exception;
	
	// 해외거래처별 수출실적
	XSSFSheet analysis4TopSummary(List<?> resultList, XSSFSheet sheet, SearchVO serarchVo, UserSessionVO userVO) throws Exception;
	
	// 외환신고대상 수출
	XSSFSheet analysis7TopSummary(List<?> resultList, XSSFSheet sheet, SearchVO serarchVo, UserSessionVO userVO) throws Exception;
	
	// 수입물품 단가비교
	XSSFSheet cost1TopSummary(List<?> resultList, XSSFSheet sheet, SearchVO serarchVo, UserSessionVO userVO)throws Exception;
	
	// 유무상 수입건 과세가격 비교
	XSSFSheet cost2TopSummary(List<?> resultList, XSSFSheet sheet, SearchVO serarchVo, UserSessionVO userVO)throws Exception;
	
	// 동일거래, 결제통화 변경점검 
	XSSFSheet cost3TopSummary(List<?> resultList, XSSFSheet sheet, SearchVO serarchVo, UserSessionVO userVO)throws Exception;
	
	// 동일자재코드 품목분류 상이점검
	XSSFSheet etc1TopSummary(List<?> resultList, XSSFSheet sheet, SearchVO serarchVo, UserSessionVO userVO)throws Exception;
	
	// 동일자재코드 관세구분 상이점검
	XSSFSheet etc2TopSummary(List<?> resultList, XSSFSheet sheet, SearchVO serarchVo, UserSessionVO userVO)throws Exception;
	
	// FTA 적정성(직접운송원칙)
	XSSFSheet etc3TopSummary(List<?> resultList, XSSFSheet sheet, SearchVO serarchVo, UserSessionVO userVO)throws Exception;
	
	// FTA 적용누락
	XSSFSheet etc4TopSummary(List<?> resultList, XSSFSheet sheet, SearchVO serarchVo, UserSessionVO userVOt)throws Exception;
}
