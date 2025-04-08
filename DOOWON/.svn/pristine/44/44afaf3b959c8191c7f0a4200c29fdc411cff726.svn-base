package egovframework.pf.item.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.itextpdf.text.log.SysoCounter;

import egovframework.pf.item.service.SaveSpecVO;
import egovframework.pf.item.service.SaveMemoVO;
import egovframework.pf.item.service.pfItemService;
import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : ItemServiceImpl.java
 * @Description : ItemServiceImpl Class
 * @Modification Information
 * @
 * @         수정일            		       수정자           			수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.02.16          	권예지         			최초 생성
 *
 * @author 권예지
 * @since 2024.01.10
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KordSystems All right reserved.
 */

@Service("pfItemService")
public class pfItemServiceImpl extends EgovAbstractServiceImpl implements pfItemService {


	@Resource(name="pfItemMapper")
	private pfItemMapper pfItemMapper;
	

	


	@Override
	public List<?> selectItemViewMemoList(SearchVO vo) throws Exception {
		
		return pfItemMapper.selectItemViewMemoList(vo);
	}
	
	// 편집일 경우 내가 쓴 메모만 보이게 작업
	@Override
	public List<?> selecteditItemViewMemoList(SearchVO vo,UserSessionVO userVO) throws Exception {
		String id = userVO.getId();
		System.out.println("ID"+id);
		vo.setSrch1(id);
		return pfItemMapper.selecteditItemViewMemoList(vo);
	}
	
	// 편집일 경우 내가 쓴 요건정보만 보이게 작업
		@Override
		public List<?> selectEditItemViewSpecList(SearchVO vo,UserSessionVO userVO) throws Exception {
			String name = userVO.getUsrNm();
			System.out.println("name"+name);
			vo.setSrch1(name);
			return pfItemMapper.selectEditItemViewSpecList(vo);
		}
		
	//요건정보 저장
	@Override
	public void saveItemViewSpec(List<SaveSpecVO> voList, UserSessionVO userVO) throws Exception {
		String tableType = "";
		String id = userVO.getId();
		String ip = userVO.getIp();
		String lang = userVO.getLang();
		String name = userVO.getUsrNm();
		SearchVO ocVO = new SearchVO();
		
		for(SaveSpecVO vo : voList) {
			tableType = vo.getTableType();
				
			System.out.println("tableType"+tableType);
			
			if(tableType.equals("edit")) {
				vo.setEdtId(id);
				vo.setUsrName(name);
				pfItemMapper.updateItemViewSpec(vo);
			
			}else if(tableType.equals("enrol")) {
				vo.setRegId(id);
				vo.setUsrName(name);
				pfItemMapper.insertItemViewSpec(vo);
			}
			
		}
	}


	// 메모정보 저장
	public void saveItemViewMemo(List<SaveMemoVO> voList, UserSessionVO userVO) throws Exception {
		String tableType = "";
		String id = userVO.getId();
		String name = userVO.getUsrNm();
		System.out.println("name"+name);
		String ip = userVO.getIp();
		String lang = userVO.getLang();
		SearchVO ocVO = new SearchVO();
		
		for(SaveMemoVO vo : voList) {
			tableType = vo.getTableType();
				
			System.out.println("tableType"+tableType);
			
			if(tableType.equals("edit")) {
				vo.setEdtId(id);
				vo.setUserName(name);
				pfItemMapper.updateItemViewMemo(vo);
			
			}else if(tableType.equals("enrol")) {
				vo.setRegId(id);
				vo.setUserName(name);
				pfItemMapper.insertItemViewMemo(vo);
			}
			
		}
		
	}

	// 중복 허용X 아이템 전체 조회
	@Override
	public List<?> selectItemViewList(SearchVO vo) throws Exception {
		return pfItemMapper.selectItemViewList(vo);
	}
	// 중복 허용X 아이템 전체 조회(카운트)
	@Override
	public int selectItemViewListCnt(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectItemViewListCnt(vo);
	}

	// 중복 허용X 아이템 수입 조회
	@Override
	public List<?> selectItemViewimportList(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectItemViewimportList(vo);
	}

	// 중복 허용X 아이템 수입 조회(카운트)
	@Override
	public int selectItemViewimportListCnt(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectItemViewimportListCnt(vo);
	}

	// 중복 허용X 아이템 수출 조회
	@Override
	public List<?> selectItemViewExportList(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectItemViewExportList(vo);
	}

	// 중복 허용X 아이템 수출 조회(카운트)
	@Override
	public int selectItemViewExportListCnt(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectItemViewExportListCnt(vo);
	}

	// 중복 허용O 아이템 전체 조회
	@Override
	public List<?> selectDuplicationItemViewList(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectDuplicationItemViewList(vo);
	}

	// 중복 허용O 아이템 전체 갯수
	@Override
	public int selectDuplicationItemViewListCnt(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectDuplicationItemViewListCnt(vo);
	}

	// 중복 허용O 아이템 수입 조회
	@Override
	public List<?> selectDuplicationItemViewimportList(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectDuplicationItemViewimportList(vo);
	}

	// 중복 허용O 아이템 수입 갯수
	@Override
	public int selectDuplicationItemViewimportListCnt(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectDuplicationItemViewimportListCnt(vo);
	}

	// 중복 허용O 아이템 수출 조회
	@Override
	public List<?> selectDuplicationItemViewExportList(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectDuplicationItemViewExportList(vo);
	}

	// 중복 허용O 아이템 수출 갯수
	@Override
	public int selectDuplicationItemViewExportListCnt(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectDuplicationItemViewExportListCnt(vo);
	}

	// 통관정보 
	@Override
	public List<?> selectItemViewLanList(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectItemViewLanList(vo);
	}

	// 통관정보 검색
	@Override
	public List<?> selectitemViewLanList2(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectItemViewLanList2(vo);
	}

	// 수입 통관 정보 
	@Override
	public List<?> selectItemViewLanImportList(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectItemViewLanImportList(vo);
	}

	// 수출 통관 정보  
	@Override
	public List<?> selectItemViewLanExportList(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectItemViewLanExportList(vo);
	}

	// 수입 통관 정보 검색 
	@Override
	public List<?> selectitemViewLanImportList2(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectitemViewLanImportList2(vo);
	}

	// 수출 통관 정보 검색
	@Override
	public List<?> selectitemViewLanExportList2(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectitemViewLanExportList2(vo);
	}
	// 수입 통관 정보 갯수
	@Override
	public int selectItemViewLanImportListCnt(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectItemViewLanImportListCnt(vo);
	}
	//  수출 통관 정보 갯수
	@Override
	public int selectItemViewLanExportListCnt(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectItemViewLanExportListCnt(vo);
	}
	// 통관 정보 갯수
	@Override
	public int selectItemViewLanListCnt(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectItemViewLanListCnt(vo);
	}

	//ioom 등록한 요건정보 
	@Override
	public List<?> selectItemViewSpecList2(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectItemViewSpecList(vo);
	}
	//레디/앤컴 등록한 요건정보 
	@Override
	public List<?> selectItemViewSpecList(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selectItemViewSpecListView(vo);
	}

	// 엑셀다운로드 요건정보
	@Override
	public List<?> selectItemViewSpecExcelList(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return  pfItemMapper.selectItemViewSpecExcelList(vo);
	}
	// 엑셀다운로드 메모정보
	@Override
	public List<?> selectItemViewMemoExcelList(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return pfItemMapper.selecteditItemViewMemoExcelList(vo);
	}


	

}
	

