// Description: Java 25 JavaFX Picker of Obj Pane implementation for SecSysGrp.

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
import server.markhome.ycf.v3_1.secure.secureobj.*;

/**
 *	SecureJavaFXSecSysGrpPickerPane JavaFX Pick Obj Pane implementation
 *	for SecSysGrp.
 */
public class SecureJavaFXSecSysGrpPickerPane
extends YCFBorderPane
implements ISecureJavaFXSecSysGrpPaneList
{
	public static String S_FormName = "Choose System Security Group";
	protected ISecureJavaFXSchema javafxSchema = null;
	protected Collection<ISecureSecSysGrpObj> javafxDataCollection = null;
	protected ObservableList<ISecureSecSysGrpObj> observableListOfSecSysGrp = null;
	protected TableColumn<ISecureSecSysGrpObj, IYCFKeyHash256> tableColumnSecSysGrpId = null;
	protected TableColumn<ISecureSecSysGrpObj, String> tableColumnName = null;
	protected TableColumn<ISecureSecSysGrpObj, ISecurePubSchema.SecLevelEnum> tableColumnSecLevel = null;
	protected TableView<ISecureSecSysGrpObj> dataTable = null;
	protected YCFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSecSysGrpChosen invokeWhenChosen = null;
	protected IYCFLibAnyObj javafxContainer = null;
	protected YCFButton buttonCancel = null;
	protected YCFButton buttonChooseNone = null;
	protected YCFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public SecureJavaFXSecSysGrpPickerPane( IYCFFormManager formManager,
		ISecureJavaFXSchema argSchema,
		ISecureSecSysGrpObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<ISecureSecSysGrpObj> argDataCollection,
		ISecureJavaFXSecSysGrpChosen whenChosen )
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
		dataTable = new TableView<ISecureSecSysGrpObj>();
		tableColumnSecSysGrpId = new TableColumn<ISecureSecSysGrpObj,IYCFKeyHash256>( "System Security Group Id" );
		tableColumnSecSysGrpId.setCellValueFactory( new Callback<CellDataFeatures<ISecureSecSysGrpObj,IYCFKeyHash256>,ObservableValue<IYCFKeyHash256> >() {
			public ObservableValue<IYCFKeyHash256> call( CellDataFeatures<ISecureSecSysGrpObj, IYCFKeyHash256> p ) {
				ISecureSecSysGrpObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IYCFKeyHash256 value = obj.getRequiredSecSysGrpId();
					ReadOnlyObjectWrapper<IYCFKeyHash256> observable = new ReadOnlyObjectWrapper<IYCFKeyHash256>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnSecSysGrpId.setCellFactory( new Callback<TableColumn<ISecureSecSysGrpObj,IYCFKeyHash256>,TableCell<ISecureSecSysGrpObj,IYCFKeyHash256>>() {
			@Override public TableCell<ISecureSecSysGrpObj,IYCFKeyHash256> call(
				TableColumn<ISecureSecSysGrpObj,IYCFKeyHash256> arg)
			{
				return new YCFDbKeyHash256TableCell<ISecureSecSysGrpObj>();
			}
		});
		dataTable.getColumns().add( tableColumnSecSysGrpId );
		tableColumnName = new TableColumn<ISecureSecSysGrpObj,String>( "Name" );
		tableColumnName.setCellValueFactory( new Callback<CellDataFeatures<ISecureSecSysGrpObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ISecureSecSysGrpObj, String> p ) {
				ISecureSecSysGrpObj obj = p.getValue();
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
		tableColumnName.setCellFactory( new Callback<TableColumn<ISecureSecSysGrpObj,String>,TableCell<ISecureSecSysGrpObj,String>>() {
			@Override public TableCell<ISecureSecSysGrpObj,String> call(
				TableColumn<ISecureSecSysGrpObj,String> arg)
			{
				return new YCFStringTableCell<ISecureSecSysGrpObj>();
			}
		});
		dataTable.getColumns().add( tableColumnName );
		tableColumnSecLevel = new TableColumn<ISecureSecSysGrpObj,ISecurePubSchema.SecLevelEnum>( "Group Level" );
		tableColumnSecLevel.setCellValueFactory( new Callback<CellDataFeatures<ISecureSecSysGrpObj,ISecurePubSchema.SecLevelEnum>,ObservableValue<ISecurePubSchema.SecLevelEnum> >() {
			public ObservableValue<ISecurePubSchema.SecLevelEnum> call( CellDataFeatures<ISecureSecSysGrpObj, ISecurePubSchema.SecLevelEnum> p ) {
				ISecureSecSysGrpObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ISecurePubSchema.SecLevelEnum value = obj.getRequiredSecLevel();
					ReadOnlyObjectWrapper<ISecurePubSchema.SecLevelEnum> observable = new ReadOnlyObjectWrapper<ISecurePubSchema.SecLevelEnum>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnSecLevel.setCellFactory( new Callback<TableColumn<ISecureSecSysGrpObj,ISecurePubSchema.SecLevelEnum>,TableCell<ISecureSecSysGrpObj,ISecurePubSchema.SecLevelEnum>>() {
			@Override public TableCell<ISecureSecSysGrpObj,ISecurePubSchema.SecLevelEnum> call(
				TableColumn<ISecureSecSysGrpObj,ISecurePubSchema.SecLevelEnum> arg)
			{
				return new YCFEnumTableCell<ISecureSecSysGrpObj,ISecureSchema.SecLevelEnum>();
			}
		});
		dataTable.getColumns().add( tableColumnSecLevel );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ISecureSecSysGrpObj>() {
				@Override public void changed( ObservableValue<? extends ISecureSecSysGrpObj> observable,
					ISecureSecSysGrpObj oldValue,
					ISecureSecSysGrpObj newValue )
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
					ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
					if( schemaObj == null ) {
						throw new YCFLibNullArgumentException( getClass(),
							S_ProcName,
							0,
							"schemaObj" );
					}
					invokeWhenChosen.choseSecSysGrp( null );
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
					ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
					if( schemaObj == null ) {
						throw new YCFLibNullArgumentException( getClass(),
							S_ProcName,
							0,
							"schemaObj" );
					}
					ISecureSecSysGrpObj selectedInstance = getJavaFXFocusAsSecSysGrp();
					invokeWhenChosen.choseSecSysGrp( selectedInstance );
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

	public ISecureJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ISecureSecSysGrpObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecSysGrpObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ISecureSecSysGrpObj getJavaFXFocusAsSecSysGrp() {
		return( (ISecureSecSysGrpObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSecSysGrp( ISecureSecSysGrpObj value ) {
		setJavaFXFocus( value );
	}

	public class SecSysGrpByQualNameComparator
	implements Comparator<ISecureSecSysGrpObj>
	{
		public SecSysGrpByQualNameComparator() {
		}

		public int compare( ISecureSecSysGrpObj lhs, ISecureSecSysGrpObj rhs ) {
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

	protected SecSysGrpByQualNameComparator compareSecSysGrpByQualName = new SecSysGrpByQualNameComparator();

	public Collection<ISecureSecSysGrpObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ISecureSecSysGrpObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfSecSysGrp = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ISecureSecSysGrpObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfSecSysGrp.add( iter.next() );
				}
				observableListOfSecSysGrp.sort( compareSecSysGrpByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfSecSysGrp );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public IYCFLibAnyObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( IYCFLibAnyObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ISecureSecSysGrpObj selectedObj = getJavaFXFocusAsSecSysGrp();
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

