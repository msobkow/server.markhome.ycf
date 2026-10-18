
// Description: Java 25 XML SAX Element Handler for SecUserPWReset

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

package server.markhome.ycf.v3_1.busmodel.busmodelsaxloader;

import java.math.*;
import java.sql.*;
import java.text.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.xml.sax.*;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.Inz;
import server.markhome.ycf.*;
import server.markhome.ycf.v3_1.secure.secure.*;
import server.markhome.ycf.v3_1.intnet.intnet.*;
import server.markhome.ycf.v3_1.busmodel.busmodel.*;
import server.markhome.ycf.v3_1.secure.secureobj.*;
import server.markhome.ycf.v3_1.intnet.intnetobj.*;
import server.markhome.ycf.v3_1.busmodel.busmodelobj.*;

/*
 *	BusModelSaxLoaderSecUserPWResetParse XML SAX Element Handler implementation
 *	for SecUserPWReset.
 */
public class BusModelSaxLoaderSecUserPWReset
	extends YCFLibXmlCoreElementHandler
{
	public BusModelSaxLoaderSecUserPWReset( BusModelSaxLoader saxLoader ) {
		super( saxLoader );
	}

	public void startElement(
		String		uri,
		String		localName,
		String		qName,
		Attributes	attrs )
	throws SAXException
	{
		final String S_ProcName = "startElement";
		IBusModelSecUserPWResetObj origBuff = null;
		IBusModelSecUserPWResetEditObj editBuff = null;
		// Common XML Attributes
		String attrId = null;
		// SecUserPWReset Attributes
		String attrSentToEMailAddr = null;
		String attrPasswordResetUuid6 = null;
		String attrNewAccount = null;
		// SecUserPWReset References
		IBusModelSecUserObj refUser = null;
		// Attribute Extraction
		String attrLocalName;
		int numAttrs;
		int idxAttr;
		final String S_LocalName = "LocalName";
		try {
			assert qName.equals( "SecUserPWReset" );

			BusModelSaxLoader saxLoader = (BusModelSaxLoader)getParser();
			if( saxLoader == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser()" );
			}

			IBusModelSchemaObj schemaObj = saxLoader.getSchemaObj();
			if( schemaObj == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"getParser().getSchemaObj()" );
			}

			// Instantiate an edit buffer for the parsed information
			origBuff = (IBusModelSecUserPWResetObj)schemaObj.getSecUserPWResetTableObj().newInstance();
			editBuff = (IBusModelSecUserPWResetEditObj)origBuff.beginEdit();

			// Extract Attributes
			numAttrs = attrs.getLength();
			for( idxAttr = 0; idxAttr < numAttrs; idxAttr++ ) {
				attrLocalName = attrs.getLocalName( idxAttr );
				if( attrLocalName.equals( "Id" ) ) {
					if( attrId != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrId = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "SentToEMailAddr" ) ) {
					if( attrSentToEMailAddr != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrSentToEMailAddr = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "PasswordResetUuid6" ) ) {
					if( attrPasswordResetUuid6 != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrPasswordResetUuid6 = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "NewAccount" ) ) {
					if( attrNewAccount != null ) {
						throw new YCFLibUniqueIndexViolationException( getClass(),
							S_ProcName,
							S_LocalName,
							attrLocalName );
					}
					attrNewAccount = attrs.getValue( idxAttr );
				}
				else if( attrLocalName.equals( "schemaLocation" ) ) {
					// ignored
				}
				else {
					throw new YCFLibUnrecognizedAttributeException( getClass(),
						S_ProcName,
						getParser().getLocationInfo(),
						attrLocalName );
				}
			}

			// Ensure that required attributes have values
			if( attrSentToEMailAddr == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"SentToEMailAddr" );
			}
			if( ( attrPasswordResetUuid6 == null ) || ( attrPasswordResetUuid6.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"PasswordResetUuid6" );
			}
			if( ( attrNewAccount == null ) || ( attrNewAccount.length() <= 0 ) ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"NewAccount" );
			}

			// Save named attributes to context
			YCFLibXmlCoreContext curContext = getParser().getCurContext();
			curContext.putNamedValue( "Id", attrId );
			curContext.putNamedValue( "SentToEMailAddr", attrSentToEMailAddr );
			curContext.putNamedValue( "PasswordResetUuid6", attrPasswordResetUuid6 );
			curContext.putNamedValue( "NewAccount", attrNewAccount );

			// Convert string attributes to native Java types
			// and apply the converted attributes to the editBuff.

			Integer natId;
			if( ( attrId != null ) && ( attrId.length() > 0 ) ) {
				natId = Integer.valueOf( Integer.parseInt( attrId ) );
			}
			else {
				natId = null;
			}
			String natSentToEMailAddr = attrSentToEMailAddr;
			editBuff.setRequiredSentToEMailAddr( natSentToEMailAddr );

			YCFLibUuid6 natPasswordResetUuid6;
			try {
				natPasswordResetUuid6 = YCFLibUuid6.fromString( attrPasswordResetUuid6 );
			}
			catch( RuntimeException e ) {
				throw new YCFLibInvalidArgumentException( getClass(),
					S_ProcName,
					0,
					"PasswordResetUuid6",
					e );
			}
			editBuff.setRequiredPasswordResetUuid6( natPasswordResetUuid6 );

			boolean natNewAccount;
			if( attrNewAccount.equals( "true" ) || attrNewAccount.equals( "yes" ) || attrNewAccount.equals( "1" ) ) {
				natNewAccount = true;
			}
			else if( attrNewAccount.equals( "false" ) || attrNewAccount.equals( "no" ) || attrNewAccount.equals( "0" ) ) {
				natNewAccount = false;
			}
			else {
				throw new YCFLibUsageException( getClass(),
					S_ProcName,
					String.format(Inz.x("ycflib.xml.YCFLibXmlUtil.XmlBooleanInvalid"), "NewAccount", attrNewAccount),
					String.format(Inz.s("ycflib.xml.YCFLibXmlUtil.XmlBooleanInvalid"), "NewAccount", attrNewAccount));
			}
			editBuff.setRequiredNewAccount( natNewAccount );

			// Get the scope/container object

			YCFLibXmlCoreContext parentContext = curContext.getPrevContext();
			Object scopeObj;
			if( parentContext != null ) {
				scopeObj = parentContext.getNamedValue( "Object" );
			}
			else {
				scopeObj = null;
			}

			// Resolve and apply required Container reference

			if( scopeObj == null ) {
				throw new YCFLibNullArgumentException( getClass(),
					S_ProcName,
					0,
					"scopeObj" );
			}
			else if( scopeObj instanceof IBusModelSecUserObj ) {
				refUser = (IBusModelSecUserObj) scopeObj;
				editBuff.setRequiredContainerUser( refUser );
			}
			else {
				throw new YCFLibUnsupportedClassException( getClass(),
					S_ProcName,
					"scopeObj",
					scopeObj,
					"IBusModelSecUserObj" );
			}

			BusModelSaxLoader.LoaderBehaviourEnum loaderBehaviour = saxLoader.getSecUserPWResetLoaderBehaviour();
			IBusModelSecUserPWResetEditObj editSecUserPWReset = null;
			IBusModelSecUserPWResetObj origSecUserPWReset = (IBusModelSecUserPWResetObj)schemaObj.getSecUserPWResetTableObj().readSecUserPWResetByUUuid6Idx( editBuff.getRequiredPasswordResetUuid6() );
			if( origSecUserPWReset == null ) {
				editSecUserPWReset = editBuff;
			}
			else {
				switch( loaderBehaviour ) {
					case Insert:
						break;
					case Update:
						editSecUserPWReset = (IBusModelSecUserPWResetEditObj)origSecUserPWReset.beginEdit();
						editSecUserPWReset.setRequiredSentToEMailAddr( editBuff.getRequiredSentToEMailAddr() );
						editSecUserPWReset.setRequiredPasswordResetUuid6( editBuff.getRequiredPasswordResetUuid6() );
						editSecUserPWReset.setRequiredNewAccount( editBuff.getRequiredNewAccount() );
						break;
					case Replace:
						editSecUserPWReset = (IBusModelSecUserPWResetEditObj)origSecUserPWReset.beginEdit();
						editSecUserPWReset.deleteInstance();
						editSecUserPWReset = null;
						origSecUserPWReset = null;
						editSecUserPWReset = editBuff;
						break;
				}
			}

			if( editSecUserPWReset != null ) {
				if( origSecUserPWReset != null ) {
					editSecUserPWReset.update();
				}
				else {
					origSecUserPWReset = (IBusModelSecUserPWResetObj)editSecUserPWReset.create();
				}
				editSecUserPWReset = null;
			}

			curContext.putNamedValue( "Object", origSecUserPWReset );
		}
		catch( RuntimeException e ) {
			throw new SAXException( "Near " + getParser().getLocationInfo() + ": Caught and rethrew " + e.getClass().getName() + " - " + e.getMessage(),
				e );
		}
		catch( Error e ) {
			throw new SAXException( "Near " + getParser().getLocationInfo() + ": Caught and rethrew " + e.getClass().getName() + " - " + e.getMessage() );
		}
	}

	public void endElement(
		String		uri,
		String		localName,
		String		qName )
	throws SAXException
	{
	}
}
