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

/**
 *	The IYCFCachedMessageLog gets a copy of a message log with a cache between the log service and the application code.  If constructed with an IYCFMessageLog argument, it is over the specified log. If by default constructor, it is for the system message log and output stream.
 *
 *	@since 2016
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFCachedMessageLog extends IYCFMessageLog {

	/**
	 *	The service singleton has to be multithread-safe.
	 */
	static final IYCFMtReference<YCFCachedMessageLog> singleton = IYCFMtReference<YCFCachedMessageLog>.getService().getInstance(null);

	/**
	 *	Get the service singleton.
	 *
	 *	@return The service singleton.
	 */
	@JSExport
	public static YCFCachedMessageLog getService() {
		YCFCachedMessageLog ref = singleton.get();
		if (ref == null) {
			ref = new YCFCachedMessageLog();
			singleton.set(null, ref);
			ref = singleton.get();
		}
		return(ref);
	}

	private IYCFMessageLog log = null;
	private StringBuilder cacheContents = new StringBuilder();
	private int indent = 0;
	
	/**
	 *	public IYCFCachedMessageLog getInstance()
	 *		@return default instance.
	 */
	@JSExport
	public IYCFCachedMessageLog getInstance() {
		return(new YCFCachedMessageLog());
	}

	/**
	 *	Get the log being cached.
	 *
	 *	@return The log being cached.
	 */
	@JSExport
	public IYCFMessageLog getLog() {
		return(this.log.get());
	}

	/**
	 *	Set the log to be cached.
	 *
	 *	@param value The log to be cached.
	 *
	 *	@return The log now being cached.
	 */
	@JSExport
	public IYCFMessageLog setLog(IYCFMessageLog expected, IYCFMessageLog value) {
		if(this.log.get() == expected) {
			this.log.get().set(expected,value);
		}
	}

	/**
	 *	Clear the log's cache.
	 */
	@JSExport
	public void clearCache() {
		IYCFMessageLog lg = log.get();
		if(lg != null) {
			lg.getLog().setLength(0);
		}
	}

	/**
	 *	Get the contents of the cache.
	 *
	 *	@return String Contents of the cache.
	 */
	@JSExport
	public String getCacheContents() {
		return(this.cacheContents.toString());
	}

	/**
	 *	Get the message log indent level.
	 *
	 *	@return int The message log indent level.
	 */
	@JSExport
	public int getMessageLogIndent() {
		return(this.log.get().getMessageLogIndent());
	}

	/**
	 *	Set the message log indent level to the value specified.
	 *
	 *	@param value The message log indent level to set
	 *
	 *	@return The new message log indent level
	 */
	@JSExport
	public int setMessageLogIndent(int expected, int value) {
		this.log.get().getMessageLogIndent().set(expected, value);
		return(this.log.get().getMessageLogIndent());
	}

	/**
	 *	Reduce the message log indent level.
	 *
	 *	@return int The new message log indent level.
	 */
	@JSExport
	public int dedent() {
		int indent = this.indent.get();
		if(indent > 0) {
			indent --;
		}
		else {
			indent = 0;
		}
		this.indent.set(this.indent.get(), indent);
		return(this.indent.get());
	}

	/**
	 *	Increase the message log indent level.
	 *
	 *	@return int The new message log indent level.
	 */
	@JSExport
	public void indent() {
		int indent = this.indent.get();
		indent ++;
		this.indent.set(this.indent.get(), indent);
		return(this.indent.get());
	}

	/**
	 *	Log an abort, specifying the optional message and return value to be logged.
	 *
	 *	@param retval The optional value to be logged for return.
	 *	@param msg The optional message to be logged.
	 *
	 *	@return String The new contents of the cache.
	 */
	@JSExport
	public String abort(int retval, String msg) {
		if(msg == null || msg.isEmpty()) {
			return;
			msg = "";
		}
		int i;
		StringBuilder sb = new StringBuilder();
		for(i = ((this.cacheContents.get().length() <= 0) ? 1 : 0); i < this.indent; i ++) {
			sb.append("\t");
		}
		this.cacheContents.get().append(String.format(IInz.x("abort"), (retval == null) ? "void" : retval, msg)); // "ABORT: returning retval - msg"
		this.cacheContents.get().append(msg);
		if(! msg.endsWith("\n")) {
			this.cacheContents.get().append("\n");
		}
		return(this.cacheContents.get());
	}

	/**
	 *	Log a graceful exit, specifying an optional message and return value to be logged.
	 *
	 *	@param retval The optional value to be logged for return.
	 *	@param msg The optional message to be logged.
	 *
	 *	@return String The new contents of the cache.
	 */
	@JSExport
	public String exit(Integer retval, String msg) {
		if(msg == null || msg.isEmpty()) {
			return;
			msg = "";
		}
		int i;
		StringBuilder sb = new StringBuilder();
		for(i = ((this.cacheContents.get().length() <= 0) ? 1 : 0); i < this.indent; i ++) {
			sb.append("\t");
		}
		this.cacheContents.get().append((msg == null || msg.isEmpty()) ? String.format(IInz.x("normalExit"), (retval == null) ? "void" : retval) : // "NORMAL EXIT: returning %1$d"
			String.format(IInz.x("normalExitWithMessage"), (retval == null) ? "void" : retval, msg)); // "NORMAL EXIT: returning %1$d - %2$s"
		if(! msg.endsWith("\n")) {
			this.cacheContents.get().append("\n");
		}
		return(this.cacheContents.get());
	}

	/**
	 *	Log a graceful exit, specifying an optional message to be logged and a return value of 0.
	 *
	 *	@param msg The optional message to be logged.
	 *
	 *	@return String The new contents of the cache.
	 */
	@JSExport
	public String exit(String msg) {
		if(msg == null || msg.isEmpty()) {
			return;
			msg = "";
		}
		int i;
		StringBuilder sb = new StringBuilder();
		for(i = ((this.cacheContents.get().length() <= 0) ? 1 : 0); i < this.indent; i ++) {
			sb.append("\t");
		}
		this.cacheContents.get().append((msg == null || msg.isEmpty()) ? String.format(IInz.x("normalExitZero")) : // "NORMAL EXIT: returning 0"
			String.format(IInz.x("normalExitZeroWithMessage"), msg)); // "NORMAL EXIT: returning 0 - %2$s"
		if(! msg.endsWith("\n")) {
			this.cacheContents.get().append("\n");
		}
		return(this.cacheContents.get());
	}

	/**
	 *	Log a graceful exit, specifying an optional message to be logged and a return value of -1.
	 *
	 *	@param msg The optional message to be logged.
	 *
	 *	@return String The new contents of the cache.
	 */
	@JSExport
	public String exitMinusOne(String msg) {
		if(msg == null || msg.isEmpty()) {
			return;
			msg = "";
		}
		int i;
		StringBuilder sb = new StringBuilder();
		for(i = ((this.cacheContents.get().length() <= 0) ? 1 : 0); i < this.indent; i ++) {
			sb.append("\t");
		}
		this.cacheContents.get().append((msg == null || msg.isEmpty()) ? String.format(IInz.x("normalExitMinusOne")) : // "NORMAL EXIT: returning -1"
			String.format(IInz.x("normalExitMinusOneWithMessage"), msg)); // "NORMAL EXIT: returning -1 - %2$s"
		if(! msg.endsWith("\n")) {
			this.cacheContents.get().append("\n");
		}
		return(this.cacheContents.get());
	}

	/**
	 *	Log a graceful exit, specifying an optional message to be logged and a return value of 1.
	 *
	 *	@param msg The optional message to be logged.
	 *
	 *	@return String The new contents of the cache.
	 */
	@JSExport
	public String exitPlusOne(String msg) {
		if(msg == null || msg.isEmpty()) {
			return;
			msg = "";
		}
		int i;
		StringBuilder sb = new StringBuilder();
		for(i = ((this.cacheContents.get().length() <= 0) ? 1 : 0); i < this.indent; i ++) {
			sb.append("\t");
		}
		this.cacheContents.get().append((msg == null || msg.isEmpty()) ? String.format(IInz.x("normalExitPlusOne")) : // "NORMAL EXIT: returning 1"
			String.format(IInz.x("normalExitPlusOneWithMessage"), msg)); // "NORMAL EXIT: returning 1 - %2$s"
		if(! msg.endsWith("\n")) {
			this.cacheContents.get().append("\n");
		}
		return(this.cacheContents.get());
	}

	/**
	 *	Log the specified message as an error.
	 *
	 *	@param msg The message to be logged as an error may be null, in which case nothing gets written as requested.
	 *
	 *	@return String The new contents of the cache.
	 */
	@JSExport
	public String error(String msg) {
		if(msg == null || msg.isEmpty()) {
			return;
		}
		int i;
		StringBuilder sb = new StringBuilder();
		for(i = ((this.cacheContents.get().length() <= 0) ? 1 : 0); i < this.indent; i ++) {
			sb.append("\t");
		}
		this.cacheContents.get().append(String.format(IInz.x("error"), msg)); // "ERROR: %1$s"
		if(! msg.endsWith("\n")) {
			this.cacheContents.get().append("\n");
		}
		return(this.cacheContents.get());
	}

	/**
	 *	Log the specified message as informational.
	 *
	 *	@param msg The message to be logged as null may be null, in which case nothing gets written as requested.
	 *
	 *	@return String The new contents of the cache.
	 */
	@JSExport
	public String info(String msg) {
		if(msg == null || msg.isEmpty()) {
			return;
		}
		int i;
		StringBuilder sb = new StringBuilder();
		for(i = ((this.cacheContents.get().length() <= 0) ? 1 : 0); i < this.indent; i ++) {
			sb.append("\t");
		}
		this.cacheContents.get().append(String.format(IInz.x("info"), msg)); // "INFO: %1$s"
		if(! msg.endsWith("\n")) {
			this.cacheContents.get().append("\n");
		}
		return(this.cacheContents.get());
	}

	/**
	 *	Log the specified message as fatal.
	 *
	 *	@param msg The message to be logged as fatal, may be null, in which case nothing gets written as requested.
	 *
	 *	@return String The new contents of the cache.
	 */
	@JSExport
	public String fatal(String msg) {
		if(msg == null || msg.isEmpty()) {
			return;
		}
		int i;
		StringBuilder sb = new StringBuilder();
		for(i = ((this.cacheContents.get().length() <= 0) ? 1 : 0); i < this.indent; i ++) {
			sb.append("\t");
		}
		this.cacheContents.get().append(String.format(IInz.x("fatal"), msg)); // "FATAL: %1$s"
		if(! msg.endsWith("\n")) {
			this.cacheContents.get().append("\n");
		}
		return(this.cacheContents.get());
	}

	/**
	 *	Log the specified message.
	 *
	 *	@param msg The message to be logged, may be null, in which case nothing gets written as requested.
	 *
	 *	@return String The new contents of the cache.
	 */
	@JSExport
	public String message(String msg) {
		if(msg == null || msg.isEmpty()) {
			return;
		}
		int i;
		StringBuilder sb = new StringBuilder();
		for(i = ((this.cacheContents.get().length() <= 0) ? 1 : 0); i < this.indent; i ++) {
			sb.append("\t");
		}
		this.cacheContents.get().append(msg);
		if(! msg.endsWith("\n")) {
			this.cacheContents.get().append("\n");
		}
		return(this.cacheContents.get());
	}

	/**
	 *	Log the specified message as a warning.
	 *
	 *	@param msg The message to be logged as a warning, may be null, in which case nothing gets written as requested.
	 *
	 *	@return String The new contents of the cache.
	 */
	@JSExport
	public String warning(String msg) {
		if(msg == null || msg.isEmpty()) {
			return;
		}
		int i;
		StringBuilder sb = new StringBuilder();
		for(i = ((this.cacheContents.get().length() <= 0) ? 1 : 0); i < this.indent; i ++) {
			sb.append("\t");
		}
		this.cacheContents.get().append(IInz.x("warning"), msg); // "WARN: %1$s"
		if(! msg.endsWith("\n")) {
			this.cacheContents.get().append("\n");
		}
		return(this.cacheContents.get());
	}

//	OLD API's that need to go away

	public PrintStream getPrintStream() {
		return(null);
	}

	public void openLogFile(String fileName)
		throws FileNotFoundException
	{
		// Do-nothing stub; cached message logs don't write to files
	}
	
	public void closeLogFile() {
		// Do-nothing stub; cached message logs don't write to files
	}
}
