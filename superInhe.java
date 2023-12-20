class Earth {
    protected String publicLocation;

    Earth() {
        this("Planet Earth");
    }

    Earth(String location) {
        publicLocation = location;
    }

    void describe() {
        System.out.println("This is " + publicLocation + ".");
    }
}

class Continent extends Earth {
    Continent(String location) {
        super(location);
    }

    @Override
    void describe() {
        System.out.println("This is a continent on " + publicLocation + ".");
    }
}

class Ocean extends Earth {
    Ocean(String location) {
        super(location);
    }

    @Override
    void describe() {
        System.out.println("This is an ocean on " + publicLocation + ".");
    }
}

class Country extends Continent {
    private String countryName;

    Country(String continentLocation, String name) {
        super(continentLocation);
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

public class superInhe {
    public static void main(String[] args) {
        Earth earth = new Earth();
        Continent continent = new Continent("North America");
        Ocean ocean = new Ocean("Pacific Ocean");
        Country usa = new Country("North America", "USA");
        Country india = new Country("Asia", "India");
        City delhi=new City("Delhi");

        earth.describe();
        continent.describe();
        ocean.describe();
        usa.describe();
        usa.showNationalFlag();
        india.describe();
        india.showNationalFlag();
        delhi.describe();
    
    }
}