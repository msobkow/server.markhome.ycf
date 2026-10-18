// Description: Java 25 JavaFX Finder Form implementation for ISOTZone.

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
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
import server.markhome.ycf.v3_1.secure.secureobj.*;

/**
 *	SecureJavaFXISOTZoneFinderForm JavaFX Finder Form implementation
 *	for ISOTZone.
 */
public class SecureJavaFXISOTZoneFinderForm
extends YCFBorderPane
implements ISecureJavaFXISOTZonePaneCommon,
	IYCFForm
{
	public static String S_FormName = "Find ISO Timezone";
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	protected ScrollPane scrollMenu = null;
	protected YCFHBox hboxMenu = null;
	protected YCFVBox vboxMenuAdd = null;
	protected ScrollPane scrollMenuAdd = null;
	protected YCFButton buttonAdd = null;
	protected YCFButton buttonCancelAdd = null;
	protected YCFButton buttonAddISOTZone = null;
	protected YCFButton buttonViewSelected = null;
	protected YCFButton buttonEditSelected = null;
	protected YCFButton buttonClose = null;
	protected YCFButton buttonDeleteSelected = null;
	protected List<ISecureISOTZoneObj> listOfISOTZone = null;
	protected ObservableList<ISecureISOTZoneObj> observableListOfISOTZone = null;
	protected TableColumn<ISecureISOTZoneObj, Short> tableColumnISOTZoneId = null;
	protected TableColumn<ISecureISOTZoneObj, String> tableColumnIso8601 = null;
	protected TableColumn<ISecureISOTZoneObj, String> tableColumnTZName = null;
	protected TableColumn<ISecureISOTZoneObj, Short> tableColumnTZHourOffset = null;
	protected TableColumn<ISecureISOTZoneObj, Short> tableColumnTZMinOffset = null;
	protected TableColumn<ISecureISOTZoneObj, String> tableColumnDescription = null;
	protected TableColumn<ISecureISOTZoneObj, Boolean> tableColumnVisible = null;
	protected TableView<ISecureISOTZoneObj> dataTable = null;

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

	public SecureJavaFXISOTZoneFinderForm( IYCFFormManager formManager, ISecureJavaFXSchema argSchema ) {
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
		javafxSchema = argSchema;
		dataTable = new TableView<ISecureISOTZoneObj>();
		tableColumnISOTZoneId = new TableColumn<ISecureISOTZoneObj,Short>( "ISO Timezone Id" );
		tableColumnISOTZoneId.setCellValueFactory( new Callback<CellDataFeatures<ISecureISOTZoneObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<ISecureISOTZoneObj, Short> p ) {
				ISecureISOTZoneObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					short value = obj.getRequiredISOTZoneId();
					Short wrapped = Short.valueOf( value );
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnISOTZoneId.setCellFactory( new Callback<TableColumn<ISecureISOTZoneObj,Short>,TableCell<ISecureISOTZoneObj,Short>>() {
			@Override public TableCell<ISecureISOTZoneObj,Short> call(
				TableColumn<ISecureISOTZoneObj,Short> arg)
			{
				return new YCFInt16TableCell<ISecureISOTZoneObj>();
			}
		});
		dataTable.getColumns().add( tableColumnISOTZoneId );
		tableColumnIso8601 = new TableColumn<ISecureISOTZoneObj,String>( "ISO8601" );
		tableColumnIso8601.setCellValueFactory( new Callback<CellDataFeatures<ISecureISOTZoneObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ISecureISOTZoneObj, String> p ) {
				ISecureISOTZoneObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredIso8601();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnIso8601.setCellFactory( new Callback<TableColumn<ISecureISOTZoneObj,String>,TableCell<ISecureISOTZoneObj,String>>() {
			@Override public TableCell<ISecureISOTZoneObj,String> call(
				TableColumn<ISecureISOTZoneObj,String> arg)
			{
				return new YCFStringTableCell<ISecureISOTZoneObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIso8601 );
		tableColumnTZName = new TableColumn<ISecureISOTZoneObj,String>( "Timezone Name" );
		tableColumnTZName.setCellValueFactory( new Callback<CellDataFeatures<ISecureISOTZoneObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ISecureISOTZoneObj, String> p ) {
				ISecureISOTZoneObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredTZName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnTZName.setCellFactory( new Callback<TableColumn<ISecureISOTZoneObj,String>,TableCell<ISecureISOTZoneObj,String>>() {
			@Override public TableCell<ISecureISOTZoneObj,String> call(
				TableColumn<ISecureISOTZoneObj,String> arg)
			{
				return new YCFStringTableCell<ISecureISOTZoneObj>();
			}
		});
		dataTable.getColumns().add( tableColumnTZName );
		tableColumnTZHourOffset = new TableColumn<ISecureISOTZoneObj,Short>( "Timezone Hour Offset" );
		tableColumnTZHourOffset.setCellValueFactory( new Callback<CellDataFeatures<ISecureISOTZoneObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<ISecureISOTZoneObj, Short> p ) {
				ISecureISOTZoneObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					short value = obj.getRequiredTZHourOffset();
					Short wrapped = Short.valueOf( value );
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnTZHourOffset.setCellFactory( new Callback<TableColumn<ISecureISOTZoneObj,Short>,TableCell<ISecureISOTZoneObj,Short>>() {
			@Override public TableCell<ISecureISOTZoneObj,Short> call(
				TableColumn<ISecureISOTZoneObj,Short> arg)
			{
				return new YCFInt16TableCell<ISecureISOTZoneObj>();
			}
		});
		dataTable.getColumns().add( tableColumnTZHourOffset );
		tableColumnTZMinOffset = new TableColumn<ISecureISOTZoneObj,Short>( "Timezone Minute Offset" );
		tableColumnTZMinOffset.setCellValueFactory( new Callback<CellDataFeatures<ISecureISOTZoneObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<ISecureISOTZoneObj, Short> p ) {
				ISecureISOTZoneObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					short value = obj.getRequiredTZMinOffset();
					Short wrapped = Short.valueOf( value );
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnTZMinOffset.setCellFactory( new Callback<TableColumn<ISecureISOTZoneObj,Short>,TableCell<ISecureISOTZoneObj,Short>>() {
			@Override public TableCell<ISecureISOTZoneObj,Short> call(
				TableColumn<ISecureISOTZoneObj,Short> arg)
			{
				return new YCFInt16TableCell<ISecureISOTZoneObj>();
			}
		});
		dataTable.getColumns().add( tableColumnTZMinOffset );
		tableColumnDescription = new TableColumn<ISecureISOTZoneObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<ISecureISOTZoneObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ISecureISOTZoneObj, String> p ) {
				ISecureISOTZoneObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredDescription();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnDescription.setCellFactory( new Callback<TableColumn<ISecureISOTZoneObj,String>,TableCell<ISecureISOTZoneObj,String>>() {
			@Override public TableCell<ISecureISOTZoneObj,String> call(
				TableColumn<ISecureISOTZoneObj,String> arg)
			{
				return new YCFStringTableCell<ISecureISOTZoneObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnVisible = new TableColumn<ISecureISOTZoneObj,Boolean>( "Visible" );
		tableColumnVisible.setCellValueFactory( new Callback<CellDataFeatures<ISecureISOTZoneObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ISecureISOTZoneObj, Boolean> p ) {
				ISecureISOTZoneObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredVisible();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnVisible.setCellFactory( new Callback<TableColumn<ISecureISOTZoneObj,Boolean>,TableCell<ISecureISOTZoneObj,Boolean>>() {
			@Override public TableCell<ISecureISOTZoneObj,Boolean> call(
				TableColumn<ISecureISOTZoneObj,Boolean> arg)
			{
				return new YCFBoolTableCell<ISecureISOTZoneObj>();
			}
		});
		dataTable.getColumns().add( tableColumnVisible );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ISecureISOTZoneObj>() {
				@Override public void changed( ObservableValue<? extends ISecureISOTZoneObj> observable,
					ISecureISOTZoneObj oldValue,
					ISecureISOTZoneObj newValue )
				{
					setJavaFXFocus( newValue );
				}
			});

		scrollMenu = new ScrollPane();
		scrollMenu.setVbarPolicy( ScrollBarPolicy.NEVER );
		scrollMenu.setHbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollMenu.setFitToHeight( true );
		scrollMenu.setContent( getHBoxMenu() );

		setTop( scrollMenu );
		setCenter( dataTable );

		refreshMe();
		javafxIsInitializing = false;
		adjustFinderButtons();
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

	public void forceCancelAndClose() {
		if( ycfFormManager != null ) {
			if( ycfFormManager.getCurrentForm() == this ) {
				ycfFormManager.closeCurrentForm();
			}
		}
	}

	public ISecureJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
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

	public YCFHBox getHBoxMenu() {
		if( hboxMenu == null ) {
			hboxMenu = new YCFHBox( 10 );

			buttonAddISOTZone = new YCFButton();
			buttonAddISOTZone.setMinWidth( 200 );
			buttonAddISOTZone.setText( "Add ISO Timezone..." );
			buttonAddISOTZone.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						ISecureISOTZoneObj obj = (ISecureISOTZoneObj)schemaObj.getISOTZoneTableObj().newInstance();
						ISecureISOTZoneEditObj edit = (ISecureISOTZoneEditObj)( obj.beginEdit() );
						if( edit == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"edit" );
						}
						YCFBorderPane frame = javafxSchema.getISOTZoneFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
						ISecureJavaFXISOTZonePaneCommon jpanelCommon = (ISecureJavaFXISOTZonePaneCommon)frame;
						jpanelCommon.setPaneMode( YCFPane.PaneMode.Add );
						ycfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAddISOTZone );

			buttonViewSelected = new YCFButton();
			buttonViewSelected.setMinWidth( 200 );
			buttonViewSelected.setText( "View Selected" );
			buttonViewSelected.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						ISecureISOTZoneObj selectedInstance = getJavaFXFocusAsISOTZone();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = ISecureSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("Secure") && backingClassCode == ISecureISOTZone.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getISOTZoneFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ISecureJavaFXISOTZonePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ISecureISOTZoneObj" );
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
						ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						ISecureISOTZoneObj selectedInstance = getJavaFXFocusAsISOTZone();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = ISecureSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("Secure") && backingClassCode == ISecureISOTZone.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getISOTZoneFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ISecureJavaFXISOTZonePaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ISecureISOTZoneObj" );
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
						ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						ISecureISOTZoneObj selectedInstance = getJavaFXFocusAsISOTZone();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = ISecureSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("Secure") && backingClassCode == ISecureISOTZone.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getISOTZoneFactory().newAskDeleteForm( ycfFormManager, selectedInstance, getDeleteCallback() );
								((ISecureJavaFXISOTZonePaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ISecureISOTZoneObj" );
							}
						}
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonDeleteSelected );

			buttonClose = new YCFButton();
			buttonClose.setMinWidth( 200 );
			buttonClose.setText( "Close" );
			buttonClose.setOnAction( new EventHandler<ActionEvent>() {
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
			hboxMenu.getChildren().add( buttonClose );
		}
		return( hboxMenu );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ISecureISOTZoneObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureISOTZoneObj" );
		}
		adjustFinderButtons();
	}

	public ISecureISOTZoneObj getJavaFXFocusAsISOTZone() {
		return( (ISecureISOTZoneObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsISOTZone( ISecureISOTZoneObj value ) {
		setJavaFXFocus( value );
	}

	public void adjustFinderButtons() {
		ISecureISOTZoneObj selectedObj = getJavaFXFocusAsISOTZone();
		boolean disableState;
		if( selectedObj == null ) {
			disableState = true;
		}
		else {
			disableState = false;
		}
		boolean inAddMode;
		if( getLeft() == null ) {
			inAddMode = false;
		}
		else {
			inAddMode = true;
			disableState = true;
		}

		if( buttonViewSelected != null ) {
			buttonViewSelected.setDisable( disableState );
		}
		if( buttonEditSelected != null ) {
			buttonEditSelected.setDisable( disableState );
		}
		if( buttonDeleteSelected != null ) {
			buttonDeleteSelected.setDisable( disableState );
		}
		if( buttonAddISOTZone != null ) {
			buttonAddISOTZone.setDisable( false );
		}

	}

	public class ISOTZoneByQualNameComparator
	implements Comparator<ISecureISOTZoneObj>
	{
		public ISOTZoneByQualNameComparator() {
		}

		public int compare( ISecureISOTZoneObj lhs, ISecureISOTZoneObj rhs ) {
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

	protected ISOTZoneByQualNameComparator compareISOTZoneByQualName = new ISOTZoneByQualNameComparator();

	public void loadData( boolean forceReload ) {
		ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
		if( ( listOfISOTZone == null ) || forceReload ) {
			observableListOfISOTZone = null;
			listOfISOTZone = schemaObj.getISOTZoneTableObj().readAllISOTZone( javafxIsInitializing );
			if( listOfISOTZone != null ) {
				observableListOfISOTZone = FXCollections.observableArrayList( listOfISOTZone );
				observableListOfISOTZone.sort( compareISOTZoneByQualName );
			}
			else {
				observableListOfISOTZone = FXCollections.observableArrayList();
			}
			dataTable.setItems( observableListOfISOTZone );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public void refreshMe() {
		loadData( true );
	}
}
