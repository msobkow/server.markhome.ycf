
// Description: Java 25 Factory service implementation for Tld buffers

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
 *	Java 25 Factory service implementation for Tld buffers.
 */
@Service("intnet31BuffTldFactoryService")
public class IntNetBuffTldFactoryService
	implements IIntNetTldFactory
{
	public IntNetBuffTldFactoryService() {
	}

	@Override
	public IIntNetTldHPKey newHPKey() {
		IIntNetTldHPKey hpkey =
			new IntNetBuffTldHPKey();
		return( hpkey );
	}

	public IntNetBuffTldHPKey ensureHPKey(IIntNetTldHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetBuffTldHPKey) {
			return( (IntNetBuffTldHPKey)key );
		}
		else {
			IntNetBuffTldHPKey mapped = new IntNetBuffTldHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredId( key.getRequiredId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetTldByTenantIdxKey newByTenantIdxKey() {
		IIntNetTldByTenantIdxKey key =
			new IntNetBuffTldByTenantIdxKey();
		return( key );
	}

	public IntNetBuffTldByTenantIdxKey ensureByTenantIdxKey(IIntNetTldByTenantIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffTldByTenantIdxKey) {
			return( (IntNetBuffTldByTenantIdxKey)key );
		}
		else {
			IntNetBuffTldByTenantIdxKey mapped = new IntNetBuffTldByTenantIdxKey();
			mapped.setRequiredTenantId( key.getRequiredTenantId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetTldByNameIdxKey newByNameIdxKey() {
		IIntNetTldByNameIdxKey key =
			new IntNetBuffTldByNameIdxKey();
		return( key );
	}

	public IntNetBuffTldByNameIdxKey ensureByNameIdxKey(IIntNetTldByNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffTldByNameIdxKey) {
			return( (IntNetBuffTldByNameIdxKey)key );
		}
		else {
			IntNetBuffTldByNameIdxKey mapped = new IntNetBuffTldByNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IIntNetTld newRec() {
		IIntNetTld rec =
			new IntNetBuffTld();
		return( rec );
	}

	public IntNetBuffTld ensureRec(IIntNetTld rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetBuffTld) {
			return ((IntNetBuffTld)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IIntNetTld.CLASS_CODE: {
					IntNetBuffTld mapped = new IntNetBuffTld();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetTld",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetTld");
			}
		}
	}

	@Override
	public IIntNetTldH newHRec() {
		IIntNetTldH hrec =
			new IntNetBuffTldH();
		return( hrec );
	}

	public IntNetBuffTldH ensureHRec(IIntNetTldH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetBuffTldH) {
			return ((IntNetBuffTldH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IIntNetTld.CLASS_CODE: {
					IntNetBuffTldH mapped = new IntNetBuffTldH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetTld",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetTld");
			}
		}
	}
}
