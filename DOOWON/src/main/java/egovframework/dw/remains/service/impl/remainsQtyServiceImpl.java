package egovframework.dw.remains.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.dw.cmmn.service.SearchVO;
import egovframework.dw.cmmn.service.UserSessionVO;
import egovframework.dw.remains.service.remainsInfoVO;
import egovframework.dw.remains.service.remainsQtyService;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Service("remainsQtyService")
public class remainsQtyServiceImpl extends EgovAbstractMapper implements remainsQtyService {

	@Resource(name="remainsQtyMapper")
	private remainsQtyMapper remainsQtyMapper;

	@Override
	public List<?> selectRemainsViewList(SearchVO vo) throws Exception {
		return remainsQtyMapper.selectRemainsViewList(vo);
	}
	@Override
	public List<?> selectRemainsRptNoList(SearchVO vo) throws Exception {
		return remainsQtyMapper.selectRemainsRptNoList(vo);
	}
	@Override
	public List<?> selectRemainsInputList(SearchVO vo) throws Exception {
		return remainsQtyMapper.selectRemainsInputList(vo);
	}
	@Override
	public void insertRemainsInputList(List<remainsInfoVO> voList, UserSessionVO userVO) throws Exception {
		for (remainsInfoVO rvo : voList) {
			rvo.setRegId(userVO.getId());
			rvo.setEdtId(userVO.getId());
			remainsQtyMapper.insertRemainsInputList(rvo);
		}
	}
	@Override
	public List<?> getImporterList() throws Exception {
		return remainsQtyMapper.getImporterList();
	}
	@Override
	public void deleteRemainsInputList(remainsInfoVO vo) throws Exception {
		remainsQtyMapper.deleteRemainsInputList(vo);
	}
}