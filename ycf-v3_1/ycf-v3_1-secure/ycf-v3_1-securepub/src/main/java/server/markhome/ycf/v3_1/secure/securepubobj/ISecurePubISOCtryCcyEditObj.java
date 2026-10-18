// Description: Java 25 Public Instance Edit Object interface for Secure ISOCtryCcy.

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

package server.markhome.ycf.v3_1.secure.securepubobj;

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

public interface ISecurePubISOCtryCcyEditObj
	extends ISecurePubISOCtryCcyObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecurePubISOCtryCcyObj.
	 */
	ISecurePubISOCtryCcyObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecurePubISOCtryCcyObj.
	 */
	ISecurePubISOCtryCcyObj getOrigAsISOCtryCcy();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecurePubISOCtryCcyObj create();

	/*
	 *	Update the instance.
	 */
	ISecurePubISOCtryCcyEditObj update();

	/*
	 *	Delete the instance.
	 */
	ISecurePubISOCtryCcyEditObj deleteInstance();

	/**
	 *	Set the user who created this instance.
	 *
	 *	@param	value	The ISecurePubSecUserObj instance who created this instance.
	 */
	void setCreatedBy( ISecurePubSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was created.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setCreatedAt( LocalDateTime value );

	/**
	 *	Set the user who updated this instance.
	 *
	 *	@param	value	The ISecurePubSecUserObj instance who updated this instance.
	 */
	void setUpdatedBy( ISecurePubSecUserObj value );

	/**
	 *	Set the Calendar date-time this instance was updated.
	 *
	 *	@param	value	The Calendar value for the create time of the instance.
	 */
	void setUpdatedAt( LocalDateTime value );

	/**
	 *	Get the ISecurePubISOCtryObj instance referenced by the Ctry key.
	 *
	 *	@return	The ISecurePubISOCtryObj instance referenced by the Ctry key.
	 */
	ISecurePubISOCtryObj getRequiredContainerCtry();

	/**
	 *	Get the required ISecurePubISOCtryObj instance referenced by the Ctry key.
	 *
	 *	@return	The required ISecurePubISOCtryObj instance referenced by the Ctry key.
	 */
	ISecurePubISOCtryObj getRequiredContainerCtry( boolean forceRead );

	/**
	 *	Set the ISecurePubISOCtryObj instance referenced by the Ctry key.
	 *
	 *	@param	value	the ISecurePubISOCtryObj instance to be referenced by the Ctry key.
	 */
	void setRequiredContainerCtry( ISecurePubISOCtryObj value );

	/**
	 *	Get the ISecurePubISOCcyObj instance referenced by the Ccy key.
	 *
	 *	@return	The ISecurePubISOCcyObj instance referenced by the Ccy key.
	 */
	ISecurePubISOCcyObj getRequiredParentCcy();

	/**
	 *	Get the required ISecurePubISOCcyObj instance referenced by the Ccy key.
	 *
	 *	@return	The required ISecurePubISOCcyObj instance referenced by the Ccy key.
	 */
	ISecurePubISOCcyObj getRequiredParentCcy( boolean forceRead );

	/**
	 *	Set the ISecurePubISOCcyObj instance referenced by the Ccy key.
	 *
	 *	@param	value	the ISecurePubISOCcyObj instance to be referenced by the Ccy key.
	 */
	void setRequiredParentCcy( ISecurePubISOCcyObj value );

	/**
	 *	Get the required short attribute ISOCtryId.
	 *
	 *	@return	The required short attribute ISOCtryId.
	 */
	short getRequiredISOCtryId();

	/**
	 *	Get the required short attribute ISOCcyId.
	 *
	 *	@return	The required short attribute ISOCcyId.
	 */
	short getRequiredISOCcyId();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
