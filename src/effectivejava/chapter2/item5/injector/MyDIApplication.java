package effectivejava.chapter2.item5.injector;

//midleclass
public class MyDIApplication implements Consumer{
    private MessageService messageService;
    @Override
    public void processMessage(String msg, String rec) {
        messageService.sendMessage(msg,rec);
    }

    public MyDIApplication(MessageService messageService){
        this.messageService = messageService;
    }

    @Override
    public void addedMethod() {
        messageService.addMethod();
    }
}
