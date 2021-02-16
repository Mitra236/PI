package com.pi.PoslovnaBanka.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class ReportsService implements ReportsServiceInterface{

	@Override
	public ByteArrayInputStream getReports(String racun, Date od_datuma, Date do_datuma) throws JRException, IOException, SQLException {
		Map<String, Object> map = new HashMap<>();
		map.put("racun_duznika", racun);
		map.put("od_datuma", od_datuma);
		map.put("do_datuma", do_datuma);
		JasperPrint jp = JasperFillManager.fillReport(
			getClass().getResource("/jasper/Blank_A4.jasper").openStream(),
			map, DriverManager.getConnection("jdbc:mysql://localhost:3306/piDatabase", "root", "root"));
		ByteArrayInputStream bis = new ByteArrayInputStream(JasperExportManager.exportReportToPdf(jp));
		
		return bis;
	}
	
	@Override
	public ByteArrayInputStream getBankReports() throws JRException, IOException, SQLException {
		JasperPrint jp = JasperFillManager.fillReport(
			getClass().getResource("/jasper/BankReport.jasper").openStream(),
			null, DriverManager.getConnection("jdbc:mysql://localhost:3306/piDatabase", "root", "root"));
		ByteArrayInputStream bis = new ByteArrayInputStream(JasperExportManager.exportReportToPdf(jp));
		
		return bis;
	}
	
	@Override
	public String getXMLReports(String racun, Date od_datuma, Date do_datuma) throws JRException, IOException, SQLException {
		Map<String, Object> map = new HashMap<>();
		map.put("racun_duznika", racun);
		map.put("od_datuma", od_datuma);
		map.put("do_datuma", do_datuma);
		JasperPrint jp = JasperFillManager.fillReport(
			getClass().getResource("/jasper/Blank_A4.jasper").openStream(),
			map, DriverManager.getConnection("jdbc:mysql://localhost:3306/piDatabase", "root", "root"));
		
		String bis = JasperExportManager.exportReportToXml(jp);
        
        return bis;
	}
}
