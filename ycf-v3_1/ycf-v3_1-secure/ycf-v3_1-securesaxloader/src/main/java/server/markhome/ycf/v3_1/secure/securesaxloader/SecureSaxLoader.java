// Description: Java 25 XML SAX Parser for Secure.

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

package server.markhome.ycf.v3_1.secure.securesaxloader;

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
import server.markhome.ycf.v3_1.secure.secureobj.*;

public class SecureSaxLoader
	extends YCFLibXmlCoreSaxParser
	implements ContentHandler
{

	// The namespace URI of the supported schema
	public final static String	SCHEMA_XMLNS = "http://ycf.markhome.server/ycf/v3_1/xsd/secure-structured.xsd";

	// The source for loading the supported schema
	public final static String	SCHEMA_URI = "http://ycf.markhome.server/ycf/v3_1/xsd/secure-structured.xsd";
	public final static String	SCHEMA_ROOT_URI = "http://ycf.markhome.server/ycf/v3_1/xsd/secure-structured.xsd";

	// The schema instance to load in to

	private ISecureSchemaObj schemaObj = null;

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
	private LoaderBehaviourEnum sysClusterLoaderBehaviour = LoaderBehaviourEnum.Insert;
	private LoaderBehaviourEnum tableInfoLoaderBehaviour = LoaderBehaviourEnum.Update;
	private LoaderBehaviourEnum tenantLoaderBehaviour = LoaderBehaviourEnum.Insert;


	// Constructors

	public SecureSaxLoader() {
		super();
		setRootElementHandler( getSaxRootHandler() );
		initParser();
	}

	public SecureSaxLoader( IYCFLibMessageLog logger ) {
		super( logger );
		setRootElementHandler( getSaxRootHandler() );
		initParser();
	}

	// Element Handler instances

	private SecureSaxLoaderCluster clusterHandler = null;
	private SecureSaxLoaderISOCcy iSOCcyHandler = null;
	private SecureSaxLoaderISOCtry iSOCtryHandler = null;
	private SecureSaxLoaderISOCtryCcy iSOCtryCcyHandler = null;
	private SecureSaxLoaderISOCtryLang iSOCtryLangHandler = null;
	private SecureSaxLoaderISOLang iSOLangHandler = null;
	private SecureSaxLoaderISOTZone iSOTZoneHandler = null;
	private SecureSaxLoaderSecClusGrp secClusGrpHandler = null;
	private SecureSaxLoaderSecClusGrpMemb secClusGrpMembHandler = null;
	private SecureSaxLoaderSecClusRole secClusRoleHandler = null;
	private SecureSaxLoaderSecClusRoleMemb secClusRoleMembHandler = null;
	private SecureSaxLoaderSecSession secSessionHandler = null;
	private SecureSaxLoaderSecSysGrp secSysGrpHandler = null;
	private SecureSaxLoaderSecSysGrpInc secSysGrpIncHandler = null;
	private SecureSaxLoaderSecSysGrpMemb secSysGrpMembHandler = null;
	private SecureSaxLoaderSecSysRole secSysRoleHandler = null;
	private SecureSaxLoaderSecSysRoleEnables secSysRoleEnablesHandler = null;
	private SecureSaxLoaderSecSysRoleMemb secSysRoleMembHandler = null;
	private SecureSaxLoaderSecTentGrp secTentGrpHandler = null;
	private SecureSaxLoaderSecTentGrpMemb secTentGrpMembHandler = null;
	private SecureSaxLoaderSecTentRole secTentRoleHandler = null;
	private SecureSaxLoaderSecTentRoleMemb secTentRoleMembHandler = null;
	private SecureSaxLoaderSecUser secUserHandler = null;
	private SecureSaxLoaderSecUserEMConf secUserEMConfHandler = null;
	private SecureSaxLoaderSecUserPWHistory secUserPWHistoryHandler = null;
	private SecureSaxLoaderSecUserPWReset secUserPWResetHandler = null;
	private SecureSaxLoaderSecUserPassword secUserPasswordHandler = null;
	private SecureSaxLoaderSysCluster sysClusterHandler = null;
	private SecureSaxLoaderTableInfo tableInfoHandler = null;
	private SecureSaxLoaderTenant tenantHandler = null;
	private SecureSaxRootHandler saxRootHandler = null;

	private SecureSaxDocHandler saxDocHandler = null;

	// Schema object accessors

	// SchemaObj accessors

	public ISecureSchemaObj getSchemaObj() {
		return( schemaObj );
	}

	public void setSchemaObj( ISecureSchemaObj value ) {
		schemaObj = value;
	}

	// Element Handler Resolver Factories

	protected SecureSaxLoaderCluster getClusterHandler() {
		if( clusterHandler == null ) {
			clusterHandler = new SecureSaxLoaderCluster( this );
			clusterHandler.addElementHandler( "Tenant", getTenantHandler() );
		}
		return( clusterHandler );
	}
	protected SecureSaxLoaderISOCcy getISOCcyHandler() {
		if( iSOCcyHandler == null ) {
			iSOCcyHandler = new SecureSaxLoaderISOCcy( this );
		}
		return( iSOCcyHandler );
	}
	protected SecureSaxLoaderISOCtry getISOCtryHandler() {
		if( iSOCtryHandler == null ) {
			iSOCtryHandler = new SecureSaxLoaderISOCtry( this );
			iSOCtryHandler.addElementHandler( "ISOCtryCcy", getISOCtryCcyHandler() );
			iSOCtryHandler.addElementHandler( "ISOCtryLang", getISOCtryLangHandler() );
		}
		return( iSOCtryHandler );
	}
	protected SecureSaxLoaderISOCtryCcy getISOCtryCcyHandler() {
		if( iSOCtryCcyHandler == null ) {
			iSOCtryCcyHandler = new SecureSaxLoaderISOCtryCcy( this );
		}
		return( iSOCtryCcyHandler );
	}
	protected SecureSaxLoaderISOCtryLang getISOCtryLangHandler() {
		if( iSOCtryLangHandler == null ) {
			iSOCtryLangHandler = new SecureSaxLoaderISOCtryLang( this );
		}
		return( iSOCtryLangHandler );
	}
	protected SecureSaxLoaderISOLang getISOLangHandler() {
		if( iSOLangHandler == null ) {
			iSOLangHandler = new SecureSaxLoaderISOLang( this );
		}
		return( iSOLangHandler );
	}
	protected SecureSaxLoaderISOTZone getISOTZoneHandler() {
		if( iSOTZoneHandler == null ) {
			iSOTZoneHandler = new SecureSaxLoaderISOTZone( this );
		}
		return( iSOTZoneHandler );
	}
	protected SecureSaxLoaderSecClusGrp getSecClusGrpHandler() {
		if( secClusGrpHandler == null ) {
			secClusGrpHandler = new SecureSaxLoaderSecClusGrp( this );
		}
		return( secClusGrpHandler );
	}
	protected SecureSaxLoaderSecClusGrpMemb getSecClusGrpMembHandler() {
		if( secClusGrpMembHandler == null ) {
			secClusGrpMembHandler = new SecureSaxLoaderSecClusGrpMemb( this );
		}
		return( secClusGrpMembHandler );
	}
	protected SecureSaxLoaderSecClusRole getSecClusRoleHandler() {
		if( secClusRoleHandler == null ) {
			secClusRoleHandler = new SecureSaxLoaderSecClusRole( this );
		}
		return( secClusRoleHandler );
	}
	protected SecureSaxLoaderSecClusRoleMemb getSecClusRoleMembHandler() {
		if( secClusRoleMembHandler == null ) {
			secClusRoleMembHandler = new SecureSaxLoaderSecClusRoleMemb( this );
		}
		return( secClusRoleMembHandler );
	}
	protected SecureSaxLoaderSecSession getSecSessionHandler() {
		if( secSessionHandler == null ) {
			secSessionHandler = new SecureSaxLoaderSecSession( this );
		}
		return( secSessionHandler );
	}
	protected SecureSaxLoaderSecSysGrp getSecSysGrpHandler() {
		if( secSysGrpHandler == null ) {
			secSysGrpHandler = new SecureSaxLoaderSecSysGrp( this );
			secSysGrpHandler.addElementHandler( "SecSysGrpInc", getSecSysGrpIncHandler() );
			secSysGrpHandler.addElementHandler( "SecClusGrp", getSecClusGrpHandler() );
			secSysGrpHandler.addElementHandler( "SecTentGrp", getSecTentGrpHandler() );
			secSysGrpHandler.addElementHandler( "SecClusRole", getSecClusRoleHandler() );
			secSysGrpHandler.addElementHandler( "SecTentRole", getSecTentRoleHandler() );
		}
		return( secSysGrpHandler );
	}
	protected SecureSaxLoaderSecSysGrpInc getSecSysGrpIncHandler() {
		if( secSysGrpIncHandler == null ) {
			secSysGrpIncHandler = new SecureSaxLoaderSecSysGrpInc( this );
		}
		return( secSysGrpIncHandler );
	}
	protected SecureSaxLoaderSecSysGrpMemb getSecSysGrpMembHandler() {
		if( secSysGrpMembHandler == null ) {
			secSysGrpMembHandler = new SecureSaxLoaderSecSysGrpMemb( this );
		}
		return( secSysGrpMembHandler );
	}
	protected SecureSaxLoaderSecSysRole getSecSysRoleHandler() {
		if( secSysRoleHandler == null ) {
			secSysRoleHandler = new SecureSaxLoaderSecSysRole( this );
			secSysRoleHandler.addElementHandler( "SecSysRoleEnables", getSecSysRoleEnablesHandler() );
		}
		return( secSysRoleHandler );
	}
	protected SecureSaxLoaderSecSysRoleEnables getSecSysRoleEnablesHandler() {
		if( secSysRoleEnablesHandler == null ) {
			secSysRoleEnablesHandler = new SecureSaxLoaderSecSysRoleEnables( this );
		}
		return( secSysRoleEnablesHandler );
	}
	protected SecureSaxLoaderSecSysRoleMemb getSecSysRoleMembHandler() {
		if( secSysRoleMembHandler == null ) {
			secSysRoleMembHandler = new SecureSaxLoaderSecSysRoleMemb( this );
		}
		return( secSysRoleMembHandler );
	}
	protected SecureSaxLoaderSecTentGrp getSecTentGrpHandler() {
		if( secTentGrpHandler == null ) {
			secTentGrpHandler = new SecureSaxLoaderSecTentGrp( this );
		}
		return( secTentGrpHandler );
	}
	protected SecureSaxLoaderSecTentGrpMemb getSecTentGrpMembHandler() {
		if( secTentGrpMembHandler == null ) {
			secTentGrpMembHandler = new SecureSaxLoaderSecTentGrpMemb( this );
		}
		return( secTentGrpMembHandler );
	}
	protected SecureSaxLoaderSecTentRole getSecTentRoleHandler() {
		if( secTentRoleHandler == null ) {
			secTentRoleHandler = new SecureSaxLoaderSecTentRole( this );
		}
		return( secTentRoleHandler );
	}
	protected SecureSaxLoaderSecTentRoleMemb getSecTentRoleMembHandler() {
		if( secTentRoleMembHandler == null ) {
			secTentRoleMembHandler = new SecureSaxLoaderSecTentRoleMemb( this );
		}
		return( secTentRoleMembHandler );
	}
	protected SecureSaxLoaderSecUser getSecUserHandler() {
		if( secUserHandler == null ) {
			secUserHandler = new SecureSaxLoaderSecUser( this );
			secUserHandler.addElementHandler( "SecSession", getSecSessionHandler() );
			secUserHandler.addElementHandler( "SecUserPassword", getSecUserPasswordHandler() );
			secUserHandler.addElementHandler( "SecUserEMConf", getSecUserEMConfHandler() );
			secUserHandler.addElementHandler( "SecUserPWReset", getSecUserPWResetHandler() );
		}
		return( secUserHandler );
	}
	protected SecureSaxLoaderSecUserEMConf getSecUserEMConfHandler() {
		if( secUserEMConfHandler == null ) {
			secUserEMConfHandler = new SecureSaxLoaderSecUserEMConf( this );
		}
		return( secUserEMConfHandler );
	}
	protected SecureSaxLoaderSecUserPWHistory getSecUserPWHistoryHandler() {
		if( secUserPWHistoryHandler == null ) {
			secUserPWHistoryHandler = new SecureSaxLoaderSecUserPWHistory( this );
		}
		return( secUserPWHistoryHandler );
	}
	protected SecureSaxLoaderSecUserPWReset getSecUserPWResetHandler() {
		if( secUserPWResetHandler == null ) {
			secUserPWResetHandler = new SecureSaxLoaderSecUserPWReset( this );
		}
		return( secUserPWResetHandler );
	}
	protected SecureSaxLoaderSecUserPassword getSecUserPasswordHandler() {
		if( secUserPasswordHandler == null ) {
			secUserPasswordHandler = new SecureSaxLoaderSecUserPassword( this );
		}
		return( secUserPasswordHandler );
	}
	protected SecureSaxLoaderSysCluster getSysClusterHandler() {
		if( sysClusterHandler == null ) {
			sysClusterHandler = new SecureSaxLoaderSysCluster( this );
		}
		return( sysClusterHandler );
	}
	protected SecureSaxLoaderTableInfo getTableInfoHandler() {
		if( tableInfoHandler == null ) {
			tableInfoHandler = new SecureSaxLoaderTableInfo( this );
		}
		return( tableInfoHandler );
	}
	protected SecureSaxLoaderTenant getTenantHandler() {
		if( tenantHandler == null ) {
			tenantHandler = new SecureSaxLoaderTenant( this );
		}
		return( tenantHandler );
	}
	// Root Element Handler Resolver Factory

	protected SecureSaxRootHandler getSaxRootHandler() {
		if( saxRootHandler == null ) {
			saxRootHandler = new SecureSaxRootHandler( this );
			saxRootHandler.addElementHandler( "Secure", getSaxDocHandler() );
		}
		return( saxRootHandler );
	}

	// Root Element Handler

	/*
	 *	SecureSaxRootHandler XML SAX Root Element Handler implementation
	 */
	public class SecureSaxRootHandler
		extends YCFLibXmlCoreElementHandler
	{
		public SecureSaxRootHandler( SecureSaxLoader saxLoader ) {
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

	protected SecureSaxDocHandler getSaxDocHandler() {
		if( saxDocHandler == null ) {
			saxDocHandler = new SecureSaxDocHandler( this );
			saxDocHandler.addElementHandler( "Cluster", getClusterHandler() );
			saxDocHandler.addElementHandler( "ISOCcy", getISOCcyHandler() );
			saxDocHandler.addElementHandler( "ISOCtry", getISOCtryHandler() );
			saxDocHandler.addElementHandler( "ISOLang", getISOLangHandler() );
			saxDocHandler.addElementHandler( "ISOTZone", getISOTZoneHandler() );
			saxDocHandler.addElementHandler( "SecSysGrp", getSecSysGrpHandler() );
			saxDocHandler.addElementHandler( "SecSysRole", getSecSysRoleHandler() );
			saxDocHandler.addElementHandler( "SecUser", getSecUserHandler() );
			saxDocHandler.addElementHandler( "SecUserPWHistory", getSecUserPWHistoryHandler() );
			saxDocHandler.addElementHandler( "TableInfo", getTableInfoHandler() );
		}
		return( saxDocHandler );
	}

	// Document Element Handler

	/*
	 *	SecureSaxDocHandler XML SAX Doc Element Handler implementation
	 */
	public class SecureSaxDocHandler
		extends YCFLibXmlCoreElementHandler
	{
		public SecureSaxDocHandler( SecureSaxLoader saxLoader ) {
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

	// Parse a file

	public void parseFile( String url ) {
		parse( url );
	}
}
