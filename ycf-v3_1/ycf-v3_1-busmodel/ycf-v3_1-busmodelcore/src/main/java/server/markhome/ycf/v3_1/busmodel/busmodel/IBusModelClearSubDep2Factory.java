
// Description: Java JPA Factory interface for ClearSubDep2.

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
 *	IBusModelClearSubDep2Factory interface for ClearSubDep2
 */
public interface IBusModelClearSubDep2Factory extends IBusModelProtClearSubDep2Factory
{

	/**
	 *	Allocate a ClearSubDep1Idx key over ClearSubDep2 instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelClearSubDep2ByClearSubDep1IdxKey newByClearSubDep1IdxKey();

	/**
	 *	Allocate a protected ClearSubDep1Idx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtClearSubDep2ByClearSubDep1IdxKey asProtected(IBusModelClearSubDep2ByClearSubDep1IdxKey src);

	/**
	 *	Allocate a public ClearSubDep1Idx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubClearSubDep2ByClearSubDep1IdxKey asPublic(IBusModelClearSubDep2ByClearSubDep1IdxKey src);

	/**
	 *	Allocate a UNameIdx key over ClearSubDep2 instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelClearSubDep2ByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtClearSubDep2ByUNameIdxKey asProtected(IBusModelClearSubDep2ByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubClearSubDep2ByUNameIdxKey asPublic(IBusModelClearSubDep2ByUNameIdxKey src);

	/**
	 *	Allocate a ClearSubDep2 interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelClearSubDep2 newRec();

	/**
	 *	Allocate a protected ClearSubDep2 interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtClearSubDep2 asProtected(IBusModelClearSubDep2 src);

	/**
	 *	Allocate a public ClearSubDep2 interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubClearSubDep2 asPublic(IBusModelClearSubDep2 src);

	/**
	 *	Allocate a ClearSubDep2 history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelClearSubDep2H newHRec();

	/**
	 *	Allocate a protected ClearSubDep2 history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtClearSubDep2H asProtected(IBusModelClearSubDep2H src);

	/**
	 *	Allocate a public ClearSubDep2 history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubClearSubDep2H asPublic(IBusModelClearSubDep2H src);

}
