/**
 * A class for our charming arctic friends
 */
public class Pingu {
    private String pinguName;
    private String favouriteFishSpecies;
    private float millisLivedAlready;

    public Pingu(String name, String favouriteFishSpecies, float millisecondsLivedAlready) {
        pinguName = name;
        favouriteFishSpecies = favouriteFishSpecies;
        millisLivedAlready = millisecondsLivedAlready;

    }


    // vvv --Getter and Setter usually are at the bottom of the class-- vvv

    public String getFavouriteFishSpecies() {
        return favouriteFishSpecies;
    }

    public void setFavouriteFishSpecies(String favouriteFishSpecies) {
        this.favouriteFishSpecies = favouriteFishSpecies;
    }

    public String getPinguName() {
        return pinguName;
    }

    public float getMillisLivedAlready() {
        return millisLivedAlready;
    }
}
