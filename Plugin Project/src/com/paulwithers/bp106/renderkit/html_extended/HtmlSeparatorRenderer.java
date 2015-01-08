package com.paulwithers.bp106.renderkit.html_extended;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import com.paulwithers.bp106.components.HtmlSeparator;

public class HtmlSeparatorRenderer extends Renderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		System.out.println("Starting encode begin");
		super.encodeBegin(context, component);
		if (component instanceof HtmlSeparator) {
			HtmlSeparator separator = (HtmlSeparator) component;

			ResponseWriter rw = context.getResponseWriter();
			if ("New Line".equals(separator.getSeparatorType())) {
				for (int i = 0; i < separator.getCount(); i++) {
					rw.startElement("br", separator);
					rw.endElement("br");
				}
			} else if ("Space".equals(separator.getSeparatorType())) {
				for (int i = 0; i < separator.getCount(); i++) {
					rw.write("&#160;");
				}
			}
		}
	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		super.encodeEnd(context, component);
	}

}
