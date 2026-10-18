// Description: Java 25 JavaFX Picker of Obj Pane implementation for SecUserPWReset.

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
 *	SecureJavaFXSecUserPWResetPickerPane JavaFX Pick Obj Pane implementation
 *	for SecUserPWReset.
 */
public class SecureJavaFXSecUserPWResetPickerPane
extends YCFBorderPane
implements ISecureJavaFXSecUserPWResetPaneList
{
	public static String S_FormName = "Choose Password Reset";
	protected ISecureJavaFXSchema javafxSchema = null;
	protected ISecureJavaFXSecUserPWResetPageCallback pageCallback;
	protected YCFButton buttonRefresh = null;
	protected YCFButton buttonMoreData = null;
	protected boolean endOfData = true;
	protected ObservableList<ISecureSecUserPWResetObj> observableListOfSecUserPWReset = null;
	protected TableColumn<ISecureSecUserPWResetObj, String> tableColumnSentToEMailAddr = null;
	protected TableColumn<ISecureSecUserPWResetObj, IYCFUuid6> tableColumnPasswordResetUuid6 = null;
	protected TableColumn<ISecureSecUserPWResetObj, Boolean> tableColumnNewAccount = null;
	protected TableView<ISecureSecUserPWResetObj> dataTable = null;
	protected YCFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSecUserPWResetChosen invokeWhenChosen = null;
	protected ISecureSecUserObj javafxContainer = null;
	protected YCFButton buttonCancel = null;
	protected YCFButton buttonChooseNone = null;
	protected YCFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public SecureJavaFXSecUserPWResetPickerPane( IYCFFormManager formManager,
		ISecureJavaFXSchema argSchema,
		ISecureSecUserPWResetObj argFocus,
		ISecureSecUserObj argContainer,
		ISecureJavaFXSecUserPWResetPageCallback argPageCallback,
		ISecureJavaFXSecUserPWResetChosen whenChosen )
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
		pageCallback = argPageCallback;
		dataTable = new TableView<ISecureSecUserPWResetObj>();
		tableColumnSentToEMailAddr = new TableColumn<ISecureSecUserPWResetObj,String>( "Sent To EMail Address" );
		tableColumnSentToEMailAddr.setCellValueFactory( new Callback<CellDataFeatures<ISecureSecUserPWResetObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ISecureSecUserPWResetObj, String> p ) {
				ISecureSecUserPWResetObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredSentToEMailAddr();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnSentToEMailAddr.setCellFactory( new Callback<TableColumn<ISecureSecUserPWResetObj,String>,TableCell<ISecureSecUserPWResetObj,String>>() {
			@Override public TableCell<ISecureSecUserPWResetObj,String> call(
				TableColumn<ISecureSecUserPWResetObj,String> arg)
			{
				return new YCFStringTableCell<ISecureSecUserPWResetObj>();
			}
		});
		dataTable.getColumns().add( tableColumnSentToEMailAddr );
		tableColumnPasswordResetUuid6 = new TableColumn<ISecureSecUserPWResetObj,IYCFUuid6>( "Password Reset UUID6" );
		tableColumnPasswordResetUuid6.setCellValueFactory( new Callback<CellDataFeatures<ISecureSecUserPWResetObj,IYCFUuid6>,ObservableValue<IYCFUuid6> >() {
			public ObservableValue<IYCFUuid6> call( CellDataFeatures<ISecureSecUserPWResetObj, IYCFUuid6> p ) {
				ISecureSecUserPWResetObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IYCFUuid6 value = obj.getRequiredPasswordResetUuid6();
					ReadOnlyObjectWrapper<IYCFUuid6> observable = new ReadOnlyObjectWrapper<IYCFUuid6>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnPasswordResetUuid6.setCellFactory( new Callback<TableColumn<ISecureSecUserPWResetObj,IYCFUuid6>,TableCell<ISecureSecUserPWResetObj,IYCFUuid6>>() {
			@Override public TableCell<ISecureSecUserPWResetObj,IYCFUuid6> call(
				TableColumn<ISecureSecUserPWResetObj,IYCFUuid6> arg)
			{
				return new YCFUuid6TableCell<ISecureSecUserPWResetObj>();
			}
		});
		dataTable.getColumns().add( tableColumnPasswordResetUuid6 );
		tableColumnNewAccount = new TableColumn<ISecureSecUserPWResetObj,Boolean>( "Password reset is for new account?" );
		tableColumnNewAccount.setCellValueFactory( new Callback<CellDataFeatures<ISecureSecUserPWResetObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ISecureSecUserPWResetObj, Boolean> p ) {
				ISecureSecUserPWResetObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					boolean value = obj.getRequiredNewAccount();
					Boolean wrapped = Boolean.valueOf( value );
					ReadOnlyObjectWrapper<Boolean> observable = new ReadOnlyObjectWrapper<Boolean>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnNewAccount.setCellFactory( new Callback<TableColumn<ISecureSecUserPWResetObj,Boolean>,TableCell<ISecureSecUserPWResetObj,Boolean>>() {
			@Override public TableCell<ISecureSecUserPWResetObj,Boolean> call(
				TableColumn<ISecureSecUserPWResetObj,Boolean> arg)
			{
				return new YCFBoolTableCell<ISecureSecUserPWResetObj>();
			}
		});
		dataTable.getColumns().add( tableColumnNewAccount );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ISecureSecUserPWResetObj>() {
				@Override public void changed( ObservableValue<? extends ISecureSecUserPWResetObj> observable,
					ISecureSecUserPWResetObj oldValue,
					ISecureSecUserPWResetObj newValue )
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
			buttonRefresh = new YCFButton();
			buttonRefresh.setMinWidth( 200 );
			buttonRefresh.setText( "Refresh" );
			buttonRefresh.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						observableListOfSecUserPWReset = FXCollections.observableArrayList();
						List<ISecureSecUserPWResetObj> page = pageCallback.pageData( null );
						Iterator<ISecureSecUserPWResetObj> iter = page.iterator();
						while( iter.hasNext() ) {
							observableListOfSecUserPWReset.add( iter.next() );
						}
						if( page.size() < 25 ) {
							observableListOfSecUserPWReset.sort( compareSecUserPWResetByQualName );
							endOfData = true;
						}
						else {
							endOfData = false;
						}
						if( dataTable != null ) {
							dataTable.setItems( observableListOfSecUserPWReset );
							// Hack from stackoverflow to fix JavaFX TableView refresh issue
							((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
							((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
						}
						adjustListButtons();
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonRefresh );

			buttonMoreData = new YCFButton();
			buttonMoreData.setMinWidth( 200 );
			buttonMoreData.setText( "MoreData" );
			buttonMoreData.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ISecureSecUserPWResetObj lastObj = null;
						if( ( observableListOfSecUserPWReset != null ) && ( observableListOfSecUserPWReset.size() > 0 ) ) {
							lastObj = observableListOfSecUserPWReset.get( observableListOfSecUserPWReset.size() - 1 );
						}
						List<ISecureSecUserPWResetObj> page;
						if( lastObj != null ) {
							page = pageCallback.pageData( lastObj.getRequiredSecUserId() );
						}
						else {
							page = pageCallback.pageData( null );
						}
						Iterator<ISecureSecUserPWResetObj> iter = page.iterator();
						while( iter.hasNext() ) {
							observableListOfSecUserPWReset.add( iter.next() );
						}
						if( page.size() < 25 ) {
							observableListOfSecUserPWReset.sort( compareSecUserPWResetByQualName );
							endOfData = true;
						}
						else {
							endOfData = false;
						}
						if( dataTable != null ) {
							dataTable.setItems( observableListOfSecUserPWReset );
							// Hack from stackoverflow to fix JavaFX TableView refresh issue
							((TableColumn)dataTable.getColumns().get(0)).setVisible( false );
							((TableColumn)dataTable.getColumns().get(0)).setVisible( true );
						}
						adjustListButtons();
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonMoreData );

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
					invokeWhenChosen.choseSecUserPWReset( null );
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
					ISecureSecUserPWResetObj selectedInstance = getJavaFXFocusAsSecUserPWReset();
					invokeWhenChosen.choseSecUserPWReset( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ISecureSecUserPWResetObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecUserPWResetObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ISecureSecUserPWResetObj getJavaFXFocusAsSecUserPWReset() {
		return( (ISecureSecUserPWResetObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSecUserPWReset( ISecureSecUserPWResetObj value ) {
		setJavaFXFocus( value );
	}

	public class SecUserPWResetByQualNameComparator
	implements Comparator<ISecureSecUserPWResetObj>
	{
		public SecUserPWResetByQualNameComparator() {
		}

		public int compare( ISecureSecUserPWResetObj lhs, ISecureSecUserPWResetObj rhs ) {
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

	protected SecUserPWResetByQualNameComparator compareSecUserPWResetByQualName = new SecUserPWResetByQualNameComparator();

	public Collection<ISecureSecUserPWResetObj> getJavaFXDataCollection() {
		return( null );
	}

	public void setJavaFXDataCollection( Collection<ISecureSecUserPWResetObj> value ) {
		// Use page data instead
	}

	public ISecureSecUserObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ISecureSecUserObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ISecureSecUserPWResetObj selectedObj = getJavaFXFocusAsSecUserPWReset();
		if( selectedObj == null ) {
			enableState = false;
		}
		else {
			enableState = true;
		}

		if( buttonRefresh != null ) {
			buttonRefresh.setDisable( false );
		}
		if( buttonMoreData != null ) {
			buttonMoreData.setDisable( endOfData );
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

