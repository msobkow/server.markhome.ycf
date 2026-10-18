
// Description: Java JPA Factory interface for Chain.

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
 *	IBusModelChainFactory interface for Chain
 */
public interface IBusModelChainFactory extends IBusModelProtChainFactory
{

	/**
	 *	Allocate a primary history key for Chain instances.
	 *
	 *	@return	The new instance.
	 */
	IBusModelChainHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for Chain instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelProtChainHPKey asProtected(IBusModelChainHPKey src);

	/**
	 *	Allocate a public primary history key for Chain instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelPubChainHPKey asPublic(IBusModelChainHPKey src);

	/**
	 *	Allocate a ChainTableIdx key over Chain instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelChainByChainTableIdxKey newByChainTableIdxKey();

	/**
	 *	Allocate a protected ChainTableIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtChainByChainTableIdxKey asProtected(IBusModelChainByChainTableIdxKey src);

	/**
	 *	Allocate a public ChainTableIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubChainByChainTableIdxKey asPublic(IBusModelChainByChainTableIdxKey src);

	/**
	 *	Allocate a DefSchemaIdx key over Chain instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelChainByDefSchemaIdxKey newByDefSchemaIdxKey();

	/**
	 *	Allocate a protected DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtChainByDefSchemaIdxKey asProtected(IBusModelChainByDefSchemaIdxKey src);

	/**
	 *	Allocate a public DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubChainByDefSchemaIdxKey asPublic(IBusModelChainByDefSchemaIdxKey src);

	/**
	 *	Allocate a UNameIdx key over Chain instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelChainByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtChainByUNameIdxKey asProtected(IBusModelChainByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubChainByUNameIdxKey asPublic(IBusModelChainByUNameIdxKey src);

	/**
	 *	Allocate a PrevRelIdx key over Chain instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelChainByPrevRelIdxKey newByPrevRelIdxKey();

	/**
	 *	Allocate a protected PrevRelIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtChainByPrevRelIdxKey asProtected(IBusModelChainByPrevRelIdxKey src);

	/**
	 *	Allocate a public PrevRelIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubChainByPrevRelIdxKey asPublic(IBusModelChainByPrevRelIdxKey src);

	/**
	 *	Allocate a NextRelIdx key over Chain instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelChainByNextRelIdxKey newByNextRelIdxKey();

	/**
	 *	Allocate a protected NextRelIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtChainByNextRelIdxKey asProtected(IBusModelChainByNextRelIdxKey src);

	/**
	 *	Allocate a public NextRelIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubChainByNextRelIdxKey asPublic(IBusModelChainByNextRelIdxKey src);

	/**
	 *	Allocate a Chain interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelChain newRec();

	/**
	 *	Allocate a protected Chain interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtChain asProtected(IBusModelChain src);

	/**
	 *	Allocate a public Chain interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubChain asPublic(IBusModelChain src);

	/**
	 *	Allocate a Chain history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelChainH newHRec();

	/**
	 *	Allocate a protected Chain history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtChainH asProtected(IBusModelChainH src);

	/**
	 *	Allocate a public Chain history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubChainH asPublic(IBusModelChainH src);

}
