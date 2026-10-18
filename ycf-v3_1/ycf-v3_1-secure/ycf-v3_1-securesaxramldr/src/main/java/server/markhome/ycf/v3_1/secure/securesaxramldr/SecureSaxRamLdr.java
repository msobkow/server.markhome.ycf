// Description: Java 25 XML SAX Parser for Secure.

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

package server.markhome.ycf.v3_1.secure.securesaxramldr;

import org.apache.log4j.*;
import server.markhome.ycf.*;
import server.markhome.ycf.*;
import server.markhome.ycf.v3_1.secure.secure.*;

import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.secure.SecureRam.*;
import server.markhome.ycf.v3_1.secure.SecureSaxLoader.*;

public class SecureSaxRamLdr
	extends SecureSaxLdr
{
	private static IYCFLibMessageLog log = new YCFLibConsoleMessageLog();

	// Constructors

	public SecureSaxRamLdr() {
		super( log );
	}

	// main() entry point

	public static void main( String args[] ) {
		final String S_ProcName = "SecureSaxRamLdr.main() ";
		initConsoleLog();
		int numArgs = args.length;
		if( numArgs >= 2 ) {
			ISecureSchema secureSchema = new SecureRamSchema();
			ISecureSchemaObj secureSchemaObj = new SecureSchemaObj();
			secureSchemaObj.setBackingStore( secureSchema );
			SecureSaxLdr cli = new SecureSaxRamLdr();
			SecureSaxLoader loader = cli.getSaxLoader();
			loader.setSchemaObj( secureSchemaObj );
			String url = args[1];
			try {
				secureSchema.connect( "system", "system", "system", "system" );
				secureSchema.rollback();
				secureSchema.beginTransaction();
				secureSchemaObj.setSecCluster( secureSchemaObj.getClusterTableObj().getSystemCluster() );
				secureSchemaObj.setSecTenant( secureSchemaObj.getTenantTableObj().getSystemTenant() );
				secureSchemaObj.setSecSession( secureSchemaObj.getSecSessionTableObj().getSystemSession() );
				SecureAuthorization auth = new SecureAuthorization();
				auth.setSecCluster( secureSchemaObj.getSecCluster() );
				auth.setSecTenant( secureSchemaObj.getSecTenant() );
				auth.setSecSession( secureSchemaObj.getSecSession() );
				secureSchemaObj.setAuthorization( auth );
				loader.setUseCluster( secureSchemaObj.getSecCluster() );
				loader.setUseTenant( secureSchemaObj.getSecTenant() );
				applyLoaderOptions( loader, args[0] );
				cli.evaluateRemainingArgs( args, 2 );
				loader.parseFile( url );
				secureSchema.commit();
				secureSchema.disconnect( true );
			}
			catch( Exception e ) {
				log.message( S_ProcName + "EXCEPTION: Could not parse XML file \"" + url + "\": " + e.getMessage() );
				e.printStackTrace( System.out );
			}
			catch( Error e ) {
				log.message( S_ProcName + "ERROR: Could not parse XML file \"" + url + "\": " + e.getMessage() );
				e.printStackTrace( System.out );
			}
			finally {
				if( secureSchema.isConnected() ) {
					secureSchema.rollback();
					secureSchema.disconnect( false );
				}
			}
		}
		else {
			log.message( S_ProcName + "ERROR: Expected at least two argument specifying the loader options and the name of the XML file to parse.  The first argument may be empty." );
		}
	}

	// Initialize the console log

	protected static void initConsoleLog() {
//		Layout layout = new PatternLayout(
//				"%d{ISO8601}"		// Start with a timestamp
//			+	" %-5p"				// Include the severity
//			+	" %C.%M"			// pkg.class.method()
//			+	" %F[%L]"			// File[lineNumber]
//			+	": %m\n" );			// Message text
//		BasicConfigurator.configure( new ConsoleAppender( layout, "System.out" ) );
	}

	// Evaluate remaining arguments

	public void evaluateRemainingArgs( String[] args, int consumed ) {
		// There are no extra arguments for the RAM "database" instance
		if( args.length > consumed ) {
			log.message( "SecureSaxRamLdr.evaluateRemainingArgs() WARNING No extra arguments are expected for a RAM database instance, but "
				+ Integer.toString( args.length - consumed )
				+ " extra arguments were specified.  Extra arguments ignored." );
		}
	}

}
