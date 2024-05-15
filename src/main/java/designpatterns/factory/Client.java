package designpatterns.factory;

public class Client {

    public static void main(String[] args) {
        Flutter flutter = new Flutter();
        UIFactory uiFactory = flutter.getUIFactoryForPlatform(SupportedPlatform.ANDROID);

        uiFactory.createButton().click();
        uiFactory.createMenu().showMenu();
    }
}
