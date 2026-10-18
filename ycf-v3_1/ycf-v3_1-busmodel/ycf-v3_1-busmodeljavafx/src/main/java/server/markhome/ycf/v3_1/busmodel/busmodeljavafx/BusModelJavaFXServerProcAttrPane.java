// Description: Java 25 JavaFX Attribute Pane implementation for ServerProc.

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
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;
import server.markhome.ycf.v3_1.secure.securejavafx.*;
import server.markhome.ycf.v3_1.intnet.intnetjavafx.*;

/**
 *	BusModelJavaFXServerProcAttrPane JavaFX Attribute Pane implementation
 *	for ServerProc.
 */
public class BusModelJavaFXServerProcAttrPane
extends YCFGridPane
implements IBusModelJavaFXServerProcPaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected IBusModelJavaFXSchema javafxSchema = null;
	boolean javafxIsInitializing = true;

	protected ObservableList<String> observableListOfCodeVis =
		FXCollections.observableArrayList(
			"Public",
			"Protected",
			"Private" );

	protected class DefSchemaYCFLabel
		extends YCFLabel
	{
		public DefSchemaYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.ServerMethod.AttrPane.LookupDefSchema.EffLabel"));
		}
	}

	protected class CallbackDefSchemaChosen
	implements IBusModelJavaFXSchemaDefChosen
	{
		public CallbackDefSchemaChosen() {
		}

		public void choseSchemaDef( IBusModelSchemaDefObj value ) {
			if( javafxReferenceLookupDefSchema != null ) {
				IBusModelServerProcObj cur = getJavaFXFocusAsServerProc();
				if( cur != null ) {
					IBusModelServerProcEditObj editObj = (IBusModelServerProcEditObj)cur.getEdit();
					if( null != editObj ) {
						YCFPane.PaneMode curMode = getPaneMode();
						if( ( curMode == YCFPane.PaneMode.Add ) || ( curMode == YCFPane.PaneMode.Edit ) ) {
							javafxReferenceLookupDefSchema.setReferencedObject( value );
							editObj.setOptionalLookupDefSchema( value );
						}
					}
				}
			}
		}
	}

	protected class DefSchemaReferenceCallback
	implements IYCFReferenceCallback
	{
		public void chose( IYCFLibAnyObj value ) {
			final String S_ProcName = "chose";
			Node cont;
			IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
			IBusModelServerProcObj focus = getEffJavaFXFocus();
			IBusModelSchemaDefObj referencedObj = (IBusModelSchemaDefObj)javafxReferenceLookupDefSchema.getReferencedObject();
			java.util.List<IBusModelSchemaDefObj> listOfSchemaDef = null;
			Collection<IBusModelSchemaDefObj> cltn = null;
			YCFBorderPane form = javafxSchema.getSchemaDefFactory().newPickerForm( ycfFormManager, referencedObj, null, cltn, new CallbackDefSchemaChosen() );
			((IBusModelJavaFXSchemaDefPaneCommon)form).setPaneMode( YCFPane.PaneMode.View );
			ycfFormManager.pushForm( form );
		}

		public void view( IYCFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			IBusModelServerProcObj focus = getEffJavaFXFocus();
			if( focus != null ) {
				IBusModelSchemaDefObj referencedObj = (IBusModelSchemaDefObj)javafxReferenceLookupDefSchema.getReferencedObject();
				YCFBorderPane form = null;
				if( referencedObj != null ) {
					int classCode = referencedObj.getClassCode();
					ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
					int backingClassCode = entry.getBackingClassCode();
					if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelSchemaDef.CLASS_CODE ) {
						form = javafxSchema.getSchemaDefFactory().newAddForm( ycfFormManager, referencedObj, null, true );
						IBusModelJavaFXSchemaDefPaneCommon spec = (IBusModelJavaFXSchemaDefPaneCommon)form;
						spec.setJavaFXFocus( referencedObj );
						spec.setPaneMode( YCFPane.PaneMode.View );
					}
					else {
						throw new YCFLibUnsupportedClassException( getClass(),
							S_ProcName,
							"javaFXFocus",
							focus,
							"IBusModelSchemaDefObj" );
					}
					ycfFormManager.pushForm( form );
				}
			}
		}
	}

	protected class DefSchemaYCFReferenceEditor
		extends YCFReferenceEditor
	{
		public DefSchemaYCFReferenceEditor() {
			super( new DefSchemaReferenceCallback() );
			setFieldNameInzTag( "busmodel.javafx.ServerMethod.AttrPane.DefSchema.EffLabel" );
		}
	}

	protected class IdYCFLabel
		extends YCFLabel
	{
		public IdYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Scope.AttrPane.Id.EffLabel"));
		}
	}

	protected class IdEditor
		extends YCFDbKeyHash256Editor
	{
		public IdEditor() {
			super();
			setFieldNameInzTag( "busmodel.javafx.Scope.AttrPane.Id.EffLabel" );
		}
	}

	protected class NameYCFLabel
		extends YCFLabel
	{
		public NameYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.ServerMethod.AttrPane.Name.EffLabel"));
		}
	}

	protected class NameEditor
		extends YCFStringEditor
	{
		public NameEditor() {
			super();
			setMaxLen( 192 );
			setFieldNameInzTag( "busmodel.javafx.ServerMethod.AttrPane.Name.EffLabel" );
		}
	}

	protected class ShortNameYCFLabel
		extends YCFLabel
	{
		public ShortNameYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.ServerMethod.AttrPane.ShortName.EffLabel"));
		}
	}

	protected class ShortNameEditor
		extends YCFStringEditor
	{
		public ShortNameEditor() {
			super();
			setMaxLen( 16 );
			setFieldNameInzTag( "busmodel.javafx.ServerMethod.AttrPane.ShortName.EffLabel" );
		}
	}

	protected class LabelYCFLabel
		extends YCFLabel
	{
		public LabelYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.ServerMethod.AttrPane.Label.EffLabel"));
		}
	}

	protected class LabelEditor
		extends YCFStringEditor
	{
		public LabelEditor() {
			super();
			setMaxLen( 64 );
			setFieldNameInzTag( "busmodel.javafx.ServerMethod.AttrPane.Label.EffLabel" );
		}
	}

	protected class ShortDescriptionYCFLabel
		extends YCFLabel
	{
		public ShortDescriptionYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.ServerMethod.AttrPane.ShortDescription.EffLabel"));
		}
	}

	protected class ShortDescriptionEditor
		extends YCFStringEditor
	{
		public ShortDescriptionEditor() {
			super();
			setMaxLen( 128 );
			setFieldNameInzTag( "busmodel.javafx.ServerMethod.AttrPane.ShortDescription.EffLabel" );
		}
	}

	protected class DescriptionYCFLabel
		extends YCFLabel
	{
		public DescriptionYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.ServerMethod.AttrPane.Description.EffLabel"));
		}
	}

	protected class DescriptionEditor
		extends YCFStringEditor
	{
		public DescriptionEditor() {
			super();
			setMaxLen( 1023 );
			setFieldNameInzTag( "busmodel.javafx.ServerMethod.AttrPane.Description.EffLabel" );
		}
	}

	protected class SuffixYCFLabel
		extends YCFLabel
	{
		public SuffixYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.ServerMethod.AttrPane.Suffix.EffLabel"));
		}
	}

	protected class SuffixEditor
		extends YCFStringEditor
	{
		public SuffixEditor() {
			super();
			setMaxLen( 16 );
			setFieldNameInzTag( "busmodel.javafx.ServerMethod.AttrPane.Suffix.EffLabel" );
		}
	}

	protected class IsInstanceMethodYCFLabel
		extends YCFLabel
	{
		public IsInstanceMethodYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.ServerMethod.AttrPane.IsInstanceMethod.EffLabel"));
		}
	}

	protected class IsInstanceMethodEditor
		extends YCFBoolEditor
	{
		public IsInstanceMethodEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "busmodel.javafx.ServerMethod.AttrPane.IsInstanceMethod.EffLabel" );
		}
	}

	protected class IsServerOnlyYCFLabel
		extends YCFLabel
	{
		public IsServerOnlyYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.ServerMethod.AttrPane.IsServerOnly.EffLabel"));
		}
	}

	protected class IsServerOnlyEditor
		extends YCFBoolEditor
	{
		public IsServerOnlyEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "busmodel.javafx.ServerMethod.AttrPane.IsServerOnly.EffLabel" );
		}
	}

	protected class CodeVisYCFLabel
		extends YCFLabel
	{
		public CodeVisYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.ServerMethod.AttrPane.CodeVis.EffLabel"));
		}
	}

	protected class CodeVisEditor
		extends ComboBox<String>
	{
		public CodeVisEditor() {
			super();
			setItems( observableListOfCodeVis );
		}
	}

	protected class JMethodBodyYCFLabel
		extends YCFLabel
	{
		public JMethodBodyYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.ServerMethod.AttrPane.JMethodBody.EffLabel"));
		}
	}

	protected class JMethodBodyEditor
		extends YCFTextEditor
	{
		public JMethodBodyEditor() {
			super();
			setMaxLen( 2000000 );
			setFieldNameInzTag( "busmodel.javafx.ServerMethod.AttrPane.JMethodBody.EffLabel" );
			setPrefHeight( 10 * 20 );
			setMinHeight( 10 * 20 );
		}
	}

	protected class CppMethodBodyYCFLabel
		extends YCFLabel
	{
		public CppMethodBodyYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.ServerMethod.AttrPane.CppMethodBody.EffLabel"));
		}
	}

	protected class CppMethodBodyEditor
		extends YCFTextEditor
	{
		public CppMethodBodyEditor() {
			super();
			setMaxLen( 2000000 );
			setFieldNameInzTag( "busmodel.javafx.ServerMethod.AttrPane.CppMethodBody.EffLabel" );
			setPrefHeight( 10 * 20 );
			setMinHeight( 10 * 20 );
		}
	}

	protected class CsMethodBodyYCFLabel
		extends YCFLabel
	{
		public CsMethodBodyYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.ServerMethod.AttrPane.CsMethodBody.EffLabel"));
		}
	}

	protected class CsMethodBodyEditor
		extends YCFTextEditor
	{
		public CsMethodBodyEditor() {
			super();
			setMaxLen( 2000000 );
			setFieldNameInzTag( "busmodel.javafx.ServerMethod.AttrPane.CsMethodBody.EffLabel" );
			setPrefHeight( 10 * 20 );
			setMinHeight( 10 * 20 );
		}
	}

	protected class DummyYCFLabel
		extends YCFLabel
	{
		public DummyYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.ServerProc.AttrPane.Dummy.EffLabel"));
		}
	}

	protected class DummyEditor
		extends YCFStringEditor
	{
		public DummyEditor() {
			super();
			setMaxLen( 16 );
			setFieldNameInzTag( "busmodel.javafx.ServerProc.AttrPane.Dummy.EffLabel" );
		}
	}

	protected IBusModelSchemaDefObj javafxLookupDefSchemaObj = null;
	protected DefSchemaYCFLabel javafxLabelLookupDefSchema = null;
	protected DefSchemaYCFReferenceEditor javafxReferenceLookupDefSchema = null;
	protected IdYCFLabel javafxLabelId = null;
	protected IdEditor javafxEditorId = null;
	protected NameYCFLabel javafxLabelName = null;
	protected NameEditor javafxEditorName = null;
	protected ShortNameYCFLabel javafxLabelShortName = null;
	protected ShortNameEditor javafxEditorShortName = null;
	protected LabelYCFLabel javafxLabelLabel = null;
	protected LabelEditor javafxEditorLabel = null;
	protected ShortDescriptionYCFLabel javafxLabelShortDescription = null;
	protected ShortDescriptionEditor javafxEditorShortDescription = null;
	protected DescriptionYCFLabel javafxLabelDescription = null;
	protected DescriptionEditor javafxEditorDescription = null;
	protected SuffixYCFLabel javafxLabelSuffix = null;
	protected SuffixEditor javafxEditorSuffix = null;
	protected IsInstanceMethodYCFLabel javafxLabelIsInstanceMethod = null;
	protected IsInstanceMethodEditor javafxEditorIsInstanceMethod = null;
	protected IsServerOnlyYCFLabel javafxLabelIsServerOnly = null;
	protected IsServerOnlyEditor javafxEditorIsServerOnly = null;
	protected CodeVisYCFLabel javafxLabelCodeVis = null;
	protected CodeVisEditor javafxEditorCodeVis = null;
	protected JMethodBodyYCFLabel javafxLabelJMethodBody = null;
	protected JMethodBodyEditor javafxEditorJMethodBody = null;
	protected CppMethodBodyYCFLabel javafxLabelCppMethodBody = null;
	protected CppMethodBodyEditor javafxEditorCppMethodBody = null;
	protected CsMethodBodyYCFLabel javafxLabelCsMethodBody = null;
	protected CsMethodBodyEditor javafxEditorCsMethodBody = null;
	protected DummyYCFLabel javafxLabelDummy = null;
	protected DummyEditor javafxEditorDummy = null;

	public BusModelJavaFXServerProcAttrPane( IYCFFormManager formManager, IBusModelJavaFXSchema argSchema, IBusModelServerProcObj argFocus ) {
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
		setJavaFXFocusAsServerProc( argFocus );
		setPadding( new Insets(5) );
		setHgap( 5 );
		setVgap( 5 );
		setAlignment( Pos.CENTER );
		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth( 100 );
		getColumnConstraints().addAll( column1 );
		int gridRow = 0;
		label = getJavaFXLabelLookupDefSchema();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		reference = getJavaFXReferenceLookupDefSchema();
		setHalignment( reference, HPos.LEFT );
		add( reference, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelId();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorId();
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

		label = getJavaFXLabelShortName();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorShortName();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelLabel();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorLabel();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelShortDescription();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorShortDescription();
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

		label = getJavaFXLabelSuffix();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorSuffix();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelIsInstanceMethod();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorIsInstanceMethod();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelIsServerOnly();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorIsServerOnly();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelCodeVis();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorCodeVis();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelJMethodBody();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorJMethodBody();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelCppMethodBody();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorCppMethodBody();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelCsMethodBody();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorCsMethodBody();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelDummy();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorDummy();
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

	public IBusModelJavaFXSchema getJavaFXSchema() {
		return( javafxSchema );
	}

	public void setJavaFXFocus( IYCFLibAnyObj value ) {
		final String S_ProcName = "setJavaFXFocus";
		if( ( value == null ) || ( value instanceof IBusModelServerProcObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IBusModelServerProcObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public IBusModelServerProcObj getJavaFXFocusAsServerProc() {
		return( (IBusModelServerProcObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsServerProc( IBusModelServerProcObj value ) {
		setJavaFXFocus( value );
	}

	public IBusModelServerProcObj getEffJavaFXFocus() {
		IBusModelServerProcObj eff = (IBusModelServerProcObj)getJavaFXFocus();
		if( eff != null ) {
			if( null != eff.getEdit() ) {
				eff = (IBusModelServerProcObj)eff.getEdit();
			}
		}
		return( eff );
	}

	public IBusModelSchemaDefObj getJavaFXLookupDefSchemaObj() {
		return( javafxLookupDefSchemaObj );
	}

	public void setJavaFXLookupDefSchemaObj( IBusModelSchemaDefObj value ) {
		javafxLookupDefSchemaObj = value;
	}

	public YCFLabel getJavaFXLabelLookupDefSchema() {
		if( javafxLabelLookupDefSchema == null ) {
			javafxLabelLookupDefSchema = new DefSchemaYCFLabel();
		}
		return( javafxLabelLookupDefSchema );
	}

	public YCFReferenceEditor getJavaFXReferenceLookupDefSchema() {
		if( javafxReferenceLookupDefSchema == null ) {
			javafxReferenceLookupDefSchema = new DefSchemaYCFReferenceEditor();
		}
		return( javafxReferenceLookupDefSchema );
	}

	public void setJavaFXReferenceLookupDefSchema( DefSchemaYCFReferenceEditor value ) {
		javafxReferenceLookupDefSchema = value;
	}

	public IdYCFLabel getJavaFXLabelId() {
		if( javafxLabelId == null ) {
			javafxLabelId = new IdYCFLabel();
		}
		return( javafxLabelId );
	}

	public void setJavaFXLabelId( IdYCFLabel value ) {
		javafxLabelId = value;
	}

	public IdEditor getJavaFXEditorId() {
		if( javafxEditorId == null ) {
			javafxEditorId = new IdEditor();
		}
		return( javafxEditorId );
	}

	public void setJavaFXEditorId( IdEditor value ) {
		javafxEditorId = value;
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

	public ShortNameYCFLabel getJavaFXLabelShortName() {
		if( javafxLabelShortName == null ) {
			javafxLabelShortName = new ShortNameYCFLabel();
		}
		return( javafxLabelShortName );
	}

	public void setJavaFXLabelShortName( ShortNameYCFLabel value ) {
		javafxLabelShortName = value;
	}

	public ShortNameEditor getJavaFXEditorShortName() {
		if( javafxEditorShortName == null ) {
			javafxEditorShortName = new ShortNameEditor();
		}
		return( javafxEditorShortName );
	}

	public void setJavaFXEditorShortName( ShortNameEditor value ) {
		javafxEditorShortName = value;
	}

	public LabelYCFLabel getJavaFXLabelLabel() {
		if( javafxLabelLabel == null ) {
			javafxLabelLabel = new LabelYCFLabel();
		}
		return( javafxLabelLabel );
	}

	public void setJavaFXLabelLabel( LabelYCFLabel value ) {
		javafxLabelLabel = value;
	}

	public LabelEditor getJavaFXEditorLabel() {
		if( javafxEditorLabel == null ) {
			javafxEditorLabel = new LabelEditor();
		}
		return( javafxEditorLabel );
	}

	public void setJavaFXEditorLabel( LabelEditor value ) {
		javafxEditorLabel = value;
	}

	public ShortDescriptionYCFLabel getJavaFXLabelShortDescription() {
		if( javafxLabelShortDescription == null ) {
			javafxLabelShortDescription = new ShortDescriptionYCFLabel();
		}
		return( javafxLabelShortDescription );
	}

	public void setJavaFXLabelShortDescription( ShortDescriptionYCFLabel value ) {
		javafxLabelShortDescription = value;
	}

	public ShortDescriptionEditor getJavaFXEditorShortDescription() {
		if( javafxEditorShortDescription == null ) {
			javafxEditorShortDescription = new ShortDescriptionEditor();
		}
		return( javafxEditorShortDescription );
	}

	public void setJavaFXEditorShortDescription( ShortDescriptionEditor value ) {
		javafxEditorShortDescription = value;
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

	public SuffixYCFLabel getJavaFXLabelSuffix() {
		if( javafxLabelSuffix == null ) {
			javafxLabelSuffix = new SuffixYCFLabel();
		}
		return( javafxLabelSuffix );
	}

	public void setJavaFXLabelSuffix( SuffixYCFLabel value ) {
		javafxLabelSuffix = value;
	}

	public SuffixEditor getJavaFXEditorSuffix() {
		if( javafxEditorSuffix == null ) {
			javafxEditorSuffix = new SuffixEditor();
		}
		return( javafxEditorSuffix );
	}

	public void setJavaFXEditorSuffix( SuffixEditor value ) {
		javafxEditorSuffix = value;
	}

	public IsInstanceMethodYCFLabel getJavaFXLabelIsInstanceMethod() {
		if( javafxLabelIsInstanceMethod == null ) {
			javafxLabelIsInstanceMethod = new IsInstanceMethodYCFLabel();
		}
		return( javafxLabelIsInstanceMethod );
	}

	public void setJavaFXLabelIsInstanceMethod( IsInstanceMethodYCFLabel value ) {
		javafxLabelIsInstanceMethod = value;
	}

	public IsInstanceMethodEditor getJavaFXEditorIsInstanceMethod() {
		if( javafxEditorIsInstanceMethod == null ) {
			javafxEditorIsInstanceMethod = new IsInstanceMethodEditor();
		}
		return( javafxEditorIsInstanceMethod );
	}

	public void setJavaFXEditorIsInstanceMethod( IsInstanceMethodEditor value ) {
		javafxEditorIsInstanceMethod = value;
	}

	public IsServerOnlyYCFLabel getJavaFXLabelIsServerOnly() {
		if( javafxLabelIsServerOnly == null ) {
			javafxLabelIsServerOnly = new IsServerOnlyYCFLabel();
		}
		return( javafxLabelIsServerOnly );
	}

	public void setJavaFXLabelIsServerOnly( IsServerOnlyYCFLabel value ) {
		javafxLabelIsServerOnly = value;
	}

	public IsServerOnlyEditor getJavaFXEditorIsServerOnly() {
		if( javafxEditorIsServerOnly == null ) {
			javafxEditorIsServerOnly = new IsServerOnlyEditor();
		}
		return( javafxEditorIsServerOnly );
	}

	public void setJavaFXEditorIsServerOnly( IsServerOnlyEditor value ) {
		javafxEditorIsServerOnly = value;
	}

	public CodeVisYCFLabel getJavaFXLabelCodeVis() {
		if( javafxLabelCodeVis == null ) {
			javafxLabelCodeVis = new CodeVisYCFLabel();
		}
		return( javafxLabelCodeVis );
	}

	public void setJavaFXLabelCodeVis( CodeVisYCFLabel value ) {
		javafxLabelCodeVis = value;
	}

	public CodeVisEditor getJavaFXEditorCodeVis() {
		if( javafxEditorCodeVis == null ) {
			javafxEditorCodeVis = new CodeVisEditor();
		}
		return( javafxEditorCodeVis );
	}

	public void setJavaFXEditorCodeVis( CodeVisEditor value ) {
		javafxEditorCodeVis = value;
	}

	public JMethodBodyYCFLabel getJavaFXLabelJMethodBody() {
		if( javafxLabelJMethodBody == null ) {
			javafxLabelJMethodBody = new JMethodBodyYCFLabel();
		}
		return( javafxLabelJMethodBody );
	}

	public void setJavaFXLabelJMethodBody( JMethodBodyYCFLabel value ) {
		javafxLabelJMethodBody = value;
	}

	public JMethodBodyEditor getJavaFXEditorJMethodBody() {
		if( javafxEditorJMethodBody == null ) {
			javafxEditorJMethodBody = new JMethodBodyEditor();
		}
		return( javafxEditorJMethodBody );
	}

	public void setJavaFXEditorJMethodBody( JMethodBodyEditor value ) {
		javafxEditorJMethodBody = value;
	}

	public CppMethodBodyYCFLabel getJavaFXLabelCppMethodBody() {
		if( javafxLabelCppMethodBody == null ) {
			javafxLabelCppMethodBody = new CppMethodBodyYCFLabel();
		}
		return( javafxLabelCppMethodBody );
	}

	public void setJavaFXLabelCppMethodBody( CppMethodBodyYCFLabel value ) {
		javafxLabelCppMethodBody = value;
	}

	public CppMethodBodyEditor getJavaFXEditorCppMethodBody() {
		if( javafxEditorCppMethodBody == null ) {
			javafxEditorCppMethodBody = new CppMethodBodyEditor();
		}
		return( javafxEditorCppMethodBody );
	}

	public void setJavaFXEditorCppMethodBody( CppMethodBodyEditor value ) {
		javafxEditorCppMethodBody = value;
	}

	public CsMethodBodyYCFLabel getJavaFXLabelCsMethodBody() {
		if( javafxLabelCsMethodBody == null ) {
			javafxLabelCsMethodBody = new CsMethodBodyYCFLabel();
		}
		return( javafxLabelCsMethodBody );
	}

	public void setJavaFXLabelCsMethodBody( CsMethodBodyYCFLabel value ) {
		javafxLabelCsMethodBody = value;
	}

	public CsMethodBodyEditor getJavaFXEditorCsMethodBody() {
		if( javafxEditorCsMethodBody == null ) {
			javafxEditorCsMethodBody = new CsMethodBodyEditor();
		}
		return( javafxEditorCsMethodBody );
	}

	public void setJavaFXEditorCsMethodBody( CsMethodBodyEditor value ) {
		javafxEditorCsMethodBody = value;
	}

	public DummyYCFLabel getJavaFXLabelDummy() {
		if( javafxLabelDummy == null ) {
			javafxLabelDummy = new DummyYCFLabel();
		}
		return( javafxLabelDummy );
	}

	public void setJavaFXLabelDummy( DummyYCFLabel value ) {
		javafxLabelDummy = value;
	}

	public DummyEditor getJavaFXEditorDummy() {
		if( javafxEditorDummy == null ) {
			javafxEditorDummy = new DummyEditor();
		}
		return( javafxEditorDummy );
	}

	public void setJavaFXEditorDummy( DummyEditor value ) {
		javafxEditorDummy = value;
	}

	public void populateFields()
	{
		IBusModelServerProcObj popObj = getEffJavaFXFocus();
		if( getPaneMode() == YCFPane.PaneMode.Unknown ) {
			popObj = null;
		}
		if( popObj == null ) {
			javafxLookupDefSchemaObj = null;
		}
		else {
			javafxLookupDefSchemaObj = (IBusModelSchemaDefObj)popObj.getOptionalLookupDefSchema( javafxIsInitializing );
		}
		if( javafxReferenceLookupDefSchema != null ) {
			javafxReferenceLookupDefSchema.setReferencedObject( javafxLookupDefSchemaObj );
		}

		if( popObj == null ) {
			getJavaFXEditorId().setDbKeyHash256Value( null );
		}
		else {
			getJavaFXEditorId().setDbKeyHash256Value( popObj.getRequiredId() );
		}

		if( popObj == null ) {
			getJavaFXEditorName().setStringValue( null );
		}
		else {
			getJavaFXEditorName().setStringValue( popObj.getRequiredName() );
		}

		if( popObj == null ) {
			getJavaFXEditorShortName().setStringValue( null );
		}
		else {
			getJavaFXEditorShortName().setStringValue( popObj.getOptionalShortName() );
		}

		if( popObj == null ) {
			getJavaFXEditorLabel().setStringValue( null );
		}
		else {
			getJavaFXEditorLabel().setStringValue( popObj.getOptionalLabel() );
		}

		if( popObj == null ) {
			getJavaFXEditorShortDescription().setStringValue( null );
		}
		else {
			getJavaFXEditorShortDescription().setStringValue( popObj.getOptionalShortDescription() );
		}

		if( popObj == null ) {
			getJavaFXEditorDescription().setStringValue( null );
		}
		else {
			getJavaFXEditorDescription().setStringValue( popObj.getOptionalDescription() );
		}

		if( popObj == null ) {
			getJavaFXEditorSuffix().setStringValue( null );
		}
		else {
			getJavaFXEditorSuffix().setStringValue( popObj.getOptionalSuffix() );
		}

		if( popObj == null ) {
			getJavaFXEditorIsInstanceMethod().setBooleanValue( null );
		}
		else {
			getJavaFXEditorIsInstanceMethod().setBooleanValue( popObj.getRequiredIsInstanceMethod() );
		}

		if( popObj == null ) {
			getJavaFXEditorIsServerOnly().setBooleanValue( null );
		}
		else {
			getJavaFXEditorIsServerOnly().setBooleanValue( popObj.getRequiredIsServerOnly() );
		}

		if( popObj == null ) {
			getJavaFXEditorCodeVis().setValue( null );
		}
		else {
			getJavaFXEditorCodeVis().setValue(
				( popObj.getRequiredCodeVis() == null )
					? null
					: popObj.getRequiredCodeVis().toString() );
		}

		if( popObj == null ) {
			getJavaFXEditorJMethodBody().setTextValue( null );
		}
		else {
			getJavaFXEditorJMethodBody().setTextValue( popObj.getRequiredJMethodBody() );
		}

		if( popObj == null ) {
			getJavaFXEditorCppMethodBody().setTextValue( null );
		}
		else {
			getJavaFXEditorCppMethodBody().setTextValue( popObj.getRequiredCppMethodBody() );
		}

		if( popObj == null ) {
			getJavaFXEditorCsMethodBody().setTextValue( null );
		}
		else {
			getJavaFXEditorCsMethodBody().setTextValue( popObj.getRequiredCsMethodBody() );
		}

		if( popObj == null ) {
			getJavaFXEditorDummy().setStringValue( null );
		}
		else {
			getJavaFXEditorDummy().setStringValue( popObj.getOptionalDummy() );
		}
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		IBusModelServerProcObj focus = getJavaFXFocusAsServerProc();
		IBusModelServerProcEditObj editObj;
		if( focus != null ) {
			editObj = (IBusModelServerProcEditObj)(focus.getEdit());
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

		javafxLookupDefSchemaObj = (IBusModelSchemaDefObj)( javafxReferenceLookupDefSchema.getReferencedObject() );
		editObj.setOptionalLookupDefSchema( javafxLookupDefSchemaObj );

		if( getJavaFXEditorName().getStringValue() == null ) {
			editObj.setRequiredName( "" );
		}
		else {
			editObj.setRequiredName( getJavaFXEditorName().getStringValue() );
		}

		if( ( getJavaFXEditorShortName().getStringValue() != null ) && ( getJavaFXEditorShortName().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalShortName( null );
		}
		else {
			editObj.setOptionalShortName( getJavaFXEditorShortName().getStringValue() );
		}

		if( ( getJavaFXEditorLabel().getStringValue() != null ) && ( getJavaFXEditorLabel().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalLabel( null );
		}
		else {
			editObj.setOptionalLabel( getJavaFXEditorLabel().getStringValue() );
		}

		if( ( getJavaFXEditorShortDescription().getStringValue() != null ) && ( getJavaFXEditorShortDescription().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalShortDescription( null );
		}
		else {
			editObj.setOptionalShortDescription( getJavaFXEditorShortDescription().getStringValue() );
		}

		if( ( getJavaFXEditorDescription().getStringValue() != null ) && ( getJavaFXEditorDescription().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalDescription( null );
		}
		else {
			editObj.setOptionalDescription( getJavaFXEditorDescription().getStringValue() );
		}

		if( ( getJavaFXEditorSuffix().getStringValue() != null ) && ( getJavaFXEditorSuffix().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalSuffix( null );
		}
		else {
			editObj.setOptionalSuffix( getJavaFXEditorSuffix().getStringValue() );
		}

		editObj.setRequiredIsInstanceMethod( getJavaFXEditorIsInstanceMethod().getBooleanValue() );

		editObj.setRequiredIsServerOnly( getJavaFXEditorIsServerOnly().getBooleanValue() );

		String strcodevis = getJavaFXEditorCodeVis().getValue();
		IBusModelSchema.CodeVisibilityEnum curcodevis = IBusModelSchema.parseCodeVisibilityEnum( "CodeVis", strcodevis );
		editObj.setRequiredCodeVis( curcodevis );

		if( getJavaFXEditorJMethodBody().getTextValue() == null ) {
			editObj.setRequiredJMethodBody( "" );
		}
		else {
			editObj.setRequiredJMethodBody( getJavaFXEditorJMethodBody().getTextValue() );
		}

		if( getJavaFXEditorCppMethodBody().getTextValue() == null ) {
			editObj.setRequiredCppMethodBody( "" );
		}
		else {
			editObj.setRequiredCppMethodBody( getJavaFXEditorCppMethodBody().getTextValue() );
		}

		if( getJavaFXEditorCsMethodBody().getTextValue() == null ) {
			editObj.setRequiredCsMethodBody( "" );
		}
		else {
			editObj.setRequiredCsMethodBody( getJavaFXEditorCsMethodBody().getTextValue() );
		}

		if( ( getJavaFXEditorDummy().getStringValue() != null ) && ( getJavaFXEditorDummy().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalDummy( null );
		}
		else {
			editObj.setOptionalDummy( getJavaFXEditorDummy().getStringValue() );
		}
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		YCFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		IBusModelServerProcObj focus = getJavaFXFocusAsServerProc();
		if( ( value != YCFPane.PaneMode.Unknown ) && ( value != YCFPane.PaneMode.View ) ) {
			if( focus == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"javaFXFocus" );
			}
		}
		IBusModelServerProcEditObj editObj;
		if( focus != null ) {
			editObj  = (IBusModelServerProcEditObj)focus.getEdit();
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
								editObj = (IBusModelServerProcEditObj)focus.beginEdit();
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
							editObj = (IBusModelServerProcEditObj)focus.beginEdit();
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
							editObj = (IBusModelServerProcEditObj)focus.beginEdit();
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
							editObj = (IBusModelServerProcEditObj)focus.beginEdit();
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
						focus = (IBusModelServerProcObj)editObj.create();
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
								editObj = (IBusModelServerProcEditObj)focus.beginEdit();
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
								editObj = (IBusModelServerProcEditObj)focus.beginEdit();
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
							editObj = (IBusModelServerProcEditObj)focus.beginEdit();
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
			IBusModelServerProcObj focus = getJavaFXFocusAsServerProc();
			if( focus == null ) {
				isEditing = false;
			}
			else if( null == focus.getEdit() ) {
				isEditing = false;
			}
		}
		if( javafxReferenceLookupDefSchema != null ) {
			javafxReferenceLookupDefSchema.setCustomDisable( ! isEditing );
		}
		if( javafxEditorId != null ) {
			javafxEditorId.setDisable( true );
		}
		if( javafxEditorName != null ) {
			javafxEditorName.setDisable( ! isEditing );
		}
		if( javafxEditorShortName != null ) {
			javafxEditorShortName.setDisable( ! isEditing );
		}
		if( javafxEditorLabel != null ) {
			javafxEditorLabel.setDisable( ! isEditing );
		}
		if( javafxEditorShortDescription != null ) {
			javafxEditorShortDescription.setDisable( ! isEditing );
		}
		if( javafxEditorDescription != null ) {
			javafxEditorDescription.setDisable( ! isEditing );
		}
		if( javafxEditorSuffix != null ) {
			javafxEditorSuffix.setDisable( ! isEditing );
		}
		if( javafxEditorIsInstanceMethod != null ) {
			javafxEditorIsInstanceMethod.setDisable( ! isEditing );
		}
		if( javafxEditorIsServerOnly != null ) {
			javafxEditorIsServerOnly.setDisable( ! isEditing );
		}
		if( javafxEditorCodeVis != null ) {
			javafxEditorCodeVis.setDisable( ! isEditing );
		}
		if( javafxEditorJMethodBody != null ) {
			javafxEditorJMethodBody.setDisable( ! isEditing );
		}
		if( javafxEditorCppMethodBody != null ) {
			javafxEditorCppMethodBody.setDisable( ! isEditing );
		}
		if( javafxEditorCsMethodBody != null ) {
			javafxEditorCsMethodBody.setDisable( ! isEditing );
		}
		if( javafxEditorDummy != null ) {
			javafxEditorDummy.setDisable( ! isEditing );
		}
	}
}
