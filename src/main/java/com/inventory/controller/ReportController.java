package com.inventory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dto.report.CustomerReportDto;
import com.inventory.dto.report.ItemReportDto;
import com.inventory.service.ReportService;

@RestController
public class ReportController {

	@Autowired
	private ReportService reportService;

	@GetMapping("/saleReport/{fromDate}")
	public ItemReportDto getItemReport(@PathVariable("fromDate") String fromDate, @RequestParam("toDate") String toDate,
			@RequestParam("userId") Long useId) {
		return reportService.getItemReport(fromDate, toDate, useId);
	}

	@GetMapping("/saleReport/{fromDate}/{mobileNumber}")
	public CustomerReportDto getReportByCustomer(@PathVariable("fromDate") String fromDate,
			@RequestParam("toDate") String toDate, @PathVariable("mobileNumber") String mobileNumber) {
		return reportService.getReportByCustomer(fromDate, toDate, mobileNumber);
	}

}
