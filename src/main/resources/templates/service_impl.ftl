<#assign dtoType = entity.camelBigName() + "Dto" />
<#assign entityType = entity.camelBigName() />
<#assign primaryType = entity.primary().typeName() />
<#assign repository = entity.camelSmallName() + "Repository" />
<#assign assemblerType = entityType + "Assembler" />
<#--FIXME 导包问题-->
import com.howard.plat.base.utils.PageBean;
import com.howard.plat.base.utils.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ${entityType}ServiceImpl implements ${entityType}Service {

    @Autowired
    private ${entityType}Repository ${repository};

    @Override
    public PageBean<${dtoType}> getPage(PageParam pageParam, ${dtoType} example) {
        ${assemblerType} assembler = new ${assemblerType}();
        PageBean<${entityType}> page = ${repository}.getPage(pageParam, assembler.dtoToEntity(example));
        return new PageBean<>(page.getCurrentPage(), page.getNumPerPage(), page.getTotalCount(), assembler.entityToDto(page.getRecordList()));
    }

    @Override
    public ${dtoType} getById(${primaryType} id) {
        return new ${assemblerType}().entityToDto(${repository}.getById(id));
    }

    @Override
    public void delete(${primaryType} id, String currentUser) {
        ${repository}.delete(id);
    }

    @Override
    public void update(${primaryType} id, ${dtoType} example, String currentUser) {
        ${entityType} target = ${repository}.getById(id);
        if (null == target) {
//            throw new PaperBizException(PaperBizEnum.FOCUS_NOT_FOUND);
        }
        target.update(example, currentUser);
        ${repository}.update(target);
    }

    @Override
    public void doCreate(${dtoType} example, String currentUser) {
        ${entityType} target = ${entityType}.create(example, currentUser);
        ${repository}.save(target);
    }

}
// blank line
