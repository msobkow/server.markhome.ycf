
// Description: Java 25 Factory service implementation for ISOCtry buffers

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
 *	Java 25 Factory service implementation for ISOCtry buffers.
 */
@Service("secure31BuffISOCtryFactoryService")
public class SecureBuffISOCtryFactoryService
	implements ISecureISOCtryFactory
{
	public SecureBuffISOCtryFactoryService() {
	}

	@Override
	public ISecureISOCtryHPKey newHPKey() {
		ISecureISOCtryHPKey hpkey =
			new SecureBuffISOCtryHPKey();
		return( hpkey );
	}

	public SecureBuffISOCtryHPKey ensureHPKey(ISecureISOCtryHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffISOCtryHPKey) {
			return( (SecureBuffISOCtryHPKey)key );
		}
		else {
			SecureBuffISOCtryHPKey mapped = new SecureBuffISOCtryHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOCtryByISOCodeIdxKey newByISOCodeIdxKey() {
		ISecureISOCtryByISOCodeIdxKey key =
			new SecureBuffISOCtryByISOCodeIdxKey();
		return( key );
	}

	public SecureBuffISOCtryByISOCodeIdxKey ensureByISOCodeIdxKey(ISecureISOCtryByISOCodeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOCtryByISOCodeIdxKey) {
			return( (SecureBuffISOCtryByISOCodeIdxKey)key );
		}
		else {
			SecureBuffISOCtryByISOCodeIdxKey mapped = new SecureBuffISOCtryByISOCodeIdxKey();
			mapped.setRequiredISOCode( key.getRequiredISOCode() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOCtryByNameIdxKey newByNameIdxKey() {
		ISecureISOCtryByNameIdxKey key =
			new SecureBuffISOCtryByNameIdxKey();
		return( key );
	}

	public SecureBuffISOCtryByNameIdxKey ensureByNameIdxKey(ISecureISOCtryByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOCtryByNameIdxKey) {
			return( (SecureBuffISOCtryByNameIdxKey)key );
		}
		else {
			SecureBuffISOCtryByNameIdxKey mapped = new SecureBuffISOCtryByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOCtry newRec() {
		ISecureISOCtry rec =
			new SecureBuffISOCtry();
		return( rec );
	}

	public SecureBuffISOCtry ensureRec(ISecureISOCtry rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffISOCtry) {
			return ((SecureBuffISOCtry)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureISOCtry.CLASS_CODE: {
					SecureBuffISOCtry mapped = new SecureBuffISOCtry();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCtry",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCtry");
			}
		}
	}

	@Override
	public ISecureISOCtryH newHRec() {
		ISecureISOCtryH hrec =
			new SecureBuffISOCtryH();
		return( hrec );
	}

	public SecureBuffISOCtryH ensureHRec(ISecureISOCtryH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffISOCtryH) {
			return ((SecureBuffISOCtryH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureISOCtry.CLASS_CODE: {
					SecureBuffISOCtryH mapped = new SecureBuffISOCtryH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCtry",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCtry");
			}
		}
	}
}
