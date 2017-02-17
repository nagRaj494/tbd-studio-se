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
package org.talend.designer.pigmap.dnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.talend.designer.gefabstractmap.dnd.MapperDragSourceListener;
import org.talend.designer.gefabstractmap.dnd.TransferdType;
import org.talend.designer.gefabstractmap.dnd.TransferedObject;
import org.talend.designer.gefabstractmap.figures.sash.ISash;
import org.talend.designer.gefabstractmap.part.MapperTablePart;
import org.talend.designer.gefabstractmap.part.TableEntityPart;
import org.talend.designer.gefabstractmap.utils.MapperUtils;
import org.talend.designer.pigmap.parts.PigMapTableNodePart;
import org.talend.designer.pigmap.parts.PigMapVarNodeEditPart;

/**
 * 
 * DOC hcyi class global comment. Detailled comment
 */
public class PigDragSourceListener extends MapperDragSourceListener {

    public PigDragSourceListener(EditPartViewer viewer) {
        super(viewer);
    }

    @Override
    protected Object getTemplate(DragSourceEvent event) {
        final RootEditPart rootEditPart = getViewer().getRootEditPart();
        if (rootEditPart instanceof AbstractGraphicalEditPart) {
            AbstractGraphicalEditPart graphicPart = (AbstractGraphicalEditPart) rootEditPart;
            final IFigure figure = graphicPart.getFigure();
            final IFigure findFigureAt = figure.findFigureAt(new Point(event.x, event.y));
            if (findFigureAt instanceof ISash) {
                return findFigureAt;
            }
        }
        List<EditPart> filtedSelection = new ArrayList<EditPart>();
        for (Object part : getViewer().getSelectedEditParts()) {
            if (part instanceof PigMapTableNodePart || part instanceof PigMapVarNodeEditPart) {
                filtedSelection.add((EditPart) part);
            }
        }

        if (filtedSelection == null || filtedSelection.isEmpty()) {
            return null;
        }
        List toTransfer = new ArrayList();
        TransferdType type = null;
        List<TableEntityPart> partList = new ArrayList<TableEntityPart>();
        EditPart lastSelection = filtedSelection.get(filtedSelection.size() - 1);
        if (lastSelection instanceof PigMapTableNodePart) {
            type = TransferdType.INPUT;
        } else if (lastSelection instanceof PigMapVarNodeEditPart) {
            type = TransferdType.VAR;
        }

        if (type != null) {
            if (filtedSelection.size() > 1) {
                partList.addAll(lastSelection.getParent().getChildren());
                Map<EditPart, Integer> partAndIndex = new HashMap<EditPart, Integer>();
                if (type == TransferdType.INPUT) {
                    MapperTablePart abstractInOutTablePart = MapperUtils.getMapperTablePart((TableEntityPart) lastSelection);
                    if (abstractInOutTablePart != null) {
                        partList = MapperUtils.getFlatChildrenPartList(abstractInOutTablePart);
                    }
                } else {
                    partList.addAll(lastSelection.getParent().getChildren());
                }

                for (EditPart selected : filtedSelection) {
                    int indexOf = partList.indexOf(selected);
                    if (indexOf != -1) {
                        partAndIndex.put(selected, indexOf);
                        int index = 0;
                        for (int i = 0; i < toTransfer.size(); i++) {
                            if (indexOf > partAndIndex.get(toTransfer.get(i))) {
                                index = i + 1;
                            }
                        }
                        toTransfer.add(index, selected);
                    }
                }

            } else {
                toTransfer.add(lastSelection);
            }
            return new TransferedObject(toTransfer, type);
        }
        return null;
    }
}
