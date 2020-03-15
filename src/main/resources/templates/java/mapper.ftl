package ${groupId}.${packageName}.mapper;

import ${groupId}.${packageName}.entity.${firstUpperName};
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ${firstUpperName}Mapper {

    List<${firstUpperName}> list();

    ${firstUpperName} get(${primaryKeyType} ${primaryKey});

    int add(${firstUpperName} ${camelCaseName});

    int update(${firstUpperName} ${camelCaseName});

    int delete(${primaryKeyType} ${primaryKey});

}