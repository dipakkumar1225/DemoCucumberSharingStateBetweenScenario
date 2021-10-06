package utilities.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "file:./config/androidApk.properties",
        "file:./config/generic.properties",
        "file:./config/devices/device1.properties",
})
public interface Configuration extends Config {

    @Key("app.testData.path")
    String filePathTestData();

    @Key("app.android.app.noReset")
    Boolean noReset();

    @Key("app.android.path")
    String androidAppPath();

    @Key("app.android.appPackage")
    String androidAppPackage();

    @Key("app.android.appActivity")
    String androidAppActivity();

    @Key("app.android.platformNameAndVersion")
    String androidPlatformAndVersion();

    @Key("app.android.udid")
    String androidDeviceUDID();

    @Key("app.android.systemPort")
    String androidSystemPort();
}
