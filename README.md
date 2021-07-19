# charter
Demo project for Charter Communications using Spring Boot

To run it, simply clone the repository and run the command "mvn spring-boot:run".

The app will open port 8080, so now you can test the api call getRewards in your browing entering "http://localhost:8080/getRewards?uId=X", where X
is a user id between 2 and 50 and will return the number of points rewarded to that user. If you don´t specify a userId, then it will return 0.
You can see in the console the purchases assigned to that user.

For this sample purposes, a sample data of purchases was created with random data, assigning a random userId (from 2 to 50) and a random purchase
subtotal (between $15 and $225). This would be obtained from a DB in a production environment.
