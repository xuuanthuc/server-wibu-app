package storage.model.database;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConfigDatabaseTable {
	@SerializedName("blog")
	@Expose
	public String blog;
	@SerializedName("item")
	@Expose
	public String item;
	@SerializedName("category")
	@Expose
	public String category;
}