# NewsApp-With-Firebase
## Student Name: Pranjali Kotgire
## University Name: San Jose State University
## Professor : Dr.Kaikai Liu
## ISA : Hari Haran Kura
## Demo:https://www.youtube.com/watch?v=04wgdx42zmQ

## Project Functionalities
1. Sign Up using firebase
2. Sign in using firebase
3. Splash Screen for mobile application
4. Search functionality where in user can search news by keywords
5. Getting news from multiple resources such as CNN news, ABC News,Google News, BBC News etc.
6. User can share news on multiple platforms such Twitter, Gmail, Facebook etc.
7. For each news there is detail view where user can view news along with brief information, video and images associated with it.
8. User can select news resouces from given list and can read news associated with particular news resource.
9. Hot Recommendation section Where user can see recent news from each news source in kenburn's format.

## Project Description
1. For bulletin cluster news app I am using firebase for user authentication, where user can sign up and sign in using firebase.
2. Splash screen will be displayed once you will be able to sign in.
3. Then you will be headed towards landing page of application where you can see all the latest news from diffrent news resources.
4. On landing page i have added search functionality where user can search news by keyword.
5. I am using android-ago dependancy which shows when the particular article has posted.
6. For showing news in a similar uniform container i am using cardview and to show those in recycer view I have added recycler view library.
7. Once you select particular news to read you will br redirected to a detail news page where you can view news along with description,video and images.
8. And if you want to share news on particular platform you can do it from detail views page just by clicking on particular news platform such as twitter,facebook,gmail,whatsapp etc.

## Step-by-step Description
1.	Firstly, I have created a sign in and signup pages for users which will be used for users to login to the application.
2.	For signup and sign in I am using firebase authentication whereas user’s data will be stored in firebase.
3.	After sign in user will see a splash screen which shows application name and I have set timeout for splash screen as 5 seconds.
4.	After 5 seconds you will be redirect to a home page which has news from multiple news resources such as google news, ABC News, CNN News, CNBC news etc. on the same page I have added a search bar where user can type a keyword and search news by keywords.
5.	All the news on home page, I am fetching from newsapi.org site.
6.	On home page I am fetching news from all resources in a card view because I wanted to have it in a uniform size container and added Recycler view that provides ability to implement the horizontal, vertical and expandable list. On the same page user can see time when the news has uploaded like 5 minutes ago, 10 minutes ago etc.
7.	Once you click on any news from home page you will redirect to its detail view page where you can see a news in details along with images, videos, description associated with it.
8.	In detail view, under each news you can see a feature where user can share news on multiple platforms such as Twitter, WhatsApp, Gmail, Facebook etc. by simply clicking on platform icon where you want to share the news.
9.	On Home page user can see a button named News Sources and by clicking that button user will redirect to a news resources list page where user can select one news resouce and can get to see news associated with that resouce in a card view format and on top latest news will be shown in kenburn's view which is zoom in like feature in android. and after clicking on any news user will be prompted to news detail page where user can see video,images and data associated with that news and from detail view page user can share news on multiple platform such as Twitter,Facebook,Whatsapp, Gmail etc.
10.	While sharing news on particular platform user has to provide credentials associated with that Platform.



## Libraries used
1. Retrofit
2. Android ago
3. Picasso
4. Recyclerview
5. Cardview
6. Firebase-core
7. firebase-auth
8. circleimageview
9. picasso
10. paperdb
11. kenburnsview
12. spots-dialog

## Project Screenshots:
1. SignIn Page
<img src="https://github.com/kotgirep/newsApp-With-Firebase/blob/main/277Images/SignIn.png" width="250">


2. Sign Up Page
<img src="https://github.com/kotgirep/newsApp-With-Firebase/blob/main/277Images/SignUp.png" width="250">


3. Splash Screen
<img src="https://github.com/kotgirep/newsApp-With-Firebase/blob/main/277Images/SplashScreen.png" width="250">


4. Landing Page
<img src="https://github.com/kotgirep/newsApp-With-Firebase/blob/main/277Images/Screen%20Shot%202021-05-26%20at%202.05.38%20PM.png" width="250">


5. With Search Functionality by typing a keyword as covid
<img src="https://github.com/kotgirep/newsApp-With-Firebase/blob/main/277Images/Searchbarupdatedss.png" width="250">


6. Detailed News Page
<img src="https://github.com/kotgirep/newsApp-With-Firebase/blob/main/277Images/DetailPage.png" width="250">

7. News Resources List Page
<img src="https://github.com/kotgirep/newsApp-With-Firebase/blob/main/277Images/Resource-List.png" width="250">

8. Selected News Resource page with kenburn's View
<img src="https://github.com/kotgirep/newsApp-With-Firebase/blob/main/277Images/kenburn-view.png" width="250">

9. Detailed View Page for Selected news
<img src="https://github.com/kotgirep/newsApp-With-Firebase/blob/main/277Images/Detail-page.png" width="250">

10. News Shared on Twitter
<img src="https://github.com/kotgirep/newsApp-With-Firebase/blob/main/277Images/Tweet.png" width="250">

11. Firebase Authentication
<img src="https://github.com/kotgirep/newsApp-With-Firebase/blob/main/277Images/Firebase-auth.png" width="500">


12. Project Architecture Diagram
<img src="https://github.com/kotgirep/newsApp-With-Firebase/blob/main/277Images/CMPE-277Architecture.png" width="500">

## Refrences
1. https://stackoverflow.com/questions/27015895/how-to-link-two-xml-pages-in-android-app-when-a-button-is-clicked
2. https://www.codegrepper.com/code-examples/java/link+to+new+page+in+android+studio (How to link pages tutorial)
3. https://www.c-sharpcorner.com/article/how-to-be-working-with-multiple-activities-and-navigate-the-activities-in-androi/ (creating multiple activities and navigation between them)
4. https://medium.com/android-news/right-way-to-create-splash-screen-on-android-e7f1709ba154 (creating splash screen in android)


