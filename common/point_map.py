from .point import Point

class PointMap:
    
    
    def __init__(self):
        self.points = {}
        self.rows = 0
        self.cols = 0
        
    def __init__(self,char_array):
        self.points = {}
        self.rows = 0
        self.cols = 0  
        
        for i in range(len(char_array)):
            for j in range(len(char_array[i])):
                self.add_point(Point(i, j, char_array[i][j]))   

    def add_point(self, point):
       # print(point)
        self.points[(point.x, point.y)] = point
        self.rows = max(self.rows, point.x)
        self.cols = max(self.cols, point.y)

    def get_point(self, x, y):
        return self.points.get((x, y))

    def get_point_value(self, x, y):
        if(self.points.get((x, y)) == None):
            return None
        return self.points.get((x, y)).value
    
    def update_point_value(self, x, y, value):
        self.points[(x, y)].value = value


    def get_adjacent_points(self, x, y):
        adjacent_coords = [
            (x - 1, y), (x + 1, y),  # Left and Right
            (x, y - 1), (x, y + 1)   # Up and Down
        ]
        return [self.get_point(cx, cy) for cx, cy in adjacent_coords if (cx, cy) in self.points]
    
    
    def print_point_map_values(self):
        
        for i in range(self.rows+1):
            line = ""
            for j in range(self.cols+1):
                line += self.get_point_value(i, j)
            print(line)

    def find_first_point(self, value):
        for point in self.points.values():
            if point.value == value:
                return point
        return None
    
    def find_points(self, value):
        points = []
        for point in self.points.values():
            if point.value == value:
                points.append(point)
        return 
    
    def move(self, point, direction):
        moves = {"NORTH": (-1, 0), "SOUTH": (1, 0), "WEST": (0, -1), "EAST": (0, 1)}
        dx, dy = moves[direction]
        new_x, new_y = point.x + dx, point.y + dy
        return self.get_point(new_x, new_y)
    
    def turn_right(self, direction):
        turn_right = {"NORTH": "EAST", "SOUTH": "WEST", "WEST": "NORTH", "EAST": "SOUTH"}
        return turn_right[direction]
    
    def look_around(self, point, value):
        results = []
        directions = [(1,0),(0,1),(0,-1),(-1, 0)]
        for dx, dy in directions:
            new_x, new_y = point.x + dx, point.y + dy   
            print(f"Checking {new_x},{new_y} for {value}")                
            if (value == self.get_point_value(new_x, new_y)):
                results.append(self.get_point(new_x, new_y))
                #print(f"found {self.get_point(new_x, new_y)}")    
        return results    