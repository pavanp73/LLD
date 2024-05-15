package designpatterns.factory;

// practical factory pattern
public class UIFactoryFactory {

    public static UIFactory getUIFactoryForPlatform(SupportedPlatform platform) {

        if (platform.equals(SupportedPlatform.ANDROID)) {
            return new AndroidUIFactory();
        } else if (platform.equals(SupportedPlatform.IOS)) {
            return new IOSUIFactory();
        }
        return null;
    }
}
