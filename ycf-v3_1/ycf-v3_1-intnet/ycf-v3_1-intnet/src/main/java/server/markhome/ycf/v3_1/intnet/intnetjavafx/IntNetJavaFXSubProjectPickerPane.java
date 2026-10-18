// Description: Java 25 JavaFX Picker of Obj Pane implementation for SubProject.

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
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.secure.securejavafx.*;

/**
 *	IntNetJavaFXSubProjectPickerPane JavaFX Pick Obj Pane implementation
 *	for SubProject.
 */
public class IntNetJavaFXSubProjectPickerPane
extends YCFBorderPane
implements IIntNetJavaFXSubProjectPaneList
{
	public static String S_FormName = "Choose SubProject";
	protected IIntNetJavaFXSchema javafxSchema = null;
	protected Collection<IIntNetSubProjectObj> javafxDataCollection = null;
	protected ObservableList<IIntNetSubProjectObj> observableListOfSubProject = null;
	protected TableColumn<IIntNetSubProjectObj, IYCFKeyHash256> tableColumnId = null;
	protected TableColumn<IIntNetSubProjectObj, String> tableColumnName = null;
	protected TableColumn<IIntNetSubProjectObj, String> tableColumnDescription = null;
	protected TableView<IIntNetSubProjectObj> dataTable = null;
	protected YCFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected IYCFFormManager ycfFormManager = null;
	protected IIntNetJavaFXSubProjectChosen invokeWhenChosen = null;
	protected IIntNetTopProjectObj javafxContainer = null;
	protected YCFButton buttonCancel = null;
	protected YCFButton buttonChooseNone = null;
	protected YCFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public IntNetJavaFXSubProjectPickerPane( IYCFFormManager formManager,
		IIntNetJavaFXSchema argSchema,
		IIntNetSubProjectObj argFocus,
		IIntNetTopProjectObj argContainer,
		Collection<IIntNetSubProjectObj> argDataCollection,
		IIntNetJavaFXSubProjectChosen whenChosen )
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
		dataTable = new TableView<IIntNetSubProjectObj>();
		tableColumnId = new TableColumn<IIntNetSubProjectObj,IYCFKeyHash256>( "Id" );
		tableColumnId.setCellValueFactory( new Callback<CellDataFeatures<IIntNetSubProjectObj,IYCFKeyHash256>,ObservableValue<IYCFKeyHash256> >() {
			public ObservableValue<IYCFKeyHash256> call( CellDataFeatures<IIntNetSubProjectObj, IYCFKeyHash256> p ) {
				IIntNetSubProjectObj obj = p.getValue();
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
		tableColumnId.setCellFactory( new Callback<TableColumn<IIntNetSubProjectObj,IYCFKeyHash256>,TableCell<IIntNetSubProjectObj,IYCFKeyHash256>>() {
			@Override public TableCell<IIntNetSubProjectObj,IYCFKeyHash256> call(
				TableColumn<IIntNetSubProjectObj,IYCFKeyHash256> arg)
			{
				return new YCFDbKeyHash256TableCell<IIntNetSubProjectObj>();
			}
		});
		dataTable.getColumns().add( tableColumnId );
		tableColumnName = new TableColumn<IIntNetSubProjectObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<IIntNetSubProjectObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IIntNetSubProjectObj, String> p ) {
				IIntNetSubProjectObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<IIntNetSubProjectObj,String>,TableCell<IIntNetSubProjectObj,String>>() {
			@Override public TableCell<IIntNetSubProjectObj,String> call(
				TableColumn<IIntNetSubProjectObj,String> arg)
			{
				return new YCFStringTableCell<IIntNetSubProjectObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnDescription = new TableColumn<IIntNetSubProjectObj,String>( "Description" );
		tableColumnDescription.setCellValueFactory( new Callback<CellDataFeatures<IIntNetSubProjectObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<IIntNetSubProjectObj, String> p ) {
				IIntNetSubProjectObj obj = p.getValue();
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
		tableColumnDescription.setCellFactory( new Callback<TableColumn<IIntNetSubProjectObj,String>,TableCell<IIntNetSubProjectObj,String>>() {
			@Override public TableCell<IIntNetSubProjectObj,String> call(
				TableColumn<IIntNetSubProjectObj,String> arg)
			{
				return new YCFStringTableCell<IIntNetSubProjectObj>();
			}
		});
		dataTable.getColumns().add( tableColumnDescription );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<IIntNetSubProjectObj>() {
				@Override public void changed( ObservableValue<? extends IIntNetSubProjectObj> observable,
					IIntNetSubProjectObj oldValue,
					IIntNetSubProjectObj newValue )
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
					IIntNetSchemaObj schemaObj = (IIntNetSchemaObj)javafxSchema.getSchema();
					if( schemaObj == null ) {
						throw new YCFLibNullArgumentException( getClass(),
							S_ProcName,
							0,
							"schemaObj" );
					}
					invokeWhenChosen.choseSubProject( null );
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
					IIntNetSchemaObj schemaObj = (IIntNetSchemaObj)javafxSchema.getSchema();
					if( schemaObj == null ) {
						throw new YCFLibNullArgumentException( getClass(),
							S_ProcName,
							0,
							"schemaObj" );
					}
					IIntNetSubProjectObj selectedInstance = getJavaFXFocusAsSubProject();
					invokeWhenChosen.choseSubProject( selectedInstance );
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

	public IIntNetJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof IIntNetSubProjectObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IIntNetSubProjectObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public IIntNetSubProjectObj getJavaFXFocusAsSubProject() {
		return( (IIntNetSubProjectObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSubProject( IIntNetSubProjectObj value ) {
		setJavaFXFocus( value );
	}

	public class SubProjectByQualNameComparator
	implements Comparator<IIntNetSubProjectObj>
	{
		public SubProjectByQualNameComparator() {
		}

		public int compare( IIntNetSubProjectObj lhs, IIntNetSubProjectObj rhs ) {
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

	protected SubProjectByQualNameComparator compareSubProjectByQualName = new SubProjectByQualNameComparator();

	public Collection<IIntNetSubProjectObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<IIntNetSubProjectObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfSubProject = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<IIntNetSubProjectObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfSubProject.add( iter.next() );
				}
				observableListOfSubProject.sort( compareSubProjectByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfSubProject );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public IIntNetTopProjectObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( IIntNetTopProjectObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		IIntNetSubProjectObj selectedObj = getJavaFXFocusAsSubProject();
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

