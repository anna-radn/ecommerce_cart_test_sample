The use case for this project is that user goes to the Webstaurant website, enters “stainless work table” in the search bar, and hits the search button. Then he looks through all the pages with matching results.
Found products should all contain the word “table” in their description. Then he adds the last found item into the cart and removes it.
To test this case I used Cucumber tool which I find very useful for automated tests. To start off, we provide necessary drivers on which we want to test and plugin all necessary dependencies in pom.xml file.
In our main folder, we create config.properties file to provide variable data. In pages folder we create all necessary pages, such as BasePage where we keep all generic methods used in the project, CartPage,
and SearchPage with their own elements and methods that will extend BasePage. In util folder we create files like BrowserFactory where the logic of used browsers is put.
In our test folder we define features, runners, steps, and testPages file. Our runner files will run the tests, and with the successful execution will provide a screenshot of the last found product and save it
into screenshot folder.
