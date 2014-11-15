CMSC434-IA05
Angela Mei, Ambily Bose
============

Instructions:
Download the Zip File.
Open Android Studio.
Import the project. 
Run it. (Requires API 18, We prefer Nexus 4 as the device for best viewing experience )


Clock One - This is a very basic clock in terms of design, however has a preferences that allows the user to customize various properties such as Timezone, Time Display format, and Time Convention. The settings are persistent. The settings can be accessed by clicking on the Menu, then the preference option. Revert back to the Clock either by clicking on the Menu, then clock or the back button.

Clock Two - Custom View clock with twelve circles representing each hour. For the current hour, the circle is red while the previous hours are black and the future hours are gray. The hour circle's radius increases based on the second and the opacity of the circle gets darker as the minute approaches the next hour. 

MyActivity is the main class which creates a Timer that is used in the refresh() function. In this function, postInvalidate() is called for the CircleView in order to update the view every second. 

CircleView: Custom View class that creates the twelve circles in the onDraw() method. There is a counter within that keeps track of global variables seconds, minutes, and hour. Based on the time, the onDraw() method will create different views. There are also functions defaultCircles (which creates the static circles) and findCos() and findSin() which is used to help create the position of the circles based on the degree from the origin. 

activity_my.xml: XML file detailing the layout of the app. 
