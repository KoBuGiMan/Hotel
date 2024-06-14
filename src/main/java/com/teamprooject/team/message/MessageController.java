package com.teamprooject.team.message;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.exception.NurigoBadRequestException;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Random;

@RestController
public class MessageController {


    final DefaultMessageService messageService;


    public MessageController() {
        this.messageService = NurigoApp.INSTANCE.initialize("NCSXY9JJDJG4EGR4", "S8NBHT2IWDDMBXCHCK6U0WYWLEPAFJKO", "https://api.coolsms.co.kr");
    }


    @PostMapping("/send-mms")
    public VerificationResponse sendMmsByResourcePath(@RequestBody PhoneNumberRequest phoneNumberRequest) throws IOException, NurigoBadRequestException {
        String phoneNum = phoneNumberRequest.getPhoneNum();
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000; // Ensuring a 4-digit number

        if (phoneNum == null || !phoneNum.matches("\\d{10,11}")) {
            throw new NurigoBadRequestException("Invalid phone number format.");
        }

        Message message = new Message();
        message.setFrom("01056703899");
        message.setTo(phoneNum);
        message.setText("Your verification code is: [" + randomNumber+"]");
        System.out.println(message);
        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);

        return new VerificationResponse(randomNumber, response);
    }

    public static class PhoneNumberRequest {
        private String phoneNum;

        public String getPhoneNum() {
            return phoneNum;
        }

        public void setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
        }
    }

    public static class VerificationResponse {
        private int verificationCode;
        private SingleMessageSentResponse messageResponse;

        public VerificationResponse(int verificationCode, SingleMessageSentResponse messageResponse) {
            this.verificationCode = verificationCode;
            this.messageResponse = messageResponse;
        }

        public int getVerificationCode() {
            return verificationCode;
        }

        public SingleMessageSentResponse getMessageResponse() {
            return messageResponse;
        }
    }
}