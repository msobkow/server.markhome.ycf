// Description: Java 25 JavaFX Attribute Pane implementation for SecTentRole.

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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.javafx.*;
import server.markhome.ycf.javafx.YCFReferenceEditor.IYCFReferenceCallback;
import org.apache.commons.codec.binaryYCFCore64;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

/**
 *	SecureJavaFXSecTentRoleAttrPane JavaFX Attribute Pane implementation
 *	for SecTentRole.
 */
public class SecureJavaFXSecTentRoleAttrPane
extends YCFGridPane
implements ISecureJavaFXSecTentRolePaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	boolean javafxIsInitializing = true;

	protected class SecTentRoleIdYCFLabel
		extends YCFLabel
	{
		public SecTentRoleIdYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecTentRole.AttrPane.SecTentRoleId.EffLabel"));
		}
	}

	protected class SecTentRoleIdEditor
		extends YCFDbKeyHash256Editor
	{
		public SecTentRoleIdEditor() {
			super();
			setFieldNameInzTag( "secure.javafx.SecTentRole.AttrPane.SecTentRoleId.EffLabel" );
		}
	}

	protected SecTentRoleIdYCFLabel javafxLabelSecTentRoleId = null;
	protected SecTentRoleIdEditor javafxEditorSecTentRoleId = null;

	public SecureJavaFXSecTentRoleAttrPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureSecTentRoleObj argFocus ) {
		super();
		Control ctrl;
		YCFLabel label;
		YCFReferenceEditor reference;
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
		setJavaFXFocusAsSecTentRole( argFocus );
		setPadding( new Insets(5) );
		setHgap( 5 );
		setVgap( 5 );
		setAlignment( Pos.CENTER );
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth( 100 );
		getColumnConstraints().addAll( column1 );
		int gridRow = 0;
		label = getJavaFXLabelSecTentRoleId();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorSecTentRoleId();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		populateFields();
		adjustComponentEnableStates();
		javafxIsInitializing = false;
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
		if( ( value == null ) || ( value instanceof ISecureSecTentRoleObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecTentRoleObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ISecureSecTentRoleObj getJavaFXFocusAsSecTentRole() {
		return( (ISecureSecTentRoleObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSecTentRole( ISecureSecTentRoleObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureSecTentRoleObj getEffJavaFXFocus() {
		ISecureSecTentRoleObj eff = (ISecureSecTentRoleObj)getJavaFXFocus();
		if( eff != null ) {
			if( null != eff.getEdit() ) {
				eff = (ISecureSecTentRoleObj)eff.getEdit();
			}
		}
		return( eff );
	}

	public SecTentRoleIdYCFLabel getJavaFXLabelSecTentRoleId() {
		if( javafxLabelSecTentRoleId == null ) {
			javafxLabelSecTentRoleId = new SecTentRoleIdYCFLabel();
		}
		return( javafxLabelSecTentRoleId );
	}

	public void setJavaFXLabelSecTentRoleId( SecTentRoleIdYCFLabel value ) {
		javafxLabelSecTentRoleId = value;
	}

	public SecTentRoleIdEditor getJavaFXEditorSecTentRoleId() {
		if( javafxEditorSecTentRoleId == null ) {
			javafxEditorSecTentRoleId = new SecTentRoleIdEditor();
		}
		return( javafxEditorSecTentRoleId );
	}

	public void setJavaFXEditorSecTentRoleId( SecTentRoleIdEditor value ) {
		javafxEditorSecTentRoleId = value;
	}

	public void populateFields()
	{
		ISecureSecTentRoleObj popObj = getEffJavaFXFocus();
		if( getPaneMode() == YCFPane.PaneMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			getJavaFXEditorSecTentRoleId().setDbKeyHash256Value( null );
		}
		else {
			getJavaFXEditorSecTentRoleId().setDbKeyHash256Value( popObj.getRequiredSecTentRoleId() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ISecureSecTentRoleObj focus = getJavaFXFocusAsSecTentRole();
		ISecureSecTentRoleEditObj editObj;
		if( focus != null ) {
			editObj = (ISecureSecTentRoleEditObj)(focus.getEdit());
		}
		else {
			editObj = null;
		}
		if( editObj == null ) {
			throw new YCFLibUsageException( getClass(),
				S_ProcName,
				Inz.s("ycflibjavafx.common.PaneIsUnfocusedOrNotEditing"),
				Inz.x("ycflibjavafx.common.PaneIsUnfocusedOrNotEditing") );
		}
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		YCFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		ISecureSecTentRoleObj focus = getJavaFXFocusAsSecTentRole();
		if( ( value != YCFPane.PaneMode.Unknown ) && ( value != YCFPane.PaneMode.View ) ) {
			if( focus == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"javaFXFocus" );
			}
		}
		ISecureSecTentRoleEditObj editObj;
		if( focus != null ) {
			editObj  = (ISecureSecTentRoleEditObj)focus.getEdit();
		}
		else {
			editObj = null;
		}
		switch( value ) {
			case Unknown:
				switch( oldValue ) {
					case Unknown:
						break;
					default:
						if( editObj != null ) {
							editObj.endEdit();
							editObj = null;
						}
						break;
				}
				break;
			case Add:
				switch( oldValue ) {
					case Unknown:
					case Add:
					case View:
						if( editObj == null ) {
							if( focus != null ) {
								if( ! focus.getIsNew() ) {
									throw new YCFLibUsageException( getClass(),
										S_ProcName,
										Inz.x("ycflibjavafx.common.MustBeNew"),
										Inz.s("ycflibjavafx.common.MustBeNew") );
								}
								editObj = (ISecureSecTentRoleEditObj)focus.beginEdit();
								if( editObj == null ) {
									throw new YCFLibUsageException( getClass(),
										S_ProcName,
										Inz.x("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition"),
										Inz.s("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition") );
								}
							}
							else {
								throw new YCFLibNullArgumentException( getClass(),
									S_ProcName,
									0,
									"focus" );
							}
						}
						break;
					case Edit:
						throw new YCFLibUsageException( getClass(),
							S_ProcName,
							Inz.x("ycflibjavafx.common.CannotTransitionEditToAdd"),
							Inz.s("ycflibjavafx.common.CannotTransitionEditToAdd") );
					case Update:
						if( ( editObj == null ) || ( ! editObj.getIsNew() ) ) {
							throw new YCFLibUsageException( getClass(),
								S_ProcName,
								Inz.x("ycflibjavafx.common.CannotTransitionUpdateToAdd"),
								Inz.s("ycflibjavafx.common.CannotTransitionUpdateToAdd") );
						}
						break;
					case Delete:
						throw new YCFLibUsageException( getClass(),
							S_ProcName,
							Inz.x("ycflibjavafx.common.CannotTransitionDeleteToAdd"),
							Inz.s("ycflibjavafx.common.CannotTransitionDeleteToAdd") );
					default:
						throw new YCFLibUsageException( getClass(),
							S_ProcName,
							Inz.x("ycflibjavafx.common.CannotTransitionDefaultToAdd"),
							Inz.s("ycflibjavafx.common.CannotTransitionDefaultToAdd") );
				}
				break;
			case View:
				switch( oldValue ) {
					case Unknown:
						break;
					case View:
						break;
					case Edit:
						break;
					case Update:
						break;
					case Delete:
						break;
					default:
						throw new YCFLibUsageException( getClass(),
							S_ProcName,
							String.format(Inz.x("ycflibjavafx.common.CannotTransitionOldValueToView"), oldValue),
							String.format(Inz.s("ycflibjavafx.common.CannotTransitionOldValueToView"), oldValue) );
				}
				if( editObj != null ) {
					editObj.endEdit();
					editObj = null;
				}
				break;
			case Edit:
				switch( oldValue ) {
					case Unknown:
						if( editObj == null ) {
							editObj = (ISecureSecTentRoleEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition"),
									Inz.s("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition") );
							}
						}
						break;
					case View:
						if( editObj == null ) {
							editObj = (ISecureSecTentRoleEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition"),
									Inz.s("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition") );
							}
						}
						break;
					case Edit:
						if( editObj == null ) {
							editObj = (ISecureSecTentRoleEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition"),
									Inz.s("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition") );
							}
						}
						break;
					case Update:
						if( editObj == null ) {
							throw new YCFLibUsageException( getClass(),
								S_ProcName,
								String.format(Inz.x("ycflibjavafx.common.CannotTransitionOldValueToEdit"), oldValue),
								String.format(Inz.s("ycflibjavafx.common.CannotTransitionOldValueToEdit"), oldValue) );
						}
						break;
					default:
						throw new YCFLibUsageException( getClass(),
							S_ProcName,
							String.format(Inz.x("ycflibjavafx.common.CannotTransitionOldValueToEdit"), oldValue),
							String.format(Inz.s("ycflibjavafx.common.CannotTransitionOldValueToEdit"), oldValue) );
				}
				break;
			case Update:
				if( ( oldValue != YCFPane.PaneMode.Edit ) && ( oldValue != YCFPane.PaneMode.Add ) ) {
					throw new YCFLibUsageException( getClass(),
						S_ProcName,
						String.format(Inz.x("ycflibjavafx.common.CannotTransitionOldValueToUpdate"), oldValue),
						String.format(Inz.s("ycflibjavafx.common.CannotTransitionOldValueToUpdate"), oldValue) );
				}
				super.setPaneMode( value );
				if( editObj != null ) {
					postFields();
					if( editObj.getIsNew() ) {
						focus = (ISecureSecTentRoleObj)editObj.create();
						setJavaFXFocus( focus );
					}
					else {
						editObj.update();
					}
					editObj = null;
				}
				setPaneMode( YCFPane.PaneMode.View );
				break;
			case Delete:
				switch( oldValue ) {
					case View:
						if( focus != null ) {
							if( editObj == null ) {
								editObj = (ISecureSecTentRoleEditObj)focus.beginEdit();
								if( editObj == null ) {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition"),
									Inz.s("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition") );
								}
							}
						}
						break;
					case Edit:
						if( focus != null ) {
							if( editObj == null ) {
								editObj = (ISecureSecTentRoleEditObj)focus.beginEdit();
								if( editObj == null ) {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition"),
									Inz.s("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition") );
								}
							}
						}
						break;
					case Update:
						throw new YCFLibUsageException( getClass(),
							S_ProcName,
							String.format(Inz.x("ycflibjavafx.common.CannotTransitionOldValueToDelete"), oldValue),
							String.format(Inz.s("ycflibjavafx.common.CannotTransitionOldValueToDelete"), oldValue) );
					case Delete:
						if( editObj == null ) {
							editObj = (ISecureSecTentRoleEditObj)focus.beginEdit();
							if( editObj == null ) {
								throw new YCFLibUsageException( getClass(),
									S_ProcName,
									Inz.x("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition"),
									Inz.s("ycflibjavafx.common.ExpectedBeginEditToReturnNewEdition") );
							}
						}
						break;
					default:
						throw new YCFLibUsageException( getClass(),
							S_ProcName,
							String.format(Inz.x("ycflibjavafx.common.CannotTransitionOldValueToDelete"), oldValue),
							String.format(Inz.s("ycflibjavafx.common.CannotTransitionOldValueToDelete"), oldValue) );
				}
				editObj.deleteInstance();
				editObj = null;
				setJavaFXFocus( null );
				setPaneMode( YCFPane.PaneMode.Unknown );
				break;
			default:
				switch( oldValue ) {
					case Unknown:
						break;
					default:
						if( editObj != null ) {
							editObj.endEdit();
							editObj = null;
						}
						break;
				}
				break;
		}
		super.setPaneMode( value );
		populateFields();
		adjustComponentEnableStates();
	}

	public void adjustComponentEnableStates() {
		YCFPane.PaneMode mode = getPaneMode();
		boolean isEditing;
		switch( mode ) {
			case Unknown:
			case View:
			case Delete:
				isEditing = false;
				break;
			case Add:
			case Edit:
			case Update:
				isEditing = true;
				break;
			default:
				isEditing = false;
				break;
		}
		if( isEditing ) {
			ISecureSecTentRoleObj focus = getJavaFXFocusAsSecTentRole();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( javafxEditorSecTentRoleId != null ) {
			javafxEditorSecTentRoleId.setDisable( true );
		}
	}
}
