// Description: Java 25 JavaFX Element TabPane implementation for Cluster.

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

package server.markhome.ycf.v3_1.secure.securejavafx;

import java.math.*;
import java.time.*;
import java.text.*;
import java.util.*;
import java.util.List;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.javafx.*;
import org.apache.commons.codec.binaryYCFCore64;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

/**
 *	SecureJavaFXClusterEltTabPane JavaFX Element TabPane implementation
 *	for Cluster.
 */
public class SecureJavaFXClusterEltTabPane
extends YCFTabPane
implements ISecureJavaFXClusterPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsTenantList = "Optional Components Tenant";
	protected YCFTab tabComponentsTenant = null;
	public final String LABEL_TabComponentsSecGroupList = "Optional Components Security Group";
	protected YCFTab tabComponentsSecGroup = null;
	public final String LABEL_TabComponentsSecRoleList = "Optional Components Security Role";
	protected YCFTab tabComponentsSecRole = null;
	public final String LABEL_TabComponentsSysClusterList = "Optional Components System Cluster";
	protected YCFTab tabComponentsSysCluster = null;
	protected YCFBorderPane tabViewComponentsTenantListPane = null;
	protected YCFBorderPane tabViewComponentsSecGroupListPane = null;
	protected YCFBorderPane tabViewComponentsSecRoleListPane = null;
	protected YCFBorderPane tabViewComponentsSysClusterListPane = null;

	public SecureJavaFXClusterEltTabPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureClusterObj argFocus ) {
		super();
		final String S_ProcName = "construct-schema-focus";
		if( formManager == null ) {
			throw new YCFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"formManager" );
		}
		ycfFormManager = formManager;
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( getClass(),
				S_ProcName,
				2,
				"argSchema" );
		}
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		javafxSchema = argSchema;
		setJavaFXFocusAsCluster( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsTenant = new YCFTab();
		tabComponentsTenant.setText( LABEL_TabComponentsTenantList );
		tabComponentsTenant.setContent( getTabViewComponentsTenantListPane() );
		getTabs().add( tabComponentsTenant );
		tabComponentsSecGroup = new YCFTab();
		tabComponentsSecGroup.setText( LABEL_TabComponentsSecGroupList );
		tabComponentsSecGroup.setContent( getTabViewComponentsSecGroupListPane() );
		getTabs().add( tabComponentsSecGroup );
		tabComponentsSecRole = new YCFTab();
		tabComponentsSecRole.setText( LABEL_TabComponentsSecRoleList );
		tabComponentsSecRole.setContent( getTabViewComponentsSecRoleListPane() );
		getTabs().add( tabComponentsSecRole );
		tabComponentsSysCluster = new YCFTab();
		tabComponentsSysCluster.setText( LABEL_TabComponentsSysClusterList );
		tabComponentsSysCluster.setContent( getTabViewComponentsSysClusterListPane() );
		getTabs().add( tabComponentsSysCluster );
		javafxIsInitializing = false;
	}

	public IYCFFormManager getYCFFormManager() {
		return( ycfFormManager );
	}

	public void setYCFFormManager( IYCFFormManager value ) {
		final String S_ProcName = "setYCFFormManager";
		if( value == null ) {
			throw new YCFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"value" );
		}
		ycfFormManager = value;
	}

	public ISecureJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ISecureClusterObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureClusterObj" );
		}
	}

	public void setJavaFXFocusAsCluster( ISecureClusterObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureClusterObj getJavaFXFocusAsCluster() {
		return( (ISecureClusterObj)getJavaFXFocus() );
	}

	protected class RefreshComponentsTenantList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsTenantList() {
		}

		public void refreshMe() {
			// Use page data instead
		}
	}

	protected class PageDataComponentsTenantList
	implements ISecureJavaFXTenantPageCallback
	{
		public PageDataComponentsTenantList() {
		}

		public List<ISecureTenantObj> pageData( IYCFKeyHash256 priorId )
		{
			List<ISecureTenantObj> dataList;
			ISecureClusterObj focus = (ISecureClusterObj)getJavaFXFocusAsCluster();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
				dataList = schemaObj.getTenantTableObj().pageTenantByClusterIdx( focus.getRequiredId(),
					priorId );
			}
			else {
				dataList = new ArrayList<ISecureTenantObj>();
			}
			return( dataList );
		}
	}

	public YCFBorderPane getTabViewComponentsTenantListPane() {
		if( tabViewComponentsTenantListPane == null ) {
			ISecureClusterObj focus = (ISecureClusterObj)getJavaFXFocusAsCluster();
			ISecureClusterObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureClusterObj ) ) {
				javafxContainer = (ISecureClusterObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsTenantListPane = javafxSchema.getTenantFactory().newListPane( ycfFormManager, javafxContainer, null, new PageDataComponentsTenantList(), new RefreshComponentsTenantList(), false );
		}
		return( tabViewComponentsTenantListPane );
	}

	protected class RefreshComponentsSecGroupList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsSecGroupList() {
		}

		public void refreshMe() {
			Collection<ISecureSecClusGrpObj> dataCollection;
			ISecureClusterObj focus = (ISecureClusterObj)getJavaFXFocusAsCluster();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSecGroup( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsSecGroupListPane();
			ISecureJavaFXSecClusGrpPaneList jpList = (ISecureJavaFXSecClusGrpPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsSecGroupListPane() {
		if( tabViewComponentsSecGroupListPane == null ) {
			ISecureClusterObj focus = (ISecureClusterObj)getJavaFXFocusAsCluster();
			Collection<ISecureSecClusGrpObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSecGroup( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ISecureSecSysGrpObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecSysGrpObj ) ) {
				javafxContainer = (ISecureSecSysGrpObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsSecGroupListPane = javafxSchema.getSecClusGrpFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsSecGroupList(), false );
		}
		return( tabViewComponentsSecGroupListPane );
	}

	protected class RefreshComponentsSecRoleList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsSecRoleList() {
		}

		public void refreshMe() {
			Collection<ISecureSecClusRoleObj> dataCollection;
			ISecureClusterObj focus = (ISecureClusterObj)getJavaFXFocusAsCluster();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSecRole( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsSecRoleListPane();
			ISecureJavaFXSecClusRolePaneList jpList = (ISecureJavaFXSecClusRolePaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsSecRoleListPane() {
		if( tabViewComponentsSecRoleListPane == null ) {
			ISecureClusterObj focus = (ISecureClusterObj)getJavaFXFocusAsCluster();
			Collection<ISecureSecClusRoleObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSecRole( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ISecureSecSysGrpObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecSysGrpObj ) ) {
				javafxContainer = (ISecureSecSysGrpObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsSecRoleListPane = javafxSchema.getSecClusRoleFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsSecRoleList(), false );
		}
		return( tabViewComponentsSecRoleListPane );
	}

	protected class RefreshComponentsSysClusterList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsSysClusterList() {
		}

		public void refreshMe() {
			Collection<ISecureSysClusterObj> dataCollection;
			ISecureClusterObj focus = (ISecureClusterObj)getJavaFXFocusAsCluster();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSysCluster( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsSysClusterListPane();
			ISecureJavaFXSysClusterPaneList jpList = (ISecureJavaFXSysClusterPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsSysClusterListPane() {
		if( tabViewComponentsSysClusterListPane == null ) {
			ISecureClusterObj focus = (ISecureClusterObj)getJavaFXFocusAsCluster();
			Collection<ISecureSysClusterObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSysCluster( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			ISecureClusterObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureClusterObj ) ) {
				javafxContainer = (ISecureClusterObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsSysClusterListPane = javafxSchema.getSysClusterFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsSysClusterList(), false );
		}
		return( tabViewComponentsSysClusterListPane );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsTenantListPane != null ) {
			((ISecureJavaFXTenantPaneCommon)tabViewComponentsTenantListPane).setPaneMode( value );
		}
		if( tabViewComponentsSecGroupListPane != null ) {
			((ISecureJavaFXSecClusGrpPaneCommon)tabViewComponentsSecGroupListPane).setPaneMode( value );
		}
		if( tabViewComponentsSecRoleListPane != null ) {
			((ISecureJavaFXSecClusRolePaneCommon)tabViewComponentsSecRoleListPane).setPaneMode( value );
		}
		if( tabViewComponentsSysClusterListPane != null ) {
			((ISecureJavaFXSysClusterPaneCommon)tabViewComponentsSysClusterListPane).setPaneMode( value );
		}
	}
}
