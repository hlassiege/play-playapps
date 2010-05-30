package play.modules.playapps;

import play.Logger;
import play.Play;
import play.PlayPlugin;

public class Plugin extends PlayPlugin {

    @Override
    public void onLoad() {
        if ("playapps".equals(Play.id)) {
            Logger.info("Running on playapps.net");

            // Mode DEV forbidden
            if (Play.mode == Play.Mode.DEV) {
                Logger.error("You can't run an application in DEV mode on the playapps.net platform.\nAdd %playapps.application.mode=PROD to your application.conf file.");
                System.exit(-1);
            }
        }
    }

    @Override
    public void onConfigurationRead() {
        // Patch database
        if (Play.configuration.containsKey("db")) {
            Play.configuration.setProperty("db", "mysql:play:play@play");
        }
    }
}
