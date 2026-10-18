// Description: Java 25 JavaFX List of Obj Pane implementation for Chain.

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
 *	BusModelJavaFXChainListPane JavaFX List of Obj Pane implementation
 *	for Chain.
 */
public class BusModelJavaFXChainListPane
extends YCFBorderPane
implements IBusModelJavaFXChainPaneList
{
	public static String S_FormName = "List Chain";
	protected IBusModelJavaFXSchema javafxSchema = null;
	protected Collection<IBusModelChainObj> javafxDataCollection = null;
	protected ObservableList<IBusModelChainObj> observableListOfChain = null;
	protected ScrollPane scrollMenu = null;
	protected YCFHBox hboxMenu = null;
	protected YCFButton buttonAddChain = null;
	protected YCFButton buttonViewSelected = null;
	protected YCFButton buttonEditSelected = null;
	protected YCFButton buttonDeleteSelected = null;
	protected TableView<IBusModelChainObj> dataTable = null;
	protected TableColumn<IBusModelChainObj, IYCFKeyHash256> tableColumnId = null;
	protected TableColumn<IBusModelChainObj, String> tableColumnName = null;
	protected TableColumn<IBusModelChainObj, String> tableColumnShortName = null;
	protected TableColumn<IBusModelChainObj, String> tableColumnLabel = null;
	protected TableColumn<IBusModelChainObj, String> tableColumnShortDescription = null;
	protected TableColumn<IBusModelChainObj, String> tableColumnDescription = null;
	protected TableColumn<IBusModelChainObj, String> tableColumnSuffix = null;
	protected TableColumn<IBusModelChainObj, IBusModelSchemaDefObj> tableColumnLookupDefSchema = null;
	protected TableColumn<IBusModelChainObj, IBusModelRelationObj> tableColumnLookupPrevRel = null;
	protected TableColumn<IBusModelChainObj, IBusModelRelationObj> tableColumnLookupNextRel = null;

	public final String S_ColumnNames[] = { "Name" };
	protected IYCFFormManager ycfFormManager = null;
	protected boolean javafxIsInitializing = true;
	protected boolean javafxSortByChain = false;
	protected IBusModelTableObj javafxContainer = null;
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


	public BusModelJavaFXChainListPane( IYCFFormManager formManager,
		IBusModelJavaFXSchema argSchema,
		IBusModelTableObj argContainer,
		IBusModelChainObj argFocus,
		Collection<IBusModelChainObj> argDataCollection,
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
		dataTable = new TableView<IBusModelChainObj>();
		tableColumnId = new TableColumn<IBusModelChainObj,IYCFKeyHash256>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<IBusModelChainObj,IYCFKeyHash256>,ObservableValue<IYCFKeyHash256> >() {
			public ObservableValue<IYCFKeyHash256> call( CellDataFeatures<IBusModelChainObj, IYCFKeyHash256> p ) {
				IBusModelChainObj obj = p.getValue();
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
		tableColumnId.setCellFactory( new Callback<TableColumn<IBusModelChainObj,IYCFKeyHash256>,TableCell<IBusModelChainObj,IYCFKeyHash256>>() {
			@Override public TableCell<IBusModelChainObj,IYCFKeyHash256> call(
				TableColumn<IBusModelChainObj,IYCFKeyHash256> arg)
			{
				return new YCFDbKeyHash256TableCell<IBusModelChainObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<IBusModelChainObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelChainObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelChainObj, String> p ) {
				IBusModelChainObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<IBusModelChainObj,String>,TableCell<IBusModelChainObj,String>>() {
			@Override public TableCell<IBusModelChainObj,String> call(
				TableColumn<IBusModelChainObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelChainObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnShortName = new TableColumn<IBusModelChainObj,String>( "Short Name" );
		tableColumnShortName.setCellValueFactory( new Callback<CellDataFeatures<IBusModelChainObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelChainObj, String> p ) {
				IBusModelChainObj obj = p.getValue();
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
		tableColumnShortName.setCellFactory( new Callback<TableColumn<IBusModelChainObj,String>,TableCell<IBusModelChainObj,String>>() {
			@Override public TableCell<IBusModelChainObj,String> call(
				TableColumn<IBusModelChainObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelChainObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortName );
		tableColumnLabel = new TableColumn<IBusModelChainObj,String>( "Label" );
		tableColumnLabel.setCellValueFactory( new Callback<CellDataFeatures<IBusModelChainObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelChainObj, String> p ) {
				IBusModelChainObj obj = p.getValue();
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
		tableColumnLabel.setCellFactory( new Callback<TableColumn<IBusModelChainObj,String>,TableCell<IBusModelChainObj,String>>() {
			@Override public TableCell<IBusModelChainObj,String> call(
				TableColumn<IBusModelChainObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelChainObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLabel );
		tableColumnShortDescription = new TableColumn<IBusModelChainObj,String>( "Short Description" );
		tableColumnShortDescription.setCellValueFactory( new Callback<CellDataFeatures<IBusModelChainObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelChainObj, String> p ) {
				IBusModelChainObj obj = p.getValue();
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
		tableColumnShortDescription.setCellFactory( new Callback<TableColumn<IBusModelChainObj,String>,TableCell<IBusModelChainObj,String>>() {
			@Override public TableCell<IBusModelChainObj,String> call(
				TableColumn<IBusModelChainObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelChainObj>();
			}
		});
		dataTable.getColumns().add( tableColumnShortDescription );
		tableColumnDescription = new TableColumn<IBusModelChainObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<IBusModelChainObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelChainObj, String> p ) {
				IBusModelChainObj obj = p.getValue();
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<IBusModelChainObj,String>,TableCell<IBusModelChainObj,String>>() {
			@Override public TableCell<IBusModelChainObj,String> call(
				TableColumn<IBusModelChainObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelChainObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnSuffix = new TableColumn<IBusModelChainObj,String>( "Suffix" );
		tableColumnSuffix.setCellValueFactory( new Callback<CellDataFeatures<IBusModelChainObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IBusModelChainObj, String> p ) {
				IBusModelChainObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalSuffix();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnSuffix.setCellFactory( new Callback<TableColumn<IBusModelChainObj,String>,TableCell<IBusModelChainObj,String>>() {
			@Override public TableCell<IBusModelChainObj,String> call(
				TableColumn<IBusModelChainObj,String> arg)
			{
				return new YCFStringTableCell<IBusModelChainObj>();
			}
		});
		dataTable.getColumns().add( tableColumnSuffix );
		tableColumnLookupDefSchema = new TableColumn<IBusModelChainObj, IBusModelSchemaDefObj>( "Defining Schema Definition" );
		tableColumnLookupDefSchema.setCellValueFactory( new Callback<CellDataFeatures<IBusModelChainObj,IBusModelSchemaDefObj>,ObservableValue<IBusModelSchemaDefObj> >() {
			public ObservableValue<IBusModelSchemaDefObj> call( CellDataFeatures<IBusModelChainObj, IBusModelSchemaDefObj> p ) {
				IBusModelChainObj obj = p.getValue();
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
		tableColumnLookupDefSchema.setCellFactory( new Callback<TableColumn<IBusModelChainObj,IBusModelSchemaDefObj>,TableCell<IBusModelChainObj,IBusModelSchemaDefObj>>() {
			@Override public TableCell<IBusModelChainObj,IBusModelSchemaDefObj> call(
				TableColumn<IBusModelChainObj,IBusModelSchemaDefObj> arg)
			{
				return new YCFReferenceTableCell<IBusModelChainObj,IBusModelSchemaDefObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupDefSchema );
		tableColumnLookupPrevRel = new TableColumn<IBusModelChainObj, IBusModelRelationObj>( "Previous Relation" );
		tableColumnLookupPrevRel.setCellValueFactory( new Callback<CellDataFeatures<IBusModelChainObj,IBusModelRelationObj>,ObservableValue<IBusModelRelationObj> >() {
			public ObservableValue<IBusModelRelationObj> call( CellDataFeatures<IBusModelChainObj, IBusModelRelationObj> p ) {
				IBusModelChainObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IBusModelRelationObj ref = obj.getRequiredLookupPrevRel();
					ReadOnlyObjectWrapper<IBusModelRelationObj> observable = new ReadOnlyObjectWrapper<IBusModelRelationObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupPrevRel.setCellFactory( new Callback<TableColumn<IBusModelChainObj,IBusModelRelationObj>,TableCell<IBusModelChainObj,IBusModelRelationObj>>() {
			@Override public TableCell<IBusModelChainObj,IBusModelRelationObj> call(
				TableColumn<IBusModelChainObj,IBusModelRelationObj> arg)
			{
				return new YCFReferenceTableCell<IBusModelChainObj,IBusModelRelationObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupPrevRel );
		tableColumnLookupNextRel = new TableColumn<IBusModelChainObj, IBusModelRelationObj>( "Next Relation" );
		tableColumnLookupNextRel.setCellValueFactory( new Callback<CellDataFeatures<IBusModelChainObj,IBusModelRelationObj>,ObservableValue<IBusModelRelationObj> >() {
			public ObservableValue<IBusModelRelationObj> call( CellDataFeatures<IBusModelChainObj, IBusModelRelationObj> p ) {
				IBusModelChainObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IBusModelRelationObj ref = obj.getRequiredLookupNextRel();
					ReadOnlyObjectWrapper<IBusModelRelationObj> observable = new ReadOnlyObjectWrapper<IBusModelRelationObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnLookupNextRel.setCellFactory( new Callback<TableColumn<IBusModelChainObj,IBusModelRelationObj>,TableCell<IBusModelChainObj,IBusModelRelationObj>>() {
			@Override public TableCell<IBusModelChainObj,IBusModelRelationObj> call(
				TableColumn<IBusModelChainObj,IBusModelRelationObj> arg)
			{
				return new YCFReferenceTableCell<IBusModelChainObj,IBusModelRelationObj>();
			}
		});
		dataTable.getColumns().add( tableColumnLookupNextRel );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<IBusModelChainObj>() {
				@Override public void changed( ObservableValue<? extends IBusModelChainObj> observable,
					IBusModelChainObj oldValue,
					IBusModelChainObj newValue )
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
		if( observableListOfChain != null ) {
			dataTable.setItems( observableListOfChain );
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
		if( ( value == null ) || ( value instanceof IBusModelChainObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IBusModelChainObj" );
		}
		adjustListButtons();
	}

	public IBusModelChainObj getJavaFXFocusAsChain() {
		return( (IBusModelChainObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsChain( IBusModelChainObj value ) {
		setJavaFXFocus( value );
	}

	public class ChainByQualNameComparator
	implements Comparator<IBusModelChainObj>
	{
		public ChainByQualNameComparator() {
		}

		public int compare( IBusModelChainObj lhs, IBusModelChainObj rhs ) {
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

	protected ChainByQualNameComparator compareChainByQualName = new ChainByQualNameComparator();

	public Collection<IBusModelChainObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<IBusModelChainObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfChain = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<IBusModelChainObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfChain.add( iter.next() );
				}
				observableListOfChain.sort( compareChainByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfChain );
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
			buttonAddChain = new YCFButton();
			buttonAddChain.setMinWidth( 200 );
			buttonAddChain.setText( "Add Chain" );
			buttonAddChain.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
						IBusModelChainObj obj = (IBusModelChainObj)schemaObj.getChainTableObj().newInstance();
						IBusModelChainEditObj edit = (IBusModelChainEditObj)( obj.beginEdit() );
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
						YCFBorderPane frame = javafxSchema.getChainFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
						IBusModelJavaFXChainPaneCommon jpanelCommon = (IBusModelJavaFXChainPaneCommon)frame;
						jpanelCommon.setJavaFXFocus( obj );
						jpanelCommon.setPaneMode( YCFPane.PaneMode.Add );
						ycfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAddChain );
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
						IBusModelChainObj selectedInstance = getJavaFXFocusAsChain();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelChain.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getChainFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((IBusModelJavaFXChainPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IBusModelChainObj" );
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
						IBusModelChainObj selectedInstance = getJavaFXFocusAsChain();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelChain.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getChainFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((IBusModelJavaFXChainPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IBusModelChainObj" );
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
						IBusModelChainObj selectedInstance = getJavaFXFocusAsChain();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelChain.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getChainFactory().newAskDeleteForm( ycfFormManager, selectedInstance, getDeleteCallback() );
								((IBusModelJavaFXChainPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IBusModelChainObj" );
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

	public IBusModelTableObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( IBusModelTableObj value ) {
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
		IBusModelChainObj selectedObj = getJavaFXFocusAsChain();
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
		if( buttonAddChain != null ) {
			buttonAddChain.setDisable( ! allowAdds );
		}

	}
}
