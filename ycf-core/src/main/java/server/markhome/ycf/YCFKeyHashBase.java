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
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Base class for YCF database key hashes.
 *
 * This foundation class provides essential support for n-digit hashes, usually based on the sizes of commmon hash algorithms like SHA-256, SHA-512, etc. It
 * includes methods for byte manipulation, comparison, and static initialization of hash buffers. It is designed to be extended by specific hash
 * implementations, such as YCFKeyHash256 or YCFKeyHash512. It also provides a consistent way to handle the underlying byte arrays, ensuring that all
 * derived classes can be compared and manipulated uniformly. One issue is that the base class may provide the "gateway" for synchronization of the hash buffer
 * attributes, so the static class data defined here is used as the thread synchronization coordinator, rather than attributes of the specialization classes. To
 * be fair, whether is even an issue really depends on what the JDK and JVM fine-print processing rules say about such specific cases.
 *
 * @author msobkow
 */
public abstract class YCFKeyHashBase<T extends YCFKeyHashBase<T>> implements Comparator<T>, Comparable<T> {

	static final String hexDigits = "0123456789abcdef";
	static final int UUID6_INDEX = 0;
	static final int UUID6_LENGTH = YCFUuid6.TOTAL_BYTES;
	static final int COUNTER_INDEX = 28;
	static final int COUNTER_LENGTH = 8;
	static final int CLUSTERCODE_INDEX = 36;
	static final int CLUSTERCODE_LENGTH = 8;
	static final int PID_INDEX = 44;
	static final int PID_LENGTH = 8;
	static final int THREAD_INDEX = 52;
	static final int THREAD_LENGTH = 8;
	static final int HEADER_BYTES = 60;
	static final int RANDBYTES_INDEX = HEADER_BYTES;
	static final int RANDBYTES_LENGTH = 8;
	static final int TOTAL_BYTES = HEADER_BYTES + RANDBYTES_LENGTH;
	static final int CONCURRENT_DIGESTS = Runtime.getRuntime().availableProcessors() * 2;
	static ByteBuffer[] hashBuffer = null;
	static volatile int rotator = 0;
	static volatile long counter = 1;

	public abstract byte[] getBytes();

	public abstract void setBytes(byte[] bytes);

	public abstract void setBytes(byte[] newBytes, int offset, int length);

	public void initStatics() {
		if (hashBuffer != null) {
			return;
		}
		try {
			hashBuffer = new ByteBuffer[CONCURRENT_DIGESTS];
			YCFHostAddr.initAddrHeader();
			long pid = ProcessHandle.current().pid();
			long tid = Thread.currentThread().getId();
			for (int i = 0; i < CONCURRENT_DIGESTS; i++) {
				YCFUuid6 u = YCFUuid6.generateUuid6();
				hashBuffer[i] = ByteBuffer.allocate(TOTAL_BYTES);
				byte[] uub = u.getBytes();
				for (int j = 0; j < YCFUuid6.TOTAL_BYTES; j++) {
					hashBuffer[i].put(uub[j]);
				}
				hashBuffer[i].putLong(COUNTER_INDEX, counter);
				hashBuffer[i].putLong(CLUSTERCODE_INDEX, 1);
				hashBuffer[i].putLong(PID_INDEX, pid);
				hashBuffer[i].putLong(THREAD_INDEX, tid);
				hashBuffer[i].putLong(RANDBYTES_INDEX, 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public byte[] bytesFromHex(String string) {
		if (string == null) {
			// allowed
		} else if (string.length() > getHashLength() * 2) {
			throw new IllegalArgumentException("string length is " + string.length() + ".  Must be <= " + getHashLength() * 2 + ".  string is '" + string + "'.");
		}
		byte[] b = new byte[getHashLength()];
		if (string == null) {
			return b;
		}

		int n = string.length();
		for (int i = 0; i < n - 1; i += 2) {
			b[i / 2] = (byte) ((Character.digit(string.charAt(i), 16) << 4) + Character.digit(string.charAt(i + 1), 16));
		}
		return b;
	}

	@Override
	public int hashCode() {
		int result = 0;
		byte[] b = getBytes();
		for (int i = 3; i >= 0; i--) {
			//result = (result << 8) | id16[i];
			result = (result << 8) | (0xFF & ((int) b[i]));
		}
		return result;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object aTest) {
		if (aTest == null) {
			return false;
		}
		if (aTest == this) {
			return true;
		}
		if (aTest.getClass() != getClass()) {
			return false;
		}
		T test = (T) aTest;
		return Arrays.equals(this.getBytes(), test.getBytes());
	}

	public int reduceToInt() {
		return hashCode();
	}

	public boolean isNull() {
		byte[] b = getBytes();
		if (b != null) {
			for (int i = 0; i < getHashLength(); i++) {
				if (b[i] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public void toString(StringBuilder sb) {
		// Construct and return the representive hex string
		byte[] b = getBytes();
		if (b == null) {
			for (int i = 0; i < getHashLength(); i++) {
				sb.append('0');
				sb.append('0');
			}
		} else {
			for (int i = 0; i < getHashLength(); i++) {
				sb.append(hexDigits.charAt((b[i] & 0xF0) >>> 4));
				sb.append(hexDigits.charAt(b[i] & 0x0F));
			}
		}
	}

	@Override
	public String toString() {
		byte[] b = getBytes();
		if (b == null) {
			return "null";
		}
		StringBuilder sb = new StringBuilder(b.length * 2);
		for (int i = 0; i < getHashLength(); i++) {
			sb.append(hexDigits.charAt((b[i] & 0xF0) >>> 4));
			sb.append(hexDigits.charAt(b[i] & 0x0F));
		}
		return sb.toString();
	}

	@Override
	public int compare(T h1, T h2) {
		if (h1 == null) {
			if (h2 == null) {
				return 0;
			} else {
				return 1;
			}
		} else {
			if (h2 == null) {
				return -1;
			} else {
				byte[] b1 = h1.getBytes();
				byte[] b2 = h2.getBytes();
				if (b1 == null) {
					if (b2 == null) {
						return 0;
					} else {
						return 1;
					}
				} else {
					if (b2 == null) {
						return -1;
					} else {
						for (int i = 0; i < h1.getHashLength(); i++) {
							int v1 = b1[i];
							int v2 = b2[i];
							if (v1 < 0) {
								v1 += 256;
							}
							if (v2 < 0) {
								v2 += 256;
							}
							int c = v1 - v2;
							if (c != 0) {
								return c;
							}
						}
					}
				}
			}
		}
		return 0;
	}

	@Override
	@SuppressWarnings("unchecked")
	public int compareTo(T o) {
		int result = compare((T) this, o);
		return result;
	}

	public abstract T deepClone();

	public abstract int getHashLength();

	public abstract String getHashAlgo();

	protected abstract MessageDigest[] getM();

	public YCFKeyHashBase() {
	}

	/**
	 * This is the hex code of the underlying ID. THIS IS NOT A HASHING FUNCTION.
	 */
	public YCFKeyHashBase(String hexId) {
		setBytes(bytesFromHex(hexId));
	}

	public YCFKeyHashBase(byte[] anId) {
		if (anId == null) {
			// allowed
		} else if (anId.length > getHashLength()) {
			throw new IllegalArgumentException("anId length must be <= " + getHashLength() + ".");
		}
		setBytes(new byte[getHashLength()]);
		if (anId != null) {
			System.arraycopy(anId, 0, getBytes(), 0, Math.min(anId.length, getHashLength()));
		}
	}

	public YCFKeyHashBase(T otherKey) {
		if (otherKey == null) {
			setBytes(new byte[getHashLength()]);
			return;
		}
		byte[] _newId = new byte[getHashLength()];
		System.arraycopy(otherKey.getBytes(), 0, _newId, 0, getHashLength());
		setBytes(_newId);
	}

	public YCFKeyHashBase(int notUsed) {
		initStatics();
		int thid = (int) (Math.abs(rotator++) % CONCURRENT_DIGESTS);
		synchronized (hashBuffer[thid]) {
			while (true) {
				counter++;
				hashBuffer[thid].putLong(COUNTER_INDEX, counter);
				hashBuffer[thid].putLong(THREAD_INDEX, Thread.currentThread().getId());
				hashBuffer[thid].putLong(RANDBYTES_INDEX, (long) (Math.random() * Long.MAX_VALUE));
				getM()[thid].update(hashBuffer[thid].array(), 0, TOTAL_BYTES);

				setBytes(getM()[thid].digest());

				// we want to reserve the bottom 32 bits of the counter for incremental temporary indexing so we regenerate entries that have the top 12 bytes as 0's */
				byte[] b = getBytes();
				for (int i = 4; i < getHashLength(); i++) {
					if (b[i] != 0) {
						return;
					}
				}
			}
		}
	}
}
