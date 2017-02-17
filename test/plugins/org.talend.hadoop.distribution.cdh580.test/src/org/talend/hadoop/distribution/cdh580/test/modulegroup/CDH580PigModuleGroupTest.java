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
package org.talend.hadoop.distribution.cdh580.test.modulegroup;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.cdh580.CDH580Constant;
import org.talend.hadoop.distribution.cdh580.modulegroup.CDH580PigModuleGroup;

public class CDH580PigModuleGroupTest {

    @Test
    public void testModuleGroups() throws Exception {
        Map<String, String> results = new HashMap<>();
        results.put(CDH580Constant.PIG_MODULE_GROUP.getModuleName(), null);
        results.put(CDH580Constant.HDFS_MODULE_GROUP.getModuleName(), null);
        results.put(CDH580Constant.MAPREDUCE_MODULE_GROUP.getModuleName(), null);
        results.put(CDH580Constant.PIG_HCATALOG_MODULE_GROUP.getModuleName(), "(LOAD=='HCATLOADER')"); //$NON-NLS-1$
        results.put(CDH580Constant.HBASE_MODULE_GROUP.getModuleName(), "(LOAD=='HBASESTORAGE')"); //$NON-NLS-1$
        results.put(CDH580Constant.PIG_HBASE_MODULE_GROUP.getModuleName(), "(LOAD=='HBASESTORAGE')"); //$NON-NLS-1$
        results.put(CDH580Constant.PIG_PARQUET_MODULE_GROUP.getModuleName(), "(LOAD=='PARQUETLOADER')"); //$NON-NLS-1$
        results.put(CDH580Constant.PIG_AVRO_MODULE_GROUP.getModuleName(), "(LOAD=='AVROSTORAGE')"); //$NON-NLS-1$
        results.put(CDH580Constant.PIG_RCFILE_MODULE_GROUP.getModuleName(), "(LOAD=='RCFILEPIGSTORAGE')"); //$NON-NLS-1$
        results.put(CDH580Constant.PIG_SEQUENCEFILE_MODULE_GROUP.getModuleName(), "(LOAD=='SEQUENCEFILELOADER')"); //$NON-NLS-1$
        results.put(CDH580Constant.PIG_S3_MODULE_GROUP.getModuleName(), "(S3_LOCATION_LOAD=='true')"); //$NON-NLS-1$

        Set<DistributionModuleGroup> moduleGroups = CDH580PigModuleGroup.getModuleGroups();
        assertEquals(11, moduleGroups.size());
        moduleGroups.iterator();
        for (DistributionModuleGroup module : moduleGroups) {
            assertTrue("Should contain module " + module.getModuleName(), results.containsKey(module.getModuleName())); //$NON-NLS-1$
            if (results.get(module.getModuleName()) == null) {
                assertTrue("The condition of the module " + module.getModuleName() + " is not null.", //$NON-NLS-1$ //$NON-NLS-2$
                        results.get(module.getModuleName()) == null);
            } else {
                assertTrue("The condition of the module " + module.getModuleName() + " is null, but it should be " //$NON-NLS-1$ //$NON-NLS-2$
                        + results.get(module.getModuleName()) + ".", results.get(module.getModuleName()) != null); //$NON-NLS-1$
                assertEquals(results.get(module.getModuleName()), module.getRequiredIf().getConditionString());
            }
        }
    }
}
