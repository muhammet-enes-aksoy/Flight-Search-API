# Flight Search API

## About Project
A backend API will be developed for a flight search application.

## Project Requirements

- Data Modeling: Design and Modeling of Information to be Stored in a Database
- Crud: A CRUD structure needs to be designed.
- A Search API needs to be developed that lists flights matching the given departure location, arrival location, departure date, and return date. If the return date is not provided, it's a one-way flight; if provided, it's a round-trip flight. For a one-way flight, a single flight record should be provided; for a round-trip flight, two flight records should be provided.
- REST should be used to expose services externally.
- An Authentication structure should be implemented to verify the user's identity and grant authorization.
- Scheduled background jobs: A scheduled job should be created that sends a request to a third-party API every day to retrieve flight information and store it in the database.
- Git: The Git version control system should be used. The project will be uploaded to GitHub.
- Documentation: API documentation should be done using Swagger.
  
## Technologies
- Java Spring Boot
- PostgreSQL

## Swagger Screenshots

### User Registration Controller

![Ekran görüntüsü 2023-08-20 204938](https://github.com/enessaks/FlightSearchAPI/assets/97848966/2aebe17b-78ab-431e-a3da-2bf9acf1090c)

 - Register
   ![Ekran görüntüsü 2023-08-20 204905](https://github.com/enessaks/FlightSearchAPI/assets/97848966/8c98eeb2-a6f5-4225-bef6-33417237ce70)
   ![Ekran görüntüsü 2023-08-20 205050](https://github.com/enessaks/FlightSearchAPI/assets/97848966/24cf01a6-20f8-4ace-8acc-2ef399031883)

 - Authenticate
   ![Ekran görüntüsü 2023-08-20 205102](https://github.com/enessaks/FlightSearchAPI/assets/97848966/9ecb7beb-5e78-4374-80c1-752a29a1f489)
   ![Ekran görüntüsü 2023-08-20 205113](https://github.com/enessaks/FlightSearchAPI/assets/97848966/fa1a34d9-7892-4124-a09c-dc5d524f6326)

![Ekran görüntüsü 2023-08-20 205125](https://github.com/enessaks/FlightSearchAPI/assets/97848966/863fd3ed-c848-476f-b4f0-b650afdd0861)


### User Controller

![Ekran görüntüsü 2023-08-20 204949](https://github.com/enessaks/FlightSearchAPI/assets/97848966/4f5ef977-f182-41a4-8b70-6bff9ccbe87e)
 
  - Find All Users
    ![Ekran görüntüsü 2023-08-20 205145](https://github.com/enessaks/FlightSearchAPI/assets/97848966/7f4c5d41-62f7-4316-bd22-2387bf43fc47)

  - Find By Id
    ![Ekran görüntüsü 2023-08-20 205206](https://github.com/enessaks/FlightSearchAPI/assets/97848966/9254a22c-590f-4c1f-9f2d-0e2d2a7b21ff)

  - Delete User
    ![Ekran görüntüsü 2023-08-20 205233](https://github.com/enessaks/FlightSearchAPI/assets/97848966/2269ec8b-b085-452d-af8a-6cd5e82c0c0a)

    
### Airport Controller

![Ekran görüntüsü 2023-08-20 204943](https://github.com/enessaks/FlightSearchAPI/assets/97848966/e1808fff-d0a9-4cda-b864-94b8255c6532)

  - Find All Airports
    ![Ekran görüntüsü 2023-08-20 205253](https://github.com/enessaks/FlightSearchAPI/assets/97848966/5af1871d-451d-4f47-9239-956e384b52c2)

  - Find By Id
    ![Ekran görüntüsü 2023-08-20 205313](https://github.com/enessaks/FlightSearchAPI/assets/97848966/df1524fa-a987-40d0-ab82-ee9ca16c4ced)

  - Save Airport
   ![Ekran görüntüsü 2023-08-20 205349](https://github.com/enessaks/FlightSearchAPI/assets/97848966/3166d820-0469-4ae7-90d6-3bc5efb35d9b)

  - Delete Airport
    ![Ekran görüntüsü 2023-08-20 205409](https://github.com/enessaks/FlightSearchAPI/assets/97848966/0b40217c-3dd9-435a-8620-9c87d12f3d4d)

 ### Flight Controller   

![Ekran görüntüsü 2023-08-20 204933](https://github.com/enessaks/FlightSearchAPI/assets/97848966/26926142-f67d-4804-a4e9-b9fb4b0de134)

  - Find All Flights
    ![Ekran görüntüsü 2023-08-20 205618](https://github.com/enessaks/FlightSearchAPI/assets/97848966/bd4c8822-7632-49b4-a0f9-fe7baa70f92f)

  - Find By Id
    ![Ekran görüntüsü 2023-08-20 205632](https://github.com/enessaks/FlightSearchAPI/assets/97848966/d02c6972-7f23-4206-b03a-35d39d815241)

  - Update Flight
    ![Ekran görüntüsü 2023-08-20 205730](https://github.com/enessaks/FlightSearchAPI/assets/97848966/990c5993-dd16-42b0-80f3-93bec9118f6f)

  - Delete Flight
    ![Ekran görüntüsü 2023-08-20 205748](https://github.com/enessaks/FlightSearchAPI/assets/97848966/9a311c55-9b2e-44cd-996a-a9fada235773)

  - Save Flight
    ![Ekran görüntüsü 2023-08-20 205829](https://github.com/enessaks/FlightSearchAPI/assets/97848966/133236d4-d5d3-434c-b3dc-93d1ef333f9b)

  - Search One Way Flight
    ![Ekran görüntüsü 2023-08-20 205859](https://github.com/enessaks/FlightSearchAPI/assets/97848966/5f742b9e-a2f6-44e0-b5ac-f6493e5c5495)

  - Search Two Way Flight
    ![Ekran görüntüsü 2023-08-20 205915](https://github.com/enessaks/FlightSearchAPI/assets/97848966/fb848114-f80b-4ffd-9439-7a67afaad9ab)


