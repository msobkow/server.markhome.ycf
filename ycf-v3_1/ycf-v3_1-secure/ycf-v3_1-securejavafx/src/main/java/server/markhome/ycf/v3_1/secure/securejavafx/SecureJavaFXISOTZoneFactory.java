// Description: Java 25 JavaFX Display Element Factory for ISOTZone.

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
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.javafx.*;
import org.apache.commons.codec.binaryYCFCore64;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;

/**
 *	SecureJavaFXISOTZoneFactory JavaFX Display Element Factory
 *	for ISOTZone.
 */
public class SecureJavaFXISOTZoneFactory
implements ISecureJavaFXISOTZoneFactory
{
	protected ISecureJavaFXSchema javafxSchema = null;

	public SecureJavaFXISOTZoneFactory( ISecureJavaFXSchema argSchema ) {
		final String S_ProcName = "construct-schema";
		if( argSchema == null ) {
			throw new YCFLibNullArgumentException( this.getClass(),
				S_ProcName,
				1,
				"argSchema" );
		}
		javafxSchema = argSchema;
	}

	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureISOTZoneObj argFocus ) {
		SecureJavaFXISOTZoneAttrPane retnew = new SecureJavaFXISOTZoneAttrPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		IYCFLibAnyObj argContainer,
		ISecureISOTZoneObj argFocus,
		Collection<ISecureISOTZoneObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain )
	{
		SecureJavaFXISOTZoneListPane retnew = new SecureJavaFXISOTZoneListPane( formManager,
			javafxSchema,
			argContainer,
			argFocus,
			argDataCollection,
			refreshCallback,
			sortByChain );
		return( retnew );
	}

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureISOTZoneObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<ISecureISOTZoneObj> argDataCollection,
		ISecureJavaFXISOTZoneChosen whenChosen )
	{
		SecureJavaFXISOTZonePickerPane retnew = new SecureJavaFXISOTZonePickerPane( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFTabPane newEltTabPane( IYCFFormManager formManager, ISecureISOTZoneObj argFocus ) {
		SecureJavaFXISOTZoneEltTabPane retnew = new SecureJavaFXISOTZoneEltTabPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newAddPane( IYCFFormManager formManager, ISecureISOTZoneObj argFocus ) {
		SecureJavaFXISOTZoneAddPane retnew = new SecureJavaFXISOTZoneAddPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFSplitPane newViewEditPane( IYCFFormManager formManager, ISecureISOTZoneObj argFocus ) {
		SecureJavaFXISOTZoneViewEditPane retnew = new SecureJavaFXISOTZoneViewEditPane( formManager, javafxSchema, argFocus );
		return( retnew );
	}

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureISOTZoneObj argFocus, IYCFDeleteCallback callback ) {
		SecureJavaFXISOTZoneAskDeleteForm retnew = new SecureJavaFXISOTZoneAskDeleteForm( formManager, javafxSchema, argFocus, callback );
		return( retnew );
	}

	public YCFBorderPane newFinderForm( IYCFFormManager formManager ) {
		SecureJavaFXISOTZoneFinderForm retnew = new SecureJavaFXISOTZoneFinderForm( formManager, javafxSchema );
		return( retnew );
	}

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureISOTZoneObj argFocus,
		IYCFLibAnyObj argContainer,
		Collection<ISecureISOTZoneObj> argDataCollection,
		ISecureJavaFXISOTZoneChosen whenChosen )
	{
		SecureJavaFXISOTZonePickerForm retnew = new SecureJavaFXISOTZonePickerForm( formManager,
			javafxSchema,
			argFocus,
			argContainer,
			argDataCollection,
			whenChosen );
		return( retnew );
	}

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureISOTZoneObj argFocus, IYCFFormClosedCallback closeCallback, boolean allowSave ) {
		SecureJavaFXISOTZoneAddForm retnew = new SecureJavaFXISOTZoneAddForm( formManager, javafxSchema, argFocus, closeCallback, allowSave );
		return( retnew );
	}

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureISOTZoneObj argFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd ) {
		SecureJavaFXISOTZoneViewEditForm retnew = new SecureJavaFXISOTZoneViewEditForm( formManager, javafxSchema, argFocus, closeCallback, cameFromAdd );
		return( retnew );
	}
}
