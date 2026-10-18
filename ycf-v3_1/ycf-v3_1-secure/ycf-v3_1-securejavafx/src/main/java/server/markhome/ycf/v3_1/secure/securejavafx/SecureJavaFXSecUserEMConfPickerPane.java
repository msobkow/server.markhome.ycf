// Description: Java 25 JavaFX Picker of Obj Pane implementation for SecUserEMConf.

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
 *	SecureJavaFXSecUserEMConfPickerPane JavaFX Pick Obj Pane implementation
 *	for SecUserEMConf.
 */
public class SecureJavaFXSecUserEMConfPickerPane
extends YCFBorderPane
implements ISecureJavaFXSecUserEMConfPaneList
{
	public static String S_FormName = "Choose Email confirmation";
	protected ISecureJavaFXSchema javafxSchema = null;
	protected ISecureJavaFXSecUserEMConfPageCallback pageCallback;
	protected YCFButton buttonRefresh = null;
	protected YCFButton buttonMoreData = null;
	protected boolean endOfData = true;
	protected ObservableList<ISecureSecUserEMConfObj> observableListOfSecUserEMConf = null;
	protected TableColumn<ISecureSecUserEMConfObj, String> tableColumnConfirmEMailAddr = null;
	protected TableColumn<ISecureSecUserEMConfObj, LocalDateTime> tableColumnEMailSentStamp = null;
	protected TableColumn<ISecureSecUserEMConfObj, IYCFUuid6> tableColumnEMConfirmationUuid6 = null;
	protected TableColumn<ISecureSecUserEMConfObj, Boolean> tableColumnNewAccount = null;
	protected TableView<ISecureSecUserEMConfObj> dataTable = null;
	protected YCFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSecUserEMConfChosen invokeWhenChosen = null;
	protected ISecureSecUserObj javafxContainer = null;
	protected YCFButton buttonCancel = null;
	protected YCFButton buttonChooseNone = null;
	protected YCFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public SecureJavaFXSecUserEMConfPickerPane( IYCFFormManager formManager,
		ISecureJavaFXSchema argSchema,
		ISecureSecUserEMConfObj argFocus,
		ISecureSecUserObj argContainer,
		ISecureJavaFXSecUserEMConfPageCallback argPageCallback,
		ISecureJavaFXSecUserEMConfChosen whenChosen )
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
		dataTable = new TableView<ISecureSecUserEMConfObj>();
		tableColumnConfirmEMailAddr = new TableColumn<ISecureSecUserEMConfObj,String>( "Confirm EMail Address" );
		tableColumnConfirmEMailAddr.setCellValueFactory( new Callback<CellDataFeatures<ISecureSecUserEMConfObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ISecureSecUserEMConfObj, String> p ) {
				ISecureSecUserEMConfObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredConfirmEMailAddr();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnConfirmEMailAddr.setCellFactory( new Callback<TableColumn<ISecureSecUserEMConfObj,String>,TableCell<ISecureSecUserEMConfObj,String>>() {
			@Override public TableCell<ISecureSecUserEMConfObj,String> call(
				TableColumn<ISecureSecUserEMConfObj,String> arg)
			{
				return new YCFStringTableCell<ISecureSecUserEMConfObj>();
			}
		});
		dataTable.getColumns().add( tableColumnConfirmEMailAddr );
		tableColumnEMailSentStamp = new TableColumn<ISecureSecUserEMConfObj,LocalDateTime>( "Confirmation EMail Sent At" );
		tableColumnEMailSentStamp.setCellValueFactory( new Callback<CellDataFeatures<ISecureSecUserEMConfObj,LocalDateTime>,ObservableValue<LocalDateTime> >() {
			public ObservableValue<LocalDateTime> call( CellDataFeatures<ISecureSecUserEMConfObj, LocalDateTime> p ) {
				ISecureSecUserEMConfObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					LocalDateTime value = obj.getRequiredEMailSentStamp();
					ReadOnlyObjectWrapper<LocalDateTime> observable = new ReadOnlyObjectWrapper<LocalDateTime>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnEMailSentStamp.setCellFactory( new Callback<TableColumn<ISecureSecUserEMConfObj,LocalDateTime>,TableCell<ISecureSecUserEMConfObj,LocalDateTime>>() {
			@Override public TableCell<ISecureSecUserEMConfObj,LocalDateTime> call(
				TableColumn<ISecureSecUserEMConfObj,LocalDateTime> arg)
			{
				return new YCFTimestampTableCell<ISecureSecUserEMConfObj>();
			}
		});
		dataTable.getColumns().add( tableColumnEMailSentStamp );
		tableColumnEMConfirmationUuid6 = new TableColumn<ISecureSecUserEMConfObj,IYCFUuid6>( "EMail Confirmation UUID6" );
		tableColumnEMConfirmationUuid6.setCellValueFactory( new Callback<CellDataFeatures<ISecureSecUserEMConfObj,IYCFUuid6>,ObservableValue<IYCFUuid6> >() {
			public ObservableValue<IYCFUuid6> call( CellDataFeatures<ISecureSecUserEMConfObj, IYCFUuid6> p ) {
				ISecureSecUserEMConfObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					IYCFUuid6 value = obj.getRequiredEMConfirmationUuid6();
					ReadOnlyObjectWrapper<IYCFUuid6> observable = new ReadOnlyObjectWrapper<IYCFUuid6>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnEMConfirmationUuid6.setCellFactory( new Callback<TableColumn<ISecureSecUserEMConfObj,IYCFUuid6>,TableCell<ISecureSecUserEMConfObj,IYCFUuid6>>() {
			@Override public TableCell<ISecureSecUserEMConfObj,IYCFUuid6> call(
				TableColumn<ISecureSecUserEMConfObj,IYCFUuid6> arg)
			{
				return new YCFUuid6TableCell<ISecureSecUserEMConfObj>();
			}
		});
		dataTable.getColumns().add( tableColumnEMConfirmationUuid6 );
		tableColumnNewAccount = new TableColumn<ISecureSecUserEMConfObj,Boolean>( "Confirmation email is for new account?" );
		tableColumnNewAccount.setCellValueFactory( new Callback<CellDataFeatures<ISecureSecUserEMConfObj,Boolean>,ObservableValue<Boolean> >() {
			public ObservableValue<Boolean> call( CellDataFeatures<ISecureSecUserEMConfObj, Boolean> p ) {
				ISecureSecUserEMConfObj obj = p.getValue();
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
		tableColumnNewAccount.setCellFactory( new Callback<TableColumn<ISecureSecUserEMConfObj,Boolean>,TableCell<ISecureSecUserEMConfObj,Boolean>>() {
			@Override public TableCell<ISecureSecUserEMConfObj,Boolean> call(
				TableColumn<ISecureSecUserEMConfObj,Boolean> arg)
			{
				return new YCFBoolTableCell<ISecureSecUserEMConfObj>();
			}
		});
		dataTable.getColumns().add( tableColumnNewAccount );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ISecureSecUserEMConfObj>() {
				@Override public void changed( ObservableValue<? extends ISecureSecUserEMConfObj> observable,
					ISecureSecUserEMConfObj oldValue,
					ISecureSecUserEMConfObj newValue )
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
						observableListOfSecUserEMConf = FXCollections.observableArrayList();
						List<ISecureSecUserEMConfObj> page = pageCallback.pageData( null );
						Iterator<ISecureSecUserEMConfObj> iter = page.iterator();
						while( iter.hasNext() ) {
							observableListOfSecUserEMConf.add( iter.next() );
						}
						if( page.size() < 25 ) {
							observableListOfSecUserEMConf.sort( compareSecUserEMConfByQualName );
							endOfData = true;
						}
						else {
							endOfData = false;
						}
						if( dataTable != null ) {
							dataTable.setItems( observableListOfSecUserEMConf );
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
						ISecureSecUserEMConfObj lastObj = null;
						if( ( observableListOfSecUserEMConf != null ) && ( observableListOfSecUserEMConf.size() > 0 ) ) {
							lastObj = observableListOfSecUserEMConf.get( observableListOfSecUserEMConf.size() - 1 );
						}
						List<ISecureSecUserEMConfObj> page;
						if( lastObj != null ) {
							page = pageCallback.pageData( lastObj.getRequiredSecUserId() );
						}
						else {
							page = pageCallback.pageData( null );
						}
						Iterator<ISecureSecUserEMConfObj> iter = page.iterator();
						while( iter.hasNext() ) {
							observableListOfSecUserEMConf.add( iter.next() );
						}
						if( page.size() < 25 ) {
							observableListOfSecUserEMConf.sort( compareSecUserEMConfByQualName );
							endOfData = true;
						}
						else {
							endOfData = false;
						}
						if( dataTable != null ) {
							dataTable.setItems( observableListOfSecUserEMConf );
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
					invokeWhenChosen.choseSecUserEMConf( null );
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
					ISecureSecUserEMConfObj selectedInstance = getJavaFXFocusAsSecUserEMConf();
					invokeWhenChosen.choseSecUserEMConf( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ISecureSecUserEMConfObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecUserEMConfObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ISecureSecUserEMConfObj getJavaFXFocusAsSecUserEMConf() {
		return( (ISecureSecUserEMConfObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSecUserEMConf( ISecureSecUserEMConfObj value ) {
		setJavaFXFocus( value );
	}

	public class SecUserEMConfByQualNameComparator
	implements Comparator<ISecureSecUserEMConfObj>
	{
		public SecUserEMConfByQualNameComparator() {
		}

		public int compare( ISecureSecUserEMConfObj lhs, ISecureSecUserEMConfObj rhs ) {
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

	protected SecUserEMConfByQualNameComparator compareSecUserEMConfByQualName = new SecUserEMConfByQualNameComparator();

	public Collection<ISecureSecUserEMConfObj> getJavaFXDataCollection() {
		return( null );
	}

	public void setJavaFXDataCollection( Collection<ISecureSecUserEMConfObj> value ) {
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
		ISecureSecUserEMConfObj selectedObj = getJavaFXFocusAsSecUserEMConf();
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

