package net.moon.util.bundlePropertiesEditor.editor;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;

public class PropertiesRelativeFile {

	private IFile pluginFile;
	private IFile manifestFile;
	private List<IFile> list;
	private IFile file;

	public PropertiesRelativeFile(IFile file) {
		this.file = file;
	}

	public List<IFile> loadRelativeLanguageFile() {
		IProject project = file.getProject();

		String fileFullName = file.getName();
		int indexOf = fileFullName.indexOf('.');
		final String fileName = fileFullName.substring(0, indexOf);

		list = getLagnuageFileList(file, fileName, project);

		return list;

	}

	public IFile loadRelativeDefaultFile() {
		IProject project = file.getProject();

		String fileFullName = file.getName();
		int indexOf = fileFullName.indexOf("_");
		String fileName = fileFullName.substring(0, indexOf);
		fileName += ".properties";
		IFile defaultFile = getFile(fileName, project);

		return defaultFile;

	}

	public IFile loadPluginFile() {
		IProject project = file.getProject();

		pluginFile = project.getFile("plugin.xml");
		try {
			pluginFile.refreshLocal(IFile.DEPTH_ONE, new NullProgressMonitor());
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
		return pluginFile;
	}

	public IFile loadManifestFile() {
		IProject project = file.getProject();

		manifestFile = project.getFile("META-INF/MANIFEST.MF");
		try {
			manifestFile.refreshLocal(IFile.DEPTH_ONE,
					new NullProgressMonitor());
		}
		catch (CoreException e) {
			e.printStackTrace();
		}
		return manifestFile;

	}

	/**
	 * 디폴트 파일 저장.
	 * 
	 * @param text
	 */
	public void savePropertiesFile(String text) {
		if (file == null || text == null) {
			return;
		}
		try {
			ByteArrayInputStream in = null;
			in = new ByteArrayInputStream(text.getBytes("ISO-8859-1"));

			file.setContents(in, true, true, new NullProgressMonitor());
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 프로퍼티 파일 저장. charset ISO-8859-1
	 * 
	 * @param file
	 * @param text
	 */
	public void savePropertiesFile(IFile file, String text) {
		if (file == null || text == null) {
			return;
		}
		try {
			ByteArrayInputStream in = null;
			in = new ByteArrayInputStream(text.getBytes("ISO-8859-1"));

			file.setContents(in, true, true, new NullProgressMonitor());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * plugin.xml 저장. charset UTF-8
	 * 
	 * @param text
	 */
	public void savePluginFile(String text) {
		if (pluginFile == null) {
			return;
		}
		try {
			ByteArrayInputStream in = null;
			in = new ByteArrayInputStream(text.getBytes("UTF-8"));

			pluginFile.setContents(in, true, true, new NullProgressMonitor());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * MANIFEST.MF 저장. charset UTF-8
	 * 
	 * @param text
	 */
	public void saveManifestFile(String text) {
		if (manifestFile == null) {
			return;
		}
		try {
			ByteArrayInputStream in = null;
			in = new ByteArrayInputStream(text.getBytes("UTF-8"));

			pluginFile.setContents(in, true, true, new NullProgressMonitor());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<IFile> getLagnuageFileList(IFile file, final String fileName,
			IProject project) {
		final List<IPath> list = new ArrayList<IPath>();
		IPath removeLastSegments = file.getFullPath().removeLastSegments(1);
		IFolder folder = project.getFolder(removeLastSegments
				.removeFirstSegments(1));
		try {
			folder.refreshLocal(IFolder.DEPTH_ONE, new NullProgressMonitor());
		}
		catch (CoreException e1) {
			e1.printStackTrace();
		}
		try {
			folder.accept(new IResourceVisitor() {

				@Override
				public boolean visit(IResource resource) throws CoreException {

					if (resource.getName().startsWith(fileName + "_")
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
		if (list.size() == 0 || list == null) {
			return null;
		}
		List<IFile> fileList = new ArrayList<IFile>();
		for (IPath eachPath : list) {
			IFile eachPathFile = project.getFile(eachPath);
			fileList.add(eachPathFile);
		}
		return fileList;
	}

	private IFile getFile(final String name, IProject project) {
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
		IFile file = project.getFile(path);

		return file;
	}
}
