from common import Point, PointMap

# Example function using Point and PointMap
def example_usage():
    point_map = PointMap()
    point_map.add_point(Point(0, 0, 10))
    point_map.add_point(Point(1, 0, 20))
    point_map.add_point(Point(0, 1, 30))
    point_map.add_point(Point(1, 1, 40))

    point = point_map.get_point(0, 0)
    print(point)  # Output: Point(x=0, y=0, value=10)

    adjacent_points = point_map.get_adjacent_points(0, 0)
    print(adjacent_points)  # Output: [Point(x=1, y=0, value=20), Point(x=0, y=1, value=30)]