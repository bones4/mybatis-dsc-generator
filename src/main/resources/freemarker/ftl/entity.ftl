package ${entityUrl};

import java.io.Serializable;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * @program:${project}
 * @description: ${entityComment}
 * @author: ${author}
 * @create: ${createTime}
 */
@ApiModel("${entityComment}")
public class ${entityName} implements Serializable {

<#list cis as ci>
	@ApiModelProperty("${ci.comment}")
	private String ${ ci.property};
</#list>
}
	