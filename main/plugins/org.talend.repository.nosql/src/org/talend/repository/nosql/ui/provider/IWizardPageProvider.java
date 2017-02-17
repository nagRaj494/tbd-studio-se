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
package org.talend.repository.nosql.ui.provider;

import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.widgets.Composite;
import org.talend.core.model.metadata.builder.connection.MetadataTable;
import org.talend.core.model.properties.ConnectionItem;
import org.talend.repository.model.nosql.NoSQLConnection;
import org.talend.repository.nosql.exceptions.NoSQLExtractSchemaException;
import org.talend.repository.nosql.model.INoSQLSchemaNode;
import org.talend.repository.nosql.ui.common.AbstractNoSQLConnForm;
import org.talend.repository.nosql.ui.common.AbstractNoSQLRetrieveSchemaForm;
import org.talend.repository.nosql.ui.common.AbstractNoSQLSchemaForm;

/**
 * created by ycbai on 2014-6-12 Detailled comment
 * 
 */
public interface IWizardPageProvider {

    public AbstractNoSQLConnForm createConnectionForm(Composite parent, ConnectionItem connectionItem, String[] existingNames,
            boolean creation, WizardPage parentWizardPage);

    public AbstractNoSQLRetrieveSchemaForm createRetrieveSchemaForm(Composite parent, ConnectionItem connectionItem,
            boolean creation, WizardPage parentWizardPage);

    public AbstractNoSQLSchemaForm createSchemaForm(Composite parent, ConnectionItem connectionItem, MetadataTable metadataTable,
            boolean creation, WizardPage parentWizardPage);

    public List<INoSQLSchemaNode> createSchemaNodes(NoSQLConnection connection) throws NoSQLExtractSchemaException;

}
