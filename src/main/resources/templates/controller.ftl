<#assign entityType = entity.camelBigName() />
<#assign dtoType = entity.camelBigName() + "Dto" />
<#assign voType = entity.camelBigName() + "Vo" />
<#assign primaryType = entity.primary().typeName() />
<#assign primaryName = entity.primary().camelSmallName() />
<#assign primaryBigName = entity.primary().camelBigName() />
<#assign service = entity.camelSmallName() + "Service" />
<#assign entityLineName = entity.lineName() />
<#assign domain = "paper" />
<#--FIXME 导包问题-->
import com.howard.plat.base.utils.PageBean;
import com.howard.plat.base.utils.PageParam;
import com.howard.plat.utils.AjaxResult;
import com.howard.plat.utils.AppContext;
import com.howard.plat.controller.base.BaseController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/${entityLineName}")
public class ${entityType}Controller extends BaseController {

    @Autowired
    private ${entityType}Service ${service};

    @RequestMapping("/${entityLineName}_list")
    public ModelAndView getPage(${voType} vo, ModelMap model) {
        PageParam pageParam = new PageParam(vo.getCurrentPage(), vo.getPageSize());
        PageBean<${dtoType}> page = ${service}.getPage(pageParam, vo.toDto());
        model.put(PAGE_KEY, page);
        return view("/${domain}/${entityLineName}/${entityLineName}_list", model);
    }

    @RequestMapping("/${entityLineName}_edit")
    public ModelAndView edit(
        @RequestParam(name = "${primaryName}", defaultValue = "") ${primaryType} ${primaryName},
        ModelMap model) {
        ${dtoType} entity = null == ${primaryName} ? null : ${service}.getById(${primaryName});
        model.put("entity", entity);
        return view("/${domain}/${entityLineName}/${entityLineName}_edit", model);
    }

    @RequestMapping(value = "/${entityLineName}_save", method = RequestMethod.POST, produces = JSON_PRODUCER)
    @ResponseBody
    public String save(${voType} vo) {
        try {
            ${service}.doCreate(vo.toDto(), AppContext.getUserExt().getUsername());
            return AjaxResult.getSuccessJson("新增成功!");
//        } catch (PaperBizException e) {
//            logger.error(e.getBiz().getDesc(), e);
//            return AjaxResult.getFailureJson(e.getBiz().getDesc());
        } catch (Exception e) {
            String errMsg = "新增失败!";
            logger.error(errMsg, e);
            return AjaxResult.getFailureJson(errMsg);
        }
    }

    @RequestMapping(value = "/${entityLineName}_update", method = RequestMethod.POST, produces = JSON_PRODUCER)
    @ResponseBody
    public String update(${voType} vo) {
        try {
            ${dtoType} dto = vo.toDto();
            ${service}.update(dto.get${primaryBigName}(), dto, AppContext.getUserExt().getUsername());
            return AjaxResult.getSuccessJson("更新成功!");
//        } catch (PaperBizException e) {
//            logger.error(e.getBiz().getDesc(), e);
//            return AjaxResult.getFailureJson(e.getBiz().getDesc());
        } catch (Exception e) {
            String errMsg = "更新失败!";
            logger.error(errMsg, e);
            return AjaxResult.getFailureJson(errMsg);
        }

    }

    @RequestMapping(value = "/${entityLineName}_delete", produces = JSON_PRODUCER)
    @ResponseBody
    public String delete(
    @RequestParam(name = "${primaryName}", defaultValue = "") ${primaryType} ${primaryName},
    ModelMap model) {
        try {
            ${service}.delete(${primaryName}, AppContext.getUserExt().getUsername());
            return AjaxResult.getSuccessJson("删除成功!");
//        } catch (PaperBizException e) {
//            logger.error(e.getBiz().getDesc(), e);
//            return AjaxResult.getFailureJson(e.getBiz().getDesc());
        } catch (Exception e) {
            String errMsg = "删除失败!";
            logger.error(errMsg, e);
            return AjaxResult.getFailureJson(errMsg);
        }
    }
}
// blank line
