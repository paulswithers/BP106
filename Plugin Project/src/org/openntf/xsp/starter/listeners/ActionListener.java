package org.openntf.xsp.starter.listeners;

import com.paulwithers.bp106.Activator;
import com.sun.faces.application.ActionListenerImpl;

public class ActionListener extends ActionListenerImpl {
	private final static boolean _debug = Activator._debug;
	static {
		if (_debug)
			System.out.println(ActionListener.class.getName() + " loaded");
	}

	public ActionListener() {
		if (_debug) {
			System.out.println(getClass().getName() + " created");
		}
	}

}
