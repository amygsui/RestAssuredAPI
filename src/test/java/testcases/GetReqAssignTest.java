package testcases;

import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetReqAssignTest {

    private static String baseURI = "https://pokeapi.co/api/v2";

    @Test
    public void get_berries() {

        String endpoint = "/berry/1/";

        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get(endpoint);

        // Getting status line
        System.out.println("Status Line: " + response.statusLine());

        // Getting status code
        System.out.println("Status Code: " + response.statusCode());

        // Getting all headers
        System.out.println("All headers: ");
        Headers headers = response.headers();
        String entireHeader = headers.toString();
        System.out.println(entireHeader);

        // Getting 3 specific headers + key/value pairs
        System.out.println("\nHere are three headers: \n");
        String contentType = headers.getValue("Content-Type");
        String server = headers.getValue("Server");
        String date = headers.getValue("Date");

        System.out.println("Content Type: " + contentType);
        System.out.println("Server: " + server);
        System.out.println("Date: " + date);

        // Getting response body
        System.out.println("\nResponse Body: \n");
        String responseBody = response.getBody().prettyPrint();
        System.out.println(responseBody);

        // Extract 3 values using JsonPath and jsonpath Query
        String flavorNameValue = JsonPath.read(responseBody, "$.name");
        int sizeValue = JsonPath.read(responseBody, "$.size");
        int naturalGiftPowerValue = JsonPath.read(responseBody, "$.natural_gift_power");

        System.out.println("Flavor of berry 1: " + flavorNameValue);
        System.out.println("Size of berry 1: " + sizeValue);
        System.out.println("Natural Gift Power of berry 1: " + naturalGiftPowerValue);

    }

    @Test
    public void get_evolution_triggers() {

        String endpoint = "evolution-trigger/1/";

        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get(endpoint);

        // Getting status line
        System.out.println("Status Line: " + response.statusLine());

        // Getting status code
        System.out.println("Status Code: " + response.statusCode());

        // Getting all headers
        System.out.println("All headers: ");
        Headers headers = response.headers();
        String entireHeader = headers.toString();
        System.out.println(entireHeader);

        // Getting 3 specific headers + key/value pairs
        System.out.println("\nHere are three headers: \n");
        String contentEncoding = headers.getValue("Content-Encoding");
        String age = headers.getValue("Age");
        String date = headers.getValue("Date");

        System.out.println("Content Encoding: " + contentEncoding);
        System.out.println("Age: " + age);
        System.out.println("Date: " + date);

        // Getting response body
        System.out.println("\nResponse Body: \n");
        String responseBody = response.getBody().prettyPrint();
        System.out.println(responseBody);

        // Extract 3 values using JsonPath and jsonpath Query
        String triggerNameValue = JsonPath.read(responseBody, "$.names[2].name");
        String pokemonSpeciesValue = JsonPath.read(responseBody, "$.pokemon_species[0].name");
        String languageValue = JsonPath.read(responseBody, "$.names[2].language.name");

        System.out.println("Evolution trigger: " + triggerNameValue);
        System.out.println("Evolving Pokemon Species: " + pokemonSpeciesValue);
        System.out.println("Language: " + languageValue);
    }

    @Test
    public void get_generations() {

        String endpoint = "generation/1/";

        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get(endpoint);

        // Getting status line
        System.out.println("Status Line: " + response.statusLine());

        // Getting status code
        System.out.println("Status Code: " + response.statusCode());

        // Getting all headers
        System.out.println("\nAll headers: \n");
        Headers headers = response.headers();
        String entireHeader = headers.toString();
        System.out.println(entireHeader);

        // Getting 3 specific headers + key/value pairs
        System.out.println("\nHere are three headers: \n");
        String contentLength = headers.getValue("Content-Length");
        String connection = headers.getValue("Connection");
        String setCookie = headers.getValue("Set-Cookie");

        System.out.println("Content Length: " + contentLength);
        System.out.println("Connection: " + connection);
        System.out.println("Set-Cookie: " + setCookie);

        // Getting response body
        System.out.println("\nResponse Body: \n");
        String responseBody = response.getBody().prettyPrint();
        System.out.println(responseBody);

        // Extract 3 values using JsonPath and jsonpath Query
        String regionNameValue = JsonPath.read(responseBody, "$.main_region.name");
        String pokemonSpeciesValue = JsonPath.read(responseBody, "$.pokemon_species[0].name");
        String pokemonTypeValue = JsonPath.read(responseBody, "$.types[0].name");

        System.out.println("Evolution trigger: " + regionNameValue);
        System.out.println("Evolving Pokemon Species: " + pokemonSpeciesValue);
        System.out.println("Language: " + pokemonTypeValue);

    }

    @Test
    public void get_pokedexes() {

        String endpoint = "pokedex/2/";

        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get(endpoint);

        // Getting status line
        System.out.println("Status Line: " + response.statusLine());

        // Getting status code
        System.out.println("Status Code: " + response.statusCode());

        // Getting all headers
        System.out.println("\nAll headers: \n");
        Headers headers = response.headers();
        String entireHeader = headers.toString();
        System.out.println(entireHeader);

        // Getting 3 specific headers + key/value pairs
        System.out.println("\nHere are three headers: \n");
        String accessControl = headers.getValue("Access-Control");
        String cacheControl = headers.getValue("Cache-Control");
        String contentEncoding = headers.getValue("ContentEncoding");

        System.out.println("Access Control: " + accessControl);
        System.out.println("Cache Control: " + cacheControl);
        System.out.println("Content Encoding: " + contentEncoding);

        // Getting response body
        System.out.println("\nResponse Body: \n");
        String responseBody = response.getBody().prettyPrint();
        System.out.println(responseBody);

        // Extract 3 values using JsonPath and jsonpath Query
        String nameValue = JsonPath.read(responseBody, "$.name");
        String pokedexEntry1Value = JsonPath.read(responseBody, "$.pokemon_entries[0].pokemon_species.name");
        String pokedexVersionGroupValue = JsonPath.read(responseBody, "$.version_groups[0].name");

        System.out.println("Pokedex Region Name: " + nameValue);
        System.out.println("Pokedex Entry 1: " + pokedexEntry1Value);
        System.out.println("Pokedex Version Group: " + pokedexVersionGroupValue);

    }

    @Test
    public void get_version() {

        String endpoint = "version/1/";

        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get(endpoint);

        // Getting status line
        System.out.println("Status Line: " + response.statusLine());

        // Getting status code
        System.out.println("Status Code: " + response.statusCode());

        // Getting all headers
        System.out.println("\nAll headers: \n");
        Headers headers = response.headers();
        String entireHeader = headers.toString();
        System.out.println(entireHeader);

        // Getting 3 specific headers + key/value pairs
        System.out.println("\nHere are three headers: \n");
        String date = headers.getValue("Date");
        String contentType = headers.getValue("Content-Type");
        String transferEncoding = headers.getValue("Transfer-Encoding");

        System.out.println("Date: " + date);
        System.out.println("Content-Type: " + contentType);
        System.out.println("Transfer Encoding: " + transferEncoding);

        // Getting response body
        System.out.println("\nResponse Body: \n");
        String responseBody = response.getBody().prettyPrint();
        System.out.println(responseBody);

        // Extract 3 values using JsonPath and jsonpath Query
        String nameValue = JsonPath.read(responseBody, "$.name");
        String versionURLValue = JsonPath.read(responseBody, "$.names[0].language.url");
        String pokedexVersionGroupValue = JsonPath.read(responseBody, "$.version_group.name");

        System.out.println("Version Name: " + nameValue);
        System.out.println("Version URL: " + versionURLValue);
        System.out.println("Version Group: " + pokedexVersionGroupValue);

    }

    @Test
    public void get_item_info() {

        String endpoint = "item/1/";

        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get(endpoint);

        // Getting status line
        System.out.println("Status Line: " + response.statusLine());

        // Getting status code
        System.out.println("Status Code: " + response.statusCode());

        // Getting all headers
        System.out.println("\nAll headers: \n");
        Headers headers = response.headers();
        String entireHeader = headers.toString();
        System.out.println(entireHeader);

        // Getting 3 specific headers + key/value pairs
        System.out.println("\nHere are three headers: \n");
        String date = headers.getValue("Date");
        String contentType = headers.getValue("Content-Type");
        String transferEncoding = headers.getValue("Transfer-Encoding");

        System.out.println("Date: " + date);
        System.out.println("Content-Type: " + contentType);
        System.out.println("Transfer Encoding: " + transferEncoding);

        // Getting response body
        System.out.println("\nResponse Body: \n");
        String responseBody = response.getBody().prettyPrint();
        System.out.println(responseBody);

        // Extract 3 values using JsonPath and jsonpath Query
        String itemNameValue = JsonPath.read(responseBody, "$.name");
        String itemCategoryName = JsonPath.read(responseBody, "$.category.name");
        int costValue = JsonPath.read(responseBody, "$.cost");

        System.out.println("Item Name: " + itemNameValue);
        System.out.println("Item Category: " + itemCategoryName);
        System.out.println("Cost of Item: " + costValue);

    }

    @Test
    public void get_item_categories() {

        String endpoint = "item-category/1/";

        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get(endpoint);

        // Getting status line
        System.out.println("Status Line: " + response.statusLine());

        // Getting status code
        System.out.println("Status Code: " + response.statusCode());

        // Getting all headers
        System.out.println("\nAll headers: \n");
        Headers headers = response.headers();
        String entireHeader = headers.toString();
        System.out.println(entireHeader);

        // Getting 3 specific headers + key/value pairs
        System.out.println("\nHere are three headers: \n");
        String date = headers.getValue("Date");
        String contentType = headers.getValue("Content-Type");
        String transferEncoding = headers.getValue("Transfer-Encoding");

        System.out.println("Date: " + date);
        System.out.println("Content-Type: " + contentType);
        System.out.println("Transfer Encoding: " + transferEncoding);

        // Getting response body
        System.out.println("\nResponse Body: \n");
        String responseBody = response.getBody().prettyPrint();
        System.out.println(responseBody);

        // Extract 3 values using JsonPath and jsonpath Query
        String itemCategoryValue = JsonPath.read(responseBody, "$.name");
        String itemURLValue = JsonPath.read(responseBody, "$.items[0].url");
        String pocketValue = JsonPath.read(responseBody, "$.pocket.name");

        System.out.println("Item Category Type: " + itemCategoryValue);
        System.out.println("Item URL: " + itemURLValue);
        System.out.println("Pocket/Usage: " + pocketValue);

    }

    @Test
    public void get_regions() {

        String endpoint = "region/1/";

        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get(endpoint);

        // Getting status line
        System.out.println("Status Line: " + response.statusLine());

        // Getting status code
        System.out.println("Status Code: " + response.statusCode());

        // Getting all headers
        System.out.println("\nAll headers: \n");
        Headers headers = response.headers();
        String entireHeader = headers.toString();
        System.out.println(entireHeader);

        // Getting 3 specific headers + key/value pairs
        System.out.println("\nHere are three headers: \n");
        String date = headers.getValue("Date");
        String contentType = headers.getValue("Content-Type");
        String transferEncoding = headers.getValue("Transfer-Encoding");

        System.out.println("Date: " + date);
        System.out.println("Content-Type: " + contentType);
        System.out.println("Transfer Encoding: " + transferEncoding);

        // Getting response body
        System.out.println("\nResponse Body: \n");
        String responseBody = response.getBody().prettyPrint();
        System.out.println(responseBody);

        // Extract 3 values using JsonPath and jsonpath Query
        String regionValue = JsonPath.read(responseBody, "$.name");
        String regionLocationValue = JsonPath.read(responseBody, "$.locations[0].name");
        String generationValue = JsonPath.read(responseBody, "$.main_generation.name");

        System.out.println("Region Name: " + regionValue);
        System.out.println("Location in Region: " + regionLocationValue);
        System.out.println("Generation of Region: " + generationValue);

    }

    @Test
    public void get_pokemon_moves() {

        String endpoint = "move/1/";

        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get(endpoint);

        // Getting status line
        System.out.println("Status Line: " + response.statusLine());

        // Getting status code
        System.out.println("Status Code: " + response.statusCode());

        // Getting all headers
        System.out.println("\nAll headers: \n");
        Headers headers = response.headers();
        String entireHeader = headers.toString();
        System.out.println(entireHeader);

        // Getting 3 specific headers + key/value pairs
        System.out.println("\nHere are three headers: \n");
        String date = headers.getValue("Date");
        String contentType = headers.getValue("Content-Type");
        String transferEncoding = headers.getValue("Transfer-Encoding");

        System.out.println("Date: " + date);
        System.out.println("Content-Type: " + contentType);
        System.out.println("Transfer Encoding: " + transferEncoding);

        // Getting response body
        System.out.println("\nResponse Body: \n");
        String responseBody = response.getBody().prettyPrint();
        System.out.println(responseBody);

        // Extract 3 values using JsonPath and jsonpath Query
        String moveValue = JsonPath.read(responseBody, "$.name");
        int moveCostValue = JsonPath.read(responseBody, "$.pp");
        String moveClassValue = JsonPath.read(responseBody, "$.damage_class.name");

        System.out.println("Move Name: " + moveValue);
        System.out.println("Move Cost: " + moveCostValue);
        System.out.println("Move Damage Type: " + moveClassValue);

    }

    @Test
    public void get_pokemon_info() {

        String endpoint = "pokemon/12/";

        RestAssured.baseURI = baseURI;
        RequestSpecification reqSpec = RestAssured.given();
        Response response = reqSpec.get(endpoint);

        // Getting status line
        System.out.println("Status Line: " + response.statusLine());

        // Getting status code
        System.out.println("Status Code: " + response.statusCode());

        // Getting all headers
        System.out.println("\nAll headers: \n");
        Headers headers = response.headers();
        String entireHeader = headers.toString();
        System.out.println(entireHeader);

        // Getting 3 specific headers + key/value pairs
        System.out.println("\nHere are three headers: \n");
        String date = headers.getValue("Date");
        String contentType = headers.getValue("Content-Type");
        String transferEncoding = headers.getValue("Transfer-Encoding");

        System.out.println("Date: " + date);
        System.out.println("Content-Type: " + contentType);
        System.out.println("Transfer Encoding: " + transferEncoding);

        // Getting response body
        System.out.println("\nResponse Body: \n");
        String responseBody = response.getBody().prettyPrint();
        System.out.println(responseBody);

        // Extract 3 values using JsonPath and jsonpath Query
        String pokemonNameValue = JsonPath.read(responseBody, "$.name");
        int pokemonWeightValue = JsonPath.read(responseBody, "$.weight");
        String abilityValue = JsonPath.read(responseBody, "$.abilities[0].ability.name");

        System.out.println("Pokemon Name: " + pokemonNameValue);
        System.out.println("Pokemon Weight: " + pokemonWeightValue);
        System.out.println("Best Pokemon Ability: " + abilityValue);

    }
    
}
