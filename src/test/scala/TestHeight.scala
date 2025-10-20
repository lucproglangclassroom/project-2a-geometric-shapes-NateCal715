package edu.luc.cs.laufer.cs371.shapes

import TestFixtures.*
import Shape.*
import org.scalatest.funsuite.AnyFunSuite

class TestHeight extends AnyFunSuite:
  
  test("height of a rectangle") {
    val r = Rectangle(10, 20)
    assert(height(r) == 1)
  }

  test("height of an ellipse") {
    val e = Ellipse(15, 25)
    assert(height(e) == 1)
  }

    test("height of a location") {
        val l = Location(5, 5, Rectangle(10, 20))
        assert(height(l) == 2)
    }

    test("height of a basic group") {
        val g = Group(Ellipse(10, 20), Rectangle(30, 40))
        assert(height(g) == 2)
    }

    test("height of a complex group") {
        val g = Group(
            Location(0, 0, Ellipse(10, 20)),
            Location(10, 10, Rectangle(30, 40)),
            Group(
                Rectangle(5, 5),
                Ellipse(15, 25)
            )
        )
        assert(height(g) == 3)
    }

end TestHeight