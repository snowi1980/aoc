import string
import re


def read_file_to_string_array(file_path):
    with open(file_path, 'r') as file:
        lines = file.readlines()
    # Strip newline characters from each line
    lines = [line.strip() for line in lines]
    return lines

def read_file_to_string(file_path):
    content = ""
    with open(file_path, 'r') as file:
        lines = file.readlines()
    # Strip newline characters from each line
    lines = [line.strip() for line in lines]
    for line in lines:
        content += line
    return content

def read_file_to_2d_char_array(file_path):
    with open(file_path, 'r') as file:
        lines = file.readlines()
    # Convert each line to a list of characters and store in a 2D array
    char_array = [list(line.strip()) for line in lines]
    return char_array

file_path = './example3-1.txt'
s = read_file_to_string(file_path)
string_array = read_file_to_string_array(file_path)
regex = r"mul\(\d{1,3},\d{1,3}\)"
regex2 = r"\d{1,3}"

products = []
result1 = 0
result2 = 0

def multiply_numbers(s):
  result = 0
  products = re.findall(regex, s)

  for i in range(0, len(products)):
      numbers = re.findall(regex2, products[i])
      result += int(numbers[0]) * int(numbers[1])

  return result

result1 = multiply_numbers(s)

dos = s.split("do()")

for text in dos:
  stop = text.find("don't()")
  print(f"Stop:{stop}")
  if stop > 0:
    result2 += multiply_numbers(text[:stop])
  else:
    result2 += multiply_numbers(text)
  
print(f"Dos:{len(dos)}")

print(f"Result1:{result1}")
print(f"Result2:{result2}")

#assert(result1 == 11)
#3323218
#41795107