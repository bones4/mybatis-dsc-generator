package ${base.entityUrl};

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * @program:${base.project}
 * @description: ${base.entityComment}
 * @author: ${base.author}
 * @create: ${base.createTime}
 */
@ApiModel
public class ${method.atter['inputName']} implements Serializable {

<#list method.input as ci>
	@ApiModelProperty("${ci.tag}")
	private String ${ci.name};
</#list>
<#list method.input as ci>
    public String get${util("fristUpper",ci.name)}() {return ${ci.name};}
    public void set${util("fristUpper",ci.name)}(String ${ci.name}) {this.${ci.name} = ${ci.name};}
</#list>
}
	