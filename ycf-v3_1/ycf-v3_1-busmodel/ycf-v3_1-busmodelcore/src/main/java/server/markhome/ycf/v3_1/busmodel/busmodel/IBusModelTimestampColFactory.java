
// Description: Java JPA Factory interface for TimestampCol.

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodel;

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

/*
 *	IBusModelTimestampColFactory interface for TimestampCol
 */
public interface IBusModelTimestampColFactory extends IBusModelProtTimestampColFactory
{

	/**
	 *	Allocate a TableIdx key over TimestampCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelTimestampColByTableIdxKey newByTableIdxKey();

	/**
	 *	Allocate a protected TableIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtTimestampColByTableIdxKey asProtected(IBusModelTimestampColByTableIdxKey src);

	/**
	 *	Allocate a public TableIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubTimestampColByTableIdxKey asPublic(IBusModelTimestampColByTableIdxKey src);

	/**
	 *	Allocate a TimestampCol interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelTimestampCol newRec();

	/**
	 *	Allocate a protected TimestampCol interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtTimestampCol asProtected(IBusModelTimestampCol src);

	/**
	 *	Allocate a public TimestampCol interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubTimestampCol asPublic(IBusModelTimestampCol src);

	/**
	 *	Allocate a TimestampCol history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelTimestampColH newHRec();

	/**
	 *	Allocate a protected TimestampCol history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtTimestampColH asProtected(IBusModelTimestampColH src);

	/**
	 *	Allocate a public TimestampCol history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubTimestampColH asPublic(IBusModelTimestampColH src);

}
