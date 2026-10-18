// Description: Java 25 implementation of an in-memory RAM IntNet schema.

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

package server.markhome.ycf.v3_1.intnet.intnetram;

import java.lang.reflect.*;
import java.net.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;

import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.secure.secure.buff.*;
import server.markhome.ycf.v3_1.intnet.intnet.buff.*;
import server.markhome.ycf.v3_1.intnet.intnetsaxloader.*;

import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffSchema;
import server.markhome.ycf.v3_1.secure.secure.buff.SecureBuffFactoryService;
//import server.markhome.ycf.v3_1.intnet.intnetpub.buff.IntNetPubBuffFactoryService;

public class IntNetRamSchema
	extends IntNetBuffSchema
	implements IIntNetSchema
{
	protected int nextMimeTypeIdGenValue = 1;
	protected int nextURLProtocolIdGenValue = 1;


	public IntNetRamSchema() {
		super();
		tableLicense = new IntNetRamLicenseTable( this );
		tableMajorVersion = new IntNetRamMajorVersionTable( this );
		tableMimeType = new IntNetRamMimeTypeTable( this );
		tableMinorVersion = new IntNetRamMinorVersionTable( this );
		tableSubProject = new IntNetRamSubProjectTable( this );
		tableTld = new IntNetRamTldTable( this );
		tableTopDomain = new IntNetRamTopDomainTable( this );
		tableTopProject = new IntNetRamTopProjectTable( this );
		tableURLProtocol = new IntNetRamURLProtocolTable( this );
	}

	@Override
	public IIntNetSchema newSchema() {
		throw new YCFMustOverrideException( getClass(), "newSchema" );
	}

	@Override
	public int nextMimeTypeIdGen() {
		int next = nextMimeTypeIdGenValue++;
		return( next );
	}

	@Override
	public int nextURLProtocolIdGen() {
		int next = nextURLProtocolIdGenValue++;
		return( next );
	}

	@Override
	public YCFDbKeyHash256 nextMajorVersionIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextMinorVersionIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextSubProjectIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextTldIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextTopDomainIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextTopProjectIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	@Override
	public YCFDbKeyHash256 nextLicenseIdGen() {
		YCFDbKeyHash256 retval = new YCFDbKeyHash256(0);
		return( retval );
	}

	public String fileImport( SecureAuthorization Authorization,
		String fileName,
		String fileContent )
	{
		final String S_ProcName = "fileImport";
		if( ( fileName == null ) || ( fileName.length() <= 0 ) ) {
			throw new YCFNullArgumentException( getClass(),
				S_ProcName,
				1,
				"fileName" );
		}
		if( ( fileContent == null ) || ( fileContent.length() <= 0 ) ) {
			throw new YCFNullArgumentException( getClass(),
				S_ProcName,
				2,
				"fileContent" );
		}

		IntNetSaxLoader saxLoader = new IntNetSaxLoader();
		IIntNetSchemaObj schemaObj = new IntNetSchemaObj();
		schemaObj.setIntNetBackingStore( this );
		saxLoader.setSchemaObj( schemaObj );
		ISecureClusterObj useCluster = schemaObj.getClusterTableObj().readClusterByIdIdx( Authorization.getSecClusterId() );
		ISecureTenantObj useTenant = schemaObj.getTenantTableObj().readTenantByIdIdx( Authorization.getSecTenantId() );
		YCFCachedMessageLog runlog = new YCFCachedMessageLog();
		saxLoader.setLog( runlog );
		saxLoader.setUseCluster( useCluster );
		saxLoader.setUseTenant( useTenant );
		saxLoader.parseStringContents( fileContent );
		String logFileContent = runlog.getCacheContents();
		if( logFileContent == null ) {
			logFileContent = "";
		}

		return( logFileContent );
	}

		
	@Override
	public void wireTableTableInstances() {
		if (tableLicense == null || !(tableLicense instanceof IntNetRamLicenseTable)) {
			tableLicense = new IntNetRamLicenseTable(this);
		}
		if (tableMajorVersion == null || !(tableMajorVersion instanceof IntNetRamMajorVersionTable)) {
			tableMajorVersion = new IntNetRamMajorVersionTable(this);
		}
		if (tableMimeType == null || !(tableMimeType instanceof IntNetRamMimeTypeTable)) {
			tableMimeType = new IntNetRamMimeTypeTable(this);
		}
		if (tableMinorVersion == null || !(tableMinorVersion instanceof IntNetRamMinorVersionTable)) {
			tableMinorVersion = new IntNetRamMinorVersionTable(this);
		}
		if (tableSubProject == null || !(tableSubProject instanceof IntNetRamSubProjectTable)) {
			tableSubProject = new IntNetRamSubProjectTable(this);
		}
		if (tableTld == null || !(tableTld instanceof IntNetRamTldTable)) {
			tableTld = new IntNetRamTldTable(this);
		}
		if (tableTopDomain == null || !(tableTopDomain instanceof IntNetRamTopDomainTable)) {
			tableTopDomain = new IntNetRamTopDomainTable(this);
		}
		if (tableTopProject == null || !(tableTopProject instanceof IntNetRamTopProjectTable)) {
			tableTopProject = new IntNetRamTopProjectTable(this);
		}
		if (tableURLProtocol == null || !(tableURLProtocol instanceof IntNetRamURLProtocolTable)) {
			tableURLProtocol = new IntNetRamURLProtocolTable(this);
		}
	}
}
