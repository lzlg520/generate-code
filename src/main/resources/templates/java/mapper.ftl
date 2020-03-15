package ${groupId}.${artifactId}.mapper;

import ${groupId}.${artifactId}.entity.${firstUpperName};
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ${firstUpperName}Mapper {

    List<${firstUpperName}> list();

    ${firstUpperName} get(int id);

    int add(${firstUpperName} ${camelCaseName});

    int update(${firstUpperName} ${camelCaseName});

    int delete(int id);

}