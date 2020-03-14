package ${groupId}.${artifactId}.mapper;

import ${groupId}.${artifactId}.entity.${tableName};
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ${tableName}Mapper {

    List<${tableName}> list();

    ${tableName} get(int id);

    int add(${tableName} ${tableName});

    int update(${tableName} ${tableName});

    int delete(int id);

}