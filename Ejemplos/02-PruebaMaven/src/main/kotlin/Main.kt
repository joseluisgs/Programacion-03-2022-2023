import colors.fBright
import colors.fError
import colors.fNormal
import colors.fWarning
import com.diogonunes.jcolor.Ansi.colorize
import com.diogonunes.jcolor.Attribute.*

fun main() {
    println(colorize("Hello World!", BOLD(), BRIGHT_YELLOW_TEXT(), GREEN_BACK()))

    println(colorize("Esto es un texto warning", fWarning));

    println(colorize("Esto es un texto warning", fError));

    println (fNormal.format("O usar las funciones de colores ") + fBright.format(" Y combinarlos"))

}