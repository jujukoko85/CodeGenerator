<#assign dtoType = entity.camelBigName() + "Dto" />
<#assign entityType = entity.camelBigName() />
<#--FIXME 导包问题-->
import com.howard.plat.base.model.assembler.BaseAssembler;
import org.springframework.beans.BeanUtils;

public class ${entityType}Assembler extends BaseAssembler<${entityType}, ${dtoType}> {

    @Override
    public ${dtoType} entityToDto(${entityType} entity) {
        if (null == entity) {
            return null;
        }
        ${dtoType} dto = new ${dtoType}();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    @Override
    public ${entityType} dtoToEntity(${dtoType} dto) {
        if (null == dto) {
            return null;
        }
        ${entityType} entity = new ${entityType}();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
// blank line
