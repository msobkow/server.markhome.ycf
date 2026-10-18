// Description: Java 25 protlic interface for a SecUser history object

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

package server.markhome.ycf.v3_1.secure.secureprot;

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
import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/**
 *	ISecureProtSecUserH provides access to protlic history records matching the SecureProtSecUser object change history.
 */
public interface ISecureProtSecUserH
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

	public ISecureProtSecUserHPKey getProtPKey();
	public void setProtPKey( ISecureProtSecUserHPKey pkey );
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

	public IYCFKeyHash256 getRequiredSecUserId();
	public void setRequiredSecUserId( IYCFKeyHash256 requiredSecUserId );

	public String getRequiredLoginId();
	public void setRequiredLoginId( String value );
	public ISecurePubSchema.SecAccountStatusEnum getRequiredAccountStatus();
	public void setRequiredAccountStatus( ISecurePubSchema.SecAccountStatusEnum value );
	public String getOptionalDfltSysGrpName();
	public void setOptionalDfltSysGrpName( String value );
	public String getOptionalDfltClusGrpName();
	public void setOptionalDfltClusGrpName( String value );
	public String getOptionalDfltTentGrpName();
	public void setOptionalDfltTentGrpName( String value );
	public String getRequiredEMailAddress();
	public void setRequiredEMailAddress( String value );
	@Override
	public boolean equals( Object obj );

	@Override
	public int hashCode();

	//@Override
	public int compareTo( Object obj );

	public void set( ISecureProtSecUser src );
	public void set( ISecureProtSecUserH src );
	public void setSecUser( ISecureProtSecUser src );
	public void setSecUser( ISecureProtSecUserH src );
	public String getXmlAttrFragment();

	@Override
	public String toString();
}
