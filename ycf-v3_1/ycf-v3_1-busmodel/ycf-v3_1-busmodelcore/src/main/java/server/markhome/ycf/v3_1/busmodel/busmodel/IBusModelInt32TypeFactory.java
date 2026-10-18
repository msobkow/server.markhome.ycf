
// Description: Java JPA Factory interface for Int32Type.

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
 *	IBusModelInt32TypeFactory interface for Int32Type
 */
public interface IBusModelInt32TypeFactory extends IBusModelProtInt32TypeFactory
{

	/**
	 *	Allocate a SchemaIdx key over Int32Type instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelInt32TypeBySchemaIdxKey newBySchemaIdxKey();

	/**
	 *	Allocate a protected SchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtInt32TypeBySchemaIdxKey asProtected(IBusModelInt32TypeBySchemaIdxKey src);

	/**
	 *	Allocate a public SchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubInt32TypeBySchemaIdxKey asPublic(IBusModelInt32TypeBySchemaIdxKey src);

	/**
	 *	Allocate a Int32Type interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelInt32Type newRec();

	/**
	 *	Allocate a protected Int32Type interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtInt32Type asProtected(IBusModelInt32Type src);

	/**
	 *	Allocate a public Int32Type interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubInt32Type asPublic(IBusModelInt32Type src);

	/**
	 *	Allocate a Int32Type history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelInt32TypeH newHRec();

	/**
	 *	Allocate a protected Int32Type history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtInt32TypeH asProtected(IBusModelInt32TypeH src);

	/**
	 *	Allocate a public Int32Type history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubInt32TypeH asPublic(IBusModelInt32TypeH src);

}
