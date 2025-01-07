package RailgunDownloaderV4.Components.YoutubeUI.Helper;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class DownloadHelper {

    public void StartDownload(JTextArea LogResult, String VideoURL, String VideoQuality, String SavePath) {
        String RelativePath = "bin/YoutubeHelper/Youtube.lib";

        File YoutubeDownloadFile = new File(RelativePath);
        String AbsolutePath = YoutubeDownloadFile.getAbsolutePath();

        ProcessBuilder ProcessBuild = new ProcessBuilder(
                AbsolutePath,
                "--u", VideoURL,
                "--q", VideoQuality,
                "--p", SavePath
        );

        Thread LogThread = new Thread(() -> {
            try {
                Process HelperProcess = ProcessBuild.start();
                BufferedReader Stdout = new BufferedReader(
                        new InputStreamReader(HelperProcess.getInputStream())
                );

                StringBuilder LogBuilder = new StringBuilder();
                String ResultLine;

                while ((ResultLine = Stdout.readLine()) != null) {
                    LogBuilder.append(ResultLine).append("\n");
                    SwingUtilities.invokeLater(() -> LogResult.setText(LogBuilder + "\n"));
                }

            } catch (Exception error) {
                System.out.println("" + error);
            }
        });
        LogThread.start();
    }
}
