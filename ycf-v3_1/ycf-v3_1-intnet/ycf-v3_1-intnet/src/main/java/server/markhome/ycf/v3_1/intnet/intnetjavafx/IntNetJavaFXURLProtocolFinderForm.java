// Description: Java 25 JavaFX Finder Form implementation for URLProtocol.

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnetjavafx;

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
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;

/**
 *	IntNetJavaFXURLProtocolFinderForm JavaFX Finder Form implementation
 *	for URLProtocol.
 */
public class IntNetJavaFXURLProtocolFinderForm
extends YCFBorderPane
implements IIntNetJavaFXURLProtocolPaneCommon,
	IYCFForm
{
	public static String S_FormName = "Find URL Protocol";
	protected IYCFFormManager ycfFormManager = null;
	protected IIntNetJavaFXSchema javafxSchema = null;
	protected boolean javafxIsInitializing = true;
	protected ScrollPane scrollMenu = null;
	protected YCFHBox hboxMenu = null;
	protected YCFVBox vboxMenuAdd = null;
	protected ScrollPane scrollMenuAdd = null;
	protected YCFButton buttonAdd = null;
	protected YCFButton buttonCancelAdd = null;
	protected YCFButton buttonAddURLProtocol = null;
	protected YCFButton buttonViewSelected = null;
	protected YCFButton buttonEditSelected = null;
	protected YCFButton buttonClose = null;
	protected YCFButton buttonDeleteSelected = null;
	protected List<IIntNetURLProtocolObj> listOfURLProtocol = null;
	protected ObservableList<IIntNetURLProtocolObj> observableListOfURLProtocol = null;
	protected TableColumn<IIntNetURLProtocolObj, Integer> tableColumnURLProtocolId = null;
	protected TableColumn<IIntNetURLProtocolObj, String> tableColumnName = null;
	protected TableColumn<IIntNetURLProtocolObj, String> tableColumnDescription = null;
	protected TableColumn<IIntNetURLProtocolObj, Boolean> tableColumnIsSecure = null;
	protected TableView<IIntNetURLProtocolObj> dataTable = null;

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

	public IntNetJavaFXURLProtocolFinderForm( IYCFFormManager formManager, IIntNetJavaFXSchema argSchema ) {
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
		dataTable = new TableView<IIntNetURLProtocolObj>();
		tableColumnURLProtocolId = new TableColumn<IIntNetURLProtocolObj,Integer>( "URL Protocol Id" );
		tableColumnURLProtocolId.setCellValueFactory( new Callback<CellDataFeatures<IIntNetURLProtocolObj,Integer>,ObservableValue<Integer> >() {
			public ObservableValue<Integer> call( CellDataFeatures<IIntNetURLProtocolObj, Integer> p ) {
				IIntNetURLProtocolObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					int value = obj.getRequiredURLProtocolId();
					Integer wrapped = Integer.valueOf( value );
					ReadOnlyObjectWrapper<Integer> observable = new ReadOnlyObjectWrapper<Integer>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnURLProtocolId.setCellFactory( new Callback<TableColumn<IIntNetURLProtocolObj,Integer>,TableCell<IIntNetURLProtocolObj,Integer>>() {
			@Override public TableCell<IIntNetURLProtocolObj,Integer> call(
				TableColumn<IIntNetURLProtocolObj,Integer> arg)
			{
				return new YCFInt32TableCell<IIntNetURLProtocolObj>();
			}
		});
		dataTable.getColumns().add( tableColumnURLProtocolId );
		tableColumnName = new TableColumn<IIntNetURLProtocolObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<IIntNetURLProtocolObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IIntNetURLProtocolObj, String> p ) {
				IIntNetURLProtocolObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<IIntNetURLProtocolObj,String>,TableCell<IIntNetURLProtocolObj,String>>() {
			@Override public TableCell<IIntNetURLProtocolObj,String> call(
				TableColumn<IIntNetURLProtocolObj,String> arg)
			{
				return new YCFStringTableCell<IIntNetURLProtocolObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnDescription = new TableColumn<IIntNetURLProtocolObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<IIntNetURLProtocolObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IIntNetURLProtocolObj, String> p ) {
				IIntNetURLProtocolObj obj = p.getValue();
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<IIntNetURLProtocolObj,String>,TableCell<IIntNetURLProtocolObj,String>>() {
			@Override public TableCell<IIntNetURLProtocolObj,String> call(
				TableColumn<IIntNetURLProtocolObj,String> arg)
			{
				return new YCFStringTableCell<IIntNetURLProtocolObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		tableColumnIsSecure = new TableColumn<IIntNetURLProtocolObj,Boolean>( "IsSecure" );
		tableColumnIsSecure.setCellValueFactory( new Callback<CellDataFeatures<IIntNetURLProtocolObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<IIntNetURLProtocolObj, Boolean> p ) {
				IIntNetURLProtocolObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredIsSecure();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnIsSecure.setCellFactory( new Callback<TableColumn<IIntNetURLProtocolObj,Boolean>,TableCell<IIntNetURLProtocolObj,Boolean>>() {
			@Override public TableCell<IIntNetURLProtocolObj,Boolean> call(
				TableColumn<IIntNetURLProtocolObj,Boolean> arg)
			{
				return new YCFBoolTableCell<IIntNetURLProtocolObj>();
			}
		});
		dataTable.getColumns().add( tableColumnIsSecure );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<IIntNetURLProtocolObj>() {
				@Override public void changed( ObservableValue<? extends IIntNetURLProtocolObj> observable,
					IIntNetURLProtocolObj oldValue,
					IIntNetURLProtocolObj newValue )
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

	public IIntNetJavaFXSchema getJavaFXSchema() {
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

			buttonAddURLProtocol = new YCFButton();
			buttonAddURLProtocol.setMinWidth( 200 );
			buttonAddURLProtocol.setText( "Add URL Protocol..." );
			buttonAddURLProtocol.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						IIntNetSchemaObj schemaObj = (IIntNetSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						IIntNetURLProtocolObj obj = (IIntNetURLProtocolObj)schemaObj.getURLProtocolTableObj().newInstance();
						IIntNetURLProtocolEditObj edit = (IIntNetURLProtocolEditObj)( obj.beginEdit() );
						if( edit == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"edit" );
						}
						YCFBorderPane frame = javafxSchema.getURLProtocolFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
						IIntNetJavaFXURLProtocolPaneCommon jpanelCommon = (IIntNetJavaFXURLProtocolPaneCommon)frame;
						jpanelCommon.setPaneMode( YCFPane.PaneMode.Add );
						ycfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAddURLProtocol );

			buttonViewSelected = new YCFButton();
			buttonViewSelected.setMinWidth( 200 );
			buttonViewSelected.setText( "View Selected" );
			buttonViewSelected.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						IIntNetSchemaObj schemaObj = (IIntNetSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						IIntNetURLProtocolObj selectedInstance = getJavaFXFocusAsURLProtocol();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IIntNetSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("IntNet") && backingClassCode == IIntNetURLProtocol.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getURLProtocolFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((IIntNetJavaFXURLProtocolPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IIntNetURLProtocolObj" );
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
						IIntNetSchemaObj schemaObj = (IIntNetSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						IIntNetURLProtocolObj selectedInstance = getJavaFXFocusAsURLProtocol();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IIntNetSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("IntNet") && backingClassCode == IIntNetURLProtocol.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getURLProtocolFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((IIntNetJavaFXURLProtocolPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IIntNetURLProtocolObj" );
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
						IIntNetSchemaObj schemaObj = (IIntNetSchemaObj)javafxSchema.getSchema();
						if( schemaObj == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"schemaObj" );
						}
						IIntNetURLProtocolObj selectedInstance = getJavaFXFocusAsURLProtocol();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IIntNetSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("IntNet") && backingClassCode == IIntNetURLProtocol.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getURLProtocolFactory().newAskDeleteForm( ycfFormManager, selectedInstance, getDeleteCallback() );
								((IIntNetJavaFXURLProtocolPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IIntNetURLProtocolObj" );
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
		if( ( value == null ) || ( value instanceof IIntNetURLProtocolObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IIntNetURLProtocolObj" );
		}
		adjustFinderButtons();
	}

	public IIntNetURLProtocolObj getJavaFXFocusAsURLProtocol() {
		return( (IIntNetURLProtocolObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsURLProtocol( IIntNetURLProtocolObj value ) {
		setJavaFXFocus( value );
	}

	public void adjustFinderButtons() {
		IIntNetURLProtocolObj selectedObj = getJavaFXFocusAsURLProtocol();
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
		if( buttonAddURLProtocol != null ) {
			buttonAddURLProtocol.setDisable( false );
		}

	}

	public class URLProtocolByQualNameComparator
	implements Comparator<IIntNetURLProtocolObj>
	{
		public URLProtocolByQualNameComparator() {
		}

		public int compare( IIntNetURLProtocolObj lhs, IIntNetURLProtocolObj rhs ) {
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

	protected URLProtocolByQualNameComparator compareURLProtocolByQualName = new URLProtocolByQualNameComparator();

	public void loadData( boolean forceReload ) {
		IIntNetSchemaObj schemaObj = (IIntNetSchemaObj)javafxSchema.getSchema();
		if( ( listOfURLProtocol == null ) || forceReload ) {
			observableListOfURLProtocol = null;
			listOfURLProtocol = schemaObj.getURLProtocolTableObj().readAllURLProtocol( javafxIsInitializing );
			if( listOfURLProtocol != null ) {
				observableListOfURLProtocol = FXCollections.observableArrayList( listOfURLProtocol );
				observableListOfURLProtocol.sort( compareURLProtocolByQualName );
			}
			else {
				observableListOfURLProtocol = FXCollections.observableArrayList();
			}
			dataTable.setItems( observableListOfURLProtocol );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public void refreshMe() {
		loadData( true );
	}
}
