// Description: Java 25 public interface for a ISOTZone history object

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

package server.markhome.ycf.v3_1.secure.securepub;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.YCFXmlUtil;
//import server.markhome.ycf.v3_1.secure.securepub.*;

/**
 *	ISecurePubISOTZoneH provides access to public history records matching the SecurePubISOTZone object change history.
 */
public interface ISecurePubISOTZoneH
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

	public ISecurePubISOTZoneHPKey getPubPKey();
	public void setPubPKey( ISecurePubISOTZoneHPKey pkey );
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

	public short getRequiredISOTZoneId();
	public void setRequiredISOTZoneId( short requiredISOTZoneId );

	public String getRequiredIso8601();
	public void setRequiredIso8601( String value );
	public String getRequiredTZName();
	public void setRequiredTZName( String value );
	public short getRequiredTZHourOffset();
	public void setRequiredTZHourOffset( short value );
	public short getRequiredTZMinOffset();
	public void setRequiredTZMinOffset( short value );
	public String getRequiredDescription();
	public void setRequiredDescription( String value );
	public boolean getRequiredVisible();
	public void setRequiredVisible( boolean value );
	@Override
	public boolean equals( Object obj );

	@Override
	public int hashCode();

	//@Override
	public int compareTo( Object obj );

	public void set( ISecurePubISOTZone src );
	public void set( ISecurePubISOTZoneH src );
	public void setISOTZone( ISecurePubISOTZone src );
	public void setISOTZone( ISecurePubISOTZoneH src );
	public String getXmlAttrFragment();

	@Override
	public String toString();
}
