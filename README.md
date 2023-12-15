# Project Description
This project is a crash course of compose UI , how to build views using compose ui instead of xml views.

# Compose UI 
 Jetpack Compose UI it is a new way of building ui views in  android development.in compose ui we use Kotlin to build UI instead of using XML . 
 compose UI is called Declarative UI that use states, it is a new way of thinking.

# Compose : how it works ?
composable function run sequentially.

# Basic compose designs:
 ### Two text views above each other 
```kotlin
Column {
 Text(
  text = "Hello World",
  color = Color.Red,
  fontSize = 30.sp
 )
 Text(
  text = "Hello Mina",
  color = Color.Blue,
  fontSize = 30.sp
 )
}
```
