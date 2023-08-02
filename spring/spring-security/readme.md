Spring Security

## 1.正常用户登录的步骤

正常流程就是用户提交一个登录申请，我们这边需要查询数据库，拿数据库里面的数据和用户提交的表单数据进行对比，对比一致说明认证没有问题。

Spring Security的整体原理为：

1. 当http请求进来时，使用severlet的Filter来拦截。
2. 提取http请求中的认证信息，例如username和password，或者Token。
3. 从数据库（或者其他地方，例如Redis）中查询用户注册时的信息，然后进行比对，相同则认证成功，反之失败。

## 2.请求处理步骤

整个流程如下图所示：

![](assert/Spring-Security请求处理步骤.png)

下面我来逐一介绍上面几个关键组件的作用：

* Filter

  * 默认实现：`UsernamePasswordAuthenticationFilter`

  * 作用：拦截Http请求，获取用户名和秘密等认证信息。

  * 关键方法：

    ```java
    public abstract Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException;
    ```

* AuthenticationManager

  * 默认实现：`ProviderManager`

  * 作用：从filter中获取认证信息，然后查找合适的`AuthenticationProvider`来发起认证流程。

  * 关键方法：

    ```java
    Authentication authenticate(Authentication authentication) throws AuthenticationException;
    ```

* AuthenticationProvider

  * 默认实现：`DaoAuthenticationProvider`

  * 作用：调用UserDetailsService来查询已经保存的用户信息并与从http请求中获取的认证信息比对。如果成功则返回，否则则抛出异常。

  * 关键方法：

    ```java
    protected abstract UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
                throws AuthenticationException;
    ```

* UserDetailsService

  * 默认实现：`InMemoryUserDetailsManager`

  * 作用：负责获取用户保存的认证信息，例如查询数据库。

  * 关键方法：

    ```java
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    ```

## 3.其他的一些类

1. `UsernamePasswordAuthenticationToken`类

   * 作用：用来封装用户的认证信息，该对象仅仅是一个凭证，里面保存了用户的信息，例如username，password，权限等。

   * 关键字段：
     * `credentials`：用户凭证，一般是一个密码。
     * `principal`：被认证的身份，一般是用户名。

## 4.具体实践

1. 在用户的登录接口中，我们生成了一个jwt token。

   * 使用用户名和密码生成一个用户凭证。

   * 然后用自定义的校验逻辑使用该凭证，走我们自己的用户验证逻辑，并返回用户权限。

     ```java
     authenticationManager.authenticate(authenticationToken);
     // 这句代码最后会走到我们自定义的AuthenticationProvider中验证用户
     ```

   * 生成jwt token

2. 接着我们为了每次请求之前都对用户的信息进行鉴权，这里我们编写了`JwtAuthenticationTokenFilter`过滤器。

   * 首先我们会从头中取出jwt token。
   * 从token中解析出username。
   * 然后使用username获取用户的信息，这里面包含用户名、密码和权限等信息。
   * 将用户凭证保存到security的上下文中以便于在程序中使用。

3. 这里还涉及其余的几个功能：

   * 声明验证用户是否登录的handler。
   * 声明验证用户是否有权限的handler。
   * 对接口方法进行角色的限制声明。



