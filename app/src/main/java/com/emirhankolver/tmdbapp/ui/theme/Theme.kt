package com.emirhankolver.tmdbapp.ui.theme
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.compose.backgroundDark
import com.example.compose.backgroundDarkHighContrast
import com.example.compose.backgroundDarkMediumContrast
import com.example.compose.backgroundLight
import com.example.compose.backgroundLightHighContrast
import com.example.compose.backgroundLightMediumContrast
import com.example.compose.errorContainerDark
import com.example.compose.errorContainerDarkHighContrast
import com.example.compose.errorContainerDarkMediumContrast
import com.example.compose.errorContainerLight
import com.example.compose.errorContainerLightHighContrast
import com.example.compose.errorContainerLightMediumContrast
import com.example.compose.errorDark
import com.example.compose.errorDarkHighContrast
import com.example.compose.errorDarkMediumContrast
import com.example.compose.errorLight
import com.example.compose.errorLightHighContrast
import com.example.compose.errorLightMediumContrast
import com.example.compose.inverseOnSurfaceDark
import com.example.compose.inverseOnSurfaceDarkHighContrast
import com.example.compose.inverseOnSurfaceDarkMediumContrast
import com.example.compose.inverseOnSurfaceLight
import com.example.compose.inverseOnSurfaceLightHighContrast
import com.example.compose.inverseOnSurfaceLightMediumContrast
import com.example.compose.inversePrimaryDark
import com.example.compose.inversePrimaryDarkHighContrast
import com.example.compose.inversePrimaryDarkMediumContrast
import com.example.compose.inversePrimaryLight
import com.example.compose.inversePrimaryLightHighContrast
import com.example.compose.inversePrimaryLightMediumContrast
import com.example.compose.inverseSurfaceDark
import com.example.compose.inverseSurfaceDarkHighContrast
import com.example.compose.inverseSurfaceDarkMediumContrast
import com.example.compose.inverseSurfaceLight
import com.example.compose.inverseSurfaceLightHighContrast
import com.example.compose.inverseSurfaceLightMediumContrast
import com.example.compose.onBackgroundDark
import com.example.compose.onBackgroundDarkHighContrast
import com.example.compose.onBackgroundDarkMediumContrast
import com.example.compose.onBackgroundLight
import com.example.compose.onBackgroundLightHighContrast
import com.example.compose.onBackgroundLightMediumContrast
import com.example.compose.onErrorContainerDark
import com.example.compose.onErrorContainerDarkHighContrast
import com.example.compose.onErrorContainerDarkMediumContrast
import com.example.compose.onErrorContainerLight
import com.example.compose.onErrorContainerLightHighContrast
import com.example.compose.onErrorContainerLightMediumContrast
import com.example.compose.onErrorDark
import com.example.compose.onErrorDarkHighContrast
import com.example.compose.onErrorDarkMediumContrast
import com.example.compose.onErrorLight
import com.example.compose.onErrorLightHighContrast
import com.example.compose.onErrorLightMediumContrast
import com.example.compose.onPrimaryContainerDark
import com.example.compose.onPrimaryContainerDarkHighContrast
import com.example.compose.onPrimaryContainerDarkMediumContrast
import com.example.compose.onPrimaryContainerLight
import com.example.compose.onPrimaryContainerLightHighContrast
import com.example.compose.onPrimaryContainerLightMediumContrast
import com.example.compose.onPrimaryDark
import com.example.compose.onPrimaryDarkHighContrast
import com.example.compose.onPrimaryDarkMediumContrast
import com.example.compose.onPrimaryLight
import com.example.compose.onPrimaryLightHighContrast
import com.example.compose.onPrimaryLightMediumContrast
import com.example.compose.onSecondaryContainerDark
import com.example.compose.onSecondaryContainerDarkHighContrast
import com.example.compose.onSecondaryContainerDarkMediumContrast
import com.example.compose.onSecondaryContainerLight
import com.example.compose.onSecondaryContainerLightHighContrast
import com.example.compose.onSecondaryContainerLightMediumContrast
import com.example.compose.onSecondaryDark
import com.example.compose.onSecondaryDarkHighContrast
import com.example.compose.onSecondaryDarkMediumContrast
import com.example.compose.onSecondaryLight
import com.example.compose.onSecondaryLightHighContrast
import com.example.compose.onSecondaryLightMediumContrast
import com.example.compose.onSurfaceDark
import com.example.compose.onSurfaceDarkHighContrast
import com.example.compose.onSurfaceDarkMediumContrast
import com.example.compose.onSurfaceLight
import com.example.compose.onSurfaceLightHighContrast
import com.example.compose.onSurfaceLightMediumContrast
import com.example.compose.onSurfaceVariantDark
import com.example.compose.onSurfaceVariantDarkHighContrast
import com.example.compose.onSurfaceVariantDarkMediumContrast
import com.example.compose.onSurfaceVariantLight
import com.example.compose.onSurfaceVariantLightHighContrast
import com.example.compose.onSurfaceVariantLightMediumContrast
import com.example.compose.onTertiaryContainerDark
import com.example.compose.onTertiaryContainerDarkHighContrast
import com.example.compose.onTertiaryContainerDarkMediumContrast
import com.example.compose.onTertiaryContainerLight
import com.example.compose.onTertiaryContainerLightHighContrast
import com.example.compose.onTertiaryContainerLightMediumContrast
import com.example.compose.onTertiaryDark
import com.example.compose.onTertiaryDarkHighContrast
import com.example.compose.onTertiaryDarkMediumContrast
import com.example.compose.onTertiaryLight
import com.example.compose.onTertiaryLightHighContrast
import com.example.compose.onTertiaryLightMediumContrast
import com.example.compose.outlineDark
import com.example.compose.outlineDarkHighContrast
import com.example.compose.outlineDarkMediumContrast
import com.example.compose.outlineLight
import com.example.compose.outlineLightHighContrast
import com.example.compose.outlineLightMediumContrast
import com.example.compose.outlineVariantDark
import com.example.compose.outlineVariantDarkHighContrast
import com.example.compose.outlineVariantDarkMediumContrast
import com.example.compose.outlineVariantLight
import com.example.compose.outlineVariantLightHighContrast
import com.example.compose.outlineVariantLightMediumContrast
import com.example.compose.primaryContainerDark
import com.example.compose.primaryContainerDarkHighContrast
import com.example.compose.primaryContainerDarkMediumContrast
import com.example.compose.primaryContainerLight
import com.example.compose.primaryContainerLightHighContrast
import com.example.compose.primaryContainerLightMediumContrast
import com.example.compose.primaryDark
import com.example.compose.primaryDarkHighContrast
import com.example.compose.primaryDarkMediumContrast
import com.example.compose.primaryLight
import com.example.compose.primaryLightHighContrast
import com.example.compose.primaryLightMediumContrast
import com.example.compose.scrimDark
import com.example.compose.scrimDarkHighContrast
import com.example.compose.scrimDarkMediumContrast
import com.example.compose.scrimLight
import com.example.compose.scrimLightHighContrast
import com.example.compose.scrimLightMediumContrast
import com.example.compose.secondaryContainerDark
import com.example.compose.secondaryContainerDarkHighContrast
import com.example.compose.secondaryContainerDarkMediumContrast
import com.example.compose.secondaryContainerLight
import com.example.compose.secondaryContainerLightHighContrast
import com.example.compose.secondaryContainerLightMediumContrast
import com.example.compose.secondaryDark
import com.example.compose.secondaryDarkHighContrast
import com.example.compose.secondaryDarkMediumContrast
import com.example.compose.secondaryLight
import com.example.compose.secondaryLightHighContrast
import com.example.compose.secondaryLightMediumContrast
import com.example.compose.surfaceBrightDark
import com.example.compose.surfaceBrightDarkHighContrast
import com.example.compose.surfaceBrightDarkMediumContrast
import com.example.compose.surfaceBrightLight
import com.example.compose.surfaceBrightLightHighContrast
import com.example.compose.surfaceBrightLightMediumContrast
import com.example.compose.surfaceContainerDark
import com.example.compose.surfaceContainerDarkHighContrast
import com.example.compose.surfaceContainerDarkMediumContrast
import com.example.compose.surfaceContainerHighDark
import com.example.compose.surfaceContainerHighDarkHighContrast
import com.example.compose.surfaceContainerHighDarkMediumContrast
import com.example.compose.surfaceContainerHighLight
import com.example.compose.surfaceContainerHighLightHighContrast
import com.example.compose.surfaceContainerHighLightMediumContrast
import com.example.compose.surfaceContainerHighestDark
import com.example.compose.surfaceContainerHighestDarkHighContrast
import com.example.compose.surfaceContainerHighestDarkMediumContrast
import com.example.compose.surfaceContainerHighestLight
import com.example.compose.surfaceContainerHighestLightHighContrast
import com.example.compose.surfaceContainerHighestLightMediumContrast
import com.example.compose.surfaceContainerLight
import com.example.compose.surfaceContainerLightHighContrast
import com.example.compose.surfaceContainerLightMediumContrast
import com.example.compose.surfaceContainerLowDark
import com.example.compose.surfaceContainerLowDarkHighContrast
import com.example.compose.surfaceContainerLowDarkMediumContrast
import com.example.compose.surfaceContainerLowLight
import com.example.compose.surfaceContainerLowLightHighContrast
import com.example.compose.surfaceContainerLowLightMediumContrast
import com.example.compose.surfaceContainerLowestDark
import com.example.compose.surfaceContainerLowestDarkHighContrast
import com.example.compose.surfaceContainerLowestDarkMediumContrast
import com.example.compose.surfaceContainerLowestLight
import com.example.compose.surfaceContainerLowestLightHighContrast
import com.example.compose.surfaceContainerLowestLightMediumContrast
import com.example.compose.surfaceDark
import com.example.compose.surfaceDarkHighContrast
import com.example.compose.surfaceDarkMediumContrast
import com.example.compose.surfaceDimDark
import com.example.compose.surfaceDimDarkHighContrast
import com.example.compose.surfaceDimDarkMediumContrast
import com.example.compose.surfaceDimLight
import com.example.compose.surfaceDimLightHighContrast
import com.example.compose.surfaceDimLightMediumContrast
import com.example.compose.surfaceLight
import com.example.compose.surfaceLightHighContrast
import com.example.compose.surfaceLightMediumContrast
import com.example.compose.surfaceVariantDark
import com.example.compose.surfaceVariantDarkHighContrast
import com.example.compose.surfaceVariantDarkMediumContrast
import com.example.compose.surfaceVariantLight
import com.example.compose.surfaceVariantLightHighContrast
import com.example.compose.surfaceVariantLightMediumContrast
import com.example.compose.tertiaryContainerDark
import com.example.compose.tertiaryContainerDarkHighContrast
import com.example.compose.tertiaryContainerDarkMediumContrast
import com.example.compose.tertiaryContainerLight
import com.example.compose.tertiaryContainerLightHighContrast
import com.example.compose.tertiaryContainerLightMediumContrast
import com.example.compose.tertiaryDark
import com.example.compose.tertiaryDarkHighContrast
import com.example.compose.tertiaryDarkMediumContrast
import com.example.compose.tertiaryLight
import com.example.compose.tertiaryLightHighContrast
import com.example.compose.tertiaryLightMediumContrast
import com.example.ui.theme.AppTypography

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun TMDbAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> darkScheme
        else -> lightScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}

