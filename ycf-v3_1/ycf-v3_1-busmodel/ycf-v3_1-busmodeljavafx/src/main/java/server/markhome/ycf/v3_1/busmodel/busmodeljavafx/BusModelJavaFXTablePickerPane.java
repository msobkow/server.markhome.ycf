// Description: Java 25 JavaFX Picker of Obj Pane implementation for Table.

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
 *	BusModelJavaFXTablePickerPane JavaFX Pick Obj Pane implementation
 *	for Table.
 */
public class BusModelJavaFXTablePickerPane
extends YCFBorderPane
implements IBusModelJavaFXTablePaneList
{
	public static String S_FormName = "Choose Table";
	protected IBusModelJavaFXSchema javafxSchema = null;
	protected Collection<IBusModelTableObj> javafxDataCollection = null;
	protected ObservableList<IBusModelTableObj> observableListOfTable = null;
	protected TableColumn<IBusModelTableObj, IYCFKeyHash256> tableColumnId = null;
	protected TableColumn<IBusModelTableObj, String> tableColumnName = null;
	protected TableColumn<IBusModelTableObj, String> tableColumnDbName = null;
	protected TableColumn<IBusModelTableObj, String> tableColumnShortName = null;
	protected TableColumn<IBusModelTableObj, String> tableColumnLabel = null;
	protected TableColumn<IBusModelTableObj, String> tableColumnShortDescription = null;
	protected TableColumn<IBusModelTableObj, String> tableColumnDescription = null;
	protected TableColumn<IBusModelTableObj, Boolean> tableColumnPageData = null;
	protected TableColumn<IBusModelTableObj, String> tableColumnTableClassCode = null;
	protected TableColumn<IBusModelTableObj, Boolean> tableColumnIsInstantiable = null;
	protected TableColumn<IBusModelTableObj, Boolean> tableColumnHasHistory = null;
	protected TableColumn<IBusModelTableObj, Boolean> tableColumnHasAuditColumns = null;
	protected TableColumn<IBusModelTableObj, Boolean> tableColumnIsMutable = null;
	protected TableColumn<IBusModelTableObj, Boolean> tableColumnIsServerOnly = null;
	protected TableColumn<IBusModelTableObj, IBusModelPubSchema.LoaderBehaviourEnum> tableColumnLoaderBehaviour = null;
	protected TableColumn<IBusModelTableObj, IBusModelPubSchema.SecScopeEnum> tableColumnSecScope = null;
	protected TableColumn<IBusModelTableObj, IBusModelPubSchema.CodeVisibilityEnum> tableColumnCodeVis = null;
	protected TableColumn<IBusModelTableObj, IBusModelSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableColumn<IBusModelTableObj, IBusModelIndexObj> tableColumnLookupLookupIndex = null;
	protected TableColumn<IBusModelTableObj, IBusModelIndexObj> tableColumnLookupAltIndex = null;
	protected TableColumn<IBusModelTableObj, IBusModelTableObj> tableColumnLookupQualTable = null;
	protected TableColumn<IBusModelTableObj, IBusModelIndexObj> tableColumnLookupPrimaryIndex = null;
	protected TableView<IBusModelTableObj> dataTable = null;
	protected YCFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected IYCFFormManager ycfFormManager = null;
	protected IBusModelJavaFXTableChosen invokeWhenChosen = null;
	protected IBusModelSchemaDefObj javafxContainer = null;
	protected YCFButton buttonCancel = null;
	protected YCFButton buttonChooseNone = null;
	protected YCFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public BusModelJavaFXTablePickerPane( IYCFFormManager formManager,
		IBusModelJavaFXSchema argSchema,
		IBusModelTableObj argFocus,
		IBusModelSchemaDefObj argContainer,
		Collection<IBusModelTableObj> argDataCollection,
		IBusModelJavaFXTableChosen whenChosen )
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
		if( whenChosen == null ) {
			throw new YCFLibNullArgumentException( getClass(),
				S_ProcName,
				6,
				"whenChosen" );
		}
		invokeWhenChosen = whenChosen;
		// argFocus is optional; focus may be set later during execution as
		// conditions of the runtime change.
		javafxSchema = argSchema;
		javaFXFocus = argFocus;
		javafxContainer = argContainer;
		setJavaFXDataCollection( argDataCollection );
		dataTable = new TableView<IBusModelTableObj>();
		tableColumnId = new TableColumn<IBusModelTableObj,IYCFKeyHash256>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,IYCFKeyHash256>,ObservableValue<IYCFKeyHash256> >() {
			public ObservableValue<IYCFKeyHash256> call( CellDataFeatures<IBusModelTableObj, IYCFKeyHash256> p ) {
				IBusModelScopeObj obj = p.getValue();
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
		tableColumnId.setCellFactory( new Callback<TableColumn<IBusModelTableObj,IYCFKeyHash256>,TableCell<IBusModelTableObj,IYCFKeyHash256>>() {
			@Override public TableCell<IBusModelTableObj,IYCFKeyHash256> call(
				TableColumn<IBusModelTableObj,IYCFKeyHash256> arg)
			{
				return new YCFDbKeyHash256TableCell<IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<IBusModelTableObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableObj, String> p ) {
				IBusModelTableObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<IBusModelTableObj,String>,TableCell<IBusModelTableObj,String>>() {
			@Override public TableCell<IBusModelTableObj,String> call(
				TableColumn<IBusModelTableObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnDbName = new TableColumn<IBusModelTableObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableObj, String> p ) {
				IBusModelTableObj obj = p.getValue();
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<IBusModelTableObj,String>,TableCell<IBusModelTableObj,String>>() {
			@Override public TableCell<IBusModelTableObj,String> call(
				TableColumn<IBusModelTableObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnShortName = new TableColumn<IBusModelTableObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableObj, String> p ) {
				IBusModelTableObj obj = p.getValue();
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<IBusModelTableObj,String>,TableCell<IBusModelTableObj,String>>() {
			@Override public TableCell<IBusModelTableObj,String> call(
				TableColumn<IBusModelTableObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<IBusModelTableObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableObj, String> p ) {
				IBusModelTableObj obj = p.getValue();
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<IBusModelTableObj,String>,TableCell<IBusModelTableObj,String>>() {
			@Override public TableCell<IBusModelTableObj,String> call(
				TableColumn<IBusModelTableObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<IBusModelTableObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableObj, String> p ) {
				IBusModelTableObj obj = p.getValue();
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<IBusModelTableObj,String>,TableCell<IBusModelTableObj,String>>() {
			@Override public TableCell<IBusModelTableObj,String> call(
				TableColumn<IBusModelTableObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<IBusModelTableObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableObj, String> p ) {
				IBusModelTableObj obj = p.getValue();
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<IBusModelTableObj,String>,TableCell<IBusModelTableObj,String>>() {
			@Override public TableCell<IBusModelTableObj,String> call(
				TableColumn<IBusModelTableObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnPageData = new TableColumn<IBusModelTableObj,Boolean>( "PageData" );
		tableColumnPageData.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelTableObj, Boolean> p ) {
				IBusModelTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredPageData();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnPageData.setCellFactory( new Callback<TableColumn<IBusModelTableObj,Boolean>,TableCell<IBusModelTableObj,Boolean>>() {
			@Override public TableCell<IBusModelTableObj,Boolean> call(
				TableColumn<IBusModelTableObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnPageData );
		tableColumnTableClassCode = new TableColumn<IBusModelTableObj,String>( "Table Class Code" );
		tableColumnTableClassCode.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableObj, String> p ) {
				IBusModelTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredTableClassCode();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnTableClassCode.setCellFactory( new Callback<TableColumn<IBusModelTableObj,String>,TableCell<IBusModelTableObj,String>>() {
			@Override public TableCell<IBusModelTableObj,String> call(
				TableColumn<IBusModelTableObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnTableClassCode );
		tableColumnIsInstantiable = new TableColumn<IBusModelTableObj,Boolean>( "Is Instantiable" );
		tableColumnIsInstantiable.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelTableObj, Boolean> p ) {
				IBusModelTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredIsInstantiable();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnIsInstantiable.setCellFactory( new Callback<TableColumn<IBusModelTableObj,Boolean>,TableCell<IBusModelTableObj,Boolean>>() {
			@Override public TableCell<IBusModelTableObj,Boolean> call(
				TableColumn<IBusModelTableObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsInstantiable );
		tableColumnHasHistory = new TableColumn<IBusModelTableObj,Boolean>( "Has History" );
		tableColumnHasHistory.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelTableObj, Boolean> p ) {
				IBusModelTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredHasHistory();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnHasHistory.setCellFactory( new Callback<TableColumn<IBusModelTableObj,Boolean>,TableCell<IBusModelTableObj,Boolean>>() {
			@Override public TableCell<IBusModelTableObj,Boolean> call(
				TableColumn<IBusModelTableObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHasHistory );
		tableColumnHasAuditColumns = new TableColumn<IBusModelTableObj,Boolean>( "Has Audit Columns" );
		tableColumnHasAuditColumns.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelTableObj, Boolean> p ) {
				IBusModelTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredHasAuditColumns();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnHasAuditColumns.setCellFactory( new Callback<TableColumn<IBusModelTableObj,Boolean>,TableCell<IBusModelTableObj,Boolean>>() {
			@Override public TableCell<IBusModelTableObj,Boolean> call(
				TableColumn<IBusModelTableObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHasAuditColumns );
		tableColumnIsMutable = new TableColumn<IBusModelTableObj,Boolean>( "Is Mutable" );
		tableColumnIsMutable.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelTableObj, Boolean> p ) {
				IBusModelTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredIsMutable();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnIsMutable.setCellFactory( new Callback<TableColumn<IBusModelTableObj,Boolean>,TableCell<IBusModelTableObj,Boolean>>() {
			@Override public TableCell<IBusModelTableObj,Boolean> call(
				TableColumn<IBusModelTableObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsMutable );
		tableColumnIsServerOnly = new TableColumn<IBusModelTableObj,Boolean>( "Is Server Table Only" );
		tableColumnIsServerOnly.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelTableObj, Boolean> p ) {
				IBusModelTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredIsServerOnly();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnIsServerOnly.setCellFactory( new Callback<TableColumn<IBusModelTableObj,Boolean>,TableCell<IBusModelTableObj,Boolean>>() {
			@Override public TableCell<IBusModelTableObj,Boolean> call(
				TableColumn<IBusModelTableObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsServerOnly );
		tableColumnLoaderBehaviour = new TableColumn<IBusModelTableObj,IBusModelPubSchema.LoaderBehaviourEnum>( "Loader Behaviour" );
		tableColumnLoaderBehaviour.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,IBusModelPubSchema.LoaderBehaviourEnum>,ObservableValue<IBusModelPubSchema.LoaderBehaviourEnum> >() {
			public ObservableValue<IBusModelPubSchema.LoaderBehaviourEnum> call( CellDataFeatures<IBusModelTableObj, IBusModelPubSchema.LoaderBehaviourEnum> p ) {
				IBusModelTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IBusModelPubSchema.LoaderBehaviourEnum value = obj.getRequiredLoaderBehaviour();
					ReadOnlyObjectWrapper<IBusModelPubSchema.LoaderBehaviourEnum> observable = new ReadOnlyObjectWrapper<IBusModelPubSchema.LoaderBehaviourEnum>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnLoaderBehaviour.setCellFactory( new Callback<TableColumn<IBusModelTableObj,IBusModelPubSchema.LoaderBehaviourEnum>,TableCell<IBusModelTableObj,IBusModelPubSchema.LoaderBehaviourEnum>>() {
			@Override public TableCell<IBusModelTableObj,IBusModelPubSchema.LoaderBehaviourEnum> call(
				TableColumn<IBusModelTableObj,IBusModelPubSchema.LoaderBehaviourEnum> arg)
			{
				return new YCFEnumTableCell<IBusModelTableObj,IBusModelSchema.LoaderBehaviourEnum>();
			}
		});
		dataTable.getColumns().add( tableColumnLoaderBehaviour );
		tableColumnSecScope = new TableColumn<IBusModelTableObj,IBusModelPubSchema.SecScopeEnum>( "Security Scope" );
		tableColumnSecScope.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,IBusModelPubSchema.SecScopeEnum>,ObservableValue<IBusModelPubSchema.SecScopeEnum> >() {
			public ObservableValue<IBusModelPubSchema.SecScopeEnum> call( CellDataFeatures<IBusModelTableObj, IBusModelPubSchema.SecScopeEnum> p ) {
				IBusModelTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IBusModelPubSchema.SecScopeEnum value = obj.getRequiredSecScope();
					ReadOnlyObjectWrapper<IBusModelPubSchema.SecScopeEnum> observable = new ReadOnlyObjectWrapper<IBusModelPubSchema.SecScopeEnum>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnSecScope.setCellFactory( new Callback<TableColumn<IBusModelTableObj,IBusModelPubSchema.SecScopeEnum>,TableCell<IBusModelTableObj,IBusModelPubSchema.SecScopeEnum>>() {
			@Override public TableCell<IBusModelTableObj,IBusModelPubSchema.SecScopeEnum> call(
				TableColumn<IBusModelTableObj,IBusModelPubSchema.SecScopeEnum> arg)
			{
				return new YCFEnumTableCell<IBusModelTableObj,IBusModelSchema.SecScopeEnum>();
			}
		});
		dataTable.getColumns().add( tableColumnSecScope );
		tableColumnCodeVis = new TableColumn<IBusModelTableObj,IBusModelPubSchema.CodeVisibilityEnum>( "Table Code Visibility" );
		tableColumnCodeVis.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,IBusModelPubSchema.CodeVisibilityEnum>,ObservableValue<IBusModelPubSchema.CodeVisibilityEnum> >() {
			public ObservableValue<IBusModelPubSchema.CodeVisibilityEnum> call( CellDataFeatures<IBusModelTableObj, IBusModelPubSchema.CodeVisibilityEnum> p ) {
				IBusModelTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IBusModelPubSchema.CodeVisibilityEnum value = obj.getRequiredCodeVis();
					ReadOnlyObjectWrapper<IBusModelPubSchema.CodeVisibilityEnum> observable = new ReadOnlyObjectWrapper<IBusModelPubSchema.CodeVisibilityEnum>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCodeVis.setCellFactory( new Callback<TableColumn<IBusModelTableObj,IBusModelPubSchema.CodeVisibilityEnum>,TableCell<IBusModelTableObj,IBusModelPubSchema.CodeVisibilityEnum>>() {
			@Override public TableCell<IBusModelTableObj,IBusModelPubSchema.CodeVisibilityEnum> call(
				TableColumn<IBusModelTableObj,IBusModelPubSchema.CodeVisibilityEnum> arg)
			{
				return new YCFEnumTableCell<IBusModelTableObj,IBusModelSchema.CodeVisibilityEnum>();
			}
		});
		dataTable.getColumns().add( tableColumnCodeVis );
		tableColumnLookupDefSchema = new TableColumn<IBusModelTableObj, IBusModelSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,IBusModelSchemaDefObj>,ObservableValue<IBusModelSchemaDefObj> >() {
			public ObservableValue<IBusModelSchemaDefObj> call( CellDataFeatures<IBusModelTableObj, IBusModelSchemaDefObj> p ) {
				IBusModelTableObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<IBusModelTableObj,IBusModelSchemaDefObj>,TableCell<IBusModelTableObj,IBusModelSchemaDefObj>>() {
			@Override public TableCell<IBusModelTableObj,IBusModelSchemaDefObj> call(
				TableColumn<IBusModelTableObj,IBusModelSchemaDefObj> arg)
			{
				return new YCFReferenceTableCell<IBusModelTableObj,IBusModelSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		tableColumnLookupLookupIndex = new TableColumn<IBusModelTableObj, IBusModelIndexObj>( "Lookup Index" );
		tableColumnLookupLookupIndex.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,IBusModelIndexObj>,ObservableValue<IBusModelIndexObj> >() {
			public ObservableValue<IBusModelIndexObj> call( CellDataFeatures<IBusModelTableObj, IBusModelIndexObj> p ) {
				IBusModelTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IBusModelIndexObj ref = obj.getOptionalLookupLookupIndex();
					ReadOnlyObjectWrapper<IBusModelIndexObj> observable = new ReadOnlyObjectWrapper<IBusModelIndexObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupLookupIndex.setCellFactory( new Callback<TableColumn<IBusModelTableObj,IBusModelIndexObj>,TableCell<IBusModelTableObj,IBusModelIndexObj>>() {
			@Override public TableCell<IBusModelTableObj,IBusModelIndexObj> call(
				TableColumn<IBusModelTableObj,IBusModelIndexObj> arg)
			{
				return new YCFReferenceTableCell<IBusModelTableObj,IBusModelIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupLookupIndex );
		tableColumnLookupAltIndex = new TableColumn<IBusModelTableObj, IBusModelIndexObj>( "Alt Index" );
		tableColumnLookupAltIndex.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,IBusModelIndexObj>,ObservableValue<IBusModelIndexObj> >() {
			public ObservableValue<IBusModelIndexObj> call( CellDataFeatures<IBusModelTableObj, IBusModelIndexObj> p ) {
				IBusModelTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IBusModelIndexObj ref = obj.getOptionalLookupAltIndex();
					ReadOnlyObjectWrapper<IBusModelIndexObj> observable = new ReadOnlyObjectWrapper<IBusModelIndexObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupAltIndex.setCellFactory( new Callback<TableColumn<IBusModelTableObj,IBusModelIndexObj>,TableCell<IBusModelTableObj,IBusModelIndexObj>>() {
			@Override public TableCell<IBusModelTableObj,IBusModelIndexObj> call(
				TableColumn<IBusModelTableObj,IBusModelIndexObj> arg)
			{
				return new YCFReferenceTableCell<IBusModelTableObj,IBusModelIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupAltIndex );
		tableColumnLookupQualTable = new TableColumn<IBusModelTableObj, IBusModelTableObj>( "Qualifying Table" );
		tableColumnLookupQualTable.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,IBusModelTableObj>,ObservableValue<IBusModelTableObj> >() {
			public ObservableValue<IBusModelTableObj> call( CellDataFeatures<IBusModelTableObj, IBusModelTableObj> p ) {
				IBusModelTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IBusModelTableObj ref = obj.getOptionalLookupQualTable();
					ReadOnlyObjectWrapper<IBusModelTableObj> observable = new ReadOnlyObjectWrapper<IBusModelTableObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupQualTable.setCellFactory( new Callback<TableColumn<IBusModelTableObj,IBusModelTableObj>,TableCell<IBusModelTableObj,IBusModelTableObj>>() {
			@Override public TableCell<IBusModelTableObj,IBusModelTableObj> call(
				TableColumn<IBusModelTableObj,IBusModelTableObj> arg)
			{
				return new YCFReferenceTableCell<IBusModelTableObj,IBusModelTableObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupQualTable );
		tableColumnLookupPrimaryIndex = new TableColumn<IBusModelTableObj, IBusModelIndexObj>( "Primary Index" );
		tableColumnLookupPrimaryIndex.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableObj,IBusModelIndexObj>,ObservableValue<IBusModelIndexObj> >() {
			public ObservableValue<IBusModelIndexObj> call( CellDataFeatures<IBusModelTableObj, IBusModelIndexObj> p ) {
				IBusModelTableObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IBusModelIndexObj ref = obj.getOptionalLookupPrimaryIndex();
					ReadOnlyObjectWrapper<IBusModelIndexObj> observable = new ReadOnlyObjectWrapper<IBusModelIndexObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupPrimaryIndex.setCellFactory( new Callback<TableColumn<IBusModelTableObj,IBusModelIndexObj>,TableCell<IBusModelTableObj,IBusModelIndexObj>>() {
			@Override public TableCell<IBusModelTableObj,IBusModelIndexObj> call(
				TableColumn<IBusModelTableObj,IBusModelIndexObj> arg)
			{
				return new YCFReferenceTableCell<IBusModelTableObj,IBusModelIndexObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupPrimaryIndex );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<IBusModelTableObj>() {
				@Override public void changed( ObservableValue<? extends IBusModelTableObj> observable,
					IBusModelTableObj oldValue,
					IBusModelTableObj newValue )
				{
					setJavaFXFocus( newValue );
					if( buttonChooseSelected != null ) {
						if( newValue != null ) {
							buttonChooseSelected.setDisable( false );
						}
						else {
							buttonChooseSelected.setDisable( true );
						}
					}
				}
			});
		hboxMenu = new YCFHBox( 10 );
		buttonCancel = new YCFButton();
		buttonCancel.setMinWidth( 200 );
		buttonCancel.setText( "Cancel" );
		buttonCancel.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				final String S_ProcName = "handle";
				try {
					ycfFormManager.closeCurrentForm();
				}
				catch( Throwable t ) {
					YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
				}
			}
		});
		hboxMenu.getChildren().add( buttonCancel );
		buttonChooseNone = new YCFButton();
		buttonChooseNone.setMinWidth( 200 );
		buttonChooseNone.setText( "ChooseNone" );
		buttonChooseNone.setOnAction( new EventHandler<ActionEvent>() {
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
					invokeWhenChosen.choseTable( null );
					ycfFormManager.closeCurrentForm();
				}
				catch( Throwable t ) {
					YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
				}
			}
		});
		hboxMenu.getChildren().add( buttonChooseNone );
		buttonChooseSelected = new YCFButton();
		buttonChooseSelected.setMinWidth( 200 );
		buttonChooseSelected.setText( "ChooseSelected" );
		buttonChooseSelected.setOnAction( new EventHandler<ActionEvent>() {
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
					IBusModelTableObj selectedInstance = getJavaFXFocusAsTable();
					invokeWhenChosen.choseTable( selectedInstance );
					ycfFormManager.closeCurrentForm();
				}
				catch( Throwable t ) {
					YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
				}
			}
		});
		hboxMenu.getChildren().add( buttonChooseSelected );
		if( argFocus != null ) {
			dataTable.getSelectionModel().select( argFocus );
		}

		scrollMenu = new ScrollPane();
		scrollMenu.setVbarPolicy( ScrollBarPolicy.NEVER );
		scrollMenu.setHbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollMenu.setFitToHeight( true );
		scrollMenu.setContent( hboxMenu );

		setTop( scrollMenu );
		setCenter( dataTable );
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
		if( dataTable == null ) {
			return;
		}
	}

	public IBusModelTableObj getJavaFXFocusAsTable() {
		return( (IBusModelTableObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsTable( IBusModelTableObj value ) {
		setJavaFXFocus( value );
	}

	public class TableByQualNameComparator
	implements Comparator<IBusModelTableObj>
	{
		public TableByQualNameComparator() {
		}

		public int compare( IBusModelTableObj lhs, IBusModelTableObj rhs ) {
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

	protected TableByQualNameComparator compareTableByQualName = new TableByQualNameComparator();

	public Collection<IBusModelTableObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<IBusModelTableObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfTable = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<IBusModelTableObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfTable.add( iter.next() );
				}
				observableListOfTable.sort( compareTableByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfTable );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public IBusModelSchemaDefObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( IBusModelSchemaDefObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		IBusModelTableObj selectedObj = getJavaFXFocusAsTable();
		if( selectedObj == null ) {
			enableState = false;
		}
		else {
			enableState = true;
		}

		if( buttonChooseSelected != null ) {
			buttonChooseSelected.setDisable( ! enableState );
		}
		if( buttonChooseNone != null ) {
			buttonChooseNone.setDisable( false );
		}
		if( buttonCancel != null ) {
			buttonCancel.setDisable( false );
		}

	}
}

