package cn.bravedawn.collection.list.multidimensinalarraylist;

import java.util.ArrayList;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/14 11:00
 */
public class MultiDimensionalArrayListExample {

    /**
     * 二维ArrayList
     */

    public static void main(String[] args) {
        // 创建一个二维的ArrayList
        int vertexCount = 3;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertexCount);

        // 初始化每个元素
        for (int i = 0; i < vertexCount; i++) {
            graph.add(new ArrayList<>());
        }

        // 将所有边 (0, 1)、(1, 2) 和 (2, 0) 添加到二维 ArrayList 中
        graph.get(0).add(1);
        graph.get(1).add(2);
        graph.get(2).add(0);

        // 假设我们的图不是有向图。 因此，我们还需要将边 (1, 0)、(2, 1) 和 (0, 2) 添加到二维 ArrayList
        graph.get(1).add(0);
        graph.get(2).add(1);
        graph.get(0).add(2);

        // 遍历整个图
        for (int i = 0; i < vertexCount; i++) {
            int edgeCount = graph.get(i).size();
            for (int j = 0; j < edgeCount; j++) {
                Integer startVertex = i;
                Integer endVertex = graph.get(i).get(j);
                System.out.printf("Vertex %d is connected to vertex %d%n", startVertex, endVertex);
            }
        }
    }
}
