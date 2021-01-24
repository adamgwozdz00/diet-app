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
- [x] Count total daily amount of nutritional values. 
- [x] Register using username, name and password
- [ ] Register using username, email(with verification), password.
- [x] Login.
- [x] Register and login exceptions. 
- [ ] Food and diet  exceptions.
- [ ] Mobile view.


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
![Zrzut ekranu 2021-01-24 o 22 00 21](https://user-images.githubusercontent.com/70854700/105643424-17a62c80-5e90-11eb-8ccd-aab740fb84d3.png)
![Zrzut ekranu 2021-01-24 o 22 00 31](https://user-images.githubusercontent.com/70854700/105643425-18d75980-5e90-11eb-8c3a-3c486c9588f4.png)
![Zrzut ekranu 2021-01-24 o 22 00 49](https://user-images.githubusercontent.com/70854700/105643427-196ff000-5e90-11eb-903e-2b4497d51b7c.png)
![Zrzut ekranu 2021-01-24 o 22 01 01](https://user-images.githubusercontent.com/70854700/105643428-196ff000-5e90-11eb-9fa7-b328603e4253.png)
![Zrzut ekranu 2021-01-24 o 22 01 13](https://user-images.githubusercontent.com/70854700/105643429-1a088680-5e90-11eb-84d2-453191213378.png)
![Zrzut ekranu 2021-01-24 o 22 01 31](https://user-images.githubusercontent.com/70854700/105643430-1aa11d00-5e90-11eb-8f60-0997632ade7a.png)
![Zrzut ekranu 2021-01-24 o 22 01 57](https://user-images.githubusercontent.com/70854700/105643431-1aa11d00-5e90-11eb-9986-aaf0e4bc8320.png)
