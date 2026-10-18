// Description: Java 25 JavaFX package hook for Secure.

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

package server.markhome.ycf.v3_1.secure.securejavafx;

import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.InzPathEntry;
import server.markhome.ycf.javafx.*;

/**
 *	The SecureJavaFX package hook is used to initialize the Inz path search among other things.
 */
public class SecureJavaFX
{
	protected static boolean initialized = false;
		
	public static void init() {
		if (initialized) {
			return;
		}
		YCFJavaFX.init();
		initialized = true;
        
		InzPathEntry entry = new InzPathEntry(SecureJavaFX.class, "resource:/inz/langs/");
		Inz.addPathEntry(entry);
	}
}
