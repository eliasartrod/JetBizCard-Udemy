package com.composeproject.jetbizcard.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.sp

// 1. Define custom FontFamilies if needed (example)
// val appFontFamily = FontFamily(
//     Font(R.font.my_custom_font_regular, FontWeight.Normal),
//     Font(R.font.my_custom_font_bold, FontWeight.Bold),
//     Font(R.font.my_custom_font_italic, FontWeight.Normal, FontStyle.Italic)
// )

// Set of Material typography styles to start with
// You are customizing the defaults provided by MaterialTheme
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default, // Or your custom appFontFamily
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp,
        color = Color.Black // Default color for bodyLarge
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default, // Or your custom appFontFamily
        fontWeight = FontWeight.Bold, // Changed to Bold for example
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp,
        color = Color.DarkGray // Example color
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default, // Or your custom appFontFamily
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp,
        color = Color.Gray // Example color
    )
    // You can continue to override other Material styles like:
    // displayLarge, displayMedium, displaySmall,
    // headlineLarge, headlineMedium, headlineSmall,
    // titleMedium, titleSmall,
    // bodyMedium, bodySmall,
    // labelLarge, labelMedium
)

// 2. Define additional, independent TextStyles
val MyCustomHeadline = TextStyle(
    fontFamily = FontFamily.Serif, // Example: using a different font family
    fontWeight = FontWeight.Bold,
    fontSize = 28.sp,
    color = Color.Red,
    letterSpacing = 1.2.sp
)

val MyCustomCaption = TextStyle(
    fontFamily = FontFamily.Default, // Or your custom appFontFamily
    fontWeight = FontWeight.Light,
    fontStyle = FontStyle.Italic,
    fontSize = 12.sp,
    color = Color.Blue,
    lineHeight = 16.sp
)

val LinkTextStyle = TextStyle(
    fontFamily = FontFamily.SansSerif,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    color = Color(0xFF64B5F6), // A light blue color, for example
    textDecoration = androidx.compose.ui.text.style.TextDecoration.Underline
)

// ...and any other custom styles you need