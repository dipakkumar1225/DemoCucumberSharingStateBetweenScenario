package utilities.platform;

import utilities.enums.DeviceTypeEnum;
import utilities.platform.android.AndroidDevice;

public class DriverFactory {

    public static DriverManager getMobileDriverManager(DeviceTypeEnum mobilePlatform){
        DriverManager mobileDriverManager = null;
        if (mobilePlatform == DeviceTypeEnum.ANDROID) {
            mobileDriverManager = new AndroidDevice();
        } else {
            System.out.println("Provided platform \"" + mobilePlatform + "\" is not supported....");
        }
        return mobileDriverManager;
    }
}
