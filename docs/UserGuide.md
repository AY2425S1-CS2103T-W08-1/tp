---
layout: default.md
title: "User Guide"
pageNav: 3
---

# TrackMate User Guide

## Welcome to the TrackMate User Guide

Welcome to the **TrackMate User Guide** - your essential supplementary tools in your teaching journey as a SOC
Teaching Assistant at National University of Singapore (NUS).

In this comprehensive user guide, we will take you to experience a full journey with TrackMate step by step.

--------------------------------------------------------------------------------------------------------------------

## Table of Content

[1. Introduction](#introduction)
- [1.1 What is TrackMate-NUS](#what-is-trackmate)
- [1.2 User Proficiency and Expectations](#user-proficiency-and-expectations)
- [1.3 Why This Guide Matters](#why-this-guide-matters)

[2. How to use this User Guide](#how-to-use-this-user-guide)
- [2.1 Navigating the Document](#navigating-the-document)
- [2.2 Sections](#sections)
- [2.3 Icons](#icons)

[3. Getting Started](#getting-started)
- [3.1 Installation](#installation)
- [3.2 Graphical User Interface Layout](#graphical-user-interface-layout)
    - [3.2.1 User Interface Overview](#user-interface-overview)
    - [3.2.2 Additional UI Components](#additional-ui-components)
- [3.3 How to use TrackMate commands](#how-to-use-track-mate-nus-commands)
    - [3.3.1 Parameter Prefixes](#parameter-prefixes)
    - [3.3.2 Parameters](#parameters)
    - [3.3.3 Command Format](#command-format)

[4. Commands](#commands)
- [4.1 Student Data Related Commands](#student-data-commands)
    - [4.1.1 Adding a student: `add`](#adding-a-student-add)
    - [4.1.2 Editing a student: `edit`](#editing-a-student-edit)
    - [4.1.3 Deleting a student: `deleteStu`](#deleting-a-student-deleteStu)
    - [4.1.4 Listing students: `listStu`](#listing-students-listStu)
    - [4.1.5 Find Students by Name: `find`](#find-students-find)
- [4.2 Tutorial Data Related Commands](#tutorial-data-commands)
    - [4.2.1 Adding a tutorial: `addTut`](#adding-a-tutorial-addTut)
    - [4.2.2 Deleting a tutorial: `deleteTut`](#deleting-a-tutorial-deleteTut)
    - [4.2.3 Listing tutorials: `listTut`](#listing-tutorials-listTut)
- [4.3 Assignment Data Related Commands](#assignment-data-commands)
    - [4.3.1 Adding an assignment: `addAsg`](#adding-an-assigment-addAsg)
    - [4.3.2 Deleting an assignment: `deleteTut`](#deleting-an-assignment-deleteAsg)
    - [4.3.3 Listing assignments: `listAsg`](#listing-assignments-listAsg)
    - [4.3.4 Marking an assignment: `markAsg`](#marking-an-assignment-markAsg)
    - [4.3.5 Unmarking an assignment: `unmarkAsg`](#unmarking-an-assignment-unmarkAsg)
    - [4.3.6 Checking an assignment: `checkAsg`](#checking-an-assignment-checkAsg)
- [4.4 Attendance Data Related Commands](#attendance-data-commands)
  - [4.4.1 Marking an attendance: `attend`](#adding-an-assigment-addAsg)
  - [4.4.2 Unmarking an attendance: `TBC`](#deleting-an-assignment-deleteAsg)
- [4.5 General Commands](#general-commands)
    - [4.5.1 Viewing a Student on the Student Card](#viewing-a-student-on-the-student-card)
    - [4.5.2 Clearing all entries: `clear`](#clearing-all-entries-clear)
    - [4.5.3 Exiting the program: `exit`](#exiting-the-program-exit)
    - [4.5.4 Viewing help: `help`](#viewing-help-help)
- [4.6 Saving the Data](#saving-the-data)
- [4.7 Editing the Data File](#editing-the-data-file)

[5. FAQ](#faq)

[6. Known issues](#known-issues)

[7. Glossary](#glossary)

[8. Command summary](#command-summary)

--------------------------------------------------------------------------------------------------------------------

## 1. Introduction
<a id="introduction"></a>

### 1.1 What is TrackMate
<a id="what-is-trackmate"></a>

TO BE DONE

### 1.2 User Proficiency and Expectations
<a id="user-proficiency-and-expectations"></a>

TO BE DONE

### 1.3 Why This Guide Matters
<a id="why-this-guide-matters"></a>

TO BE DONE

--------------------------------------------------------------------------------------------------------------------

## 2. How to use this User Guide
<a id="how-to-use-this-user-guide"></a>

This section is designed to help users effectively navigate the User Guide for TrackMate. Below, you'll find 
information on how to interpret icons, formatting, and instructions provided throughout the document.

### 2.1 Navigating the Document:

TO BE DONE

### 2.2 Sections:
<a id="sections"></a>

Below is a detailed overview of the main sections within this User Guide and what can be expected from each section.

TO BE DONE

### 2.3 Icons:
<a id="icons"></a>

TO BE DONE

--------------------------------------------------------------------------------------------------------------------
## 3. Getting Started
<a id="getting-started"></a>

### 3.1 Installation
<a id="installation"></a>

TO BE CHANGED

1. Ensure you have Java `17` or above installed on your Computer.

2. Download the latest `.jar` file from [here](https://github.com/se-edu/addressbook-level3/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your AddressBook.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar addressbook.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

    * `list` : Lists all contacts.
    * `add n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.
    * `delete 3` : Deletes the 3rd contact shown in the current list.
    * `clear` : Deletes all contacts.
    * `exit` : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

### 3.2 Graphical User Interface Layout:
<a id="graphical-user-interface-layout"></a>

#### 3.2.1 User Interface Overview:
<a id="user-interface-overview"></a>

TO BE DONE

#### 3.2.2 Additional UI Components:
<a id="additional-ui-components"></a>

TO BE DONE

### 3.3 How to use TrackMate commands:
<a id="how-to-use-track-mate-commands"></a>

TrackMate operates primarily through text-based commands. Before we explore the specific commands in detail in the 
Commands section, let’s familiarize ourselves with the basic components and format of a command.

#### 3.3.1 Parameter Prefixes:
<a id="parameter-prefixes"></a>

In TrackMate, a parameter prefix acts as a delimiter for specifying different types of parameters in commands. 
Here's a reference table for common parameter prefixes and their corresponding parameters:

TO BE DONE

#### 3.3.2 Parameters:
<a id="parameters"></a>

In TrackMate, a parameter represents a placeholder where users input data. 
Parameters typically follow immediately after their corresponding Parameter Prefixes. 
Essentially they are to be supplied by the user.

TO BE DONE

#### 3.3.3 Command Format:
<a id="command-format"></a>

To understand how a full command is interpreted, we will utilise the following example.

TO BE DONE

**General Notes about TrackMate:**<br>

TO BE DONE

**Notes about the command format:**<br>

TO BE DONE

**IMPORTANT !!!**<br>

TO BE DONE

--------------------------------------------------------------------------------------------------------------------

## 4. Commands
<a id="commands"></a>

This section provides comprehensive guidance on how to use each command, detailing their functionalities and 
usage scenarios. For specific constraints related to each parameter, please refer to the [Parameter](#parameters) 
section for detailed information

### 4.1 Student Data Commands:
<a id="student-data-commands"></a>

#### 4.1.1 Adding a student: `add`
<a id="adding-a-student-add"></a>

> Adds a student to the TrackMate application.

#### 4.1.2 Edit existing student detail: `edit`
<a id="editing-a-student-edit"></a>

> Edits an existing student details to the TrackMate application.

#### 4.1.3 Delete a student: `deleteStu`
<a id="deleting-a-student-deleteStu"></a>

> TO BE DONE

#### 4.1.4 Listing students: `listStu`
<a id="listing-students-listStu"></a>

> TO BE DONE

#### 4.1.5 Find Students by Name: `find`
<a id="find-students-find"></a>

> TO BE DONE

### 4.2 Tutorial Data Related Commands:
<a id="tutorial-data-commands"></a>

#### 4.2.1 Adding a tutorial: `addTut`
<a id="adding-a-tutorial-addTut"></a>

> TO BE DONE

#### 4.2.2 Delete a tutorial: `deleteTut`
<a id="deleting-a-tutorial-deleteTut"></a>

> TO BE DONE

#### 4.2.3 List tutorials: `listTut`
<a id="listing-tutorials-listTut"></a>

> TO BE DONE

### 4.3 Assignment Data Related Commands:
<a id="assignment-data-commands"></a>

#### 4.3.1 Adding an assignment: `addAsg`
<a id="adding-an-assignment-add"></a>

> TO BE DONE

#### 4.3.2 Delete an assigment: `deleteAsg`
<a id="deleting-an-assignment-deleteAsg"></a>

> TO BE DONE

#### 4.3.3 List assignments: `listAsg`
<a id="listing-assignments-listAsg"></a>

> TO BE DONE

#### 4.3.4 Mark an assignment: `markAsg`
<a id="marking-an-assignment-markAsg"></a>

> TO BE DONE

#### 4.3.5 Unmark an assignment: `unmarkAsg`
<a id="unmarking-an-assignment-unmarkAsg"></a>

> TO BE DONE

#### 4.3.6 Check an assignment: `checkAsg`
<a id="checking-an-assignment-checkAsg"></a>

> TO BE DONE

### 4.4 Attendance Data Related Commands:
<a id="assignment-data-commands"></a>

#### 4.4.1 Marking an attendance: `attend`
<a id="adding-an-attendance-add"></a>

> TO BE DONE

#### 4.4.2 Unmarking an attendance: `TBC`
<a id="unmarking-an-attendance-add"></a>

> TO BE DONE

### 4.5 General Commands:
<a id="general-commands"></a>

#### 4.5.1 Viewing a Student on the Student Card:
<a id="viewing-a-student-on-the-student-card"></a>

> View a single student's details in a formatted and organized manner.

**Method 1 -  Using GUI**: Left-click on a specific Student Panel Card within the Student List Panel of the TrackMate User Interface.

**Method 2 -  Using CLI**: Navigate using the `UP` and `DOWN` arrow keys to switch between Student Panel Cards on the Student List Panel.

#### 4.5.2 Clearing all entries: `clear`
<a id="clearing-all-entries-clear"></a>

> Clears all entries from the EduLink-NUS application.

Format: `clear`

Command Details & Constraints:
* The command does not require any additional parameters; entered parameters will be disregarded.

#### 4.5.3 Exiting the program: `exit`
<a id="exiting-the-program-exit"></a>

> Exits the TrackMate application.

Format: `exit`

Command Details & Constraints:
* The command does not require any additional parameters; entered parameters will be disregarded.

#### 4.5.4 Viewing help: `help`
<a id="viewing-help-help"></a>

> Shows a message explaining how to access the help page.

Format: `help`

Command Details & Constraints:
* The command does not require any additional parameters; entered parameters will be disregarded.
* The help message image provided offers clear instructions for users seeking assistance.


### 4.6 Saving the data
<a id="saving-the-data"></a>

TO BE DONE

### 4.7 Editing the data file
<a id="editing-the-data-file"></a>

AddressBook data are saved automatically as a JSON file `[JAR file location]/data/addressbook.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless>
<b>Caution:</b>
If your changes to the data file makes its format invalid, the TrackMate application will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.<br>
Furthermore, certain edits can cause the TrackMate to behave in unexpected ways (e.g., if a value entered is outside the acceptable range). Therefore, edit the data file only if you are confident that you can update it correctly.
</box>

TO BE CHANGED

--------------------------------------------------------------------------------------------------------------------

## 5. FAQ
<a id="faq"></a>

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous EduLink-NUS home folder.

--------------------------------------------------------------------------------------------------------------------

## 6 Known issues
<a id="known-issues"></a>

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.
2. **`NAME` Parameter**, if you try to enter a name that contains `/` the application will show error message about invalid format for `NAME` but someone can have `/` in their legal name e.g `Prabhat S/O Radhe`, this limitation arises due to usage of `/` character for Internal use within the Application. The remedy is to use `|` i.e. pipe character in place of `/`. We Understand that this format doesn't comply with their Legal Names but Since Our Application identifies students based on their StudentID , this remedy doesn't limit the Capabilities of EduLink-NUS in any possible way.
3. **Student List Panel doesn't move**, if you click `UP` or `DOWN` arrow key to view Student Details Card for students even though the details card are shown correctly and changes perfectly according to the input , the Student List Panel doesn't scroll down or up to align or match with the current Student Displayed in the Details Card. The remedy is to scroll down manually to the highlighted Student Card in the Panel to know which student which being currently displayed.

--------------------------------------------------------------------------------------------------------------------
## 7. Glossary
<a id="glossary"></a>

| Term                      | Definition and or Explanation                                                                                                                                                                                             |
|---------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **CSV**                   | **Comma-Seperated Values** , a file format generally used to import data in Spreadsheets and Do analysis                                                                                                                  |
| **JSON**                  | **JavaScript Object Notation**, a standard file format for data interchange                                                                                                                                               |
| **NUS**                   | National University of Singapore , A University Located in Central Singapore                                                                                                                                              |
| **Student ID**            | A particular format of ID followed in NUS, Starting with a Alphabet followed by 7 digits and ending with an Alphabet e.g A0252195L                                                                                        |
| **GUI**                   | Graphical User Interface , all the part of the application which you can interact with your mouse                                                                                                                         |
| **CLI**                   | Command Line Interface , part of application which can only be used with commands from the Keyboard                                                                                                                       |


TO BE DONE

--------------------------------------------------------------------------------------------------------------------

## 8. Command summary
<a id="command-summary"></a>

| Action            | Format, Examples                                                                                                                                                       |
|-------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Add Student**    | `add n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS [t/TAG]…​`<br> e.g. `add n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 t/friend t/colleague`    |
| **Clear**          | `clear`                                                                                                                                                               |
| **Delete Student**  | `deleteStu INDEX`<br> e.g., `deleteStu 3`                                                                                                                            |
| **Edit Student**    | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g., `edit 2 n/James Lee e/jameslee@example.com`                                          |
| **Find Student**    | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`                                                                                                            |
| **List Students**   | `listStu`                                                                                                                                                            |
| **Add Tutorial**    | `addTut tn/[TUTORIAL NAME] id/[TUTORIAL ID]`<br> e.g., `addTut tn/CS1010 id/1011`                                                                                     |
| **List Tutorials**  | `listTut`                                                                                                                                                            |
| **Delete Tutorial** | `deleteTut [TUTORIAL ID]`<br> e.g., `deleteTut 1011`                                                                                                                 |
| **Add Assignment**  | `addAsg n/[ASSIGNMENT TITLE] d/[DUE DATE]`<br> e.g., `addAsg n/Assignment 1 d/2024-10-23 1230`                                                                       |
| **Delete Assignment**| `deleteAsg [ASSIGNMENT TITLE]`<br> e.g., `deleteAsg Assignment 1`                                                                                                   |
| **List Assignments**| `listAsg`                                                                                                                                                            |
| **Mark Attendance** | `attend s/[STUDENT ID] c/[TUTORIAL ID] d/[TUTORIAL DATE]`<br> e.g., `attend s/1001 c/1001 d/2024/02/21`                                                               |
| **Unmark Attendance**| `unmarkAttend s/[STUDENT ID] c/[TUTORIAL ID] d/[TUTORIAL DATE]`<br> e.g., `unmarkAttend s/1001 c/1001 d/2024/02/21`                                                  |
| **Mark Assignment** | `markAsg [INDEX] n/[ASSIGNMENT TITLE]`<br> e.g., `markAsg 1 n/Assignment 1`                                                                                           |
| **Unmark Assignment**| `unmarkAsg [INDEX] n/[ASSIGNMENT TITLE]`<br> e.g., `unmarkAsg 1 n/Assignment 1`                                                                                      |
| **Check Assignment**| `checkAsg n/[ASSIGNMENT TITLE]`<br> e.g., `checkAsg n/Assignment 1`                                                                                                   |
| **Clear**          | `clear`                                                                                                                                                               |
| **Help**           | `help`                                                                                                                                                                |
| **Exit**           | `exit`                                                                                                                                                                |

--------------------------------------------------------------------------------------------------------------------

