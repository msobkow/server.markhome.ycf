// Description: Java 25 JavaFX Picker of Obj Pane implementation for SecSysRoleEnables.

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
 *	SecureJavaFXSecSysRoleEnablesPickerPane JavaFX Pick Obj Pane implementation
 *	for SecSysRoleEnables.
 */
public class SecureJavaFXSecSysRoleEnablesPickerPane
extends YCFBorderPane
implements ISecureJavaFXSecSysRoleEnablesPaneList
{
	public static String S_FormName = "Choose Security System Role Enables Group";
	protected ISecureJavaFXSchema javafxSchema = null;
	protected ISecureJavaFXSecSysRoleEnablesPageCallback pageCallback;
	protected YCFButton buttonRefresh = null;
	protected YCFButton buttonMoreData = null;
	protected boolean endOfData = true;
	protected ObservableList<ISecureSecSysRoleEnablesObj> observableListOfSecSysRoleEnables = null;
	protected TableColumn<ISecureSecSysRoleEnablesObj, ISecureSecSysGrpObj> tableColumnParentEnableGroup = null;
	protected TableView<ISecureSecSysRoleEnablesObj> dataTable = null;
	protected YCFHBox hboxMenu = null;
	public final String S_ColumnNames[] = { "Name" };
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSecSysRoleEnablesChosen invokeWhenChosen = null;
	protected ISecureSecSysRoleObj javafxContainer = null;
	protected YCFButton buttonCancel = null;
	protected YCFButton buttonChooseNone = null;
	protected YCFButton buttonChooseSelected = null;
	protected ScrollPane scrollMenu = null;
	public SecureJavaFXSecSysRoleEnablesPickerPane( IYCFFormManager formManager,
		ISecureJavaFXSchema argSchema,
		ISecureSecSysRoleEnablesObj argFocus,
		ISecureSecSysRoleObj argContainer,
		ISecureJavaFXSecSysRoleEnablesPageCallback argPageCallback,
		ISecureJavaFXSecSysRoleEnablesChosen whenChosen )
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
		dataTable = new TableView<ISecureSecSysRoleEnablesObj>();
		tableColumnParentEnableGroup = new TableColumn<ISecureSecSysRoleEnablesObj, ISecureSecSysGrpObj>( "Enable Group" );
		tableColumnParentEnableGroup.setCellValueFactory( new Callback<CellDataFeatures<ISecureSecSysRoleEnablesObj,ISecureSecSysGrpObj>,ObservableValue<ISecureSecSysGrpObj> >() {
			public ObservableValue<ISecureSecSysGrpObj> call( CellDataFeatures<ISecureSecSysRoleEnablesObj, ISecureSecSysGrpObj> p ) {
				ISecureSecSysRoleEnablesObj obj = p.getValue();
				if( obj == null ) {
					return( null );
				}
				else {
					ISecureSecSysGrpObj ref = obj.getRequiredParentEnableGroup();
					ReadOnlyObjectWrapper<ISecureSecSysGrpObj> observable = new ReadOnlyObjectWrapper<ISecureSecSysGrpObj>();
					observable.setValue( ref );
					return( observable );
				}
			}
		});
		tableColumnParentEnableGroup.setCellFactory( new Callback<TableColumn<ISecureSecSysRoleEnablesObj,ISecureSecSysGrpObj>,TableCell<ISecureSecSysRoleEnablesObj,ISecureSecSysGrpObj>>() {
			@Override public TableCell<ISecureSecSysRoleEnablesObj,ISecureSecSysGrpObj> call(
				TableColumn<ISecureSecSysRoleEnablesObj,ISecureSecSysGrpObj> arg)
			{
				return new YCFReferenceTableCell<ISecureSecSysRoleEnablesObj,ISecureSecSysGrpObj>();
			}
		});
		dataTable.getColumns().add( tableColumnParentEnableGroup );
		dataTable.getSelectionModel().selectedItemProperty().addListener(
			new ChangeListener<ISecureSecSysRoleEnablesObj>() {
				@Override public void changed( ObservableValue<? extends ISecureSecSysRoleEnablesObj> observable,
					ISecureSecSysRoleEnablesObj oldValue,
					ISecureSecSysRoleEnablesObj newValue )
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
						observableListOfSecSysRoleEnables = FXCollections.observableArrayList();
						List<ISecureSecSysRoleEnablesObj> page = pageCallback.pageData( null,
							null );
						Iterator<ISecureSecSysRoleEnablesObj> iter = page.iterator();
						while( iter.hasNext() ) {
							observableListOfSecSysRoleEnables.add( iter.next() );
						}
						if( page.size() < 25 ) {
							observableListOfSecSysRoleEnables.sort( compareSecSysRoleEnablesByQualName );
							endOfData = true;
						}
						else {
							endOfData = false;
						}
						if( dataTable != null ) {
							dataTable.setItems( observableListOfSecSysRoleEnables );
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
						ISecureSecSysRoleEnablesObj lastObj = null;
						if( ( observableListOfSecSysRoleEnables != null ) && ( observableListOfSecSysRoleEnables.size() > 0 ) ) {
							lastObj = observableListOfSecSysRoleEnables.get( observableListOfSecSysRoleEnables.size() - 1 );
						}
						List<ISecureSecSysRoleEnablesObj> page;
						if( lastObj != null ) {
							page = pageCallback.pageData( lastObj.getRequiredSecSysRoleId(),
							lastObj.getRequiredEnableName() );
						}
						else {
							page = pageCallback.pageData( null,
							null );
						}
						Iterator<ISecureSecSysRoleEnablesObj> iter = page.iterator();
						while( iter.hasNext() ) {
							observableListOfSecSysRoleEnables.add( iter.next() );
						}
						if( page.size() < 25 ) {
							observableListOfSecSysRoleEnables.sort( compareSecSysRoleEnablesByQualName );
							endOfData = true;
						}
						else {
							endOfData = false;
						}
						if( dataTable != null ) {
							dataTable.setItems( observableListOfSecSysRoleEnables );
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
					invokeWhenChosen.choseSecSysRoleEnables( null );
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
					ISecureSecSysRoleEnablesObj selectedInstance = getJavaFXFocusAsSecSysRoleEnables();
					invokeWhenChosen.choseSecSysRoleEnables( selectedInstance );
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
		if( ( value == null ) || ( value instanceof ISecureSecSysRoleEnablesObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecSysRoleEnablesObj" );
		}
		if( dataTable == null ) {
			return;
		}
	}

	public ISecureSecSysRoleEnablesObj getJavaFXFocusAsSecSysRoleEnables() {
		return( (ISecureSecSysRoleEnablesObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSecSysRoleEnables( ISecureSecSysRoleEnablesObj value ) {
		setJavaFXFocus( value );
	}

	public class SecSysRoleEnablesByQualNameComparator
	implements Comparator<ISecureSecSysRoleEnablesObj>
	{
		public SecSysRoleEnablesByQualNameComparator() {
		}

		public int compare( ISecureSecSysRoleEnablesObj lhs, ISecureSecSysRoleEnablesObj rhs ) {
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

	protected SecSysRoleEnablesByQualNameComparator compareSecSysRoleEnablesByQualName = new SecSysRoleEnablesByQualNameComparator();

	public Collection<ISecureSecSysRoleEnablesObj> getJavaFXDataCollection() {
		return( null );
	}

	public void setJavaFXDataCollection( Collection<ISecureSecSysRoleEnablesObj> value ) {
		// Use page data instead
	}

	public ISecureSecSysRoleObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( ISecureSecSysRoleObj value ) {
		javafxContainer = value;
	}

	public void adjustListButtons() {
		boolean enableState;
		ISecureSecSysRoleEnablesObj selectedObj = getJavaFXFocusAsSecSysRoleEnables();
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

