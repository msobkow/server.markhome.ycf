// Description: Java 25 JavaFX Attribute Pane implementation for ISOCcy.

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
 *	SecureJavaFXISOCcyAttrPane JavaFX Attribute Pane implementation
 *	for ISOCcy.
 */
public class SecureJavaFXISOCcyAttrPane
extends YCFGridPane
implements ISecureJavaFXISOCcyPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	boolean javafxIsInitializing = true;

	protected class ISOCcyIdYCFLabel
		extends YCFLabel
	{
		public ISOCcyIdYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOCcy.AttrPane.ISOCcyId.EffLabel"));
		}
	}

	protected class ISOCcyIdEditor
		extends YCFInt16Editor
	{
		public ISOCcyIdEditor() {
			super();
			setMinValue( ISecureISOCcy.ISOCCYID_MIN_VALUE );
			setFieldNameInzTag( "secure.javafx.ISOCcy.AttrPane.ISOCcyId.EffLabel" );
		}
	}

	protected class ISOCodeYCFLabel
		extends YCFLabel
	{
		public ISOCodeYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOCcy.AttrPane.ISOCode.EffLabel"));
		}
	}

	protected class ISOCodeEditor
		extends YCFStringEditor
	{
		public ISOCodeEditor() {
			super();
			setMaxLen( 3 );
			setFieldNameInzTag( "secure.javafx.ISOCcy.AttrPane.ISOCode.EffLabel" );
		}
	}

	protected class NameYCFLabel
		extends YCFLabel
	{
		public NameYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOCcy.AttrPane.Name.EffLabel"));
		}
	}

	protected class NameEditor
		extends YCFStringEditor
	{
		public NameEditor() {
			super();
			setMaxLen( 64 );
			setFieldNameInzTag( "secure.javafx.ISOCcy.AttrPane.Name.EffLabel" );
		}
	}

	protected class UnitSymbolYCFLabel
		extends YCFLabel
	{
		public UnitSymbolYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOCcy.AttrPane.UnitSymbol.EffLabel"));
		}
	}

	protected class UnitSymbolEditor
		extends YCFStringEditor
	{
		public UnitSymbolEditor() {
			super();
			setMaxLen( 4 );
			setFieldNameInzTag( "secure.javafx.ISOCcy.AttrPane.UnitSymbol.EffLabel" );
		}
	}

	protected class PrecisYCFLabel
		extends YCFLabel
	{
		public PrecisYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOCcy.AttrPane.Precis.EffLabel"));
		}
	}

	protected class PrecisEditor
		extends YCFInt16Editor
	{
		public PrecisEditor() {
			super();
			setMinValue( ISecureISOCcy.PRECIS_MIN_VALUE );
			setMaxValue( ISecureISOCcy.PRECIS_MAX_VALUE );
			setFieldNameInzTag( "secure.javafx.ISOCcy.AttrPane.Precis.EffLabel" );
		}
	}

	protected ISOCcyIdYCFLabel javafxLabelISOCcyId = null;
	protected ISOCcyIdEditor javafxEditorISOCcyId = null;
	protected ISOCodeYCFLabel javafxLabelISOCode = null;
	protected ISOCodeEditor javafxEditorISOCode = null;
	protected NameYCFLabel javafxLabelName = null;
	protected NameEditor javafxEditorName = null;
	protected UnitSymbolYCFLabel javafxLabelUnitSymbol = null;
	protected UnitSymbolEditor javafxEditorUnitSymbol = null;
	protected PrecisYCFLabel javafxLabelPrecis = null;
	protected PrecisEditor javafxEditorPrecis = null;

	public SecureJavaFXISOCcyAttrPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureISOCcyObj argFocus ) {
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
		setJavaFXFocusAsISOCcy( argFocus );
		setPadding( new Insets(5) );
		setHgap( 5 );
		setVgap( 5 );
		setAlignment( Pos.CENTER );
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth( 100 );
		getColumnConstraints().addAll( column1 );
		int gridRow = 0;
		label = getJavaFXLabelISOCcyId();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorISOCcyId();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelISOCode();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorISOCode();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelName();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorName();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelUnitSymbol();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorUnitSymbol();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelPrecis();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorPrecis();
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
		if( ( value == null ) || ( value instanceof ISecureISOCcyObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureISOCcyObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ISecureISOCcyObj getJavaFXFocusAsISOCcy() {
		return( (ISecureISOCcyObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsISOCcy( ISecureISOCcyObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureISOCcyObj getEffJavaFXFocus() {
		ISecureISOCcyObj eff = (ISecureISOCcyObj)getJavaFXFocus();
		if( eff != null ) {
			if( null != eff.getEdit() ) {
				eff = (ISecureISOCcyObj)eff.getEdit();
			}
		}
		return( eff );
	}

	public ISOCcyIdYCFLabel getJavaFXLabelISOCcyId() {
		if( javafxLabelISOCcyId == null ) {
			javafxLabelISOCcyId = new ISOCcyIdYCFLabel();
		}
		return( javafxLabelISOCcyId );
	}

	public void setJavaFXLabelISOCcyId( ISOCcyIdYCFLabel value ) {
		javafxLabelISOCcyId = value;
	}

	public ISOCcyIdEditor getJavaFXEditorISOCcyId() {
		if( javafxEditorISOCcyId == null ) {
			javafxEditorISOCcyId = new ISOCcyIdEditor();
		}
		return( javafxEditorISOCcyId );
	}

	public void setJavaFXEditorISOCcyId( ISOCcyIdEditor value ) {
		javafxEditorISOCcyId = value;
	}

	public ISOCodeYCFLabel getJavaFXLabelISOCode() {
		if( javafxLabelISOCode == null ) {
			javafxLabelISOCode = new ISOCodeYCFLabel();
		}
		return( javafxLabelISOCode );
	}

	public void setJavaFXLabelISOCode( ISOCodeYCFLabel value ) {
		javafxLabelISOCode = value;
	}

	public ISOCodeEditor getJavaFXEditorISOCode() {
		if( javafxEditorISOCode == null ) {
			javafxEditorISOCode = new ISOCodeEditor();
		}
		return( javafxEditorISOCode );
	}

	public void setJavaFXEditorISOCode( ISOCodeEditor value ) {
		javafxEditorISOCode = value;
	}

	public NameYCFLabel getJavaFXLabelName() {
		if( javafxLabelName == null ) {
			javafxLabelName = new NameYCFLabel();
		}
		return( javafxLabelName );
	}

	public void setJavaFXLabelName( NameYCFLabel value ) {
		javafxLabelName = value;
	}

	public NameEditor getJavaFXEditorName() {
		if( javafxEditorName == null ) {
			javafxEditorName = new NameEditor();
		}
		return( javafxEditorName );
	}

	public void setJavaFXEditorName( NameEditor value ) {
		javafxEditorName = value;
	}

	public UnitSymbolYCFLabel getJavaFXLabelUnitSymbol() {
		if( javafxLabelUnitSymbol == null ) {
			javafxLabelUnitSymbol = new UnitSymbolYCFLabel();
		}
		return( javafxLabelUnitSymbol );
	}

	public void setJavaFXLabelUnitSymbol( UnitSymbolYCFLabel value ) {
		javafxLabelUnitSymbol = value;
	}

	public UnitSymbolEditor getJavaFXEditorUnitSymbol() {
		if( javafxEditorUnitSymbol == null ) {
			javafxEditorUnitSymbol = new UnitSymbolEditor();
		}
		return( javafxEditorUnitSymbol );
	}

	public void setJavaFXEditorUnitSymbol( UnitSymbolEditor value ) {
		javafxEditorUnitSymbol = value;
	}

	public PrecisYCFLabel getJavaFXLabelPrecis() {
		if( javafxLabelPrecis == null ) {
			javafxLabelPrecis = new PrecisYCFLabel();
		}
		return( javafxLabelPrecis );
	}

	public void setJavaFXLabelPrecis( PrecisYCFLabel value ) {
		javafxLabelPrecis = value;
	}

	public PrecisEditor getJavaFXEditorPrecis() {
		if( javafxEditorPrecis == null ) {
			javafxEditorPrecis = new PrecisEditor();
		}
		return( javafxEditorPrecis );
	}

	public void setJavaFXEditorPrecis( PrecisEditor value ) {
		javafxEditorPrecis = value;
	}

	public void populateFields()
	{
		ISecureISOCcyObj popObj = getEffJavaFXFocus();
		if( getPaneMode() == YCFPane.PaneMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			getJavaFXEditorISOCcyId().setInt16Value( null );
		}
		else {
			getJavaFXEditorISOCcyId().setInt16Value( popObj.getRequiredISOCcyId() );
		}

		if( popObj == null ) {
			getJavaFXEditorISOCode().setStringValue( null );
		}
		else {
			getJavaFXEditorISOCode().setStringValue( popObj.getRequiredISOCode() );
		}

		if( popObj == null ) {
			getJavaFXEditorName().setStringValue( null );
		}
		else {
			getJavaFXEditorName().setStringValue( popObj.getRequiredName() );
		}

		if( popObj == null ) {
			getJavaFXEditorUnitSymbol().setStringValue( null );
		}
		else {
			getJavaFXEditorUnitSymbol().setStringValue( popObj.getOptionalUnitSymbol() );
		}

		if( popObj == null ) {
			getJavaFXEditorPrecis().setInt16Value( null );
		}
		else {
			getJavaFXEditorPrecis().setInt16Value( popObj.getRequiredPrecis() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ISecureISOCcyObj focus = getJavaFXFocusAsISOCcy();
		ISecureISOCcyEditObj editObj;
		if( focus != null ) {
			editObj = (ISecureISOCcyEditObj)(focus.getEdit());
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

		if( getJavaFXEditorISOCode().getStringValue() == null ) {
			editObj.setRequiredISOCode( "" );
		}
		else {
			editObj.setRequiredISOCode( getJavaFXEditorISOCode().getStringValue() );
		}

		if( getJavaFXEditorName().getStringValue() == null ) {
			editObj.setRequiredName( "" );
		}
		else {
			editObj.setRequiredName( getJavaFXEditorName().getStringValue() );
		}

		if( ( getJavaFXEditorUnitSymbol().getStringValue() != null ) && ( getJavaFXEditorUnitSymbol().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalUnitSymbol( null );
		}
		else {
			editObj.setOptionalUnitSymbol( getJavaFXEditorUnitSymbol().getStringValue() );
		}

		editObj.setRequiredPrecis( getJavaFXEditorPrecis().getInt16Value() );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		YCFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		ISecureISOCcyObj focus = getJavaFXFocusAsISOCcy();
		if( ( value != YCFPane.PaneMode.Unknown ) && ( value != YCFPane.PaneMode.View ) ) {
			if( focus == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"javaFXFocus" );
			}
		}
		ISecureISOCcyEditObj editObj;
		if( focus != null ) {
			editObj  = (ISecureISOCcyEditObj)focus.getEdit();
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
								editObj = (ISecureISOCcyEditObj)focus.beginEdit();
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
							editObj = (ISecureISOCcyEditObj)focus.beginEdit();
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
							editObj = (ISecureISOCcyEditObj)focus.beginEdit();
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
							editObj = (ISecureISOCcyEditObj)focus.beginEdit();
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
						focus = (ISecureISOCcyObj)editObj.create();
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
								editObj = (ISecureISOCcyEditObj)focus.beginEdit();
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
								editObj = (ISecureISOCcyEditObj)focus.beginEdit();
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
							editObj = (ISecureISOCcyEditObj)focus.beginEdit();
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
			ISecureISOCcyObj focus = getJavaFXFocusAsISOCcy();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( javafxEditorISOCcyId != null ) {
			javafxEditorISOCcyId.setDisable( true );
		}
		if( javafxEditorISOCode != null ) {
			javafxEditorISOCode.setDisable( ! isEditing );
		}
		if( javafxEditorName != null ) {
			javafxEditorName.setDisable( ! isEditing );
		}
		if( javafxEditorUnitSymbol != null ) {
			javafxEditorUnitSymbol.setDisable( ! isEditing );
		}
		if( javafxEditorPrecis != null ) {
			javafxEditorPrecis.setDisable( ! isEditing );
		}
	}
}
