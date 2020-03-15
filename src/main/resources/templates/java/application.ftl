package ${groupId}.${packageName};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.mybatis.spring.annotation.MapperScan;

/**
* @author lzlg
* 2020/3/14 10:14
*/
@SpringBootApplication
@EntityScan("${groupId}.${packageName}.entity")   //扫描实体类
@MapperScan(basePackages = {"${groupId}.${packageName}.mapper"})//扫描Mapper
public class ${firstUpperArtifact}Application {
    public static void main(String[] args) {
        SpringApplication.run(${firstUpperArtifact}Application.class, args);
    }
}