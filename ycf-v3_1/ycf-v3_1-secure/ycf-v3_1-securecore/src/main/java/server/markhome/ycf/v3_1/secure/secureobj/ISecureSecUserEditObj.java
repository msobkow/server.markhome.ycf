// Description: Java 25 Instance Edit Object interface for Secure SecUser.

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

package server.markhome.ycf.v3_1.secure.secureobj;

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
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

public interface ISecureSecUserEditObj
	extends ISecureSecUserObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecureSecUserObj.
	 */
	ISecureSecUserObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecureSecUserObj.
	 */
	ISecureSecUserObj getOrigAsSecUser();

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

	/*
	 *	Delete the instance.
	 */
	SecureSecUserEditObj deleteInstance();

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
