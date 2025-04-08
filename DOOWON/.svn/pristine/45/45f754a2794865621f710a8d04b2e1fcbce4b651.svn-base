package egovframework.pf.exp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.stereotype.Service;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.pf.exp.service.CusExpUploadService;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Service("cusExpUploadService")
public class CusExpUploadServiceImpl extends EgovAbstractMapper implements CusExpUploadService {

	@Resource(name="cusExpUploadMapper")
	private CusExpUploadMapper cusExpUploadMapper;

	/*@Override
	public Map<String, Integer> insertExportTempExcelData(Map<String, Object> excelData, UserSessionVO loginUser) {
		Map<String, Integer> result = new HashMap<String, Integer>();
		System.out.println("columnCount"+excelData.get("columnCount").toString());
		//레디
		if(excelData.get("columnCount").toString().equals("138")) {
			System.out.println("레디");
			result = insertReadyExportData(excelData,loginUser);
		}//엔컴
		else if(excelData.get("columnCount").toString().equals("176")) {
			System.out.println("엔컴");
			result = insertEncomExportData(excelData,loginUser);
		}// 운서 특송
		else if(excelData.get("columnCount").toString().equals("130")) {
			System.out.println("운서특송");
			result = insertDHLExportData(excelData,loginUser);
		}
		return result;
	}*/

	//운서 특송
	public Map<String, Integer> insertDHLExportData(Map<String, Object> excelData, UserSessionVO loginUser) {
		System.out.println("운서 특송 수출");
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) excelData.get("dataList");
		//신고일자
		List<String> registerDate = new ArrayList<String>();
		
		Map<String, Integer> resultMap = new HashMap<>();
		//파일이름
		String fileName = (String) excelData.get("fileName");
		
		int failCount = 0;
		int successCount = 0;
		int doubleCount = 0;
		int resultCntView = 0;
		int resultCntLan = 0;
		int resultCntSpec = 0;
		int failReason = 0;
		
		Map<String, Integer> errorMap = new HashMap<>(); 
		
		
		for(Map<String,Object>data : dataList) {
			//신고일자
			
			//데이터유효성
			data.put("FAIL_REASON", null);
			System.out.println("data.size()"+data.size());
			if(data.size() != 132) {
				failReason = 1;
				failCount += 1;
			}else if(data.get("excel_7") == null || !data.get("excel_7").toString().equals(loginUser.getCorpNo())){
				//사업자번호다름 
				failReason = 2;
	            failCount += 1;
			}else if(data.get("excel_0") == null) {
				 failReason = 3;//신고번호누락
	             failCount += 1;
			}
		
			if (failReason != 0) {
	            errorMap.put("failReason", failReason); // Integer 타입으로 저장
	        }
			
			if(failCount == 0) {
			
			data.put("fileName", fileName);
            data.put("Id", loginUser.getId());
            
          
            System.out.println("data"+data);
            String rptNo = data.get("excel_0").toString();
            String ranNo = data.get("excel_1").toString();
            String sil = data.get("excel_2").toString();
          //공통내역 seq
            Map<String, String> resultMap1 = cusExpUploadMapper.insertReadyExportDataA1Seq(rptNo);
            String resultCount1Seq = String.valueOf(resultMap1.get("SN"));
            String result1Status = resultMap1.get("STATUS");
            data.put("resultCount1", resultCount1Seq);
            //란 seq
            Map<String, String> resultMap2 = cusExpUploadMapper.insertReadyExportDataB1Seq(rptNo, ranNo);
            String resultCount2Seq = String.valueOf(resultMap2.get("SN"));
            String result2Status = resultMap2.get("STATUS");
            data.put("resultCount2", resultCount2Seq);
            //규격 seq
            Map<String, String> resultMap3 = cusExpUploadMapper.insertReadyExportDataC1Seq(rptNo, ranNo, sil);
            String resultCount3Seq = String.valueOf(resultMap3.get("SN"));
            String result3Status = resultMap3.get("STATUS");
            data.put("resultCount3", resultCount3Seq);
            
            //공통내역
			int resultCount1 = cusExpUploadMapper.insertDHLExportDataA1(data);
			//란
			int resultCount2 = cusExpUploadMapper.insertDHLExportDataB1(data);
			//규격
			int resultCount3 = cusExpUploadMapper.insertDHLExportDataC1(data);
			
			if(result1Status.equals("신규")) {
				resultCntView += resultCount1;
			}
			if(result2Status.equals("신규")) {
				resultCntLan += resultCount2;
			}
			if(result3Status.equals("신규")) {
				resultCntSpec += resultCount3;
			}
		}
		
		resultMap.put("main", resultCntView);
		resultMap.put("lan", resultCntLan);
		resultMap.put("spec", resultCntSpec);
		}
		resultMap.put("failReason", failReason);
		
		return resultMap;
	}

		//레디 
		public Map<String, Integer> insertExpReadyExcelData(Map<String, Object> excelData, UserSessionVO loginUser) {
			System.out.println("레디 수출");
			List<Map<String, Object>> dataList = (List<Map<String, Object>>) excelData.get("dataList");
			//신고일자
			List<String> registerDate = new ArrayList<String>();
			
			Map<String, Integer> resultMap = new HashMap<>();
			//파일이름
			String fileName = (String) excelData.get("fileName");
			
			int failCount = 0;
			int successCount = 0;
			int doubleCount = 0;
			int resultCntView = 0;
			int resultCntLan = 0;
			int resultCntSpec = 0;
			int failReason = 0;
			
			//System.out.println("dataList"+dataList);
			Map<String, Integer> errorMap = new HashMap<>();
			
			for(Map<String,Object>data : dataList) {
				//데이터유효성
				if(data.size() != 139) {
					//갯수가 적음
					//data.put("FAIL_REASON", "열의 개수가 맞지 않습니다.");
					failCount += 1;
					failReason = 1;
				}else if(data.get("excel_7") == null || !data.get("excel_7").toString().equals(loginUser.getCorpNo())){
					//사업자번호다름 
					// data.put("FAIL_REASON", "사업자번호가 다릅니다.");      
					failCount += 1;
		            failReason = 2;
				}else if(data.get("excel_0") == null) {
					 // data.put("FAIL_REASON", "신고번호가 누락되었습니다.");      //필수데이터누락
					 failCount += 1;
		             failReason = 3;//필수데이터누락
				}
				 
				if (failReason != 0) {
			            errorMap.put("failReason", failReason); // Integer 타입으로 저장
			        }
	            
				
				if(failCount == 0) {
				
				data.put("fileName", fileName);
	            data.put("Id", loginUser.getId());
	          
	            System.out.println("data"+data);
	            String rptNo = data.get("excel_0").toString();
	            String ranNo = data.get("excel_1").toString();
	            String sil = data.get("excel_2").toString();
				//공통내역 seq
	            Map<String, String> resultMap1 = cusExpUploadMapper.insertReadyExportDataA1Seq(rptNo);
	            String resultCount1Seq = String.valueOf(resultMap1.get("SN"));
	            String result1Status = resultMap1.get("STATUS");
	            data.put("resultCount1", resultCount1Seq);
	            //란 seq
	            Map<String, String> resultMap2 = cusExpUploadMapper.insertReadyExportDataB1Seq(rptNo, ranNo);
	            String resultCount2Seq = String.valueOf(resultMap2.get("SN"));
	            String result2Status = resultMap2.get("STATUS");
	            data.put("resultCount2", resultCount2Seq);
	            //규격 seq
	            Map<String, String> resultMap3 = cusExpUploadMapper.insertReadyExportDataC1Seq(rptNo, ranNo, sil);
	            String resultCount3Seq = String.valueOf(resultMap3.get("SN"));
	            String result3Status = resultMap3.get("STATUS");
	            data.put("resultCount3", resultCount3Seq);
	            
	            //공통내역
				int resultCount1 = cusExpUploadMapper.insertReadyExportDataA1(data);
				//란
				int resultCount2 = cusExpUploadMapper.insertReadyExportDataB1(data);
				//규격
				int resultCount3 = cusExpUploadMapper.insertReadyExportDataC1(data);
				
				if(result1Status.equals("신규")) {
					resultCntView += resultCount1;
				}
				if(result2Status.equals("신규")) {
					resultCntLan += resultCount2;
				}
				if(result3Status.equals("신규")) {
					resultCntSpec += resultCount3;
				}
			}
			
			resultMap.put("main", resultCntView);
			resultMap.put("lan", resultCntLan);
			resultMap.put("spec", resultCntSpec);
			}
			resultMap.put("failReason", failReason);
			return resultMap;
		}
	
	
	//엔컴
	public Map<String, Integer> insertExpEncomExcelData(Map<String, Object> excelData, UserSessionVO loginUser) {
		System.out.println("엔컴");
		List<Map<String, Object>> dataList = (List<Map<String, Object>>) excelData.get("dataList");
		//신고일자
		List<String> registerDate = new ArrayList<String>();
		
		Map<String, Integer> resultMap = new HashMap<>();
		//파일이름
		String fileName = (String) excelData.get("fileName");
		
		int failCount = 0;
		int successCount = 0;
		int doubleCount = 0;
		int resultCntView = 0;
		int resultCntLan = 0;
		int resultCntSpec = 0;
		int failReason = 0;
		
		Map<String, Integer> errorMap = new HashMap<>(); 
		
		
		for(Map<String,Object>data : dataList) {
			//System.out.println("data"+data);
			//신고일자
			if (data.get("excel_2") != null && StringUtils.isNotEmpty(data.get("excel_2").toString())) {
                registerDate.add(data.get("excel_2").toString());
            }
			//데이터유효성
			if(data.size() != 177) {
				//갯수가 적음
				// data.put("FAIL_REASON", "열의 개수가 맞지 않습니다.");
				failReason = 1;
				failCount += 1;
			}else if(data.get("excel_25") == null || !data.get("excel_25").toString().equals(loginUser.getCorpNo())){
				//사업자번호다름 
				//data.put("FAIL_REASON", "사업자번호가 다릅니다.");      
				failReason = 2;
	            failCount += 1;
			}else if(data.get("excel_4") == null) {
				 //data.put("FAIL_REASON", "신고번호가 누락되었습니다.");      //필수데이터누락
				 failReason = 3;//필수데이터누락
	             failCount += 1;
			}
			
			if (failReason != 0) {
	            errorMap.put("failReason", failReason); // Integer 타입으로 저장
	        }
			
			if(failCount == 0) {
			//data.put("fileName", fileName);
             
            data.put("Id", loginUser.getId());
          
            //System.out.println("data"+data);
            String rptNo = data.get("excel_4").toString();
            String ranNo = data.get("excel_159").toString();
            String sil = data.get("excel_160").toString();
            Map<String, String> resultMap1 = cusExpUploadMapper.insertReadyExportDataA1Seq(rptNo);
            String resultCount1Seq = String.valueOf(resultMap1.get("SN"));
            String result1Status = resultMap1.get("STATUS");
            data.put("resultCount1", resultCount1Seq);
            //란 seq
            Map<String, String> resultMap2 = cusExpUploadMapper.insertReadyExportDataB1Seq(rptNo, ranNo);
            String resultCount2Seq = String.valueOf(resultMap2.get("SN"));
            String result2Status = resultMap2.get("STATUS");
            data.put("resultCount2", resultCount2Seq);
            //규격 seq
            Map<String, String> resultMap3 = cusExpUploadMapper.insertReadyExportDataC1Seq(rptNo, ranNo, sil);
            String resultCount3Seq = String.valueOf(resultMap3.get("SN"));
            String result3Status = resultMap3.get("STATUS");
            data.put("resultCount3", resultCount3Seq);
            
            //공통내역
			int resultCount1 = cusExpUploadMapper.insertEncomExportDataA1(data);
			//란
			int resultCount2 = cusExpUploadMapper.insertEncomExportDataB1(data);
			//규격
			int resultCount3 = cusExpUploadMapper.insertEncomExportDataC1(data);
			
			
			if(result1Status.equals("신규")) {
				resultCntView += resultCount1;
			}
			if(result2Status.equals("신규")) {
				resultCntLan += resultCount2;
			}
			if(result3Status.equals("신규")) {
				resultCntSpec += resultCount3;
			}
		}
		resultMap.put("main", resultCntView);
		resultMap.put("lan", resultCntLan);
		resultMap.put("spec", resultCntSpec);
		}
		resultMap.put("failReason", failReason);
		return resultMap;
	}

	

	
	@Override
	public int insertExportTempDataUploadLog(Map<String, Object> excelData, Map<String, Object> returnData,
			UserSessionVO loginUser) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int deleteTempData(Map<String, Object> loginUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	// 타관세사 데이터 공통 리스트
	@Override
	public List<?> selectCusExpViewList(SearchVO vo) {
		return cusExpUploadMapper.selectCusExpViewList(vo);
	}

	// 타관세사 데이터 업로드 정보 
	@Override
	public List<?> selectCusFileList(SearchVO vo) {
		return cusExpUploadMapper.selectCusFileList(vo);
	}


	@Override
	public List<?> selectCusExpViewLanList(SearchVO vo) {
		return cusExpUploadMapper.selectCusExpViewLanList(vo);
	}


	@Override
	public List<?> selectCusExpViewSpecList(SearchVO vo) {
		return cusExpUploadMapper.selectCusExpViewSpecList(vo);
	}

	//리스트 삭제
	@Override
	public void deleteExportView(SearchVO vo) {
		cusExpUploadMapper.deleteCusExpDataA1(vo);
		cusExpUploadMapper.deleteCusExpDataB1(vo);
		cusExpUploadMapper.deleteCusExpDataC1(vo);
		
	}

}
