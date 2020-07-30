package effectivejava.chapter2.item5.injector;

public class EmailService {
    public void sendEmail(String message,String receiver){
        System.out.println("Email send to " + receiver + " with message " + message);
    }
}
