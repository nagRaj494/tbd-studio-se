// ============================================================================
//
// Copyright (C) 2006-2016 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.oozie.scheduler.actions;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;
import org.talend.designer.core.ui.AbstractMultiPageTalendEditor;

/**
 * Save the job if it is refered by a tRunJob. <br/>
 * 
 * 2007-07-16 17:06:40
 * 
 */
public class SaveJobBeforeRunAction extends Action {

    private IProcess activeProcess;

    /**
     * SaveJobBeforeRunAction constructor comment.
     * 
     * @param activeProcess
     */
    public SaveJobBeforeRunAction(IProcess activeProcess) {
        this.activeProcess = activeProcess;
    }

    public void run() {
        List<? extends INode> nodes = activeProcess.getGraphicalNodes();

        if (nodes.isEmpty()) {
            return;
        }
        IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
              .getActiveEditor();
        
     
        if (part!=null && part instanceof AbstractMultiPageTalendEditor) {
            AbstractMultiPageTalendEditor editor = (AbstractMultiPageTalendEditor) part;
            editor.doSave(new NullProgressMonitor());
        }
    }
}
