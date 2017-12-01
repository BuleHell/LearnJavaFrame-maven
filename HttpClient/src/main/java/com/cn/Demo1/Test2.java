package com.cn.Demo1;

import java.security.Provider;
import java.security.Security;

/**
 * Created by guabutian on 2017/11/30.
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            System.out.println("Java version: " + System.getProperty("java.version"));
            System.out.println("Java vendor: " + System.getProperty("java.vendor"));
            System.out.println("Java class path: " + System.getProperty("java.class.path"));
            System.out.println("Operating system name: " + System.getProperty("os.name"));
            System.out.println("Operating system architecture: " + System.getProperty("os.arch"));
            System.out.println("Operating system version: " + System.getProperty("os.version"));

            //显示所有的安装者提供的信息
            Provider[] providers = Security.getProviders();
            for (int i = 0; i < providers.length; i++) {
                Provider provider = providers[i];
                System.out.println(provider.getName() + " " + provider.getVersion()
                        + ": " + provider.getInfo());
            }
        } catch (SecurityException ignore) {
        }

    }
}
