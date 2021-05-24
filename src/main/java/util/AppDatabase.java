package util;

import org.jsoup.internal.StringUtil;
import storage.AppStorage;
import storage.model.database.ConfigDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class AppDatabase {
	private Connection connection;
	private AppLogger appLogger;
	private AppStorage appStorage;

	public AppDatabase() {
		appStorage = AppStorage.getInstance();
		appLogger = AppLogger.getInstance();

	}

	public void connect( Callback callback ) {
		try {
			Class.forName(AppData.Database.MySQL.driver);
			ConfigDatabase configDatabase = appStorage.config.database;
			if (configDatabase == null) return;
			String connectString = String.format(
					AppData.Database.MySQL.url ,
					configDatabase.domain + ":" + configDatabase.port ,
					configDatabase.schema ,
					configDatabase.user ,
					configDatabase.pass
			);
			connection = DriverManager.getConnection(connectString);
			callback.execute(connection);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public String getInsertQuery( String[] columns , List<String> primaryKeys , String table ) {
		if (StringUtil.isBlank(table)) {
			appLogger.info("null table name");
		}
		StringBuilder columnName = new StringBuilder();
		StringBuilder markValue = new StringBuilder();
		StringBuilder update = new StringBuilder();

		for (int i = 0; i < columns.length; i++) {
			String column = columns[i];
			columnName.append(String.format("%s, " , column));
			markValue.append("?, ");
			if (!primaryKeys.contains(column)) {
				update.append(String.format("%s = VALUES(%s), " , column , column));
			}
		}

		String sql = String.format(
				"INSERT INTO %s (%s) VALUES (%s) ON DUPLICATE KEY UPDATE %s" ,
				table ,
				columnName.substring(0 , columnName.length() - 2) ,
				markValue.substring(0 , markValue.length() - 2) ,
				update.substring(0 , update.length() - 2)
		);

		return sql;
	}

	private void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public interface Callback {
		void execute( Connection connect );
	}
}