## Running with docker-compose
First download wait-for-it, by executing:
> git submodule init

> git submodule update

Now the project can be built and run by executing:
> docker-compose -f docker-compose.dev.yml up --build

This runs the mortgage-plan Java application in one container and a 
MySQL database for it in another container.

## Running without docker-compose
Tests can be run with:
> gradlew test

And the application itself with:
> gradlew bootRun

A MySQL database is required to run the application.

## Using mortgage-plan
If mortgage-plan can be given a file name for a csv file to import 
into its database. The format of the file is expected to look like 
prospects.txt. No data is imported if the format is different.

prospects.txt can be imported with the following command:
> gradlew bootrun --args="prospects.txt"

When mortgage-plan is running, it serves a plain HTML interface on 
port 8080. Through the HTML interface, new data can be added, and 
existing data is shown. When running mortgage-plan locally, the web 
interface can be accessed by navigating to localhost:8080 with a web
browser.
