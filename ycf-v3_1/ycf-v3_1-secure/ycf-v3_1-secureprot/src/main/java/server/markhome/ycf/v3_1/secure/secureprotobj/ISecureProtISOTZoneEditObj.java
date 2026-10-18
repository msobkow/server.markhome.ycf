// Description: Java 25 Protected Instance Edit Object interface for Secure ISOTZone.

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

public interface ISecureProtISOTZoneEditObj
	extends ISecureProtISOTZoneObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecureProtISOTZoneObj.
	 */
	ISecureProtISOTZoneObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecureProtISOTZoneObj.
	 */
	ISecureProtISOTZoneObj getOrigAsISOTZone();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecureProtISOTZoneObj create();

	/*
	 *	Update the instance.
	 */
	ISecureProtISOTZoneEditObj update();

	/*
	 *	Delete the instance.
	 */
	ISecureProtISOTZoneEditObj deleteInstance();

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
	 *	Get the required short attribute ISOTZoneId.
	 *
	 *	@return	The required short attribute ISOTZoneId.
	 */
	short getRequiredISOTZoneId();

	/**
	 *	Set the required short attribute ISOTZoneId.
	 *
	 *	@param value The required short attribute ISOTZoneId value to be applied.
	 */
	void setRequiredISOTZoneId(short value);

	/**
	 *	Get the required String attribute Iso8601.
	 *
	 *	@return	The required String attribute Iso8601.
	 */
	String getRequiredIso8601();

	/**
	 *	Set the required String attribute Iso8601.
	 *
	 *	@param value The required String attribute Iso8601 value to be applied.
	 */
	void setRequiredIso8601(String value);

	/**
	 *	Get the required String attribute TZName.
	 *
	 *	@return	The required String attribute TZName.
	 */
	String getRequiredTZName();

	/**
	 *	Set the required String attribute TZName.
	 *
	 *	@param value The required String attribute TZName value to be applied.
	 */
	void setRequiredTZName(String value);

	/**
	 *	Get the required short attribute TZHourOffset.
	 *
	 *	@return	The required short attribute TZHourOffset.
	 */
	short getRequiredTZHourOffset();

	/**
	 *	Set the required short attribute TZHourOffset.
	 *
	 *	@param value The required short attribute TZHourOffset value to be applied.
	 */
	void setRequiredTZHourOffset(short value);

	/**
	 *	Get the required short attribute TZMinOffset.
	 *
	 *	@return	The required short attribute TZMinOffset.
	 */
	short getRequiredTZMinOffset();

	/**
	 *	Set the required short attribute TZMinOffset.
	 *
	 *	@param value The required short attribute TZMinOffset value to be applied.
	 */
	void setRequiredTZMinOffset(short value);

	/**
	 *	Get the required String attribute Description.
	 *
	 *	@return	The required String attribute Description.
	 */
	String getRequiredDescription();

	/**
	 *	Set the required String attribute Description.
	 *
	 *	@param value The required String attribute Description value to be applied.
	 */
	void setRequiredDescription(String value);

	/**
	 *	Get the required boolean attribute Visible.
	 *
	 *	@return	The required boolean attribute Visible.
	 */
	boolean getRequiredVisible();

	/**
	 *	Set the required boolean attribute Visible.
	 *
	 *	@param value The required boolean attribute Visible value to be applied.
	 */
	void setRequiredVisible(boolean value);

	public void copyRecToOrig();
	public void copyOrigToRec();

}
