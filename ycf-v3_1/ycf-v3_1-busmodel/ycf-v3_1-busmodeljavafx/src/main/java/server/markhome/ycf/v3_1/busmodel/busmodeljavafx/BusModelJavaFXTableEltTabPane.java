// Description: Java 25 JavaFX Element TabPane implementation for Table.

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
 *	BusModelJavaFXTableEltTabPane JavaFX Element TabPane implementation
 *	for Table.
 */
public class BusModelJavaFXTableEltTabPane
extends YCFTabPane
implements IBusModelJavaFXTablePaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected IBusModelJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsRelationList = "Optional Components Relation Definitions";
	protected YCFTab tabComponentsRelation = null;
	public final String LABEL_TabComponentsIndexList = "Optional Components Index Definitions";
	protected YCFTab tabComponentsIndex = null;
	public final String LABEL_TabComponentsColumnsList = "Optional Components Columns";
	protected YCFTab tabComponentsColumns = null;
	public final String LABEL_TabChildrenReverseRelationsList = "Optional Children Reverse Relations";
	protected YCFTab tabChildrenReverseRelations = null;
	public final String LABEL_TabComponentsChainsList = "Optional Components Chains";
	protected YCFTab tabComponentsChains = null;
	public final String LABEL_TabComponentsDelDepList = "Optional Components Deletion Dependency";
	protected YCFTab tabComponentsDelDep = null;
	public final String LABEL_TabComponentsClearDepList = "Optional Components Clear Relationships Dependency";
	protected YCFTab tabComponentsClearDep = null;
	public final String LABEL_TabComponentsServerMethodsList = "Optional Components Server Methods";
	protected YCFTab tabComponentsServerMethods = null;
	public final String LABEL_TabComponentsTweaksList = "Optional Components Table Tweaks";
	protected YCFTab tabComponentsTweaks = null;
	protected YCFBorderPane tabViewComponentsRelationListPane = null;
	protected YCFBorderPane tabViewComponentsIndexListPane = null;
	protected YCFBorderPane tabViewComponentsColumnsListPane = null;
	protected YCFBorderPane tabViewChildrenReverseRelationsListPane = null;
	protected YCFBorderPane tabViewComponentsChainsListPane = null;
	protected YCFBorderPane tabViewComponentsDelDepListPane = null;
	protected YCFBorderPane tabViewComponentsClearDepListPane = null;
	protected YCFBorderPane tabViewComponentsServerMethodsListPane = null;
	protected YCFBorderPane tabViewComponentsTweaksListPane = null;

	public BusModelJavaFXTableEltTabPane( IYCFFormManager formManager, IBusModelJavaFXSchema argSchema, IBusModelTableObj argFocus ) {
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
		setJavaFXFocusAsTable( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsRelation = new YCFTab();
		tabComponentsRelation.setText( LABEL_TabComponentsRelationList );
		tabComponentsRelation.setContent( getTabViewComponentsRelationListPane() );
		getTabs().add( tabComponentsRelation );
		tabComponentsIndex = new YCFTab();
		tabComponentsIndex.setText( LABEL_TabComponentsIndexList );
		tabComponentsIndex.setContent( getTabViewComponentsIndexListPane() );
		getTabs().add( tabComponentsIndex );
		tabComponentsColumns = new YCFTab();
		tabComponentsColumns.setText( LABEL_TabComponentsColumnsList );
		tabComponentsColumns.setContent( getTabViewComponentsColumnsListPane() );
		getTabs().add( tabComponentsColumns );
		tabChildrenReverseRelations = new YCFTab();
		tabChildrenReverseRelations.setText( LABEL_TabChildrenReverseRelationsList );
		tabChildrenReverseRelations.setContent( getTabViewChildrenReverseRelationsListPane() );
		getTabs().add( tabChildrenReverseRelations );
		tabComponentsChains = new YCFTab();
		tabComponentsChains.setText( LABEL_TabComponentsChainsList );
		tabComponentsChains.setContent( getTabViewComponentsChainsListPane() );
		getTabs().add( tabComponentsChains );
		tabComponentsDelDep = new YCFTab();
		tabComponentsDelDep.setText( LABEL_TabComponentsDelDepList );
		tabComponentsDelDep.setContent( getTabViewComponentsDelDepListPane() );
		getTabs().add( tabComponentsDelDep );
		tabComponentsClearDep = new YCFTab();
		tabComponentsClearDep.setText( LABEL_TabComponentsClearDepList );
		tabComponentsClearDep.setContent( getTabViewComponentsClearDepListPane() );
		getTabs().add( tabComponentsClearDep );
		tabComponentsServerMethods = new YCFTab();
		tabComponentsServerMethods.setText( LABEL_TabComponentsServerMethodsList );
		tabComponentsServerMethods.setContent( getTabViewComponentsServerMethodsListPane() );
		getTabs().add( tabComponentsServerMethods );
		tabComponentsTweaks = new YCFTab();
		tabComponentsTweaks.setText( LABEL_TabComponentsTweaksList );
		tabComponentsTweaks.setContent( getTabViewComponentsTweaksListPane() );
		getTabs().add( tabComponentsTweaks );
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
		if( ( value == null ) || ( value instanceof IBusModelTableObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IBusModelTableObj" );
		}
	}

	public void setJavaFXFocusAsTable( IBusModelTableObj value ) {
		setJavaFXFocus( value );
	}

	public IBusModelTableObj getJavaFXFocusAsTable() {
		return( (IBusModelTableObj)getJavaFXFocus() );
	}

	protected class RefreshComponentsRelationList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsRelationList() {
		}

		public void refreshMe() {
			Collection<IBusModelRelationObj> dataCollection;
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsRelation( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsRelationListPane();
			IBusModelJavaFXRelationPaneList jpList = (IBusModelJavaFXRelationPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsRelationListPane() {
		if( tabViewComponentsRelationListPane == null ) {
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			Collection<IBusModelRelationObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsRelation( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IBusModelTableObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IBusModelTableObj ) ) {
				javafxContainer = (IBusModelTableObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsRelationListPane = javafxSchema.getRelationFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsRelationList(), false );
		}
		return( tabViewComponentsRelationListPane );
	}

	protected class RefreshComponentsIndexList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsIndexList() {
		}

		public void refreshMe() {
			Collection<IBusModelIndexObj> dataCollection;
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsIndex( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsIndexListPane();
			IBusModelJavaFXIndexPaneList jpList = (IBusModelJavaFXIndexPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsIndexListPane() {
		if( tabViewComponentsIndexListPane == null ) {
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			Collection<IBusModelIndexObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsIndex( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IBusModelTableObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IBusModelTableObj ) ) {
				javafxContainer = (IBusModelTableObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsIndexListPane = javafxSchema.getIndexFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsIndexList(), false );
		}
		return( tabViewComponentsIndexListPane );
	}

	protected class RefreshComponentsColumnsList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsColumnsList() {
		}

		public void refreshMe() {
			Collection<IBusModelValueObj> dataCollection;
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsColumns( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsColumnsListPane();
			IBusModelJavaFXValuePaneList jpList = (IBusModelJavaFXValuePaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsColumnsListPane() {
		if( tabViewComponentsColumnsListPane == null ) {
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			Collection<IBusModelValueObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsColumns( javafxIsInitializing );
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
			tabViewComponentsColumnsListPane = javafxSchema.getValueFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsColumnsList(), true );
		}
		return( tabViewComponentsColumnsListPane );
	}

	protected class RefreshChildrenReverseRelationsList
	implements IYCFRefreshCallback
	{
		public RefreshChildrenReverseRelationsList() {
		}

		public void refreshMe() {
			Collection<IBusModelRelationObj> dataCollection;
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenReverseRelations( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewChildrenReverseRelationsListPane();
			IBusModelJavaFXRelationPaneList jpList = (IBusModelJavaFXRelationPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewChildrenReverseRelationsListPane() {
		if( tabViewChildrenReverseRelationsListPane == null ) {
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			Collection<IBusModelRelationObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalChildrenReverseRelations( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IBusModelTableObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IBusModelTableObj ) ) {
				javafxContainer = (IBusModelTableObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewChildrenReverseRelationsListPane = javafxSchema.getRelationFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshChildrenReverseRelationsList(), false );
		}
		return( tabViewChildrenReverseRelationsListPane );
	}

	protected class RefreshComponentsChainsList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsChainsList() {
		}

		public void refreshMe() {
			Collection<IBusModelChainObj> dataCollection;
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsChains( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsChainsListPane();
			IBusModelJavaFXChainPaneList jpList = (IBusModelJavaFXChainPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsChainsListPane() {
		if( tabViewComponentsChainsListPane == null ) {
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			Collection<IBusModelChainObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsChains( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IBusModelTableObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IBusModelTableObj ) ) {
				javafxContainer = (IBusModelTableObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsChainsListPane = javafxSchema.getChainFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsChainsList(), false );
		}
		return( tabViewComponentsChainsListPane );
	}

	protected class RefreshComponentsDelDepList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsDelDepList() {
		}

		public void refreshMe() {
			Collection<IBusModelDelTopDepObj> dataCollection;
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsDelDep( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsDelDepListPane();
			IBusModelJavaFXDelTopDepPaneList jpList = (IBusModelJavaFXDelTopDepPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsDelDepListPane() {
		if( tabViewComponentsDelDepListPane == null ) {
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			Collection<IBusModelDelTopDepObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsDelDep( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IBusModelTableObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IBusModelTableObj ) ) {
				javafxContainer = (IBusModelTableObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsDelDepListPane = javafxSchema.getDelTopDepFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsDelDepList(), true );
		}
		return( tabViewComponentsDelDepListPane );
	}

	protected class RefreshComponentsClearDepList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsClearDepList() {
		}

		public void refreshMe() {
			Collection<IBusModelClearTopDepObj> dataCollection;
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsClearDep( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsClearDepListPane();
			IBusModelJavaFXClearTopDepPaneList jpList = (IBusModelJavaFXClearTopDepPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsClearDepListPane() {
		if( tabViewComponentsClearDepListPane == null ) {
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			Collection<IBusModelClearTopDepObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsClearDep( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IBusModelTableObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IBusModelTableObj ) ) {
				javafxContainer = (IBusModelTableObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsClearDepListPane = javafxSchema.getClearTopDepFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsClearDepList(), true );
		}
		return( tabViewComponentsClearDepListPane );
	}

	protected class RefreshComponentsServerMethodsList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsServerMethodsList() {
		}

		public void refreshMe() {
			Collection<IBusModelServerMethodObj> dataCollection;
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsServerMethods( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsServerMethodsListPane();
			IBusModelJavaFXServerMethodPaneList jpList = (IBusModelJavaFXServerMethodPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsServerMethodsListPane() {
		if( tabViewComponentsServerMethodsListPane == null ) {
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
			Collection<IBusModelServerMethodObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsServerMethods( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IBusModelTableObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IBusModelTableObj ) ) {
				javafxContainer = (IBusModelTableObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsServerMethodsListPane = javafxSchema.getServerMethodFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsServerMethodsList(), false );
		}
		return( tabViewComponentsServerMethodsListPane );
	}

	protected class RefreshComponentsTweaksList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsTweaksList() {
		}

		public void refreshMe() {
			Collection<IBusModelTweakObj> dataCollection;
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
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
			IBusModelTableObj focus = (IBusModelTableObj)getJavaFXFocusAsTable();
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

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsRelationListPane != null ) {
			((IBusModelJavaFXRelationPaneCommon)tabViewComponentsRelationListPane).setPaneMode( value );
		}
		if( tabViewComponentsIndexListPane != null ) {
			((IBusModelJavaFXIndexPaneCommon)tabViewComponentsIndexListPane).setPaneMode( value );
		}
		if( tabViewComponentsColumnsListPane != null ) {
			((IBusModelJavaFXValuePaneCommon)tabViewComponentsColumnsListPane).setPaneMode( value );
		}
		if( tabViewChildrenReverseRelationsListPane != null ) {
			((IBusModelJavaFXRelationPaneCommon)tabViewChildrenReverseRelationsListPane).setPaneMode( value );
		}
		if( tabViewComponentsChainsListPane != null ) {
			((IBusModelJavaFXChainPaneCommon)tabViewComponentsChainsListPane).setPaneMode( value );
		}
		if( tabViewComponentsDelDepListPane != null ) {
			((IBusModelJavaFXDelTopDepPaneCommon)tabViewComponentsDelDepListPane).setPaneMode( value );
		}
		if( tabViewComponentsClearDepListPane != null ) {
			((IBusModelJavaFXClearTopDepPaneCommon)tabViewComponentsClearDepListPane).setPaneMode( value );
		}
		if( tabViewComponentsServerMethodsListPane != null ) {
			((IBusModelJavaFXServerMethodPaneCommon)tabViewComponentsServerMethodsListPane).setPaneMode( value );
		}
		if( tabViewComponentsTweaksListPane != null ) {
			((IBusModelJavaFXTweakPaneCommon)tabViewComponentsTweaksListPane).setPaneMode( value );
		}
	}
}
