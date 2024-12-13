import unittest
from common import Point, PointMap

class TestPointMap(unittest.TestCase):
    def test_add_and_get_point(self):
        point_map = PointMap()
        point = Point(0, 0, 10)
        point_map.add_point(point)
        self.assertEqual(point_map.get_point(0, 0), point)

    def test_get_adjacent_points(self):
        point_map = PointMap()
        point_map.add_point(Point(0, 0, 10))
        point_map.add_point(Point(1, 0, 20))
        point_map.add_point(Point(0, 1, 30))
        point_map.add_point(Point(1, 1, 40))
        adjacent_points = point_map.get_adjacent_points(0, 0)
        self.assertEqual(len(adjacent_points), 2)

if __name__ == '__main__':
    unittest.main()