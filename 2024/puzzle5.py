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


file_path = './puzzle5-1.txt'

string_array = read_file_to_string_array(file_path)

result1 = 0
result2 = 0

order_rules = {}
wrong_updates = []

def create_ordering_rules(order_rule):
    rules = order_rule.split("|")
    page = int(rules[0])
    order = int(rules[1])
    if(page in order_rules):
        order_rules[page].add(order)
    else:
        order_rules[page] = {order}
        

def extract_middle_value(pages):
   # print(f"correctUpdate {updates}")    
    size = len(pages) - 1
    middle = size // 2
   # print(f"Middle:{pages[middle]}")
    return pages[middle]


def check_ordering_rules(updates):
    pages =  list(map(int, updates.split(",")))
    i = 1   
    for  page in pages[:-1]:
        #print(f"Checking:{i} {page}")
        if(page in order_rules):
            orders = order_rules[page]
         #   print(f"{pages[i:]}")
         #   print(f"{orders}")
            for checkPage in pages[i:]:
               # print(f"Checking: if {checkPage} in {orders}")
                if(checkPage not in orders):
                   # print(f" Not Found: {checkPage} in {orders}")
                    wrong_updates.append(pages)
                    return 0
        else:
            wrong_updates.append(pages)
            return 0
        i += 1
    return extract_middle_value(pages)
    

def correct_unordered_pages(unorderd):
       
    for i in range(len(unorderd)):
        page = unorderd[i]
        print(f"Checking unordered:{i} {page}")
        if(page in order_rules):
            orders = order_rules[page]
            for checkPage in unorderd[i:]:
                print(f"Checking: if {checkPage} in {orders}")
                if(checkPage not in orders):
                    print(f" Not Found: {checkPage} in {orders}")
                    if(page in order_rules[checkPage]):
                        #swap
                        unorderd.remove(checkPage)
                        unorderd.insert(i, checkPage)
                        print(f"Swapped:{unorderd}") 
        else:
            print(f"Page {page} not found in order rules --> send to back")
            unorderd.remove(page)
            unorderd.append(page)
            print(f"Unordered1:{unorderd}")

        #print(f"Unordered:{unorderd_pages}")
    return extract_middle_value(unorderd_pages)


for s in string_array:
    #print(f"String:{s}")
    if ("|" in s):
        create_ordering_rules(s)
    elif("," in s):
        result1 += check_ordering_rules(s)

for unorderd_pages in wrong_updates:
    result2 += correct_unordered_pages(unorderd_pages)
        
print(f"{len(wrong_updates)}")
print(f"Result1:{result1}")
print(f"Result2:{result2}")


