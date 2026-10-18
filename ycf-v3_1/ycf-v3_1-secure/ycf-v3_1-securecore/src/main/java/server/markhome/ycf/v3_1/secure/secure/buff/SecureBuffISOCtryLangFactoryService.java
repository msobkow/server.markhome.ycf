
// Description: Java 25 Factory service implementation for ISOCtryLang buffers

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
 *	Java 25 Factory service implementation for ISOCtryLang buffers.
 */
@Service("secure31BuffISOCtryLangFactoryService")
public class SecureBuffISOCtryLangFactoryService
	implements ISecureISOCtryLangFactory
{
	public SecureBuffISOCtryLangFactoryService() {
	}

    @Override
    public ISecureISOCtryLangPKey newPKey() {
        ISecureISOCtryLangPKey pkey =
            new SecureBuffISOCtryLangPKey();
        return( pkey );
    }

	public SecureBuffISOCtryLangPKey ensurePKey(ISecureISOCtryLangPKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOCtryLangPKey) {
			return( (SecureBuffISOCtryLangPKey)key );
		}
		else {
			SecureBuffISOCtryLangPKey mapped = new SecureBuffISOCtryLangPKey();
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			mapped.setRequiredISOLangId( key.getRequiredISOLangId() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOCtryLangHPKey newHPKey() {
		ISecureISOCtryLangHPKey hpkey =
			new SecureBuffISOCtryLangHPKey();
		return( hpkey );
	}

	public SecureBuffISOCtryLangHPKey ensureHPKey(ISecureISOCtryLangHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffISOCtryLangHPKey) {
			return( (SecureBuffISOCtryLangHPKey)key );
		}
		else {
			SecureBuffISOCtryLangHPKey mapped = new SecureBuffISOCtryLangHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			mapped.setRequiredISOLangId( key.getRequiredISOLangId() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOCtryLangByCtryIdxKey newByCtryIdxKey() {
		ISecureISOCtryLangByCtryIdxKey key =
			new SecureBuffISOCtryLangByCtryIdxKey();
		return( key );
	}

	public SecureBuffISOCtryLangByCtryIdxKey ensureByCtryIdxKey(ISecureISOCtryLangByCtryIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOCtryLangByCtryIdxKey) {
			return( (SecureBuffISOCtryLangByCtryIdxKey)key );
		}
		else {
			SecureBuffISOCtryLangByCtryIdxKey mapped = new SecureBuffISOCtryLangByCtryIdxKey();
			mapped.setRequiredISOCtryId( key.getRequiredISOCtryId() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOCtryLangByLangIdxKey newByLangIdxKey() {
		ISecureISOCtryLangByLangIdxKey key =
			new SecureBuffISOCtryLangByLangIdxKey();
		return( key );
	}

	public SecureBuffISOCtryLangByLangIdxKey ensureByLangIdxKey(ISecureISOCtryLangByLangIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOCtryLangByLangIdxKey) {
			return( (SecureBuffISOCtryLangByLangIdxKey)key );
		}
		else {
			SecureBuffISOCtryLangByLangIdxKey mapped = new SecureBuffISOCtryLangByLangIdxKey();
			mapped.setRequiredISOLangId( key.getRequiredISOLangId() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOCtryLang newRec() {
		ISecureISOCtryLang rec =
			new SecureBuffISOCtryLang();
		return( rec );
	}

	public SecureBuffISOCtryLang ensureRec(ISecureISOCtryLang rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffISOCtryLang) {
			return ((SecureBuffISOCtryLang)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureISOCtryLang.CLASS_CODE: {
					SecureBuffISOCtryLang mapped = new SecureBuffISOCtryLang();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCtryLang",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOCtryLang");
			}
		}
	}

	@Override
	public ISecureISOCtryLangH newHRec() {
		ISecureISOCtryLangH hrec =
			new SecureBuffISOCtryLangH();
		return( hrec );
	}

	public SecureBuffISOCtryLangH ensureHRec(ISecureISOCtryLangH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffISOCtryLangH) {
			return ((SecureBuffISOCtryLangH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureISOCtryLang.CLASS_CODE: {
					SecureBuffISOCtryLangH mapped = new SecureBuffISOCtryLangH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCtryLang",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOCtryLang");
			}
		}
	}
}
