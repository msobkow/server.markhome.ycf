// Description: Java 25 JavaFX Attribute Pane implementation for Table.

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
 *	BusModelJavaFXTableAttrPane JavaFX Attribute Pane implementation
 *	for Table.
 */
public class BusModelJavaFXTableAttrPane
extends YCFGridPane
implements IBusModelJavaFXTablePaneCommon
{
	protected IYCFFormManager ycfFormManager = null;
	protected IBusModelJavaFXSchema javafxSchema = null;
	boolean javafxIsInitializing = true;

	protected ObservableList<String> observableListOfLoaderBehaviour =
		FXCollections.observableArrayList(
			"Insert",
			"Update",
			"Replace" );

	protected ObservableList<String> observableListOfSecScope =
		FXCollections.observableArrayList(
			"None",
			"System",
			"Cluster",
			"Tenant",
			"SystemGroup",
			"ClusterGroup",
			"TenantGroup" );

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
			setText(Inz.s("busmodel.javafx.Table.AttrPane.LookupDefSchema.EffLabel"));
		}
	}

	protected class CallbackDefSchemaChosen
	implements IBusModelJavaFXSchemaDefChosen
	{
		public CallbackDefSchemaChosen() {
		}

		public void choseSchemaDef( IBusModelSchemaDefObj value ) {
			if( javafxReferenceLookupDefSchema != null ) {
				IBusModelTableObj cur = getJavaFXFocusAsTable();
				if( cur != null ) {
					IBusModelTableEditObj editObj = (IBusModelTableEditObj)cur.getEdit();
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
			IBusModelTableObj focus = getEffJavaFXFocus();
			IBusModelSchemaDefObj referencedObj = (IBusModelSchemaDefObj)javafxReferenceLookupDefSchema.getReferencedObject();
			java.util.List<IBusModelSchemaDefObj> listOfSchemaDef = null;
			Collection<IBusModelSchemaDefObj> cltn = null;
			YCFBorderPane form = javafxSchema.getSchemaDefFactory().newPickerForm( ycfFormManager, referencedObj, null, cltn, new CallbackDefSchemaChosen() );
			((IBusModelJavaFXSchemaDefPaneCommon)form).setPaneMode( YCFPane.PaneMode.View );
			ycfFormManager.pushForm( form );
		}

		public void view( IYCFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			IBusModelTableObj focus = getEffJavaFXFocus();
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
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.DefSchema.EffLabel" );
		}
	}

	protected class LookupIndexYCFLabel
		extends YCFLabel
	{
		public LookupIndexYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.LookupLookupIndex.EffLabel"));
		}
	}

	protected class CallbackLookupIndexChosen
	implements IBusModelJavaFXIndexChosen
	{
		public CallbackLookupIndexChosen() {
		}

		public void choseIndex( IBusModelIndexObj value ) {
			if( javafxReferenceLookupLookupIndex != null ) {
				IBusModelTableObj cur = getJavaFXFocusAsTable();
				if( cur != null ) {
					IBusModelTableEditObj editObj = (IBusModelTableEditObj)cur.getEdit();
					if( null != editObj ) {
						YCFPane.PaneMode curMode = getPaneMode();
						if( ( curMode == YCFPane.PaneMode.Add ) || ( curMode == YCFPane.PaneMode.Edit ) ) {
							javafxReferenceLookupLookupIndex.setReferencedObject( value );
							editObj.setOptionalLookupLookupIndex( value );
						}
					}
				}
			}
		}
	}

	protected class LookupIndexReferenceCallback
	implements IYCFReferenceCallback
	{
		public void chose( IYCFLibAnyObj value ) {
			final String S_ProcName = "chose";
			Node cont;
			IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
			IBusModelTableObj focus = getEffJavaFXFocus();
			IBusModelIndexObj referencedObj = (IBusModelIndexObj)javafxReferenceLookupLookupIndex.getReferencedObject();
			java.util.List<IBusModelIndexObj> listOfIndex = null;
			Collection<IBusModelIndexObj> cltn = null;
			YCFBorderPane form = javafxSchema.getIndexFactory().newPickerForm( ycfFormManager, referencedObj, null, cltn, new CallbackLookupIndexChosen() );
			((IBusModelJavaFXIndexPaneCommon)form).setPaneMode( YCFPane.PaneMode.View );
			ycfFormManager.pushForm( form );
		}

		public void view( IYCFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			IBusModelTableObj focus = getEffJavaFXFocus();
			if( focus != null ) {
				IBusModelIndexObj referencedObj = (IBusModelIndexObj)javafxReferenceLookupLookupIndex.getReferencedObject();
				YCFBorderPane form = null;
				if( referencedObj != null ) {
					int classCode = referencedObj.getClassCode();
					ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
					int backingClassCode = entry.getBackingClassCode();
					if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelIndex.CLASS_CODE ) {
						form = javafxSchema.getIndexFactory().newAddForm( ycfFormManager, referencedObj, null, true );
						IBusModelJavaFXIndexPaneCommon spec = (IBusModelJavaFXIndexPaneCommon)form;
						spec.setJavaFXFocus( referencedObj );
						spec.setPaneMode( YCFPane.PaneMode.View );
					}
					else {
						throw new YCFLibUnsupportedClassException( getClass(),
							S_ProcName,
							"javaFXFocus",
							focus,
							"IBusModelIndexObj" );
					}
					ycfFormManager.pushForm( form );
				}
			}
		}
	}

	protected class LookupIndexYCFReferenceEditor
		extends YCFReferenceEditor
	{
		public LookupIndexYCFReferenceEditor() {
			super( new LookupIndexReferenceCallback() );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.LookupIndex.EffLabel" );
		}
	}

	protected class AltIndexYCFLabel
		extends YCFLabel
	{
		public AltIndexYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.LookupAltIndex.EffLabel"));
		}
	}

	protected class CallbackAltIndexChosen
	implements IBusModelJavaFXIndexChosen
	{
		public CallbackAltIndexChosen() {
		}

		public void choseIndex( IBusModelIndexObj value ) {
			if( javafxReferenceLookupAltIndex != null ) {
				IBusModelTableObj cur = getJavaFXFocusAsTable();
				if( cur != null ) {
					IBusModelTableEditObj editObj = (IBusModelTableEditObj)cur.getEdit();
					if( null != editObj ) {
						YCFPane.PaneMode curMode = getPaneMode();
						if( ( curMode == YCFPane.PaneMode.Add ) || ( curMode == YCFPane.PaneMode.Edit ) ) {
							javafxReferenceLookupAltIndex.setReferencedObject( value );
							editObj.setOptionalLookupAltIndex( value );
						}
					}
				}
			}
		}
	}

	protected class AltIndexReferenceCallback
	implements IYCFReferenceCallback
	{
		public void chose( IYCFLibAnyObj value ) {
			final String S_ProcName = "chose";
			Node cont;
			IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
			IBusModelTableObj focus = getEffJavaFXFocus();
			IBusModelIndexObj referencedObj = (IBusModelIndexObj)javafxReferenceLookupAltIndex.getReferencedObject();
			java.util.List<IBusModelIndexObj> listOfIndex = null;
			Collection<IBusModelIndexObj> cltn = null;
			YCFBorderPane form = javafxSchema.getIndexFactory().newPickerForm( ycfFormManager, referencedObj, null, cltn, new CallbackAltIndexChosen() );
			((IBusModelJavaFXIndexPaneCommon)form).setPaneMode( YCFPane.PaneMode.View );
			ycfFormManager.pushForm( form );
		}

		public void view( IYCFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			IBusModelTableObj focus = getEffJavaFXFocus();
			if( focus != null ) {
				IBusModelIndexObj referencedObj = (IBusModelIndexObj)javafxReferenceLookupAltIndex.getReferencedObject();
				YCFBorderPane form = null;
				if( referencedObj != null ) {
					int classCode = referencedObj.getClassCode();
					ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
					int backingClassCode = entry.getBackingClassCode();
					if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelIndex.CLASS_CODE ) {
						form = javafxSchema.getIndexFactory().newAddForm( ycfFormManager, referencedObj, null, true );
						IBusModelJavaFXIndexPaneCommon spec = (IBusModelJavaFXIndexPaneCommon)form;
						spec.setJavaFXFocus( referencedObj );
						spec.setPaneMode( YCFPane.PaneMode.View );
					}
					else {
						throw new YCFLibUnsupportedClassException( getClass(),
							S_ProcName,
							"javaFXFocus",
							focus,
							"IBusModelIndexObj" );
					}
					ycfFormManager.pushForm( form );
				}
			}
		}
	}

	protected class AltIndexYCFReferenceEditor
		extends YCFReferenceEditor
	{
		public AltIndexYCFReferenceEditor() {
			super( new AltIndexReferenceCallback() );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.AltIndex.EffLabel" );
		}
	}

	protected class QualifyingTableYCFLabel
		extends YCFLabel
	{
		public QualifyingTableYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.LookupQualTable.EffLabel"));
		}
	}

	protected class CallbackQualifyingTableChosen
	implements IBusModelJavaFXTableChosen
	{
		public CallbackQualifyingTableChosen() {
		}

		public void choseTable( IBusModelTableObj value ) {
			if( javafxReferenceLookupQualTable != null ) {
				IBusModelTableObj cur = getJavaFXFocusAsTable();
				if( cur != null ) {
					IBusModelTableEditObj editObj = (IBusModelTableEditObj)cur.getEdit();
					if( null != editObj ) {
						YCFPane.PaneMode curMode = getPaneMode();
						if( ( curMode == YCFPane.PaneMode.Add ) || ( curMode == YCFPane.PaneMode.Edit ) ) {
							javafxReferenceLookupQualTable.setReferencedObject( value );
							editObj.setOptionalLookupQualTable( value );
						}
					}
				}
			}
		}
	}

	protected class QualifyingTableReferenceCallback
	implements IYCFReferenceCallback
	{
		public void chose( IYCFLibAnyObj value ) {
			final String S_ProcName = "chose";
			Node cont;
			IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
			IBusModelTableObj focus = getEffJavaFXFocus();
			IBusModelTableObj referencedObj = (IBusModelTableObj)javafxReferenceLookupQualTable.getReferencedObject();
			java.util.List<IBusModelTableObj> listOfTable = null;
			Collection<IBusModelTableObj> cltn = null;
			YCFBorderPane form = javafxSchema.getTableFactory().newPickerForm( ycfFormManager, referencedObj, null, cltn, new CallbackQualifyingTableChosen() );
			((IBusModelJavaFXTablePaneCommon)form).setPaneMode( YCFPane.PaneMode.View );
			ycfFormManager.pushForm( form );
		}

		public void view( IYCFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			IBusModelTableObj focus = getEffJavaFXFocus();
			if( focus != null ) {
				IBusModelTableObj referencedObj = (IBusModelTableObj)javafxReferenceLookupQualTable.getReferencedObject();
				YCFBorderPane form = null;
				if( referencedObj != null ) {
					int classCode = referencedObj.getClassCode();
					ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
					int backingClassCode = entry.getBackingClassCode();
					if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelTable.CLASS_CODE ) {
						form = javafxSchema.getTableFactory().newAddForm( ycfFormManager, referencedObj, null, true );
						IBusModelJavaFXTablePaneCommon spec = (IBusModelJavaFXTablePaneCommon)form;
						spec.setJavaFXFocus( referencedObj );
						spec.setPaneMode( YCFPane.PaneMode.View );
					}
					else {
						throw new YCFLibUnsupportedClassException( getClass(),
							S_ProcName,
							"javaFXFocus",
							focus,
							"IBusModelTableObj" );
					}
					ycfFormManager.pushForm( form );
				}
			}
		}
	}

	protected class QualifyingTableYCFReferenceEditor
		extends YCFReferenceEditor
	{
		public QualifyingTableYCFReferenceEditor() {
			super( new QualifyingTableReferenceCallback() );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.QualifyingTable.EffLabel" );
		}
	}

	protected class PrimaryIndexYCFLabel
		extends YCFLabel
	{
		public PrimaryIndexYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.LookupPrimaryIndex.EffLabel"));
		}
	}

	protected class CallbackPrimaryIndexChosen
	implements IBusModelJavaFXIndexChosen
	{
		public CallbackPrimaryIndexChosen() {
		}

		public void choseIndex( IBusModelIndexObj value ) {
			if( javafxReferenceLookupPrimaryIndex != null ) {
				IBusModelTableObj cur = getJavaFXFocusAsTable();
				if( cur != null ) {
					IBusModelTableEditObj editObj = (IBusModelTableEditObj)cur.getEdit();
					if( null != editObj ) {
						YCFPane.PaneMode curMode = getPaneMode();
						if( ( curMode == YCFPane.PaneMode.Add ) || ( curMode == YCFPane.PaneMode.Edit ) ) {
							javafxReferenceLookupPrimaryIndex.setReferencedObject( value );
							editObj.setOptionalLookupPrimaryIndex( value );
						}
					}
				}
			}
		}
	}

	protected class PrimaryIndexReferenceCallback
	implements IYCFReferenceCallback
	{
		public void chose( IYCFLibAnyObj value ) {
			final String S_ProcName = "chose";
			Node cont;
			IBusModelSchemaObj schemaObj = (IBusModelSchemaObj)javafxSchema.getSchema();
			IBusModelTableObj focus = getEffJavaFXFocus();
			IBusModelIndexObj referencedObj = (IBusModelIndexObj)javafxReferenceLookupPrimaryIndex.getReferencedObject();
			java.util.List<IBusModelIndexObj> listOfIndex = null;
			listOfIndex = focus.getOptionalComponentsIndex( javafxIsInitializing );
			if( listOfIndex == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"listOfIndex" );
			}
			Collection<IBusModelIndexObj> cltn = listOfIndex;
			YCFBorderPane form = javafxSchema.getIndexFactory().newPickerForm( ycfFormManager, referencedObj, null, cltn, new CallbackPrimaryIndexChosen() );
			((IBusModelJavaFXIndexPaneCommon)form).setPaneMode( YCFPane.PaneMode.View );
			ycfFormManager.pushForm( form );
		}

		public void view( IYCFLibAnyObj value ) {
			final String S_ProcName = "actionPerformed";
			IBusModelTableObj focus = getEffJavaFXFocus();
			if( focus != null ) {
				IBusModelIndexObj referencedObj = (IBusModelIndexObj)javafxReferenceLookupPrimaryIndex.getReferencedObject();
				YCFBorderPane form = null;
				if( referencedObj != null ) {
					int classCode = referencedObj.getClassCode();
					ISecureSchema.ClassMapEntry entry = IBusModelSchema.getClassMapByRuntimeClassCode(classCode);
					int backingClassCode = entry.getBackingClassCode();
					if( entry.getSchemaName().equals("BusModel") && backingClassCode == IBusModelIndex.CLASS_CODE ) {
						form = javafxSchema.getIndexFactory().newAddForm( ycfFormManager, referencedObj, null, true );
						IBusModelJavaFXIndexPaneCommon spec = (IBusModelJavaFXIndexPaneCommon)form;
						spec.setJavaFXFocus( referencedObj );
						spec.setPaneMode( YCFPane.PaneMode.View );
					}
					else {
						throw new YCFLibUnsupportedClassException( getClass(),
							S_ProcName,
							"javaFXFocus",
							focus,
							"IBusModelIndexObj" );
					}
					ycfFormManager.pushForm( form );
				}
			}
		}
	}

	protected class PrimaryIndexYCFReferenceEditor
		extends YCFReferenceEditor
	{
		public PrimaryIndexYCFReferenceEditor() {
			super( new PrimaryIndexReferenceCallback() );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.PrimaryIndex.EffLabel" );
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
			setText(Inz.s("busmodel.javafx.Table.AttrPane.Name.EffLabel"));
		}
	}

	protected class NameEditor
		extends YCFStringEditor
	{
		public NameEditor() {
			super();
			setMaxLen( 192 );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.Name.EffLabel" );
		}
	}

	protected class DbNameYCFLabel
		extends YCFLabel
	{
		public DbNameYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.DbName.EffLabel"));
		}
	}

	protected class DbNameEditor
		extends YCFStringEditor
	{
		public DbNameEditor() {
			super();
			setMaxLen( 32 );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.DbName.EffLabel" );
		}
	}

	protected class ShortNameYCFLabel
		extends YCFLabel
	{
		public ShortNameYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.ShortName.EffLabel"));
		}
	}

	protected class ShortNameEditor
		extends YCFStringEditor
	{
		public ShortNameEditor() {
			super();
			setMaxLen( 16 );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.ShortName.EffLabel" );
		}
	}

	protected class LabelYCFLabel
		extends YCFLabel
	{
		public LabelYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.Label.EffLabel"));
		}
	}

	protected class LabelEditor
		extends YCFStringEditor
	{
		public LabelEditor() {
			super();
			setMaxLen( 64 );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.Label.EffLabel" );
		}
	}

	protected class ShortDescriptionYCFLabel
		extends YCFLabel
	{
		public ShortDescriptionYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.ShortDescription.EffLabel"));
		}
	}

	protected class ShortDescriptionEditor
		extends YCFStringEditor
	{
		public ShortDescriptionEditor() {
			super();
			setMaxLen( 50 );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.ShortDescription.EffLabel" );
		}
	}

	protected class DescriptionYCFLabel
		extends YCFLabel
	{
		public DescriptionYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.Description.EffLabel"));
		}
	}

	protected class DescriptionEditor
		extends YCFStringEditor
	{
		public DescriptionEditor() {
			super();
			setMaxLen( 100 );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.Description.EffLabel" );
		}
	}

	protected class PageDataYCFLabel
		extends YCFLabel
	{
		public PageDataYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.PageData.EffLabel"));
		}
	}

	protected class PageDataEditor
		extends YCFBoolEditor
	{
		public PageDataEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.PageData.EffLabel" );
		}
	}

	protected class TableClassCodeYCFLabel
		extends YCFLabel
	{
		public TableClassCodeYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.TableClassCode.EffLabel"));
		}
	}

	protected class TableClassCodeEditor
		extends YCFStringEditor
	{
		public TableClassCodeEditor() {
			super();
			setMaxLen( 4 );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.TableClassCode.EffLabel" );
		}
	}

	protected class IsInstantiableYCFLabel
		extends YCFLabel
	{
		public IsInstantiableYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.IsInstantiable.EffLabel"));
		}
	}

	protected class IsInstantiableEditor
		extends YCFBoolEditor
	{
		public IsInstantiableEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.IsInstantiable.EffLabel" );
		}
	}

	protected class HasHistoryYCFLabel
		extends YCFLabel
	{
		public HasHistoryYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.HasHistory.EffLabel"));
		}
	}

	protected class HasHistoryEditor
		extends YCFBoolEditor
	{
		public HasHistoryEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.HasHistory.EffLabel" );
		}
	}

	protected class HasAuditColumnsYCFLabel
		extends YCFLabel
	{
		public HasAuditColumnsYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.HasAuditColumns.EffLabel"));
		}
	}

	protected class HasAuditColumnsEditor
		extends YCFBoolEditor
	{
		public HasAuditColumnsEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.HasAuditColumns.EffLabel" );
		}
	}

	protected class IsMutableYCFLabel
		extends YCFLabel
	{
		public IsMutableYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.IsMutable.EffLabel"));
		}
	}

	protected class IsMutableEditor
		extends YCFBoolEditor
	{
		public IsMutableEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.IsMutable.EffLabel" );
		}
	}

	protected class IsServerOnlyYCFLabel
		extends YCFLabel
	{
		public IsServerOnlyYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.IsServerOnly.EffLabel"));
		}
	}

	protected class IsServerOnlyEditor
		extends YCFBoolEditor
	{
		public IsServerOnlyEditor() {
			super();
			setIsNullable( false );
			setFieldNameInzTag( "busmodel.javafx.Table.AttrPane.IsServerOnly.EffLabel" );
		}
	}

	protected class LoaderBehaviourYCFLabel
		extends YCFLabel
	{
		public LoaderBehaviourYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.LoaderBehaviour.EffLabel"));
		}
	}

	protected class LoaderBehaviourEditor
		extends ComboBox<String>
	{
		public LoaderBehaviourEditor() {
			super();
			setItems( observableListOfLoaderBehaviour );
		}
	}

	protected class SecScopeYCFLabel
		extends YCFLabel
	{
		public SecScopeYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.SecScope.EffLabel"));
		}
	}

	protected class SecScopeEditor
		extends ComboBox<String>
	{
		public SecScopeEditor() {
			super();
			setItems( observableListOfSecScope );
		}
	}

	protected class CodeVisYCFLabel
		extends YCFLabel
	{
		public CodeVisYCFLabel() {
			super();
			setText(Inz.s("busmodel.javafx.Table.AttrPane.CodeVis.EffLabel"));
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

	protected IBusModelSchemaDefObj javafxLookupDefSchemaObj = null;
	protected DefSchemaYCFLabel javafxLabelLookupDefSchema = null;
	protected DefSchemaYCFReferenceEditor javafxReferenceLookupDefSchema = null;
	protected IBusModelIndexObj javafxLookupLookupIndexObj = null;
	protected LookupIndexYCFLabel javafxLabelLookupLookupIndex = null;
	protected LookupIndexYCFReferenceEditor javafxReferenceLookupLookupIndex = null;
	protected IBusModelIndexObj javafxLookupAltIndexObj = null;
	protected AltIndexYCFLabel javafxLabelLookupAltIndex = null;
	protected AltIndexYCFReferenceEditor javafxReferenceLookupAltIndex = null;
	protected IBusModelTableObj javafxLookupQualTableObj = null;
	protected QualifyingTableYCFLabel javafxLabelLookupQualTable = null;
	protected QualifyingTableYCFReferenceEditor javafxReferenceLookupQualTable = null;
	protected IBusModelIndexObj javafxLookupPrimaryIndexObj = null;
	protected PrimaryIndexYCFLabel javafxLabelLookupPrimaryIndex = null;
	protected PrimaryIndexYCFReferenceEditor javafxReferenceLookupPrimaryIndex = null;
	protected IdYCFLabel javafxLabelId = null;
	protected IdEditor javafxEditorId = null;
	protected NameYCFLabel javafxLabelName = null;
	protected NameEditor javafxEditorName = null;
	protected DbNameYCFLabel javafxLabelDbName = null;
	protected DbNameEditor javafxEditorDbName = null;
	protected ShortNameYCFLabel javafxLabelShortName = null;
	protected ShortNameEditor javafxEditorShortName = null;
	protected LabelYCFLabel javafxLabelLabel = null;
	protected LabelEditor javafxEditorLabel = null;
	protected ShortDescriptionYCFLabel javafxLabelShortDescription = null;
	protected ShortDescriptionEditor javafxEditorShortDescription = null;
	protected DescriptionYCFLabel javafxLabelDescription = null;
	protected DescriptionEditor javafxEditorDescription = null;
	protected PageDataYCFLabel javafxLabelPageData = null;
	protected PageDataEditor javafxEditorPageData = null;
	protected TableClassCodeYCFLabel javafxLabelTableClassCode = null;
	protected TableClassCodeEditor javafxEditorTableClassCode = null;
	protected IsInstantiableYCFLabel javafxLabelIsInstantiable = null;
	protected IsInstantiableEditor javafxEditorIsInstantiable = null;
	protected HasHistoryYCFLabel javafxLabelHasHistory = null;
	protected HasHistoryEditor javafxEditorHasHistory = null;
	protected HasAuditColumnsYCFLabel javafxLabelHasAuditColumns = null;
	protected HasAuditColumnsEditor javafxEditorHasAuditColumns = null;
	protected IsMutableYCFLabel javafxLabelIsMutable = null;
	protected IsMutableEditor javafxEditorIsMutable = null;
	protected IsServerOnlyYCFLabel javafxLabelIsServerOnly = null;
	protected IsServerOnlyEditor javafxEditorIsServerOnly = null;
	protected LoaderBehaviourYCFLabel javafxLabelLoaderBehaviour = null;
	protected LoaderBehaviourEditor javafxEditorLoaderBehaviour = null;
	protected SecScopeYCFLabel javafxLabelSecScope = null;
	protected SecScopeEditor javafxEditorSecScope = null;
	protected CodeVisYCFLabel javafxLabelCodeVis = null;
	protected CodeVisEditor javafxEditorCodeVis = null;

	public BusModelJavaFXTableAttrPane( IYCFFormManager formManager, IBusModelJavaFXSchema argSchema, IBusModelTableObj argFocus ) {
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
		setJavaFXFocusAsTable( argFocus );
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

		label = getJavaFXLabelLookupLookupIndex();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		reference = getJavaFXReferenceLookupLookupIndex();
		setHalignment( reference, HPos.LEFT );
		add( reference, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelLookupAltIndex();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		reference = getJavaFXReferenceLookupAltIndex();
		setHalignment( reference, HPos.LEFT );
		add( reference, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelLookupQualTable();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		reference = getJavaFXReferenceLookupQualTable();
		setHalignment( reference, HPos.LEFT );
		add( reference, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelLookupPrimaryIndex();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		reference = getJavaFXReferenceLookupPrimaryIndex();
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

		label = getJavaFXLabelDbName();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorDbName();
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

		label = getJavaFXLabelPageData();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorPageData();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelTableClassCode();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorTableClassCode();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelIsInstantiable();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorIsInstantiable();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelHasHistory();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorHasHistory();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelHasAuditColumns();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorHasAuditColumns();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelIsMutable();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorIsMutable();
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

		label = getJavaFXLabelLoaderBehaviour();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorLoaderBehaviour();
		setHalignment( ctrl, HPos.LEFT );
		add( ctrl, 0, gridRow );
		gridRow ++;

		label = getJavaFXLabelSecScope();
		setHalignment( label, HPos.LEFT );
		setValignment( label, VPos.BOTTOM );
		add( label, 0, gridRow );
		gridRow ++;

		ctrl = getJavaFXEditorSecScope();
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
		if( ( value == null ) || ( value instanceof IBusModelTableObj ) ) {
			super.setJavaFXFocus( value );
		}
		else {
			throw new YCFLibUnsupportedClassException( getClass(),
				S_ProcName,
				"value",
				value,
				"IBusModelTableObj" );
		}
		populateFields();
		adjustComponentEnableStates();
	}

	public IBusModelTableObj getJavaFXFocusAsTable() {
		return( (IBusModelTableObj)getJavaFXFocus() );
	}

	public void setJavaFXFocusAsTable( IBusModelTableObj value ) {
		setJavaFXFocus( value );
	}

	public IBusModelTableObj getEffJavaFXFocus() {
		IBusModelTableObj eff = (IBusModelTableObj)getJavaFXFocus();
		if( eff != null ) {
			if( null != eff.getEdit() ) {
				eff = (IBusModelTableObj)eff.getEdit();
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

	public IBusModelIndexObj getJavaFXLookupLookupIndexObj() {
		return( javafxLookupLookupIndexObj );
	}

	public void setJavaFXLookupLookupIndexObj( IBusModelIndexObj value ) {
		javafxLookupLookupIndexObj = value;
	}

	public YCFLabel getJavaFXLabelLookupLookupIndex() {
		if( javafxLabelLookupLookupIndex == null ) {
			javafxLabelLookupLookupIndex = new LookupIndexYCFLabel();
		}
		return( javafxLabelLookupLookupIndex );
	}

	public YCFReferenceEditor getJavaFXReferenceLookupLookupIndex() {
		if( javafxReferenceLookupLookupIndex == null ) {
			javafxReferenceLookupLookupIndex = new LookupIndexYCFReferenceEditor();
		}
		return( javafxReferenceLookupLookupIndex );
	}

	public void setJavaFXReferenceLookupLookupIndex( LookupIndexYCFReferenceEditor value ) {
		javafxReferenceLookupLookupIndex = value;
	}

	public IBusModelIndexObj getJavaFXLookupAltIndexObj() {
		return( javafxLookupAltIndexObj );
	}

	public void setJavaFXLookupAltIndexObj( IBusModelIndexObj value ) {
		javafxLookupAltIndexObj = value;
	}

	public YCFLabel getJavaFXLabelLookupAltIndex() {
		if( javafxLabelLookupAltIndex == null ) {
			javafxLabelLookupAltIndex = new AltIndexYCFLabel();
		}
		return( javafxLabelLookupAltIndex );
	}

	public YCFReferenceEditor getJavaFXReferenceLookupAltIndex() {
		if( javafxReferenceLookupAltIndex == null ) {
			javafxReferenceLookupAltIndex = new AltIndexYCFReferenceEditor();
		}
		return( javafxReferenceLookupAltIndex );
	}

	public void setJavaFXReferenceLookupAltIndex( AltIndexYCFReferenceEditor value ) {
		javafxReferenceLookupAltIndex = value;
	}

	public IBusModelTableObj getJavaFXLookupQualTableObj() {
		return( javafxLookupQualTableObj );
	}

	public void setJavaFXLookupQualTableObj( IBusModelTableObj value ) {
		javafxLookupQualTableObj = value;
	}

	public YCFLabel getJavaFXLabelLookupQualTable() {
		if( javafxLabelLookupQualTable == null ) {
			javafxLabelLookupQualTable = new QualifyingTableYCFLabel();
		}
		return( javafxLabelLookupQualTable );
	}

	public YCFReferenceEditor getJavaFXReferenceLookupQualTable() {
		if( javafxReferenceLookupQualTable == null ) {
			javafxReferenceLookupQualTable = new QualifyingTableYCFReferenceEditor();
		}
		return( javafxReferenceLookupQualTable );
	}

	public void setJavaFXReferenceLookupQualTable( QualifyingTableYCFReferenceEditor value ) {
		javafxReferenceLookupQualTable = value;
	}

	public IBusModelIndexObj getJavaFXLookupPrimaryIndexObj() {
		return( javafxLookupPrimaryIndexObj );
	}

	public void setJavaFXLookupPrimaryIndexObj( IBusModelIndexObj value ) {
		javafxLookupPrimaryIndexObj = value;
	}

	public YCFLabel getJavaFXLabelLookupPrimaryIndex() {
		if( javafxLabelLookupPrimaryIndex == null ) {
			javafxLabelLookupPrimaryIndex = new PrimaryIndexYCFLabel();
		}
		return( javafxLabelLookupPrimaryIndex );
	}

	public YCFReferenceEditor getJavaFXReferenceLookupPrimaryIndex() {
		if( javafxReferenceLookupPrimaryIndex == null ) {
			javafxReferenceLookupPrimaryIndex = new PrimaryIndexYCFReferenceEditor();
		}
		return( javafxReferenceLookupPrimaryIndex );
	}

	public void setJavaFXReferenceLookupPrimaryIndex( PrimaryIndexYCFReferenceEditor value ) {
		javafxReferenceLookupPrimaryIndex = value;
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

	public DbNameYCFLabel getJavaFXLabelDbName() {
		if( javafxLabelDbName == null ) {
			javafxLabelDbName = new DbNameYCFLabel();
		}
		return( javafxLabelDbName );
	}

	public void setJavaFXLabelDbName( DbNameYCFLabel value ) {
		javafxLabelDbName = value;
	}

	public DbNameEditor getJavaFXEditorDbName() {
		if( javafxEditorDbName == null ) {
			javafxEditorDbName = new DbNameEditor();
		}
		return( javafxEditorDbName );
	}

	public void setJavaFXEditorDbName( DbNameEditor value ) {
		javafxEditorDbName = value;
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

	public PageDataYCFLabel getJavaFXLabelPageData() {
		if( javafxLabelPageData == null ) {
			javafxLabelPageData = new PageDataYCFLabel();
		}
		return( javafxLabelPageData );
	}

	public void setJavaFXLabelPageData( PageDataYCFLabel value ) {
		javafxLabelPageData = value;
	}

	public PageDataEditor getJavaFXEditorPageData() {
		if( javafxEditorPageData == null ) {
			javafxEditorPageData = new PageDataEditor();
		}
		return( javafxEditorPageData );
	}

	public void setJavaFXEditorPageData( PageDataEditor value ) {
		javafxEditorPageData = value;
	}

	public TableClassCodeYCFLabel getJavaFXLabelTableClassCode() {
		if( javafxLabelTableClassCode == null ) {
			javafxLabelTableClassCode = new TableClassCodeYCFLabel();
		}
		return( javafxLabelTableClassCode );
	}

	public void setJavaFXLabelTableClassCode( TableClassCodeYCFLabel value ) {
		javafxLabelTableClassCode = value;
	}

	public TableClassCodeEditor getJavaFXEditorTableClassCode() {
		if( javafxEditorTableClassCode == null ) {
			javafxEditorTableClassCode = new TableClassCodeEditor();
		}
		return( javafxEditorTableClassCode );
	}

	public void setJavaFXEditorTableClassCode( TableClassCodeEditor value ) {
		javafxEditorTableClassCode = value;
	}

	public IsInstantiableYCFLabel getJavaFXLabelIsInstantiable() {
		if( javafxLabelIsInstantiable == null ) {
			javafxLabelIsInstantiable = new IsInstantiableYCFLabel();
		}
		return( javafxLabelIsInstantiable );
	}

	public void setJavaFXLabelIsInstantiable( IsInstantiableYCFLabel value ) {
		javafxLabelIsInstantiable = value;
	}

	public IsInstantiableEditor getJavaFXEditorIsInstantiable() {
		if( javafxEditorIsInstantiable == null ) {
			javafxEditorIsInstantiable = new IsInstantiableEditor();
		}
		return( javafxEditorIsInstantiable );
	}

	public void setJavaFXEditorIsInstantiable( IsInstantiableEditor value ) {
		javafxEditorIsInstantiable = value;
	}

	public HasHistoryYCFLabel getJavaFXLabelHasHistory() {
		if( javafxLabelHasHistory == null ) {
			javafxLabelHasHistory = new HasHistoryYCFLabel();
		}
		return( javafxLabelHasHistory );
	}

	public void setJavaFXLabelHasHistory( HasHistoryYCFLabel value ) {
		javafxLabelHasHistory = value;
	}

	public HasHistoryEditor getJavaFXEditorHasHistory() {
		if( javafxEditorHasHistory == null ) {
			javafxEditorHasHistory = new HasHistoryEditor();
		}
		return( javafxEditorHasHistory );
	}

	public void setJavaFXEditorHasHistory( HasHistoryEditor value ) {
		javafxEditorHasHistory = value;
	}

	public HasAuditColumnsYCFLabel getJavaFXLabelHasAuditColumns() {
		if( javafxLabelHasAuditColumns == null ) {
			javafxLabelHasAuditColumns = new HasAuditColumnsYCFLabel();
		}
		return( javafxLabelHasAuditColumns );
	}

	public void setJavaFXLabelHasAuditColumns( HasAuditColumnsYCFLabel value ) {
		javafxLabelHasAuditColumns = value;
	}

	public HasAuditColumnsEditor getJavaFXEditorHasAuditColumns() {
		if( javafxEditorHasAuditColumns == null ) {
			javafxEditorHasAuditColumns = new HasAuditColumnsEditor();
		}
		return( javafxEditorHasAuditColumns );
	}

	public void setJavaFXEditorHasAuditColumns( HasAuditColumnsEditor value ) {
		javafxEditorHasAuditColumns = value;
	}

	public IsMutableYCFLabel getJavaFXLabelIsMutable() {
		if( javafxLabelIsMutable == null ) {
			javafxLabelIsMutable = new IsMutableYCFLabel();
		}
		return( javafxLabelIsMutable );
	}

	public void setJavaFXLabelIsMutable( IsMutableYCFLabel value ) {
		javafxLabelIsMutable = value;
	}

	public IsMutableEditor getJavaFXEditorIsMutable() {
		if( javafxEditorIsMutable == null ) {
			javafxEditorIsMutable = new IsMutableEditor();
		}
		return( javafxEditorIsMutable );
	}

	public void setJavaFXEditorIsMutable( IsMutableEditor value ) {
		javafxEditorIsMutable = value;
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

	public LoaderBehaviourYCFLabel getJavaFXLabelLoaderBehaviour() {
		if( javafxLabelLoaderBehaviour == null ) {
			javafxLabelLoaderBehaviour = new LoaderBehaviourYCFLabel();
		}
		return( javafxLabelLoaderBehaviour );
	}

	public void setJavaFXLabelLoaderBehaviour( LoaderBehaviourYCFLabel value ) {
		javafxLabelLoaderBehaviour = value;
	}

	public LoaderBehaviourEditor getJavaFXEditorLoaderBehaviour() {
		if( javafxEditorLoaderBehaviour == null ) {
			javafxEditorLoaderBehaviour = new LoaderBehaviourEditor();
		}
		return( javafxEditorLoaderBehaviour );
	}

	public void setJavaFXEditorLoaderBehaviour( LoaderBehaviourEditor value ) {
		javafxEditorLoaderBehaviour = value;
	}

	public SecScopeYCFLabel getJavaFXLabelSecScope() {
		if( javafxLabelSecScope == null ) {
			javafxLabelSecScope = new SecScopeYCFLabel();
		}
		return( javafxLabelSecScope );
	}

	public void setJavaFXLabelSecScope( SecScopeYCFLabel value ) {
		javafxLabelSecScope = value;
	}

	public SecScopeEditor getJavaFXEditorSecScope() {
		if( javafxEditorSecScope == null ) {
			javafxEditorSecScope = new SecScopeEditor();
		}
		return( javafxEditorSecScope );
	}

	public void setJavaFXEditorSecScope( SecScopeEditor value ) {
		javafxEditorSecScope = value;
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

	public void populateFields()
	{
		IBusModelTableObj popObj = getEffJavaFXFocus();
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
			javafxLookupLookupIndexObj = null;
		}
		else {
			javafxLookupLookupIndexObj = (IBusModelIndexObj)popObj.getOptionalLookupLookupIndex( javafxIsInitializing );
		}
		if( javafxReferenceLookupLookupIndex != null ) {
			javafxReferenceLookupLookupIndex.setReferencedObject( javafxLookupLookupIndexObj );
		}

		if( popObj == null ) {
			javafxLookupAltIndexObj = null;
		}
		else {
			javafxLookupAltIndexObj = (IBusModelIndexObj)popObj.getOptionalLookupAltIndex( javafxIsInitializing );
		}
		if( javafxReferenceLookupAltIndex != null ) {
			javafxReferenceLookupAltIndex.setReferencedObject( javafxLookupAltIndexObj );
		}

		if( popObj == null ) {
			javafxLookupQualTableObj = null;
		}
		else {
			javafxLookupQualTableObj = (IBusModelTableObj)popObj.getOptionalLookupQualTable( javafxIsInitializing );
		}
		if( javafxReferenceLookupQualTable != null ) {
			javafxReferenceLookupQualTable.setReferencedObject( javafxLookupQualTableObj );
		}

		if( popObj == null ) {
			javafxLookupPrimaryIndexObj = null;
		}
		else {
			javafxLookupPrimaryIndexObj = (IBusModelIndexObj)popObj.getOptionalLookupPrimaryIndex( javafxIsInitializing );
		}
		if( javafxReferenceLookupPrimaryIndex != null ) {
			javafxReferenceLookupPrimaryIndex.setReferencedObject( javafxLookupPrimaryIndexObj );
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
			getJavaFXEditorDbName().setStringValue( null );
		}
		else {
			getJavaFXEditorDbName().setStringValue( popObj.getOptionalDbName() );
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
			getJavaFXEditorPageData().setBooleanValue( null );
		}
		else {
			getJavaFXEditorPageData().setBooleanValue( popObj.getRequiredPageData() );
		}

		if( popObj == null ) {
			getJavaFXEditorTableClassCode().setStringValue( null );
		}
		else {
			getJavaFXEditorTableClassCode().setStringValue( popObj.getRequiredTableClassCode() );
		}

		if( popObj == null ) {
			getJavaFXEditorIsInstantiable().setBooleanValue( null );
		}
		else {
			getJavaFXEditorIsInstantiable().setBooleanValue( popObj.getRequiredIsInstantiable() );
		}

		if( popObj == null ) {
			getJavaFXEditorHasHistory().setBooleanValue( null );
		}
		else {
			getJavaFXEditorHasHistory().setBooleanValue( popObj.getRequiredHasHistory() );
		}

		if( popObj == null ) {
			getJavaFXEditorHasAuditColumns().setBooleanValue( null );
		}
		else {
			getJavaFXEditorHasAuditColumns().setBooleanValue( popObj.getRequiredHasAuditColumns() );
		}

		if( popObj == null ) {
			getJavaFXEditorIsMutable().setBooleanValue( null );
		}
		else {
			getJavaFXEditorIsMutable().setBooleanValue( popObj.getRequiredIsMutable() );
		}

		if( popObj == null ) {
			getJavaFXEditorIsServerOnly().setBooleanValue( null );
		}
		else {
			getJavaFXEditorIsServerOnly().setBooleanValue( popObj.getRequiredIsServerOnly() );
		}

		if( popObj == null ) {
			getJavaFXEditorLoaderBehaviour().setValue( null );
		}
		else {
			getJavaFXEditorLoaderBehaviour().setValue(
				( popObj.getRequiredLoaderBehaviour() == null )
					? null
					: popObj.getRequiredLoaderBehaviour().toString() );
		}

		if( popObj == null ) {
			getJavaFXEditorSecScope().setValue( null );
		}
		else {
			getJavaFXEditorSecScope().setValue(
				( popObj.getRequiredSecScope() == null )
					? null
					: popObj.getRequiredSecScope().toString() );
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
	}

	public void postFields()
	{
		final String S_ProcName = "postFields";
		IBusModelTableObj focus = getJavaFXFocusAsTable();
		IBusModelTableEditObj editObj;
		if( focus != null ) {
			editObj = (IBusModelTableEditObj)(focus.getEdit());
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

		javafxLookupLookupIndexObj = (IBusModelIndexObj)( javafxReferenceLookupLookupIndex.getReferencedObject() );
		editObj.setOptionalLookupLookupIndex( javafxLookupLookupIndexObj );

		javafxLookupAltIndexObj = (IBusModelIndexObj)( javafxReferenceLookupAltIndex.getReferencedObject() );
		editObj.setOptionalLookupAltIndex( javafxLookupAltIndexObj );

		javafxLookupQualTableObj = (IBusModelTableObj)( javafxReferenceLookupQualTable.getReferencedObject() );
		editObj.setOptionalLookupQualTable( javafxLookupQualTableObj );

		javafxLookupPrimaryIndexObj = (IBusModelIndexObj)( javafxReferenceLookupPrimaryIndex.getReferencedObject() );
		editObj.setOptionalLookupPrimaryIndex( javafxLookupPrimaryIndexObj );

		if( getJavaFXEditorName().getStringValue() == null ) {
			editObj.setRequiredName( "" );
		}
		else {
			editObj.setRequiredName( getJavaFXEditorName().getStringValue() );
		}

		if( ( getJavaFXEditorDbName().getStringValue() != null ) && ( getJavaFXEditorDbName().getStringValue().length() <= 0 ) ) {
			editObj.setOptionalDbName( null );
		}
		else {
			editObj.setOptionalDbName( getJavaFXEditorDbName().getStringValue() );
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

		editObj.setRequiredPageData( getJavaFXEditorPageData().getBooleanValue() );

		if( getJavaFXEditorTableClassCode().getStringValue() == null ) {
			editObj.setRequiredTableClassCode( "" );
		}
		else {
			editObj.setRequiredTableClassCode( getJavaFXEditorTableClassCode().getStringValue() );
		}

		editObj.setRequiredIsInstantiable( getJavaFXEditorIsInstantiable().getBooleanValue() );

		editObj.setRequiredHasHistory( getJavaFXEditorHasHistory().getBooleanValue() );

		editObj.setRequiredHasAuditColumns( getJavaFXEditorHasAuditColumns().getBooleanValue() );

		editObj.setRequiredIsMutable( getJavaFXEditorIsMutable().getBooleanValue() );

		editObj.setRequiredIsServerOnly( getJavaFXEditorIsServerOnly().getBooleanValue() );

		String strloaderbehaviour = getJavaFXEditorLoaderBehaviour().getValue();
		IBusModelSchema.LoaderBehaviourEnum curloaderbehaviour = IBusModelSchema.parseLoaderBehaviourEnum( "LoaderBehaviour", strloaderbehaviour );
		editObj.setRequiredLoaderBehaviour( curloaderbehaviour );

		String strsecscope = getJavaFXEditorSecScope().getValue();
		IBusModelSchema.SecScopeEnum cursecscope = IBusModelSchema.parseSecScopeEnum( "SecScope", strsecscope );
		editObj.setRequiredSecScope( cursecscope );

		String strcodevis = getJavaFXEditorCodeVis().getValue();
		IBusModelSchema.CodeVisibilityEnum curcodevis = IBusModelSchema.parseCodeVisibilityEnum( "CodeVis", strcodevis );
		editObj.setRequiredCodeVis( curcodevis );
	}

	public void setPaneMode( YCFPane.PaneMode value ) {
		final String S_ProcName = "setPaneMode";
		YCFPane.PaneMode oldValue = getPaneMode();
		if( oldValue == value ) {
			return;
		}
		IBusModelTableObj focus = getJavaFXFocusAsTable();
		if( ( value != YCFPane.PaneMode.Unknown ) && ( value != YCFPane.PaneMode.View ) ) {
			if( focus == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"javaFXFocus" );
			}
		}
		IBusModelTableEditObj editObj;
		if( focus != null ) {
			editObj  = (IBusModelTableEditObj)focus.getEdit();
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
								editObj = (IBusModelTableEditObj)focus.beginEdit();
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
							editObj = (IBusModelTableEditObj)focus.beginEdit();
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
							editObj = (IBusModelTableEditObj)focus.beginEdit();
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
							editObj = (IBusModelTableEditObj)focus.beginEdit();
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
						focus = (IBusModelTableObj)editObj.create();
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
								editObj = (IBusModelTableEditObj)focus.beginEdit();
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
								editObj = (IBusModelTableEditObj)focus.beginEdit();
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
							editObj = (IBusModelTableEditObj)focus.beginEdit();
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
			IBusModelTableObj focus = getJavaFXFocusAsTable();
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
		if( javafxReferenceLookupLookupIndex != null ) {
			javafxReferenceLookupLookupIndex.setCustomDisable( ! isEditing );
		}
		if( javafxReferenceLookupAltIndex != null ) {
			javafxReferenceLookupAltIndex.setCustomDisable( ! isEditing );
		}
		if( javafxReferenceLookupQualTable != null ) {
			javafxReferenceLookupQualTable.setCustomDisable( ! isEditing );
		}
		if( javafxReferenceLookupPrimaryIndex != null ) {
			javafxReferenceLookupPrimaryIndex.setCustomDisable( ! isEditing );
		}
		if( javafxEditorId != null ) {
			javafxEditorId.setDisable( true );
		}
		if( javafxEditorName != null ) {
			javafxEditorName.setDisable( ! isEditing );
		}
		if( javafxEditorDbName != null ) {
			javafxEditorDbName.setDisable( ! isEditing );
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
		if( javafxEditorPageData != null ) {
			javafxEditorPageData.setDisable( ! isEditing );
		}
		if( javafxEditorTableClassCode != null ) {
			javafxEditorTableClassCode.setDisable( ! isEditing );
		}
		if( javafxEditorIsInstantiable != null ) {
			javafxEditorIsInstantiable.setDisable( ! isEditing );
		}
		if( javafxEditorHasHistory != null ) {
			javafxEditorHasHistory.setDisable( ! isEditing );
		}
		if( javafxEditorHasAuditColumns != null ) {
			javafxEditorHasAuditColumns.setDisable( ! isEditing );
		}
		if( javafxEditorIsMutable != null ) {
			javafxEditorIsMutable.setDisable( ! isEditing );
		}
		if( javafxEditorIsServerOnly != null ) {
			javafxEditorIsServerOnly.setDisable( ! isEditing );
		}
		if( javafxEditorLoaderBehaviour != null ) {
			javafxEditorLoaderBehaviour.setDisable( ! isEditing );
		}
		if( javafxEditorSecScope != null ) {
			javafxEditorSecScope.setDisable( ! isEditing );
		}
		if( javafxEditorCodeVis != null ) {
			javafxEditorCodeVis.setDisable( ! isEditing );
		}
	}
}
