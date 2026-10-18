// Description: Java 25 JavaFX Picker of Obj Pane implementation for TableCol.

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
 *	BusModelJavaFXTableColPickerPane JavaFX Pick Obj Pane implementation
 *	for TableCol.
 */
public class BusModelJavaFXTableColPickerPane
extends YCFBorderPane
implements IBusModelJavaFXTableColPaneList
{
	public static String S_FormName = "Choose TableCol";
	protected IBusModelJavaFXSchema javafxSchema = null;
	protected Collection<IBusModelTableColObj> javafxDataCollection = null;
	protected ObservableList<IBusModelTableColObj> observableListOfTableCol = null;
	protected TableColumn<IBusModelTableColObj, IYCFKeyHash256> tableColumnId = null;
	protected TableColumn<IBusModelTableColObj, String> tableColumnName = null;
	protected TableColumn<IBusModelTableColObj, String> tableColumnShortName = null;
	protected TableColumn<IBusModelTableColObj, String> tableColumnLabel = null;
	protected TableColumn<IBusModelTableColObj, String> tableColumnShortDescription = null;
	protected TableColumn<IBusModelTableColObj, String> tableColumnDescription = null;
	protected TableColumn<IBusModelTableColObj, String> tableColumnDefaultXmlValue = null;
	protected TableColumn<IBusModelTableColObj, Boolean> tableColumnIsNullable = null;
	protected TableColumn<IBusModelTableColObj, Boolean> tableColumnGenerateId = null;
	protected TableColumn<IBusModelTableColObj, Boolean> tableColumnImplementsPolymorph = null;
	protected TableColumn<IBusModelTableColObj, String> tableColumnDbName = null;
	protected TableColumn<IBusModelTableColObj, String> tableColumnXmlElementName = null;
	protected TableColumn<IBusModelTableColObj, IBusModelValueObj> tableColumnParentDataType = null;
	protected TableColumn<IBusModelTableColObj, IBusModelSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableView<IBusModelTableColObj> dataTable = null;
	protected YCFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected IYCFFormManager ycfFormManager = null;
	protected IBusModelJavaFXTableColChosen invokeWhenChosen = null;
	protected IBusModelTableObj javafxContainer = null;
	protected YCFButton buttonCancel = null;
	protected YCFButton buttonChooseNone = null;
	protected YCFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public BusModelJavaFXTableColPickerPane( IYCFFormManager formManager,
		IBusModelJavaFXSchema argSchema,
		IBusModelTableColObj argFocus,
		IBusModelTableObj argContainer,
		Collection<IBusModelTableColObj> argDataCollection,
		IBusModelJavaFXTableColChosen whenChosen )
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
		dataTable = new TableView<IBusModelTableColObj>();
		tableColumnId = new TableColumn<IBusModelTableColObj,IYCFKeyHash256>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableColObj,IYCFKeyHash256>,ObservableValue<IYCFKeyHash256> >() {
			public ObservableValue<IYCFKeyHash256> call( CellDataFeatures<IBusModelTableColObj, IYCFKeyHash256> p ) {
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
		tableColumnId.setCellFactory( new Callback<TableColumn<IBusModelTableColObj,IYCFKeyHash256>,TableCell<IBusModelTableColObj,IYCFKeyHash256>>() {
			@Override public TableCell<IBusModelTableColObj,IYCFKeyHash256> call(
				TableColumn<IBusModelTableColObj,IYCFKeyHash256> arg)
			{
				return new YCFDbKeyHash256TableCell<IBusModelTableColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<IBusModelTableColObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableColObj, String> p ) {
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
		tableColumnName.setCellFactory( new Callback<TableColumn<IBusModelTableColObj,String>,TableCell<IBusModelTableColObj,String>>() {
			@Override public TableCell<IBusModelTableColObj,String> call(
				TableColumn<IBusModelTableColObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<IBusModelTableColObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableColObj, String> p ) {
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<IBusModelTableColObj,String>,TableCell<IBusModelTableColObj,String>>() {
			@Override public TableCell<IBusModelTableColObj,String> call(
				TableColumn<IBusModelTableColObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<IBusModelTableColObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableColObj, String> p ) {
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<IBusModelTableColObj,String>,TableCell<IBusModelTableColObj,String>>() {
			@Override public TableCell<IBusModelTableColObj,String> call(
				TableColumn<IBusModelTableColObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<IBusModelTableColObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableColObj, String> p ) {
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<IBusModelTableColObj,String>,TableCell<IBusModelTableColObj,String>>() {
			@Override public TableCell<IBusModelTableColObj,String> call(
				TableColumn<IBusModelTableColObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<IBusModelTableColObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableColObj, String> p ) {
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<IBusModelTableColObj,String>,TableCell<IBusModelTableColObj,String>>() {
			@Override public TableCell<IBusModelTableColObj,String> call(
				TableColumn<IBusModelTableColObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnDefaultXmlValue = new TableColumn<IBusModelTableColObj,String>( "DefaultXmlValue" );
		tableColumnDefaultXmlValue.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableColObj, String> p ) {
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
		tableColumnDefaultXmlValue.setCellFactory( new Callback<TableColumn<IBusModelTableColObj,String>,TableCell<IBusModelTableColObj,String>>() {
			@Override public TableCell<IBusModelTableColObj,String> call(
				TableColumn<IBusModelTableColObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDefaultXmlValue );
		tableColumnIsNullable = new TableColumn<IBusModelTableColObj,Boolean>( "Is Nullable" );
		tableColumnIsNullable.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableColObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelTableColObj, Boolean> p ) {
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
		tableColumnIsNullable.setCellFactory( new Callback<TableColumn<IBusModelTableColObj,Boolean>,TableCell<IBusModelTableColObj,Boolean>>() {
			@Override public TableCell<IBusModelTableColObj,Boolean> call(
				TableColumn<IBusModelTableColObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelTableColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsNullable );
		tableColumnGenerateId = new TableColumn<IBusModelTableColObj,Boolean>( "Generate Id" );
		tableColumnGenerateId.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableColObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelTableColObj, Boolean> p ) {
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
		tableColumnGenerateId.setCellFactory( new Callback<TableColumn<IBusModelTableColObj,Boolean>,TableCell<IBusModelTableColObj,Boolean>>() {
			@Override public TableCell<IBusModelTableColObj,Boolean> call(
				TableColumn<IBusModelTableColObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelTableColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnGenerateId );
		tableColumnImplementsPolymorph = new TableColumn<IBusModelTableColObj,Boolean>( "ImplementsPolymorph" );
		tableColumnImplementsPolymorph.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableColObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IBusModelTableColObj, Boolean> p ) {
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
		tableColumnImplementsPolymorph.setCellFactory( new Callback<TableColumn<IBusModelTableColObj,Boolean>,TableCell<IBusModelTableColObj,Boolean>>() {
			@Override public TableCell<IBusModelTableColObj,Boolean> call(
				TableColumn<IBusModelTableColObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IBusModelTableColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnImplementsPolymorph );
		tableColumnDbName = new TableColumn<IBusModelTableColObj,String>( "Db Name" );
		tableColumnDbName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableColObj, String> p ) {
				IBusModelTableColObj obj = p.getValue();
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
		tableColumnDbName.setCellFactory( new Callback<TableColumn<IBusModelTableColObj,String>,TableCell<IBusModelTableColObj,String>>() {
			@Override public TableCell<IBusModelTableColObj,String> call(
				TableColumn<IBusModelTableColObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDbName );
		tableColumnXmlElementName = new TableColumn<IBusModelTableColObj,String>( "XmlElementName" );
		tableColumnXmlElementName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableColObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelTableColObj, String> p ) {
				IBusModelTableColObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalXmlElementName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnXmlElementName.setCellFactory( new Callback<TableColumn<IBusModelTableColObj,String>,TableCell<IBusModelTableColObj,String>>() {
			@Override public TableCell<IBusModelTableColObj,String> call(
				TableColumn<IBusModelTableColObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelTableColObj>();
			}
		});
		dataTable.getColumns().add( tableColumnXmlElementName );
		tableColumnParentDataType = new TableColumn<IBusModelTableColObj, IBusModelValueObj>( "Column Data Type" );
		tableColumnParentDataType.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableColObj,IBusModelValueObj>,ObservableValue<IBusModelValueObj> >() {
			public ObservableValue<IBusModelValueObj> call( CellDataFeatures<IBusModelTableColObj, IBusModelValueObj> p ) {
				IBusModelTableColObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IBusModelValueObj ref = obj.getRequiredParentDataType();
					ReadOnlyObjectWrapper<IBusModelValueObj> observable = new ReadOnlyObjectWrapper<IBusModelValueObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnParentDataType.setCellFactory( new Callback<TableColumn<IBusModelTableColObj,IBusModelValueObj>,TableCell<IBusModelTableColObj,IBusModelValueObj>>() {
			@Override public TableCell<IBusModelTableColObj,IBusModelValueObj> call(
				TableColumn<IBusModelTableColObj,IBusModelValueObj> arg)
			{
				return new YCFReferenceTableCell<IBusModelTableColObj,IBusModelValueObj>();
			}
		});
		dataTable.getColumns().add( tableColumnParentDataType );
		tableColumnLookupDefSchema = new TableColumn<IBusModelTableColObj, IBusModelSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<IBusModelTableColObj,IBusModelSchemaDefObj>,ObservableValue<IBusModelSchemaDefObj> >() {
			public ObservableValue<IBusModelSchemaDefObj> call( CellDataFeatures<IBusModelTableColObj, IBusModelSchemaDefObj> p ) {
				IBusModelTableColObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<IBusModelTableColObj,IBusModelSchemaDefObj>,TableCell<IBusModelTableColObj,IBusModelSchemaDefObj>>() {
			@Override public TableCell<IBusModelTableColObj,IBusModelSchemaDefObj> call(
				TableColumn<IBusModelTableColObj,IBusModelSchemaDefObj> arg)
			{
				return new YCFReferenceTableCell<IBusModelTableColObj,IBusModelSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<IBusModelTableColObj>() {
				@Override public void changed( ObservableValue<? extends IBusModelTableColObj> observable,
					IBusModelTableColObj oldValue,
					IBusModelTableColObj newValue )
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
					invokeWhenChosen.choseTableCol( null );
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
					IBusModelTableColObj selectedInstance = getJavaFXFocusAsTableCol();
					invokeWhenChosen.choseTableCol( selectedInstance );
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
		if( ( value == null ) || ( value instanceof IBusModelTableColObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IBusModelTableColObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public IBusModelTableColObj getJavaFXFocusAsTableCol() {
		return( (IBusModelTableColObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsTableCol( IBusModelTableColObj value ) {
		setJavaFXFocus( value );
	}

	public class TableColByQualNameComparator
	implements Comparator<IBusModelTableColObj>
	{
		public TableColByQualNameComparator() {
		}

		public int compare( IBusModelTableColObj lhs, IBusModelTableColObj rhs ) {
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

	protected TableColByQualNameComparator compareTableColByQualName = new TableColByQualNameComparator();

	public Collection<IBusModelTableColObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<IBusModelTableColObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfTableCol = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<IBusModelTableColObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfTableCol.add( iter.next() );
				}
				observableListOfTableCol.sort( compareTableColByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfTableCol );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public IBusModelTableObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( IBusModelTableObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		IBusModelTableColObj selectedObj = getJavaFXFocusAsTableCol();
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

