package egovframework.pf.cmmn.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hsqldb.lib.StringUtil;
import org.springframework.stereotype.Service;

import com.itextpdf.text.log.SysoCounter;

//import egovframework.fta.base.service.impl.CnvrsnrtMapper;
/*import egovframework.fta.base.service.SaveCnvrsnrtVO;
import egovframework.fta.base.service.impl.CnvrsnrtMapper;*/
import egovframework.pf.cmmn.service.CmmnService;
import egovframework.pf.cmmn.service.CompanyService;
import egovframework.pf.cmmn.service.MenuService;
import egovframework.pf.cmmn.service.SaveMemberUpateVO;
import egovframework.pf.cmmn.service.SaveMenuVO;
import egovframework.pf.cmmn.service.UserService;

import egovframework.pf.cmmn.service.SearchVO;
import egovframework.pf.cmmn.service.UserSessionVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;


/**
 * @Class Name : UserService.java
 * @Description : UserService Class
 * @Modification Information
 * @
 * @         수정일            			수정자          			 수정내용
 * @    ----------------    ------------    ---------------------------
 * @       2024.02.05	 	        권예지			          최초 생성
 * @     
 *
 * @author 권예지
 * @since 2024.02.05
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */

@Service("menuService")
public class MenuServiceImpl extends EgovAbstractServiceImpl implements MenuService{

	@Resource(name="menuMapper")
	private MenuMapper menuMapper;
	
	@Resource(name = "CmmnService")
	private CmmnService CmmnService;
	
	
	//대메뉴 조회
	@Override
	public List<?> selectMenuList(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return menuMapper.selectMenuList(vo);
	}
	//대메뉴 조회 갯수
	@Override
	public int selectMenuListCnt(SearchVO vo) throws Exception {
		// TODO Auto-generated method stub
		return menuMapper.selectMenuListCnt(vo);
	}
	@Override
	public List<?> selectUpprMenuDropdown() throws Exception {
		// TODO Auto-generated method stub
		return menuMapper.selectUpprMenuDropdown();
	}
	
	//메뉴 목록 저장
	@Override
	public void savePfMenuInfo(List<SaveMenuVO> voList, UserSessionVO userVO) {
		
		for(SaveMenuVO vo :voList) {
			String menuId = vo.getMenuId();
			System.out.println();
			String id = userVO.getId();
			vo.setEdtId(id);
			vo.setRegId(id);
			System.out.println("menuType"+vo.getMenuType());
			if(vo.getMenuType().equals("02")) {

				String menuType = vo.getMenuType();
					menuType = "02";
					vo.setMenuType(menuType);
					System.out.println("소메뉴");
				//소메뉴
				menuMapper.insertPfMenuInfo(vo);
			}else if(vo.getMenuType().equals("01")){

				vo.setUpprMenuId("super");
				System.out.println("대메뉴");
				//대메뉴
				menuMapper.insertPfMenuInfo(vo);
			}
			
		}
		
	}
	
	 }


	


