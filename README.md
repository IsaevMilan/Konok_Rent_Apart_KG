# Android App - Airbnb Clone

Нативная Android версия приложения на Kotlin.

## Технологии

- **Kotlin** - язык программирования
- **Jetpack Compose** - UI фреймворк
- **FlowMVI** - управление состоянием (MVI архитектура)
- **Ktor Client** - HTTP клиент для сетевых запросов
- **Kotlinx Serialization** - сериализация JSON
- **Room** - локальная база данных
- **Hilt** - Dependency Injection
- **Navigation Compose** - навигация
- **Coil** - загрузка изображений
- **Material Design 3** - дизайн система

## Архитектура

Проект использует Clean Architecture:

```
app/
├── data/
│   ├── remote/          # Ktor клиент, API сервисы
│   ├── local/           # Room Database, DataStore
│   └── repository/      # Реализации репозиториев
├── domain/
│   ├── entities/        # Бизнес-сущности
│   ├── usecases/        # Use cases
│   └── repository/      # Интерфейсы репозиториев
├── presentation/
│   ├── screens/         # Compose экраны
│   ├── components/      # Переиспользуемые компоненты
│   └── viewmodel/       # ViewModel с FlowMVI
└── di/                  # Hilt модули
```

## Структура экранов

- **Auth**: Login, Register, Verify Code
- **Profile**: Profile, Edit Profile, Privacy, Settings, Change Password
- **Messages**: Messages List, Chat, Search Messages
- **Booking**: Booking, Payment Method, Add Card
- **Listings**: Listing Detail, Reviews
- **Wishlist**: Wishlist List, Create Wishlist
- **Search**: Search, Filters
- **Map**: Map View
- **Main**: Main Screen with Bottom Navigation

## API

Все API endpoints описаны в `../my_fixed_app/API_ENDPOINTS.md`

