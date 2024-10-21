package pl.pwr.ite.dynak.DataProcessingUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Bucket {
    private final Double maxCapacity;
    @Setter
    private Double contents;
    private final Integer pileAngle;
    private final Integer bucketNo;

    public Bucket(Integer bucketNo, Double contents, Integer pileAngle) {
        this.maxCapacity = contents;
        this.contents = contents;
        this.pileAngle = pileAngle;
        this.bucketNo = bucketNo;
    }

}
