package egovframework.ms.item.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.ms.item.service.ItemService;
import egovframework.pf.cmmn.service.SearchVO;
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

@Service("itemService")
public class ItemServiceImpl extends EgovAbstractServiceImpl implements ItemService {


	@Resource(name="itemMapper")
	private ItemMapper itemMapper;
	
	// 전체 아이템 조회
	@Override
	public List<?> selectItemViewList(SearchVO vo) throws Exception {
		return itemMapper.selectItemViewList(vo);
	}

	@Override
	public int selectItemViewListCnt(SearchVO vo) throws Exception {
		int cnt;
		cnt = itemMapper.selectItemViewListCnt(vo);
		return cnt;
	}
	
	// 통관정보 조회
	@Override
	public List<?> selectItemViewLanList(SearchVO vo) throws Exception {
		return itemMapper.selectItemViewLanList(vo);
	}
	// 요건정보 조회
	@Override
	public List<?> selectItemViewSpecList(SearchVO vo) throws Exception {
		return itemMapper.selectItemViewSpecList(vo);
	}
	// 수입 아이템 조회
	@Override
	public List<?> selectItemViewimportList(SearchVO vo) throws Exception {
		return itemMapper.selectItemViewimportList(vo);
	}

	@Override
	public int selectItemViewimportListCnt(SearchVO vo) throws Exception {
		int cnt;
		cnt = itemMapper.selectItemViewimportListCnt(vo);
		return cnt;
	}
	// 수출 아이템 조회
	@Override
	public List<?> selectItemViewExportList(SearchVO vo) throws Exception {
		return itemMapper.selectItemViewExportList(vo);
	}

	@Override
	public int selectItemViewExportListCnt(SearchVO vo) throws Exception {
		int cnt;
		cnt = itemMapper.selectItemViewExportListCnt(vo);
		return cnt;
	}
    // 수입통관내역 조회
	@Override
	public List<?> selectItemViewLanImportList(SearchVO vo) throws Exception {
		return itemMapper.selectItemViewLanImportList(vo);
	}
	// 수출통관내역 조회
	@Override
	public List<?> selectItemViewLanExportList(SearchVO vo) throws Exception {
		return itemMapper.selectItemViewLanExportList(vo);
	}
	// 수출입 통관 내역 검색
	@Override
	public List<?> selectitemViewLanList2(SearchVO vo) throws Exception {
		return itemMapper.selectitemViewLanList2(vo);
	}
	// 수입통관내역 검색
	@Override
	public List<?> selectitemViewLanImportList2(SearchVO vo) throws Exception {
		return itemMapper.selectitemViewLanImportList2(vo);
	}
	// 수출통관내역 검색
	@Override
	public List<?> selectitemViewLanExportList2(SearchVO vo) throws Exception {
		return itemMapper.selectitemViewLanExportList2(vo);
	}
	// 중복허용될때 전체 아이템 조회
	@Override
	public List<?> selectDuplicationItemViewList(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return itemMapper.selectDuplicationItemViewList(vo);
	}
	
	@Override
	public int selectDuplicationItemViewListCnt(SearchVO vo) throws Exception {
		return itemMapper.selectDuplicationItemViewListCnt(vo);
	}
	// 중복허용될때 수입 아이템 조회
	@Override
	public List<?> selectDuplicationItemViewimportList(SearchVO vo) throws Exception {
		return itemMapper.selectDuplicationItemViewimportList(vo);
	}

	@Override
	public int selectDuplicationItemViewimportListCnt(SearchVO vo) throws Exception {
		return itemMapper.selectDuplicationItemViewimportListCnt(vo);
	}
	// 중복허용될때 수출 아이템 조회
	@Override
	public List<?> selectDuplicationItemViewExportList(SearchVO vo) throws Exception {
		return itemMapper.selectDuplicationItemViewExportList(vo);
	}

	@Override
	public int selectDuplicationItemViewExportListCnt(SearchVO vo) throws Exception {
		return itemMapper.selectDuplicationItemViewExportListCnt(vo);
	}

	
}
