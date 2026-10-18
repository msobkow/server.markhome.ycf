// Description: Java 25 Instance Edit Object interface for IntNet TableInfo.

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnetobj;

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface IIntNetTableInfoEditObj
	extends IIntNetTableInfoObj, ISecureTableInfoEditObj
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
	ISecureTableInfoObj create();

	/*
	 *	Update the instance.
	 */
	SecureTableInfoEditObj update();

	/**
	 *	Get the ISecureTableInfoObj instance referenced by the SuperRef key.
	 *
	 *	@return	The ISecureTableInfoObj instance referenced by the SuperRef key.
	 */
	ISecureTableInfoObj getOptionalParentSuperRef();

	/**
	 *	Get the optional ISecureTableInfoObj instance referenced by the SuperRef key.
	 *
	 *	@return	The optional ISecureTableInfoObj instance referenced by the SuperRef key.
	 */
	ISecureTableInfoObj getOptionalParentSuperRef( boolean forceRead );

	/**
	 *	Set the ISecureTableInfoObj instance referenced by the SuperRef key.
	 *
	 *	@param	value	the ISecureTableInfoObj instance to be referenced by the SuperRef key.
	 */
	void setOptionalParentSuperRef( ISecureTableInfoObj value );

	/**
	 *	Get a list ISecureTableInfoObj instances referenced by the SubRefs key.
	 *
	 *	@return	The (potentially empty) list of ISecureTableInfoObj instances referenced by the SubRefs key.
	 */
	List<ISecureTableInfoObj> getOptionalChildrenSubRefs();

	public void copyRecToOrig();
	public void copyOrigToRec();

}
