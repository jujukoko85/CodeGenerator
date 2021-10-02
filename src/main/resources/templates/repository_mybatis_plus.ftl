<#assign mapper = entity.camelSmallName() + "Mapper" />
<#assign entityType = entity.camelBigName() />
<#assign primaryType = entity.primary().typeName() />
<#--FIXME 导包问题-->
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

@Repository
public class ${entityType}MybatisRepository implements ${entityType}Repository {

    @Autowired
    private ${entityType}Mapper ${mapper};

    @Override
    public void save(${entityType} entity) {
        ${mapper}.insert(entity);
    }

    @Override
    public ${entityType} getById(${primaryType} id) {
        return ${mapper}.selectById(id);
    }

    @Override
    public int update(${entityType} entity) {
        return ${mapper}.updateById(entity);
    }

    @Override
    public int delete(${primaryType} id) {
        return ${mapper}.deleteById(id);
    }

    @Override
    public PageBean<${entityType}> getPage(PageParam pageParam, ${entityType} example) {
        QueryWrapper<${entityType}> query = new QueryWrapper<>();
        Page<${entityType}> page = ${mapper}.selectPage(new Page<>(pageParam.getPageNum(), pageParam.getNumPerPage(), true), query);
        return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), (int) page.getTotal(), page.getRecords());
    }
}
// blank line