// Description: Java 25 interface for a SecTentRole history object

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

package server.markhome.ycf.v3_1.secure.secure;

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
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/**
 *	ISecureSecTentRoleH provides access to history records matching the SecureSecTentRole object change history.
 */
public interface ISecureSecTentRoleH
{
	public int getClassCode();

	public YCFDbKeyHash256 getCreatedByUserId();
	public void setCreatedByUserId( YCFDbKeyHash256 value );
	public LocalDateTime getCreatedAt();
	public void setCreatedAt( LocalDateTime value );
	public YCFDbKeyHash256 getUpdatedByUserId();
	public void setUpdatedByUserId( YCFDbKeyHash256 value );
	public LocalDateTime getUpdatedAt();
	public void setUpdatedAt( LocalDateTime value );

	public ISecureSecTentRoleHPKey getPKey();
	public void setPKey( ISecureSecTentRoleHPKey pkey );
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

	public IYCFKeyHash256 getRequiredSecTentRoleId();
	public void setRequiredSecTentRoleId( IYCFKeyHash256 requiredSecTentRoleId );

	public IYCFKeyHash256 getRequiredTenantId();
	public void setRequiredTenantId( IYCFKeyHash256 value );
	public String getRequiredName();
	public void setRequiredName( String value );
	@Override
	public boolean equals( Object obj );

	@Override
	public int hashCode();

	//@Override
	public int compareTo( Object obj );

	public void set( ISecureSecTentRole src );
	public void set( ISecureSecTentRoleH src );
	public void setSecTentRole( ISecureSecTentRole src );
	public void setSecTentRole( ISecureSecTentRoleH src );
	public String getXmlAttrFragment();

	@Override
	public String toString();
}
