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

import java.util.Set;

import org.talend.hadoop.distribution.ComponentType;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.EHadoopVersion;
import org.talend.hadoop.distribution.condition.ComponentCondition;

/**
 * Base interface that exposes generic methods for all Hadoop components (eg. HDFS, M/R, Pig).
 *
 */
public interface HadoopComponent {

    /**
     * @return the name of the distribution.
     */
    public String getDistribution();

    /**
     * @return the display name of the distribution.
     */
    public String getDistributionName();

    /**
     * @return the name of the version.
     */
    public String getVersion();

    /**
     * @param componentType - the {@link ComponentType} for which we want to retrieve the version name.
     * @return the display name of the version.
     */
    public String getVersionName(ComponentType componentType);

    /**
     * A distribution can be using Hadoop 1 or Hadoop 2. This method returns the used Hadoop version.
     * 
     * @return the @link{EHadoopVersion} of the distribution.
     */
    public EHadoopVersion getHadoopVersion();

    /**
     * @return true if the distribution uses @link{EHadoopVersion} HADOOP_2.
     */
    public boolean isHadoop2();

    /**
     * @return true if the distribution uses @link{EHadoopVersion} HADOOP_1.
     */
    public boolean isHadoop1();

    /**
     * @return a boolean that indicates if the distribution supports Kerberos.
     */
    public boolean doSupportKerberos();

    /**
     * @return a boolean that indicates if the distribution supports MapR Ticket.
     */
    public boolean doSupportMapRTicket();

    /**
     * The method getMapRCredentialsViaPassword from maprfs-x.x-mapr.jar By v52 we mean the follwoing signature :
     * getMapRCredentialsViaPassword(STRING, STRING, STRING, LONG, STRING)
     * 
     * @return
     */
    public boolean doSupportMaprTicketV52API();

    /**
     * @return a boolean that indicates if the distribution supports the USE_DATANODE_HOSTNAME property.
     */
    public boolean doSupportUseDatanodeHostname();

    /**
     * @return a boolean that indicates if the distribution supports the Group information to build the
     * UserGroupInformation object.
     */
    public boolean doSupportGroup();

    /**
     * @param componentType - the {@link ComponentType} for which we want to retrieve the module groups.
     * @return a Set of {@link DistributionModuleGroup} describing the module group.
     */
    public Set<DistributionModuleGroup> getModuleGroups(ComponentType componentType);

    /**
     * @param componentType - the {@link ComponentType} for which we want to retrieve the module groups.
     * @param componentName - the component name in which to import module groups.
     * @return a Set of {@link DistributionModuleGroup} describing the module group.
     */
    public Set<DistributionModuleGroup> getModuleGroups(ComponentType componentType, String componentName);

    /**
     * @param componentType - the {@link ComponentType} for which we want to retrieve the display conditions.
     * @return a {@link ComponentCondition} defining the condition that makes a distribution visible or not.
     */

    public ComponentCondition getDisplayCondition(ComponentType componentType);

    /**
     * Technical method that tags the new distribution that uses only the new import mode. The goal is to avoid the
     * 'automatic' import for conditions that are true for not yet exisiting distributions. For example, there are some
     * conditions that return 'true' if the distribution is 'CLOUDERA', which is true for the new CDH coming versions.
     * We now want each single distribution to be totally autonomous and to be responsible for its own dependencies.
     * 
     * @return true if the distribution doesn't use the legacy imports in the java XML files.
     */
    public boolean doSupportOldImportMode();

    /**
     * Define whether a distribution supports S3 or not.
     * 
     * @return true if the distribution supports S3.
     */
    public boolean doSupportS3();

    /**
     * @return true if the Hadoop version support S3 API in version 4. It will be used by spark s3 configuration in
     * order to set the region. The V4 API is supported only since hadoop version 2.7.
     */
    public boolean doSupportS3V4();

    /**
     * Get the default configurations for different distributions.
     */
    public String getDefaultConfig(String... keys);

    /**
     *
     * @return true if the distribution supports HDFS encryption which is supported on Hadoop >= 2.6.0.
     */
    public boolean doSupportHDFSEncryption();
}
