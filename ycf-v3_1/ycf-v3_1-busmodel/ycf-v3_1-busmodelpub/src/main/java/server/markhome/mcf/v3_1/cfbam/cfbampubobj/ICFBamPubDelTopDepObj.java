// Description: Java 25 Object interface for CFBamPub DelTopDep.

/*
 *	server.markhome.mcf.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal CFBam 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
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
 *	Mark's Code Fractal CFBam is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFBam is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Mark's Code Fractal CFBam.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.mcf.v3_1.cfbam.cfbampubobj;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfbam.cfbampub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;

public interface ICFBamPubDelTopDepObj
	extends ICFBamPubDelDepObj
{
	/**
	 *	Move this object up in the chain and refresh the cache.
	 *
	 *	@return	ICFBamPubDelTopDepObj the reference to the moved and refreshed instance.
	 */
	ICFBamPubDelTopDepObj moveUp();

	/**
	 *	Move this object down in the chain and refresh the cache.
	 *
	 *	@return	ICFBamPubDelTopDepObj the reference to the moved and refreshed instance.
	 */
	ICFBamPubDelTopDepObj moveDown();

	/**
	 *	Get the current edition of this DelTopDep instance as a ICFBamPubDelTopDepEditObj.
	 *
	 *	@return	The ICFBamPubDelTopDepEditObj edition of this instance.
	 */
	ICFBamPubDelTopDepEditObj getEditAsDelTopDep();

	/**
	 *	Get the ICFBamPubDelTopDepTableObj table cache which manages this instance.
	 *
	 *	@return	ICFBamPubDelTopDepTableObj table cache which manages this instance.
	 */
	ICFBamPubDelTopDepTableObj getDelTopDepTable();

	/**
	 *	Get the ICFBamPubDelTopDep instance which currently backs this instance.
	 *	<p>
	 *	This value <i>will</i> change for read-only instances, so you should
	 *	not hold on to the value as a reference anywhere outside the current call stack.
	 *
	 *	@return	ICFBamPubDelTopDep instance which currently backs this object.
	 */
	ICFBamPubDelTopDep getDelTopDepRec();

	/**
	 *	Get the required ICFBamPubTableObj instance referenced by the Table key.
	 *
	 *	@return	The required ICFBamPubTableObj instance referenced by the Table key.
	 */
	ICFBamPubTableObj getRequiredContainerTable();

	/**
	 *	Get the required ICFBamPubTableObj instance referenced by the Table key.
	 *
	 *	@return	The required ICFBamPubTableObj instance referenced by the Table key.
	 */
	ICFBamPubTableObj getRequiredContainerTable( boolean forceRead );

	/**
	 *	Get the array of optional ICFBamPubDelSubDep1Obj array of instances referenced by the DelDep key.
	 *
	 *	@return	The optional ICFBamPubDelSubDep1Obj[] array of instances referenced by the DelDep key.
	 */
	List<ICFBamPubDelSubDep1Obj> getOptionalComponentsDelDep();

	/**
	 *	Get the array of optional ICFBamPubDelSubDep1Obj array of instances referenced by the DelDep key.
	 *
	 *	@return	The optional ICFBamPubDelSubDep1Obj[] array of instances referenced by the DelDep key.
	 */
	List<ICFBamPubDelSubDep1Obj> getOptionalComponentsDelDep( boolean forceRead );

	/**
	 *	Get the optional ICFBamPubDelTopDepObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamPubDelTopDepObj instance referenced by the Prev key.
	 */
	ICFBamPubDelTopDepObj getOptionalLookupPrev();

	/**
	 *	Get the optional ICFBamPubDelTopDepObj instance referenced by the Prev key.
	 *
	 *	@return	The optional ICFBamPubDelTopDepObj instance referenced by the Prev key.
	 */
	ICFBamPubDelTopDepObj getOptionalLookupPrev( boolean forceRead );

	/**
	 *	Get the optional ICFBamPubDelTopDepObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamPubDelTopDepObj instance referenced by the Next key.
	 */
	ICFBamPubDelTopDepObj getOptionalLookupNext();

	/**
	 *	Get the optional ICFBamPubDelTopDepObj instance referenced by the Next key.
	 *
	 *	@return	The optional ICFBamPubDelTopDepObj instance referenced by the Next key.
	 */
	ICFBamPubDelTopDepObj getOptionalLookupNext( boolean forceRead );

	/**
	 *	Get the required MCFDbKeyHash256 attribute Id.
	 *
	 *	@return	The required MCFDbKeyHash256 attribute Id.
	 */
	MCFDbKeyHash256 getRequiredId();

	/**
	 *	Get the required String attribute Name.
	 *
	 *	@return	The required String attribute Name.
	 */
	String getRequiredName();

	/**
	 *	Get the required MCFDbKeyHash256 attribute TableId.
	 *
	 *	@return	The required MCFDbKeyHash256 attribute TableId.
	 */
	MCFDbKeyHash256 getRequiredTableId();

	/**
	 *	Get the optional MCFDbKeyHash256 attribute PrevId.
	 *
	 *	@return	The optional MCFDbKeyHash256 attribute PrevId.
	 */
	MCFDbKeyHash256 getOptionalPrevId();

	/**
	 *	Get the optional MCFDbKeyHash256 attribute NextId.
	 *
	 *	@return	The optional MCFDbKeyHash256 attribute NextId.
	 */
	MCFDbKeyHash256 getOptionalNextId();

}
