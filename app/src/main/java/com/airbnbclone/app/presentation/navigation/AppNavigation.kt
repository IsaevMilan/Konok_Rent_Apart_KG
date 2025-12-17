package com.airbnbclone.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnbclone.app.presentation.screens.auth.LoginScreen
import com.airbnbclone.app.presentation.screens.auth.RegisterScreen
import com.airbnbclone.app.presentation.screens.auth.VerifyCodeScreen
import com.airbnbclone.app.presentation.screens.main.MainScreen
import com.airbnbclone.app.presentation.screens.profile.ProfileScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = "main"
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable("main") {
            MainScreen(navController = navController)
        }
        
        // Auth routes
        composable("auth/login") {
            LoginScreen(
                navController = navController,
                onLoginSuccess = { navController.navigate("main") { popUpTo(0) } }
            )
        }
        composable("auth/register") {
            RegisterScreen(
                navController = navController,
                onRegisterSuccess = { phone ->
                    navController.navigate("auth/verify-code?phone=$phone")
                }
            )
        }
        composable("auth/verify-code?phone={phone}") { backStackEntry ->
            val phone = backStackEntry.arguments?.getString("phone")
            VerifyCodeScreen(
                navController = navController,
                phoneNumber = phone,
                onVerifySuccess = { navController.navigate("main") { popUpTo(0) } }
            )
        }
        
        // Profile routes
        composable("profile") {
            ProfileScreen(navController = navController)
        }
        composable("profile/edit") {
            // TODO: EditProfileScreen
            ProfileScreen(navController = navController)
        }
        composable("profile/privacy") {
            // TODO: PrivacyScreen
            ProfileScreen(navController = navController)
        }
        composable("profile/account") {
            // TODO: MyAccountScreen
            ProfileScreen(navController = navController)
        }
        composable("profile/settings") {
            // TODO: SettingsScreen
            ProfileScreen(navController = navController)
        }
        composable("profile/change-password") {
            // TODO: ChangePasswordScreen
            ProfileScreen(navController = navController)
        }
        composable("profile/permissions") {
            // TODO: PermissionsScreen
            ProfileScreen(navController = navController)
        }
        
        // Messages routes
        composable("messages") {
            // TODO: MessagesScreen
            MainScreen(navController = navController)
        }
        composable("messages/edit") {
            // TODO: EditMessagesScreen
            MainScreen(navController = navController)
        }
        composable("messages/chat/{id}") { backStackEntry ->
            val chatId = backStackEntry.arguments?.getString("id")
            // TODO: ChatScreen
            MainScreen(navController = navController)
        }
        
        // Booking routes
        composable("booking") {
            // TODO: BookingScreen
            MainScreen(navController = navController)
        }
        composable("booking/payment-method") {
            // TODO: PaymentMethodScreen
            MainScreen(navController = navController)
        }
        composable("booking/add-card") {
            // TODO: AddCardScreen
            MainScreen(navController = navController)
        }
        
        // Listing routes
        composable("listing/{id}") { backStackEntry ->
            val listingId = backStackEntry.arguments?.getString("id")
            // TODO: ListingScreen
            MainScreen(navController = navController)
        }
        composable("listing/{id}/reviews") { backStackEntry ->
            val listingId = backStackEntry.arguments?.getString("id")
            // TODO: ReviewsScreen
            MainScreen(navController = navController)
        }
        
        // Wishlist routes
        composable("wishlist") {
            // TODO: WishlistScreen
            MainScreen(navController = navController)
        }
        composable("wishlist/save") {
            // TODO: SaveWishlistScreen
            MainScreen(navController = navController)
        }
        
        // Other routes
        composable("search") {
            // TODO: SearchScreen
            MainScreen(navController = navController)
        }
        composable("search/filter") {
            // TODO: FilterScreen
            MainScreen(navController = navController)
        }
        composable("map") {
            // TODO: MapScreen
            MainScreen(navController = navController)
        }
    }
}
