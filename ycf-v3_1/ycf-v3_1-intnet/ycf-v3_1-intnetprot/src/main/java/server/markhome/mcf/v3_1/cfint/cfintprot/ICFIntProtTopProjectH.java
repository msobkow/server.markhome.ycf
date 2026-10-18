// Description: Java 25 protlic interface for a TopProject history object

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
 *	ICFIntProtTopProjectH provides access to protlic history records matching the CFIntProtTopProject object change history.
 */
public interface ICFIntProtTopProjectH
{
	public int getClassCode();

	public MCFDbKeyHash256 getCreatedByUserId();
	public void setCreatedByUserId( MCFDbKeyHash256 value );
	public LocalDateTime getCreatedAt();
	public void setCreatedAt( LocalDateTime value );
	public MCFDbKeyHash256 getUpdatedByUserId();
	public void setUpdatedByUserId( MCFDbKeyHash256 value );
	public LocalDateTime getUpdatedAt();
	public void setUpdatedAt( LocalDateTime value );

	public ICFIntProtTopProjectHPKey getProtPKey();
	public void setProtPKey( ICFIntProtTopProjectHPKey pkey );
	public MCFDbKeyHash256 getAuditClusterId();
	public void setAuditClusterId(MCFDbKeyHash256 auditClusterId);
	public LocalDateTime getAuditStamp();
	public void setAuditStamp(LocalDateTime auditStamp);
	public short getAuditActionId();
	public void setAuditActionId(short auditActionId);
	public int getRequiredRevision();
	public void setRequiredRevision(int revision);
	public MCFDbKeyHash256 getAuditSessionId();
	public void setAuditSessionId(MCFDbKeyHash256 auditSessionId);

	public IMCFKeyHash256 getRequiredId();
	public void setRequiredId( IMCFKeyHash256 requiredId );

	public IMCFKeyHash256 getRequiredTenantId();
	public void setRequiredTenantId( IMCFKeyHash256 value );
	public IMCFKeyHash256 getRequiredTopDomainId();
	public void setRequiredTopDomainId( IMCFKeyHash256 value );
	public String getRequiredName();
	public void setRequiredName( String value );
	public String getOptionalDescription();
	public void setOptionalDescription( String value );
	@Override
	public boolean equals( Object obj );

	@Override
	public int hashCode();

	//@Override
	public int compareTo( Object obj );

	public void set( ICFIntProtTopProject src );
	public void set( ICFIntProtTopProjectH src );
	public void setTopProject( ICFIntProtTopProject src );
	public void setTopProject( ICFIntProtTopProjectH src );
	public String getXmlAttrFragment();

	@Override
	public String toString();
}
