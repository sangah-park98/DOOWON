package egovframework.pf.rpt.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.pf.rpt.service.SaveCalculInfoVO;
import egovframework.pf.rpt.service.SaveFundSettleVO;
import egovframework.pf.rpt.service.SaveFundSettledetailVO;
import egovframework.pf.rpt.service.fundSettleService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;


/**
 * @Class Name : fundSettleServiceImpl.java
 * @Description : fundSettleServiceImpl Class
 * @Modification Information
 * @
 * @         수정일            		       수정자           			수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2025.02.17          	권예지         			최초 생성
 *
 * @author 권예지
 * @since  2025.02.17 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by KordSystems All right reserved.
 */

@Service("fundSettleService")
public class fundSettleServiceImpl extends EgovAbstractServiceImpl implements fundSettleService {


	@Resource(name="fundSettleMapper")
	private fundSettleMapper fundSettleMapper;
	
	// 마스터 리스트
	@Override
	public List<?> selectMasterInfo(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return fundSettleMapper.selectMasterInfo(vo);
	}

	// 마스터 편집 저장
	@Override
	public void savefundSettle(List<SaveFundSettleVO> voList, UserSessionVO userVO) throws Exception {
		// TODO Auto-generated method stub
		for(SaveFundSettleVO vo : voList) {
			vo.setRegId(userVO.getId());
			if(vo.getSeq() != null) {
				// update
				System.out.println("UPDATE");
				fundSettleMapper.updatefundSettle(vo);
			}else {
				//insert
				System.out.println("INSERT");
				fundSettleMapper.savefundSettle(vo);
			}
			
		}
	}
	//자금정산 select
	@Override
	public List<?> selectfundSettle(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return fundSettleMapper.selectfundSettle(vo);
	}
	//fr_key select
	@Override
	public String selectfrKey(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return fundSettleMapper.selectfrKey(vo);
	}
	//화물관리번호 select 
	public String selectmrnNo(String frKey) throws Exception {
		// TODO Auto-generated method stub
		return fundSettleMapper.selectmrnNo(frKey);
	}

	// 팝업 자금정산 select 
	@Override
	public List<?> selectfundSettleDetail(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return fundSettleMapper.selectfundSettleDetail(vo);
	}
	
	//세관 select 
	@Override
	public List<?> selectCustomsList() throws Exception {
		// TODO Auto-generated method stub
		return fundSettleMapper.selectCustomsList();
	}

	//포워더 select
	@Override
	public List<?> selectforwordList() throws Exception {
		// TODO Auto-generated method stub
		return fundSettleMapper.selectforwordList();
	}
	//운송 select
	@Override
	public List<?> selectTransportationList() throws Exception {
		// TODO Auto-generated method stub
		return fundSettleMapper.selectTransportationList();
	}
	//창고 select 
	@Override
	public List<?> selectWarehouseList() throws Exception {
		// TODO Auto-generated method stub
		return fundSettleMapper.selectWarehouseList();
	}
	//보험료 select 
	@Override
	public List<?> selectPremiumList() throws Exception {
		// TODO Auto-generated method stub
		return fundSettleMapper.selectPremiumList();
	}

	@Override
	public void savefundSettleDetail(List<SaveFundSettledetailVO> voList, UserSessionVO userVO) throws Exception {
		// TODO Auto-generated method stub
			for(SaveFundSettledetailVO vo : voList) {
				vo.setRegId(userVO.getId());
				vo.setTaxNo(userVO.getCorpNo());
				fundSettleMapper.savefundSettleDetail(vo);
				}
				
			}
	//통관수수료 select
	@Override
	public List<?> selectfeeList() throws Exception {
		// TODO Auto-generated method stub
		return fundSettleMapper.selectfeeList();
	}
	//모든 마스터 select
	@Override
	public List<?> selectMasterList() throws Exception {
		// TODO Auto-generated method stub
		return fundSettleMapper.selectMasterList();
	}

	@Override
	public void savefundSettleEtc(List<SaveFundSettledetailVO> voList, UserSessionVO userVO) throws Exception {
		for(SaveFundSettledetailVO vo : voList) {
			vo.setRegId(userVO.getId());
			vo.setTaxNo(userVO.getCorpNo());
			fundSettleMapper.insertfundSettleEtc(vo);
			}
		
	}

	@Override
	public void insertDeadlineYn(List<SaveFundSettledetailVO> setVoList, UserSessionVO userVO) throws Exception {
		for(SaveFundSettledetailVO vo : setVoList) {
			vo.setRegId(userVO.getId());
			vo.setTaxNo(userVO.getCorpNo());
			fundSettleMapper.insertDeadlineYn(vo);
			}
		
	}
	}
