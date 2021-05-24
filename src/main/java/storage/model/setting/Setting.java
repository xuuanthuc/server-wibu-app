package storage.model.setting;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Setting {
	@SerializedName("timeCheck")
	@Expose
	public Integer timeCheck;
}