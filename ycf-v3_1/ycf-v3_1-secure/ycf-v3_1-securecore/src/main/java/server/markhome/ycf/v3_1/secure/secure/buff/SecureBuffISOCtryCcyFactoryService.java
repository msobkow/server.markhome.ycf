
// Description: Java 25 Factory service implementation for ISOCtryCcy buffers

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
 *	Java 25 Factory service implementation for ISOCtryCcy buffers.
 */
@Service("secure31BuffISOCtryCcyFactoryService")
public class SecureBuffISOCtryCcyFactoryService
	implements ISecureISOCtryCcyFactory
{
	public SecureBuffISOCtryCcyFactoryService() {
	}

    @Override
    public ISecureISOCtryCcyPKey newPKey() {
        ISecureISOCtryCcyPKey pkey =
            new SecureBuffISOCtryCcyPKey();
        return( pkey );
    }

	public SecureBuffISOCtryCcyPKey ensurePKey(ISecureISOCtryCcyPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOCtryCcyPKey) {
			return( (SecureBuffISOCtryCcyPKey)key );
		}
		else {
			SecureBuffISOCtryCcyPKey mapped = new SecureBuffISOCtryCcyPKey();
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			mapped.setRequiredISOCcyId( key.getRequiredISOCcyId() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOCtryCcyHPKey newHPKey() {
		ISecureISOCtryCcyHPKey hpkey =
			new SecureBuffISOCtryCcyHPKey();
		return( hpkey );
	}

	public SecureBuffISOCtryCcyHPKey ensureHPKey(ISecureISOCtryCcyHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffISOCtryCcyHPKey) {
			return( (SecureBuffISOCtryCcyHPKey)key );
		}
		else {
			SecureBuffISOCtryCcyHPKey mapped = new SecureBuffISOCtryCcyHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			mapped.setRequiredISOCcyId( key.getRequiredISOCcyId() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOCtryCcyByCtryIdxKey newByCtryIdxKey() {
		ISecureISOCtryCcyByCtryIdxKey key =
			new SecureBuffISOCtryCcyByCtryIdxKey();
		return( key );
	}

	public SecureBuffISOCtryCcyByCtryIdxKey ensureByCtryIdxKey(ISecureISOCtryCcyByCtryIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOCtryCcyByCtryIdxKey) {
			return( (SecureBuffISOCtryCcyByCtryIdxKey)key );
		}
		else {
			SecureBuffISOCtryCcyByCtryIdxKey mapped = new SecureBuffISOCtryCcyByCtryIdxKey();
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOCtryCcyByCcyIdxKey newByCcyIdxKey() {
		ISecureISOCtryCcyByCcyIdxKey key =
			new SecureBuffISOCtryCcyByCcyIdxKey();
		return( key );
	}

	public SecureBuffISOCtryCcyByCcyIdxKey ensureByCcyIdxKey(ISecureISOCtryCcyByCcyIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOCtryCcyByCcyIdxKey) {
			return( (SecureBuffISOCtryCcyByCcyIdxKey)key );
		}
		else {
			SecureBuffISOCtryCcyByCcyIdxKey mapped = new SecureBuffISOCtryCcyByCcyIdxKey();
			mapped.setRequiredISOCcyId( key.getRequiredISOCcyId() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOCtryCcy newRec() {
		ISecureISOCtryCcy rec =
			new SecureBuffISOCtryCcy();
		return( rec );
	}

	public SecureBuffISOCtryCcy ensureRec(ISecureISOCtryCcy rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffISOCtryCcy) {
			return ((SecureBuffISOCtryCcy)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureISOCtryCcy.CLASS_CODE: {
					SecureBuffISOCtryCcy mapped = new SecureBuffISOCtryCcy();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCtryCcy",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCtryCcy");
			}
		}
	}

	@Override
	public ISecureISOCtryCcyH newHRec() {
		ISecureISOCtryCcyH hrec =
			new SecureBuffISOCtryCcyH();
		return( hrec );
	}

	public SecureBuffISOCtryCcyH ensureHRec(ISecureISOCtryCcyH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffISOCtryCcyH) {
			return ((SecureBuffISOCtryCcyH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureISOCtryCcy.CLASS_CODE: {
					SecureBuffISOCtryCcyH mapped = new SecureBuffISOCtryCcyH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCtryCcy",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCtryCcy");
			}
		}
	}
}
