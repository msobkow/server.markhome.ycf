
// Description: Java 25 Factory service implementation for ISOCcy buffers

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
 *	Java 25 Factory service implementation for ISOCcy buffers.
 */
@Service("secure31BuffISOCcyFactoryService")
public class SecureBuffISOCcyFactoryService
	implements ISecureISOCcyFactory
{
	public SecureBuffISOCcyFactoryService() {
	}

	@Override
	public ISecureISOCcyHPKey newHPKey() {
		ISecureISOCcyHPKey hpkey =
			new SecureBuffISOCcyHPKey();
		return( hpkey );
	}

	public SecureBuffISOCcyHPKey ensureHPKey(ISecureISOCcyHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffISOCcyHPKey) {
			return( (SecureBuffISOCcyHPKey)key );
		}
		else {
			SecureBuffISOCcyHPKey mapped = new SecureBuffISOCcyHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOCcyId( key.getRequiredISOCcyId() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOCcyByCcyCdIdxKey newByCcyCdIdxKey() {
		ISecureISOCcyByCcyCdIdxKey key =
			new SecureBuffISOCcyByCcyCdIdxKey();
		return( key );
	}

	public SecureBuffISOCcyByCcyCdIdxKey ensureByCcyCdIdxKey(ISecureISOCcyByCcyCdIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOCcyByCcyCdIdxKey) {
			return( (SecureBuffISOCcyByCcyCdIdxKey)key );
		}
		else {
			SecureBuffISOCcyByCcyCdIdxKey mapped = new SecureBuffISOCcyByCcyCdIdxKey();
			mapped.setRequiredISOCode( key.getRequiredISOCode() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOCcyByCcyNmIdxKey newByCcyNmIdxKey() {
		ISecureISOCcyByCcyNmIdxKey key =
			new SecureBuffISOCcyByCcyNmIdxKey();
		return( key );
	}

	public SecureBuffISOCcyByCcyNmIdxKey ensureByCcyNmIdxKey(ISecureISOCcyByCcyNmIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOCcyByCcyNmIdxKey) {
			return( (SecureBuffISOCcyByCcyNmIdxKey)key );
		}
		else {
			SecureBuffISOCcyByCcyNmIdxKey mapped = new SecureBuffISOCcyByCcyNmIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOCcy newRec() {
		ISecureISOCcy rec =
			new SecureBuffISOCcy();
		return( rec );
	}

	public SecureBuffISOCcy ensureRec(ISecureISOCcy rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffISOCcy) {
			return ((SecureBuffISOCcy)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureISOCcy.CLASS_CODE: {
					SecureBuffISOCcy mapped = new SecureBuffISOCcy();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCcy",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCcy");
			}
		}
	}

	@Override
	public ISecureISOCcyH newHRec() {
		ISecureISOCcyH hrec =
			new SecureBuffISOCcyH();
		return( hrec );
	}

	public SecureBuffISOCcyH ensureHRec(ISecureISOCcyH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffISOCcyH) {
			return ((SecureBuffISOCcyH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureISOCcy.CLASS_CODE: {
					SecureBuffISOCcyH mapped = new SecureBuffISOCcyH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCcy",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCcy");
			}
		}
	}
}
