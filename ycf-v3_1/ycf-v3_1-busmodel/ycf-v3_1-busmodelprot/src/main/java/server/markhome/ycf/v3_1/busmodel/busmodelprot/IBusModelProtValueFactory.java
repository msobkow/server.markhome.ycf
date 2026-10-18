
// Description: Java Protected Factory interface for Value.

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
 *	IBusModelProtValueFactory protected interface for Value
 */
public interface IBusModelProtValueFactory extends IBusModelPubValueFactory
{

	/**
	 *	Allocate a protected primary history key for Value instances.
	 *
	 *	@return	The new instance.
	 */
	IBusModelProtValueHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for Value instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelPubValueHPKey asPublic(IBusModelProtValueHPKey src);

	/**
	 *	Allocate a protected UNameIdx key over protected Value instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueByUNameIdxKey newProtByUNameIdxKey();

	/**
	 *	Allocate a public UNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueByUNameIdxKey asPublic(IBusModelProtValueByUNameIdxKey src);

	/**
	 *	Allocate a protected ScopeIdx key over protected Value instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueByScopeIdxKey newProtByScopeIdxKey();

	/**
	 *	Allocate a public ScopeIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueByScopeIdxKey asPublic(IBusModelProtValueByScopeIdxKey src);

	/**
	 *	Allocate a protected DefSchemaIdx key over protected Value instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueByDefSchemaIdxKey newProtByDefSchemaIdxKey();

	/**
	 *	Allocate a public DefSchemaIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueByDefSchemaIdxKey asPublic(IBusModelProtValueByDefSchemaIdxKey src);

	/**
	 *	Allocate a protected PrevIdx key over protected Value instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueByPrevIdxKey newProtByPrevIdxKey();

	/**
	 *	Allocate a public PrevIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueByPrevIdxKey asPublic(IBusModelProtValueByPrevIdxKey src);

	/**
	 *	Allocate a protected NextIdx key over protected Value instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueByNextIdxKey newProtByNextIdxKey();

	/**
	 *	Allocate a public NextIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueByNextIdxKey asPublic(IBusModelProtValueByNextIdxKey src);

	/**
	 *	Allocate a protected ContPrevIdx key over protected Value instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueByContPrevIdxKey newProtByContPrevIdxKey();

	/**
	 *	Allocate a public ContPrevIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueByContPrevIdxKey asPublic(IBusModelProtValueByContPrevIdxKey src);

	/**
	 *	Allocate a protected ContNextIdx key over protected Value instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueByContNextIdxKey newProtByContNextIdxKey();

	/**
	 *	Allocate a public ContNextIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueByContNextIdxKey asPublic(IBusModelProtValueByContNextIdxKey src);

	/**
	 *	Allocate a protected Value interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValue newProtRec();

	/**
	 *	Allocate a public Value interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValue asPublic(IBusModelProtValue src);

	/**
	 *	Allocate a protected Value history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtValueH newProtHRec();

	/**
	 *	Allocate a public Value history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubValueH asPublic(IBusModelProtValueH src);

}
