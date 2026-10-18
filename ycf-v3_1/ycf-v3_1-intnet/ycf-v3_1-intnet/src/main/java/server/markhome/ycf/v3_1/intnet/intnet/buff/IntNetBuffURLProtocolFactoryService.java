
// Description: Java 25 Factory service implementation for URLProtocol buffers

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnet.buff;

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
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetprot.*;
import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;

/*
 *	Java 25 Factory service implementation for URLProtocol buffers.
 */
@Service("intnet31BuffURLProtocolFactoryService")
public class IntNetBuffURLProtocolFactoryService
	implements IIntNetURLProtocolFactory
{
	public IntNetBuffURLProtocolFactoryService() {
	}

	@Override
	public IIntNetURLProtocolHPKey newHPKey() {
		IIntNetURLProtocolHPKey hpkey =
			new IntNetBuffURLProtocolHPKey();
		return( hpkey );
	}

	public IntNetBuffURLProtocolHPKey ensureHPKey(IIntNetURLProtocolHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetBuffURLProtocolHPKey) {
			return( (IntNetBuffURLProtocolHPKey)key );
		}
		else {
			IntNetBuffURLProtocolHPKey mapped = new IntNetBuffURLProtocolHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredURLProtocolId( key.getRequiredURLProtocolId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetURLProtocolByUNameIdxKey newByUNameIdxKey() {
		IIntNetURLProtocolByUNameIdxKey key =
			new IntNetBuffURLProtocolByUNameIdxKey();
		return( key );
	}

	public IntNetBuffURLProtocolByUNameIdxKey ensureByUNameIdxKey(IIntNetURLProtocolByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffURLProtocolByUNameIdxKey) {
			return( (IntNetBuffURLProtocolByUNameIdxKey)key );
		}
		else {
			IntNetBuffURLProtocolByUNameIdxKey mapped = new IntNetBuffURLProtocolByUNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IIntNetURLProtocolByIsSecureIdxKey newByIsSecureIdxKey() {
		IIntNetURLProtocolByIsSecureIdxKey key =
			new IntNetBuffURLProtocolByIsSecureIdxKey();
		return( key );
	}

	public IntNetBuffURLProtocolByIsSecureIdxKey ensureByIsSecureIdxKey(IIntNetURLProtocolByIsSecureIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffURLProtocolByIsSecureIdxKey) {
			return( (IntNetBuffURLProtocolByIsSecureIdxKey)key );
		}
		else {
			IntNetBuffURLProtocolByIsSecureIdxKey mapped = new IntNetBuffURLProtocolByIsSecureIdxKey();
			mapped.setRequiredIsSecure( key.getRequiredIsSecure() );
			return( mapped );
		}
	}

	@Override
	public IIntNetURLProtocol newRec() {
		IIntNetURLProtocol rec =
			new IntNetBuffURLProtocol();
		return( rec );
	}

	public IntNetBuffURLProtocol ensureRec(IIntNetURLProtocol rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetBuffURLProtocol) {
			return ((IntNetBuffURLProtocol)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IIntNetURLProtocol.CLASS_CODE: {
					IntNetBuffURLProtocol mapped = new IntNetBuffURLProtocol();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetURLProtocol",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetURLProtocol");
			}
		}
	}

	@Override
	public IIntNetURLProtocolH newHRec() {
		IIntNetURLProtocolH hrec =
			new IntNetBuffURLProtocolH();
		return( hrec );
	}

	public IntNetBuffURLProtocolH ensureHRec(IIntNetURLProtocolH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetBuffURLProtocolH) {
			return ((IntNetBuffURLProtocolH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IIntNetURLProtocol.CLASS_CODE: {
					IntNetBuffURLProtocolH mapped = new IntNetBuffURLProtocolH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetURLProtocol",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetURLProtocol");
			}
		}
	}
}
