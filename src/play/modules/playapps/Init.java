package play.modules.playapps;

import java.io.File;
import org.apache.log4j.PropertyConfigurator;
import play.Logger;
import play.Play;

public class Init {

    static {
        if(Play.id != null && Play.id.startsWith("playapps")) {
            File logs = Play.getFile("../logs");
            if (!logs.exists()) {
                logs.mkdir();
            }
            PropertyConfigurator.configure(Plugin.class.getResource("playappsLog4j.properties"));
            Logger.log4j = org.apache.log4j.Logger.getLogger("play");
        }
    }
}
