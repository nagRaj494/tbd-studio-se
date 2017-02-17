// ============================================================================
//
// Copyright (C) 2006-2015 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.hadoop.distribution.cdh550.test.modulegroup;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.cdh550.CDH550Constant;
import org.talend.hadoop.distribution.cdh550.modulegroup.CDH550PigModuleGroup;

public class CDH550PigModuleGroupTest {

    @Test
    public void testModuleGroups() throws Exception {
        Map<String, String> results = new HashMap<String, String>();
        results.put(CDH550Constant.PIG_MODULE_GROUP.getModuleName(), null);
        results.put(CDH550Constant.HDFS_MODULE_GROUP.getModuleName(), null);
        results.put(CDH550Constant.MAPREDUCE_MODULE_GROUP.getModuleName(), null);
        results.put(CDH550Constant.PIG_HCATALOG_MODULE_GROUP.getModuleName(), "(LOAD=='HCATLOADER')");
        results.put(CDH550Constant.HBASE_MODULE_GROUP.getModuleName(), "(LOAD=='HBASESTORAGE')");
        results.put(CDH550Constant.PIG_HBASE_MODULE_GROUP.getModuleName(), "(LOAD=='HBASESTORAGE')");
        results.put(CDH550Constant.PIG_PARQUET_MODULE_GROUP.getModuleName(), "(LOAD=='PARQUETLOADER')");
        results.put(CDH550Constant.PIG_AVRO_MODULE_GROUP.getModuleName(), "(LOAD=='AVROSTORAGE')");
        results.put(CDH550Constant.PIG_RCFILE_MODULE_GROUP.getModuleName(), "(LOAD=='RCFILEPIGSTORAGE')");
        results.put(CDH550Constant.PIG_SEQUENCEFILE_MODULE_GROUP.getModuleName(), "(LOAD=='SEQUENCEFILELOADER')");
        results.put(CDH550Constant.PIG_S3_MODULE_GROUP.getModuleName(), "(S3_LOCATION_LOAD=='true')");

        Set<DistributionModuleGroup> moduleGroups = CDH550PigModuleGroup.getModuleGroups();
        assertEquals(11, moduleGroups.size());
        moduleGroups.iterator();
        for (DistributionModuleGroup module : moduleGroups) {
            assertTrue("Should contain module " + module.getModuleName(), results.containsKey(module.getModuleName()));
            if (results.get(module.getModuleName()) == null) {
                assertTrue("The condition of the module " + module.getModuleName() + " is not null.",
                        results.get(module.getModuleName()) == null);
            } else {
                assertTrue(
                        "The condition of the module " + module.getModuleName() + " is null, but it should be "
                                + results.get(module.getModuleName()) + ".", results.get(module.getModuleName()) != null);
                assertEquals(results.get(module.getModuleName()), module.getRequiredIf().getConditionString());
            }
        }
    }
}
