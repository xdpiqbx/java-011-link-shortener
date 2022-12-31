package cw.lnkshort.storage;

import java.io.File;

public class StorageConstants {
  //    public static final String CONNECTION_URL = "jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1"; // connection for tests
  //  public static final String CONNECTION_URL = "jdbc:h2:./short_link";
  public static String CONNECTION_URL;

  static{
    String homeDirectory = System.getenv().get("MAX_HOME");
    String dbFolderPath = homeDirectory + "\\.shortlink";
    new File(dbFolderPath).mkdirs();
    CONNECTION_URL = "jdbc:h2:" + dbFolderPath + "\\db";
    System.out.println("CONNECTION_URL = " + CONNECTION_URL);
  }
}
