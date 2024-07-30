package cn.bravedawn.springsecurity.security;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

import java.util.Collection;

/**
 * @author : depers
 * @program : 3.spring-security
 * @date : Created in 2024/5/10 15:19
 *
 * 自定义接口访问权限控制逻辑
 */
public class MyAccessDecisionVoter implements AccessDecisionVoter<Object> {


    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    /**
     * 访问投票
     * @param authentication 认证信息
     * @param object 请求信息
     * @param collection 角色信息
     * @return
     */
    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> collection) {
        int result = ACCESS_ABSTAIN; // 弃权
        if (authentication == null) {
            result = ACCESS_DENIED; // 访问拒绝
        }

        FilterInvocation filterInvocation = (FilterInvocation) object;
        String url = filterInvocation.getRequestUrl();
        String method = filterInvocation.getRequest().getMethod();
        String username = (String) authentication.getPrincipal();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (ConfigAttribute attribute : collection) {
            for (GrantedAuthority authority : authorities) {
                if (attribute.getAttribute().equals(attribute.getAttribute())) {
                    return ACCESS_ABSTAIN;
                }
            }
        }
        return result;
    }

    @Override
    public boolean supports(Class clazz) {
        return true;
    }
}
