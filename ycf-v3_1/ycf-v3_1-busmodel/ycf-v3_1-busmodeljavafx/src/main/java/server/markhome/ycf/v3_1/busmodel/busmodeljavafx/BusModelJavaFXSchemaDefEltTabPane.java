// Description: Java 25 JavaFX Element TabPane implementation for SchemaDef.

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodeljavafx;

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
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;

/**
 *	BusModelJavaFXSchemaDefEltTabPane JavaFX Element TabPane implementation
 *	for SchemaDef.
 */
public class BusModelJavaFXSchemaDefEltTabPane
extends YCFTabPane
implements IBusModelJavaFXSchemaDefPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected IBusModelJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsTablesList = "Optional Components Table Definitions";
	protected YCFTab tabComponentsTables = null;
	public final String LABEL_TabComponentsTypesList = "Optional Components Type Definitions";
	protected YCFTab tabComponentsTypes = null;
	public final String LABEL_TabComponentsSchemaRefsList = "Optional Components Schema References";
	protected YCFTab tabComponentsSchemaRefs = null;
	public final String LABEL_TabComponentsTweaksList = "Optional Components Schema Tweaks";
	protected YCFTab tabComponentsTweaks = null;
	public final String LABEL_TabComponentsRolesList = "Optional Components Schema Roles";
	protected YCFTab tabComponentsRoles = null;
	protected YCFBorderPane tabViewComponentsTablesListPane = null;
	protected YCFBorderPane tabViewComponentsTypesListPane = null;
	protected YCFBorderPane tabViewComponentsSchemaRefsListPane = null;
	protected YCFBorderPane tabViewComponentsTweaksListPane = null;
	protected YCFBorderPane tabViewComponentsRolesListPane = null;

	public BusModelJavaFXSchemaDefEltTabPane( IYCFFormManager formManager, IBusModelJavaFXSchema argSchema, IBusModelSchemaDefObj argFocus ) {
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
		setJavaFXFocusAsSchemaDef( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsTables = new YCFTab();
		tabComponentsTables.setText( LABEL_TabComponentsTablesList );
		tabComponentsTables.setContent( getTabViewComponentsTablesListPane() );
		getTabs().add( tabComponentsTables );
		tabComponentsTypes = new YCFTab();
		tabComponentsTypes.setText( LABEL_TabComponentsTypesList );
		tabComponentsTypes.setContent( getTabViewComponentsTypesListPane() );
		getTabs().add( tabComponentsTypes );
		tabComponentsSchemaRefs = new YCFTab();
		tabComponentsSchemaRefs.setText( LABEL_TabComponentsSchemaRefsList );
		tabComponentsSchemaRefs.setContent( getTabViewComponentsSchemaRefsListPane() );
		getTabs().add( tabComponentsSchemaRefs );
		tabComponentsTweaks = new YCFTab();
		tabComponentsTweaks.setText( LABEL_TabComponentsTweaksList );
		tabComponentsTweaks.setContent( getTabViewComponentsTweaksListPane() );
		getTabs().add( tabComponentsTweaks );
		tabComponentsRoles = new YCFTab();
		tabComponentsRoles.setText( LABEL_TabComponentsRolesList );
		tabComponentsRoles.setContent( getTabViewComponentsRolesListPane() );
		getTabs().add( tabComponentsRoles );
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

	public IBusModelJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof IBusModelSchemaDefObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IBusModelSchemaDefObj" );
		}
	}

	public void setJavaFXFocusAsSchemaDef( IBusModelSchemaDefObj value ) {
		setJavaFXFocus( value );
	}

	public IBusModelSchemaDefObj getJavaFXFocusAsSchemaDef() {
		return( (IBusModelSchemaDefObj)getJavaFXFocus() );
	}

	protected class RefreshComponentsTablesList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsTablesList() {
		}

		public void refreshMe() {
			Collection<IBusModelTableObj> dataCollection;
			IBusModelSchemaDefObj focus = (IBusModelSchemaDefObj)getJavaFXFocusAsSchemaDef();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsTables( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsTablesListPane();
			IBusModelJavaFXTablePaneList jpList = (IBusModelJavaFXTablePaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsTablesListPane() {
		if( tabViewComponentsTablesListPane == null ) {
			IBusModelSchemaDefObj focus = (IBusModelSchemaDefObj)getJavaFXFocusAsSchemaDef();
			Collection<IBusModelTableObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsTables( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IBusModelSchemaDefObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IBusModelSchemaDefObj ) ) {
				javafxContainer = (IBusModelSchemaDefObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsTablesListPane = javafxSchema.getTableFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsTablesList(), false );
		}
		return( tabViewComponentsTablesListPane );
	}

	protected class RefreshComponentsTypesList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsTypesList() {
		}

		public void refreshMe() {
			Collection<IBusModelValueObj> dataCollection;
			IBusModelSchemaDefObj focus = (IBusModelSchemaDefObj)getJavaFXFocusAsSchemaDef();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsTypes( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsTypesListPane();
			IBusModelJavaFXValuePaneList jpList = (IBusModelJavaFXValuePaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsTypesListPane() {
		if( tabViewComponentsTypesListPane == null ) {
			IBusModelSchemaDefObj focus = (IBusModelSchemaDefObj)getJavaFXFocusAsSchemaDef();
			Collection<IBusModelValueObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsTypes( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IBusModelScopeObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IBusModelScopeObj ) ) {
				javafxContainer = (IBusModelScopeObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsTypesListPane = javafxSchema.getValueFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsTypesList(), true );
		}
		return( tabViewComponentsTypesListPane );
	}

	protected class RefreshComponentsSchemaRefsList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsSchemaRefsList() {
		}

		public void refreshMe() {
			Collection<IBusModelSchemaRefObj> dataCollection;
			IBusModelSchemaDefObj focus = (IBusModelSchemaDefObj)getJavaFXFocusAsSchemaDef();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSchemaRefs( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsSchemaRefsListPane();
			IBusModelJavaFXSchemaRefPaneList jpList = (IBusModelJavaFXSchemaRefPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsSchemaRefsListPane() {
		if( tabViewComponentsSchemaRefsListPane == null ) {
			IBusModelSchemaDefObj focus = (IBusModelSchemaDefObj)getJavaFXFocusAsSchemaDef();
			Collection<IBusModelSchemaRefObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsSchemaRefs( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IBusModelSchemaDefObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IBusModelSchemaDefObj ) ) {
				javafxContainer = (IBusModelSchemaDefObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsSchemaRefsListPane = javafxSchema.getSchemaRefFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsSchemaRefsList(), true );
		}
		return( tabViewComponentsSchemaRefsListPane );
	}

	protected class RefreshComponentsTweaksList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsTweaksList() {
		}

		public void refreshMe() {
			Collection<IBusModelTweakObj> dataCollection;
			IBusModelSchemaDefObj focus = (IBusModelSchemaDefObj)getJavaFXFocusAsSchemaDef();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsTweaks( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsTweaksListPane();
			IBusModelJavaFXTweakPaneList jpList = (IBusModelJavaFXTweakPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsTweaksListPane() {
		if( tabViewComponentsTweaksListPane == null ) {
			IBusModelSchemaDefObj focus = (IBusModelSchemaDefObj)getJavaFXFocusAsSchemaDef();
			Collection<IBusModelTweakObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsTweaks( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IBusModelScopeObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IBusModelScopeObj ) ) {
				javafxContainer = (IBusModelScopeObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsTweaksListPane = javafxSchema.getTweakFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsTweaksList(), false );
		}
		return( tabViewComponentsTweaksListPane );
	}

	protected class RefreshComponentsRolesList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsRolesList() {
		}

		public void refreshMe() {
			Collection<IBusModelSchemaRoleObj> dataCollection;
			IBusModelSchemaDefObj focus = (IBusModelSchemaDefObj)getJavaFXFocusAsSchemaDef();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsRoles( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsRolesListPane();
			IBusModelJavaFXSchemaRolePaneList jpList = (IBusModelJavaFXSchemaRolePaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsRolesListPane() {
		if( tabViewComponentsRolesListPane == null ) {
			IBusModelSchemaDefObj focus = (IBusModelSchemaDefObj)getJavaFXFocusAsSchemaDef();
			Collection<IBusModelSchemaRoleObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsRoles( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IBusModelSchemaDefObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IBusModelSchemaDefObj ) ) {
				javafxContainer = (IBusModelSchemaDefObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsRolesListPane = javafxSchema.getSchemaRoleFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsRolesList(), false );
		}
		return( tabViewComponentsRolesListPane );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsTablesListPane != null ) {
			((IBusModelJavaFXTablePaneCommon)tabViewComponentsTablesListPane).setPaneMode( value );
		}
		if( tabViewComponentsTypesListPane != null ) {
			((IBusModelJavaFXValuePaneCommon)tabViewComponentsTypesListPane).setPaneMode( value );
		}
		if( tabViewComponentsSchemaRefsListPane != null ) {
			((IBusModelJavaFXSchemaRefPaneCommon)tabViewComponentsSchemaRefsListPane).setPaneMode( value );
		}
		if( tabViewComponentsTweaksListPane != null ) {
			((IBusModelJavaFXTweakPaneCommon)tabViewComponentsTweaksListPane).setPaneMode( value );
		}
		if( tabViewComponentsRolesListPane != null ) {
			((IBusModelJavaFXSchemaRolePaneCommon)tabViewComponentsRolesListPane).setPaneMode( value );
		}
	}
}
