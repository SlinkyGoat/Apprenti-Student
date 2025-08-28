public class Artifact {

    private String name;
    private Person discoverer;
    private Person curator;
    private int yearOfDiscovery;

    public Artifact(String name, Person discoverer, Person curator, int yearOfDiscovery) {
        this.name = name;
        this.discoverer = discoverer;
        this.curator = curator;
        this.yearOfDiscovery = yearOfDiscovery;
    }

    public String getName() {
        return name;
    }

    public Person getDiscoverer() {
        return discoverer;
    }

    public Person getCurator() {
        return curator;
    }

    public int getYearOfDiscovery() {
        return yearOfDiscovery;
    }

    public String toString(){
        return "Artifact: " + getName() + " (" + getYearOfDiscovery() + ")\n" +
                "Discoverer: " + getDiscoverer().toString() + "\n" +
                "Curator: " + getCurator().toString();
    }
}
