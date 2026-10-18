// Description: Java 25 JavaFX Attribute Pane implementation for SecUser.

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
 *	SecureJavaFXSecUserAttrPane JavaFX Attribute Pane implementation
 *	for SecUser.
 */
public class SecureJavaFXSecUserAttrPane
extends YCFGridPane
implements ISecureJavaFXSecUserPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	boolean javafxIsInitializing = true;

	protected ObservableList<String> observableListOfAccountStatus =
		FXCollections.observableArrayList(
			"System",
			"VerifyingEmail",
			"CreatingDevKey",
			"NormalUser",
			"ResettingPassword",
			"Locked" );

	protected class SecUserIdYCFLabel
		extends YCFLabel
	{
		public SecUserIdYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecUser.AttrPane.SecUserId.EffLabel"));
		}
	}

	protected class SecUserIdEditor
		extends YCFDbKeyHash256Editor
	{
		public SecUserIdEditor() {
			super();
			setFieldNameInzTag( "secure.javafx.SecUser.AttrPane.SecUserId.EffLabel" );
		}
	}

	protected class LoginIdYCFLabel
		extends YCFLabel
	{
		public LoginIdYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecUser.AttrPane.LoginId.EffLabel"));
		}
	}

	protected class LoginIdEditor
		extends YCFStringEditor
	{
		public LoginIdEditor() {
			super();
			setMaxLen( 32 );
			setFieldNameInzTag( "secure.javafx.SecUser.AttrPane.LoginId.EffLabel" );
		}
	}

	protected class AccountStatusYCFLabel
		extends YCFLabel
	{
		public AccountStatusYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecUser.AttrPane.AccountStatus.EffLabel"));
		}
	}

	protected class AccountStatusEditor
		extends ComboBox<String>
	{
		public AccountStatusEditor() {
			super();
			setItems( observableListOfAccountStatus );
		}
	}

	protected class DfltSysGrpNameYCFLabel
		extends YCFLabel
	{
		public DfltSysGrpNameYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecUser.AttrPane.DfltSysGrpName.EffLabel"));
		}
	}

	protected class DfltSysGrpNameEditor
		extends YCFStringEditor
	{
		public DfltSysGrpNameEditor() {
			super();
			setMaxLen( 64 );
			setFieldNameInzTag( "secure.javafx.SecUser.AttrPane.DfltSysGrpName.EffLabel" );
		}
	}

	protected class DfltClusGrpNameYCFLabel
		extends YCFLabel
	{
		public DfltClusGrpNameYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecUser.AttrPane.DfltClusGrpName.EffLabel"));
		}
	}

	protected class DfltClusGrpNameEditor
		extends YCFStringEditor
	{
		public DfltClusGrpNameEditor() {
			super();
			setMaxLen( 64 );
			setFieldNameInzTag( "secure.javafx.SecUser.AttrPane.DfltClusGrpName.EffLabel" );
		}
	}

	protected class DfltTentGrpNameYCFLabel
		extends YCFLabel
	{
		public DfltTentGrpNameYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecUser.AttrPane.DfltTentGrpName.EffLabel"));
		}
	}

	protected class DfltTentGrpNameEditor
		extends YCFStringEditor
	{
		public DfltTentGrpNameEditor() {
			super();
			setMaxLen( 64 );
			setFieldNameInzTag( "secure.javafx.SecUser.AttrPane.DfltTentGrpName.EffLabel" );
		}
	}

	protected class EMailAddressYCFLabel
		extends YCFLabel
	{
		public EMailAddressYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.SecUser.AttrPane.EMailAddress.EffLabel"));
		}
	}

	protected class EMailAddressEditor
		extends YCFStringEditor
	{
		public EMailAddressEditor() {
			super();
			setMaxLen( 512 );
			setFieldNameInzTag( "secure.javafx.SecUser.AttrPane.EMailAddress.EffLabel" );
		}
	}

	protected SecUserIdYCFLabel javafxLabelSecUserId = null;
	protected SecUserIdEditor javafxEditorSecUserId = null;
	protected LoginIdYCFLabel javafxLabelLoginId = null;
	protected LoginIdEditor javafxEditorLoginId = null;
	protected AccountStatusYCFLabel javafxLabelAccountStatus = null;
	protected AccountStatusEditor javafxEditorAccountStatus = null;
	protected DfltSysGrpNameYCFLabel javafxLabelDfltSysGrpName = null;
	protected DfltSysGrpNameEditor javafxEditorDfltSysGrpName = null;
	protected DfltClusGrpNameYCFLabel javafxLabelDfltClusGrpName = null;
	protected DfltClusGrpNameEditor javafxEditorDfltClusGrpName = null;
	protected DfltTentGrpNameYCFLabel javafxLabelDfltTentGrpName = null;
	protected DfltTentGrpNameEditor javafxEditorDfltTentGrpName = null;
	protected EMailAddressYCFLabel javafxLabelEMailAddress = null;
	protected EMailAddressEditor javafxEditorEMailAddress = null;

	public SecureJavaFXSecUserAttrPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureSecUserObj argFocus ) {
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
		setJavaFXFocusAsSecUser( argFocus );
		setPadding( new Insets(5) );
		setHgap( 5 );
		setVgap( 5 );
		setAlignment( Pos.CENTER );
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth( 100 );
		getColumnConstraints().addAll( column1 );
		int gridRow = 0;
		label = getJavaFXLabelSecUserId();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorSecUserId();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelLoginId();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorLoginId();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelAccountStatus();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorAccountStatus();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelDfltSysGrpName();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorDfltSysGrpName();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelDfltClusGrpName();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorDfltClusGrpName();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelDfltTentGrpName();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorDfltTentGrpName();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelEMailAddress();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorEMailAddress();
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
		if( ( value == null ) || ( value instanceof ISecureSecUserObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureSecUserObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ISecureSecUserObj getJavaFXFocusAsSecUser() {
		return( (ISecureSecUserObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsSecUser( ISecureSecUserObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureSecUserObj getEffJavaFXFocus() {
		ISecureSecUserObj eff = (ISecureSecUserObj)getJavaFXFocus();
		if( eff != null ) {
			if( null != eff.getEdit() ) {
				eff = (ISecureSecUserObj)eff.getEdit();
			}
		}
		return( eff );
	}

	public SecUserIdYCFLabel getJavaFXLabelSecUserId() {
		if( javafxLabelSecUserId == null ) {
			javafxLabelSecUserId = new SecUserIdYCFLabel();
		}
		return( javafxLabelSecUserId );
	}

	public void setJavaFXLabelSecUserId( SecUserIdYCFLabel value ) {
		javafxLabelSecUserId = value;
	}

	public SecUserIdEditor getJavaFXEditorSecUserId() {
		if( javafxEditorSecUserId == null ) {
			javafxEditorSecUserId = new SecUserIdEditor();
		}
		return( javafxEditorSecUserId );
	}

	public void setJavaFXEditorSecUserId( SecUserIdEditor value ) {
		javafxEditorSecUserId = value;
	}

	public LoginIdYCFLabel getJavaFXLabelLoginId() {
		if( javafxLabelLoginId == null ) {
			javafxLabelLoginId = new LoginIdYCFLabel();
		}
		return( javafxLabelLoginId );
	}

	public void setJavaFXLabelLoginId( LoginIdYCFLabel value ) {
		javafxLabelLoginId = value;
	}

	public LoginIdEditor getJavaFXEditorLoginId() {
		if( javafxEditorLoginId == null ) {
			javafxEditorLoginId = new LoginIdEditor();
		}
		return( javafxEditorLoginId );
	}

	public void setJavaFXEditorLoginId( LoginIdEditor value ) {
		javafxEditorLoginId = value;
	}

	public AccountStatusYCFLabel getJavaFXLabelAccountStatus() {
		if( javafxLabelAccountStatus == null ) {
			javafxLabelAccountStatus = new AccountStatusYCFLabel();
		}
		return( javafxLabelAccountStatus );
	}

	public void setJavaFXLabelAccountStatus( AccountStatusYCFLabel value ) {
		javafxLabelAccountStatus = value;
	}

	public AccountStatusEditor getJavaFXEditorAccountStatus() {
		if( javafxEditorAccountStatus == null ) {
			javafxEditorAccountStatus = new AccountStatusEditor();
		}
		return( javafxEditorAccountStatus );
	}

	public void setJavaFXEditorAccountStatus( AccountStatusEditor value ) {
		javafxEditorAccountStatus = value;
	}

	public DfltSysGrpNameYCFLabel getJavaFXLabelDfltSysGrpName() {
		if( javafxLabelDfltSysGrpName == null ) {
			javafxLabelDfltSysGrpName = new DfltSysGrpNameYCFLabel();
		}
		return( javafxLabelDfltSysGrpName );
	}

	public void setJavaFXLabelDfltSysGrpName( DfltSysGrpNameYCFLabel value ) {
		javafxLabelDfltSysGrpName = value;
	}

	public DfltSysGrpNameEditor getJavaFXEditorDfltSysGrpName() {
		if( javafxEditorDfltSysGrpName == null ) {
			javafxEditorDfltSysGrpName = new DfltSysGrpNameEditor();
		}
		return( javafxEditorDfltSysGrpName );
	}

	public void setJavaFXEditorDfltSysGrpName( DfltSysGrpNameEditor value ) {
		javafxEditorDfltSysGrpName = value;
	}

	public DfltClusGrpNameYCFLabel getJavaFXLabelDfltClusGrpName() {
		if( javafxLabelDfltClusGrpName == null ) {
			javafxLabelDfltClusGrpName = new DfltClusGrpNameYCFLabel();
		}
		return( javafxLabelDfltClusGrpName );
	}

	public void setJavaFXLabelDfltClusGrpName( DfltClusGrpNameYCFLabel value ) {
		javafxLabelDfltClusGrpName = value;
	}

	public DfltClusGrpNameEditor getJavaFXEditorDfltClusGrpName() {
		if( javafxEditorDfltClusGrpName == null ) {
			javafxEditorDfltClusGrpName = new DfltClusGrpNameEditor();
		}
		return( javafxEditorDfltClusGrpName );
	}

	public void setJavaFXEditorDfltClusGrpName( DfltClusGrpNameEditor value ) {
		javafxEditorDfltClusGrpName = value;
	}

	public DfltTentGrpNameYCFLabel getJavaFXLabelDfltTentGrpName() {
		if( javafxLabelDfltTentGrpName == null ) {
			javafxLabelDfltTentGrpName = new DfltTentGrpNameYCFLabel();
		}
		return( javafxLabelDfltTentGrpName );
	}

	public void setJavaFXLabelDfltTentGrpName( DfltTentGrpNameYCFLabel value ) {
		javafxLabelDfltTentGrpName = value;
	}

	public DfltTentGrpNameEditor getJavaFXEditorDfltTentGrpName() {
		if( javafxEditorDfltTentGrpName == null ) {
			javafxEditorDfltTentGrpName = new DfltTentGrpNameEditor();
		}
		return( javafxEditorDfltTentGrpName );
	}

	public void setJavaFXEditorDfltTentGrpName( DfltTentGrpNameEditor value ) {
		javafxEditorDfltTentGrpName = value;
	}

	public EMailAddressYCFLabel getJavaFXLabelEMailAddress() {
		if( javafxLabelEMailAddress == null ) {
			javafxLabelEMailAddress = new EMailAddressYCFLabel();
		}
		return( javafxLabelEMailAddress );
	}

	public void setJavaFXLabelEMailAddress( EMailAddressYCFLabel value ) {
		javafxLabelEMailAddress = value;
	}

	public EMailAddressEditor getJavaFXEditorEMailAddress() {
		if( javafxEditorEMailAddress == null ) {
			javafxEditorEMailAddress = new EMailAddressEditor();
		}
		return( javafxEditorEMailAddress );
	}

	public void setJavaFXEditorEMailAddress( EMailAddressEditor value ) {
		javafxEditorEMailAddress = value;
	}

	public void populateFields()
	{
		ISecureSecUserObj popObj = getEffJavaFXFocus();
		if( getPaneMode() == YCFPane.PaneMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			getJavaFXEditorSecUserId().setDbKeyHash256Value( null );
		}
		else {
			getJavaFXEditorSecUserId().setDbKeyHash256Value( popObj.getRequiredSecUserId() );
		}

		if( popObj == null ) {
			getJavaFXEditorLoginId().setStringValue( null );
		}
		else {
			getJavaFXEditorLoginId().setStringValue( popObj.getRequiredLoginId() );
		}

		if( popObj == null ) {
			getJavaFXEditorAccountStatus().setValue( null );
		}
		else {
			getJavaFXEditorAccountStatus().setValue(
				( popObj.getRequiredAccountStatus() == null )
					? null
					: popObj.getRequiredAccountStatus().toString() );
		}

		if( popObj == null ) {
			getJavaFXEditorDfltSysGrpName().setStringValue( null );
		}
		else {
			getJavaFXEditorDfltSysGrpName().setStringValue( popObj.getOptionalDfltSysGrpName() );
		}

		if( popObj == null ) {
			getJavaFXEditorDfltClusGrpName().setStringValue( null );
		}
		else {
			getJavaFXEditorDfltClusGrpName().setStringValue( popObj.getOptionalDfltClusGrpName() );
		}

		if( popObj == null ) {
			getJavaFXEditorDfltTentGrpName().setStringValue( null );
		}
		else {
			getJavaFXEditorDfltTentGrpName().setStringValue( popObj.getOptionalDfltTentGrpName() );
		}

		if( popObj == null ) {
			getJavaFXEditorEMailAddress().setStringValue( null );
		}
		else {
			getJavaFXEditorEMailAddress().setStringValue( popObj.getRequiredEMailAddress() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ISecureSecUserObj focus = getJavaFXFocusAsSecUser();
		ISecureSecUserEditObj editObj;
		if( focus != null ) {
			editObj = (ISecureSecUserEditObj)(focus.getEdit());
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

		if( getJavaFXEditorLoginId().getStringValue() == null ) {
			editObj.setRequiredLoginId( "" );
		}
		else {
			editObj.setRequiredLoginId( getJavaFXEditorLoginId().getStringValue() );
		}

		String straccountstatus = getJavaFXEditorAccountStatus().getValue();
		ISecureSchema.SecAccountStatusEnum curaccountstatus = ISecureSchema.parseSecAccountStatusEnum( "AccountStatus", straccountstatus );
		editObj.setRequiredAccountStatus( curaccountstatus );

		if( ( getJavaFXEditorDfltSysGrpName().getStringValue() != null ) && ( getJavaFXEditorDfltSysGrpName().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalDfltSysGrpName( null );
		}
		else {
			editObj.setOptionalDfltSysGrpName( getJavaFXEditorDfltSysGrpName().getStringValue() );
		}

		if( ( getJavaFXEditorDfltClusGrpName().getStringValue() != null ) && ( getJavaFXEditorDfltClusGrpName().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalDfltClusGrpName( null );
		}
		else {
			editObj.setOptionalDfltClusGrpName( getJavaFXEditorDfltClusGrpName().getStringValue() );
		}

		if( ( getJavaFXEditorDfltTentGrpName().getStringValue() != null ) && ( getJavaFXEditorDfltTentGrpName().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalDfltTentGrpName( null );
		}
		else {
			editObj.setOptionalDfltTentGrpName( getJavaFXEditorDfltTentGrpName().getStringValue() );
		}

		if( getJavaFXEditorEMailAddress().getStringValue() == null ) {
			editObj.setRequiredEMailAddress( "" );
		}
		else {
			editObj.setRequiredEMailAddress( getJavaFXEditorEMailAddress().getStringValue() );
		}
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		YCFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		ISecureSecUserObj focus = getJavaFXFocusAsSecUser();
		if( ( value != YCFPane.PaneMode.Unknown ) && ( value != YCFPane.PaneMode.View ) ) {
			if( focus == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"javaFXFocus" );
			}
		}
		ISecureSecUserEditObj editObj;
		if( focus != null ) {
			editObj  = (ISecureSecUserEditObj)focus.getEdit();
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
								editObj = (ISecureSecUserEditObj)focus.beginEdit();
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
							editObj = (ISecureSecUserEditObj)focus.beginEdit();
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
							editObj = (ISecureSecUserEditObj)focus.beginEdit();
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
							editObj = (ISecureSecUserEditObj)focus.beginEdit();
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
						focus = (ISecureSecUserObj)editObj.create();
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
								editObj = (ISecureSecUserEditObj)focus.beginEdit();
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
								editObj = (ISecureSecUserEditObj)focus.beginEdit();
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
							editObj = (ISecureSecUserEditObj)focus.beginEdit();
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
			ISecureSecUserObj focus = getJavaFXFocusAsSecUser();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( javafxEditorSecUserId != null ) {
			javafxEditorSecUserId.setDisable( true );
		}
		if( javafxEditorLoginId != null ) {
			javafxEditorLoginId.setDisable( ! isEditing );
		}
		if( javafxEditorAccountStatus != null ) {
			javafxEditorAccountStatus.setDisable( ! isEditing );
		}
		if( javafxEditorDfltSysGrpName != null ) {
			javafxEditorDfltSysGrpName.setDisable( ! isEditing );
		}
		if( javafxEditorDfltClusGrpName != null ) {
			javafxEditorDfltClusGrpName.setDisable( ! isEditing );
		}
		if( javafxEditorDfltTentGrpName != null ) {
			javafxEditorDfltTentGrpName.setDisable( ! isEditing );
		}
		if( javafxEditorEMailAddress != null ) {
			javafxEditorEMailAddress.setDisable( ! isEditing );
		}
	}
}
