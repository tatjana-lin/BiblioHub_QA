# BiblioHub_QA
## Project Overview:
This is my graduation project after the QA Manual and Automation Tester course in AIT-TR school. I was a part of a student team. My role - QA engineer. 

The goal of my project is automation of testing of the BiblioHub website, created by our team. The project’s initial name was Bibliothèque. Here you can get acquainted with the code
[Backend](https://github.com/Anarchitector/Bibliotheque_backend)
[Frontend](https://github.com/Anarchitector/Bibliotheque_frontend).

BiblioHub was developed as a user-friendly and efficient platform enabling users to comfortably search for books in libraries and reserve books from the library with the most convenient location. Users can search for books by title, author’s name or ISBN. Key features include user registration and authentication, updating user profile, book search, adding to cart and completing book reservation.
## Key Features:
### 1. User Authentication and Roles:
  - Users can register on the platform using email and password.
  - Authentication occurs via entering credentials.
  - User roles are categorized into User, Admin and Library.
### 2. Book search
- All users can perform a book search.
- Users can search for books by title, author’s name or ISBN.
### 3. Book reservation
- All Users can add books to their cart.
- Authenticated Users can complete a reservation.
*****
## Testing Phases:
### 1. Analysis
At the very beginning of the project I created user-story based mind maps and state transition diagrams to visualize how the functionality of the application would work step by step. For this purpose I used tools like Miro and MindMup.  
[MindMap registration](images/Unregistered_User_registers.png)  
[MindMap login](images/Registered_User_logs_in.png)  
[MindMap book search & reservation](images/Registered_User_books_a_book.png)  
[STD registration](images/STD_registration.png)  
[STD login](images/STD_login.png)  
[STD book search](images/STD_bookSearch.png)

### 2. Planning
In a team we developed a Test Plan, outlining the functions to test, test design techniques, acceptance criteria, and more. Then a Requirement Specification was created with the help of the TestLink management system.  
[Test plan](https://drive.google.com/file/d/1WsVgYR7H76yXzTCSmeVoLPlB_iPpsDcC/view?usp=drive_link)  
[Requirements spec](https://docs.google.com/document/d/1paCxmm0PGLtlIt26bxyprq1z2ZOXh2kL/edit?usp=drive_link&ouid=115695229689061073439&rtpof=true&sd=true)
### 3. Test design
In a team we wrote over 100 test cases in TestLink, both positive and negative. I also prepared a number of tables for the tests, using test design techniques such as equivalence partitioning and boundary value analysis.   
[Test spec](https://docs.google.com/document/d/1tLP-NSAKJULIRasVYTczwzm7cK4-CYFb/edit)  
[Table positive example](src/test/resources/user.csv)  
[Table negative example](https://github.com/tatjana-lin/Bibliotheque_QA/blob/main/src/test/resources/regNegEmail.csv)

### 4. Test automation & execution 
UI testing I automated with the help of Selenium (design pattern - Page Object Model) and TestNG. Additionally, I used a Logger and Screenshots for reports to ensure comprehensive logging of test execution.  
In total I created 125 [UI tests](https://github.com/tatjana-lin/Bibliotheque_QA/tree/main/src/test/java/com/bibliotheque/tests).  
API testing was at first completed using Postman
[My Postman Collection](https://github.com/tatjana-lin/Bibliotheque_QA/blob/main/BiblioHub.postman_collection.json)  
and then automated with the help of REST Assured and Lombok libraries.  
In total I created 144 [API tests](https://github.com/tatjana-lin/Bibliotheque_QA/tree/main/src/test/java/com/bibliotheque_API/tests).  
I also used Jenkins for continuous integration (CI).

### Languages and Tools:
<p align="left">
  <a href="https://www.selenium.dev/" target="_blank">
    <img src="images/selenium_logo.png" alt="Selenium" width="40" height="40"/>
  </a>
  <a href="https://rest-assured.io/" target="_blank">
    <img src="https://avatars.githubusercontent.com/u/19369327?s=200&v=4" alt="RestAssured" width="40" height="40"/>
  </a>
  <a href="https://testng.org/" target="_blank">
    <img src="images/testNG_logo.png" alt="TestNG" width="40" height="40"/>
  </a>
  <a href="https://projectlombok.org/" target="_blank">
    <img src="images/Lombok_logo.png" alt="Lombok" width="40" height="40"/>
  </a>
  <a href="https://wave.webaim.org/" target="_blank">
    <img src="https://wave.webaim.org/favicon.ico" alt="Wave" width="40" height="40"/>
  </a>
  <a href="https://www.java.com/" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="Java" width="40" height="40"/>
  </a>
  <a href="https://www.jetbrains.com/idea/" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/intellij/intellij-original.svg" alt="IntelliJ IDEA" width="40" height="40"/>
  </a>
  <a href="https://www.postman.com/" target="_blank">
    <img src="https://www.vectorlogo.zone/logos/getpostman/getpostman-icon.svg" alt="Postman" width="40" height="40"/>
  </a>
  <a href="https://www.jenkins.io/" target="_blank">
    <img src="https://www.vectorlogo.zone/logos/jenkins/jenkins-icon.svg" alt="Jenkins" width="40" height="40"/>
  </a>
  <a href="https://testlink.org/" target="_blank">
    <img src="https://avatars.githubusercontent.com/u/10183815?s=48&v=4" alt="TestLink" width="40" height="40"/>
  </a>
  <a href="https://www.atlassian.com/software/jira" target="_blank">
    <img src="images/jira_logo.png" alt="Jira" width="40" height="40"/>
  </a>
  <a href="https://www.mindmup.com/" target="_blank">
    <img src="images/mindMup_logo.png" alt="MindMup" width="40" height="40"/>
  </a>
  <a href="https://miro.com/" target="_blank">
    <img src="images/Miro_logo.png" alt="Miro" width="40" height="40"/>
  </a>
  <a href="https://www.postgresql.org/" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/postgresql/postgresql-original.svg" alt="PostgreSQL" width="40" height="40"/>
  </a>
  <a href="https://code.visualstudio.com/" target="_blank">
    <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/vscode/vscode-original.svg" alt="VS Code" width="40" height="40"/>
  </a>
</p>
