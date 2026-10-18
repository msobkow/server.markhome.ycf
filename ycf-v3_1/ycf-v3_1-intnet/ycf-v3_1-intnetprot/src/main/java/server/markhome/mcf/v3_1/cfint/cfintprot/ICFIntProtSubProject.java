// Description: Java 25 protected interface for a SubProject record implementation

/*
 *	server.markhome.mcf.CFInt
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal 3.1 CFInt - Internet Essentials
 *	
 *	This file is part of Mark's Code Fractal CFInt.
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

package server.markhome.mcf.v3_1.cfint.cfintprot;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.dbutil.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cflib.xml.MCFXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
import server.markhome.mcf.v3_1.cfsec.cfsecpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintpubobj.*;
import server.markhome.mcf.v3_1.cfint.cfintprotobj.*;

/**
 *	ICFIntProtSubProject persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ICFIntProtSubProject
{
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 INIT_CREATED_BY = MCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 INIT_UPDATED_BY = MCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final String S_ID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 ID_INIT_VALUE = MCFDbKeyHash256.fromHex( S_ID_INIT_VALUE );
	public static final String S_TENANTID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 TENANTID_INIT_VALUE = MCFDbKeyHash256.fromHex( S_TENANTID_INIT_VALUE );
	public static final String S_TOPPROJECTID_INIT_VALUE = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final MCFDbKeyHash256 TOPPROJECTID_INIT_VALUE = MCFDbKeyHash256.fromHex( S_TOPPROJECTID_INIT_VALUE );
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final String DESCRIPTION_INIT_VALUE = new String( "" );
	public final static int CLASS_CODE = 0xa105;
	public final static String S_CLASS_CODE = "a105";

	public int getClassCode();

	public MCFDbKeyHash256 getCreatedByUserId();

	public void setCreatedByUserId( MCFDbKeyHash256 value );

	public LocalDateTime getCreatedAt();

	public void setCreatedAt( LocalDateTime value );

	public MCFDbKeyHash256 getUpdatedByUserId();

	public void setUpdatedByUserId( MCFDbKeyHash256 value );

	public LocalDateTime getUpdatedAt();

	public void setUpdatedAt( LocalDateTime value );

	public MCFDbKeyHash256 getPKey();
	public void setPKey(MCFDbKeyHash256 requiredId);
	public List<ICFIntProtMajorVersion> getOptionalComponentsMajorVer();

	public IMCFKeyHash256 getRequiredId();
	public void setRequiredId( IMCFKeyHash256 value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public ICFSecProtTenant getRequiredOwnerTenant();

	public void setRequiredOwnerTenant(IMCFKeyHash256 argTenantId);

	public void setRequiredOwnerTenant(ICFSecPubTenant argObj);

	public ICFIntProtTopProject getRequiredContainerParentTPrj();

	public void setRequiredContainerParentTPrj(IMCFKeyHash256 argTopProjectId);


	public void setRequiredContainerParentTPrj(ICFIntProtTopProject argObj);

	public void setRequiredContainerParentTPrj(ICFIntPubTopProject argObj);

	public IMCFKeyHash256 getRequiredTenantId();
	public void setRequiredTenantId( IMCFKeyHash256 value );
	public IMCFKeyHash256 getRequiredTopProjectId();
	public void setRequiredTopProjectId( IMCFKeyHash256 value );
	public String getRequiredName();
	public void setRequiredName( String value );
	public String getOptionalDescription();
	public void setOptionalDescription( String value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ICFIntProtSubProject src );

	public void setSubProject( ICFIntProtSubProject src );

	public void set( ICFIntProtSubProjectH src );

	public void setSubProject( ICFIntProtSubProjectH src );

	public void set( ICFIntPubSubProject src );

	public void setSubProject( ICFIntPubSubProject src );

	public void set( ICFIntPubSubProjectH src );

	public void setSubProject( ICFIntPubSubProjectH src );

	public String getXmlAttrFragment();

	public String toString();
}
