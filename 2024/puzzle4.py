import string
import re


def read_file_to_string_array(file_path):
    with open(file_path, 'r') as file:
        return [line.strip() for line in file]


def read_file_to_string(file_path):
    with open(file_path, 'r') as file:
        content = file.read().replace('\n', '')
    return content


def read_file_to_2d_char_array(file_path):
    with open(file_path, 'r') as file:
        # Read lines and convert each line to a list of characters in one step
        char_array = [list(line.strip()) for line in file]
    return char_array

XMAS = r"XMAS"
SAM = r"SAM"
MAS = r"MAS"


file_path = './puzzle4-1.txt'

char_array = read_file_to_string_array(file_path)


def findChristmasTimes(row, col):
    xmases = []
    # right 
    if (col + 3 < max_cols):
        # print(f"right")
        xmases.append(char_array[row][col]  + char_array[row][col+1]  + char_array[row][col+2] + char_array[row][col+3] )
    # left
    if (col - 3 >= 0):
        # print(f"left")
        xmases.append(char_array[row][col]  + char_array[row][col-1]  + char_array[row][col-2] + char_array[row][col-3] )
    
    # up
    if (row + 3 < max_rows):
        # print(f"up")
        xmases.append(char_array[row][col]  + char_array[row+1][col]  + char_array[row+2][col] + char_array[row+3][col] )
    # down
    if (row - 3 >= 0):
        # print(f"down")
        xmases.append(char_array[row][col]  + char_array[row-1][col]  + char_array[row-2][col] + char_array[row-3][col] )
   
    # up right 
    if (row + 3 < max_rows and col + 3 < max_cols):
        # print(f"up right")
        xmases.append(char_array[row][col]  + char_array[row+1][col+1]  + char_array[row+2][col+2] + char_array[row+3][col+3] )
    
    # down left
    if (row - 3 >= 0 and col - 3 >= 0):
        # print(f"down left")
        xmases.append(char_array[row][col]  + char_array[row-1][col-1]  + char_array[row-2][col-2] + char_array[row-3][col-3] )
    
    # up left 
    if (row + 3 < max_rows and col - 3 >= 0):
        # print(f"up left")
        xmases.append(char_array[row][col]  + char_array[row+1][col-1]  + char_array[row+2][col-2] + char_array[row+3][col-3] )
    
    #down right
    if (row - 3 >= 0 and col + 3 < max_cols):
        # print(f"down right")
        xmases.append(char_array[row][col]  + char_array[row-1][col+1]  + char_array[row-2][col+2] + char_array[row-3][col+3] )
   
   
  #  print(f"XMAS: {xmases}")
    count = sum(len(re.findall(XMAS, xmas)) for xmas in xmases)
   # print(f"Found: {count}")
    return count


def findXMASTimes(row, col):

    xmases = {"SAMSAM", "MASMAS", "SAMMAS", "MASSAM"}

     
    if (row in range (1, max_rows-1) and col in range(1, max_cols-1)):
        # print(f"up right")
        xmases.add(char_array[row-1][col-1]  + char_array[row][col]  + char_array[row+1][col+1] + char_array[row+1][col-1]  + char_array[row][col]  + char_array[row-1][col+1]  )
    else:
        return 0
    
   # print(f"XMAS: {xmases}")
    
    if(len(xmases) == 4):
        return 1
    
    return 0


max_rows = len(char_array)
max_cols = len(char_array[0])



result1 = 0
result2 = 0

for i in range(len(char_array)):
    for j in range(len(char_array[i])):
        #if(j == 4 and i == 4):
            result1 += findChristmasTimes(i, j)
            result2 += findXMASTimes(i, j)


print(f"Result1: {result1}")
print(f"Result2: {result2}")

