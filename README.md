# ZooManager

This project is work in progress REST application and also my little playground, where my goal is to further improve my programming skills. Currenty there are only features to register user with `ROLE_USER` authority and authentication of already existed user in database. Both return response with status `200 OK` and body with JWT.

I already created similar [project](https://github.com/Garin1998/Zoo_Manager_deprecated) as homework and this one is its expansion.

## How to run with Docker
- **Docker must be installed on yours device!**
- Clone this repository with link: `https://github.com/Garin1998/ZooManager.git`
- Provide variables to `.env` file inside project or use already provided
- Open terminal with path to project folder and type: `docker-compose up --build`

    ### Additional Information
  - default active profile is `prod`
  - initialised with default `db.sql` inside `./sql` folder database is going to have empty tables. To use features in application it is required to provide records. 

## How to run with on local machine
- Download or clone repositroy with link: `https://github.com/Garin1998/ZooManager.git`
- Open project with IDE
- Create new package with maven by using `mvn clean package -P dev`
- Open terminal inside `./target` folder with command `java -jar *.jar` where `*` is the name of created jar package by Maven

    ### Additional Information
  - with `dev` profile it is required to provide in `./src/main/resource/application-dev.yaml` datasource properties
  - initialised with default `db.sql` inside `./sql` folder database is going to have empty tables. To use features provided by the application it is required to create some records e.g. roles 



