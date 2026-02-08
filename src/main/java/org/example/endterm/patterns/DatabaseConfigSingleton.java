package org.example.endterm.patterns;

public class DatabaseConfigSingleton {

    private static DatabaseConfigSingleton instance;

    private DatabaseConfigSingleton() {}

    public static synchronized DatabaseConfigSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseConfigSingleton();
        }
        return instance;
    }
}

