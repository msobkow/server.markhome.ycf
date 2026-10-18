// Description: Java 25 interface for a ISOTZone record declementation

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

package server.markhome.ycf.v3_1.secure.secure;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;

import server.markhome.ycf.v3_1.secure.secureprotobj.*;

/**
 *	ISecureISOTZone persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface ISecureISOTZone
{
	public static final short ISOTZONEID_MIN_VALUE = (short)0;
	public static final short TZHOUROFFSET_MIN_VALUE = (short)-12;
	public static final short TZMINOFFSET_MIN_VALUE = (short)-59;
	public static final short TZHOUROFFSET_MAX_VALUE = (short)12;
	public static final short TZMINOFFSET_MAX_VALUE = (short)59;
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_CREATED_BY = YCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_UPDATED_BY = YCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final short ISOTZONEID_INIT_VALUE = (short)0;
	public static final String ISO8601_INIT_VALUE = new String( "" );
	public static final String TZNAME_INIT_VALUE = new String( "" );
	public static final short TZHOUROFFSET_INIT_VALUE = (short)0;
	public static final short TZMINOFFSET_INIT_VALUE = (short)0;
	public static final String DESCRIPTION_INIT_VALUE = new String( "" );
	public final static boolean VISIBLE_INIT_VALUE = true;
	public final static int CLASS_CODE = 0xa008;
	public final static String S_CLASS_CODE = "a008";

	public int getClassCode();

	public YCFDbKeyHash256 getCreatedByUserId();

	public void setCreatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getCreatedAt();

	public void setCreatedAt( LocalDateTime value );

	public YCFDbKeyHash256 getUpdatedByUserId();

	public void setUpdatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getUpdatedAt();

	public void setUpdatedAt( LocalDateTime value );

	public $implCommaIJavaOptAtomType$ getPKey();
	public void setPKey($implCommaIJavaOptAtomType$ requiredISOTZoneId);
	public short getRequiredISOTZoneId();
	public void setRequiredISOTZoneId( short value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public String getRequiredIso8601();
	public void setRequiredIso8601( String value );
	public String getRequiredTZName();
	public void setRequiredTZName( String value );
	public short getRequiredTZHourOffset();
	public void setRequiredTZHourOffset( short value );
	public short getRequiredTZMinOffset();
	public void setRequiredTZMinOffset( short value );
	public String getRequiredDescription();
	public void setRequiredDescription( String value );
	public boolean getRequiredVisible();
	public void setRequiredVisible( boolean value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( ISecureISOTZone src );

	public void setISOTZone( ISecureISOTZone src );

	public void set( ISecureISOTZoneH src );

	public void setISOTZone( ISecureISOTZoneH src );

	public void set( ISecureProtISOTZone src );

	public void setISOTZone( ISecureProtISOTZone src );

	public void set( ISecureProtISOTZoneH src );

	public void setISOTZone( ISecureProtISOTZoneH src );

	public void set( ISecurePubISOTZone src );

	public void setISOTZone( ISecurePubISOTZone src );

	public void set( ISecurePubISOTZoneH src );

	public void setISOTZone( ISecurePubISOTZoneH src );

	public String getXmlAttrFragment();

	public String toString();
}
