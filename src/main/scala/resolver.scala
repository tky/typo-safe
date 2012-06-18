package com.tk.libra

import com.tk.libra.utils.Using

trait Resolver {
  def resolve(word: String): Boolean
}

object MockResolver extends Resolver {
  override def resolve(word: String): Boolean = {
    word == "apple"
  }
}

class FileResolver(filename: String) extends Using with Resolver {
  import scala.io.Source
  lazy val dictionary: Set[String] = using(Source.fromFile(filename)) { source =>
    source.getLines.toSet
  }
  override def resolve(word: String): Boolean = dictionary.contains(word)
}

object FileResolver {
  def apply(ext: String): Option[FileResolver] = {
    val file = new java.io.File("./resource/dictionary/%s.dict".format(ext.toLowerCase))
    if (file.exists) {
      Option(new FileResolver(file.getAbsolutePath))
    } else { 
      None
    }
  }
}
