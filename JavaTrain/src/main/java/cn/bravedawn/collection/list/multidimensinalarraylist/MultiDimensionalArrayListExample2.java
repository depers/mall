package cn.bravedawn.collection.list.multidimensinalarraylist;

import java.util.ArrayList;

/**
 * PC: SPDB
 * author: fengx9
 * create time: 2022/9/14 12:58
 */
public class MultiDimensionalArrayListExample2 {

    /**
     * 三维ArrayList
     */

    public static void main(String[] args) {

        int x_axis_length = 2;
        int y_axis_length = 2;
        int z_axis_length = 2;
        ArrayList<ArrayList<ArrayList<String>>> space = new ArrayList<>(x_axis_length);

        // 初始化
        for (int i = 0; i < x_axis_length; i++) {
            space.add(new ArrayList<ArrayList<String>>(y_axis_length));
            for (int j = 0; j < y_axis_length; j++) {
                space.get(i).add(new ArrayList<String>(z_axis_length));
            }
        }

        space.get(0).get(0).add(0, "Red");
        space.get(0).get(0).add(1, "Red");

        space.get(0).get(1).add(0, "Blue");
        space.get(0).get(1).add(1, "Blue");

        space.get(1).get(1).add(0, "Green");
        space.get(1).get(1).add(1, "Green");

        for (int i = 0; i < x_axis_length; i++) {
            for (int j = 0; j < y_axis_length; j++) {
                for (int k = 0; k < z_axis_length; k++) {
                    if (!space.get(i).get(j).isEmpty()) {
                        System.out.printf("Vertex %d, %d, %d, its color is %s.%n", i, j, k, space.get(i).get(j).get(k));
                    }

                    /**
                     * Vertex 0, 0, 0, its color is Red.
                     * Vertex 0, 0, 1, its color is Red.
                     * Vertex 0, 1, 0, its color is Blue.
                     * Vertex 0, 1, 1, its color is Blue.
                     * Vertex 1, 1, 0, its color is Green.
                     * Vertex 1, 1, 1, its color is Green.
                     */
                }
            }
        }
    }
}
