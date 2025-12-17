# Структура Android проекта

## Созданная базовая структура:

```
android_app/
├── app/
│   ├── build.gradle.kts          # Зависимости приложения
│   ├── proguard-rules.pro        # ProGuard правила
│   └── src/main/
│       ├── AndroidManifest.xml   # Манифест приложения
│       ├── java/com/airbnbclone/app/
│       │   ├── AirbnbCloneApplication.kt  # Application класс с Hilt
│       │   ├── MainActivity.kt            # Главная Activity
│       │   └── presentation/
│       │       ├── navigation/
│       │       │   └── AppNavigation.kt  # Навигация
│       │       ├── screens/
│       │       │   └── main/
│       │       │       └── MainScreen.kt  # Главный экран
│       │       └── theme/
│       │           ├── Theme.kt           # Тема приложения
│       │           ├── AppColors.kt       # Цвета
│       │           └── Type.kt            # Типографика
│       └── res/
│           └── values/
│               ├── strings.xml
│               └── themes.xml
├── build.gradle.kts              # Корневой build файл
├── settings.gradle.kts           # Настройки проекта
├── gradle.properties             # Свойства Gradle
└── README.md                      # Документация
```

## Следующие шаги для полной реализации:

### 1. Domain Layer
```
domain/
├── entities/
│   ├── User.kt
│   ├── Listing.kt
│   ├── Booking.kt
│   ├── Message.kt
│   └── Wishlist.kt
├── repository/
│   ├── UserRepository.kt
│   ├── ListingRepository.kt
│   ├── BookingRepository.kt
│   ├── MessageRepository.kt
│   └── WishlistRepository.kt
└── usecases/
    ├── GetUserUseCase.kt
    ├── UpdateUserUseCase.kt
    └── ...
```

### 2. Data Layer
```
data/
├── remote/
│   ├── api/
│   │   ├── AuthApi.kt
│   │   ├── UserApi.kt
│   │   ├── ListingApi.kt
│   │   └── ...
│   ├── dto/
│   │   ├── UserDto.kt
│   │   ├── ListingDto.kt
│   │   └── ...
│   └── KtorClient.kt
├── local/
│   ├── database/
│   │   ├── AppDatabase.kt
│   │   └── dao/
│   └── datastore/
│       └── PreferencesManager.kt
└── repository/
    ├── UserRepositoryImpl.kt
    ├── ListingRepositoryImpl.kt
    └── ...
```

### 3. Presentation Layer
```
presentation/
├── screens/
│   ├── auth/
│   │   ├── LoginScreen.kt
│   │   ├── RegisterScreen.kt
│   │   └── VerifyCodeScreen.kt
│   ├── profile/
│   │   ├── ProfileScreen.kt
│   │   ├── EditProfileScreen.kt
│   │   └── ...
│   ├── messages/
│   │   ├── MessagesScreen.kt
│   │   ├── ChatScreen.kt
│   │   └── ...
│   └── ...
├── components/
│   ├── CustomButton.kt
│   ├── CustomTextField.kt
│   └── ...
└── viewmodel/
    ├── UserViewModel.kt
    ├── ListingViewModel.kt
    └── ...
```

### 4. DI (Dependency Injection)
```
di/
├── NetworkModule.kt
├── DatabaseModule.kt
├── RepositoryModule.kt
└── UseCaseModule.kt
```

## Команды для запуска:

1. Открыть проект в Android Studio
2. Синхронизировать Gradle
3. Запустить на эмуляторе или устройстве

## Зависимости уже добавлены:

- ✅ Jetpack Compose
- ✅ Hilt для DI
- ✅ Ktor Client
- ✅ Kotlinx Serialization
- ✅ Room Database
- ✅ Navigation Compose
- ✅ Coil для изображений
- ✅ FlowMVI (MVIKotlin)

## Следующие шаги:

1. Реализовать Domain entities и repositories
2. Настроить Ktor клиент с API endpoints
3. Создать Room database
4. Реализовать ViewModels с FlowMVI
5. Создать все экраны в Compose
6. Настроить навигацию между экранами

