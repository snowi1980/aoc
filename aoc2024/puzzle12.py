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




#char_array = read_file_to_string_array(file_path)
#pebbles = [125, 17]




def puzzle():
    file_path = './example12-1.txt'    
    start_time = time.time()
    
    result1 = 0
    result2 = 0
    
    
    char_array = read_file_to_string_array(file_path)
    point_map = PointMap(char_array)
    
    print(point_map.print_point_map_values())
    
    region_points = set()
    
    for i in range(point_map.rows+1):
        for j in range(point_map.cols+1):
            point = point_map.get_point(i, j)
            if point.value == '#':
                region_points.add(point)
    
    print(f"Result1:{result1}")
    print(f"Result2:{result2}")        

    end_time = time.time()

    elapsed_time = end_time - start_time
    print(f"Time needed to execute the puzzle method: {elapsed_time:.6f} seconds")


