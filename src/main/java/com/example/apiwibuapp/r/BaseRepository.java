package com.example.apiwibuapp.r;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import storage.AppStorage;
import util.AppDatabase;
import util.AppLogger;

import java.util.List;

public class BaseRepository {
    protected AppStorage appStorage;
    protected AppDatabase appDatabase;
    protected AppLogger appLogger;
    protected Gson gson;
    @Autowired
    public BaseRepository() {
        this.appStorage = AppStorage.getInstance();
        this.appDatabase = new AppDatabase();
        this.appLogger = AppLogger.getInstance();
        this.gson = new Gson();
    }
}
