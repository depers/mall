package cn.bravedawn.orm;

import java.util.List;

/**
 *
 * 通用的数据库操作接口
 *
 * @author : depers
 * @program : jdbc-demo
 * @date : Created in 2022/11/6 20:35
 */
public interface JDBCRepository<T> {


    /**
     * 根据实体对象的属性查询对象数组
     * @param entityClass 实体的Class对象
     * @param args 查询参数
     * @return
     */
    List<?> selectList(Class entityClass, Object... args);

    /**
     * 插入数据
     * @param entity 实体对象
     * @return
     */
    int insertSelective(T entity);


    /**
     * 批量插入数据
     * @param entities 实体对象数组
     * @return
     */
    int insertBatch(List<T> entities);

    /**
     * 删除数据
     * @param id 主键
     * @return
     */
    int deleteByPrimaryKey(long id);


    /**
     * 更新数据
     * @param entity 实体对象
     * @return
     */
    int updateByIdSelective(T entity);

}
