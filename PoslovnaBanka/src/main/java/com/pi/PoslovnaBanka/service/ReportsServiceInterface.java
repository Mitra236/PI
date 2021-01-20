package com.pi.PoslovnaBanka.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;

public interface ReportsServiceInterface {

	ByteArrayInputStream getReports(String racun, Date od_datuma, Date do_datuma) throws JRException, IOException, SQLException;
}
