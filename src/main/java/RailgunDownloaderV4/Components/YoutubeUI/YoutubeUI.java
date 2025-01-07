package RailgunDownloaderV4.Components.YoutubeUI;
import RailgunDownloaderV4.Application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class YoutubeUI {
    private final JFrame ApplicationUI;
    public final Application AppContext;
    private final InputURL InputURLComponent;
    private final ShowPath ShowPathComponent;
    private final ChoosePath ChoosePathComponent;
    private final DownloadButton DownloadButtonComponent;
    private final Resultlog LogResultComponent;
    private final QualityList ListQuality;

    public final JTextField InputURLField;
    public  JTextField ShowPathField;
    private JButton ChoosePathButton;
    private JButton DownloadButton;
    public JTextArea LogResult;
    public JList<String> QualityListBox;

    public YoutubeUI(Application AppContext) {
        ApplicationUI = new JFrame();
        this.AppContext = AppContext;
        InputURLComponent = new InputURL();
        ShowPathComponent = new ShowPath();
        ChoosePathComponent = new ChoosePath(this);
        DownloadButtonComponent = new DownloadButton(this);
        InputURLField = new JTextField();
        ShowPathField = new JTextField();
        LogResultComponent = new Resultlog();
        ListQuality = new QualityList();
    }

    public void ShowYoutubeUI(boolean Visible) {
        ChoosePathButton = new JButton();
        DownloadButton = new JButton();
        LogResult = new JTextArea();
        QualityListBox = new JList<>();

        SwingUtilities.invokeLater(() -> {
            ApplicationUI.setTitle("Download from Youtube");
            ApplicationUI.setIconImage(
                    Objects.requireNonNull(
                            Toolkit.getDefaultToolkit().getImage(
                                    getClass().getResource("/AppIcon.jpg")
                            )
                    )
            );
            ApplicationUI.setSize(new Dimension(600, 650));
            ApplicationUI.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            ApplicationUI.setLocationRelativeTo(null);
            ApplicationUI.setLayout(null);
            ApplicationUI.setResizable(false);
            ApplicationUI.setMaximumSize(new Dimension(600, 650));
            ApplicationUI.getContentPane().setBackground(new Color(21, 21, 21));
            ApplicationUI.setVisible(Visible);

            InputURLComponent.SetInputURL(ApplicationUI, InputURLField);
            ShowPathComponent.SetShowPath(ApplicationUI, ShowPathField);
            ChoosePathComponent.SetChoosePath(ApplicationUI, ChoosePathButton);
            DownloadButtonComponent.SetDownloadButton(ApplicationUI, DownloadButton);
            LogResultComponent.SetResultlog(ApplicationUI, LogResult);
            ListQuality.SetQuality(ApplicationUI, QualityListBox);

            OnClosing();
        });
    }

    private  void OnClosing() {
        ApplicationUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                AppContext.App.setVisible(true);
            }
        });
    }
}
