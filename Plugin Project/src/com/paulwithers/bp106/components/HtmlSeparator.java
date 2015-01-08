package com.paulwithers.bp106.components;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import com.ibm.xsp.component.UIOutputEx;

public class HtmlSeparator extends UIOutputEx {
	public static final String COMPONENT_TYPE = "com.paulwithers.bp106.HtmlSeparator";
	public static final String RENDERER_TYPE = "com.paulwithers.bp106.HtmlSeparator";
	private String separatorType;
	private int count = 1;

	public HtmlSeparator() {
		super();
		System.out.println("Creating HTML Separator");
		System.err.println(getFamily() + " - required for faces-config.xml mapping");
		setRendererType(RENDERER_TYPE);
	}

	public String getSeparatorType() {
		if (separatorType != null) {
			return separatorType;
		}
		ValueBinding vb = getValueBinding("separatorType");
		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		} else {
			return null;
		}
	}

	public void setSeparatorType(String type) {
		this.separatorType = type;
	}

	public int getCount() {
		// Check if there's a ValueBinding and run that
		ValueBinding vb = getValueBinding("count");
		if (vb != null) {
			Object result = vb.getValue(getFacesContext());
			if (result == null) {
				setCount(1);
			} else {
				setCount(((Number) result).intValue());
			}
		}
		if (count != Integer.MIN_VALUE) {
			return count;
		} else {
			return 1;
		}
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public void restoreState(FacesContext context, Object state) {
		Object[] properties = (Object[]) state;
		int idx = 0;
		super.restoreState(context, properties[idx++]);
		this.separatorType = ((String) properties[idx++]);
		this.count = ((Integer) properties[idx++]);
	}

	@Override
	public Object saveState(FacesContext context) {
		Object[] properties = new Object[3];
		int idx = 0;
		properties[idx++] = super.saveState(context);
		properties[idx++] = this.separatorType;
		properties[idx++] = this.count;
		return properties;
	}

}
