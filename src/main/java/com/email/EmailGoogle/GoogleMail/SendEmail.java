package com.email.EmailGoogle.GoogleMail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmail {

    @Autowired
    JavaMailSender javaMailSender;

    public  String send(User user){
        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setFrom(user.getFrom());
            mail.setTo(user.getTo());
            mail.setSubject(user.getSubject());
            mail.setText(user.getContent());

            javaMailSender.send(mail);

        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }


//    public void sendEmailWithAttachment(User user) throws MailException, MessagingException {
//
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//
//        helper.setTo(user.getEmailAddress());
//        helper.setSubject("Testing Mail API with Attachment");
//        helper.setText("Please find the attached document below.");
//
//        ClassPathResource classPathResource = new ClassPathResource("Attachment.pdf");
//        helper.addAttachment(classPathResource.getFilename(), classPathResource);
//
//        javaMailSender.send(mimeMessage);
//    }



}
