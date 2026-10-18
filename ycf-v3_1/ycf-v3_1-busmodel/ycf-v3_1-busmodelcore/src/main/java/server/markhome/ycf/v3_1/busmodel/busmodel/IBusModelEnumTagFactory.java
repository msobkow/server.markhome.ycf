
// Description: Java JPA Factory interface for EnumTag.

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
 *	IBusModelEnumTagFactory interface for EnumTag
 */
public interface IBusModelEnumTagFactory extends IBusModelProtEnumTagFactory
{

	/**
	 *	Allocate a primary history key for EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	IBusModelEnumTagHPKey newHPKey();

	/**
	 *	Allocate a protected primary history key for EnumTag instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelProtEnumTagHPKey asProtected(IBusModelEnumTagHPKey src);

	/**
	 *	Allocate a public primary history key for EnumTag instances from a private instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelPubEnumTagHPKey asPublic(IBusModelEnumTagHPKey src);

	/**
	 *	Allocate a EnumIdx key over EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelEnumTagByEnumIdxKey newByEnumIdxKey();

	/**
	 *	Allocate a protected EnumIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtEnumTagByEnumIdxKey asProtected(IBusModelEnumTagByEnumIdxKey src);

	/**
	 *	Allocate a public EnumIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubEnumTagByEnumIdxKey asPublic(IBusModelEnumTagByEnumIdxKey src);

	/**
	 *	Allocate a DefSchemaIdx key over EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelEnumTagByDefSchemaIdxKey newByDefSchemaIdxKey();

	/**
	 *	Allocate a protected DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtEnumTagByDefSchemaIdxKey asProtected(IBusModelEnumTagByDefSchemaIdxKey src);

	/**
	 *	Allocate a public DefSchemaIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubEnumTagByDefSchemaIdxKey asPublic(IBusModelEnumTagByDefSchemaIdxKey src);

	/**
	 *	Allocate a EnumNameIdx key over EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelEnumTagByEnumNameIdxKey newByEnumNameIdxKey();

	/**
	 *	Allocate a protected EnumNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtEnumTagByEnumNameIdxKey asProtected(IBusModelEnumTagByEnumNameIdxKey src);

	/**
	 *	Allocate a public EnumNameIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubEnumTagByEnumNameIdxKey asPublic(IBusModelEnumTagByEnumNameIdxKey src);

	/**
	 *	Allocate a PrevIdx key over EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelEnumTagByPrevIdxKey newByPrevIdxKey();

	/**
	 *	Allocate a protected PrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtEnumTagByPrevIdxKey asProtected(IBusModelEnumTagByPrevIdxKey src);

	/**
	 *	Allocate a public PrevIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubEnumTagByPrevIdxKey asPublic(IBusModelEnumTagByPrevIdxKey src);

	/**
	 *	Allocate a NextIdx key over EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelEnumTagByNextIdxKey newByNextIdxKey();

	/**
	 *	Allocate a protected NextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtEnumTagByNextIdxKey asProtected(IBusModelEnumTagByNextIdxKey src);

	/**
	 *	Allocate a public NextIdx key from a private instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubEnumTagByNextIdxKey asPublic(IBusModelEnumTagByNextIdxKey src);

	/**
	 *	Allocate a EnumTag interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelEnumTag newRec();

	/**
	 *	Allocate a protected EnumTag interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtEnumTag asProtected(IBusModelEnumTag src);

	/**
	 *	Allocate a public EnumTag interface from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubEnumTag asPublic(IBusModelEnumTag src);

	/**
	 *	Allocate a EnumTag history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelEnumTagH newHRec();

	/**
	 *	Allocate a protected EnumTag history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtEnumTagH asProtected(IBusModelEnumTagH src);

	/**
	 *	Allocate a public EnumTag history interface implementation from a private interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubEnumTagH asPublic(IBusModelEnumTagH src);

}
