package org.openntf.xsp.starter.servlet;

import com.ibm.xsp.webapp.DesignerFacesServlet;
import com.paulwithers.bp106.Activator;

public class StarterServlet extends DesignerFacesServlet {
	private final static boolean _debug = Activator._debug;
	static {
		if (_debug)
			System.out.println(StarterServlet.class.getName() + " loaded");
	}

	public StarterServlet() {
		if (_debug) {
			System.out.println(getClass().getName() + " created");
		}
	}

}
