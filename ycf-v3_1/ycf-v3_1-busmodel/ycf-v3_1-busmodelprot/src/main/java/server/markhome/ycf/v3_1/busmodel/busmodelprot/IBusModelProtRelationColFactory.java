
// Description: Java Protected Factory interface for RelationCol.

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

package server.markhome.ycf.v3_1.busmodel.busmodelprot;

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

/*
 *	IBusModelProtRelationColFactory protected interface for RelationCol
 */
public interface IBusModelProtRelationColFactory extends IBusModelPubRelationColFactory
{

	/**
	 *	Allocate a protected primary history key for RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	IBusModelProtRelationColHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for RelationCol instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelPubRelationColHPKey asPublic(IBusModelProtRelationColHPKey src);

	/**
	 *	Allocate a protected UNameIdx key over protected RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByUNameIdxKey newProtByUNameIdxKey();

	/**
	 *	Allocate a public UNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByUNameIdxKey asPublic(IBusModelProtRelationColByUNameIdxKey src);

	/**
	 *	Allocate a protected RelationIdx key over protected RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByRelationIdxKey newProtByRelationIdxKey();

	/**
	 *	Allocate a public RelationIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByRelationIdxKey asPublic(IBusModelProtRelationColByRelationIdxKey src);

	/**
	 *	Allocate a protected DefSchemaIdx key over protected RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByDefSchemaIdxKey newProtByDefSchemaIdxKey();

	/**
	 *	Allocate a public DefSchemaIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByDefSchemaIdxKey asPublic(IBusModelProtRelationColByDefSchemaIdxKey src);

	/**
	 *	Allocate a protected FromColIdx key over protected RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByFromColIdxKey newProtByFromColIdxKey();

	/**
	 *	Allocate a public FromColIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByFromColIdxKey asPublic(IBusModelProtRelationColByFromColIdxKey src);

	/**
	 *	Allocate a protected ToColIdx key over protected RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByToColIdxKey newProtByToColIdxKey();

	/**
	 *	Allocate a public ToColIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByToColIdxKey asPublic(IBusModelProtRelationColByToColIdxKey src);

	/**
	 *	Allocate a protected PrevIdx key over protected RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByPrevIdxKey newProtByPrevIdxKey();

	/**
	 *	Allocate a public PrevIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByPrevIdxKey asPublic(IBusModelProtRelationColByPrevIdxKey src);

	/**
	 *	Allocate a protected NextIdx key over protected RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByNextIdxKey newProtByNextIdxKey();

	/**
	 *	Allocate a public NextIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByNextIdxKey asPublic(IBusModelProtRelationColByNextIdxKey src);

	/**
	 *	Allocate a protected RelPrevIdx key over protected RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByRelPrevIdxKey newProtByRelPrevIdxKey();

	/**
	 *	Allocate a public RelPrevIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByRelPrevIdxKey asPublic(IBusModelProtRelationColByRelPrevIdxKey src);

	/**
	 *	Allocate a protected RelNextIdx key over protected RelationCol instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColByRelNextIdxKey newProtByRelNextIdxKey();

	/**
	 *	Allocate a public RelNextIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColByRelNextIdxKey asPublic(IBusModelProtRelationColByRelNextIdxKey src);

	/**
	 *	Allocate a protected RelationCol interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationCol newProtRec();

	/**
	 *	Allocate a public RelationCol interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationCol asPublic(IBusModelProtRelationCol src);

	/**
	 *	Allocate a protected RelationCol history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationColH newProtHRec();

	/**
	 *	Allocate a public RelationCol history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationColH asPublic(IBusModelProtRelationColH src);

}
