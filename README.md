# Project Description

This project is a crash course of compose UI , how to build views using compose ui instead of xml
views.

# Compose UI

Jetpack Compose UI it is a new way of building ui views in android development.in compose ui we use
Kotlin to build UI instead of using XML .
compose UI is called Declarative UI that use states, it is a new way of thinking.

# Compose : how it works ?

* Composable function run sequentially.
* For every composable you can add modifiers.
* Composable function is a regular function annotated by @Composable , this enable other composable
  within it .
* with composable , an Activity remains the entry point to an android app.
* With composable , you use setContent() to define your layout but instead of using XML ,you use a
  composable functions within it.
* In compose you don't hide UI element, simply you don't add in composition. so they are not added
  to the UI tree that compose generate.

# Recomposition:

Compose apps transform data into UI by calling composable functions , if your data changes, compose
re-execute these function with the new data, creating an updated UI.

State and MutableState are interfaces that hold some value and trigger UI updates (recompositions)
whenever that value changes.

# State Hoisting :

In Composable functions , state that is read and modified by multiple function should be live in a
common ancestor - this process is called state hoisting . to hoist means to elevate or raise.

making state hoistable avoid duplicate duplicate state and introducing bugs ,helps reuse composable
,making composable easier to test.

# Persisting State:

Imagine the case when you run the app and click buttons then you rotate ,then you will lose all
states . the `remember` function works ** only as long as the composable is kept in the
Composition ** . so when you rotate , the whole activity is restarted so all state is lost.

### Solution :

instead of using `remember` you can use `rememberSaveable` , this will save each state surviving
Configurations changes (like rotation) and process kill.

```kotlin
   var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
```

## Notes :

### When importing classes related to Jetpack Compose in this project, use those from:

* androidx.compose.* for compiler and runtime classes.
* androidx.compose.ui.* for UI toolkit and libraries.

### LazyColumn and LazyRow are equivalent to RecyclerView in Android Views.

* the LazyColumn API provides an items element within its scope, where individual item rendering
  logic is written.

## Important elements in Compose :

### modifier parameter :

Modifiers tell a UI element how to lay out, display, or behave within its parent layout.
there is a list of compose
modifier . [List of Compose modifiers](https://developer.android.com/jetpack/compose/modifiers-list).

### Multiple Modifiers :

to add multiple modifiers to an element , you simply chain them .

```kotlin
    modifier = Modifier.fillMaxWidth().padding(4.dp)
```

### Weight Modifier:

the weight modifier makes the element fill the available space.making it flexible, effectively
pushing away all other elements that doesn't have weight.which are called inflexible.

```kotlin
Row(modifier = Modifier.padding(24.dp)) {
    Column(
        modifier = Modifier.weight(1f)
    ) {
        Text(text = "Hello")
        Text(text = "$name!")
    }
    ElevatedButton(onClick = { /*TODO*/ }) {
        Text(text = "Show more")
    }
}
```

# Basic compose designs:

### Two text views above each other (Vertical Orientation) :

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

### Two text views above each other in center of the screen (Vertical Orientation) :

```kotlin
  Column(
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxSize()
) {
    Text(
        text = "Hello World",
        color = Color.Red,
        fontSize = 30.sp
    )
    Text(
        text = "Hello",
        color = Color.Blue,
        fontSize = 30.sp
    )
}
```

### Two text views beside each other (Horizontal  Orientation) :

```kotlin
Row(
    horizontalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxSize()
) {
    Text(
        text = "Hello World",
        color = Color.Red,
        fontSize = 30.sp
    )
    Text(
        text = "Hello",
        color = Color.Blue,
        fontSize = 30.sp
    )
}
```

### How to create FrameLayout (BOX):

```kotlin
  Box(
    modifier = Modifier.fillMaxSize()
) {
    Text(
        text = "Hello World",
        color = Color.Red,
        fontSize = 30.sp,
        modifier = Modifier.align(Alignment.Center)
    )
}
```

### Create Image with source:

```kotlin
  Image(
    painter = painterResource(id = R.drawable.ic_launcher_foreground),
    contentDescription = null,
    modifier = Modifier.background(Color.Black)
)
```

### Create Icon with image vector:

```kotlin
     Icon(imageVector = Icons.Default.Add, contentDescription = null)
```

### How to change composable visibility based on conditional statement:

```kotlin
 if (name.length > 5) {
    Icon(imageVector = Icons.Default.Add, contentDescription = null)
}
 ```

### How to display composable 10 times in column horizontally :

```kotlin
 Column {
    for (i in 1..10) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null)
    }
}
 ```

### How to  create a simple list of 10 items :

```kotlin
LazyColumn(Modifier.fillMaxSize()) {
    items(count = 10)
    { i ->
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
    }
}
 ```

## Resources :

[Jetpack Compose basics](https://developer.android.com/codelabs/jetpack-compose-basics#0).

[The Jetpack Compose Beginner Crash Course ](https://www.youtube.com/watch?v=6_wK_Ud8--0).


## Next steps : 
[Jetpack Compose for Android Developers](https://developer.android.com/courses/jetpack-compose/course)

[Thinking in Compose](https://developer.android.com/jetpack/compose/mental-model)