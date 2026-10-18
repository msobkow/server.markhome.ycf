// Description: Java 25 JavaFX Display Element Factory Interface for SysCluster.

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
 *	ISecureJavaFXSysClusterFactory JavaFX Display Element Factory Interface
 *	for SysCluster.
 */
public interface ISecureJavaFXSysClusterFactory
{
	public YCFGridPane newAttrPane( IYCFFormManager formManager, ISecureSysClusterObj javaFXFocus );

	public YCFBorderPane newListPane( IYCFFormManager formManager,
		ISecureClusterObj argContainer,
		ISecureSysClusterObj argFocus,
		Collection<ISecureSysClusterObj> argDataCollection,
		IYCFRefreshCallback refreshCallback,
		boolean sortByChain );

	public YCFBorderPane newPickerPane( IYCFFormManager formManager,
		ISecureSysClusterObj argFocus,
		ISecureClusterObj argContainer,
		Collection<ISecureSysClusterObj> argDataCollection,
		ISecureJavaFXSysClusterChosen whenChosen );

	public YCFTabPane newEltTabPane( IYCFFormManager formManger, ISecureSysClusterObj javaFXFocus );

	public YCFBorderPane newAskDeleteForm( IYCFFormManager formManager, ISecureSysClusterObj javaFXFocus, IYCFDeleteCallback callback );

	public YCFSplitPane newAddPane( IYCFFormManager formManger, ISecureSysClusterObj javaFXFocus );

	public YCFSplitPane newViewEditPane( IYCFFormManager formManger, ISecureSysClusterObj javaFXFocus );

	public YCFBorderPane newFinderForm( IYCFFormManager formManager );

	public YCFBorderPane newPickerForm( IYCFFormManager formManager,
		ISecureSysClusterObj javaFXFocus,
		ISecureClusterObj argContainer,
		Collection<ISecureSysClusterObj> argDataCollection,
		ISecureJavaFXSysClusterChosen whenChosen );

	public YCFBorderPane newAddForm( IYCFFormManager formManager, ISecureSysClusterObj javaFXFocus, IYCFFormClosedCallback closeCallback, boolean allowSave );

	public YCFBorderPane newViewEditForm( IYCFFormManager formManager, ISecureSysClusterObj javaFXFocus, IYCFFormClosedCallback closeCallback, boolean cameFromAdd );
}
