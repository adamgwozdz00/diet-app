# diet-app
Calories calculator app in build...
It will be an app that allows the user to plan his daily diet and calculate the amount of calories, protein, fat, carbs and sugar.

Description:
Application gets data from rest api https://www.edamam.com/ then map to the food class.
All users and diet information data is collected in two tables in MySql database. It allows registered users to search food information and create their own menu with calculated nutrition values. 

Implemented functionality:
- [x] Search food using rest api and display on site.
- [x] Add food to the user diet plan.
- [x] Delete food from the user diet plan.
- [ ] Count total daily amount of nutritional values. 
- [x] Register using username, name and password
- [ ] Register using username, email(with verification), password.
- [x] Login.
- [x] Register and login exceptions. 
- [ ] Food and diet  exceptions.


Dependencies:
1. Spring Boot 2.4.1
2. Spring Security
3. Data JPA
4. Hibernate Validator
5. Jackson 
6. Thymeleaf
7. Lombok

Technologies:
1. Java 15
2. MySql
3. JUnit5

Prewiew

![login](https://user-images.githubusercontent.com/70854700/105379557-39dc4800-5c0d-11eb-9125-1f3793676ab6.png)

![register](https://user-images.githubusercontent.com/70854700/105379628-51b3cc00-5c0d-11eb-99c6-a66a684fa0ab.png)

![search](https://user-images.githubusercontent.com/70854700/105379690-62fcd880-5c0d-11eb-9f6a-33e27b043f06.png)

![search2](https://user-images.githubusercontent.com/70854700/105379727-6b551380-5c0d-11eb-8ef5-347d605b7e2f.png)
![search3](https://user-images.githubusercontent.com/70854700/105379796-7c9e2000-5c0d-11eb-891c-a87b8a29d3af.png)

![menu1](https://user-images.githubusercontent.com/70854700/105379848-8de72c80-5c0d-11eb-90d8-ea6dd501c466.png)


![menu2](https://user-images.githubusercontent.com/70854700/105379925-a0616600-5c0d-11eb-9e9e-8f8d67240f03.png)
