package ${groupId}.${artifactId}.entity;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class ${firstUpperName} implements Serializable {

<#list columnModelList as column>
    /**
    * ${column.remarks}
    */
    private ${column.type} ${column.name};
</#list>
}