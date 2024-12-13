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


file_path = './puzzle6-1.txt'
result1 = 0
result2 = 0
point_map = PointMap()
    

char_array = read_file_to_string_array(file_path)

def turn_right(direction):
    if direction == '^':
        return '>'
    if direction == 'v':
        return '<'
    if direction == '<':
        return '^'
    if direction == '>':
        return 'v'
    return direction


def move(point):
    direction = point.value
    moves = {'^': (-1, 0), 'v': (1, 0), '<': (0, -1), '>': (0, 1)}
    
    dx, dy = moves[direction]
    new_x, new_y = point.x + dx, point.y + dy
    
    point_map.update_point_value(point.x, point.y, 'X')
    move_to = point_map.get_point(new_x, new_y)
    
    if move_to and move_to.value != '#':
        point_map.update_point_value(new_x, new_y, direction)
        return move_to
    elif move_to and move_to.value == '#':
        direction = turn_right(direction)
        point_map.update_point_value(point.x, point.y, direction)
        return point
    
    return None


def puzzle():

    

    for i in range(len(char_array)):
        for j in range(len(char_array[i])):
            point_map.add_point(Point(i, j, char_array[i][j]))    
        

    point = point_map.find_first_point('^')
    while point != None:
        print(point)	
        point = move(point)
    
    print(point_map.print_point_map_values())
    result1 = len(point_map.find_points('X'))
    print(f"Result1:{result1}")
    print(f"Result2:{result2}")

