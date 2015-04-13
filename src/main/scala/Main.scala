
import scala.reflect.runtime.universe

object BlaMain extends App {

  //  val cl = getClass.getClassLoader
  //  val rm = universe.runtimeMirror(cl)
  //  val symbol = rm.staticClass("models.MyRecord")

  //symbol.toType.members.filter(_.isMethod).map(_.asMethod).filter(m => m.owner == symbol).map(println)

  println(ClassModel("ClassModel").toString)

}

case class ClassModel(name: String) {
  val cl = getClass.getClassLoader
  val rm = universe.runtimeMirror(cl)
  val symbol = rm.staticClass(name)

  def methods: Iterable[universe.MethodSymbol] = {
    symbol
      .toType
      .members
      .filter(_.isMethod)
      .map(_.asMethod)
      .filter(m => m.owner == symbol)
      .filterNot(_.isConstructor)
  }

  override def toString: String = {
    s"class ${symbol.name} {\n" +
      methods.map(method => method.name + ":" + method.returnType.resultType.typeSymbol.name + " "  + method.owner.name).mkString("\n") +
      "\n}"
  }

}