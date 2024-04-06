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
