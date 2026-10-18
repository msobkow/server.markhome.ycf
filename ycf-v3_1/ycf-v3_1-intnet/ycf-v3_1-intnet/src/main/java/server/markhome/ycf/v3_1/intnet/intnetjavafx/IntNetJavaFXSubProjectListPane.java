// Description: Java 25 JavaFX List of Obj Pane implementation for SubProject.

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
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.secure.securejavafx.*;

/**
 *	IntNetJavaFXSubProjectListPane JavaFX List of Obj Pane implementation
 *	for SubProject.
 */
public class IntNetJavaFXSubProjectListPane
extends YCFBorderPane
implements IIntNetJavaFXSubProjectPaneList
{
	public static String S_FormName = "List SubProject";
	protected IIntNetJavaFXSchema javafxSchema = null;
	protected Collection<IIntNetSubProjectObj> javafxDataCollection = null;
	protected ObservableList<IIntNetSubProjectObj> observableListOfSubProject = null;
	protected ScrollPane scrollMenu = null;
	protected YCFHBox hboxMenu = null;
	protected YCFButton buttonAddSubProject = null;
	protected YCFButton buttonViewSelected = null;
	protected YCFButton buttonEditSelected = null;
	protected YCFButton buttonDeleteSelected = null;
	protected TableView<IIntNetSubProjectObj> dataTable = null;
	protected TableColumn<IIntNetSubProjectObj, IYCFKeyHash256> tableColumnId = null;
	protected TableColumn<IIntNetSubProjectObj, String> tableColumnName = null;
	protected TableColumn<IIntNetSubProjectObj, String> tableColumnDescription = null;

	public final String S_ColumnNames[] = { "Name" };
	protected IYCFFormManager ycfFormManager = null;
	protected boolean javafxIsInitializing = true;
	protected boolean javafxSortByChain = false;
	protected IIntNetTopProjectObj javafxContainer = null;
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


	public IntNetJavaFXSubProjectListPane( IYCFFormManager formManager,
		IIntNetJavaFXSchema argSchema,
		IIntNetTopProjectObj argContainer,
		IIntNetSubProjectObj argFocus,
		Collection<IIntNetSubProjectObj> argDataCollection,
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
		if( observableListOfSubProject != null ) {
			dataTable.setItems( observableListOfSubProject );
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

	public IIntNetJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		super.setPaneMode( value );
		adjustListButtons();
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
		adjustListButtons();
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
			buttonAddSubProject = new YCFButton();
			buttonAddSubProject.setMinWidth( 200 );
			buttonAddSubProject.setText( "Add SubProject" );
			buttonAddSubProject.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						IIntNetSchemaObj schemaObj = (IIntNetSchemaObj)javafxSchema.getSchema();
						IIntNetSubProjectObj obj = (IIntNetSubProjectObj)schemaObj.getSubProjectTableObj().newInstance();
						IIntNetSubProjectEditObj edit = (IIntNetSubProjectEditObj)( obj.beginEdit() );
						if( edit == null ) {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"edit" );
						}
								ISecureTenantObj secTenant = schemaObj.getSecTenant();
								edit.setRequiredOwnerTenant( secTenant );
								IIntNetTopProjectObj container = (IIntNetTopProjectObj)( getJavaFXContainer() );
								if( container == null ) {
									throw new YCFLibNullArgumentException( getClass(),
										S_ProcName,
										0,
										"JavaFXContainer" );
								}
								edit.setRequiredContainerParentTPrj( container );
						YCFBorderPane frame = javafxSchema.getSubProjectFactory().newAddForm( ycfFormManager, obj, getViewEditClosedCallback(), true );
						IIntNetJavaFXSubProjectPaneCommon jpanelCommon = (IIntNetJavaFXSubProjectPaneCommon)frame;
						jpanelCommon.setJavaFXFocus( obj );
						jpanelCommon.setPaneMode( YCFPane.PaneMode.Add );
						ycfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonAddSubProject );
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
						IIntNetSubProjectObj selectedInstance = getJavaFXFocusAsSubProject();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IIntNetSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("IntNet") && backingClassCode == IIntNetSubProject.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getSubProjectFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((IIntNetJavaFXSubProjectPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IIntNetSubProjectObj" );
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
						IIntNetSubProjectObj selectedInstance = getJavaFXFocusAsSubProject();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IIntNetSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("IntNet") && backingClassCode == IIntNetSubProject.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getSubProjectFactory().newViewEditForm( ycfFormManager, selectedInstance, getViewEditClosedCallback(), false );
								((IIntNetJavaFXSubProjectPaneCommon)frame).setPaneMode( YCFPane.PaneMode.Edit );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IIntNetSubProjectObj" );
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
						IIntNetSubProjectObj selectedInstance = getJavaFXFocusAsSubProject();
						if( selectedInstance != null ) {
							int classCode = selectedInstance.getClassCode();
							ISecureSchema.ClassMapEntry entry = IIntNetSchema.getClassMapByRuntimeClassCode(classCode);
							int backingClassCode = entry.getBackingClassCode();
							if( entry.getSchemaName().equals("IntNet") && backingClassCode == IIntNetSubProject.CLASS_CODE ) {
								YCFBorderPane frame = javafxSchema.getSubProjectFactory().newAskDeleteForm( ycfFormManager, selectedInstance, getDeleteCallback() );
								((IIntNetJavaFXSubProjectPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
								ycfFormManager.pushForm( frame );
							}
							else {
								throw new YCFLibUnsupportedClassException( getClass(),
									S_ProcName,
									"selectedInstance",
									selectedInstance,
									"IIntNetSubProjectObj" );
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

	public IIntNetTopProjectObj getJavaFXContainer() {
		return( javafxContainer );
	}

	public void setJavaFXContainer( IIntNetTopProjectObj value ) {
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
		IIntNetSubProjectObj selectedObj = getJavaFXFocusAsSubProject();
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
		if( buttonAddSubProject != null ) {
			buttonAddSubProject.setDisable( ! allowAdds );
		}

	}
}
