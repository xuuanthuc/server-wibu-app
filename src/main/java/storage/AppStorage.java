package storage;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import storage.model.Config;
import util.AppData;
import util.AppLogger;

import java.io.File;
import java.io.IOException;

public class AppStorage {
	private static AppStorage single_instance = null;

	public static AppStorage getInstance() {
		if (single_instance == null)
			single_instance = new AppStorage();

		return single_instance;
	}

	public String jarPath;
	public Config config;
	private AppLogger appLogger;

	private AppStorage() {
		appLogger = AppLogger.getInstance();
	}

	public void loadConfig( Gson gson ) {
		try {
			appLogger.info("Loading current directory");
			jarPath = System.getProperty("user.dir");
			String dir = AppStorage.getInstance().jarPath;

			appLogger.info("Loading config file");
			File file = new File(dir + AppData.Config.Input.configFile);
			String string = FileUtils.readFileToString(file , AppData.charset);
			config = gson.fromJson(string , Config.class);
			config.setting.timeCheck = config.setting.timeCheck * 60 * 1000;
			appLogger.debug(gson.toJson(config));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
