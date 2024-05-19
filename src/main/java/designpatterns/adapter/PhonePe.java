package designpatterns.adapter;

public class PhonePe {

    /*public void sendMoney(String from, String to, int amount) {
        bankAPI.sendMoney(from, to, amount);
    }*/

    public static void main(String[] args) {
        final BankAPI bankAPI = BankAPIFactory.getBankAPIFactory(Bank.ICICIBANK);
        assert bankAPI != null;
        bankAPI.sendMoney("1234", "6578", 1000);
    }
}
