package net.moon.util.bundlePropertiesEditor;

import java.io.IOException;
import java.io.StringReader;

import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Annotation;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.impl.PropertieseditorFactoryImpl;

public class BundlePropertiesParser {
	private static final int NORMAL_STATE = 1;
	private static final int KEY_STATE = 2;
	private static final int VALUE_STATE = 3;
	private static final int ANNOTATION_STATE = 5;
	private String fileName;

	public BundlePropertiesParser(String fileName) {
		this.fileName = fileName;
	}

	public Properties parse(String str) {
		int CURRENT_STATE = NORMAL_STATE;
		StringReader reader = new StringReader(str);
		StringBuffer buffer = new StringBuffer();
		Property property = null;
		Properties properties = PropertieseditorFactoryImpl.eINSTANCE
				.createProperties();

		try {
			int ch = -1;
			while ((ch = reader.read()) != -1) {
				Character c = (char) ch;
				switch (CURRENT_STATE) {
				case NORMAL_STATE:
					if (c == '=') {
						CURRENT_STATE = VALUE_STATE;
						break;
					}
					if (c == '#') {
						CURRENT_STATE = ANNOTATION_STATE;
						buffer.append(c);
						break;
					}
					if (!(c == '\r' || c == '\n' || c == ' ' || c == '\t')) {
						CURRENT_STATE = KEY_STATE;
						buffer.append(c);
					}
					break;
				case ANNOTATION_STATE:
					if (c == '\r' || c == '\n') {
						CURRENT_STATE = NORMAL_STATE;
						Annotation annotation = PropertieseditorFactoryImpl.eINSTANCE
								.createAnnotation();
						annotation.setContent(buffer.toString());
						properties.getAnnotation().add(annotation);
						buffer = new StringBuffer();
					}
					else {
						buffer.append(c);
					}
					break;
				case KEY_STATE:
					if (c == '=') {
						CURRENT_STATE = VALUE_STATE;
						property = PropertieseditorFactoryImpl.eINSTANCE
								.createProperty();
						String key = buffer.toString();
						property.setKey(key.trim());
						property.setOldKey(key.trim());
						buffer = new StringBuffer();

					}
					else {
						buffer.append(c);
					}
					break;
				case VALUE_STATE:
					if (c == '\r' || c == '\n') {
						CURRENT_STATE = NORMAL_STATE;
						String value = buffer.toString();
						property.setValue(value.trim());
						property.setOldValue(value.trim());
						properties.getProperty().add(property);
						buffer = new StringBuffer();

					}
					else {
						buffer.append(c);
					}
					break;
				}
			}
			if (CURRENT_STATE == VALUE_STATE && buffer.length() != 0) {
				String value = buffer.toString();
				property.setValue(value.trim());
				property.setOldValue(value.trim());
				properties.getProperty().add(property);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
}
