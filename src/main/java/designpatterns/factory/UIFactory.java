package designpatterns.factory;

import designpatterns.factory.button.Button;
import designpatterns.factory.menu.Menu;

// we will have only factory methods
public interface UIFactory {

    Button createButton();

    Menu createMenu();

}
