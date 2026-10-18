// Description: Java 25 Instance Edit Object interface for BusModel ClearTopDep.

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

package server.markhome.ycf.v3_1.busmodel.busmodelobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpub.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprot.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelpubobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelprotobj.*;

public interface IBusModelClearTopDepEditObj
	extends IBusModelClearTopDepObj, IBusModelClearDepEditObj
{
	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a IBusModelClearTopDepObj.
	 */
	IBusModelClearTopDepObj getOrigAsClearTopDep();

	/**
	 *	Get the IBusModelTableObj instance referenced by the Table key.
	 *
	 *	@return	The IBusModelTableObj instance referenced by the Table key.
	 */
	IBusModelTableObj getRequiredContainerTable();

	/**
	 *	Get the required IBusModelTableObj instance referenced by the Table key.
	 *
	 *	@return	The required IBusModelTableObj instance referenced by the Table key.
	 */
	IBusModelTableObj getRequiredContainerTable( boolean forceRead );

	/**
	 *	Set the IBusModelTableObj instance referenced by the Table key.
	 *
	 *	@param	value	the IBusModelTableObj instance to be referenced by the Table key.
	 */
	void setRequiredContainerTable( IBusModelTableObj value );

	/**
	 *	Get a list IBusModelClearSubDep1Obj instances referenced by the ClearDep key.
	 *
	 *	@return	The (potentially empty) list of IBusModelClearSubDep1Obj instances referenced by the ClearDep key.
	 */
	List<IBusModelClearSubDep1Obj> getOptionalComponentsClearDep();

	/**
	 *	Get the IBusModelClearTopDepObj instance referenced by the Prev key.
	 *
	 *	@return	The IBusModelClearTopDepObj instance referenced by the Prev key.
	 */
	IBusModelClearTopDepObj getOptionalLookupPrev();

	/**
	 *	Get the optional IBusModelClearTopDepObj instance referenced by the Prev key.
	 *
	 *	@return	The optional IBusModelClearTopDepObj instance referenced by the Prev key.
	 */
	IBusModelClearTopDepObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Set the IBusModelClearTopDepObj instance referenced by the Prev key.
	 *
	 *	@param	value	the IBusModelClearTopDepObj instance to be referenced by the Prev key.
	 */
	void setOptionalLookupPrev( IBusModelClearTopDepObj value );

	/**
	 *	Get the IBusModelClearTopDepObj instance referenced by the Next key.
	 *
	 *	@return	The IBusModelClearTopDepObj instance referenced by the Next key.
	 */
	IBusModelClearTopDepObj getOptionalLookupNext();

	/**
	 *	Get the optional IBusModelClearTopDepObj instance referenced by the Next key.
	 *
	 *	@return	The optional IBusModelClearTopDepObj instance referenced by the Next key.
	 */
	IBusModelClearTopDepObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Set the IBusModelClearTopDepObj instance referenced by the Next key.
	 *
	 *	@param	value	the IBusModelClearTopDepObj instance to be referenced by the Next key.
	 */
	void setOptionalLookupNext( IBusModelClearTopDepObj value );

	/**
	 *	Get the required IYCFKeyHash256 attribute TableId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute TableId.
	 */
	IYCFKeyHash256 getRequiredTableId();

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
	 *	Get the optional IYCFKeyHash256 attribute PrevId.
	 *
	 *	@return	The optional IYCFKeyHash256 attribute PrevId.
	 */
	IYCFKeyHash256 getOptionalPrevId();

	/**
	 *	Get the optional IYCFKeyHash256 attribute NextId.
	 *
	 *	@return	The optional IYCFKeyHash256 attribute NextId.
	 */
	IYCFKeyHash256 getOptionalNextId();

}
