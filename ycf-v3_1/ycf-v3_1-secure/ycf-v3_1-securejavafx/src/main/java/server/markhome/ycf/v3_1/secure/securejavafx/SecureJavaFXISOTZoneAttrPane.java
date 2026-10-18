// Description: Java 25 JavaFX Attribute Pane implementation for ISOTZone.

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
 *	SecureJavaFXISOTZoneAttrPane JavaFX Attribute Pane implementation
 *	for ISOTZone.
 */
public class SecureJavaFXISOTZoneAttrPane
extends YCFGridPane
implements ISecureJavaFXISOTZonePaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected ISecureJavaFXSchema javafxSchema = null;
	boolean javafxIsInitializing = true;

	protected class ISOTZoneIdYCFLabel
		extends YCFLabel
	{
		public ISOTZoneIdYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOTZone.AttrPane.ISOTZoneId.EffLabel"));
		}
	}

	protected class ISOTZoneIdEditor
		extends YCFInt16Editor
	{
		public ISOTZoneIdEditor() {
			super();
			setMinValue( ISecureISOTZone.ISOTZONEID_MIN_VALUE );
			setFieldNameInzTag( "secure.javafx.ISOTZone.AttrPane.ISOTZoneId.EffLabel" );
		}
	}

	protected class Iso8601YCFLabel
		extends YCFLabel
	{
		public Iso8601YCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOTZone.AttrPane.Iso8601.EffLabel"));
		}
	}

	protected class Iso8601Editor
		extends YCFStringEditor
	{
		public Iso8601Editor() {
			super();
			setMaxLen( 6 );
			setFieldNameInzTag( "secure.javafx.ISOTZone.AttrPane.Iso8601.EffLabel" );
		}
	}

	protected class TZNameYCFLabel
		extends YCFLabel
	{
		public TZNameYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOTZone.AttrPane.TZName.EffLabel"));
		}
	}

	protected class TZNameEditor
		extends YCFStringEditor
	{
		public TZNameEditor() {
			super();
			setMaxLen( 64 );
			setFieldNameInzTag( "secure.javafx.ISOTZone.AttrPane.TZName.EffLabel" );
		}
	}

	protected class TZHourOffsetYCFLabel
		extends YCFLabel
	{
		public TZHourOffsetYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOTZone.AttrPane.TZHourOffset.EffLabel"));
		}
	}

	protected class TZHourOffsetEditor
		extends YCFInt16Editor
	{
		public TZHourOffsetEditor() {
			super();
			setMinValue( ISecureISOTZone.TZHOUROFFSET_MIN_VALUE );
			setMaxValue( ISecureISOTZone.TZHOUROFFSET_MAX_VALUE );
			setFieldNameInzTag( "secure.javafx.ISOTZone.AttrPane.TZHourOffset.EffLabel" );
		}
	}

	protected class TZMinOffsetYCFLabel
		extends YCFLabel
	{
		public TZMinOffsetYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOTZone.AttrPane.TZMinOffset.EffLabel"));
		}
	}

	protected class TZMinOffsetEditor
		extends YCFInt16Editor
	{
		public TZMinOffsetEditor() {
			super();
			setMinValue( ISecureISOTZone.TZMINOFFSET_MIN_VALUE );
			setMaxValue( ISecureISOTZone.TZMINOFFSET_MAX_VALUE );
			setFieldNameInzTag( "secure.javafx.ISOTZone.AttrPane.TZMinOffset.EffLabel" );
		}
	}

	protected class DescriptionYCFLabel
		extends YCFLabel
	{
		public DescriptionYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOTZone.AttrPane.Description.EffLabel"));
		}
	}

	protected class DescriptionEditor
		extends YCFStringEditor
	{
		public DescriptionEditor() {
			super();
			setMaxLen( 128 );
			setFieldNameInzTag( "secure.javafx.ISOTZone.AttrPane.Description.EffLabel" );
		}
	}

	protected class VisibleYCFLabel
		extends YCFLabel
	{
		public VisibleYCFLabel() {
			super();
			setText(Inz.s("secure.javafx.ISOTZone.AttrPane.Visible.EffLabel"));
		}
	}

	protected class VisibleEditor
		extends YCFBoolEditor
	{
		public VisibleEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "secure.javafx.ISOTZone.AttrPane.Visible.EffLabel" );
		}
	}

	protected ISOTZoneIdYCFLabel javafxLabelISOTZoneId = null;
	protected ISOTZoneIdEditor javafxEditorISOTZoneId = null;
	protected Iso8601YCFLabel javafxLabelIso8601 = null;
	protected Iso8601Editor javafxEditorIso8601 = null;
	protected TZNameYCFLabel javafxLabelTZName = null;
	protected TZNameEditor javafxEditorTZName = null;
	protected TZHourOffsetYCFLabel javafxLabelTZHourOffset = null;
	protected TZHourOffsetEditor javafxEditorTZHourOffset = null;
	protected TZMinOffsetYCFLabel javafxLabelTZMinOffset = null;
	protected TZMinOffsetEditor javafxEditorTZMinOffset = null;
	protected DescriptionYCFLabel javafxLabelDescription = null;
	protected DescriptionEditor javafxEditorDescription = null;
	protected VisibleYCFLabel javafxLabelVisible = null;
	protected VisibleEditor javafxEditorVisible = null;

	public SecureJavaFXISOTZoneAttrPane( IYCFFormManager formManager, ISecureJavaFXSchema argSchema, ISecureISOTZoneObj argFocus ) {
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
		setJavaFXFocusAsISOTZone( argFocus );
		setPadding( new Insets(5) );
		setHgap( 5 );
		setVgap( 5 );
		setAlignment( Pos.CENTER );
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth( 100 );
		getColumnConstraints().addAll( column1 );
		int gridRow = 0;
		label = getJavaFXLabelISOTZoneId();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorISOTZoneId();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelIso8601();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorIso8601();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelTZName();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorTZName();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelTZHourOffset();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorTZHourOffset();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelTZMinOffset();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorTZMinOffset();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelDescription();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorDescription();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelVisible();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorVisible();
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
		if( ( value == null ) || ( value instanceof ISecureISOTZoneObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"ISecureISOTZoneObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public ISecureISOTZoneObj getJavaFXFocusAsISOTZone() {
		return( (ISecureISOTZoneObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsISOTZone( ISecureISOTZoneObj value ) {
		setJavaFXFocus( value );
	}

	public ISecureISOTZoneObj getEffJavaFXFocus() {
		ISecureISOTZoneObj eff = (ISecureISOTZoneObj)getJavaFXFocus();
		if( eff != null ) {
			if( null != eff.getEdit() ) {
				eff = (ISecureISOTZoneObj)eff.getEdit();
			}
		}
		return( eff );
	}

	public ISOTZoneIdYCFLabel getJavaFXLabelISOTZoneId() {
		if( javafxLabelISOTZoneId == null ) {
			javafxLabelISOTZoneId = new ISOTZoneIdYCFLabel();
		}
		return( javafxLabelISOTZoneId );
	}

	public void setJavaFXLabelISOTZoneId( ISOTZoneIdYCFLabel value ) {
		javafxLabelISOTZoneId = value;
	}

	public ISOTZoneIdEditor getJavaFXEditorISOTZoneId() {
		if( javafxEditorISOTZoneId == null ) {
			javafxEditorISOTZoneId = new ISOTZoneIdEditor();
		}
		return( javafxEditorISOTZoneId );
	}

	public void setJavaFXEditorISOTZoneId( ISOTZoneIdEditor value ) {
		javafxEditorISOTZoneId = value;
	}

	public Iso8601YCFLabel getJavaFXLabelIso8601() {
		if( javafxLabelIso8601 == null ) {
			javafxLabelIso8601 = new Iso8601YCFLabel();
		}
		return( javafxLabelIso8601 );
	}

	public void setJavaFXLabelIso8601( Iso8601YCFLabel value ) {
		javafxLabelIso8601 = value;
	}

	public Iso8601Editor getJavaFXEditorIso8601() {
		if( javafxEditorIso8601 == null ) {
			javafxEditorIso8601 = new Iso8601Editor();
		}
		return( javafxEditorIso8601 );
	}

	public void setJavaFXEditorIso8601( Iso8601Editor value ) {
		javafxEditorIso8601 = value;
	}

	public TZNameYCFLabel getJavaFXLabelTZName() {
		if( javafxLabelTZName == null ) {
			javafxLabelTZName = new TZNameYCFLabel();
		}
		return( javafxLabelTZName );
	}

	public void setJavaFXLabelTZName( TZNameYCFLabel value ) {
		javafxLabelTZName = value;
	}

	public TZNameEditor getJavaFXEditorTZName() {
		if( javafxEditorTZName == null ) {
			javafxEditorTZName = new TZNameEditor();
		}
		return( javafxEditorTZName );
	}

	public void setJavaFXEditorTZName( TZNameEditor value ) {
		javafxEditorTZName = value;
	}

	public TZHourOffsetYCFLabel getJavaFXLabelTZHourOffset() {
		if( javafxLabelTZHourOffset == null ) {
			javafxLabelTZHourOffset = new TZHourOffsetYCFLabel();
		}
		return( javafxLabelTZHourOffset );
	}

	public void setJavaFXLabelTZHourOffset( TZHourOffsetYCFLabel value ) {
		javafxLabelTZHourOffset = value;
	}

	public TZHourOffsetEditor getJavaFXEditorTZHourOffset() {
		if( javafxEditorTZHourOffset == null ) {
			javafxEditorTZHourOffset = new TZHourOffsetEditor();
		}
		return( javafxEditorTZHourOffset );
	}

	public void setJavaFXEditorTZHourOffset( TZHourOffsetEditor value ) {
		javafxEditorTZHourOffset = value;
	}

	public TZMinOffsetYCFLabel getJavaFXLabelTZMinOffset() {
		if( javafxLabelTZMinOffset == null ) {
			javafxLabelTZMinOffset = new TZMinOffsetYCFLabel();
		}
		return( javafxLabelTZMinOffset );
	}

	public void setJavaFXLabelTZMinOffset( TZMinOffsetYCFLabel value ) {
		javafxLabelTZMinOffset = value;
	}

	public TZMinOffsetEditor getJavaFXEditorTZMinOffset() {
		if( javafxEditorTZMinOffset == null ) {
			javafxEditorTZMinOffset = new TZMinOffsetEditor();
		}
		return( javafxEditorTZMinOffset );
	}

	public void setJavaFXEditorTZMinOffset( TZMinOffsetEditor value ) {
		javafxEditorTZMinOffset = value;
	}

	public DescriptionYCFLabel getJavaFXLabelDescription() {
		if( javafxLabelDescription == null ) {
			javafxLabelDescription = new DescriptionYCFLabel();
		}
		return( javafxLabelDescription );
	}

	public void setJavaFXLabelDescription( DescriptionYCFLabel value ) {
		javafxLabelDescription = value;
	}

	public DescriptionEditor getJavaFXEditorDescription() {
		if( javafxEditorDescription == null ) {
			javafxEditorDescription = new DescriptionEditor();
		}
		return( javafxEditorDescription );
	}

	public void setJavaFXEditorDescription( DescriptionEditor value ) {
		javafxEditorDescription = value;
	}

	public VisibleYCFLabel getJavaFXLabelVisible() {
		if( javafxLabelVisible == null ) {
			javafxLabelVisible = new VisibleYCFLabel();
		}
		return( javafxLabelVisible );
	}

	public void setJavaFXLabelVisible( VisibleYCFLabel value ) {
		javafxLabelVisible = value;
	}

	public VisibleEditor getJavaFXEditorVisible() {
		if( javafxEditorVisible == null ) {
			javafxEditorVisible = new VisibleEditor();
		}
		return( javafxEditorVisible );
	}

	public void setJavaFXEditorVisible( VisibleEditor value ) {
		javafxEditorVisible = value;
	}

	public void populateFields()
	{
		ISecureISOTZoneObj popObj = getEffJavaFXFocus();
		if( getPaneMode() == YCFPane.PaneMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			getJavaFXEditorISOTZoneId().setInt16Value( null );
		}
		else {
			getJavaFXEditorISOTZoneId().setInt16Value( popObj.getRequiredISOTZoneId() );
		}

		if( popObj == null ) {
			getJavaFXEditorIso8601().setStringValue( null );
		}
		else {
			getJavaFXEditorIso8601().setStringValue( popObj.getRequiredIso8601() );
		}

		if( popObj == null ) {
			getJavaFXEditorTZName().setStringValue( null );
		}
		else {
			getJavaFXEditorTZName().setStringValue( popObj.getRequiredTZName() );
		}

		if( popObj == null ) {
			getJavaFXEditorTZHourOffset().setInt16Value( null );
		}
		else {
			getJavaFXEditorTZHourOffset().setInt16Value( popObj.getRequiredTZHourOffset() );
		}

		if( popObj == null ) {
			getJavaFXEditorTZMinOffset().setInt16Value( null );
		}
		else {
			getJavaFXEditorTZMinOffset().setInt16Value( popObj.getRequiredTZMinOffset() );
		}

		if( popObj == null ) {
			getJavaFXEditorDescription().setStringValue( null );
		}
		else {
			getJavaFXEditorDescription().setStringValue( popObj.getRequiredDescription() );
		}

		if( popObj == null ) {
			getJavaFXEditorVisible().setBooleanValue( null );
		}
		else {
			getJavaFXEditorVisible().setBooleanValue( popObj.getRequiredVisible() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		ISecureISOTZoneObj focus = getJavaFXFocusAsISOTZone();
		ISecureISOTZoneEditObj editObj;
		if( focus != null ) {
			editObj = (ISecureISOTZoneEditObj)(focus.getEdit());
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

		if( getJavaFXEditorIso8601().getStringValue() == null ) {
			editObj.setRequiredIso8601( "" );
		}
		else {
			editObj.setRequiredIso8601( getJavaFXEditorIso8601().getStringValue() );
		}

		if( getJavaFXEditorTZName().getStringValue() == null ) {
			editObj.setRequiredTZName( "" );
		}
		else {
			editObj.setRequiredTZName( getJavaFXEditorTZName().getStringValue() );
		}

		editObj.setRequiredTZHourOffset( getJavaFXEditorTZHourOffset().getInt16Value() );

		editObj.setRequiredTZMinOffset( getJavaFXEditorTZMinOffset().getInt16Value() );

		if( getJavaFXEditorDescription().getStringValue() == null ) {
			editObj.setRequiredDescription( "" );
		}
		else {
			editObj.setRequiredDescription( getJavaFXEditorDescription().getStringValue() );
		}

		editObj.setRequiredVisible( getJavaFXEditorVisible().getBooleanValue() );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		YCFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		ISecureISOTZoneObj focus = getJavaFXFocusAsISOTZone();
		if( ( value != YCFPane.PaneMode.Unknown ) && ( value != YCFPane.PaneMode.View ) ) {
			if( focus == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"javaFXFocus" );
			}
		}
		ISecureISOTZoneEditObj editObj;
		if( focus != null ) {
			editObj  = (ISecureISOTZoneEditObj)focus.getEdit();
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
								editObj = (ISecureISOTZoneEditObj)focus.beginEdit();
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
							editObj = (ISecureISOTZoneEditObj)focus.beginEdit();
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
							editObj = (ISecureISOTZoneEditObj)focus.beginEdit();
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
							editObj = (ISecureISOTZoneEditObj)focus.beginEdit();
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
						focus = (ISecureISOTZoneObj)editObj.create();
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
								editObj = (ISecureISOTZoneEditObj)focus.beginEdit();
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
								editObj = (ISecureISOTZoneEditObj)focus.beginEdit();
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
							editObj = (ISecureISOTZoneEditObj)focus.beginEdit();
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
			ISecureISOTZoneObj focus = getJavaFXFocusAsISOTZone();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( javafxEditorISOTZoneId != null ) {
			javafxEditorISOTZoneId.setDisable( true );
		}
		if( javafxEditorIso8601 != null ) {
			javafxEditorIso8601.setDisable( ! isEditing );
		}
		if( javafxEditorTZName != null ) {
			javafxEditorTZName.setDisable( ! isEditing );
		}
		if( javafxEditorTZHourOffset != null ) {
			javafxEditorTZHourOffset.setDisable( ! isEditing );
		}
		if( javafxEditorTZMinOffset != null ) {
			javafxEditorTZMinOffset.setDisable( ! isEditing );
		}
		if( javafxEditorDescription != null ) {
			javafxEditorDescription.setDisable( ! isEditing );
		}
		if( javafxEditorVisible != null ) {
			javafxEditorVisible.setDisable( ! isEditing );
		}
	}
}
