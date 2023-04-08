Amiibo Collection Manager - README

This project is a web application that allows users to manage their Amiibo figure and card collections.

Running

Run this using sbt.

sh
Copy code
sbt run
And then go to http://localhost:9000 to see the running web application.

Main Features

Users can view and search for Amiibo figures and cards.
Users can log in to manage their personal Amiibo collection.
Users can create a new account to start their own collection.
Controllers

There is a controller already in place to make sure this mostly empty project works.

TestController.java
AmiiboController
This class is responsible for handling requests related to Amiibo figures and cards. It includes methods for:

Retrieving a list of Amiibo figures based on the search name.
Retrieving a list of Amiibo cards based on the search name.
Displaying the About Amiibo page.
Displaying the Home page.
Retrieving a user's collection of Amiibo cards based on the search name.
SessionsController
This class is responsible for handling user authentication and user account management. It includes methods for:

Displaying the login page.
Authenticating users based on their email and password.
Creating a new user account with an email and password.
Usage

Clone the repository to your local machine.
Ensure you have the necessary dependencies installed.
Run the application using your preferred development environment.
Access the web application through your browser.
