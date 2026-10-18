// Description: Java 25 Protected Schema Object interface for IntNetProt.

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

package server.markhome.ycf.v3_1.intnet.intnetprotobj;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;

public interface IIntNetProtSchemaObj
	extends ISecurePubSchemaObj
{
	public ISecurePubSchema getSecureProtBackingStore();
	public void setSecureProtBackingStore(ISecurePubSchema secureprotBackingStore);

	public IIntNetProtSchema getIntNetProtBackingStore();
	public void setIntNetProtBackingStore(IIntNetProtSchema intnetprotBackingStore);

	/**
	 *	Get the License interface for the schema.
	 *
	 *	@return	The IIntNetProtLicenseTableObj interface implementation for the schema.
	 */
	IIntNetProtLicenseTableObj getLicenseTableObj();

	/**
	 *	Get the MajorVersion interface for the schema.
	 *
	 *	@return	The IIntNetProtMajorVersionTableObj interface implementation for the schema.
	 */
	IIntNetProtMajorVersionTableObj getMajorVersionTableObj();

	/**
	 *	Get the MimeType interface for the schema.
	 *
	 *	@return	The IIntNetProtMimeTypeTableObj interface implementation for the schema.
	 */
	IIntNetProtMimeTypeTableObj getMimeTypeTableObj();

	/**
	 *	Get the MinorVersion interface for the schema.
	 *
	 *	@return	The IIntNetProtMinorVersionTableObj interface implementation for the schema.
	 */
	IIntNetProtMinorVersionTableObj getMinorVersionTableObj();

	/**
	 *	Get the SubProject interface for the schema.
	 *
	 *	@return	The IIntNetProtSubProjectTableObj interface implementation for the schema.
	 */
	IIntNetProtSubProjectTableObj getSubProjectTableObj();

	/**
	 *	Get the Tld interface for the schema.
	 *
	 *	@return	The IIntNetProtTldTableObj interface implementation for the schema.
	 */
	IIntNetProtTldTableObj getTldTableObj();

	/**
	 *	Get the TopDomain interface for the schema.
	 *
	 *	@return	The IIntNetProtTopDomainTableObj interface implementation for the schema.
	 */
	IIntNetProtTopDomainTableObj getTopDomainTableObj();

	/**
	 *	Get the TopProject interface for the schema.
	 *
	 *	@return	The IIntNetProtTopProjectTableObj interface implementation for the schema.
	 */
	IIntNetProtTopProjectTableObj getTopProjectTableObj();

	/**
	 *	Get the URLProtocol interface for the schema.
	 *
	 *	@return	The IIntNetProtURLProtocolTableObj interface implementation for the schema.
	 */
	IIntNetProtURLProtocolTableObj getURLProtocolTableObj();
}
