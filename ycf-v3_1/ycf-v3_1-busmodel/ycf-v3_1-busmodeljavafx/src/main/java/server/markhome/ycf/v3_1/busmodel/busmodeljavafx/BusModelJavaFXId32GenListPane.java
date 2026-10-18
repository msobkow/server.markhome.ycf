// Description: Java 25 JavaFX List of Obj Pane implementation for Id32Gen.

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
 *	BusModelJavaFXId32GenListPane JavaFX List of Obj Pane implementation
 *	for Id32Gen.
 */
public class BusModelJavaFXId32GenListPane
extends YCFBorderPane
implements IBusModelJavaFXId32GenPaneList
{
	public static String S_FormName = "List Id32Gen";
	protected IBusModelJavaFXSchema javafxSchema = null;
	protected Collection<IBusModelId32GenObj> javafxDataCollection = null;
	protected ObservableList<IBusModelId32GenObj> observableListOfId32Gen = null;
	protected ScrollPane scrollMenu = null;
	protected YCFHBox hboxMenu = null;
	protected YCFButton buttonAddId32Gen = null;
	protected YCFButton buttonViewSelected = null;
	protected YCFButton buttonEditSelected = null;
	protected YCFButton buttonDeleteSelected = null;
	protected TableView<IBusModelId32GenObj> dataTable = null;
	protected TableColumn<IBusModelId32GenObj, IYCFKeyHash256> tableColumnId = null;
	protected TableColumn<IBusModelId32GenObj, String> tableColumnName = null;
	protected TableColumn<IBusModelId32GenObj, String> tableColumnShortName = null;
	protected TableColumn<IBusModelId32GenObj, String> tableColumnLabel = null;
	protected TableColumn<IBusModelId32GenObj, String> tableColumnShortDescription = null;
	protected TableColumn<IBusModelId32GenObj, String> tableColumnDescription = null;
	protected TableColumn<IBusModelId32GenObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<IBusModelId32GenObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<IBusModelId32GenObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<IBusModelId32GenObj, Boolean> tableColumnImplementsPolymorph = null;
	protected TableColumn<IBusModelId32GenObj, String> tableColumnDbName = null;
	protected TableColumn<IBusModelId32GenObj, Integer> tableColumnInitValue = null;
	protected TableColumn<IBusModelId32GenObj, Integer> tableColumnMinValue = null;
	protected TableColumn<IBusModelId32GenObj, Integer> tableColumnMaxValue = null;
	protected TableColumn<IBusModelId32GenObj, Short> tableColumnSlice = null;
	protected TableColumn<IBusModelId32GenObj, Integer> tableColumnBlockSize = null;
	protected TableColumn<IBusModelId32GenObj, IBusModelSchemaDefObj> tableColumnLookupDefSchema = null;

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


	public BusModelJavaFXId32GenListPane( IYCFFormManager formManager,
		IBusModelJavaFXSchema argSchema,
		IBusModelSchemaDefObj argContainer,
		IBusModelId32GenObj argFocus,
		Collection<IBusModelId32GenObj> argDataCollection,
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
		dataTable = new TableView<IBusModelId32GenObj>();
		tableColumnId = new TableColumn<IBusModelId32GenObj,IYCFKeyHash256>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,IYCFKeyHash256>,ObservableValue<IYCFKeyHash256> >() {
			public ObservableValue<IYCFKeyHash256> call( CellDataFeatures<IBusModelId32GenObj, IYCFKeyHash256> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,IYCFKeyHash256>,TableCell<IBusModelId32GenObj,IYCFKeyHash256>>() {
			@Override public TableCell<IBusModelId32GenObj,IYCFKeyHash256> call(
				TableColumn<IBusModelId32GenObj,IYCFKeyHash256> arg)
			{
				return new YCFDbKeyHash256TableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<IBusModelId32GenObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelId32GenObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,String>,TableCell<IBusModelId32GenObj,String>>() {
			@Override public TableCell<IBusModelId32GenObj,String> call(
				TableColumn<IBusModelId32GenObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<IBusModelId32GenObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelId32GenObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,String>,TableCell<IBusModelId32GenObj,String>>() {
			@Override public TableCell<IBusModelId32GenObj,String> call(
				TableColumn<IBusModelId32GenObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<IBusModelId32GenObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelId32GenObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,String>,TableCell<IBusModelId32GenObj,String>>() {
			@Override public TableCell<IBusModelId32GenObj,String> call(
				TableColumn<IBusModelId32GenObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<IBusModelId32GenObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelId32GenObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,String>,TableCell<IBusModelId32GenObj,String>>() {
			@Override public TableCell<IBusModelId32GenObj,String> call(
				TableColumn<IBusModelId32GenObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<IBusModelId32GenObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelId32GenObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,String>,TableCell<IBusModelId32GenObj,String>>() {
			@Override public TableCell<IBusModelId32GenObj,String> call(
				TableColumn<IBusModelId32GenObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<IBusModelId32GenObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelId32GenObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,String>,TableCell<IBusModelId32GenObj,String>>() {
			@Override public TableCell<IBusModelId32GenObj,String> call(
				TableColumn<IBusModelId32GenObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<IBusModelId32GenObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelId32GenObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,Boolean>,TableCell<IBusModelId32GenObj,Boolean>>() {
			@Override public TableCell<IBusModelId32GenObj,Boolean> call(
				TableColumn<IBusModelId32GenObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<IBusModelId32GenObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelId32GenObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,Boolean>,TableCell<IBusModelId32GenObj,Boolean>>() {
			@Override public TableCell<IBusModelId32GenObj,Boolean> call(
				TableColumn<IBusModelId32GenObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnImplementsPolymorph = new TableColumn<IBusModelId32GenObj,Boolean>( "ImplementsPolymorph" );
		tableColumnImplementsPolymorph.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelId32GenObj, Boolean> p ) {
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
		tableColumnImplementsPolymorph.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,Boolean>,TableCell<IBusModelId32GenObj,Boolean>>() {
			@Override public TableCell<IBusModelId32GenObj,Boolean> call(
				TableColumn<IBusModelId32GenObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnImplementsPolymorph );
		tableColumnDbName = new TableColumn<IBusModelId32GenObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelId32GenObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,String>,TableCell<IBusModelId32GenObj,String>>() {
			@Override public TableCell<IBusModelId32GenObj,String> call(
				TableColumn<IBusModelId32GenObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnInitValue = new TableColumn<IBusModelId32GenObj,Integer>( "Init. Value" );
		tableColumnInitValue.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,Integer>,ObservableValue<Integer> >() {
			public ObservableValue<Integer> call( CellDataFeatures<IBusModelId32GenObj, Integer> p ) {
				IBusModelInt32DefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Integer value = obj.getOptionalInitValue();
					ReadOnlyObjectWrapper<Integer> observable = new ReadOnlyObjectWrapper<Integer>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnInitValue.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,Integer>,TableCell<IBusModelId32GenObj,Integer>>() {
			@Override public TableCell<IBusModelId32GenObj,Integer> call(
				TableColumn<IBusModelId32GenObj,Integer> arg)
			{
				return new YCFInt32TableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnInitValue );
		tableColumnMinValue = new TableColumn<IBusModelId32GenObj,Integer>( "Min. Value" );
		tableColumnMinValue.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,Integer>,ObservableValue<Integer> >() {
			public ObservableValue<Integer> call( CellDataFeatures<IBusModelId32GenObj, Integer> p ) {
				IBusModelInt32DefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Integer value = obj.getOptionalMinValue();
					ReadOnlyObjectWrapper<Integer> observable = new ReadOnlyObjectWrapper<Integer>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMinValue.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,Integer>,TableCell<IBusModelId32GenObj,Integer>>() {
			@Override public TableCell<IBusModelId32GenObj,Integer> call(
				TableColumn<IBusModelId32GenObj,Integer> arg)
			{
				return new YCFInt32TableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMinValue );
		tableColumnMaxValue = new TableColumn<IBusModelId32GenObj,Integer>( "Max. Value" );
		tableColumnMaxValue.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,Integer>,ObservableValue<Integer> >() {
			public ObservableValue<Integer> call( CellDataFeatures<IBusModelId32GenObj, Integer> p ) {
				IBusModelInt32DefObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					Integer value = obj.getOptionalMaxValue();
					ReadOnlyObjectWrapper<Integer> observable = new ReadOnlyObjectWrapper<Integer>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnMaxValue.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,Integer>,TableCell<IBusModelId32GenObj,Integer>>() {
			@Override public TableCell<IBusModelId32GenObj,Integer> call(
				TableColumn<IBusModelId32GenObj,Integer> arg)
			{
				return new YCFInt32TableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnMaxValue );
		tableColumnSlice = new TableColumn<IBusModelId32GenObj,Short>( "Slice" );
		tableColumnSlice.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<IBusModelId32GenObj, Short> p ) {
				IBusModelId32GenObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					short value = obj.getRequiredSlice();
					Short wrapped = Short.valueOf( value );
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnSlice.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,Short>,TableCell<IBusModelId32GenObj,Short>>() {
			@Override public TableCell<IBusModelId32GenObj,Short> call(
				TableColumn<IBusModelId32GenObj,Short> arg)
			{
				return new YCFInt16TableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnSlice );
		tableColumnBlockSize = new TableColumn<IBusModelId32GenObj,Integer>( "BlockSize" );
		tableColumnBlockSize.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,Integer>,ObservableValue<Integer> >() {
			public ObservableValue<Integer> call( CellDataFeatures<IBusModelId32GenObj, Integer> p ) {
				IBusModelId32GenObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					int value = obj.getRequiredBlockSize();
					Integer wrapped = Integer.valueOf( value );
					ReadOnlyObjectWrapper<Integer> observable = new ReadOnlyObjectWrapper<Integer>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnBlockSize.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,Integer>,TableCell<IBusModelId32GenObj,Integer>>() {
			@Override public TableCell<IBusModelId32GenObj,Integer> call(
				TableColumn<IBusModelId32GenObj,Integer> arg)
			{
				return new YCFInt32TableCell<IBusModelId32GenObj>();
			}
		});
		dataTable.getColumns().add( tableColumnBlockSize );
		tableColumnLookupDefSchema = new TableColumn<IBusModelId32GenObj, IBusModelSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<IBusModelId32GenObj,IBusModelSchemaDefObj>,ObservableValue<IBusModelSchemaDefObj> >() {
			public ObservableValue<IBusModelSchemaDefObj> call( CellDataFeatures<IBusModelId32GenObj, IBusModelSchemaDefObj> p ) {
				IBusModelId32GenObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<IBusModelId32GenObj,IBusModelSchemaDefObj>,TableCell<IBusModelId32GenObj,IBusModelSchemaDefObj>>() {
			@Override public TableCell<IBusModelId32GenObj,IBusModelSchemaDefObj> call(
				TableColumn<IBusModelId32GenObj,IBusModelSchemaDefObj> arg)
			{
				return new YCFReferenceTableCell<IBusModelId32GenObj,IBusModelSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<IBusModelId32GenObj>() {
				@Override public void changed( ObservableValue<? extends IBusModelId32GenObj> observable,
					IBusModelId32GenObj oldValue,
					IBusModelId32GenObj newValue )
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
		if( observableListOfId32Gen != null ) {
			dataTable.setItems( observableListOfId32Gen );
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
		if( ( value == null ) || ( value instanceof IBusModelId32GenObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IBusModelId32GenObj" );
		}
		adjustListButtons();
	}

	public IBusModelId32GenObj getJavaFXFocusAsId32Gen() {
		return( (IBusModelId32GenObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsId32Gen( IBusModelId32GenObj value ) {
		setJavaFXFocus( value );
	}

	public class Id32GenByQualNameComparator
	implements Comparator<IBusModelId32GenObj>
	{
		public Id32GenByQualNameComparator() {
		}

		public int compare( IBusModelId32GenObj lhs, IBusModelId32GenObj rhs ) {
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

	protected Id32GenByQualNameComparator compareId32GenByQualName = new Id32GenByQualNameComparator();

	public Collection<IBusModelId32GenObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<IBusModelId32GenObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfId32Gen = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<IBusModelId32GenObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfId32Gen.add( iter.next() );
				}
				observableListOfId32Gen.sort( compareId32GenByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfId32Gen );
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
			buttonAddId32Gen = new YCFButton();
			buttonAddId32Gen.setMinWidth( 200 );
			buttonAddId32Gen.setText( "Add Id32Gen" );
			buttonAddId32Gen.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
						IBusModelId32GenObj obj = (IBusModelId32GenObj)schemaObj.getId32GenTableObj().newInstance();
						IBusModelId32GenEditObj edit = (IBusModelId32GenEditObj)( obj.beginEdit() );
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
						YCFBorderPane frame = javafxSchema.getId32GenFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
						IBusModelJavaFXId32GenPaneCommon jpanelCommon = (IBusModelJavaFXId32GenPaneCommon)frame;
						jpanelCommon.setJavaFXFocus( obj );
						jpanelCommon.setPaneMode( YCFPane.PaneMode.Add );
						ycfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAddId32Gen );
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
						IBusModelId32GenObj selectedInstance = getJavaFXFocusAsId32Gen();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId32Gen.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getId32GenFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((IBusModelJavaFXId32GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IBusModelId32GenObj" );
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
						IBusModelId32GenObj selectedInstance = getJavaFXFocusAsId32Gen();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId32Gen.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getId32GenFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((IBusModelJavaFXId32GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IBusModelId32GenObj" );
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
						IBusModelId32GenObj selectedInstance = getJavaFXFocusAsId32Gen();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId32Gen.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getId32GenFactory().newAskDeleteForm( ycfFormManager, selectedInstance, getDeleteCallback() );
								((IBusModelJavaFXId32GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IBusModelId32GenObj" );
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
		IBusModelId32GenObj selectedObj = getJavaFXFocusAsId32Gen();
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
		if( buttonAddId32Gen != null ) {
			buttonAddId32Gen.setDisable( ! allowAdds );
		}

	}
}
