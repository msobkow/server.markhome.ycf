// Description: Java 25 JavaFX Ask Delete Pane implementation for Cluster.

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

import java.time.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.javafx.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

/**
 *	SecureJavaFXClusterAskDeleteForm JavaFX Ask Delete Pane implementation
 *	for Cluster.
 */
public class SecureJavaFXClusterAskDeleteForm
extends YCFBorderPane
implements ISecureJavaFXClusterPaneCommon,
	IYCFForm
{
	public static String S_FormName = "Ask Delete Cluster";
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	protected IYCFDeleteCallback deleteCallback = null;
	protected YCFTextArea textAreaMessage = null;
	protected YCFHBox hboxButtons = null;
	protected YCFButton buttonOk = null;
	protected YCFButton buttonCancel = null;
	protected ScrollPane scrollPane = null;
	protected YCFGridPane attrPane = null;

	public SecureJavaFXClusterAskDeleteForm( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureClusterObj argFocus, IYCFDeleteCallback callback ) {
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
		deleteCallback = callback;
		// Construct the various objects
		textAreaMessage = new YCFTextArea();
		textAreaMessage.setText( "Are you sure you want to delete this Cluster?" );
		hboxButtons = new YCFHBox( 10 );
		buttonOk = new YCFButton();
		buttonOk.setMinWidth( 200 );
		buttonOk.setText( "Ok" );
		buttonOk.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				final String S_ProcName = "actionOkPerformed";
				try {
					ISecureClusterObj obj = getJavaFXFocusAsCluster();
					ISecureClusterEditObj editObj = (ISecureClusterEditObj)obj.beginEdit();
					editObj.deleteInstance();
					editObj = null;
					ycfFormManager.closeCurrentForm();
					if( deleteCallback != null ) {
						deleteCallback.formClosed( null );
						deleteCallback.deleted( obj );
					}
				}
				catch( Throwable t ) {
					YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
				}
			}
		});
		buttonCancel = new YCFButton();
		buttonCancel.setMinWidth( 200 );
		buttonCancel.setText( "Cancel" );
		buttonCancel.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				final String S_ProcName = "actionCancelPerformed";
				try {
					ycfFormManager.closeCurrentForm();
					if( deleteCallback != null ) {
						deleteCallback.formClosed( null );
					}
				}
				catch( Throwable t ) {
					YCFConsole.formException( S_FormName, ((YCFButton)e.getSource()).getText(), t );
				}
			}
		});
		hboxButtons.getChildren().addAll( buttonOk, buttonCancel );
		attrPane = argSchema.getClusterFactory().newAttrPane( ycfFormManager, argFocus );
		scrollPane = new ScrollPane();
		scrollPane.setFitToWidth( true );
		scrollPane.setHbarPolicy( ScrollBarPolicy.NEVER );
		scrollPane.setVbarPolicy( ScrollBarPolicy.AS_NEEDED );
		scrollPane.setContent( attrPane );
		setTop( textAreaMessage );
		setCenter( scrollPane );
		setBottom( hboxButtons );
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
		if( ( value == null ) || ( value instanceof ISecureClusterObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureClusterObj" );
		}
	}

	public ISecureClusterObj getJavaFXFocusAsCluster() {
		return( (ISecureClusterObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsCluster( ISecureClusterObj value ) {
		javaFXFocus = value;
		if( attrPane != null ) {
			((ISecureJavaFXClusterPaneCommon)attrPane).setJavaFXFocus( value );
		}
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		YCFPane.PaneMode oldMode = getPaneMode();
		if( oldMode == value ) {
			return;
		}
		if( ( value != YCFPane.PaneMode.Unknown )
		 && ( value != YCFPane.PaneMode.View )
		 && ( value != YCFPane.PaneMode.Delete ) )
		{
			throw new YCFLibUsageException( getClass(),
				S_ProcName,
				Inz.x("ycflibjavafx.common.AskDeleteFormModes"),
				Inz.s("ycflibjavafx.common.AskDeleteFormModes") );
		}
		super.setPaneMode( value );
		if( attrPane != null ) {
			((ISecureJavaFXClusterPaneCommon)attrPane).setPaneMode( value );
		}
	}

	public void forceCancelAndClose() {
		ISecureClusterObj focus = getJavaFXFocusAsCluster();
		if( ycfFormManager != null ) {
			if( ycfFormManager.getCurrentForm() == this ) {
				ycfFormManager.closeCurrentForm();
			}
		}
		if( deleteCallback != null ) {
			deleteCallback.formClosed( null );
		}
	}
}
