#!/usr/bin/env python3
#
# Wuheng Yu
# 11/20/2019
# Platform: Linux 4.15.0-66-generic (x86_64 x86_64 x86_64 GNU/Linux)
# Python 3.6.8
# accounts.py: Uses a log file that contains a list of account transactions (deposits and withdrawals),
# to create and give the options to show a specific account's info or transaction history.
# There's also an option to insert a transaction to a specific account.
#

import sys
import os
import datetime

"""
This function reads and splits each line in the "filename" variable into lists.
Each of those list are then appended to an initially empty list, called accInfo.
The result is a list of lists.

A try and except block will be used to handle the FileNotFoundError.
"""
def readFile(accInfo) :
    try :
        with open(filename) as filenames :
            for line in filenames : 
                splitInfo = line.split(":")
                accInfo.append(splitInfo)
        filenames.close()
    except FileNotFoundError:
        print(f'\n{filename} does not exist in current directory or the specified path.\n')
        sys.exit(1)

"""
This function uses the lambda function to first sort by account name, account[1];
if the account name are the same, the function then goes to sort by the account #, account[0].
"""
def sortAccInfo(accInfo) :
    accInfo.sort(key = lambda account: (account[1],account[0]))

"""
Parameter: (The already sorted "accInfo" list, empty dictionary "accDict") 

This function creates a dictionary with unique account # as the key; 
a list that stores the name and balance associated with the specific account #
is the value of the dictionary key.

NOTE: The result will be a sorted dicitonary, since this function
      uses the already sorted "accInfo" list.
"""
def createDict(accInfo, accDict) :
    acc_info = []                       # a list to temporarily hold the name and balance
    for i in range(0, len(accInfo)) :
        key = accInfo[i][0]
        acc_info.append(accInfo[i][1])
        acc_info.append(0)              # balance of each account is initially 0
        accDict[key] = acc_info
        acc_info = []

"""
This function calculates the balance of each account by using the "accInfo" list.
For each list or transaction in the "accInfo" list, a withdrawal or deposit
calculation will be performed on the account associated with the transaction.

A withdrawal will subtract from current balance of the specific account.
A deposit will add to the specific account's balance.
"""
def calc_balance(accInfo, accDict) :
    W = 0                               # temporarily store the amount of the withdrawal
    D = 0
    for i in accInfo :
        if i[3] == 'W' :
            W -= float(i[4].strip())
            balance = float(accDict[i[0]][1])
            balance += W
            accDict[i[0]][1] = balance
            W = 0                       # reset the withdrawal amount for next transaction

        elif i[3] == 'D' :
            D += float(i[4].strip())
            balance = float(accDict[i[0]][1])
            balance += D
            accDict[i[0]][1] = balance
            D = 0

"""
This function gives the option to select an account from the "accDict" dictionary.
It will also display an enumerated, alphabetical list of account holders, 
followed by the account number.
There's also an option to quit the program.

When an account is selected, the specified account's 
account #, name, and balance will be displayed.
Then the program will prompt to return to the list of account holders.
"""
def get_accInfo(accDict) :

    while True :
        i = 1                             # counter to enumerate account holders
        print('\nInfo\n----')
        for key in accDict :
            print(str(i) + ') ' + str(accDict[key][0]) + ' ' + key)
            i += 1
        print('q)uit\n')
        
        choice = input('Enter choice => ')
        print('')
        if choice == 'q' :
            break

        i = 1
        for key in accDict :
            if choice == str(i) :
                print(f'  {"account #:":>10}  {key}')
                print(f'  {"name:":>10}  {accDict[key][0]}')
                if accDict[key][1] < 0 :
                    x = (-1 * accDict[key][1])
                    print(f'  {"balance:":>10}  -${x:,.2f}')
                else :
                    print(f'  {"balance:":>10}  ${accDict[key][1]:,.2f}')
                while True :
                    choice = input('\nEnter "r" or "R" to return to account list: ')
                    if choice.lower() == 'r' :
                        break
            else :
                i += 1

"""
The u_Info parameter is the "unsortedAccInfo" variable at the bottom of this script, 
which is a list of unsorted transactions from the log file.
The transactions in the log file are already in chronological order,
so the transactions in u_Info is also in chronological order.

This function gives the option to select an account from the "accDict" dictionary.
It will also display an enumerated, alphabetical list of account holders,
followed by the account number.
There's also an option to quit the program.

When an account is selected, the specified account's 
transaction history will be displayed in chronological order.
Then the program will prompt to return to the list of account holders.
"""
def get_accHistory(u_Info, accDict) :
    while True :
        i = 1
        print('\nInfo\n----')
        for key in accDict :
            print(str(i) + ') ' + str(accDict[key][0]) + ' ' + key)
            i += 1
        print('q)uit\n')

        i = 1
        choice = input('Enter choice => ')
        print('')
        if choice == 'q' :
            break

        for key in accDict :
            if choice == str(i) :
                for info in u_Info :
                    if (key == info[0]) and (info[3] == 'W') :
                        transaction = float(info[4].strip())
                        print(f'   {info[2]} withdrawal ${transaction:,.2f}')
                    elif (key == info[0]) and (info[3] == 'D') :
                        transaction = float(info[4].strip())
                        print(f'   {info[2]} deposit ${transaction:,.2f}')
                while True :
                    choice = input('\nEnter "r" or "R" to return to account list: ')
                    if choice.lower() == 'r' :
                        break
            else :
                i += 1

"""
This function gives the option to select an account from the "accDict" dictionary.
It will also display an enumerated, alphabetical list of account holders,
followed by the account number.
There's also an option to quit the program.
There's also an optiin to create a new account.

When an account is selected, the program will prompt for
a withdrawal or deposit to the specified account.

When a transaction type (withdrawal or deposit) is selected,
the program will prompt for the amount to withdraw or deposit.
The function will check if the input is a number.

After an amount is entered, the program will
write the appropriate transaction history to the log file
and exit to the list of account holders.
"""
def insert_trans(accDict) :
    
    while True :
        i = 1                                # counter to enumerate account holders
        print('\nInfo\n----')
        for key in accDict :
            print(str(i) + ') ' + str(accDict[key][0]) + ' ' + key)
            i += 1
        print('c)reate new account')
        print('q)uit\n')

        choice = input('Enter choice => ')
        print('')
        if choice == 'q' :
            break
        elif choice == 'c' :                 # option to create an account
            create_Acc()  
            update_AccInfo()                 # make sure that the new account shows up on the list of account holders

        i = 1
        for key in accDict :
            if choice == str(i) :
                trans = input('Enter "w" to withdraw, or "d" to deposit: ')
                while True :
                    if trans == 'w' :
                        W = input('\nEnter the amount to withdraw: $')
                        userInput = "".join(W.split(".", 1))                     # used to check for decimal number input
                        while True:
                            if userInput.isdigit() :
                                break
                            else :
                                W = input('\nEnter the amount to withdraw: $')
                                userInput = "".join(W.split(".", 1))

                        d = datetime.datetime.now()                              
                        date = d.strftime("%y.%m.%d")                            # string format of today's date YY.MM.DD
                        new_entry = f'{key}:{accDict[key][0]}:{date}:W:{W}\n'
                        with open(filename, 'a') as filenames :
                            filenames.write(new_entry)
                            filenames.close()
                        break

                    elif trans == 'd' :
                        D = input('\nEnter the amount to deposit: $')
                        userInput = "".join(D.split(".", 1))
                        while True :
                            if userInput.isdigit() :
                                break
                            else :
                                D = input('\nEnter the amount to deposit: $')
                                userInput = "".join(D.split(".", 1))

                        d = datetime.datetime.now()
                        date = d.strftime("%y.%m.%d")
                        new_entry = f'{key}:{accDict[key][0]}:{date}:D:{D}\n'
                        with open(filename, 'a') as filenames :
                            filenames.write(new_entry)
                            filenames.close()
                        break

                    else :
                        trans = input('\nEnter "w" to withdraw, or "d" to deposit: ')
                break
            else :
                i += 1

"""
This function first prompts for a new account name.
Then a 4 digit account # will be generated for the new account name.
The generated account # will be unique to the list of account holders.

Lastly, the function will prompt to withdraw or deposit and perform 
the other necessary function, as it was done in the insert_trans() function.
"""
def create_Acc() :
    name = input('Enter new account name: ')
    uniq_key = None
    for k in range(0, 10000) :
        if f'{k:04d}' not in accDict :
            uniq_key = f'{k:04d}'
            print(uniq_key + ' is your account #.')
            break
    if uniq_key == None :
        print('\nNo more room for accounts. Account not created.')
    elif uniq_key != None :
        i = 1
        trans = input('\nEnter "w" to withdraw, or "d" to deposit: ')
        while True :
            if trans == 'w' :
                W = input('\nEnter the amount to withdraw: $')
                userInput = "".join(W.split(".", 1))
                while True:
                    if userInput.isdigit() :
                        break
                    else :
                        W = input('\nEnter the amount to withdraw: $')
                        userInput = "".join(W.split(".", 1))

                d = datetime.datetime.now()
                date = d.strftime("%y.%m.%d")
                new_entry = f'{uniq_key}:{name}:{date}:W:{W}\n'
                with open(filename, 'a') as filenames :
                    filenames.write(new_entry)
                    filenames.close()
                break

            elif trans == 'd' :
                D = input('\nEnter the amount to deposit: $')
                userInput = "".join(D.split(".", 1))
                while True :
                    if userInput.isdigit() :
                        break
                    else :
                        D = input('\nEnter the amount to deposit: $')
                        userInput = "".join(D.split(".", 1))

                d = datetime.datetime.now()
                date = d.strftime("%y.%m.%d")
                new_entry = f'{uniq_key}:{name}:{date}:D:{D}\n'
                with open(filename, 'a') as filenames :
                    filenames.write(new_entry)
                    filenames.close()
                break

            else :
                trans = input('\nEnter "w" to withdraw, or "d" to deposit: ')
    else :
        i += 1

"""
This function is used to update the list of account holders menu
after a new account is created or when the create_Acc() function is executed. 
This is so that the new account is displayed and available to perform 
transcation(s) on, when the user returns to the list of account holders menu.
"""
def update_AccInfo() :
    readFile(unsortedAccInfo)
    readFile(accInfo)
    sortAccInfo(accInfo)
    createDict(accInfo, accDict)
    calc_balance(accInfo, accDict)

"""
This function prints a usage message.
"""
def show_usage() :
    print('\nExecute with the following options:')
    print('   -i View Account Information')
    print('   -h View Account History')
    print('   -t Insert Transaction')
    print('   -? Show Usage Message\n')

try :
    filename = os.environ['ACCT_LIST'] #try and except this.
except KeyError :
    print('\nThe environment variable, ACCT_LIST, is not exported')
    print('or not assigned any value.\n')
    sys.exit(1)

unsortedAccInfo = []                   # unsorted list of the transaction from the log file
accInfo = []                           # sorted list of the transaction from the log file
accDict = {}                           # sorted dictionary of accounts

readFile(unsortedAccInfo)
readFile(accInfo)
sortAccInfo(accInfo)
createDict(accInfo, accDict)           
calc_balance(accInfo, accDict)

if (len(sys.argv) > 1) :
    if (sys.argv[1] == "-i") :
        get_accInfo(accDict)

    elif (sys.argv[1] == "-h") :
        get_accHistory(unsortedAccInfo, accDict)

    elif (sys.argv[1] == "-t") :
        insert_trans(accDict)
    elif (sys.argv[1] == "-?") :
        show_usage() 
    else :
        print('\nUse the "-?" for usage info.\n')
else :
    show_usage()

sys.exit(0)
