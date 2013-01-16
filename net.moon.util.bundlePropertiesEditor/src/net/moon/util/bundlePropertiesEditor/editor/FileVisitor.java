package net.moon.util.bundlePropertiesEditor.editor;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

public class FileVisitor implements IResourceVisitor {
	private String name;
	private IPath path;

	public FileVisitor(String name) {
		this.name = name;
	}

	@Override
	public boolean visit(IResource resource) throws CoreException {
		if (resource instanceof IFile && resource.getName().equals(name)) {
			path = resource.getProjectRelativePath();
		}
		return resource instanceof IContainer;
	}

	public IPath getPath() {
		return path;
	}

}
