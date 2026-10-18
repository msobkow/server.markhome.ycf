
// Description: Java 25 Factory service implementation for MimeType buffers

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
 *	Java 25 Factory service implementation for MimeType buffers.
 */
@Service("intnet31BuffMimeTypeFactoryService")
public class IntNetBuffMimeTypeFactoryService
	implements IIntNetMimeTypeFactory
{
	public IntNetBuffMimeTypeFactoryService() {
	}

	@Override
	public IIntNetMimeTypeHPKey newHPKey() {
		IIntNetMimeTypeHPKey hpkey =
			new IntNetBuffMimeTypeHPKey();
		return( hpkey );
	}

	public IntNetBuffMimeTypeHPKey ensureHPKey(IIntNetMimeTypeHPKey key) {
		if (key == null) {
			return( null );
		}
		else if( key instanceof IntNetBuffMimeTypeHPKey) {
			return( (IntNetBuffMimeTypeHPKey)key );
		}
		else {
			IntNetBuffMimeTypeHPKey mapped = new IntNetBuffMimeTypeHPKey();
			mapped.setAuditClusterId(key.getAuditClusterId());
			mapped.setAuditActionId(key.getAuditActionId());
			mapped.setAuditSessionId(key.getAuditSessionId());
			mapped.setAuditStamp(key.getAuditStamp());
			mapped.setRequiredMimeTypeId( key.getRequiredMimeTypeId() );
			return( mapped );
		}
	}

	@Override
	public IIntNetMimeTypeByUNameIdxKey newByUNameIdxKey() {
		IIntNetMimeTypeByUNameIdxKey key =
			new IntNetBuffMimeTypeByUNameIdxKey();
		return( key );
	}

	public IntNetBuffMimeTypeByUNameIdxKey ensureByUNameIdxKey(IIntNetMimeTypeByUNameIdxKey key) {
		if (key == null) {
			return( null );
		}
		else if (key instanceof IntNetBuffMimeTypeByUNameIdxKey) {
			return( (IntNetBuffMimeTypeByUNameIdxKey)key );
		}
		else {
			IntNetBuffMimeTypeByUNameIdxKey mapped = new IntNetBuffMimeTypeByUNameIdxKey();
			mapped.setRequiredName( key.getRequiredName() );
			return( mapped );
		}
	}

	@Override
	public IIntNetMimeType newRec() {
		IIntNetMimeType rec =
			new IntNetBuffMimeType();
		return( rec );
	}

	public IntNetBuffMimeType ensureRec(IIntNetMimeType rec) {
		if( rec == null ) {
			return( null );
		}
		else if (rec instanceof IntNetBuffMimeType) {
			return ((IntNetBuffMimeType)rec);
		}
		else {	
			switch (rec.getClassCode()) {
				case IIntNetMimeType.CLASS_CODE: {
					IntNetBuffMimeType mapped = new IntNetBuffMimeType();
					mapped.set(rec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureRec",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetMimeType",
						"Unsupported class code " + rec.getClassCode() + " is not a derivative of IntNetMimeType");
			}
		}
	}

	@Override
	public IIntNetMimeTypeH newHRec() {
		IIntNetMimeTypeH hrec =
			new IntNetBuffMimeTypeH();
		return( hrec );
	}

	public IntNetBuffMimeTypeH ensureHRec(IIntNetMimeTypeH hrec) {
		if( hrec == null ) {
			return( null );
		}
		else if (hrec instanceof IntNetBuffMimeTypeH) {
			return ((IntNetBuffMimeTypeH)hrec);
		}
		else {	
			switch (hrec.getClassCode()) {
				case IIntNetMimeType.CLASS_CODE: {
					IntNetBuffMimeTypeH mapped = new IntNetBuffMimeTypeH();
					mapped.set(hrec);
					return(mapped); }
				default:
					throw new YCFUnsupportedClassException(getClass(), "ensureHRec",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetMimeType",
						"Unsupported class code " + hrec.getClassCode() + " is not a derivative of IntNetMimeType");
			}
		}
	}
}
