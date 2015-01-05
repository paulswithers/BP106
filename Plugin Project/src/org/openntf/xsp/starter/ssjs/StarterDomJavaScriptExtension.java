package org.openntf.xsp.starter.ssjs;

import com.ibm.designer.runtime.extensions.JavaScriptProvider;
import com.ibm.jscript.JSContext;

public class StarterDomJavaScriptExtension implements JavaScriptProvider {

	/**
	 * Constructor
	 */
	public StarterDomJavaScriptExtension() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ibm.designer.runtime.extensions.JavaScriptProvider#registerWrappers
	 * (com.ibm.jscript.JSContext)
	 */
	@Override
	public void registerWrappers(final JSContext context) {
		StarterOpenDomino.register(context);
	}
}
