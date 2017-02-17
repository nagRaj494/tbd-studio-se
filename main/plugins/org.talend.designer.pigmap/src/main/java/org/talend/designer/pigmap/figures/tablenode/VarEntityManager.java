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
package org.talend.designer.pigmap.figures.tablenode;

import org.talend.designer.gefabstractmap.figures.manager.TableEntityManager;
import org.talend.designer.pigmap.model.emf.pigmap.VarNode;
import org.talend.designer.pigmap.model.emf.pigmap.VarTable;
import org.talend.designer.pigmap.parts.PigMapVarNodeEditPart;

/**
 * DOC hcyi class global comment. Detailled comment
 */
public class VarEntityManager extends TableEntityManager {

    public VarEntityManager(VarNode entityModel, PigMapVarNodeEditPart entityPart) {
        super(entityModel, entityPart);
    }

    @Override
    public VarNode getModel() {
        return (VarNode) super.getModel();
    }

    @Override
    public VarTable getMapperTable() {
        return (VarTable) super.getMapperTable();
    }

    @Override
    public boolean isTableMinimized() {
        return getMapperTable().isMinimized();
    }

}
