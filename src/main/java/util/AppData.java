package util;

public interface AppData {
    String charset = "utf-8";
    int threadDefault = 5;

    interface Config {
        String root = "/asset";
        interface Input {
            String dir = root + "/input";
            String configFile = dir + "/config.json";
        }

        interface Output {
            String dir = root + "/output";
        }
    }

    interface Database {
        interface MySQL {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://%s/%s?user=%s&password=%s";
        }
    }
}
