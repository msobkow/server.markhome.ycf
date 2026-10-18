// Description: Java 25 implementation of a SecSysRoleEnables history buffer primary key

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

package server.markhome.ycf.v3_1.secure.secure.buff;

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
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

/**
 *	SecureBuffSecSysRoleEnablesHPKey History Primary Key for SecSysRoleEnables
 *		requiredSecSysRoleId	Required object attribute SecSysRoleId.
 *		requiredEnableName	Required object attribute EnableName.
 */
public class SecureBuffSecSysRoleEnablesHPKey
	implements ISecureSecSysRoleEnablesHPKey, Comparable<Object>, Serializable
{
	protected YCFDbKeyHash256 auditClusterId;
	protected LocalDateTime auditStamp;
	protected short auditActionId;
	protected int requiredRevision;
	protected YCFDbKeyHash256 auditSessionId;

	protected IYCFKeyHash256 requiredSecSysRoleId;
	protected String requiredEnableName;

	public SecureBuffSecSysRoleEnablesHPKey() {
		auditClusterId = ISecureProtCluster.ID_INIT_VALUE;
		auditStamp = LocalDateTime.now();
		auditActionId = 0;
		requiredRevision = 1;
		auditSessionId = YCFDbKeyHash256.nullGet();
		requiredSecSysRoleId = YCFDbKeyHash256.fromHex( ISecureProtSecSysRoleEnables.SECSYSROLEID_INIT_VALUE.toString() );
		requiredEnableName = ISecureProtSecSysRoleEnables.ENABLENAME_INIT_VALUE;
	}

	@Override
	public YCFDbKeyHash256 getAuditClusterId() {
		return( auditClusterId );
	}

	@Override
	public void setAuditClusterId( YCFDbKeyHash256 value ) {
		auditClusterId = value;
	}

	@Override
	public LocalDateTime getAuditStamp() {
		return( auditStamp );
	}

	@Override
	public void setAuditStamp( LocalDateTime value ) {
		auditStamp = value;
	}

	@Override
	public short getAuditActionId() {
		return( auditActionId );
	}

	@Override
	public void setAuditActionId( short value ) {
		auditActionId = value;
	}

	@Override
	public int getRequiredRevision() {
		return( requiredRevision );
	}

	@Override
	public void setRequiredRevision( int value ) {
		requiredRevision = value;
	}

	@Override
	public YCFDbKeyHash256 getAuditSessionId() {
		return( auditSessionId );
	}

	@Override
	public void setAuditSessionId( YCFDbKeyHash256 value ) {
		auditSessionId = value;
	}

	@Override
	public IYCFKeyHash256 getRequiredSecSysRoleId() {
		return(requiredSecSysRoleId);
	}

	public void setRequiredSecSysRoleId( IYCFKeyHash256 value ) {
		if( value == null || value.isNull() ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredSecSysRoleId",
				1,
				"value" );
		}
		requiredSecSysRoleId = value;
	}

	@Override
	public String getRequiredEnableName() {
		return(requiredEnableName);
	}

	public void setRequiredEnableName( String value ) {
		if( value == null ) {
			throw new YCFNullArgumentException( getClass(),
				"setRequiredEnableName",
				1,
				"value" );
		}
		else if( value.length() > 64 ) {
			throw new YCFArgumentOverflowException( getClass(),
				"setRequiredEnableName",
				1,
				"value.length()",
				value.length(),
				64 );
		}
		requiredEnableName = value;
	}

	@Override
	public boolean equals( Object obj ) {
		if (obj == null) {
			return( false );
		}
		else if(obj == this) {
			return( true );
		}
		else if (obj instanceof ISecureSecSysRoleEnablesHPKey rhs) {
			if (getAuditClusterId() != null) {
				if (rhs.getAuditClusterId() != null) {
					if ( ! getAuditClusterId().equals(rhs.getAuditClusterId())) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else if (rhs.getAuditClusterId() != null) {
				return( false );
			}
			if (getAuditStamp() != null) {
				if (rhs.getAuditStamp() != null) {
					if ( ! getAuditStamp().equals(rhs.getAuditStamp())) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else if (rhs.getAuditStamp() != null) {
				return( false );
			}
			if( getAuditActionId() != rhs.getAuditActionId() ) {
				return( false );
			}
			if( getRequiredRevision() != rhs.getRequiredRevision() ) {
				return( false );
			}
			if (getAuditSessionId() != null && !getAuditSessionId().isNull() ) {
				if (rhs.getAuditSessionId() != null && !rhs.getAuditSessionId().isNull() ) {
					if ( ! getAuditSessionId().equals(rhs.getAuditSessionId())) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else if (rhs.getAuditSessionId() != null && !rhs.getAuditSessionId().isNull() ) {
				return( false );
			}
			if( getRequiredSecSysRoleId() != null ) {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					if( ! getRequiredSecSysRoleId().equals( rhs.getRequiredSecSysRoleId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					return( false );
				}
			}
			if( getRequiredEnableName() != null ) {
				if( rhs.getRequiredEnableName() != null ) {
					if( ! getRequiredEnableName().equals( rhs.getRequiredEnableName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnableName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof ISecureSecSysRoleEnablesPKey rhs) {
			if( getRequiredSecSysRoleId() != null ) {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					if( ! getRequiredSecSysRoleId().equals( rhs.getRequiredSecSysRoleId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					return( false );
				}
			}
			if( getRequiredEnableName() != null ) {
				if( rhs.getRequiredEnableName() != null ) {
					if( ! getRequiredEnableName().equals( rhs.getRequiredEnableName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnableName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof ISecureSecSysRoleEnablesH rhs) {
			if (getAuditClusterId() != null) {
				if (rhs.getAuditClusterId() != null) {
					if ( ! getAuditClusterId().equals(rhs.getAuditClusterId())) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else if (rhs.getAuditClusterId() != null) {
				return( false );
			}
			if (getAuditStamp() != null) {
				if (rhs.getAuditStamp() != null) {
					if ( ! getAuditStamp().equals(rhs.getAuditStamp())) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else if (rhs.getAuditStamp() != null) {
				return( false );
			}
			if( getAuditActionId() != rhs.getAuditActionId() ) {
				return( false );
			}
			if( getRequiredRevision() != rhs.getRequiredRevision() ) {
				return( false );
			}
			if (getAuditSessionId() != null && !getAuditSessionId().isNull() ) {
				if (rhs.getAuditSessionId() != null && !rhs.getAuditSessionId().isNull() ) {
					if ( ! getAuditSessionId().equals(rhs.getAuditSessionId())) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else if (rhs.getAuditSessionId() != null && !rhs.getAuditSessionId().isNull() ) {
				return( false );
			}
			if( getRequiredSecSysRoleId() != null ) {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					if( ! getRequiredSecSysRoleId().equals( rhs.getRequiredSecSysRoleId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					return( false );
				}
			}
			if( getRequiredEnableName() != null ) {
				if( rhs.getRequiredEnableName() != null ) {
					if( ! getRequiredEnableName().equals( rhs.getRequiredEnableName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnableName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof ISecureSecSysRoleEnables rhs) {
			if( getRequiredSecSysRoleId() != null ) {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					if( ! getRequiredSecSysRoleId().equals( rhs.getRequiredSecSysRoleId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					return( false );
				}
			}
			if( getRequiredEnableName() != null ) {
				if( rhs.getRequiredEnableName() != null ) {
					if( ! getRequiredEnableName().equals( rhs.getRequiredEnableName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnableName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof ISecureProtSecSysRoleEnablesHPKey rhs) {
			if (getAuditClusterId() != null) {
				if (rhs.getAuditClusterId() != null) {
					if ( ! getAuditClusterId().equals(rhs.getAuditClusterId())) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else if (rhs.getAuditClusterId() != null) {
				return( false );
			}
			if (getAuditStamp() != null) {
				if (rhs.getAuditStamp() != null) {
					if ( ! getAuditStamp().equals(rhs.getAuditStamp())) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else if (rhs.getAuditStamp() != null) {
				return( false );
			}
			if( getAuditActionId() != rhs.getAuditActionId() ) {
				return( false );
			}
			if( getRequiredRevision() != rhs.getRequiredRevision() ) {
				return( false );
			}
			if (getAuditSessionId() != null && !getAuditSessionId().isNull() ) {
				if (rhs.getAuditSessionId() != null && !rhs.getAuditSessionId().isNull() ) {
					if ( ! getAuditSessionId().equals(rhs.getAuditSessionId())) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else if (rhs.getAuditSessionId() != null && !rhs.getAuditSessionId().isNull() ) {
				return( false );
			}
			if( getRequiredSecSysRoleId() != null ) {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					if( ! getRequiredSecSysRoleId().equals( rhs.getRequiredSecSysRoleId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					return( false );
				}
			}
			if( getRequiredEnableName() != null ) {
				if( rhs.getRequiredEnableName() != null ) {
					if( ! getRequiredEnableName().equals( rhs.getRequiredEnableName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnableName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof ISecureProtSecSysRoleEnablesPKey rhs) {
			if( getRequiredSecSysRoleId() != null ) {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					if( ! getRequiredSecSysRoleId().equals( rhs.getRequiredSecSysRoleId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					return( false );
				}
			}
			if( getRequiredEnableName() != null ) {
				if( rhs.getRequiredEnableName() != null ) {
					if( ! getRequiredEnableName().equals( rhs.getRequiredEnableName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnableName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof ISecureProtSecSysRoleEnablesH rhs) {
			if (getAuditClusterId() != null) {
				if (rhs.getAuditClusterId() != null) {
					if ( ! getAuditClusterId().equals(rhs.getAuditClusterId())) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else if (rhs.getAuditClusterId() != null) {
				return( false );
			}
			if (getAuditStamp() != null) {
				if (rhs.getAuditStamp() != null) {
					if ( ! getAuditStamp().equals(rhs.getAuditStamp())) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else if (rhs.getAuditStamp() != null) {
				return( false );
			}
			if( getAuditActionId() != rhs.getAuditActionId() ) {
				return( false );
			}
			if( getRequiredRevision() != rhs.getRequiredRevision() ) {
				return( false );
			}
			if (getAuditSessionId() != null && !getAuditSessionId().isNull() ) {
				if (rhs.getAuditSessionId() != null && !rhs.getAuditSessionId().isNull() ) {
					if ( ! getAuditSessionId().equals(rhs.getAuditSessionId())) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else if (rhs.getAuditSessionId() != null && !rhs.getAuditSessionId().isNull() ) {
				return( false );
			}
			if( getRequiredSecSysRoleId() != null ) {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					if( ! getRequiredSecSysRoleId().equals( rhs.getRequiredSecSysRoleId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					return( false );
				}
			}
			if( getRequiredEnableName() != null ) {
				if( rhs.getRequiredEnableName() != null ) {
					if( ! getRequiredEnableName().equals( rhs.getRequiredEnableName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnableName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else if (obj instanceof ISecureProtSecSysRoleEnables rhs) {
			if( getRequiredSecSysRoleId() != null ) {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					if( ! getRequiredSecSysRoleId().equals( rhs.getRequiredSecSysRoleId() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredSecSysRoleId() != null ) {
					return( false );
				}
			}
			if( getRequiredEnableName() != null ) {
				if( rhs.getRequiredEnableName() != null ) {
					if( ! getRequiredEnableName().equals( rhs.getRequiredEnableName() ) ) {
						return( false );
					}
				}
				else {
					return( false );
				}
			}
			else {
				if( rhs.getRequiredEnableName() != null ) {
					return( false );
				}
			}
			return( true );
		}
		else {
			return( false );
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		if( auditClusterId != null ) {
			hashCode = hashCode + auditClusterId.hashCode();
		}
		if( auditStamp != null ) {
			hashCode = hashCode + auditStamp.hashCode();
		}
		hashCode = hashCode + auditActionId;
		hashCode = hashCode + requiredRevision;
		if( auditSessionId != null ) {
			hashCode = hashCode + auditSessionId.hashCode();
		}
		hashCode = hashCode + getRequiredSecSysRoleId().hashCode();
		if( getRequiredEnableName() != null ) {
			hashCode = hashCode + getRequiredEnableName().hashCode();
		}
		return( hashCode & 0x7fffffff );
	}

	@Override
	public int compareTo( Object obj ) {
		int cmp;
		if (obj == null) {
			return( 1 );
		}
		if (obj == this) {
			return( 0 );
		}
		else if (obj instanceof ISecureSecSysRoleEnablesHPKey rhs) {
			if( getAuditClusterId() == null ) {
				if( rhs.getAuditClusterId() != null ) {
					return( -1 );
				}
			}
			else if( rhs.getAuditClusterId() == null ) {
				return( 1 );
			}
			else {
				cmp = getAuditClusterId().compareTo( rhs.getAuditClusterId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getAuditStamp() == null ) {
				if( rhs.getAuditStamp() != null ) {
					return( -1 );
				}
			}
			else if( rhs.getAuditStamp() == null ) {
				return( 1 );
			}
			else {
				cmp = getAuditStamp().compareTo( rhs.getAuditStamp() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getAuditActionId() < rhs.getAuditActionId() ) {
				return( -1 );
			}
			else if( getAuditActionId() > rhs.getAuditActionId() ) {
				return( 1 );
			}
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if( getAuditSessionId() == null ) {
				if( rhs.getAuditSessionId() != null ) {
					return( -1 );
				}
			}
			else if( rhs.getAuditSessionId() == null ) {
				return( 1 );
			}
			else {
				cmp = getAuditSessionId().compareTo( rhs.getAuditSessionId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if (getRequiredSecSysRoleId() != null) {
				if (rhs.getRequiredSecSysRoleId() != null) {
					cmp = getRequiredSecSysRoleId().compareTo( rhs.getRequiredSecSysRoleId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecSysRoleId() != null) {
				return( -1 );
			}
			if (getRequiredEnableName() != null) {
				if (rhs.getRequiredEnableName() != null) {
					cmp = getRequiredEnableName().compareTo( rhs.getRequiredEnableName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnableName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof ISecureSecSysRoleEnablesPKey rhs) {
			if (getRequiredSecSysRoleId() != null) {
				if (rhs.getRequiredSecSysRoleId() != null) {
					cmp = getRequiredSecSysRoleId().compareTo( rhs.getRequiredSecSysRoleId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecSysRoleId() != null) {
				return( -1 );
			}
			if (getRequiredEnableName() != null) {
				if (rhs.getRequiredEnableName() != null) {
					cmp = getRequiredEnableName().compareTo( rhs.getRequiredEnableName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnableName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof ISecureSecSysRoleEnablesH) {
			ISecureSecSysRoleEnablesH rhs = (ISecureSecSysRoleEnablesH)obj;
			if( getAuditClusterId() == null ) {
				if( rhs.getAuditClusterId() != null ) {
					return( -1 );
				}
			}
			else if( rhs.getAuditClusterId() == null ) {
				return( 1 );
			}
			else {
				cmp = getAuditClusterId().compareTo( rhs.getAuditClusterId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getAuditStamp() == null ) {
				if( rhs.getAuditStamp() != null ) {
					return( -1 );
				}
			}
			else if( rhs.getAuditStamp() == null ) {
				return( 1 );
			}
			else {
				cmp = getAuditStamp().compareTo( rhs.getAuditStamp() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getAuditActionId() < rhs.getAuditActionId() ) {
				return( -1 );
			}
			else if( getAuditActionId() > rhs.getAuditActionId() ) {
				return( 1 );
			}
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if( getAuditSessionId() == null ) {
				if( rhs.getAuditSessionId() != null ) {
					return( -1 );
				}
			}
			else if( rhs.getAuditSessionId() == null ) {
				return( 1 );
			}
			else {
				cmp = getAuditSessionId().compareTo( rhs.getAuditSessionId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if (getRequiredSecSysRoleId() != null) {
				if (rhs.getRequiredSecSysRoleId() != null) {
					cmp = getRequiredSecSysRoleId().compareTo( rhs.getRequiredSecSysRoleId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecSysRoleId() != null) {
				return( -1 );
			}
			if (getRequiredEnableName() != null) {
				if (rhs.getRequiredEnableName() != null) {
					cmp = getRequiredEnableName().compareTo( rhs.getRequiredEnableName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnableName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof ISecureSecSysRoleEnables rhs) {
			if (getRequiredSecSysRoleId() != null) {
				if (rhs.getRequiredSecSysRoleId() != null) {
					cmp = getRequiredSecSysRoleId().compareTo( rhs.getRequiredSecSysRoleId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecSysRoleId() != null) {
				return( -1 );
			}
			if (getRequiredEnableName() != null) {
				if (rhs.getRequiredEnableName() != null) {
					cmp = getRequiredEnableName().compareTo( rhs.getRequiredEnableName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnableName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof ISecureProtSecSysRoleEnablesHPKey rhs) {
			if( getAuditClusterId() == null ) {
				if( rhs.getAuditClusterId() != null ) {
					return( -1 );
				}
			}
			else if( rhs.getAuditClusterId() == null ) {
				return( 1 );
			}
			else {
				cmp = getAuditClusterId().compareTo( rhs.getAuditClusterId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getAuditStamp() == null ) {
				if( rhs.getAuditStamp() != null ) {
					return( -1 );
				}
			}
			else if( rhs.getAuditStamp() == null ) {
				return( 1 );
			}
			else {
				cmp = getAuditStamp().compareTo( rhs.getAuditStamp() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getAuditActionId() < rhs.getAuditActionId() ) {
				return( -1 );
			}
			else if( getAuditActionId() > rhs.getAuditActionId() ) {
				return( 1 );
			}
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if( getAuditSessionId() == null ) {
				if( rhs.getAuditSessionId() != null ) {
					return( -1 );
				}
			}
			else if( rhs.getAuditSessionId() == null ) {
				return( 1 );
			}
			else {
				cmp = getAuditSessionId().compareTo( rhs.getAuditSessionId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if (getRequiredSecSysRoleId() != null) {
				if (rhs.getRequiredSecSysRoleId() != null) {
					cmp = getRequiredSecSysRoleId().compareTo( rhs.getRequiredSecSysRoleId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecSysRoleId() != null) {
				return( -1 );
			}
			if (getRequiredEnableName() != null) {
				if (rhs.getRequiredEnableName() != null) {
					cmp = getRequiredEnableName().compareTo( rhs.getRequiredEnableName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnableName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof ISecureProtSecSysRoleEnablesPKey rhs) {
			if (getRequiredSecSysRoleId() != null) {
				if (rhs.getRequiredSecSysRoleId() != null) {
					cmp = getRequiredSecSysRoleId().compareTo( rhs.getRequiredSecSysRoleId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecSysRoleId() != null) {
				return( -1 );
			}
			if (getRequiredEnableName() != null) {
				if (rhs.getRequiredEnableName() != null) {
					cmp = getRequiredEnableName().compareTo( rhs.getRequiredEnableName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnableName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof ISecureProtSecSysRoleEnablesH rhs) {
			if( getAuditClusterId() == null ) {
				if( rhs.getAuditClusterId() != null ) {
					return( -1 );
				}
			}
			else if( rhs.getAuditClusterId() == null ) {
				return( 1 );
			}
			else {
				cmp = getAuditClusterId().compareTo( rhs.getAuditClusterId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getAuditStamp() == null ) {
				if( rhs.getAuditStamp() != null ) {
					return( -1 );
				}
			}
			else if( rhs.getAuditStamp() == null ) {
				return( 1 );
			}
			else {
				cmp = getAuditStamp().compareTo( rhs.getAuditStamp() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if( getAuditActionId() < rhs.getAuditActionId() ) {
				return( -1 );
			}
			else if( getAuditActionId() > rhs.getAuditActionId() ) {
				return( 1 );
			}
			if( getRequiredRevision() < rhs.getRequiredRevision() ) {
				return( -1 );
			}
			else if( getRequiredRevision() > rhs.getRequiredRevision() ) {
				return( 1 );
			}
			if( getAuditSessionId() == null ) {
				if( rhs.getAuditSessionId() != null ) {
					return( -1 );
				}
			}
			else if( rhs.getAuditSessionId() == null ) {
				return( 1 );
			}
			else {
				cmp = getAuditSessionId().compareTo( rhs.getAuditSessionId() );
				if( cmp != 0 ) {
					return( cmp );
				}
			}
			if (getRequiredSecSysRoleId() != null) {
				if (rhs.getRequiredSecSysRoleId() != null) {
					cmp = getRequiredSecSysRoleId().compareTo( rhs.getRequiredSecSysRoleId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecSysRoleId() != null) {
				return( -1 );
			}
			if (getRequiredEnableName() != null) {
				if (rhs.getRequiredEnableName() != null) {
					cmp = getRequiredEnableName().compareTo( rhs.getRequiredEnableName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnableName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else if (obj instanceof ISecureProtSecSysRoleEnables rhs) {
			if (getRequiredSecSysRoleId() != null) {
				if (rhs.getRequiredSecSysRoleId() != null) {
					cmp = getRequiredSecSysRoleId().compareTo( rhs.getRequiredSecSysRoleId() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredSecSysRoleId() != null) {
				return( -1 );
			}
			if (getRequiredEnableName() != null) {
				if (rhs.getRequiredEnableName() != null) {
					cmp = getRequiredEnableName().compareTo( rhs.getRequiredEnableName() );
					if( cmp != 0 ) {
						return( cmp );
					}
				}
				else {
					return( 1 );
				}
			}
			else if (rhs.getRequiredEnableName() != null) {
				return( -1 );
			}
			return( 0 );
		}
		else {
			throw new YCFUnsupportedClassException( getClass(),
				"compareTo",
				"obj",
				obj,
				"ISecureSecSysRoleEnablesPKey, ISecureSecSysRoleEnables, SecureSecSysRoleEnablesHPKey, SecureSecSysRoleEnablesH" );
		}
	}

	@Override
	public String getXmlAttrFragment() {
		String ret = " auditClusterId=\"" + (auditClusterId != null ? auditClusterId.toString() : "null") + "\""
			+ " auditStamp=\"" + (auditStamp != null ? YCFXmlUtil.formatTimestamp(auditStamp) : "null") + "\""
			+ " auditAction=\"" + auditActionId + "\""
			+ " revision=\"" + requiredRevision + "\""
			+ " auditSessionId=\"" + (getAuditSessionId() != null ? getAuditSessionId().toString() : "null") + "\""
			+ " RequiredSecSysRoleId=" + "\"" + getRequiredSecSysRoleId().toString() + "\""
			+ " RequiredEnableName=" + "\"" + StringEscapeUtils.escapeXml11( getRequiredEnableName() ) + "\"";
		return( ret );
	}

	@Override
	public String toString() {
		String ret = "<SecureBuffSecSysRoleEnablesHPKey" + getXmlAttrFragment() + "/>";
		return( ret );
	}
}
