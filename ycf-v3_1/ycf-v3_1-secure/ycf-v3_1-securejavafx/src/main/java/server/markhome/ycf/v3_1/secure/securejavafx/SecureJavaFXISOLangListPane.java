// Description: Java 25 JavaFX List of Obj Pane implementation for ISOLang.

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
import server.markhome.ycf.v3_1.secure.secureobj.*;

/**
 *	SecureJavaFXISOLangListPane JavaFX List of Obj Pane implementation
 *	for ISOLang.
 */
public class SecureJavaFXISOLangListPane
extends YCFBorderPane
implements ISecureJavaFXISOLangPaneList
{
	public static String S_FormName = "List ISO Lang";
	protected ISecureJavaFXSchema javafxSchema = null;
	protected Collection<ISecureISOLangObj> javafxDataCollection = null;
	protected ObservableList<ISecureISOLangObj> observableListOfISOLang = null;
	protected ScrollPane scrollMenu = null;
	protected YCFHBox hboxMenu = null;
	protected YCFButton buttonAddISOLang = null;
	protected YCFButton buttonViewSelected = null;
	protected YCFButton buttonEditSelected = null;
	protected YCFButton buttonDeleteSelected = null;
	protected TableView<ISecureISOLangObj> dataTable = null;
	protected TableColumn<ISecureISOLangObj, Short> tableColumnISOLangId = null;
	protected TableColumn<ISecureISOLangObj, String> tableColumnISO6392Code = null;
	protected TableColumn<ISecureISOLangObj, String> tableColumnISO6391Code = null;
	protected TableColumn<ISecureISOLangObj, String> tableColumnEnglishName = null;

	public final String S_ColumnNames[] = { "Name" };
	protected IYCFFormManager ycfFormManager = null;
	protected boolean javafxIsInitializing = true;
	protected boolean javafxSortByChain = false;
	protected IYCFLibAnyObj javafxContainer = null;
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


	public SecureJavaFXISOLangListPane( IYCFFormManager formManager,
		ISecureJavaFXSchema argSchema,
		IYCFLibAnyObj argContainer,
		ISecureISOLangObj argFocus,
		Collection<ISecureISOLangObj> argDataCollection,
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
		if( observableListOfISOLang != null ) {
			dataTable.setItems( observableListOfISOLang );
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

	public ISecureJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		super.setPaneMode( value );
		adjustListButtons();
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
		adjustListButtons();
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
			buttonAddISOLang = new YCFButton();
			buttonAddISOLang.setMinWidth( 200 );
			buttonAddISOLang.setText( "Add ISO Lang" );
			buttonAddISOLang.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
						ISecureISOLangObj obj = (ISecureISOLangObj)schemaObj.getISOLangTableObj().newInstance();
						ISecureISOLangEditObj edit = (ISecureISOLangEditObj)( obj.beginEdit() );
						if( edit == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"edit" );
						}
						YCFBorderPane frame = javafxSchema.getISOLangFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
						ISecureJavaFXISOLangPaneCommon jpanelCommon = (ISecureJavaFXISOLangPaneCommon)frame;
						jpanelCommon.setJavaFXFocus( obj );
						jpanelCommon.setPaneMode( YCFPane.PaneMode.Add );
						ycfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAddISOLang );
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
						ISecureISOLangObj selectedInstance = getJavaFXFocusAsISOLang();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = ISecureSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("Secure") && backingClassCode == ISecureISOLang.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getISOLangFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ISecureJavaFXISOLangPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ISecureISOLangObj" );
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
						ISecureISOLangObj selectedInstance = getJavaFXFocusAsISOLang();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = ISecureSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("Secure") && backingClassCode == ISecureISOLang.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getISOLangFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((ISecureJavaFXISOLangPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ISecureISOLangObj" );
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
						ISecureISOLangObj selectedInstance = getJavaFXFocusAsISOLang();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = ISecureSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("Secure") && backingClassCode == ISecureISOLang.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getISOLangFactory().newAskDeleteForm( ycfFormManager, selectedInstance, getDeleteCallback() );
								((ISecureJavaFXISOLangPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"ISecureISOLangObj" );
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

	public IYCFLibAnyObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( IYCFLibAnyObj value ) {
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
		ISecureISOLangObj selectedObj = getJavaFXFocusAsISOLang();
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
		if( buttonAddISOLang != null ) {
			buttonAddISOLang.setDisable( ! allowAdds );
		}

	}
}
