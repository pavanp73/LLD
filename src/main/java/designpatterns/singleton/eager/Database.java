package designpatterns.singleton.eager;

public class Database {

    // eager initialization
    private static Database database = new Database();

    private Database() {}

    public static Database getInstance() {
        return database;
    }
}
