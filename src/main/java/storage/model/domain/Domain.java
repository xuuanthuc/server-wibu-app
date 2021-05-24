package storage.model.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Domain {
	@SerializedName("url")
	@Expose
	public String url;
	@SerializedName("port")
	@Expose
	public Integer port;
}