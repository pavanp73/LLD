package designpatterns.adapter;

public class PhonePe {

    static BankAPI bankAPI = new ICICIAdapter();

    /*public void sendMoney(String from, String to, int amount) {
        bankAPI.sendMoney(from, to, amount);
    }*/

    public static void main(String[] args) {
        bankAPI.sendMoney("1234", "6578", 1000);
    }

}
