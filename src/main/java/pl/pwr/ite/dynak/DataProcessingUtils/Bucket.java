package pl.pwr.ite.dynak.DataProcessingUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Bucket {
    private final Integer maxCapacity;
    @Setter
    private Integer contents;
    private final Integer pileAngle;
    private final Integer bucketNo;

    public Bucket(Integer bucketNo, Integer contents, Integer pileAngle) {
        this.maxCapacity = contents;
        this.contents = contents;
        this.pileAngle = pileAngle;
        this.bucketNo = bucketNo;
    }

}
