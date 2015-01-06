package org.iconuk;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.StandardToStringStyle;

import com.ibm.xsp.extlib.util.ExtLibUtil;
import com.paulwithers.bp106.DemoUtils;

public class Utils {

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

	public static void dumpUserBeanNSF() {
		ArrayList<DemoObject> people = new ArrayList<DemoObject>();
		people.add(new DemoObject("Paul", "Withers", "Reading", 41));
		people.add(new DemoObject("John", "Doe", "London", 28));
		String details = "";
		for (DemoObject person : people) {
			details = details + ReflectionToStringBuilder.toString(person) + "<br/>";
		}
		ExtLibUtil.getViewScope().put("dumpValue", details);
	}

	public static void dumpUserBeanNSFPrivileged() {
		ArrayList<DemoObject> people = new ArrayList<DemoObject>();
		people.add(new DemoObject("Paul", "Withers", "Reading", 41));
		people.add(new DemoObject("John", "Doe", "London", 28));
		String details = "";
		for (DemoObject person : people) {
			details = details + convertObjectToString(person) + "<br/>";
		}
		ExtLibUtil.getViewScope().put("dumpValue", details);
	}

	public static void dumpUserBeanPluginBasic() {
		ArrayList<DemoObject> people = new ArrayList<DemoObject>();
		people.add(new DemoObject("Paul", "Withers", "Reading", 41));
		people.add(new DemoObject("John", "Doe", "London", 28));
		String details = "";
		for (DemoObject person : people) {
			details = details + DemoUtils.convertObjectToString(person) + "<br/>";
		}
		ExtLibUtil.getViewScope().put("dumpValue", details);
	}

	public static void dumpUserBeanPluginStyled() {
		StandardToStringStyle style = new StandardToStringStyle();
		style.setFieldSeparator("</span><br/><span style=\"color:red;font-weight:bold\">");
		style.setContentStart("<br/><span style=\"color:red;font-weight:bold\">");
		style.setContentEnd("</span><br/>");
		style.setFieldNameValueSeparator("</span><span> - ");
		ArrayList<DemoObject> people = new ArrayList<DemoObject>();
		people.add(new DemoObject("Paul", "Withers", "Reading", 41));
		people.add(new DemoObject("John", "Doe", "London", 28));
		String details = "";
		for (DemoObject person : people) {
			details = details + DemoUtils.convertObjectToString(person, style) + "<br/>";
		}
		ExtLibUtil.getViewScope().put("dumpValue", details);
	}

}
