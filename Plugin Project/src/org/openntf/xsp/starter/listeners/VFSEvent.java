package org.openntf.xsp.starter.listeners;

import com.ibm.commons.vfs.VFS;
import com.ibm.commons.vfs.VFSEventAdapter;
import com.paulwithers.bp106.Activator;

public class VFSEvent extends VFSEventAdapter {
	private final static boolean _debug = Activator._debug;
	static {
		if (_debug)
			System.out.println(VFSEvent.class.getName() + " loaded");
	}

	public VFSEvent() {
		if (_debug) {
			System.out.println(getClass().getName() + " created");
		}
	}

	@Override
	public void onBeginRefresh(VFS paramVFS) {
		if (_debug) {
			System.out.println(getClass().getName() + " refresh beginning");
		}
		super.onBeginRefresh(paramVFS);
	}

	@Override
	public void onEndRefresh(VFS paramVFS) {
		super.onEndRefresh(paramVFS);
		if (_debug) {
			System.out.println(getClass().getName() + " refresh completed");
		}
	}

}
