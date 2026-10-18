// Description: Java 25 JavaFX List of Obj Pane implementation for Int16Type.

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
import java.util.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.util.Callback;
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
import server.markhome.ycf.v3_1.secure.securejavafx.*;
import server.markhome.ycf.v3_1.intnet.intnetjavafx.*;

/**
 *	BusModelJavaFXInt16TypeListPane JavaFX List of Obj Pane implementation
 *	for Int16Type.
 */
public class BusModelJavaFXInt16TypeListPane
extends YCFBorderPane
implements IBusModelJavaFXInt16TypePaneList
{
	public static String S_FormName = "List Int16Type";
	protected IBusModelJavaFXSchema javafxSchema = null;
	protected Collection<IBusModelInt16TypeObj> javafxDataCollection = null;
	protected ObservableList<IBusModelInt16TypeObj> observableListOfInt16Type = null;
	protected ScrollPane scrollMenu = null;
	protected YCFHBox hboxMenu = null;
	protected ScrollPane scrollMenuAdd = null;
	protected YCFVBox vboxMenuAdd = null;
	protected YCFButton buttonAdd = null;
	protected YCFButton buttonCancelAdd = null;
	protected YCFButton buttonAddInt16Type = null;
	protected YCFButton buttonAddId16Gen = null;
	protected YCFButton buttonViewSelected = null;
	protected YCFButton buttonEditSelected = null;
	protected YCFButton buttonDeleteSelected = null;
	protected TableView<IBusModelInt16TypeObj> dataTable = null;
	protected TableColumn<IBusModelInt16TypeObj,String> tableColumnObjKind = null;
	protected TableColumn<IBusModelInt16TypeObj, IYCFKeyHash256> tableColumnId = null;
	protected TableColumn<IBusModelInt16TypeObj, String> tableColumnName = null;
	protected TableColumn<IBusModelInt16TypeObj, String> tableColumnShortName = null;
	protected TableColumn<IBusModelInt16TypeObj, String> tableColumnLabel = null;
	protected TableColumn<IBusModelInt16TypeObj, String> tableColumnShortDescription = null;
	protected TableColumn<IBusModelInt16TypeObj, String> tableColumnDescription = null;
	protected TableColumn<IBusModelInt16TypeObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<IBusModelInt16TypeObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<IBusModelInt16TypeObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<IBusModelInt16TypeObj, Boolean> tableColumnImplementsPolymorph = null;
	protected TableColumn<IBusModelInt16TypeObj, String> tableColumnDbName = null;
	protected TableColumn<IBusModelInt16TypeObj, Short> tableColumnInitValue = null;
	protected TableColumn<IBusModelInt16TypeObj, Short> tableColumnMinValue = null;
	protected TableColumn<IBusModelInt16TypeObj, Short> tableColumnMaxValue = null;
	protected TableColumn<IBusModelInt16TypeObj, IBusModelSchemaDefObj> tableColumnLookupDefSchema = null;

	public final String S_ColumnNames[] = { "Name" };
	protected IYCFFormManager ycfFormManager = null;
	protected boolean javafxIsInitializing = true;
	protected boolean javafxSortByChain = false;
	protected IBusModelSchemaDefObj javafxContainer = null;
	protected IYCFRefreshCallback javafxRefreshCallback = null;
	class ViewEditClosedCallback implements IYCFFormClosedCallback {
		public ViewEditClosedCallback() {
		}

		@Override
		public void formClosed( IYCFLibAnyObj affectedObject ) {
			if( affectedObject != null ) {
				refreshMe();
			}
		}
	}

	protected ViewEditClosedCallback viewEditClosedCallback = null;

	public IYCFFormClosedCallback getViewEditClosedCallback() {
		if( viewEditClosedCallback == null ) {
			viewEditClosedCallback = new ViewEditClosedCallback();
		}
		return( viewEditClosedCallback );
	}

	class DeleteCallback implements IYCFDeleteCallback {
		public DeleteCallback() {
		}
		@Override
		public void deleted( IYCFLibAnyObj deletedObject ) {
			if( deletedObject != null ) {
				refreshMe();
			}
		}

		@Override
		public void formClosed( IYCFLibAnyObj affectedObject ) {
			if( affectedObject != null ) {
				refreshMe();
			}
		}
	}

	protected DeleteCallback deleteCallback = null;

	public IYCFDeleteCallback getDeleteCallback() {
		if( deleteCallback == null ) {
			deleteCallback = new DeleteCallback();
		}
		return( deleteCallback );
	}


	public BusModelJavaFXInt16TypeListPane( IYCFFormManager formManager,
		IBusModelJavaFXSchema argSchema,
		IBusModelSchemaDefObj argContainer,
		IBusModelInt16TypeObj argFocus,
		Collection<IBusModelInt16TypeObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
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
		javaFXFocus = argFocus;
		javafxContainer = argContainer;
		javafxRefreshCallback = refreshCallback;
		javafxSortByChain = sortByChain;
		setJavaFXDataCollection( argDataCollection );
		dataTable = new TableView<IBusModelInt16TypeObj>();
		tableColumnObjKind = new TableColumn<IBusModelInt16TypeObj,String>( "Class Code" );
		tableColumnObjKind.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,String>,ObservableValue<String> >() {
			@Override public ObservableValue<String> call( CellDataFeatures<IBusModelInt16TypeObj, String> p ) {
				IBusModelInt16TypeObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					int classCode = obj.getClassCode();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( Integer.toString(classCode) );
					return( observable );
				}
			}
		});
		tableColumnObjKind.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,String>,TableCell<IBusModelInt16TypeObj,String>>() {
			@Override public TableCell<IBusModelInt16TypeObj,String> call(
				TableColumn<IBusModelInt16TypeObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnObjKind );
		tableColumnId = new TableColumn<IBusModelInt16TypeObj,IYCFKeyHash256>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,IYCFKeyHash256>,ObservableValue<IYCFKeyHash256> >() {
			public ObservableValue<IYCFKeyHash256> call( CellDataFeatures<IBusModelInt16TypeObj, IYCFKeyHash256> p ) {
				IBusModelValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IYCFKeyHash256 value = obj.getRequiredId();
					ReadOnlyObjectWrapper<IYCFKeyHash256> observable = new ReadOnlyObjectWrapper<IYCFKeyHash256>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnId.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,IYCFKeyHash256>,TableCell<IBusModelInt16TypeObj,IYCFKeyHash256>>() {
			@Override public TableCell<IBusModelInt16TypeObj,IYCFKeyHash256> call(
				TableColumn<IBusModelInt16TypeObj,IYCFKeyHash256> arg)
			{
				return new YCFDbKeyHash256TableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<IBusModelInt16TypeObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelInt16TypeObj, String> p ) {
				IBusModelValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnName.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,String>,TableCell<IBusModelInt16TypeObj,String>>() {
			@Override public TableCell<IBusModelInt16TypeObj,String> call(
				TableColumn<IBusModelInt16TypeObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<IBusModelInt16TypeObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelInt16TypeObj, String> p ) {
				IBusModelValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalShortName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnShortName.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,String>,TableCell<IBusModelInt16TypeObj,String>>() {
			@Override public TableCell<IBusModelInt16TypeObj,String> call(
				TableColumn<IBusModelInt16TypeObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<IBusModelInt16TypeObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelInt16TypeObj, String> p ) {
				IBusModelValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalLabel();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnLabel.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,String>,TableCell<IBusModelInt16TypeObj,String>>() {
			@Override public TableCell<IBusModelInt16TypeObj,String> call(
				TableColumn<IBusModelInt16TypeObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<IBusModelInt16TypeObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelInt16TypeObj, String> p ) {
				IBusModelValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalShortDescription();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,String>,TableCell<IBusModelInt16TypeObj,String>>() {
			@Override public TableCell<IBusModelInt16TypeObj,String> call(
				TableColumn<IBusModelInt16TypeObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<IBusModelInt16TypeObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelInt16TypeObj, String> p ) {
				IBusModelValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalDescription();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDescription.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,String>,TableCell<IBusModelInt16TypeObj,String>>() {
			@Override public TableCell<IBusModelInt16TypeObj,String> call(
				TableColumn<IBusModelInt16TypeObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<IBusModelInt16TypeObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelInt16TypeObj, String> p ) {
				IBusModelValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalDefaultXmlValue();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,String>,TableCell<IBusModelInt16TypeObj,String>>() {
			@Override public TableCell<IBusModelInt16TypeObj,String> call(
				TableColumn<IBusModelInt16TypeObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<IBusModelInt16TypeObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelInt16TypeObj, Boolean> p ) {
				IBusModelValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredIsNullable();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,Boolean>,TableCell<IBusModelInt16TypeObj,Boolean>>() {
			@Override public TableCell<IBusModelInt16TypeObj,Boolean> call(
				TableColumn<IBusModelInt16TypeObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<IBusModelInt16TypeObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelInt16TypeObj, Boolean> p ) {
				IBusModelValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Boolean value = obj.getOptionalGenerateId();
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,Boolean>,TableCell<IBusModelInt16TypeObj,Boolean>>() {
			@Override public TableCell<IBusModelInt16TypeObj,Boolean> call(
				TableColumn<IBusModelInt16TypeObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnImplementsPolymorph = new TableColumn<IBusModelInt16TypeObj,Boolean>( "ImplementsPolymorph" );
		tableColumnImplementsPolymorph.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelInt16TypeObj, Boolean> p ) {
				IBusModelValueObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredImplementsPolymorph();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnImplementsPolymorph.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,Boolean>,TableCell<IBusModelInt16TypeObj,Boolean>>() {
			@Override public TableCell<IBusModelInt16TypeObj,Boolean> call(
				TableColumn<IBusModelInt16TypeObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnImplementsPolymorph );
		tableColumnDbName = new TableColumn<IBusModelInt16TypeObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelInt16TypeObj, String> p ) {
				IBusModelAtomObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalDbName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDbName.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,String>,TableCell<IBusModelInt16TypeObj,String>>() {
			@Override public TableCell<IBusModelInt16TypeObj,String> call(
				TableColumn<IBusModelInt16TypeObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnInitValue = new TableColumn<IBusModelInt16TypeObj,Short>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<IBusModelInt16TypeObj, Short> p ) {
				IBusModelInt16DefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Short value = obj.getOptionalInitValue();
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,Short>,TableCell<IBusModelInt16TypeObj,Short>>() {
			@Override public TableCell<IBusModelInt16TypeObj,Short> call(
				TableColumn<IBusModelInt16TypeObj,Short> arg)
			{
				return new YCFInt16TableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnMinValue = new TableColumn<IBusModelInt16TypeObj,Short>( "Min. Value" );
		tableColumnMinValue.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<IBusModelInt16TypeObj, Short> p ) {
				IBusModelInt16DefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Short value = obj.getOptionalMinValue();
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMinValue.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,Short>,TableCell<IBusModelInt16TypeObj,Short>>() {
			@Override public TableCell<IBusModelInt16TypeObj,Short> call(
				TableColumn<IBusModelInt16TypeObj,Short> arg)
			{
				return new YCFInt16TableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMinValue );
		tableColumnMaxValue = new TableColumn<IBusModelInt16TypeObj,Short>( "Max. Value" );
		tableColumnMaxValue.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<IBusModelInt16TypeObj, Short> p ) {
				IBusModelInt16DefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Short value = obj.getOptionalMaxValue();
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMaxValue.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,Short>,TableCell<IBusModelInt16TypeObj,Short>>() {
			@Override public TableCell<IBusModelInt16TypeObj,Short> call(
				TableColumn<IBusModelInt16TypeObj,Short> arg)
			{
				return new YCFInt16TableCell<IBusModelInt16TypeObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMaxValue );
		tableColumnLookupDefSchema = new TableColumn<IBusModelInt16TypeObj, IBusModelSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<IBusModelInt16TypeObj,IBusModelSchemaDefObj>,ObservableValue<IBusModelSchemaDefObj> >() {
			public ObservableValue<IBusModelSchemaDefObj> call( CellDataFeatures<IBusModelInt16TypeObj, IBusModelSchemaDefObj> p ) {
				IBusModelInt16TypeObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IBusModelSchemaDefObj ref = obj.getOptionalLookupDefSchema();
					ReadOnlyObjectWrapper<IBusModelSchemaDefObj> observable = new ReadOnlyObjectWrapper<IBusModelSchemaDefObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<IBusModelInt16TypeObj,IBusModelSchemaDefObj>,TableCell<IBusModelInt16TypeObj,IBusModelSchemaDefObj>>() {
			@Override public TableCell<IBusModelInt16TypeObj,IBusModelSchemaDefObj> call(
				TableColumn<IBusModelInt16TypeObj,IBusModelSchemaDefObj> arg)
			{
				return new YCFReferenceTableCell<IBusModelInt16TypeObj,IBusModelSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<IBusModelInt16TypeObj>() {
				@Override public void changed( ObservableValue<? extends IBusModelInt16TypeObj> observable,
					IBusModelInt16TypeObj oldValue,
					IBusModelInt16TypeObj newValue )
				{
					setJavaFXFocus( newValue );
				}
			});

		scrollMenu = new ScrollPane();
		scrollMenu.setVbarPolicy( ScrollBarPolicy.NEVER );
		scrollMenu.setHbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollMenu.setFitToHeight( true );
		scrollMenu.setContent( getPanelHBoxMenu() );

		setTop( scrollMenu );
		setCenter( dataTable );
		javafxIsInitializing = false;
		if( observableListOfInt16Type != null ) {
			dataTable.setItems( observableListOfInt16Type );
		}
		adjustListButtons();
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

	public void setPaneMode( YCFPane.PaneMode value ) {
		super.setPaneMode( value );
		adjustListButtons();
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof IBusModelInt16TypeObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IBusModelInt16TypeObj" );
		}
		adjustListButtons();
	}

	public IBusModelInt16TypeObj getJavaFXFocusAsInt16Type() {
		return( (IBusModelInt16TypeObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsInt16Type( IBusModelInt16TypeObj value ) {
		setJavaFXFocus( value );
	}

	public class Int16TypeByQualNameComparator
	implements Comparator<IBusModelInt16TypeObj>
	{
		public Int16TypeByQualNameComparator() {
		}

		public int compare( IBusModelInt16TypeObj lhs, IBusModelInt16TypeObj rhs ) {
			if( lhs == null ) {
				if( rhs == null ) {
					return( 0 );
				}
				else {
					return( -1 );
				}
			}
			else if( rhs == null ) {
				return( 1 );
			}
			else {
				String lhsValue = lhs.getObjQualifiedName();
				String rhsValue = rhs.getObjQualifiedName();
				if( lhsValue == null ) {
					if( rhsValue == null ) {
						return( 0 );
					}
					else {
						return( -1 );
					}
				}
				else if( rhsValue == null ) {
					return( 1 );
				}
				else {
					return( lhsValue.compareTo( rhsValue ) );
				}
			}
		}
	}

	protected Int16TypeByQualNameComparator compareInt16TypeByQualName = new Int16TypeByQualNameComparator();

	public Collection<IBusModelInt16TypeObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<IBusModelInt16TypeObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfInt16Type = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<IBusModelInt16TypeObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfInt16Type.add( iter.next() );
				}
				observableListOfInt16Type.sort( compareInt16TypeByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfInt16Type );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	protected class CompareYCFButtonByText
	implements Comparator<YCFButton>
	{
		public CompareYCFButtonByText() {
		}

		@Override public int compare( YCFButton lhs, YCFButton rhs ) {
			if( lhs == null ) {
				if( rhs == null ) {
					return( 0 );
				}
				else {
					return( -1 );
				}
			}
			else if( rhs == null ) {
				return( 1 );
			}
			else {
				int retval = lhs.getText().compareTo( rhs.getText() );
				return( retval );
			}
		}
	}

	public YCFHBox getPanelHBoxMenu() {
		if( hboxMenu == null ) {
			hboxMenu = new YCFHBox( 10 );
				LinkedList<YCFButton> list = new LinkedList<YCFButton>();

				vboxMenuAdd = new YCFVBox( 10 );
					buttonAddInt16Type = new YCFButton();
					buttonAddInt16Type.setMinWidth( 200 );
					buttonAddInt16Type.setText( "Add Int16Type" );
					buttonAddInt16Type.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelInt16TypeObj obj = (IBusModelInt16TypeObj)schemaObj.getInt16TypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getInt16TypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelInt16TypeEditObj edit = (IBusModelInt16TypeEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelSchemaDefObj container = (IBusModelSchemaDefObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerSchemaDef( container );
								IBusModelJavaFXInt16TypePaneCommon jpanelCommon = (IBusModelJavaFXInt16TypePaneCommon)frame;
								jpanelCommon.setJavaFXFocus( obj );
								jpanelCommon.setPaneMode( YCFPane.PaneMode.Add );
								ycfFormManager.pushForm( frame );
								setLeft( null );
								adjustListButtons();
							}
							catch( Throwable t ) {
								YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
							}
						}
					});
					if( javafxContainer instanceof IBusModelSchemaDefObj ) {
						list.add( buttonAddInt16Type );
					}
					buttonAddId16Gen = new YCFButton();
					buttonAddId16Gen.setMinWidth( 200 );
					buttonAddId16Gen.setText( "Add Id16Gen" );
					buttonAddId16Gen.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelId16GenObj obj = (IBusModelId16GenObj)schemaObj.getId16GenTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getId16GenFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelId16GenEditObj edit = (IBusModelId16GenEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelSchemaDefObj container = (IBusModelSchemaDefObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerSchemaDef( container );
								IBusModelJavaFXId16GenPaneCommon jpanelCommon = (IBusModelJavaFXId16GenPaneCommon)frame;
								jpanelCommon.setJavaFXFocus( obj );
								jpanelCommon.setPaneMode( YCFPane.PaneMode.Add );
								ycfFormManager.pushForm( frame );
								setLeft( null );
								adjustListButtons();
							}
							catch( Throwable t ) {
								YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
							}
						}
					});
					if( javafxContainer instanceof IBusModelSchemaDefObj ) {
						list.add( buttonAddId16Gen );
					}

				int len = list.size();
				YCFButton arr[] = new YCFButton[len];
				Iterator<YCFButton> iter = list.iterator();
				int idx = 0;
				while( iter.hasNext() ) {
					arr[idx++] = iter.next();
				}
				Arrays.sort( arr, new CompareYCFButtonByText() );
				for( idx = 0; idx < len; idx ++ ) {
					vboxMenuAdd.getChildren().add( arr[idx] );
				}

				buttonCancelAdd = new YCFButton();
				buttonCancelAdd.setMinWidth( 200 );
				buttonCancelAdd.setText( "Cancel Add..." );
				buttonCancelAdd.setOnAction( new EventHandler<ActionEvent>() {
					@Override public void handle( ActionEvent e ) {
						final String S_ProcName = "handle";
						try {
							setLeft( null );
							adjustListButtons();
						}
						catch( Throwable t ) {
							YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
						}
					}
				});
				vboxMenuAdd.getChildren().add( buttonCancelAdd );

				scrollMenuAdd = new ScrollPane();
				scrollMenuAdd.setMinWidth( 240 );
				scrollMenuAdd.setMaxWidth( 240 );
				scrollMenuAdd.setFitToWidth( true );
				scrollMenuAdd.setHbarPolicy( ScrollBarPolicy.NEVER );
				scrollMenuAdd.setVbarPolicy( ScrollBarPolicy.AS_NEEDED );
				scrollMenuAdd.setContent( vboxMenuAdd );

			buttonAdd = new YCFButton();
			buttonAdd.setMinWidth( 200 );
			buttonAdd.setText( "Add..." );
			buttonAdd.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						setLeft( scrollMenuAdd );
						adjustListButtons();
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAdd );

			buttonViewSelected = new YCFButton();
			buttonViewSelected.setMinWidth( 200 );
			buttonViewSelected.setText( "View Selected" );
			buttonViewSelected.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						IBusModelInt16TypeObj selectedInstance = getJavaFXFocusAsInt16Type();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt16Type.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getInt16TypeFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt16TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId16Gen.CLASS_CODE ) {
								IBusModelId16GenObj obj = (IBusModelId16GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getId16GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXId16GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IBusModelInt16TypeObj, IBusModelId16GenObj" );
							}
						}
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonViewSelected );

			buttonEditSelected = new YCFButton();
			buttonEditSelected.setMinWidth( 200 );
			buttonEditSelected.setText( "Edit Selected" );
			buttonEditSelected.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						IBusModelInt16TypeObj selectedInstance = getJavaFXFocusAsInt16Type();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt16Type.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getInt16TypeFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt16TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId16Gen.CLASS_CODE ) {
								IBusModelId16GenObj obj = (IBusModelId16GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getId16GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXId16GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IBusModelInt16TypeObj, IBusModelId16GenObj" );
							}
						}
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonEditSelected );

			buttonDeleteSelected = new YCFButton();
			buttonDeleteSelected.setMinWidth( 200 );
			buttonDeleteSelected.setText( "Delete Selected" );
			buttonDeleteSelected.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						IBusModelInt16TypeObj selectedInstance = getJavaFXFocusAsInt16Type();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt16Type.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getInt16TypeFactory().newAskDeleteForm( ycfFormManager, selectedInstance, getDeleteCallback() );
								((IBusModelJavaFXInt16TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId16Gen.CLASS_CODE ) {
								IBusModelId16GenObj obj = (IBusModelId16GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getId16GenFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXId16GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IBusModelInt16TypeObj, IBusModelId16GenObj" );
							}
						}
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonDeleteSelected );

		}
		return( hboxMenu );
	}

	public IBusModelSchemaDefObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( IBusModelSchemaDefObj value ) {
		javafxContainer = value;
	}

	public void refreshMe() {
		if( javafxRefreshCallback != null ) {
			javafxRefreshCallback.refreshMe();
		}
	}

	public void adjustListButtons() {
		boolean enableState;
		boolean inEditState;
		boolean allowAdds;
		boolean inAddMode = false;
		IBusModelInt16TypeObj selectedObj = getJavaFXFocusAsInt16Type();
		YCFPane.PaneMode mode = getPaneMode();
		if( mode == YCFPane.PaneMode.Edit ) {
			inEditState = true;
			allowAdds = false;
		}
		else {
			inEditState = false;
			if( getJavaFXContainer() != null ) {
				if( getLeft() != null ) {
					allowAdds = false;
					inAddMode = true;
				}
				else {
					allowAdds = true;
				}
			}
			else {
				allowAdds = false;
			}
		}
		if( selectedObj == null ) {
			enableState = false;
		}
		else {
			if( ( ! inAddMode ) && ( ! inEditState ) ) {
				enableState = true;
			}
			else {
				enableState = false;
			}
		}

		if( buttonViewSelected != null ) {
			buttonViewSelected.setDisable( ! enableState );
		}
		if( buttonEditSelected != null ) {
			if( inEditState ) {
				buttonEditSelected.setDisable( true );
			}
			else {
				buttonEditSelected.setDisable( ! enableState );
			}
		}
		if( buttonDeleteSelected != null ) {
			buttonDeleteSelected.setDisable( ! enableState );
		}
		if( buttonAddInt16Type != null ) {
			buttonAddInt16Type.setDisable( ! allowAdds );
		}

		if( buttonAdd != null ) {
			buttonAdd.setDisable( ! allowAdds );
		}
	}
}
