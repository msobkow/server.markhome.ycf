// Description: Java 25 JavaFX Attribute Pane implementation for SecSysGrpInc.

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
 *	SecureJavaFXSecSysGrpIncAttrPane JavaFX Attribute Pane implementation
 *	for SecSysGrpInc.
 */
public class SecureJavaFXSecSysGrpIncAttrPane
extends YCFGridPane
implements ISecureJavaFXSecSysGrpIncPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	boolean javafxIsInitializing = true;

	protected class SecSysGrpIncSubGroupYCFLabel
		extends YCFLabel
	{
		public SecSysGrpIncSubGroupYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecSysGrpInc.AttrPane.ParentSubGroup.EffLabel"));
		}
	}

	protected class CallbackSecSysGrpIncSubGroupChosen
	implements ISecureJavaFXSecSysGrpChosen
	{
		public CallbackSecSysGrpIncSubGroupChosen() {
		}

		public void choseSecSysGrp( ISecureSecSysGrpObj value ) {
			if( javafxReferenceParentSubGroup != null ) {
				ISecureSecSysGrpIncObj cur = getJavaFXFocusAsSecSysGrpInc();
				if( cur != null ) {
					ISecureSecSysGrpIncEditObj editObj = (ISecureSecSysGrpIncEditObj)cur.getEdit();
					if( null != editObj ) {
						YCFPane.PaneMode curMode = getPaneMode();
						if( ( curMode == YCFPane.PaneMode.Add ) || ( curMode == YCFPane.PaneMode.Edit ) ) {
							javafxReferenceParentSubGroup.setReferencedObject( value );
							editObj.setRequiredParentSubGroup( value );
						}
					}
				}
			}
		}
	}

	protected class SecSysGrpIncSubGroupReferenceCallback
	implements IYCFReferenceCallback
	{
		public void chose( IYCFLibAnyObj value ) {
			final String S_ProcName = "chose";
			Node cont;
			ISecureSchemaObj schemaObj = (ISecureSchemaObj)javafxSchema.getSchema();
			ISecureSecSysGrpIncObj focus = getEffJavaFXFocus();
			ISecureSecSysGrpObj referencedObj = (ISecureSecSysGrpObj)javafxReferenceParentSubGroup.getReferencedObject();
			java.util.List<ISecureSecSysGrpObj> listOfSecSysGrp = null;
			listOfSecSysGrp = schemaObj.getSecSysGrpTableObj().readAllSecSysGrp();
			if( listOfSecSysGrp == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfSecSysGrp" );
			}
			Collection<ISecureSecSysGrpObj> cltn = listOfSecSysGrp;
			YCFBorderPane form = javafxSchema.getSecSysGrpFactory().newPickerForm( ycfFormManager, referencedObj, null, cltn, new CallbackSecSysGrpIncSubGroupChosen() );
			((ISecureJavaFXSecSysGrpPaneCommon)form).setPaneMode( YCFPane.PaneMode.View );
			ycfFormManager.pushForm( form );
		}

		public void view( IYCFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			ISecureSecSysGrpIncObj focus = getEffJavaFXFocus();
			if( focus != null ) {
				ISecureSecSysGrpObj referencedObj = (ISecureSecSysGrpObj)javafxReferenceParentSubGroup.getReferencedObject();
				YCFBorderPane form = null;
				if( referencedObj != null ) {
					int classCode = referencedObj.getClassCode();
					ISecureSchema.ClassMapEntry entry = ISecureSchema.getClassMapByRuntimeClassCode(classCode);
					int backingClassCode = entry.getBackingClassCode();
					if( entry.getSchemaName().equals("Secure") && backingClassCode == ISecureSecSysGrp.CLASS_CODE ) {
						form = javafxSchema.getSecSysGrpFactory().newAddForm( ycfFormManager, referencedObj, null, true );
						ISecureJavaFXSecSysGrpPaneCommon spec = (ISecureJavaFXSecSysGrpPaneCommon)form;
						spec.setJavaFXFocus( referencedObj );
						spec.setPaneMode( YCFPane.PaneMode.View );
					}
					else {
						throw new YCFLibUnsupportedClassException( getClass(),
							S_ProcName,
							"javaFXFocus",
							focus,
							"ISecureSecSysGrpObj" );
					}
					ycfFormManager.pushForm( form );
				}
			}
		}
	}

	protected class SecSysGrpIncSubGroupYCFReferenceEditor
		extends YCFReferenceEditor
	{
		public SecSysGrpIncSubGroupYCFReferenceEditor() {
			super( new SecSysGrpIncSubGroupReferenceCallback() );
			setFieldNameInzTag( "secure.javafx.SecSysGrpInc.AttrPane.SecSysGrpIncSubGroup.EffLabel" );
		}
	}

	protected ISecureSecSysGrpObj javafxParentSubGroupObj = null;
	protected SecSysGrpIncSubGroupYCFLabel javafxLabelParentSubGroup = null;
	protected SecSysGrpIncSubGroupYCFReferenceEditor javafxReferenceParentSubGroup = null;

	public SecureJavaFXSecSysGrpIncAttrPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureSecSysGrpIncObj argFocus ) {
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
		setJavaFXFocusAsSecSysGrpInc( argFocus );
		setPadding( new Insets(5) );
		setHgap( 5 );
		setVgap( 5 );
		setAlignment( Pos.CENTER );
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth( 100 );
		getColumnConstraints().addAll( column1 );
		int gridRow = 0;
		label = getJavaFXLabelParentSubGroup();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		reference = getJavaFXReferenceParentSubGroup();
		setHalignment( reference, HPos.LEFT );
		add( reference, 0, gridRow );
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
		if( ( value == null ) || ( value instanceof ISecureSecSysGrpIncObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecSysGrpIncObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ISecureSecSysGrpIncObj getJavaFXFocusAsSecSysGrpInc() {
		return( (ISecureSecSysGrpIncObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSecSysGrpInc( ISecureSecSysGrpIncObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureSecSysGrpIncObj getEffJavaFXFocus() {
		ISecureSecSysGrpIncObj eff = (ISecureSecSysGrpIncObj)getJavaFXFocus();
		if( eff != null ) {
			if( null != eff.getEdit() ) {
				eff = (ISecureSecSysGrpIncObj)eff.getEdit();
			}
		}
		return( eff );
	}

	public ISecureSecSysGrpObj getJavaFXParentSubGroupObj() {
		return( javafxParentSubGroupObj );
	}

	public void setJavaFXParentSubGroupObj( ISecureSecSysGrpObj value ) {
		javafxParentSubGroupObj = value;
	}

	public YCFLabel getJavaFXLabelParentSubGroup() {
		if( javafxLabelParentSubGroup == null ) {
			javafxLabelParentSubGroup = new SecSysGrpIncSubGroupYCFLabel();
		}
		return( javafxLabelParentSubGroup );
	}

	public YCFReferenceEditor getJavaFXReferenceParentSubGroup() {
		if( javafxReferenceParentSubGroup == null ) {
			javafxReferenceParentSubGroup = new SecSysGrpIncSubGroupYCFReferenceEditor();
		}
		return( javafxReferenceParentSubGroup );
	}

	public void setJavaFXReferenceParentSubGroup( SecSysGrpIncSubGroupYCFReferenceEditor value ) {
		javafxReferenceParentSubGroup = value;
	}

	public void populateFields()
	{
		ISecureSecSysGrpIncObj popObj = getEffJavaFXFocus();
		if( getPaneMode() == YCFPane.PaneMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			javafxParentSubGroupObj = null;
		}
		else {
			javafxParentSubGroupObj = (ISecureSecSysGrpObj)popObj.getRequiredParentSubGroup( javafxIsInitializing );
		}
		if( javafxReferenceParentSubGroup != null ) {
			javafxReferenceParentSubGroup.setReferencedObject( javafxParentSubGroupObj );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ISecureSecSysGrpIncObj focus = getJavaFXFocusAsSecSysGrpInc();
		ISecureSecSysGrpIncEditObj editObj;
		if( focus != null ) {
			editObj = (ISecureSecSysGrpIncEditObj)(focus.getEdit());
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

		javafxParentSubGroupObj = (ISecureSecSysGrpObj)( javafxReferenceParentSubGroup.getReferencedObject() );
		editObj.setRequiredParentSubGroup( javafxParentSubGroupObj );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		YCFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		ISecureSecSysGrpIncObj focus = getJavaFXFocusAsSecSysGrpInc();
		if( ( value != YCFPane.PaneMode.Unknown ) && ( value != YCFPane.PaneMode.View ) ) {
			if( focus == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"javaFXFocus" );
			}
		}
		ISecureSecSysGrpIncEditObj editObj;
		if( focus != null ) {
			editObj  = (ISecureSecSysGrpIncEditObj)focus.getEdit();
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
								editObj = (ISecureSecSysGrpIncEditObj)focus.beginEdit();
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
							editObj = (ISecureSecSysGrpIncEditObj)focus.beginEdit();
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
							editObj = (ISecureSecSysGrpIncEditObj)focus.beginEdit();
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
							editObj = (ISecureSecSysGrpIncEditObj)focus.beginEdit();
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
						focus = (ISecureSecSysGrpIncObj)editObj.create();
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
								editObj = (ISecureSecSysGrpIncEditObj)focus.beginEdit();
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
								editObj = (ISecureSecSysGrpIncEditObj)focus.beginEdit();
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
							editObj = (ISecureSecSysGrpIncEditObj)focus.beginEdit();
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
			ISecureSecSysGrpIncObj focus = getJavaFXFocusAsSecSysGrpInc();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( javafxReferenceParentSubGroup != null ) {
			javafxReferenceParentSubGroup.setCustomDisable( ! isEditing );
		}
	}
}
