package edu.luc.cs.laufer.cs371.shapes

/** data Shape = Rectangle(w, h) | Location(x, y, Shape) */
enum Shape derives CanEqual:
  case Rectangle(width: Int, height: Int)
  case Location(x: Int, y: Int, shape: Shape)
  case Ellipse(rx: Int, ry: Int)
  case Group(shapes: Shape*)

  //  val simpleGroup = Group(
  //    Location(200, 100, Ellipse(50, 30)),
  //    Location(400, 300, Rectangle(100, 50))
  //  )
  //  val complexGroup =
  //    Location(50, 100,
  //      Group(
  //        Ellipse(20, 40),
  //        Location(150, 50,
  //        Group(
  //          Rectangle(50, 30),
  //          Rectangle(300, 60),
  //          Location(100, 200,
  //            Ellipse(50, 30)
  //          )
  //      )),
  //      Rectangle(100, 200)
  //    ))
  
  // TODO add missing cases (see test fixtures)
