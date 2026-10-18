
// Description: Java JPA Factory interface for Tweak.

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
 *	IBusModelTweakFactory interface for Tweak
 */
public interface IBusModelTweakFactory extends IBusModelProtTweakFactory
{

	/**
	 *	Allocate a primary history key for Tweak instances.
	 *
	 *	@return	The new instance.
	 */
	IBusModelTweakHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for Tweak instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelProtTweakHPKey asProtected(IBusModelTweakHPKey src);

	/**
	 *	Allocate a public primary history key for Tweak instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelPubTweakHPKey asPublic(IBusModelTweakHPKey src);

	/**
	 *	Allocate a UNameIdx key over Tweak instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelTweakByUNameIdxKey newByUNameIdxKey();

	/**
	 *	Allocate a protected UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtTweakByUNameIdxKey asProtected(IBusModelTweakByUNameIdxKey src);

	/**
	 *	Allocate a public UNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubTweakByUNameIdxKey asPublic(IBusModelTweakByUNameIdxKey src);

	/**
	 *	Allocate a ValTentIdx key over Tweak instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelTweakByValTentIdxKey newByValTentIdxKey();

	/**
	 *	Allocate a protected ValTentIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtTweakByValTentIdxKey asProtected(IBusModelTweakByValTentIdxKey src);

	/**
	 *	Allocate a public ValTentIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubTweakByValTentIdxKey asPublic(IBusModelTweakByValTentIdxKey src);

	/**
	 *	Allocate a ScopeIdx key over Tweak instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelTweakByScopeIdxKey newByScopeIdxKey();

	/**
	 *	Allocate a protected ScopeIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtTweakByScopeIdxKey asProtected(IBusModelTweakByScopeIdxKey src);

	/**
	 *	Allocate a public ScopeIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubTweakByScopeIdxKey asPublic(IBusModelTweakByScopeIdxKey src);

	/**
	 *	Allocate a DefSchemaIdx key over Tweak instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelTweakByDefSchemaIdxKey newByDefSchemaIdxKey();

	/**
	 *	Allocate a protected DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtTweakByDefSchemaIdxKey asProtected(IBusModelTweakByDefSchemaIdxKey src);

	/**
	 *	Allocate a public DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubTweakByDefSchemaIdxKey asPublic(IBusModelTweakByDefSchemaIdxKey src);

	/**
	 *	Allocate a UDefIdx key over Tweak instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelTweakByUDefIdxKey newByUDefIdxKey();

	/**
	 *	Allocate a protected UDefIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtTweakByUDefIdxKey asProtected(IBusModelTweakByUDefIdxKey src);

	/**
	 *	Allocate a public UDefIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubTweakByUDefIdxKey asPublic(IBusModelTweakByUDefIdxKey src);

	/**
	 *	Allocate a Tweak interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelTweak newRec();

	/**
	 *	Allocate a protected Tweak interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtTweak asProtected(IBusModelTweak src);

	/**
	 *	Allocate a public Tweak interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubTweak asPublic(IBusModelTweak src);

	/**
	 *	Allocate a Tweak history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelTweakH newHRec();

	/**
	 *	Allocate a protected Tweak history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtTweakH asProtected(IBusModelTweakH src);

	/**
	 *	Allocate a public Tweak history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubTweakH asPublic(IBusModelTweakH src);

}
