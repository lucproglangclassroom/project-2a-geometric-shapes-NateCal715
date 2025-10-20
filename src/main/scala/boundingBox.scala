package edu.luc.cs.laufer.cs371.shapes

// TODO: implement this behavior

import Shape.*

object boundingBox:
  def apply(s: Shape): Location = s match
    
    case Ellipse(rx, ry) =>
      Location(-rx, -ry, Rectangle(2 * rx, 2 * ry))
    
    case Rectangle(width, height) =>
      Location(0, 0, Rectangle(width, height))
    
    case Location(x, y, shape) =>
      val Location(u, v, Rectangle(w, h)) = apply(shape)
      Location(x + u, y + v, Rectangle(w, h))
    
    case Group(shapes*) =>
      
      val boxes = shapes.map(apply)
      
      
      val leftEdges = boxes.map {
        case Location(x, _, Rectangle(_, _)) => x
      }
      
      val rightEdges = boxes.map {
        case Location(x, _, Rectangle(w, _)) => x + w
      }
      
      val topEdges = boxes.map {
        case Location(_, y, Rectangle(_, _)) => y
      }
      
      val bottomEdges = boxes.map {
        case Location(_, y, Rectangle(_, h)) => y + h
      }
        
      val minX = leftEdges.min
      val minY = topEdges.min
      val maxX = rightEdges.max
      val maxY = bottomEdges.max
        
      Location(minX, minY, Rectangle(maxX - minX, maxY - minY)) 
    
    
    // Default cases for Rectangle and Location
    case _ => Location(0, 0, Rectangle(0, 0)) // not yet implemented
    
end boundingBox
