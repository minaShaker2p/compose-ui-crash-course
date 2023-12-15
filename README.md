# Project Description

This project is a crash course of compose UI , how to build views using compose ui instead of xml
views.

# Compose UI

Jetpack Compose UI it is a new way of building ui views in android development.in compose ui we use
Kotlin to build UI instead of using XML .
compose UI is called Declarative UI that use states, it is a new way of thinking.

# Compose : how it works ?

1-composable function run sequentially.
2- for every composable you can add modifiers.

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
        Icon(imageVector = Icons.Default.Add,
            contentDescription = null,
            modifier = Modifier.size(100.dp))
    }
}
 ```