// Description: Java 25 Public Schema Object interface for IntNetPub.

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

package server.markhome.ycf.v3_1.intnet.intnetpubobj;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;

public interface IIntNetPubSchemaObj
	extends ISecurePubSchemaObj
{
	public ISecurePubSchema getSecurePubBackingStore();
	public void setSecurePubBackingStore(ISecurePubSchema securepubBackingStore);

	public IIntNetPubSchema getIntNetPubBackingStore();
	public void setIntNetPubBackingStore(IIntNetPubSchema intnetpubBackingStore);

	/**
	 *	Get the License interface for the schema.
	 *
	 *	@return	The IIntNetPubLicenseTableObj interface implementation for the schema.
	 */
	IIntNetPubLicenseTableObj getLicenseTableObj();

	/**
	 *	Get the MajorVersion interface for the schema.
	 *
	 *	@return	The IIntNetPubMajorVersionTableObj interface implementation for the schema.
	 */
	IIntNetPubMajorVersionTableObj getMajorVersionTableObj();

	/**
	 *	Get the MimeType interface for the schema.
	 *
	 *	@return	The IIntNetPubMimeTypeTableObj interface implementation for the schema.
	 */
	IIntNetPubMimeTypeTableObj getMimeTypeTableObj();

	/**
	 *	Get the MinorVersion interface for the schema.
	 *
	 *	@return	The IIntNetPubMinorVersionTableObj interface implementation for the schema.
	 */
	IIntNetPubMinorVersionTableObj getMinorVersionTableObj();

	/**
	 *	Get the SubProject interface for the schema.
	 *
	 *	@return	The IIntNetPubSubProjectTableObj interface implementation for the schema.
	 */
	IIntNetPubSubProjectTableObj getSubProjectTableObj();

	/**
	 *	Get the Tld interface for the schema.
	 *
	 *	@return	The IIntNetPubTldTableObj interface implementation for the schema.
	 */
	IIntNetPubTldTableObj getTldTableObj();

	/**
	 *	Get the TopDomain interface for the schema.
	 *
	 *	@return	The IIntNetPubTopDomainTableObj interface implementation for the schema.
	 */
	IIntNetPubTopDomainTableObj getTopDomainTableObj();

	/**
	 *	Get the TopProject interface for the schema.
	 *
	 *	@return	The IIntNetPubTopProjectTableObj interface implementation for the schema.
	 */
	IIntNetPubTopProjectTableObj getTopProjectTableObj();

	/**
	 *	Get the URLProtocol interface for the schema.
	 *
	 *	@return	The IIntNetPubURLProtocolTableObj interface implementation for the schema.
	 */
	IIntNetPubURLProtocolTableObj getURLProtocolTableObj();
}
