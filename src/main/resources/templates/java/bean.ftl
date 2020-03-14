package ${groupId}.${artifactId}.entity.course;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ${tableName} implements Serializable {

<#list columnModelList as column>
    /**
    * ${column.remarks}
    */
    private ${column.type} ${column.name};
</#list>
}