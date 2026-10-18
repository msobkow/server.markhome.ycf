// Description: Java 25 protected interface for a License record implementation

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

package server.markhome.ycf.v3_1.intnet.intnetprot;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;

/**
 *	IIntNetProtLicense persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IIntNetProtLicense
{
	public static final String S_ID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 ID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_ID_INIT_VALUE );
	public static final String S_TENANTID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 TENANTID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_TENANTID_INIT_VALUE );
	public static final String S_TOPDOMAINID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 TOPDOMAINID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_TOPDOMAINID_INIT_VALUE );
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final String DESCRIPTION_INIT_VALUE = new String( "" );
	public static final String EMBEDDEDTEXT_INIT_VALUE = new String( "" );
	public static final String FULLTEXT_INIT_VALUE = new String( "" );
	public final static int CLASS_CODE = 0xa110;
	public final static String S_CLASS_CODE = "a110";

	public int getClassCode();

	public YCFDbKeyHash256 getPKey();
	public void setPKey(YCFDbKeyHash256 requiredId);
	public IYCFKeyHash256 getRequiredId();
	public void setRequiredId( IYCFKeyHash256 value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public ISecureProtTenant getRequiredOwnerTenant();

	public void setRequiredOwnerTenant(IYCFKeyHash256 argTenantId);

	public void setRequiredOwnerTenant(ISecurePubTenant argObj);

	public IIntNetProtTopDomain getRequiredContainerTopDomain();

	public void setRequiredContainerTopDomain(IYCFKeyHash256 argTopDomainId);


	public void setRequiredContainerTopDomain(IIntNetProtTopDomain argObj);

	public void setRequiredContainerTopDomain(IIntNetPubTopDomain argObj);

	public IYCFKeyHash256 getRequiredTenantId();
	public void setRequiredTenantId( IYCFKeyHash256 value );
	public IYCFKeyHash256 getRequiredTopDomainId();
	public void setRequiredTopDomainId( IYCFKeyHash256 value );
	public String getRequiredName();
	public void setRequiredName( String value );
	public String getOptionalDescription();
	public void setOptionalDescription( String value );
	public String getOptionalEmbeddedText();
	public void setOptionalEmbeddedText( String value );
	public String getOptionalFullText();
	public void setOptionalFullText( String value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( IIntNetProtLicense src );

	public void setLicense( IIntNetProtLicense src );

	public void set( IIntNetProtLicenseH src );

	public void setLicense( IIntNetProtLicenseH src );

	public void set( IIntNetPubLicense src );

	public void setLicense( IIntNetPubLicense src );

	public void set( IIntNetPubLicenseH src );

	public void setLicense( IIntNetPubLicenseH src );

	public String getXmlAttrFragment();

	public String toString();
}
