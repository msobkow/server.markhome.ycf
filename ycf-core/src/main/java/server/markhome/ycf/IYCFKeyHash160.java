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
 *	IYCFKeyHash160 implements a 160-bit key hash using a HASHALGO algorithm.
 *
 *	@since 2026
 *	@author Mark Sobkow (mark.sobkow@gmail.com)
 */
public interface IYCFKeyHash160 extends IYCFKeyHashBase<IYCFKeyHash160> {

	/**
	 *	The service singleton has to be thread-safe.
	 */
	static final IYCFMtReference singleton = IYCFMtReference.getService().getInstance();

	/**
	 *	Get the service singleton.
	 *
	 *	@return The service singleton.
	 */
	@JSExport
	public static IYCFKeyHash160 getService() {
		IYCFKeyHash160 ref = ((IYCFKeyHash160)(singleton.get()));
		if (ref == null) {
			ref = new YCFKeyHash160();
			singleton.set(null, ref);
			ref = ((IYCFKeyHash160)(singleton.get()));
		}
		return(ref);
	}

	/**
	 *	IYCFKeyHash160 getInstance()
	 *		Get an instance that provides the service method implementations.
	 *
	 *	@return IYCFKeyHash160 The instance implementation.
	 */
	@JSExport
	public IYCFKeyHash160 getInstance();

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_getInstance(i)
	 *		Get an instance that provides the service method implementations with a generated value.
	 *
	 *	@param Dummy integer parameter to indicate a key value should be generated.
	 *
	 *	@return IYCFKeyHash160 The instance implementation with a generated value.
	 */
	@JSExport
	public static IYCFKeyHash160 YCFKeyHash160_getInstance(int i);

	/**
	 *	IYCFKeyHash160 getInstance(i)
	 *		Get an instance that provides the service method implementations with a generated value.
	 *
	 *	@param Dummy integer parameter to indicate a key value should be generated.
	 *
	 *	@return IYCFKeyHash160 The instance implementation with a generated value.
	 */
	@JSExport
	public IYCFKeyHash160 getInstance(int i);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_getInstance(s)
	 *		Get an instance that provides the service method implementations with a generated value.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash160_getHashLengthString() characters long.
	 *
	 *	@return An instance which may be a null if the string s is null.
	 */
	@JSExport
	public static IYCFKeyHash160 YCFKeyHash160_getInstance(String s);

	/**
	 *	IYCFKeyHash160 getInstance()
	 *		Get an instance that provides the service method implementations with a generated value.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash160_getHashLengthString() characters long.
	 *
	 *	@return An instance which may be a null if the string s is null.
	 */
	@JSExport
	public IYCFKeyHash160 getInstance(String s);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_getInstance(a)
	 *		Get an instance using the specified byte array as an initializer for the hash data.
	 *
	 *	@param a The byte array to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the byte array a is null.
	 */
	@JSExport
	public static IYCFKeyHash160 YCFKeyHash160_getInstance(byte[] a);

	/**
	 *	IYCFKeyHash160 getInstance(a)
	 *		Get an instance using the specified byte array as an initializer for the hash data.
	 *
	 *	@param a The byte array to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the byte array a is null.
	 */
	@JSExport
	public IYCFKeyHash160 getInstance(byte[] a);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash160 YCFKeyHash160_getInstance(IYCFKeyHash128 k);

	/**
	 *	IYCFKeyHash160 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash160 getInstance(IYCFKeyHash128 k);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash160 YCFKeyHash160_getInstance(IYCFKeyHash160 k);

	/**
	 *	IYCFKeyHash160 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash160 getInstance(IYCFKeyHash160 k);

	/**
	 *	IYCFKeyHash160 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash160 getInstance(IYCFKeyHash224 k);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash160 YCFKeyHash160_getInstance(IYCFKeyHash224 k);

	/**
	 *	IYCFKeyHash160 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash160 getInstance(IYCFKeyHash256 k);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash160 YCFKeyHash160_getInstance(IYCFKeyHash256 k);

	/**
	 *	IYCFKeyHash160 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash160 getInstance(IYCFKeyHash384 k);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash160 YCFKeyHash160_getInstance(IYCFKeyHash384 k);

	/**
	 *	IYCFKeyHash160 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash160 getInstance(IYCFKeyHash512 k);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public static IYCFKeyHash160 YCFKeyHash160_getInstance(IYCFKeyHash512 k);

	/**
	 *	IYCFKeyHash160 getInstance(k)
	 *		Get an instance using the specified key as an initializer for the hash data.
	 *
	 *	@param k The key to use to initialize the hash data.
	 *
	 *	@return An instance which may be a null if the key k is null.
	 */
	@JSExport
	public IYCFKeyHash160 getInstance(IYCFKeyHash160 k);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_fromInt(i)
	 *		Get an instance that uses the integer i to initialize the first 4 bytes of the key data.
	 *
	 *	@return IYCFKeyHash160 An instance that uses the integer i to initialize the first 4 bytes of the key data.
	 */
	@JSExport
	public static IYCFKeyHash160 YCFKeyHash160_fromInt(int i);

	/**
	 *	IYCFKeyHash160 fromInt(i)
	 *		Get an instance that uses the integer i to initialize the first 4 bytes of the key data.
	 *
	 *	@return IYCFKeyHash160 An instance that uses the integer i to initialize the first 4 bytes of the key data.
	 */
	@JSExport
	public IYCFKeyHash160 fromInt(int i);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_nullGet()
	 *		Get a null instance.
	 *
	 *	@return IYCFKeyHash160 A null instance
	 */
	@JSExport
	public static IYCFKeyHash160 YCFKeyHash160_nullGet();

	/**
	 *	IYCFKeyHash160 nullGet()
	 *		Get a null instance.
	 *
	 *	@return IYCFKeyHash160 A null instance.
	 */
	@JSExport
	public IYCFKeyHash160 nullGet();

	/**
	 *	String YCFKeyHash160_nullString()
	 *		Get a null value string.
	 *
	 *	@return String The null value string.
	 */
	@JSExport
	public static String YCFKeyHash160_nullString();

	/**
	 *	String nullString()
	 *		Get the null value string.
	 *
	 *	@return  String the null value string.
	 */
	@JSExport
	public String nullString();

	/**
	 *	int YCFKeyHash160_getHashLength()
	 *		Get the length of the hash value.
	 *
	 *	@return The length of hashed values (size of the byte arrays.)
	 */
	@JSExport
  	public static int YCFKeyHash160_getHashLength();

	/**
	 *	int getHashLength()
	 *		Get the length of the hash value.
	 *
	 *	@return The length of hashed values (size of the byte arrays.)
	 */
	@JSExport
  	public int getHashLength();

	/**
	 *	int YCFKeyHash160_getHashLengthString()
	 *		Get the length of the hash value string form.
	 *
	 *	@return The length of hashed value strings.
	 */
	@JSExport
  	public static int YCFKeyHash160_getHashLengthString();

	/**
	 *	int getHashLengthString()
	 *		Get the length of the hash value string form.
	 *
	 *	@return The length of hashed value strings.
	 */
	@JSExport
  	public int getHashLengthString();

	/**
	 *	String YCFKeyHash160_getHashAlgo()
	 *		Get the name of the hash algorithm used.
	 *
	 *	@return The name of the hash algorithm used.
	 */
	@JSExport
  	public static String YCFKeyHash160_getHashAlgo();

	/**
	 *	String getHashAlgo()
	 *		Get the name of the hash algorithm used.
	 *
	 *	@return The name of the hash algorithm used.
	 */
	@JSExport
  	public String getHashAlgo();

	/**
	 *	int YCFKeyHash160_compare()
	 *		Compare two instances.
	 *
	 *	@return less than zero if A is less than B, greater than zero if A is greater than B, otherwise zero.
	 */
	@JSExport
  	public static int YCFKeyHash160_compare(IYCFKeyHash160 a, IYCFKeyHash160 b);

	/**
	 *	int compare(b)
	 *		Compare an instance.
	 *
	 *	@return less than zero if this is less than B, greater than zero if this is greater than B, otherwise zero.
	 */
	@JSExport
  	public int compare(IYCFKeyHash160 b);

	/**
	 *	int YCFKeyHash160_compareOrdered()
	 *		Compare two instances.
	 *
	 *	@return less than zero if A is less than B, greater than zero if A is greater than B, otherwise zero.
	 */
	@JSExport
  	public static int YCFKeyHash160_compareOrdered(IYCFKeyHash160 a, IYCFKeyHash160 b);

	/**
	 *	int compareOrdered()
	 *		Compare two instances.
	 *
	 *	@return less than zero if this is less than B, greater than zero if this is greater than B, otherwise zero.
	 */
	@JSExport
  	public int compareOrdered(IYCFKeyHash160 b);

	/**
	 *	void YCFKeyHash160_initStatics()
	 *		Initialize the statics.
	 */
	@JSExport
  	public static void YCFKeyHash160_initStatics();

	/**
	 *	byte[] YCFKeyHash160_sbytesFromHex(s)
	 *		Calculate a hash byte array from a hexadecimal string.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash160_getHashLengthString() characters long.
	 *
	 *	@return A byte array or null if the string s is null.
	 */
	@JSExport
  	public static byte[] YCFKeyHash160_sbytesFromHex(String s);

	/**
	 *	byte[] sbytesFromHex(s)
	 *		Calculate a hash byte array from a hexadecimal string.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash160_getHashLengthString() characters long.
	 *
	 *	@return A byte array or null if the string s is null.
	 */
	@JSExport
  	public byte[] sbytesFromHex(String s);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_fromHex(s)
	 *		Create an instance from a hexadecimal string.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash160_getHashLengthString() characters long.
	 *
	 *	@return An instance or null.
	 */
	@JSExport
  	public static IYCFKeyHash160 YCFKeyHash160_fromHex(String s);

	/**
	 *	IYCFKeyHash160 fromHex(s)
	 *		Create an instance from a hexadecimal string.
	 *
	 *	@param s The string of hexadecimal characters, no more than YCFKeyHash160_getHashLengthString() characters long.
	 *
	 *	@return An instance or null.
	 */
	@JSExport
  	public IYCFKeyHash160 fromHex(String s);

	/**
	 *	Comparator<IYCFKeyHash160> YCFKeyHash160_getComparator()
	 *		Get a Comparator instance for the keys.
	 *
	 *	@return A Comparator for the key instances.
	 */
	@JSExport
	public static Comparator<IYCFKeyHash160> YCFKeyHash160_getComparator();

	/**
	 *	Comparator<IYCFKeyHash160> getComparator()
	 *		Get a Comparator instance for the keys.
	 *
	 *	@return A Comparator for the key instances.
	 */
	@JSExport
	public Comparator<IYCFKeyHash160> getComparator();

	/**
	 *	byte[] YCFKeyHash160_getBytes(k)
	 *		Get the byte array for key value k.
	 *
	 *	@param k The key value to be evaluated.
	 *
	 *	@return The byte array for key value k, or null if k is null.
	 */
	@JSExport
	public static byte[] YCFKeyHash160_getBytes(IYCFKeyHash160 k);

	/**
	 *	byte[] getBytes()
	 *		Get the byte array for this key.
	 *
	 *	@return The byte array for this key.
	 */
	@JSExport
	public byte[] getBytes();

	/**
	 *	void YCFKeyHash160_setBytes(k, a)
	 *		Set the byte array for key value k to a copy of the byte array a. If a is null, set k's key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param k The key value to be updated.
	 *	@param a The byte array to use for the update.  If it is null, then k's key data is set to zeroes.
	 */
	@JSExport
	public static void YCFKeyHash160_setBytes(IYCFKeyHash160 k, byte[] a);

	/**
	 *	void setBytes(a)
	 *		Set the byte array for the key to a copy of the byte array a. If a is null, set the key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param a The byte array to use for the update.  If it is null, then the key data is set to zeroes.
	 */
	@JSExport
	public void setBytes(byte[] a);

	/**
	 *	void YCFKeyHash160_setBytes(k, a, o, l)
	 *		Set the byte array for key value k to a copy of the byte array a starting at the offset o for the length l. If a is null, set k's key data to zeroes.  We want the KeyHash to be immutable so this method shouldn't even exist, but it is necessary for JPA. This is the only code that should use this method.
	 *
	 *	@param k The key value to be updated.
	 *	@param a The byte array to use for the update.  If it is null, then k's key data is set to zeroes.
	 *	@param o The offset into the array a
	 *	@param l The number of bytes to copy from array a
	 */
	@JSExport
	public static void YCFKeyHash160_setBytes(IYCFKeyHash160 k, byte[] a, int o, int l);

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
	 *	boolean YCFKeyHash160_isNull(k)
	 *		Is the key k null valued?
	 *
	 *	@return True if k is null or null valued, otherwise false.
	 */
	@JSExport
  	public static boolean YCFKeyHash160_isNull(IYCFKeyHash160 k);

	/**
	 *	boolean isNull()
	 *		Is this key null valued?
	 *
	 *	@return True if this key is null valued, otherwise false.
	 */
	@JSExport
  	public boolean isNull();

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_hash(s)
	 *		Create an instance by hashing the string s.
	 *
	 *	@param s The string to be hashed.
	 *
	 *	@return An instance or null if s is null.
	 */
	@JSExport
  	public static IYCFKeyHash160 YCFKeyHash160_hash(String s);

	/**
	 *	IYCFKeyHash160 hash(s)
	 *		Create an instance by hashing the string s.
	 *
	 *	@param s The string to be hashed.
	 *
	 *	@return An instance or null if s is null.
	 */
	@JSExport
  	public IYCFKeyHash160 hash(String s);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_hash(a)
	 *		Create an instance by hashing the byte array a.
	 *
	 *	@param a The byte array to be hashed.
	 *
	 *	@return An instance or null if a is null.
	 */
	@JSExport
  	public static IYCFKeyHash160 YCFKeyHash160_hash(byte[] a);

	/**
	 *	IYCFKeyHash160 hash(a)
	 *		Create an instance by hashing the byte array a.
	 *
	 *	@param a The byte array to be hashed.
	 *
	 *	@return An instance or null if a is null.
	 */
	@JSExport
  	public IYCFKeyHash160 hash(byte[] a);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_hash(a...)
	 *		Create an instance by hashing the byte arrays a and ....
	 *
	 *	@param a... The byte arrays to be hashed.
	 *
	 *	@return An instance or null if a is null and no other arrays are specified.
	 */
	@JSExport
  	public static IYCFKeyHash160 YCFKeyHash160_hash(byte[]... a);

	/**
	 *	IYCFKeyHash160 hash(a...)
	 *		Create an instance by hashing the byte arrays a and ....
	 *
	 *	@param a... The byte arrays to be hashed.
	 *
	 *	@return An instance or null if a is null and no other arrays are specified.
	 */
	@JSExport
  	public IYCFKeyHash160 hash(byte[]... a);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_hash(k...)
	 *		Create an instance by hashing the keys k and ....
	 *
	 *	@param k... The keys to be hashed.
	 *
	 *	@return An instance or null if k is null and no other keys are specified.
	 */
	@JSExport
  	public static IYCFKeyHash160 YCFKeyHash160_hash(IYCFKeyHash160... k);

	/**
	 *	IYCFKeyHash160 hash(k...)
	 *		Create an instance by hashing the keys k and ....
	 *
	 *	@param k... The keys to be hashed.
	 *
	 *	@return An instance or null if k is null and no other keys are specified.
	 */
	@JSExport
  	public IYCFKeyHash160 hash(IYCFKeyHash160... k);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_hash(i...)
	 *		Create an instance by hashing the integers i and ....
	 *
	 *	@param k... The integers to be hashed.
	 *
	 *	@return An instance.
	 */
	@JSExport
  	public static IYCFKeyHash160 YCFKeyHash160_hash(int... k);

	/**
	 *	IYCFKeyHash160 hash(i...)
	 *		Create an instance by hashing the integers i and ....
	 *
	 *	@param i... The integers to be hashed.
	 *
	 *	@return An instance.
	 */
	@JSExport
  	public IYCFKeyHash160 hash(int... i);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_hash(a...)
	 *		Create an instance by hashing the integer arrays a and ....
	 *
	 *	@param a... The integer arrays to be hashed.
	 *
	 *	@return An instance, or null if a is null and no other arrays are specified.
	 */
	@JSExport
  	public static IYCFKeyHash160 YCFKeyHash160_hash(int[]... a);

	/**
	 *	IYCFKeyHash160 hash(a...)
	 *		Create an instance by hashing the integer arrays a and ....
	 *
	 *	@param a... The integer arrays to be hashed.
	 *
	 *	@return An instance, or null if a is null and no other arrays are specified.
	 */
	@JSExport
  	public IYCFKeyHash160 hash(int[]... a);

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_deepClone(k)
	 *		Create an instance by deep cloning the key data for k.
	 *
	 *	@param k The key value to clone.
	 *
	 *	@return An instance, or null if k is null.
	 */
	@JSExport
  	public static IYCFKeyHash160 YCFKeyHash160_deepClone(IYCFKeyHash160 k);

	/**
	 *	IYCFKeyHash160 deepClone()
	 *		Create an instance by deep cloning this key's data.
	 *
	 *	@return An instance cloned from this one.
	 */
	@JSExport
  	public IYCFKeyHash160 deepClone();

	/**
	 *	IYCFKeyHash160 YCFKeyHash160_fromHexQuick(s)
	 *		Create an instance by converting String s from hexadecimal.
	 *
	 *	@param s The hexadecimal string to convert.
	 *
	 *	@return An instance, or null if s is null.
	 */
	@JSExport
  	public static IYCFKeyHash160 YCFKeyHash160_fromHexQuick(String s);

	/**
	 *	IYCFKeyHash160 fromHexQuick(s)
	 *		Create an instance by converting String s from hexadecimal.
	 *
	 *	@param s The hexadecimal string to convert.
	 *
	 *	@return An instance, or null if s is null.
	 */
	@JSExport
  	public IYCFKeyHash160 fromHexQuick(String s);

	/**
	 *	IYCFKeyHash160[] YCFKeyHash160_toKeyHashes(a)
	 *		Create an array of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return An array of instances, or null if a was null.
	 */
	@JSExport
  	public static IYCFKeyHash160[] YCFKeyHash160_toKeyHashes(String[] a);

	/**
	 *	IYCFKeyHash160[] toKeyHashes(a)
	 *		Create an array of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return An array of instances, or null if a was null.
	 */
	@JSExport
  	public IYCFKeyHash160[] toKeyHashes(String[] a);

	/**
	 *	List<IYCFKeyHash160> YCFKeyHash160_toKeyHashesList(a)
	 *		Create a list of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return A list of instances, or null if a was null.
	 */
	@JSExport
  	public static List<IYCFKeyHash160> YCFKeyHash160_toKeyHashesList(String[] a);

	/**
	 *	List<IYCFKeyHash160> toKeyHashesList(a)
	 *		Create a list of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return A list of instances, or null if a was null.
	 */
	@JSExport
  	public List<IYCFKeyHash160> toKeyHashesList(String[] a);

	/**
	 *	Set<IYCFKeyHash160> YCFKeyHash160_toKeyHashesSet(a)
	 *		Create a set of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return A set of instances, or null if a was null.
	 */
	@JSExport
  	public static Set<IYCFKeyHash160> YCFKeyHash160_toKeyHashesSet(String[] a);

	/**
	 *	Set<IYCFKeyHash160> toKeyHashesSet(a)
	 *		Create a set of instances from an array of hexadecimal strings.
	 *
	 *	@param a The array of hexadecimal strings to convert.
	 *
	 *	@return A set of instances, or null if a was null.
	 */
	@JSExport
  	public Set<IYCFKeyHash160> toKeyHashesSet(String[] a);
}
