// Description: Java 25 JavaFX Element TabPane implementation for SecTentRole.

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
 *	SecureJavaFXSecTentRoleEltTabPane JavaFX Element TabPane implementation
 *	for SecTentRole.
 */
public class SecureJavaFXSecTentRoleEltTabPane
extends YCFTabPane
implements ISecureJavaFXSecTentRolePaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabChildrenMembByRoleList = "Optional Children Members of Role";
	protected YCFTab tabChildrenMembByRole = null;
	protected YCFBorderPane tabViewChildrenMembByRoleListPane = null;

	public SecureJavaFXSecTentRoleEltTabPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureSecTentRoleObj argFocus ) {
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
		setJavaFXFocusAsSecTentRole( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
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
		if( ( value == null ) || ( value instanceof ISecureSecTentRoleObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecTentRoleObj" );
		}
	}

	public void setJavaFXFocusAsSecTentRole( ISecureSecTentRoleObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureSecTentRoleObj getJavaFXFocusAsSecTentRole() {
		return( (ISecureSecTentRoleObj)getJavaFXFocus() );
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
	implements ISecureJavaFXSecTentRoleMembPageCallback
	{
		public PageDataChildrenMembByRoleList() {
		}

		public List<ISecureSecTentRoleMembObj> pageData( IYCFKeyHash256 priorSecTentRoleId,
		String priorLoginId )
		{
			List<ISecureSecTentRoleMembObj> dataList;
			ISecureSecTentRoleObj focus = (ISecureSecTentRoleObj)getJavaFXFocusAsSecTentRole();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
				dataList = schemaObj.getSecTentRoleMembTableObj().pageSecTentRoleMembByTentRoleIdx( focus.getRequiredSecTentRoleId(),
					priorSecTentRoleId,
					priorLoginId );
			}
			else {
				dataList = new ArrayList<ISecureSecTentRoleMembObj>();
			}
			return( dataList );
		}
	}

	public YCFBorderPane getTabViewChildrenMembByRoleListPane() {
		if( tabViewChildrenMembByRoleListPane == null ) {
			ISecureSecTentRoleObj focus = (ISecureSecTentRoleObj)getJavaFXFocusAsSecTentRole();
			ISecureSecTentRoleObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecTentRoleObj ) ) {
				javafxContainer = (ISecureSecTentRoleObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewChildrenMembByRoleListPane = javafxSchema.getSecTentRoleMembFactory().newListPane( ycfFormManager, javafxContainer, null, new PageDataChildrenMembByRoleList(), new RefreshChildrenMembByRoleList(), false );
		}
		return( tabViewChildrenMembByRoleListPane );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewChildrenMembByRoleListPane != null ) {
			((ISecureJavaFXSecTentRoleMembPaneCommon)tabViewChildrenMembByRoleListPane).setPaneMode( value );
		}
	}
}
