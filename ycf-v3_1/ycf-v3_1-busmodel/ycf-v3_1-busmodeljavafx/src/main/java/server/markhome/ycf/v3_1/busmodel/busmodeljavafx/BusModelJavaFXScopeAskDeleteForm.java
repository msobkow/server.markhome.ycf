// Description: Java 25 JavaFX Ask Delete Pane implementation for Scope.

/*
 *	server.markhome.ycf.BusModel
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal BusModel 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Yorkton Code Fractal BusModel.
 *	
 *	Yorkton Code Fractal BusModel is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU General Public License,
 *	Version 3 or later with classpath and static linking exceptions.
 *	
 *	As a special exception, Mark Sobkow gives you permission to link this library
 *	with independent modules to produce an executable, provided that none of them
 *	conflict with the intent of the GPLv3; that is, you are not allowed to invoke
 *	the methods of this library from non-GPLv3-compatibly licensed code. You may not
 *	implement an LPGLv3 "wedge" to try to bypass this restriction. That said, code which
 *	does not rely on this library is free to specify whatever license its authors decide
 *	to use. Mark Sobkow specifically rejects the infectious nature of the GPLv3, and
 *	considers the mere act of including GPLv3 modules in an executable to be perfectly
 *	reasonable given tools like modern Java's single-jar deployment options.
 *	
 *	Yorkton Code Fractal BusModel is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Yorkton Code Fractal BusModel is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Yorkton Code Fractal BusModel.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.ycf.v3_1.busmodel.busmodeljavafx;

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
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;

/**
 *	BusModelJavaFXScopeAskDeleteForm JavaFX Ask Delete Pane implementation
 *	for Scope.
 */
public class BusModelJavaFXScopeAskDeleteForm
extends YCFBorderPane
implements IBusModelJavaFXScopePaneCommon,
	IYCFForm
{
	public static String S_FormName = "Ask Delete Scope";
	protected IYCFFormManager ycfFormManager = null;
	protected IBusModelJavaFXSchema javafxSchema = null;
	protected IYCFDeleteCallback deleteCallback = null;
	protected YCFTextArea textAreaMessage = null;
	protected YCFHBox hboxButtons = null;
	protected YCFButton buttonOk = null;
	protected YCFButton buttonCancel = null;
	protected ScrollPane scrollPane = null;
	protected YCFGridPane attrPane = null;

	public BusModelJavaFXScopeAskDeleteForm( IYCFFormManager formManager, IBusModelJavaFXSchema argSchema, IBusModelScopeObj argFocus, IYCFDeleteCallback callback ) {
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
		textAreaMessage.setText( "Are you sure you want to delete this Scope?" );
		hboxButtons = new YCFHBox( 10 );
		buttonOk = new YCFButton();
		buttonOk.setMinWidth( 200 );
		buttonOk.setText( "Ok" );
		buttonOk.setOnAction( new EventHandler<ActionEvent>() {
			@Override public void handle( ActionEvent e ) {
				final String S_ProcName = "actionOkPerformed";
				try {
					IBusModelScopeObj obj = getJavaFXFocusAsScope();
					IBusModelScopeEditObj editObj = (IBusModelScopeEditObj)obj.beginEdit();
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
		attrPane = argSchema.getScopeFactory().newAttrPane( ycfFormManager, argFocus );
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

	public IBusModelJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof IBusModelScopeObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IBusModelScopeObj" );
		}
	}

	public IBusModelScopeObj getJavaFXFocusAsScope() {
		return( (IBusModelScopeObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsScope( IBusModelScopeObj value ) {
		javaFXFocus = value;
		if( attrPane != null ) {
			((IBusModelJavaFXScopePaneCommon)attrPane).setJavaFXFocus( value );
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
			((IBusModelJavaFXScopePaneCommon)attrPane).setPaneMode( value );
		}
	}

	public void forceCancelAndClose() {
		IBusModelScopeObj focus = getJavaFXFocusAsScope();
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
