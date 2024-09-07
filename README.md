# Spell Checker Program

## Overview
This Java program provides a simple spell-checking system using two dictionaries: a common dictionary and a personal dictionary. Users can check the spelling of words and add new words to their personal dictionary.

## Features
- Reads words from a `common-dictionary.txt` and a `personal-dictionary.txt` file.
- Uses binary search for fast spell-checking.
- Allows users to add new words to their personal dictionary.
- Updates and saves the personal dictionary to `personal-dictionary.txt`.

## Requirements
- Java 8 or higher
- `common-dictionary.txt` file containing common words (one word per line).
- (Optional) `personal-dictionary.txt` file to store the user's personalized words.

## How to Use
1. Place the `common-dictionary.txt` file in the same directory as the program.
2. (Optional) Place a `personal-dictionary.txt` file if you already have one. If not, one will be created when you add words.
3. Compile and run the program:
   ```bash
   javac Project11.java
   java Project11
