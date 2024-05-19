package designpatterns.adapter;

public class BankAPIFactory {

    public static BankAPI getBankAPIFactory(Bank bank) {
        switch (bank) {
            case YESBANK:
                return new YesBankAdapter();
            case ICICIBANK:
                return new ICICIAdapter();
            default:
                return null;
        }
    }
}
