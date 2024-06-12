package designpatterns.singleton.lazy;

public class Database {

    private static Database database;

    private Database() {}

    public static Database getInstance() {

        // lazy initialization
        if (database == null) {
            database = new Database();
        }
        return database;
    }
}
