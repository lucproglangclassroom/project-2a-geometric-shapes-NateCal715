package edu.luc.cs.laufer.cs371.shapes

import TestFixtures.*
import Shape.*
import org.scalatest.funsuite.AnyFunSuite

class TestSize extends AnyFunSuite:
  
  test("size of a rectangle") {
    val r = Rectangle(10, 20)
    assert(size(r) == 1)
  }

  test("size of an ellipse") {
    val e = Ellipse(15, 25)
    assert(size(e) == 1)
  }

    test("size of a location") {
        val l = Location(5, 5, Rectangle(10, 20))
        assert(size(l) == 1)
    }

    test("size of a basic group") {
        val g = Group(Ellipse(10, 20), Rectangle(30, 40))
        assert(size(g) == 2)
    }

    test("size of a complex group") {
        val g = Group(
            Location(0, 0, Ellipse(10, 20)),
            Location(10, 10, Rectangle(30, 40)),
            Group(
                Rectangle(5, 5),
                Ellipse(15, 25)
            )
        )
        assert(size(g) == 4)
    }

end TestSize
    