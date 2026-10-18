// Description: Java 25 Instance Edit Object interface for BusModel SecUser.

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface IBusModelSecUserEditObj
	extends IBusModelSecUserObj, ISecureSecUserEditObj, IIntNetSecUserEditObj
{
	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureSecUserObj create();

	/*
	 *	Update the instance.
	 */
	SecureSecUserEditObj update();

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ISecureSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ISecureSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( LocalDateTime value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ISecureSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ISecureSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( LocalDateTime value );

	/**
	 *	Get a list ISecureSecSessionObj instances referenced by the SecSess key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecSessionObj instances referenced by the SecSess key.
	 */
	List<ISecureSecSessionObj> getOptionalComponentsSecSess();

	/**
	 *	Get a list ISecureSecSessionObj instances referenced by the SecProxy key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecSessionObj instances referenced by the SecProxy key.
	 */
	List<ISecureSecSessionObj> getOptionalChildrenSecProxy();

	/**
	 *	Get the ISecureSecUserPasswordObj instance referenced by the Password key.
	 *
	 *	@return	The ISecureSecUserPasswordObj instance referenced by the Password key.
	 */
	ISecureSecUserPasswordObj getOptionalComponentsPassword();

	/**
	 *	Get the optional ISecureSecUserPasswordObj instance referenced by the Password key.
	 *
	 *	@return	The optional ISecureSecUserPasswordObj instance referenced by the Password key.
	 */
	ISecureSecUserPasswordObj getOptionalComponentsPassword( boolean forceRead );

	/**
	 *	Get the ISecureSecUserEMConfObj instance referenced by the EMConf key.
	 *
	 *	@return	The ISecureSecUserEMConfObj instance referenced by the EMConf key.
	 */
	ISecureSecUserEMConfObj getOptionalComponentsEMConf();

	/**
	 *	Get the optional ISecureSecUserEMConfObj instance referenced by the EMConf key.
	 *
	 *	@return	The optional ISecureSecUserEMConfObj instance referenced by the EMConf key.
	 */
	ISecureSecUserEMConfObj getOptionalComponentsEMConf( boolean forceRead );

	/**
	 *	Get the ISecureSecUserPWResetObj instance referenced by the PWReset key.
	 *
	 *	@return	The ISecureSecUserPWResetObj instance referenced by the PWReset key.
	 */
	ISecureSecUserPWResetObj getOptionalComponentsPWReset();

	/**
	 *	Get the optional ISecureSecUserPWResetObj instance referenced by the PWReset key.
	 *
	 *	@return	The optional ISecureSecUserPWResetObj instance referenced by the PWReset key.
	 */
	ISecureSecUserPWResetObj getOptionalComponentsPWReset( boolean forceRead );

	/**
	 *	Get the ISecureSecUserPWHistoryObj instance referenced by the PWHistory key.
	 *
	 *	@return	The ISecureSecUserPWHistoryObj instance referenced by the PWHistory key.
	 */
	ISecureSecUserPWHistoryObj getOptionalChildrenPWHistory();

	/**
	 *	Get the optional ISecureSecUserPWHistoryObj instance referenced by the PWHistory key.
	 *
	 *	@return	The optional ISecureSecUserPWHistoryObj instance referenced by the PWHistory key.
	 */
	ISecureSecUserPWHistoryObj getOptionalChildrenPWHistory( boolean forceRead );

	/**
	 *	Get a list ISecureSecSysGrpMembObj instances referenced by the SysSecGrpMemb key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecSysGrpMembObj instances referenced by the SysSecGrpMemb key.
	 */
	List<ISecureSecSysGrpMembObj> getOptionalChildrenSysSecGrpMemb();

	/**
	 *	Get a list ISecureSecClusGrpMembObj instances referenced by the ClusSecGrpMemb key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecClusGrpMembObj instances referenced by the ClusSecGrpMemb key.
	 */
	List<ISecureSecClusGrpMembObj> getOptionalChildrenClusSecGrpMemb();

	/**
	 *	Get a list ISecureSecTentGrpMembObj instances referenced by the TentSecGrpMemb key.
	 *
	 *	@return	The (potentially empty) list of ISecureSecTentGrpMembObj instances referenced by the TentSecGrpMemb key.
	 */
	List<ISecureSecTentGrpMembObj> getOptionalChildrenTentSecGrpMemb();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
