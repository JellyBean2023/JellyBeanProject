package com.jellybean.api.service;

import com.jellybean.api.entity.EmailEntity;
import com.jellybean.api.repository.EmailRepository;
import jakarta.mail.Message.RecipientType;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.Random;

@Slf4j
@Component
@Repository
@RestController
@Controller
@Service
public class EmailServiceImpl implements EmailService{
    private final EmailRepository emailRepository;

    public EmailServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    @Override
    public void saveEmailCode(String email, String code) {
        EmailEntity emailEntity = new EmailEntity();
        emailEntity.setEmail(email);
        emailEntity.setCode(code);
        emailRepository.save(emailEntity);
    }

    @Autowired
    JavaMailSender emailSender;

    public static final String ePw = createKey();

    private MimeMessage createMessage(String to)throws Exception{
        System.out.println("보내는 대상 : "+ to);
        System.out.println("인증 번호 : "+ePw);
        MimeMessage message = emailSender.createMimeMessage();

        message.addRecipients(RecipientType.TO, to);//보내는 대상
        message.setSubject("JellyBean 이메일 인증 코드 '~'");//제목

        String msgg="";
        msgg+= "<div style='margin:20px;'>";
        msgg+= "<h1> JellyBean 이메일 인증 '~'</h1>";
        msgg+= "<br>";
        msgg+= "<p>아래 코드를 복사해 입력해주세요<p>";
        msgg+= "<br>";
        msgg+= "<p>감사합니다 '~'<p>";
        msgg+= "<br>";
        msgg+= "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msgg+= "<h3 style='color:blue;'>회원가입 인증 코드</h3>";
        msgg+= "<div style='font-size:130%'>";
        msgg+= "CODE : <strong>";
        msgg+= ePw+"</strong><div><br/> ";
        msgg+= "</div>";
        message.setText(msgg, "utf-8", "html");//내용
        message.setFrom(new InternetAddress("yoodh124@gmail.com","yoodahee"));//보내는 사람

        return message;
    }

    public static String createKey() {
        StringBuffer key = new StringBuffer();
        Random rnd = new Random();

        for (int i = 0; i < 8; i++) { // 인증코드 8자리
            int index = rnd.nextInt(3); // 0~2 까지 랜덤

            switch (index) {
                case 0:
                    key.append((char) ((int) (rnd.nextInt(26)) + 97));
                    //  a~z  (ex. 1+97=98 => (char)98 = 'b')
                    break;
                case 1:
                    key.append((char) ((int) (rnd.nextInt(26)) + 65));
                    //  A~Z
                    break;
                case 2:
                    key.append((rnd.nextInt(10)));
                    // 0~9
                    break;
            }
        }
        return key.toString();
    }

    @Override
    public String sendSimpleMessage(String to)throws Exception {
        // 이메일 전송
        MimeMessage message = createMessage(to);
        try{//예외처리
            emailSender.send(message);
        }catch(MailException es){
            es.printStackTrace();
            throw new IllegalArgumentException("Failed to send email.");
        }

        // DB에 이메일과 인증번호 저장
        saveEmailCode(to, ePw);

        return ePw;
    }

    public boolean checker(String email, String code) {
        // DB에서 해당 이메일로 저장된 인증 코드를 가져옴
        Optional<EmailEntity> savedVerificationCode = emailRepository.findByemail(email);

        // Optional 객체가 비어있는지 확인하고 인증 코드 비교
        if (savedVerificationCode.isPresent()) {
            return code.equals(savedVerificationCode.get().getCode());
        } else {
            // 해당 이메일로 저장된 인증 코드가 없는 경우
            return false;
        }
    }
}

