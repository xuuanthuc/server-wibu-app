package storage.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Logger {
	@SerializedName("isLog")
	@Expose
	public Boolean isLog;
	@SerializedName("isFile")
	@Expose
	public Boolean isFile;
	@SerializedName("level")
	@Expose
	public String level;
	@SerializedName("directory")
	@Expose
	public String directory;
}