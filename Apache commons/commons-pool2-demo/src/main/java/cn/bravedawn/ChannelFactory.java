package cn.bravedawn;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.DestroyMode;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * @author : depers
 * @program : common-pool2-demo
 * @date : Created in 2024/7/16 13:55
 */
public class ChannelFactory extends BasePooledObjectFactory<Channel> {


    @Override
    public void destroyObject(PooledObject<Channel> p, DestroyMode destroyMode) throws Exception {
        p.getObject().close();
    }

    @Override
    public Channel create() throws Exception {
        return new Channel();
    }

    @Override
    public PooledObject<Channel> wrap(Channel channel) {
        return new DefaultPooledObject<>(channel);
    }

    @Override
    public boolean validateObject(PooledObject<Channel> p) {
        return p.getObject().reconnect();
    }
}
