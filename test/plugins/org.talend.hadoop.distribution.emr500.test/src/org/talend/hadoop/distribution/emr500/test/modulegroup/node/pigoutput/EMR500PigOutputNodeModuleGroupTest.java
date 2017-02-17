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
package org.talend.hadoop.distribution.emr500.test.modulegroup.node.pigoutput;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.emr500.EMR500Distribution;
import org.talend.hadoop.distribution.emr500.modulegroup.EMR500PigModuleGroup;
import org.talend.hadoop.distribution.emr500.modulegroup.node.pigoutput.EMR500PigOutputNodeModuleGroup;

public class EMR500PigOutputNodeModuleGroupTest {

    @Test
    public void testModuleGroups() throws Exception {
        Map<String, String> results = new HashMap<>();

        results.put(EMR500PigModuleGroup.PIG_PARQUET_GROUP_NAME,
                "(#LINK@NODE.ASSOCIATED_PIG_LOAD.DISTRIBUTION=='AMAZON_EMR') AND (#LINK@NODE.ASSOCIATED_PIG_LOAD.PIG_VERSION=='EMR_5_0_0')"); //$NON-NLS-1$
        results.put(EMR500PigModuleGroup.PIG_S3_GROUP_NAME,
                "(#LINK@NODE.ASSOCIATED_PIG_LOAD.DISTRIBUTION=='AMAZON_EMR') AND (#LINK@NODE.ASSOCIATED_PIG_LOAD.PIG_VERSION=='EMR_5_0_0') " //$NON-NLS-1$
                        + "AND (S3_LOCATION=='true') AND ((STORE!='HBASESTORAGE'))"); //$NON-NLS-1$

        Set<DistributionModuleGroup> moduleGroups = EMR500PigOutputNodeModuleGroup.getModuleGroups(
                EMR500Distribution.DISTRIBUTION_NAME, EMR500Distribution.VERSION);
        assertEquals(results.size(), moduleGroups.size());
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
