import string
import re
import time
from common import Point, PointMap


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


file_path = './example11-1.txt'    

#char_array = read_file_to_string_array(file_path)
#pebbles = [125, 17]




def puzzle():
    pebbles = [4329, 385, 0, 1444386, 600463, 19, 1, 56615]
    start_time = time.time()
    
    result1 = 0
    result2 = 0

    for blink in range (1,46):
        new_pebbles = []
        #print(pebbles)
        i = 0
        while i < len(pebbles):
            #print(f"num_pebblea:{num_pebbles} and i {i}")
            pebble = pebbles[i]
    
            digts = len(str(pebble))
                                
            if(pebble == 0):
                new_pebbles.append(1)
                #print("0 -> 1")
            elif (digts%2 == 0):
                tmp = str(pebble)
                left = int(tmp[:digts//2])
                right = int(tmp[digts//2:])
                new_pebbles.append(left)
                new_pebbles.append(right)
                #print(f"for {i}: {pebble} -> {left},{right}")
                #
            else:   
                new_pebbles.append(pebble * 2024)     
                #print(f"{pebble} -> {pebble* 2024}")
            i += 1
        pebbles = new_pebbles
            
        print(f"{len(pebbles)} pebbles after {blink} blinks")
        #print(pebbles)
    
    print(f"Result1:{result1}")
    print(f"Result2:{result2}")        

    end_time = time.time()

    elapsed_time = end_time - start_time
    print(f"Time needed to execute the puzzle method: {elapsed_time:.6f} seconds")


