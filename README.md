# Mo KMP BASE

## Introduction

Welcome to the beta version of my base code! This version may contain issues as it's still under development. Feel free to open any issues you encounter during usage.

## Features (Android only)

- **Onboarding**: Provides an onboarding experience for new users.
- **Splash Screen**: Displays a splash screen during app startup.

## Usage

This section explains how to use the project without delving into its internal workings. Provide simple instructions or examples for users to follow.


### 1- Injection

In the `shared/commonMain/com/mo/newbase/core/utils` directory, you will find `Koinhelper`. Here, you can add all your Koin modules, which will be used on both Android and iOS platforms.

To use your injected instances in any class, the class should implement `KoinComponent`.

You can inject classes in two ways:
1. Pass them to the constructor.
2. Declare them and add " by inject() " at the end.

All the modules are located in `commonMain/com/mo/newbase/di`. Take a look at the `setup` module; you should write your feature modules similarly. Some modules require platform-specific code, like the `viewModels` module. You'll need to write your viewModels injection code twice: once in `androidMain/com/.../di/viewmodels` and once in `iosMain/.../di/viewModels`. Follow the pattern used in these two files when adding new viewModels.

Additionally, I've injected `apiHelper`, local database, and local preferences at the `baseModule`.

If you want to add a native module, you can add it in the `App` (for Android) or `iOSApp.swift` (for iOS).

### 2- Prefrences
For preferences handling, I've implemented injection, simply inject "AppPreferences" anywhere in your code and start using it.

To add more keys to preferences, navigate to `commonMain/.../core/local/preferences/AppPreferences` and add the keys in the companion object. Utilize setters and getters to save your data.

### 3- database (SQLite Delight)

At `commonMain/sqldelight`, you can write your queries and schema definitions. It's recommended to read more about `sqldelight` before using it. Additionally, it has been injected as "Database".

### 4- API (Ktor)

The `KtorClient` is provided for making API requests. Inject it in any class and use methods inside (post, delete, get, put, postWithMultipart, putWithMultipart, handleRequestState).

#### Important

- All methods except for "handleRequestState" do not need further explanation.
- `handleRequestState` takes the response from other methods and returns a `RequestState`. Possible request states are:
  - "Error" with a message
  - "Loading"
  - "Success" with data
  - "NotAuthorized" with a message.

#### Note

- Ensure that all your responses inherit from "BaseResponse".
- All your view models should inherit from "BaseViewModel" where you can find a method to handle your request state. Simply pass your request state to it, and it will provide callbacks in many useful situations.


### 5- Navigation

#### For Android Only

1. Go to `commonMain/core/navigation/graph`.
2. Add all your screens there, similar to the already added screens.
3. Navigate to `android/core/navigation`.
4. Read the method names in the navigation helper, and you will understand how to navigate.


### 6-SharedViewModel

To use the `SharedViewModel` anywhere in the app, inject a class called `SharedStates`. Utilize the method `get()` like this: `sharedStates.get()`. This will provide you with the singleton instance of the `SharedViewModel`.

The `SharedViewModel` includes a method called `getStartDestination`. Currently, it is not in use, but it will be developed further in the future. It's intended to control which graph is active (main graph or auth graph), although currently, there is only one graph.

### 7- SettingsViewModel

Update (`darkMode` - `language`) states in `SettingsViewModel` which is injected to `MainActivity` to change language or dark mode.
use `setDarkMode` and `changeLanguage` methods inside `SettingsViewModel` to do that.
`setDarkMode` takes a boolean whether it is active or not.
`changeLanguage` takes a `Languages` enum value (system - ar - an) feel free to add your own locals i have prepared Arabic and English only.
