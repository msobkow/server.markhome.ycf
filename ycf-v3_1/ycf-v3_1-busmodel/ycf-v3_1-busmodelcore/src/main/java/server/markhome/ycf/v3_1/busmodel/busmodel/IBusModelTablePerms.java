// Description: Java 25 BusModel Table Permissions Interface.

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

import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;

public interface IBusModelTablePerms
extends ISecureTablePerms,
	IIntNetTablePerms
{
	/**
	 *	Is the session allowed to create Atom instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateAtom( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Atom instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadAtom( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Atom instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateAtom( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Atom instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteAtom( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create BlobCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateBlobCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read BlobCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadBlobCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update BlobCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateBlobCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete BlobCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteBlobCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create BlobDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateBlobDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read BlobDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadBlobDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update BlobDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateBlobDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete BlobDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteBlobDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create BlobType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateBlobType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read BlobType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadBlobType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update BlobType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateBlobType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete BlobType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteBlobType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create BoolCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateBoolCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read BoolCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadBoolCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update BoolCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateBoolCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete BoolCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteBoolCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create BoolDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateBoolDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read BoolDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadBoolDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update BoolDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateBoolDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete BoolDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteBoolDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create BoolType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateBoolType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read BoolType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadBoolType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update BoolType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateBoolType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete BoolType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteBoolType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Chain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateChain( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Chain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadChain( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Chain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateChain( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Chain instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteChain( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ClearDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateClearDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ClearDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadClearDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ClearDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateClearDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ClearDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteClearDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ClearSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateClearSubDep1( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ClearSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadClearSubDep1( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ClearSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateClearSubDep1( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ClearSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteClearSubDep1( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ClearSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateClearSubDep2( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ClearSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadClearSubDep2( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ClearSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateClearSubDep2( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ClearSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteClearSubDep2( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ClearSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateClearSubDep3( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ClearSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadClearSubDep3( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ClearSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateClearSubDep3( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ClearSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteClearSubDep3( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ClearTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateClearTopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ClearTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadClearTopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ClearTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateClearTopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ClearTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteClearTopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDateCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDateCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDateCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDateCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDateDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDateDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDateDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDateDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDateType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDateType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDateType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDateType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash128Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash128Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash128Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash128Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash128Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash128Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash128Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash128Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash128Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash128Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash128Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash128Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash128Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash128Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash128Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash128Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash128Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash128Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash128Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash128Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash128Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash128Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash128Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash128Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash128Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash128Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash128Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash128Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash128Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash128Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash128Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash128Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash160Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash160Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash160Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash160Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash160Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash160Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash160Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash160Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash160Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash160Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash160Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash160Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash160Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash160Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash160Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash160Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash160Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash160Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash160Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash160Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash160Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash160Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash160Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash160Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash160Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash160Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash160Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash160Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash160Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash160Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash160Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash160Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash224Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash224Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash224Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash224Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash224Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash224Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash224Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash224Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash224Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash224Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash224Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash224Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash224Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash224Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash224Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash224Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash224Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash224Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash224Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash224Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash224Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash224Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash224Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash224Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash224Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash224Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash224Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash224Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash224Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash224Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash224Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash224Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash256Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash256Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash256Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash256Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash256Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash256Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash256Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash256Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash256Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash256Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash256Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash256Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash256Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash256Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash256Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash256Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash256Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash256Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash256Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash256Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash256Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash256Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash256Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash256Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash256Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash256Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash256Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash256Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash256Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash256Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash256Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash256Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash384Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash384Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash384Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash384Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash384Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash384Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash384Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash384Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash384Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash384Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash384Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash384Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash384Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash384Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash384Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash384Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash384Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash384Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash384Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash384Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash384Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash384Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash384Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash384Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash384Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash384Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash384Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash384Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash384Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash384Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash384Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash384Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash512Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash512Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash512Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash512Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash512Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash512Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash512Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash512Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash512Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash512Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash512Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash512Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash512Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash512Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash512Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash512Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash512Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash512Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash512Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash512Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash512Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash512Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash512Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash512Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DbKeyHash512Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDbKeyHash512Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DbKeyHash512Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDbKeyHash512Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DbKeyHash512Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDbKeyHash512Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DbKeyHash512Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDbKeyHash512Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DelDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDelDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DelDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDelDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DelDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDelDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DelDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDelDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DelSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDelSubDep1( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DelSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDelSubDep1( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DelSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDelSubDep1( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DelSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDelSubDep1( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DelSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDelSubDep2( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DelSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDelSubDep2( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DelSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDelSubDep2( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DelSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDelSubDep2( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DelSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDelSubDep3( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DelSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDelSubDep3( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DelSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDelSubDep3( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DelSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDelSubDep3( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DelTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDelTopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DelTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDelTopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DelTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDelTopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DelTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDelTopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DoubleCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDoubleCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DoubleCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDoubleCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DoubleCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDoubleCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DoubleCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDoubleCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DoubleDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDoubleDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DoubleDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDoubleDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DoubleDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDoubleDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DoubleDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDoubleDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create DoubleType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateDoubleType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read DoubleType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadDoubleType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update DoubleType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateDoubleType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete DoubleType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteDoubleType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create EnumDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateEnumDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read EnumDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadEnumDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update EnumDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateEnumDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete EnumDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteEnumDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create EnumTag instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateEnumTag( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read EnumTag instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadEnumTag( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update EnumTag instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateEnumTag( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete EnumTag instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteEnumTag( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create EnumType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateEnumType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read EnumType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadEnumType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update EnumType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateEnumType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete EnumType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteEnumType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create FloatCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateFloatCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read FloatCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadFloatCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update FloatCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateFloatCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete FloatCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteFloatCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create FloatDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateFloatDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read FloatDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadFloatDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update FloatDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateFloatDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete FloatDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteFloatDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create FloatType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateFloatType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read FloatType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadFloatType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update FloatType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateFloatType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete FloatType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteFloatType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Id16Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateId16Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Id16Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadId16Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Id16Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateId16Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Id16Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteId16Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Id32Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateId32Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Id32Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadId32Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Id32Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateId32Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Id32Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteId32Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Id64Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateId64Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Id64Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadId64Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Id64Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateId64Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Id64Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteId64Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Index instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateIndex( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Index instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadIndex( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Index instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateIndex( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Index instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteIndex( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create IndexCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateIndexCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read IndexCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadIndexCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update IndexCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateIndexCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete IndexCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteIndexCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create IndexTweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateIndexTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read IndexTweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadIndexTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update IndexTweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateIndexTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete IndexTweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteIndexTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt16Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt16Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt16Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt16Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt16Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt16Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt16Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt16Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt16Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt16Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt16Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt16Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt32Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt32Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt32Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt32Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt32Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt32Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt32Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt32Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt32Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt32Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt32Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt32Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt64Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt64Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt64Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt64Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt64Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt64Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt64Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt64Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Int64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateInt64Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Int64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadInt64Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Int64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateInt64Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Int64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteInt64Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create NmTokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNmTokenCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read NmTokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNmTokenCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update NmTokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNmTokenCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NmTokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNmTokenCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create NmTokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNmTokenDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read NmTokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNmTokenDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update NmTokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNmTokenDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NmTokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNmTokenDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create NmTokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNmTokenType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read NmTokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNmTokenType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update NmTokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNmTokenType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NmTokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNmTokenType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create NmTokensCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNmTokensCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read NmTokensCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNmTokensCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update NmTokensCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNmTokensCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NmTokensCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNmTokensCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create NmTokensDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNmTokensDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read NmTokensDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNmTokensDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update NmTokensDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNmTokensDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NmTokensDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNmTokensDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create NmTokensType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNmTokensType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read NmTokensType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNmTokensType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update NmTokensType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNmTokensType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NmTokensType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNmTokensType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create NumberCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNumberCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read NumberCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNumberCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update NumberCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNumberCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NumberCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNumberCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create NumberDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNumberDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read NumberDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNumberDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update NumberDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNumberDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NumberDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNumberDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create NumberType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateNumberType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read NumberType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadNumberType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update NumberType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateNumberType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete NumberType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteNumberType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Param instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateParam( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Param instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadParam( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Param instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateParam( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Param instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteParam( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create PopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreatePopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read PopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadPopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update PopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdatePopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete PopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeletePopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create PopSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreatePopSubDep1( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read PopSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadPopSubDep1( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update PopSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdatePopSubDep1( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete PopSubDep1 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeletePopSubDep1( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create PopSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreatePopSubDep2( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read PopSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadPopSubDep2( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update PopSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdatePopSubDep2( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete PopSubDep2 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeletePopSubDep2( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create PopSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreatePopSubDep3( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read PopSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadPopSubDep3( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update PopSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdatePopSubDep3( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete PopSubDep3 instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeletePopSubDep3( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create PopTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreatePopTopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read PopTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadPopTopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update PopTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdatePopTopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete PopTopDep instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeletePopTopDep( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Relation instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateRelation( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Relation instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadRelation( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Relation instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateRelation( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Relation instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteRelation( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create RelationCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateRelationCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read RelationCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadRelationCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update RelationCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateRelationCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete RelationCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteRelationCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create RoleDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateRoleDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read RoleDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadRoleDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update RoleDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateRoleDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete RoleDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteRoleDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SchemaDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSchemaDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SchemaDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSchemaDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SchemaDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSchemaDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SchemaDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSchemaDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SchemaRef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSchemaRef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SchemaRef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSchemaRef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SchemaRef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSchemaRef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SchemaRef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSchemaRef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SchemaRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSchemaRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SchemaRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSchemaRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SchemaRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSchemaRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SchemaRole instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSchemaRole( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create SchemaTweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateSchemaTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read SchemaTweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadSchemaTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update SchemaTweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateSchemaTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete SchemaTweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteSchemaTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Scope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateScope( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Scope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadScope( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Scope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateScope( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Scope instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteScope( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ServerListFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateServerListFunc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ServerListFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadServerListFunc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ServerListFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateServerListFunc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ServerListFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteServerListFunc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ServerMethod instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateServerMethod( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ServerMethod instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadServerMethod( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ServerMethod instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateServerMethod( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ServerMethod instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteServerMethod( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ServerObjFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateServerObjFunc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ServerObjFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadServerObjFunc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ServerObjFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateServerObjFunc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ServerObjFunc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteServerObjFunc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create ServerProc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateServerProc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read ServerProc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadServerProc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update ServerProc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateServerProc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete ServerProc instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteServerProc( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create StringCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateStringCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read StringCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadStringCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update StringCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateStringCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete StringCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteStringCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create StringDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateStringDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read StringDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadStringDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update StringDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateStringDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete StringDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteStringDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create StringType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateStringType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read StringType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadStringType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update StringType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateStringType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete StringType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteStringType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZDateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZDateCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZDateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZDateCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZDateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZDateCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZDateCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZDateCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZDateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZDateDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZDateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZDateDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZDateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZDateDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZDateDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZDateDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZDateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZDateType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZDateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZDateType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZDateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZDateType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZDateType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZDateType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZTimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZTimeCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZTimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZTimeCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZTimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZTimeCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZTimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZTimeCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZTimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZTimeDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZTimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZTimeDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZTimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZTimeDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZTimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZTimeDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZTimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZTimeType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZTimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZTimeType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZTimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZTimeType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZTimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZTimeType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZTimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZTimestampCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZTimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZTimestampCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZTimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZTimestampCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZTimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZTimestampCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZTimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZTimestampDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZTimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZTimestampDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZTimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZTimestampDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZTimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZTimestampDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TZTimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTZTimestampType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TZTimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTZTimestampType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TZTimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTZTimestampType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TZTimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTZTimestampType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Table instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTable( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Table instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTable( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Table instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTable( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Table instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTable( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TableCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTableCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TableCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTableCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TableCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTableCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TableCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTableCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TableTweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTableTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TableTweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTableTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TableTweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTableTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TableTweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTableTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TextCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTextCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TextCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTextCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TextCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTextCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TextCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTextCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TextDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTextDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TextDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTextDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TextDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTextDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TextDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTextDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TextType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTextType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TextType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTextType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TextType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTextType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TextType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTextType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTimeCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTimeCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTimeCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TimeCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTimeCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTimeDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTimeDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTimeDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TimeDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTimeDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTimeType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTimeType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTimeType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TimeType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTimeType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTimestampCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTimestampCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTimestampCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TimestampCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTimestampCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTimestampDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTimestampDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTimestampDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TimestampDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTimestampDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTimestampType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTimestampType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTimestampType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TimestampType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTimestampType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTokenCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTokenCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTokenCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TokenCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTokenCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTokenDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTokenDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTokenDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TokenDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTokenDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create TokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTokenType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read TokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTokenType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update TokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTokenType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete TokenType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTokenType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Tweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Tweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Tweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Tweak instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteTweak( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt16Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt16Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt16Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt16Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt16Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt16Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt16Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt16Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt16Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt16Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt16Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt16Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt16Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt16Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt16Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt32Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt32Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt32Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt32Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt32Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt32Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt32Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt32Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt32Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt32Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt32Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt32Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt32Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt32Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt32Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt64Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt64Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt64Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt64Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt64Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt64Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt64Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt64Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt64Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt64Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create UInt64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUInt64Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read UInt64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUInt64Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update UInt64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUInt64Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UInt64Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUInt64Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Uuid6Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUuid6Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Uuid6Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUuid6Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Uuid6Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUuid6Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Uuid6Col instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUuid6Col( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Uuid6Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUuid6Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Uuid6Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUuid6Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Uuid6Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUuid6Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Uuid6Def instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUuid6Def( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Uuid6Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUuid6Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Uuid6Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUuid6Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Uuid6Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUuid6Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Uuid6Gen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUuid6Gen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Uuid6Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUuid6Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Uuid6Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUuid6Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Uuid6Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUuid6Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Uuid6Type instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUuid6Type( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create UuidCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUuidCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read UuidCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUuidCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update UuidCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUuidCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UuidCol instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUuidCol( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create UuidDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUuidDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read UuidDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUuidDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update UuidDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUuidDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UuidDef instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUuidDef( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create UuidGen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUuidGen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read UuidGen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUuidGen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update UuidGen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUuidGen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UuidGen instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUuidGen( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create UuidType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateUuidType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read UuidType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadUuidType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update UuidType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateUuidType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete UuidType instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteUuidType( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to create Value instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowCreateValue( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to read Value instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowReadValue( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to update Value instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowUpdateValue( SecureAuthorization Authorization );

	/**
	 *	Is the session allowed to delete Value instances?
	 *
	 *	@param	Authorization	The session authorization information.
	 */
	boolean allowDeleteValue( SecureAuthorization Authorization );
}
