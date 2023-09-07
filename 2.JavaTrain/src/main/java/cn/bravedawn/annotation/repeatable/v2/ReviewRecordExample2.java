package cn.bravedawn.annotation.repeatable.v2;


/**
 * @author : fengx9
 * @program : JavaTrain
 * @date : Created in 2023/03/01 1:11 PM
 */


@ReviewRecord(name="Eric", date="2019-12-19", comment="No comment")
@ReviewRecord(name="Joan", date="2019-12-29")
public class ReviewRecordExample2 {

    /**
     * 在Java8之后我们使用@Repeatable(ReviewRecords.class)注解之后，就不用想v1那样写了，直接重复就行
     */

    public static void main(String[] args) {
        ReviewRecords recordsAnno = ReviewRecordExample2.class.getAnnotation(ReviewRecords.class);
        for(ReviewRecord recordAnno : recordsAnno.value()) {
            System.out.println(recordAnno);
        }
        System.out.println("---------------------------");

        // 重复使用的注解，直接获取一个会报null
        ReviewRecord reviewRecord = ReviewRecordExample2.class.getAnnotation(ReviewRecord.class);
        System.out.println(reviewRecord);
    }

}
