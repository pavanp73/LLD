package designpatterns.factory;

public class Flutter {

    void refreshUI() {
        System.out.println("Refreshing UI");
    }

    void setTheme() {
        System.out.println("Setting theme");
    }

    UIFactory getUIFactoryForPlatform(SupportedPlatform platform) {
        if (platform.equals(SupportedPlatform.ANDROID)) {
            return new AndroidUIFactory();
        } else if (platform.equals(SupportedPlatform.IOS)) {
            return new IOSUIFactory();
        }
        return null;
    }
}
