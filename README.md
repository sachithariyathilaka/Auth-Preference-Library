# Auth Preference

Shared Preference library for save &amp; fetch user data &amp; user headers 

You can save user id, login state, user headers as arraylist & fetch those values 


# Setup Auth Preference

Add Jitpack on your project level gradle file

```allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
  
Add Auth Preference on your app level gradle file

```implementation 'com.github.sachithariyathilaka:AuthPreference:1.1'```

# Use Auth Preference

You can use insert user data & headers as using authUserData & saveUserHeaders methods.

Also you can fetch user id, headers & user login state by seperately. 

