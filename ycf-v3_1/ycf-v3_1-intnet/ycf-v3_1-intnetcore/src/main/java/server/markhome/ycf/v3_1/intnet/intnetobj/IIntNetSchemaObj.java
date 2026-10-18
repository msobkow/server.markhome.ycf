// Description: Java 25 Schema Object interface for IntNet.

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
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.intnet.intnetprot.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;

public interface IIntNetSchemaObj
	extends ISecureSchemaObj
{
	public ISecureSchema getSecureBackingStore();
	public void setSecureBackingStore(ISecureSchema secureBackingStore);

	public IIntNetSchema getIntNetBackingStore();
	public void setIntNetBackingStore(IIntNetSchema intnetBackingStore);

	/**
	 *	Get the License interface for the schema.
	 *
	 *	@return	The IIntNetLicenseTableObj interface implementation for the schema.
	 */
	IIntNetLicenseTableObj getLicenseTableObj();

	/**
	 *	Get the MajorVersion interface for the schema.
	 *
	 *	@return	The IIntNetMajorVersionTableObj interface implementation for the schema.
	 */
	IIntNetMajorVersionTableObj getMajorVersionTableObj();

	/**
	 *	Get the MimeType interface for the schema.
	 *
	 *	@return	The IIntNetMimeTypeTableObj interface implementation for the schema.
	 */
	IIntNetMimeTypeTableObj getMimeTypeTableObj();

	/**
	 *	Get the MinorVersion interface for the schema.
	 *
	 *	@return	The IIntNetMinorVersionTableObj interface implementation for the schema.
	 */
	IIntNetMinorVersionTableObj getMinorVersionTableObj();

	/**
	 *	Get the SubProject interface for the schema.
	 *
	 *	@return	The IIntNetSubProjectTableObj interface implementation for the schema.
	 */
	IIntNetSubProjectTableObj getSubProjectTableObj();

	/**
	 *	Get the Tld interface for the schema.
	 *
	 *	@return	The IIntNetTldTableObj interface implementation for the schema.
	 */
	IIntNetTldTableObj getTldTableObj();

	/**
	 *	Get the TopDomain interface for the schema.
	 *
	 *	@return	The IIntNetTopDomainTableObj interface implementation for the schema.
	 */
	IIntNetTopDomainTableObj getTopDomainTableObj();

	/**
	 *	Get the TopProject interface for the schema.
	 *
	 *	@return	The IIntNetTopProjectTableObj interface implementation for the schema.
	 */
	IIntNetTopProjectTableObj getTopProjectTableObj();

	/**
	 *	Get the URLProtocol interface for the schema.
	 *
	 *	@return	The IIntNetURLProtocolTableObj interface implementation for the schema.
	 */
	IIntNetURLProtocolTableObj getURLProtocolTableObj();
}
