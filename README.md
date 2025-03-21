# ATM Interface Project

## Overview
A Java-based ATM (Automated Teller Machine) interface implementation that simulates basic banking operations. This project demonstrates Object-Oriented Programming concepts and secure transaction handling.

## Features
- Account Balance Inquiry
- Cash Withdrawal
- Cash Deposit
- Fund Transfer
- Transaction History
- Secure PIN Authentication
- Exception Handling for Invalid Operations

## Technical Details
- Language: Java
- Design Pattern: Object-Oriented Programming
- Exception Handling: Custom exceptions for insufficient balance and invalid operations
- Data Management: In-memory transaction tracking

##  Project Structure
```
ATM_Interface
├── src
│   └── com
│       └── sanju
             │  └── CustomerDetails.java
│            ├──Mainclasse
│               ├── Account.java
│               ├── Transaction.java
│               └── Main.java
├── .gitignore
└── README.md
```

## Class Structure
- `Account.java`: Manages account details and balance
  - Balance management
  - Transaction history
  - Account validation

- `Transaction.java`: Handles transaction records
  - Transaction types (Deposit, Withdrawal, Transfer)
  - Transaction timestamps
  - Transaction validation

## Getting Started
1. Clone the repository
```bash
git clone https://github.com/Ksanjeev7/-Brainwave_Matrix_Intern.git

```
2. Navigate to project dircetory
```
   cd ATM_Interface
```
3. Compile the Java files

```
javac src/packagename/*.java
```

4. Run the application
```
java src/packagename/Main
```

## Usage

1. Start the application

2. Enter account number and PIN

3. Select from available operations:

     - Check Balance

    - Withdraw Money

    - Deposit Money

    - Transfer Funds

    - View Transaction History

    - Exit

4. Security Features

- PIN-based authentication

- Transaction validation

- Exception handling for invalid operations

- Secure balance management

## Error Handling
  - Insufficient Balance

  - Invalid Amount

  - Invalid Account Number

  - Invalid PIN

  - Transaction Limits

## Best Practices Implemented
  - SOLID Principles

  - Clean Code

  - Proper Exception Handling

  - Input Validation

  - Transaction Security

## Future Enhancements
  - Database Integration

  - Multiple Account Types

  - SMS/Email Notifications

  - Enhanced Security Features

  - User Interface Improvements

## Contributing
Fork the repository

Create your feature branch
