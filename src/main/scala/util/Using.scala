package com.tk.libra.utils

trait Using {
  def using[A, R<: { def close() }](r: R)(f: R => A): A =
    try { f(r) } finally { r.close() }
}
