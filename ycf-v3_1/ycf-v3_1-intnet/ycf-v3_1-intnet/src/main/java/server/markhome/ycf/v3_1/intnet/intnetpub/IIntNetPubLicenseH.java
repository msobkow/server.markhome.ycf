// Description: Java 25 public interface for a License history object

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

package server.markhome.ycf.v3_1.intnet.intnetpub;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
//import server.markhome.ycf.v3_1.intnet.intnetpub.*;

/**
 *	IIntNetPubLicenseH provides access to public history records matching the IntNetPubLicense object change history.
 */
public interface IIntNetPubLicenseH
{
	public int getClassCode();

	public IIntNetPubLicenseHPKey getPubPKey();
	public void setPubPKey( IIntNetPubLicenseHPKey pkey );
	public YCFDbKeyHash256 getAuditClusterId();
	public void setAuditClusterId(YCFDbKeyHash256 auditClusterId);
	public LocalDateTime getAuditStamp();
	public void setAuditStamp(LocalDateTime auditStamp);
	public short getAuditActionId();
	public void setAuditActionId(short auditActionId);
	public int getRequiredRevision();
	public void setRequiredRevision(int revision);
	public YCFDbKeyHash256 getAuditSessionId();
	public void setAuditSessionId(YCFDbKeyHash256 auditSessionId);

	public IYCFKeyHash256 getRequiredId();
	public void setRequiredId( IYCFKeyHash256 requiredId );

	public YCFDbKeyHash256 getRequiredTenantId();
	public void setRequiredTenantId( YCFDbKeyHash256 value );
	public YCFDbKeyHash256 getRequiredTopDomainId();
	public void setRequiredTopDomainId( YCFDbKeyHash256 value );
	public String getRequiredName();
	public void setRequiredName( String value );
	public String getOptionalDescription();
	public void setOptionalDescription( String value );
	public String getOptionalEmbeddedText();
	public void setOptionalEmbeddedText( String value );
	public String getOptionalFullText();
	public void setOptionalFullText( String value );
	@Override
	public boolean equals( Object obj );

	@Override
	public int hashCode();

	//@Override
	public int compareTo( Object obj );

	public void set( IIntNetPubLicense src );
	public void set( IIntNetPubLicenseH src );
	public void setLicense( IIntNetPubLicense src );
	public void setLicense( IIntNetPubLicenseH src );
	public String getXmlAttrFragment();

	@Override
	public String toString();
}
