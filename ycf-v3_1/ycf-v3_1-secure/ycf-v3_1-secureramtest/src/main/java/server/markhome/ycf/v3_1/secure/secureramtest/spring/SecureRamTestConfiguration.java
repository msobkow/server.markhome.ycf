
// Description: Java 25 Configuration of the RamTest application

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
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

package server.markhome.ycf.v3_1.secure.secureramtest.spring;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureram.*;
import server.markhome.ycf.v3_1.secure.secureramtest.SecureRamTest;

@Configuration
public class SecureRamTestConfiguration {
	
	@Bean(name = "appApplicationProperties")
	public Properties appApplicationProperties() {
		return( SecureRamTest.getApplicationProperties() );
	}
	
	@Bean(name = "appSystemProperties")
	public Properties appSystemProperties() {
		return( SecureRamTest.getSystemProperties() );
	}

	@Bean(name = "appUserDefaultProperties")
	public Properties appUserDefaultProperties() {
		return( SecureRamTest.getUserDefaultProperties() );
	}
	
	@Bean(name = "appUserProperties")
	public Properties appUserProperties() {
		return( SecureRamTest.getUserProperties() );
	}
	
	@Bean(name = "appMergedProperties")
	public Properties appMergedProperties() {
		return( SecureRamTest.getMergedProperties() );
	}
}
