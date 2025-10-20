package edu.luc.cs.laufer.cs371.shapes

import Shape.*

object scale:
    def apply(s: Shape, factor: Double): Shape = s match
        case Rectangle(width, height) =>
        Rectangle((width * factor).toInt, (height * factor).toInt)
        
        case Location(x, y, shape) =>
        Location((x * factor).toInt, (y * factor).toInt, apply(shape, factor))
        
        case Ellipse(rx, ry) =>
        Ellipse((rx * factor).toInt, (ry * factor).toInt)
        
        case Group(shapes*) =>
        Group(shapes.map(apply(factor))*)
        
    end scale