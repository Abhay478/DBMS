======================================================
Oracle Free Use Terms and Conditions (FUTC) License 
======================================================
https://www.oracle.com/downloads/licenses/oracle-free-license.html
===================================================================

ojdbc11-full.tar.gz - JDBC Thin Driver and Companion JARS
========================================================
This TAR archive (ojdbc11-full.tar.gz) contains the 21.8.0.0 release of the Oracle JDBC Thin driver(ojdbc11.jar), the Universal Connection Pool (ucp.jar) and other companion JARs grouped by category. 

(1) ojdbc11.jar (5,181,682 bytes) - 
(SHA1 Checksum: 91cfebdd95a7b39e8d775045bbbfe81629246632)
Oracle JDBC Driver compatible with Certified with JDK11, JDK12, JDK13, JDK14, and JDK15;
Note: "java -jar ojdbc11.jar" shows the version as 21.7.0.0. But, it is indeed from the release 21.8.0.0. 
(2) ucp11.jar (1,801,604 bytes) - (SHA1 Checksum: 6ae2b57e556fa814ccdb532c892f5fbc61926d99)
Universal Connection Pool classes to be used with ojdbc11.jar -- for performance, scalability, high availability, sharded and multitenant databases.
Note: "java -jar ucp.jar" shows the version as 21.7.0.0. But, it is indeed from the release 21.8.0.0. 
You need to change ucp11.jar to ucp.jar to display the version. 
(3) rsi.jar (345,266 bytes) - (SHA1 Checksum: 7f1f9e2c074d8cee6a82b0d52315807e3fc0cfa6)
Reactive Streams Ingestion (RSI) 
(4) ojdbc.policy (21,515 bytes) - Sample security policy file for Oracle Database JDBC drivers

======================
Security Related JARs
======================
Java applications require some additional jars to use Oracle Wallets. 
You need to use all the three jars while using Oracle Wallets. 
(5) oraclepki.jar (307,822 bytes) - (SHA1 Checksum: 147a4bd2174d960e25c475ef4bf64f958a73af45)
Additional jar required to access Oracle Wallets from Java
(6) osdt_cert.jar (211,063 bytes) - (SHA1 Checksum: 77c2c4c1058354058d876ef49b2179bb7e7ad198)
Additional jar required to access Oracle Wallets from Java
(7) osdt_core.jar (312,984 bytes ) - (SHA1 Checksum: a50bf37812a7fdb69ad12e58548fcb6e9ec6a194)
Additional jar required to access Oracle Wallets from Java

=============================
JARs for NLS and XDK support 
=============================

(8) orai18n.jar (1,664,684 bytes) - (SHA1 Checksum: 61a67d51fae646a3b3c0aa53e381eda239f948e0) 
Classes for NLS support
(9) xdb.jar (129,570 bytes) - (SHA1 Checksum: c3715d8dce5ef91639373287621de7a86ae166db)
Classes to support standard JDBC 4.x java.sql.SQLXML interface 
(10) xmlparserv2.jar (1,953,953 bytes) - (SHA1 Checksum: 8c9a1d3abc1b3702f97ef204a434d5d2fce77d26)
Classes to support standard JDBC 4.x java.sql.SQLXML interface 
(11) xmlparserv2_sans_jaxp_services.jar (1,949,183 bytes) - (SHA1 Checksum: b10c282ccae24254550941ba39566fb34400232d) 
Classes to support standard JDBC 4.x java.sql.SQLXML interface

====================================================
JARs for Real Application Clusters(RAC), ADG, or DG 
====================================================
(12) ons.jar (198,688 bytes) - (SHA1 Checksum: 7f0348724c47c762c66251230b235e1fbc8ae276)
for use by the pure Java client-side Oracle Notification Services (ONS) daemon
(13) simplefan.jar (32,432 bytes ) - (SHA1 Checksum: 99023f5c996457e6b3c03c3cf096e4e5e2cde179)
Java APIs for subscribing to RAC events via ONS; simplefan policy and javadoc

==================================================================================
NOTE: The diagnosability JARs **SHOULD NOT** be used in the production environment. 
These JARs (ojdbc11_g.jar,ojdbc11dms.jar, ojdbc11dms_g.jar) are meant to be used in the 
development, testing, or pre-production environment to diagnose any JDBC related issues. 

=====================================
OJDBC - Diagnosability Related JARs
===================================== 

(14) ojdbc11_g.jar (8,604,839 bytes) - (SHA1 Checksum: d508317a42ec371f7b6257b60f8340262cec016e)
Same as ojdbc8.jar except compiled with "javac -g" and contains tracing code.

(15) ojdbc11dms.jar (7,182,396 bytes) - (SHA1 Checksum: 3a7e86b0ed1b919b78dd0c5f9784316533b20f31)
Same as ojdbc8.jar, except that it contains instrumentation to support DMS and limited java.util.logging calls.

(16) ojdbc11dms_g.jar (8,606,709 bytes) - (SHA1 Checksum: 501435d822e46b34f462ccb6bd35ce145ce27b99)
Same as ojdbc8_g.jar except that it contains instrumentation to support DMS.

(17) dms.jar (2,194,533 bytes) - (SHA1 Checksum: 884c9504d0ff7628bc5dc3c2b81e752df85dc7b4)
dms.jar required for DMS-enabled JAR files.

==================================================================
Oracle JDBC and UCP - Javadoc and README
==================================================================

(18) JDBC-Javadoc-21c.jar (2,594,044 bytes) - JDBC API Reference 21c

(19) ucp11-Javadoc-21c.jar (811,960 bytes ) - UCP Java API Reference 21c

(20) RSI-Javadoc-21c.jar (425,929 bytes) - RSI Java API Reference 21c

(21) simplefan-Javadoc-21c.jar (86,952 bytes) - Simplefan API Reference 21c 

(22) xdb-Javadoc-21c.jar (2,631,100 bytes) - XDB API Reference 21c 

(23) xmlparserv2-Javadoc-21c.jar (2,631,100 bytes ) - xmlparserv2 API Reference 21c 

(24) JDBC-Readme.txt: It contains general information about the JDBC driver and bugs that have been fixed in the 21.8.0.0 release. 

(25) UCP-Readme.txt: It contains general information about UCP and bugs that are fixed in the 21.8.0.0 release. 

=============== Known Problems in the Release 21c ==================== 

Refer to Bugs-fixed-in-21c.txt on JDBC download page (https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html) for the list of bugs fixed in the 21c release.

=================
USAGE GUIDELINES
=================
Refer to the JDBC Developers Guide (https://docs.oracle.com/en/database/oracle/oracle-database/21/jjdbc/index.html) and Universal Connection Pool Developers Guide (https://docs.oracle.com/en/database/oracle/oracle-database/21/jjucp/index.html) for more details. 