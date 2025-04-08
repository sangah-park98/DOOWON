package egovframework.dw.config;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReportsContext;
import net.sf.jasperreports.engine.design.JRAbstractMultiClassCompiler;

public class JRJavacCompiler2 extends JRAbstractMultiClassCompiler{

	public JRJavacCompiler2(JasperReportsContext jasperReportsContext) {
		super(jasperReportsContext);
	}

	@Override
	public String compileClasses(File[] sourceFiles, String classpath) throws JRException {
		String[] source = new String[sourceFiles.length +5];
		source[0] = "javac";
		source[1] = "-encoding";
		source[2] = "utf-8";
		source[3] = "-classpath";
		source[4] = "classpath";
		
		for (int i = 0; i < sourceFiles.length; i++) {
			source[i+5] = sourceFiles[i].getPath();
		}
		
		try {
			Process compile = Runtime.getRuntime().exec(source);
			InputStream errFile = compile.getErrorStream();
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int count = 0;
			do {
				count = errFile.read(buffer);
				if(count > 0) {
					baos.write(buffer, 0, count);
				}
			} while (count >= 0);
			
			if(baos.toString().indexOf("error") != -1) {
				return baos.toString();
			}
			
			return null;
		}catch(Exception e) {
			StringBuffer files = new StringBuffer();
			for (int i = 0; i < sourceFiles.length; i++) {
				files.append(sourceFiles[i].getPath());
				files.append(' ');
			}
			throw new JRException(EXCEPTION_MESSAGE_KEY_JAVA_SOURCE_COMPILE_ERROR, new Object[] {files}, e);
		}		
	}
}
