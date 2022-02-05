# ReWrite

Re-write is an application for generating letters, CV in a short duration. It also takes care of making the output as per user requirements as it provides various samples to the user to choose from.


## Software and API 

### Andriod Studio

Android Studio is used to compile all the code together to create an application. Android studio has multiple libraries which can be imported in your java file. Apart from the most common libraries, we have used Spannable, SpannableStringBuilder, StyleSpan which helps in styling the font for example we have edited some text as italics  and some as bold. With the help of toast function, we have made it easier for the user to understand if something is wrong. More type of libraries have been included such as PageAdapter, LayoutInflater etc. With the help of such libraries we have successfully implemented slide view. A user can simply slide around the app jump from source activity to multiple activities. We have also implemented scroll view which allows the user to stay on one activity and enter multiple inputs rather moving to different activities. The implementation of these view wherever required have made the application user friendly, as the user will not run into any hassles at the time of creating their letter or CV. We have implemented spinner widget which displays a drop-down menu, allowing user to choose from multiple options.

Android Studio allows the creator to ask for specific hardware permission from the user.

In our app we have asked the user to allow the application to store a .pdf file in the local storage of user's mobile phone.


### Firebase
We have used firebase for login, Sign up page and for real time data-base. The user must create an account in order to use the application. The sign-up page asks the user to enter his name, last name, username, email address, phone number and password. The application checks for valid email address and phone number. With the help of firebase, we have achieved verification via email. According to which a mail is been sent to the user given email which has a verification link, thus authenticating a valid user.

The account details are stored in the firebase. Once the user has signed up, his username and password are verified each time the user logs in. A real-time database is a database system which uses real-time processing to handle workloads whose state is constantly changing. 

As multiple users sign up, the records are constantly updated so that when a user logs in, his credentials are checked and verified and only if the username and password match in the database the user is given access to the application or else a toast is given stating “invalid username/password”.

### SQLite

In contrast to many other database management systems, SQLite is not a client–server database engine. Rather, it is embedded into the end program
Re-write stores the frequently used details from the user in client/local storage so that retrieving information is faster.
SQLite uses an unusual type system for an SQL-compatible DBMS.
We keep on adding user entered values in the database, all values are stored in their respective column. Re-write has three different databases one stores the address of user, second stores the educational qualification and key skills of the user.
The use of three different databases is that if a user wants to use preexisting data, he can just skip the respective activity as the database won’t be updated, previous existing values will be used.

