package railgunDownloaderV4.components.ulti;

public class CheckOS {
    public String SysType() {
        String OS_Property = System.getProperty("os.name").toLowerCase();

        if(OS_Property.contains("win")) {
            return "Windows";
        } else if (OS_Property.contains("nix") || OS_Property.contains("nux") || OS_Property.contains("aix")) {
            return "Linux";
        }

        return "UnknownOS";
    }
}
