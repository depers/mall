package cn.bravedawn;

import cn.bravedawn.mapper.RoleMapper;
import cn.bravedawn.pojo.Role;
import cn.bravedawn.utils.CommonPage;
import cn.bravedawn.utils.PageUtils;
import cn.bravedawn.vo.RoleVo;
import cn.hutool.json.JSONUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : depers
 * @program : pagehelper
 * @description:
 * @date : Created in 2022/1/4 17:26
 */
public class PageInfoExample {

    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            // 读取配置文件，mybatis读取resource文件有自己的一套实现
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = null;
        // 采用构建者模式，通过配置文件构建会话工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);

            PageHelper.startPage(1, 10);
            List<Role> roles = roleMapper.selectListByRoleName("test");
            PageInfo<Role> pageInfo = new PageInfo(roles);

            System.out.println("之前的--------------------------------");
            System.out.println(JSONUtil.toJsonStr(pageInfo));

            List<RoleVo> collect = roles.stream().map(role -> {
                RoleVo roleVo = new RoleVo();
                roleVo.setRoleName(role.getRoleName());
                roleVo.setId(role.getId());
                return roleVo;
            }).collect(Collectors.toList());

            System.out.println("之后的--------------------------------");
            CommonPage<RoleVo> voCommonPage = CommonPage.resetPage(pageInfo, collect);

            System.out.println(JSONUtil.toJsonStr(voCommonPage));


            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }


}
