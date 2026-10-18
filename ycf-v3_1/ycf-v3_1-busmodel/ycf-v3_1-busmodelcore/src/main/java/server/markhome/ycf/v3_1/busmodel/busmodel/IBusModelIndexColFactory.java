
// Description: Java JPA Factory interface for IndexCol.

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
 *	IBusModelIndexColFactory interface for IndexCol
 */
public interface IBusModelIndexColFactory extends IBusModelProtIndexColFactory
{

	/**
	 *	Allocate a primary history key for IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	IBusModelIndexColHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for IndexCol instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelProtIndexColHPKey asProtected(IBusModelIndexColHPKey src);

	/**
	 *	Allocate a public primary history key for IndexCol instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelPubIndexColHPKey asPublic(IBusModelIndexColHPKey src);

	/**
	 *	Allocate a UNameIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelIndexColByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtIndexColByUNameIdxKey asProtected(IBusModelIndexColByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubIndexColByUNameIdxKey asPublic(IBusModelIndexColByUNameIdxKey src);

	/**
	 *	Allocate a IndexIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelIndexColByIndexIdxKey newByIndexIdxKey();

	/**
	 *	Allocate a protected IndexIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtIndexColByIndexIdxKey asProtected(IBusModelIndexColByIndexIdxKey src);

	/**
	 *	Allocate a public IndexIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubIndexColByIndexIdxKey asPublic(IBusModelIndexColByIndexIdxKey src);

	/**
	 *	Allocate a DefSchemaIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelIndexColByDefSchemaIdxKey newByDefSchemaIdxKey();

	/**
	 *	Allocate a protected DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtIndexColByDefSchemaIdxKey asProtected(IBusModelIndexColByDefSchemaIdxKey src);

	/**
	 *	Allocate a public DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubIndexColByDefSchemaIdxKey asPublic(IBusModelIndexColByDefSchemaIdxKey src);

	/**
	 *	Allocate a ColIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelIndexColByColIdxKey newByColIdxKey();

	/**
	 *	Allocate a protected ColIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtIndexColByColIdxKey asProtected(IBusModelIndexColByColIdxKey src);

	/**
	 *	Allocate a public ColIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubIndexColByColIdxKey asPublic(IBusModelIndexColByColIdxKey src);

	/**
	 *	Allocate a PrevIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelIndexColByPrevIdxKey newByPrevIdxKey();

	/**
	 *	Allocate a protected PrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtIndexColByPrevIdxKey asProtected(IBusModelIndexColByPrevIdxKey src);

	/**
	 *	Allocate a public PrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubIndexColByPrevIdxKey asPublic(IBusModelIndexColByPrevIdxKey src);

	/**
	 *	Allocate a NextIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelIndexColByNextIdxKey newByNextIdxKey();

	/**
	 *	Allocate a protected NextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtIndexColByNextIdxKey asProtected(IBusModelIndexColByNextIdxKey src);

	/**
	 *	Allocate a public NextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubIndexColByNextIdxKey asPublic(IBusModelIndexColByNextIdxKey src);

	/**
	 *	Allocate a IdxPrevIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelIndexColByIdxPrevIdxKey newByIdxPrevIdxKey();

	/**
	 *	Allocate a protected IdxPrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtIndexColByIdxPrevIdxKey asProtected(IBusModelIndexColByIdxPrevIdxKey src);

	/**
	 *	Allocate a public IdxPrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubIndexColByIdxPrevIdxKey asPublic(IBusModelIndexColByIdxPrevIdxKey src);

	/**
	 *	Allocate a IdxNextIdx key over IndexCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelIndexColByIdxNextIdxKey newByIdxNextIdxKey();

	/**
	 *	Allocate a protected IdxNextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtIndexColByIdxNextIdxKey asProtected(IBusModelIndexColByIdxNextIdxKey src);

	/**
	 *	Allocate a public IdxNextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubIndexColByIdxNextIdxKey asPublic(IBusModelIndexColByIdxNextIdxKey src);

	/**
	 *	Allocate a IndexCol interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelIndexCol newRec();

	/**
	 *	Allocate a protected IndexCol interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtIndexCol asProtected(IBusModelIndexCol src);

	/**
	 *	Allocate a public IndexCol interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubIndexCol asPublic(IBusModelIndexCol src);

	/**
	 *	Allocate a IndexCol history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelIndexColH newHRec();

	/**
	 *	Allocate a protected IndexCol history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtIndexColH asProtected(IBusModelIndexColH src);

	/**
	 *	Allocate a public IndexCol history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubIndexColH asPublic(IBusModelIndexColH src);

}
