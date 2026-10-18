
// Description: Java JPA Factory interface for Value.

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
 *	IBusModelValueFactory interface for Value
 */
public interface IBusModelValueFactory extends IBusModelProtValueFactory
{

	/**
	 *	Allocate a primary history key for Value instances.
	 *
	 *	@return	The new instance.
	 */
	IBusModelValueHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for Value instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelProtValueHPKey asProtected(IBusModelValueHPKey src);

	/**
	 *	Allocate a public primary history key for Value instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelPubValueHPKey asPublic(IBusModelValueHPKey src);

	/**
	 *	Allocate a UNameIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelValueByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueByUNameIdxKey asProtected(IBusModelValueByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueByUNameIdxKey asPublic(IBusModelValueByUNameIdxKey src);

	/**
	 *	Allocate a ScopeIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelValueByScopeIdxKey newByScopeIdxKey();

	/**
	 *	Allocate a protected ScopeIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueByScopeIdxKey asProtected(IBusModelValueByScopeIdxKey src);

	/**
	 *	Allocate a public ScopeIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueByScopeIdxKey asPublic(IBusModelValueByScopeIdxKey src);

	/**
	 *	Allocate a DefSchemaIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelValueByDefSchemaIdxKey newByDefSchemaIdxKey();

	/**
	 *	Allocate a protected DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueByDefSchemaIdxKey asProtected(IBusModelValueByDefSchemaIdxKey src);

	/**
	 *	Allocate a public DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueByDefSchemaIdxKey asPublic(IBusModelValueByDefSchemaIdxKey src);

	/**
	 *	Allocate a PrevIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelValueByPrevIdxKey newByPrevIdxKey();

	/**
	 *	Allocate a protected PrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueByPrevIdxKey asProtected(IBusModelValueByPrevIdxKey src);

	/**
	 *	Allocate a public PrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueByPrevIdxKey asPublic(IBusModelValueByPrevIdxKey src);

	/**
	 *	Allocate a NextIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelValueByNextIdxKey newByNextIdxKey();

	/**
	 *	Allocate a protected NextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueByNextIdxKey asProtected(IBusModelValueByNextIdxKey src);

	/**
	 *	Allocate a public NextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueByNextIdxKey asPublic(IBusModelValueByNextIdxKey src);

	/**
	 *	Allocate a ContPrevIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelValueByContPrevIdxKey newByContPrevIdxKey();

	/**
	 *	Allocate a protected ContPrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueByContPrevIdxKey asProtected(IBusModelValueByContPrevIdxKey src);

	/**
	 *	Allocate a public ContPrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueByContPrevIdxKey asPublic(IBusModelValueByContPrevIdxKey src);

	/**
	 *	Allocate a ContNextIdx key over Value instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelValueByContNextIdxKey newByContNextIdxKey();

	/**
	 *	Allocate a protected ContNextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueByContNextIdxKey asProtected(IBusModelValueByContNextIdxKey src);

	/**
	 *	Allocate a public ContNextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueByContNextIdxKey asPublic(IBusModelValueByContNextIdxKey src);

	/**
	 *	Allocate a Value interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelValue newRec();

	/**
	 *	Allocate a protected Value interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValue asProtected(IBusModelValue src);

	/**
	 *	Allocate a public Value interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValue asPublic(IBusModelValue src);

	/**
	 *	Allocate a Value history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelValueH newHRec();

	/**
	 *	Allocate a protected Value history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueH asProtected(IBusModelValueH src);

	/**
	 *	Allocate a public Value history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueH asPublic(IBusModelValueH src);

}
