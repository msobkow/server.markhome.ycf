// Description: Java 25 public interface for a RoleDef history object

/*
 *	server.markhome.mcf.CFBam
 *
 *	Copyright (c) 2016-2026 Mark Stephen Sobkow
 *	
 *	Mark's Code Fractal CFBam 3.1 Business Application Model
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	This file is part of Mark's Code Fractal CFBam.
 *	
 *	Mark's Code Fractal CFBam is available under dual commercial license from
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
 *	Mark's Code Fractal CFBam is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFBam is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *	
 *	You should have received a copy of the GNU General Public License
 *	along with Mark's Code Fractal CFBam.  If not, see <https://www.gnu.org/licenses/>.
 *	
 *	If you wish to modify and use this code without publishing your changes,
 *	or integrate it with proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */

package server.markhome.mcf.v3_1.cfbam.cfbampub;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.text.StringEscapeUtils;
import server.markhome.mcf.v3_1.cflib.*;
import server.markhome.mcf.v3_1.cflib.keyhash.*;
import server.markhome.mcf.v3_1.cflib.xml.MCFXmlUtil;
import server.markhome.mcf.v3_1.cfsec.cfsecpub.*;
import server.markhome.mcf.v3_1.cfint.cfintpub.*;
//import server.markhome.mcf.v3_1.cfbam.cfbampub.*;

/**
 *	ICFBamPubRoleDefH provides access to public history records matching the CFBamPubRoleDef object change history.
 */
public interface ICFBamPubRoleDefH
{
	public int getClassCode();

	public MCFDbKeyHash256 getCreatedByUserId();
	public void setCreatedByUserId( MCFDbKeyHash256 value );
	public LocalDateTime getCreatedAt();
	public void setCreatedAt( LocalDateTime value );
	public MCFDbKeyHash256 getUpdatedByUserId();
	public void setUpdatedByUserId( MCFDbKeyHash256 value );
	public LocalDateTime getUpdatedAt();
	public void setUpdatedAt( LocalDateTime value );

	public ICFBamPubRoleDefHPKey getPubPKey();
	public void setPubPKey( ICFBamPubRoleDefHPKey pkey );
	public MCFDbKeyHash256 getAuditClusterId();
	public void setAuditClusterId(MCFDbKeyHash256 auditClusterId);
	public LocalDateTime getAuditStamp();
	public void setAuditStamp(LocalDateTime auditStamp);
	public short getAuditActionId();
	public void setAuditActionId(short auditActionId);
	public int getRequiredRevision();
	public void setRequiredRevision(int revision);
	public MCFDbKeyHash256 getAuditSessionId();
	public void setAuditSessionId(MCFDbKeyHash256 auditSessionId);

	public IMCFKeyHash256 getRequiredId();
	public void setRequiredId( IMCFKeyHash256 requiredId );

	public MCFDbKeyHash256 getRequiredScopeId();
	public void setRequiredScopeId( MCFDbKeyHash256 value );
	public MCFDbKeyHash256 getOptionalDefSchemaId();
	public void setOptionalDefSchemaId( MCFDbKeyHash256 value );
	public String getRequiredName();
	public void setRequiredName( String value );
	public String getRequiredEnables();
	public void setRequiredEnables( String value );
	public String getRequiredIncludes();
	public void setRequiredIncludes( String value );
	@Override
	public boolean equals( Object obj );

	@Override
	public int hashCode();

	//@Override
	public int compareTo( Object obj );

	public void set( ICFBamPubRoleDef src );
	public void set( ICFBamPubRoleDefH src );
	public void setRoleDef( ICFBamPubRoleDef src );
	public void setRoleDef( ICFBamPubRoleDefH src );
	public String getXmlAttrFragment();

	@Override
	public String toString();
}
