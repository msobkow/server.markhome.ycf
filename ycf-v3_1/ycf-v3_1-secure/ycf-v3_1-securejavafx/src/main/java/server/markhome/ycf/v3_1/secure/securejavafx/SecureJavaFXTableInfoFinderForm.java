// Description: Java 25 JavaFX Finder Form implementation for TableInfo.

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
 *	SecureJavaFXTableInfoFinderForm JavaFX Finder Form implementation
 *	for TableInfo.
 */
public class SecureJavaFXTableInfoFinderForm
extends YCFBorderPane
implements ISecureJavaFXTableInfoPaneCommon,
	IYCFForm
{
	public static String S_FormName = "Find Table Information";
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	protected ScrollPane scrollMenu = null;
	protected YCFHBox hboxMenu = null;
	protected YCFVBox vboxMenuAdd = null;
	protected ScrollPane scrollMenuAdd = null;
	protected YCFButton buttonAdd = null;
	protected YCFButton buttonCancelAdd = null;
	protected YCFButton buttonAddTableInfo = null;
	protected YCFButton buttonViewSelected = null;
	protected YCFButton buttonEditSelected = null;
	protected YCFButton buttonClose = null;
	protected YCFButton buttonDeleteSelected = null;
	protected List<ISecureTableInfoObj> listOfTableInfo = null;
	protected ObservableList<ISecureTableInfoObj> observableListOfTableInfo = null;
	protected TableColumn<ISecureTableInfoObj, Integer> tableColumnTableInfoId = null;
	protected TableColumn<ISecureTableInfoObj, String> tableColumnSchemaName = null;
	protected TableColumn<ISecureTableInfoObj, String> tableColumnTableName = null;
	protected TableColumn<ISecureTableInfoObj, Integer> tableColumnBackingClassCode = null;
	protected TableColumn<ISecureTableInfoObj, Integer> tableColumnRuntimeClassCode = null;
	protected TableColumn<ISecureTableInfoObj, Boolean> tableColumnHasHistory = null;
	protected TableColumn<ISecureTableInfoObj, Boolean> tableColumnIsMutable = null;
	protected TableColumn<ISecureTableInfoObj, String> tableColumnSecScopeName = null;
	protected TableColumn<ISecureTableInfoObj, String> tableColumnCodeVis = null;
	protected TableColumn<ISecureTableInfoObj, ISecureTableInfoObj> tableColumnParentSuperRef = null;
	protected TableView<ISecureTableInfoObj> dataTable = null;

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

	public SecureJavaFXTableInfoFinderForm( IYCFFormManager formManager, ISecureJavaFXSchema argSchema ) {
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
		dataTable = new TableView<ISecureTableInfoObj>();
		tableColumnTableInfoId = new TableColumn<ISecureTableInfoObj,Integer>( "TableInfoId" );
		tableColumnTableInfoId.setCellValueFactory( new Callback<CellDataFeatures<ISecureTableInfoObj,Integer>,ObservableValue<Integer> >() {
			public ObservableValue<Integer> call( CellDataFeatures<ISecureTableInfoObj, Integer> p ) {
				ISecureTableInfoObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					int value = obj.getRequiredTableInfoId();
					Integer wrapped = Integer.valueOf( value );
					ReadOnlyObjectWrapper<Integer> observable = new ReadOnlyObjectWrapper<Integer>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnTableInfoId.setCellFactory( new Callback<TableColumn<ISecureTableInfoObj,Integer>,TableCell<ISecureTableInfoObj,Integer>>() {
			@Override public TableCell<ISecureTableInfoObj,Integer> call(
				TableColumn<ISecureTableInfoObj,Integer> arg)
			{
				return new YCFInt32TableCell<ISecureTableInfoObj>();
			}
		});
		dataTable.getColumns().add( tableColumnTableInfoId );
		tableColumnSchemaName = new TableColumn<ISecureTableInfoObj,String>( "SchemaName" );
		tableColumnSchemaName.setCellValueFactory( new Callback<CellDataFeatures<ISecureTableInfoObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ISecureTableInfoObj, String> p ) {
				ISecureTableInfoObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredSchemaName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnSchemaName.setCellFactory( new Callback<TableColumn<ISecureTableInfoObj,String>,TableCell<ISecureTableInfoObj,String>>() {
			@Override public TableCell<ISecureTableInfoObj,String> call(
				TableColumn<ISecureTableInfoObj,String> arg)
			{
				return new YCFStringTableCell<ISecureTableInfoObj>();
			}
		});
		dataTable.getColumns().add( tableColumnSchemaName );
		tableColumnTableName = new TableColumn<ISecureTableInfoObj,String>( "TableName" );
		tableColumnTableName.setCellValueFactory( new Callback<CellDataFeatures<ISecureTableInfoObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ISecureTableInfoObj, String> p ) {
				ISecureTableInfoObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredTableName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnTableName.setCellFactory( new Callback<TableColumn<ISecureTableInfoObj,String>,TableCell<ISecureTableInfoObj,String>>() {
			@Override public TableCell<ISecureTableInfoObj,String> call(
				TableColumn<ISecureTableInfoObj,String> arg)
			{
				return new YCFStringTableCell<ISecureTableInfoObj>();
			}
		});
		dataTable.getColumns().add( tableColumnTableName );
		tableColumnBackingClassCode = new TableColumn<ISecureTableInfoObj,Integer>( "BackingClassCode" );
		tableColumnBackingClassCode.setCellValueFactory( new Callback<CellDataFeatures<ISecureTableInfoObj,Integer>,ObservableValue<Integer> >() {
			public ObservableValue<Integer> call( CellDataFeatures<ISecureTableInfoObj, Integer> p ) {
				ISecureTableInfoObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					int value = obj.getRequiredBackingClassCode();
					Integer wrapped = Integer.valueOf( value );
					ReadOnlyObjectWrapper<Integer> observable = new ReadOnlyObjectWrapper<Integer>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnBackingClassCode.setCellFactory( new Callback<TableColumn<ISecureTableInfoObj,Integer>,TableCell<ISecureTableInfoObj,Integer>>() {
			@Override public TableCell<ISecureTableInfoObj,Integer> call(
				TableColumn<ISecureTableInfoObj,Integer> arg)
			{
				return new YCFInt32TableCell<ISecureTableInfoObj>();
			}
		});
		dataTable.getColumns().add( tableColumnBackingClassCode );
		tableColumnRuntimeClassCode = new TableColumn<ISecureTableInfoObj,Integer>( "RuntimeClassCode" );
		tableColumnRuntimeClassCode.setCellValueFactory( new Callback<CellDataFeatures<ISecureTableInfoObj,Integer>,ObservableValue<Integer> >() {
			public ObservableValue<Integer> call( CellDataFeatures<ISecureTableInfoObj, Integer> p ) {
				ISecureTableInfoObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					int value = obj.getRequiredRuntimeClassCode();
					Integer wrapped = Integer.valueOf( value );
					ReadOnlyObjectWrapper<Integer> observable = new ReadOnlyObjectWrapper<Integer>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnRuntimeClassCode.setCellFactory( new Callback<TableColumn<ISecureTableInfoObj,Integer>,TableCell<ISecureTableInfoObj,Integer>>() {
			@Override public TableCell<ISecureTableInfoObj,Integer> call(
				TableColumn<ISecureTableInfoObj,Integer> arg)
			{
				return new YCFInt32TableCell<ISecureTableInfoObj>();
			}
		});
		dataTable.getColumns().add( tableColumnRuntimeClassCode );
		tableColumnHasHistory = new TableColumn<ISecureTableInfoObj,Boolean>( "HasHistory" );
		tableColumnHasHistory.setCellValueFactory( new Callback<CellDataFeatures<ISecureTableInfoObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ISecureTableInfoObj, Boolean> p ) {
				ISecureTableInfoObj obj = p.getValue();
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
		tableColumnHasHistory.setCellFactory( new Callback<TableColumn<ISecureTableInfoObj,Boolean>,TableCell<ISecureTableInfoObj,Boolean>>() {
			@Override public TableCell<ISecureTableInfoObj,Boolean> call(
				TableColumn<ISecureTableInfoObj,Boolean> arg)
			{
				return new YCFBoolTableCell<ISecureTableInfoObj>();
			}
		});
		dataTable.getColumns().add( tableColumnHasHistory );
		tableColumnIsMutable = new TableColumn<ISecureTableInfoObj,Boolean>( "IsMutable" );
		tableColumnIsMutable.setCellValueFactory( new Callback<CellDataFeatures<ISecureTableInfoObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ISecureTableInfoObj, Boolean> p ) {
				ISecureTableInfoObj obj = p.getValue();
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
		tableColumnIsMutable.setCellFactory( new Callback<TableColumn<ISecureTableInfoObj,Boolean>,TableCell<ISecureTableInfoObj,Boolean>>() {
			@Override public TableCell<ISecureTableInfoObj,Boolean> call(
				TableColumn<ISecureTableInfoObj,Boolean> arg)
			{
				return new YCFBoolTableCell<ISecureTableInfoObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsMutable );
		tableColumnSecScopeName = new TableColumn<ISecureTableInfoObj,String>( "SecScopeName" );
		tableColumnSecScopeName.setCellValueFactory( new Callback<CellDataFeatures<ISecureTableInfoObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ISecureTableInfoObj, String> p ) {
				ISecureTableInfoObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredSecScopeName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnSecScopeName.setCellFactory( new Callback<TableColumn<ISecureTableInfoObj,String>,TableCell<ISecureTableInfoObj,String>>() {
			@Override public TableCell<ISecureTableInfoObj,String> call(
				TableColumn<ISecureTableInfoObj,String> arg)
			{
				return new YCFStringTableCell<ISecureTableInfoObj>();
			}
		});
		dataTable.getColumns().add( tableColumnSecScopeName );
		tableColumnCodeVis = new TableColumn<ISecureTableInfoObj,String>( "CodeVis" );
		tableColumnCodeVis.setCellValueFactory( new Callback<CellDataFeatures<ISecureTableInfoObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ISecureTableInfoObj, String> p ) {
				ISecureTableInfoObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredCodeVis();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnCodeVis.setCellFactory( new Callback<TableColumn<ISecureTableInfoObj,String>,TableCell<ISecureTableInfoObj,String>>() {
			@Override public TableCell<ISecureTableInfoObj,String> call(
				TableColumn<ISecureTableInfoObj,String> arg)
			{
				return new YCFStringTableCell<ISecureTableInfoObj>();
			}
		});
		dataTable.getColumns().add( tableColumnCodeVis );
		tableColumnParentSuperRef = new TableColumn<ISecureTableInfoObj, ISecureTableInfoObj>( "Superclass Table Reference" );
		tableColumnParentSuperRef.setCellValueFactory( new Callback<CellDataFeatures<ISecureTableInfoObj,ISecureTableInfoObj>,ObservableValue<ISecureTableInfoObj> >() {
			public ObservableValue<ISecureTableInfoObj> call( CellDataFeatures<ISecureTableInfoObj, ISecureTableInfoObj> p ) {
				ISecureTableInfoObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ISecureTableInfoObj ref = obj.getOptionalParentSuperRef();
					ReadOnlyObjectWrapper<ISecureTableInfoObj> observable = new ReadOnlyObjectWrapper<ISecureTableInfoObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnParentSuperRef.setCellFactory( new Callback<TableColumn<ISecureTableInfoObj,ISecureTableInfoObj>,TableCell<ISecureTableInfoObj,ISecureTableInfoObj>>() {
			@Override public TableCell<ISecureTableInfoObj,ISecureTableInfoObj> call(
				TableColumn<ISecureTableInfoObj,ISecureTableInfoObj> arg)
			{
				return new YCFReferenceTableCell<ISecureTableInfoObj,ISecureTableInfoObj>();
			}
		});
		dataTable.getColumns().add( tableColumnParentSuperRef );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ISecureTableInfoObj>() {
				@Override public void changed( ObservableValue<? extends ISecureTableInfoObj> observable,
					ISecureTableInfoObj oldValue,
					ISecureTableInfoObj newValue )
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

			buttonAddTableInfo = new YCFButton();
			buttonAddTableInfo.setMinWidth( 200 );
			buttonAddTableInfo.setText( "Add Table Information..." );
			buttonAddTableInfo.setOnAction( new EventHandler<ActionEvent>() {
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
						ISecureTableInfoObj obj = (ISecureTableInfoObj)schemaObj.getTableInfoTableObj().newInstance();
						ISecureTableInfoEditObj edit = (ISecureTableInfoEditObj)( obj.beginEdit() );
						if( edit == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"edit" );
						}
						YCFBorderPane frame = javafxSchema.getTableInfoFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
						ISecureJavaFXTableInfoPaneCommon jpanelCommon = (ISecureJavaFXTableInfoPaneCommon)frame;
						jpanelCommon.setPaneMode( YCFPane.PaneMode.Add );
						ycfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAddTableInfo );

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
						ISecureTableInfoObj selectedInstance = getJavaFXFocusAsTableInfo();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = ISecureSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("Secure") && backingClassCode == ISecureTableInfo.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getTableInfoFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ISecureJavaFXTableInfoPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ISecureTableInfoObj" );
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
						ISecureTableInfoObj selectedInstance = getJavaFXFocusAsTableInfo();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = ISecureSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("Secure") && backingClassCode == ISecureTableInfo.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getTableInfoFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ISecureJavaFXTableInfoPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ISecureTableInfoObj" );
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
						ISecureTableInfoObj selectedInstance = getJavaFXFocusAsTableInfo();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = ISecureSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("Secure") && backingClassCode == ISecureTableInfo.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getTableInfoFactory().newAskDeleteForm( ycfFormManager, selectedInstance, getDeleteCallback() );
								((ISecureJavaFXTableInfoPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ISecureTableInfoObj" );
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
		if( ( value == null ) || ( value instanceof ISecureTableInfoObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureTableInfoObj" );
		}
		adjustFinderButtons();
	}

	public ISecureTableInfoObj getJavaFXFocusAsTableInfo() {
		return( (ISecureTableInfoObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsTableInfo( ISecureTableInfoObj value ) {
		setJavaFXFocus( value );
	}

	public void adjustFinderButtons() {
		ISecureTableInfoObj selectedObj = getJavaFXFocusAsTableInfo();
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
		if( buttonAddTableInfo != null ) {
			buttonAddTableInfo.setDisable( false );
		}

	}

	public class TableInfoByQualNameComparator
	implements Comparator<ISecureTableInfoObj>
	{
		public TableInfoByQualNameComparator() {
		}

		public int compare( ISecureTableInfoObj lhs, ISecureTableInfoObj rhs ) {
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

	protected TableInfoByQualNameComparator compareTableInfoByQualName = new TableInfoByQualNameComparator();

	public void loadData( boolean forceReload ) {
		ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
		if( ( listOfTableInfo == null ) || forceReload ) {
			observableListOfTableInfo = null;
			listOfTableInfo = schemaObj.getTableInfoTableObj().readAllTableInfo( javafxIsInitializing );
			if( listOfTableInfo != null ) {
				observableListOfTableInfo = FXCollections.observableArrayList( listOfTableInfo );
				observableListOfTableInfo.sort( compareTableInfoByQualName );
			}
			else {
				observableListOfTableInfo = FXCollections.observableArrayList();
			}
			dataTable.setItems( observableListOfTableInfo );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public void refreshMe() {
		loadData( true );
	}
}
