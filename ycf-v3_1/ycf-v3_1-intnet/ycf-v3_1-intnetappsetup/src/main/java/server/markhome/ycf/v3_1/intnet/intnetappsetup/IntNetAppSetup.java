
// Description: Java 25 Main for testing the IntNet schema database creation

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.intnet.intnetappsetup;

import java.lang.reflect.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import javafx.application.Application;

import ch.qos.logback.classic.LoggerContext;

import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;

import server.markhome.ycf.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.InzPathEntry;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secure.buff.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnet.buff.*;
import server.markhome.ycf.v3_1.intnet.intnetappsetup.fx.IntNetAppSetupFxApplication;

@SpringBootApplication
@ComponentScan(basePackages = {
    "server.markhome.ycf.v3_1.intnet.intnetappsetup.fx",   // if you have service beans here
    "server.markhome.ycf.v3_1.intnet.intnetappsetup.spring"   // if you have service beans here
})
@EnableAutoConfiguration(exclude = {
})
public class IntNetAppSetup
{
    private static final AtomicReference<Properties> systemProperties = new AtomicReference<>(null);
    private static final AtomicReference<Properties> applicationProperties = new AtomicReference<>(null);
    private static final AtomicReference<Properties> userDefaultProperties = new AtomicReference<>(null);
    private static final AtomicReference<Properties> userProperties = new AtomicReference<>(null);
    private static final AtomicReference<Properties> mergedProperties = new AtomicReference<>(null);

	public static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(server.markhome.ycf.v3_1.intnet.intnetappsetup.IntNetAppSetup.class.getName());
	public static LoggerContext loggerContext = (LoggerContext) org.slf4j.LoggerFactory.getILoggerFactory();
	public static String startingupMessage = IntNetAppSetup.class.getName() + " starting.";

    /**
     * Loads the application properties file from the application resources.
     */
    public static Properties getApplicationProperties() {
        if (applicationProperties.get() == null) {
            Properties props = new Properties();
            try (var in = IntNetAppSetup.class.getClassLoader().getResourceAsStream("application.properties")) {
                if (in != null) {
                    props.load(in);
                } else {
                    throw new RuntimeException(Inz.x("intnetappsetup.ApplicationPropertiesNotFound"));
                }
            } catch (IOException e) {
                throw new RuntimeException(Inz.x("intnetappsetup.CouldNotLoadApplicationProperties"), e);
            }
            applicationProperties.compareAndSet(null, props);
        }
        return applicationProperties.get();
    }

    /**
     * Loads the system properties, which hopefully haven't had the merge applied yet.
     */
    public static Properties getSystemProperties() {
        if (systemProperties.get() == null) {
            Properties props = new Properties();
            props.putAll(System.getProperties());
            systemProperties.compareAndSet(null, props);
        }
        return systemProperties.get();
    }
  
    /**
     * Loads the user default properties file from the application resources.
     */
    public static Properties getUserDefaultProperties() {
        if (userDefaultProperties.get() == null) {
            Properties props = new Properties();
            try (var in = IntNetAppSetup.class.getClassLoader().getResourceAsStream("user-default.properties")) {
                if (in != null) {
                    props.load(in);
                } else {
                    throw new RuntimeException(Inz.x("intnetappsetup.UserDefaultPropertiesNotFound"));
                }
            } catch (IOException e) {
                throw new RuntimeException(Inz.x("intnetappsetup.FailedToLoadUserDefaultProperties"), e);
            }
            userDefaultProperties.compareAndSet(null, props);
        }
        return userDefaultProperties.get();
    }

    /**
     * Make sure the user properties file doesn't exist yet
     */
    public static Properties getUserProperties() {
        if (userProperties.get() == null) {
            Properties props = new Properties();
            File userFile = new File(System.getProperty("user.home"), ".intnetappsrv.properties");
            if (userFile.exists()) {
				throw new YCFUsageException(IntNetAppSetup.class,
					"getUserProperties",
					String.format("%1$s already exists - application initialization previously completed", userFile.getPath ( ) ), String.format ( "%1$s already exists - application initialization previously completed", userFile.getPath()));
                
			}
			userProperties.compareAndSet(null, props);
        }
        return userProperties.get();
    }

    /**
     * Merges the System and User properties, giving preference to the User properties.
     */
    public static Properties getMergedProperties() {
        if (mergedProperties.get() == null) {
            Properties merged = new Properties();
            merged.putAll(getApplicationProperties());
            merged.putAll(getUserDefaultProperties());
            merged.putAll(getSystemProperties());
            merged.putAll(getUserProperties());
            mergedProperties.compareAndSet(null, merged);
        }
        return mergedProperties.get();
    }

    public static void main(String[] args) {
        Inz.addPathEntry(new InzPathEntry("/opt/ycf/v3_1/java" + "/server.markhome.ycf.v3_1.intnet.intnetappsetup/src/main/resources/" + "/server.markhome.ycf.v3_1.intnet.intnetappsetup".replace(".","/") + "/langs"));

        // This weird looking cadence ensures that all the sub-property lists are prepared before getMergedProperties() is invoked, ensuring that any errors and exceptions along the way are thrown first and in predictable order
        Properties mergedProperties = getApplicationProperties();
        mergedProperties = getUserDefaultProperties();
        mergedProperties = getSystemProperties();
        mergedProperties = getUserProperties();
        mergedProperties = getMergedProperties();
        System.getProperties().putAll(mergedProperties);

        SpringApplication app = new SpringApplication(IntNetAppSetup.class);
        app.addInitializers((applicationContext) -> {
            ConfigurableEnvironment env = applicationContext.getEnvironment();
            env.getPropertySources().addLast(new org.springframework.core.env.PropertiesPropertySource("userProperties", userProperties.get()));
        });
		int finalvalue = 0xf00000;
		SecureBuffSchema buffSecure = new SecureBuffSchema();
		finalvalue = buffSecure.initClassMapEntries(finalvalue);
		buffSecure.setSecureSchema(buffSecure);
		IntNetBuffSchema buffIntNet = new IntNetBuffSchema();
		finalvalue = buffIntNet.initClassMapEntries(finalvalue);
		buffIntNet.setIntNetSchema(buffIntNet);
		logStartupInfo(args);
		logger.info("Runtime class codes are " + 0xf00000 + ".." + (finalvalue-1) + " (" + (finalvalue-0xf00000-1) + " tables in total)");
        Application.launch(IntNetAppSetupFxApplication.class, args);
    }

	public static void logStartupInfo(String[] args) {
		logger.info(startingupMessage);
		String argsString = "";
		if (args != null && args.length > 0) {
			StringBuilder sb = new StringBuilder(argsString);
			for (int i = 0; i < args.length; i++) {
				sb.append("arg ").append(i).append(" = >>>").append(args[i]).append("<<<");
			}
			argsString = sb.toString();
		}
		String message = "Spring boot Application args >>>" + argsString + "<<<";
		logger.info("The IntNet Application Setup is starting with args >>>{}<<<", message);
		String currentDirectory = new File(".").getAbsolutePath();
		message = "Application current Directory is: >>>" + currentDirectory + "<<<";
		logger.info(message);
	}

}


