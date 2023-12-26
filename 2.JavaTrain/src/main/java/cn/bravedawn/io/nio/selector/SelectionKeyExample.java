package cn.bravedawn.io.nio.selector;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-25 14:15
 */
public class SelectionKeyExample {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        Set<SelectionKey> selectedKeys = selector.selectedKeys();
        Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
        while (keyIterator.hasNext()) {
            SelectionKey key = keyIterator.next();
            if (key != null) {
                if (key.isAcceptable()) {
                    // ServerSocketChannel 接收了一个新连接
                } else if (key.isConnectable()) {
                    // 表示一个新连接建立
                } else if (key.isReadable()) {
                    // Channel 有准备好的数据，可以读取
                } else if (key.isWritable()) {
                    // Channel 有空闲的 Buffer，可以写入数据
                }
            }
            keyIterator.remove();
        }

    }
}
