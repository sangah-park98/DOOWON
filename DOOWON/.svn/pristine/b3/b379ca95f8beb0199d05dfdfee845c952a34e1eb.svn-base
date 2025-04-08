package egovframework.com.cmm.config;

import java.security.Security;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.web.WebApplicationInitializer;

public class EgovWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// TODO Auto-generated method stub
		Security.setProperty("jdk.tls.disabledAlgorithms", "");
		Security.setProperty("jdk.certpath.disabledAlgorithms", "");
		
	}

}
