// Description: Java 25 Public Instance Edit Object interface for Secure SecSession.

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

public interface ISecurePubSecSessionEditObj
	extends ISecurePubSecSessionObj
{
	/*
	 *	Get the original for this edition as the base type for the class hierarchy.
	 *
	 *	@return The original, non-modifiable instance as a base ISecurePubSecSessionObj.
	 */
	ISecurePubSecSessionObj getOrig();

	/*
	 *	Get the original for this edition cast as the specified type.
	 *
	 *	@return The original, non-modifiable instance cast to a ISecurePubSecSessionObj.
	 */
	ISecurePubSecSessionObj getOrigAsSecSession();

	/*
	 *	create() may return a different instance than the
	 *	one used to invoke the operation.  All future references
	 *	should be to the returned instance, not the original
	 *	invoker.  You should lose all references to the original
	 *	invoker.
	 *
	 *	@return The created instance.
	 */
	ISecurePubSecSessionObj create();

	/*
	 *	Update the instance.
	 */
	ISecurePubSecSessionEditObj update();

	/*
	 *	Delete the instance.
	 */
	ISecurePubSecSessionEditObj deleteInstance();

	/**
	 *	Get the ISecurePubSecUserObj instance referenced by the SecUser key.
	 *
	 *	@return	The ISecurePubSecUserObj instance referenced by the SecUser key.
	 */
	ISecurePubSecUserObj getRequiredContainerSecUser();

	/**
	 *	Get the required ISecurePubSecUserObj instance referenced by the SecUser key.
	 *
	 *	@return	The required ISecurePubSecUserObj instance referenced by the SecUser key.
	 */
	ISecurePubSecUserObj getRequiredContainerSecUser( boolean forceRead );

	/**
	 *	Set the ISecurePubSecUserObj instance referenced by the SecUser key.
	 *
	 *	@param	value	the ISecurePubSecUserObj instance to be referenced by the SecUser key.
	 */
	void setRequiredContainerSecUser( ISecurePubSecUserObj value );

	/**
	 *	Get the required YCFDbKeyHash256 attribute SecSessionId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute SecSessionId.
	 */
	YCFDbKeyHash256 getRequiredSecSessionId();

	/**
	 *	Set the required YCFDbKeyHash256 attribute SecSessionId.
	 *
	 *	@param value The required YCFDbKeyHash256 attribute SecSessionId value to be applied.
	 */
	void setRequiredSecSessionId(YCFDbKeyHash256 value);

	/**
	 *	Get the required YCFDbKeyHash256 attribute SecUserId.
	 *
	 *	@return	The required YCFDbKeyHash256 attribute SecUserId.
	 */
	YCFDbKeyHash256 getRequiredSecUserId();

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

	public void copyRecToOrig();
	public void copyOrigToRec();

}
