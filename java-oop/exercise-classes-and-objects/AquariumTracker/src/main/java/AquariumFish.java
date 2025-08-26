public class AquariumFish {

    private String species;
    private String commonName;
    private double maxTemp;
    private double minTemp;
    private String diet;

    public AquariumFish(String species, String commonName, double maxTemp, double minTemp, String diet) {
        this.species = species;
        this.commonName = commonName;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.diet = diet;
    }

    public double averageTemperature(){

        return (this.maxTemp + this.minTemp) / 2;

    }
}
