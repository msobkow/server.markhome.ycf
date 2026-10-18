// Description: Java 25 XML SAX Parser for IntNet.

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

package server.markhome.ycf.v3_1.intnet.intnetsaxramldr;

import org.apache.log4j.*;
import server.markhome.ycf.*;
import server.markhome.ycf.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;

import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.intnet.IntNetRam.*;
import server.markhome.ycf.v3_1.intnet.IntNetSaxLoader.*;

public class IntNetSaxRamLdr
	extends IntNetSaxLdr
{
	private static IYCFLibMessageLog log = new YCFLibConsoleMessageLog();

	// Constructors

	public IntNetSaxRamLdr() {
		super( log );
	}

	// main() entry point

	public static void main( String args[] ) {
		final String S_ProcName = "IntNetSaxRamLdr.main() ";
		initConsoleLog();
		int numArgs = args.length;
		if( numArgs >= 2 ) {
			IIntNetSchema intNetSchema = new IntNetRamSchema();
			IIntNetSchemaObj intNetSchemaObj = new IntNetSchemaObj();
			intNetSchemaObj.setBackingStore( intNetSchema );
			IntNetSaxLdr cli = new IntNetSaxRamLdr();
			IntNetSaxLoader loader = cli.getSaxLoader();
			loader.setSchemaObj( intNetSchemaObj );
			String url = args[1];
			try {
				intNetSchema.connect( "system", "system", "system", "system" );
				intNetSchema.rollback();
				intNetSchema.beginTransaction();
				intNetSchemaObj.setSecCluster( intNetSchemaObj.getClusterTableObj().getSystemCluster() );
				intNetSchemaObj.setSecTenant( intNetSchemaObj.getTenantTableObj().getSystemTenant() );
				intNetSchemaObj.setSecSession( intNetSchemaObj.getSecSessionTableObj().getSystemSession() );
				SecureAuthorization auth = new SecureAuthorization();
				auth.setSecCluster( intNetSchemaObj.getSecCluster() );
				auth.setSecTenant( intNetSchemaObj.getSecTenant() );
				auth.setSecSession( intNetSchemaObj.getSecSession() );
				intNetSchemaObj.setAuthorization( auth );
				loader.setUseCluster( intNetSchemaObj.getSecCluster() );
				loader.setUseTenant( intNetSchemaObj.getSecTenant() );
				applyLoaderOptions( loader, args[0] );
				cli.evaluateRemainingArgs( args, 2 );
				loader.parseFile( url );
				intNetSchema.commit();
				intNetSchema.disconnect( true );
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
				if( intNetSchema.isConnected() ) {
					intNetSchema.rollback();
					intNetSchema.disconnect( false );
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
			log.message( "IntNetSaxRamLdr.evaluateRemainingArgs() WARNING No extra arguments are expected for a RAM database instance, but "
				+ Integer.toString( args.length - consumed )
				+ " extra arguments were specified.  Extra arguments ignored." );
		}
	}

}
