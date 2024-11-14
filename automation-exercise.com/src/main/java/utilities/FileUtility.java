package utilities;

import java.io.File;

public class FileUtility extends Utility{

    static String downloadPath = "/Users/suleymankayir/Documents/TestDownload";

    public static boolean isFileDownloaded(String fileName, int timeoutInSeconds) {
        File dir = new File(downloadPath);
        File[] dirContents;

        int waited = 0;
        while (waited < timeoutInSeconds) {
            dirContents = dir.listFiles();
            if (dirContents != null) {
                for (File file : dirContents) {
                    if (file.getName().contains(fileName)) {
                        return true;
                    }
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            waited++;
        }
        return false;
    }
}
