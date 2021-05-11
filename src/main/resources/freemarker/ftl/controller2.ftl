/**
 * @program:${project}
 * @description: ${entityName}控制层
 * @author: ${author}
 * @create: ${createTime}
 */
package ${controllerUrl};
#方法
<#list motheds as item>

@ApiOperation(value = "${item.atter['tag']}", notes = "${item.atter['remark']}")
@PostMapping("/${item.atter['name']}")
@CustomLog
public ResponseJson<#if item.atter['outputtype']='null'> <#else><${util("fristUpper",item.atter['name'])}Output></#if> ${item.atter['name']}( @RequestBody <#if item.atter['inputtype']='null'> <#else>${util("fristUpper",item.atter['name'])}Input input </#if>){
 <#if item.atter['inputtype']='default' >
    //校验参数
    <#list item.input as param>
     <#if param.required!='false' >

      if (StringUtil.isEmpty(input.get${util("fristUpper",param.name)}())) {
      return ResponseUtil.getResponseMsg(RESPONSE_CODE_ERROR, "${param.name}为空!");
     }
     </#if>
    </#list>
 </#if>
 }


</#list>