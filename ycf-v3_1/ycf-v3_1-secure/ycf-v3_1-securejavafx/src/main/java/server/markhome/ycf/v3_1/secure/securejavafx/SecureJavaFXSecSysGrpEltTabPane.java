// Description: Java 25 JavaFX Element TabPane implementation for SecSysGrp.

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
 *	SecureJavaFXSecSysGrpEltTabPane JavaFX Element TabPane implementation
 *	for SecSysGrp.
 */
public class SecureJavaFXSecSysGrpEltTabPane
extends YCFTabPane
implements ISecureJavaFXSecSysGrpPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsImplSysRoleAttr = "Optional Components Implements role";
	protected YCFTab tabComponentsImplSysRole = null;
	public final String LABEL_TabComponentsIncByGrpList = "Optional Components Included by Group";
	protected YCFTab tabComponentsIncByGrp = null;
	public final String LABEL_TabChildrenMembByGrpList = "Optional Children Members of Group";
	protected YCFTab tabChildrenMembByGrp = null;
	public final String LABEL_TabComponentsImplClusGrpList = "Optional Components Implements cluster group";
	protected YCFTab tabComponentsImplClusGrp = null;
	public final String LABEL_TabComponentsImplTentGrpList = "Optional Components Implements tenant group";
	protected YCFTab tabComponentsImplTentGrp = null;
	public final String LABEL_TabComponentsImplClusRoleList = "Optional Components Implements cluster role";
	protected YCFTab tabComponentsImplClusRole = null;
	public final String LABEL_TabComponentsImplTentRoleList = "Optional Components Implements tenant role";
	protected YCFTab tabComponentsImplTentRole = null;
	public final String LABEL_TabChildrenSysGrpByNameList = "Optional Children SysGroup by Name";
	protected YCFTab tabChildrenSysGrpByName = null;
	public final String LABEL_TabChildrenRoleByEnableNameList = "Optional Children System Role by Name";
	protected YCFTab tabChildrenRoleByEnableName = null;
	protected ScrollPane tabViewComponentsImplSysRoleAttrScrollPane = null;
	protected YCFGridPane tabViewComponentsImplSysRoleAttrPane = null;
	protected YCFBorderPane tabViewComponentsIncByGrpListPane = null;
	protected YCFBorderPane tabViewChildrenMembByGrpListPane = null;
	protected YCFBorderPane tabViewComponentsImplClusGrpListPane = null;
	protected YCFBorderPane tabViewComponentsImplTentGrpListPane = null;
	protected YCFBorderPane tabViewComponentsImplClusRoleListPane = null;
	protected YCFBorderPane tabViewComponentsImplTentRoleListPane = null;
	protected YCFBorderPane tabViewChildrenSysGrpByNameListPane = null;
	protected YCFBorderPane tabViewChildrenRoleByEnableNameListPane = null;

	public SecureJavaFXSecSysGrpEltTabPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureSecSysGrpObj argFocus ) {
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
		setJavaFXFocusAsSecSysGrp( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsImplSysRole = new YCFTab();
		tabComponentsImplSysRole.setText( LABEL_TabComponentsImplSysRoleAttr );
		tabComponentsImplSysRole.setContent( getTabViewComponentsImplSysRoleAttrScrollPane() );
		getTabs().add( tabComponentsImplSysRole );
		tabComponentsIncByGrp = new YCFTab();
		tabComponentsIncByGrp.setText( LABEL_TabComponentsIncByGrpList );
		tabComponentsIncByGrp.setContent( getTabViewComponentsIncByGrpListPane() );
		getTabs().add( tabComponentsIncByGrp );
		tabChildrenMembByGrp = new YCFTab();
		tabChildrenMembByGrp.setText( LABEL_TabChildrenMembByGrpList );
		tabChildrenMembByGrp.setContent( getTabViewChildrenMembByGrpListPane() );
		getTabs().add( tabChildrenMembByGrp );
		tabComponentsImplClusGrp = new YCFTab();
		tabComponentsImplClusGrp.setText( LABEL_TabComponentsImplClusGrpList );
		tabComponentsImplClusGrp.setContent( getTabViewComponentsImplClusGrpListPane() );
		getTabs().add( tabComponentsImplClusGrp );
		tabComponentsImplTentGrp = new YCFTab();
		tabComponentsImplTentGrp.setText( LABEL_TabComponentsImplTentGrpList );
		tabComponentsImplTentGrp.setContent( getTabViewComponentsImplTentGrpListPane() );
		getTabs().add( tabComponentsImplTentGrp );
		tabComponentsImplClusRole = new YCFTab();
		tabComponentsImplClusRole.setText( LABEL_TabComponentsImplClusRoleList );
		tabComponentsImplClusRole.setContent( getTabViewComponentsImplClusRoleListPane() );
		getTabs().add( tabComponentsImplClusRole );
		tabComponentsImplTentRole = new YCFTab();
		tabComponentsImplTentRole.setText( LABEL_TabComponentsImplTentRoleList );
		tabComponentsImplTentRole.setContent( getTabViewComponentsImplTentRoleListPane() );
		getTabs().add( tabComponentsImplTentRole );
		tabChildrenSysGrpByName = new YCFTab();
		tabChildrenSysGrpByName.setText( LABEL_TabChildrenSysGrpByNameList );
		tabChildrenSysGrpByName.setContent( getTabViewChildrenSysGrpByNameListPane() );
		getTabs().add( tabChildrenSysGrpByName );
		tabChildrenRoleByEnableName = new YCFTab();
		tabChildrenRoleByEnableName.setText( LABEL_TabChildrenRoleByEnableNameList );
		tabChildrenRoleByEnableName.setContent( getTabViewChildrenRoleByEnableNameListPane() );
		getTabs().add( tabChildrenRoleByEnableName );
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
		if( ( value == null ) || ( value instanceof ISecureSecSysGrpObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecSysGrpObj" );
		}
	}

	public void setJavaFXFocusAsSecSysGrp( ISecureSecSysGrpObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureSecSysGrpObj getJavaFXFocusAsSecSysGrp() {
		return( (ISecureSecSysGrpObj)getJavaFXFocus() );
	}

	public ScrollPane getTabViewComponentsImplSysRoleAttrScrollPane() {
		if( tabViewComponentsImplSysRoleAttrScrollPane == null ) {
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			ISecureSecSysRoleObj refImplSysRole =
				( focus != null )
					? focus.getOptionalComponentsImplSysRole()
					: null;
			tabViewComponentsImplSysRoleAttrPane = javafxSchema.getSecSysRoleFactory().newAttrPane( ycfFormManager, refImplSysRole );
			tabViewComponentsImplSysRoleAttrScrollPane = new ScrollPane();
			tabViewComponentsImplSysRoleAttrScrollPane.setFitToWidth( true );
			tabViewComponentsImplSysRoleAttrScrollPane.setHbarPolicy( ScrollBarPolicy.NEVER );
			tabViewComponentsImplSysRoleAttrScrollPane.setVbarPolicy( ScrollBarPolicy.AS_NEEDED );
			tabViewComponentsImplSysRoleAttrScrollPane.setContent( tabViewComponentsImplSysRoleAttrPane );
		}
		return( tabViewComponentsImplSysRoleAttrScrollPane );
	}

	protected class RefreshComponentsIncByGrpList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsIncByGrpList() {
		}

		public void refreshMe() {
			// Use page data instead
		}
	}

	protected class PageDataComponentsIncByGrpList
	implements ISecureJavaFXSecSysGrpIncPageCallback
	{
		public PageDataComponentsIncByGrpList() {
		}

		public List<ISecureSecSysGrpIncObj> pageData( IYCFKeyHash256 priorSecSysGrpId,
		String priorInclName )
		{
			List<ISecureSecSysGrpIncObj> dataList;
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
				dataList = schemaObj.getSecSysGrpIncTableObj().pageSecSysGrpIncBySysGrpIdx( focus.getRequiredSecSysGrpId(),
					priorSecSysGrpId,
					priorInclName );
			}
			else {
				dataList = new ArrayList<ISecureSecSysGrpIncObj>();
			}
			return( dataList );
		}
	}

	public YCFBorderPane getTabViewComponentsIncByGrpListPane() {
		if( tabViewComponentsIncByGrpListPane == null ) {
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			ISecureSecSysGrpObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecSysGrpObj ) ) {
				javafxContainer = (ISecureSecSysGrpObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsIncByGrpListPane = javafxSchema.getSecSysGrpIncFactory().newListPane( ycfFormManager, javafxContainer, null, new PageDataComponentsIncByGrpList(), new RefreshComponentsIncByGrpList(), false );
		}
		return( tabViewComponentsIncByGrpListPane );
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
	implements ISecureJavaFXSecSysGrpMembPageCallback
	{
		public PageDataChildrenMembByGrpList() {
		}

		public List<ISecureSecSysGrpMembObj> pageData( IYCFKeyHash256 priorSecSysGrpId,
		String priorLoginId )
		{
			List<ISecureSecSysGrpMembObj> dataList;
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
				dataList = schemaObj.getSecSysGrpMembTableObj().pageSecSysGrpMembBySysGrpIdx( focus.getRequiredSecSysGrpId(),
					priorSecSysGrpId,
					priorLoginId );
			}
			else {
				dataList = new ArrayList<ISecureSecSysGrpMembObj>();
			}
			return( dataList );
		}
	}

	public YCFBorderPane getTabViewChildrenMembByGrpListPane() {
		if( tabViewChildrenMembByGrpListPane == null ) {
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			ISecureSecSysGrpObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecSysGrpObj ) ) {
				javafxContainer = (ISecureSecSysGrpObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewChildrenMembByGrpListPane = javafxSchema.getSecSysGrpMembFactory().newListPane( ycfFormManager, javafxContainer, null, new PageDataChildrenMembByGrpList(), new RefreshChildrenMembByGrpList(), false );
		}
		return( tabViewChildrenMembByGrpListPane );
	}

	protected class RefreshComponentsImplClusGrpList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsImplClusGrpList() {
		}

		public void refreshMe() {
			Collection<ISecureSecClusGrpObj> dataCollection;
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsImplClusGrp( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsImplClusGrpListPane();
			ISecureJavaFXSecClusGrpPaneList jpList = (ISecureJavaFXSecClusGrpPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsImplClusGrpListPane() {
		if( tabViewComponentsImplClusGrpListPane == null ) {
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			Collection<ISecureSecClusGrpObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsImplClusGrp( javafxIsInitializing );
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
			tabViewComponentsImplClusGrpListPane = javafxSchema.getSecClusGrpFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsImplClusGrpList(), false );
		}
		return( tabViewComponentsImplClusGrpListPane );
	}

	protected class RefreshComponentsImplTentGrpList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsImplTentGrpList() {
		}

		public void refreshMe() {
			Collection<ISecureSecTentGrpObj> dataCollection;
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsImplTentGrp( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsImplTentGrpListPane();
			ISecureJavaFXSecTentGrpPaneList jpList = (ISecureJavaFXSecTentGrpPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsImplTentGrpListPane() {
		if( tabViewComponentsImplTentGrpListPane == null ) {
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			Collection<ISecureSecTentGrpObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsImplTentGrp( javafxIsInitializing );
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
			tabViewComponentsImplTentGrpListPane = javafxSchema.getSecTentGrpFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsImplTentGrpList(), false );
		}
		return( tabViewComponentsImplTentGrpListPane );
	}

	protected class RefreshComponentsImplClusRoleList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsImplClusRoleList() {
		}

		public void refreshMe() {
			Collection<ISecureSecClusRoleObj> dataCollection;
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsImplClusRole( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsImplClusRoleListPane();
			ISecureJavaFXSecClusRolePaneList jpList = (ISecureJavaFXSecClusRolePaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsImplClusRoleListPane() {
		if( tabViewComponentsImplClusRoleListPane == null ) {
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			Collection<ISecureSecClusRoleObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsImplClusRole( javafxIsInitializing );
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
			tabViewComponentsImplClusRoleListPane = javafxSchema.getSecClusRoleFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsImplClusRoleList(), false );
		}
		return( tabViewComponentsImplClusRoleListPane );
	}

	protected class RefreshComponentsImplTentRoleList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsImplTentRoleList() {
		}

		public void refreshMe() {
			Collection<ISecureSecTentRoleObj> dataCollection;
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsImplTentRole( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsImplTentRoleListPane();
			ISecureJavaFXSecTentRolePaneList jpList = (ISecureJavaFXSecTentRolePaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsImplTentRoleListPane() {
		if( tabViewComponentsImplTentRoleListPane == null ) {
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			Collection<ISecureSecTentRoleObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsImplTentRole( javafxIsInitializing );
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
			tabViewComponentsImplTentRoleListPane = javafxSchema.getSecTentRoleFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsImplTentRoleList(), false );
		}
		return( tabViewComponentsImplTentRoleListPane );
	}

	protected class RefreshChildrenSysGrpByNameList
	implements IYCFRefreshCallback
	{
		public RefreshChildrenSysGrpByNameList() {
		}

		public void refreshMe() {
			// Use page data instead
		}
	}

	protected class PageDataChildrenSysGrpByNameList
	implements ISecureJavaFXSecSysGrpIncPageCallback
	{
		public PageDataChildrenSysGrpByNameList() {
		}

		public List<ISecureSecSysGrpIncObj> pageData( IYCFKeyHash256 priorSecSysGrpId,
		String priorInclName )
		{
			List<ISecureSecSysGrpIncObj> dataList;
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
				dataList = schemaObj.getSecSysGrpIncTableObj().pageSecSysGrpIncByNameIdx( focus.getRequiredName(),
					priorSecSysGrpId,
					priorInclName );
			}
			else {
				dataList = new ArrayList<ISecureSecSysGrpIncObj>();
			}
			return( dataList );
		}
	}

	public YCFBorderPane getTabViewChildrenSysGrpByNameListPane() {
		if( tabViewChildrenSysGrpByNameListPane == null ) {
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			ISecureSecSysGrpObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecSysGrpObj ) ) {
				javafxContainer = (ISecureSecSysGrpObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewChildrenSysGrpByNameListPane = javafxSchema.getSecSysGrpIncFactory().newListPane( ycfFormManager, javafxContainer, null, new PageDataChildrenSysGrpByNameList(), new RefreshChildrenSysGrpByNameList(), false );
		}
		return( tabViewChildrenSysGrpByNameListPane );
	}

	protected class RefreshChildrenRoleByEnableNameList
	implements IYCFRefreshCallback
	{
		public RefreshChildrenRoleByEnableNameList() {
		}

		public void refreshMe() {
			// Use page data instead
		}
	}

	protected class PageDataChildrenRoleByEnableNameList
	implements ISecureJavaFXSecSysRoleEnablesPageCallback
	{
		public PageDataChildrenRoleByEnableNameList() {
		}

		public List<ISecureSecSysRoleEnablesObj> pageData( IYCFKeyHash256 priorSecSysRoleId,
		String priorEnableName )
		{
			List<ISecureSecSysRoleEnablesObj> dataList;
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			if( focus != null ) {
				ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
				dataList = schemaObj.getSecSysRoleEnablesTableObj().pageSecSysRoleEnablesByNameIdx( focus.getRequiredName(),
					priorSecSysRoleId,
					priorEnableName );
			}
			else {
				dataList = new ArrayList<ISecureSecSysRoleEnablesObj>();
			}
			return( dataList );
		}
	}

	public YCFBorderPane getTabViewChildrenRoleByEnableNameListPane() {
		if( tabViewChildrenRoleByEnableNameListPane == null ) {
			ISecureSecSysGrpObj focus = (ISecureSecSysGrpObj)getJavaFXFocusAsSecSysGrp();
			ISecureSecSysRoleObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof ISecureSecSysRoleObj ) ) {
				javafxContainer = (ISecureSecSysRoleObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewChildrenRoleByEnableNameListPane = javafxSchema.getSecSysRoleEnablesFactory().newListPane( ycfFormManager, javafxContainer, null, new PageDataChildrenRoleByEnableNameList(), new RefreshChildrenRoleByEnableNameList(), false );
		}
		return( tabViewChildrenRoleByEnableNameListPane );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
	if( tabViewComponentsImplSysRoleAttrPane != null ) {
		((ISecureJavaFXSecSysRolePaneCommon)tabViewComponentsImplSysRoleAttrPane).setPaneMode( YCFPane.PaneMode.View );
	}
		if( tabViewComponentsIncByGrpListPane != null ) {
			((ISecureJavaFXSecSysGrpIncPaneCommon)tabViewComponentsIncByGrpListPane).setPaneMode( value );
		}
		if( tabViewChildrenMembByGrpListPane != null ) {
			((ISecureJavaFXSecSysGrpMembPaneCommon)tabViewChildrenMembByGrpListPane).setPaneMode( value );
		}
		if( tabViewComponentsImplClusGrpListPane != null ) {
			((ISecureJavaFXSecClusGrpPaneCommon)tabViewComponentsImplClusGrpListPane).setPaneMode( value );
		}
		if( tabViewComponentsImplTentGrpListPane != null ) {
			((ISecureJavaFXSecTentGrpPaneCommon)tabViewComponentsImplTentGrpListPane).setPaneMode( value );
		}
		if( tabViewComponentsImplClusRoleListPane != null ) {
			((ISecureJavaFXSecClusRolePaneCommon)tabViewComponentsImplClusRoleListPane).setPaneMode( value );
		}
		if( tabViewComponentsImplTentRoleListPane != null ) {
			((ISecureJavaFXSecTentRolePaneCommon)tabViewComponentsImplTentRoleListPane).setPaneMode( value );
		}
		if( tabViewChildrenSysGrpByNameListPane != null ) {
			((ISecureJavaFXSecSysGrpIncPaneCommon)tabViewChildrenSysGrpByNameListPane).setPaneMode( value );
		}
		if( tabViewChildrenRoleByEnableNameListPane != null ) {
			((ISecureJavaFXSecSysRoleEnablesPaneCommon)tabViewChildrenRoleByEnableNameListPane).setPaneMode( value );
		}
	}
}
