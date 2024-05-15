package designpatterns.factory;

import designpatterns.factory.button.AndroidButton;
import designpatterns.factory.button.Button;
import designpatterns.factory.menu.AndroidMenu;
import designpatterns.factory.menu.Menu;

public class AndroidUIFactory implements UIFactory {

    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public Menu createMenu() {
        return new AndroidMenu();
    }
}
