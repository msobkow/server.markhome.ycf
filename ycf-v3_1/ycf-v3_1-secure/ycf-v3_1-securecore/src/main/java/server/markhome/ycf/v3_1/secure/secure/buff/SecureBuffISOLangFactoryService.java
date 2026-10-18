
// Description: Java 25 Factory service implementation for ISOLang buffers

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
 *	Java 25 Factory service implementation for ISOLang buffers.
 */
@Service("secure31BuffISOLangFactoryService")
public class SecureBuffISOLangFactoryService
	implements ISecureISOLangFactory
{
	public SecureBuffISOLangFactoryService() {
	}

	@Override
	public ISecureISOLangHPKey newHPKey() {
		ISecureISOLangHPKey hpkey =
			new SecureBuffISOLangHPKey();
		return( hpkey );
	}

	public SecureBuffISOLangHPKey ensureHPKey(ISecureISOLangHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffISOLangHPKey) {
			return( (SecureBuffISOLangHPKey)key );
		}
		else {
			SecureBuffISOLangHPKey mapped = new SecureBuffISOLangHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredISOLangId( key.getRequiredISOLangId() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOLangByCode3IdxKey newByCode3IdxKey() {
		ISecureISOLangByCode3IdxKey key =
			new SecureBuffISOLangByCode3IdxKey();
		return( key );
	}

	public SecureBuffISOLangByCode3IdxKey ensureByCode3IdxKey(ISecureISOLangByCode3IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOLangByCode3IdxKey) {
			return( (SecureBuffISOLangByCode3IdxKey)key );
		}
		else {
			SecureBuffISOLangByCode3IdxKey mapped = new SecureBuffISOLangByCode3IdxKey();
			mapped.setRequiredISO6392Code( key.getRequiredISO6392Code() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOLangByCode2IdxKey newByCode2IdxKey() {
		ISecureISOLangByCode2IdxKey key =
			new SecureBuffISOLangByCode2IdxKey();
		return( key );
	}

	public SecureBuffISOLangByCode2IdxKey ensureByCode2IdxKey(ISecureISOLangByCode2IdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffISOLangByCode2IdxKey) {
			return( (SecureBuffISOLangByCode2IdxKey)key );
		}
		else {
			SecureBuffISOLangByCode2IdxKey mapped = new SecureBuffISOLangByCode2IdxKey();
			mapped.setOptionalISO6391Code( key.getOptionalISO6391Code() );
			return( mapped );
		}
	}

	@Override
	public ISecureISOLang newRec() {
		ISecureISOLang rec =
			new SecureBuffISOLang();
		return( rec );
	}

	public SecureBuffISOLang ensureRec(ISecureISOLang rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffISOLang) {
			return ((SecureBuffISOLang)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureISOLang.CLASS_CODE: {
					SecureBuffISOLang mapped = new SecureBuffISOLang();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOLang",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureISOLang");
			}
		}
	}

	@Override
	public ISecureISOLangH newHRec() {
		ISecureISOLangH hrec =
			new SecureBuffISOLangH();
		return( hrec );
	}

	public SecureBuffISOLangH ensureHRec(ISecureISOLangH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffISOLangH) {
			return ((SecureBuffISOLangH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureISOLang.CLASS_CODE: {
					SecureBuffISOLangH mapped = new SecureBuffISOLangH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOLang",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureISOLang");
			}
		}
	}
}
