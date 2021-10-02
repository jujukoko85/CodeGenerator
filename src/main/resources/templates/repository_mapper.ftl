<#--FIXME 导包问题-->
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ${entity.camelBigName()}Mapper extends BaseMapper<${entity.camelBigName()}> {

}
// blank line
