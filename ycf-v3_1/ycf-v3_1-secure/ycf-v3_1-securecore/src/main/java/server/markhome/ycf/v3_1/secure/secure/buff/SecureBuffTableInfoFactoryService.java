
// Description: Java 25 Factory service implementation for TableInfo buffers

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
 *	Java 25 Factory service implementation for TableInfo buffers.
 */
@Service("secure31BuffTableInfoFactoryService")
public class SecureBuffTableInfoFactoryService
	implements ISecureTableInfoFactory
{
	public SecureBuffTableInfoFactoryService() {
	}

	@Override
	public ISecureTableInfoHPKey newHPKey() {
		ISecureTableInfoHPKey hpkey =
			new SecureBuffTableInfoHPKey();
		return( hpkey );
	}

	public SecureBuffTableInfoHPKey ensureHPKey(ISecureTableInfoHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof SecureBuffTableInfoHPKey) {
			return( (SecureBuffTableInfoHPKey)key );
		}
		else {
			SecureBuffTableInfoHPKey mapped = new SecureBuffTableInfoHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredTableInfoId( key.getRequiredTableInfoId() );
			return( mapped );
		}
	}

	@Override
	public ISecureTableInfoByTableNameIdxKey newByTableNameIdxKey() {
		ISecureTableInfoByTableNameIdxKey key =
			new SecureBuffTableInfoByTableNameIdxKey();
		return( key );
	}

	public SecureBuffTableInfoByTableNameIdxKey ensureByTableNameIdxKey(ISecureTableInfoByTableNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffTableInfoByTableNameIdxKey) {
			return( (SecureBuffTableInfoByTableNameIdxKey)key );
		}
		else {
			SecureBuffTableInfoByTableNameIdxKey mapped = new SecureBuffTableInfoByTableNameIdxKey();
			mapped.setRequiredTableName( key.getRequiredTableName() );
			return( mapped );
		}
	}

	@Override
	public ISecureTableInfoBySuperNameIdxKey newBySuperNameIdxKey() {
		ISecureTableInfoBySuperNameIdxKey key =
			new SecureBuffTableInfoBySuperNameIdxKey();
		return( key );
	}

	public SecureBuffTableInfoBySuperNameIdxKey ensureBySuperNameIdxKey(ISecureTableInfoBySuperNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffTableInfoBySuperNameIdxKey) {
			return( (SecureBuffTableInfoBySuperNameIdxKey)key );
		}
		else {
			SecureBuffTableInfoBySuperNameIdxKey mapped = new SecureBuffTableInfoBySuperNameIdxKey();
			mapped.setOptionalSuperName( key.getOptionalSuperName() );
			return( mapped );
		}
	}

	@Override
	public ISecureTableInfoBySchemaNameIdxKey newBySchemaNameIdxKey() {
		ISecureTableInfoBySchemaNameIdxKey key =
			new SecureBuffTableInfoBySchemaNameIdxKey();
		return( key );
	}

	public SecureBuffTableInfoBySchemaNameIdxKey ensureBySchemaNameIdxKey(ISecureTableInfoBySchemaNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffTableInfoBySchemaNameIdxKey) {
			return( (SecureBuffTableInfoBySchemaNameIdxKey)key );
		}
		else {
			SecureBuffTableInfoBySchemaNameIdxKey mapped = new SecureBuffTableInfoBySchemaNameIdxKey();
			mapped.setRequiredSchemaName( key.getRequiredSchemaName() );
			return( mapped );
		}
	}

	@Override
	public ISecureTableInfoBySchemaBkCodeIdxKey newBySchemaBkCodeIdxKey() {
		ISecureTableInfoBySchemaBkCodeIdxKey key =
			new SecureBuffTableInfoBySchemaBkCodeIdxKey();
		return( key );
	}

	public SecureBuffTableInfoBySchemaBkCodeIdxKey ensureBySchemaBkCodeIdxKey(ISecureTableInfoBySchemaBkCodeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffTableInfoBySchemaBkCodeIdxKey) {
			return( (SecureBuffTableInfoBySchemaBkCodeIdxKey)key );
		}
		else {
			SecureBuffTableInfoBySchemaBkCodeIdxKey mapped = new SecureBuffTableInfoBySchemaBkCodeIdxKey();
			mapped.setRequiredSchemaName( key.getRequiredSchemaName() );
			mapped.setRequiredBackingClassCode( key.getRequiredBackingClassCode() );
			return( mapped );
		}
	}

	@Override
	public ISecureTableInfoBySchemaRTCodeIdxKey newBySchemaRTCodeIdxKey() {
		ISecureTableInfoBySchemaRTCodeIdxKey key =
			new SecureBuffTableInfoBySchemaRTCodeIdxKey();
		return( key );
	}

	public SecureBuffTableInfoBySchemaRTCodeIdxKey ensureBySchemaRTCodeIdxKey(ISecureTableInfoBySchemaRTCodeIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof SecureBuffTableInfoBySchemaRTCodeIdxKey) {
			return( (SecureBuffTableInfoBySchemaRTCodeIdxKey)key );
		}
		else {
			SecureBuffTableInfoBySchemaRTCodeIdxKey mapped = new SecureBuffTableInfoBySchemaRTCodeIdxKey();
			mapped.setRequiredRuntimeClassCode( key.getRequiredRuntimeClassCode() );
			return( mapped );
		}
	}

	@Override
	public ISecureTableInfo newRec() {
		ISecureTableInfo rec =
			new SecureBuffTableInfo();
		return( rec );
	}

	public SecureBuffTableInfo ensureRec(ISecureTableInfo rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof SecureBuffTableInfo) {
			return ((SecureBuffTableInfo)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case ISecureTableInfo.CLASS_CODE: {
					SecureBuffTableInfo mapped = new SecureBuffTableInfo();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureTableInfo",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of SecureTableInfo");
			}
		}
	}

	@Override
	public ISecureTableInfoH newHRec() {
		ISecureTableInfoH hrec =
			new SecureBuffTableInfoH();
		return( hrec );
	}

	public SecureBuffTableInfoH ensureHRec(ISecureTableInfoH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof SecureBuffTableInfoH) {
			return ((SecureBuffTableInfoH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case ISecureTableInfo.CLASS_CODE: {
					SecureBuffTableInfoH mapped = new SecureBuffTableInfoH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureTableInfo",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of SecureTableInfo");
			}
		}
	}
}
