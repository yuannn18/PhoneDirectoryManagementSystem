# Phone Directory Management System

## CDS2003 - Data Structures and Object-Oriented Programming

This project is a Java-based phone directory management system designed for the Data Structures and Object-Oriented Programming course (CDS2003) at Lingnan University.

### Prepared for:
[Prof. Haoran Xie](https://xiehaoran.net/index.php)


### Prepared by:
- [KARASSAY Yelaman](https://twitter.com/valikhanovich)

### Date:
April 30, 2021

## Table of Contents
- [Introduction](#introduction)
- [Functions](#functions)
- [Design](#design)
- [Demonstrations](#demonstrations)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Phone Directory Management System is a program developed in Java aimed at storing and maintaining contact data, including functionalities for addition, deletion, search, and display of contacts. The system operates without a database, ensuring data persistence only during runtime. It leverages Binary Search and Quicksort algorithms for efficient data handling and is designed following the MVC (Model-View-Controller) architecture with SOLID and KISS design principles.

## Functions

### Models
- `User`: Represents the contact entity with name, phone number, and address. Includes constructors, getters, setters, and a `toString` method.

### Utilss
- `InsertUtil`: Handles the insertion of new contacts.
- `DeleteUtil`: Assists in deleting existing contacts.
- `BinarySearchUtil`: Implements binary search for contact lookup by name.
- `QuickSortUtil`: Provides quicksort algorithm for sorting contacts alphabetically.

### Main
- `main`: The entry point of the program.
- `program`: Contains the main program code.
- `insertUser`: Handles the insertion of new users.
- `delete`: Processes contact deletion.
- `searchBinary`: Handles the binary search operation.
- `displayListOfRecordings`: Displays all contacts.
- `printMainScreen`: Prints the main menu screen.
- `printSmileFace`: Prints a smiley face for a varied console output.

## Design

The project is designed for maximum readability and flexibility, utilizing ArrayList to efficiently implement Binary Search and Quick Sort algorithms. The choice of data structure and algorithms was made considering performance and memory considerations.

## Demonstrations

The system provides a user-friendly menu with options to insert, delete, search, and display contacts, as well as to exit the program.

## Getting Started

To set up the project locally, clone the repository and compile the Java files.

```bash
git clone https://github.com/YelamanKarassay/PhoneDirectoryManagementSystem.git

cd PhoneDirectoryManagementSystem
# Compile the Java files in the appropriate directory
```
## Usage

Run the compiled Java program through the command line to start the phone directory management system.
    
```bash
java Main
# Run the compiled Java program
```

## Contributing

If you wish to contribute to this project, please fork the repository and submit a pull request.

## License
This project is licensed under the MIT License.
[LICENSE](LICENSE) file for details.