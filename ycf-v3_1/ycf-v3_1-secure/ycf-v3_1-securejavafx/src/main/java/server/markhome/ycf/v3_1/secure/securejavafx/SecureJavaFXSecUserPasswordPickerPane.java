// Description: Java 25 JavaFX Picker of Obj Pane implementation for SecUserPassword.

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
 *	SecureJavaFXSecUserPasswordPickerPane JavaFX Pick Obj Pane implementation
 *	for SecUserPassword.
 */
public class SecureJavaFXSecUserPasswordPickerPane
extends YCFBorderPane
implements ISecureJavaFXSecUserPasswordPaneList
{
	public static String S_FormName = "Choose Security User Password";
	protected ISecureJavaFXSchema javafxSchema = null;
	protected Collection<ISecureSecUserPasswordObj> javafxDataCollection = null;
	protected ObservableList<ISecureSecUserPasswordObj> observableListOfSecUserPassword = null;
	protected TableColumn<ISecureSecUserPasswordObj, LocalDateTime> tableColumnPWSetStamp = null;
	protected TableColumn<ISecureSecUserPasswordObj, String> tableColumnPasswordHash = null;
	protected TableView<ISecureSecUserPasswordObj> dataTable = null;
	protected YCFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSecUserPasswordChosen invokeWhenChosen = null;
	protected ISecureSecUserObj javafxContainer = null;
	protected YCFButton buttonCancel = null;
	protected YCFButton buttonChooseNone = null;
	protected YCFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public SecureJavaFXSecUserPasswordPickerPane( IYCFFormManager formManager,
		ISecureJavaFXSchema argSchema,
		ISecureSecUserPasswordObj argFocus,
		ISecureSecUserObj argContainer,
		Collection<ISecureSecUserPasswordObj> argDataCollection,
		ISecureJavaFXSecUserPasswordChosen whenChosen )
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
		dataTable = new TableView<ISecureSecUserPasswordObj>();
		tableColumnPWSetStamp = new TableColumn<ISecureSecUserPasswordObj,LocalDateTime>( "Password set at" );
		tableColumnPWSetStamp.setCellValueFactory( new Callback<CellDataFeatures<ISecureSecUserPasswordObj,LocalDateTime>,ObservableValue<LocalDateTime> >() {
			public ObservableValue<LocalDateTime> call( CellDataFeatures<ISecureSecUserPasswordObj, LocalDateTime> p ) {
				ISecureSecUserPasswordObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					LocalDateTime value = obj.getRequiredPWSetStamp();
					ReadOnlyObjectWrapper<LocalDateTime> observable = new ReadOnlyObjectWrapper<LocalDateTime>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnPWSetStamp.setCellFactory( new Callback<TableColumn<ISecureSecUserPasswordObj,LocalDateTime>,TableCell<ISecureSecUserPasswordObj,LocalDateTime>>() {
			@Override public TableCell<ISecureSecUserPasswordObj,LocalDateTime> call(
				TableColumn<ISecureSecUserPasswordObj,LocalDateTime> arg)
			{
				return new YCFTimestampTableCell<ISecureSecUserPasswordObj>();
			}
		});
		dataTable.getColumns().add( tableColumnPWSetStamp );
		tableColumnPasswordHash = new TableColumn<ISecureSecUserPasswordObj,String>( "Password Hash" );
		tableColumnPasswordHash.setCellValueFactory( new Callback<CellDataFeatures<ISecureSecUserPasswordObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ISecureSecUserPasswordObj, String> p ) {
				ISecureSecUserPasswordObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredPasswordHash();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnPasswordHash.setCellFactory( new Callback<TableColumn<ISecureSecUserPasswordObj,String>,TableCell<ISecureSecUserPasswordObj,String>>() {
			@Override public TableCell<ISecureSecUserPasswordObj,String> call(
				TableColumn<ISecureSecUserPasswordObj,String> arg)
			{
				return new YCFStringTableCell<ISecureSecUserPasswordObj>();
			}
		});
		dataTable.getColumns().add( tableColumnPasswordHash );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ISecureSecUserPasswordObj>() {
				@Override public void changed( ObservableValue<? extends ISecureSecUserPasswordObj> observable,
					ISecureSecUserPasswordObj oldValue,
					ISecureSecUserPasswordObj newValue )
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
					invokeWhenChosen.choseSecUserPassword( null );
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
					ISecureSecUserPasswordObj selectedInstance = getJavaFXFocusAsSecUserPassword();
					invokeWhenChosen.choseSecUserPassword( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ISecureSecUserPasswordObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecUserPasswordObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ISecureSecUserPasswordObj getJavaFXFocusAsSecUserPassword() {
		return( (ISecureSecUserPasswordObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSecUserPassword( ISecureSecUserPasswordObj value ) {
		setJavaFXFocus( value );
	}

	public class SecUserPasswordByQualNameComparator
	implements Comparator<ISecureSecUserPasswordObj>
	{
		public SecUserPasswordByQualNameComparator() {
		}

		public int compare( ISecureSecUserPasswordObj lhs, ISecureSecUserPasswordObj rhs ) {
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

	protected SecUserPasswordByQualNameComparator compareSecUserPasswordByQualName = new SecUserPasswordByQualNameComparator();

	public Collection<ISecureSecUserPasswordObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ISecureSecUserPasswordObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfSecUserPassword = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ISecureSecUserPasswordObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfSecUserPassword.add( iter.next() );
				}
				observableListOfSecUserPassword.sort( compareSecUserPasswordByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfSecUserPassword );
			// Hack from stackoverflow to fix JavaFX TableView refresh issue
			((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
			((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
		}
	}

	public ISecureSecUserObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ISecureSecUserObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ISecureSecUserPasswordObj selectedObj = getJavaFXFocusAsSecUserPassword();
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

