
// Description: Java Protected Factory interface for EnumTag.

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
 *	IBusModelProtEnumTagFactory protected interface for EnumTag
 */
public interface IBusModelProtEnumTagFactory extends IBusModelPubEnumTagFactory
{

	/**
	 *	Allocate a protected primary history key for EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	IBusModelProtEnumTagHPKey newProtHPKey();

	/**
	 *	Allocate a public primary history key for EnumTag instances from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	IBusModelPubEnumTagHPKey asPublic(IBusModelProtEnumTagHPKey src);

	/**
	 *	Allocate a protected EnumIdx key over protected EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtEnumTagByEnumIdxKey newProtByEnumIdxKey();

	/**
	 *	Allocate a public EnumIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubEnumTagByEnumIdxKey asPublic(IBusModelProtEnumTagByEnumIdxKey src);

	/**
	 *	Allocate a protected DefSchemaIdx key over protected EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtEnumTagByDefSchemaIdxKey newProtByDefSchemaIdxKey();

	/**
	 *	Allocate a public DefSchemaIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubEnumTagByDefSchemaIdxKey asPublic(IBusModelProtEnumTagByDefSchemaIdxKey src);

	/**
	 *	Allocate a protected EnumNameIdx key over protected EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtEnumTagByEnumNameIdxKey newProtByEnumNameIdxKey();

	/**
	 *	Allocate a public EnumNameIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubEnumTagByEnumNameIdxKey asPublic(IBusModelProtEnumTagByEnumNameIdxKey src);

	/**
	 *	Allocate a protected PrevIdx key over protected EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtEnumTagByPrevIdxKey newProtByPrevIdxKey();

	/**
	 *	Allocate a public PrevIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubEnumTagByPrevIdxKey asPublic(IBusModelProtEnumTagByPrevIdxKey src);

	/**
	 *	Allocate a protected NextIdx key over protected EnumTag instances.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtEnumTagByNextIdxKey newProtByNextIdxKey();

	/**
	 *	Allocate a public NextIdx key from a protected instance.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubEnumTagByNextIdxKey asPublic(IBusModelProtEnumTagByNextIdxKey src);

	/**
	 *	Allocate a protected EnumTag interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtEnumTag newProtRec();

	/**
	 *	Allocate a public EnumTag interface from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubEnumTag asPublic(IBusModelProtEnumTag src);

	/**
	 *	Allocate a protected EnumTag history interface implementation.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelProtEnumTagH newProtHRec();

	/**
	 *	Allocate a public EnumTag history interface implementation from a protected interface.
	 *
	 *	@return	The new instance.
	 */
	public IBusModelPubEnumTagH asPublic(IBusModelProtEnumTagH src);

}
