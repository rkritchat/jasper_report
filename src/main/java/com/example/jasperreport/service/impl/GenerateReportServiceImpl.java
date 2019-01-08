package com.example.jasperreport.service.impl;

import com.example.jasperreport.model.ExampleModel;
import com.example.jasperreport.service.GenerateReportService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 *
 * /home/rkritchat/Desktop/jasper_report_template.jrxml is Linux path
 */
@Service
public class GenerateReportServiceImpl implements GenerateReportService {

    @Override
    public void generatePdf() {
        try {
            List<ExampleModel> dataList = prepareParameter();
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);
            String destinationPath = "/home/rkritchat/Desktop/sample_report.pdf";
            JasperPrint jasperPrint = createJasperPrint(dataSource);
            JasperExportManager.exportReportToPdfFile(jasperPrint,destinationPath);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateHtml() {
        try {
            List<ExampleModel> dataList = prepareParameter();
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);
            String destinationPath = "/home/rkritchat/Desktop/sample_report.html";
            JasperPrint jasperPrint = createJasperPrint(dataSource);
            JasperExportManager.exportReportToHtmlFile(jasperPrint,destinationPath);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void generateXml() {
        try {
            /**
             * This method will generate xml file but it looks strange but let it be, at least it working at all....
             */
            List<ExampleModel> dataList = prepareParameter();
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(dataList);
            String destinationPath = "/home/rkritchat/Desktop/sample_report.xml";
            JasperPrint jasperPrint = createJasperPrint(dataSource);
            JasperExportManager.exportReportToXmlFile(jasperPrint,destinationPath,true);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }


    private JasperPrint createJasperPrint(JRBeanCollectionDataSource dataSource){
        /**
         *    Compile jrxml to jasper file, in case already have .jasper then we can skip this step..
         */
        //JasperCompileManager.compileReportToFile("/home/rkritchat/Desktop/jasper_report_template.jrxml");
        try {
            String targetFile = "/home/rkritchat/Desktop/jasper_report_template.jasper";
            /**
             * send empty HashMap tp fillReportToFile
             */
            Map empTyHashMap = new HashMap();
            return JasperFillManager.fillReport(targetFile, empTyHashMap, dataSource);
        } catch (JRException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    /**
     * Prepare parameter
     * @return
     */
    private List<ExampleModel> prepareParameter() {
        return Arrays.asList(
                new ExampleModel().setName("Kritchat").setCountry("Thailand"),
                new ExampleModel().setName("Rojanaphruk").setCountry("India")
        );
    }
}
