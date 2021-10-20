package com.cloud.sunnbird.common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.net.URL;


public class AppiumResource {
    private AppiumDriver<AndroidElement> appiumDriver;

    /**
     * 获取Appium 驱动
     *
     * @return Appium驱动
     */
    public AppiumDriver getAppiumDriver() {
        /* 设置初始化相关参数 */
        DesiredCapabilities capabilities = new DesiredCapabilities();
        setCapabilities("deviceName", "A10s", capabilities);
        setCapabilities("platformName", "Android", capabilities);
        setCapabilities("platformVersion", "9", capabilities);
        setCapabilities("appPackage", "com.cloud.sunnbird", capabilities);
        setCapabilities("appActivity", ".ui.activity.SplashActivity", capabilities);



        try {
            appiumDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (Exception e){
            System.out.println("无法启动Appium");
        }

        return appiumDriver;
    }


    /**
     * 设置配置属性
     *
     * @param name         属性名称
     * @param value        属性值
     * @param capabilities 配置容器
     */
    protected void setCapabilities(String name, String value, DesiredCapabilities capabilities) {
        if (null == value) {
            return;
        }

        capabilities.setCapability(name, value);
    }



    //    /**
//     * 系统关闭的时候关闭Appium连接
//     */
//    public void stopAppiumServer() {
//        if (!appiumAutotestProperties.isAppiumServerMngEnable()) {
//            return;
//        }
//
//        Properties deviceConfig = appiumAutotestProperties.getDeviceConfig();
//        String deviceIp = deviceConfig.getProperty("ip");
//        String devicePort = deviceConfig.getProperty("port");
//        String url = String.format("%s/appium/servers", appiumServerMngUrl);
//        UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromUriString(url).queryParam("deviceIp", deviceIp);
//        if (StringUtils.isNotBlank(devicePort)) {
//            urlBuilder.queryParam("devicePort", devicePort);
//        }
//
//        URI deleteUrl = urlBuilder.build().toUri();
//
//        try {
//            restTemplate.delete(deleteUrl);
//        } catch (Exception e) {
//            return;
//        }
//    }


}
