package usecase.notifications;

public interface SenderEmailService {

    void sendEmail (String email, String contentBody);

}
