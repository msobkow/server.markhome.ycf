// Description: Java 25 JavaFX Attribute Pane implementation for SecUserEMConf.

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
 *	SecureJavaFXSecUserEMConfAttrPane JavaFX Attribute Pane implementation
 *	for SecUserEMConf.
 */
public class SecureJavaFXSecUserEMConfAttrPane
extends YCFGridPane
implements ISecureJavaFXSecUserEMConfPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	boolean javafxIsInitializing = true;

	protected class ConfirmEMailAddrYCFLabel
		extends YCFLabel
	{
		public ConfirmEMailAddrYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecUserEMConf.AttrPane.ConfirmEMailAddr.EffLabel"));
		}
	}

	protected class ConfirmEMailAddrEditor
		extends YCFStringEditor
	{
		public ConfirmEMailAddrEditor() {
			super();
			setMaxLen( 512 );
			setFieldNameInzTag( "secure.javafx.SecUserEMConf.AttrPane.ConfirmEMailAddr.EffLabel" );
		}
	}

	protected class EMailSentStampYCFLabel
		extends YCFLabel
	{
		public EMailSentStampYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecUserEMConf.AttrPane.EMailSentStamp.EffLabel"));
		}
	}

	protected class EMailSentStampEditor
		extends YCFTimestampEditor
	{
		public EMailSentStampEditor() {
			super();
			setFieldNameInzTag( "secure.javafx.SecUserEMConf.AttrPane.EMailSentStamp.EffLabel" );
		}
	}

	protected class EMConfirmationUuid6YCFLabel
		extends YCFLabel
	{
		public EMConfirmationUuid6YCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecUserEMConf.AttrPane.EMConfirmationUuid6.EffLabel"));
		}
	}

	protected class EMConfirmationUuid6Editor
		extends YCFUuid6Editor
	{
		public EMConfirmationUuid6Editor() {
			super();
			setFieldNameInzTag( "secure.javafx.SecUserEMConf.AttrPane.EMConfirmationUuid6.EffLabel" );
		}
	}

	protected class NewAccountYCFLabel
		extends YCFLabel
	{
		public NewAccountYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecUserEMConf.AttrPane.NewAccount.EffLabel"));
		}
	}

	protected class NewAccountEditor
		extends YCFBoolEditor
	{
		public NewAccountEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "secure.javafx.SecUserEMConf.AttrPane.NewAccount.EffLabel" );
		}
	}

	protected ConfirmEMailAddrYCFLabel javafxLabelConfirmEMailAddr = null;
	protected ConfirmEMailAddrEditor javafxEditorConfirmEMailAddr = null;
	protected EMailSentStampYCFLabel javafxLabelEMailSentStamp = null;
	protected EMailSentStampEditor javafxEditorEMailSentStamp = null;
	protected EMConfirmationUuid6YCFLabel javafxLabelEMConfirmationUuid6 = null;
	protected EMConfirmationUuid6Editor javafxEditorEMConfirmationUuid6 = null;
	protected NewAccountYCFLabel javafxLabelNewAccount = null;
	protected NewAccountEditor javafxEditorNewAccount = null;

	public SecureJavaFXSecUserEMConfAttrPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureSecUserEMConfObj argFocus ) {
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
		setJavaFXFocusAsSecUserEMConf( argFocus );
		setPadding( new Insets(5) );
		setHgap( 5 );
		setVgap( 5 );
		setAlignment( Pos.CENTER );
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth( 100 );
		getColumnConstraints().addAll( column1 );
		int gridRow = 0;
		label = getJavaFXLabelConfirmEMailAddr();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorConfirmEMailAddr();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelEMailSentStamp();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorEMailSentStamp();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelEMConfirmationUuid6();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorEMConfirmationUuid6();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelNewAccount();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorNewAccount();
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
		if( ( value == null ) || ( value instanceof ISecureSecUserEMConfObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecUserEMConfObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ISecureSecUserEMConfObj getJavaFXFocusAsSecUserEMConf() {
		return( (ISecureSecUserEMConfObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSecUserEMConf( ISecureSecUserEMConfObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureSecUserEMConfObj getEffJavaFXFocus() {
		ISecureSecUserEMConfObj eff = (ISecureSecUserEMConfObj)getJavaFXFocus();
		if( eff != null ) {
			if( null != eff.getEdit() ) {
				eff = (ISecureSecUserEMConfObj)eff.getEdit();
			}
		}
		return( eff );
	}

	public ConfirmEMailAddrYCFLabel getJavaFXLabelConfirmEMailAddr() {
		if( javafxLabelConfirmEMailAddr == null ) {
			javafxLabelConfirmEMailAddr = new ConfirmEMailAddrYCFLabel();
		}
		return( javafxLabelConfirmEMailAddr );
	}

	public void setJavaFXLabelConfirmEMailAddr( ConfirmEMailAddrYCFLabel value ) {
		javafxLabelConfirmEMailAddr = value;
	}

	public ConfirmEMailAddrEditor getJavaFXEditorConfirmEMailAddr() {
		if( javafxEditorConfirmEMailAddr == null ) {
			javafxEditorConfirmEMailAddr = new ConfirmEMailAddrEditor();
		}
		return( javafxEditorConfirmEMailAddr );
	}

	public void setJavaFXEditorConfirmEMailAddr( ConfirmEMailAddrEditor value ) {
		javafxEditorConfirmEMailAddr = value;
	}

	public EMailSentStampYCFLabel getJavaFXLabelEMailSentStamp() {
		if( javafxLabelEMailSentStamp == null ) {
			javafxLabelEMailSentStamp = new EMailSentStampYCFLabel();
		}
		return( javafxLabelEMailSentStamp );
	}

	public void setJavaFXLabelEMailSentStamp( EMailSentStampYCFLabel value ) {
		javafxLabelEMailSentStamp = value;
	}

	public EMailSentStampEditor getJavaFXEditorEMailSentStamp() {
		if( javafxEditorEMailSentStamp == null ) {
			javafxEditorEMailSentStamp = new EMailSentStampEditor();
		}
		return( javafxEditorEMailSentStamp );
	}

	public void setJavaFXEditorEMailSentStamp( EMailSentStampEditor value ) {
		javafxEditorEMailSentStamp = value;
	}

	public EMConfirmationUuid6YCFLabel getJavaFXLabelEMConfirmationUuid6() {
		if( javafxLabelEMConfirmationUuid6 == null ) {
			javafxLabelEMConfirmationUuid6 = new EMConfirmationUuid6YCFLabel();
		}
		return( javafxLabelEMConfirmationUuid6 );
	}

	public void setJavaFXLabelEMConfirmationUuid6( EMConfirmationUuid6YCFLabel value ) {
		javafxLabelEMConfirmationUuid6 = value;
	}

	public EMConfirmationUuid6Editor getJavaFXEditorEMConfirmationUuid6() {
		if( javafxEditorEMConfirmationUuid6 == null ) {
			javafxEditorEMConfirmationUuid6 = new EMConfirmationUuid6Editor();
		}
		return( javafxEditorEMConfirmationUuid6 );
	}

	public void setJavaFXEditorEMConfirmationUuid6( EMConfirmationUuid6Editor value ) {
		javafxEditorEMConfirmationUuid6 = value;
	}

	public NewAccountYCFLabel getJavaFXLabelNewAccount() {
		if( javafxLabelNewAccount == null ) {
			javafxLabelNewAccount = new NewAccountYCFLabel();
		}
		return( javafxLabelNewAccount );
	}

	public void setJavaFXLabelNewAccount( NewAccountYCFLabel value ) {
		javafxLabelNewAccount = value;
	}

	public NewAccountEditor getJavaFXEditorNewAccount() {
		if( javafxEditorNewAccount == null ) {
			javafxEditorNewAccount = new NewAccountEditor();
		}
		return( javafxEditorNewAccount );
	}

	public void setJavaFXEditorNewAccount( NewAccountEditor value ) {
		javafxEditorNewAccount = value;
	}

	public void populateFields()
	{
		ISecureSecUserEMConfObj popObj = getEffJavaFXFocus();
		if( getPaneMode() == YCFPane.PaneMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			getJavaFXEditorConfirmEMailAddr().setStringValue( null );
		}
		else {
			getJavaFXEditorConfirmEMailAddr().setStringValue( popObj.getRequiredConfirmEMailAddr() );
		}

		if( popObj == null ) {
			getJavaFXEditorEMailSentStamp().setTimestampValue( null );
		}
		else {
			getJavaFXEditorEMailSentStamp().setTimestampValue( popObj.getRequiredEMailSentStamp() );
		}

		if( popObj == null ) {
			getJavaFXEditorEMConfirmationUuid6().setUuid6Value( null );
		}
		else {
			getJavaFXEditorEMConfirmationUuid6().setUuid6Value( popObj.getRequiredEMConfirmationUuid6() );
		}

		if( popObj == null ) {
			getJavaFXEditorNewAccount().setBooleanValue( null );
		}
		else {
			getJavaFXEditorNewAccount().setBooleanValue( popObj.getRequiredNewAccount() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ISecureSecUserEMConfObj focus = getJavaFXFocusAsSecUserEMConf();
		ISecureSecUserEMConfEditObj editObj;
		if( focus != null ) {
			editObj = (ISecureSecUserEMConfEditObj)(focus.getEdit());
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

		if( getJavaFXEditorConfirmEMailAddr().getStringValue() == null ) {
			editObj.setRequiredConfirmEMailAddr( "" );
		}
		else {
			editObj.setRequiredConfirmEMailAddr( getJavaFXEditorConfirmEMailAddr().getStringValue() );
		}

		editObj.setRequiredEMailSentStamp( getJavaFXEditorEMailSentStamp().getTimestampValue() );

		editObj.setRequiredEMConfirmationUuid6( getJavaFXEditorEMConfirmationUuid6().getUuid6Value() );

		editObj.setRequiredNewAccount( getJavaFXEditorNewAccount().getBooleanValue() );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		YCFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		ISecureSecUserEMConfObj focus = getJavaFXFocusAsSecUserEMConf();
		if( ( value != YCFPane.PaneMode.Unknown ) && ( value != YCFPane.PaneMode.View ) ) {
			if( focus == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"javaFXFocus" );
			}
		}
		ISecureSecUserEMConfEditObj editObj;
		if( focus != null ) {
			editObj  = (ISecureSecUserEMConfEditObj)focus.getEdit();
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
								editObj = (ISecureSecUserEMConfEditObj)focus.beginEdit();
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
							editObj = (ISecureSecUserEMConfEditObj)focus.beginEdit();
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
							editObj = (ISecureSecUserEMConfEditObj)focus.beginEdit();
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
							editObj = (ISecureSecUserEMConfEditObj)focus.beginEdit();
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
						focus = (ISecureSecUserEMConfObj)editObj.create();
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
								editObj = (ISecureSecUserEMConfEditObj)focus.beginEdit();
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
								editObj = (ISecureSecUserEMConfEditObj)focus.beginEdit();
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
							editObj = (ISecureSecUserEMConfEditObj)focus.beginEdit();
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
			ISecureSecUserEMConfObj focus = getJavaFXFocusAsSecUserEMConf();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( javafxEditorConfirmEMailAddr != null ) {
			javafxEditorConfirmEMailAddr.setDisable( ! isEditing );
		}
		if( javafxEditorEMailSentStamp != null ) {
			javafxEditorEMailSentStamp.setDisable( ! isEditing );
		}
		if( javafxEditorEMConfirmationUuid6 != null ) {
			javafxEditorEMConfirmationUuid6.setDisable( ! isEditing );
		}
		if( javafxEditorNewAccount != null ) {
			javafxEditorNewAccount.setDisable( ! isEditing );
		}
	}
}
