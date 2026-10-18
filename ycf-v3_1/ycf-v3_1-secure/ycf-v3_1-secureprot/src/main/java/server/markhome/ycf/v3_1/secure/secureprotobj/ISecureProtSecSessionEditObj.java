// Description: Java 25 Protected Instance Edit Object interface for Secure SecSession.

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

public interface ISecureProtSecSessionEditObj
	extends ISecureProtSecSessionObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecureProtSecSessionObj.
	 */
	ISecureProtSecSessionObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecureProtSecSessionObj.
	 */
	ISecureProtSecSessionObj getOrigAsSecSession();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureProtSecSessionObj create();

	/*
	 *	Update the instance.
	 */
	ISecureProtSecSessionEditObj update();

	/*
	 *	Delete the instance.
	 */
	ISecureProtSecSessionEditObj deleteInstance();

	/**
	 *	Get the ISecureProtSecUserObj instance referenced by the SecUser key.
	 *
	 *	@return	The ISecureProtSecUserObj instance referenced by the SecUser key.
	 */
	ISecureProtSecUserObj getRequiredContainerSecUser();

	/**
	 *	Get the required ISecureProtSecUserObj instance referenced by the SecUser key.
	 *
	 *	@return	The required ISecureProtSecUserObj instance referenced by the SecUser key.
	 */
	ISecureProtSecUserObj getRequiredContainerSecUser( boolean forceRead );

	/**
	 *	Set the ISecureProtSecUserObj instance referenced by the SecUser key.
	 *
	 *	@param	value	the ISecureProtSecUserObj instance to be referenced by the SecUser key.
	 */
	void setRequiredContainerSecUser( ISecureProtSecUserObj value );

	/**
	 *	Get the ISecureProtSecUserObj instance referenced by the SecProxy key.
	 *
	 *	@return	The ISecureProtSecUserObj instance referenced by the SecProxy key.
	 */
	ISecureProtSecUserObj getRequiredParentSecProxy();

	/**
	 *	Get the required ISecureProtSecUserObj instance referenced by the SecProxy key.
	 *
	 *	@return	The required ISecureProtSecUserObj instance referenced by the SecProxy key.
	 */
	ISecureProtSecUserObj getRequiredParentSecProxy( boolean forceRead );

	/**
	 *	Set the ISecureProtSecUserObj instance referenced by the SecProxy key.
	 *
	 *	@param	value	the ISecureProtSecUserObj instance to be referenced by the SecProxy key.
	 */
	void setRequiredParentSecProxy( ISecureProtSecUserObj value );

	/**
	 *	Get the required IYCFKeyHash256 attribute SecSessionId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecSessionId.
	 */
	IYCFKeyHash256 getRequiredSecSessionId();

	/**
	 *	Set the required IYCFKeyHash256 attribute SecSessionId.
	 *
	 *	@param value The required IYCFKeyHash256 attribute SecSessionId value to be applied.
	 */
	void setRequiredSecSessionId(IYCFKeyHash256 value);

	/**
	 *	Get the required IYCFKeyHash256 attribute SecUserId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecUserId.
	 */
	IYCFKeyHash256 getRequiredSecUserId();

	/**
	 *	Get the required LocalDateTime attribute Start.
	 *
	 *	@return	The required LocalDateTime attribute Start.
	 */
	LocalDateTime getRequiredStart();

	/**
	 *	Set the required LocalDateTime attribute Start.
	 *
	 *	@param value The required LocalDateTime attribute Start value to be applied.
	 */
	void setRequiredStart(LocalDateTime value);

	/**
	 *	Get the optional LocalDateTime attribute Finish.
	 *
	 *	@return	The optional LocalDateTime attribute Finish.
	 */
	LocalDateTime getOptionalFinish();

	/**
	 *	Set the optional LocalDateTime attribute Finish.
	 *
	 *	@param value The optional LocalDateTime attribute Finish value to be applied.
	 */
	void setOptionalFinish(LocalDateTime value);

	/**
	 *	Get the optional YCFDbKeyHash256 attribute SecProxyId.
	 *
	 *	@return	The optional YCFDbKeyHash256 attribute SecProxyId.
	 */
	YCFDbKeyHash256 getOptionalSecProxyId();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
