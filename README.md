# WordTrainer

A modern Android application for vocabulary learning and pronunciation practice, built with declarative UI using **Jetpack Compose** following **Clean Architecture** and **MVVM** principles.

This project is an interactive educational app (MVP) that allows users to create custom flashcard decks, practice listening skills, and improve pronunciation using AI.


## 🚀 Features

### 📦 Core CRUD Operations 
- **Thematic Collections:** Create, view, and delete decks/groups for words.
- **Vocabulary Management:** Add new words, descriptions (definitions), and images.

### 🧠 Interactive Learning Modules (Planned)
- **Smart Flashcards:** Cards with sleek 3D flipping animations for self-testing.
- **Audio Dictation (Listening & Writing):** Words are spoken aloud using the native **Text-to-Speech (TTS)** engine, requiring users to type what they hear for automatic evaluation.
- **AI Pronunciation Coach (Speech Assessment):** Records user speech and evaluates pronunciation accuracy using specialized AI platforms for granular phonetic feedback.

## 🛠 Tech Stack

- **Language:** Kotlin
- **UI Framework:** Jetpack Compose (Material 3, Animations, Graphics Layer)
- **Architecture:** MVVM (Model-View-ViewModel) + Reactive Data Streams
- **Local Database:** SQLite via **Room Persistence Library**
- **Asynchrony:** Kotlin Coroutines & Reactive `Flow` (for instant UI updates)
- **Date & Time:** `kotlinx-datetime` library
- **Audio Services:** Android TTS, `MediaRecorder` for voice capture.

## 🏗 Database Schema (Room)

The app utilizes a local relational database with a **One-to-Many** relationship and supports cascade deletion (`CASCADE`).

### 1. `collections` Table (Word Decks)
| Column | Type | Description |
| :--- | :--- | :--- |
| `id` 🔑 | `Int` | Primary Key (Auto-generated) |
| `name` | `String` | Name of the collection (e.g., "IT Terms") |
| `createdAt` | `Long` | Timestamp of creation (Epoch millis via TypeConverter) |

### 2. `words` Table (Flashcards)
| Column | Type | Description |
| :--- | :--- | :--- |
| `id` 🔑 | `Int` | Primary Key (Auto-generated) |
| `collectionId` 🔗 | `Int` | Foreign Key referencing `collections.id` |
| `term` | `String` | The word or phrase to learn |
| `definition` | `String` | Translation or definition of the term |
| `imageUri` | `String?` | Local path to the image on the device (Optional) |
| `isLearned` | `Boolean` | Flag for tracking flashcard mastery |
