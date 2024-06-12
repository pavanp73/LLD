package designpatterns.singleton.doublechecklocking;

public class Database {

    private static Database database;

    private Database() {}

    // lazy initialization with thready safety
    public static Database getInstance() {

        if (database == null) {
            synchronized (Database.class) {
                if (database == null) {
                    database = new Database();
                }
            }
        }
        return database;
    }
}
