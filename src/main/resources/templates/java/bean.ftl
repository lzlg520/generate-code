package ${groupId}.${packageName}.entity;

import lombok.Data;
import lombok.ToString;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

@Data
@ToString
@NoArgsConstructor
public class ${firstUpperName} implements Serializable {

<#list columnModelList as column>
    /**
    * ${column.remarks}
    */
    private ${column.type} ${column.camelCaseName};
</#list>
}