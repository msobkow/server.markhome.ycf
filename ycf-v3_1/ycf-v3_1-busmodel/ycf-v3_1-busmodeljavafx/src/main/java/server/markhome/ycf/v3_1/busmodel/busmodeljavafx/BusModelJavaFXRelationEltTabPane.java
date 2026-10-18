// Description: Java 25 JavaFX Element TabPane implementation for Relation.

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
 *	BusModelJavaFXRelationEltTabPane JavaFX Element TabPane implementation
 *	for Relation.
 */
public class BusModelJavaFXRelationEltTabPane
extends YCFTabPane
implements IBusModelJavaFXRelationPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected IBusModelJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	public final String LABEL_TabComponentsColumnsList = "Optional Components Columns";
	protected YCFTab tabComponentsColumns = null;
	public final String LABEL_TabComponentsPopDepList = "Optional Components Population Dependency";
	protected YCFTab tabComponentsPopDep = null;
	protected YCFBorderPane tabViewComponentsColumnsListPane = null;
	protected YCFBorderPane tabViewComponentsPopDepListPane = null;

	public BusModelJavaFXRelationEltTabPane( IYCFFormManager formManager, IBusModelJavaFXSchema argSchema, IBusModelRelationObj argFocus ) {
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
		setJavaFXFocusAsRelation( argFocus );
		// Wire the newly constructed Panes/Tabs to this TabPane
		tabComponentsColumns = new YCFTab();
		tabComponentsColumns.setText( LABEL_TabComponentsColumnsList );
		tabComponentsColumns.setContent( getTabViewComponentsColumnsListPane() );
		getTabs().add( tabComponentsColumns );
		tabComponentsPopDep = new YCFTab();
		tabComponentsPopDep.setText( LABEL_TabComponentsPopDepList );
		tabComponentsPopDep.setContent( getTabViewComponentsPopDepListPane() );
		getTabs().add( tabComponentsPopDep );
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
		if( ( value == null ) || ( value instanceof IBusModelRelationObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IBusModelRelationObj" );
		}
	}

	public void setJavaFXFocusAsRelation( IBusModelRelationObj value ) {
		setJavaFXFocus( value );
	}

	public IBusModelRelationObj getJavaFXFocusAsRelation() {
		return( (IBusModelRelationObj)getJavaFXFocus() );
	}

	protected class RefreshComponentsColumnsList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsColumnsList() {
		}

		public void refreshMe() {
			Collection<IBusModelRelationColObj> dataCollection;
			IBusModelRelationObj focus = (IBusModelRelationObj)getJavaFXFocusAsRelation();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsColumns( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsColumnsListPane();
			IBusModelJavaFXRelationColPaneList jpList = (IBusModelJavaFXRelationColPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsColumnsListPane() {
		if( tabViewComponentsColumnsListPane == null ) {
			IBusModelRelationObj focus = (IBusModelRelationObj)getJavaFXFocusAsRelation();
			Collection<IBusModelRelationColObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsColumns( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IBusModelRelationObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IBusModelRelationObj ) ) {
				javafxContainer = (IBusModelRelationObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsColumnsListPane = javafxSchema.getRelationColFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsColumnsList(), true );
		}
		return( tabViewComponentsColumnsListPane );
	}

	protected class RefreshComponentsPopDepList
	implements IYCFRefreshCallback
	{
		public RefreshComponentsPopDepList() {
		}

		public void refreshMe() {
			Collection<IBusModelPopTopDepObj> dataCollection;
			IBusModelRelationObj focus = (IBusModelRelationObj)getJavaFXFocusAsRelation();
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsPopDep( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			YCFBorderPane pane = getTabViewComponentsPopDepListPane();
			IBusModelJavaFXPopTopDepPaneList jpList = (IBusModelJavaFXPopTopDepPaneList)pane;
			jpList.setJavaFXDataCollection( dataCollection );
		}
	}

	public YCFBorderPane getTabViewComponentsPopDepListPane() {
		if( tabViewComponentsPopDepListPane == null ) {
			IBusModelRelationObj focus = (IBusModelRelationObj)getJavaFXFocusAsRelation();
			Collection<IBusModelPopTopDepObj> dataCollection;
			if( focus != null ) {
				dataCollection = focus.getOptionalComponentsPopDep( javafxIsInitializing );
			}
			else {
				dataCollection = null;
			}
			IBusModelRelationObj javafxContainer;
			if( ( focus != null ) && ( focus instanceof IBusModelRelationObj ) ) {
				javafxContainer = (IBusModelRelationObj)focus;
			}
			else {
				javafxContainer = null;
			}
			tabViewComponentsPopDepListPane = javafxSchema.getPopTopDepFactory().newListPane( ycfFormManager, javafxContainer, null, dataCollection, new RefreshComponentsPopDepList(), false );
		}
		return( tabViewComponentsPopDepListPane );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		super.setPaneMode( value );
		if( tabViewComponentsColumnsListPane != null ) {
			((IBusModelJavaFXRelationColPaneCommon)tabViewComponentsColumnsListPane).setPaneMode( value );
		}
		if( tabViewComponentsPopDepListPane != null ) {
			((IBusModelJavaFXPopTopDepPaneCommon)tabViewComponentsPopDepListPane).setPaneMode( value );
		}
	}
}
