// Description: Java 25 Protected Instance Edit Object interface for Secure ISOCtryLang.

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

public interface ISecureProtISOCtryLangEditObj
	extends ISecureProtISOCtryLangObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecureProtISOCtryLangObj.
	 */
	ISecureProtISOCtryLangObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecureProtISOCtryLangObj.
	 */
	ISecureProtISOCtryLangObj getOrigAsISOCtryLang();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureProtISOCtryLangObj create();

	/*
	 *	Update the instance.
	 */
	ISecureProtISOCtryLangEditObj update();

	/*
	 *	Delete the instance.
	 */
	ISecureProtISOCtryLangEditObj deleteInstance();

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
	 *	Get the ISecureProtISOCtryObj instance referenced by the Ctry key.
	 *
	 *	@return	The ISecureProtISOCtryObj instance referenced by the Ctry key.
	 */
	ISecureProtISOCtryObj getRequiredContainerCtry();

	/**
	 *	Get the required ISecureProtISOCtryObj instance referenced by the Ctry key.
	 *
	 *	@return	The required ISecureProtISOCtryObj instance referenced by the Ctry key.
	 */
	ISecureProtISOCtryObj getRequiredContainerCtry( boolean forceRead );

	/**
	 *	Set the ISecureProtISOCtryObj instance referenced by the Ctry key.
	 *
	 *	@param	value	the ISecureProtISOCtryObj instance to be referenced by the Ctry key.
	 */
	void setRequiredContainerCtry( ISecureProtISOCtryObj value );

	/**
	 *	Get the ISecureProtISOLangObj instance referenced by the Lang key.
	 *
	 *	@return	The ISecureProtISOLangObj instance referenced by the Lang key.
	 */
	ISecureProtISOLangObj getRequiredParentLang();

	/**
	 *	Get the required ISecureProtISOLangObj instance referenced by the Lang key.
	 *
	 *	@return	The required ISecureProtISOLangObj instance referenced by the Lang key.
	 */
	ISecureProtISOLangObj getRequiredParentLang( boolean forceRead );

	/**
	 *	Set the ISecureProtISOLangObj instance referenced by the Lang key.
	 *
	 *	@param	value	the ISecureProtISOLangObj instance to be referenced by the Lang key.
	 */
	void setRequiredParentLang( ISecureProtISOLangObj value );

	/**
	 *	Get the required short attribute ISOCtryId.
	 *
	 *	@return	The required short attribute ISOCtryId.
	 */
	short getRequiredISOCtryId();

	/**
	 *	Get the required short attribute ISOLangId.
	 *
	 *	@return	The required short attribute ISOLangId.
	 */
	short getRequiredISOLangId();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
