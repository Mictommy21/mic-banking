package com.baraka.mic_banking.service;

import com.baraka.mic_banking.dto.EmailDetails;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Objects;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    @Override
    public void sendEmailAlert(EmailDetails emailDetails) {

        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            mailMessage.setFrom(senderEmail);
            mailMessage.setTo(emailDetails.getRecipient());
            mailMessage.setSubject(emailDetails.getSubject());
            mailMessage.setText(emailDetails.getMessageBody());

            javaMailSender.send(mailMessage);

            log.info("Email sent successfully to {}",
                    emailDetails.getRecipient());

        } catch (MailException e) {

            log.error("Failed to send email to {}",
                    emailDetails.getRecipient(), e);

            throw new RuntimeException("Failed to send email", e);
        }
    }

    @Override
    public void sendEmailWithAttachment(EmailDetails emailDetails) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper =
                    new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(senderEmail);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setSubject(emailDetails.getSubject());
            mimeMessageHelper.setText(emailDetails.getMessageBody());

            FileSystemResource file =
                    new FileSystemResource(
                            new File(emailDetails.getAttachment())
                    );

            mimeMessageHelper.addAttachment(
                    Objects.requireNonNull(file.getFilename()),
                    file
            );

            javaMailSender.send(mimeMessage);

            log.info(
                    "{} has been sent to {}",
                    file.getFilename(),
                    emailDetails.getRecipient()
            );

        } catch (MessagingException | MailException e) {

            log.error(
                    "Failed to send attachment email to {}",
                    emailDetails.getRecipient(),
                    e
            );

            throw new RuntimeException("Failed to send email with attachment", e);
        }
    }
}