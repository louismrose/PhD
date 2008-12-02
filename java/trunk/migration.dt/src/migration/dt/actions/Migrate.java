/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package migration.dt.actions;

import java.io.File;

import migration.MigrationModule;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.actions.AbstractObjectActionDelegate;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class Migrate extends AbstractObjectActionDelegate implements IObjectActionDelegate {
	
	public void run(IAction action) {
		if (getFirstElementInSelection() instanceof IFile) {
			final IFile file = (IFile)getFirstElementInSelection();
			
			final MigrationModule migrationModule = new MigrationModule(file.getRawLocationURI());
			
			final File migratedHutn = new File(file.getLocation().removeFileExtension().toOSString() + "-migrated.hutn");
			
			try {
				FileUtil.setFileContents(migrationModule.toHutn(migrationModule.suggestMigration()), migratedHutn);
			
			} catch (Exception e) {
				EpsilonConsole.getInstance().getErrorStream().println("Could not save migrated HUTN: " + e.getMessage());
				e.printStackTrace();
			}
			
			try {
				file.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
				
				openFile((IFile)file.getProject().findMember(migratedHutn.getName()));
				
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void openFile(IFile file) throws PartInitException {
		final IWorkbenchPage page    = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
	
		page.openEditor(new FileEditorInput(file), desc.getId());
	}
	
	
//	private void saveSlotModel(Spec spec, String destination) {
//		final Resource resource = EmfUtil.createResource(URI.createFileURI(destination));
//		resource.getContents().add(spec);
//		
//		System.err.println("Saving to: " + destination);
//		
//		final EmfModel model = new InMemoryEmfModel("Intermediate", resource, HutnPackage.eINSTANCE);
//		model.store(destination);
//		model.dispose();
//	}
}
