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

import java.util.*;

import java.io.*;
import java.util.*;

/**
 *	Implement the OmfMessageLogInterface over a Log4J Logger.
 */
public class YCFConsoleMessageLog
implements IYCFMessageLog {

	/**
	 *	Handle for the current file output stream.
	 */
	private PrintStream	logFile = null;

	/**
	 *	What is the current indent level for logging?
	 */
	private int		   	indent = 0;
	
	/**
	 *	Default constructor.
	 */
	public YCFConsoleMessageLog() {
		indent = 0;
	}
	
	/**
	 *	Get the current log indent level.
	 */
	public int getMessageLogIndent() {
		return( indent );
	}
	
	/**
	 *	Indent the logging messages another level
	 */
	public synchronized void dedent() {
		if( indent > 0 ) {
			indent --;
		}
		else {
			indent = 0;
		}
	}
	
	/**
	 *	Indent the logging messages another level
	 */
	public synchronized void indent() {
		indent ++;
	}

	/**
	 *	Get an PrintStream that wraps this log
	 */
	public PrintStream getPrintStream() {
		return( logFile );
	}
	
	/**
	 *	Log a message
	 *
	 *	@param		msg		String
	 */
	public synchronized void message( String msg ) {

		if( msg == null ) {
			return;
		}

		StringBuilder buff = new StringBuilder();

		Calendar cal = Calendar.getInstance();
		String stamp = String.format( "%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS.%1$tL ", cal );
		buff.append( stamp );

		int			i;
		for( i = 0; i < indent; i ++ ) {
			buff.append( "\t" );
		}
		buff.append( msg );
		if( ! msg.endsWith( "\n" ) ) {
			buff.append( "\n" );
		}

		boolean wroteSomewhere = false;

		if( logFile != null ) {
			logFile.append( buff.toString() );
			logFile.flush();
		}

		if( ! wroteSomewhere ) {
			System.out.append( buff.toString() );
			System.out.flush();
		}
	}

//	OLD API's that need to go away

	/**
	 *	Open the specified file for logging
	 *
	 *	@param	fileName	The name of the file to open as a log.
	 */
	public void openLogFile( String fileName )
		throws FileNotFoundException
	{
		assert ( fileName != null ) && ( fileName.length() > 0 ) : "File name must be specified";
		assert logFile == null : "Log file is already open";
		logFile = new PrintStream( fileName );
	}
	
	/**
	 *	Close the log file.
	 */
	public void closeLogFile() {
		if( logFile != null ) {
			PrintStream old = logFile;
			logFile = null;
			
			old.flush();
			old.close();
		}
	}

}
