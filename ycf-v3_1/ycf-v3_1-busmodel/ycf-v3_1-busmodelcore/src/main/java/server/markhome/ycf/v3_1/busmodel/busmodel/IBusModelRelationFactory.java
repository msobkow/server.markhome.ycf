
// Description: Java JPA Factory interface for Relation.

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
 *	IBusModelRelationFactory interface for Relation
 */
public interface IBusModelRelationFactory extends IBusModelProtRelationFactory
{

	/**
	 *	Allocate a UNameIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationByUNameIdxKey asProtected(IBusModelRelationByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationByUNameIdxKey asPublic(IBusModelRelationByUNameIdxKey src);

	/**
	 *	Allocate a RelTableIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationByRelTableIdxKey newByRelTableIdxKey();

	/**
	 *	Allocate a protected RelTableIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationByRelTableIdxKey asProtected(IBusModelRelationByRelTableIdxKey src);

	/**
	 *	Allocate a public RelTableIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationByRelTableIdxKey asPublic(IBusModelRelationByRelTableIdxKey src);

	/**
	 *	Allocate a RelCodeVisIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationByRelCodeVisIdxKey newByRelCodeVisIdxKey();

	/**
	 *	Allocate a protected RelCodeVisIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationByRelCodeVisIdxKey asProtected(IBusModelRelationByRelCodeVisIdxKey src);

	/**
	 *	Allocate a public RelCodeVisIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationByRelCodeVisIdxKey asPublic(IBusModelRelationByRelCodeVisIdxKey src);

	/**
	 *	Allocate a RelTableCodeVisX key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationByRelTableCodeVisXKey newByRelTableCodeVisXKey();

	/**
	 *	Allocate a protected RelTableCodeVisX key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationByRelTableCodeVisXKey asProtected(IBusModelRelationByRelTableCodeVisXKey src);

	/**
	 *	Allocate a public RelTableCodeVisX key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationByRelTableCodeVisXKey asPublic(IBusModelRelationByRelTableCodeVisXKey src);

	/**
	 *	Allocate a DefSchemaIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationByDefSchemaIdxKey newByDefSchemaIdxKey();

	/**
	 *	Allocate a protected DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationByDefSchemaIdxKey asProtected(IBusModelRelationByDefSchemaIdxKey src);

	/**
	 *	Allocate a public DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationByDefSchemaIdxKey asPublic(IBusModelRelationByDefSchemaIdxKey src);

	/**
	 *	Allocate a FromKeyIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationByFromKeyIdxKey newByFromKeyIdxKey();

	/**
	 *	Allocate a protected FromKeyIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationByFromKeyIdxKey asProtected(IBusModelRelationByFromKeyIdxKey src);

	/**
	 *	Allocate a public FromKeyIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationByFromKeyIdxKey asPublic(IBusModelRelationByFromKeyIdxKey src);

	/**
	 *	Allocate a ToTblIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationByToTblIdxKey newByToTblIdxKey();

	/**
	 *	Allocate a protected ToTblIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationByToTblIdxKey asProtected(IBusModelRelationByToTblIdxKey src);

	/**
	 *	Allocate a public ToTblIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationByToTblIdxKey asPublic(IBusModelRelationByToTblIdxKey src);

	/**
	 *	Allocate a ToKeyIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationByToKeyIdxKey newByToKeyIdxKey();

	/**
	 *	Allocate a protected ToKeyIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationByToKeyIdxKey asProtected(IBusModelRelationByToKeyIdxKey src);

	/**
	 *	Allocate a public ToKeyIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationByToKeyIdxKey asPublic(IBusModelRelationByToKeyIdxKey src);

	/**
	 *	Allocate a NarrowedIdx key over Relation instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationByNarrowedIdxKey newByNarrowedIdxKey();

	/**
	 *	Allocate a protected NarrowedIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationByNarrowedIdxKey asProtected(IBusModelRelationByNarrowedIdxKey src);

	/**
	 *	Allocate a public NarrowedIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationByNarrowedIdxKey asPublic(IBusModelRelationByNarrowedIdxKey src);

	/**
	 *	Allocate a Relation interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelation newRec();

	/**
	 *	Allocate a protected Relation interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelation asProtected(IBusModelRelation src);

	/**
	 *	Allocate a public Relation interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelation asPublic(IBusModelRelation src);

	/**
	 *	Allocate a Relation history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelRelationH newHRec();

	/**
	 *	Allocate a protected Relation history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtRelationH asProtected(IBusModelRelationH src);

	/**
	 *	Allocate a public Relation history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubRelationH asPublic(IBusModelRelationH src);

}
