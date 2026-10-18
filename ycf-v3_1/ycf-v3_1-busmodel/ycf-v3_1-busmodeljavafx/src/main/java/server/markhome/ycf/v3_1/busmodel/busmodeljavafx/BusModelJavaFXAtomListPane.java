// Description: Java 25 JavaFX List of Obj Pane implementation for Atom.

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
 *	BusModelJavaFXAtomListPane JavaFX List of Obj Pane implementation
 *	for Atom.
 */
public class BusModelJavaFXAtomListPane
extends YCFBorderPane
implements IBusModelJavaFXAtomPaneList
{
	public static String S_FormName = "List Atom";
	protected IBusModelJavaFXSchema javafxSchema = null;
	protected Collection<IBusModelAtomObj> javafxDataCollection = null;
	protected ObservableList<IBusModelAtomObj> observableListOfAtom = null;
	protected ScrollPane scrollMenu = null;
	protected YCFHBox hboxMenu = null;
	protected ScrollPane scrollMenuAdd = null;
	protected YCFVBox vboxMenuAdd = null;
	protected YCFButton buttonAdd = null;
	protected YCFButton buttonCancelAdd = null;
	protected YCFButton buttonAddBlobType = null;
	protected YCFButton buttonAddBlobCol = null;
	protected YCFButton buttonAddBoolType = null;
	protected YCFButton buttonAddBoolCol = null;
	protected YCFButton buttonAddDateType = null;
	protected YCFButton buttonAddDateCol = null;
	protected YCFButton buttonAddDoubleType = null;
	protected YCFButton buttonAddDoubleCol = null;
	protected YCFButton buttonAddFloatType = null;
	protected YCFButton buttonAddFloatCol = null;
	protected YCFButton buttonAddInt16Type = null;
	protected YCFButton buttonAddId16Gen = null;
	protected YCFButton buttonAddEnumType = null;
	protected YCFButton buttonAddInt16Col = null;
	protected YCFButton buttonAddInt32Type = null;
	protected YCFButton buttonAddId32Gen = null;
	protected YCFButton buttonAddInt32Col = null;
	protected YCFButton buttonAddInt64Type = null;
	protected YCFButton buttonAddId64Gen = null;
	protected YCFButton buttonAddInt64Col = null;
	protected YCFButton buttonAddNmTokenType = null;
	protected YCFButton buttonAddNmTokenCol = null;
	protected YCFButton buttonAddNmTokensType = null;
	protected YCFButton buttonAddNmTokensCol = null;
	protected YCFButton buttonAddNumberType = null;
	protected YCFButton buttonAddNumberCol = null;
	protected YCFButton buttonAddDbKeyHash128Col = null;
	protected YCFButton buttonAddDbKeyHash128Type = null;
	protected YCFButton buttonAddDbKeyHash128Gen = null;
	protected YCFButton buttonAddDbKeyHash160Col = null;
	protected YCFButton buttonAddDbKeyHash160Type = null;
	protected YCFButton buttonAddDbKeyHash160Gen = null;
	protected YCFButton buttonAddDbKeyHash224Col = null;
	protected YCFButton buttonAddDbKeyHash224Type = null;
	protected YCFButton buttonAddDbKeyHash224Gen = null;
	protected YCFButton buttonAddDbKeyHash256Col = null;
	protected YCFButton buttonAddDbKeyHash256Type = null;
	protected YCFButton buttonAddDbKeyHash256Gen = null;
	protected YCFButton buttonAddDbKeyHash384Col = null;
	protected YCFButton buttonAddDbKeyHash384Type = null;
	protected YCFButton buttonAddDbKeyHash384Gen = null;
	protected YCFButton buttonAddDbKeyHash512Col = null;
	protected YCFButton buttonAddDbKeyHash512Type = null;
	protected YCFButton buttonAddDbKeyHash512Gen = null;
	protected YCFButton buttonAddStringType = null;
	protected YCFButton buttonAddStringCol = null;
	protected YCFButton buttonAddTZDateType = null;
	protected YCFButton buttonAddTZDateCol = null;
	protected YCFButton buttonAddTZTimeType = null;
	protected YCFButton buttonAddTZTimeCol = null;
	protected YCFButton buttonAddTZTimestampType = null;
	protected YCFButton buttonAddTZTimestampCol = null;
	protected YCFButton buttonAddTextType = null;
	protected YCFButton buttonAddTextCol = null;
	protected YCFButton buttonAddTimeType = null;
	protected YCFButton buttonAddTimeCol = null;
	protected YCFButton buttonAddTimestampType = null;
	protected YCFButton buttonAddTimestampCol = null;
	protected YCFButton buttonAddTokenType = null;
	protected YCFButton buttonAddTokenCol = null;
	protected YCFButton buttonAddUInt16Type = null;
	protected YCFButton buttonAddUInt16Col = null;
	protected YCFButton buttonAddUInt32Type = null;
	protected YCFButton buttonAddUInt32Col = null;
	protected YCFButton buttonAddUInt64Type = null;
	protected YCFButton buttonAddUInt64Col = null;
	protected YCFButton buttonAddUuidType = null;
	protected YCFButton buttonAddUuidGen = null;
	protected YCFButton buttonAddUuidCol = null;
	protected YCFButton buttonAddUuid6Type = null;
	protected YCFButton buttonAddUuid6Gen = null;
	protected YCFButton buttonAddUuid6Col = null;
	protected YCFButton buttonViewSelected = null;
	protected YCFButton buttonEditSelected = null;
	protected YCFButton buttonDeleteSelected = null;
	protected TableView<IBusModelAtomObj> dataTable = null;
	protected TableColumn<IBusModelAtomObj,String> tableColumnObjKind = null;
	protected TableColumn<IBusModelAtomObj, IYCFKeyHash256> tableColumnId = null;
	protected TableColumn<IBusModelAtomObj, String> tableColumnName = null;
	protected TableColumn<IBusModelAtomObj, String> tableColumnShortName = null;
	protected TableColumn<IBusModelAtomObj, String> tableColumnLabel = null;
	protected TableColumn<IBusModelAtomObj, String> tableColumnShortDescription = null;
	protected TableColumn<IBusModelAtomObj, String> tableColumnDescription = null;
	protected TableColumn<IBusModelAtomObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<IBusModelAtomObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<IBusModelAtomObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<IBusModelAtomObj, Boolean> tableColumnImplementsPolymorph = null;
	protected TableColumn<IBusModelAtomObj, String> tableColumnDbName = null;
	protected TableColumn<IBusModelAtomObj, IBusModelSchemaDefObj> tableColumnLookupDefSchema = null;

	public final String S_ColumnNames[] = { "Name" };
	protected IYCFFormManager ycfFormManager = null;
	protected boolean javafxIsInitializing = true;
	protected boolean javafxSortByChain = false;
	protected IBusModelScopeObj javafxContainer = null;
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


	public BusModelJavaFXAtomListPane( IYCFFormManager formManager,
		IBusModelJavaFXSchema argSchema,
		IBusModelScopeObj argContainer,
		IBusModelAtomObj argFocus,
		Collection<IBusModelAtomObj> argDataCollection,
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
		dataTable = new TableView<IBusModelAtomObj>();
		tableColumnObjKind = new TableColumn<IBusModelAtomObj,String>( "Class Code" );
		tableColumnObjKind.setCellValueFactory( new Callback<CellDataFeatures<IBusModelAtomObj,String>,ObservableValue<String> >() {
			@Override public ObservableValue<String> call( CellDataFeatures<IBusModelAtomObj, String> p ) {
				IBusModelAtomObj obj = p.getValue();
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
		tableColumnObjKind.setCellFactory( new Callback<TableColumn<IBusModelAtomObj,String>,TableCell<IBusModelAtomObj,String>>() {
			@Override public TableCell<IBusModelAtomObj,String> call(
				TableColumn<IBusModelAtomObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelAtomObj>();
			}
		});
		dataTable.getColumns().add( tableColumnObjKind );
		tableColumnId = new TableColumn<IBusModelAtomObj,IYCFKeyHash256>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<IBusModelAtomObj,IYCFKeyHash256>,ObservableValue<IYCFKeyHash256> >() {
			public ObservableValue<IYCFKeyHash256> call( CellDataFeatures<IBusModelAtomObj, IYCFKeyHash256> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<IBusModelAtomObj,IYCFKeyHash256>,TableCell<IBusModelAtomObj,IYCFKeyHash256>>() {
			@Override public TableCell<IBusModelAtomObj,IYCFKeyHash256> call(
				TableColumn<IBusModelAtomObj,IYCFKeyHash256> arg)
			{
				return new YCFDbKeyHash256TableCell<IBusModelAtomObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<IBusModelAtomObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelAtomObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelAtomObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<IBusModelAtomObj,String>,TableCell<IBusModelAtomObj,String>>() {
			@Override public TableCell<IBusModelAtomObj,String> call(
				TableColumn<IBusModelAtomObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelAtomObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<IBusModelAtomObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelAtomObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelAtomObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<IBusModelAtomObj,String>,TableCell<IBusModelAtomObj,String>>() {
			@Override public TableCell<IBusModelAtomObj,String> call(
				TableColumn<IBusModelAtomObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelAtomObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<IBusModelAtomObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<IBusModelAtomObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelAtomObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<IBusModelAtomObj,String>,TableCell<IBusModelAtomObj,String>>() {
			@Override public TableCell<IBusModelAtomObj,String> call(
				TableColumn<IBusModelAtomObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelAtomObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<IBusModelAtomObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<IBusModelAtomObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelAtomObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<IBusModelAtomObj,String>,TableCell<IBusModelAtomObj,String>>() {
			@Override public TableCell<IBusModelAtomObj,String> call(
				TableColumn<IBusModelAtomObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelAtomObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<IBusModelAtomObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<IBusModelAtomObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelAtomObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<IBusModelAtomObj,String>,TableCell<IBusModelAtomObj,String>>() {
			@Override public TableCell<IBusModelAtomObj,String> call(
				TableColumn<IBusModelAtomObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelAtomObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<IBusModelAtomObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<IBusModelAtomObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelAtomObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<IBusModelAtomObj,String>,TableCell<IBusModelAtomObj,String>>() {
			@Override public TableCell<IBusModelAtomObj,String> call(
				TableColumn<IBusModelAtomObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelAtomObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<IBusModelAtomObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<IBusModelAtomObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelAtomObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<IBusModelAtomObj,Boolean>,TableCell<IBusModelAtomObj,Boolean>>() {
			@Override public TableCell<IBusModelAtomObj,Boolean> call(
				TableColumn<IBusModelAtomObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelAtomObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<IBusModelAtomObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<IBusModelAtomObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelAtomObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<IBusModelAtomObj,Boolean>,TableCell<IBusModelAtomObj,Boolean>>() {
			@Override public TableCell<IBusModelAtomObj,Boolean> call(
				TableColumn<IBusModelAtomObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelAtomObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnImplementsPolymorph = new TableColumn<IBusModelAtomObj,Boolean>( "ImplementsPolymorph" );
		tableColumnImplementsPolymorph.setCellValueFactory( new Callback<CellDataFeatures<IBusModelAtomObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelAtomObj, Boolean> p ) {
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
		tableColumnImplementsPolymorph.setCellFactory( new Callback<TableColumn<IBusModelAtomObj,Boolean>,TableCell<IBusModelAtomObj,Boolean>>() {
			@Override public TableCell<IBusModelAtomObj,Boolean> call(
				TableColumn<IBusModelAtomObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelAtomObj>();
			}
		});
		dataTable.getColumns().add( tableColumnImplementsPolymorph );
		tableColumnDbName = new TableColumn<IBusModelAtomObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelAtomObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelAtomObj, String> p ) {
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<IBusModelAtomObj,String>,TableCell<IBusModelAtomObj,String>>() {
			@Override public TableCell<IBusModelAtomObj,String> call(
				TableColumn<IBusModelAtomObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelAtomObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnLookupDefSchema = new TableColumn<IBusModelAtomObj, IBusModelSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<IBusModelAtomObj,IBusModelSchemaDefObj>,ObservableValue<IBusModelSchemaDefObj> >() {
			public ObservableValue<IBusModelSchemaDefObj> call( CellDataFeatures<IBusModelAtomObj, IBusModelSchemaDefObj> p ) {
				IBusModelAtomObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<IBusModelAtomObj,IBusModelSchemaDefObj>,TableCell<IBusModelAtomObj,IBusModelSchemaDefObj>>() {
			@Override public TableCell<IBusModelAtomObj,IBusModelSchemaDefObj> call(
				TableColumn<IBusModelAtomObj,IBusModelSchemaDefObj> arg)
			{
				return new YCFReferenceTableCell<IBusModelAtomObj,IBusModelSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<IBusModelAtomObj>() {
				@Override public void changed( ObservableValue<? extends IBusModelAtomObj> observable,
					IBusModelAtomObj oldValue,
					IBusModelAtomObj newValue )
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
		if( observableListOfAtom != null ) {
			dataTable.setItems( observableListOfAtom );
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
		if( ( value == null ) || ( value instanceof IBusModelAtomObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IBusModelAtomObj" );
		}
		adjustListButtons();
	}

	public IBusModelAtomObj getJavaFXFocusAsAtom() {
		return( (IBusModelAtomObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsAtom( IBusModelAtomObj value ) {
		setJavaFXFocus( value );
	}

	public class AtomByQualNameComparator
	implements Comparator<IBusModelAtomObj>
	{
		public AtomByQualNameComparator() {
		}

		public int compare( IBusModelAtomObj lhs, IBusModelAtomObj rhs ) {
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

	protected AtomByQualNameComparator compareAtomByQualName = new AtomByQualNameComparator();

	public Collection<IBusModelAtomObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<IBusModelAtomObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfAtom = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<IBusModelAtomObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfAtom.add( iter.next() );
				}
				observableListOfAtom.sort( compareAtomByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfAtom );
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
					buttonAddBlobType = new YCFButton();
					buttonAddBlobType.setMinWidth( 200 );
					buttonAddBlobType.setText( "Add BlobType" );
					buttonAddBlobType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelBlobTypeObj obj = (IBusModelBlobTypeObj)schemaObj.getBlobTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getBlobTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelBlobTypeEditObj edit = (IBusModelBlobTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXBlobTypePaneCommon jpanelCommon = (IBusModelJavaFXBlobTypePaneCommon)frame;
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
						list.add( buttonAddBlobType );
					}
					buttonAddBlobCol = new YCFButton();
					buttonAddBlobCol.setMinWidth( 200 );
					buttonAddBlobCol.setText( "Add BlobCol" );
					buttonAddBlobCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelBlobColObj obj = (IBusModelBlobColObj)schemaObj.getBlobColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getBlobColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelBlobColEditObj edit = (IBusModelBlobColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXBlobColPaneCommon jpanelCommon = (IBusModelJavaFXBlobColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddBlobCol );
					}
					buttonAddBoolType = new YCFButton();
					buttonAddBoolType.setMinWidth( 200 );
					buttonAddBoolType.setText( "Add BoolType" );
					buttonAddBoolType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelBoolTypeObj obj = (IBusModelBoolTypeObj)schemaObj.getBoolTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getBoolTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelBoolTypeEditObj edit = (IBusModelBoolTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXBoolTypePaneCommon jpanelCommon = (IBusModelJavaFXBoolTypePaneCommon)frame;
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
						list.add( buttonAddBoolType );
					}
					buttonAddBoolCol = new YCFButton();
					buttonAddBoolCol.setMinWidth( 200 );
					buttonAddBoolCol.setText( "Add BoolCol" );
					buttonAddBoolCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelBoolColObj obj = (IBusModelBoolColObj)schemaObj.getBoolColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getBoolColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelBoolColEditObj edit = (IBusModelBoolColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXBoolColPaneCommon jpanelCommon = (IBusModelJavaFXBoolColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddBoolCol );
					}
					buttonAddDateType = new YCFButton();
					buttonAddDateType.setMinWidth( 200 );
					buttonAddDateType.setText( "Add DateType" );
					buttonAddDateType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDateTypeObj obj = (IBusModelDateTypeObj)schemaObj.getDateTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDateTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDateTypeEditObj edit = (IBusModelDateTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXDateTypePaneCommon jpanelCommon = (IBusModelJavaFXDateTypePaneCommon)frame;
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
						list.add( buttonAddDateType );
					}
					buttonAddDateCol = new YCFButton();
					buttonAddDateCol.setMinWidth( 200 );
					buttonAddDateCol.setText( "Add DateCol" );
					buttonAddDateCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDateColObj obj = (IBusModelDateColObj)schemaObj.getDateColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDateColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDateColEditObj edit = (IBusModelDateColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXDateColPaneCommon jpanelCommon = (IBusModelJavaFXDateColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddDateCol );
					}
					buttonAddDoubleType = new YCFButton();
					buttonAddDoubleType.setMinWidth( 200 );
					buttonAddDoubleType.setText( "Add DoubleType" );
					buttonAddDoubleType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDoubleTypeObj obj = (IBusModelDoubleTypeObj)schemaObj.getDoubleTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDoubleTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDoubleTypeEditObj edit = (IBusModelDoubleTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXDoubleTypePaneCommon jpanelCommon = (IBusModelJavaFXDoubleTypePaneCommon)frame;
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
						list.add( buttonAddDoubleType );
					}
					buttonAddDoubleCol = new YCFButton();
					buttonAddDoubleCol.setMinWidth( 200 );
					buttonAddDoubleCol.setText( "Add DoubleCol" );
					buttonAddDoubleCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDoubleColObj obj = (IBusModelDoubleColObj)schemaObj.getDoubleColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDoubleColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDoubleColEditObj edit = (IBusModelDoubleColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXDoubleColPaneCommon jpanelCommon = (IBusModelJavaFXDoubleColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddDoubleCol );
					}
					buttonAddFloatType = new YCFButton();
					buttonAddFloatType.setMinWidth( 200 );
					buttonAddFloatType.setText( "Add FloatType" );
					buttonAddFloatType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelFloatTypeObj obj = (IBusModelFloatTypeObj)schemaObj.getFloatTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getFloatTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelFloatTypeEditObj edit = (IBusModelFloatTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXFloatTypePaneCommon jpanelCommon = (IBusModelJavaFXFloatTypePaneCommon)frame;
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
						list.add( buttonAddFloatType );
					}
					buttonAddFloatCol = new YCFButton();
					buttonAddFloatCol.setMinWidth( 200 );
					buttonAddFloatCol.setText( "Add FloatCol" );
					buttonAddFloatCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelFloatColObj obj = (IBusModelFloatColObj)schemaObj.getFloatColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getFloatColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelFloatColEditObj edit = (IBusModelFloatColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXFloatColPaneCommon jpanelCommon = (IBusModelJavaFXFloatColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddFloatCol );
					}
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
					buttonAddEnumType = new YCFButton();
					buttonAddEnumType.setMinWidth( 200 );
					buttonAddEnumType.setText( "Add EnumType" );
					buttonAddEnumType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelEnumTypeObj obj = (IBusModelEnumTypeObj)schemaObj.getEnumTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getEnumTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelEnumTypeEditObj edit = (IBusModelEnumTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXEnumTypePaneCommon jpanelCommon = (IBusModelJavaFXEnumTypePaneCommon)frame;
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
						list.add( buttonAddEnumType );
					}
					buttonAddInt16Col = new YCFButton();
					buttonAddInt16Col.setMinWidth( 200 );
					buttonAddInt16Col.setText( "Add Int16Col" );
					buttonAddInt16Col.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelInt16ColObj obj = (IBusModelInt16ColObj)schemaObj.getInt16ColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getInt16ColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelInt16ColEditObj edit = (IBusModelInt16ColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXInt16ColPaneCommon jpanelCommon = (IBusModelJavaFXInt16ColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddInt16Col );
					}
					buttonAddInt32Type = new YCFButton();
					buttonAddInt32Type.setMinWidth( 200 );
					buttonAddInt32Type.setText( "Add Int32Type" );
					buttonAddInt32Type.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelInt32TypeObj obj = (IBusModelInt32TypeObj)schemaObj.getInt32TypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getInt32TypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelInt32TypeEditObj edit = (IBusModelInt32TypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXInt32TypePaneCommon jpanelCommon = (IBusModelJavaFXInt32TypePaneCommon)frame;
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
						list.add( buttonAddInt32Type );
					}
					buttonAddId32Gen = new YCFButton();
					buttonAddId32Gen.setMinWidth( 200 );
					buttonAddId32Gen.setText( "Add Id32Gen" );
					buttonAddId32Gen.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelId32GenObj obj = (IBusModelId32GenObj)schemaObj.getId32GenTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getId32GenFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
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
								IBusModelJavaFXId32GenPaneCommon jpanelCommon = (IBusModelJavaFXId32GenPaneCommon)frame;
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
						list.add( buttonAddId32Gen );
					}
					buttonAddInt32Col = new YCFButton();
					buttonAddInt32Col.setMinWidth( 200 );
					buttonAddInt32Col.setText( "Add Int32Col" );
					buttonAddInt32Col.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelInt32ColObj obj = (IBusModelInt32ColObj)schemaObj.getInt32ColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getInt32ColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelInt32ColEditObj edit = (IBusModelInt32ColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXInt32ColPaneCommon jpanelCommon = (IBusModelJavaFXInt32ColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddInt32Col );
					}
					buttonAddInt64Type = new YCFButton();
					buttonAddInt64Type.setMinWidth( 200 );
					buttonAddInt64Type.setText( "Add Int64Type" );
					buttonAddInt64Type.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelInt64TypeObj obj = (IBusModelInt64TypeObj)schemaObj.getInt64TypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getInt64TypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelInt64TypeEditObj edit = (IBusModelInt64TypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXInt64TypePaneCommon jpanelCommon = (IBusModelJavaFXInt64TypePaneCommon)frame;
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
						list.add( buttonAddInt64Type );
					}
					buttonAddId64Gen = new YCFButton();
					buttonAddId64Gen.setMinWidth( 200 );
					buttonAddId64Gen.setText( "Add Id64Gen" );
					buttonAddId64Gen.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelId64GenObj obj = (IBusModelId64GenObj)schemaObj.getId64GenTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getId64GenFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelId64GenEditObj edit = (IBusModelId64GenEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXId64GenPaneCommon jpanelCommon = (IBusModelJavaFXId64GenPaneCommon)frame;
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
						list.add( buttonAddId64Gen );
					}
					buttonAddInt64Col = new YCFButton();
					buttonAddInt64Col.setMinWidth( 200 );
					buttonAddInt64Col.setText( "Add Int64Col" );
					buttonAddInt64Col.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelInt64ColObj obj = (IBusModelInt64ColObj)schemaObj.getInt64ColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getInt64ColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelInt64ColEditObj edit = (IBusModelInt64ColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXInt64ColPaneCommon jpanelCommon = (IBusModelJavaFXInt64ColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddInt64Col );
					}
					buttonAddNmTokenType = new YCFButton();
					buttonAddNmTokenType.setMinWidth( 200 );
					buttonAddNmTokenType.setText( "Add NmTokenType" );
					buttonAddNmTokenType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelNmTokenTypeObj obj = (IBusModelNmTokenTypeObj)schemaObj.getNmTokenTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getNmTokenTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelNmTokenTypeEditObj edit = (IBusModelNmTokenTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXNmTokenTypePaneCommon jpanelCommon = (IBusModelJavaFXNmTokenTypePaneCommon)frame;
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
						list.add( buttonAddNmTokenType );
					}
					buttonAddNmTokenCol = new YCFButton();
					buttonAddNmTokenCol.setMinWidth( 200 );
					buttonAddNmTokenCol.setText( "Add NmTokenCol" );
					buttonAddNmTokenCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelNmTokenColObj obj = (IBusModelNmTokenColObj)schemaObj.getNmTokenColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getNmTokenColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelNmTokenColEditObj edit = (IBusModelNmTokenColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXNmTokenColPaneCommon jpanelCommon = (IBusModelJavaFXNmTokenColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddNmTokenCol );
					}
					buttonAddNmTokensType = new YCFButton();
					buttonAddNmTokensType.setMinWidth( 200 );
					buttonAddNmTokensType.setText( "Add NmTokensType" );
					buttonAddNmTokensType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelNmTokensTypeObj obj = (IBusModelNmTokensTypeObj)schemaObj.getNmTokensTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getNmTokensTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelNmTokensTypeEditObj edit = (IBusModelNmTokensTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXNmTokensTypePaneCommon jpanelCommon = (IBusModelJavaFXNmTokensTypePaneCommon)frame;
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
						list.add( buttonAddNmTokensType );
					}
					buttonAddNmTokensCol = new YCFButton();
					buttonAddNmTokensCol.setMinWidth( 200 );
					buttonAddNmTokensCol.setText( "Add NmTokensCol" );
					buttonAddNmTokensCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelNmTokensColObj obj = (IBusModelNmTokensColObj)schemaObj.getNmTokensColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getNmTokensColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelNmTokensColEditObj edit = (IBusModelNmTokensColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXNmTokensColPaneCommon jpanelCommon = (IBusModelJavaFXNmTokensColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddNmTokensCol );
					}
					buttonAddNumberType = new YCFButton();
					buttonAddNumberType.setMinWidth( 200 );
					buttonAddNumberType.setText( "Add NumberType" );
					buttonAddNumberType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelNumberTypeObj obj = (IBusModelNumberTypeObj)schemaObj.getNumberTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getNumberTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelNumberTypeEditObj edit = (IBusModelNumberTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXNumberTypePaneCommon jpanelCommon = (IBusModelJavaFXNumberTypePaneCommon)frame;
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
						list.add( buttonAddNumberType );
					}
					buttonAddNumberCol = new YCFButton();
					buttonAddNumberCol.setMinWidth( 200 );
					buttonAddNumberCol.setText( "Add NumberCol" );
					buttonAddNumberCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelNumberColObj obj = (IBusModelNumberColObj)schemaObj.getNumberColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getNumberColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelNumberColEditObj edit = (IBusModelNumberColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXNumberColPaneCommon jpanelCommon = (IBusModelJavaFXNumberColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddNumberCol );
					}
					buttonAddDbKeyHash128Col = new YCFButton();
					buttonAddDbKeyHash128Col.setMinWidth( 200 );
					buttonAddDbKeyHash128Col.setText( "Add DbKeyHash128Col" );
					buttonAddDbKeyHash128Col.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash128ColObj obj = (IBusModelDbKeyHash128ColObj)schemaObj.getDbKeyHash128ColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash128ColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash128ColEditObj edit = (IBusModelDbKeyHash128ColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXDbKeyHash128ColPaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash128ColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddDbKeyHash128Col );
					}
					buttonAddDbKeyHash128Type = new YCFButton();
					buttonAddDbKeyHash128Type.setMinWidth( 200 );
					buttonAddDbKeyHash128Type.setText( "Add DbKeyHash128Type" );
					buttonAddDbKeyHash128Type.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash128TypeObj obj = (IBusModelDbKeyHash128TypeObj)schemaObj.getDbKeyHash128TypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash128TypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash128TypeEditObj edit = (IBusModelDbKeyHash128TypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXDbKeyHash128TypePaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash128TypePaneCommon)frame;
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
						list.add( buttonAddDbKeyHash128Type );
					}
					buttonAddDbKeyHash128Gen = new YCFButton();
					buttonAddDbKeyHash128Gen.setMinWidth( 200 );
					buttonAddDbKeyHash128Gen.setText( "Add DbKeyHash128Gen" );
					buttonAddDbKeyHash128Gen.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash128GenObj obj = (IBusModelDbKeyHash128GenObj)schemaObj.getDbKeyHash128GenTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash128GenFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash128GenEditObj edit = (IBusModelDbKeyHash128GenEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXDbKeyHash128GenPaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash128GenPaneCommon)frame;
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
						list.add( buttonAddDbKeyHash128Gen );
					}
					buttonAddDbKeyHash160Col = new YCFButton();
					buttonAddDbKeyHash160Col.setMinWidth( 200 );
					buttonAddDbKeyHash160Col.setText( "Add DbKeyHash160Col" );
					buttonAddDbKeyHash160Col.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash160ColObj obj = (IBusModelDbKeyHash160ColObj)schemaObj.getDbKeyHash160ColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash160ColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash160ColEditObj edit = (IBusModelDbKeyHash160ColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXDbKeyHash160ColPaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash160ColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddDbKeyHash160Col );
					}
					buttonAddDbKeyHash160Type = new YCFButton();
					buttonAddDbKeyHash160Type.setMinWidth( 200 );
					buttonAddDbKeyHash160Type.setText( "Add DbKeyHash160Type" );
					buttonAddDbKeyHash160Type.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash160TypeObj obj = (IBusModelDbKeyHash160TypeObj)schemaObj.getDbKeyHash160TypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash160TypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash160TypeEditObj edit = (IBusModelDbKeyHash160TypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXDbKeyHash160TypePaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash160TypePaneCommon)frame;
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
						list.add( buttonAddDbKeyHash160Type );
					}
					buttonAddDbKeyHash160Gen = new YCFButton();
					buttonAddDbKeyHash160Gen.setMinWidth( 200 );
					buttonAddDbKeyHash160Gen.setText( "Add DbKeyHash160Gen" );
					buttonAddDbKeyHash160Gen.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash160GenObj obj = (IBusModelDbKeyHash160GenObj)schemaObj.getDbKeyHash160GenTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash160GenFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash160GenEditObj edit = (IBusModelDbKeyHash160GenEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXDbKeyHash160GenPaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash160GenPaneCommon)frame;
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
						list.add( buttonAddDbKeyHash160Gen );
					}
					buttonAddDbKeyHash224Col = new YCFButton();
					buttonAddDbKeyHash224Col.setMinWidth( 200 );
					buttonAddDbKeyHash224Col.setText( "Add DbKeyHash224Col" );
					buttonAddDbKeyHash224Col.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash224ColObj obj = (IBusModelDbKeyHash224ColObj)schemaObj.getDbKeyHash224ColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash224ColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash224ColEditObj edit = (IBusModelDbKeyHash224ColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXDbKeyHash224ColPaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash224ColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddDbKeyHash224Col );
					}
					buttonAddDbKeyHash224Type = new YCFButton();
					buttonAddDbKeyHash224Type.setMinWidth( 200 );
					buttonAddDbKeyHash224Type.setText( "Add DbKeyHash224Type" );
					buttonAddDbKeyHash224Type.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash224TypeObj obj = (IBusModelDbKeyHash224TypeObj)schemaObj.getDbKeyHash224TypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash224TypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash224TypeEditObj edit = (IBusModelDbKeyHash224TypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXDbKeyHash224TypePaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash224TypePaneCommon)frame;
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
						list.add( buttonAddDbKeyHash224Type );
					}
					buttonAddDbKeyHash224Gen = new YCFButton();
					buttonAddDbKeyHash224Gen.setMinWidth( 200 );
					buttonAddDbKeyHash224Gen.setText( "Add DbKeyHash224Gen" );
					buttonAddDbKeyHash224Gen.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash224GenObj obj = (IBusModelDbKeyHash224GenObj)schemaObj.getDbKeyHash224GenTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash224GenFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash224GenEditObj edit = (IBusModelDbKeyHash224GenEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXDbKeyHash224GenPaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash224GenPaneCommon)frame;
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
						list.add( buttonAddDbKeyHash224Gen );
					}
					buttonAddDbKeyHash256Col = new YCFButton();
					buttonAddDbKeyHash256Col.setMinWidth( 200 );
					buttonAddDbKeyHash256Col.setText( "Add DbKeyHash256Col" );
					buttonAddDbKeyHash256Col.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash256ColObj obj = (IBusModelDbKeyHash256ColObj)schemaObj.getDbKeyHash256ColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash256ColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash256ColEditObj edit = (IBusModelDbKeyHash256ColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXDbKeyHash256ColPaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash256ColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddDbKeyHash256Col );
					}
					buttonAddDbKeyHash256Type = new YCFButton();
					buttonAddDbKeyHash256Type.setMinWidth( 200 );
					buttonAddDbKeyHash256Type.setText( "Add DbKeyHash256Type" );
					buttonAddDbKeyHash256Type.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash256TypeObj obj = (IBusModelDbKeyHash256TypeObj)schemaObj.getDbKeyHash256TypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash256TypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash256TypeEditObj edit = (IBusModelDbKeyHash256TypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXDbKeyHash256TypePaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash256TypePaneCommon)frame;
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
						list.add( buttonAddDbKeyHash256Type );
					}
					buttonAddDbKeyHash256Gen = new YCFButton();
					buttonAddDbKeyHash256Gen.setMinWidth( 200 );
					buttonAddDbKeyHash256Gen.setText( "Add DbKeyHash256Gen" );
					buttonAddDbKeyHash256Gen.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash256GenObj obj = (IBusModelDbKeyHash256GenObj)schemaObj.getDbKeyHash256GenTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash256GenFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash256GenEditObj edit = (IBusModelDbKeyHash256GenEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXDbKeyHash256GenPaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash256GenPaneCommon)frame;
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
						list.add( buttonAddDbKeyHash256Gen );
					}
					buttonAddDbKeyHash384Col = new YCFButton();
					buttonAddDbKeyHash384Col.setMinWidth( 200 );
					buttonAddDbKeyHash384Col.setText( "Add DbKeyHash384Col" );
					buttonAddDbKeyHash384Col.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash384ColObj obj = (IBusModelDbKeyHash384ColObj)schemaObj.getDbKeyHash384ColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash384ColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash384ColEditObj edit = (IBusModelDbKeyHash384ColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXDbKeyHash384ColPaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash384ColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddDbKeyHash384Col );
					}
					buttonAddDbKeyHash384Type = new YCFButton();
					buttonAddDbKeyHash384Type.setMinWidth( 200 );
					buttonAddDbKeyHash384Type.setText( "Add DbKeyHash384Type" );
					buttonAddDbKeyHash384Type.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash384TypeObj obj = (IBusModelDbKeyHash384TypeObj)schemaObj.getDbKeyHash384TypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash384TypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash384TypeEditObj edit = (IBusModelDbKeyHash384TypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXDbKeyHash384TypePaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash384TypePaneCommon)frame;
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
						list.add( buttonAddDbKeyHash384Type );
					}
					buttonAddDbKeyHash384Gen = new YCFButton();
					buttonAddDbKeyHash384Gen.setMinWidth( 200 );
					buttonAddDbKeyHash384Gen.setText( "Add DbKeyHash384Gen" );
					buttonAddDbKeyHash384Gen.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash384GenObj obj = (IBusModelDbKeyHash384GenObj)schemaObj.getDbKeyHash384GenTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash384GenFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash384GenEditObj edit = (IBusModelDbKeyHash384GenEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXDbKeyHash384GenPaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash384GenPaneCommon)frame;
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
						list.add( buttonAddDbKeyHash384Gen );
					}
					buttonAddDbKeyHash512Col = new YCFButton();
					buttonAddDbKeyHash512Col.setMinWidth( 200 );
					buttonAddDbKeyHash512Col.setText( "Add DbKeyHash512Col" );
					buttonAddDbKeyHash512Col.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash512ColObj obj = (IBusModelDbKeyHash512ColObj)schemaObj.getDbKeyHash512ColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash512ColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash512ColEditObj edit = (IBusModelDbKeyHash512ColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXDbKeyHash512ColPaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash512ColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddDbKeyHash512Col );
					}
					buttonAddDbKeyHash512Type = new YCFButton();
					buttonAddDbKeyHash512Type.setMinWidth( 200 );
					buttonAddDbKeyHash512Type.setText( "Add DbKeyHash512Type" );
					buttonAddDbKeyHash512Type.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash512TypeObj obj = (IBusModelDbKeyHash512TypeObj)schemaObj.getDbKeyHash512TypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash512TypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash512TypeEditObj edit = (IBusModelDbKeyHash512TypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXDbKeyHash512TypePaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash512TypePaneCommon)frame;
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
						list.add( buttonAddDbKeyHash512Type );
					}
					buttonAddDbKeyHash512Gen = new YCFButton();
					buttonAddDbKeyHash512Gen.setMinWidth( 200 );
					buttonAddDbKeyHash512Gen.setText( "Add DbKeyHash512Gen" );
					buttonAddDbKeyHash512Gen.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelDbKeyHash512GenObj obj = (IBusModelDbKeyHash512GenObj)schemaObj.getDbKeyHash512GenTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getDbKeyHash512GenFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelDbKeyHash512GenEditObj edit = (IBusModelDbKeyHash512GenEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXDbKeyHash512GenPaneCommon jpanelCommon = (IBusModelJavaFXDbKeyHash512GenPaneCommon)frame;
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
						list.add( buttonAddDbKeyHash512Gen );
					}
					buttonAddStringType = new YCFButton();
					buttonAddStringType.setMinWidth( 200 );
					buttonAddStringType.setText( "Add StringType" );
					buttonAddStringType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelStringTypeObj obj = (IBusModelStringTypeObj)schemaObj.getStringTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getStringTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelStringTypeEditObj edit = (IBusModelStringTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXStringTypePaneCommon jpanelCommon = (IBusModelJavaFXStringTypePaneCommon)frame;
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
						list.add( buttonAddStringType );
					}
					buttonAddStringCol = new YCFButton();
					buttonAddStringCol.setMinWidth( 200 );
					buttonAddStringCol.setText( "Add StringCol" );
					buttonAddStringCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelStringColObj obj = (IBusModelStringColObj)schemaObj.getStringColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getStringColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelStringColEditObj edit = (IBusModelStringColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXStringColPaneCommon jpanelCommon = (IBusModelJavaFXStringColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddStringCol );
					}
					buttonAddTZDateType = new YCFButton();
					buttonAddTZDateType.setMinWidth( 200 );
					buttonAddTZDateType.setText( "Add TZDateType" );
					buttonAddTZDateType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelTZDateTypeObj obj = (IBusModelTZDateTypeObj)schemaObj.getTZDateTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getTZDateTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelTZDateTypeEditObj edit = (IBusModelTZDateTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXTZDateTypePaneCommon jpanelCommon = (IBusModelJavaFXTZDateTypePaneCommon)frame;
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
						list.add( buttonAddTZDateType );
					}
					buttonAddTZDateCol = new YCFButton();
					buttonAddTZDateCol.setMinWidth( 200 );
					buttonAddTZDateCol.setText( "Add TZDateCol" );
					buttonAddTZDateCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelTZDateColObj obj = (IBusModelTZDateColObj)schemaObj.getTZDateColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getTZDateColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelTZDateColEditObj edit = (IBusModelTZDateColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXTZDateColPaneCommon jpanelCommon = (IBusModelJavaFXTZDateColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddTZDateCol );
					}
					buttonAddTZTimeType = new YCFButton();
					buttonAddTZTimeType.setMinWidth( 200 );
					buttonAddTZTimeType.setText( "Add TZTimeType" );
					buttonAddTZTimeType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelTZTimeTypeObj obj = (IBusModelTZTimeTypeObj)schemaObj.getTZTimeTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getTZTimeTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelTZTimeTypeEditObj edit = (IBusModelTZTimeTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXTZTimeTypePaneCommon jpanelCommon = (IBusModelJavaFXTZTimeTypePaneCommon)frame;
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
						list.add( buttonAddTZTimeType );
					}
					buttonAddTZTimeCol = new YCFButton();
					buttonAddTZTimeCol.setMinWidth( 200 );
					buttonAddTZTimeCol.setText( "Add TZTimeCol" );
					buttonAddTZTimeCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelTZTimeColObj obj = (IBusModelTZTimeColObj)schemaObj.getTZTimeColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getTZTimeColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelTZTimeColEditObj edit = (IBusModelTZTimeColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXTZTimeColPaneCommon jpanelCommon = (IBusModelJavaFXTZTimeColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddTZTimeCol );
					}
					buttonAddTZTimestampType = new YCFButton();
					buttonAddTZTimestampType.setMinWidth( 200 );
					buttonAddTZTimestampType.setText( "Add TZTimestampType" );
					buttonAddTZTimestampType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelTZTimestampTypeObj obj = (IBusModelTZTimestampTypeObj)schemaObj.getTZTimestampTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getTZTimestampTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelTZTimestampTypeEditObj edit = (IBusModelTZTimestampTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXTZTimestampTypePaneCommon jpanelCommon = (IBusModelJavaFXTZTimestampTypePaneCommon)frame;
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
						list.add( buttonAddTZTimestampType );
					}
					buttonAddTZTimestampCol = new YCFButton();
					buttonAddTZTimestampCol.setMinWidth( 200 );
					buttonAddTZTimestampCol.setText( "Add TZTimestampCol" );
					buttonAddTZTimestampCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelTZTimestampColObj obj = (IBusModelTZTimestampColObj)schemaObj.getTZTimestampColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getTZTimestampColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelTZTimestampColEditObj edit = (IBusModelTZTimestampColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXTZTimestampColPaneCommon jpanelCommon = (IBusModelJavaFXTZTimestampColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddTZTimestampCol );
					}
					buttonAddTextType = new YCFButton();
					buttonAddTextType.setMinWidth( 200 );
					buttonAddTextType.setText( "Add TextType" );
					buttonAddTextType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelTextTypeObj obj = (IBusModelTextTypeObj)schemaObj.getTextTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getTextTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelTextTypeEditObj edit = (IBusModelTextTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXTextTypePaneCommon jpanelCommon = (IBusModelJavaFXTextTypePaneCommon)frame;
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
						list.add( buttonAddTextType );
					}
					buttonAddTextCol = new YCFButton();
					buttonAddTextCol.setMinWidth( 200 );
					buttonAddTextCol.setText( "Add TextCol" );
					buttonAddTextCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelTextColObj obj = (IBusModelTextColObj)schemaObj.getTextColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getTextColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelTextColEditObj edit = (IBusModelTextColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXTextColPaneCommon jpanelCommon = (IBusModelJavaFXTextColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddTextCol );
					}
					buttonAddTimeType = new YCFButton();
					buttonAddTimeType.setMinWidth( 200 );
					buttonAddTimeType.setText( "Add TimeType" );
					buttonAddTimeType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelTimeTypeObj obj = (IBusModelTimeTypeObj)schemaObj.getTimeTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getTimeTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelTimeTypeEditObj edit = (IBusModelTimeTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXTimeTypePaneCommon jpanelCommon = (IBusModelJavaFXTimeTypePaneCommon)frame;
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
						list.add( buttonAddTimeType );
					}
					buttonAddTimeCol = new YCFButton();
					buttonAddTimeCol.setMinWidth( 200 );
					buttonAddTimeCol.setText( "Add TimeCol" );
					buttonAddTimeCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelTimeColObj obj = (IBusModelTimeColObj)schemaObj.getTimeColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getTimeColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelTimeColEditObj edit = (IBusModelTimeColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXTimeColPaneCommon jpanelCommon = (IBusModelJavaFXTimeColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddTimeCol );
					}
					buttonAddTimestampType = new YCFButton();
					buttonAddTimestampType.setMinWidth( 200 );
					buttonAddTimestampType.setText( "Add TimestampType" );
					buttonAddTimestampType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelTimestampTypeObj obj = (IBusModelTimestampTypeObj)schemaObj.getTimestampTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getTimestampTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelTimestampTypeEditObj edit = (IBusModelTimestampTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXTimestampTypePaneCommon jpanelCommon = (IBusModelJavaFXTimestampTypePaneCommon)frame;
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
						list.add( buttonAddTimestampType );
					}
					buttonAddTimestampCol = new YCFButton();
					buttonAddTimestampCol.setMinWidth( 200 );
					buttonAddTimestampCol.setText( "Add TimestampCol" );
					buttonAddTimestampCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelTimestampColObj obj = (IBusModelTimestampColObj)schemaObj.getTimestampColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getTimestampColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelTimestampColEditObj edit = (IBusModelTimestampColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXTimestampColPaneCommon jpanelCommon = (IBusModelJavaFXTimestampColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddTimestampCol );
					}
					buttonAddTokenType = new YCFButton();
					buttonAddTokenType.setMinWidth( 200 );
					buttonAddTokenType.setText( "Add TokenType" );
					buttonAddTokenType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelTokenTypeObj obj = (IBusModelTokenTypeObj)schemaObj.getTokenTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getTokenTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelTokenTypeEditObj edit = (IBusModelTokenTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXTokenTypePaneCommon jpanelCommon = (IBusModelJavaFXTokenTypePaneCommon)frame;
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
						list.add( buttonAddTokenType );
					}
					buttonAddTokenCol = new YCFButton();
					buttonAddTokenCol.setMinWidth( 200 );
					buttonAddTokenCol.setText( "Add TokenCol" );
					buttonAddTokenCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelTokenColObj obj = (IBusModelTokenColObj)schemaObj.getTokenColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getTokenColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelTokenColEditObj edit = (IBusModelTokenColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXTokenColPaneCommon jpanelCommon = (IBusModelJavaFXTokenColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddTokenCol );
					}
					buttonAddUInt16Type = new YCFButton();
					buttonAddUInt16Type.setMinWidth( 200 );
					buttonAddUInt16Type.setText( "Add UInt16Type" );
					buttonAddUInt16Type.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelUInt16TypeObj obj = (IBusModelUInt16TypeObj)schemaObj.getUInt16TypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getUInt16TypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelUInt16TypeEditObj edit = (IBusModelUInt16TypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXUInt16TypePaneCommon jpanelCommon = (IBusModelJavaFXUInt16TypePaneCommon)frame;
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
						list.add( buttonAddUInt16Type );
					}
					buttonAddUInt16Col = new YCFButton();
					buttonAddUInt16Col.setMinWidth( 200 );
					buttonAddUInt16Col.setText( "Add UInt16Col" );
					buttonAddUInt16Col.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelUInt16ColObj obj = (IBusModelUInt16ColObj)schemaObj.getUInt16ColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getUInt16ColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelUInt16ColEditObj edit = (IBusModelUInt16ColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXUInt16ColPaneCommon jpanelCommon = (IBusModelJavaFXUInt16ColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddUInt16Col );
					}
					buttonAddUInt32Type = new YCFButton();
					buttonAddUInt32Type.setMinWidth( 200 );
					buttonAddUInt32Type.setText( "Add UInt32Type" );
					buttonAddUInt32Type.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelUInt32TypeObj obj = (IBusModelUInt32TypeObj)schemaObj.getUInt32TypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getUInt32TypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelUInt32TypeEditObj edit = (IBusModelUInt32TypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXUInt32TypePaneCommon jpanelCommon = (IBusModelJavaFXUInt32TypePaneCommon)frame;
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
						list.add( buttonAddUInt32Type );
					}
					buttonAddUInt32Col = new YCFButton();
					buttonAddUInt32Col.setMinWidth( 200 );
					buttonAddUInt32Col.setText( "Add UInt32Col" );
					buttonAddUInt32Col.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelUInt32ColObj obj = (IBusModelUInt32ColObj)schemaObj.getUInt32ColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getUInt32ColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelUInt32ColEditObj edit = (IBusModelUInt32ColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXUInt32ColPaneCommon jpanelCommon = (IBusModelJavaFXUInt32ColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddUInt32Col );
					}
					buttonAddUInt64Type = new YCFButton();
					buttonAddUInt64Type.setMinWidth( 200 );
					buttonAddUInt64Type.setText( "Add UInt64Type" );
					buttonAddUInt64Type.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelUInt64TypeObj obj = (IBusModelUInt64TypeObj)schemaObj.getUInt64TypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getUInt64TypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelUInt64TypeEditObj edit = (IBusModelUInt64TypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXUInt64TypePaneCommon jpanelCommon = (IBusModelJavaFXUInt64TypePaneCommon)frame;
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
						list.add( buttonAddUInt64Type );
					}
					buttonAddUInt64Col = new YCFButton();
					buttonAddUInt64Col.setMinWidth( 200 );
					buttonAddUInt64Col.setText( "Add UInt64Col" );
					buttonAddUInt64Col.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelUInt64ColObj obj = (IBusModelUInt64ColObj)schemaObj.getUInt64ColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getUInt64ColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelUInt64ColEditObj edit = (IBusModelUInt64ColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXUInt64ColPaneCommon jpanelCommon = (IBusModelJavaFXUInt64ColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddUInt64Col );
					}
					buttonAddUuidType = new YCFButton();
					buttonAddUuidType.setMinWidth( 200 );
					buttonAddUuidType.setText( "Add UuidType" );
					buttonAddUuidType.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelUuidTypeObj obj = (IBusModelUuidTypeObj)schemaObj.getUuidTypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getUuidTypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelUuidTypeEditObj edit = (IBusModelUuidTypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXUuidTypePaneCommon jpanelCommon = (IBusModelJavaFXUuidTypePaneCommon)frame;
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
						list.add( buttonAddUuidType );
					}
					buttonAddUuidGen = new YCFButton();
					buttonAddUuidGen.setMinWidth( 200 );
					buttonAddUuidGen.setText( "Add UuidGen" );
					buttonAddUuidGen.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelUuidGenObj obj = (IBusModelUuidGenObj)schemaObj.getUuidGenTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getUuidGenFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelUuidGenEditObj edit = (IBusModelUuidGenEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXUuidGenPaneCommon jpanelCommon = (IBusModelJavaFXUuidGenPaneCommon)frame;
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
						list.add( buttonAddUuidGen );
					}
					buttonAddUuidCol = new YCFButton();
					buttonAddUuidCol.setMinWidth( 200 );
					buttonAddUuidCol.setText( "Add UuidCol" );
					buttonAddUuidCol.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelUuidColObj obj = (IBusModelUuidColObj)schemaObj.getUuidColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getUuidColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelUuidColEditObj edit = (IBusModelUuidColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXUuidColPaneCommon jpanelCommon = (IBusModelJavaFXUuidColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddUuidCol );
					}
					buttonAddUuid6Type = new YCFButton();
					buttonAddUuid6Type.setMinWidth( 200 );
					buttonAddUuid6Type.setText( "Add Uuid6Type" );
					buttonAddUuid6Type.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelUuid6TypeObj obj = (IBusModelUuid6TypeObj)schemaObj.getUuid6TypeTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getUuid6TypeFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelUuid6TypeEditObj edit = (IBusModelUuid6TypeEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXUuid6TypePaneCommon jpanelCommon = (IBusModelJavaFXUuid6TypePaneCommon)frame;
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
						list.add( buttonAddUuid6Type );
					}
					buttonAddUuid6Gen = new YCFButton();
					buttonAddUuid6Gen.setMinWidth( 200 );
					buttonAddUuid6Gen.setText( "Add Uuid6Gen" );
					buttonAddUuid6Gen.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelUuid6GenObj obj = (IBusModelUuid6GenObj)schemaObj.getUuid6GenTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getUuid6GenFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelUuid6GenEditObj edit = (IBusModelUuid6GenEditObj)( obj.beginEdit() );
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
								IBusModelJavaFXUuid6GenPaneCommon jpanelCommon = (IBusModelJavaFXUuid6GenPaneCommon)frame;
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
						list.add( buttonAddUuid6Gen );
					}
					buttonAddUuid6Col = new YCFButton();
					buttonAddUuid6Col.setMinWidth( 200 );
					buttonAddUuid6Col.setText( "Add Uuid6Col" );
					buttonAddUuid6Col.setOnAction( new EventHandler<ActionEvent>() {
						@Override public void handle( ActionEvent e ) {
							final String S_ProcName = "handle";
							try {
								IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
								IBusModelUuid6ColObj obj = (IBusModelUuid6ColObj)schemaObj.getUuid6ColTableObj().newInstance();
								YCFBorderPane frame = javafxSchema.getUuid6ColFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
								IBusModelUuid6ColEditObj edit = (IBusModelUuid6ColEditObj)( obj.beginEdit() );
								if( edit == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"edit" );
								}
								IBusModelTableObj container = (IBusModelTableObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerTable( container );
								IBusModelJavaFXUuid6ColPaneCommon jpanelCommon = (IBusModelJavaFXUuid6ColPaneCommon)frame;
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
					if( javafxContainer instanceof IBusModelTableObj ) {
						list.add( buttonAddUuid6Col );
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
						IBusModelAtomObj selectedInstance = getJavaFXFocusAsAtom();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelAtom.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getAtomFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((IBusModelJavaFXAtomPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBlobDef.CLASS_CODE ) {
								IBusModelBlobDefObj obj = (IBusModelBlobDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBlobDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXBlobDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBlobType.CLASS_CODE ) {
								IBusModelBlobTypeObj obj = (IBusModelBlobTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBlobTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXBlobTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBlobCol.CLASS_CODE ) {
								IBusModelBlobColObj obj = (IBusModelBlobColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBlobColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXBlobColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBoolDef.CLASS_CODE ) {
								IBusModelBoolDefObj obj = (IBusModelBoolDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBoolDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXBoolDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBoolType.CLASS_CODE ) {
								IBusModelBoolTypeObj obj = (IBusModelBoolTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBoolTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXBoolTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBoolCol.CLASS_CODE ) {
								IBusModelBoolColObj obj = (IBusModelBoolColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBoolColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXBoolColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDateDef.CLASS_CODE ) {
								IBusModelDateDefObj obj = (IBusModelDateDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDateDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDateDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDateType.CLASS_CODE ) {
								IBusModelDateTypeObj obj = (IBusModelDateTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDateTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDateTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDateCol.CLASS_CODE ) {
								IBusModelDateColObj obj = (IBusModelDateColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDateColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDateColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDoubleDef.CLASS_CODE ) {
								IBusModelDoubleDefObj obj = (IBusModelDoubleDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDoubleDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDoubleDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDoubleType.CLASS_CODE ) {
								IBusModelDoubleTypeObj obj = (IBusModelDoubleTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDoubleTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDoubleTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDoubleCol.CLASS_CODE ) {
								IBusModelDoubleColObj obj = (IBusModelDoubleColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDoubleColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDoubleColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelFloatDef.CLASS_CODE ) {
								IBusModelFloatDefObj obj = (IBusModelFloatDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getFloatDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXFloatDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelFloatType.CLASS_CODE ) {
								IBusModelFloatTypeObj obj = (IBusModelFloatTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getFloatTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXFloatTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelFloatCol.CLASS_CODE ) {
								IBusModelFloatColObj obj = (IBusModelFloatColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getFloatColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXFloatColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt16Def.CLASS_CODE ) {
								IBusModelInt16DefObj obj = (IBusModelInt16DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt16DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt16DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt16Type.CLASS_CODE ) {
								IBusModelInt16TypeObj obj = (IBusModelInt16TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt16TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt16TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId16Gen.CLASS_CODE ) {
								IBusModelId16GenObj obj = (IBusModelId16GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getId16GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXId16GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelEnumDef.CLASS_CODE ) {
								IBusModelEnumDefObj obj = (IBusModelEnumDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getEnumDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXEnumDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelEnumType.CLASS_CODE ) {
								IBusModelEnumTypeObj obj = (IBusModelEnumTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getEnumTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXEnumTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt16Col.CLASS_CODE ) {
								IBusModelInt16ColObj obj = (IBusModelInt16ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt16ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt16ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt32Def.CLASS_CODE ) {
								IBusModelInt32DefObj obj = (IBusModelInt32DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt32DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt32DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt32Type.CLASS_CODE ) {
								IBusModelInt32TypeObj obj = (IBusModelInt32TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt32TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt32TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId32Gen.CLASS_CODE ) {
								IBusModelId32GenObj obj = (IBusModelId32GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getId32GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXId32GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt32Col.CLASS_CODE ) {
								IBusModelInt32ColObj obj = (IBusModelInt32ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt32ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt32ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt64Def.CLASS_CODE ) {
								IBusModelInt64DefObj obj = (IBusModelInt64DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt64DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt64DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt64Type.CLASS_CODE ) {
								IBusModelInt64TypeObj obj = (IBusModelInt64TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt64TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt64TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId64Gen.CLASS_CODE ) {
								IBusModelId64GenObj obj = (IBusModelId64GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getId64GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXId64GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt64Col.CLASS_CODE ) {
								IBusModelInt64ColObj obj = (IBusModelInt64ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt64ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt64ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokenDef.CLASS_CODE ) {
								IBusModelNmTokenDefObj obj = (IBusModelNmTokenDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokenDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNmTokenDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokenType.CLASS_CODE ) {
								IBusModelNmTokenTypeObj obj = (IBusModelNmTokenTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokenTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNmTokenTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokenCol.CLASS_CODE ) {
								IBusModelNmTokenColObj obj = (IBusModelNmTokenColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokenColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNmTokenColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokensDef.CLASS_CODE ) {
								IBusModelNmTokensDefObj obj = (IBusModelNmTokensDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokensDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNmTokensDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokensType.CLASS_CODE ) {
								IBusModelNmTokensTypeObj obj = (IBusModelNmTokensTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokensTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNmTokensTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokensCol.CLASS_CODE ) {
								IBusModelNmTokensColObj obj = (IBusModelNmTokensColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokensColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNmTokensColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNumberDef.CLASS_CODE ) {
								IBusModelNumberDefObj obj = (IBusModelNumberDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNumberDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNumberDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNumberType.CLASS_CODE ) {
								IBusModelNumberTypeObj obj = (IBusModelNumberTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNumberTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNumberTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNumberCol.CLASS_CODE ) {
								IBusModelNumberColObj obj = (IBusModelNumberColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNumberColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNumberColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
								IBusModelDbKeyHash128DefObj obj = (IBusModelDbKeyHash128DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash128DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash128DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
								IBusModelDbKeyHash128ColObj obj = (IBusModelDbKeyHash128ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash128ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash128ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
								IBusModelDbKeyHash128TypeObj obj = (IBusModelDbKeyHash128TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash128TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash128TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
								IBusModelDbKeyHash128GenObj obj = (IBusModelDbKeyHash128GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash128GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash128GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
								IBusModelDbKeyHash160DefObj obj = (IBusModelDbKeyHash160DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash160DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash160DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
								IBusModelDbKeyHash160ColObj obj = (IBusModelDbKeyHash160ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash160ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash160ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
								IBusModelDbKeyHash160TypeObj obj = (IBusModelDbKeyHash160TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash160TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash160TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
								IBusModelDbKeyHash160GenObj obj = (IBusModelDbKeyHash160GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash160GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash160GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
								IBusModelDbKeyHash224DefObj obj = (IBusModelDbKeyHash224DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash224DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash224DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
								IBusModelDbKeyHash224ColObj obj = (IBusModelDbKeyHash224ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash224ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash224ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
								IBusModelDbKeyHash224TypeObj obj = (IBusModelDbKeyHash224TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash224TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash224TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
								IBusModelDbKeyHash224GenObj obj = (IBusModelDbKeyHash224GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash224GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash224GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
								IBusModelDbKeyHash256DefObj obj = (IBusModelDbKeyHash256DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash256DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash256DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
								IBusModelDbKeyHash256ColObj obj = (IBusModelDbKeyHash256ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash256ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash256ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
								IBusModelDbKeyHash256TypeObj obj = (IBusModelDbKeyHash256TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash256TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash256TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
								IBusModelDbKeyHash256GenObj obj = (IBusModelDbKeyHash256GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash256GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash256GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
								IBusModelDbKeyHash384DefObj obj = (IBusModelDbKeyHash384DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash384DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash384DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
								IBusModelDbKeyHash384ColObj obj = (IBusModelDbKeyHash384ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash384ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash384ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
								IBusModelDbKeyHash384TypeObj obj = (IBusModelDbKeyHash384TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash384TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash384TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
								IBusModelDbKeyHash384GenObj obj = (IBusModelDbKeyHash384GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash384GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash384GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
								IBusModelDbKeyHash512DefObj obj = (IBusModelDbKeyHash512DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash512DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash512DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
								IBusModelDbKeyHash512ColObj obj = (IBusModelDbKeyHash512ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash512ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash512ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
								IBusModelDbKeyHash512TypeObj obj = (IBusModelDbKeyHash512TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash512TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash512TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
								IBusModelDbKeyHash512GenObj obj = (IBusModelDbKeyHash512GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash512GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash512GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelStringDef.CLASS_CODE ) {
								IBusModelStringDefObj obj = (IBusModelStringDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getStringDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXStringDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelStringType.CLASS_CODE ) {
								IBusModelStringTypeObj obj = (IBusModelStringTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getStringTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXStringTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelStringCol.CLASS_CODE ) {
								IBusModelStringColObj obj = (IBusModelStringColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getStringColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXStringColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZDateDef.CLASS_CODE ) {
								IBusModelTZDateDefObj obj = (IBusModelTZDateDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZDateDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZDateDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZDateType.CLASS_CODE ) {
								IBusModelTZDateTypeObj obj = (IBusModelTZDateTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZDateTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZDateTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZDateCol.CLASS_CODE ) {
								IBusModelTZDateColObj obj = (IBusModelTZDateColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZDateColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZDateColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimeDef.CLASS_CODE ) {
								IBusModelTZTimeDefObj obj = (IBusModelTZTimeDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimeDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZTimeDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimeType.CLASS_CODE ) {
								IBusModelTZTimeTypeObj obj = (IBusModelTZTimeTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimeTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZTimeTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimeCol.CLASS_CODE ) {
								IBusModelTZTimeColObj obj = (IBusModelTZTimeColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimeColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZTimeColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimestampDef.CLASS_CODE ) {
								IBusModelTZTimestampDefObj obj = (IBusModelTZTimestampDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimestampDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZTimestampDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimestampType.CLASS_CODE ) {
								IBusModelTZTimestampTypeObj obj = (IBusModelTZTimestampTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimestampTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZTimestampTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimestampCol.CLASS_CODE ) {
								IBusModelTZTimestampColObj obj = (IBusModelTZTimestampColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimestampColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZTimestampColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTextDef.CLASS_CODE ) {
								IBusModelTextDefObj obj = (IBusModelTextDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTextDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTextDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTextType.CLASS_CODE ) {
								IBusModelTextTypeObj obj = (IBusModelTextTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTextTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTextTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTextCol.CLASS_CODE ) {
								IBusModelTextColObj obj = (IBusModelTextColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTextColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTextColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimeDef.CLASS_CODE ) {
								IBusModelTimeDefObj obj = (IBusModelTimeDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimeDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTimeDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimeType.CLASS_CODE ) {
								IBusModelTimeTypeObj obj = (IBusModelTimeTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimeTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTimeTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimeCol.CLASS_CODE ) {
								IBusModelTimeColObj obj = (IBusModelTimeColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimeColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTimeColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimestampDef.CLASS_CODE ) {
								IBusModelTimestampDefObj obj = (IBusModelTimestampDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimestampDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTimestampDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimestampType.CLASS_CODE ) {
								IBusModelTimestampTypeObj obj = (IBusModelTimestampTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimestampTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTimestampTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimestampCol.CLASS_CODE ) {
								IBusModelTimestampColObj obj = (IBusModelTimestampColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimestampColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTimestampColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTokenDef.CLASS_CODE ) {
								IBusModelTokenDefObj obj = (IBusModelTokenDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTokenDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTokenDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTokenType.CLASS_CODE ) {
								IBusModelTokenTypeObj obj = (IBusModelTokenTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTokenTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTokenTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTokenCol.CLASS_CODE ) {
								IBusModelTokenColObj obj = (IBusModelTokenColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTokenColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTokenColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt16Def.CLASS_CODE ) {
								IBusModelUInt16DefObj obj = (IBusModelUInt16DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt16DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt16DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt16Type.CLASS_CODE ) {
								IBusModelUInt16TypeObj obj = (IBusModelUInt16TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt16TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt16TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt16Col.CLASS_CODE ) {
								IBusModelUInt16ColObj obj = (IBusModelUInt16ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt16ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt16ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt32Def.CLASS_CODE ) {
								IBusModelUInt32DefObj obj = (IBusModelUInt32DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt32DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt32DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt32Type.CLASS_CODE ) {
								IBusModelUInt32TypeObj obj = (IBusModelUInt32TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt32TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt32TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt32Col.CLASS_CODE ) {
								IBusModelUInt32ColObj obj = (IBusModelUInt32ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt32ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt32ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt64Def.CLASS_CODE ) {
								IBusModelUInt64DefObj obj = (IBusModelUInt64DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt64DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt64DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt64Type.CLASS_CODE ) {
								IBusModelUInt64TypeObj obj = (IBusModelUInt64TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt64TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt64TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt64Col.CLASS_CODE ) {
								IBusModelUInt64ColObj obj = (IBusModelUInt64ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt64ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt64ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuidDef.CLASS_CODE ) {
								IBusModelUuidDefObj obj = (IBusModelUuidDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuidDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuidDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuidType.CLASS_CODE ) {
								IBusModelUuidTypeObj obj = (IBusModelUuidTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuidTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuidTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuidGen.CLASS_CODE ) {
								IBusModelUuidGenObj obj = (IBusModelUuidGenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuidGenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuidGenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuidCol.CLASS_CODE ) {
								IBusModelUuidColObj obj = (IBusModelUuidColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuidColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuidColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuid6Def.CLASS_CODE ) {
								IBusModelUuid6DefObj obj = (IBusModelUuid6DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuid6DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuid6DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuid6Type.CLASS_CODE ) {
								IBusModelUuid6TypeObj obj = (IBusModelUuid6TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuid6TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuid6TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuid6Gen.CLASS_CODE ) {
								IBusModelUuid6GenObj obj = (IBusModelUuid6GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuid6GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuid6GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuid6Col.CLASS_CODE ) {
								IBusModelUuid6ColObj obj = (IBusModelUuid6ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuid6ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuid6ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IBusModelAtomObj, IBusModelBlobDefObj, IBusModelBlobTypeObj, IBusModelBlobColObj, IBusModelBoolDefObj, IBusModelBoolTypeObj, IBusModelBoolColObj, IBusModelDateDefObj, IBusModelDateTypeObj, IBusModelDateColObj, IBusModelDoubleDefObj, IBusModelDoubleTypeObj, IBusModelDoubleColObj, IBusModelFloatDefObj, IBusModelFloatTypeObj, IBusModelFloatColObj, IBusModelInt16DefObj, IBusModelInt16TypeObj, IBusModelId16GenObj, IBusModelEnumDefObj, IBusModelEnumTypeObj, IBusModelInt16ColObj, IBusModelInt32DefObj, IBusModelInt32TypeObj, IBusModelId32GenObj, IBusModelInt32ColObj, IBusModelInt64DefObj, IBusModelInt64TypeObj, IBusModelId64GenObj, IBusModelInt64ColObj, IBusModelNmTokenDefObj, IBusModelNmTokenTypeObj, IBusModelNmTokenColObj, IBusModelNmTokensDefObj, IBusModelNmTokensTypeObj, IBusModelNmTokensColObj, IBusModelNumberDefObj, IBusModelNumberTypeObj, IBusModelNumberColObj, IBusModelDbKeyHash128DefObj, IBusModelDbKeyHash128ColObj, IBusModelDbKeyHash128TypeObj, IBusModelDbKeyHash128GenObj, IBusModelDbKeyHash160DefObj, IBusModelDbKeyHash160ColObj, IBusModelDbKeyHash160TypeObj, IBusModelDbKeyHash160GenObj, IBusModelDbKeyHash224DefObj, IBusModelDbKeyHash224ColObj, IBusModelDbKeyHash224TypeObj, IBusModelDbKeyHash224GenObj, IBusModelDbKeyHash256DefObj, IBusModelDbKeyHash256ColObj, IBusModelDbKeyHash256TypeObj, IBusModelDbKeyHash256GenObj, IBusModelDbKeyHash384DefObj, IBusModelDbKeyHash384ColObj, IBusModelDbKeyHash384TypeObj, IBusModelDbKeyHash384GenObj, IBusModelDbKeyHash512DefObj, IBusModelDbKeyHash512ColObj, IBusModelDbKeyHash512TypeObj, IBusModelDbKeyHash512GenObj, IBusModelStringDefObj, IBusModelStringTypeObj, IBusModelStringColObj, IBusModelTZDateDefObj, IBusModelTZDateTypeObj, IBusModelTZDateColObj, IBusModelTZTimeDefObj, IBusModelTZTimeTypeObj, IBusModelTZTimeColObj, IBusModelTZTimestampDefObj, IBusModelTZTimestampTypeObj, IBusModelTZTimestampColObj, IBusModelTextDefObj, IBusModelTextTypeObj, IBusModelTextColObj, IBusModelTimeDefObj, IBusModelTimeTypeObj, IBusModelTimeColObj, IBusModelTimestampDefObj, IBusModelTimestampTypeObj, IBusModelTimestampColObj, IBusModelTokenDefObj, IBusModelTokenTypeObj, IBusModelTokenColObj, IBusModelUInt16DefObj, IBusModelUInt16TypeObj, IBusModelUInt16ColObj, IBusModelUInt32DefObj, IBusModelUInt32TypeObj, IBusModelUInt32ColObj, IBusModelUInt64DefObj, IBusModelUInt64TypeObj, IBusModelUInt64ColObj, IBusModelUuidDefObj, IBusModelUuidTypeObj, IBusModelUuidGenObj, IBusModelUuidColObj, IBusModelUuid6DefObj, IBusModelUuid6TypeObj, IBusModelUuid6GenObj, IBusModelUuid6ColObj" );
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
						IBusModelAtomObj selectedInstance = getJavaFXFocusAsAtom();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelAtom.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getAtomFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((IBusModelJavaFXAtomPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBlobDef.CLASS_CODE ) {
								IBusModelBlobDefObj obj = (IBusModelBlobDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBlobDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXBlobDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBlobType.CLASS_CODE ) {
								IBusModelBlobTypeObj obj = (IBusModelBlobTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBlobTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXBlobTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBlobCol.CLASS_CODE ) {
								IBusModelBlobColObj obj = (IBusModelBlobColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBlobColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXBlobColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBoolDef.CLASS_CODE ) {
								IBusModelBoolDefObj obj = (IBusModelBoolDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBoolDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXBoolDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBoolType.CLASS_CODE ) {
								IBusModelBoolTypeObj obj = (IBusModelBoolTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBoolTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXBoolTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBoolCol.CLASS_CODE ) {
								IBusModelBoolColObj obj = (IBusModelBoolColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBoolColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXBoolColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDateDef.CLASS_CODE ) {
								IBusModelDateDefObj obj = (IBusModelDateDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDateDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDateDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDateType.CLASS_CODE ) {
								IBusModelDateTypeObj obj = (IBusModelDateTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDateTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDateTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDateCol.CLASS_CODE ) {
								IBusModelDateColObj obj = (IBusModelDateColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDateColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDateColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDoubleDef.CLASS_CODE ) {
								IBusModelDoubleDefObj obj = (IBusModelDoubleDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDoubleDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDoubleDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDoubleType.CLASS_CODE ) {
								IBusModelDoubleTypeObj obj = (IBusModelDoubleTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDoubleTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDoubleTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDoubleCol.CLASS_CODE ) {
								IBusModelDoubleColObj obj = (IBusModelDoubleColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDoubleColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDoubleColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelFloatDef.CLASS_CODE ) {
								IBusModelFloatDefObj obj = (IBusModelFloatDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getFloatDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXFloatDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelFloatType.CLASS_CODE ) {
								IBusModelFloatTypeObj obj = (IBusModelFloatTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getFloatTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXFloatTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelFloatCol.CLASS_CODE ) {
								IBusModelFloatColObj obj = (IBusModelFloatColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getFloatColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXFloatColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt16Def.CLASS_CODE ) {
								IBusModelInt16DefObj obj = (IBusModelInt16DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt16DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt16DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt16Type.CLASS_CODE ) {
								IBusModelInt16TypeObj obj = (IBusModelInt16TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt16TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt16TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId16Gen.CLASS_CODE ) {
								IBusModelId16GenObj obj = (IBusModelId16GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getId16GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXId16GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelEnumDef.CLASS_CODE ) {
								IBusModelEnumDefObj obj = (IBusModelEnumDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getEnumDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXEnumDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelEnumType.CLASS_CODE ) {
								IBusModelEnumTypeObj obj = (IBusModelEnumTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getEnumTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXEnumTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt16Col.CLASS_CODE ) {
								IBusModelInt16ColObj obj = (IBusModelInt16ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt16ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt16ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt32Def.CLASS_CODE ) {
								IBusModelInt32DefObj obj = (IBusModelInt32DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt32DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt32DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt32Type.CLASS_CODE ) {
								IBusModelInt32TypeObj obj = (IBusModelInt32TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt32TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt32TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId32Gen.CLASS_CODE ) {
								IBusModelId32GenObj obj = (IBusModelId32GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getId32GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXId32GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt32Col.CLASS_CODE ) {
								IBusModelInt32ColObj obj = (IBusModelInt32ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt32ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt32ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt64Def.CLASS_CODE ) {
								IBusModelInt64DefObj obj = (IBusModelInt64DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt64DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt64DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt64Type.CLASS_CODE ) {
								IBusModelInt64TypeObj obj = (IBusModelInt64TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt64TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt64TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId64Gen.CLASS_CODE ) {
								IBusModelId64GenObj obj = (IBusModelId64GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getId64GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXId64GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt64Col.CLASS_CODE ) {
								IBusModelInt64ColObj obj = (IBusModelInt64ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt64ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXInt64ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokenDef.CLASS_CODE ) {
								IBusModelNmTokenDefObj obj = (IBusModelNmTokenDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokenDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNmTokenDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokenType.CLASS_CODE ) {
								IBusModelNmTokenTypeObj obj = (IBusModelNmTokenTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokenTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNmTokenTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokenCol.CLASS_CODE ) {
								IBusModelNmTokenColObj obj = (IBusModelNmTokenColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokenColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNmTokenColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokensDef.CLASS_CODE ) {
								IBusModelNmTokensDefObj obj = (IBusModelNmTokensDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokensDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNmTokensDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokensType.CLASS_CODE ) {
								IBusModelNmTokensTypeObj obj = (IBusModelNmTokensTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokensTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNmTokensTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokensCol.CLASS_CODE ) {
								IBusModelNmTokensColObj obj = (IBusModelNmTokensColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokensColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNmTokensColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNumberDef.CLASS_CODE ) {
								IBusModelNumberDefObj obj = (IBusModelNumberDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNumberDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNumberDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNumberType.CLASS_CODE ) {
								IBusModelNumberTypeObj obj = (IBusModelNumberTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNumberTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNumberTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNumberCol.CLASS_CODE ) {
								IBusModelNumberColObj obj = (IBusModelNumberColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNumberColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXNumberColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
								IBusModelDbKeyHash128DefObj obj = (IBusModelDbKeyHash128DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash128DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash128DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
								IBusModelDbKeyHash128ColObj obj = (IBusModelDbKeyHash128ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash128ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash128ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
								IBusModelDbKeyHash128TypeObj obj = (IBusModelDbKeyHash128TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash128TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash128TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
								IBusModelDbKeyHash128GenObj obj = (IBusModelDbKeyHash128GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash128GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash128GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
								IBusModelDbKeyHash160DefObj obj = (IBusModelDbKeyHash160DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash160DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash160DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
								IBusModelDbKeyHash160ColObj obj = (IBusModelDbKeyHash160ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash160ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash160ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
								IBusModelDbKeyHash160TypeObj obj = (IBusModelDbKeyHash160TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash160TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash160TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
								IBusModelDbKeyHash160GenObj obj = (IBusModelDbKeyHash160GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash160GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash160GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
								IBusModelDbKeyHash224DefObj obj = (IBusModelDbKeyHash224DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash224DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash224DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
								IBusModelDbKeyHash224ColObj obj = (IBusModelDbKeyHash224ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash224ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash224ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
								IBusModelDbKeyHash224TypeObj obj = (IBusModelDbKeyHash224TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash224TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash224TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
								IBusModelDbKeyHash224GenObj obj = (IBusModelDbKeyHash224GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash224GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash224GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
								IBusModelDbKeyHash256DefObj obj = (IBusModelDbKeyHash256DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash256DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash256DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
								IBusModelDbKeyHash256ColObj obj = (IBusModelDbKeyHash256ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash256ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash256ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
								IBusModelDbKeyHash256TypeObj obj = (IBusModelDbKeyHash256TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash256TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash256TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
								IBusModelDbKeyHash256GenObj obj = (IBusModelDbKeyHash256GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash256GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash256GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
								IBusModelDbKeyHash384DefObj obj = (IBusModelDbKeyHash384DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash384DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash384DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
								IBusModelDbKeyHash384ColObj obj = (IBusModelDbKeyHash384ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash384ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash384ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
								IBusModelDbKeyHash384TypeObj obj = (IBusModelDbKeyHash384TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash384TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash384TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
								IBusModelDbKeyHash384GenObj obj = (IBusModelDbKeyHash384GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash384GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash384GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
								IBusModelDbKeyHash512DefObj obj = (IBusModelDbKeyHash512DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash512DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash512DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
								IBusModelDbKeyHash512ColObj obj = (IBusModelDbKeyHash512ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash512ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash512ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
								IBusModelDbKeyHash512TypeObj obj = (IBusModelDbKeyHash512TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash512TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash512TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
								IBusModelDbKeyHash512GenObj obj = (IBusModelDbKeyHash512GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash512GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXDbKeyHash512GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelStringDef.CLASS_CODE ) {
								IBusModelStringDefObj obj = (IBusModelStringDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getStringDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXStringDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelStringType.CLASS_CODE ) {
								IBusModelStringTypeObj obj = (IBusModelStringTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getStringTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXStringTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelStringCol.CLASS_CODE ) {
								IBusModelStringColObj obj = (IBusModelStringColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getStringColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXStringColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZDateDef.CLASS_CODE ) {
								IBusModelTZDateDefObj obj = (IBusModelTZDateDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZDateDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZDateDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZDateType.CLASS_CODE ) {
								IBusModelTZDateTypeObj obj = (IBusModelTZDateTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZDateTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZDateTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZDateCol.CLASS_CODE ) {
								IBusModelTZDateColObj obj = (IBusModelTZDateColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZDateColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZDateColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimeDef.CLASS_CODE ) {
								IBusModelTZTimeDefObj obj = (IBusModelTZTimeDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimeDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZTimeDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimeType.CLASS_CODE ) {
								IBusModelTZTimeTypeObj obj = (IBusModelTZTimeTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimeTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZTimeTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimeCol.CLASS_CODE ) {
								IBusModelTZTimeColObj obj = (IBusModelTZTimeColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimeColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZTimeColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimestampDef.CLASS_CODE ) {
								IBusModelTZTimestampDefObj obj = (IBusModelTZTimestampDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimestampDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZTimestampDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimestampType.CLASS_CODE ) {
								IBusModelTZTimestampTypeObj obj = (IBusModelTZTimestampTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimestampTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZTimestampTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimestampCol.CLASS_CODE ) {
								IBusModelTZTimestampColObj obj = (IBusModelTZTimestampColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimestampColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTZTimestampColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTextDef.CLASS_CODE ) {
								IBusModelTextDefObj obj = (IBusModelTextDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTextDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTextDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTextType.CLASS_CODE ) {
								IBusModelTextTypeObj obj = (IBusModelTextTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTextTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTextTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTextCol.CLASS_CODE ) {
								IBusModelTextColObj obj = (IBusModelTextColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTextColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTextColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimeDef.CLASS_CODE ) {
								IBusModelTimeDefObj obj = (IBusModelTimeDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimeDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTimeDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimeType.CLASS_CODE ) {
								IBusModelTimeTypeObj obj = (IBusModelTimeTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimeTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTimeTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimeCol.CLASS_CODE ) {
								IBusModelTimeColObj obj = (IBusModelTimeColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimeColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTimeColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimestampDef.CLASS_CODE ) {
								IBusModelTimestampDefObj obj = (IBusModelTimestampDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimestampDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTimestampDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimestampType.CLASS_CODE ) {
								IBusModelTimestampTypeObj obj = (IBusModelTimestampTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimestampTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTimestampTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimestampCol.CLASS_CODE ) {
								IBusModelTimestampColObj obj = (IBusModelTimestampColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimestampColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTimestampColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTokenDef.CLASS_CODE ) {
								IBusModelTokenDefObj obj = (IBusModelTokenDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTokenDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTokenDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTokenType.CLASS_CODE ) {
								IBusModelTokenTypeObj obj = (IBusModelTokenTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTokenTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTokenTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTokenCol.CLASS_CODE ) {
								IBusModelTokenColObj obj = (IBusModelTokenColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTokenColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXTokenColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt16Def.CLASS_CODE ) {
								IBusModelUInt16DefObj obj = (IBusModelUInt16DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt16DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt16DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt16Type.CLASS_CODE ) {
								IBusModelUInt16TypeObj obj = (IBusModelUInt16TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt16TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt16TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt16Col.CLASS_CODE ) {
								IBusModelUInt16ColObj obj = (IBusModelUInt16ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt16ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt16ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt32Def.CLASS_CODE ) {
								IBusModelUInt32DefObj obj = (IBusModelUInt32DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt32DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt32DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt32Type.CLASS_CODE ) {
								IBusModelUInt32TypeObj obj = (IBusModelUInt32TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt32TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt32TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt32Col.CLASS_CODE ) {
								IBusModelUInt32ColObj obj = (IBusModelUInt32ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt32ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt32ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt64Def.CLASS_CODE ) {
								IBusModelUInt64DefObj obj = (IBusModelUInt64DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt64DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt64DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt64Type.CLASS_CODE ) {
								IBusModelUInt64TypeObj obj = (IBusModelUInt64TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt64TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt64TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt64Col.CLASS_CODE ) {
								IBusModelUInt64ColObj obj = (IBusModelUInt64ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt64ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUInt64ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuidDef.CLASS_CODE ) {
								IBusModelUuidDefObj obj = (IBusModelUuidDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuidDefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuidDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuidType.CLASS_CODE ) {
								IBusModelUuidTypeObj obj = (IBusModelUuidTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuidTypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuidTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuidGen.CLASS_CODE ) {
								IBusModelUuidGenObj obj = (IBusModelUuidGenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuidGenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuidGenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuidCol.CLASS_CODE ) {
								IBusModelUuidColObj obj = (IBusModelUuidColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuidColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuidColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuid6Def.CLASS_CODE ) {
								IBusModelUuid6DefObj obj = (IBusModelUuid6DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuid6DefFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuid6DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuid6Type.CLASS_CODE ) {
								IBusModelUuid6TypeObj obj = (IBusModelUuid6TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuid6TypeFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuid6TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuid6Gen.CLASS_CODE ) {
								IBusModelUuid6GenObj obj = (IBusModelUuid6GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuid6GenFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuid6GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuid6Col.CLASS_CODE ) {
								IBusModelUuid6ColObj obj = (IBusModelUuid6ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuid6ColFactory().newViewEditForm( ycfFormManager, obj, getViewEditClosedCallback(), false );
								((IBusModelJavaFXUuid6ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IBusModelAtomObj, IBusModelBlobDefObj, IBusModelBlobTypeObj, IBusModelBlobColObj, IBusModelBoolDefObj, IBusModelBoolTypeObj, IBusModelBoolColObj, IBusModelDateDefObj, IBusModelDateTypeObj, IBusModelDateColObj, IBusModelDoubleDefObj, IBusModelDoubleTypeObj, IBusModelDoubleColObj, IBusModelFloatDefObj, IBusModelFloatTypeObj, IBusModelFloatColObj, IBusModelInt16DefObj, IBusModelInt16TypeObj, IBusModelId16GenObj, IBusModelEnumDefObj, IBusModelEnumTypeObj, IBusModelInt16ColObj, IBusModelInt32DefObj, IBusModelInt32TypeObj, IBusModelId32GenObj, IBusModelInt32ColObj, IBusModelInt64DefObj, IBusModelInt64TypeObj, IBusModelId64GenObj, IBusModelInt64ColObj, IBusModelNmTokenDefObj, IBusModelNmTokenTypeObj, IBusModelNmTokenColObj, IBusModelNmTokensDefObj, IBusModelNmTokensTypeObj, IBusModelNmTokensColObj, IBusModelNumberDefObj, IBusModelNumberTypeObj, IBusModelNumberColObj, IBusModelDbKeyHash128DefObj, IBusModelDbKeyHash128ColObj, IBusModelDbKeyHash128TypeObj, IBusModelDbKeyHash128GenObj, IBusModelDbKeyHash160DefObj, IBusModelDbKeyHash160ColObj, IBusModelDbKeyHash160TypeObj, IBusModelDbKeyHash160GenObj, IBusModelDbKeyHash224DefObj, IBusModelDbKeyHash224ColObj, IBusModelDbKeyHash224TypeObj, IBusModelDbKeyHash224GenObj, IBusModelDbKeyHash256DefObj, IBusModelDbKeyHash256ColObj, IBusModelDbKeyHash256TypeObj, IBusModelDbKeyHash256GenObj, IBusModelDbKeyHash384DefObj, IBusModelDbKeyHash384ColObj, IBusModelDbKeyHash384TypeObj, IBusModelDbKeyHash384GenObj, IBusModelDbKeyHash512DefObj, IBusModelDbKeyHash512ColObj, IBusModelDbKeyHash512TypeObj, IBusModelDbKeyHash512GenObj, IBusModelStringDefObj, IBusModelStringTypeObj, IBusModelStringColObj, IBusModelTZDateDefObj, IBusModelTZDateTypeObj, IBusModelTZDateColObj, IBusModelTZTimeDefObj, IBusModelTZTimeTypeObj, IBusModelTZTimeColObj, IBusModelTZTimestampDefObj, IBusModelTZTimestampTypeObj, IBusModelTZTimestampColObj, IBusModelTextDefObj, IBusModelTextTypeObj, IBusModelTextColObj, IBusModelTimeDefObj, IBusModelTimeTypeObj, IBusModelTimeColObj, IBusModelTimestampDefObj, IBusModelTimestampTypeObj, IBusModelTimestampColObj, IBusModelTokenDefObj, IBusModelTokenTypeObj, IBusModelTokenColObj, IBusModelUInt16DefObj, IBusModelUInt16TypeObj, IBusModelUInt16ColObj, IBusModelUInt32DefObj, IBusModelUInt32TypeObj, IBusModelUInt32ColObj, IBusModelUInt64DefObj, IBusModelUInt64TypeObj, IBusModelUInt64ColObj, IBusModelUuidDefObj, IBusModelUuidTypeObj, IBusModelUuidGenObj, IBusModelUuidColObj, IBusModelUuid6DefObj, IBusModelUuid6TypeObj, IBusModelUuid6GenObj, IBusModelUuid6ColObj" );
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
						IBusModelAtomObj selectedInstance = getJavaFXFocusAsAtom();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelAtom.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getAtomFactory().newAskDeleteForm( ycfFormManager, selectedInstance, getDeleteCallback() );
								((IBusModelJavaFXAtomPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBlobDef.CLASS_CODE ) {
								IBusModelBlobDefObj obj = (IBusModelBlobDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBlobDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXBlobDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBlobType.CLASS_CODE ) {
								IBusModelBlobTypeObj obj = (IBusModelBlobTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBlobTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXBlobTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBlobCol.CLASS_CODE ) {
								IBusModelBlobColObj obj = (IBusModelBlobColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBlobColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXBlobColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBoolDef.CLASS_CODE ) {
								IBusModelBoolDefObj obj = (IBusModelBoolDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBoolDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXBoolDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBoolType.CLASS_CODE ) {
								IBusModelBoolTypeObj obj = (IBusModelBoolTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBoolTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXBoolTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelBoolCol.CLASS_CODE ) {
								IBusModelBoolColObj obj = (IBusModelBoolColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getBoolColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXBoolColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDateDef.CLASS_CODE ) {
								IBusModelDateDefObj obj = (IBusModelDateDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDateDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDateDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDateType.CLASS_CODE ) {
								IBusModelDateTypeObj obj = (IBusModelDateTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDateTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDateTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDateCol.CLASS_CODE ) {
								IBusModelDateColObj obj = (IBusModelDateColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDateColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDateColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDoubleDef.CLASS_CODE ) {
								IBusModelDoubleDefObj obj = (IBusModelDoubleDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDoubleDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDoubleDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDoubleType.CLASS_CODE ) {
								IBusModelDoubleTypeObj obj = (IBusModelDoubleTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDoubleTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDoubleTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDoubleCol.CLASS_CODE ) {
								IBusModelDoubleColObj obj = (IBusModelDoubleColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDoubleColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDoubleColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelFloatDef.CLASS_CODE ) {
								IBusModelFloatDefObj obj = (IBusModelFloatDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getFloatDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXFloatDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelFloatType.CLASS_CODE ) {
								IBusModelFloatTypeObj obj = (IBusModelFloatTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getFloatTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXFloatTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelFloatCol.CLASS_CODE ) {
								IBusModelFloatColObj obj = (IBusModelFloatColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getFloatColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXFloatColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt16Def.CLASS_CODE ) {
								IBusModelInt16DefObj obj = (IBusModelInt16DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt16DefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXInt16DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt16Type.CLASS_CODE ) {
								IBusModelInt16TypeObj obj = (IBusModelInt16TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt16TypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXInt16TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId16Gen.CLASS_CODE ) {
								IBusModelId16GenObj obj = (IBusModelId16GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getId16GenFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXId16GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelEnumDef.CLASS_CODE ) {
								IBusModelEnumDefObj obj = (IBusModelEnumDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getEnumDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXEnumDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelEnumType.CLASS_CODE ) {
								IBusModelEnumTypeObj obj = (IBusModelEnumTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getEnumTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXEnumTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt16Col.CLASS_CODE ) {
								IBusModelInt16ColObj obj = (IBusModelInt16ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt16ColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXInt16ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt32Def.CLASS_CODE ) {
								IBusModelInt32DefObj obj = (IBusModelInt32DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt32DefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXInt32DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt32Type.CLASS_CODE ) {
								IBusModelInt32TypeObj obj = (IBusModelInt32TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt32TypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXInt32TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId32Gen.CLASS_CODE ) {
								IBusModelId32GenObj obj = (IBusModelId32GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getId32GenFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXId32GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt32Col.CLASS_CODE ) {
								IBusModelInt32ColObj obj = (IBusModelInt32ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt32ColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXInt32ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt64Def.CLASS_CODE ) {
								IBusModelInt64DefObj obj = (IBusModelInt64DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt64DefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXInt64DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt64Type.CLASS_CODE ) {
								IBusModelInt64TypeObj obj = (IBusModelInt64TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt64TypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXInt64TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelId64Gen.CLASS_CODE ) {
								IBusModelId64GenObj obj = (IBusModelId64GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getId64GenFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXId64GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelInt64Col.CLASS_CODE ) {
								IBusModelInt64ColObj obj = (IBusModelInt64ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getInt64ColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXInt64ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokenDef.CLASS_CODE ) {
								IBusModelNmTokenDefObj obj = (IBusModelNmTokenDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokenDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXNmTokenDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokenType.CLASS_CODE ) {
								IBusModelNmTokenTypeObj obj = (IBusModelNmTokenTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokenTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXNmTokenTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokenCol.CLASS_CODE ) {
								IBusModelNmTokenColObj obj = (IBusModelNmTokenColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokenColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXNmTokenColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokensDef.CLASS_CODE ) {
								IBusModelNmTokensDefObj obj = (IBusModelNmTokensDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokensDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXNmTokensDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokensType.CLASS_CODE ) {
								IBusModelNmTokensTypeObj obj = (IBusModelNmTokensTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokensTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXNmTokensTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNmTokensCol.CLASS_CODE ) {
								IBusModelNmTokensColObj obj = (IBusModelNmTokensColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNmTokensColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXNmTokensColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNumberDef.CLASS_CODE ) {
								IBusModelNumberDefObj obj = (IBusModelNumberDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNumberDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXNumberDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNumberType.CLASS_CODE ) {
								IBusModelNumberTypeObj obj = (IBusModelNumberTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNumberTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXNumberTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelNumberCol.CLASS_CODE ) {
								IBusModelNumberColObj obj = (IBusModelNumberColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getNumberColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXNumberColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash128Def.CLASS_CODE ) {
								IBusModelDbKeyHash128DefObj obj = (IBusModelDbKeyHash128DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash128DefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash128DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash128Col.CLASS_CODE ) {
								IBusModelDbKeyHash128ColObj obj = (IBusModelDbKeyHash128ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash128ColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash128ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash128Type.CLASS_CODE ) {
								IBusModelDbKeyHash128TypeObj obj = (IBusModelDbKeyHash128TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash128TypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash128TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash128Gen.CLASS_CODE ) {
								IBusModelDbKeyHash128GenObj obj = (IBusModelDbKeyHash128GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash128GenFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash128GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash160Def.CLASS_CODE ) {
								IBusModelDbKeyHash160DefObj obj = (IBusModelDbKeyHash160DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash160DefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash160DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash160Col.CLASS_CODE ) {
								IBusModelDbKeyHash160ColObj obj = (IBusModelDbKeyHash160ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash160ColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash160ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash160Type.CLASS_CODE ) {
								IBusModelDbKeyHash160TypeObj obj = (IBusModelDbKeyHash160TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash160TypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash160TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash160Gen.CLASS_CODE ) {
								IBusModelDbKeyHash160GenObj obj = (IBusModelDbKeyHash160GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash160GenFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash160GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash224Def.CLASS_CODE ) {
								IBusModelDbKeyHash224DefObj obj = (IBusModelDbKeyHash224DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash224DefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash224DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash224Col.CLASS_CODE ) {
								IBusModelDbKeyHash224ColObj obj = (IBusModelDbKeyHash224ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash224ColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash224ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash224Type.CLASS_CODE ) {
								IBusModelDbKeyHash224TypeObj obj = (IBusModelDbKeyHash224TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash224TypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash224TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash224Gen.CLASS_CODE ) {
								IBusModelDbKeyHash224GenObj obj = (IBusModelDbKeyHash224GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash224GenFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash224GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash256Def.CLASS_CODE ) {
								IBusModelDbKeyHash256DefObj obj = (IBusModelDbKeyHash256DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash256DefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash256DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash256Col.CLASS_CODE ) {
								IBusModelDbKeyHash256ColObj obj = (IBusModelDbKeyHash256ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash256ColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash256ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash256Type.CLASS_CODE ) {
								IBusModelDbKeyHash256TypeObj obj = (IBusModelDbKeyHash256TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash256TypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash256TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash256Gen.CLASS_CODE ) {
								IBusModelDbKeyHash256GenObj obj = (IBusModelDbKeyHash256GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash256GenFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash256GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash384Def.CLASS_CODE ) {
								IBusModelDbKeyHash384DefObj obj = (IBusModelDbKeyHash384DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash384DefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash384DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash384Col.CLASS_CODE ) {
								IBusModelDbKeyHash384ColObj obj = (IBusModelDbKeyHash384ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash384ColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash384ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash384Type.CLASS_CODE ) {
								IBusModelDbKeyHash384TypeObj obj = (IBusModelDbKeyHash384TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash384TypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash384TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash384Gen.CLASS_CODE ) {
								IBusModelDbKeyHash384GenObj obj = (IBusModelDbKeyHash384GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash384GenFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash384GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash512Def.CLASS_CODE ) {
								IBusModelDbKeyHash512DefObj obj = (IBusModelDbKeyHash512DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash512DefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash512DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash512Col.CLASS_CODE ) {
								IBusModelDbKeyHash512ColObj obj = (IBusModelDbKeyHash512ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash512ColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash512ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash512Type.CLASS_CODE ) {
								IBusModelDbKeyHash512TypeObj obj = (IBusModelDbKeyHash512TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash512TypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash512TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelDbKeyHash512Gen.CLASS_CODE ) {
								IBusModelDbKeyHash512GenObj obj = (IBusModelDbKeyHash512GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getDbKeyHash512GenFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXDbKeyHash512GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelStringDef.CLASS_CODE ) {
								IBusModelStringDefObj obj = (IBusModelStringDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getStringDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXStringDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelStringType.CLASS_CODE ) {
								IBusModelStringTypeObj obj = (IBusModelStringTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getStringTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXStringTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelStringCol.CLASS_CODE ) {
								IBusModelStringColObj obj = (IBusModelStringColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getStringColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXStringColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZDateDef.CLASS_CODE ) {
								IBusModelTZDateDefObj obj = (IBusModelTZDateDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZDateDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTZDateDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZDateType.CLASS_CODE ) {
								IBusModelTZDateTypeObj obj = (IBusModelTZDateTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZDateTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTZDateTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZDateCol.CLASS_CODE ) {
								IBusModelTZDateColObj obj = (IBusModelTZDateColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZDateColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTZDateColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimeDef.CLASS_CODE ) {
								IBusModelTZTimeDefObj obj = (IBusModelTZTimeDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimeDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTZTimeDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimeType.CLASS_CODE ) {
								IBusModelTZTimeTypeObj obj = (IBusModelTZTimeTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimeTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTZTimeTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimeCol.CLASS_CODE ) {
								IBusModelTZTimeColObj obj = (IBusModelTZTimeColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimeColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTZTimeColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimestampDef.CLASS_CODE ) {
								IBusModelTZTimestampDefObj obj = (IBusModelTZTimestampDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimestampDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTZTimestampDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimestampType.CLASS_CODE ) {
								IBusModelTZTimestampTypeObj obj = (IBusModelTZTimestampTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimestampTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTZTimestampTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTZTimestampCol.CLASS_CODE ) {
								IBusModelTZTimestampColObj obj = (IBusModelTZTimestampColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTZTimestampColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTZTimestampColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTextDef.CLASS_CODE ) {
								IBusModelTextDefObj obj = (IBusModelTextDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTextDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTextDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTextType.CLASS_CODE ) {
								IBusModelTextTypeObj obj = (IBusModelTextTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTextTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTextTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTextCol.CLASS_CODE ) {
								IBusModelTextColObj obj = (IBusModelTextColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTextColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTextColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimeDef.CLASS_CODE ) {
								IBusModelTimeDefObj obj = (IBusModelTimeDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimeDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTimeDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimeType.CLASS_CODE ) {
								IBusModelTimeTypeObj obj = (IBusModelTimeTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimeTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTimeTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimeCol.CLASS_CODE ) {
								IBusModelTimeColObj obj = (IBusModelTimeColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimeColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTimeColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimestampDef.CLASS_CODE ) {
								IBusModelTimestampDefObj obj = (IBusModelTimestampDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimestampDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTimestampDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimestampType.CLASS_CODE ) {
								IBusModelTimestampTypeObj obj = (IBusModelTimestampTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimestampTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTimestampTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTimestampCol.CLASS_CODE ) {
								IBusModelTimestampColObj obj = (IBusModelTimestampColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTimestampColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTimestampColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTokenDef.CLASS_CODE ) {
								IBusModelTokenDefObj obj = (IBusModelTokenDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTokenDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTokenDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTokenType.CLASS_CODE ) {
								IBusModelTokenTypeObj obj = (IBusModelTokenTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTokenTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTokenTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTokenCol.CLASS_CODE ) {
								IBusModelTokenColObj obj = (IBusModelTokenColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getTokenColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXTokenColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt16Def.CLASS_CODE ) {
								IBusModelUInt16DefObj obj = (IBusModelUInt16DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt16DefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUInt16DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt16Type.CLASS_CODE ) {
								IBusModelUInt16TypeObj obj = (IBusModelUInt16TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt16TypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUInt16TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt16Col.CLASS_CODE ) {
								IBusModelUInt16ColObj obj = (IBusModelUInt16ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt16ColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUInt16ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt32Def.CLASS_CODE ) {
								IBusModelUInt32DefObj obj = (IBusModelUInt32DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt32DefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUInt32DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt32Type.CLASS_CODE ) {
								IBusModelUInt32TypeObj obj = (IBusModelUInt32TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt32TypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUInt32TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt32Col.CLASS_CODE ) {
								IBusModelUInt32ColObj obj = (IBusModelUInt32ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt32ColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUInt32ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt64Def.CLASS_CODE ) {
								IBusModelUInt64DefObj obj = (IBusModelUInt64DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt64DefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUInt64DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt64Type.CLASS_CODE ) {
								IBusModelUInt64TypeObj obj = (IBusModelUInt64TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt64TypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUInt64TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUInt64Col.CLASS_CODE ) {
								IBusModelUInt64ColObj obj = (IBusModelUInt64ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUInt64ColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUInt64ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuidDef.CLASS_CODE ) {
								IBusModelUuidDefObj obj = (IBusModelUuidDefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuidDefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUuidDefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuidType.CLASS_CODE ) {
								IBusModelUuidTypeObj obj = (IBusModelUuidTypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuidTypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUuidTypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuidGen.CLASS_CODE ) {
								IBusModelUuidGenObj obj = (IBusModelUuidGenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuidGenFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUuidGenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuidCol.CLASS_CODE ) {
								IBusModelUuidColObj obj = (IBusModelUuidColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuidColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUuidColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuid6Def.CLASS_CODE ) {
								IBusModelUuid6DefObj obj = (IBusModelUuid6DefObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuid6DefFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUuid6DefPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuid6Type.CLASS_CODE ) {
								IBusModelUuid6TypeObj obj = (IBusModelUuid6TypeObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuid6TypeFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUuid6TypePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuid6Gen.CLASS_CODE ) {
								IBusModelUuid6GenObj obj = (IBusModelUuid6GenObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuid6GenFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUuid6GenPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelUuid6Col.CLASS_CODE ) {
								IBusModelUuid6ColObj obj = (IBusModelUuid6ColObj)selectedInstance;
								YCFBorderPane frame = javafxSchema.getUuid6ColFactory().newAskDeleteForm( ycfFormManager, obj, getDeleteCallback() );
								((IBusModelJavaFXUuid6ColPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IBusModelAtomObj, IBusModelBlobDefObj, IBusModelBlobTypeObj, IBusModelBlobColObj, IBusModelBoolDefObj, IBusModelBoolTypeObj, IBusModelBoolColObj, IBusModelDateDefObj, IBusModelDateTypeObj, IBusModelDateColObj, IBusModelDoubleDefObj, IBusModelDoubleTypeObj, IBusModelDoubleColObj, IBusModelFloatDefObj, IBusModelFloatTypeObj, IBusModelFloatColObj, IBusModelInt16DefObj, IBusModelInt16TypeObj, IBusModelId16GenObj, IBusModelEnumDefObj, IBusModelEnumTypeObj, IBusModelInt16ColObj, IBusModelInt32DefObj, IBusModelInt32TypeObj, IBusModelId32GenObj, IBusModelInt32ColObj, IBusModelInt64DefObj, IBusModelInt64TypeObj, IBusModelId64GenObj, IBusModelInt64ColObj, IBusModelNmTokenDefObj, IBusModelNmTokenTypeObj, IBusModelNmTokenColObj, IBusModelNmTokensDefObj, IBusModelNmTokensTypeObj, IBusModelNmTokensColObj, IBusModelNumberDefObj, IBusModelNumberTypeObj, IBusModelNumberColObj, IBusModelDbKeyHash128DefObj, IBusModelDbKeyHash128ColObj, IBusModelDbKeyHash128TypeObj, IBusModelDbKeyHash128GenObj, IBusModelDbKeyHash160DefObj, IBusModelDbKeyHash160ColObj, IBusModelDbKeyHash160TypeObj, IBusModelDbKeyHash160GenObj, IBusModelDbKeyHash224DefObj, IBusModelDbKeyHash224ColObj, IBusModelDbKeyHash224TypeObj, IBusModelDbKeyHash224GenObj, IBusModelDbKeyHash256DefObj, IBusModelDbKeyHash256ColObj, IBusModelDbKeyHash256TypeObj, IBusModelDbKeyHash256GenObj, IBusModelDbKeyHash384DefObj, IBusModelDbKeyHash384ColObj, IBusModelDbKeyHash384TypeObj, IBusModelDbKeyHash384GenObj, IBusModelDbKeyHash512DefObj, IBusModelDbKeyHash512ColObj, IBusModelDbKeyHash512TypeObj, IBusModelDbKeyHash512GenObj, IBusModelStringDefObj, IBusModelStringTypeObj, IBusModelStringColObj, IBusModelTZDateDefObj, IBusModelTZDateTypeObj, IBusModelTZDateColObj, IBusModelTZTimeDefObj, IBusModelTZTimeTypeObj, IBusModelTZTimeColObj, IBusModelTZTimestampDefObj, IBusModelTZTimestampTypeObj, IBusModelTZTimestampColObj, IBusModelTextDefObj, IBusModelTextTypeObj, IBusModelTextColObj, IBusModelTimeDefObj, IBusModelTimeTypeObj, IBusModelTimeColObj, IBusModelTimestampDefObj, IBusModelTimestampTypeObj, IBusModelTimestampColObj, IBusModelTokenDefObj, IBusModelTokenTypeObj, IBusModelTokenColObj, IBusModelUInt16DefObj, IBusModelUInt16TypeObj, IBusModelUInt16ColObj, IBusModelUInt32DefObj, IBusModelUInt32TypeObj, IBusModelUInt32ColObj, IBusModelUInt64DefObj, IBusModelUInt64TypeObj, IBusModelUInt64ColObj, IBusModelUuidDefObj, IBusModelUuidTypeObj, IBusModelUuidGenObj, IBusModelUuidColObj, IBusModelUuid6DefObj, IBusModelUuid6TypeObj, IBusModelUuid6GenObj, IBusModelUuid6ColObj" );
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

	public IBusModelScopeObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( IBusModelScopeObj value ) {
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
		IBusModelAtomObj selectedObj = getJavaFXFocusAsAtom();
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

		if( buttonAdd != null ) {
			buttonAdd.setDisable( ! allowAdds );
		}
	}
}
