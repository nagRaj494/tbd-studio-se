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
package org.talend.hadoop.distribution.component;


/**
 * Interface that exposes specific HDFS methods.
 *
 */
public interface HDFSComponent extends HadoopComponent {

    /**
     * @return true if the distribution does support the Short type in the SequenceFileFormat.
     */
    public boolean doSupportSequenceFileShortType();
}
