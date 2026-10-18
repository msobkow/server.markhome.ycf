// Description: Java 25 JavaFX Element TabPane implementation for SecClusRole.

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
 *	SecureJavaFXSecClusRoleEltTabPane JavaFX Element TabPane implementation
 *	for SecClusRole.
 */
public class SecureJavaFXSecClusRoleEltTabPane
extends YCFTabPane
implements ISecureJavaFXSecClusRolePaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabChildrenMembByGrpList = "Optional Children Members of Group";
	protected YCFTab tabChildrenMembByGrp = null;
	protected YCFBorderPane tabViewChildrenMembByGrpListPane = null;

	public SecureJavaFXSecClusRoleEltTabPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureSecClusRoleObj argFocus ) {
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
		setJavaFXFocusAsSecClusRole( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabChildrenMembByGrp = new YCFTab();
		tabChildrenMembByGrp.setText( LABEL_TabChildrenMembByGrpList );
		tabChildrenMembByGrp.setContent( getTabViewChildrenMembByGrpListPane() );
		getTabs().add( tabChildrenMembByGrp );
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
		if( ( value == null ) || ( value instanceof ISecureSecClusRoleObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecClusRoleObj" );
		}
	}

	public void setJavaFXFocusAsSecClusRole( ISecureSecClusRoleObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureSecClusRoleObj getJavaFXFocusAsSecClusRole() {
		return( (ISecureSecClusRoleObj)getJavaFXFocus() );
	}

	protected class RefreshChildrenMembByGrpList
	implements IYCFRefreshCallback
	{
		public RefreshChildrenMembByGrpList() {
		}

		public void refreshMe() {
			// Use page data instead
		}
	}

	protected class PageDataChildrenMembByGrpList
	implements ISecureJavaFXSecClusRoleMembPageCallback
	{
		public PageDataChildrenMembByGrpList() {
		}

		public List<ISecureSecClusRoleMembObj> pageData( IYCFKeyHash256 priorSecClusRoleId,
		String priorLoginId )
		{
			List<ISecureSecClusRoleMembObj> dataList;
			ISecureSecClusRoleObj focus = (ISecureSecClusRoleObj)getJavaFXFocusAsSecClusRole();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
				dataList = schemaObj.getSecClusRoleMembTableObj().pageSecClusRoleMembByClusRoleIdx( focus.getRequiredSecClusRoleId(),
					priorSecClusRoleId,
					priorLoginId );
			}
			else {
				dataList = new ArrayList<ISecureSecClusRoleMembObj>();
			}
			return( dataList );
		}
	}

	public YCFBorderPane getTabViewChildrenMembByGrpListPane() {
		if( tabViewChildrenMembByGrpListPane == null ) {
			ISecureSecClusRoleObj focus = (ISecureSecClusRoleObj)getJavaFXFocusAsSecClusRole();
			ISecureSecClusRoleObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecClusRoleObj ) ) {
				javafxContainer = (ISecureSecClusRoleObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewChildrenMembByGrpListPane = javafxSchema.getSecClusRoleMembFactory().newListPane( ycfFormManager, javafxContainer, null, new PageDataChildrenMembByGrpList(), new RefreshChildrenMembByGrpList(), false );
		}
		return( tabViewChildrenMembByGrpListPane );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewChildrenMembByGrpListPane != null ) {
			((ISecureJavaFXSecClusRoleMembPaneCommon)tabViewChildrenMembByGrpListPane).setPaneMode( value );
		}
	}
}
