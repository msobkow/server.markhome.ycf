// Description: Java 25 Protected Instance Edit Object interface for BusModel DelTopDep.

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

package server.markhome.ycf.v3_1.busmodel.busmodelprotobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;

public interface IBusModelProtDelTopDepEditObj
	extends IBusModelProtDelTopDepObj, IBusModelProtDelDepEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a IBusModelProtDelTopDepObj.
	 */
	IBusModelProtDelTopDepObj getOrigAsDelTopDep();

	/**
	 *	Get the IBusModelProtTableObj instance referenced by the Table key.
	 *
	 *	@return	The IBusModelProtTableObj instance referenced by the Table key.
	 */
	IBusModelProtTableObj getRequiredContainerTable();

	/**
	 *	Get the required IBusModelProtTableObj instance referenced by the Table key.
	 *
	 *	@return	The required IBusModelProtTableObj instance referenced by the Table key.
	 */
	IBusModelProtTableObj getRequiredContainerTable( boolean forceRead );

	/**
	 *	Set the IBusModelProtTableObj instance referenced by the Table key.
	 *
	 *	@param	value	the IBusModelProtTableObj instance to be referenced by the Table key.
	 */
	void setRequiredContainerTable( IBusModelProtTableObj value );

	/**
	 *	Get a list IBusModelProtDelSubDep1Obj instances referenced by the DelDep key.
	 *
	 *	@return	The (potentially empty) list of IBusModelProtDelSubDep1Obj instances referenced by the DelDep key.
	 */
	List<IBusModelProtDelSubDep1Obj> getOptionalComponentsDelDep();

	/**
	 *	Get the IBusModelProtDelTopDepObj instance referenced by the Prev key.
	 *
	 *	@return	The IBusModelProtDelTopDepObj instance referenced by the Prev key.
	 */
	IBusModelProtDelTopDepObj getOptionalLookupPrev();

	/**
	 *	Get the optional IBusModelProtDelTopDepObj instance referenced by the Prev key.
	 *
	 *	@return	The optional IBusModelProtDelTopDepObj instance referenced by the Prev key.
	 */
	IBusModelProtDelTopDepObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Set the IBusModelProtDelTopDepObj instance referenced by the Prev key.
	 *
	 *	@param	value	the IBusModelProtDelTopDepObj instance to be referenced by the Prev key.
	 */
	void setOptionalLookupPrev( IBusModelProtDelTopDepObj value );

	/**
	 *	Get the IBusModelProtDelTopDepObj instance referenced by the Next key.
	 *
	 *	@return	The IBusModelProtDelTopDepObj instance referenced by the Next key.
	 */
	IBusModelProtDelTopDepObj getOptionalLookupNext();

	/**
	 *	Get the optional IBusModelProtDelTopDepObj instance referenced by the Next key.
	 *
	 *	@return	The optional IBusModelProtDelTopDepObj instance referenced by the Next key.
	 */
	IBusModelProtDelTopDepObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Set the IBusModelProtDelTopDepObj instance referenced by the Next key.
	 *
	 *	@param	value	the IBusModelProtDelTopDepObj instance to be referenced by the Next key.
	 */
	void setOptionalLookupNext( IBusModelProtDelTopDepObj value );

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Set the required String attribute Name.
	 *
	 *	@param value The required String attribute Name value to be applied.
	 */
	void setRequiredName(String value);

	/**
	 *	Get the required IYCFKeyHash256 attribute TableId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute TableId.
	 */
	IYCFKeyHash256 getRequiredTableId();

	/**
	 *	Get the optional YCFDbKeyHash256 attribute PrevId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute PrevId.
	 */
	YCFDbKeyHash256 getOptionalPrevId();

	/**
	 *	Get the optional YCFDbKeyHash256 attribute NextId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute NextId.
	 */
	YCFDbKeyHash256 getOptionalNextId();

}
