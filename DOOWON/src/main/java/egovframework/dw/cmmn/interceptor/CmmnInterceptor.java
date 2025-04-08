package egovframework.dw.cmmn.interceptor;

import java.util.Arrays;
import java.util.List;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import egovframework.dw.cmmn.service.CmmnService;
import egovframework.dw.cmmn.service.UserSessionVO;

/**
 * @Class Name : CmmnInterceptor.java
 * @Description : CmmnInterceptor Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2009.03.16           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public class CmmnInterceptor extends HandlerInterceptorAdapter {

	private static final Logger log = LoggerFactory.getLogger(CmmnInterceptor.class);

	@Resource(name = "CmmnService")
	private CmmnService CmmnService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(log.isDebugEnabled()) {
			log.debug("Request URI : " + request.getRequestURI());
		}

		//	인터페이스 페이지는 세션 체크 예외
		String requestURI = request.getRequestURI();
		if (requestURI.indexOf("/api/") > -1) {
			return true;
		}
		// 회원가입 페이지는 세션 체크 예외
		if (requestURI.indexOf("/member/") > -1) {
			return true;
		}

		HttpSession httpSession = request.getSession(true);
		if(request.getRequestURI().indexOf("/prtl/") < 0) {
			UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("USER");
	
			if(userVO == null) {
				if("true".equals(request.getHeader("AJAX"))) { // ajax인 경우 400에러 발송
					response.sendError(400);
				} else {
					response.sendRedirect(request.getContextPath()+"/relogin.do");
					System.out.println("@@@@@ logout");
					//response.sendRedirect(request.getContextPath()+"/login.do");
				}
				return false;
			}

		}else {
			UserSessionVO userVO = (UserSessionVO) httpSession.getAttribute("PORTALUSER");
			if(userVO == null) {
				response.sendRedirect(request.getContextPath()+"/rePortallogin.do");
				return false;
			}
		}

		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		//Cache 방지
		if("HTTP/1.1".equals(request.getProtocol())) {
			response.setHeader ("Cache-Control", "no-cache, no-store, must-revalidate");
		}else{
			response.setHeader ("Pragma", "no-cache");
		}
		response.setDateHeader ("Expires", 0);
	}

}
