// Description: Java 25 JavaFX Display Element Factory Interface for SecUserPassword.

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
 *	ISecureJavaFXSecUserPasswordFactory JavaFX Display Element Factory Interface
 *	for SecUserPassword.
 */
public interface ISecureJavaFXSecUserPasswordFactory
{
	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureSecUserPasswordObj javaFXFocus );

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		ISecureSecUserObj argContainer,
		ISecureSecUserPasswordObj argFocus,
		Collection<ISecureSecUserPasswordObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain );

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureSecUserPasswordObj argFocus,
		ISecureSecUserObj argContainer,
		Collection<ISecureSecUserPasswordObj> argDataCollection,
		ISecureJavaFXSecUserPasswordChosen whenChosen );

	public YCFTabPane newEltTabPane( IYCFFormManager formManger, ISecureSecUserPasswordObj javaFXFocus );

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureSecUserPasswordObj javaFXFocus, IYCFDeleteCallback callback );

	public YCFSplitPane newAddPane( IYCFFormManager formManger, ISecureSecUserPasswordObj javaFXFocus );

	public YCFSplitPane newViewEditPane( IYCFFormManager formManger, ISecureSecUserPasswordObj javaFXFocus );

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureSecUserPasswordObj javaFXFocus,
		ISecureSecUserObj argContainer,
		Collection<ISecureSecUserPasswordObj> argDataCollection,
		ISecureJavaFXSecUserPasswordChosen whenChosen );

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureSecUserPasswordObj javaFXFocus, IYCFFormClosedCallback closeCallback, boolean allowSave );

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureSecUserPasswordObj javaFXFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd );
}
