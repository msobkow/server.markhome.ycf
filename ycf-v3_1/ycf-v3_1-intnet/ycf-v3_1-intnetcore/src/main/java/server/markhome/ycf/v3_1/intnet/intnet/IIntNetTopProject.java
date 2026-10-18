// Description: Java 25 interface for a TopProject record declementation

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

package server.markhome.ycf.v3_1.intnet.intnet;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;

import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;

/**
 *	IIntNetTopProject persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IIntNetTopProject
{
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_CREATED_BY = YCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_UPDATED_BY = YCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final String S_ID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 ID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_ID_INIT_VALUE );
	public static final String S_TENANTID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 TENANTID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_TENANTID_INIT_VALUE );
	public static final String S_TOPDOMAINID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 TOPDOMAINID_INIT_VALUE = YCFDbKeyHash256.fromHex( S_TOPDOMAINID_INIT_VALUE );
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final String DESCRIPTION_INIT_VALUE = new String( "" );
	public final static int CLASS_CODE = 0xa108;
	public final static String S_CLASS_CODE = "a108";

	public int getClassCode();

	public YCFDbKeyHash256 getCreatedByUserId();

	public void setCreatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getCreatedAt();

	public void setCreatedAt( LocalDateTime value );

	public YCFDbKeyHash256 getUpdatedByUserId();

	public void setUpdatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getUpdatedAt();

	public void setUpdatedAt( LocalDateTime value );

	public $implCommaIJavaOptAtomType$ getPKey();
	public void setPKey($implCommaIJavaOptAtomType$ requiredId);
	public List<IIntNetSubProject> getOptionalComponentsSubProject();

	public IYCFKeyHash256 getRequiredId();
	public void setRequiredId( IYCFKeyHash256 value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public ISecureTenant getRequiredOwnerTenant();

	public void setRequiredOwnerTenant(IYCFKeyHash256 argTenantId);

	public void setRequiredOwnerTenant(ISecurePubTenant argObj);

	public IIntNetTopDomain getRequiredContainerParentSDom();

	public void setRequiredContainerParentSDom(IYCFKeyHash256 argTopDomainId);

	public void setRequiredContainerParentSDom(IIntNetTopDomain argObj);

	public void setRequiredContainerParentSDom(IIntNetProtTopDomain argObj);

	public void setRequiredContainerParentSDom(IIntNetPubTopDomain argObj);

	public IYCFKeyHash256 getRequiredTenantId();
	public void setRequiredTenantId( IYCFKeyHash256 value );
	public IYCFKeyHash256 getRequiredTopDomainId();
	public void setRequiredTopDomainId( IYCFKeyHash256 value );
	public String getRequiredName();
	public void setRequiredName( String value );
	public String getOptionalDescription();
	public void setOptionalDescription( String value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( IIntNetTopProject src );

	public void setTopProject( IIntNetTopProject src );

	public void set( IIntNetTopProjectH src );

	public void setTopProject( IIntNetTopProjectH src );

	public void set( IIntNetProtTopProject src );

	public void setTopProject( IIntNetProtTopProject src );

	public void set( IIntNetProtTopProjectH src );

	public void setTopProject( IIntNetProtTopProjectH src );

	public void set( IIntNetPubTopProject src );

	public void setTopProject( IIntNetPubTopProject src );

	public void set( IIntNetPubTopProjectH src );

	public void setTopProject( IIntNetPubTopProjectH src );

	public String getXmlAttrFragment();

	public String toString();
}
