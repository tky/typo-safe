import com.tk.libra._

object main extends App {
  val result = Executor.execute(MockResource)
  result.failures.foreach(println)
}
