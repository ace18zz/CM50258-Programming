  #This is your SRPN file. Make your changes here.
import re
import operator as op
from collections import deque
import random


# global stack,max_value,min_value,answer,in_comment,rand_count,rand_list
stack =  deque() #main stack 
max_value = 2147483647
min_value = -2147483647
regular1 = "-\d+|\d+|[+-\/*^%]=|[+-\/*^%=]"
regular2 = "-\d+|\d+|[+-\/*^%]$"

def caculator(command):
    global ans
    if len(stack)>1:
            num1 = stack.pop()
            num2 = stack.pop()
# perform the desired calculation using the numbers from the top of the stack
            if(command == "+"):
                ans = num1 + num2
                pushNum(ans)
            elif(command == "-"):
                ans = num2-num1
                pushNum(ans)
            elif(command == "*"):
                ans = num1*num2
                pushNum(ans)
            elif(command == "/"):
                if num1 == 0 :
                    print("Divide by 0.")
                else :
                     ans = num2//num1
                     pushNum(ans)
            elif(command == "%"):
                ans = num2 % num1
                pushNum(ans)
            elif(command == "^"):
                if num1 < 0 :
                    print ("Negative power.") 
                else:
                    ans = num2 ** num1
          
                    pushNum(ans)

    elif command =="=":
        # output top one on the stack
            print(peekStack())
    else:
        # inform the user of underflow if they try to perform calculations on a stack with less than two elements
        print("Stack underflow.")

def workinput(command):
    
    if len(re.findall("-\d+|\d+", command)) > 0:
            pushNum(int(command.strip()))
    if  len(re.findall("[+-\/*%^=]", command)) > 0:
        caculator(command.strip())

    if command == "d":
         # if the stack is empty
         # output -2147483648
        if len(stack) <= 0:
            print(min_value)
        else:
        #otherwise output number in stack
            dStack()
    elif command == "r":
        global rand_count
        print(random.randint(min_value,max_value))
        stack.append(random.randint(min_value,max_value))

# for input "d"
def dStack():
    for i in stack:
        print(i)
# check number then push it in to stack        
def pushNum(num):
    if num > max_value:
        stack.append(max_value)
    elif num <min_value:
        stack.append(min_value)
    else :
        stack.append(num)

def process_command(command):
    if len(command) > 0:
        cleanCommand = re.findall(regular1, command)

        if len(cleanCommand) >= 1:
            for element in cleanCommand:
                if len(re.findall(regular2, element)) > 0:
                    workinput(element)
                else:#Reverse processing if the element starts with an equal sign
                    for element in element[::-1]:
                        workinput(element)
        else:
            workinput(command)

def peekStack():
    if len(stack) <= 0 :
        print("Stack underflow.")
    else:
        return stack[-1]



#This is the entry point for the program.
#Do not edit the below
if __name__ == "__main__": 
    while True:
        try:
            cmd = input()
            pc = process_command(cmd)
            if pc != None:
                print(str(pc))
        except:
            exit()
