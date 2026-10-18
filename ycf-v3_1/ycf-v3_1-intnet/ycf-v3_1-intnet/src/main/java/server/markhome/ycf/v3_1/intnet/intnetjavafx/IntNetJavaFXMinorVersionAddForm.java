// Description: Java 25 JavaFX Add Form implementation for MinorVersion.

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

import java.time.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.javafx.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;

/**
 *	IntNetJavaFXMinorVersionAddForm JavaFX Add Form implementation
 *	for MinorVersion.
 */
public class IntNetJavaFXMinorVersionAddForm
extends YCFBorderPane
implements IIntNetJavaFXMinorVersionPaneCommon,
	IYCFForm
{
	public static String S_FormName = "Add MinorVersion";
	protected IYCFFormManager ycfFormManager = null;
	protected IIntNetJavaFXSchema javafxSchema = null;
	protected IYCFFormClosedCallback formClosedCallback = null;
	protected boolean allowSave = true;
	protected YCFSplitPane javafxAddPane = null;
	protected YCFButton buttonSave = null;
	protected YCFButton buttonCancel = null;
	protected YCFButton buttonClose = null;
	protected ScrollPane scrollMenu = null;
	protected YCFHBox hboxMenu = null;

	public IntNetJavaFXMinorVersionAddForm( IYCFFormManager formManager, IIntNetJavaFXSchema argSchema, IIntNetMinorVersionObj argFocus, IYCFFormClosedCallback closeCallback, boolean argAllowSave ) {
		super();
		final String S_ProcName = "construct-schema-focus";
		allowSave = argAllowSave;
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
			argFocus = (IIntNetMinorVersionObj)argFocus.read( true );
			javaFXFocus = argFocus;
		}
		javafxAddPane = argSchema.getMinorVersionFactory().newAddPane( ycfFormManager, argFocus );

		scrollMenu = new ScrollPane();
		scrollMenu.setVbarPolicy( ScrollBarPolicy.NEVER );
		scrollMenu.setHbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollMenu.setFitToHeight( true );
		scrollMenu.setContent( getHBoxMenu() );

		setTop( scrollMenu );
		setCenter( javafxAddPane );
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
		IIntNetMinorVersionObj focus = getJavaFXFocusAsMinorVersion();
		if( focus != null ) {
			IIntNetMinorVersionEditObj editObj = (IIntNetMinorVersionEditObj)focus.getEdit();
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

	public IIntNetJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public IYCFLibAnyObj getJavaFXFocus() {
		IYCFLibAnyObj obj;
		if( javafxAddPane != null ) {
			obj = javafxAddPane.getJavaFXFocus();
		}
		else {
			obj = null;
		}
		return( obj );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof IIntNetMinorVersionObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IIntNetMinorVersionObj" );
		}
		((IIntNetJavaFXMinorVersionPaneCommon)javafxAddPane).setJavaFXFocus( value );
		IIntNetMinorVersionObj argFocus = (IIntNetMinorVersionObj)value;
		if( ( argFocus != null ) && ( ! argFocus.getIsNew() ) ) {
			argFocus = (IIntNetMinorVersionObj)argFocus.read( true );
			super.setJavaFXFocus( argFocus );
		}
	}

	public IIntNetMinorVersionObj getJavaFXFocusAsMinorVersion() {
		return( (IIntNetMinorVersionObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsMinorVersion( IIntNetMinorVersionObj value ) {
		setJavaFXFocus( value );
	}

	public YCFHBox getHBoxMenu() {
		if( hboxMenu == null ) {
			hboxMenu = new YCFHBox( 10 );
			buttonSave = new YCFButton();
			buttonSave.setMinWidth( 200 );
			buttonSave.setText( "Save" );
			buttonSave.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						IIntNetMinorVersionObj focus = getJavaFXFocusAsMinorVersion();
						if( focus != null ) {
							IIntNetMinorVersionEditObj editObj = (IIntNetMinorVersionEditObj)( focus.getEdit() );
							if( editObj != null ) {
								setPaneMode( YCFPane.PaneMode.Update );
							}
							else {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflib.common.CannotSaveUneditedObject"),
									Inz.s("ycflib.common.CannotSaveUneditedObject") );
							}
						}
						// If an object was added, the focus will change to the persisted instance
						focus = getJavaFXFocusAsMinorVersion();
						YCFBorderPane frame = javafxSchema.getMinorVersionFactory().newViewEditForm( ycfFormManager, focus, formClosedCallback, true );
						((IIntNetJavaFXMinorVersionPaneCommon)frame).setPaneMode( YCFPane.PaneMode.View );
						ycfFormManager.closeCurrentForm();
						ycfFormManager.pushForm( frame );
					}
					catch( Throwable t ) {
						YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
					}
				}
			});
			if( allowSave ) {
				hboxMenu.getChildren().add( buttonSave );
			}

			buttonClose = new YCFButton();
			buttonClose.setMinWidth( 200 );
			buttonClose.setText( "Close" );
			buttonClose.setOnAction( new EventHandler<ActionEvent>() {
				@Override public void handle( ActionEvent e ) {
					final String S_ProcName = "handle";
					try {
						IIntNetMinorVersionObj focus = getJavaFXFocusAsMinorVersion();
						if( focus != null ) {
							IIntNetMinorVersionEditObj editObj = (IIntNetMinorVersionEditObj)( focus.getEdit() );
							if( editObj != null ) {
								setPaneMode( YCFPane.PaneMode.Update );
							}
							else {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflib.common.CannotSaveUneditedObject"),
									Inz.s("ycflib.common.CannotSaveUneditedObject") );
							}
						}
						// If an object was added, the focus will change to the persisted instance
						focus = getJavaFXFocusAsMinorVersion();
						ycfFormManager.closeCurrentForm();
						if( formClosedCallback != null ) {
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
						IIntNetMinorVersionObj focus = getJavaFXFocusAsMinorVersion();
						if( focus != null ) {
							IIntNetMinorVersionEditObj editObj = (IIntNetMinorVersionEditObj)focus.getEdit();
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
							formClosedCallback.formClosed( null );
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
			((IIntNetJavaFXMinorVersionPaneCommon)javafxAddPane).setPaneMode( value );
		}
		catch( Throwable t ) {
			super.setPaneMode( oldMode );
			((IIntNetJavaFXMinorVersionPaneCommon)javafxAddPane).setPaneMode( oldMode );
			throw t;
		}
		if( value == YCFPane.PaneMode.View ) {
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
		else {
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
