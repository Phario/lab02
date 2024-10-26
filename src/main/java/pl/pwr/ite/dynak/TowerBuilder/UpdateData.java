package pl.pwr.ite.dynak.TowerBuilder;
//updates the spot's radius, height and the bucket's contents
/*public class Updater {
    private double newRadius;
    private double newHeight;
    private double volume;
    private int spotNumber;
    private int bucketNumber;
    public Updater(double[] updateData) {
        this.newRadius = updateData[0];
        this.newHeight = updateData[1];
        this.volume = updateData[2];
        this.spotNumber = (int)updateData[3];
        this.bucketNumber = (int)updateData[4];
    }
}
*/
public record UpdateData(double newRadius, double newHeight, double volume, int spotNumber, int bucketNumber) {
    public UpdateData(double[] updateData){
        this(updateData[0],updateData[1],updateData[2],(int)updateData[3],(int)updateData[4]);
    }
}