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
package org.talend.hadoop.distribution.mapr310.test;

import org.junit.Test;
import org.talend.hadoop.distribution.component.HadoopComponent;
import org.talend.hadoop.distribution.mapr310.MapR310Distribution;
import org.talend.hadoop.distribution.test.hive.AbstractVersionTest4HiveMetadataHelper;

/**
 * DOC ggu class global comment. Detailled comment
 */
public class MapR310HiveMetadataHelperTest extends AbstractVersionTest4HiveMetadataHelper {

    @Override
    protected Class<? extends HadoopComponent> getHadoopComponentClass() {
        return MapR310Distribution.class;
    }

    @Test
    public void testHiveMode_MapR310_WitAll() {
        doTestGetHiveModesDisplay(getDistributionVersion(), HIVE_MODE_DISPLAY_ALL);
    }

    @Test
    public void testHiveServer_MapR310_WithAll() {
        doTestGetHiveServersDisplay(getDistributionVersion(), HIVE_SERVER_DISPLAY_ALL);
    }
}
