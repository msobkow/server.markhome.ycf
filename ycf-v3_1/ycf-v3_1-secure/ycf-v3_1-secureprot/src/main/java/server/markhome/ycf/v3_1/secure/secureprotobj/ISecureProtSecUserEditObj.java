// Description: Java 25 Protected Instance Edit Object interface for Secure SecUser.

/*
 *	server.markhome.ycf.Secure
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 Secure - Security Services
 *	
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow mark.sobkow@gmail.com
 *	
 *	These files are part of Yorkton Code Fractal Secure.
 *	
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *	
 *	http://www.apache.org/licenses/LICENSE-2.0
 *	
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *	
 */

package server.markhome.ycf.v3_1.secure.secureprotobj;

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
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface ISecureProtSecUserEditObj
	extends ISecureProtSecUserObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecureProtSecUserObj.
	 */
	ISecureProtSecUserObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecureProtSecUserObj.
	 */
	ISecureProtSecUserObj getOrigAsSecUser();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureProtSecUserObj create();

	/*
	 *	Update the instance.
	 */
	ISecureProtSecUserEditObj update();

	/*
	 *	Delete the instance.
	 */
	ISecureProtSecUserEditObj deleteInstance();

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ISecureProtSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ISecureProtSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( LocalDateTime value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ISecureProtSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ISecureProtSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( LocalDateTime value );

	/**
	 *	Get a list ISecureProtSecSessionObj instances referenced by the SecSess key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecSessionObj instances referenced by the SecSess key.
	 */
	List<ISecureProtSecSessionObj> getOptionalComponentsSecSess();

	/**
	 *	Get a list ISecureProtSecSessionObj instances referenced by the SecProxy key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecSessionObj instances referenced by the SecProxy key.
	 */
	List<ISecureProtSecSessionObj> getOptionalChildrenSecProxy();

	/**
	 *	Get the ISecureProtSecUserEMConfObj instance referenced by the EMConf key.
	 *
	 *	@return	The ISecureProtSecUserEMConfObj instance referenced by the EMConf key.
	 */
	ISecureProtSecUserEMConfObj getOptionalComponentsEMConf();

	/**
	 *	Get the optional ISecureProtSecUserEMConfObj instance referenced by the EMConf key.
	 *
	 *	@return	The optional ISecureProtSecUserEMConfObj instance referenced by the EMConf key.
	 */
	ISecureProtSecUserEMConfObj getOptionalComponentsEMConf( boolean forceRead );

	/**
	 *	Get the ISecureProtSecUserPWResetObj instance referenced by the PWReset key.
	 *
	 *	@return	The ISecureProtSecUserPWResetObj instance referenced by the PWReset key.
	 */
	ISecureProtSecUserPWResetObj getOptionalComponentsPWReset();

	/**
	 *	Get the optional ISecureProtSecUserPWResetObj instance referenced by the PWReset key.
	 *
	 *	@return	The optional ISecureProtSecUserPWResetObj instance referenced by the PWReset key.
	 */
	ISecureProtSecUserPWResetObj getOptionalComponentsPWReset( boolean forceRead );

	/**
	 *	Get a list ISecureProtSecSysGrpMembObj instances referenced by the SysSecGrpMemb key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecSysGrpMembObj instances referenced by the SysSecGrpMemb key.
	 */
	List<ISecureProtSecSysGrpMembObj> getOptionalChildrenSysSecGrpMemb();

	/**
	 *	Get a list ISecureProtSecClusGrpMembObj instances referenced by the ClusSecGrpMemb key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecClusGrpMembObj instances referenced by the ClusSecGrpMemb key.
	 */
	List<ISecureProtSecClusGrpMembObj> getOptionalChildrenClusSecGrpMemb();

	/**
	 *	Get a list ISecureProtSecTentGrpMembObj instances referenced by the TentSecGrpMemb key.
	 *
	 *	@return	The (potentially empty) list of ISecureProtSecTentGrpMembObj instances referenced by the TentSecGrpMemb key.
	 */
	List<ISecureProtSecTentGrpMembObj> getOptionalChildrenTentSecGrpMemb();

	/**
	 *	Get the required IYCFKeyHash256 attribute SecUserId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecUserId.
	 */
	IYCFKeyHash256 getRequiredSecUserId();

	/**
	 *	Set the required IYCFKeyHash256 attribute SecUserId.
	 *
	 *	@param value The required IYCFKeyHash256 attribute SecUserId value to be applied.
	 */
	void setRequiredSecUserId(IYCFKeyHash256 value);

	/**
	 *	Get the required String attribute LoginId.
	 *
	 *	@return	The required String attribute LoginId.
	 */
	String getRequiredLoginId();

	/**
	 *	Set the required String attribute LoginId.
	 *
	 *	@param value The required String attribute LoginId value to be applied.
	 */
	void setRequiredLoginId(String value);

	/**
	 *	Get the required ISecurePubSchema.SecAccountStatusEnum attribute AccountStatus.
	 *
	 *	@return	The required ISecurePubSchema.SecAccountStatusEnum attribute AccountStatus.
	 */
	ISecurePubSchema.SecAccountStatusEnum getRequiredAccountStatus();

	/**
	 *	Set the required ISecurePubSchema.SecAccountStatusEnum attribute AccountStatus.
	 *
	 *	@param value The required ISecurePubSchema.SecAccountStatusEnum attribute AccountStatus value to be applied.
	 */
	void setRequiredAccountStatus(ISecurePubSchema.SecAccountStatusEnum value);

	/**
	 *	Get the optional String attribute DfltSysGrpName.
	 *
	 *	@return	The optional String attribute DfltSysGrpName.
	 */
	String getOptionalDfltSysGrpName();

	/**
	 *	Set the optional String attribute DfltSysGrpName.
	 *
	 *	@param value The optional String attribute DfltSysGrpName value to be applied.
	 */
	void setOptionalDfltSysGrpName(String value);

	/**
	 *	Get the optional String attribute DfltClusGrpName.
	 *
	 *	@return	The optional String attribute DfltClusGrpName.
	 */
	String getOptionalDfltClusGrpName();

	/**
	 *	Set the optional String attribute DfltClusGrpName.
	 *
	 *	@param value The optional String attribute DfltClusGrpName value to be applied.
	 */
	void setOptionalDfltClusGrpName(String value);

	/**
	 *	Get the optional String attribute DfltTentGrpName.
	 *
	 *	@return	The optional String attribute DfltTentGrpName.
	 */
	String getOptionalDfltTentGrpName();

	/**
	 *	Set the optional String attribute DfltTentGrpName.
	 *
	 *	@param value The optional String attribute DfltTentGrpName value to be applied.
	 */
	void setOptionalDfltTentGrpName(String value);

	/**
	 *	Get the required String attribute EMailAddress.
	 *
	 *	@return	The required String attribute EMailAddress.
	 */
	String getRequiredEMailAddress();

	/**
	 *	Set the required String attribute EMailAddress.
	 *
	 *	@param value The required String attribute EMailAddress value to be applied.
	 */
	void setRequiredEMailAddress(String value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
