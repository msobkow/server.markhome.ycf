// Description: Java 25 JavaFX Element TabPane implementation for SecSysRole.

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
 *	SecureJavaFXSecSysRoleEltTabPane JavaFX Element TabPane implementation
 *	for SecSysRole.
 */
public class SecureJavaFXSecSysRoleEltTabPane
extends YCFTabPane
implements ISecureJavaFXSecSysRolePaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsEnabledByRoleList = "Optional Components Enabled by Role";
	protected YCFTab tabComponentsEnabledByRole = null;
	public final String LABEL_TabChildrenMembByRoleList = "Optional Children Members of System Role";
	protected YCFTab tabChildrenMembByRole = null;
	protected YCFBorderPane tabViewComponentsEnabledByRoleListPane = null;
	protected YCFBorderPane tabViewChildrenMembByRoleListPane = null;

	public SecureJavaFXSecSysRoleEltTabPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureSecSysRoleObj argFocus ) {
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
		setJavaFXFocusAsSecSysRole( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsEnabledByRole = new YCFTab();
		tabComponentsEnabledByRole.setText( LABEL_TabComponentsEnabledByRoleList );
		tabComponentsEnabledByRole.setContent( getTabViewComponentsEnabledByRoleListPane() );
		getTabs().add( tabComponentsEnabledByRole );
		tabChildrenMembByRole = new YCFTab();
		tabChildrenMembByRole.setText( LABEL_TabChildrenMembByRoleList );
		tabChildrenMembByRole.setContent( getTabViewChildrenMembByRoleListPane() );
		getTabs().add( tabChildrenMembByRole );
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
		if( ( value == null ) || ( value instanceof ISecureSecSysRoleObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecSysRoleObj" );
		}
	}

	public void setJavaFXFocusAsSecSysRole( ISecureSecSysRoleObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureSecSysRoleObj getJavaFXFocusAsSecSysRole() {
		return( (ISecureSecSysRoleObj)getJavaFXFocus() );
	}

	protected class RefreshComponentsEnabledByRoleList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsEnabledByRoleList() {
		}

		public void refreshMe() {
			// Use page data instead
		}
	}

	protected class PageDataComponentsEnabledByRoleList
	implements ISecureJavaFXSecSysRoleEnablesPageCallback
	{
		public PageDataComponentsEnabledByRoleList() {
		}

		public List<ISecureSecSysRoleEnablesObj> pageData( IYCFKeyHash256 priorSecSysRoleId,
		String priorEnableName )
		{
			List<ISecureSecSysRoleEnablesObj> dataList;
			ISecureSecSysRoleObj focus = (ISecureSecSysRoleObj)getJavaFXFocusAsSecSysRole();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
				dataList = schemaObj.getSecSysRoleEnablesTableObj().pageSecSysRoleEnablesBySysRoleIdx( focus.getRequiredSecSysRoleId(),
					priorSecSysRoleId,
					priorEnableName );
			}
			else {
				dataList = new ArrayList<ISecureSecSysRoleEnablesObj>();
			}
			return( dataList );
		}
	}

	public YCFBorderPane getTabViewComponentsEnabledByRoleListPane() {
		if( tabViewComponentsEnabledByRoleListPane == null ) {
			ISecureSecSysRoleObj focus = (ISecureSecSysRoleObj)getJavaFXFocusAsSecSysRole();
			ISecureSecSysRoleObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecSysRoleObj ) ) {
				javafxContainer = (ISecureSecSysRoleObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsEnabledByRoleListPane = javafxSchema.getSecSysRoleEnablesFactory().newListPane( ycfFormManager, javafxContainer, null, new PageDataComponentsEnabledByRoleList(), new RefreshComponentsEnabledByRoleList(), false );
		}
		return( tabViewComponentsEnabledByRoleListPane );
	}

	protected class RefreshChildrenMembByRoleList
	implements IYCFRefreshCallback
	{
		public RefreshChildrenMembByRoleList() {
		}

		public void refreshMe() {
			// Use page data instead
		}
	}

	protected class PageDataChildrenMembByRoleList
	implements ISecureJavaFXSecSysRoleMembPageCallback
	{
		public PageDataChildrenMembByRoleList() {
		}

		public List<ISecureSecSysRoleMembObj> pageData( IYCFKeyHash256 priorSecSysRoleId,
		String priorLoginId )
		{
			List<ISecureSecSysRoleMembObj> dataList;
			ISecureSecSysRoleObj focus = (ISecureSecSysRoleObj)getJavaFXFocusAsSecSysRole();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
				dataList = schemaObj.getSecSysRoleMembTableObj().pageSecSysRoleMembBySysRoleIdx( focus.getRequiredSecSysRoleId(),
					priorSecSysRoleId,
					priorLoginId );
			}
			else {
				dataList = new ArrayList<ISecureSecSysRoleMembObj>();
			}
			return( dataList );
		}
	}

	public YCFBorderPane getTabViewChildrenMembByRoleListPane() {
		if( tabViewChildrenMembByRoleListPane == null ) {
			ISecureSecSysRoleObj focus = (ISecureSecSysRoleObj)getJavaFXFocusAsSecSysRole();
			ISecureSecSysRoleObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecSysRoleObj ) ) {
				javafxContainer = (ISecureSecSysRoleObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewChildrenMembByRoleListPane = javafxSchema.getSecSysRoleMembFactory().newListPane( ycfFormManager, javafxContainer, null, new PageDataChildrenMembByRoleList(), new RefreshChildrenMembByRoleList(), false );
		}
		return( tabViewChildrenMembByRoleListPane );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsEnabledByRoleListPane != null ) {
			((ISecureJavaFXSecSysRoleEnablesPaneCommon)tabViewComponentsEnabledByRoleListPane).setPaneMode( value );
		}
		if( tabViewChildrenMembByRoleListPane != null ) {
			((ISecureJavaFXSecSysRoleMembPaneCommon)tabViewChildrenMembByRoleListPane).setPaneMode( value );
		}
	}
}
