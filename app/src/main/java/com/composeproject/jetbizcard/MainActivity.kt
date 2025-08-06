package com.composeproject.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.composeproject.jetbizcard.ui.theme.JetBizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetBizCardTheme {
                // If CreateBizCard() now uses Scaffold,
                // Scaffold will handle the background.
                // The Surface here might be redundant unless you have specific reasons
                // to keep it (e.g., overriding the default Scaffold background).
                CreateBizCard()
            }
        }
    }
}


@Composable
fun CreateBizCard() {
    // Scaffold provides the basic visual layout structure with optional slots (top bar, bottom bar, etc.)
    Scaffold { innerPadding ->
        // Surface is a basic container with background color and elevation (used for theming)
        Surface(
            modifier = Modifier
                .fillMaxSize() // Take full screen size
                .padding(innerPadding) // Respect Scaffold's padding
        ) {
            // Card creates a styled container with elevation and rounded corners
            Card(
                modifier = Modifier.padding(12.dp), // Outer padding around the card
                shape = RoundedCornerShape(corner = CornerSize(15.dp)), // Rounded edges
                colors = CardDefaults.cardColors(containerColor = Color.White), // White background
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Drop shadow
            ) {
                CreateImageProfile()
            }
        }
    }
}

@Composable
fun CreateImageProfile() {
    // Column arranges its children vertically and centers them horizontally
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        EmployeeImage()
        EmployeeInfo()
        CreateButton()
    }
}

@Composable
fun EmployeeImage() {
    // Box used to contain and style the circular profile image
    Box(
        modifier = Modifier
            .size(150.dp) // Fixed size of the circular image area
            .border(
                BorderStroke(4.dp, Color.LightGray), // Circular light gray border
                CircleShape
            )
            .shadow(4.dp, CircleShape) // Circular shadow
            .clip(CircleShape), // Crop image to a circle
        contentAlignment = Alignment.Center // Center image inside the Box
    ) {
        // Image composable that displays the profile image
        Image(
            painter = painterResource(id = R.drawable.ic_profile_image), // Drawable resource
            contentDescription = "Profile Image", // Accessibility label
            contentScale = ContentScale.Crop, // Crop image to fill Box
            modifier = Modifier.fillMaxSize() // Fill entire Box area
        )
    }
    // Divider between the image and the text
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        thickness = DividerDefaults.Thickness,
        color = DividerDefaults.color,
    )
}

@Composable
fun CreateButton() {
    val buttonClickedState = remember { mutableStateOf(false) }

    Button(
        onClick = {
            buttonClickedState.value = !buttonClickedState.value

        },
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        if (buttonClickedState.value) {
            Text(text = "Hide Portfolio")
        } else {
            Text(text = "See Portfolio")
        }
    }
    if (buttonClickedState.value) {
        Portfolio()
    } else {
        Box {}
    }
}

@Composable
fun EmployeeInfo() {
    // You can add more card content here (name, job title, contact info, etc.)
    val nameValue = stringResource(id = R.string.main_name)

    Text(
        modifier = Modifier.padding(10.dp),
        text = stringResource(
            id = R.string.main_name_format,
            nameValue
        ), // Pass nameValue as a format argument
        style = MaterialTheme.typography.titleLarge
    )

    Text(
        // You might want some padding here too, e.g., Modifier.padding(top = 4.dp)
        text = stringResource(id = R.string.title_android_programmer), // Use stringResource for this too
        // You can also add style = MaterialTheme.typography.titleMedium or bodyLarge etc.
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun Portfolio() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(4.dp),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        border = BorderStroke(2.dp, color = Color.LightGray),
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp), // Padding inside each item
            horizontalAlignment = Alignment.CenterHorizontally // This will center the children elements
        ) {
            Text(
                style = MaterialTheme.typography.titleLarge,
                text = "Project List",
            )

            val projectList = listOf("Project 1", "Project 2", "Project 3", "Project 4", "Project 5", "Project 6", "Project 7")
            val projectDescription =
                listOf("Brewery Application", "GraphQL Implementation", "Catalog-Util-Services", "Inventory-Util-Services", "Location-Util-Services", "Order-Util-Services", "Payment-Util-Services")
            PortfolioContent(projectList, projectDescription)
        }
    }
}

@Composable
fun PortfolioContent(projectList: List<String>, projectDescription: List<String>) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 20.dp), // Overall padding for the LazyColumn
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 8.dp
        ) // Padding for content inside
    ) {
        // The `items` extension function for List<T>
        items(projectList) { projectTitle ->
            // Here you define how each item (projectTitle) looks
            // You can use the index if you need to access projectDescription,
            // but it's safer to combine your data if possible (see note below)

            // Assuming projectList and projectDescription have the same size
            // and correspond to each other by index.
            val index = projectList.indexOf(projectTitle) // Be careful if titles are not unique
            val description = if (index != -1 && index < projectDescription.size) {
                projectDescription[index]
            } else {
                "No description available" // Fallback
            }

            ProjectItem(title = projectTitle, description = description)
            Spacer(modifier = Modifier.height(8.dp)) // Add some space between items
        }

        // Alternative if you want to use the index directly (less safe if list is modified)
        /*
        itemsIndexed(projectList) { index, projectTitle ->
            val description = projectDescription.getOrElse(index) { "No description" }
            ProjectItem(title = projectTitle, description = description)
            Spacer(modifier = Modifier.height(8.dp))
        }
        */
    }
}


// A new composable to represent how each project item is displayed
@Composable
fun ProjectItem(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Text(
            modifier = Modifier
                .padding(10.dp)
                .align(Alignment.CenterHorizontally),
            text = title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            // Optional: If you want the text itself to be center-aligned
            // (for multi-line text where each line is centered relative to itself)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = description,
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Composable
fun SmallExample() {
    // To center the SmallFloatingActionButton, wrap it in a Box
    // and set the Box's contentAlignment.
    Box(
        modifier = Modifier
            .fillMaxSize(), // The Box needs a defined size to center within.
        // fillMaxSize() makes it take all available space.
        // If this Box is inside another container with a specific size,
        // it will center within that container.
        contentAlignment = Alignment.TopCenter // This centers the child (the FAB)
    ) {
        SmallFloatingActionButton(
            onClick = { /*TODO*/ },
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.secondary
        ) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Small floating action button.",
                tint = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}