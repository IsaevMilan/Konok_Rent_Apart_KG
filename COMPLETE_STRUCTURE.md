# Полная структура Android проекта

## ✅ Создано

### Domain Layer
- ✅ Entities: User, Listing, Booking, Message, Wishlist, Review
- ✅ Repositories: UserRepository, AuthRepository, ListingRepository, BookingRepository, MessageRepository, WishlistRepository, PaymentRepository
- ✅ Use Cases: GetUserUseCase, UpdateUserUseCase, LoginUseCase

### Data Layer
- ✅ Remote API: AuthApi, KtorClient
- ✅ DTOs: AuthResponseDto, LoginRequestDto, RegisterRequestDto, VerifyCodeRequestDto, UserDto
- ✅ Repository Implementations: AuthRepositoryImpl, UserRepositoryImpl

### DI (Hilt)
- ✅ NetworkModule
- ✅ RepositoryModule

### Presentation Layer
- ✅ Components: CustomTextField, CustomButton, SocialLoginButton, AuthLogo
- ✅ Theme: AppColors, Theme, Typography
- ✅ Screens:
  - ✅ Auth: LoginScreen, RegisterScreen, VerifyCodeScreen
  - ✅ Profile: ProfileScreen
  - ✅ Main: MainScreen
- ✅ Navigation: AppNavigation (полная навигация настроена)

## 📋 Структура файлов

```
app/src/main/java/com/airbnbclone/app/
├── domain/
│   ├── entities/
│   │   ├── User.kt
│   │   ├── Listing.kt
│   │   ├── Booking.kt
│   │   ├── Message.kt
│   │   ├── Wishlist.kt
│   │   └── Review.kt
│   ├── repository/
│   │   ├── UserRepository.kt
│   │   ├── AuthRepository.kt
│   │   ├── ListingRepository.kt
│   │   ├── BookingRepository.kt
│   │   ├── MessageRepository.kt
│   │   ├── WishlistRepository.kt
│   │   └── PaymentRepository.kt
│   └── usecase/
│       ├── GetUserUseCase.kt
│       ├── UpdateUserUseCase.kt
│       └── LoginUseCase.kt
├── data/
│   ├── remote/
│   │   ├── api/
│   │   │   └── AuthApi.kt
│   │   ├── dto/
│   │   │   └── AuthResponseDto.kt
│   │   └── KtorClient.kt
│   └── repository/
│       ├── AuthRepositoryImpl.kt
│       └── UserRepositoryImpl.kt
├── di/
│   ├── NetworkModule.kt
│   └── RepositoryModule.kt
└── presentation/
    ├── components/
    │   ├── CustomTextField.kt
    │   ├── CustomButton.kt
    │   ├── SocialLoginButton.kt
    │   └── AuthLogo.kt
    ├── screens/
    │   ├── auth/
    │   │   ├── LoginScreen.kt
    │   │   ├── RegisterScreen.kt
    │   │   └── VerifyCodeScreen.kt
    │   ├── profile/
    │   │   └── ProfileScreen.kt
    │   └── main/
    │       └── MainScreen.kt
    ├── navigation/
    │   └── AppNavigation.kt
    └── theme/
        ├── AppColors.kt
        ├── Theme.kt
        └── Type.kt
```

## 🔨 Что нужно доделать

### Data Layer
- [ ] Создать остальные API (ListingApi, BookingApi, MessageApi, etc.)
- [ ] Создать DTOs для всех entities
- [ ] Настроить Room Database
- [ ] Реализовать все RepositoryImpl

### Presentation Layer - Остальные экраны
- [ ] Profile: EditProfileScreen, PrivacyScreen, MyAccountScreen, SettingsScreen, ChangePasswordScreen, PermissionsScreen
- [ ] Messages: MessagesScreen, ChatScreen, EditMessagesScreen, SearchMessagesScreen
- [ ] Booking: BookingScreen, PaymentMethodScreen, AddCardScreen
- [ ] Listing: ListingScreen, ReviewsScreen
- [ ] Wishlist: WishlistScreen, SaveWishlistScreen
- [ ] Search: SearchScreen, FilterScreen
- [ ] Map: MapScreen

### ViewModels
- [ ] Создать ViewModels для всех экранов с FlowMVI
- [ ] Настроить state management

### DI
- [ ] UseCaseModule для всех use cases
- [ ] DatabaseModule для Room

## 📝 Примечания

1. Все основные структуры созданы
2. Навигация настроена для всех экранов (пока с заглушками)
3. Базовая архитектура готова
4. Осталось реализовать конкретные экраны и бизнес-логику

## 🚀 Следующие шаги

1. Реализовать остальные API endpoints
2. Создать все экраны
3. Добавить ViewModels
4. Настроить Room для кеширования
5. Добавить обработку ошибок
6. Тестирование

