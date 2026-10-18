// Description: Java 25 Instance Edit Object interface for Secure SecUserPassword.

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

public interface ISecureSecUserPasswordEditObj
	extends ISecureSecUserPasswordObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecureSecUserPasswordObj.
	 */
	ISecureSecUserPasswordObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecureSecUserPasswordObj.
	 */
	ISecureSecUserPasswordObj getOrigAsSecUserPassword();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureSecUserPasswordObj create();

	/*
	 *	Update the instance.
	 */
	SecureSecUserPasswordEditObj update();

	/*
	 *	Delete the instance.
	 */
	SecureSecUserPasswordEditObj deleteInstance();

	/**
	 *	Get the ISecureSecUserObj instance referenced by the User key.
	 *
	 *	@return	The ISecureSecUserObj instance referenced by the User key.
	 */
	ISecureSecUserObj getRequiredContainerUser();

	/**
	 *	Get the required ISecureSecUserObj instance referenced by the User key.
	 *
	 *	@return	The required ISecureSecUserObj instance referenced by the User key.
	 */
	ISecureSecUserObj getRequiredContainerUser( boolean forceRead );

	/**
	 *	Set the ISecureSecUserObj instance referenced by the User key.
	 *
	 *	@param	value	the ISecureSecUserObj instance to be referenced by the User key.
	 */
	void setRequiredContainerUser( ISecureSecUserObj value );

	/**
	 *	Get the required IYCFKeyHash256 attribute SecUserId.
	 *
	 *	@return	The required IYCFKeyHash256 attribute SecUserId.
	 */
	IYCFKeyHash256 getRequiredSecUserId();

	/**
	 *	Get the required LocalDateTime attribute PWSetStamp.
	 *
	 *	@return	The required LocalDateTime attribute PWSetStamp.
	 */
	LocalDateTime getRequiredPWSetStamp();

	/**
	 *	Set the required LocalDateTime attribute PWSetStamp.
	 *
	 *	@param value The required LocalDateTime attribute PWSetStamp value to be applied.
	 */
	void setRequiredPWSetStamp(LocalDateTime value);

	/**
	 *	Get the required String attribute PasswordHash.
	 *
	 *	@return	The required String attribute PasswordHash.
	 */
	String getRequiredPasswordHash();

	/**
	 *	Set the required String attribute PasswordHash.
	 *
	 *	@param value The required String attribute PasswordHash value to be applied.
	 */
	void setRequiredPasswordHash(String value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
