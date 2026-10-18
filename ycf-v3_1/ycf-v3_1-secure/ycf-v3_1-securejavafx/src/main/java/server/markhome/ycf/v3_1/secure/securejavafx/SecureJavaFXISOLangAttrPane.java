// Description: Java 25 JavaFX Attribute Pane implementation for ISOLang.

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
 *	SecureJavaFXISOLangAttrPane JavaFX Attribute Pane implementation
 *	for ISOLang.
 */
public class SecureJavaFXISOLangAttrPane
extends YCFGridPane
implements ISecureJavaFXISOLangPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	boolean javafxIsInitializing = true;

	protected class ISOLangIdYCFLabel
		extends YCFLabel
	{
		public ISOLangIdYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOLang.AttrPane.ISOLangId.EffLabel"));
		}
	}

	protected class ISOLangIdEditor
		extends YCFInt16Editor
	{
		public ISOLangIdEditor() {
			super();
			setMinValue( ISecureISOLang.ISOLANGID_MIN_VALUE );
			setFieldNameInzTag( "secure.javafx.ISOLang.AttrPane.ISOLangId.EffLabel" );
		}
	}

	protected class ISO6392CodeYCFLabel
		extends YCFLabel
	{
		public ISO6392CodeYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOLang.AttrPane.ISO6392Code.EffLabel"));
		}
	}

	protected class ISO6392CodeEditor
		extends YCFStringEditor
	{
		public ISO6392CodeEditor() {
			super();
			setMaxLen( 3 );
			setFieldNameInzTag( "secure.javafx.ISOLang.AttrPane.ISO6392Code.EffLabel" );
		}
	}

	protected class ISO6391CodeYCFLabel
		extends YCFLabel
	{
		public ISO6391CodeYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOLang.AttrPane.ISO6391Code.EffLabel"));
		}
	}

	protected class ISO6391CodeEditor
		extends YCFStringEditor
	{
		public ISO6391CodeEditor() {
			super();
			setMaxLen( 2 );
			setFieldNameInzTag( "secure.javafx.ISOLang.AttrPane.ISO6391Code.EffLabel" );
		}
	}

	protected class EnglishNameYCFLabel
		extends YCFLabel
	{
		public EnglishNameYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOLang.AttrPane.EnglishName.EffLabel"));
		}
	}

	protected class EnglishNameEditor
		extends YCFStringEditor
	{
		public EnglishNameEditor() {
			super();
			setMaxLen( 64 );
			setFieldNameInzTag( "secure.javafx.ISOLang.AttrPane.EnglishName.EffLabel" );
		}
	}

	protected ISOLangIdYCFLabel javafxLabelISOLangId = null;
	protected ISOLangIdEditor javafxEditorISOLangId = null;
	protected ISO6392CodeYCFLabel javafxLabelISO6392Code = null;
	protected ISO6392CodeEditor javafxEditorISO6392Code = null;
	protected ISO6391CodeYCFLabel javafxLabelISO6391Code = null;
	protected ISO6391CodeEditor javafxEditorISO6391Code = null;
	protected EnglishNameYCFLabel javafxLabelEnglishName = null;
	protected EnglishNameEditor javafxEditorEnglishName = null;

	public SecureJavaFXISOLangAttrPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureISOLangObj argFocus ) {
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
		setJavaFXFocusAsISOLang( argFocus );
		setPadding( new Insets(5) );
		setHgap( 5 );
		setVgap( 5 );
		setAlignment( Pos.CENTER );
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth( 100 );
		getColumnConstraints().addAll( column1 );
		int gridRow = 0;
		label = getJavaFXLabelISOLangId();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorISOLangId();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelISO6392Code();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorISO6392Code();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelISO6391Code();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorISO6391Code();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelEnglishName();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorEnglishName();
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
		if( ( value == null ) || ( value instanceof ISecureISOLangObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureISOLangObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ISecureISOLangObj getJavaFXFocusAsISOLang() {
		return( (ISecureISOLangObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsISOLang( ISecureISOLangObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureISOLangObj getEffJavaFXFocus() {
		ISecureISOLangObj eff = (ISecureISOLangObj)getJavaFXFocus();
		if( eff != null ) {
			if( null != eff.getEdit() ) {
				eff = (ISecureISOLangObj)eff.getEdit();
			}
		}
		return( eff );
	}

	public ISOLangIdYCFLabel getJavaFXLabelISOLangId() {
		if( javafxLabelISOLangId == null ) {
			javafxLabelISOLangId = new ISOLangIdYCFLabel();
		}
		return( javafxLabelISOLangId );
	}

	public void setJavaFXLabelISOLangId( ISOLangIdYCFLabel value ) {
		javafxLabelISOLangId = value;
	}

	public ISOLangIdEditor getJavaFXEditorISOLangId() {
		if( javafxEditorISOLangId == null ) {
			javafxEditorISOLangId = new ISOLangIdEditor();
		}
		return( javafxEditorISOLangId );
	}

	public void setJavaFXEditorISOLangId( ISOLangIdEditor value ) {
		javafxEditorISOLangId = value;
	}

	public ISO6392CodeYCFLabel getJavaFXLabelISO6392Code() {
		if( javafxLabelISO6392Code == null ) {
			javafxLabelISO6392Code = new ISO6392CodeYCFLabel();
		}
		return( javafxLabelISO6392Code );
	}

	public void setJavaFXLabelISO6392Code( ISO6392CodeYCFLabel value ) {
		javafxLabelISO6392Code = value;
	}

	public ISO6392CodeEditor getJavaFXEditorISO6392Code() {
		if( javafxEditorISO6392Code == null ) {
			javafxEditorISO6392Code = new ISO6392CodeEditor();
		}
		return( javafxEditorISO6392Code );
	}

	public void setJavaFXEditorISO6392Code( ISO6392CodeEditor value ) {
		javafxEditorISO6392Code = value;
	}

	public ISO6391CodeYCFLabel getJavaFXLabelISO6391Code() {
		if( javafxLabelISO6391Code == null ) {
			javafxLabelISO6391Code = new ISO6391CodeYCFLabel();
		}
		return( javafxLabelISO6391Code );
	}

	public void setJavaFXLabelISO6391Code( ISO6391CodeYCFLabel value ) {
		javafxLabelISO6391Code = value;
	}

	public ISO6391CodeEditor getJavaFXEditorISO6391Code() {
		if( javafxEditorISO6391Code == null ) {
			javafxEditorISO6391Code = new ISO6391CodeEditor();
		}
		return( javafxEditorISO6391Code );
	}

	public void setJavaFXEditorISO6391Code( ISO6391CodeEditor value ) {
		javafxEditorISO6391Code = value;
	}

	public EnglishNameYCFLabel getJavaFXLabelEnglishName() {
		if( javafxLabelEnglishName == null ) {
			javafxLabelEnglishName = new EnglishNameYCFLabel();
		}
		return( javafxLabelEnglishName );
	}

	public void setJavaFXLabelEnglishName( EnglishNameYCFLabel value ) {
		javafxLabelEnglishName = value;
	}

	public EnglishNameEditor getJavaFXEditorEnglishName() {
		if( javafxEditorEnglishName == null ) {
			javafxEditorEnglishName = new EnglishNameEditor();
		}
		return( javafxEditorEnglishName );
	}

	public void setJavaFXEditorEnglishName( EnglishNameEditor value ) {
		javafxEditorEnglishName = value;
	}

	public void populateFields()
	{
		ISecureISOLangObj popObj = getEffJavaFXFocus();
		if( getPaneMode() == YCFPane.PaneMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			getJavaFXEditorISOLangId().setInt16Value( null );
		}
		else {
			getJavaFXEditorISOLangId().setInt16Value( popObj.getRequiredISOLangId() );
		}

		if( popObj == null ) {
			getJavaFXEditorISO6392Code().setStringValue( null );
		}
		else {
			getJavaFXEditorISO6392Code().setStringValue( popObj.getRequiredISO6392Code() );
		}

		if( popObj == null ) {
			getJavaFXEditorISO6391Code().setStringValue( null );
		}
		else {
			getJavaFXEditorISO6391Code().setStringValue( popObj.getOptionalISO6391Code() );
		}

		if( popObj == null ) {
			getJavaFXEditorEnglishName().setStringValue( null );
		}
		else {
			getJavaFXEditorEnglishName().setStringValue( popObj.getRequiredEnglishName() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ISecureISOLangObj focus = getJavaFXFocusAsISOLang();
		ISecureISOLangEditObj editObj;
		if( focus != null ) {
			editObj = (ISecureISOLangEditObj)(focus.getEdit());
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

		if( getJavaFXEditorISO6392Code().getStringValue() == null ) {
			editObj.setRequiredISO6392Code( "" );
		}
		else {
			editObj.setRequiredISO6392Code( getJavaFXEditorISO6392Code().getStringValue() );
		}

		if( ( getJavaFXEditorISO6391Code().getStringValue() != null ) && ( getJavaFXEditorISO6391Code().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalISO6391Code( null );
		}
		else {
			editObj.setOptionalISO6391Code( getJavaFXEditorISO6391Code().getStringValue() );
		}

		if( getJavaFXEditorEnglishName().getStringValue() == null ) {
			editObj.setRequiredEnglishName( "" );
		}
		else {
			editObj.setRequiredEnglishName( getJavaFXEditorEnglishName().getStringValue() );
		}
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		YCFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		ISecureISOLangObj focus = getJavaFXFocusAsISOLang();
		if( ( value != YCFPane.PaneMode.Unknown ) && ( value != YCFPane.PaneMode.View ) ) {
			if( focus == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"javaFXFocus" );
			}
		}
		ISecureISOLangEditObj editObj;
		if( focus != null ) {
			editObj  = (ISecureISOLangEditObj)focus.getEdit();
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
								editObj = (ISecureISOLangEditObj)focus.beginEdit();
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
							editObj = (ISecureISOLangEditObj)focus.beginEdit();
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
							editObj = (ISecureISOLangEditObj)focus.beginEdit();
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
							editObj = (ISecureISOLangEditObj)focus.beginEdit();
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
						focus = (ISecureISOLangObj)editObj.create();
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
								editObj = (ISecureISOLangEditObj)focus.beginEdit();
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
								editObj = (ISecureISOLangEditObj)focus.beginEdit();
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
							editObj = (ISecureISOLangEditObj)focus.beginEdit();
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
			ISecureISOLangObj focus = getJavaFXFocusAsISOLang();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( javafxEditorISOLangId != null ) {
			javafxEditorISOLangId.setDisable( true );
		}
		if( javafxEditorISO6392Code != null ) {
			javafxEditorISO6392Code.setDisable( ! isEditing );
		}
		if( javafxEditorISO6391Code != null ) {
			javafxEditorISO6391Code.setDisable( ! isEditing );
		}
		if( javafxEditorEnglishName != null ) {
			javafxEditorEnglishName.setDisable( ! isEditing );
		}
	}
}
