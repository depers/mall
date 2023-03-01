package cn.bravedawn.annotation.repeatable.v1;

/**
 * @author : fengx9
 * @program : JavaTrain
 * @date : Created in 2023/03/01 1:11 PM
 */


@ReviewRecords({
        @ReviewRecord(name="Eric", date="2019-12-19", comment="No comment"),
        @ReviewRecord(name="Joan", date="2019-12-29")
})
public class ReviewRecordExample {

    /**
     * 在1.8之前，如果想重复使用一个注解进行描述，需要像这个类一样去写
     */

    public static void main(String[] args) {
        ReviewRecords recordsAnno = ReviewRecordExample.class.getAnnotation(ReviewRecords.class);
        for(ReviewRecord recordAnno : recordsAnno.value()) {
            System.out.println(recordAnno);
        }
    }

}
