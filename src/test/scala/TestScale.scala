package edu.luc.cs.laufer.cs371.shapes

import TestFixtures.*
import Shape.*
import org.scalatest.funsuite.AnyFunSuite

class TestScale extends AnyFunSuite:
  
  test("scale a rectangle") {
    val r = Rectangle(10, 20)
    val scaled = scale(r, 2.0)
    assert(scaled == Rectangle(20, 40))
  }

  test("scale an ellipse") {
    val e = Ellipse(15, 25)
    val scaled = scale(e, 2.0)
    assert(scaled == Ellipse(30, 50))
  }

    test("scale a location") {
        val l = Location(5, 5, Rectangle(10, 20))
        val scaled = scale(l, 2.0)
        assert(scaled == Location(10, 10, Rectangle(20, 40)))
    }

    test("scale a basic group") {
        val g = Group(Ellipse(10, 20), Rectangle(30, 40))
        val scaled = scale(g, 2.0)
        assert(scaled == Group(Ellipse(20, 40), Rectangle(60, 80)))
    }

    test("scale a complex group") {
        val g = Group(
            Location(0, 0, Ellipse(10, 20)),
            Location(10, 10, Rectangle(30, 40)),
            Group(
                Rectangle(5, 5),
                Ellipse(15, 25)
            )
        )
        val scaled = scale(g, 2.0)
        assert(scaled == Group(
            Location(0, 0, Ellipse(20, 40)),
            Location(20, 20, Rectangle(60, 80)),
            Group(
                Rectangle(10, 10),
                Ellipse(30, 50)
            )
        ))
    }

end TestScale