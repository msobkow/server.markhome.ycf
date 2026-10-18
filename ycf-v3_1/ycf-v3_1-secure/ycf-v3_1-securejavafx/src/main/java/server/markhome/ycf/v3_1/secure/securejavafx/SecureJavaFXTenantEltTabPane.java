// Description: Java 25 JavaFX Element TabPane implementation for Tenant.

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
 *	SecureJavaFXTenantEltTabPane JavaFX Element TabPane implementation
 *	for Tenant.
 */
public class SecureJavaFXTenantEltTabPane
extends YCFTabPane
implements ISecureJavaFXTenantPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsSecGroupList = "Optional Components Tenant Security Group";
	protected YCFTab tabComponentsSecGroup = null;
	public final String LABEL_TabComponentsSecRoleList = "Optional Components Security Role";
	protected YCFTab tabComponentsSecRole = null;
	protected YCFBorderPane tabViewComponentsSecGroupListPane = null;
	protected YCFBorderPane tabViewComponentsSecRoleListPane = null;

	public SecureJavaFXTenantEltTabPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureTenantObj argFocus ) {
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
		setJavaFXFocusAsTenant( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsSecGroup = new YCFTab();
		tabComponentsSecGroup.setText( LABEL_TabComponentsSecGroupList );
		tabComponentsSecGroup.setContent( getTabViewComponentsSecGroupListPane() );
		getTabs().add( tabComponentsSecGroup );
		tabComponentsSecRole = new YCFTab();
		tabComponentsSecRole.setText( LABEL_TabComponentsSecRoleList );
		tabComponentsSecRole.setContent( getTabViewComponentsSecRoleListPane() );
		getTabs().add( tabComponentsSecRole );
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
		if( ( value == null ) || ( value instanceof ISecureTenantObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureTenantObj" );
		}
	}

	public void setJavaFXFocusAsTenant( ISecureTenantObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureTenantObj getJavaFXFocusAsTenant() {
		return( (ISecureTenantObj)getJavaFXFocus() );
	}

	protected class RefreshComponentsSecGroupList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsSecGroupList() {
		}

		public void refreshMe() {
			Collection<ISecureSecTentGrpObj> dataCollection;
			ISecureTenantObj focus = (ISecureTenantObj)getJavaFXFocusAsTenant();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSecGroup( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsSecGroupListPane();
			ISecureJavaFXSecTentGrpPaneList jpList = (ISecureJavaFXSecTentGrpPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsSecGroupListPane() {
		if( tabViewComponentsSecGroupListPane == null ) {
			ISecureTenantObj focus = (ISecureTenantObj)getJavaFXFocusAsTenant();
			Collection<ISecureSecTentGrpObj> dataCollection;
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
			tabViewComponentsSecGroupListPane = javafxSchema.getSecTentGrpFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsSecGroupList(), false );
		}
		return( tabViewComponentsSecGroupListPane );
	}

	protected class RefreshComponentsSecRoleList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsSecRoleList() {
		}

		public void refreshMe() {
			Collection<ISecureSecTentRoleObj> dataCollection;
			ISecureTenantObj focus = (ISecureTenantObj)getJavaFXFocusAsTenant();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSecRole( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsSecRoleListPane();
			ISecureJavaFXSecTentRolePaneList jpList = (ISecureJavaFXSecTentRolePaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsSecRoleListPane() {
		if( tabViewComponentsSecRoleListPane == null ) {
			ISecureTenantObj focus = (ISecureTenantObj)getJavaFXFocusAsTenant();
			Collection<ISecureSecTentRoleObj> dataCollection;
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
			tabViewComponentsSecRoleListPane = javafxSchema.getSecTentRoleFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsSecRoleList(), false );
		}
		return( tabViewComponentsSecRoleListPane );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsSecGroupListPane != null ) {
			((ISecureJavaFXSecTentGrpPaneCommon)tabViewComponentsSecGroupListPane).setPaneMode( value );
		}
		if( tabViewComponentsSecRoleListPane != null ) {
			((ISecureJavaFXSecTentRolePaneCommon)tabViewComponentsSecRoleListPane).setPaneMode( value );
		}
	}
}
