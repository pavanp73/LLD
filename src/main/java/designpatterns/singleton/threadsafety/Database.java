package designpatterns.singleton.threadsafety;

public class Database {

    private static Database database;

    private Database() {}

    // lazy initialization with thready safety
    public static synchronized Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }
}
