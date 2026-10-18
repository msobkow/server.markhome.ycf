// Description: Java 25 protected interface for a URLProtocol record implementation

/*
 *	server.markhome.ycf.IntNet
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Yorkton Code Fractal 3.1 IntNet - Internet Essentials
 *	
 *	This file is part of Yorkton Code Fractal IntNet.
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

package server.markhome.ycf.v3_1.intnet.intnetprot;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binaryYCFCore64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.ycf.*;
import server.markhome.ycf.dbutil.*;
import server.markhome.ycf.YCFXmlUtil;
import server.markhome.ycf.v3_1.secure.securepub.*;
import server.markhome.ycf.v3_1.intnet.intnetpub.*;
import server.markhome.ycf.v3_1.secure.securepubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetpubobj.*;
import server.markhome.ycf.v3_1.intnet.intnetprotobj.*;

/**
 *	IIntNetProtURLProtocol persistence instances have CodeVis Public, meaning that any user interface or referencing schema can access it.
 */
public interface IIntNetProtURLProtocol
{
	public static final int URLPROTOCOLID_MIN_VALUE = 0;
	public static final String S_INIT_CREATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_CREATED_BY = YCFDbKeyHash256.fromHex(S_INIT_CREATED_BY);
	public static final String S_INIT_UPDATED_BY = "0000000000000000000000000000000000000000000000000000000000000000";
	public static final YCFDbKeyHash256 INIT_UPDATED_BY = YCFDbKeyHash256.fromHex(S_INIT_UPDATED_BY);
	public static final int URLPROTOCOLID_INIT_VALUE = 0;
	public static final String NAME_INIT_VALUE = new String( "" );
	public static final String DESCRIPTION_INIT_VALUE = new String( "" );
	public final static boolean ISSECURE_INIT_VALUE = false;
	public final static int CLASS_CODE = 0xa109;
	public final static String S_CLASS_CODE = "a109";

	public int getClassCode();

	public YCFDbKeyHash256 getCreatedByUserId();

	public void setCreatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getCreatedAt();

	public void setCreatedAt( LocalDateTime value );

	public YCFDbKeyHash256 getUpdatedByUserId();

	public void setUpdatedByUserId( YCFDbKeyHash256 value );

	public LocalDateTime getUpdatedAt();

	public void setUpdatedAt( LocalDateTime value );

	public Integer getPKey();
	public void setPKey(Integer requiredURLProtocolId);
	public int getRequiredURLProtocolId();
	public void setRequiredURLProtocolId( int value );
	public int getRequiredRevision();
	public void setRequiredRevision( int value );

	public String getRequiredName();
	public void setRequiredName( String value );
	public String getRequiredDescription();
	public void setRequiredDescription( String value );
	public boolean getRequiredIsSecure();
	public void setRequiredIsSecure( boolean value );
	public boolean equals( Object obj );

	public int hashCode();

	public int compareTo( Object obj );

	public void set( IIntNetProtURLProtocol src );

	public void setURLProtocol( IIntNetProtURLProtocol src );

	public void set( IIntNetProtURLProtocolH src );

	public void setURLProtocol( IIntNetProtURLProtocolH src );

	public void set( IIntNetPubURLProtocol src );

	public void setURLProtocol( IIntNetPubURLProtocol src );

	public void set( IIntNetPubURLProtocolH src );

	public void setURLProtocol( IIntNetPubURLProtocolH src );

	public String getXmlAttrFragment();

	public String toString();
}
