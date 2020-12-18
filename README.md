# FoodiesDelight

The app is for all the food lovers. 
A foodie can browse through restuarants, select a restaurant, browse the menus , select the food items , add to cart , view cart and submit the order.
Also,  a restuarant personnel can login , see what orders his restaurant has receieved and from which users, address those orders and update the status accordingly.

This app consists of two sub apps-
  a. Customer side App
  b. Restaurant personnel Side App

Logins 
  a. Customer side login
  b. Restaurant side login
  c. Sign Up 
  I have commented the code that actually does the login auth for both the customer and the restaurants and havent implemented  the register user.
  Since we did not want any login checks in our course.
  
  To understand the flow of the app please refer :
  https://github.ccs.neu.edu/amrutabpathak/FoodiesDelight/blob/master/resources/FoodiesDelight.pptx
  
  https://github.ccs.neu.edu/amrutabpathak/FoodiesDelight/blob/master/resources/Foodies_Delight_App_Working.mp4
  
  
  Tech details:
  Tech Used : Recycler Views and Firebase Recycler views, Firebase, SQLLite
  
  Recycler views to have a flexible layout when the data underneath changes.
  FireBase as a real time database to store the users, placed orders etc.
  
  SQLLite to hold the temporary cart items of the user. Cart items are shown from the SQLLite DB. Once the user clicks order, the data is flushed to the firebase DB.
  
  I tried the following things :
  Successful :
  User:
  1. Logins for both the type of users 
  2. Showing up all restaurants in the receyler views.
  3. On click of a restuarant , takes you to the menu of that restuarant.
  4. Food items with their desc is also diplayed in recycler views.
  5. On click of any food item takes you to the add food item to cart and asks for qty. 
  6. Add to cart, View Cart, Delete the cart options work too.
  
  Restaurant:
  1. Login works
  2. Can see orders also in recycler views.
  
  Unsuccessful:
  Restaurant side order open menu bar to update the status and notify the user about the order status. But it will work once some time is invested. 
  
  Had to do but less time :
  Adding nice images to the restuarants and food items to make it look more appealing.
  Wanted a nice chat functionality between customer and restuarant personnel.
  Order Status update and UI.
  
  Acknowledgements and References Thanks to the following resources:
  
  https://firebase.google.com/docs
https://developer.android.com/reference/android/database/sqlite/SQLiteDatabase
https://developer.android.com/jetpack/androidx/releases/recyclerview
https://antonioleiva.com/recyclerview-listener/
https://abhiandroid.com/ui/nesting-of-layouts-android.html
https://www.youtube.com/channel/UCllewj2bGdqB8U9Ld15INAg

   Reused some of the components . Credits to hanishk

https://github.com/hanishk/Eat_It/



  


  
