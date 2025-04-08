package egovframework.dw.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ModelMap;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public class CmmnUtil {

	//List를 String 으로 변환
	public static String getStrList(List<?> dataSet,String keyNm,String keyValue) throws Exception {
		String result = "" ;
		if (dataSet == null) return "" ;

		for(int i=0; i<dataSet.size(); i++) {
			EgovMap map =(EgovMap)dataSet.get(i);

			if (map==null) continue ;

			String value = "" ;
			if (map.containsKey(keyNm) && map.containsKey(keyValue))
				value = "\"".concat(map.get(keyNm).toString()).concat("\" : \"").concat(map.get(keyValue).toString()).concat("\",");
			 else continue ;


			if (value != null) result = result + value ;
		}
		if (result.length()>0) result = "{" +  result.substring(0, result.length()-1) + "}";
		else  result = "{}";

		//System.out.println(result);
		return result;
	}

	//메세지 리스트 데이터 셋 반환
	public static ModelMap makeMsgSet(ModelMap model, List<?> dataList, String keyNm, String valNm) throws Exception {
		//메세지 String
		model.addAttribute("msgStr",getStrList(dataList,keyNm,valNm));
		//메세지 dataSet
		model.addAttribute("msgSet", (EgovMap)makeListToMap( dataList,  keyNm, valNm));
		return model;
	}
	
	//리스트 to map 셋 반환
	public static EgovMap makeListToMap(List<?> dataList, String keyNm, String valNm) throws Exception {
		//메세지 dataSet
		EgovMap rtnMap = new EgovMap();
		for(int i=0; i<dataList.size(); i++) {
			EgovMap map =(EgovMap)dataList.get(i);
			rtnMap.put(map.get(keyNm), map.get(valNm));
		}
		return rtnMap;
	}
	
	
	//메세지 리스트 데이터 셋 반환
	public static List<?> makeListToArray(List<?> codeList, String key) throws Exception {
		//메세지 String
		List<String> returnList = new ArrayList<String>();
		for(int i=0; i<codeList.size(); i++) {
			EgovMap map = (EgovMap)codeList.get(i);
			returnList.add("'"+(String)map.get(key)+"'");
		}
		return returnList;
	}

}