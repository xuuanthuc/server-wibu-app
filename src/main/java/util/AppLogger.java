package util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AppLogger {
	public enum Level {DEBUG, INFO, WARNING, ERROR}

	private interface Config {
		interface Default {
			String output = "%s/output/log";
		}

		interface Format {
			/**
			 * 1. Log level <br>
			 * 2. Time <br>
			 * 3. Package File<br>
			 * 4. Function <br>
			 * 5. Line of code <br>
			 * 6. Message
			 */
			String messenger = "[%5s] [%s] %s(%s-%s) : %s";
			String date = "yyyy-MM-dd HH:mm:ss";
			String file = "yyyyMMdd";
		}
	}

	public static class Setting {
		protected boolean isLog;
		protected boolean isLogFile;
		protected String output;
		protected Level level;

		public Setting(boolean isLog, boolean isLogFile, String level, String output) {
			this.isLog = isLog;
			this.isLogFile = isLogFile;
			this.level = Level.valueOf(level.toUpperCase(Locale.ROOT));
			if (this.level == null) this.level = Level.DEBUG;
			this.output = output;
		}

		public Setting(boolean isLog, boolean isLogFile, Level level, String output) {
			this.isLog = isLog;
			this.isLogFile = isLogFile;
			this.level = level;
			this.output = output;
		}
	}

	private static AppLogger instance = null;

	public static AppLogger getInstance() {
		if (instance == null)
			instance = new AppLogger();
		return instance;
	}

	private Setting setting;
	private Level level;
	private String directory;

	private AppLogger() {
		this.directory = System.getProperty("user.dir");
		this.setting = new Setting(
				true,
				false,
				Level.DEBUG,
				String.format(Config.Default.output, directory)
		);
	}

	public void setting(Setting setting) {
		this.setting = setting;
	}

	public void info(String msg) {
		print(Level.INFO, msg);
	}

	public void debug(String msg) {
		print(Level.DEBUG, msg);
	}

	public void warning(String msg) {
		print(Level.WARNING, msg);
	}

	public void error(String msg) {
		print(Level.ERROR, msg);
	}

	private void print(Level level, String msg) {
		if (setting.isLog) {
			long now = System.currentTimeMillis();
			String time = millisecondToDate(now, Config.Format.date);
			StackTraceElement element = new Throwable().getStackTrace()[2];
			String file = element.getClassName();
			String method = element.getMethodName();
			int line = element.getLineNumber();
			String string = String.format(Config.Format.messenger, level, time, file, method, line, msg);
			System.out.println(string);
			if (setting.isLogFile) {
				String name = millisecondToDate(now, Config.Format.file);
				try {
					FileUtils.write(
							new File(directory + setting.output + "/" + name),
							string + "\n",
							AppData.charset,
							true
					);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String millisecondToDate(long time, String format) {
		Date now = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(now);
	}
}
