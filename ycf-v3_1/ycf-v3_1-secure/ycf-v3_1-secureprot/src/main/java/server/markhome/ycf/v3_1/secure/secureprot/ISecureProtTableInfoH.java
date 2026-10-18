// Description: Java 25 protlic interface for a TableInfo history object

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
 *	ISecureProtTableInfoH provides access to protlic history records matching the SecureProtTableInfo object change history.
 */
public interface ISecureProtTableInfoH
{
	public int getClassCode();

	public ISecureProtTableInfoHPKey getProtPKey();
	public void setProtPKey( ISecureProtTableInfoHPKey pkey );
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

	public int getRequiredTableInfoId();
	public void setRequiredTableInfoId( int requiredTableInfoId );

	public String getRequiredSchemaName();
	public void setRequiredSchemaName( String value );
	public String getRequiredTableName();
	public void setRequiredTableName( String value );
	public String getOptionalSuperName();
	public void setOptionalSuperName( String value );
	public int getRequiredBackingClassCode();
	public void setRequiredBackingClassCode( int value );
	public int getRequiredRuntimeClassCode();
	public void setRequiredRuntimeClassCode( int value );
	public boolean getRequiredHasHistory();
	public void setRequiredHasHistory( boolean value );
	public boolean getRequiredIsMutable();
	public void setRequiredIsMutable( boolean value );
	public String getRequiredSecScopeName();
	public void setRequiredSecScopeName( String value );
	public String getRequiredCodeVis();
	public void setRequiredCodeVis( String value );
	@Override
	public boolean equals( Object obj );

	@Override
	public int hashCode();

	//@Override
	public int compareTo( Object obj );

	public void set( ISecureProtTableInfo src );
	public void set( ISecureProtTableInfoH src );
	public void setTableInfo( ISecureProtTableInfo src );
	public void setTableInfo( ISecureProtTableInfoH src );
	public String getXmlAttrFragment();

	@Override
	public String toString();
}
