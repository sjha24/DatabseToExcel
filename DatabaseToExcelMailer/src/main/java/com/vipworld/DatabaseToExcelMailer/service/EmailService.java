package com.vipworld.DatabaseToExcelMailer.service;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.io.IOException;


@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private ExcelService excelService;

    @Scheduled(cron = "0 20 13 * * ?")
    public void sendEmailWithExcelAttachment () throws MessagingException, IOException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        byte[] excelData = excelService.exportToExcel();

        helper.setTo("simisann@gmail.com");
        helper.setSubject("Daily Data Export");
        helper.setText("Hello Simi Sann Please find the attached Excel sheet containing the latest data.");

        ByteArrayResource resource = new ByteArrayResource(excelData);
        helper.addAttachment("data.xlsx",resource);

        mailSender.send(mimeMessage);
    }
}
