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
package org.talend.hadoop.distribution.hdp210.test;

import org.junit.Test;
import org.talend.core.hadoop.EHadoopCategory;
import org.talend.core.model.metadata.connection.hive.HiveModeInfo;
import org.talend.core.model.metadata.connection.hive.HiveServerVersionInfo;
import org.talend.hadoop.distribution.component.HadoopComponent;
import org.talend.hadoop.distribution.hdp210.HDP210Distribution;
import org.talend.hadoop.distribution.test.classloader.AbstractTest4ClassLoaderProvider;

/**
 * DOC ggu class global comment. Detailled comment
 */
public class HDP210ClassLoaderTest extends AbstractTest4ClassLoaderProvider {

    @Override
    protected Class<? extends HadoopComponent> getHadoopComponentClass() {
        return HDP210Distribution.class;
    }

    @Test
    public void testHive1Standalone() {
        String libsStr = "avro-1.5.4.jar;hadoop-auth-2.4.0.2.1.1.0-385.jar;hadoop-common-2.4.0.2.1.1.0-385.jar;hadoop-hdfs-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-common-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-core-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-jobclient-2.4.0.2.1.1.0-385.jar;hadoop-yarn-api-2.4.0.2.1.1.0-385.jar;hadoop-yarn-client-2.4.0.2.1.1.0-385.jar;hadoop-yarn-common-2.4.0.2.1.1.0-385.jar;hive-jdbc-0.13.0.2.1.1.0-385.jar;hive-exec-0.13.0.2.1.1.0-385.jar;hive-common-0.13.0.2.1.1.0-385.jar;hive-metastore-0.13.0.2.1.1.0-385.jar;hive-service-0.13.0.2.1.1.0-385.jar;hive-hbase-handler-0.13.0.2.1.1.0-385.jar;commons-logging-1.1.1.jar;commons-cli-1.2.jar;commons-codec-1.4.jar;commons-collections-3.2.1.jar;commons-configuration-1.6.jar;commons-lang-2.6.jar;datanucleus-api-jdo-3.2.6.jar;datanucleus-core-3.2.10.jar;datanucleus-rdbms-3.2.9.jar;derby-10.4.2.0.jar;jdo-api-3.0.1.jar;libfb303-0.9.0.jar;libthrift-0.9.0.jar;servlet-api-2.5-20081211.jar;snappy-java-1.0.5.jar;zookeeper-3.4.5.2.1.1.0-385.jar;httpcore-4.2.5.jar;httpclient-4.2.5.jar;hbase-server-0.98.0.2.1.1.0-385-hadoop2.jar;hbase-common-0.98.0.2.1.1.0-385-hadoop2.jar;hbase-client-0.98.0.2.1.1.0-385-hadoop2.jar;hbase-protocol-0.98.0.2.1.1.0-385-hadoop2.jar;htrace-core-2.04.jar;guava-12.0.1.jar;protobuf-java-2.5.0.jar;log4j-1.2.17.jar;slf4j-api-1.7.5.jar;slf4j-log4j12-1.7.5.jar;jackson-mapper-asl-1.8.8.jar;jackson-core-asl-1.8.8.jar;netty-3.6.6.Final.jar;antlr-runtime-3.4.jar;";
        doTestHiveServerWithMode(HiveServerVersionInfo.HIVE_SERVER_1, HiveModeInfo.STANDALONE, libsStr);
    }

    @Test
    public void testHive1Embedded() {
        String libsStr = "avro-1.5.4.jar;hadoop-auth-2.4.0.2.1.1.0-385.jar;hadoop-common-2.4.0.2.1.1.0-385.jar;hadoop-hdfs-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-common-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-core-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-jobclient-2.4.0.2.1.1.0-385.jar;hadoop-yarn-api-2.4.0.2.1.1.0-385.jar;hadoop-yarn-client-2.4.0.2.1.1.0-385.jar;hadoop-yarn-common-2.4.0.2.1.1.0-385.jar;hive-jdbc-0.13.0.2.1.1.0-385.jar;hive-exec-0.13.0.2.1.1.0-385.jar;hive-common-0.13.0.2.1.1.0-385.jar;hive-metastore-0.13.0.2.1.1.0-385.jar;hive-service-0.13.0.2.1.1.0-385.jar;hive-hbase-handler-0.13.0.2.1.1.0-385.jar;commons-logging-1.1.1.jar;commons-cli-1.2.jar;commons-codec-1.4.jar;commons-collections-3.2.1.jar;commons-configuration-1.6.jar;commons-lang-2.6.jar;datanucleus-api-jdo-3.2.6.jar;datanucleus-core-3.2.10.jar;datanucleus-rdbms-3.2.9.jar;derby-10.4.2.0.jar;jdo-api-3.0.1.jar;libfb303-0.9.0.jar;libthrift-0.9.0.jar;servlet-api-2.5-20081211.jar;snappy-java-1.0.5.jar;zookeeper-3.4.5.2.1.1.0-385.jar;httpcore-4.2.5.jar;httpclient-4.2.5.jar;hbase-server-0.98.0.2.1.1.0-385-hadoop2.jar;hbase-common-0.98.0.2.1.1.0-385-hadoop2.jar;hbase-client-0.98.0.2.1.1.0-385-hadoop2.jar;hbase-protocol-0.98.0.2.1.1.0-385-hadoop2.jar;htrace-core-2.04.jar;guava-12.0.1.jar;protobuf-java-2.5.0.jar;log4j-1.2.17.jar;slf4j-api-1.7.5.jar;slf4j-log4j12-1.7.5.jar;jackson-mapper-asl-1.8.8.jar;jackson-core-asl-1.8.8.jar;netty-3.6.6.Final.jar;antlr-runtime-3.4.jar;";
        doTestHiveServerWithMode(HiveServerVersionInfo.HIVE_SERVER_1, HiveModeInfo.EMBEDDED, libsStr);
    }

    @Test
    public void testHive2Standalone() {
        String libsStr = "avro-1.5.4.jar;hadoop-auth-2.4.0.2.1.1.0-385.jar;hadoop-common-2.4.0.2.1.1.0-385.jar;hadoop-hdfs-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-common-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-core-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-jobclient-2.4.0.2.1.1.0-385.jar;hadoop-yarn-api-2.4.0.2.1.1.0-385.jar;hadoop-yarn-client-2.4.0.2.1.1.0-385.jar;hadoop-yarn-common-2.4.0.2.1.1.0-385.jar;hive-jdbc-0.13.0.2.1.1.0-385.jar;hive-exec-0.13.0.2.1.1.0-385.jar;hive-common-0.13.0.2.1.1.0-385.jar;hive-metastore-0.13.0.2.1.1.0-385.jar;hive-service-0.13.0.2.1.1.0-385.jar;hive-hbase-handler-0.13.0.2.1.1.0-385.jar;commons-logging-1.1.1.jar;commons-cli-1.2.jar;commons-codec-1.4.jar;commons-collections-3.2.1.jar;commons-configuration-1.6.jar;commons-lang-2.6.jar;datanucleus-api-jdo-3.2.6.jar;datanucleus-core-3.2.10.jar;datanucleus-rdbms-3.2.9.jar;derby-10.4.2.0.jar;jdo-api-3.0.1.jar;libfb303-0.9.0.jar;libthrift-0.9.0.jar;servlet-api-2.5-20081211.jar;snappy-java-1.0.5.jar;zookeeper-3.4.5.2.1.1.0-385.jar;httpcore-4.2.5.jar;httpclient-4.2.5.jar;hbase-server-0.98.0.2.1.1.0-385-hadoop2.jar;hbase-common-0.98.0.2.1.1.0-385-hadoop2.jar;hbase-client-0.98.0.2.1.1.0-385-hadoop2.jar;hbase-protocol-0.98.0.2.1.1.0-385-hadoop2.jar;htrace-core-2.04.jar;guava-12.0.1.jar;protobuf-java-2.5.0.jar;log4j-1.2.17.jar;slf4j-api-1.7.5.jar;slf4j-log4j12-1.7.5.jar;jackson-mapper-asl-1.8.8.jar;jackson-core-asl-1.8.8.jar;netty-3.6.6.Final.jar;antlr-runtime-3.4.jar;";
        doTestHiveServerWithMode(HiveServerVersionInfo.HIVE_SERVER_2, HiveModeInfo.STANDALONE, libsStr);
    }

    @Test
    public void testHive2Embedded() {
        String libsStr = "avro-1.5.4.jar;hadoop-auth-2.4.0.2.1.1.0-385.jar;hadoop-common-2.4.0.2.1.1.0-385.jar;hadoop-hdfs-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-common-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-core-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-jobclient-2.4.0.2.1.1.0-385.jar;hadoop-yarn-api-2.4.0.2.1.1.0-385.jar;hadoop-yarn-client-2.4.0.2.1.1.0-385.jar;hadoop-yarn-common-2.4.0.2.1.1.0-385.jar;hive-jdbc-0.13.0.2.1.1.0-385.jar;hive-exec-0.13.0.2.1.1.0-385.jar;hive-common-0.13.0.2.1.1.0-385.jar;hive-metastore-0.13.0.2.1.1.0-385.jar;hive-service-0.13.0.2.1.1.0-385.jar;hive-hbase-handler-0.13.0.2.1.1.0-385.jar;commons-logging-1.1.1.jar;commons-cli-1.2.jar;commons-codec-1.4.jar;commons-collections-3.2.1.jar;commons-configuration-1.6.jar;commons-lang-2.6.jar;datanucleus-api-jdo-3.2.6.jar;datanucleus-core-3.2.10.jar;datanucleus-rdbms-3.2.9.jar;derby-10.4.2.0.jar;jdo-api-3.0.1.jar;libfb303-0.9.0.jar;libthrift-0.9.0.jar;servlet-api-2.5-20081211.jar;snappy-java-1.0.5.jar;zookeeper-3.4.5.2.1.1.0-385.jar;httpcore-4.2.5.jar;httpclient-4.2.5.jar;hbase-server-0.98.0.2.1.1.0-385-hadoop2.jar;hbase-common-0.98.0.2.1.1.0-385-hadoop2.jar;hbase-client-0.98.0.2.1.1.0-385-hadoop2.jar;hbase-protocol-0.98.0.2.1.1.0-385-hadoop2.jar;htrace-core-2.04.jar;guava-12.0.1.jar;protobuf-java-2.5.0.jar;log4j-1.2.17.jar;slf4j-api-1.7.5.jar;slf4j-log4j12-1.7.5.jar;jackson-mapper-asl-1.8.8.jar;jackson-core-asl-1.8.8.jar;netty-3.6.6.Final.jar;antlr-runtime-3.4.jar;";
        doTestHiveServerWithMode(HiveServerVersionInfo.HIVE_SERVER_2, HiveModeInfo.EMBEDDED, libsStr);
    }

    @Test
    public void testHbase() {
        String libsStr = "hadoop-auth-2.4.0.2.1.1.0-385.jar;hadoop-common-2.4.0.2.1.1.0-385.jar;hbase-client-0.98.0.2.1.1.0-385-hadoop2.jar;hbase-common-0.98.0.2.1.1.0-385-hadoop2.jar;hbase-protocol-0.98.0.2.1.1.0-385-hadoop2.jar;zookeeper-3.4.5.2.1.1.0-385.jar;htrace-core-2.04.jar;commons-lang-2.6.jar;commons-logging-1.1.1.jar;commons-configuration-1.6.jar;commons-codec-1.7.jar;guava-12.0.1.jar;protobuf-java-2.5.0.jar;log4j-1.2.16.jar;slf4j-api-1.6.1.jar;slf4j-log4j12-1.6.1.jar;jackson-mapper-asl-1.8.8.jar;jackson-core-asl-1.8.8.jar;netty-3.5.5.Final.jar;commons-collections-3.2.1.jar";
        doTestClassLoader(EHadoopCategory.HBASE.getName(), libsStr);
    }

    @Test
    public void testMapReduce() {
        String libsStr = "hadoop-hdfs-2.4.0.2.1.1.0-385.jar;hadoop-common-2.4.0.2.1.1.0-385.jar;hadoop-auth-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-common-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-core-2.4.0.2.1.1.0-385.jar;hadoop-mapreduce-client-jobclient-2.4.0.2.1.1.0-385.jar;hadoop-yarn-api-2.4.0.2.1.1.0-385.jar;hadoop-yarn-client-2.4.0.2.1.1.0-385.jar;hadoop-yarn-common-2.4.0.2.1.1.0-385.jar;guava-11.0.2.jar;protobuf-java-2.5.0.jar;avro-1.5.4.jar;commons-logging-1.1.3.jar;commons-cli-1.2.jar;commons-configuration-1.6.jar;commons-lang-2.6.jar;commons-codec-1.4.jar;commons-collections-3.2.1.jar;jackson-mapper-asl-1.8.8.jar;jackson-core-asl-1.8.8.jar;slf4j-api-1.7.5.jar;slf4j-log4j12-1.7.5.jar;log4j-1.2.17.jar";
        doTestClassLoader(EHadoopCategory.MAP_REDUCE.getName(), libsStr);
    }

    @Test
    public void testHDFS() {
        String libsStr = "hadoop-auth-2.4.0.2.1.1.0-385.jar;hadoop-common-2.4.0.2.1.1.0-385.jar;hadoop-hdfs-2.4.0.2.1.1.0-385.jar;commons-configuration-1.6.jar;commons-lang-2.6.jar;commons-logging-1.1.3.jar;commons-cli-1.2.jar;commons-collections-3.2.1.jar;guava-11.0.2.jar;protobuf-java-2.5.0.jar;slf4j-api-1.7.5.jar;slf4j-log4j12-1.7.5.jar;avro-1.5.4.jar;jackson-mapper-asl-1.8.8.jar;jackson-core-asl-1.8.8.jar;log4j-1.2.17.jar;commons-io-2.4.jar";
        doTestClassLoader(EHadoopCategory.HDFS.getName(), libsStr);
    }

    @Test
    public void testHDFSWithKerberos() {
        String libsStr = "hadoop-auth-2.4.0.2.1.1.0-385.jar;hadoop-common-2.4.0.2.1.1.0-385.jar;hadoop-hdfs-2.4.0.2.1.1.0-385.jar;commons-configuration-1.6.jar;commons-lang-2.6.jar;commons-logging-1.1.3.jar;commons-cli-1.2.jar;commons-collections-3.2.1.jar;guava-11.0.2.jar;protobuf-java-2.5.0.jar;slf4j-api-1.7.5.jar;slf4j-log4j12-1.7.5.jar;avro-1.5.4.jar;jackson-mapper-asl-1.8.8.jar;jackson-core-asl-1.8.8.jar;log4j-1.2.17.jar;hadoop-conf-kerberos.jar;jetty-util-6.1.26.jar;jersey-core-1.8.jar;commons-io-2.4.jar";
        doTestClassLoader(EHadoopCategory.HDFS.getName(), libsStr, "?USE_KRB");
    }
}
