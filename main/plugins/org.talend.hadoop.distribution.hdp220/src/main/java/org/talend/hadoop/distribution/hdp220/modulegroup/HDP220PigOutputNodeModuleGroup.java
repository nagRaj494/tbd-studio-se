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
package org.talend.hadoop.distribution.hdp220.modulegroup;

import java.util.HashSet;
import java.util.Set;

import org.talend.hadoop.distribution.ComponentType;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.condition.BasicExpression;
import org.talend.hadoop.distribution.condition.BooleanOperator;
import org.talend.hadoop.distribution.condition.ComponentCondition;
import org.talend.hadoop.distribution.condition.EqualityOperator;
import org.talend.hadoop.distribution.condition.LinkedNodeExpression;
import org.talend.hadoop.distribution.condition.MultiComponentCondition;
import org.talend.hadoop.distribution.constants.PigOutputConstant;
import org.talend.hadoop.distribution.hdp220.HDP220Constant;
import org.talend.hadoop.distribution.hdp220.HDP220Distribution;

public class HDP220PigOutputNodeModuleGroup {

    private static final ComponentCondition condition = new MultiComponentCondition(
    //
            new LinkedNodeExpression(PigOutputConstant.PIGSTORE_COMPONENT_LINKEDPARAMETER,
                    ComponentType.PIG.getDistributionParameter(), EqualityOperator.EQ, HDP220Distribution.DISTRIBUTION_NAME), //
            BooleanOperator.AND, //
            new LinkedNodeExpression(PigOutputConstant.PIGSTORE_COMPONENT_LINKEDPARAMETER,
                    ComponentType.PIG.getVersionParameter(), EqualityOperator.EQ, HDP220Distribution.VERSION));

    private static final ComponentCondition s3condition = new MultiComponentCondition( //
            new MultiComponentCondition( //
                    condition, //
                    BooleanOperator.AND, //
                    new BasicExpression(PigOutputConstant.PIGSTORE_S3_LOCATION)),//
            BooleanOperator.AND, //
            new MultiComponentCondition( //
                    new BasicExpression(PigOutputConstant.PIGSTORE_STORE, EqualityOperator.NOT_EQ, "HCATSTORER"), //
                    BooleanOperator.AND, //
                    new BasicExpression(PigOutputConstant.PIGSTORE_STORE, EqualityOperator.NOT_EQ, "HBASESTORAGE")));

    public static Set<DistributionModuleGroup> getModuleGroups() {
        Set<DistributionModuleGroup> hs = new HashSet<>();
        hs.add(new DistributionModuleGroup(HDP220Constant.SPARK_S3_MRREQUIRED_MODULE_GROUP.getModuleName(), false, s3condition));
        return hs;
    }

}
