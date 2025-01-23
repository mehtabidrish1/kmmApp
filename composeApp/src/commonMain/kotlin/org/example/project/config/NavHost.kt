package org.example.project.config


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.example.project.ui.auth.splash.SplashPage


@Composable
fun AppHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController,
) {
    NavHost(navController = navHostController, startDestination = Splash) {
        composable<Splash> {
            SplashPage(navigateUp = {
//                navHostController.navigate(OnBoarding) {
//                    popUpTo(Splash) {
//                        inclusive = true;
//                    }
//                }
            })
        }
//        composable<SelectLanguage> {
//            LanguagePage() {
//                navHostController.navigate(Login);
//            }
//        }
//        composable<Login> {
//            LoginPage(navigateUp = {
//                navHostController.navigate(Dashboard) {
//                    popUpTo(Login) {
//                        inclusive = true;
//                    }
//                }
//            }, onRegister = {
//                navHostController.navigate(Registration)
//            })
//        }
//
//        composable<OnBoarding> {
//            OnBoardingPage(
//                navigateUp = {
//                    navHostController.navigate(SelectLanguage)
//                },
//            )
//        }
//
//        composable<Registration> {
//            RegistrationPage(navigateUp = {})
//        }
//
//        composable<Dashboard> {
//            DashboardPage(navigateUp = {
//                when (it) {
//                    0 -> navHostController.navigate(Profile)
//                    1 -> navHostController.navigate(SchemeList)
//                    3 -> navHostController.navigate(Faq)
//                    5 -> navHostController.navigate(Sync)
//                }
//            })
//        }
//
//        composable<SchemeList> {
//            SchemeListPage(navigateUp = {
//                navHostController.navigate(SchemeDetail)
//            }, navigateDown = {
//                navHostController.popBackStack()
//
//            })
//        }
//
//        composable<SchemeDetail> {
//            SchemeDetailPage(
//                navigateDown = {
//                    navHostController.popBackStack();
//                },
//                navigateUp = {},
//            )
//        }
//
//        composable<Profile> {
//            ProfilePage(navigateUp = {}, navigateDown = {
//                navHostController.popBackStack();
//
//            })
//        }
//
//        composable<Sync> {
//            SyncPage {
//                navHostController.popBackStack();
//            }
//        }
//
//        composable<Faq> {
//            FaqPage(navigateDown = {
//                navHostController.popBackStack();
//            })
//        }
    }
}