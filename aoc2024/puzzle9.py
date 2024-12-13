import string
import re
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

def convert_string_to_int_list(file_path):
    with open(file_path, 'r') as file:
        content = file.read().replace('\n', '')
    int_list = [int(char) for char in content if char.isdigit()]
    return int_list


file_path = './puzzle9-1.txt'

    


diskMap = convert_string_to_int_list(file_path)




def print_string_n_times(s, n):
    retval = ""
    for _ in range(n):
        retval += s 
    return retval

def add_id_n_times(map,start,id, n):  
    for _ in range(n):
        map[start] = id
        start += 1

def add_free_blocks(map,start, n):
        if(n > 0):
            map[start] = n
        
    
def puzzle():
    result1 = 0
    result2 = 0
    freeBlocksNum = 0 
   # print(diskMap)    
    isBlock = True
    id = 0
    i = 0 
    text = ""
    disc = dict()
    freeBlocks = dict()
    for value in diskMap:
        if(isBlock):
            text += print_string_n_times(str(id), value)
            add_id_n_times(disc,i,id,value)
            id += 1
        else:   
            text += print_string_n_times(".", value)   
            add_free_blocks(freeBlocks,i,value)
            freeBlocksNum += value
        i += value
         
        isBlock = not isBlock


    idList = list(disc.keys())

    for start in freeBlocks:    
        times = freeBlocks[start]
        for j in range(times):
                val = idList.pop()
                if(start >= val):
                    break    
                id = disc[val]
                #print(f"Update Disc at:{start + j} to ID:{id} already replaced: {replaced} entries")
                disc[start+j] = id
                disc[val] = "."


    newMap = ""


    for z in sorted(disc.keys()):
        
        if(disc[z] == '.'):
            break;
        newMap += str(disc[z])
        result1 += z * int(disc[z])
        

    print(f"newMap:{newMap}")
    print(f"Result1:{result1}")
    print(f"Result2:{result2}")

