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


file_path = './example10-2.txt'

point_map = PointMap()
    

char_array = read_file_to_string_array(file_path)
trail_heads  = []



def puzzle():
    result1 = 0
    result2 = 0

    for y in range(len(char_array)):
        for x in range(len(char_array[y])):
            value = char_array[y][x]
            point_map.add_point(Point(x, y, value))
            if(value == "0"):
                trail_heads.append(point_map.get_point(x, y))
                
    paths = {"0": trail_heads}

    
    height = 0

    for height in range(0, 9):
        height += 1
        for step in paths[str(height-1)]:
            
            next_ones = (point_map.look_around(step, str(height)))
            if len(next_ones) > 0:
                
                if str(height) in paths:
                    paths[str(height)].extend(next_ones)
                else:
                    paths[str(height)] = next_ones
                    
                if(str(height) == "9"):
                    result1 += 1
            
    print(f"Paths:{paths['9']}")
    print(f"3,5:{point_map.get_point(3, 5)}")
    print(f"Result1:{result1}")
    print(f"Result2:{result2}")        



