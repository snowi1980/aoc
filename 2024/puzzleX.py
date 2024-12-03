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


file_path = './exampleX-1.txt'

string_array = read_file_to_string_array(file_path)

result1 = 0
result2 = 0

for s in string_array:
    print(f"String:{s}")

print(f"Result1:{result1}")
print(f"Result2:{result2}")

