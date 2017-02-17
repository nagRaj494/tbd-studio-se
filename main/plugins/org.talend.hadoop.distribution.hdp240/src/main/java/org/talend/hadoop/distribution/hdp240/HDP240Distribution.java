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

package org.talend.hadoop.distribution.hdp240;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.talend.hadoop.distribution.AbstractDistribution;
import org.talend.hadoop.distribution.ComponentType;
import org.talend.hadoop.distribution.DistributionModuleGroup;
import org.talend.hadoop.distribution.EHadoopVersion;
import org.talend.hadoop.distribution.ESparkVersion;
import org.talend.hadoop.distribution.NodeComponentTypeBean;
import org.talend.hadoop.distribution.component.HBaseComponent;
import org.talend.hadoop.distribution.component.HCatalogComponent;
import org.talend.hadoop.distribution.component.HDFSComponent;
import org.talend.hadoop.distribution.component.HiveComponent;
import org.talend.hadoop.distribution.component.HiveOnSparkComponent;
import org.talend.hadoop.distribution.component.MRComponent;
import org.talend.hadoop.distribution.component.PigComponent;
import org.talend.hadoop.distribution.component.SparkBatchComponent;
import org.talend.hadoop.distribution.component.SparkStreamingComponent;
import org.talend.hadoop.distribution.component.SqoopComponent;
import org.talend.hadoop.distribution.condition.ComponentCondition;
import org.talend.hadoop.distribution.constants.MRConstant;
import org.talend.hadoop.distribution.constants.PigOutputConstant;
import org.talend.hadoop.distribution.constants.SparkBatchConstant;
import org.talend.hadoop.distribution.constants.SparkStreamingConstant;
import org.talend.hadoop.distribution.constants.hdp.IHortonworksDistribution;
import org.talend.hadoop.distribution.hdp240.modulegroup.HDP240HBaseModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.HDP240HCatalogModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.HDP240HDFSModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.HDP240HiveModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.HDP240HiveOnSparkModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.HDP240MapReduceModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.HDP240PigModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.HDP240PigOutputModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.HDP240SparkBatchModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.HDP240SparkStreamingModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.HDP240SqoopModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.node.mr.HDP240MRS3NodeModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.node.pigoutput.HDP240PigOutputNodeModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.node.sparkbatch.HDP240GraphFramesNodeModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.node.sparkbatch.HDP240SparkBatchParquetNodeModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.node.sparkbatch.HDP240SparkBatchS3NodeModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.node.sparkstreaming.HDP240SparkStreamingFlumeNodeModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.node.sparkstreaming.HDP240SparkStreamingKafkaAssemblyModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.node.sparkstreaming.HDP240SparkStreamingKafkaAvroModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.node.sparkstreaming.HDP240SparkStreamingKafkaClientModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.node.sparkstreaming.HDP240SparkStreamingKinesisNodeModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.node.sparkstreaming.HDP240SparkStreamingParquetNodeModuleGroup;
import org.talend.hadoop.distribution.hdp240.modulegroup.node.sparkstreaming.HDP240SparkStreamingS3NodeModuleGroup;

public class HDP240Distribution extends AbstractDistribution implements HDFSComponent, MRComponent, HBaseComponent, PigComponent,
        HiveComponent, HCatalogComponent, SparkBatchComponent, SparkStreamingComponent, HiveOnSparkComponent, SqoopComponent,
        IHortonworksDistribution {

    public static final String VERSION_DISPLAY = "Hortonworks Data Platform V2.4.0"; //$NON-NLS-1$

    public final static String VERSION = "HDP_2_4"; //$NON-NLS-1$

    private final static String YARN_APPLICATION_CLASSPATH = "$HADOOP_CONF_DIR,/usr/hdp/current/hadoop-client/*,/usr/hdp/current/hadoop-client/lib/*,/usr/hdp/current/hadoop-hdfs-client/*,/usr/hdp/current/hadoop-hdfs-client/lib/*,/usr/hdp/current/hadoop-mapreduce-client/*,/usr/hdp/current/hadoop-mapreduce-client/lib/*,/usr/hdp/current/hadoop-yarn-client/*,/usr/hdp/current/hadoop-yarn-client/lib/*"; //$NON-NLS-1$

    private final static String CUSTOM_MR_APPLICATION_CLASSPATH = "$PWD/mr-framework/hadoop/share/hadoop/mapreduce/*:$PWD/mr-framework/hadoop/share/hadoop/mapreduce/lib/*:$PWD/mr-framework/hadoop/share/hadoop/common/*:$PWD/mr-framework/hadoop/share/hadoop/common/lib/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/*:$PWD/mr-framework/hadoop/share/hadoop/yarn/lib/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/*:$PWD/mr-framework/hadoop/share/hadoop/hdfs/lib/*:/etc/hadoop/conf/secure"; //$NON-NLS-1$

    private static Map<ComponentType, Set<DistributionModuleGroup>> moduleGroups;

    private static Map<NodeComponentTypeBean, Set<DistributionModuleGroup>> nodeModuleGroups;

    private static Map<ComponentType, ComponentCondition> displayConditions;

    static {

        // Used to add a module group import for the components that have a HADOOP_DISTRIBUTION parameter, aka. the
        // components that have the distribution list.
        moduleGroups = new HashMap<>();
        moduleGroups.put(ComponentType.HDFS, HDP240HDFSModuleGroup.getModuleGroups());
        moduleGroups.put(ComponentType.HBASE, HDP240HBaseModuleGroup.getModuleGroups());
        moduleGroups.put(ComponentType.HCATALOG, HDP240HCatalogModuleGroup.getModuleGroups());
        moduleGroups.put(ComponentType.MAPREDUCE, HDP240MapReduceModuleGroup.getModuleGroups());
        moduleGroups.put(ComponentType.PIG, HDP240PigModuleGroup.getModuleGroups());
        moduleGroups.put(ComponentType.PIGOUTPUT, HDP240PigOutputModuleGroup.getModuleGroups());
        moduleGroups.put(ComponentType.SQOOP, HDP240SqoopModuleGroup.getModuleGroups());
        moduleGroups.put(ComponentType.HIVE, HDP240HiveModuleGroup.getModuleGroups());
        moduleGroups.put(ComponentType.SPARKBATCH, HDP240SparkBatchModuleGroup.getModuleGroups());
        moduleGroups.put(ComponentType.SPARKSTREAMING, HDP240SparkStreamingModuleGroup.getModuleGroups());
        moduleGroups.put(ComponentType.HIVEONSPARK, HDP240HiveOnSparkModuleGroup.getModuleGroups());

        // Used to add a module group import for a specific node. The given node must have a HADOOP_LIBRARIES parameter.
        nodeModuleGroups = new HashMap<>();

        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.MAPREDUCE, MRConstant.S3_INPUT_COMPONENT),
                HDP240MRS3NodeModuleGroup.getModuleGroups());
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.MAPREDUCE, MRConstant.S3_OUTPUT_COMPONENT),
                HDP240MRS3NodeModuleGroup.getModuleGroups());
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.PIG, PigOutputConstant.PIGSTORE_COMPONENT),
                HDP240PigOutputNodeModuleGroup.getModuleGroups());

        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.SPARKBATCH, SparkBatchConstant.PARQUET_INPUT_COMPONENT),
                HDP240SparkBatchParquetNodeModuleGroup.getModuleGroups());
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.SPARKBATCH, SparkBatchConstant.PARQUET_OUTPUT_COMPONENT),
                HDP240SparkBatchParquetNodeModuleGroup.getModuleGroups());
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.SPARKBATCH, SparkBatchConstant.S3_CONFIGURATION_COMPONENT),
                HDP240SparkBatchS3NodeModuleGroup.getModuleGroups());
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.SPARKBATCH, SparkBatchConstant.MATCH_PREDICT_COMPONENT), 
                HDP240GraphFramesNodeModuleGroup.getModuleGroups());
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.SPARKSTREAMING,
                SparkStreamingConstant.PARQUET_INPUT_COMPONENT), HDP240SparkStreamingParquetNodeModuleGroup.getModuleGroups());
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.SPARKSTREAMING,
                SparkStreamingConstant.PARQUET_OUTPUT_COMPONENT), HDP240SparkStreamingParquetNodeModuleGroup.getModuleGroups());
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.SPARKSTREAMING,
                SparkStreamingConstant.PARQUET_STREAM_INPUT_COMPONENT), HDP240SparkStreamingParquetNodeModuleGroup
                .getModuleGroups());
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.SPARKSTREAMING,
                SparkStreamingConstant.S3_CONFIGURATION_COMPONENT), HDP240SparkStreamingS3NodeModuleGroup.getModuleGroups());

        Set<DistributionModuleGroup> kinesisNodeModuleGroups = HDP240SparkStreamingKinesisNodeModuleGroup.getModuleGroups();
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.SPARKSTREAMING,
                SparkStreamingConstant.KINESIS_INPUT_COMPONENT), kinesisNodeModuleGroups);
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.SPARKSTREAMING,
                SparkStreamingConstant.KINESIS_INPUT_AVRO_COMPONENT), kinesisNodeModuleGroups);
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.SPARKSTREAMING,
                SparkStreamingConstant.KINESIS_OUTPUT_COMPONENT), kinesisNodeModuleGroups);

        Set<DistributionModuleGroup> kafkaAssemblyModuleGroups = HDP240SparkStreamingKafkaAssemblyModuleGroup.getModuleGroups();
        Set<DistributionModuleGroup> kafkaAvroModuleGroups = HDP240SparkStreamingKafkaAvroModuleGroup.getModuleGroups();
        nodeModuleGroups.put(
                new NodeComponentTypeBean(ComponentType.SPARKSTREAMING, SparkStreamingConstant.KAFKA_INPUT_COMPONENT),
                kafkaAssemblyModuleGroups);
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.SPARKSTREAMING,
                SparkStreamingConstant.KAFKA_AVRO_INPUT_COMPONENT), kafkaAvroModuleGroups);
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.SPARKSTREAMING,
                SparkStreamingConstant.KAFKA_OUTPUT_COMPONENT), HDP240SparkStreamingKafkaClientModuleGroup.getModuleGroups());

        Set<DistributionModuleGroup> flumeNodeModuleGroups = HDP240SparkStreamingFlumeNodeModuleGroup.getModuleGroups();
        nodeModuleGroups.put(
                new NodeComponentTypeBean(ComponentType.SPARKSTREAMING, SparkStreamingConstant.FLUME_INPUT_COMPONENT),
                flumeNodeModuleGroups);
        nodeModuleGroups.put(new NodeComponentTypeBean(ComponentType.SPARKSTREAMING,
                SparkStreamingConstant.FLUME_OUTPUT_COMPONENT), flumeNodeModuleGroups);

        // Used to hide the distribution according to other parameters in the component.
        displayConditions = new HashMap<>();
    }

    @Override
    public String getDistribution() {
        return DISTRIBUTION_NAME;
    }

    @Override
    public String getDistributionName() {
        return DISTRIBUTION_DISPLAY_NAME;
    }

    @Override
    public String getVersion() {
        return VERSION;
    }

    @Override
    public String getVersionName(ComponentType componentType) {
        return VERSION_DISPLAY;
    }

    @Override
    public EHadoopVersion getHadoopVersion() {
        return EHadoopVersion.HADOOP_2;
    }

    @Override
    public boolean doSupportKerberos() {
        return true;
    }

    @Override
    public Set<DistributionModuleGroup> getModuleGroups(ComponentType componentType) {
        return moduleGroups.get(componentType);
    }

    @Override
    public Set<DistributionModuleGroup> getModuleGroups(ComponentType componentType, String componentName) {
        return nodeModuleGroups.get(new NodeComponentTypeBean(componentType, componentName));
    }

    @Override
    public ComponentCondition getDisplayCondition(ComponentType componentType) {
        return displayConditions.get(componentType);
    }

    @Override
    public boolean doSupportCrossPlatformSubmission() {
        return true;
    }

    @Override
    public boolean doSupportUseDatanodeHostname() {
        return true;
    }

    @Override
    public boolean doSupportSequenceFileShortType() {
        return true;
    }

    @Override
    public String getYarnApplicationClasspath() {
        return YARN_APPLICATION_CLASSPATH;
    }

    @Override
    public boolean doSupportNewHBaseAPI() {
        return true;
    }

    @Override
    public boolean doSupportHCatalog() {
        return true;
    }

    @Override
    public boolean pigVersionPriorTo_0_12() {
        return false;
    }

    @Override
    public boolean doSupportHBase() {
        return true;
    }

    @Override
    public boolean doSupportImpersonation() {
        return true;
    }

    @Override
    public boolean doSupportEmbeddedMode() {
        return false;
    }

    @Override
    public boolean doSupportStandaloneMode() {
        return true;
    }

    @Override
    public boolean doSupportHive1() {
        return false;
    }

    @Override
    public boolean doSupportHive2() {
        return true;
    }

    @Override
    public boolean doSupportTezForHive() {
        return true;
    }

    @Override
    public boolean doSupportTezForPig() {
        return true;
    }

    @Override
    public boolean doSupportHBaseForHive() {
        return true;
    }

    @Override
    public boolean doSupportSSL() {
        return true;
    }

    @Override
    public boolean doSupportORCFormat() {
        return true;
    }

    @Override
    public boolean doSupportAvroFormat() {
        return true;
    }

    @Override
    public boolean doSupportParquetFormat() {
        return true;
    }

    @Override
    public boolean doSupportStoreAsParquet() {
        return true;
    }

    @Override
    public ESparkVersion getSparkVersion() {
        return ESparkVersion.SPARK_1_6;
    }

    @Override
    public boolean doSupportDynamicMemoryAllocation() {
        return true;
    }

    @Override
    public boolean isExecutedThroughSparkJobServer() {
        return false;
    }

    @Override
    public boolean doSupportCheckpointing() {
        return true;
    }

    @Override
    public boolean doSupportSparkStandaloneMode() {
        return false;
    }

    @Override
    public boolean doSupportSparkYarnClientMode() {
        return true;
    }

    @Override
    public boolean doSupportOldImportMode() {
        return false;
    }

    @Override
    public boolean doJavaAPISupportStorePasswordInFile() {
        return true;
    }

    @Override
    public boolean doJavaAPISqoopImportSupportDeleteTargetDir() {
        return true;
    }

    @Override
    public boolean doJavaAPISqoopImportAllTablesSupportExcludeTable() {
        return true;
    }

    @Override
    public boolean doSupportClouderaNavigator() {
        return false;
    }

    @Override
    public boolean doSupportBackpressure() {
        return true;
    }

    @Override
    public boolean doSupportCustomMRApplicationCP() {
        return true;
    }

    @Override
    public String getCustomMRApplicationCP() {
        return CUSTOM_MR_APPLICATION_CLASSPATH;
    }

    @Override
    public boolean doSupportS3() {
        return true;
    }

    @Override
    public boolean doSupportS3V4() {
        return true;
    }

    @Override
    public boolean doSupportAtlas() {
        return true;
    }

    @Override
    public boolean doSupportParquetOutput() {
        return true;
    }

    @Override
    public boolean doSupportHDFSEncryption() {
        return true;
    }
}
