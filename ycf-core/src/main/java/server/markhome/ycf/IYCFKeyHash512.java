/**
 *	server.markhome.ycf-core - Mark's Code Fractal Core Services
 *
 *	Copyright 2026 Mark Stephen Sobkow (mark.sobkow@gmail.com)
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *		http://apache.org
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 *
 *	SPDX-License-Identifier: Apache-2.0
**/

package server.markhome.ycf;

import org.teavm.jso.JSExport;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

import java.util.*;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *	IYCFKeyHash512 implements a 512-bit key hash using a HASHALGO algorithm.
 *
 *	@since 2026
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFKeyHash512 extends IYCFKeyHashBase<IYCFKeyHash512> {

	/**
	 *	The service singleton has to be multithread-safe.
	 */
	static final IYCFMtReference<IYCFKeyHash512> singleton = IYCFMtReference<IYCFKeyHash512>.getService().getInstance(null);

	/**
	 *	Get the service singleton.
	 *
	 *	@return The service singleton.
	 */
	@JSExport
	public static IYCFKeyHash512 getService() {
		IYCFKeyHash512 ref = singleton.get();
		if (ref == null) {
			ref = new IYCFKeyHash512();
			singleton.set(null, ref);
			ref = singleton.get();
		}
		return(ref);
	}

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_getInstance()
	 *		Get an instance that provides the service method implementations.
	 *
	 *	@return IYCFKeyHash512 The instance implementation.
	 */
	@JSExport
	public static IYCFKeyHash512 YCFKeyHash512_getInstance();

	/**
	 *	IYCFKeyHash512 getInstance()
	 *		Get an instance that provides the service method implementations.
	 *
	 *	@return IYCFKeyHash512 The instance implementation.
	 */
	@JSExport
	public IYCFKeyHash512 getInstance();

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_getInstance(i)
	 *		Get an instance that provides the service method implementations with a generated value.
	 *
	 *	@param Dummy integer parameter to indicate a key value should be generated.
	 *
	 *	@return IYCFKeyHash512 The instance implementation with a generated value.
	 */
	@JSExport
	public static IYCFKeyHash512 YCFKeyHash512_getInstance(int i);

	/**
	 *	IYCFKeyHash512 getInstance(i)
	 *		Get an instance that provides the service method implementations with a generated value.
	 *
	 *	@param Dummy integer parameter to indicate a key value should be generated.
	 *
	 *	@return IYCFKeyHash512 The instance implementation with a generated value.
	 */
	@JSExport
	public IYCFKeyHash512 getInstance(int i);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_getInstance(s)
	 *		Get an instance that provides the service method implementations with a generated value.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash512_getHashLengthString() characters long.
	 *
	 *	@return An instance which may be a null if the string s is null.
	 */
	@JSExport
	public static IYCFKeyHash512 YCFKeyHash512_getInstance(String s);

	/**
	 *	IYCFKeyHash512 getInstance()
	 *		Get an instance that provides the service method implementations with a generated value.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash512_getHashLengthString() characters long.
	 *
	 *	@return An instance which may be a null if the string s is null.
	 */
	@JSExport
	public IYCFKeyHash512 getInstance(String s);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_getInstance(a)
	 *		Get an instance using the specified byte array as an initializer for the hash data.
	 *
	 *	@param a The byte array to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the byte array a is null.
	 */
	@JSExport
	public static IYCFKeyHash512 YCFKeyHash512_getInstance(byte[] a);

	/**
	 *	IYCFKeyHash512 getInstance(a)
	 *		Get an instance using the specified byte array as an initializer for the hash data.
	 *
	 *	@param a The byte array to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the byte array a is null.
	 */
	@JSExport
	public IYCFKeyHash512 getInstance(byte[] a);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash512 YCFKeyHash512_getInstance(IYCFKeyHash128 k);

	/**
	 *	IYCFKeyHash512 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash512 getInstance(IYCFKeyHash128 k);

	/**
	 *	IYCFKeyHash512 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash512 getInstance(IYCFKeyHash160 k);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash512 YCFKeyHash512_getInstance(IYCFKeyHash160 k);

	/**
	 *	IYCFKeyHash512 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash512 getInstance(IYCFKeyHash224 k);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash512 YCFKeyHash512_getInstance(IYCFKeyHash224 k);

	/**
	 *	IYCFKeyHash512 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash512 getInstance(IYCFKeyHash256 k);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash512 YCFKeyHash512_getInstance(IYCFKeyHash256 k);

	/**
	 *	IYCFKeyHash512 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash512 getInstance(IYCFKeyHash384 k);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash512 YCFKeyHash512_getInstance(IYCFKeyHash384 k);

	/**
	 *	IYCFKeyHash512 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash512 getInstance(IYCFKeyHash512 k);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash512 YCFKeyHash512_getInstance(IYCFKeyHash512 k);

	/**
	 *	IYCFKeyHash512 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash512 getInstance(IYCFKeyHash512 k);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_fromInt(i)
	 *		Get an instance that uses the integer i to initialize the first 4 bytes of the key data.
	 *
	 *	@return IYCFKeyHash512 An instance that uses the integer i to initialize the first 4 bytes of the key data.
	 */
	@JSExport
	public static IYCFKeyHash512 YCFKeyHash512_fromInt(int i);

	/**
	 *	IYCFKeyHash512 fromInt(i)
	 *		Get an instance that uses the integer i to initialize the first 4 bytes of the key data.
	 *
	 *	@return IYCFKeyHash512 An instance that uses the integer i to initialize the first 4 bytes of the key data.
	 */
	@JSExport
	public IYCFKeyHash512 fromInt(int i);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_nullGet()
	 *		Get a null instance.
	 *
	 *	@return IYCFKeyHash512 A null instance
	 */
	@JSExport
	public static IYCFKeyHash512 YCFKeyHash512_nullGet();

	/**
	 *	IYCFKeyHash512 nullGet()
	 *		Get a null instance.
	 *
	 *	@return IYCFKeyHash512 A null instance.
	 */
	@JSExport
	public IYCFKeyHash512 nullGet();

	/**
	 *	String YCFKeyHash512_nullString()
	 *		Get a null value string.
	 *
	 *	@return String The null value string.
	 */
	@JSExport
	public static String YCFKeyHash512_nullString();

	/**
	 *	String nullString()
	 *		Get the null value string.
	 *
	 *	@return  String the null value string.
	 */
	@JSExport
	public String nullString();

	/**
	 *	int YCFKeyHash512_getHashLength()
	 *		Get the length of the hash value.
	 *
	 *	@return The length of hashed values (size of the byte arrays.)
	 */
	@JSExport
  	public static int YCFKeyHash512_getHashLength();

	/**
	 *	int getHashLength()
	 *		Get the length of the hash value.
	 *
	 *	@return The length of hashed values (size of the byte arrays.)
	 */
	@JSExport
  	public int getHashLength();

	/**
	 *	int YCFKeyHash512_getHashLengthString()
	 *		Get the length of the hash value string form.
	 *
	 *	@return The length of hashed value strings.
	 */
	@JSExport
  	public static int YCFKeyHash512_getHashLengthString();

	/**
	 *	int getHashLengthString()
	 *		Get the length of the hash value string form.
	 *
	 *	@return The length of hashed value strings.
	 */
	@JSExport
  	public int getHashLengthString();

	/**
	 *	String YCFKeyHash512_getHashAlgo()
	 *		Get the name of the hash algorithm used.
	 *
	 *	@return The name of the hash algorithm used.
	 */
	@JSExport
  	public static String YCFKeyHash512_getHashAlgo();

	/**
	 *	String getHashAlgo()
	 *		Get the name of the hash algorithm used.
	 *
	 *	@return The name of the hash algorithm used.
	 */
	@JSExport
  	public String getHashAlgo();

	/**
	 *	int YCFKeyHash512_compare()
	 *		Compare two instances.
	 *
	 *	@return less than zero if A is less than B, greater than zero if A is greater than B, otherwise zero.
	 */
	@JSExport
  	public static int YCFKeyHash512_compare(IYCFKeyHash512 a, IYCFKeyHash512 b);

	/**
	 *	int compare(b)
	 *		Compare an instance.
	 *
	 *	@return less than zero if this is less than B, greater than zero if this is greater than B, otherwise zero.
	 */
	@JSExport
  	public int compare(IYCFKeyHash512 b);

	/**
	 *	int YCFKeyHash512_compareOrdered()
	 *		Compare two instances.
	 *
	 *	@return less than zero if A is less than B, greater than zero if A is greater than B, otherwise zero.
	 */
	@JSExport
  	public static int YCFKeyHash512_compareOrdered(IYCFKeyHash512 a, IYCFKeyHash512 b);

	/**
	 *	int compareOrdered()
	 *		Compare two instances.
	 *
	 *	@return less than zero if this is less than B, greater than zero if this is greater than B, otherwise zero.
	 */
	@JSExport
  	public int compareOrdered(IYCFKeyHash512 b);

	/**
	 *	void YCFKeyHash512_initStatics()
	 *		Initialize the statics.
	 */
	@JSExport
  	public static void YCFKeyHash512_initStatics();

	/**
	 *	byte[] YCFKeyHash512_sbytesFromHex(s)
	 *		Calculate a hash byte array from a hexadecimal string.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash512_getHashLengthString() characters long.
	 *
	 *	@return A byte array or null if the string s is null.
	 */
	@JSExport
  	public static byte[] YCFKeyHash512_sbytesFromHex(String s);

	/**
	 *	byte[] sbytesFromHex(s)
	 *		Calculate a hash byte array from a hexadecimal string.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash512_getHashLengthString() characters long.
	 *
	 *	@return A byte array or null if the string s is null.
	 */
	@JSExport
  	public byte[] sbytesFromHex(String s);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_fromHex(s)
	 *		Create an instance from a hexadecimal string.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash512_getHashLengthString() characters long.
	 *
	 *	@return An instance or null.
	 */
	@JSExport
  	public static IYCFKeyHash512 YCFKeyHash512_fromHex(String s);

	/**
	 *	IYCFKeyHash512 fromHex(s)
	 *		Create an instance from a hexadecimal string.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash512_getHashLengthString() characters long.
	 *
	 *	@return An instance or null.
	 */
	@JSExport
  	public IYCFKeyHash512 fromHex(String s);

	/**
	 *	Comparator<IYCFKeyHash512> YCFKeyHash512_getComparator()
	 *		Get a Comparator instance for the keys.
	 *
	 *	@return A Comparator for the key instances.
	 */
	@JSExport
	public static Comparator<IYCFKeyHash512> YCFKeyHash512_getComparator();

	/**
	 *	Comparator<IYCFKeyHash512> getComparator()
	 *		Get a Comparator instance for the keys.
	 *
	 *	@return A Comparator for the key instances.
	 */
	@JSExport
	public Comparator<IYCFKeyHash512> getComparator();

	/**
	 *	byte[] YCFKeyHash512_getBytes(k)
	 *		Get the byte array for key value k.
	 *
	 *	@param k The key value to be evaluated.
	 *
	 *	@return The byte array for key value k, or null if k is null.
	 */
	@JSExport
	public static byte[] YCFKeyHash512_getBytes(IYCFKeyHash512 k);

	/**
	 *	byte[] getBytes()
	 *		Get the byte array for this key.
	 *
	 *	@return The byte array for this key.
	 */
	@JSExport
	public byte[] getBytes();

	/**
	 *	void YCFKeyHash512_setBytes(k, a)
	 *		Set the byte array for key value k to a copy of the byte array a. If a is null, set k's key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param k The key value to be updated.
	 *	@param a The byte array to use for the update.  If it is null, then k's key data is set to zeroes.
	 */
	@JSExport
	public static void YCFKeyHash512_setBytes(IYCFKeyHash512 k, byte[] a);

	/**
	 *	void setBytes(a)
	 *		Set the byte array for the key to a copy of the byte array a. If a is null, set the key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param a The byte array to use for the update.  If it is null, then the key data is set to zeroes.
	 */
	@JSExport
	public void setBytes(byte[] a);

	/**
	 *	void YCFKeyHash512_setBytes(k, a, o, l)
	 *		Set the byte array for key value k to a copy of the byte array a starting at the offset o for the length l. If a is null, set k's key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param k The key value to be updated.
	 *	@param a The byte array to use for the update.  If it is null, then k's key data is set to zeroes.
	 *	@param o The offset into the array a
	 *	@param l The number of bytes to copy from array a
	 */
	@JSExport
	public static void YCFKeyHash512_setBytes(IYCFKeyHash512 k, byte[] a, int o, int l);

	/**
	 *	void setBytes(a, o, l)
	 *		Set the byte array for the key to a copy of the byte array a starting at the offset o for the length l. If a is null, set the key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param a The byte array to use for the update.  If it is null, then the key data is set to zeroes.
	 *	@param o The offset into the array a
	 *	@param l The number of bytes to copy from array a
	 */
	@JSExport
	public void setBytes(byte[] a, int o, int l);

	/**
	 *	boolean YCFKeyHash512_isNull(k)
	 *		Is the key k null valued?
	 *
	 *	@return True if k is null or null valued, otherwise false.
	 */
	@JSExport
  	public static boolean YCFKeyHash512_isNull(IYCFKeyHash512 k);

	/**
	 *	boolean isNull()
	 *		Is this key null valued?
	 *
	 *	@return True if this key is null valued, otherwise false.
	 */
	@JSExport
  	public boolean isNull();

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_hash(s)
	 *		Create an instance by hashing the string s.
	 *
	 *	@param s The string to be hashed.
	 *
	 *	@return An instance or null if s is null.
	 */
	@JSExport
  	public static IYCFKeyHash512 YCFKeyHash512_hash(String s);

	/**
	 *	IYCFKeyHash512 hash(s)
	 *		Create an instance by hashing the string s.
	 *
	 *	@param s The string to be hashed.
	 *
	 *	@return An instance or null if s is null.
	 */
	@JSExport
  	public IYCFKeyHash512 hash(String s);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_hash(a)
	 *		Create an instance by hashing the byte array a.
	 *
	 *	@param a The byte array to be hashed.
	 *
	 *	@return An instance or null if a is null.
	 */
	@JSExport
  	public static IYCFKeyHash512 YCFKeyHash512_hash(byte[] a);

	/**
	 *	IYCFKeyHash512 hash(a)
	 *		Create an instance by hashing the byte array a.
	 *
	 *	@param a The byte array to be hashed.
	 *
	 *	@return An instance or null if a is null.
	 */
	@JSExport
  	public IYCFKeyHash512 hash(byte[] a);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_hash(a...)
	 *		Create an instance by hashing the byte arrays a and ....
	 *
	 *	@param a... The byte arrays to be hashed.
	 *
	 *	@return An instance or null if a is null and no other arrays are specified.
	 */
	@JSExport
  	public static IYCFKeyHash512 YCFKeyHash512_hash(byte[]... a);

	/**
	 *	IYCFKeyHash512 hash(a...)
	 *		Create an instance by hashing the byte arrays a and ....
	 *
	 *	@param a... The byte arrays to be hashed.
	 *
	 *	@return An instance or null if a is null and no other arrays are specified.
	 */
	@JSExport
  	public IYCFKeyHash512 hash(byte[]... a);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_hash(k...)
	 *		Create an instance by hashing the keys k and ....
	 *
	 *	@param k... The keys to be hashed.
	 *
	 *	@return An instance or null if k is null and no other keys are specified.
	 */
	@JSExport
  	public static IYCFKeyHash512 YCFKeyHash512_hash(IYCFKeyHash512... k);

	/**
	 *	IYCFKeyHash512 hash(k...)
	 *		Create an instance by hashing the keys k and ....
	 *
	 *	@param k... The keys to be hashed.
	 *
	 *	@return An instance or null if k is null and no other keys are specified.
	 */
	@JSExport
  	public IYCFKeyHash512 hash(IYCFKeyHash512... k);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_hash(i...)
	 *		Create an instance by hashing the integers i and ....
	 *
	 *	@param k... The integers to be hashed.
	 *
	 *	@return An instance.
	 */
	@JSExport
  	public static IYCFKeyHash512 YCFKeyHash512_hash(int... k);

	/**
	 *	IYCFKeyHash512 hash(i...)
	 *		Create an instance by hashing the integers i and ....
	 *
	 *	@param i... The integers to be hashed.
	 *
	 *	@return An instance.
	 */
	@JSExport
  	public IYCFKeyHash512 hash(int... i);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_hash(a...)
	 *		Create an instance by hashing the integer arrays a and ....
	 *
	 *	@param a... The integer arrays to be hashed.
	 *
	 *	@return An instance, or null if a is null and no other arrays are specified.
	 */
	@JSExport
  	public static IYCFKeyHash512 YCFKeyHash512_hash(int[]... a);

	/**
	 *	IYCFKeyHash512 hash(a...)
	 *		Create an instance by hashing the integer arrays a and ....
	 *
	 *	@param a... The integer arrays to be hashed.
	 *
	 *	@return An instance, or null if a is null and no other arrays are specified.
	 */
	@JSExport
  	public IYCFKeyHash512 hash(int[]... a);

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_deepClone(k)
	 *		Create an instance by deep cloning the key data for k.
	 *
	 *	@param k The key value to clone.
	 *
	 *	@return An instance, or null if k is null.
	 */
	@JSExport
  	public static IYCFKeyHash512 YCFKeyHash512_deepClone(IYCFKeyHash512 k);

	/**
	 *	IYCFKeyHash512 deepClone()
	 *		Create an instance by deep cloning this key's data.
	 *
	 *	@return An instance cloned from this one.
	 */
	@JSExport
  	public IYCFKeyHash512 deepClone();

	/**
	 *	IYCFKeyHash512 YCFKeyHash512_fromHexQuick(s)
	 *		Create an instance by converting String s from hexadecimal.
	 *
	 *	@param s The hexadecimal string to convert.
	 *
	 *	@return An instance, or null if s is null.
	 */
	@JSExport
  	public static IYCFKeyHash512 YCFKeyHash512_fromHexQuick(String s);

	/**
	 *	IYCFKeyHash512 fromHexQuick(s)
	 *		Create an instance by converting String s from hexadecimal.
	 *
	 *	@param s The hexadecimal string to convert.
	 *
	 *	@return An instance, or null if s is null.
	 */
	@JSExport
  	public IYCFKeyHash512 fromHexQuick(String s);

	/**
	 *	IYCFKeyHash512[] YCFKeyHash512_toKeyHashes(a)
	 *		Create an array of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return An array of instances, or null if a was null.
	 */
	@JSExport
  	public static IYCFKeyHash512[] YCFKeyHash512_toKeyHashes(String[] a);

	/**
	 *	IYCFKeyHash512[] toKeyHashes(a)
	 *		Create an array of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return An array of instances, or null if a was null.
	 */
	@JSExport
  	public IYCFKeyHash512[] toKeyHashes(String[] a);

	/**
	 *	List<IYCFKeyHash512> YCFKeyHash512_toKeyHashesList(a)
	 *		Create a list of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return A list of instances, or null if a was null.
	 */
	@JSExport
  	public static List<IYCFKeyHash512> YCFKeyHash512_toKeyHashesList(String[] a);

	/**
	 *	List<IYCFKeyHash512> toKeyHashesList(a)
	 *		Create a list of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return A list of instances, or null if a was null.
	 */
	@JSExport
  	public List<IYCFKeyHash512> toKeyHashesList(String[] a);

	/**
	 *	Set<IYCFKeyHash512> YCFKeyHash512_toKeyHashesSet(a)
	 *		Create a set of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return A set of instances, or null if a was null.
	 */
	@JSExport
  	public static Set<IYCFKeyHash512> YCFKeyHash512_toKeyHashesSet(String[] a);

	/**
	 *	Set<IYCFKeyHash512> toKeyHashesSet(a)
	 *		Create a set of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return A set of instances, or null if a was null.
	 */
	@JSExport
  	public Set<IYCFKeyHash512> toKeyHashesSet(String[] a);
}
