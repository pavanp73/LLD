package designpatterns.factory;

import designpatterns.factory.button.Button;
import designpatterns.factory.button.IOSButton;
import designpatterns.factory.menu.IOSMenu;
import designpatterns.factory.menu.Menu;

public class IOSUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public Menu createMenu() {
        return new IOSMenu();
    }
}
