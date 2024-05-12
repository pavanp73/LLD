package designpatterns.prototype;

import java.util.HashMap;

public class StudentRegistry {

    private HashMap<String, Student> registry = new HashMap<>();

    public void register(String key, Student student) {
        registry.put(key, student);
    }

    public Student get(String key) {
        return registry.get(key);
    }
}
