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
package org.talend.hadoop.distribution.hdp120.test;

import org.junit.Test;
import org.talend.core.hadoop.EHadoopCategory;
import org.talend.core.model.metadata.connection.hive.HiveModeInfo;
import org.talend.core.model.metadata.connection.hive.HiveServerVersionInfo;
import org.talend.hadoop.distribution.component.HadoopComponent;
import org.talend.hadoop.distribution.hdp120.HDP120Distribution;
import org.talend.hadoop.distribution.test.classloader.AbstractTest4ClassLoaderProvider;

/**
 * DOC ggu class global comment. Detailled comment
 */
public class HDP120ClassLoaderTest extends AbstractTest4ClassLoaderProvider {

    @Override
    protected Class<? extends HadoopComponent> getHadoopComponentClass() {
        return HDP120Distribution.class;
    }

    @Test
    public void testHive1Standalone_NotSupport() {
        doTestNotSupportHiveServerWithMode(HiveServerVersionInfo.HIVE_SERVER_1, HiveModeInfo.STANDALONE);
    }

    @Test
    public void testHive1Embedded() {
        String libsStr = "hive-hbase-handler-0.10.0.21.jar;hbase-0.94.2.21.jar;commons-logging-1.0.4.jar;datanucleus-api-jdo-3.0.7.jar;datanucleus-core-3.0.9.jar;datanucleus-rdbms-3.0.8.jar;hadoop-core-1.1.2.21.jar;hive-builtins-0.10.0.21.jar;hive-exec-0.10.0.21.jar;hive-jdbc-0.10.0.21.jar;hive-metastore-0.10.0.21.jar;hive-service-0.10.0.21.jar;libfb303-0.9.0.jar;libthrift-0.9.0.jar;commons-lang-2.4.jar;antlr-runtime-3.0.1.jar;commons-dbcp-1.4.jar;commons-pool-1.5.4.jar;derby-10.4.2.0.jar;commons-configuration-1.6.jar;jdo2-api-2.3-ec.jar;log4j-1.2.16.jar;slf4j-api-1.6.1.jar;slf4j-log4j12-1.6.1.jar;jackson-core-asl-1.8.8.jar;jackson-mapper-asl-1.8.8.jar";
        doTestHiveServerWithMode(HiveServerVersionInfo.HIVE_SERVER_1, HiveModeInfo.EMBEDDED, libsStr);
    }

    @Test
    public void testHive2Standalone() {
        String libsStr = "commons-logging-1.0.4.jar;datanucleus-api-jdo-3.0.7.jar;datanucleus-core-3.0.9.jar;datanucleus-rdbms-3.0.8.jar;hadoop-core-1.1.2.21.jar;hive-builtins-0.10.0.21.jar;hive-exec-0.10.0.21.jar;hive-jdbc-0.10.0.21.jar;hive-metastore-0.10.0.21.jar;hive-service-0.10.0.21.jar;libfb303-0.9.0.jar;libthrift-0.9.0.jar;commons-lang-2.4.jar;antlr-runtime-3.0.1.jar;commons-dbcp-1.4.jar;commons-pool-1.5.4.jar;derby-10.4.2.0.jar;commons-configuration-1.6.jar;jdo2-api-2.3-ec.jar;log4j-1.2.16.jar;slf4j-api-1.6.1.jar;slf4j-log4j12-1.6.1.jar;jackson-core-asl-1.8.8.jar;jackson-mapper-asl-1.8.8.jar";
        doTestHiveServerWithMode(HiveServerVersionInfo.HIVE_SERVER_2, HiveModeInfo.STANDALONE, libsStr);
    }

    @Test
    public void testHive2Embedded() {
        String libsStr = "commons-logging-1.0.4.jar;datanucleus-api-jdo-3.0.7.jar;datanucleus-core-3.0.9.jar;datanucleus-rdbms-3.0.8.jar;hadoop-core-1.1.2.21.jar;hive-builtins-0.10.0.21.jar;hive-exec-0.10.0.21.jar;hive-jdbc-0.10.0.21.jar;hive-metastore-0.10.0.21.jar;hive-service-0.10.0.21.jar;libfb303-0.9.0.jar;libthrift-0.9.0.jar;commons-lang-2.4.jar;antlr-runtime-3.0.1.jar;commons-dbcp-1.4.jar;commons-pool-1.5.4.jar;derby-10.4.2.0.jar;commons-configuration-1.6.jar;jdo2-api-2.3-ec.jar;log4j-1.2.16.jar;slf4j-api-1.6.1.jar;slf4j-log4j12-1.6.1.jar;jackson-core-asl-1.8.8.jar;jackson-mapper-asl-1.8.8.jar";
        doTestHiveServerWithMode(HiveServerVersionInfo.HIVE_SERVER_2, HiveModeInfo.EMBEDDED, libsStr);
    }

    @Test
    public void testHbase() {
        String libsStr = "hbase-0.94.2.21.jar;zookeeper-3.4.5.21.jar;commons-configuration-1.6.jar;commons-lang-2.5.jar;commons-logging-1.1.1.jar;hadoop-core-1.1.2.21.jar;log4j-1.2.16.jar;slf4j-api-1.6.1.jar;slf4j-log4j12-1.6.1.jar;protobuf-java-2.4.0a.jar";
        doTestClassLoader(EHadoopCategory.HBASE.getName(), libsStr);
    }

    @Test
    public void testMapReduce() {
        String libsStr = "hadoop-core-1.1.2.21.jar;commons-logging-1.1.1.jar;commons-cli-1.2.jar;commons-configuration-1.6.jar;commons-lang-2.4.jar;commons-codec-1.4.jar;jackson-mapper-asl-1.8.8.jar;jackson-core-asl-1.8.8.jar;slf4j-api-1.6.1.jar;slf4j-log4j12-1.6.1.jar;log4j-1.2.16.jar";
        doTestClassLoader(EHadoopCategory.MAP_REDUCE.getName(), libsStr);
    }

    @Test
    public void testHDFS() {
        String libsStr = "hadoop-core-1.1.2.21.jar;commons-logging-1.1.1.jar;commons-configuration-1.6.jar;commons-lang-2.4.jar;jetty-util-6.1.26.jar;jersey-core-1.8.jar;avro-1.5.4.jar;jackson-mapper-asl-1.8.8.jar;jackson-core-asl-1.8.8.jar";
        doTestClassLoader(EHadoopCategory.HDFS.getName(), libsStr);
    }

    @Test
    public void testHDFSWithKerberos() {
        String libsStr = "hadoop-core-1.1.2.21.jar;commons-logging-1.1.1.jar;commons-configuration-1.6.jar;commons-lang-2.4.jar;hadoop-conf-kerberos.jar;jetty-util-6.1.26.jar;jersey-core-1.8.jar;avro-1.5.4.jar;jackson-mapper-asl-1.8.8.jar;jackson-core-asl-1.8.8.jar";
        doTestClassLoader(EHadoopCategory.HDFS.getName(), libsStr, "?USE_KRB");
    }
}
