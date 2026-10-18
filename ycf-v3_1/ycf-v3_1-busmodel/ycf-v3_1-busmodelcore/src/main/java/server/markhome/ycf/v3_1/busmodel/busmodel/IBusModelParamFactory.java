
// Description: Java JPA Factory interface for Param.

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
 *	IBusModelParamFactory interface for Param
 */
public interface IBusModelParamFactory extends IBusModelProtParamFactory
{

	/**
	 *	Allocate a primary history key for Param instances.
	 *
	 *	@return	The new instance.
	 */
	IBusModelParamHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for Param instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelProtParamHPKey asProtected(IBusModelParamHPKey src);

	/**
	 *	Allocate a public primary history key for Param instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelPubParamHPKey asPublic(IBusModelParamHPKey src);

	/**
	 *	Allocate a UNameIdx key over Param instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelParamByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtParamByUNameIdxKey asProtected(IBusModelParamByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubParamByUNameIdxKey asPublic(IBusModelParamByUNameIdxKey src);

	/**
	 *	Allocate a ServerMethodIdx key over Param instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelParamByServerMethodIdxKey newByServerMethodIdxKey();

	/**
	 *	Allocate a protected ServerMethodIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtParamByServerMethodIdxKey asProtected(IBusModelParamByServerMethodIdxKey src);

	/**
	 *	Allocate a public ServerMethodIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubParamByServerMethodIdxKey asPublic(IBusModelParamByServerMethodIdxKey src);

	/**
	 *	Allocate a DefSchemaIdx key over Param instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelParamByDefSchemaIdxKey newByDefSchemaIdxKey();

	/**
	 *	Allocate a protected DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtParamByDefSchemaIdxKey asProtected(IBusModelParamByDefSchemaIdxKey src);

	/**
	 *	Allocate a public DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubParamByDefSchemaIdxKey asPublic(IBusModelParamByDefSchemaIdxKey src);

	/**
	 *	Allocate a ServerTypeIdx key over Param instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelParamByServerTypeIdxKey newByServerTypeIdxKey();

	/**
	 *	Allocate a protected ServerTypeIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtParamByServerTypeIdxKey asProtected(IBusModelParamByServerTypeIdxKey src);

	/**
	 *	Allocate a public ServerTypeIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubParamByServerTypeIdxKey asPublic(IBusModelParamByServerTypeIdxKey src);

	/**
	 *	Allocate a PrevIdx key over Param instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelParamByPrevIdxKey newByPrevIdxKey();

	/**
	 *	Allocate a protected PrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtParamByPrevIdxKey asProtected(IBusModelParamByPrevIdxKey src);

	/**
	 *	Allocate a public PrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubParamByPrevIdxKey asPublic(IBusModelParamByPrevIdxKey src);

	/**
	 *	Allocate a NextIdx key over Param instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelParamByNextIdxKey newByNextIdxKey();

	/**
	 *	Allocate a protected NextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtParamByNextIdxKey asProtected(IBusModelParamByNextIdxKey src);

	/**
	 *	Allocate a public NextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubParamByNextIdxKey asPublic(IBusModelParamByNextIdxKey src);

	/**
	 *	Allocate a ContPrevIdx key over Param instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelParamByContPrevIdxKey newByContPrevIdxKey();

	/**
	 *	Allocate a protected ContPrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtParamByContPrevIdxKey asProtected(IBusModelParamByContPrevIdxKey src);

	/**
	 *	Allocate a public ContPrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubParamByContPrevIdxKey asPublic(IBusModelParamByContPrevIdxKey src);

	/**
	 *	Allocate a ContNextIdx key over Param instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelParamByContNextIdxKey newByContNextIdxKey();

	/**
	 *	Allocate a protected ContNextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtParamByContNextIdxKey asProtected(IBusModelParamByContNextIdxKey src);

	/**
	 *	Allocate a public ContNextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubParamByContNextIdxKey asPublic(IBusModelParamByContNextIdxKey src);

	/**
	 *	Allocate a Param interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelParam newRec();

	/**
	 *	Allocate a protected Param interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtParam asProtected(IBusModelParam src);

	/**
	 *	Allocate a public Param interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubParam asPublic(IBusModelParam src);

	/**
	 *	Allocate a Param history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelParamH newHRec();

	/**
	 *	Allocate a protected Param history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtParamH asProtected(IBusModelParamH src);

	/**
	 *	Allocate a public Param history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubParamH asPublic(IBusModelParamH src);

}
