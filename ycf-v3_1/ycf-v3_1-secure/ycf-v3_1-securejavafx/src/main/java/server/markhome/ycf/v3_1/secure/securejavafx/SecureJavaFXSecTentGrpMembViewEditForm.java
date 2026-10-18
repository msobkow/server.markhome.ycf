// Description: Java 25 JavaFX View/Edit Form implementation for SecTentGrpMemb.

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

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.javafx.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

/**
 *	SecureJavaFXSecTentGrpMembViewEditForm JavaFX View/Edit Form implementation
 *	for SecTentGrpMemb.
 */
public class SecureJavaFXSecTentGrpMembViewEditForm
extends YCFBorderPane
implements ISecureJavaFXSecTentGrpMembPaneCommon,
	IYCFForm
{
	public static String S_FormName = "View/Edit Tenant Security Group Member";
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected IYCFFormClosedCallback formClosedCallback = null;
	protected boolean dataChanged = false;
	protected YCFSplitPane javafxViewEditPane = null;
	protected YCFButton buttonEdit = null;
	protected YCFButton buttonSave = null;
	protected YCFButton buttonClose = null;
	protected YCFButton buttonCancel = null;
	protected ScrollPane scrollMenu = null;
	protected YCFHBox hboxMenu = null;

	public SecureJavaFXSecTentGrpMembViewEditForm( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureSecTentGrpMembObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		super();
		final String S_ProcName = "construct-schema-focus";
		if( formManager == null ) {
			throw new YCFLibNullArgumentException( getClass(),
				S_ProcName,
				1,
				"formManager" );
		}
		ycfFormManager = formManager;
		formClosedCallback = closeCallback;
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
		if( ( argFocus != null ) && ( ! argFocus.getIsNew() ) ) {
			argFocus = (ISecureSecTentGrpMembObj)argFocus.read( true );
			javaFXFocus = argFocus;
		}
		javafxViewEditPane = argSchema.getSecTentGrpMembFactory().newViewEditPane( ycfFormManager, argFocus );

		if( cameFromAdd ) {
			dataChanged = true;
		}

		scrollMenu = new ScrollPane();
		scrollMenu.setVbarPolicy( ScrollBarPolicy.NEVER );
		scrollMenu.setHbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollMenu.setFitToHeight( true );
		scrollMenu.setContent( getHBoxMenu() );

		setTop( scrollMenu );
		setCenter( javafxViewEditPane );
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
		ISecureSecTentGrpMembObj focus = getJavaFXFocusAsSecTentGrpMemb();
		if( focus != null ) {
			ISecureSecTentGrpMembEditObj editObj = (ISecureSecTentGrpMembEditObj)focus.getEdit();
			if( editObj != null ) {
				if( editObj.getIsNew() ) {
					editObj.endEdit();
					editObj = null;
					setJavaFXFocus( null );
					setPaneMode( YCFPane.PaneMode.Unknown );
				}
				else {
					editObj.endEdit();
					editObj = null;
					setPaneMode( YCFPane.PaneMode.View );
				}
			}
		}
		if( ycfFormManager != null ) {
			if( ycfFormManager.getCurrentForm() == this ) {
				ycfFormManager.closeCurrentForm();
			}
		}
		if( formClosedCallback != null ) {
			formClosedCallback.formClosed( null );
		}
	}

	public ISecureJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof ISecureSecTentGrpMembObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecTentGrpMembObj" );
		}
		((ISecureJavaFXSecTentGrpMembPaneCommon)javafxViewEditPane).setJavaFXFocus( value );
		ISecureSecTentGrpMembObj argFocus = (ISecureSecTentGrpMembObj)value;
		if( ( argFocus != null ) && ( ! argFocus.getIsNew() ) ) {
			argFocus = (ISecureSecTentGrpMembObj)argFocus.read( true );
			super.setJavaFXFocus( argFocus );
		}
	}

	public ISecureSecTentGrpMembObj getJavaFXFocusAsSecTentGrpMemb() {
		return( (ISecureSecTentGrpMembObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSecTentGrpMemb( ISecureSecTentGrpMembObj value ) {
		setJavaFXFocus( value );
	}

	public YCFHBox getHBoxMenu() {
		if( hboxMenu == null ) {
			hboxMenu = new YCFHBox( 10 );
			buttonEdit = new YCFButton();
			buttonEdit.setMinWidth( 200 );
			buttonEdit.setText( "Edit" );
			buttonEdit.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						if( getJavaFXFocusAsSecTentGrpMemb() != null ) {
							if( null == getJavaFXFocusAsSecTentGrpMemb().getEdit() ) {
								setPaneMode( YCFPane.PaneMode.Edit );
							}
							else {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflibjavafx.common.CannotBeginEditAlreadyEditing"),
									Inz.s("ycflibjavafx.common.CannotBeginEditAlreadyEditing") );
							}
						}
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
					adjustButtons();
				}
			});
			hboxMenu.getChildren().add( buttonEdit );

			buttonSave = new YCFButton();
			buttonSave.setMinWidth( 200 );
			buttonSave.setText( "Save" );
			buttonSave.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ISecureSecTentGrpMembObj focus = getJavaFXFocusAsSecTentGrpMemb();
						if( focus != null ) {
							ISecureSecTentGrpMembEditObj editObj = (ISecureSecTentGrpMembEditObj)( focus.getEdit() );
							if( editObj == null ) {
								throw new YCFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"editObj" );
							}

							YCFPane.PaneMode oldMode = getPaneMode();
							try {
								setPaneMode( YCFPane.PaneMode.Update );
								setPaneMode( YCFPane.PaneMode.View );
							}
							catch( Throwable t ) {
								setPaneMode( oldMode );
								throw t;
							}
						}
						else {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"focus" );
						}
						dataChanged = true;
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
					adjustButtons();
				}
			});
			hboxMenu.getChildren().add( buttonSave );

			buttonClose = new YCFButton();
			buttonClose.setMinWidth( 200 );
			buttonClose.setText( "Close" );
			buttonClose.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ISecureSecTentGrpMembObj focus = getJavaFXFocusAsSecTentGrpMemb();
						if( focus != null ) {
							ISecureSecTentGrpMembEditObj editObj = (ISecureSecTentGrpMembEditObj)( focus.getEdit() );
							if( editObj == null ) {
								throw new YCFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"editObj" );
							}

							YCFPane.PaneMode oldMode = getPaneMode();
							try {
								setPaneMode( YCFPane.PaneMode.Update );
							}
							catch( Throwable t ) {
								setPaneMode( oldMode );
								throw t;
							}
							dataChanged = true;
						}
						else {
							throw new YCFLibNullArgumentException( getClass(),
								S_ProcName,
								0,
								"focus" );
						}
						ycfFormManager.closeCurrentForm();
						if( formClosedCallback != null ) {
							focus = getJavaFXFocusAsSecTentGrpMemb();
							formClosedCallback.formClosed( focus );
						}
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonClose );

			buttonCancel = new YCFButton();
			buttonCancel.setMinWidth( 200 );
			buttonCancel.setText( "Cancel" );
			buttonCancel.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						ISecureSecTentGrpMembObj focus = getJavaFXFocusAsSecTentGrpMemb();
						if( focus != null ) {
							ISecureSecTentGrpMembEditObj editObj = (ISecureSecTentGrpMembEditObj)focus.getEdit();
							if( editObj != null ) {
								if( editObj.getIsNew() ) {
									editObj.endEdit();
									editObj = null;
									setJavaFXFocus( null );
									setPaneMode( YCFPane.PaneMode.Unknown );
								}
								else {
									editObj.endEdit();
									editObj = null;
									setPaneMode( YCFPane.PaneMode.View );
								}
							}
						}
						ycfFormManager.closeCurrentForm();
						if( formClosedCallback != null ) {
							if( dataChanged ) {
								focus = getJavaFXFocusAsSecTentGrpMemb();
							}
							else {
								focus = null;
							}
							formClosedCallback.formClosed( focus );
						}
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			hboxMenu.getChildren().add( buttonCancel );

		}
		return( hboxMenu );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		YCFPane.PaneMode oldMode = getPaneMode();
		if( oldMode == value ) {
			return;
		}
		try {
			super.setPaneMode( value );
			((ISecureJavaFXSecTentGrpMembPaneCommon)javafxViewEditPane).setPaneMode( value );
		}
		catch( Throwable t ) {
			super.setPaneMode( oldMode );
			((ISecureJavaFXSecTentGrpMembPaneCommon)javafxViewEditPane).setPaneMode( oldMode );
			throw t;
		}
		adjustButtons();
	}

	public void adjustButtons() {
		YCFPane.PaneMode value = getPaneMode();
		if( value == YCFPane.PaneMode.View ) {
			if( buttonEdit != null ) {
				buttonEdit.setDisable( false );
			}
			if( buttonSave != null ) {
				buttonSave.setDisable( true );
			}
			if( buttonCancel != null ) {
				buttonCancel.setDisable( false );
			}
			if( buttonClose != null ) {
				buttonClose.setDisable( true );
			}
		}
		else if( value == YCFPane.PaneMode.Edit ) {
			if( buttonEdit != null ) {
				buttonEdit.setDisable( true );
			}
			if( buttonSave != null ) {
				buttonSave.setDisable( false );
			}
			if( buttonCancel != null ) {
				buttonCancel.setDisable( false );
			}
			if( buttonClose != null ) {
				buttonClose.setDisable( false );
			}
		}
		else if( value == YCFPane.PaneMode.Add ) {
			if( buttonEdit != null ) {
				buttonEdit.setDisable( true );
			}
			if( buttonSave != null ) {
				buttonSave.setDisable( false );
			}
			if( buttonClose != null ) {
				buttonClose.setDisable( false );
			}
			if( buttonCancel != null ) {
				buttonCancel.setDisable( false );
			}
		}
		else {
			if( buttonEdit != null ) {
				buttonEdit.setDisable( true );
			}
			if( buttonSave != null ) {
				buttonSave.setDisable( true );
			}
			if( buttonCancel != null ) {
				buttonCancel.setDisable( false );
			}
			if( buttonClose != null ) {
				buttonClose.setDisable( true );
			}
		}
	}
}
