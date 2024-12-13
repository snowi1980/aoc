class Point:
    def __init__(self, x, y, value):
        if not (isinstance(x, (int, float)) and isinstance(y, (int, float)) ):
            raise ValueError("Coordinates and value must be numeric")
        self.x = x
        self.y = y
        self.value = value

    def __repr__(self):
        return f"Point(x={self.x}, y={self.y}, value={self.value})"

    def distance_to(self, other):
        return ((self.x - other.x) ** 2 + (self.y - other.y) ** 2) ** 0.5

    def value(self):
        return self.value



