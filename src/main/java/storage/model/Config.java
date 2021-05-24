package storage.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import storage.model.database.ConfigDatabase;
import storage.model.domain.Domain;
import storage.model.setting.Setting;

public class Config {
    @SerializedName("domains")
    @Expose
    public Domain domain = null;
    @SerializedName("database")
    @Expose
    public ConfigDatabase database = null;
    @SerializedName("setting")
    @Expose
    public Setting setting;
    @SerializedName("logger")
    @Expose
    public Logger logger;
}