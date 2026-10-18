
// Description: Java 25 Factory service implementation for ISOTZone buffers

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

import java.lang.reflect.*;
import java.net.*;
import java.rmi.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.secure.secureprot.*;
import server.markhome.ycf.v3_1.secure.secureprotobj.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

/*
 *	Java 25 Factory service implementation for ISOTZone buffers.
 */
@Service("secure31BuffISOTZoneFactoryService")
public class SecureBuffISOTZoneFactoryService
	implements ISecureISOTZoneFactory
{
	public SecureBuffISOTZoneFactoryService() {
	}

	@Override
	public ISecureISOTZoneHPKey newHPKey() {
		ISecureISOTZoneHPKey hpkey =
			new SecureBuffISOTZoneHPKey();
		return( hpkey );
	}

	public SecureBuffISOTZoneHPKey ensureHPKey(ISecureISOTZoneHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffISOTZoneHPKey) {
			return( (SecureBuffISOTZoneHPKey)key );
		}
		else {
			SecureBuffISOTZoneHPKey mapped = new SecureBuffISOTZoneHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOTZoneId( key.getRequiredISOTZoneId() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOTZoneByOffsetIdxKey newByOffsetIdxKey() {
		ISecureISOTZoneByOffsetIdxKey key =
			new SecureBuffISOTZoneByOffsetIdxKey();
		return( key );
	}

	public SecureBuffISOTZoneByOffsetIdxKey ensureByOffsetIdxKey(ISecureISOTZoneByOffsetIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOTZoneByOffsetIdxKey) {
			return( (SecureBuffISOTZoneByOffsetIdxKey)key );
		}
		else {
			SecureBuffISOTZoneByOffsetIdxKey mapped = new SecureBuffISOTZoneByOffsetIdxKey();
			mapped.setRequiredTZHourOffset( key.getRequiredTZHourOffset() );
			mapped.setRequiredTZMinOffset( key.getRequiredTZMinOffset() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOTZoneByUTZNameIdxKey newByUTZNameIdxKey() {
		ISecureISOTZoneByUTZNameIdxKey key =
			new SecureBuffISOTZoneByUTZNameIdxKey();
		return( key );
	}

	public SecureBuffISOTZoneByUTZNameIdxKey ensureByUTZNameIdxKey(ISecureISOTZoneByUTZNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOTZoneByUTZNameIdxKey) {
			return( (SecureBuffISOTZoneByUTZNameIdxKey)key );
		}
		else {
			SecureBuffISOTZoneByUTZNameIdxKey mapped = new SecureBuffISOTZoneByUTZNameIdxKey();
			mapped.setRequiredTZName( key.getRequiredTZName() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOTZoneByIso8601IdxKey newByIso8601IdxKey() {
		ISecureISOTZoneByIso8601IdxKey key =
			new SecureBuffISOTZoneByIso8601IdxKey();
		return( key );
	}

	public SecureBuffISOTZoneByIso8601IdxKey ensureByIso8601IdxKey(ISecureISOTZoneByIso8601IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOTZoneByIso8601IdxKey) {
			return( (SecureBuffISOTZoneByIso8601IdxKey)key );
		}
		else {
			SecureBuffISOTZoneByIso8601IdxKey mapped = new SecureBuffISOTZoneByIso8601IdxKey();
			mapped.setRequiredIso8601( key.getRequiredIso8601() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOTZone newRec() {
		ISecureISOTZone rec =
			new SecureBuffISOTZone();
		return( rec );
	}

	public SecureBuffISOTZone ensureRec(ISecureISOTZone rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffISOTZone) {
			return ((SecureBuffISOTZone)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureISOTZone.CLASS_CODE: {
					SecureBuffISOTZone mapped = new SecureBuffISOTZone();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOTZone",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOTZone");
			}
		}
	}

	@Override
	public ISecureISOTZoneH newHRec() {
		ISecureISOTZoneH hrec =
			new SecureBuffISOTZoneH();
		return( hrec );
	}

	public SecureBuffISOTZoneH ensureHRec(ISecureISOTZoneH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffISOTZoneH) {
			return ((SecureBuffISOTZoneH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureISOTZone.CLASS_CODE: {
					SecureBuffISOTZoneH mapped = new SecureBuffISOTZoneH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOTZone",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOTZone");
			}
		}
	}
}
