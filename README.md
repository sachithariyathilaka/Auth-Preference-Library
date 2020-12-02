# Auth Preference
Shared Preference library for save &amp; fetch user data &amp; user headers 

You can save user id, login state, user headers as arraylist & fetch those values

# Instructions

Step 01: Add Jitpack on your project level gradle file

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Step 02: Add Auth Preference on your app level gradle file

implementation 'com.github.sachithariyathilaka:AuthPreference:1.1'

Step 03: You can use insert user data & headers as using authUserData & saveUserHeaders methods.

Step 04: Also you can fetch user id, headers & user login state by seperately. 

