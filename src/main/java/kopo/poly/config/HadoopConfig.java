package kopo.poly.config;

import org.apache.hadoop.conf.Configuration;
import org.springframework.beans.factory.annotation.Value;

/**
 * 하둡 접속 설정
 * */
@org.springframework.context.annotation.Configuration
public class HadoopConfig {

    // 네임노드가 설치된 마스터 서버 IP
    @Value("${hadoop.hdfs.namenode.host}")
    String namenodeHost;

    // 네임노드 포트
    @Value("${hadoop.hdfs.namenode.port}")
    String namenodePort;

    // 얀 포트
    @Value("${hadoop.yarn.port}")
    String yarnPort;

    /**
     * 하둡 접속 설정
     * */
    public Configuration getHadoopConfiguration() {

        Configuration conf = new Configuration();

        // fs.defaultFS 설정 값 : hdfs://192.168.2.136:9000
        conf.set("fs.defaultFS", "hdfs://" + namenodeHost + ":" + namenodePort);

        // yarn 주소 설정
        conf.set("yarn.resourcemanager.address", namenodeHost + ":" + yarnPort);

        return conf;
    }
}
