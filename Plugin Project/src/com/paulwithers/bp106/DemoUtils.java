/*
 * © Copyright GBS Inc 2011
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package com.paulwithers.bp106;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DemoUtils {

	public static String convertObjectToString(final Object o) {
		String retVal_ = "";
		try {
			retVal_ = AccessController.doPrivileged(new PrivilegedExceptionAction<String>() {
				public String run() throws Exception {
					return ReflectionToStringBuilder.toString(o);
				}
			});
		} catch (AccessControlException e) {
			e.printStackTrace();
		} catch (PrivilegedActionException e) {
			e.printStackTrace();
		}
		return retVal_;
	}

	public static String convertObjectToString(final Object o, final ToStringStyle style) {
		String retVal_ = "";
		try {
			retVal_ = AccessController.doPrivileged(new PrivilegedExceptionAction<String>() {
				public String run() throws Exception {
					return ReflectionToStringBuilder.toString(o, style);
				}
			});
		} catch (AccessControlException e) {
			e.printStackTrace();
		} catch (PrivilegedActionException e) {
			e.printStackTrace();
		}
		return retVal_;
	}
}
