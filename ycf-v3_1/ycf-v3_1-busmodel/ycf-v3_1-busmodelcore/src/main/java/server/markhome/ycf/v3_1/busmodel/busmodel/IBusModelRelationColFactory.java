
// Description: Java JPA Factory interface for RelationCol.

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
 *	IBusModelRelationColFactory interface for RelationCol
 */
public interface IBusModelRelationColFactory extends IBusModelProtRelationColFactory
{

	/**
	 *	Allocate a primary history key for RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	IBusModelRelationColHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for RelationCol instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelProtRelationColHPKey asProtected(IBusModelRelationColHPKey src);

	/**
	 *	Allocate a public primary history key for RelationCol instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelPubRelationColHPKey asPublic(IBusModelRelationColHPKey src);

	/**
	 *	Allocate a UNameIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationColByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByUNameIdxKey asProtected(IBusModelRelationColByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByUNameIdxKey asPublic(IBusModelRelationColByUNameIdxKey src);

	/**
	 *	Allocate a RelationIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationColByRelationIdxKey newByRelationIdxKey();

	/**
	 *	Allocate a protected RelationIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByRelationIdxKey asProtected(IBusModelRelationColByRelationIdxKey src);

	/**
	 *	Allocate a public RelationIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByRelationIdxKey asPublic(IBusModelRelationColByRelationIdxKey src);

	/**
	 *	Allocate a DefSchemaIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationColByDefSchemaIdxKey newByDefSchemaIdxKey();

	/**
	 *	Allocate a protected DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByDefSchemaIdxKey asProtected(IBusModelRelationColByDefSchemaIdxKey src);

	/**
	 *	Allocate a public DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByDefSchemaIdxKey asPublic(IBusModelRelationColByDefSchemaIdxKey src);

	/**
	 *	Allocate a FromColIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationColByFromColIdxKey newByFromColIdxKey();

	/**
	 *	Allocate a protected FromColIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByFromColIdxKey asProtected(IBusModelRelationColByFromColIdxKey src);

	/**
	 *	Allocate a public FromColIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByFromColIdxKey asPublic(IBusModelRelationColByFromColIdxKey src);

	/**
	 *	Allocate a ToColIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationColByToColIdxKey newByToColIdxKey();

	/**
	 *	Allocate a protected ToColIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByToColIdxKey asProtected(IBusModelRelationColByToColIdxKey src);

	/**
	 *	Allocate a public ToColIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByToColIdxKey asPublic(IBusModelRelationColByToColIdxKey src);

	/**
	 *	Allocate a PrevIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationColByPrevIdxKey newByPrevIdxKey();

	/**
	 *	Allocate a protected PrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByPrevIdxKey asProtected(IBusModelRelationColByPrevIdxKey src);

	/**
	 *	Allocate a public PrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByPrevIdxKey asPublic(IBusModelRelationColByPrevIdxKey src);

	/**
	 *	Allocate a NextIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationColByNextIdxKey newByNextIdxKey();

	/**
	 *	Allocate a protected NextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByNextIdxKey asProtected(IBusModelRelationColByNextIdxKey src);

	/**
	 *	Allocate a public NextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByNextIdxKey asPublic(IBusModelRelationColByNextIdxKey src);

	/**
	 *	Allocate a RelPrevIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationColByRelPrevIdxKey newByRelPrevIdxKey();

	/**
	 *	Allocate a protected RelPrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByRelPrevIdxKey asProtected(IBusModelRelationColByRelPrevIdxKey src);

	/**
	 *	Allocate a public RelPrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByRelPrevIdxKey asPublic(IBusModelRelationColByRelPrevIdxKey src);

	/**
	 *	Allocate a RelNextIdx key over RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationColByRelNextIdxKey newByRelNextIdxKey();

	/**
	 *	Allocate a protected RelNextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByRelNextIdxKey asProtected(IBusModelRelationColByRelNextIdxKey src);

	/**
	 *	Allocate a public RelNextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByRelNextIdxKey asPublic(IBusModelRelationColByRelNextIdxKey src);

	/**
	 *	Allocate a RelationCol interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationCol newRec();

	/**
	 *	Allocate a protected RelationCol interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationCol asProtected(IBusModelRelationCol src);

	/**
	 *	Allocate a public RelationCol interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationCol asPublic(IBusModelRelationCol src);

	/**
	 *	Allocate a RelationCol history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationColH newHRec();

	/**
	 *	Allocate a protected RelationCol history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColH asProtected(IBusModelRelationColH src);

	/**
	 *	Allocate a public RelationCol history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColH asPublic(IBusModelRelationColH src);

}
