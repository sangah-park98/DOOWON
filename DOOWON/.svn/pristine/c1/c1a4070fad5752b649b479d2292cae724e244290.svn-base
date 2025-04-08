package egovframework.pf.config;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;

@Component("forexView")
public class CurrencyRateHtmlView extends AbstractView {
	  private JasperReport currencyRatesReport;

	  @Override
	  protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
	                                         HttpServletResponse response) throws Exception {
	      response.setContentType("text/html");
	      List<JasperListVo> itemList = (List<JasperListVo>) model.get("itemList");

	      CurrencyRate param = (CurrencyRate) model.get("parameter");

	      Map parameters = new HashMap();
	      parameters.put("currencyPair", param.getCurrencyPair());
	      parameters.put("askPrice", param.getAskPrice());
	      parameters.put("bidPrice", param.getBidPrice());
	      parameters.put("date", param.getDate());



	      //data source
	      JRDataSource dataSource = new JRBeanCollectionDataSource(itemList);
	      //compile jrxml template and get report
	      JasperReport report = null;
	      if (currencyRatesReport == null) {//compile only once lazily
	          //InputStream stream = getClass().getResourceAsStream("/rates.jrxml");
	    	  InputStream stream = getClass().getResourceAsStream("/Blank_A4.jrxml");
	    	  //InputStream stream = getClass().getResourceAsStream("/UnicodeReport.jrxml");
	          currencyRatesReport = JasperCompileManager.compileReport(stream);
	      }
	      report = currencyRatesReport;

	      //fill the report with data source objects
	      JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, dataSource);


	      //export to html
	      HtmlExporter exporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
	      exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
	      exporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
	      exporter.exportReport();

//	      HtmlExporter exporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
////	      exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
////	      exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
//	      exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//	      //exporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
//
//	      SimpleHtmlReportConfiguration reportExportConfiguration = new SimpleHtmlReportConfiguration();
//	      //reportExportConfiguration.setSizeUnit(HtmlSizeUnitEnum.POINT);
//	      exporter.setConfiguration(reportExportConfiguration);
//	      exporter.exportReport();

	  }


	  private JRDataSource getDataSource(List<CurrencyRate> rates) {
	      JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(rates);
	      return dataSource;
	  }

	  public JasperReport getReport() throws JRException {
	      if (currencyRatesReport == null) {//compile only once lazily
	          //InputStream stream = getClass().getResourceAsStream("/rates.jrxml");
	    	  InputStream stream = getClass().getResourceAsStream("/Blank_A4.jrxml");
	          currencyRatesReport = JasperCompileManager.compileReport(stream);
	      }
	      return currencyRatesReport;
	  }
	}
