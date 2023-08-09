package cn.bravedawn;

import cn.bravedawn.basicoperate.dao.PostDao;
import cn.bravedawn.basicoperate.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.Test;

import java.io.IOException;


@ContextConfiguration(locations = {"classpath:applicationContext-simpleexample.xml"})
@Rollback
@Transactional
public class TestPostDao extends AbstractTransactionalTestNGSpringContextTests {


    @Autowired
    private PostDao postDao;


    @Test
    public void testAddPost() throws IOException {
        Post post = new Post();
        post.setUserId(2);
        ClassPathResource res = new ClassPathResource("temp.jpg");
        byte[] mockImg = FileCopyUtils.copyToByteArray(res.getFile());
        post.setPostAttach(mockImg);
        post.setPostText("测试帖子的内容");
        postDao.addPost(post);
    }
}
