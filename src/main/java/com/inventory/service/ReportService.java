package com.inventory.service;

import com.inventory.dto.report.CustomerReportDto;
import com.inventory.dto.report.ItemReportDto;

public interface ReportService {

	ItemReportDto getItemReport(String fromDate, String toDate, Long useId);
	
	CustomerReportDto getReportByCustomer(String fromDate, String toDate, String mobileNumber);
}
