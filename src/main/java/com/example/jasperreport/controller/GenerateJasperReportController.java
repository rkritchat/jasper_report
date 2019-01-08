package com.example.jasperreport.controller;

import com.example.jasperreport.service.GenerateReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generate")
public class GenerateJasperReportController {

    @Autowired
    private GenerateReportService generateReportService;

    @GetMapping("/pdf")
    public String generatePdf()   {
        generateReportService.generatePdf();
        return "Generated PDF Successfully";
    }

    @GetMapping("/html")
    public String generateHtml(){
        generateReportService.generateHtml();
        return "Generated HTML Successfully";
    }

    @GetMapping("/xml")
    public String generateXml(){
        generateReportService.generateXml();
        return "Generated Xml Successfully";
    }
}