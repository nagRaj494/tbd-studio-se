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
package org.talend.repository.nosql.ui.node;

import org.talend.commons.ui.runtime.image.ECoreImage;
import org.talend.commons.ui.runtime.image.IImage;
import org.talend.repository.model.RepositoryNode;
import org.talend.repository.model.StableRepositoryNode;

/**
 * 
 * created by ycbai on 2014-4-14 Detailled comment
 * 
 */
public class NoSQLFolderRepositoryNode extends StableRepositoryNode {

    public NoSQLFolderRepositoryNode(RepositoryNode parent, String label) {
        this(parent, label, ECoreImage.FOLDER_CLOSE_ICON);
    }

    public NoSQLFolderRepositoryNode(RepositoryNode parent, String label, IImage icon) {
        super(parent, label, icon);
    }

}
