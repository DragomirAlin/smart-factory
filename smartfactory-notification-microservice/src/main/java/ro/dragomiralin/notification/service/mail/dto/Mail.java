package ro.dragomiralin.notification.service.mail.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Mail {
    private String mailFrom;
    private String mailTo;
    private String mailCc;
    private String mailBcc;
    private String mailSubject;
    private String mailContent;
    private String contentType;
    private List<Object> attachments;

}