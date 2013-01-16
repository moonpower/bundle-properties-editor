package net.moon.util.bundlePropertiesEditor.editor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import net.moon.util.bundlePropertiesEditor.StringUtil;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Annotation;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Properties;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.PropertiesEditor;
import net.moon.util.bundlePropertiesEditor.model.propertieseditor.Property;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;


public class ReplacePluginFile {
	private static IFile file;

	public ReplacePluginFile(IFile file) {
		this.file = file;
	}

	public void replacePluginFile(String oldValue, String newValue) {
		IProject project = file.getProject();
		IFile pluginFile = project.getFile("plugin.xml");
		try {
			String read = StringUtil.read(pluginFile.getContents(), "UTF-8");
			String replace = read.replace("%" + oldValue, "%" + newValue);
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
					replace.getBytes());

			if (pluginFile.exists()) {
				pluginFile.delete(true, new NullProgressMonitor());
			}
			pluginFile.create(byteArrayInputStream, true,
					new NullProgressMonitor());

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void replaceManifestFile(String oldValue, String newValue) {
		IProject project = file.getProject();
		IFile manifestFile = project.getFile("META-INF/MANIFEST.MF");
		try {
			String read = StringUtil.read(manifestFile.getContents(), "UTF-8");
			String replace = read.replace("%" + oldValue, "%" + newValue);
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
					replace.getBytes());

			if (manifestFile.exists()) {
				manifestFile.delete(true, new NullProgressMonitor());
			}
			manifestFile.create(byteArrayInputStream, true,
					new NullProgressMonitor());

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public static void saveProperties(PropertiesEditor propertiesEditor,
			IFile defaultFile) {
		IProject project = defaultFile.getProject();

		IFile manifestFile = getFile("MANIFEST.MF", project);
		IFile pluginFile = getFile("plugin.xml", project);

		List<IFile> propertyFileList = new ArrayList<IFile>();
		for (Properties each : propertiesEditor.getProperties()) {
			propertyFileList.add(getFile(each.getName(), project));
		}

		String pluginText = getFileText(pluginFile, "UTF-8");

		String manifestText = getFileText(manifestFile, "UTF-8");

		EList<Property> property = propertiesEditor.getProperties().get(0)
				.getProperty();
		for (Property each : property) {

			String newKey = StringUtil.getUnicodeToUnicodeText(each.getKey());
			String oldKey = StringUtil
					.getUnicodeToUnicodeText(each.getOldKey());
			if (manifestText != null) {
				manifestText = manifestText.replace("%" + oldKey, "%" + newKey);
			}
			if (pluginText != null) {
				pluginText = pluginText.replace("%" + oldKey, "%" + newKey);
			}

		}
		if (manifestFile != null) {
			createFile(manifestFile, manifestText);
		}
		if (pluginFile != null) {
			createFile(pluginFile, pluginText);
		}

		for (Properties each : propertiesEditor.getProperties()) {
			IFile eachFile = getFile(each.getName(), project);
			StringBuffer buffer = new StringBuffer();
			for (Annotation eachAnnotation : each.getAnnotation()) {
				buffer.append(eachAnnotation.getContent());
			}
			for (Property eachProperty : each.getProperty()) {
				buffer.append("\r\n");
				buffer.append(eachProperty.getKey() + " = "
						+ eachProperty.getValue());
			}
			createFile(eachFile, buffer.toString());
		}

		refreshModel(propertiesEditor);

	}

	private static void refreshModel(PropertiesEditor properties) {
		for (Properties each : properties.getProperties()) {
			for (Property eachProperty : each.getProperty()) {
				eachProperty.setOldKey(eachProperty.getKey());
				eachProperty.setOldValue(eachProperty.getValue());
			}
		}
	}

	private static void createFile(IFile file, String text) {
		ByteArrayInputStream pluginBIS = null;
		try {
			if (file.getName().equals("plugin.xml")
					|| file.getName().equals("MANIFEST.MF")) {
				pluginBIS = new ByteArrayInputStream(text.getBytes("UTF-8"));
			}
			else {
				pluginBIS = new ByteArrayInputStream(
						text.getBytes("ISO-8859-1"));

			}

		}
		catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		try {
			if (file.exists()) {
				file.delete(true, new NullProgressMonitor());
			}

			file.create(pluginBIS, true, new NullProgressMonitor());
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public static IFile getFile(final String name, IProject project) {
		FileVisitor visitor = new FileVisitor(name);
		try {
			project.accept(visitor);
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
		IPath path = visitor.getPath();
		if (path == null) {
			return null;
		}
		file = project.getFile(path);

		return file;
	}

	/**
	 * 
	 * @param bundleFile
	 * @param encoding
	 * @param path
	 *            null 또는 워크스페이스 경로
	 * @return
	 */
	private static String getFileText(IFile file, String encoding) {

		String read = null;
		if (file == null) {
			return null;
		}
		try {
			read = StringUtil.read(file.getContents(), encoding);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
		return read;
	}

	public void replaceDefaultPropertiesFile(String oldValue, String newValue) {

		IFile propertiesFile = file;
		try {
			String read = StringUtil.read(propertiesFile.getContents());
			String replace = read.replace(oldValue,
					new String(newValue.getBytes(), "ISO-8859-1"));
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
					replace.getBytes());

			if (propertiesFile.exists()) {
				propertiesFile.delete(true, new NullProgressMonitor());
			}
			propertiesFile.create(byteArrayInputStream, true,
					new NullProgressMonitor());

		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void replaceNLPropertiesFile(String oldValue, String newValue) {

		IProject project = file.getProject();

		final List<IPath> list = new ArrayList<IPath>();
		try {
			project.accept(new IResourceVisitor() {

				@Override
				public boolean visit(IResource resource) throws CoreException {

					if (resource.getName().startsWith("bundle_")
							&& resource instanceof IFile) {
						list.add(resource.getProjectRelativePath());
						return true;
					}
					return resource instanceof IContainer;
				}
			});
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
		for (IPath path : list) {
			IFile propertiesFile = project.getFile(path);

			try {
				String read = StringUtil.read(propertiesFile.getContents(),
						"ISO-8859-1");
				String replace = read.replace(oldValue, newValue);
				ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(
						replace.getBytes());

				if (propertiesFile.exists()) {
					propertiesFile.delete(true, new NullProgressMonitor());
				}
				propertiesFile.create(byteArrayInputStream, true,
						new NullProgressMonitor());

			}
			catch (IOException e) {
				e.printStackTrace();
			}
			catch (CoreException e) {
				e.printStackTrace();
			}

		}
	}
}
