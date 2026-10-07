/**
 *	server.markhome.ycf-core - Mark's Code Fractal Core Services
 *
 *	Copyright 2026 Mark Stephen Sobkow (mark.sobkow@gmail.com)
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *		http://apache.org
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *
 *	SPDX-License-Identifier: Apache-2.0
**/

package server.markhome.ycf;

import org.teavm.jso.JSExport;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

import java.io.*;

public class YCFCachedMessageLog
implements IYCFMessageLog {

	private StringBuilder cacheContents = new StringBuilder();
	private int		   	indent = 0;
	
	/**
	 *	Default constructor.
	 */
	public YCFCachedMessageLog() {
		indent = 0;
	}

	public void clearCache() {
		cacheContents.setLength( 0 );
	}

	public String getCacheContents() {
		return( cacheContents.toString() );
	}
	
	public int getMessageLogIndent() {
		return( indent );
	}
	
	public synchronized void dedent() {
		if( indent > 0 ) {
			indent --;
		}
		else {
			indent = 0;
		}
	}
	
	public synchronized void indent() {
		indent ++;
	}
	
	public synchronized void message( String msg ) {

		if( msg == null ) {
			return;
		}

		int			i;
		for( i = ( ( cacheContents.length() <= 0 ) ? 1 : 0 ); i < indent; i ++ ) {
			cacheContents.append( "\t" );
		}
		cacheContents.append( msg );
		if( ! msg.endsWith( "\n" ) ) {
			cacheContents.append( "\n" );
		}
	}

//	OLD API's that need to go away

	public PrintStream getPrintStream() {
		return( null );
	}

	public void openLogFile( String fileName )
		throws FileNotFoundException
	{
		// Do-nothing stub; cached message logs don't write to files
	}
	
	public void closeLogFile() {
		// Do-nothing stub; cached message logs don't write to files
	}
}
