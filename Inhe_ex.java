class Earth {
    public String publicLocation;

    Earth() {
        publicLocation = "Planet Earth";
    }

    void describe() {
        System.out.println("This is " + publicLocation + ".");
    }

    private String privateSurface;

    protected String protectedCore;
}

class Continent extends Earth {
    @Override
    void describe() {
        System.out.println("This is a continent on " + publicLocation + ".");
    }
}
class Ocean extends Earth {
    @Override
    void describe() {
        System.out.println("This is a Ocean on " + publicLocation + ".");
    }
}

class Country extends Continent {
    private String countryName;

    Country(String name) {
        countryName = name;
    }

    @Override
    void describe() {
        System.out.println("This is the country of " + countryName + " on a continent on " + publicLocation + ".");
    }

    void showNationalFlag() {
        System.out.println("Displaying the national flag of " + countryName + ".");
    }
}

class City {
    private String cityName;

    City(String name) {
        cityName = name;
    }

    void describe() {
        System.out.println("This is the city of " + cityName + ".");
    }

    void showCityMap() {
        System.out.println("Displaying the map of " + cityName + ".");
    }
}

public class Inhe_ex {
    public static void main(String[] args) {
        Earth earth = new Earth();
        Continent continent = new Continent();
        Ocean ocean=new Ocean();
        Country usa = new Country("USA");
        Country india = new Country("India");
        
        earth.describe();
        continent.describe();
        ocean.describe();
        usa.describe();
        usa.showNationalFlag();
        india.describe();
        india.showNationalFlag();
        
    }
}