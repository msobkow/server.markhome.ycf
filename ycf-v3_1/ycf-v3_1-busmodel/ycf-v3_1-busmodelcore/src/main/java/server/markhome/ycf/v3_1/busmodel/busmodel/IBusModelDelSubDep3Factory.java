
// Description: Java JPA Factory interface for DelSubDep3.

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
 *	IBusModelDelSubDep3Factory interface for DelSubDep3
 */
public interface IBusModelDelSubDep3Factory extends IBusModelProtDelSubDep3Factory
{

	/**
	 *	Allocate a DelSubDep2Idx key over DelSubDep3 instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelDelSubDep3ByDelSubDep2IdxKey newByDelSubDep2IdxKey();

	/**
	 *	Allocate a protected DelSubDep2Idx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtDelSubDep3ByDelSubDep2IdxKey asProtected(IBusModelDelSubDep3ByDelSubDep2IdxKey src);

	/**
	 *	Allocate a public DelSubDep2Idx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubDelSubDep3ByDelSubDep2IdxKey asPublic(IBusModelDelSubDep3ByDelSubDep2IdxKey src);

	/**
	 *	Allocate a UNameIdx key over DelSubDep3 instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelDelSubDep3ByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtDelSubDep3ByUNameIdxKey asProtected(IBusModelDelSubDep3ByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubDelSubDep3ByUNameIdxKey asPublic(IBusModelDelSubDep3ByUNameIdxKey src);

	/**
	 *	Allocate a DelSubDep3 interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelDelSubDep3 newRec();

	/**
	 *	Allocate a protected DelSubDep3 interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtDelSubDep3 asProtected(IBusModelDelSubDep3 src);

	/**
	 *	Allocate a public DelSubDep3 interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubDelSubDep3 asPublic(IBusModelDelSubDep3 src);

	/**
	 *	Allocate a DelSubDep3 history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelDelSubDep3H newHRec();

	/**
	 *	Allocate a protected DelSubDep3 history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtDelSubDep3H asProtected(IBusModelDelSubDep3H src);

	/**
	 *	Allocate a public DelSubDep3 history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubDelSubDep3H asPublic(IBusModelDelSubDep3H src);

}
