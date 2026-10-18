// Description: Java 25 XML SAX Parser for IntNet.

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

package server.markhome.ycf.v3_1.intnet.intnetsaxloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.*;
import java.math.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.text.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.xml.sax.*;

import server.markhome.ycf.*;
import server.markhome.ycf.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;

public class IntNetSaxLoader
	extends YCFLibXmlCoreSaxParser
	implements ContentHandler
{

	// The namespace URI of the supported schema
	public final static String	SCHEMA_XMLNS = "http://ycf.markhome.server/ycf/v3_1/xsd/intnet-structured.xsd";

	// The source for loading the supported schema
	public final static String	SCHEMA_URI = "http://ycf.markhome.server/ycf/v3_1/xsd/intnet-structured.xsd";
	public final static String	SCHEMA_ROOT_URI = "http://ycf.markhome.server/ycf/v3_1/xsd/intnet-structured.xsd";
	public final static String SECURE_XMLNS = "http://ycf.markhome.server/ycf/v3_1/xsd/secure-structured.xsd";
	public final static String SECURE_URI = "http://ycf.markhome.server/ycf/v3_1/xsd/secure-structured.xsd";
	public final static String SECURE_ROOT_URI = "http://ycf.markhome.server/ycf/v3_1/xsd/secure-structured.xsd";


	// The schema instance to load in to

	private IIntNetSchemaObj schemaObj = null;

	// The cluster to use for loading

	private ISecureClusterObj useCluster = null;

	public ISecureClusterObj getUseCluster() {
		return( useCluster );
	}

	public void setUseCluster( ISecureClusterObj value ) {
		useCluster = value;
	}

	// The tenant to use for loading

	private ISecureTenantObj useTenant = null;

	public ISecureTenantObj getUseTenant() {
		return( useTenant );
	}

	public void setUseTenant( ISecureTenantObj value ) {
		useTenant = value;
	}

	// Loader behaviour configuration attributes

	public enum LoaderBehaviourEnum {
		Insert,
		Update,
		Replace
	};
	private LoaderBehaviourEnum clusterLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum iSOCcyLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum iSOCtryLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum iSOCtryCcyLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum iSOCtryLangLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum iSOLangLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum iSOTZoneLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum licenseLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum majorVersionLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum mimeTypeLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum minorVersionLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum secClusGrpLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secClusGrpMembLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secClusRoleLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secClusRoleMembLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSessionLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSysGrpLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSysGrpIncLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSysGrpMembLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSysRoleLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSysRoleEnablesLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secSysRoleMembLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secTentGrpLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secTentGrpMembLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secTentRoleLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secTentRoleMembLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secUserLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secUserEMConfLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secUserPWHistoryLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secUserPWResetLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum secUserPasswordLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum subProjectLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum sysClusterLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum tableInfoLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tenantLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum tldLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum topDomainLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum topProjectLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum uRLProtocolLoaderBehaviour = LoaderBehaviourEnum.Update;


	// Constructors

	public IntNetSaxLoader() {
		super();
		setRootElementHandler( getSaxRootHandler() );
		initParser();
	}

	public IntNetSaxLoader( IYCFLibMessageLog logger ) {
		super( logger );
		setRootElementHandler( getSaxRootHandler() );
		initParser();
	}

	// Element Handler instances

	private IntNetSaxLoaderCluster clusterHandler = null;
	private IntNetSaxLoaderISOCcy iSOCcyHandler = null;
	private IntNetSaxLoaderISOCtry iSOCtryHandler = null;
	private IntNetSaxLoaderISOCtryCcy iSOCtryCcyHandler = null;
	private IntNetSaxLoaderISOCtryLang iSOCtryLangHandler = null;
	private IntNetSaxLoaderISOLang iSOLangHandler = null;
	private IntNetSaxLoaderISOTZone iSOTZoneHandler = null;
	private IntNetSaxLoaderLicense licenseHandler = null;
	private IntNetSaxLoaderMajorVersion majorVersionHandler = null;
	private IntNetSaxLoaderMimeType mimeTypeHandler = null;
	private IntNetSaxLoaderMinorVersion minorVersionHandler = null;
	private IntNetSaxLoaderSecClusGrp secClusGrpHandler = null;
	private IntNetSaxLoaderSecClusGrpMemb secClusGrpMembHandler = null;
	private IntNetSaxLoaderSecClusRole secClusRoleHandler = null;
	private IntNetSaxLoaderSecClusRoleMemb secClusRoleMembHandler = null;
	private IntNetSaxLoaderSecSession secSessionHandler = null;
	private IntNetSaxLoaderSecSysGrp secSysGrpHandler = null;
	private IntNetSaxLoaderSecSysGrpInc secSysGrpIncHandler = null;
	private IntNetSaxLoaderSecSysGrpMemb secSysGrpMembHandler = null;
	private IntNetSaxLoaderSecSysRole secSysRoleHandler = null;
	private IntNetSaxLoaderSecSysRoleEnables secSysRoleEnablesHandler = null;
	private IntNetSaxLoaderSecSysRoleMemb secSysRoleMembHandler = null;
	private IntNetSaxLoaderSecTentGrp secTentGrpHandler = null;
	private IntNetSaxLoaderSecTentGrpMemb secTentGrpMembHandler = null;
	private IntNetSaxLoaderSecTentRole secTentRoleHandler = null;
	private IntNetSaxLoaderSecTentRoleMemb secTentRoleMembHandler = null;
	private IntNetSaxLoaderSecUser secUserHandler = null;
	private IntNetSaxLoaderSecUserEMConf secUserEMConfHandler = null;
	private IntNetSaxLoaderSecUserPWHistory secUserPWHistoryHandler = null;
	private IntNetSaxLoaderSecUserPWReset secUserPWResetHandler = null;
	private IntNetSaxLoaderSecUserPassword secUserPasswordHandler = null;
	private IntNetSaxLoaderSubProject subProjectHandler = null;
	private IntNetSaxLoaderSysCluster sysClusterHandler = null;
	private IntNetSaxLoaderTableInfo tableInfoHandler = null;
	private IntNetSaxLoaderTenant tenantHandler = null;
	private IntNetSaxLoaderTld tldHandler = null;
	private IntNetSaxLoaderTopDomain topDomainHandler = null;
	private IntNetSaxLoaderTopProject topProjectHandler = null;
	private IntNetSaxLoaderURLProtocol uRLProtocolHandler = null;
	private IntNetSaxRootHandler saxRootHandler = null;

	private IntNetSaxDocHandler saxDocHandler = null;

	// Schema object accessors

	// SchemaObj accessors

	public IIntNetSchemaObj getSchemaObj() {
		return( schemaObj );
	}

	public void setSchemaObj( IIntNetSchemaObj value ) {
		schemaObj = value;
	}

	// Element Handler Resolver Factories

	protected IntNetSaxLoaderCluster getClusterHandler() {
		if( clusterHandler == null ) {
			clusterHandler = new IntNetSaxLoaderCluster( this );
			clusterHandler.addElementHandler( "Tenant", getTenantHandler() );
		}
		return( clusterHandler );
	}
	protected IntNetSaxLoaderISOCcy getISOCcyHandler() {
		if( iSOCcyHandler == null ) {
			iSOCcyHandler = new IntNetSaxLoaderISOCcy( this );
		}
		return( iSOCcyHandler );
	}
	protected IntNetSaxLoaderISOCtry getISOCtryHandler() {
		if( iSOCtryHandler == null ) {
			iSOCtryHandler = new IntNetSaxLoaderISOCtry( this );
			iSOCtryHandler.addElementHandler( "ISOCtryCcy", getISOCtryCcyHandler() );
			iSOCtryHandler.addElementHandler( "ISOCtryLang", getISOCtryLangHandler() );
		}
		return( iSOCtryHandler );
	}
	protected IntNetSaxLoaderISOCtryCcy getISOCtryCcyHandler() {
		if( iSOCtryCcyHandler == null ) {
			iSOCtryCcyHandler = new IntNetSaxLoaderISOCtryCcy( this );
		}
		return( iSOCtryCcyHandler );
	}
	protected IntNetSaxLoaderISOCtryLang getISOCtryLangHandler() {
		if( iSOCtryLangHandler == null ) {
			iSOCtryLangHandler = new IntNetSaxLoaderISOCtryLang( this );
		}
		return( iSOCtryLangHandler );
	}
	protected IntNetSaxLoaderISOLang getISOLangHandler() {
		if( iSOLangHandler == null ) {
			iSOLangHandler = new IntNetSaxLoaderISOLang( this );
		}
		return( iSOLangHandler );
	}
	protected IntNetSaxLoaderISOTZone getISOTZoneHandler() {
		if( iSOTZoneHandler == null ) {
			iSOTZoneHandler = new IntNetSaxLoaderISOTZone( this );
		}
		return( iSOTZoneHandler );
	}
	protected IntNetSaxLoaderLicense getLicenseHandler() {
		if( licenseHandler == null ) {
			licenseHandler = new IntNetSaxLoaderLicense( this );
		}
		return( licenseHandler );
	}
	protected IntNetSaxLoaderMajorVersion getMajorVersionHandler() {
		if( majorVersionHandler == null ) {
			majorVersionHandler = new IntNetSaxLoaderMajorVersion( this );
			majorVersionHandler.addElementHandler( "MinorVersion", getMinorVersionHandler() );
		}
		return( majorVersionHandler );
	}
	protected IntNetSaxLoaderMimeType getMimeTypeHandler() {
		if( mimeTypeHandler == null ) {
			mimeTypeHandler = new IntNetSaxLoaderMimeType( this );
		}
		return( mimeTypeHandler );
	}
	protected IntNetSaxLoaderMinorVersion getMinorVersionHandler() {
		if( minorVersionHandler == null ) {
			minorVersionHandler = new IntNetSaxLoaderMinorVersion( this );
		}
		return( minorVersionHandler );
	}
	protected IntNetSaxLoaderSecClusGrp getSecClusGrpHandler() {
		if( secClusGrpHandler == null ) {
			secClusGrpHandler = new IntNetSaxLoaderSecClusGrp( this );
		}
		return( secClusGrpHandler );
	}
	protected IntNetSaxLoaderSecClusGrpMemb getSecClusGrpMembHandler() {
		if( secClusGrpMembHandler == null ) {
			secClusGrpMembHandler = new IntNetSaxLoaderSecClusGrpMemb( this );
		}
		return( secClusGrpMembHandler );
	}
	protected IntNetSaxLoaderSecClusRole getSecClusRoleHandler() {
		if( secClusRoleHandler == null ) {
			secClusRoleHandler = new IntNetSaxLoaderSecClusRole( this );
		}
		return( secClusRoleHandler );
	}
	protected IntNetSaxLoaderSecClusRoleMemb getSecClusRoleMembHandler() {
		if( secClusRoleMembHandler == null ) {
			secClusRoleMembHandler = new IntNetSaxLoaderSecClusRoleMemb( this );
		}
		return( secClusRoleMembHandler );
	}
	protected IntNetSaxLoaderSecSession getSecSessionHandler() {
		if( secSessionHandler == null ) {
			secSessionHandler = new IntNetSaxLoaderSecSession( this );
		}
		return( secSessionHandler );
	}
	protected IntNetSaxLoaderSecSysGrp getSecSysGrpHandler() {
		if( secSysGrpHandler == null ) {
			secSysGrpHandler = new IntNetSaxLoaderSecSysGrp( this );
			secSysGrpHandler.addElementHandler( "SecSysGrpInc", getSecSysGrpIncHandler() );
			secSysGrpHandler.addElementHandler( "SecClusGrp", getSecClusGrpHandler() );
			secSysGrpHandler.addElementHandler( "SecTentGrp", getSecTentGrpHandler() );
			secSysGrpHandler.addElementHandler( "SecClusRole", getSecClusRoleHandler() );
			secSysGrpHandler.addElementHandler( "SecTentRole", getSecTentRoleHandler() );
		}
		return( secSysGrpHandler );
	}
	protected IntNetSaxLoaderSecSysGrpInc getSecSysGrpIncHandler() {
		if( secSysGrpIncHandler == null ) {
			secSysGrpIncHandler = new IntNetSaxLoaderSecSysGrpInc( this );
		}
		return( secSysGrpIncHandler );
	}
	protected IntNetSaxLoaderSecSysGrpMemb getSecSysGrpMembHandler() {
		if( secSysGrpMembHandler == null ) {
			secSysGrpMembHandler = new IntNetSaxLoaderSecSysGrpMemb( this );
		}
		return( secSysGrpMembHandler );
	}
	protected IntNetSaxLoaderSecSysRole getSecSysRoleHandler() {
		if( secSysRoleHandler == null ) {
			secSysRoleHandler = new IntNetSaxLoaderSecSysRole( this );
			secSysRoleHandler.addElementHandler( "SecSysRoleEnables", getSecSysRoleEnablesHandler() );
		}
		return( secSysRoleHandler );
	}
	protected IntNetSaxLoaderSecSysRoleEnables getSecSysRoleEnablesHandler() {
		if( secSysRoleEnablesHandler == null ) {
			secSysRoleEnablesHandler = new IntNetSaxLoaderSecSysRoleEnables( this );
		}
		return( secSysRoleEnablesHandler );
	}
	protected IntNetSaxLoaderSecSysRoleMemb getSecSysRoleMembHandler() {
		if( secSysRoleMembHandler == null ) {
			secSysRoleMembHandler = new IntNetSaxLoaderSecSysRoleMemb( this );
		}
		return( secSysRoleMembHandler );
	}
	protected IntNetSaxLoaderSecTentGrp getSecTentGrpHandler() {
		if( secTentGrpHandler == null ) {
			secTentGrpHandler = new IntNetSaxLoaderSecTentGrp( this );
		}
		return( secTentGrpHandler );
	}
	protected IntNetSaxLoaderSecTentGrpMemb getSecTentGrpMembHandler() {
		if( secTentGrpMembHandler == null ) {
			secTentGrpMembHandler = new IntNetSaxLoaderSecTentGrpMemb( this );
		}
		return( secTentGrpMembHandler );
	}
	protected IntNetSaxLoaderSecTentRole getSecTentRoleHandler() {
		if( secTentRoleHandler == null ) {
			secTentRoleHandler = new IntNetSaxLoaderSecTentRole( this );
		}
		return( secTentRoleHandler );
	}
	protected IntNetSaxLoaderSecTentRoleMemb getSecTentRoleMembHandler() {
		if( secTentRoleMembHandler == null ) {
			secTentRoleMembHandler = new IntNetSaxLoaderSecTentRoleMemb( this );
		}
		return( secTentRoleMembHandler );
	}
	protected IntNetSaxLoaderSecUser getSecUserHandler() {
		if( secUserHandler == null ) {
			secUserHandler = new IntNetSaxLoaderSecUser( this );
			secUserHandler.addElementHandler( "SecSession", getSecSessionHandler() );
			secUserHandler.addElementHandler( "SecUserPassword", getSecUserPasswordHandler() );
			secUserHandler.addElementHandler( "SecUserEMConf", getSecUserEMConfHandler() );
			secUserHandler.addElementHandler( "SecUserPWReset", getSecUserPWResetHandler() );
		}
		return( secUserHandler );
	}
	protected IntNetSaxLoaderSecUserEMConf getSecUserEMConfHandler() {
		if( secUserEMConfHandler == null ) {
			secUserEMConfHandler = new IntNetSaxLoaderSecUserEMConf( this );
		}
		return( secUserEMConfHandler );
	}
	protected IntNetSaxLoaderSecUserPWHistory getSecUserPWHistoryHandler() {
		if( secUserPWHistoryHandler == null ) {
			secUserPWHistoryHandler = new IntNetSaxLoaderSecUserPWHistory( this );
		}
		return( secUserPWHistoryHandler );
	}
	protected IntNetSaxLoaderSecUserPWReset getSecUserPWResetHandler() {
		if( secUserPWResetHandler == null ) {
			secUserPWResetHandler = new IntNetSaxLoaderSecUserPWReset( this );
		}
		return( secUserPWResetHandler );
	}
	protected IntNetSaxLoaderSecUserPassword getSecUserPasswordHandler() {
		if( secUserPasswordHandler == null ) {
			secUserPasswordHandler = new IntNetSaxLoaderSecUserPassword( this );
		}
		return( secUserPasswordHandler );
	}
	protected IntNetSaxLoaderSubProject getSubProjectHandler() {
		if( subProjectHandler == null ) {
			subProjectHandler = new IntNetSaxLoaderSubProject( this );
			subProjectHandler.addElementHandler( "MajorVersion", getMajorVersionHandler() );
		}
		return( subProjectHandler );
	}
	protected IntNetSaxLoaderSysCluster getSysClusterHandler() {
		if( sysClusterHandler == null ) {
			sysClusterHandler = new IntNetSaxLoaderSysCluster( this );
		}
		return( sysClusterHandler );
	}
	protected IntNetSaxLoaderTableInfo getTableInfoHandler() {
		if( tableInfoHandler == null ) {
			tableInfoHandler = new IntNetSaxLoaderTableInfo( this );
		}
		return( tableInfoHandler );
	}
	protected IntNetSaxLoaderTenant getTenantHandler() {
		if( tenantHandler == null ) {
			tenantHandler = new IntNetSaxLoaderTenant( this );
			tenantHandler.addElementHandler( "Tld", getTldHandler() );
		}
		return( tenantHandler );
	}
	protected IntNetSaxLoaderTld getTldHandler() {
		if( tldHandler == null ) {
			tldHandler = new IntNetSaxLoaderTld( this );
			tldHandler.addElementHandler( "TopDomain", getTopDomainHandler() );
		}
		return( tldHandler );
	}
	protected IntNetSaxLoaderTopDomain getTopDomainHandler() {
		if( topDomainHandler == null ) {
			topDomainHandler = new IntNetSaxLoaderTopDomain( this );
			topDomainHandler.addElementHandler( "TopProject", getTopProjectHandler() );
			topDomainHandler.addElementHandler( "License", getLicenseHandler() );
		}
		return( topDomainHandler );
	}
	protected IntNetSaxLoaderTopProject getTopProjectHandler() {
		if( topProjectHandler == null ) {
			topProjectHandler = new IntNetSaxLoaderTopProject( this );
			topProjectHandler.addElementHandler( "SubProject", getSubProjectHandler() );
		}
		return( topProjectHandler );
	}
	protected IntNetSaxLoaderURLProtocol getURLProtocolHandler() {
		if( uRLProtocolHandler == null ) {
			uRLProtocolHandler = new IntNetSaxLoaderURLProtocol( this );
		}
		return( uRLProtocolHandler );
	}
	// Root Element Handler Resolver Factory

	protected IntNetSaxRootHandler getSaxRootHandler() {
		if( saxRootHandler == null ) {
			saxRootHandler = new IntNetSaxRootHandler( this );
			saxRootHandler.addElementHandler( "IntNet", getSaxDocHandler() );
			saxRootHandler.addElementHandler( "Secure", getSaxDocHandler() );
		}
		return( saxRootHandler );
	}

	// Root Element Handler

	/*
	 *	IntNetSaxRootHandler XML SAX Root Element Handler implementation
	 */
	public class IntNetSaxRootHandler
		extends YCFLibXmlCoreElementHandler
	{
		public IntNetSaxRootHandler( IntNetSaxLoader saxLoader ) {
			super( saxLoader );
		}

		public void startElement(
			String		uri,
			String		localName,
			String		qName,
			Attributes	attrs )
		throws SAXException
		{
		}

		public void endElement(
			String		uri,
			String		localName,
			String		qName )
		throws SAXException
		{
		}
	}

	// Document Element Handler Resolver Factory

	protected IntNetSaxDocHandler getSaxDocHandler() {
		if( saxDocHandler == null ) {
			saxDocHandler = new IntNetSaxDocHandler( this );
			saxDocHandler.addElementHandler( "Cluster", getClusterHandler() );
			saxDocHandler.addElementHandler( "ISOCcy", getISOCcyHandler() );
			saxDocHandler.addElementHandler( "ISOCtry", getISOCtryHandler() );
			saxDocHandler.addElementHandler( "ISOLang", getISOLangHandler() );
			saxDocHandler.addElementHandler( "ISOTZone", getISOTZoneHandler() );
			saxDocHandler.addElementHandler( "MimeType", getMimeTypeHandler() );
			saxDocHandler.addElementHandler( "SecSysGrp", getSecSysGrpHandler() );
			saxDocHandler.addElementHandler( "SecSysRole", getSecSysRoleHandler() );
			saxDocHandler.addElementHandler( "SecUser", getSecUserHandler() );
			saxDocHandler.addElementHandler( "SecUserPWHistory", getSecUserPWHistoryHandler() );
			saxDocHandler.addElementHandler( "TableInfo", getTableInfoHandler() );
			saxDocHandler.addElementHandler( "URLProtocol", getURLProtocolHandler() );
		}
		return( saxDocHandler );
	}

	// Document Element Handler

	/*
	 *	IntNetSaxDocHandler XML SAX Doc Element Handler implementation
	 */
	public class IntNetSaxDocHandler
		extends YCFLibXmlCoreElementHandler
	{
		public IntNetSaxDocHandler( IntNetSaxLoader saxLoader ) {
			super( saxLoader );
		}

		public void startElement(
			String		uri,
			String		localName,
			String		qName,
			Attributes	attrs )
		throws SAXException
		{
		}

		public void endElement(
			String		uri,
			String		localName,
			String		qName )
		throws SAXException
		{
		}
	}

	// Loader behaviour configuration accessors

	public LoaderBehaviourEnum getClusterLoaderBehaviour() {
		return( clusterLoaderBehaviour );
	}

	public void setClusterLoaderBehaviour( LoaderBehaviourEnum value ) {
		clusterLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOCcyLoaderBehaviour() {
		return( iSOCcyLoaderBehaviour );
	}

	public void setISOCcyLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOCcyLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOCtryLoaderBehaviour() {
		return( iSOCtryLoaderBehaviour );
	}

	public void setISOCtryLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOCtryLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOCtryCcyLoaderBehaviour() {
		return( iSOCtryCcyLoaderBehaviour );
	}

	public void setISOCtryCcyLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOCtryCcyLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOCtryLangLoaderBehaviour() {
		return( iSOCtryLangLoaderBehaviour );
	}

	public void setISOCtryLangLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOCtryLangLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOLangLoaderBehaviour() {
		return( iSOLangLoaderBehaviour );
	}

	public void setISOLangLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOLangLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getISOTZoneLoaderBehaviour() {
		return( iSOTZoneLoaderBehaviour );
	}

	public void setISOTZoneLoaderBehaviour( LoaderBehaviourEnum value ) {
		iSOTZoneLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getLicenseLoaderBehaviour() {
		return( licenseLoaderBehaviour );
	}

	public void setLicenseLoaderBehaviour( LoaderBehaviourEnum value ) {
		licenseLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getMajorVersionLoaderBehaviour() {
		return( majorVersionLoaderBehaviour );
	}

	public void setMajorVersionLoaderBehaviour( LoaderBehaviourEnum value ) {
		majorVersionLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getMimeTypeLoaderBehaviour() {
		return( mimeTypeLoaderBehaviour );
	}

	public void setMimeTypeLoaderBehaviour( LoaderBehaviourEnum value ) {
		mimeTypeLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getMinorVersionLoaderBehaviour() {
		return( minorVersionLoaderBehaviour );
	}

	public void setMinorVersionLoaderBehaviour( LoaderBehaviourEnum value ) {
		minorVersionLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecClusGrpLoaderBehaviour() {
		return( secClusGrpLoaderBehaviour );
	}

	public void setSecClusGrpLoaderBehaviour( LoaderBehaviourEnum value ) {
		secClusGrpLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecClusGrpMembLoaderBehaviour() {
		return( secClusGrpMembLoaderBehaviour );
	}

	public void setSecClusGrpMembLoaderBehaviour( LoaderBehaviourEnum value ) {
		secClusGrpMembLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecClusRoleLoaderBehaviour() {
		return( secClusRoleLoaderBehaviour );
	}

	public void setSecClusRoleLoaderBehaviour( LoaderBehaviourEnum value ) {
		secClusRoleLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecClusRoleMembLoaderBehaviour() {
		return( secClusRoleMembLoaderBehaviour );
	}

	public void setSecClusRoleMembLoaderBehaviour( LoaderBehaviourEnum value ) {
		secClusRoleMembLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSessionLoaderBehaviour() {
		return( secSessionLoaderBehaviour );
	}

	public void setSecSessionLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSessionLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSysGrpLoaderBehaviour() {
		return( secSysGrpLoaderBehaviour );
	}

	public void setSecSysGrpLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSysGrpLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSysGrpIncLoaderBehaviour() {
		return( secSysGrpIncLoaderBehaviour );
	}

	public void setSecSysGrpIncLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSysGrpIncLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSysGrpMembLoaderBehaviour() {
		return( secSysGrpMembLoaderBehaviour );
	}

	public void setSecSysGrpMembLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSysGrpMembLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSysRoleLoaderBehaviour() {
		return( secSysRoleLoaderBehaviour );
	}

	public void setSecSysRoleLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSysRoleLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSysRoleEnablesLoaderBehaviour() {
		return( secSysRoleEnablesLoaderBehaviour );
	}

	public void setSecSysRoleEnablesLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSysRoleEnablesLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecSysRoleMembLoaderBehaviour() {
		return( secSysRoleMembLoaderBehaviour );
	}

	public void setSecSysRoleMembLoaderBehaviour( LoaderBehaviourEnum value ) {
		secSysRoleMembLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecTentGrpLoaderBehaviour() {
		return( secTentGrpLoaderBehaviour );
	}

	public void setSecTentGrpLoaderBehaviour( LoaderBehaviourEnum value ) {
		secTentGrpLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecTentGrpMembLoaderBehaviour() {
		return( secTentGrpMembLoaderBehaviour );
	}

	public void setSecTentGrpMembLoaderBehaviour( LoaderBehaviourEnum value ) {
		secTentGrpMembLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecTentRoleLoaderBehaviour() {
		return( secTentRoleLoaderBehaviour );
	}

	public void setSecTentRoleLoaderBehaviour( LoaderBehaviourEnum value ) {
		secTentRoleLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecTentRoleMembLoaderBehaviour() {
		return( secTentRoleMembLoaderBehaviour );
	}

	public void setSecTentRoleMembLoaderBehaviour( LoaderBehaviourEnum value ) {
		secTentRoleMembLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecUserLoaderBehaviour() {
		return( secUserLoaderBehaviour );
	}

	public void setSecUserLoaderBehaviour( LoaderBehaviourEnum value ) {
		secUserLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecUserEMConfLoaderBehaviour() {
		return( secUserEMConfLoaderBehaviour );
	}

	public void setSecUserEMConfLoaderBehaviour( LoaderBehaviourEnum value ) {
		secUserEMConfLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecUserPWHistoryLoaderBehaviour() {
		return( secUserPWHistoryLoaderBehaviour );
	}

	public void setSecUserPWHistoryLoaderBehaviour( LoaderBehaviourEnum value ) {
		secUserPWHistoryLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecUserPWResetLoaderBehaviour() {
		return( secUserPWResetLoaderBehaviour );
	}

	public void setSecUserPWResetLoaderBehaviour( LoaderBehaviourEnum value ) {
		secUserPWResetLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSecUserPasswordLoaderBehaviour() {
		return( secUserPasswordLoaderBehaviour );
	}

	public void setSecUserPasswordLoaderBehaviour( LoaderBehaviourEnum value ) {
		secUserPasswordLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSubProjectLoaderBehaviour() {
		return( subProjectLoaderBehaviour );
	}

	public void setSubProjectLoaderBehaviour( LoaderBehaviourEnum value ) {
		subProjectLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getSysClusterLoaderBehaviour() {
		return( sysClusterLoaderBehaviour );
	}

	public void setSysClusterLoaderBehaviour( LoaderBehaviourEnum value ) {
		sysClusterLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTableInfoLoaderBehaviour() {
		return( tableInfoLoaderBehaviour );
	}

	public void setTableInfoLoaderBehaviour( LoaderBehaviourEnum value ) {
		tableInfoLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTenantLoaderBehaviour() {
		return( tenantLoaderBehaviour );
	}

	public void setTenantLoaderBehaviour( LoaderBehaviourEnum value ) {
		tenantLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTldLoaderBehaviour() {
		return( tldLoaderBehaviour );
	}

	public void setTldLoaderBehaviour( LoaderBehaviourEnum value ) {
		tldLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTopDomainLoaderBehaviour() {
		return( topDomainLoaderBehaviour );
	}

	public void setTopDomainLoaderBehaviour( LoaderBehaviourEnum value ) {
		topDomainLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getTopProjectLoaderBehaviour() {
		return( topProjectLoaderBehaviour );
	}

	public void setTopProjectLoaderBehaviour( LoaderBehaviourEnum value ) {
		topProjectLoaderBehaviour = value;
	}

	public LoaderBehaviourEnum getURLProtocolLoaderBehaviour() {
		return( uRLProtocolLoaderBehaviour );
	}

	public void setURLProtocolLoaderBehaviour( LoaderBehaviourEnum value ) {
		uRLProtocolLoaderBehaviour = value;
	}

	// Parse a file

	public void parseFile( String url ) {
		parse( url );
	}
}
