// Description: Java 25 JavaFX Picker of Obj Pane implementation for ISOLang.

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
 *	SecureJavaFXISOLangPickerPane JavaFX Pick Obj Pane implementation
 *	for ISOLang.
 */
public class SecureJavaFXISOLangPickerPane
extends YCFBorderPane
implements ISecureJavaFXISOLangPaneList
{
	public static String S_FormName = "Choose ISO Lang";
	protected ISecureJavaFXSchema javafxSchema = null;
	protected Collection<ISecureISOLangObj> javafxDataCollection = null;
	protected ObservableList<ISecureISOLangObj> observableListOfISOLang = null;
	protected TableColumn<ISecureISOLangObj, Short> tableColumnISOLangId = null;
	protected TableColumn<ISecureISOLangObj, String> tableColumnISO6392Code = null;
	protected TableColumn<ISecureISOLangObj, String> tableColumnISO6391Code = null;
	protected TableColumn<ISecureISOLangObj, String> tableColumnEnglishName = null;
	protected TableView<ISecureISOLangObj> dataTable = null;
	protected YCFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXISOLangChosen invokeWhenChosen = null;
	protected IYCFLibAnyObj javafxContainer = null;
	protected YCFButton buttonCancel = null;
	protected YCFButton buttonChooseNone = null;
	protected YCFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public SecureJavaFXISOLangPickerPane( IYCFFormManager formManager,
		ISecureJavaFXSchema argSchema,
		ISecureISOLangObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<ISecureISOLangObj> argDataCollection,
		ISecureJavaFXISOLangChosen whenChosen )
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
		dataTable = new TableView<ISecureISOLangObj>();
		tableColumnISOLangId = new TableColumn<ISecureISOLangObj,Short>( "ISOLangId" );
		tableColumnISOLangId.setCellValueFactory( new Callback<CellDataFeatures<ISecureISOLangObj,Short>,ObservableValue<Short> >() {
			public ObservableValue<Short> call( CellDataFeatures<ISecureISOLangObj, Short> p ) {
				ISecureISOLangObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					short value = obj.getRequiredISOLangId();
					Short wrapped = Short.valueOf( value );
					ReadOnlyObjectWrapper<Short> observable = new ReadOnlyObjectWrapper<Short>();
					observable.setValue( wrapped );
					return( observable );
				}
			}
		});
		tableColumnISOLangId.setCellFactory( new Callback<TableColumn<ISecureISOLangObj,Short>,TableCell<ISecureISOLangObj,Short>>() {
			@Override public TableCell<ISecureISOLangObj,Short> call(
				TableColumn<ISecureISOLangObj,Short> arg)
			{
				return new YCFInt16TableCell<ISecureISOLangObj>();
			}
		});
		dataTable.getColumns().add( tableColumnISOLangId );
		tableColumnISO6392Code = new TableColumn<ISecureISOLangObj,String>( "ISO6392Code" );
		tableColumnISO6392Code.setCellValueFactory( new Callback<CellDataFeatures<ISecureISOLangObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ISecureISOLangObj, String> p ) {
				ISecureISOLangObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredISO6392Code();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnISO6392Code.setCellFactory( new Callback<TableColumn<ISecureISOLangObj,String>,TableCell<ISecureISOLangObj,String>>() {
			@Override public TableCell<ISecureISOLangObj,String> call(
				TableColumn<ISecureISOLangObj,String> arg)
			{
				return new YCFStringTableCell<ISecureISOLangObj>();
			}
		});
		dataTable.getColumns().add( tableColumnISO6392Code );
		tableColumnISO6391Code = new TableColumn<ISecureISOLangObj,String>( "ISO6391Code" );
		tableColumnISO6391Code.setCellValueFactory( new Callback<CellDataFeatures<ISecureISOLangObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ISecureISOLangObj, String> p ) {
				ISecureISOLangObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getOptionalISO6391Code();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnISO6391Code.setCellFactory( new Callback<TableColumn<ISecureISOLangObj,String>,TableCell<ISecureISOLangObj,String>>() {
			@Override public TableCell<ISecureISOLangObj,String> call(
				TableColumn<ISecureISOLangObj,String> arg)
			{
				return new YCFStringTableCell<ISecureISOLangObj>();
			}
		});
		dataTable.getColumns().add( tableColumnISO6391Code );
		tableColumnEnglishName = new TableColumn<ISecureISOLangObj,String>( "EnglishName" );
		tableColumnEnglishName.setCellValueFactory( new Callback<CellDataFeatures<ISecureISOLangObj,String>,ObservableValue<String> >() {
			public ObservableValue<String> call( CellDataFeatures<ISecureISOLangObj, String> p ) {
				ISecureISOLangObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					String value = obj.getRequiredEnglishName();
					ReadOnlyObjectWrapper<String> observable = new ReadOnlyObjectWrapper<String>();
					observable.setValue( value );
					return( observable );
				}
			}
		});
		tableColumnEnglishName.setCellFactory( new Callback<TableColumn<ISecureISOLangObj,String>,TableCell<ISecureISOLangObj,String>>() {
			@Override public TableCell<ISecureISOLangObj,String> call(
				TableColumn<ISecureISOLangObj,String> arg)
			{
				return new YCFStringTableCell<ISecureISOLangObj>();
			}
		});
		dataTable.getColumns().add( tableColumnEnglishName );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ISecureISOLangObj>() {
				@Override public void changed( ObservableValue<? extends ISecureISOLangObj> observable,
					ISecureISOLangObj oldValue,
					ISecureISOLangObj newValue )
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
					invokeWhenChosen.choseISOLang( null );
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
					ISecureISOLangObj selectedInstance = getJavaFXFocusAsISOLang();
					invokeWhenChosen.choseISOLang( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ISecureISOLangObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureISOLangObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ISecureISOLangObj getJavaFXFocusAsISOLang() {
		return( (ISecureISOLangObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsISOLang( ISecureISOLangObj value ) {
		setJavaFXFocus( value );
	}

	public class ISOLangByQualNameComparator
	implements Comparator<ISecureISOLangObj>
	{
		public ISOLangByQualNameComparator() {
		}

		public int compare( ISecureISOLangObj lhs, ISecureISOLangObj rhs ) {
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

	protected ISOLangByQualNameComparator compareISOLangByQualName = new ISOLangByQualNameComparator();

	public Collection<ISecureISOLangObj> getJavaFXDataCollection() {
		return( javafxDataCollection );
	}

	public void setJavaFXDataCollection( Collection<ISecureISOLangObj> value ) {
		final String S_ProcName = "setJavaFXDataCollection";
		javafxDataCollection = value;
		observableListOfISOLang = FXCollections.observableArrayList();
		if( javafxDataCollection != null ) {
				Iterator<ISecureISOLangObj> iter = javafxDataCollection.iterator();
				while( iter.hasNext() ) {
					observableListOfISOLang.add( iter.next() );
				}
				observableListOfISOLang.sort( compareISOLangByQualName );
		}
		if( dataTable != null ) {
			dataTable.setItems( observableListOfISOLang );
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
		ISecureISOLangObj selectedObj = getJavaFXFocusAsISOLang();
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

